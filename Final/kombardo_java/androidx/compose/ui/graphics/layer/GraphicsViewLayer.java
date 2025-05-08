package androidx.compose.ui.graphics.layer;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.CompositingStrategy;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 §\u00012\u00020\u0001:\u0002§\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u0013J*\u0010!\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J$\u0010'\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\b%\u0010&J;\u00101\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u000e0.H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u000e2\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u000eH\u0016¢\u0006\u0004\b:\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010;R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010?\u001a\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001c\u0010G\u001a\n F*\u0004\u0018\u00010E0E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010P\u001a\u0004\u0018\u00010O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010T\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010?R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010UR\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010UR\u001c\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001e\u0010<R\u0016\u0010V\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\"\u0010X\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bX\u0010W\u001a\u0004\bX\u0010\u0016\"\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010WR\u0016\u0010\\\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010WR\u001a\u0010]\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b]\u0010<\u001a\u0004\b^\u0010>R0\u0010a\u001a\u00020_2\u0006\u0010`\u001a\u00020_8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\ba\u0010U\u001a\u0004\bb\u0010c\"\u0004\bd\u0010\u0010R.\u0010f\u001a\u0004\u0018\u00010e2\b\u0010`\u001a\u0004\u0018\u00010e8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR0\u0010\r\u001a\u00020\f2\u0006\u0010`\u001a\u00020\f8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\r\u0010U\u001a\u0004\bl\u0010c\"\u0004\bm\u0010\u0010R*\u0010o\u001a\u00020n2\u0006\u0010`\u001a\u00020n8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u0016\u0010u\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010WR0\u0010w\u001a\u00020v2\u0006\u0010`\u001a\u00020v8\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bw\u0010<\u001a\u0004\bx\u0010>\"\u0004\by\u0010zR*\u0010{\u001a\u00020n2\u0006\u0010`\u001a\u00020n8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b{\u0010p\u001a\u0004\b|\u0010r\"\u0004\b}\u0010tR+\u0010~\u001a\u00020n2\u0006\u0010`\u001a\u00020n8\u0016@VX\u0096\u000e¢\u0006\u0013\n\u0004\b~\u0010p\u001a\u0004\b\u007f\u0010r\"\u0005\b\u0080\u0001\u0010tR.\u0010\u0081\u0001\u001a\u00020n2\u0006\u0010`\u001a\u00020n8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010p\u001a\u0005\b\u0082\u0001\u0010r\"\u0005\b\u0083\u0001\u0010tR.\u0010\u0084\u0001\u001a\u00020n2\u0006\u0010`\u001a\u00020n8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010p\u001a\u0005\b\u0085\u0001\u0010r\"\u0005\b\u0086\u0001\u0010tR.\u0010\u0087\u0001\u001a\u00020n2\u0006\u0010`\u001a\u00020n8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010p\u001a\u0005\b\u0088\u0001\u0010r\"\u0005\b\u0089\u0001\u0010tR6\u0010\u008b\u0001\u001a\u00030\u008a\u00012\u0007\u0010`\u001a\u00030\u008a\u00018\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0015\n\u0005\b\u008b\u0001\u0010<\u001a\u0005\b\u008c\u0001\u0010>\"\u0005\b\u008d\u0001\u0010zR6\u0010\u008e\u0001\u001a\u00030\u008a\u00012\u0007\u0010`\u001a\u00030\u008a\u00018\u0016@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0015\n\u0005\b\u008e\u0001\u0010<\u001a\u0005\b\u008f\u0001\u0010>\"\u0005\b\u0090\u0001\u0010zR.\u0010\u0091\u0001\u001a\u00020n2\u0006\u0010`\u001a\u00020n8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0091\u0001\u0010p\u001a\u0005\b\u0092\u0001\u0010r\"\u0005\b\u0093\u0001\u0010tR.\u0010\u0094\u0001\u001a\u00020n2\u0006\u0010`\u001a\u00020n8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0094\u0001\u0010p\u001a\u0005\b\u0095\u0001\u0010r\"\u0005\b\u0096\u0001\u0010tR.\u0010\u0097\u0001\u001a\u00020n2\u0006\u0010`\u001a\u00020n8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010p\u001a\u0005\b\u0098\u0001\u0010r\"\u0005\b\u0099\u0001\u0010tR7\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00012\t\u0010`\u001a\u0005\u0018\u00010\u009a\u00018\u0016@VX\u0096\u000e¢\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R'\u0010£\u0001\u001a\u00020n2\u0006\u0010`\u001a\u00020n8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¡\u0001\u0010r\"\u0005\b¢\u0001\u0010tR'\u0010¦\u0001\u001a\u00020\u00142\u0006\u0010`\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¤\u0001\u0010\u0016\"\u0005\b¥\u0001\u0010Z\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¨\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsViewLayer;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "layerContainer", BuildConfig.FLAVOR, "ownerId", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "canvasDrawScope", "<init>", "(Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", BuildConfig.FLAVOR, "applyCompositingLayer-Wpw9cng", "(I)V", "applyCompositingLayer", "updateLayerProperties", "()V", BuildConfig.FLAVOR, "requiresCompositingLayer", "()Z", "requiresLayerPaint", "recordDrawingOperations", "updateClipBounds", BuildConfig.FLAVOR, "x", "y", "Landroidx/compose/ui/unit/IntSize;", "size", "setPosition-H0pRuoY", "(IIJ)V", "setPosition", "Landroid/graphics/Outline;", "outline", "outlineSize", "setOutline-O0kMr_c", "(Landroid/graphics/Outline;J)V", "setOutline", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "record", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/jvm/functions/Function1;)V", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "draw", "(Landroidx/compose/ui/graphics/Canvas;)V", "Landroid/graphics/Matrix;", "calculateMatrix", "()Landroid/graphics/Matrix;", "discardDisplayList", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "J", "getOwnerId", "()J", "Landroidx/compose/ui/graphics/CanvasHolder;", "getCanvasHolder", "()Landroidx/compose/ui/graphics/CanvasHolder;", "Landroidx/compose/ui/graphics/layer/ViewLayer;", "viewLayer", "Landroidx/compose/ui/graphics/layer/ViewLayer;", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "resources", "Landroid/content/res/Resources;", "Landroid/graphics/Rect;", "clipRect", "Landroid/graphics/Rect;", "Landroid/graphics/Paint;", "layerPaint", "Landroid/graphics/Paint;", "Landroid/graphics/Picture;", "picture", "Landroid/graphics/Picture;", "pictureDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "pictureCanvasHolder", "I", "clipBoundsInvalidated", "Z", "isInvalidated", "setInvalidated", "(Z)V", "outlineIsProvided", "clipToBounds", "layerId", "getLayerId", "Landroidx/compose/ui/graphics/BlendMode;", "value", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", BuildConfig.FLAVOR, "alpha", "F", "getAlpha", "()F", "setAlpha", "(F)V", "shouldManuallySetCenterPivot", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "(J)V", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "getCameraDistance", "setCameraDistance", "cameraDistance", "getClip", "setClip", "clip", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphicsViewLayer implements GraphicsLayerImpl {
    private float alpha;
    private long ambientShadowColor;
    private int blendMode;
    private final CanvasHolder canvasHolder;
    private boolean clipBoundsInvalidated;
    private final Rect clipRect;
    private boolean clipToBounds;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private boolean isInvalidated;
    private final DrawChildContainer layerContainer;
    private final long layerId;
    private Paint layerPaint;
    private boolean outlineIsProvided;
    private final long ownerId;
    private final Picture picture;
    private final CanvasHolder pictureCanvasHolder;
    private final CanvasDrawScope pictureDrawScope;
    private long pivotOffset;
    private RenderEffect renderEffect;
    private final Resources resources;
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
    private final ViewLayer viewLayer;
    private int x;
    private int y;
    private static final boolean mayRenderInSoftware = !SurfaceUtils.INSTANCE.isLockHardwareCanvasAvailable();
    private static final Canvas PlaceholderCanvas = new Canvas() { // from class: androidx.compose.ui.graphics.layer.GraphicsViewLayer$Companion$PlaceholderCanvas$1
        @Override // android.graphics.Canvas
        public boolean isHardwareAccelerated() {
            return true;
        }
    };

    public GraphicsViewLayer(DrawChildContainer drawChildContainer, long j5, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        this.layerContainer = drawChildContainer;
        this.ownerId = j5;
        this.canvasHolder = canvasHolder;
        ViewLayer viewLayer = new ViewLayer(drawChildContainer, canvasHolder, canvasDrawScope);
        this.viewLayer = viewLayer;
        this.resources = drawChildContainer.getResources();
        this.clipRect = new Rect();
        boolean z5 = mayRenderInSoftware;
        this.picture = z5 ? new Picture() : null;
        this.pictureDrawScope = z5 ? new CanvasDrawScope() : null;
        this.pictureCanvasHolder = z5 ? new CanvasHolder() : null;
        drawChildContainer.addView(viewLayer);
        viewLayer.setClipBounds(null);
        this.size = IntSize.INSTANCE.m2665getZeroYbymL2g();
        this.isInvalidated = true;
        this.layerId = View.generateViewId();
        this.blendMode = BlendMode.INSTANCE.m1459getSrcOver0nO6VwU();
        this.compositingStrategy = CompositingStrategy.INSTANCE.m1712getAutoke2Ky5w();
        this.alpha = 1.0f;
        this.pivotOffset = Offset.INSTANCE.m1349getZeroF1C5BW0();
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        Color.Companion companion = Color.INSTANCE;
        this.ambientShadowColor = companion.m1496getBlack0d7_KjU();
        this.spotShadowColor = companion.m1496getBlack0d7_KjU();
    }

    /* renamed from: applyCompositingLayer-Wpw9cng, reason: not valid java name */
    private final void m1742applyCompositingLayerWpw9cng(int compositingStrategy) {
        ViewLayer viewLayer = this.viewLayer;
        CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
        boolean z5 = true;
        if (CompositingStrategy.m1711equalsimpl0(compositingStrategy, companion.m1714getOffscreenke2Ky5w())) {
            this.viewLayer.setLayerType(2, this.layerPaint);
        } else if (CompositingStrategy.m1711equalsimpl0(compositingStrategy, companion.m1713getModulateAlphake2Ky5w())) {
            this.viewLayer.setLayerType(0, this.layerPaint);
            z5 = false;
        } else {
            this.viewLayer.setLayerType(0, this.layerPaint);
        }
        viewLayer.setCanUseCompositingLayer$ui_graphics_release(z5);
    }

    private final void recordDrawingOperations() {
        try {
            CanvasHolder canvasHolder = this.canvasHolder;
            Canvas canvas = PlaceholderCanvas;
            Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
            canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
            AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
            DrawChildContainer drawChildContainer = this.layerContainer;
            ViewLayer viewLayer = this.viewLayer;
            drawChildContainer.drawChild$ui_graphics_release(androidCanvas, viewLayer, viewLayer.getDrawingTime());
            canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        } catch (Throwable unused) {
        }
    }

    private final boolean requiresCompositingLayer() {
        return CompositingStrategy.m1711equalsimpl0(getCompositingStrategy(), CompositingStrategy.INSTANCE.m1714getOffscreenke2Ky5w()) || requiresLayerPaint();
    }

    private final boolean requiresLayerPaint() {
        return (BlendMode.m1429equalsimpl0(getBlendMode(), BlendMode.INSTANCE.m1459getSrcOver0nO6VwU()) && getColorFilter() == null) ? false : true;
    }

    private final void updateClipBounds() {
        Rect rect;
        if (this.clipBoundsInvalidated) {
            ViewLayer viewLayer = this.viewLayer;
            if (!getClip() || this.outlineIsProvided) {
                rect = null;
            } else {
                rect = this.clipRect;
                rect.left = 0;
                rect.top = 0;
                rect.right = this.viewLayer.getWidth();
                rect.bottom = this.viewLayer.getHeight();
            }
            viewLayer.setClipBounds(rect);
        }
    }

    private final void updateLayerProperties() {
        if (requiresCompositingLayer()) {
            m1742applyCompositingLayerWpw9cng(CompositingStrategy.INSTANCE.m1714getOffscreenke2Ky5w());
        } else {
            m1742applyCompositingLayerWpw9cng(getCompositingStrategy());
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix calculateMatrix() {
        return this.viewLayer.getMatrix();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void discardDisplayList() {
        this.layerContainer.removeViewInLayout(this.viewLayer);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void draw(androidx.compose.ui.graphics.Canvas canvas) {
        updateClipBounds();
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            DrawChildContainer drawChildContainer = this.layerContainer;
            ViewLayer viewLayer = this.viewLayer;
            drawChildContainer.drawChild$ui_graphics_release(canvas, viewLayer, viewLayer.getDrawingTime());
        } else {
            Picture picture = this.picture;
            if (picture != null) {
                nativeCanvas.drawPicture(picture);
            }
        }
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
        return this.viewLayer.getCameraDistance() / this.resources.getDisplayMetrics().densityDpi;
    }

    public boolean getClip() {
        return this.clipToBounds || this.viewLayer.getClipToOutline();
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
        CanvasHolder canvasHolder;
        Canvas canvas;
        if (this.viewLayer.getParent() == null) {
            this.layerContainer.addView(this.viewLayer);
        }
        this.viewLayer.setDrawParams(density, layoutDirection, layer, block);
        if (this.viewLayer.isAttachedToWindow()) {
            this.viewLayer.setVisibility(4);
            this.viewLayer.setVisibility(0);
            recordDrawingOperations();
            Picture picture = this.picture;
            if (picture != null) {
                Canvas beginRecording = picture.beginRecording(IntSize.m2661getWidthimpl(this.size), IntSize.m2660getHeightimpl(this.size));
                try {
                    CanvasHolder canvasHolder2 = this.pictureCanvasHolder;
                    if (canvasHolder2 != null) {
                        Canvas internalCanvas = canvasHolder2.getAndroidCanvas().getInternalCanvas();
                        canvasHolder2.getAndroidCanvas().setInternalCanvas(beginRecording);
                        AndroidCanvas androidCanvas = canvasHolder2.getAndroidCanvas();
                        CanvasDrawScope canvasDrawScope = this.pictureDrawScope;
                        if (canvasDrawScope != null) {
                            long m2668toSizeozmzZPI = IntSizeKt.m2668toSizeozmzZPI(this.size);
                            CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
                            Density density2 = drawParams.getDensity();
                            LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
                            androidx.compose.ui.graphics.Canvas canvas2 = drawParams.getCanvas();
                            canvasHolder = canvasHolder2;
                            canvas = internalCanvas;
                            long size = drawParams.getSize();
                            CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
                            drawParams2.setDensity(density);
                            drawParams2.setLayoutDirection(layoutDirection);
                            drawParams2.setCanvas(androidCanvas);
                            drawParams2.m1681setSizeuvyYCjk(m2668toSizeozmzZPI);
                            androidCanvas.save();
                            block.invoke(canvasDrawScope);
                            androidCanvas.restore();
                            CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
                            drawParams3.setDensity(density2);
                            drawParams3.setLayoutDirection(layoutDirection2);
                            drawParams3.setCanvas(canvas2);
                            drawParams3.m1681setSizeuvyYCjk(size);
                        } else {
                            canvasHolder = canvasHolder2;
                            canvas = internalCanvas;
                        }
                        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
                        Unit unit = Unit.INSTANCE;
                    }
                    picture.endRecording();
                } catch (Throwable th) {
                    picture.endRecording();
                    throw th;
                }
            }
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float f5) {
        this.alpha = f5;
        this.viewLayer.setAlpha(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setAmbientShadowColor-8_81llA */
    public void mo1734setAmbientShadowColor8_81llA(long j5) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.ambientShadowColor = j5;
            ViewLayerVerificationHelper28.INSTANCE.setOutlineAmbientShadowColor(this.viewLayer, ColorKt.m1508toArgb8_81llA(j5));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setCameraDistance(float f5) {
        this.viewLayer.setCameraDistance(f5 * this.resources.getDisplayMetrics().densityDpi);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setClip(boolean z5) {
        boolean z6 = false;
        this.clipToBounds = z5 && !this.outlineIsProvided;
        this.clipBoundsInvalidated = true;
        ViewLayer viewLayer = this.viewLayer;
        if (z5 && this.outlineIsProvided) {
            z6 = true;
        }
        viewLayer.setClipToOutline(z6);
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
        boolean layerOutline = this.viewLayer.setLayerOutline(outline);
        if (getClip() && outline != null) {
            this.viewLayer.setClipToOutline(true);
            if (this.clipToBounds) {
                this.clipToBounds = false;
                this.clipBoundsInvalidated = true;
            }
        }
        this.outlineIsProvided = outline != null;
        if (layerOutline) {
            return;
        }
        this.viewLayer.invalidate();
        recordDrawingOperations();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setPivotOffset-k-4lQ0M */
    public void mo1737setPivotOffsetk4lQ0M(long j5) {
        this.pivotOffset = j5;
        if (!OffsetKt.m1352isUnspecifiedk4lQ0M(j5)) {
            this.shouldManuallySetCenterPivot = false;
            this.viewLayer.setPivotX(Offset.m1337getXimpl(j5));
            this.viewLayer.setPivotY(Offset.m1338getYimpl(j5));
        } else {
            if (Build.VERSION.SDK_INT >= 28) {
                ViewLayerVerificationHelper28.INSTANCE.resetPivot(this.viewLayer);
                return;
            }
            this.shouldManuallySetCenterPivot = true;
            this.viewLayer.setPivotX(IntSize.m2661getWidthimpl(this.size) / 2.0f);
            this.viewLayer.setPivotY(IntSize.m2660getHeightimpl(this.size) / 2.0f);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setPosition-H0pRuoY */
    public void mo1738setPositionH0pRuoY(int x5, int y5, long size) {
        if (IntSize.m2659equalsimpl0(this.size, size)) {
            int i5 = this.x;
            if (i5 != x5) {
                this.viewLayer.offsetLeftAndRight(x5 - i5);
            }
            int i6 = this.y;
            if (i6 != y5) {
                this.viewLayer.offsetTopAndBottom(y5 - i6);
            }
        } else {
            if (getClip()) {
                this.clipBoundsInvalidated = true;
            }
            this.viewLayer.layout(x5, y5, IntSize.m2661getWidthimpl(size) + x5, IntSize.m2660getHeightimpl(size) + y5);
            this.size = size;
            if (this.shouldManuallySetCenterPivot) {
                this.viewLayer.setPivotX(IntSize.m2661getWidthimpl(size) / 2.0f);
                this.viewLayer.setPivotY(IntSize.m2660getHeightimpl(size) / 2.0f);
            }
        }
        this.x = x5;
        this.y = y5;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRenderEffect(RenderEffect renderEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            ViewLayerVerificationHelper31.INSTANCE.setRenderEffect(this.viewLayer, renderEffect);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationX(float f5) {
        this.rotationX = f5;
        this.viewLayer.setRotationX(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationY(float f5) {
        this.rotationY = f5;
        this.viewLayer.setRotationY(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationZ(float f5) {
        this.rotationZ = f5;
        this.viewLayer.setRotation(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleX(float f5) {
        this.scaleX = f5;
        this.viewLayer.setScaleX(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleY(float f5) {
        this.scaleY = f5;
        this.viewLayer.setScaleY(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setShadowElevation(float f5) {
        this.shadowElevation = f5;
        this.viewLayer.setElevation(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setSpotShadowColor-8_81llA */
    public void mo1739setSpotShadowColor8_81llA(long j5) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.spotShadowColor = j5;
            ViewLayerVerificationHelper28.INSTANCE.setOutlineSpotShadowColor(this.viewLayer, ColorKt.m1508toArgb8_81llA(j5));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationX(float f5) {
        this.translationX = f5;
        this.viewLayer.setTranslationX(f5);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationY(float f5) {
        this.translationY = f5;
        this.viewLayer.setTranslationY(f5);
    }

    public /* synthetic */ GraphicsViewLayer(DrawChildContainer drawChildContainer, long j5, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawChildContainer, j5, (i5 & 4) != 0 ? new CanvasHolder() : canvasHolder, (i5 & 8) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }
}
