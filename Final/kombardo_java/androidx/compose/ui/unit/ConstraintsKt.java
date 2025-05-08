package androidx.compose.ui.unit;

import com.sun.jna.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u000f\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0012\u001a7\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0014\u0010\u0010\u001a\u001c\u0010\u0018\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001e\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0017\u001a\u001e\u0010\u001e\u001a\u00020\u0000*\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001e\u0010!\u001a\u00020\u0000*\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010\u001d\u001a\u001e\u0010%\u001a\u00020\"*\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a*\u0010*\u001a\u00020\u000e*\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u00002\b\b\u0002\u0010'\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u001f\u0010-\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0002¢\u0006\u0004\b-\u0010.\"\u0014\u0010/\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u00100\"\u0014\u00101\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u00100\"\u0014\u00102\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00100\"\u0014\u00103\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u00100\"\u0014\u00104\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00100\"\u0014\u00106\u001a\u0002058\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00107\"\u0014\u00108\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00100\"\u0014\u00109\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00100\"\u0014\u0010:\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u00100\"\u0014\u0010;\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u00100\"\u0014\u0010<\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u00100\"\u0014\u0010=\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u00100\"\u0014\u0010>\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u00100\"\u0014\u0010?\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u00100\"\u0014\u0010@\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u00100\"\u0014\u0010A\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u00100\"\u0014\u0010B\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u00100\"\u0014\u0010C\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u00100\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006D"}, d2 = {BuildConfig.FLAVOR, "widthVal", "heightVal", BuildConfig.FLAVOR, "invalidConstraint", "(II)V", "size", BuildConfig.FLAVOR, "invalidSize", "(I)Ljava/lang/Void;", "minWidth", "maxWidth", "minHeight", "maxHeight", "Landroidx/compose/ui/unit/Constraints;", "createConstraints", "(IIII)J", "bitsNeedForSizeUnchecked", "(I)I", "maxAllowedForSize", "Constraints", "otherConstraints", "constrain-N9IONVI", "(JJ)J", "constrain", "Landroidx/compose/ui/unit/IntSize;", "constrain-4WqzIAM", "width", "constrainWidth-K40F9xA", "(JI)I", "constrainWidth", "height", "constrainHeight-K40F9xA", "constrainHeight", BuildConfig.FLAVOR, "isSatisfiedBy-4WqzIAM", "(JJ)Z", "isSatisfiedBy", "horizontal", "vertical", "offset-NN6Ew-U", "(JII)J", "offset", "max", "value", "addMaxWithMinimum", "(II)I", "Infinity", "I", "MinFocusWidth", "MaxFocusWidth", "MinFocusHeight", "MaxFocusHeight", BuildConfig.FLAVOR, "FocusMask", "J", "MinFocusBits", "MaxAllowedForMinFocusBits", "MinFocusMask", "MinNonFocusBits", "MaxAllowedForMinNonFocusBits", "MinNonFocusMask", "MaxFocusBits", "MaxAllowedForMaxFocusBits", "MaxFocusMask", "MaxNonFocusBits", "MaxAllowedForMaxNonFocusBits", "MaxNonFocusMask", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ConstraintsKt {
    private static final long FocusMask = 3;
    private static final int Infinity = Integer.MAX_VALUE;
    private static final int MaxAllowedForMaxFocusBits = 8190;
    private static final int MaxAllowedForMaxNonFocusBits = 262142;
    private static final int MaxAllowedForMinFocusBits = 32766;
    private static final int MaxAllowedForMinNonFocusBits = 65534;
    private static final int MaxFocusBits = 18;
    private static final int MaxFocusHeight = 0;
    private static final int MaxFocusMask = 262143;
    private static final int MaxFocusWidth = 3;
    private static final int MaxNonFocusBits = 13;
    private static final int MaxNonFocusMask = 8191;
    private static final int MinFocusBits = 16;
    private static final int MinFocusHeight = 1;
    private static final int MinFocusMask = 65535;
    private static final int MinFocusWidth = 2;
    private static final int MinNonFocusBits = 15;
    private static final int MinNonFocusMask = 32767;

    public static final long Constraints(int i5, int i6, int i7, int i8) {
        boolean z5 = false;
        if (!(i6 >= i5)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxWidth(" + i6 + ") must be >= than minWidth(" + i5 + ')');
        }
        if (!(i8 >= i7)) {
            InlineClassHelperKt.throwIllegalArgumentException("maxHeight(" + i8 + ") must be >= than minHeight(" + i7 + ')');
        }
        if (i5 >= 0 && i7 >= 0) {
            z5 = true;
        }
        if (!z5) {
            InlineClassHelperKt.throwIllegalArgumentException("minWidth(" + i5 + ") and minHeight(" + i7 + ") must be >= 0");
        }
        return createConstraints(i5, i6, i7, i8);
    }

    public static /* synthetic */ long Constraints$default(int i5, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i5 = 0;
        }
        if ((i9 & 2) != 0) {
            i6 = Infinity;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = Infinity;
        }
        return Constraints(i5, i6, i7, i8);
    }

    private static final int addMaxWithMinimum(int i5, int i6) {
        return i5 == Infinity ? i5 : RangesKt.coerceAtLeast(i5 + i6, 0);
    }

    private static final int bitsNeedForSizeUnchecked(int i5) {
        if (i5 < MaxNonFocusMask) {
            return 13;
        }
        if (i5 < MinNonFocusMask) {
            return 15;
        }
        if (i5 < MinFocusMask) {
            return 16;
        }
        if (i5 < MaxFocusMask) {
            return 18;
        }
        return Function.USE_VARARGS;
    }

    /* renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m2590constrain4WqzIAM(long j5, long j6) {
        return IntSizeKt.IntSize(RangesKt.coerceIn(IntSize.m2661getWidthimpl(j6), Constraints.m2580getMinWidthimpl(j5), Constraints.m2578getMaxWidthimpl(j5)), RangesKt.coerceIn(IntSize.m2660getHeightimpl(j6), Constraints.m2579getMinHeightimpl(j5), Constraints.m2577getMaxHeightimpl(j5)));
    }

    /* renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m2591constrainN9IONVI(long j5, long j6) {
        return Constraints(RangesKt.coerceIn(Constraints.m2580getMinWidthimpl(j6), Constraints.m2580getMinWidthimpl(j5), Constraints.m2578getMaxWidthimpl(j5)), RangesKt.coerceIn(Constraints.m2578getMaxWidthimpl(j6), Constraints.m2580getMinWidthimpl(j5), Constraints.m2578getMaxWidthimpl(j5)), RangesKt.coerceIn(Constraints.m2579getMinHeightimpl(j6), Constraints.m2579getMinHeightimpl(j5), Constraints.m2577getMaxHeightimpl(j5)), RangesKt.coerceIn(Constraints.m2577getMaxHeightimpl(j6), Constraints.m2579getMinHeightimpl(j5), Constraints.m2577getMaxHeightimpl(j5)));
    }

    /* renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m2592constrainHeightK40F9xA(long j5, int i5) {
        return RangesKt.coerceIn(i5, Constraints.m2579getMinHeightimpl(j5), Constraints.m2577getMaxHeightimpl(j5));
    }

    /* renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m2593constrainWidthK40F9xA(long j5, int i5) {
        return RangesKt.coerceIn(i5, Constraints.m2580getMinWidthimpl(j5), Constraints.m2578getMaxWidthimpl(j5));
    }

    public static final long createConstraints(int i5, int i6, int i7, int i8) {
        int i9 = i8 == Infinity ? i7 : i8;
        int bitsNeedForSizeUnchecked = bitsNeedForSizeUnchecked(i9);
        int i10 = i6 == Infinity ? i5 : i6;
        int bitsNeedForSizeUnchecked2 = bitsNeedForSizeUnchecked(i10);
        if (bitsNeedForSizeUnchecked + bitsNeedForSizeUnchecked2 > 31) {
            invalidConstraint(i10, i9);
        }
        int i11 = i6 + 1;
        int i12 = i11 & (~(i11 >> 31));
        int i13 = i8 + 1;
        int i14 = i13 & (~(i13 >> 31));
        int i15 = 0;
        if (bitsNeedForSizeUnchecked2 != 13) {
            if (bitsNeedForSizeUnchecked2 == 18) {
                i15 = 3;
            } else if (bitsNeedForSizeUnchecked2 == 15) {
                i15 = 1;
            } else if (bitsNeedForSizeUnchecked2 == 16) {
                i15 = 2;
            }
        }
        int i16 = ((i15 & 1) << 1) + (((i15 & 2) >> 1) * 3);
        return Constraints.m2568constructorimpl((i12 << 33) | i15 | (i5 << 2) | (i7 << (i16 + 15)) | (i14 << (i16 + 46)));
    }

    private static final void invalidConstraint(int i5, int i6) {
        throw new IllegalArgumentException("Can't represent a width of " + i5 + " and height of " + i6 + " in Constraints");
    }

    private static final Void invalidSize(int i5) {
        throw new IllegalArgumentException("Can't represent a size of " + i5 + " in Constraints");
    }

    /* renamed from: isSatisfiedBy-4WqzIAM, reason: not valid java name */
    public static final boolean m2594isSatisfiedBy4WqzIAM(long j5, long j6) {
        int m2580getMinWidthimpl = Constraints.m2580getMinWidthimpl(j5);
        int m2578getMaxWidthimpl = Constraints.m2578getMaxWidthimpl(j5);
        int m2661getWidthimpl = IntSize.m2661getWidthimpl(j6);
        if (m2580getMinWidthimpl <= m2661getWidthimpl && m2661getWidthimpl <= m2578getMaxWidthimpl) {
            int m2579getMinHeightimpl = Constraints.m2579getMinHeightimpl(j5);
            int m2577getMaxHeightimpl = Constraints.m2577getMaxHeightimpl(j5);
            int m2660getHeightimpl = IntSize.m2660getHeightimpl(j6);
            if (m2579getMinHeightimpl <= m2660getHeightimpl && m2660getHeightimpl <= m2577getMaxHeightimpl) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxAllowedForSize(int i5) {
        if (i5 < MaxNonFocusMask) {
            return MaxAllowedForMaxNonFocusBits;
        }
        if (i5 < MinNonFocusMask) {
            return MaxAllowedForMinNonFocusBits;
        }
        if (i5 < MinFocusMask) {
            return MaxAllowedForMinFocusBits;
        }
        if (i5 < MaxFocusMask) {
            return MaxAllowedForMaxFocusBits;
        }
        invalidSize(i5);
        throw new KotlinNothingValueException();
    }

    /* renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m2595offsetNN6EwU(long j5, int i5, int i6) {
        return Constraints(RangesKt.coerceAtLeast(Constraints.m2580getMinWidthimpl(j5) + i5, 0), addMaxWithMinimum(Constraints.m2578getMaxWidthimpl(j5), i5), RangesKt.coerceAtLeast(Constraints.m2579getMinHeightimpl(j5) + i6, 0), addMaxWithMinimum(Constraints.m2577getMaxHeightimpl(j5), i6));
    }

    /* renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m2596offsetNN6EwU$default(long j5, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = 0;
        }
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return m2595offsetNN6EwU(j5, i5, i6);
    }
}
