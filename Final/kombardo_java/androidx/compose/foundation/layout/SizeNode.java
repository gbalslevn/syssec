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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u0014\u001a\u00020\u0011*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0019\u001a\u00020\u0017*\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001c\u001a\u00020\u0017*\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ#\u0010\u001d\u001a\u00020\u0017*\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001d\u0010\u001aJ#\u0010\u001e\u001a\u00020\u0017*\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001e\u0010\u001aR(\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R(\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R(\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u00102\u001a\u00020\u000f*\u00020/8BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b0\u00101\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00063"}, d2 = {"Landroidx/compose/foundation/layout/SizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/unit/Dp;", "minWidth", "minHeight", "maxWidth", "maxHeight", BuildConfig.FLAVOR, "enforceIncoming", "<init>", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", BuildConfig.FLAVOR, "height", "minIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I", "width", "minIntrinsicHeight", "maxIntrinsicWidth", "maxIntrinsicHeight", "F", "getMinWidth-D9Ej5fM", "()F", "setMinWidth-0680j_4", "(F)V", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "getMaxWidth-D9Ej5fM", "setMaxWidth-0680j_4", "getMaxHeight-D9Ej5fM", "setMaxHeight-0680j_4", "Z", "getEnforceIncoming", "()Z", "setEnforceIncoming", "(Z)V", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "targetConstraints", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public /* synthetic */ SizeNode(float f5, float f6, float f7, float f8, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f5, f6, f7, f8, z5);
    }

    /* renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    private final long m339getTargetConstraintsOenEA2s(Density density) {
        int i5;
        int coerceAtLeast;
        float f5 = this.maxWidth;
        Dp.Companion companion = Dp.INSTANCE;
        int i6 = 0;
        int coerceAtLeast2 = !Dp.m2601equalsimpl0(f5, companion.m2608getUnspecifiedD9Ej5fM()) ? RangesKt.coerceAtLeast(density.mo206roundToPx0680j_4(this.maxWidth), 0) : Integer.MAX_VALUE;
        int coerceAtLeast3 = !Dp.m2601equalsimpl0(this.maxHeight, companion.m2608getUnspecifiedD9Ej5fM()) ? RangesKt.coerceAtLeast(density.mo206roundToPx0680j_4(this.maxHeight), 0) : Integer.MAX_VALUE;
        if (Dp.m2601equalsimpl0(this.minWidth, companion.m2608getUnspecifiedD9Ej5fM()) || (i5 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(density.mo206roundToPx0680j_4(this.minWidth), coerceAtLeast2), 0)) == Integer.MAX_VALUE) {
            i5 = 0;
        }
        if (!Dp.m2601equalsimpl0(this.minHeight, companion.m2608getUnspecifiedD9Ej5fM()) && (coerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(density.mo206roundToPx0680j_4(this.minHeight), coerceAtLeast3), 0)) != Integer.MAX_VALUE) {
            i6 = coerceAtLeast;
        }
        return ConstraintsKt.Constraints(i5, coerceAtLeast2, i6, coerceAtLeast3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        long m339getTargetConstraintsOenEA2s = m339getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m2575getHasFixedHeightimpl(m339getTargetConstraintsOenEA2s) ? Constraints.m2577getMaxHeightimpl(m339getTargetConstraintsOenEA2s) : ConstraintsKt.m2592constrainHeightK40F9xA(m339getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicHeight(i5));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        long m339getTargetConstraintsOenEA2s = m339getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m2576getHasFixedWidthimpl(m339getTargetConstraintsOenEA2s) ? Constraints.m2578getMaxWidthimpl(m339getTargetConstraintsOenEA2s) : ConstraintsKt.m2593constrainWidthK40F9xA(m339getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicWidth(i5));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo46measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        long Constraints;
        long m339getTargetConstraintsOenEA2s = m339getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            Constraints = ConstraintsKt.m2591constrainN9IONVI(j5, m339getTargetConstraintsOenEA2s);
        } else {
            float f5 = this.minWidth;
            Dp.Companion companion = Dp.INSTANCE;
            Constraints = ConstraintsKt.Constraints(!Dp.m2601equalsimpl0(f5, companion.m2608getUnspecifiedD9Ej5fM()) ? Constraints.m2580getMinWidthimpl(m339getTargetConstraintsOenEA2s) : RangesKt.coerceAtMost(Constraints.m2580getMinWidthimpl(j5), Constraints.m2578getMaxWidthimpl(m339getTargetConstraintsOenEA2s)), !Dp.m2601equalsimpl0(this.maxWidth, companion.m2608getUnspecifiedD9Ej5fM()) ? Constraints.m2578getMaxWidthimpl(m339getTargetConstraintsOenEA2s) : RangesKt.coerceAtLeast(Constraints.m2578getMaxWidthimpl(j5), Constraints.m2580getMinWidthimpl(m339getTargetConstraintsOenEA2s)), !Dp.m2601equalsimpl0(this.minHeight, companion.m2608getUnspecifiedD9Ej5fM()) ? Constraints.m2579getMinHeightimpl(m339getTargetConstraintsOenEA2s) : RangesKt.coerceAtMost(Constraints.m2579getMinHeightimpl(j5), Constraints.m2577getMaxHeightimpl(m339getTargetConstraintsOenEA2s)), !Dp.m2601equalsimpl0(this.maxHeight, companion.m2608getUnspecifiedD9Ej5fM()) ? Constraints.m2577getMaxHeightimpl(m339getTargetConstraintsOenEA2s) : RangesKt.coerceAtLeast(Constraints.m2577getMaxHeightimpl(j5), Constraints.m2579getMinHeightimpl(m339getTargetConstraintsOenEA2s)));
        }
        final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(Constraints);
        return MeasureScope.layout$default(measureScope, mo1946measureBRTryo0.getWidth(), mo1946measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.SizeNode$measure$1
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
        long m339getTargetConstraintsOenEA2s = m339getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m2575getHasFixedHeightimpl(m339getTargetConstraintsOenEA2s) ? Constraints.m2577getMaxHeightimpl(m339getTargetConstraintsOenEA2s) : ConstraintsKt.m2592constrainHeightK40F9xA(m339getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicHeight(i5));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        long m339getTargetConstraintsOenEA2s = m339getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m2576getHasFixedWidthimpl(m339getTargetConstraintsOenEA2s) ? Constraints.m2578getMaxWidthimpl(m339getTargetConstraintsOenEA2s) : ConstraintsKt.m2593constrainWidthK40F9xA(m339getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicWidth(i5));
    }

    public final void setEnforceIncoming(boolean z5) {
        this.enforceIncoming = z5;
    }

    /* renamed from: setMaxHeight-0680j_4, reason: not valid java name */
    public final void m340setMaxHeight0680j_4(float f5) {
        this.maxHeight = f5;
    }

    /* renamed from: setMaxWidth-0680j_4, reason: not valid java name */
    public final void m341setMaxWidth0680j_4(float f5) {
        this.maxWidth = f5;
    }

    /* renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m342setMinHeight0680j_4(float f5) {
        this.minHeight = f5;
    }

    /* renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m343setMinWidth0680j_4(float f5) {
        this.minWidth = f5;
    }

    private SizeNode(float f5, float f6, float f7, float f8, boolean z5) {
        this.minWidth = f5;
        this.minHeight = f6;
        this.maxWidth = f7;
        this.maxHeight = f8;
        this.enforceIncoming = z5;
    }
}
