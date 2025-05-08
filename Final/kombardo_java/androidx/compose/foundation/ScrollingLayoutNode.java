package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u001c\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J&\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001c\u0010!\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\"\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0012H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\f\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Landroidx/compose/foundation/ScrollingLayoutNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "scrollerState", "Landroidx/compose/foundation/ScrollState;", "isReversed", BuildConfig.FLAVOR, "isVertical", "(Landroidx/compose/foundation/ScrollState;ZZ)V", "()Z", "setReversed", "(Z)V", "setVertical", "getScrollerState", "()Landroidx/compose/foundation/ScrollState;", "setScrollerState", "(Landroidx/compose/foundation/ScrollState;)V", "maxIntrinsicHeight", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollingLayoutNode extends Modifier.Node implements LayoutModifierNode {
    private boolean isReversed;
    private boolean isVertical;
    private ScrollState scrollerState;

    public ScrollingLayoutNode(ScrollState scrollState, boolean z5, boolean z6) {
        this.scrollerState = scrollState;
        this.isReversed = z5;
        this.isVertical = z6;
    }

    public final ScrollState getScrollerState() {
        return this.scrollerState;
    }

    /* renamed from: isReversed, reason: from getter */
    public final boolean getIsReversed() {
        return this.isReversed;
    }

    /* renamed from: isVertical, reason: from getter */
    public final boolean getIsVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        return this.isVertical ? intrinsicMeasurable.maxIntrinsicHeight(i5) : intrinsicMeasurable.maxIntrinsicHeight(Integer.MAX_VALUE);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        return this.isVertical ? intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE) : intrinsicMeasurable.maxIntrinsicWidth(i5);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo46measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        CheckScrollableContainerConstraintsKt.m118checkScrollableContainerConstraintsK40F9xA(j5, this.isVertical ? Orientation.Vertical : Orientation.Horizontal);
        final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(Constraints.m2570copyZbe2FdA$default(j5, 0, this.isVertical ? Constraints.m2578getMaxWidthimpl(j5) : Integer.MAX_VALUE, 0, this.isVertical ? Integer.MAX_VALUE : Constraints.m2577getMaxHeightimpl(j5), 5, null));
        int coerceAtMost = RangesKt.coerceAtMost(mo1946measureBRTryo0.getWidth(), Constraints.m2578getMaxWidthimpl(j5));
        int coerceAtMost2 = RangesKt.coerceAtMost(mo1946measureBRTryo0.getHeight(), Constraints.m2577getMaxHeightimpl(j5));
        final int height = mo1946measureBRTryo0.getHeight() - coerceAtMost2;
        int width = mo1946measureBRTryo0.getWidth() - coerceAtMost;
        if (!this.isVertical) {
            height = width;
        }
        this.scrollerState.setMaxValue$foundation_release(height);
        this.scrollerState.setViewportSize$foundation_release(this.isVertical ? coerceAtMost2 : coerceAtMost);
        return MeasureScope.layout$default(measureScope, coerceAtMost, coerceAtMost2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.ScrollingLayoutNode$measure$1
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
                int coerceIn = RangesKt.coerceIn(ScrollingLayoutNode.this.getScrollerState().getValue(), 0, height);
                int i5 = ScrollingLayoutNode.this.getIsReversed() ? coerceIn - height : -coerceIn;
                final int i6 = ScrollingLayoutNode.this.getIsVertical() ? 0 : i5;
                final int i7 = ScrollingLayoutNode.this.getIsVertical() ? i5 : 0;
                final Placeable placeable = mo1946measureBRTryo0;
                placementScope.withMotionFrameOfReferencePlacement(new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.ScrollingLayoutNode$measure$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope2) {
                        invoke2(placementScope2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope placementScope2) {
                        Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope2, Placeable.this, i6, i7, 0.0f, null, 12, null);
                    }
                });
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        return this.isVertical ? intrinsicMeasurable.minIntrinsicHeight(i5) : intrinsicMeasurable.minIntrinsicHeight(Integer.MAX_VALUE);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        return this.isVertical ? intrinsicMeasurable.minIntrinsicWidth(Integer.MAX_VALUE) : intrinsicMeasurable.minIntrinsicWidth(i5);
    }

    public final void setReversed(boolean z5) {
        this.isReversed = z5;
    }

    public final void setScrollerState(ScrollState scrollState) {
        this.scrollerState = scrollState;
    }

    public final void setVertical(boolean z5) {
        this.isVertical = z5;
    }
}
