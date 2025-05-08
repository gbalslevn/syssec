package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.os.Build;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B9\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010!\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010$\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\"H\u0016ø\u0001\u0000¢\u0006\u0004\b#\u0010 J\u000f\u0010%\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010\u000fJ!\u0010'\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\bH\u0016¢\u0006\u0004\b)\u0010\u000fJ\u000f\u0010*\u001a\u00020\bH\u0016¢\u0006\u0004\b*\u0010\u000fJ\"\u0010/\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u001f\u00102\u001a\u00020\b2\u0006\u00101\u001a\u0002002\u0006\u0010,\u001a\u00020\u0019H\u0016¢\u0006\u0004\b2\u00103J9\u00104\u001a\u00020\b2\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016¢\u0006\u0004\b4\u00105J\u001a\u0010:\u001a\u00020\b2\u0006\u00107\u001a\u000206H\u0016ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u001a\u0010<\u001a\u00020\b2\u0006\u00107\u001a\u000206H\u0016ø\u0001\u0000¢\u0006\u0004\b;\u00109R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010=\u001a\u0004\b>\u0010?R,\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010@R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010AR$\u0010C\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u00198\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010DR\u0016\u0010K\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010DR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020P0O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u001c\u0010W\u001a\u00020V8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Y\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010\\\u001a\u00020[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006_"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer;", "Landroidx/compose/ui/node/OwnedLayer;", BuildConfig.FLAVOR, "Landroidx/compose/ui/platform/AndroidComposeView;", "ownerView", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", BuildConfig.FLAVOR, "drawBlock", "Lkotlin/Function0;", "invalidateParentLayer", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "triggerRepaint", "()V", "canvas", "clipRenderNode", "(Landroidx/compose/ui/graphics/Canvas;)V", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "scope", "updateLayerProperties", "(Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;)V", "Landroidx/compose/ui/geometry/Offset;", "position", BuildConfig.FLAVOR, "isInLayer-k-4lQ0M", "(J)Z", "isInLayer", "Landroidx/compose/ui/unit/IntSize;", "size", "resize-ozmzZPI", "(J)V", "resize", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "move", "invalidate", "parentLayer", "drawLayer", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "updateDisplayList", "destroy", "point", "inverse", "mapOffset-8S9VItk", "(JZ)J", "mapOffset", "Landroidx/compose/ui/geometry/MutableRect;", "rect", "mapBounds", "(Landroidx/compose/ui/geometry/MutableRect;Z)V", "reuseLayer", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "transform-58bKbWc", "([F)V", "transform", "inverseTransform-58bKbWc", "inverseTransform", "Landroidx/compose/ui/platform/AndroidComposeView;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function0;", "value", "isDirty", "Z", "setDirty", "(Z)V", "Landroidx/compose/ui/platform/OutlineResolver;", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "isDestroyed", "drawnWithZ", "Landroidx/compose/ui/graphics/Paint;", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "Landroidx/compose/ui/platform/LayerMatrixCache;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "Landroidx/compose/ui/graphics/TransformOrigin;", "transformOrigin", "J", "renderNode", "Landroidx/compose/ui/platform/DeviceRenderNode;", BuildConfig.FLAVOR, "mutatedFields", "I", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RenderNodeLayer implements OwnedLayer {
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithZ;
    private Function0<Unit> invalidateParentLayer;
    private boolean isDestroyed;
    private boolean isDirty;
    private int mutatedFields;
    private final AndroidComposeView ownerView;
    private final DeviceRenderNode renderNode;
    private Paint softwareLayerPaint;
    public static final int $stable = 8;
    private static final Function2<DeviceRenderNode, Matrix, Unit> getMatrix = new Function2<DeviceRenderNode, Matrix, Unit>() { // from class: androidx.compose.ui.platform.RenderNodeLayer$Companion$getMatrix$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(DeviceRenderNode deviceRenderNode, Matrix matrix) {
            invoke2(deviceRenderNode, matrix);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DeviceRenderNode deviceRenderNode, Matrix matrix) {
            deviceRenderNode.getMatrix(matrix);
        }
    };
    private final OutlineResolver outlineResolver = new OutlineResolver();
    private final LayerMatrixCache<DeviceRenderNode> matrixCache = new LayerMatrixCache<>(getMatrix);
    private final CanvasHolder canvasHolder = new CanvasHolder();
    private long transformOrigin = TransformOrigin.INSTANCE.m1635getCenterSzJe1aQ();

    public RenderNodeLayer(AndroidComposeView androidComposeView, Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        this.ownerView = androidComposeView;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
        DeviceRenderNode renderNodeApi29 = Build.VERSION.SDK_INT >= 29 ? new RenderNodeApi29(androidComposeView) : new RenderNodeApi23(androidComposeView);
        renderNodeApi29.setHasOverlappingRendering(true);
        renderNodeApi29.setClipToBounds(false);
        this.renderNode = renderNodeApi29;
    }

    private final void clipRenderNode(Canvas canvas) {
        if (this.renderNode.getClipToOutline() || this.renderNode.getClipToBounds()) {
            this.outlineResolver.clipToOutline(canvas);
        }
    }

    private final void setDirty(boolean z5) {
        if (z5 != this.isDirty) {
            this.isDirty = z5;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z5);
        }
    }

    private final void triggerRepaint() {
        WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        if (this.renderNode.getHasDisplayList()) {
            this.renderNode.discardDisplayList();
        }
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        this.ownerView.requestClearInvalidObservations();
        this.ownerView.recycle$ui_release(this);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(Canvas canvas, GraphicsLayer parentLayer) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            boolean z5 = this.renderNode.getElevation() > 0.0f;
            this.drawnWithZ = z5;
            if (z5) {
                canvas.enableZ();
            }
            this.renderNode.drawInto(nativeCanvas);
            if (this.drawnWithZ) {
                canvas.disableZ();
                return;
            }
            return;
        }
        float left = this.renderNode.getLeft();
        float top = this.renderNode.getTop();
        float right = this.renderNode.getRight();
        float bottom = this.renderNode.getBottom();
        if (this.renderNode.getAlpha() < 1.0f) {
            Paint paint = this.softwareLayerPaint;
            if (paint == null) {
                paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = paint;
            }
            paint.setAlpha(this.renderNode.getAlpha());
            nativeCanvas.saveLayer(left, top, right, bottom, paint.getInternalPaint());
        } else {
            canvas.save();
        }
        canvas.translate(left, top);
        canvas.mo1391concat58bKbWc(this.matrixCache.m2140calculateMatrixGrdbGEg(this.renderNode));
        clipRenderNode(canvas);
        Function2<? super Canvas, ? super GraphicsLayer, Unit> function2 = this.drawBlock;
        if (function2 != null) {
            function2.invoke(canvas, null);
        }
        canvas.restore();
        setDirty(false);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.isDirty || this.isDestroyed) {
            return;
        }
        this.ownerView.invalidate();
        setDirty(true);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: inverseTransform-58bKbWc */
    public void mo2076inverseTransform58bKbWc(float[] matrix) {
        float[] m2139calculateInverseMatrixbWbORWo = this.matrixCache.m2139calculateInverseMatrixbWbORWo(this.renderNode);
        if (m2139calculateInverseMatrixbWbORWo != null) {
            androidx.compose.ui.graphics.Matrix.m1558timesAssign58bKbWc(matrix, m2139calculateInverseMatrixbWbORWo);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: isInLayer-k-4lQ0M */
    public boolean mo2077isInLayerk4lQ0M(long position) {
        float m1337getXimpl = Offset.m1337getXimpl(position);
        float m1338getYimpl = Offset.m1338getYimpl(position);
        if (this.renderNode.getClipToBounds()) {
            return 0.0f <= m1337getXimpl && m1337getXimpl < ((float) this.renderNode.getWidth()) && 0.0f <= m1338getYimpl && m1338getYimpl < ((float) this.renderNode.getHeight());
        }
        if (this.renderNode.getClipToOutline()) {
            return this.outlineResolver.m2149isInOutlinek4lQ0M(position);
        }
        return true;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(MutableRect rect, boolean inverse) {
        if (!inverse) {
            androidx.compose.ui.graphics.Matrix.m1551mapimpl(this.matrixCache.m2140calculateMatrixGrdbGEg(this.renderNode), rect);
            return;
        }
        float[] m2139calculateInverseMatrixbWbORWo = this.matrixCache.m2139calculateInverseMatrixbWbORWo(this.renderNode);
        if (m2139calculateInverseMatrixbWbORWo == null) {
            rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            androidx.compose.ui.graphics.Matrix.m1551mapimpl(m2139calculateInverseMatrixbWbORWo, rect);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: mapOffset-8S9VItk */
    public long mo2078mapOffset8S9VItk(long point, boolean inverse) {
        if (!inverse) {
            return androidx.compose.ui.graphics.Matrix.m1550mapMKHz9U(this.matrixCache.m2140calculateMatrixGrdbGEg(this.renderNode), point);
        }
        float[] m2139calculateInverseMatrixbWbORWo = this.matrixCache.m2139calculateInverseMatrixbWbORWo(this.renderNode);
        return m2139calculateInverseMatrixbWbORWo != null ? androidx.compose.ui.graphics.Matrix.m1550mapMKHz9U(m2139calculateInverseMatrixbWbORWo, point) : Offset.INSTANCE.m1347getInfiniteF1C5BW0();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: move--gyyYBs */
    public void mo2079movegyyYBs(long position) {
        int left = this.renderNode.getLeft();
        int top = this.renderNode.getTop();
        int m2640getXimpl = IntOffset.m2640getXimpl(position);
        int m2641getYimpl = IntOffset.m2641getYimpl(position);
        if (left == m2640getXimpl && top == m2641getYimpl) {
            return;
        }
        if (left != m2640getXimpl) {
            this.renderNode.offsetLeftAndRight(m2640getXimpl - left);
        }
        if (top != m2641getYimpl) {
            this.renderNode.offsetTopAndBottom(m2641getYimpl - top);
        }
        triggerRepaint();
        this.matrixCache.invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: resize-ozmzZPI */
    public void mo2080resizeozmzZPI(long size) {
        int m2661getWidthimpl = IntSize.m2661getWidthimpl(size);
        int m2660getHeightimpl = IntSize.m2660getHeightimpl(size);
        this.renderNode.setPivotX(TransformOrigin.m1630getPivotFractionXimpl(this.transformOrigin) * m2661getWidthimpl);
        this.renderNode.setPivotY(TransformOrigin.m1631getPivotFractionYimpl(this.transformOrigin) * m2660getHeightimpl);
        DeviceRenderNode deviceRenderNode = this.renderNode;
        if (deviceRenderNode.setPosition(deviceRenderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getLeft() + m2661getWidthimpl, this.renderNode.getTop() + m2660getHeightimpl)) {
            this.renderNode.setOutline(this.outlineResolver.getAndroidOutline());
            invalidate();
            this.matrixCache.invalidate();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        setDirty(false);
        this.isDestroyed = false;
        this.drawnWithZ = false;
        this.transformOrigin = TransformOrigin.INSTANCE.m1635getCenterSzJe1aQ();
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: transform-58bKbWc */
    public void mo2081transform58bKbWc(float[] matrix) {
        androidx.compose.ui.graphics.Matrix.m1558timesAssign58bKbWc(matrix, this.matrixCache.m2140calculateMatrixGrdbGEg(this.renderNode));
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.isDirty || !this.renderNode.getHasDisplayList()) {
            Path clipPath = (!this.renderNode.getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) ? null : this.outlineResolver.getClipPath();
            final Function2<? super Canvas, ? super GraphicsLayer, Unit> function2 = this.drawBlock;
            if (function2 != null) {
                this.renderNode.record(this.canvasHolder, clipPath, new Function1<Canvas, Unit>() { // from class: androidx.compose.ui.platform.RenderNodeLayer$updateDisplayList$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                        invoke2(canvas);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Canvas canvas) {
                        function2.invoke(canvas, null);
                    }
                });
            }
            setDirty(false);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateLayerProperties(ReusableGraphicsLayerScope scope) {
        Function0<Unit> function0;
        int mutatedFields = scope.getMutatedFields() | this.mutatedFields;
        int i5 = mutatedFields & 4096;
        if (i5 != 0) {
            this.transformOrigin = scope.getTransformOrigin();
        }
        boolean z5 = false;
        boolean z6 = this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported();
        if ((mutatedFields & 1) != 0) {
            this.renderNode.setScaleX(scope.getScaleX());
        }
        if ((mutatedFields & 2) != 0) {
            this.renderNode.setScaleY(scope.getScaleY());
        }
        if ((mutatedFields & 4) != 0) {
            this.renderNode.setAlpha(scope.getAlpha());
        }
        if ((mutatedFields & 8) != 0) {
            this.renderNode.setTranslationX(scope.getTranslationX());
        }
        if ((mutatedFields & 16) != 0) {
            this.renderNode.setTranslationY(scope.getTranslationY());
        }
        if ((mutatedFields & 32) != 0) {
            this.renderNode.setElevation(scope.getShadowElevation());
        }
        if ((mutatedFields & 64) != 0) {
            this.renderNode.setAmbientShadowColor(ColorKt.m1508toArgb8_81llA(scope.getAmbientShadowColor()));
        }
        if ((mutatedFields & 128) != 0) {
            this.renderNode.setSpotShadowColor(ColorKt.m1508toArgb8_81llA(scope.getSpotShadowColor()));
        }
        if ((mutatedFields & 1024) != 0) {
            this.renderNode.setRotationZ(scope.getRotationZ());
        }
        if ((mutatedFields & 256) != 0) {
            this.renderNode.setRotationX(scope.getRotationX());
        }
        if ((mutatedFields & 512) != 0) {
            this.renderNode.setRotationY(scope.getRotationY());
        }
        if ((mutatedFields & 2048) != 0) {
            this.renderNode.setCameraDistance(scope.getCameraDistance());
        }
        if (i5 != 0) {
            this.renderNode.setPivotX(TransformOrigin.m1630getPivotFractionXimpl(this.transformOrigin) * this.renderNode.getWidth());
            this.renderNode.setPivotY(TransformOrigin.m1631getPivotFractionYimpl(this.transformOrigin) * this.renderNode.getHeight());
        }
        boolean z7 = scope.getClip() && scope.getShape() != RectangleShapeKt.getRectangleShape();
        if ((mutatedFields & 24576) != 0) {
            this.renderNode.setClipToOutline(z7);
            this.renderNode.setClipToBounds(scope.getClip() && scope.getShape() == RectangleShapeKt.getRectangleShape());
        }
        if ((131072 & mutatedFields) != 0) {
            DeviceRenderNode deviceRenderNode = this.renderNode;
            scope.getRenderEffect();
            deviceRenderNode.setRenderEffect(null);
        }
        if ((32768 & mutatedFields) != 0) {
            this.renderNode.mo2129setCompositingStrategyaDBOjCE(scope.getCompositingStrategy());
        }
        boolean m2150updateS_szKao = this.outlineResolver.m2150updateS_szKao(scope.getOutline(), scope.getAlpha(), z7, scope.getShadowElevation(), scope.getSize());
        if (this.outlineResolver.getCacheIsDirty()) {
            this.renderNode.setOutline(this.outlineResolver.getAndroidOutline());
        }
        if (z7 && !this.outlineResolver.getOutlineClipSupported()) {
            z5 = true;
        }
        if (z6 != z5 || (z5 && m2150updateS_szKao)) {
            invalidate();
        } else {
            triggerRepaint();
        }
        if (!this.drawnWithZ && this.renderNode.getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        if ((mutatedFields & 7963) != 0) {
            this.matrixCache.invalidate();
        }
        this.mutatedFields = scope.getMutatedFields();
    }
}
