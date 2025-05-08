package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0004\b\f\u0010\rJ&\u0010\u0016\u001a\u00020\u0013*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R4\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Landroidx/compose/foundation/layout/WrapContentNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/foundation/layout/Direction;", "direction", BuildConfig.FLAVOR, "unbounded", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/IntOffset;", "alignmentCallback", "<init>", "(Landroidx/compose/foundation/layout/Direction;ZLkotlin/jvm/functions/Function2;)V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/foundation/layout/Direction;", "getDirection", "()Landroidx/compose/foundation/layout/Direction;", "setDirection", "(Landroidx/compose/foundation/layout/Direction;)V", "Z", "getUnbounded", "()Z", "setUnbounded", "(Z)V", "Lkotlin/jvm/functions/Function2;", "getAlignmentCallback", "()Lkotlin/jvm/functions/Function2;", "setAlignmentCallback", "(Lkotlin/jvm/functions/Function2;)V", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class WrapContentNode extends Modifier.Node implements LayoutModifierNode {
    private Function2<? super IntSize, ? super LayoutDirection, IntOffset> alignmentCallback;
    private Direction direction;
    private boolean unbounded;

    public WrapContentNode(Direction direction, boolean z5, Function2<? super IntSize, ? super LayoutDirection, IntOffset> function2) {
        this.direction = direction;
        this.unbounded = z5;
        this.alignmentCallback = function2;
    }

    public final Function2<IntSize, LayoutDirection, IntOffset> getAlignmentCallback() {
        return this.alignmentCallback;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo46measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j5) {
        Direction direction = this.direction;
        Direction direction2 = Direction.Vertical;
        int m2580getMinWidthimpl = direction != direction2 ? 0 : Constraints.m2580getMinWidthimpl(j5);
        Direction direction3 = this.direction;
        Direction direction4 = Direction.Horizontal;
        final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(ConstraintsKt.Constraints(m2580getMinWidthimpl, (this.direction == direction2 || !this.unbounded) ? Constraints.m2578getMaxWidthimpl(j5) : Integer.MAX_VALUE, direction3 == direction4 ? Constraints.m2579getMinHeightimpl(j5) : 0, (this.direction == direction4 || !this.unbounded) ? Constraints.m2577getMaxHeightimpl(j5) : Integer.MAX_VALUE));
        final int coerceIn = RangesKt.coerceIn(mo1946measureBRTryo0.getWidth(), Constraints.m2580getMinWidthimpl(j5), Constraints.m2578getMaxWidthimpl(j5));
        final int coerceIn2 = RangesKt.coerceIn(mo1946measureBRTryo0.getHeight(), Constraints.m2579getMinHeightimpl(j5), Constraints.m2577getMaxHeightimpl(j5));
        return MeasureScope.layout$default(measureScope, coerceIn, coerceIn2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.WrapContentNode$measure$1
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
                Placeable.PlacementScope.m1968place70tqf50$default(placementScope, mo1946measureBRTryo0, WrapContentNode.this.getAlignmentCallback().invoke(IntSize.m2656boximpl(IntSizeKt.IntSize(coerceIn - mo1946measureBRTryo0.getWidth(), coerceIn2 - mo1946measureBRTryo0.getHeight())), measureScope.getLayoutDirection()).getPackedValue(), 0.0f, 2, null);
            }
        }, 4, null);
    }

    public final void setAlignmentCallback(Function2<? super IntSize, ? super LayoutDirection, IntOffset> function2) {
        this.alignmentCallback = function2;
    }

    public final void setDirection(Direction direction) {
        this.direction = direction;
    }

    public final void setUnbounded(boolean z5) {
        this.unbounded = z5;
    }
}
