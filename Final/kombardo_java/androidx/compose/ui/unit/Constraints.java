package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0087@\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J;\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0019\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u0012\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b \u0010\u0013R\u0011\u0010#\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010%\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u001a\u0010(\u001a\u00020\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\u001c\u001a\u0004\b&\u0010\"R\u001a\u0010+\u001a\u00020\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010\u001c\u001a\u0004\b)\u0010\"R\u001a\u0010.\u001a\u00020\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010\u001c\u001a\u0004\b,\u0010\"\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/compose/ui/unit/Constraints;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "constructor-impl", "(J)J", BuildConfig.FLAVOR, "minWidth", "maxWidth", "minHeight", "maxHeight", "copy-Zbe2FdA", "(JIIII)J", "copy", BuildConfig.FLAVOR, "toString-impl", "(J)Ljava/lang/String;", "toString", "hashCode-impl", "(J)I", "hashCode", "other", BuildConfig.FLAVOR, "equals-impl", "(JLjava/lang/Object;)Z", "equals", "J", "getValue$annotations", "()V", "getMinWidth-impl", "getMaxWidth-impl", "getMinHeight-impl", "getMaxHeight-impl", "getHasBoundedWidth-impl", "(J)Z", "hasBoundedWidth", "getHasBoundedHeight-impl", "hasBoundedHeight", "getHasFixedWidth-impl", "getHasFixedWidth$annotations", "hasFixedWidth", "getHasFixedHeight-impl", "getHasFixedHeight$annotations", "hasFixedHeight", "isZero-impl", "isZero$annotations", "isZero", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Constraints {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long value;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\fJ5\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J5\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/unit/Constraints$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "width", "height", "Landroidx/compose/ui/unit/Constraints;", "fixed-JhjzzOo", "(II)J", "fixed", "fixedWidth-OenEA2s", "(I)J", "fixedWidth", "fixedHeight-OenEA2s", "fixedHeight", "minWidth", "maxWidth", "minHeight", "maxHeight", "fitPrioritizingWidth-Zbe2FdA", "(IIII)J", "fitPrioritizingWidth", "fitPrioritizingHeight-Zbe2FdA", "fitPrioritizingHeight", "Infinity", "I", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: fitPrioritizingHeight-Zbe2FdA, reason: not valid java name */
        public final long m2585fitPrioritizingHeightZbe2FdA(int minWidth, int maxWidth, int minHeight, int maxHeight) {
            int maxAllowedForSize;
            int min = Math.min(minHeight, 262142);
            int min2 = maxHeight == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(maxHeight, 262142);
            maxAllowedForSize = ConstraintsKt.maxAllowedForSize(min2 == Integer.MAX_VALUE ? min : min2);
            return ConstraintsKt.Constraints(Math.min(maxAllowedForSize, minWidth), maxWidth != Integer.MAX_VALUE ? Math.min(maxAllowedForSize, maxWidth) : Integer.MAX_VALUE, min, min2);
        }

        /* renamed from: fitPrioritizingWidth-Zbe2FdA, reason: not valid java name */
        public final long m2586fitPrioritizingWidthZbe2FdA(int minWidth, int maxWidth, int minHeight, int maxHeight) {
            int maxAllowedForSize;
            int min = Math.min(minWidth, 262142);
            int min2 = maxWidth == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(maxWidth, 262142);
            maxAllowedForSize = ConstraintsKt.maxAllowedForSize(min2 == Integer.MAX_VALUE ? min : min2);
            return ConstraintsKt.Constraints(min, min2, Math.min(maxAllowedForSize, minHeight), maxHeight != Integer.MAX_VALUE ? Math.min(maxAllowedForSize, maxHeight) : Integer.MAX_VALUE);
        }

        /* renamed from: fixed-JhjzzOo, reason: not valid java name */
        public final long m2587fixedJhjzzOo(int width, int height) {
            if (!(width >= 0 && height >= 0)) {
                InlineClassHelperKt.throwIllegalArgumentException("width(" + width + ") and height(" + height + ") must be >= 0");
            }
            return ConstraintsKt.createConstraints(width, width, height, height);
        }

        /* renamed from: fixedHeight-OenEA2s, reason: not valid java name */
        public final long m2588fixedHeightOenEA2s(int height) {
            if (!(height >= 0)) {
                InlineClassHelperKt.throwIllegalArgumentException("height(" + height + ") must be >= 0");
            }
            return ConstraintsKt.createConstraints(0, Integer.MAX_VALUE, height, height);
        }

        /* renamed from: fixedWidth-OenEA2s, reason: not valid java name */
        public final long m2589fixedWidthOenEA2s(int width) {
            if (!(width >= 0)) {
                InlineClassHelperKt.throwIllegalArgumentException("width(" + width + ") must be >= 0");
            }
            return ConstraintsKt.createConstraints(width, width, 0, Integer.MAX_VALUE);
        }

        private Companion() {
        }
    }

    private /* synthetic */ Constraints(long j5) {
        this.value = j5;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Constraints m2567boximpl(long j5) {
        return new Constraints(j5);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2568constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: copy-Zbe2FdA, reason: not valid java name */
    public static final long m2569copyZbe2FdA(long j5, int i5, int i6, int i7, int i8) {
        if (!(i7 >= 0 && i5 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("minHeight(" + i7 + ") and minWidth(" + i5 + ") must be >= 0");
        }
        if (!(i6 >= i5)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth(" + i6 + ") must be >= minWidth(" + i5 + ')');
        }
        if (!(i8 >= i7)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxHeight(" + i8 + ") must be >= minHeight(" + i7 + ')');
        }
        return ConstraintsKt.createConstraints(i5, i6, i7, i8);
    }

    /* renamed from: copy-Zbe2FdA$default, reason: not valid java name */
    public static /* synthetic */ long m2570copyZbe2FdA$default(long j5, int i5, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i5 = m2580getMinWidthimpl(j5);
        }
        int i10 = i5;
        if ((i9 & 2) != 0) {
            i6 = m2578getMaxWidthimpl(j5);
        }
        int i11 = i6;
        if ((i9 & 4) != 0) {
            i7 = m2579getMinHeightimpl(j5);
        }
        int i12 = i7;
        if ((i9 & 8) != 0) {
            i8 = m2577getMaxHeightimpl(j5);
        }
        return m2569copyZbe2FdA(j5, i10, i11, i12, i8);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2571equalsimpl(long j5, Object obj) {
        return (obj instanceof Constraints) && j5 == ((Constraints) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2572equalsimpl0(long j5, long j6) {
        return j5 == j6;
    }

    /* renamed from: getHasBoundedHeight-impl, reason: not valid java name */
    public static final boolean m2573getHasBoundedHeightimpl(long j5) {
        int i5 = (int) (3 & j5);
        int i6 = ((i5 & 1) << 1) + (((i5 & 2) >> 1) * 3);
        return (((int) (j5 >> (i6 + 46))) & ((1 << (18 - i6)) - 1)) != 0;
    }

    /* renamed from: getHasBoundedWidth-impl, reason: not valid java name */
    public static final boolean m2574getHasBoundedWidthimpl(long j5) {
        int i5 = (int) (3 & j5);
        return (((int) (j5 >> 33)) & ((1 << ((((i5 & 1) << 1) + (((i5 & 2) >> 1) * 3)) + 13)) - 1)) != 0;
    }

    /* renamed from: getHasFixedHeight-impl, reason: not valid java name */
    public static final boolean m2575getHasFixedHeightimpl(long j5) {
        int i5 = (int) (3 & j5);
        int i6 = ((i5 & 1) << 1) + (((i5 & 2) >> 1) * 3);
        int i7 = (1 << (18 - i6)) - 1;
        int i8 = ((int) (j5 >> (i6 + 15))) & i7;
        int i9 = ((int) (j5 >> (i6 + 46))) & i7;
        return i8 == (i9 == 0 ? Integer.MAX_VALUE : i9 - 1);
    }

    /* renamed from: getHasFixedWidth-impl, reason: not valid java name */
    public static final boolean m2576getHasFixedWidthimpl(long j5) {
        int i5 = (int) (3 & j5);
        int i6 = (1 << ((((i5 & 1) << 1) + (((i5 & 2) >> 1) * 3)) + 13)) - 1;
        int i7 = ((int) (j5 >> 2)) & i6;
        int i8 = ((int) (j5 >> 33)) & i6;
        return i7 == (i8 == 0 ? Integer.MAX_VALUE : i8 - 1);
    }

    /* renamed from: getMaxHeight-impl, reason: not valid java name */
    public static final int m2577getMaxHeightimpl(long j5) {
        int i5 = (int) (3 & j5);
        int i6 = ((i5 & 1) << 1) + (((i5 & 2) >> 1) * 3);
        int i7 = ((int) (j5 >> (i6 + 46))) & ((1 << (18 - i6)) - 1);
        if (i7 == 0) {
            return Integer.MAX_VALUE;
        }
        return i7 - 1;
    }

    /* renamed from: getMaxWidth-impl, reason: not valid java name */
    public static final int m2578getMaxWidthimpl(long j5) {
        int i5 = (int) (3 & j5);
        int i6 = ((int) (j5 >> 33)) & ((1 << ((((i5 & 1) << 1) + (((i5 & 2) >> 1) * 3)) + 13)) - 1);
        if (i6 == 0) {
            return Integer.MAX_VALUE;
        }
        return i6 - 1;
    }

    /* renamed from: getMinHeight-impl, reason: not valid java name */
    public static final int m2579getMinHeightimpl(long j5) {
        int i5 = (int) (3 & j5);
        int i6 = ((i5 & 1) << 1) + (((i5 & 2) >> 1) * 3);
        return ((int) (j5 >> (i6 + 15))) & ((1 << (18 - i6)) - 1);
    }

    /* renamed from: getMinWidth-impl, reason: not valid java name */
    public static final int m2580getMinWidthimpl(long j5) {
        int i5 = (int) (3 & j5);
        return ((int) (j5 >> 2)) & ((1 << ((((i5 & 1) << 1) + (((i5 & 2) >> 1) * 3)) + 13)) - 1);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2581hashCodeimpl(long j5) {
        return Long.hashCode(j5);
    }

    /* renamed from: isZero-impl, reason: not valid java name */
    public static final boolean m2582isZeroimpl(long j5) {
        int i5 = (int) (3 & j5);
        int i6 = ((i5 & 1) << 1) + (((i5 & 2) >> 1) * 3);
        return (((int) (j5 >> 33)) & ((1 << (i6 + 13)) - 1)) - 1 == 0 || (((int) (j5 >> (i6 + 46))) & ((1 << (18 - i6)) - 1)) - 1 == 0;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2583toStringimpl(long j5) {
        int m2578getMaxWidthimpl = m2578getMaxWidthimpl(j5);
        String valueOf = m2578getMaxWidthimpl == Integer.MAX_VALUE ? "Infinity" : String.valueOf(m2578getMaxWidthimpl);
        int m2577getMaxHeightimpl = m2577getMaxHeightimpl(j5);
        return "Constraints(minWidth = " + m2580getMinWidthimpl(j5) + ", maxWidth = " + valueOf + ", minHeight = " + m2579getMinHeightimpl(j5) + ", maxHeight = " + (m2577getMaxHeightimpl != Integer.MAX_VALUE ? String.valueOf(m2577getMaxHeightimpl) : "Infinity") + ')';
    }

    public boolean equals(Object obj) {
        return m2571equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2581hashCodeimpl(this.value);
    }

    public String toString() {
        return m2583toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }
}
