package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.TextUtils;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001<B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b \u0010\u0019J\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u001f\u001a\u00020\u0006H\u0000¢\u0006\u0004\b#\u0010$J\u0015\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0012008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0017\u00108\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;¨\u0006="}, d2 = {"Landroidx/compose/ui/text/android/LayoutHelper;", BuildConfig.FLAVOR, "Landroid/text/Layout;", "layout", "<init>", "(Landroid/text/Layout;)V", BuildConfig.FLAVOR, "offset", BuildConfig.FLAVOR, "primary", BuildConfig.FLAVOR, "getDownstreamHorizontal", "(IZ)F", "lineEnd", "lineStart", "lineEndToVisibleEnd", "(II)I", "paragraphIndex", "Ljava/text/Bidi;", "analyzeBidi", "(I)Ljava/text/Bidi;", "upstream", "getParagraphForOffset", "(IZ)I", "getParagraphStart", "(I)I", "isRtlParagraph", "(I)Z", "usePrimaryDirection", "getHorizontalPosition", "(IZZ)F", "lineIndex", "getLineVisibleEnd", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "getLineBidiRuns$ui_text_release", "(I)[Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "getLineBidiRuns", BuildConfig.FLAVOR, "c", "isLineEndSpace", "(C)Z", "Landroid/text/Layout;", "getLayout", "()Landroid/text/Layout;", BuildConfig.FLAVOR, "paragraphEnds", "Ljava/util/List;", BuildConfig.FLAVOR, "paragraphBidi", BuildConfig.FLAVOR, "bidiProcessedParagraphs", "[Z", BuildConfig.FLAVOR, "tmpBuffer", "[C", "paragraphCount", "I", "getParagraphCount", "()I", "BidiRun", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutHelper {
    private final boolean[] bidiProcessedParagraphs;
    private final Layout layout;
    private final List<Bidi> paragraphBidi;
    private final int paragraphCount;
    private final List<Integer> paragraphEnds;
    private char[] tmpBuffer;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0006\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "start", "end", BuildConfig.FLAVOR, "isRtl", "<init>", "(IIZ)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getStart", "getEnd", "Z", "()Z", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* data */ class BidiRun {
        private final int end;
        private final boolean isRtl;
        private final int start;

        public BidiRun(int i5, int i6, boolean z5) {
            this.start = i5;
            this.end = i6;
            this.isRtl = z5;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BidiRun)) {
                return false;
            }
            BidiRun bidiRun = (BidiRun) other;
            return this.start == bidiRun.start && this.end == bidiRun.end && this.isRtl == bidiRun.isRtl;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.start) * 31) + Integer.hashCode(this.end)) * 31) + Boolean.hashCode(this.isRtl);
        }

        /* renamed from: isRtl, reason: from getter */
        public final boolean getIsRtl() {
            return this.isRtl;
        }

        public String toString() {
            return "BidiRun(start=" + this.start + ", end=" + this.end + ", isRtl=" + this.isRtl + ')';
        }
    }

    public LayoutHelper(Layout layout) {
        this.layout = layout;
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        do {
            int indexOf$default = StringsKt.indexOf$default(this.layout.getText(), '\n', i5, false, 4, (Object) null);
            i5 = indexOf$default < 0 ? this.layout.getText().length() : indexOf$default + 1;
            arrayList.add(Integer.valueOf(i5));
        } while (i5 < this.layout.getText().length());
        this.paragraphEnds = arrayList;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i6 = 0; i6 < size; i6++) {
            arrayList2.add(null);
        }
        this.paragraphBidi = arrayList2;
        this.bidiProcessedParagraphs = new boolean[this.paragraphEnds.size()];
        this.paragraphCount = this.paragraphEnds.size();
    }

    private final float getDownstreamHorizontal(int offset, boolean primary) {
        int coerceAtMost = RangesKt.coerceAtMost(offset, this.layout.getLineEnd(this.layout.getLineForOffset(offset)));
        return primary ? this.layout.getPrimaryHorizontal(coerceAtMost) : this.layout.getSecondaryHorizontal(coerceAtMost);
    }

    public static /* synthetic */ int getParagraphForOffset$default(LayoutHelper layoutHelper, int i5, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        return layoutHelper.getParagraphForOffset(i5, z5);
    }

    private final int lineEndToVisibleEnd(int lineEnd, int lineStart) {
        while (lineEnd > lineStart && isLineEndSpace(this.layout.getText().charAt(lineEnd - 1))) {
            lineEnd--;
        }
        return lineEnd;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
    
        if (r0.getRunCount() == 1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bidi analyzeBidi(int paragraphIndex) {
        Bidi bidi;
        if (this.bidiProcessedParagraphs[paragraphIndex]) {
            return this.paragraphBidi.get(paragraphIndex);
        }
        int intValue = paragraphIndex == 0 ? 0 : this.paragraphEnds.get(paragraphIndex - 1).intValue();
        int intValue2 = this.paragraphEnds.get(paragraphIndex).intValue();
        int i5 = intValue2 - intValue;
        char[] cArr = this.tmpBuffer;
        if (cArr == null || cArr.length < i5) {
            cArr = new char[i5];
        }
        char[] cArr2 = cArr;
        TextUtils.getChars(this.layout.getText(), intValue, intValue2, cArr2, 0);
        if (Bidi.requiresBidi(cArr2, 0, i5)) {
            bidi = new Bidi(cArr2, 0, null, 0, i5, isRtlParagraph(paragraphIndex) ? 1 : 0);
        }
        bidi = null;
        this.paragraphBidi.set(paragraphIndex, bidi);
        this.bidiProcessedParagraphs[paragraphIndex] = true;
        if (bidi != null) {
            char[] cArr3 = this.tmpBuffer;
            cArr2 = cArr2 == cArr3 ? null : cArr3;
        }
        this.tmpBuffer = cArr2;
        return bidi;
    }

    public final float getHorizontalPosition(int offset, boolean usePrimaryDirection, boolean upstream) {
        int i5 = offset;
        if (!upstream) {
            return getDownstreamHorizontal(offset, usePrimaryDirection);
        }
        int lineForOffset = LayoutCompat_androidKt.getLineForOffset(this.layout, i5, upstream);
        int lineStart = this.layout.getLineStart(lineForOffset);
        int lineEnd = this.layout.getLineEnd(lineForOffset);
        if (i5 != lineStart && i5 != lineEnd) {
            return getDownstreamHorizontal(offset, usePrimaryDirection);
        }
        if (i5 == 0 || i5 == this.layout.getText().length()) {
            return getDownstreamHorizontal(offset, usePrimaryDirection);
        }
        int paragraphForOffset = getParagraphForOffset(i5, upstream);
        boolean isRtlParagraph = isRtlParagraph(paragraphForOffset);
        int lineEndToVisibleEnd = lineEndToVisibleEnd(lineEnd, lineStart);
        int paragraphStart = getParagraphStart(paragraphForOffset);
        int i6 = lineStart - paragraphStart;
        int i7 = lineEndToVisibleEnd - paragraphStart;
        Bidi analyzeBidi = analyzeBidi(paragraphForOffset);
        Bidi createLineBidi = analyzeBidi != null ? analyzeBidi.createLineBidi(i6, i7) : null;
        boolean z5 = false;
        if (createLineBidi == null || createLineBidi.getRunCount() == 1) {
            boolean isRtlCharAt = this.layout.isRtlCharAt(lineStart);
            if (usePrimaryDirection || isRtlParagraph == isRtlCharAt) {
                isRtlParagraph = !isRtlParagraph;
            }
            if (i5 == lineStart) {
                z5 = isRtlParagraph;
            } else if (!isRtlParagraph) {
                z5 = true;
            }
            Layout layout = this.layout;
            return z5 ? layout.getLineLeft(lineForOffset) : layout.getLineRight(lineForOffset);
        }
        int runCount = createLineBidi.getRunCount();
        BidiRun[] bidiRunArr = new BidiRun[runCount];
        for (int i8 = 0; i8 < runCount; i8++) {
            bidiRunArr[i8] = new BidiRun(createLineBidi.getRunStart(i8) + lineStart, createLineBidi.getRunLimit(i8) + lineStart, createLineBidi.getRunLevel(i8) % 2 == 1);
        }
        int runCount2 = createLineBidi.getRunCount();
        byte[] bArr = new byte[runCount2];
        for (int i9 = 0; i9 < runCount2; i9++) {
            bArr[i9] = (byte) createLineBidi.getRunLevel(i9);
        }
        Bidi.reorderVisually(bArr, 0, bidiRunArr, 0, runCount);
        int i10 = -1;
        if (i5 == lineStart) {
            int i11 = 0;
            while (true) {
                if (i11 >= runCount) {
                    break;
                }
                if (bidiRunArr[i11].getStart() == i5) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            BidiRun bidiRun = bidiRunArr[i10];
            if (usePrimaryDirection || isRtlParagraph == bidiRun.getIsRtl()) {
                isRtlParagraph = !isRtlParagraph;
            }
            return (i10 == 0 && isRtlParagraph) ? this.layout.getLineLeft(lineForOffset) : (i10 != ArraysKt.getLastIndex(bidiRunArr) || isRtlParagraph) ? isRtlParagraph ? this.layout.getPrimaryHorizontal(bidiRunArr[i10 - 1].getStart()) : this.layout.getPrimaryHorizontal(bidiRunArr[i10 + 1].getStart()) : this.layout.getLineRight(lineForOffset);
        }
        if (i5 > lineEndToVisibleEnd) {
            i5 = lineEndToVisibleEnd(i5, lineStart);
        }
        int i12 = 0;
        while (true) {
            if (i12 >= runCount) {
                break;
            }
            if (bidiRunArr[i12].getEnd() == i5) {
                i10 = i12;
                break;
            }
            i12++;
        }
        BidiRun bidiRun2 = bidiRunArr[i10];
        if (!usePrimaryDirection && isRtlParagraph != bidiRun2.getIsRtl()) {
            isRtlParagraph = !isRtlParagraph;
        }
        return (i10 == 0 && isRtlParagraph) ? this.layout.getLineLeft(lineForOffset) : (i10 != ArraysKt.getLastIndex(bidiRunArr) || isRtlParagraph) ? isRtlParagraph ? this.layout.getPrimaryHorizontal(bidiRunArr[i10 - 1].getEnd()) : this.layout.getPrimaryHorizontal(bidiRunArr[i10 + 1].getEnd()) : this.layout.getLineRight(lineForOffset);
    }

    public final BidiRun[] getLineBidiRuns$ui_text_release(int lineIndex) {
        Bidi createLineBidi;
        int lineStart = this.layout.getLineStart(lineIndex);
        int lineEnd = this.layout.getLineEnd(lineIndex);
        int paragraphForOffset$default = getParagraphForOffset$default(this, lineStart, false, 2, null);
        int paragraphStart = getParagraphStart(paragraphForOffset$default);
        int i5 = lineStart - paragraphStart;
        int i6 = lineEnd - paragraphStart;
        Bidi analyzeBidi = analyzeBidi(paragraphForOffset$default);
        if (analyzeBidi == null || (createLineBidi = analyzeBidi.createLineBidi(i5, i6)) == null) {
            return new BidiRun[]{new BidiRun(lineStart, lineEnd, this.layout.isRtlCharAt(lineStart))};
        }
        int runCount = createLineBidi.getRunCount();
        BidiRun[] bidiRunArr = new BidiRun[runCount];
        for (int i7 = 0; i7 < runCount; i7++) {
            int runStart = createLineBidi.getRunStart(i7) + lineStart;
            int runLimit = createLineBidi.getRunLimit(i7) + lineStart;
            boolean z5 = true;
            if (createLineBidi.getRunLevel(i7) % 2 != 1) {
                z5 = false;
            }
            bidiRunArr[i7] = new BidiRun(runStart, runLimit, z5);
        }
        return bidiRunArr;
    }

    public final int getLineVisibleEnd(int lineIndex) {
        return lineEndToVisibleEnd(this.layout.getLineEnd(lineIndex), this.layout.getLineStart(lineIndex));
    }

    public final int getParagraphForOffset(int offset, boolean upstream) {
        int binarySearch$default = CollectionsKt.binarySearch$default(this.paragraphEnds, Integer.valueOf(offset), 0, 0, 6, (Object) null);
        int i5 = binarySearch$default < 0 ? -(binarySearch$default + 1) : binarySearch$default + 1;
        if (upstream && i5 > 0) {
            int i6 = i5 - 1;
            if (offset == this.paragraphEnds.get(i6).intValue()) {
                return i6;
            }
        }
        return i5;
    }

    public final int getParagraphStart(int paragraphIndex) {
        if (paragraphIndex == 0) {
            return 0;
        }
        return this.paragraphEnds.get(paragraphIndex - 1).intValue();
    }

    public final boolean isLineEndSpace(char c5) {
        return c5 == ' ' || c5 == '\n' || c5 == 5760 || (Intrinsics.compare((int) c5, 8192) >= 0 && Intrinsics.compare((int) c5, 8202) <= 0 && c5 != 8199) || c5 == 8287 || c5 == 12288;
    }

    public final boolean isRtlParagraph(int paragraphIndex) {
        return this.layout.getParagraphDirection(this.layout.getLineForOffset(getParagraphStart(paragraphIndex))) == -1;
    }
}
