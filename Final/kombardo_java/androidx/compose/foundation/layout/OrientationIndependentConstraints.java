package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0081@\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0007\u0010\rB\u0011\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\rJ;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u0088\u0001\u000e\u0092\u0001\u00020\t\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "mainAxisMin", "mainAxisMax", "crossAxisMin", "crossAxisMax", "constructor-impl", "(IIII)J", "Landroidx/compose/ui/unit/Constraints;", "c", "Landroidx/compose/foundation/layout/LayoutOrientation;", "orientation", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)J", "value", "(J)J", "toBoxConstraints-OenEA2s", "toBoxConstraints", "copy-yUG9Ft0", "(JIIII)J", "copy", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class OrientationIndependentConstraints {
    /* renamed from: constructor-impl, reason: not valid java name */
    private static long m301constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: copy-yUG9Ft0, reason: not valid java name */
    public static final long m303copyyUG9Ft0(long j5, int i5, int i6, int i7, int i8) {
        return m300constructorimpl(i5, i6, i7, i8);
    }

    /* renamed from: copy-yUG9Ft0$default, reason: not valid java name */
    public static /* synthetic */ long m304copyyUG9Ft0$default(long j5, int i5, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i5 = Constraints.m2580getMinWidthimpl(j5);
        }
        int i10 = i5;
        if ((i9 & 2) != 0) {
            i6 = Constraints.m2578getMaxWidthimpl(j5);
        }
        int i11 = i6;
        if ((i9 & 4) != 0) {
            i7 = Constraints.m2579getMinHeightimpl(j5);
        }
        int i12 = i7;
        if ((i9 & 8) != 0) {
            i8 = Constraints.m2577getMaxHeightimpl(j5);
        }
        return m303copyyUG9Ft0(j5, i10, i11, i12, i8);
    }

    /* renamed from: toBoxConstraints-OenEA2s, reason: not valid java name */
    public static final long m305toBoxConstraintsOenEA2s(long j5, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? ConstraintsKt.Constraints(Constraints.m2580getMinWidthimpl(j5), Constraints.m2578getMaxWidthimpl(j5), Constraints.m2579getMinHeightimpl(j5), Constraints.m2577getMaxHeightimpl(j5)) : ConstraintsKt.Constraints(Constraints.m2579getMinHeightimpl(j5), Constraints.m2577getMaxHeightimpl(j5), Constraints.m2580getMinWidthimpl(j5), Constraints.m2578getMaxWidthimpl(j5));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m300constructorimpl(int i5, int i6, int i7, int i8) {
        return m301constructorimpl(ConstraintsKt.Constraints(i5, i6, i7, i8));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m302constructorimpl(long j5, LayoutOrientation layoutOrientation) {
        LayoutOrientation layoutOrientation2 = LayoutOrientation.Horizontal;
        return m300constructorimpl(layoutOrientation == layoutOrientation2 ? Constraints.m2580getMinWidthimpl(j5) : Constraints.m2579getMinHeightimpl(j5), layoutOrientation == layoutOrientation2 ? Constraints.m2578getMaxWidthimpl(j5) : Constraints.m2577getMaxHeightimpl(j5), layoutOrientation == layoutOrientation2 ? Constraints.m2579getMinHeightimpl(j5) : Constraints.m2580getMinWidthimpl(j5), layoutOrientation == layoutOrientation2 ? Constraints.m2577getMaxHeightimpl(j5) : Constraints.m2578getMaxWidthimpl(j5));
    }
}
