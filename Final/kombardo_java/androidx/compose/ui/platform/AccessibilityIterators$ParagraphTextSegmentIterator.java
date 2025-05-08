package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\r¨\u0006\u0010"}, d2 = {"androidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "<init>", "()V", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "isStartBoundary", "(I)Z", "isEndBoundary", "current", BuildConfig.FLAVOR, "following", "(I)[I", "preceding", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AccessibilityIterators$ParagraphTextSegmentIterator extends AccessibilityIterators$AbstractTextSegmentIterator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static AccessibilityIterators$ParagraphTextSegmentIterator instance;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator$Companion;", BuildConfig.FLAVOR, "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator;", "getInstance", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AccessibilityIterators$ParagraphTextSegmentIterator getInstance() {
            if (AccessibilityIterators$ParagraphTextSegmentIterator.instance == null) {
                AccessibilityIterators$ParagraphTextSegmentIterator.instance = new AccessibilityIterators$ParagraphTextSegmentIterator(null);
            }
            AccessibilityIterators$ParagraphTextSegmentIterator accessibilityIterators$ParagraphTextSegmentIterator = AccessibilityIterators$ParagraphTextSegmentIterator.instance;
            Intrinsics.checkNotNull(accessibilityIterators$ParagraphTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator");
            return accessibilityIterators$ParagraphTextSegmentIterator;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AccessibilityIterators$ParagraphTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final boolean isEndBoundary(int index) {
        return index > 0 && getText().charAt(index + (-1)) != '\n' && (index == getText().length() || getText().charAt(index) == '\n');
    }

    private final boolean isStartBoundary(int index) {
        return getText().charAt(index) != '\n' && (index == 0 || getText().charAt(index - 1) == '\n');
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
    
        return null;
     */
    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] following(int current) {
        int length = getText().length();
        if (length <= 0 || current >= length) {
            return null;
        }
        if (current < 0) {
            current = 0;
        }
        while (current < length && getText().charAt(current) == '\n' && !isStartBoundary(current)) {
            current++;
        }
        int i5 = current + 1;
        while (i5 < length && !isEndBoundary(i5)) {
            i5++;
        }
        return getRange(current, i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        return null;
     */
    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] preceding(int current) {
        int length = getText().length();
        if (length <= 0 || current <= 0) {
            return null;
        }
        if (current > length) {
            current = length;
        }
        while (current > 0 && getText().charAt(current - 1) == '\n' && !isEndBoundary(current)) {
            current--;
        }
        int i5 = current - 1;
        while (i5 > 0 && !isStartBoundary(i5)) {
            i5--;
        }
        return getRange(i5, current);
    }

    private AccessibilityIterators$ParagraphTextSegmentIterator() {
    }
}
