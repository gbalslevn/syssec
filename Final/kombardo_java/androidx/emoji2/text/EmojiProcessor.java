package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class EmojiProcessor {
    private static final int ACTION_ADVANCE_BOTH = 1;
    private static final int ACTION_ADVANCE_END = 2;
    private static final int ACTION_FLUSH = 3;
    private static final int MAX_LOOK_AROUND_CHARACTER = 16;
    private final int[] mEmojiAsDefaultStyleExceptions;
    private EmojiCompat.GlyphChecker mGlyphChecker;
    private final MetadataRepo mMetadataRepo;
    private final EmojiCompat.SpanFactory mSpanFactory;
    private final boolean mUseEmojiAsDefaultStyle;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class CodepointIndexFinder {
        private static final int INVALID_INDEX = -1;

        static int findIndexBackward(CharSequence charSequence, int i5, int i6) {
            int length = charSequence.length();
            if (i5 < 0 || length < i5 || i6 < 0) {
                return -1;
            }
            while (true) {
                boolean z5 = false;
                while (i6 != 0) {
                    i5--;
                    if (i5 < 0) {
                        return z5 ? -1 : 0;
                    }
                    char charAt = charSequence.charAt(i5);
                    if (z5) {
                        if (!Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        i6--;
                    } else if (!Character.isSurrogate(charAt)) {
                        i6--;
                    } else {
                        if (Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        z5 = true;
                    }
                }
                return i5;
            }
        }

        static int findIndexForward(CharSequence charSequence, int i5, int i6) {
            int length = charSequence.length();
            if (i5 < 0 || length < i5 || i6 < 0) {
                return -1;
            }
            while (true) {
                boolean z5 = false;
                while (i6 != 0) {
                    if (i5 >= length) {
                        if (z5) {
                            return -1;
                        }
                        return length;
                    }
                    char charAt = charSequence.charAt(i5);
                    if (z5) {
                        if (!Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i6--;
                        i5++;
                    } else if (!Character.isSurrogate(charAt)) {
                        i6--;
                        i5++;
                    } else {
                        if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i5++;
                        z5 = true;
                    }
                }
                return i5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class EmojiProcessAddSpanCallback implements EmojiProcessCallback<UnprecomputeTextOnModificationSpannable> {
        private final EmojiCompat.SpanFactory mSpanFactory;
        public UnprecomputeTextOnModificationSpannable spannable;

        EmojiProcessAddSpanCallback(UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable, EmojiCompat.SpanFactory spanFactory) {
            this.spannable = unprecomputeTextOnModificationSpannable;
            this.mSpanFactory = spanFactory;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public boolean handleEmoji(CharSequence charSequence, int i5, int i6, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            if (typefaceEmojiRasterizer.isPreferredSystemRender()) {
                return true;
            }
            if (this.spannable == null) {
                this.spannable = new UnprecomputeTextOnModificationSpannable(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
            }
            this.spannable.setSpan(this.mSpanFactory.createSpan(typefaceEmojiRasterizer), i5, i6, 33);
            return true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public UnprecomputeTextOnModificationSpannable getResult() {
            return this.spannable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface EmojiProcessCallback<T> {
        T getResult();

        boolean handleEmoji(CharSequence charSequence, int i5, int i6, TypefaceEmojiRasterizer typefaceEmojiRasterizer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class EmojiProcessLookupCallback implements EmojiProcessCallback<EmojiProcessLookupCallback> {
        private final int mOffset;
        public int start = -1;
        public int end = -1;

        EmojiProcessLookupCallback(int i5) {
            this.mOffset = i5;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public EmojiProcessLookupCallback getResult() {
            return this;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public boolean handleEmoji(CharSequence charSequence, int i5, int i6, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            int i7 = this.mOffset;
            if (i5 > i7 || i7 >= i6) {
                return i6 <= i7;
            }
            this.start = i5;
            this.end = i6;
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class MarkExclusionCallback implements EmojiProcessCallback<MarkExclusionCallback> {
        private final String mExclusion;

        MarkExclusionCallback(String str) {
            this.mExclusion = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public MarkExclusionCallback getResult() {
            return this;
        }

        @Override // androidx.emoji2.text.EmojiProcessor.EmojiProcessCallback
        public boolean handleEmoji(CharSequence charSequence, int i5, int i6, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
            if (!TextUtils.equals(charSequence.subSequence(i5, i6), this.mExclusion)) {
                return true;
            }
            typefaceEmojiRasterizer.setExclusion(true);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ProcessorSm {
        private static final int STATE_DEFAULT = 1;
        private static final int STATE_WALKING = 2;
        private int mCurrentDepth;
        private MetadataRepo.Node mCurrentNode;
        private final int[] mEmojiAsDefaultStyleExceptions;
        private MetadataRepo.Node mFlushNode;
        private int mLastCodepoint;
        private final MetadataRepo.Node mRootNode;
        private int mState = 1;
        private final boolean mUseEmojiAsDefaultStyle;

        ProcessorSm(MetadataRepo.Node node, boolean z5, int[] iArr) {
            this.mRootNode = node;
            this.mCurrentNode = node;
            this.mUseEmojiAsDefaultStyle = z5;
            this.mEmojiAsDefaultStyleExceptions = iArr;
        }

        private static boolean isEmojiStyle(int i5) {
            return i5 == 65039;
        }

        private static boolean isTextStyle(int i5) {
            return i5 == 65038;
        }

        private int reset() {
            this.mState = 1;
            this.mCurrentNode = this.mRootNode;
            this.mCurrentDepth = 0;
            return 1;
        }

        private boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
            if (this.mCurrentNode.getData().isDefaultEmoji() || isEmojiStyle(this.mLastCodepoint)) {
                return true;
            }
            if (this.mUseEmojiAsDefaultStyle) {
                if (this.mEmojiAsDefaultStyleExceptions == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.mEmojiAsDefaultStyleExceptions, this.mCurrentNode.getData().getCodepointAt(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int check(int i5) {
            MetadataRepo.Node node = this.mCurrentNode.get(i5);
            int i6 = 2;
            if (this.mState != 2) {
                if (node == null) {
                    i6 = reset();
                } else {
                    this.mState = 2;
                    this.mCurrentNode = node;
                    this.mCurrentDepth = 1;
                }
            } else if (node != null) {
                this.mCurrentNode = node;
                this.mCurrentDepth++;
            } else if (isTextStyle(i5)) {
                i6 = reset();
            } else if (!isEmojiStyle(i5)) {
                if (this.mCurrentNode.getData() != null) {
                    i6 = 3;
                    if (this.mCurrentDepth != 1) {
                        this.mFlushNode = this.mCurrentNode;
                        reset();
                    } else if (shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                        this.mFlushNode = this.mCurrentNode;
                        reset();
                    } else {
                        i6 = reset();
                    }
                } else {
                    i6 = reset();
                }
            }
            this.mLastCodepoint = i5;
            return i6;
        }

        TypefaceEmojiRasterizer getCurrentMetadata() {
            return this.mCurrentNode.getData();
        }

        TypefaceEmojiRasterizer getFlushMetadata() {
            return this.mFlushNode.getData();
        }

        boolean isInFlushableState() {
            return this.mState == 2 && this.mCurrentNode.getData() != null && (this.mCurrentDepth > 1 || shouldUseEmojiPresentationStyleForSingleCodepoint());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiProcessor(MetadataRepo metadataRepo, EmojiCompat.SpanFactory spanFactory, EmojiCompat.GlyphChecker glyphChecker, boolean z5, int[] iArr, Set<int[]> set) {
        this.mSpanFactory = spanFactory;
        this.mMetadataRepo = metadataRepo;
        this.mGlyphChecker = glyphChecker;
        this.mUseEmojiAsDefaultStyle = z5;
        this.mEmojiAsDefaultStyleExceptions = iArr;
        initExclusions(set);
    }

    private static boolean delete(Editable editable, KeyEvent keyEvent, boolean z5) {
        EmojiSpan[] emojiSpanArr;
        if (hasModifiers(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!hasInvalidSelection(selectionStart, selectionEnd) && (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
            for (EmojiSpan emojiSpan : emojiSpanArr) {
                int spanStart = editable.getSpanStart(emojiSpan);
                int spanEnd = editable.getSpanEnd(emojiSpan);
                if ((z5 && spanStart == selectionStart) || ((!z5 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean handleDeleteSurroundingText(InputConnection inputConnection, Editable editable, int i5, int i6, boolean z5) {
        int max;
        int min;
        if (editable != null && inputConnection != null && i5 >= 0 && i6 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (hasInvalidSelection(selectionStart, selectionEnd)) {
                return false;
            }
            if (z5) {
                max = CodepointIndexFinder.findIndexBackward(editable, selectionStart, Math.max(i5, 0));
                min = CodepointIndexFinder.findIndexForward(editable, selectionEnd, Math.max(i6, 0));
                if (max == -1 || min == -1) {
                    return false;
                }
            } else {
                max = Math.max(selectionStart - i5, 0);
                min = Math.min(selectionEnd + i6, editable.length());
            }
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) editable.getSpans(max, min, EmojiSpan.class);
            if (emojiSpanArr != null && emojiSpanArr.length > 0) {
                for (EmojiSpan emojiSpan : emojiSpanArr) {
                    int spanStart = editable.getSpanStart(emojiSpan);
                    int spanEnd = editable.getSpanEnd(emojiSpan);
                    max = Math.min(spanStart, max);
                    min = Math.max(spanEnd, min);
                }
                int max2 = Math.max(max, 0);
                int min2 = Math.min(min, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max2, min2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean handleOnKeyDown(Editable editable, int i5, KeyEvent keyEvent) {
        if (!(i5 != 67 ? i5 != 112 ? false : delete(editable, keyEvent, true) : delete(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean hasGlyph(CharSequence charSequence, int i5, int i6, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if (typefaceEmojiRasterizer.getHasGlyph() == 0) {
            typefaceEmojiRasterizer.setHasGlyph(this.mGlyphChecker.hasGlyph(charSequence, i5, i6, typefaceEmojiRasterizer.getSdkAdded()));
        }
        return typefaceEmojiRasterizer.getHasGlyph() == 2;
    }

    private static boolean hasInvalidSelection(int i5, int i6) {
        return i5 == -1 || i6 == -1 || i5 != i6;
    }

    private static boolean hasModifiers(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    private void initExclusions(Set<int[]> set) {
        if (set.isEmpty()) {
            return;
        }
        for (int[] iArr : set) {
            String str = new String(iArr, 0, iArr.length);
            process(str, 0, str.length(), 1, true, new MarkExclusionCallback(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEmojiEnd(CharSequence charSequence, int i5) {
        if (i5 < 0 || i5 >= charSequence.length()) {
            return -1;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) spanned.getSpans(i5, i5 + 1, EmojiSpan.class);
            if (emojiSpanArr.length > 0) {
                return spanned.getSpanEnd(emojiSpanArr[0]);
            }
        }
        return ((EmojiProcessLookupCallback) process(charSequence, Math.max(0, i5 - 16), Math.min(charSequence.length(), i5 + 16), Integer.MAX_VALUE, true, new EmojiProcessLookupCallback(i5))).end;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEmojiStart(CharSequence charSequence, int i5) {
        if (i5 < 0 || i5 >= charSequence.length()) {
            return -1;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) spanned.getSpans(i5, i5 + 1, EmojiSpan.class);
            if (emojiSpanArr.length > 0) {
                return spanned.getSpanStart(emojiSpanArr[0]);
            }
        }
        return ((EmojiProcessLookupCallback) process(charSequence, Math.max(0, i5 - 16), Math.min(charSequence.length(), i5 + 16), Integer.MAX_VALUE, true, new EmojiProcessLookupCallback(i5))).start;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049 A[Catch: all -> 0x002a, TryCatch #0 {all -> 0x002a, blocks: (B:51:0x000e, B:54:0x0013, B:56:0x0017, B:58:0x0024, B:9:0x003a, B:11:0x0042, B:13:0x0045, B:15:0x0049, B:17:0x0055, B:19:0x0058, B:24:0x0066, B:30:0x0074, B:31:0x0080, B:33:0x0094, B:6:0x002f), top: B:50:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094 A[Catch: all -> 0x002a, TRY_LEAVE, TryCatch #0 {all -> 0x002a, blocks: (B:51:0x000e, B:54:0x0013, B:56:0x0017, B:58:0x0024, B:9:0x003a, B:11:0x0042, B:13:0x0045, B:15:0x0049, B:17:0x0055, B:19:0x0058, B:24:0x0066, B:30:0x0074, B:31:0x0080, B:33:0x0094, B:6:0x002f), top: B:50:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CharSequence process(CharSequence charSequence, int i5, int i6, int i7, boolean z5) {
        UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable;
        int i8;
        UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable2;
        EmojiSpan[] emojiSpanArr;
        boolean z6 = charSequence instanceof SpannableBuilder;
        if (z6) {
            ((SpannableBuilder) charSequence).beginBatchEdit();
        }
        if (!z6) {
            try {
                if (!(charSequence instanceof Spannable)) {
                    unprecomputeTextOnModificationSpannable = (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i5 + (-1), i6 + 1, EmojiSpan.class) > i6) ? null : new UnprecomputeTextOnModificationSpannable(charSequence);
                    if (unprecomputeTextOnModificationSpannable != null && (emojiSpanArr = (EmojiSpan[]) unprecomputeTextOnModificationSpannable.getSpans(i5, i6, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
                        for (EmojiSpan emojiSpan : emojiSpanArr) {
                            int spanStart = unprecomputeTextOnModificationSpannable.getSpanStart(emojiSpan);
                            int spanEnd = unprecomputeTextOnModificationSpannable.getSpanEnd(emojiSpan);
                            if (spanStart != i6) {
                                unprecomputeTextOnModificationSpannable.removeSpan(emojiSpan);
                            }
                            i5 = Math.min(spanStart, i5);
                            i6 = Math.max(spanEnd, i6);
                        }
                    }
                    i8 = i6;
                    if (i5 != i8 && i5 < charSequence.length()) {
                        if (i7 != Integer.MAX_VALUE && unprecomputeTextOnModificationSpannable != null) {
                            i7 -= ((EmojiSpan[]) unprecomputeTextOnModificationSpannable.getSpans(0, unprecomputeTextOnModificationSpannable.length(), EmojiSpan.class)).length;
                        }
                        unprecomputeTextOnModificationSpannable2 = (UnprecomputeTextOnModificationSpannable) process(charSequence, i5, i8, i7, z5, new EmojiProcessAddSpanCallback(unprecomputeTextOnModificationSpannable, this.mSpanFactory));
                        if (unprecomputeTextOnModificationSpannable2 != null) {
                            if (z6) {
                                ((SpannableBuilder) charSequence).endBatchEdit();
                            }
                            return charSequence;
                        }
                        Spannable unwrappedSpannable = unprecomputeTextOnModificationSpannable2.getUnwrappedSpannable();
                        if (z6) {
                            ((SpannableBuilder) charSequence).endBatchEdit();
                        }
                        return unwrappedSpannable;
                    }
                    return charSequence;
                }
            } finally {
                if (z6) {
                    ((SpannableBuilder) charSequence).endBatchEdit();
                }
            }
        }
        unprecomputeTextOnModificationSpannable = new UnprecomputeTextOnModificationSpannable((Spannable) charSequence);
        if (unprecomputeTextOnModificationSpannable != null) {
            while (r6 < r5) {
            }
        }
        i8 = i6;
        if (i5 != i8) {
            if (i7 != Integer.MAX_VALUE) {
                i7 -= ((EmojiSpan[]) unprecomputeTextOnModificationSpannable.getSpans(0, unprecomputeTextOnModificationSpannable.length(), EmojiSpan.class)).length;
            }
            unprecomputeTextOnModificationSpannable2 = (UnprecomputeTextOnModificationSpannable) process(charSequence, i5, i8, i7, z5, new EmojiProcessAddSpanCallback(unprecomputeTextOnModificationSpannable, this.mSpanFactory));
            if (unprecomputeTextOnModificationSpannable2 != null) {
            }
        }
        return charSequence;
    }

    private <T> T process(CharSequence charSequence, int i5, int i6, int i7, boolean z5, EmojiProcessCallback<T> emojiProcessCallback) {
        int i8;
        ProcessorSm processorSm = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int i9 = 0;
        boolean z6 = true;
        int codePointAt = Character.codePointAt(charSequence, i5);
        loop0: while (true) {
            i8 = i5;
            while (i5 < i6 && i9 < i7 && z6) {
                int check = processorSm.check(codePointAt);
                if (check == 1) {
                    i8 += Character.charCount(Character.codePointAt(charSequence, i8));
                    if (i8 < i6) {
                        codePointAt = Character.codePointAt(charSequence, i8);
                    }
                    i5 = i8;
                } else if (check == 2) {
                    i5 += Character.charCount(codePointAt);
                    if (i5 < i6) {
                        codePointAt = Character.codePointAt(charSequence, i5);
                    }
                } else if (check == 3) {
                    if (z5 || !hasGlyph(charSequence, i8, i5, processorSm.getFlushMetadata())) {
                        z6 = emojiProcessCallback.handleEmoji(charSequence, i8, i5, processorSm.getFlushMetadata());
                        i9++;
                    }
                }
            }
        }
        if (processorSm.isInFlushableState() && i9 < i7 && z6 && (z5 || !hasGlyph(charSequence, i8, i5, processorSm.getCurrentMetadata()))) {
            emojiProcessCallback.handleEmoji(charSequence, i8, i5, processorSm.getCurrentMetadata());
        }
        return emojiProcessCallback.getResult();
    }
}
