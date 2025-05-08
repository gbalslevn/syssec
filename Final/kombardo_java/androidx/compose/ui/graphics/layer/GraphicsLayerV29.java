package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.CompositingStrategy;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import f.AbstractC0339a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0012\u001a\u00020\n*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J*\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ$\u0010%\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b#\u0010$J;\u0010/\u001a\u00020\n2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\n0,H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\n2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\nH\u0016¢\u0006\u0004\b8\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u00109\u001a\u0004\b:\u0010;R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010<R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010=R\u0014\u0010>\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001c\u0010\u001c\u001a\u00020@8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001c\u00109R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010D\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR*\u0010J\u001a\u00020H2\u0006\u0010I\u001a\u00020H8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR0\u0010Q\u001a\u00020P2\u0006\u0010I\u001a\u00020P8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR.\u0010X\u001a\u0004\u0018\u00010W2\b\u0010I\u001a\u0004\u0018\u00010W8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R0\u0010_\u001a\u00020^2\u0006\u0010I\u001a\u00020^8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b_\u00109\u001a\u0004\b`\u0010;\"\u0004\ba\u0010bR*\u0010c\u001a\u00020H2\u0006\u0010I\u001a\u00020H8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bc\u0010K\u001a\u0004\bd\u0010M\"\u0004\be\u0010OR*\u0010f\u001a\u00020H2\u0006\u0010I\u001a\u00020H8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bf\u0010K\u001a\u0004\bg\u0010M\"\u0004\bh\u0010OR*\u0010i\u001a\u00020H2\u0006\u0010I\u001a\u00020H8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bi\u0010K\u001a\u0004\bj\u0010M\"\u0004\bk\u0010OR*\u0010l\u001a\u00020H2\u0006\u0010I\u001a\u00020H8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bl\u0010K\u001a\u0004\bm\u0010M\"\u0004\bn\u0010OR*\u0010o\u001a\u00020H2\u0006\u0010I\u001a\u00020H8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bo\u0010K\u001a\u0004\bp\u0010M\"\u0004\bq\u0010OR0\u0010s\u001a\u00020r2\u0006\u0010I\u001a\u00020r8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bs\u00109\u001a\u0004\bt\u0010;\"\u0004\bu\u0010bR0\u0010v\u001a\u00020r2\u0006\u0010I\u001a\u00020r8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bv\u00109\u001a\u0004\bw\u0010;\"\u0004\bx\u0010bR*\u0010y\u001a\u00020H2\u0006\u0010I\u001a\u00020H8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\by\u0010K\u001a\u0004\bz\u0010M\"\u0004\b{\u0010OR*\u0010|\u001a\u00020H2\u0006\u0010I\u001a\u00020H8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b|\u0010K\u001a\u0004\b}\u0010M\"\u0004\b~\u0010OR,\u0010\u007f\u001a\u00020H2\u0006\u0010I\u001a\u00020H8\u0016@VX\u0096\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010K\u001a\u0005\b\u0080\u0001\u0010M\"\u0005\b\u0081\u0001\u0010OR.\u0010\u0082\u0001\u001a\u00020H2\u0006\u0010I\u001a\u00020H8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010K\u001a\u0005\b\u0083\u0001\u0010M\"\u0005\b\u0084\u0001\u0010OR/\u0010\u0085\u0001\u001a\u00020\u00142\u0006\u0010I\u001a\u00020\u00148\u0016@VX\u0096\u000e¢\u0006\u0016\n\u0005\b\u0085\u0001\u0010G\u001a\u0005\b\u0086\u0001\u0010\u0016\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u0089\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010GR\u0018\u0010\u008a\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010GR7\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00012\t\u0010I\u001a\u0005\u0018\u00010\u008b\u00018\u0016@VX\u0096\u000e¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R2\u0010\u000f\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\u000e8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0014\n\u0004\b\u000f\u0010R\u001a\u0005\b\u0092\u0001\u0010T\"\u0005\b\u0093\u0001\u0010VR'\u0010\u0094\u0001\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0016\n\u0005\b\u0094\u0001\u0010G\u001a\u0005\b\u0094\u0001\u0010\u0016\"\u0006\b\u0095\u0001\u0010\u0088\u0001R\u0016\u0010\u0097\u0001\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0096\u0001\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0098\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerV29;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", BuildConfig.FLAVOR, "ownerId", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "canvasDrawScope", "<init>", "(JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", BuildConfig.FLAVOR, "applyClip", "()V", "Landroid/graphics/RenderNode;", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "applyCompositingStrategy-Z1X6vPc", "(Landroid/graphics/RenderNode;I)V", "applyCompositingStrategy", "updateLayerProperties", BuildConfig.FLAVOR, "requiresCompositingLayer", "()Z", "requiresLayerPaint", BuildConfig.FLAVOR, "x", "y", "Landroidx/compose/ui/unit/IntSize;", "size", "setPosition-H0pRuoY", "(IIJ)V", "setPosition", "Landroid/graphics/Outline;", "outline", "outlineSize", "setOutline-O0kMr_c", "(Landroid/graphics/Outline;J)V", "setOutline", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "record", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/jvm/functions/Function1;)V", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "draw", "(Landroidx/compose/ui/graphics/Canvas;)V", "Landroid/graphics/Matrix;", "calculateMatrix", "()Landroid/graphics/Matrix;", "discardDisplayList", "J", "getOwnerId", "()J", "Landroidx/compose/ui/graphics/CanvasHolder;", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "renderNode", "Landroid/graphics/RenderNode;", "Landroidx/compose/ui/geometry/Size;", "Landroid/graphics/Paint;", "layerPaint", "Landroid/graphics/Paint;", "matrix", "Landroid/graphics/Matrix;", "outlineIsProvided", "Z", BuildConfig.FLAVOR, "value", "alpha", "F", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "I", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "(J)V", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "getClip", "setClip", "(Z)V", "clipToBounds", "clipToOutline", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "isInvalidated", "setInvalidated", "getHasDisplayList", "hasDisplayList", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphicsLayerV29 implements GraphicsLayerImpl {
    private float alpha;
    private long ambientShadowColor;
    private int blendMode;
    private float cameraDistance;
    private final CanvasDrawScope canvasDrawScope;
    private final CanvasHolder canvasHolder;
    private boolean clip;
    private boolean clipToBounds;
    private boolean clipToOutline;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private boolean isInvalidated;
    private Paint layerPaint;
    private Matrix matrix;
    private boolean outlineIsProvided;
    private final long ownerId;
    private long pivotOffset;
    private RenderEffect renderEffect;
    private final RenderNode renderNode;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;
    private long size;
    private long spotShadowColor;
    private float translationX;
    private float translationY;

    public GraphicsLayerV29(long j5, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        this.ownerId = j5;
        this.canvasHolder = canvasHolder;
        this.canvasDrawScope = canvasDrawScope;
        RenderNode a5 = AbstractC0339a.a("graphicsLayer");
        this.renderNode = a5;
        this.size = Size.INSTANCE.m1384getZeroNHjbRc();
        a5.setClipToBounds(false);
        CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
        m1741applyCompositingStrategyZ1X6vPc(a5, companion.m1712getAutoke2Ky5w());
        this.alpha = 1.0f;
        this.blendMode = BlendMode.INSTANCE.m1459getSrcOver0nO6VwU();
        this.pivotOffset = Offset.INSTANCE.m1348getUnspecifiedF1C5BW0();
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        Color.Companion companion2 = Color.INSTANCE;
        this.ambientShadowColor = companion2.m1496getBlack0d7_KjU();
        this.spotShadowColor = companion2.m1496getBlack0d7_KjU();
        this.cameraDistance = 8.0f;
        this.compositingStrategy = companion.m1712getAutoke2Ky5w();
        this.isInvalidated = true;
    }

    private final void applyClip() {
        boolean z5 = false;
        boolean z6 = getClip() && !this.outlineIsProvided;
        if (getClip() && this.outlineIsProvided) {
            z5 = true;
        }
        if (z6 != this.clipToBounds) {
            this.clipToBounds = z6;
            this.renderNode.setClipToBounds(z6);
        }
        if (z5 != this.clipToOutline) {
            this.clipToOutline = z5;
            this.renderNode.setClipToOutline(z5);
        }
    }

    /* renamed from: applyCompositingStrategy-Z1X6vPc, reason: not valid java name */
    private final void m1741applyCompositingStrategyZ1X6vPc(RenderNode renderNode, int i5) {
        CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
        if (CompositingStrategy.m1711equalsimpl0(i5, companion.m1714getOffscreenke2Ky5w())) {
            renderNode.setUseCompositingLayer(true, this.layerPaint);
            renderNode.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.m1711equalsimpl0(i5, companion.m1713getModulateAlphake2Ky5w())) {
            renderNode.setUseCompositingLayer(false, this.layerPaint);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, this.layerPaint);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    private final boolean requiresCompositingLayer() {
        if (CompositingStrategy.m1711equalsimpl0(getCompositingStrategy(), CompositingStrategy.INSTANCE.m1714getOffscreenke2Ky5w()) || requiresLayerPaint()) {
            return true;
        }
        getRenderEffect();
        return false;
    }

    private final boolean requiresLayerPaint() {
        return (BlendMode.m1429equalsimpl0(getBlendMode(), BlendMode.INSTANCE.m1459getSrcOver0nO6VwU()) && getColorFilter() == null) ? false : true;
    }

    private final void updateLayerProperties() {
        if (requiresCompositingLayer()) {
            m1741applyCompositingStrategyZ1X6vPc(this.renderNode, CompositingStrategy.INSTANCE.m1714getOffscreenke2Ky5w());
        } else {
            m1741applyCompositingStrategyZ1X6vPc(this.renderNode, getCompositingStrategy());
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix calculateMatrix() {
        Matrix matrix = this.matrix;
        if (matrix == null) {
            matrix = new Matrix();
            this.matrix = matrix;
        }
        this.renderNode.getMatrix(matrix);
        return matrix;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void discardDisplayList() {
        this.renderNode.discardDisplayList();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void draw(Canvas canvas) {
        AndroidCanvas_androidKt.getNativeCanvas(canvas).drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getAmbientShadowColor-0d7_KjU, reason: from getter */
    public long getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getBlendMode-0nO6VwU, reason: from getter */
    public int getBlendMode() {
        return this.blendMode;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getCameraDistance() {
        return this.cameraDistance;
    }

    public boolean getClip() {
        return this.clip;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getCompositingStrategy-ke2Ky5w, reason: from getter */
    public int getCompositingStrategy() {
        return this.compositingStrategy;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean getHasDisplayList() {
        boolean hasDisplayList;
        hasDisplayList = this.renderNode.hasDisplayList();
        return hasDisplayList;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public RenderEffect getRenderEffect() {
        return null;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationX() {
        return this.rotationX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationY() {
        return this.rotationY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationZ() {
        return this.rotationZ;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getScaleX() {
        return this.scaleX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getScaleY() {
        return this.scaleY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getShadowElevation() {
        return this.shadowElevation;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getSpotShadowColor-0d7_KjU, reason: from getter */
    public long getSpotShadowColor() {
        return this.spotShadowColor;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getTranslationX() {
        return this.translationX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getTranslationY() {
        return this.translationY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void record(Density density, LayoutDirection layoutDirection, GraphicsLayer layer, Function1<? super DrawScope, Unit> block) {
        RecordingCanvas beginRecording;
        beginRecording = this.renderNode.beginRecording();
        try {
            CanvasHolder canvasHolder = this.canvasHolder;
            android.graphics.Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
            canvasHolder.getAndroidCanvas().setInternalCanvas(beginRecording);
            AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
            DrawContext drawContext = this.canvasDrawScope.getDrawContext();
            drawContext.setDensity(density);
            drawContext.setLayoutDirection(layoutDirection);
            drawContext.setGraphicsLayer(layer);
            drawContext.mo1683setSizeuvyYCjk(this.size);
            drawContext.setCanvas(androidCanvas);
            block.invoke(this.canvasDrawScope);
            canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
            this.renderNode.endRecording();
            setInvalidated(false);
        } catch (Throwable th) {
            this.renderNode.endRecording();
            throw th;
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float f5) {
        this.alpha = f5;
        this.renderNode.setAlpha(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setAmbientShadowColor-8_81llA */
    public void mo1734setAmbientShadowColor8_81llA(long j5) {
        this.ambientShadowColor = j5;
        this.renderNode.setAmbientShadowColor(ColorKt.m1508toArgb8_81llA(j5));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setCameraDistance(float f5) {
        this.cameraDistance = f5;
        this.renderNode.setCameraDistance(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setClip(boolean z5) {
        this.clip = z5;
        applyClip();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setCompositingStrategy-Wpw9cng */
    public void mo1735setCompositingStrategyWpw9cng(int i5) {
        this.compositingStrategy = i5;
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setInvalidated(boolean z5) {
        this.isInvalidated = z5;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setOutline-O0kMr_c */
    public void mo1736setOutlineO0kMr_c(Outline outline, long outlineSize) {
        this.renderNode.setOutline(outline);
        this.outlineIsProvided = outline != null;
        applyClip();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setPivotOffset-k-4lQ0M */
    public void mo1737setPivotOffsetk4lQ0M(long j5) {
        this.pivotOffset = j5;
        if (OffsetKt.m1352isUnspecifiedk4lQ0M(j5)) {
            this.renderNode.resetPivot();
        } else {
            this.renderNode.setPivotX(Offset.m1337getXimpl(j5));
            this.renderNode.setPivotY(Offset.m1338getYimpl(j5));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setPosition-H0pRuoY */
    public void mo1738setPositionH0pRuoY(int x5, int y5, long size) {
        this.renderNode.setPosition(x5, y5, IntSize.m2661getWidthimpl(size) + x5, IntSize.m2660getHeightimpl(size) + y5);
        this.size = IntSizeKt.m2668toSizeozmzZPI(size);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRenderEffect(RenderEffect renderEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            RenderNodeVerificationHelper.INSTANCE.setRenderEffect(this.renderNode, renderEffect);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationX(float f5) {
        this.rotationX = f5;
        this.renderNode.setRotationX(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationY(float f5) {
        this.rotationY = f5;
        this.renderNode.setRotationY(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationZ(float f5) {
        this.rotationZ = f5;
        this.renderNode.setRotationZ(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleX(float f5) {
        this.scaleX = f5;
        this.renderNode.setScaleX(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleY(float f5) {
        this.scaleY = f5;
        this.renderNode.setScaleY(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setShadowElevation(float f5) {
        this.shadowElevation = f5;
        this.renderNode.setElevation(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setSpotShadowColor-8_81llA */
    public void mo1739setSpotShadowColor8_81llA(long j5) {
        this.spotShadowColor = j5;
        this.renderNode.setSpotShadowColor(ColorKt.m1508toArgb8_81llA(j5));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationX(float f5) {
        this.translationX = f5;
        this.renderNode.setTranslationX(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationY(float f5) {
        this.translationY = f5;
        this.renderNode.setTranslationY(f5);
    }

    public /* synthetic */ GraphicsLayerV29(long j5, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, (i5 & 2) != 0 ? new CanvasHolder() : canvasHolder, (i5 & 4) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }
}
