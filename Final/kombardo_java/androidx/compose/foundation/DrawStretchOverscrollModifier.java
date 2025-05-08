package androidx.compose.foundation;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.widget.EdgeEffect;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import f.AbstractC0339a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ#\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J#\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u0017J#\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\b\u001d\u0010\u0017J+\u0010!\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\b!\u0010\"J\u0013\u0010$\u001a\u00020\t*\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010&R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, d2 = {"Landroidx/compose/foundation/DrawStretchOverscrollModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "overscrollEffect", "Landroidx/compose/foundation/EdgeEffectWrapper;", "edgeEffectWrapper", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", BuildConfig.FLAVOR, "inspectorInfo", "<init>", "(Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;Landroidx/compose/foundation/EdgeEffectWrapper;Lkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "shouldDrawVerticalStretch", "()Z", "shouldDrawHorizontalStretch", "Landroid/widget/EdgeEffect;", "left", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "canvas", "drawLeftStretch", "(Landroid/widget/EdgeEffect;Landroid/graphics/Canvas;)Z", "top", "drawTopStretch", "right", "drawRightStretch", "bottom", "drawBottomStretch", BuildConfig.FLAVOR, "rotationDegrees", "edgeEffect", "drawWithRotation", "(FLandroid/widget/EdgeEffect;Landroid/graphics/Canvas;)Z", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "draw", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/EdgeEffectWrapper;", "Landroid/graphics/RenderNode;", "_renderNode", "Landroid/graphics/RenderNode;", "getRenderNode", "()Landroid/graphics/RenderNode;", "renderNode", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DrawStretchOverscrollModifier extends InspectorValueInfo implements DrawModifier {
    private RenderNode _renderNode;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final AndroidEdgeEffectOverscrollEffect overscrollEffect;

    public DrawStretchOverscrollModifier(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, EdgeEffectWrapper edgeEffectWrapper, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.overscrollEffect = androidEdgeEffectOverscrollEffect;
        this.edgeEffectWrapper = edgeEffectWrapper;
    }

    private final boolean drawBottomStretch(EdgeEffect bottom, Canvas canvas) {
        return drawWithRotation(180.0f, bottom, canvas);
    }

    private final boolean drawLeftStretch(EdgeEffect left, Canvas canvas) {
        return drawWithRotation(270.0f, left, canvas);
    }

    private final boolean drawRightStretch(EdgeEffect right, Canvas canvas) {
        return drawWithRotation(90.0f, right, canvas);
    }

    private final boolean drawTopStretch(EdgeEffect top, Canvas canvas) {
        return drawWithRotation(0.0f, top, canvas);
    }

    private final boolean drawWithRotation(float rotationDegrees, EdgeEffect edgeEffect, Canvas canvas) {
        if (rotationDegrees == 0.0f) {
            return edgeEffect.draw(canvas);
        }
        int save = canvas.save();
        canvas.rotate(rotationDegrees);
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final RenderNode getRenderNode() {
        RenderNode renderNode = this._renderNode;
        if (renderNode != null) {
            return renderNode;
        }
        RenderNode a5 = AbstractC0339a.a("AndroidEdgeEffectOverscrollEffect");
        this._renderNode = a5;
        return a5;
    }

    private final boolean shouldDrawHorizontalStretch() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        return edgeEffectWrapper.isLeftAnimating() || edgeEffectWrapper.isLeftNegationStretched() || edgeEffectWrapper.isRightAnimating() || edgeEffectWrapper.isRightNegationStretched();
    }

    private final boolean shouldDrawVerticalStretch() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        return edgeEffectWrapper.isTopAnimating() || edgeEffectWrapper.isTopNegationStretched() || edgeEffectWrapper.isBottomAnimating() || edgeEffectWrapper.isBottomNegationStretched();
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public void draw(ContentDrawScope contentDrawScope) {
        RecordingCanvas beginRecording;
        boolean z5;
        float f5;
        float f6;
        this.overscrollEffect.m102updateSizeuvyYCjk$foundation_release(contentDrawScope.mo1703getSizeNHjbRc());
        if (Size.m1379isEmptyimpl(contentDrawScope.mo1703getSizeNHjbRc())) {
            contentDrawScope.drawContent();
            return;
        }
        this.overscrollEffect.getRedrawSignal$foundation_release().getValue();
        float mo212toPx0680j_4 = contentDrawScope.mo212toPx0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(contentDrawScope.getDrawContext().getCanvas());
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        boolean shouldDrawVerticalStretch = shouldDrawVerticalStretch();
        boolean shouldDrawHorizontalStretch = shouldDrawHorizontalStretch();
        if (shouldDrawVerticalStretch && shouldDrawHorizontalStretch) {
            getRenderNode().setPosition(0, 0, nativeCanvas.getWidth(), nativeCanvas.getHeight());
        } else if (shouldDrawVerticalStretch) {
            getRenderNode().setPosition(0, 0, nativeCanvas.getWidth() + (MathKt.roundToInt(mo212toPx0680j_4) * 2), nativeCanvas.getHeight());
        } else {
            if (!shouldDrawHorizontalStretch) {
                contentDrawScope.drawContent();
                return;
            }
            getRenderNode().setPosition(0, 0, nativeCanvas.getWidth(), nativeCanvas.getHeight() + (MathKt.roundToInt(mo212toPx0680j_4) * 2));
        }
        beginRecording = getRenderNode().beginRecording();
        if (edgeEffectWrapper.isLeftNegationStretched()) {
            EdgeEffect orCreateLeftEffectNegation = edgeEffectWrapper.getOrCreateLeftEffectNegation();
            drawRightStretch(orCreateLeftEffectNegation, beginRecording);
            orCreateLeftEffectNegation.finish();
        }
        if (edgeEffectWrapper.isLeftAnimating()) {
            EdgeEffect orCreateLeftEffect = edgeEffectWrapper.getOrCreateLeftEffect();
            z5 = drawLeftStretch(orCreateLeftEffect, beginRecording);
            if (edgeEffectWrapper.isLeftStretched()) {
                float m1338getYimpl = Offset.m1338getYimpl(this.overscrollEffect.m101displacementF1C5BW0$foundation_release());
                EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
                edgeEffectCompat.onPullDistanceCompat(edgeEffectWrapper.getOrCreateLeftEffectNegation(), edgeEffectCompat.getDistanceCompat(orCreateLeftEffect), 1 - m1338getYimpl);
            }
        } else {
            z5 = false;
        }
        if (edgeEffectWrapper.isTopNegationStretched()) {
            EdgeEffect orCreateTopEffectNegation = edgeEffectWrapper.getOrCreateTopEffectNegation();
            drawBottomStretch(orCreateTopEffectNegation, beginRecording);
            orCreateTopEffectNegation.finish();
        }
        if (edgeEffectWrapper.isTopAnimating()) {
            EdgeEffect orCreateTopEffect = edgeEffectWrapper.getOrCreateTopEffect();
            z5 = drawTopStretch(orCreateTopEffect, beginRecording) || z5;
            if (edgeEffectWrapper.isTopStretched()) {
                float m1337getXimpl = Offset.m1337getXimpl(this.overscrollEffect.m101displacementF1C5BW0$foundation_release());
                EdgeEffectCompat edgeEffectCompat2 = EdgeEffectCompat.INSTANCE;
                edgeEffectCompat2.onPullDistanceCompat(edgeEffectWrapper.getOrCreateTopEffectNegation(), edgeEffectCompat2.getDistanceCompat(orCreateTopEffect), m1337getXimpl);
            }
        }
        if (edgeEffectWrapper.isRightNegationStretched()) {
            EdgeEffect orCreateRightEffectNegation = edgeEffectWrapper.getOrCreateRightEffectNegation();
            drawLeftStretch(orCreateRightEffectNegation, beginRecording);
            orCreateRightEffectNegation.finish();
        }
        if (edgeEffectWrapper.isRightAnimating()) {
            EdgeEffect orCreateRightEffect = edgeEffectWrapper.getOrCreateRightEffect();
            z5 = drawRightStretch(orCreateRightEffect, beginRecording) || z5;
            if (edgeEffectWrapper.isRightStretched()) {
                float m1338getYimpl2 = Offset.m1338getYimpl(this.overscrollEffect.m101displacementF1C5BW0$foundation_release());
                EdgeEffectCompat edgeEffectCompat3 = EdgeEffectCompat.INSTANCE;
                edgeEffectCompat3.onPullDistanceCompat(edgeEffectWrapper.getOrCreateRightEffectNegation(), edgeEffectCompat3.getDistanceCompat(orCreateRightEffect), m1338getYimpl2);
            }
        }
        if (edgeEffectWrapper.isBottomNegationStretched()) {
            EdgeEffect orCreateBottomEffectNegation = edgeEffectWrapper.getOrCreateBottomEffectNegation();
            drawTopStretch(orCreateBottomEffectNegation, beginRecording);
            orCreateBottomEffectNegation.finish();
        }
        if (edgeEffectWrapper.isBottomAnimating()) {
            EdgeEffect orCreateBottomEffect = edgeEffectWrapper.getOrCreateBottomEffect();
            boolean z6 = drawBottomStretch(orCreateBottomEffect, beginRecording) || z5;
            if (edgeEffectWrapper.isBottomStretched()) {
                float m1337getXimpl2 = Offset.m1337getXimpl(this.overscrollEffect.m101displacementF1C5BW0$foundation_release());
                EdgeEffectCompat edgeEffectCompat4 = EdgeEffectCompat.INSTANCE;
                edgeEffectCompat4.onPullDistanceCompat(edgeEffectWrapper.getOrCreateBottomEffectNegation(), edgeEffectCompat4.getDistanceCompat(orCreateBottomEffect), 1 - m1337getXimpl2);
            }
            z5 = z6;
        }
        if (z5) {
            this.overscrollEffect.invalidateOverscroll$foundation_release();
        }
        float f7 = shouldDrawHorizontalStretch ? 0.0f : mo212toPx0680j_4;
        if (shouldDrawVerticalStretch) {
            mo212toPx0680j_4 = 0.0f;
        }
        LayoutDirection layoutDirection = contentDrawScope.getLayoutDirection();
        androidx.compose.ui.graphics.Canvas Canvas = AndroidCanvas_androidKt.Canvas(beginRecording);
        long mo1703getSizeNHjbRc = contentDrawScope.mo1703getSizeNHjbRc();
        Density density = contentDrawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = contentDrawScope.getDrawContext().getLayoutDirection();
        androidx.compose.ui.graphics.Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
        long mo1682getSizeNHjbRc = contentDrawScope.getDrawContext().mo1682getSizeNHjbRc();
        GraphicsLayer graphicsLayer = contentDrawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = contentDrawScope.getDrawContext();
        drawContext.setDensity(contentDrawScope);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(Canvas);
        drawContext.mo1683setSizeuvyYCjk(mo1703getSizeNHjbRc);
        drawContext.setGraphicsLayer(null);
        Canvas.save();
        try {
            contentDrawScope.getDrawContext().getTransform().translate(f7, mo212toPx0680j_4);
            try {
                contentDrawScope.drawContent();
                Canvas.restore();
                DrawContext drawContext2 = contentDrawScope.getDrawContext();
                drawContext2.setDensity(density);
                drawContext2.setLayoutDirection(layoutDirection2);
                drawContext2.setCanvas(canvas);
                drawContext2.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
                drawContext2.setGraphicsLayer(graphicsLayer);
                getRenderNode().endRecording();
                int save = nativeCanvas.save();
                nativeCanvas.translate(f5, f6);
                nativeCanvas.drawRenderNode(getRenderNode());
                nativeCanvas.restoreToCount(save);
            } finally {
                contentDrawScope.getDrawContext().getTransform().translate(-f7, -mo212toPx0680j_4);
            }
        } catch (Throwable th) {
            Canvas.restore();
            DrawContext drawContext3 = contentDrawScope.getDrawContext();
            drawContext3.setDensity(density);
            drawContext3.setLayoutDirection(layoutDirection2);
            drawContext3.setCanvas(canvas);
            drawContext3.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
            drawContext3.setGraphicsLayer(graphicsLayer);
            throw th;
        }
    }
}
