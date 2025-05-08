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
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\r\u001a\u00020\n*\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\n*\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0013\u001a\u00020\n*\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0010J \u0010\u0015\u001a\u00020\n*\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0010J \u0010\u0017\u001a\u00020\n*\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0010J&\u0010\u001f\u001a\u00020\u001c*\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010$\u001a\u00020\"*\u00020 2\u0006\u0010\u001a\u001a\u00020!2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020\"*\u00020 2\u0006\u0010\u001a\u001a\u00020!2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b&\u0010%J#\u0010(\u001a\u00020\"*\u00020 2\u0006\u0010\u001a\u001a\u00020!2\u0006\u0010'\u001a\u00020\"H\u0016¢\u0006\u0004\b(\u0010%J#\u0010)\u001a\u00020\"*\u00020 2\u0006\u0010\u001a\u001a\u00020!2\u0006\u0010'\u001a\u00020\"H\u0016¢\u0006\u0004\b)\u0010%R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", BuildConfig.FLAVOR, "aspectRatio", BuildConfig.FLAVOR, "matchHeightConstraintsFirst", "<init>", "(FZ)V", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/IntSize;", "findSize-ToXhtMw", "(J)J", "findSize", "enforceConstraints", "tryMaxWidth-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxHeight-JN-0ABg", "tryMaxHeight", "tryMinWidth-JN-0ABg", "tryMinWidth", "tryMinHeight-JN-0ABg", "tryMinHeight", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", BuildConfig.FLAVOR, "height", "minIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "F", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "Z", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public AspectRatioNode(float f5, boolean z5) {
        this.aspectRatio = f5;
        this.matchHeightConstraintsFirst = z5;
    }

    /* renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m268findSizeToXhtMw(long j5) {
        if (this.matchHeightConstraintsFirst) {
            long m270tryMaxHeightJN0ABg$default = m270tryMaxHeightJN0ABg$default(this, j5, false, 1, null);
            IntSize.Companion companion = IntSize.INSTANCE;
            if (!IntSize.m2659equalsimpl0(m270tryMaxHeightJN0ABg$default, companion.m2665getZeroYbymL2g())) {
                return m270tryMaxHeightJN0ABg$default;
            }
            long m272tryMaxWidthJN0ABg$default = m272tryMaxWidthJN0ABg$default(this, j5, false, 1, null);
            if (!IntSize.m2659equalsimpl0(m272tryMaxWidthJN0ABg$default, companion.m2665getZeroYbymL2g())) {
                return m272tryMaxWidthJN0ABg$default;
            }
            long m274tryMinHeightJN0ABg$default = m274tryMinHeightJN0ABg$default(this, j5, false, 1, null);
            if (!IntSize.m2659equalsimpl0(m274tryMinHeightJN0ABg$default, companion.m2665getZeroYbymL2g())) {
                return m274tryMinHeightJN0ABg$default;
            }
            long m276tryMinWidthJN0ABg$default = m276tryMinWidthJN0ABg$default(this, j5, false, 1, null);
            if (!IntSize.m2659equalsimpl0(m276tryMinWidthJN0ABg$default, companion.m2665getZeroYbymL2g())) {
                return m276tryMinWidthJN0ABg$default;
            }
            long m269tryMaxHeightJN0ABg = m269tryMaxHeightJN0ABg(j5, false);
            if (!IntSize.m2659equalsimpl0(m269tryMaxHeightJN0ABg, companion.m2665getZeroYbymL2g())) {
                return m269tryMaxHeightJN0ABg;
            }
            long m271tryMaxWidthJN0ABg = m271tryMaxWidthJN0ABg(j5, false);
            if (!IntSize.m2659equalsimpl0(m271tryMaxWidthJN0ABg, companion.m2665getZeroYbymL2g())) {
                return m271tryMaxWidthJN0ABg;
            }
            long m273tryMinHeightJN0ABg = m273tryMinHeightJN0ABg(j5, false);
            if (!IntSize.m2659equalsimpl0(m273tryMinHeightJN0ABg, companion.m2665getZeroYbymL2g())) {
                return m273tryMinHeightJN0ABg;
            }
            long m275tryMinWidthJN0ABg = m275tryMinWidthJN0ABg(j5, false);
            if (!IntSize.m2659equalsimpl0(m275tryMinWidthJN0ABg, companion.m2665getZeroYbymL2g())) {
                return m275tryMinWidthJN0ABg;
            }
        } else {
            long m272tryMaxWidthJN0ABg$default2 = m272tryMaxWidthJN0ABg$default(this, j5, false, 1, null);
            IntSize.Companion companion2 = IntSize.INSTANCE;
            if (!IntSize.m2659equalsimpl0(m272tryMaxWidthJN0ABg$default2, companion2.m2665getZeroYbymL2g())) {
                return m272tryMaxWidthJN0ABg$default2;
            }
            long m270tryMaxHeightJN0ABg$default2 = m270tryMaxHeightJN0ABg$default(this, j5, false, 1, null);
            if (!IntSize.m2659equalsimpl0(m270tryMaxHeightJN0ABg$default2, companion2.m2665getZeroYbymL2g())) {
                return m270tryMaxHeightJN0ABg$default2;
            }
            long m276tryMinWidthJN0ABg$default2 = m276tryMinWidthJN0ABg$default(this, j5, false, 1, null);
            if (!IntSize.m2659equalsimpl0(m276tryMinWidthJN0ABg$default2, companion2.m2665getZeroYbymL2g())) {
                return m276tryMinWidthJN0ABg$default2;
            }
            long m274tryMinHeightJN0ABg$default2 = m274tryMinHeightJN0ABg$default(this, j5, false, 1, null);
            if (!IntSize.m2659equalsimpl0(m274tryMinHeightJN0ABg$default2, companion2.m2665getZeroYbymL2g())) {
                return m274tryMinHeightJN0ABg$default2;
            }
            long m271tryMaxWidthJN0ABg2 = m271tryMaxWidthJN0ABg(j5, false);
            if (!IntSize.m2659equalsimpl0(m271tryMaxWidthJN0ABg2, companion2.m2665getZeroYbymL2g())) {
                return m271tryMaxWidthJN0ABg2;
            }
            long m269tryMaxHeightJN0ABg2 = m269tryMaxHeightJN0ABg(j5, false);
            if (!IntSize.m2659equalsimpl0(m269tryMaxHeightJN0ABg2, companion2.m2665getZeroYbymL2g())) {
                return m269tryMaxHeightJN0ABg2;
            }
            long m275tryMinWidthJN0ABg2 = m275tryMinWidthJN0ABg(j5, false);
            if (!IntSize.m2659equalsimpl0(m275tryMinWidthJN0ABg2, companion2.m2665getZeroYbymL2g())) {
                return m275tryMinWidthJN0ABg2;
            }
            long m273tryMinHeightJN0ABg2 = m273tryMinHeightJN0ABg(j5, false);
            if (!IntSize.m2659equalsimpl0(m273tryMinHeightJN0ABg2, companion2.m2665getZeroYbymL2g())) {
                return m273tryMinHeightJN0ABg2;
            }
        }
        return IntSize.INSTANCE.m2665getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m269tryMaxHeightJN0ABg(long j5, boolean z5) {
        int round;
        int m2577getMaxHeightimpl = Constraints.m2577getMaxHeightimpl(j5);
        if (m2577getMaxHeightimpl != Integer.MAX_VALUE && (round = Math.round(m2577getMaxHeightimpl * this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(round, m2577getMaxHeightimpl);
            if (!z5 || ConstraintsKt.m2594isSatisfiedBy4WqzIAM(j5, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.INSTANCE.m2665getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m270tryMaxHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j5, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = true;
        }
        return aspectRatioNode.m269tryMaxHeightJN0ABg(j5, z5);
    }

    /* renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m271tryMaxWidthJN0ABg(long j5, boolean z5) {
        int round;
        int m2578getMaxWidthimpl = Constraints.m2578getMaxWidthimpl(j5);
        if (m2578getMaxWidthimpl != Integer.MAX_VALUE && (round = Math.round(m2578getMaxWidthimpl / this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(m2578getMaxWidthimpl, round);
            if (!z5 || ConstraintsKt.m2594isSatisfiedBy4WqzIAM(j5, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.INSTANCE.m2665getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m272tryMaxWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j5, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = true;
        }
        return aspectRatioNode.m271tryMaxWidthJN0ABg(j5, z5);
    }

    /* renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m273tryMinHeightJN0ABg(long j5, boolean z5) {
        int m2579getMinHeightimpl = Constraints.m2579getMinHeightimpl(j5);
        int round = Math.round(m2579getMinHeightimpl * this.aspectRatio);
        if (round > 0) {
            long IntSize = IntSizeKt.IntSize(round, m2579getMinHeightimpl);
            if (!z5 || ConstraintsKt.m2594isSatisfiedBy4WqzIAM(j5, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.INSTANCE.m2665getZeroYbymL2g();
    }

    /* renamed from: tryMinHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m274tryMinHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j5, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = true;
        }
        return aspectRatioNode.m273tryMinHeightJN0ABg(j5, z5);
    }

    /* renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m275tryMinWidthJN0ABg(long j5, boolean z5) {
        int m2580getMinWidthimpl = Constraints.m2580getMinWidthimpl(j5);
        int round = Math.round(m2580getMinWidthimpl / this.aspectRatio);
        if (round > 0) {
            long IntSize = IntSizeKt.IntSize(m2580getMinWidthimpl, round);
            if (!z5 || ConstraintsKt.m2594isSatisfiedBy4WqzIAM(j5, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.INSTANCE.m2665getZeroYbymL2g();
    }

    /* renamed from: tryMinWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m276tryMinWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j5, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = true;
        }
        return aspectRatioNode.m275tryMinWidthJN0ABg(j5, z5);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        return i5 != Integer.MAX_VALUE ? Math.round(i5 / this.aspectRatio) : intrinsicMeasurable.maxIntrinsicHeight(i5);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        return i5 != Integer.MAX_VALUE ? Math.round(i5 * this.aspectRatio) : intrinsicMeasurable.maxIntrinsicWidth(i5);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo46measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        long m268findSizeToXhtMw = m268findSizeToXhtMw(j5);
        if (!IntSize.m2659equalsimpl0(m268findSizeToXhtMw, IntSize.INSTANCE.m2665getZeroYbymL2g())) {
            j5 = Constraints.INSTANCE.m2587fixedJhjzzOo(IntSize.m2661getWidthimpl(m268findSizeToXhtMw), IntSize.m2660getHeightimpl(m268findSizeToXhtMw));
        }
        final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(j5);
        return MeasureScope.layout$default(measureScope, mo1946measureBRTryo0.getWidth(), mo1946measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AspectRatioNode$measure$1
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
        return i5 != Integer.MAX_VALUE ? Math.round(i5 / this.aspectRatio) : intrinsicMeasurable.minIntrinsicHeight(i5);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        return i5 != Integer.MAX_VALUE ? Math.round(i5 * this.aspectRatio) : intrinsicMeasurable.minIntrinsicWidth(i5);
    }

    public final void setAspectRatio(float f5) {
        this.aspectRatio = f5;
    }

    public final void setMatchHeightConstraintsFirst(boolean z5) {
        this.matchHeightConstraintsFirst = z5;
    }
}
