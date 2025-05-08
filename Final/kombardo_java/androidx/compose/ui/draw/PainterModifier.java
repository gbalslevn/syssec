package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b%\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BA\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0015J\u0016\u0010\u001d\u001a\u00020\u0006*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001f\u001a\u00020\u0006*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001cJ&\u0010&\u001a\u00020#*\u00020 2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016ø\u0001\u0000¢\u0006\u0004\b$\u0010%J#\u0010+\u001a\u00020)*\u00020'2\u0006\u0010\"\u001a\u00020(2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J#\u0010-\u001a\u00020)*\u00020'2\u0006\u0010\"\u001a\u00020(2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b-\u0010,J#\u0010/\u001a\u00020)*\u00020'2\u0006\u0010\"\u001a\u00020(2\u0006\u0010.\u001a\u00020)H\u0016¢\u0006\u0004\b/\u0010,J#\u00100\u001a\u00020)*\u00020'2\u0006\u0010\"\u001a\u00020(2\u0006\u0010.\u001a\u00020)H\u0016¢\u0006\u0004\b0\u0010,J\u0013\u00103\u001a\u000202*\u000201H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010?R\u0014\u0010Y\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010?\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Z"}, d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", BuildConfig.FLAVOR, "sizeToIntrinsics", "Landroidx/compose/ui/Alignment;", "alignment", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", BuildConfig.FLAVOR, "alpha", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "calculateScaledSize", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "modifyConstraints", "hasSpecifiedAndFiniteWidth-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteHeight-uvyYCjk", "hasSpecifiedAndFiniteHeight", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", BuildConfig.FLAVOR, "height", "minIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", BuildConfig.FLAVOR, "draw", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "Z", "getSizeToIntrinsics", "()Z", "setSizeToIntrinsics", "(Z)V", "Landroidx/compose/ui/Alignment;", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "Landroidx/compose/ui/layout/ContentScale;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "F", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getUseIntrinsicSize", "useIntrinsicSize", "getShouldAutoInvalidate", "shouldAutoInvalidate", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.ui.draw.PainterNode, reason: from toString */
/* loaded from: classes.dex */
final class PainterModifier extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    public PainterModifier(Painter painter, boolean z5, Alignment alignment, ContentScale contentScale, float f5, ColorFilter colorFilter) {
        this.painter = painter;
        this.sizeToIntrinsics = z5;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f5;
        this.colorFilter = colorFilter;
    }

    /* renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m1262calculateScaledSizeE7KxVPU(long dstSize) {
        if (!getUseIntrinsicSize()) {
            return dstSize;
        }
        long Size = SizeKt.Size(!m1264hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.mo1744getIntrinsicSizeNHjbRc()) ? Size.m1377getWidthimpl(dstSize) : Size.m1377getWidthimpl(this.painter.mo1744getIntrinsicSizeNHjbRc()), !m1263hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.mo1744getIntrinsicSizeNHjbRc()) ? Size.m1375getHeightimpl(dstSize) : Size.m1375getHeightimpl(this.painter.mo1744getIntrinsicSizeNHjbRc()));
        return (Size.m1377getWidthimpl(dstSize) == 0.0f || Size.m1375getHeightimpl(dstSize) == 0.0f) ? Size.INSTANCE.m1384getZeroNHjbRc() : ScaleFactorKt.m1983timesUQTWf7w(Size, this.contentScale.mo1937computeScaleFactorH7hwNQA(Size, dstSize));
    }

    private final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.mo1744getIntrinsicSizeNHjbRc() != 9205357640488583168L;
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m1263hasSpecifiedAndFiniteHeightuvyYCjk(long j5) {
        if (!Size.m1374equalsimpl0(j5, Size.INSTANCE.m1383getUnspecifiedNHjbRc())) {
            float m1375getHeightimpl = Size.m1375getHeightimpl(j5);
            if (!Float.isInfinite(m1375getHeightimpl) && !Float.isNaN(m1375getHeightimpl)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m1264hasSpecifiedAndFiniteWidthuvyYCjk(long j5) {
        if (!Size.m1374equalsimpl0(j5, Size.INSTANCE.m1383getUnspecifiedNHjbRc())) {
            float m1377getWidthimpl = Size.m1377getWidthimpl(j5);
            if (!Float.isInfinite(m1377getWidthimpl) && !Float.isNaN(m1377getWidthimpl)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m1265modifyConstraintsZezNO4M(long constraints) {
        boolean z5 = false;
        boolean z6 = Constraints.m2574getHasBoundedWidthimpl(constraints) && Constraints.m2573getHasBoundedHeightimpl(constraints);
        if (Constraints.m2576getHasFixedWidthimpl(constraints) && Constraints.m2575getHasFixedHeightimpl(constraints)) {
            z5 = true;
        }
        if ((!getUseIntrinsicSize() && z6) || z5) {
            return Constraints.m2570copyZbe2FdA$default(constraints, Constraints.m2578getMaxWidthimpl(constraints), 0, Constraints.m2577getMaxHeightimpl(constraints), 0, 10, null);
        }
        long mo1744getIntrinsicSizeNHjbRc = this.painter.mo1744getIntrinsicSizeNHjbRc();
        long m1262calculateScaledSizeE7KxVPU = m1262calculateScaledSizeE7KxVPU(SizeKt.Size(ConstraintsKt.m2593constrainWidthK40F9xA(constraints, m1264hasSpecifiedAndFiniteWidthuvyYCjk(mo1744getIntrinsicSizeNHjbRc) ? Math.round(Size.m1377getWidthimpl(mo1744getIntrinsicSizeNHjbRc)) : Constraints.m2580getMinWidthimpl(constraints)), ConstraintsKt.m2592constrainHeightK40F9xA(constraints, m1263hasSpecifiedAndFiniteHeightuvyYCjk(mo1744getIntrinsicSizeNHjbRc) ? Math.round(Size.m1375getHeightimpl(mo1744getIntrinsicSizeNHjbRc)) : Constraints.m2579getMinHeightimpl(constraints))));
        return Constraints.m2570copyZbe2FdA$default(constraints, ConstraintsKt.m2593constrainWidthK40F9xA(constraints, Math.round(Size.m1377getWidthimpl(m1262calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m2592constrainHeightK40F9xA(constraints, Math.round(Size.m1375getHeightimpl(m1262calculateScaledSizeE7KxVPU))), 0, 10, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        long mo1744getIntrinsicSizeNHjbRc = this.painter.mo1744getIntrinsicSizeNHjbRc();
        long Size = SizeKt.Size(m1264hasSpecifiedAndFiniteWidthuvyYCjk(mo1744getIntrinsicSizeNHjbRc) ? Size.m1377getWidthimpl(mo1744getIntrinsicSizeNHjbRc) : Size.m1377getWidthimpl(contentDrawScope.mo1703getSizeNHjbRc()), m1263hasSpecifiedAndFiniteHeightuvyYCjk(mo1744getIntrinsicSizeNHjbRc) ? Size.m1375getHeightimpl(mo1744getIntrinsicSizeNHjbRc) : Size.m1375getHeightimpl(contentDrawScope.mo1703getSizeNHjbRc()));
        long m1384getZeroNHjbRc = (Size.m1377getWidthimpl(contentDrawScope.mo1703getSizeNHjbRc()) == 0.0f || Size.m1375getHeightimpl(contentDrawScope.mo1703getSizeNHjbRc()) == 0.0f) ? Size.INSTANCE.m1384getZeroNHjbRc() : ScaleFactorKt.m1983timesUQTWf7w(Size, this.contentScale.mo1937computeScaleFactorH7hwNQA(Size, contentDrawScope.mo1703getSizeNHjbRc()));
        long mo1251alignKFBX0sM = this.alignment.mo1251alignKFBX0sM(IntSizeKt.IntSize(Math.round(Size.m1377getWidthimpl(m1384getZeroNHjbRc)), Math.round(Size.m1375getHeightimpl(m1384getZeroNHjbRc))), IntSizeKt.IntSize(Math.round(Size.m1377getWidthimpl(contentDrawScope.mo1703getSizeNHjbRc())), Math.round(Size.m1375getHeightimpl(contentDrawScope.mo1703getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float m2640getXimpl = IntOffset.m2640getXimpl(mo1251alignKFBX0sM);
        float m2641getYimpl = IntOffset.m2641getYimpl(mo1251alignKFBX0sM);
        contentDrawScope.getDrawContext().getTransform().translate(m2640getXimpl, m2641getYimpl);
        try {
            this.painter.m1749drawx_KDEd0(contentDrawScope, m1384getZeroNHjbRc, this.alpha, this.colorFilter);
            contentDrawScope.getDrawContext().getTransform().translate(-m2640getXimpl, -m2641getYimpl);
            contentDrawScope.drawContent();
        } catch (Throwable th) {
            contentDrawScope.getDrawContext().getTransform().translate(-m2640getXimpl, -m2641getYimpl);
            throw th;
        }
    }

    public final Painter getPainter() {
        return this.painter;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicHeight(i5);
        }
        long m1265modifyConstraintsZezNO4M = m1265modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i5, 0, 0, 13, null));
        return Math.max(Constraints.m2579getMinHeightimpl(m1265modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicHeight(i5));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicWidth(i5);
        }
        long m1265modifyConstraintsZezNO4M = m1265modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i5, 7, null));
        return Math.max(Constraints.m2580getMinWidthimpl(m1265modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicWidth(i5));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo46measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(m1265modifyConstraintsZezNO4M(j5));
        return MeasureScope.layout$default(measureScope, mo1946measureBRTryo0.getWidth(), mo1946measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
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
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicHeight(i5);
        }
        long m1265modifyConstraintsZezNO4M = m1265modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i5, 0, 0, 13, null));
        return Math.max(Constraints.m2579getMinHeightimpl(m1265modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicHeight(i5));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicWidth(i5);
        }
        long m1265modifyConstraintsZezNO4M = m1265modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i5, 7, null));
        return Math.max(Constraints.m2580getMinWidthimpl(m1265modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicWidth(i5));
    }

    public final void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public final void setAlpha(float f5) {
        this.alpha = f5;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public final void setContentScale(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    public final void setPainter(Painter painter) {
        this.painter = painter;
    }

    public final void setSizeToIntrinsics(boolean z5) {
        this.sizeToIntrinsics = z5;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
