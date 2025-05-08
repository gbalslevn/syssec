package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u0010\u001a\u00020\r*\u00020\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0015\u001a\u00020\u0013*\u00020\u00112\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\u00020\u0013*\u00020\u00112\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J#\u0010\u0019\u001a\u00020\u0013*\u00020\u00112\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u0016J#\u0010\u001a\u001a\u00020\u0013*\u00020\u00112\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u0016R(\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/unit/Dp;", "minWidth", "minHeight", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", BuildConfig.FLAVOR, "height", "minIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "F", "getMinWidth-D9Ej5fM", "()F", "setMinWidth-0680j_4", "(F)V", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {
    private float minHeight;
    private float minWidth;

    public /* synthetic */ UnspecifiedConstraintsNode(float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5, f6);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        return RangesKt.coerceAtLeast(intrinsicMeasurable.maxIntrinsicHeight(i5), !Dp.m2601equalsimpl0(this.minHeight, Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo206roundToPx0680j_4(this.minHeight) : 0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        return RangesKt.coerceAtLeast(intrinsicMeasurable.maxIntrinsicWidth(i5), !Dp.m2601equalsimpl0(this.minWidth, Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo206roundToPx0680j_4(this.minWidth) : 0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo46measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        float f5 = this.minWidth;
        Dp.Companion companion = Dp.INSTANCE;
        final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(ConstraintsKt.Constraints((Dp.m2601equalsimpl0(f5, companion.m2608getUnspecifiedD9Ej5fM()) || Constraints.m2580getMinWidthimpl(j5) != 0) ? Constraints.m2580getMinWidthimpl(j5) : RangesKt.coerceAtLeast(RangesKt.coerceAtMost(measureScope.mo206roundToPx0680j_4(this.minWidth), Constraints.m2578getMaxWidthimpl(j5)), 0), Constraints.m2578getMaxWidthimpl(j5), (Dp.m2601equalsimpl0(this.minHeight, companion.m2608getUnspecifiedD9Ej5fM()) || Constraints.m2579getMinHeightimpl(j5) != 0) ? Constraints.m2579getMinHeightimpl(j5) : RangesKt.coerceAtLeast(RangesKt.coerceAtMost(measureScope.mo206roundToPx0680j_4(this.minHeight), Constraints.m2577getMaxHeightimpl(j5)), 0), Constraints.m2577getMaxHeightimpl(j5)));
        return MeasureScope.layout$default(measureScope, mo1946measureBRTryo0.getWidth(), mo1946measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.UnspecifiedConstraintsNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        return RangesKt.coerceAtLeast(intrinsicMeasurable.minIntrinsicHeight(i5), !Dp.m2601equalsimpl0(this.minHeight, Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo206roundToPx0680j_4(this.minHeight) : 0);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        return RangesKt.coerceAtLeast(intrinsicMeasurable.minIntrinsicWidth(i5), !Dp.m2601equalsimpl0(this.minWidth, Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo206roundToPx0680j_4(this.minWidth) : 0);
    }

    /* renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m344setMinHeight0680j_4(float f5) {
        this.minHeight = f5;
    }

    /* renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m345setMinWidth0680j_4(float f5) {
        this.minWidth = f5;
    }

    private UnspecifiedConstraintsNode(float f5, float f6) {
        this.minWidth = f5;
        this.minHeight = f6;
    }
}
