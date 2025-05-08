package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u0012\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\r*\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\r*\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0015J/\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJi\u0010'\u001a\u00020&2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0 2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u00182\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\rH\u0016¢\u0006\u0004\b'\u0010(J=\u00102\u001a\u00020/2\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\r2\u0006\u0010.\u001a\u00020-H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J,\u00109\u001a\u00020&*\u00020\u001b2\f\u00105\u001a\b\u0012\u0004\u0012\u000204032\u0006\u00106\u001a\u00020/H\u0016ø\u0001\u0001¢\u0006\u0004\b7\u00108J)\u0010=\u001a\u00020\r*\u00020:2\f\u00105\u001a\b\u0012\u0004\u0012\u00020;032\u0006\u0010<\u001a\u00020\rH\u0016¢\u0006\u0004\b=\u0010>J)\u0010@\u001a\u00020\r*\u00020:2\f\u00105\u001a\b\u0012\u0004\u0012\u00020;032\u0006\u0010?\u001a\u00020\rH\u0016¢\u0006\u0004\b@\u0010>J)\u0010A\u001a\u00020\r*\u00020:2\f\u00105\u001a\b\u0012\u0004\u0012\u00020;032\u0006\u0010<\u001a\u00020\rH\u0016¢\u0006\u0004\bA\u0010>J)\u0010B\u001a\u00020\r*\u00020:2\f\u00105\u001a\b\u0012\u0004\u0012\u00020;032\u0006\u0010?\u001a\u00020\rH\u0016¢\u0006\u0004\bB\u0010>J\u0010\u0010D\u001a\u00020CHÖ\u0001¢\u0006\u0004\bD\u0010EJ\u0010\u0010F\u001a\u00020\rHÖ\u0001¢\u0006\u0004\bF\u0010GJ\u001a\u0010J\u001a\u00020-2\b\u0010I\u001a\u0004\u0018\u00010HHÖ\u0003¢\u0006\u0004\bJ\u0010KR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010LR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010M\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006N"}, d2 = {"Landroidx/compose/foundation/layout/ColumnMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalArrangement", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontalAlignment", "<init>", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;)V", "Landroidx/compose/ui/layout/Placeable;", "placeable", "Landroidx/compose/foundation/layout/RowColumnParentData;", "parentData", BuildConfig.FLAVOR, "crossAxisLayoutSize", "beforeCrossAxisAlignmentLine", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getCrossAxisPosition", "(Landroidx/compose/ui/layout/Placeable;Landroidx/compose/foundation/layout/RowColumnParentData;IILandroidx/compose/ui/unit/LayoutDirection;)I", "mainAxisSize", "(Landroidx/compose/ui/layout/Placeable;)I", "crossAxisSize", "mainAxisLayoutSize", BuildConfig.FLAVOR, "childrenMainAxisSize", "mainAxisPositions", "Landroidx/compose/ui/layout/MeasureScope;", "measureScope", BuildConfig.FLAVOR, "populateMainAxisPositions", "(I[I[ILandroidx/compose/ui/layout/MeasureScope;)V", BuildConfig.FLAVOR, "placeables", "crossAxisOffset", "currentLineIndex", "startIndex", "endIndex", "Landroidx/compose/ui/layout/MeasureResult;", "placeHelper", "([Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/MeasureScope;I[III[IIII)Landroidx/compose/ui/layout/MeasureResult;", "mainAxisMin", "crossAxisMin", "mainAxisMax", "crossAxisMax", BuildConfig.FLAVOR, "isPrioritizing", "Landroidx/compose/ui/unit/Constraints;", "createConstraints-xF2OJ5Q", "(IIIIZ)J", "createConstraints", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/Measurable;", "measurables", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Ljava/util/List;I)I", "width", "minIntrinsicHeight", "maxIntrinsicWidth", "maxIntrinsicHeight", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Landroidx/compose/ui/Alignment$Horizontal;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ColumnMeasurePolicy implements MeasurePolicy, RowColumnMeasurePolicy {
    private final Alignment.Horizontal horizontalAlignment;
    private final Arrangement.Vertical verticalArrangement;

    public ColumnMeasurePolicy(Arrangement.Vertical vertical, Alignment.Horizontal horizontal) {
        this.verticalArrangement = vertical;
        this.horizontalAlignment = horizontal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCrossAxisPosition(Placeable placeable, RowColumnParentData parentData, int crossAxisLayoutSize, int beforeCrossAxisAlignmentLine, LayoutDirection layoutDirection) {
        CrossAxisAlignment crossAxisAlignment = parentData != null ? parentData.getCrossAxisAlignment() : null;
        return crossAxisAlignment != null ? crossAxisAlignment.align$foundation_layout_release(crossAxisLayoutSize - placeable.getWidth(), layoutDirection, placeable, beforeCrossAxisAlignmentLine) : this.horizontalAlignment.align(0, crossAxisLayoutSize - placeable.getWidth(), layoutDirection);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    /* renamed from: createConstraints-xF2OJ5Q, reason: not valid java name */
    public long mo279createConstraintsxF2OJ5Q(int mainAxisMin, int crossAxisMin, int mainAxisMax, int crossAxisMax, boolean isPrioritizing) {
        return ColumnKt.createColumnConstraints(isPrioritizing, mainAxisMin, crossAxisMin, mainAxisMax, crossAxisMax);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int crossAxisSize(Placeable placeable) {
        return placeable.getWidth();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColumnMeasurePolicy)) {
            return false;
        }
        ColumnMeasurePolicy columnMeasurePolicy = (ColumnMeasurePolicy) other;
        return Intrinsics.areEqual(this.verticalArrangement, columnMeasurePolicy.verticalArrangement) && Intrinsics.areEqual(this.horizontalAlignment, columnMeasurePolicy.horizontalAlignment);
    }

    public int hashCode() {
        return (this.verticalArrangement.hashCode() * 31) + this.horizontalAlignment.hashCode();
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public int mainAxisSize(Placeable placeable) {
        return placeable.getHeight();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMaxHeight(list, i5, intrinsicMeasureScope.mo206roundToPx0680j_4(this.verticalArrangement.getSpacing()));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMaxWidth(list, i5, intrinsicMeasureScope.mo206roundToPx0680j_4(this.verticalArrangement.getSpacing()));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
        MeasureResult measure;
        measure = RowColumnMeasurePolicyKt.measure(this, Constraints.m2579getMinHeightimpl(j5), Constraints.m2580getMinWidthimpl(j5), Constraints.m2577getMaxHeightimpl(j5), Constraints.m2578getMaxWidthimpl(j5), measureScope.mo206roundToPx0680j_4(this.verticalArrangement.getSpacing()), measureScope, list, new Placeable[list.size()], 0, list.size(), (r28 & 1024) != 0 ? null : null, (r28 & 2048) != 0 ? 0 : 0);
        return measure;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMinHeight(list, i5, intrinsicMeasureScope.mo206roundToPx0680j_4(this.verticalArrangement.getSpacing()));
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
        return IntrinsicMeasureBlocks.INSTANCE.VerticalMinWidth(list, i5, intrinsicMeasureScope.mo206roundToPx0680j_4(this.verticalArrangement.getSpacing()));
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public MeasureResult placeHelper(final Placeable[] placeables, final MeasureScope measureScope, final int beforeCrossAxisAlignmentLine, final int[] mainAxisPositions, int mainAxisLayoutSize, final int crossAxisLayoutSize, int[] crossAxisOffset, int currentLineIndex, int startIndex, int endIndex) {
        return MeasureScope.layout$default(measureScope, crossAxisLayoutSize, mainAxisLayoutSize, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.ColumnMeasurePolicy$placeHelper$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                int crossAxisPosition;
                Placeable[] placeableArr = placeables;
                ColumnMeasurePolicy columnMeasurePolicy = this;
                int i5 = crossAxisLayoutSize;
                int i6 = beforeCrossAxisAlignmentLine;
                MeasureScope measureScope2 = measureScope;
                int[] iArr = mainAxisPositions;
                int length = placeableArr.length;
                int i7 = 0;
                int i8 = 0;
                while (i7 < length) {
                    Placeable placeable = placeableArr[i7];
                    Intrinsics.checkNotNull(placeable);
                    crossAxisPosition = columnMeasurePolicy.getCrossAxisPosition(placeable, RowColumnImplKt.getRowColumnParentData(placeable), i5, i6, measureScope2.getLayoutDirection());
                    Placeable.PlacementScope.place$default(placementScope, placeable, crossAxisPosition, iArr[i8], 0.0f, 4, null);
                    i7++;
                    i8++;
                }
            }
        }, 4, null);
    }

    @Override // androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public void populateMainAxisPositions(int mainAxisLayoutSize, int[] childrenMainAxisSize, int[] mainAxisPositions, MeasureScope measureScope) {
        this.verticalArrangement.arrange(measureScope, mainAxisLayoutSize, childrenMainAxisSize, mainAxisPositions);
    }

    public String toString() {
        return "ColumnMeasurePolicy(verticalArrangement=" + this.verticalArrangement + ", horizontalAlignment=" + this.horizontalAlignment + ')';
    }
}
