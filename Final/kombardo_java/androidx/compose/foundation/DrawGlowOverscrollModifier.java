package androidx.compose.foundation;

import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0016\u001a\u00020\u0015*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0019\u001a\u00020\u0015*\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00102\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J'\u0010\u001b\u001a\u00020\u0015*\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00102\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013H\u0002¢\u0006\u0004\b\u001b\u0010\u0017J'\u0010\u001d\u001a\u00020\u0015*\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00102\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u0017J6\u0010%\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00102\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0013\u0010'\u001a\u00020\u000b*\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010)R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010*R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010+\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"Landroidx/compose/foundation/DrawGlowOverscrollModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "overscrollEffect", "Landroidx/compose/foundation/EdgeEffectWrapper;", "edgeEffectWrapper", "Landroidx/compose/foundation/OverscrollConfiguration;", "overscrollConfig", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", BuildConfig.FLAVOR, "inspectorInfo", "<init>", "(Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;Landroidx/compose/foundation/EdgeEffectWrapper;Landroidx/compose/foundation/OverscrollConfiguration;Lkotlin/jvm/functions/Function1;)V", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroid/widget/EdgeEffect;", "left", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "canvas", BuildConfig.FLAVOR, "drawLeftGlow", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroid/widget/EdgeEffect;Landroid/graphics/Canvas;)Z", "top", "drawTopGlow", "right", "drawRightGlow", "bottom", "drawBottomGlow", BuildConfig.FLAVOR, "rotationDegrees", "Landroidx/compose/ui/geometry/Offset;", "offset", "edgeEffect", "drawWithRotationAndOffset-ubNVwUQ", "(FJLandroid/widget/EdgeEffect;Landroid/graphics/Canvas;)Z", "drawWithRotationAndOffset", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "draw", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/EdgeEffectWrapper;", "Landroidx/compose/foundation/OverscrollConfiguration;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DrawGlowOverscrollModifier extends InspectorValueInfo implements DrawModifier {
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final OverscrollConfiguration overscrollConfig;
    private final AndroidEdgeEffectOverscrollEffect overscrollEffect;

    public DrawGlowOverscrollModifier(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, EdgeEffectWrapper edgeEffectWrapper, OverscrollConfiguration overscrollConfiguration, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.overscrollEffect = androidEdgeEffectOverscrollEffect;
        this.edgeEffectWrapper = edgeEffectWrapper;
        this.overscrollConfig = overscrollConfiguration;
    }

    private final boolean drawBottomGlow(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        return m137drawWithRotationAndOffsetubNVwUQ(180.0f, OffsetKt.Offset(-Size.m1377getWidthimpl(drawScope.mo1703getSizeNHjbRc()), (-Size.m1375getHeightimpl(drawScope.mo1703getSizeNHjbRc())) + drawScope.mo212toPx0680j_4(this.overscrollConfig.getDrawPadding().getBottom())), edgeEffect, canvas);
    }

    private final boolean drawLeftGlow(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        return m137drawWithRotationAndOffsetubNVwUQ(270.0f, OffsetKt.Offset(-Size.m1375getHeightimpl(drawScope.mo1703getSizeNHjbRc()), drawScope.mo212toPx0680j_4(this.overscrollConfig.getDrawPadding().mo290calculateLeftPaddingu2uoSUM(drawScope.getLayoutDirection()))), edgeEffect, canvas);
    }

    private final boolean drawRightGlow(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        return m137drawWithRotationAndOffsetubNVwUQ(90.0f, OffsetKt.Offset(0.0f, (-MathKt.roundToInt(Size.m1377getWidthimpl(drawScope.mo1703getSizeNHjbRc()))) + drawScope.mo212toPx0680j_4(this.overscrollConfig.getDrawPadding().mo291calculateRightPaddingu2uoSUM(drawScope.getLayoutDirection()))), edgeEffect, canvas);
    }

    private final boolean drawTopGlow(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        return m137drawWithRotationAndOffsetubNVwUQ(0.0f, OffsetKt.Offset(0.0f, drawScope.mo212toPx0680j_4(this.overscrollConfig.getDrawPadding().getTop())), edgeEffect, canvas);
    }

    /* renamed from: drawWithRotationAndOffset-ubNVwUQ, reason: not valid java name */
    private final boolean m137drawWithRotationAndOffsetubNVwUQ(float rotationDegrees, long offset, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(rotationDegrees);
        canvas.translate(Offset.m1337getXimpl(offset), Offset.m1338getYimpl(offset));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public void draw(ContentDrawScope contentDrawScope) {
        this.overscrollEffect.m102updateSizeuvyYCjk$foundation_release(contentDrawScope.mo1703getSizeNHjbRc());
        if (Size.m1379isEmptyimpl(contentDrawScope.mo1703getSizeNHjbRc())) {
            contentDrawScope.drawContent();
            return;
        }
        contentDrawScope.drawContent();
        this.overscrollEffect.getRedrawSignal$foundation_release().getValue();
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(contentDrawScope.getDrawContext().getCanvas());
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        boolean drawLeftGlow = edgeEffectWrapper.isLeftAnimating() ? drawLeftGlow(contentDrawScope, edgeEffectWrapper.getOrCreateLeftEffect(), nativeCanvas) : false;
        if (edgeEffectWrapper.isTopAnimating()) {
            drawLeftGlow = drawTopGlow(contentDrawScope, edgeEffectWrapper.getOrCreateTopEffect(), nativeCanvas) || drawLeftGlow;
        }
        if (edgeEffectWrapper.isRightAnimating()) {
            drawLeftGlow = drawRightGlow(contentDrawScope, edgeEffectWrapper.getOrCreateRightEffect(), nativeCanvas) || drawLeftGlow;
        }
        if (edgeEffectWrapper.isBottomAnimating()) {
            drawLeftGlow = drawBottomGlow(contentDrawScope, edgeEffectWrapper.getOrCreateBottomEffect(), nativeCanvas) || drawLeftGlow;
        }
        if (drawLeftGlow) {
            this.overscrollEffect.invalidateOverscroll$foundation_release();
        }
    }
}
