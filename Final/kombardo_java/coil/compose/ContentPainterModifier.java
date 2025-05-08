package coil.compose;

import android.support.v4.media.session.a;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0013J)\u0010\u001f\u001a\u00020\u001c*\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010$\u001a\u00020\"*\u00020 2\u0006\u0010\u001b\u001a\u00020!2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J#\u0010&\u001a\u00020\"*\u00020 2\u0006\u0010\u001b\u001a\u00020!2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b&\u0010%J#\u0010(\u001a\u00020\"*\u00020 2\u0006\u0010\u001b\u001a\u00020!2\u0006\u0010'\u001a\u00020\"H\u0016¢\u0006\u0004\b(\u0010%J#\u0010)\u001a\u00020\"*\u00020 2\u0006\u0010\u001b\u001a\u00020!2\u0006\u0010'\u001a\u00020\"H\u0016¢\u0006\u0004\b)\u0010%J\u0013\u0010,\u001a\u00020+*\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0010\u0010/\u001a\u00020.HÖ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b1\u00102J\u001a\u00106\u001a\u0002052\b\u00104\u001a\u0004\u0018\u000103HÖ\u0003¢\u0006\u0004\b6\u00107R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00108R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00109R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010:R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010;R\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010<\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006="}, d2 = {"Lcoil/compose/ContentPainterModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "Landroidx/compose/ui/graphics/painter/Painter;", "painter", "Landroidx/compose/ui/Alignment;", "alignment", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", BuildConfig.FLAVOR, "alpha", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "calculateScaledSize", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "modifyConstraints", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", BuildConfig.FLAVOR, "height", "minIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", BuildConfig.FLAVOR, "draw", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/ui/Alignment;", "Landroidx/compose/ui/layout/ContentScale;", "F", "Landroidx/compose/ui/graphics/ColorFilter;", "coil-compose-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ContentPainterModifier extends InspectorValueInfo implements LayoutModifier, DrawModifier {
    private final Alignment alignment;
    private final float alpha;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final Painter painter;

    public ContentPainterModifier(final Painter painter, final Alignment alignment, final ContentScale contentScale, final float f5, final ColorFilter colorFilter) {
        super(InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: coil.compose.ContentPainterModifier$special$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                a.a(inspectorInfo);
                invoke2((InspectorInfo) null);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                throw null;
            }
        } : InspectableValueKt.getNoInspectorInfo());
        this.painter = painter;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f5;
        this.colorFilter = colorFilter;
    }

    /* renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m2737calculateScaledSizeE7KxVPU(long dstSize) {
        if (Size.m1379isEmptyimpl(dstSize)) {
            return Size.INSTANCE.m1384getZeroNHjbRc();
        }
        long mo1744getIntrinsicSizeNHjbRc = this.painter.mo1744getIntrinsicSizeNHjbRc();
        if (mo1744getIntrinsicSizeNHjbRc == Size.INSTANCE.m1383getUnspecifiedNHjbRc()) {
            return dstSize;
        }
        float m1377getWidthimpl = Size.m1377getWidthimpl(mo1744getIntrinsicSizeNHjbRc);
        if (Float.isInfinite(m1377getWidthimpl) || Float.isNaN(m1377getWidthimpl)) {
            m1377getWidthimpl = Size.m1377getWidthimpl(dstSize);
        }
        float m1375getHeightimpl = Size.m1375getHeightimpl(mo1744getIntrinsicSizeNHjbRc);
        if (Float.isInfinite(m1375getHeightimpl) || Float.isNaN(m1375getHeightimpl)) {
            m1375getHeightimpl = Size.m1375getHeightimpl(dstSize);
        }
        long Size = SizeKt.Size(m1377getWidthimpl, m1375getHeightimpl);
        return ScaleFactorKt.m1983timesUQTWf7w(Size, this.contentScale.mo1937computeScaleFactorH7hwNQA(Size, dstSize));
    }

    /* renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m2738modifyConstraintsZezNO4M(long constraints) {
        float m2580getMinWidthimpl;
        int m2579getMinHeightimpl;
        float m2746constrainHeightK40F9xA;
        boolean m2576getHasFixedWidthimpl = Constraints.m2576getHasFixedWidthimpl(constraints);
        boolean m2575getHasFixedHeightimpl = Constraints.m2575getHasFixedHeightimpl(constraints);
        if (m2576getHasFixedWidthimpl && m2575getHasFixedHeightimpl) {
            return constraints;
        }
        boolean z5 = Constraints.m2574getHasBoundedWidthimpl(constraints) && Constraints.m2573getHasBoundedHeightimpl(constraints);
        long mo1744getIntrinsicSizeNHjbRc = this.painter.mo1744getIntrinsicSizeNHjbRc();
        if (mo1744getIntrinsicSizeNHjbRc == Size.INSTANCE.m1383getUnspecifiedNHjbRc()) {
            return z5 ? Constraints.m2570copyZbe2FdA$default(constraints, Constraints.m2578getMaxWidthimpl(constraints), 0, Constraints.m2577getMaxHeightimpl(constraints), 0, 10, null) : constraints;
        }
        if (z5 && (m2576getHasFixedWidthimpl || m2575getHasFixedHeightimpl)) {
            m2580getMinWidthimpl = Constraints.m2578getMaxWidthimpl(constraints);
            m2579getMinHeightimpl = Constraints.m2577getMaxHeightimpl(constraints);
        } else {
            float m1377getWidthimpl = Size.m1377getWidthimpl(mo1744getIntrinsicSizeNHjbRc);
            float m1375getHeightimpl = Size.m1375getHeightimpl(mo1744getIntrinsicSizeNHjbRc);
            m2580getMinWidthimpl = (Float.isInfinite(m1377getWidthimpl) || Float.isNaN(m1377getWidthimpl)) ? Constraints.m2580getMinWidthimpl(constraints) : UtilsKt.m2747constrainWidthK40F9xA(constraints, m1377getWidthimpl);
            if (!Float.isInfinite(m1375getHeightimpl) && !Float.isNaN(m1375getHeightimpl)) {
                m2746constrainHeightK40F9xA = UtilsKt.m2746constrainHeightK40F9xA(constraints, m1375getHeightimpl);
                long m2737calculateScaledSizeE7KxVPU = m2737calculateScaledSizeE7KxVPU(SizeKt.Size(m2580getMinWidthimpl, m2746constrainHeightK40F9xA));
                return Constraints.m2570copyZbe2FdA$default(constraints, ConstraintsKt.m2593constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m1377getWidthimpl(m2737calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m2592constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m1375getHeightimpl(m2737calculateScaledSizeE7KxVPU))), 0, 10, null);
            }
            m2579getMinHeightimpl = Constraints.m2579getMinHeightimpl(constraints);
        }
        m2746constrainHeightK40F9xA = m2579getMinHeightimpl;
        long m2737calculateScaledSizeE7KxVPU2 = m2737calculateScaledSizeE7KxVPU(SizeKt.Size(m2580getMinWidthimpl, m2746constrainHeightK40F9xA));
        return Constraints.m2570copyZbe2FdA$default(constraints, ConstraintsKt.m2593constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m1377getWidthimpl(m2737calculateScaledSizeE7KxVPU2))), 0, ConstraintsKt.m2592constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m1375getHeightimpl(m2737calculateScaledSizeE7KxVPU2))), 0, 10, null);
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public void draw(ContentDrawScope contentDrawScope) {
        long m2737calculateScaledSizeE7KxVPU = m2737calculateScaledSizeE7KxVPU(contentDrawScope.mo1703getSizeNHjbRc());
        long mo1251alignKFBX0sM = this.alignment.mo1251alignKFBX0sM(UtilsKt.m2748toIntSizeuvyYCjk(m2737calculateScaledSizeE7KxVPU), UtilsKt.m2748toIntSizeuvyYCjk(contentDrawScope.mo1703getSizeNHjbRc()), contentDrawScope.getLayoutDirection());
        float m2633component1impl = IntOffset.m2633component1impl(mo1251alignKFBX0sM);
        float m2634component2impl = IntOffset.m2634component2impl(mo1251alignKFBX0sM);
        contentDrawScope.getDrawContext().getTransform().translate(m2633component1impl, m2634component2impl);
        this.painter.m1749drawx_KDEd0(contentDrawScope, m2737calculateScaledSizeE7KxVPU, this.alpha, this.colorFilter);
        contentDrawScope.getDrawContext().getTransform().translate(-m2633component1impl, -m2634component2impl);
        contentDrawScope.drawContent();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentPainterModifier)) {
            return false;
        }
        ContentPainterModifier contentPainterModifier = (ContentPainterModifier) other;
        return Intrinsics.areEqual(this.painter, contentPainterModifier.painter) && Intrinsics.areEqual(this.alignment, contentPainterModifier.alignment) && Intrinsics.areEqual(this.contentScale, contentPainterModifier.contentScale) && Float.compare(this.alpha, contentPainterModifier.alpha) == 0 && Intrinsics.areEqual(this.colorFilter, contentPainterModifier.colorFilter);
    }

    public int hashCode() {
        int hashCode = ((((((this.painter.hashCode() * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.hashCode(this.alpha)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        return hashCode + (colorFilter == null ? 0 : colorFilter.hashCode());
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        if (this.painter.mo1744getIntrinsicSizeNHjbRc() == Size.INSTANCE.m1383getUnspecifiedNHjbRc()) {
            return intrinsicMeasurable.maxIntrinsicHeight(i5);
        }
        int maxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(Constraints.m2578getMaxWidthimpl(m2738modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i5, 0, 0, 13, null))));
        return Math.max(MathKt.roundToInt(Size.m1375getHeightimpl(m2737calculateScaledSizeE7KxVPU(SizeKt.Size(i5, maxIntrinsicHeight)))), maxIntrinsicHeight);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        if (this.painter.mo1744getIntrinsicSizeNHjbRc() == Size.INSTANCE.m1383getUnspecifiedNHjbRc()) {
            return intrinsicMeasurable.maxIntrinsicWidth(i5);
        }
        int maxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(Constraints.m2577getMaxHeightimpl(m2738modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i5, 7, null))));
        return Math.max(MathKt.roundToInt(Size.m1377getWidthimpl(m2737calculateScaledSizeE7KxVPU(SizeKt.Size(maxIntrinsicWidth, i5)))), maxIntrinsicWidth);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo21measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(m2738modifyConstraintsZezNO4M(j5));
        return MeasureScope.layout$default(measureScope, mo1946measureBRTryo0.getWidth(), mo1946measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: coil.compose.ContentPainterModifier$measure$1
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

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        if (this.painter.mo1744getIntrinsicSizeNHjbRc() == Size.INSTANCE.m1383getUnspecifiedNHjbRc()) {
            return intrinsicMeasurable.minIntrinsicHeight(i5);
        }
        int minIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(Constraints.m2578getMaxWidthimpl(m2738modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i5, 0, 0, 13, null))));
        return Math.max(MathKt.roundToInt(Size.m1375getHeightimpl(m2737calculateScaledSizeE7KxVPU(SizeKt.Size(i5, minIntrinsicHeight)))), minIntrinsicHeight);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        if (this.painter.mo1744getIntrinsicSizeNHjbRc() == Size.INSTANCE.m1383getUnspecifiedNHjbRc()) {
            return intrinsicMeasurable.minIntrinsicWidth(i5);
        }
        int minIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(Constraints.m2577getMaxHeightimpl(m2738modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i5, 7, null))));
        return Math.max(MathKt.roundToInt(Size.m1377getWidthimpl(m2737calculateScaledSizeE7KxVPU(SizeKt.Size(minIntrinsicWidth, i5)))), minIntrinsicWidth);
    }

    public String toString() {
        return "ContentPainterModifier(painter=" + this.painter + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
