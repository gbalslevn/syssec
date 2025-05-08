package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002BO\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J2\u0010\u001e\u001a\u00020\u001b*\u00020\u00152\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\"\u001a\u00020\u000e*\u00020\u001f2\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00160\u00162\u0006\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010#J/\u0010%\u001a\u00020\u000e*\u00020\u001f2\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00160\u00162\u0006\u0010$\u001a\u00020\u000eH\u0016¢\u0006\u0004\b%\u0010#J/\u0010&\u001a\u00020\u000e*\u00020\u001f2\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00160\u00162\u0006\u0010$\u001a\u00020\u000eH\u0016¢\u0006\u0004\b&\u0010#J/\u0010'\u001a\u00020\u000e*\u00020\u001f2\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00160\u00162\u0006\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b'\u0010#JK\u0010*\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020 0\u00162\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b*\u0010+J+\u0010-\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020 0\u00162\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e¢\u0006\u0004\b-\u0010.JK\u00100\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020 0\u00162\u0006\u0010/\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b0\u0010+J\u0010\u00102\u001a\u000201HÖ\u0001¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b4\u00105J\u001a\u00108\u001a\u00020\u00032\b\u00107\u001a\u0004\u0018\u000106HÖ\u0003¢\u0006\u0004\b8\u00109R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010:\u001a\u0004\b\u0004\u0010;R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010<\u001a\u0004\b=\u0010>R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\n\u0010BR\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010C\u001a\u0004\bD\u0010ER\u001a\u0010\r\u001a\u00020\t8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\r\u0010BR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010FR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010FR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010GR/\u0010I\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0H8\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR/\u0010M\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0H8\u0006¢\u0006\f\n\u0004\bM\u0010J\u001a\u0004\bN\u0010LR/\u0010O\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0H8\u0006¢\u0006\f\n\u0004\bO\u0010J\u001a\u0004\bP\u0010LR/\u0010Q\u001a\u001a\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0H8\u0006¢\u0006\f\n\u0004\bQ\u0010J\u001a\u0004\bR\u0010L\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006S"}, d2 = {"Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", BuildConfig.FLAVOR, "isHorizontal", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalArrangement", "Landroidx/compose/ui/unit/Dp;", "mainAxisSpacing", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisAlignment", "crossAxisArrangementSpacing", BuildConfig.FLAVOR, "maxItemsInMainAxis", "maxLines", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflow", "<init>", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/layout/MeasureScope;", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/Measurable;", "measurables", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Ljava/util/List;I)I", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "maxIntrinsicWidth", "crossAxisAvailable", "crossAxisSpacing", "minIntrinsicMainAxisSize", "(Ljava/util/List;IIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)I", "arrangementSpacing", "maxIntrinsicMainAxisSize", "(Ljava/util/List;II)I", "mainAxisAvailable", "intrinsicCrossAxisSize", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "F", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "I", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Lkotlin/Function3;", "maxMainAxisIntrinsicItemSize", "Lkotlin/jvm/functions/Function3;", "getMaxMainAxisIntrinsicItemSize", "()Lkotlin/jvm/functions/Function3;", "maxCrossAxisIntrinsicItemSize", "getMaxCrossAxisIntrinsicItemSize", "minCrossAxisIntrinsicItemSize", "getMinCrossAxisIntrinsicItemSize", "minMainAxisIntrinsicItemSize", "getMinMainAxisIntrinsicItemSize", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class FlowMeasurePolicy implements MultiContentMeasurePolicy, FlowLineMeasurePolicy {
    private final CrossAxisAlignment crossAxisAlignment;
    private final float crossAxisArrangementSpacing;
    private final Arrangement.Horizontal horizontalArrangement;
    private final boolean isHorizontal;
    private final float mainAxisSpacing;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxCrossAxisIntrinsicItemSize;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxMainAxisIntrinsicItemSize;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minCrossAxisIntrinsicItemSize;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minMainAxisIntrinsicItemSize;
    private final FlowLayoutOverflowState overflow;
    private final Arrangement.Vertical verticalArrangement;

    public /* synthetic */ FlowMeasurePolicy(boolean z5, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f5, CrossAxisAlignment crossAxisAlignment, float f6, int i5, int i6, FlowLayoutOverflowState flowLayoutOverflowState, DefaultConstructorMarker defaultConstructorMarker) {
        this(z5, horizontal, vertical, f5, crossAxisAlignment, f6, i5, i6, flowLayoutOverflowState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowMeasurePolicy)) {
            return false;
        }
        FlowMeasurePolicy flowMeasurePolicy = (FlowMeasurePolicy) other;
        return this.isHorizontal == flowMeasurePolicy.isHorizontal && Intrinsics.areEqual(this.horizontalArrangement, flowMeasurePolicy.horizontalArrangement) && Intrinsics.areEqual(this.verticalArrangement, flowMeasurePolicy.verticalArrangement) && Dp.m2601equalsimpl0(this.mainAxisSpacing, flowMeasurePolicy.mainAxisSpacing) && Intrinsics.areEqual(this.crossAxisAlignment, flowMeasurePolicy.crossAxisAlignment) && Dp.m2601equalsimpl0(this.crossAxisArrangementSpacing, flowMeasurePolicy.crossAxisArrangementSpacing) && this.maxItemsInMainAxis == flowMeasurePolicy.maxItemsInMainAxis && this.maxLines == flowMeasurePolicy.maxLines && Intrinsics.areEqual(this.overflow, flowMeasurePolicy.overflow);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    public int hashCode() {
        return (((((((((((((((Boolean.hashCode(this.isHorizontal) * 31) + this.horizontalArrangement.hashCode()) * 31) + this.verticalArrangement.hashCode()) * 31) + Dp.m2602hashCodeimpl(this.mainAxisSpacing)) * 31) + this.crossAxisAlignment.hashCode()) * 31) + Dp.m2602hashCodeimpl(this.crossAxisArrangementSpacing)) * 31) + Integer.hashCode(this.maxItemsInMainAxis)) * 31) + Integer.hashCode(this.maxLines)) * 31) + this.overflow.hashCode();
    }

    public final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> measurables, int mainAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflow) {
        long intrinsicCrossAxisSize;
        intrinsicCrossAxisSize = FlowLayoutKt.intrinsicCrossAxisSize((List<? extends IntrinsicMeasurable>) measurables, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) this.minMainAxisIntrinsicItemSize, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) this.minCrossAxisIntrinsicItemSize, mainAxisAvailable, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis, maxLines, overflow);
        return IntIntPair.m10getFirstimpl(intrinsicCrossAxisSize);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    /* renamed from: isHorizontal, reason: from getter */
    public boolean getIsHorizontal() {
        return this.isHorizontal;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i5) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        flowLayoutOverflowState.m287setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3) : null, getIsHorizontal(), ConstraintsKt.Constraints$default(0, i5, 0, 0, 13, null));
        if (getIsHorizontal()) {
            List<? extends IntrinsicMeasurable> list4 = (List) CollectionsKt.firstOrNull((List) list);
            if (list4 == null) {
                list4 = CollectionsKt.emptyList();
            }
            return intrinsicCrossAxisSize(list4, i5, intrinsicMeasureScope.mo206roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo206roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        List<? extends IntrinsicMeasurable> list5 = (List) CollectionsKt.firstOrNull((List) list);
        if (list5 == null) {
            list5 = CollectionsKt.emptyList();
        }
        return maxIntrinsicMainAxisSize(list5, i5, intrinsicMeasureScope.mo206roundToPx0680j_4(this.mainAxisSpacing));
    }

    public final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> measurables, int height, int arrangementSpacing) {
        int maxIntrinsicMainAxisSize;
        maxIntrinsicMainAxisSize = FlowLayoutKt.maxIntrinsicMainAxisSize(measurables, this.maxMainAxisIntrinsicItemSize, height, arrangementSpacing, this.maxItemsInMainAxis);
        return maxIntrinsicMainAxisSize;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i5) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        flowLayoutOverflowState.m287setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3) : null, getIsHorizontal(), ConstraintsKt.Constraints$default(0, 0, 0, i5, 7, null));
        if (getIsHorizontal()) {
            List<? extends IntrinsicMeasurable> list4 = (List) CollectionsKt.firstOrNull((List) list);
            if (list4 == null) {
                list4 = CollectionsKt.emptyList();
            }
            return maxIntrinsicMainAxisSize(list4, i5, intrinsicMeasureScope.mo206roundToPx0680j_4(this.mainAxisSpacing));
        }
        List<? extends IntrinsicMeasurable> list5 = (List) CollectionsKt.firstOrNull((List) list);
        if (list5 == null) {
            list5 = CollectionsKt.emptyList();
        }
        return intrinsicCrossAxisSize(list5, i5, intrinsicMeasureScope.mo206roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo206roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult mo288measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j5) {
        if (this.maxLines == 0 || this.maxItemsInMainAxis == 0 || list.isEmpty() || (Constraints.m2577getMaxHeightimpl(j5) == 0 && this.overflow.getType() != FlowLayoutOverflow.OverflowType.Visible)) {
            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$measure$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }, 4, null);
        }
        List list2 = (List) CollectionsKt.first((List) list);
        if (list2.isEmpty()) {
            return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$measure$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }, 4, null);
        }
        List list3 = (List) CollectionsKt.getOrNull(list, 1);
        Measurable measurable = list3 != null ? (Measurable) CollectionsKt.firstOrNull(list3) : null;
        List list4 = (List) CollectionsKt.getOrNull(list, 2);
        Measurable measurable2 = list4 != null ? (Measurable) CollectionsKt.firstOrNull(list4) : null;
        this.overflow.setItemCount$foundation_layout_release(list2.size());
        this.overflow.m286setOverflowMeasurableshBUhpc$foundation_layout_release(this, measurable, measurable2, j5);
        return FlowLayoutKt.m282breakDownItemsdi9J0FM(measureScope, this, list2.iterator(), this.mainAxisSpacing, this.crossAxisArrangementSpacing, OrientationIndependentConstraints.m302constructorimpl(j5, getIsHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i5) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        flowLayoutOverflowState.m287setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3) : null, getIsHorizontal(), ConstraintsKt.Constraints$default(0, i5, 0, 0, 13, null));
        if (getIsHorizontal()) {
            List<? extends IntrinsicMeasurable> list4 = (List) CollectionsKt.firstOrNull((List) list);
            if (list4 == null) {
                list4 = CollectionsKt.emptyList();
            }
            return intrinsicCrossAxisSize(list4, i5, intrinsicMeasureScope.mo206roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo206roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        List<? extends IntrinsicMeasurable> list5 = (List) CollectionsKt.firstOrNull((List) list);
        if (list5 == null) {
            list5 = CollectionsKt.emptyList();
        }
        return minIntrinsicMainAxisSize(list5, i5, intrinsicMeasureScope.mo206roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo206roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    public final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> measurables, int crossAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflow) {
        int minIntrinsicMainAxisSize;
        minIntrinsicMainAxisSize = FlowLayoutKt.minIntrinsicMainAxisSize(measurables, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, crossAxisAvailable, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis, maxLines, overflow);
        return minIntrinsicMainAxisSize;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i5) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        flowLayoutOverflowState.m287setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3) : null, getIsHorizontal(), ConstraintsKt.Constraints$default(0, 0, 0, i5, 7, null));
        if (getIsHorizontal()) {
            List<? extends IntrinsicMeasurable> list4 = (List) CollectionsKt.firstOrNull((List) list);
            if (list4 == null) {
                list4 = CollectionsKt.emptyList();
            }
            return minIntrinsicMainAxisSize(list4, i5, intrinsicMeasureScope.mo206roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo206roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        List<? extends IntrinsicMeasurable> list5 = (List) CollectionsKt.firstOrNull((List) list);
        if (list5 == null) {
            list5 = CollectionsKt.emptyList();
        }
        return intrinsicCrossAxisSize(list5, i5, intrinsicMeasureScope.mo206roundToPx0680j_4(this.mainAxisSpacing), intrinsicMeasureScope.mo206roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    public String toString() {
        return "FlowMeasurePolicy(isHorizontal=" + this.isHorizontal + ", horizontalArrangement=" + this.horizontalArrangement + ", verticalArrangement=" + this.verticalArrangement + ", mainAxisSpacing=" + ((Object) Dp.m2603toStringimpl(this.mainAxisSpacing)) + ", crossAxisAlignment=" + this.crossAxisAlignment + ", crossAxisArrangementSpacing=" + ((Object) Dp.m2603toStringimpl(this.crossAxisArrangementSpacing)) + ", maxItemsInMainAxis=" + this.maxItemsInMainAxis + ", maxLines=" + this.maxLines + ", overflow=" + this.overflow + ')';
    }

    private FlowMeasurePolicy(boolean z5, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f5, CrossAxisAlignment crossAxisAlignment, float f6, int i5, int i6, FlowLayoutOverflowState flowLayoutOverflowState) {
        this.isHorizontal = z5;
        this.horizontalArrangement = horizontal;
        this.verticalArrangement = vertical;
        this.mainAxisSpacing = f5;
        this.crossAxisAlignment = crossAxisAlignment;
        this.crossAxisArrangementSpacing = f6;
        this.maxItemsInMainAxis = i5;
        this.maxLines = i6;
        this.overflow = flowLayoutOverflowState;
        this.maxMainAxisIntrinsicItemSize = getIsHorizontal() ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$maxMainAxisIntrinsicItemSize$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i7, int i8) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i8));
            }
        } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$maxMainAxisIntrinsicItemSize$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i7, int i8) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i8));
            }
        };
        this.maxCrossAxisIntrinsicItemSize = getIsHorizontal() ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$maxCrossAxisIntrinsicItemSize$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i7, int i8) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i8));
            }
        } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$maxCrossAxisIntrinsicItemSize$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i7, int i8) {
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i8));
            }
        };
        this.minCrossAxisIntrinsicItemSize = getIsHorizontal() ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$minCrossAxisIntrinsicItemSize$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i7, int i8) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i8));
            }
        } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$minCrossAxisIntrinsicItemSize$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i7, int i8) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i8));
            }
        };
        this.minMainAxisIntrinsicItemSize = getIsHorizontal() ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$minMainAxisIntrinsicItemSize$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i7, int i8) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i8));
            }
        } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$minMainAxisIntrinsicItemSize$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i7, int i8) {
                return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i8));
            }
        };
    }
}
