package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J6\u0010\u001e\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ6\u0010\u001e\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010!2\b\u0010\u0017\u001a\u0004\u0018\u00010!2\u0006\u0010\u001a\u001a\u00020\u0019H\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\"J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010)\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010.\u001a\u0004\b/\u0010'R\u001a\u0010\u0006\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010.\u001a\u0004\b0\u0010'R\"\u00101\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b1\u0010.\u001a\u0004\b2\u0010'\"\u0004\b3\u00104R\"\u00105\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u0010.\u001a\u0004\b6\u0010'\"\u0004\b7\u00104R\u0018\u0010\u0016\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010\u0017\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00108R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010;R\u001e\u0010=\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b=\u0010>R\u001e\u0010?\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b?\u0010>R,\u0010A\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bC\u0010'\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", BuildConfig.FLAVOR, "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "type", BuildConfig.FLAVOR, "minLinesToShowCollapse", "minCrossAxisSizeToShowCollapse", "<init>", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;II)V", BuildConfig.FLAVOR, "hasNext", "lineIndex", "totalCrossAxisSize", "Landroidx/collection/IntIntPair;", "ellipsisSize-F35zm-w$foundation_layout_release", "(ZII)Landroidx/collection/IntIntPair;", "ellipsisSize", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "ellipsisInfo$foundation_layout_release", "(ZII)Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "ellipsisInfo", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "seeMoreMeasurable", "collapseMeasurable", "isHorizontal", "Landroidx/compose/ui/unit/Constraints;", "constraints", BuildConfig.FLAVOR, "setOverflowMeasurables--hBUhpc$foundation_layout_release", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/layout/IntrinsicMeasurable;ZJ)V", "setOverflowMeasurables", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "measurePolicy", "Landroidx/compose/ui/layout/Measurable;", "(Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Landroidx/compose/ui/layout/Measurable;Landroidx/compose/ui/layout/Measurable;J)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "getType$foundation_layout_release", "()Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "I", "getMinLinesToShowCollapse$foundation_layout_release", "getMinCrossAxisSizeToShowCollapse$foundation_layout_release", "itemShown", "getItemShown$foundation_layout_release", "setItemShown$foundation_layout_release", "(I)V", "itemCount", "getItemCount$foundation_layout_release", "setItemCount$foundation_layout_release", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "seeMorePlaceable", "Landroidx/compose/ui/layout/Placeable;", "collapsePlaceable", "seeMoreSize", "Landroidx/collection/IntIntPair;", "collapseSize", "Lkotlin/Function2;", "getOverflowMeasurable", "Lkotlin/jvm/functions/Function2;", "getNoOfItemsShown$foundation_layout_release", "noOfItemsShown", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class FlowLayoutOverflowState {
    private Measurable collapseMeasurable;
    private Placeable collapsePlaceable;
    private IntIntPair collapseSize;
    private Function2<? super Boolean, ? super Integer, ? extends Measurable> getOverflowMeasurable;
    private int itemCount;
    private int itemShown = -1;
    private final int minCrossAxisSizeToShowCollapse;
    private final int minLinesToShowCollapse;
    private Measurable seeMoreMeasurable;
    private Placeable seeMorePlaceable;
    private IntIntPair seeMoreSize;
    private final FlowLayoutOverflow.OverflowType type;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FlowLayoutOverflow.OverflowType.values().length];
            try {
                iArr[FlowLayoutOverflow.OverflowType.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlowLayoutOverflow.OverflowType.Clip.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FlowLayoutOverflow.OverflowType.ExpandIndicator.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FlowLayoutOverflowState(FlowLayoutOverflow.OverflowType overflowType, int i5, int i6) {
        this.type = overflowType;
        this.minLinesToShowCollapse = i5;
        this.minCrossAxisSizeToShowCollapse = i6;
    }

    public final FlowLayoutBuildingBlocks.WrapEllipsisInfo ellipsisInfo$foundation_layout_release(boolean hasNext, int lineIndex, int totalCrossAxisSize) {
        Measurable measurable;
        IntIntPair intIntPair;
        Placeable placeable;
        Measurable measurable2;
        Placeable placeable2;
        int i5 = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i5 == 1 || i5 == 2) {
            return null;
        }
        if (i5 != 3 && i5 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (hasNext) {
            Function2<? super Boolean, ? super Integer, ? extends Measurable> function2 = this.getOverflowMeasurable;
            if (function2 == null || (measurable = function2.invoke(Boolean.TRUE, Integer.valueOf(getNoOfItemsShown$foundation_layout_release()))) == null) {
                measurable = this.seeMoreMeasurable;
            }
            intIntPair = this.seeMoreSize;
            if (this.getOverflowMeasurable == null) {
                placeable = this.seeMorePlaceable;
                measurable2 = measurable;
                placeable2 = placeable;
            }
            measurable2 = measurable;
            placeable2 = null;
        } else {
            if (lineIndex < this.minLinesToShowCollapse - 1 || totalCrossAxisSize < this.minCrossAxisSizeToShowCollapse) {
                measurable = null;
            } else {
                Function2<? super Boolean, ? super Integer, ? extends Measurable> function22 = this.getOverflowMeasurable;
                if (function22 == null || (measurable = function22.invoke(Boolean.FALSE, Integer.valueOf(getNoOfItemsShown$foundation_layout_release()))) == null) {
                    measurable = this.collapseMeasurable;
                }
            }
            intIntPair = this.collapseSize;
            if (this.getOverflowMeasurable == null) {
                placeable = this.collapsePlaceable;
                measurable2 = measurable;
                placeable2 = placeable;
            }
            measurable2 = measurable;
            placeable2 = null;
        }
        if (measurable2 == null) {
            return null;
        }
        Intrinsics.checkNotNull(intIntPair);
        return new FlowLayoutBuildingBlocks.WrapEllipsisInfo(measurable2, placeable2, intIntPair.getPackedValue(), false, 8, null);
    }

    /* renamed from: ellipsisSize-F35zm-w$foundation_layout_release, reason: not valid java name */
    public final IntIntPair m285ellipsisSizeF35zmw$foundation_layout_release(boolean hasNext, int lineIndex, int totalCrossAxisSize) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i5 == 1 || i5 == 2) {
            return null;
        }
        if (i5 == 3) {
            if (hasNext) {
                return this.seeMoreSize;
            }
            return null;
        }
        if (i5 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (hasNext) {
            return this.seeMoreSize;
        }
        if (lineIndex + 1 < this.minLinesToShowCollapse || totalCrossAxisSize < this.minCrossAxisSizeToShowCollapse) {
            return null;
        }
        return this.collapseSize;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowLayoutOverflowState)) {
            return false;
        }
        FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) other;
        return this.type == flowLayoutOverflowState.type && this.minLinesToShowCollapse == flowLayoutOverflowState.minLinesToShowCollapse && this.minCrossAxisSizeToShowCollapse == flowLayoutOverflowState.minCrossAxisSizeToShowCollapse;
    }

    /* renamed from: getMinLinesToShowCollapse$foundation_layout_release, reason: from getter */
    public final int getMinLinesToShowCollapse() {
        return this.minLinesToShowCollapse;
    }

    public final int getNoOfItemsShown$foundation_layout_release() {
        int i5 = this.itemShown;
        if (i5 != -1) {
            return i5;
        }
        throw new IllegalStateException("Accessing noOfItemsShown before it is set. Are you calling this in the Composition phase, rather than in the draw phase? Consider our samples on how to use it during the draw phase or consider using ContextualFlowRow/ContextualFlowColumn which initializes this method in the composition phase.");
    }

    /* renamed from: getType$foundation_layout_release, reason: from getter */
    public final FlowLayoutOverflow.OverflowType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + Integer.hashCode(this.minLinesToShowCollapse)) * 31) + Integer.hashCode(this.minCrossAxisSizeToShowCollapse);
    }

    public final void setItemCount$foundation_layout_release(int i5) {
        this.itemCount = i5;
    }

    public final void setItemShown$foundation_layout_release(int i5) {
        this.itemShown = i5;
    }

    /* renamed from: setOverflowMeasurables--hBUhpc$foundation_layout_release, reason: not valid java name */
    public final void m287setOverflowMeasurableshBUhpc$foundation_layout_release(IntrinsicMeasurable seeMoreMeasurable, IntrinsicMeasurable collapseMeasurable, boolean isHorizontal, long constraints) {
        long m302constructorimpl = OrientationIndependentConstraints.m302constructorimpl(constraints, isHorizontal ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical);
        if (seeMoreMeasurable != null) {
            int mainAxisMin = FlowLayoutKt.mainAxisMin(seeMoreMeasurable, isHorizontal, Constraints.m2577getMaxHeightimpl(m302constructorimpl));
            this.seeMoreSize = IntIntPair.m6boximpl(IntIntPair.m7constructorimpl(mainAxisMin, FlowLayoutKt.crossAxisMin(seeMoreMeasurable, isHorizontal, mainAxisMin)));
            this.seeMoreMeasurable = seeMoreMeasurable instanceof Measurable ? (Measurable) seeMoreMeasurable : null;
            this.seeMorePlaceable = null;
        }
        if (collapseMeasurable != null) {
            int mainAxisMin2 = FlowLayoutKt.mainAxisMin(collapseMeasurable, isHorizontal, Constraints.m2577getMaxHeightimpl(m302constructorimpl));
            this.collapseSize = IntIntPair.m6boximpl(IntIntPair.m7constructorimpl(mainAxisMin2, FlowLayoutKt.crossAxisMin(collapseMeasurable, isHorizontal, mainAxisMin2)));
            this.collapseMeasurable = collapseMeasurable instanceof Measurable ? (Measurable) collapseMeasurable : null;
            this.collapsePlaceable = null;
        }
    }

    public String toString() {
        return "FlowLayoutOverflowState(type=" + this.type + ", minLinesToShowCollapse=" + this.minLinesToShowCollapse + ", minCrossAxisSizeToShowCollapse=" + this.minCrossAxisSizeToShowCollapse + ')';
    }

    /* renamed from: setOverflowMeasurables--hBUhpc$foundation_layout_release, reason: not valid java name */
    public final void m286setOverflowMeasurableshBUhpc$foundation_layout_release(final FlowLineMeasurePolicy measurePolicy, Measurable seeMoreMeasurable, Measurable collapseMeasurable, long constraints) {
        LayoutOrientation layoutOrientation = measurePolicy.getIsHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical;
        long m305toBoxConstraintsOenEA2s = OrientationIndependentConstraints.m305toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m304copyyUG9Ft0$default(OrientationIndependentConstraints.m302constructorimpl(constraints, layoutOrientation), 0, 0, 0, 0, 10, null), layoutOrientation);
        if (seeMoreMeasurable != null) {
            FlowLayoutKt.m283measureAndCacherqJ1uqs(seeMoreMeasurable, measurePolicy, m305toBoxConstraintsOenEA2s, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutOverflowState$setOverflowMeasurables$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable placeable) {
                    invoke2(placeable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable placeable) {
                    int i5;
                    int i6;
                    if (placeable != null) {
                        FlowLineMeasurePolicy flowLineMeasurePolicy = measurePolicy;
                        i5 = flowLineMeasurePolicy.mainAxisSize(placeable);
                        i6 = flowLineMeasurePolicy.crossAxisSize(placeable);
                    } else {
                        i5 = 0;
                        i6 = 0;
                    }
                    FlowLayoutOverflowState.this.seeMoreSize = IntIntPair.m6boximpl(IntIntPair.m7constructorimpl(i5, i6));
                    FlowLayoutOverflowState.this.seeMorePlaceable = placeable;
                }
            });
            this.seeMoreMeasurable = seeMoreMeasurable;
        }
        if (collapseMeasurable != null) {
            FlowLayoutKt.m283measureAndCacherqJ1uqs(collapseMeasurable, measurePolicy, m305toBoxConstraintsOenEA2s, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutOverflowState$setOverflowMeasurables$4$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable placeable) {
                    invoke2(placeable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable placeable) {
                    int i5;
                    int i6;
                    if (placeable != null) {
                        FlowLineMeasurePolicy flowLineMeasurePolicy = measurePolicy;
                        i5 = flowLineMeasurePolicy.mainAxisSize(placeable);
                        i6 = flowLineMeasurePolicy.crossAxisSize(placeable);
                    } else {
                        i5 = 0;
                        i6 = 0;
                    }
                    FlowLayoutOverflowState.this.collapseSize = IntIntPair.m6boximpl(IntIntPair.m7constructorimpl(i5, i6));
                    FlowLayoutOverflowState.this.collapsePlaceable = placeable;
                }
            });
            this.collapseMeasurable = collapseMeasurable;
        }
    }
}
