package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
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
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u0000 \u009e\u00012\u00020\u0001:\u0002\u009e\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ*\u0010#\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J$\u0010)\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b'\u0010(J;\u00103\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u000e00H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u000e2\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u000eH\u0016¢\u0006\u0004\b<\u0010\u0016J\u000f\u0010>\u001a\u00020\u000eH\u0000¢\u0006\u0004\b=\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010?\u001a\u0004\b@\u0010AR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010BR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010CR\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010DR\u001c\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b \u0010?R\u0018\u0010F\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010H\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001c\u0010&\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b&\u0010?R0\u0010\r\u001a\u00020\f2\u0006\u0010L\u001a\u00020\f8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\r\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010\u0010R0\u0010R\u001a\u00020Q2\u0006\u0010L\u001a\u00020Q8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bR\u0010M\u001a\u0004\bS\u0010O\"\u0004\bT\u0010\u0010R.\u0010V\u001a\u0004\u0018\u00010U2\b\u0010L\u001a\u0004\u0018\u00010U8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R*\u0010]\u001a\u00020\\2\u0006\u0010L\u001a\u00020\\8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010KR0\u0010e\u001a\u00020d2\u0006\u0010L\u001a\u00020d8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\be\u0010?\u001a\u0004\bf\u0010A\"\u0004\bg\u0010hR*\u0010i\u001a\u00020\\2\u0006\u0010L\u001a\u00020\\8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bi\u0010^\u001a\u0004\bj\u0010`\"\u0004\bk\u0010bR*\u0010l\u001a\u00020\\2\u0006\u0010L\u001a\u00020\\8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bl\u0010^\u001a\u0004\bm\u0010`\"\u0004\bn\u0010bR*\u0010o\u001a\u00020\\2\u0006\u0010L\u001a\u00020\\8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bo\u0010^\u001a\u0004\bp\u0010`\"\u0004\bq\u0010bR*\u0010r\u001a\u00020\\2\u0006\u0010L\u001a\u00020\\8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\br\u0010^\u001a\u0004\bs\u0010`\"\u0004\bt\u0010bR*\u0010u\u001a\u00020\\2\u0006\u0010L\u001a\u00020\\8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bu\u0010^\u001a\u0004\bv\u0010`\"\u0004\bw\u0010bR0\u0010y\u001a\u00020x2\u0006\u0010L\u001a\u00020x8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\by\u0010?\u001a\u0004\bz\u0010A\"\u0004\b{\u0010hR0\u0010|\u001a\u00020x2\u0006\u0010L\u001a\u00020x8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b|\u0010?\u001a\u0004\b}\u0010A\"\u0004\b~\u0010hR,\u0010\u007f\u001a\u00020\\2\u0006\u0010L\u001a\u00020\\8\u0016@VX\u0096\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010^\u001a\u0005\b\u0080\u0001\u0010`\"\u0005\b\u0081\u0001\u0010bR.\u0010\u0082\u0001\u001a\u00020\\2\u0006\u0010L\u001a\u00020\\8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010^\u001a\u0005\b\u0083\u0001\u0010`\"\u0005\b\u0084\u0001\u0010bR.\u0010\u0085\u0001\u001a\u00020\\2\u0006\u0010L\u001a\u00020\\8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010^\u001a\u0005\b\u0086\u0001\u0010`\"\u0005\b\u0087\u0001\u0010bR.\u0010\u0088\u0001\u001a\u00020\\2\u0006\u0010L\u001a\u00020\\8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0088\u0001\u0010^\u001a\u0005\b\u0089\u0001\u0010`\"\u0005\b\u008a\u0001\u0010bR/\u0010\u008b\u0001\u001a\u00020\u00122\u0006\u0010L\u001a\u00020\u00128\u0016@VX\u0096\u000e¢\u0006\u0016\n\u0005\b\u008b\u0001\u0010K\u001a\u0005\b\u008c\u0001\u0010\u0014\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0018\u0010\u008f\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010KR\u0018\u0010\u0090\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010KR,\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R'\u0010\u0098\u0001\u001a\u00020\u00128\u0016@\u0016X\u0096\u000e¢\u0006\u0016\n\u0005\b\u0098\u0001\u0010K\u001a\u0005\b\u0098\u0001\u0010\u0014\"\u0006\b\u0099\u0001\u0010\u008e\u0001R\u001d\u0010\u009a\u0001\u001a\u00020\u00048\u0016X\u0096D¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010?\u001a\u0005\b\u009b\u0001\u0010AR\u0016\u0010\u009d\u0001\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u009c\u0001\u0010\u0014\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u009f\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerV23;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "Landroid/view/View;", "ownerView", BuildConfig.FLAVOR, "ownerId", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "canvasDrawScope", "<init>", "(Landroid/view/View;JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", BuildConfig.FLAVOR, "applyCompositingStrategy-Wpw9cng", "(I)V", "applyCompositingStrategy", BuildConfig.FLAVOR, "requiresCompositingLayer", "()Z", "updateLayerProperties", "()V", "applyClip", "Landroid/view/RenderNode;", "renderNode", "verifyShadowColorProperties", "(Landroid/view/RenderNode;)V", BuildConfig.FLAVOR, "x", "y", "Landroidx/compose/ui/unit/IntSize;", "size", "setPosition-H0pRuoY", "(IIJ)V", "setPosition", "Landroid/graphics/Outline;", "outline", "outlineSize", "setOutline-O0kMr_c", "(Landroid/graphics/Outline;J)V", "setOutline", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "record", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/jvm/functions/Function1;)V", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "draw", "(Landroidx/compose/ui/graphics/Canvas;)V", "Landroid/graphics/Matrix;", "calculateMatrix", "()Landroid/graphics/Matrix;", "discardDisplayList", "discardDisplayListInternal$ui_graphics_release", "discardDisplayListInternal", "J", "getOwnerId", "()J", "Landroidx/compose/ui/graphics/CanvasHolder;", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroid/view/RenderNode;", "Landroid/graphics/Paint;", "layerPaint", "Landroid/graphics/Paint;", "matrix", "Landroid/graphics/Matrix;", "outlineIsProvided", "Z", "value", "I", "getCompositingStrategy-ke2Ky5w", "()I", "setCompositingStrategy-Wpw9cng", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", BuildConfig.FLAVOR, "alpha", "F", "getAlpha", "()F", "setAlpha", "(F)V", "shouldManuallySetCenterPivot", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "(J)V", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "getClip", "setClip", "(Z)V", "clipToBounds", "clipToOutline", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "isInvalidated", "setInvalidated", "layerId", "getLayerId", "getHasDisplayList", "hasDisplayList", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphicsLayerV23 implements GraphicsLayerImpl {
    private static final AtomicBoolean needToValidateAccess = new AtomicBoolean(true);
    private static boolean testFailCreateRenderNode;
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
    private final long layerId;
    private Paint layerPaint;
    private Matrix matrix;
    private boolean outlineIsProvided;
    private long outlineSize;
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
    private boolean shouldManuallySetCenterPivot;
    private long size;
    private long spotShadowColor;
    private float translationX;
    private float translationY;

    public GraphicsLayerV23(View view, long j5, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        this.ownerId = j5;
        this.canvasHolder = canvasHolder;
        this.canvasDrawScope = canvasDrawScope;
        RenderNode create = RenderNode.create("Compose", view);
        this.renderNode = create;
        IntSize.Companion companion = IntSize.INSTANCE;
        this.size = companion.m2665getZeroYbymL2g();
        this.outlineSize = companion.m2665getZeroYbymL2g();
        if (needToValidateAccess.getAndSet(false)) {
            create.setScaleX(create.getScaleX());
            create.setScaleY(create.getScaleY());
            create.setTranslationX(create.getTranslationX());
            create.setTranslationY(create.getTranslationY());
            create.setElevation(create.getElevation());
            create.setRotation(create.getRotation());
            create.setRotationX(create.getRotationX());
            create.setRotationY(create.getRotationY());
            create.setCameraDistance(create.getCameraDistance());
            create.setPivotX(create.getPivotX());
            create.setPivotY(create.getPivotY());
            create.setClipToOutline(create.getClipToOutline());
            create.setClipToBounds(false);
            create.setAlpha(create.getAlpha());
            create.isValid();
            create.setLeftTopRightBottom(0, 0, 0, 0);
            create.offsetLeftAndRight(0);
            create.offsetTopAndBottom(0);
            verifyShadowColorProperties(create);
            discardDisplayListInternal$ui_graphics_release();
            create.setLayerType(0);
            create.setHasOverlappingRendering(create.hasOverlappingRendering());
        }
        if (!testFailCreateRenderNode) {
            create.setClipToBounds(false);
            CompositingStrategy.Companion companion2 = CompositingStrategy.INSTANCE;
            m1740applyCompositingStrategyWpw9cng(companion2.m1712getAutoke2Ky5w());
            this.compositingStrategy = companion2.m1712getAutoke2Ky5w();
            this.blendMode = BlendMode.INSTANCE.m1459getSrcOver0nO6VwU();
            this.alpha = 1.0f;
            this.pivotOffset = Offset.INSTANCE.m1348getUnspecifiedF1C5BW0();
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            Color.Companion companion3 = Color.INSTANCE;
            this.ambientShadowColor = companion3.m1496getBlack0d7_KjU();
            this.spotShadowColor = companion3.m1496getBlack0d7_KjU();
            this.cameraDistance = 8.0f;
            this.isInvalidated = true;
            return;
        }
        throw new NoClassDefFoundError();
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

    /* renamed from: applyCompositingStrategy-Wpw9cng, reason: not valid java name */
    private final void m1740applyCompositingStrategyWpw9cng(int compositingStrategy) {
        RenderNode renderNode = this.renderNode;
        CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
        if (CompositingStrategy.m1711equalsimpl0(compositingStrategy, companion.m1714getOffscreenke2Ky5w())) {
            renderNode.setLayerType(2);
            renderNode.setLayerPaint(this.layerPaint);
            renderNode.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.m1711equalsimpl0(compositingStrategy, companion.m1713getModulateAlphake2Ky5w())) {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.layerPaint);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.layerPaint);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    private final boolean requiresCompositingLayer() {
        return (!CompositingStrategy.m1711equalsimpl0(getCompositingStrategy(), CompositingStrategy.INSTANCE.m1714getOffscreenke2Ky5w()) && BlendMode.m1429equalsimpl0(getBlendMode(), BlendMode.INSTANCE.m1459getSrcOver0nO6VwU()) && getColorFilter() == null) ? false : true;
    }

    private final void updateLayerProperties() {
        if (requiresCompositingLayer()) {
            m1740applyCompositingStrategyWpw9cng(CompositingStrategy.INSTANCE.m1714getOffscreenke2Ky5w());
        } else {
            m1740applyCompositingStrategyWpw9cng(getCompositingStrategy());
        }
    }

    private final void verifyShadowColorProperties(RenderNode renderNode) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28 renderNodeVerificationHelper28 = RenderNodeVerificationHelper28.INSTANCE;
            renderNodeVerificationHelper28.setAmbientShadowColor(renderNode, renderNodeVerificationHelper28.getAmbientShadowColor(renderNode));
            renderNodeVerificationHelper28.setSpotShadowColor(renderNode, renderNodeVerificationHelper28.getSpotShadowColor(renderNode));
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
        discardDisplayListInternal$ui_graphics_release();
    }

    public final void discardDisplayListInternal$ui_graphics_release() {
        RenderNodeVerificationHelper24.INSTANCE.discardDisplayList(this.renderNode);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void draw(Canvas canvas) {
        DisplayListCanvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        Intrinsics.checkNotNull(nativeCanvas, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        nativeCanvas.drawRenderNode(this.renderNode);
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
        return this.renderNode.isValid();
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
        android.graphics.Canvas start = this.renderNode.start(Math.max(IntSize.m2661getWidthimpl(this.size), IntSize.m2661getWidthimpl(this.outlineSize)), Math.max(IntSize.m2660getHeightimpl(this.size), IntSize.m2660getHeightimpl(this.outlineSize)));
        try {
            CanvasHolder canvasHolder = this.canvasHolder;
            android.graphics.Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
            canvasHolder.getAndroidCanvas().setInternalCanvas(start);
            AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
            CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
            long m2668toSizeozmzZPI = IntSizeKt.m2668toSizeozmzZPI(this.size);
            Density density2 = canvasDrawScope.getDrawContext().getDensity();
            LayoutDirection layoutDirection2 = canvasDrawScope.getDrawContext().getLayoutDirection();
            Canvas canvas = canvasDrawScope.getDrawContext().getCanvas();
            long mo1682getSizeNHjbRc = canvasDrawScope.getDrawContext().mo1682getSizeNHjbRc();
            GraphicsLayer graphicsLayer = canvasDrawScope.getDrawContext().getGraphicsLayer();
            DrawContext drawContext = canvasDrawScope.getDrawContext();
            drawContext.setDensity(density);
            drawContext.setLayoutDirection(layoutDirection);
            drawContext.setCanvas(androidCanvas);
            drawContext.mo1683setSizeuvyYCjk(m2668toSizeozmzZPI);
            drawContext.setGraphicsLayer(layer);
            androidCanvas.save();
            try {
                block.invoke(canvasDrawScope);
                androidCanvas.restore();
                DrawContext drawContext2 = canvasDrawScope.getDrawContext();
                drawContext2.setDensity(density2);
                drawContext2.setLayoutDirection(layoutDirection2);
                drawContext2.setCanvas(canvas);
                drawContext2.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
                drawContext2.setGraphicsLayer(graphicsLayer);
                canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
                this.renderNode.end(start);
                setInvalidated(false);
            } catch (Throwable th) {
                androidCanvas.restore();
                DrawContext drawContext3 = canvasDrawScope.getDrawContext();
                drawContext3.setDensity(density2);
                drawContext3.setLayoutDirection(layoutDirection2);
                drawContext3.setCanvas(canvas);
                drawContext3.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
                drawContext3.setGraphicsLayer(graphicsLayer);
                throw th;
            }
        } catch (Throwable th2) {
            this.renderNode.end(start);
            throw th2;
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
        if (Build.VERSION.SDK_INT >= 28) {
            this.ambientShadowColor = j5;
            RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(this.renderNode, ColorKt.m1508toArgb8_81llA(j5));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setCameraDistance(float f5) {
        this.cameraDistance = f5;
        this.renderNode.setCameraDistance(-f5);
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
        this.outlineSize = outlineSize;
        this.renderNode.setOutline(outline);
        this.outlineIsProvided = outline != null;
        applyClip();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setPivotOffset-k-4lQ0M */
    public void mo1737setPivotOffsetk4lQ0M(long j5) {
        this.pivotOffset = j5;
        if (OffsetKt.m1352isUnspecifiedk4lQ0M(j5)) {
            this.shouldManuallySetCenterPivot = true;
            this.renderNode.setPivotX(IntSize.m2661getWidthimpl(this.size) / 2.0f);
            this.renderNode.setPivotY(IntSize.m2660getHeightimpl(this.size) / 2.0f);
        } else {
            this.shouldManuallySetCenterPivot = false;
            this.renderNode.setPivotX(Offset.m1337getXimpl(j5));
            this.renderNode.setPivotY(Offset.m1338getYimpl(j5));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setPosition-H0pRuoY */
    public void mo1738setPositionH0pRuoY(int x5, int y5, long size) {
        this.renderNode.setLeftTopRightBottom(x5, y5, IntSize.m2661getWidthimpl(size) + x5, IntSize.m2660getHeightimpl(size) + y5);
        if (IntSize.m2659equalsimpl0(this.size, size)) {
            return;
        }
        if (this.shouldManuallySetCenterPivot) {
            this.renderNode.setPivotX(IntSize.m2661getWidthimpl(size) / 2.0f);
            this.renderNode.setPivotY(IntSize.m2660getHeightimpl(size) / 2.0f);
        }
        this.size = size;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRenderEffect(RenderEffect renderEffect) {
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
        this.renderNode.setRotation(f5);
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
        if (Build.VERSION.SDK_INT >= 28) {
            this.spotShadowColor = j5;
            RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(this.renderNode, ColorKt.m1508toArgb8_81llA(j5));
        }
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

    public /* synthetic */ GraphicsLayerV23(View view, long j5, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, j5, (i5 & 4) != 0 ? new CanvasHolder() : canvasHolder, (i5 & 8) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }
}
