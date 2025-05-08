package androidx.compose.ui.platform;

import android.os.Build;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BK\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u000b0\t\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0015\u0010\u0017\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u0012J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u001a\u0010'\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H\u0016ø\u0001\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010+\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020(H\u0016ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010/\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020,H\u0016ø\u0001\u0001¢\u0006\u0004\b.\u0010*J!\u00101\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u000bH\u0016¢\u0006\u0004\b3\u0010\u0012J\u000f\u00104\u001a\u00020\u000bH\u0016¢\u0006\u0004\b4\u0010\u0012J\u000f\u00105\u001a\u00020\u000bH\u0016¢\u0006\u0004\b5\u0010\u0012J\"\u0010:\u001a\u00020\"2\u0006\u00106\u001a\u00020\"2\u0006\u00107\u001a\u00020$H\u0016ø\u0001\u0001¢\u0006\u0004\b8\u00109J\u001f\u0010=\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020;2\u0006\u00107\u001a\u00020$H\u0016¢\u0006\u0004\b=\u0010>J9\u0010?\u001a\u00020\u000b2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016¢\u0006\u0004\b?\u0010@J\u001a\u0010D\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u0014H\u0016ø\u0001\u0001¢\u0006\u0004\bB\u0010CJ\u001a\u0010F\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u0014H\u0016ø\u0001\u0001¢\u0006\u0004\bE\u0010CR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010GR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010HR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010IR,\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010JR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010KR\u001c\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b-\u0010LR\u0016\u0010M\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020\u00148\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\bO\u0010PR\u001e\u0010Q\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\bQ\u0010PR$\u0010S\u001a\u00020$2\u0006\u0010R\u001a\u00020$8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bS\u0010N\"\u0004\bT\u0010UR\u0016\u0010W\u001a\u00020V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010\u001f\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010]R\u0016\u0010_\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u001c\u0010b\u001a\u00020a8\u0002@\u0002X\u0082\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\bb\u0010LR\u0018\u0010d\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010j\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010l\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010NR \u0010o\u001a\u000e\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020\u000b0m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010p\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006q"}, d2 = {"Landroidx/compose/ui/platform/GraphicsLayerOwnerLayer;", "Landroidx/compose/ui/node/OwnedLayer;", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "graphicsLayer", "Landroidx/compose/ui/graphics/GraphicsContext;", "context", "Landroidx/compose/ui/platform/AndroidComposeView;", "ownerView", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", BuildConfig.FLAVOR, "drawBlock", "Lkotlin/Function0;", "invalidateParentLayer", "<init>", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "triggerRepaint", "()V", "updateOutline", "Landroidx/compose/ui/graphics/Matrix;", "getMatrix-sQKQjiQ", "()[F", "getMatrix", "getInverseMatrix-3i98HWw", "getInverseMatrix", "updateMatrix", "canvas", "clipManually", "(Landroidx/compose/ui/graphics/Canvas;)V", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "scope", "updateLayerProperties", "(Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;)V", "Landroidx/compose/ui/geometry/Offset;", "position", BuildConfig.FLAVOR, "isInLayer-k-4lQ0M", "(J)Z", "isInLayer", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "move", "Landroidx/compose/ui/unit/IntSize;", "size", "resize-ozmzZPI", "resize", "parentLayer", "drawLayer", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "updateDisplayList", "invalidate", "destroy", "point", "inverse", "mapOffset-8S9VItk", "(JZ)J", "mapOffset", "Landroidx/compose/ui/geometry/MutableRect;", "rect", "mapBounds", "(Landroidx/compose/ui/geometry/MutableRect;Z)V", "reuseLayer", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "matrix", "transform-58bKbWc", "([F)V", "transform", "inverseTransform-58bKbWc", "inverseTransform", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "Landroidx/compose/ui/graphics/GraphicsContext;", "Landroidx/compose/ui/platform/AndroidComposeView;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function0;", "J", "isDestroyed", "Z", "matrixCache", "[F", "inverseMatrixCache", "value", "isDirty", "setDirty", "(Z)V", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", BuildConfig.FLAVOR, "mutatedFields", "I", "Landroidx/compose/ui/graphics/TransformOrigin;", "transformOrigin", "Landroidx/compose/ui/graphics/Outline;", "outline", "Landroidx/compose/ui/graphics/Outline;", "Landroidx/compose/ui/graphics/Path;", "tmpPath", "Landroidx/compose/ui/graphics/Path;", "Landroidx/compose/ui/graphics/Paint;", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "drawnWithEnabledZ", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "recordLambda", "Lkotlin/jvm/functions/Function1;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphicsLayerOwnerLayer implements OwnedLayer {
    private final GraphicsContext context;
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithEnabledZ;
    private GraphicsLayer graphicsLayer;
    private Function0<Unit> invalidateParentLayer;
    private float[] inverseMatrixCache;
    private boolean isDestroyed;
    private boolean isDirty;
    private int mutatedFields;
    private Outline outline;
    private final AndroidComposeView ownerView;
    private Paint softwareLayerPaint;
    private Path tmpPath;
    private long size = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private final float[] matrixCache = Matrix.m1547constructorimpl$default(null, 1, null);
    private Density density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private final CanvasDrawScope scope = new CanvasDrawScope();
    private long transformOrigin = TransformOrigin.INSTANCE.m1635getCenterSzJe1aQ();
    private final Function1<DrawScope, Unit> recordLambda = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.platform.GraphicsLayerOwnerLayer$recordLambda$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
            invoke2(drawScope);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DrawScope drawScope) {
            Function2 function2;
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = GraphicsLayerOwnerLayer.this;
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            function2 = graphicsLayerOwnerLayer.drawBlock;
            if (function2 != null) {
                function2.invoke(canvas, drawScope.getDrawContext().getGraphicsLayer());
            }
        }
    };

    public GraphicsLayerOwnerLayer(GraphicsLayer graphicsLayer, GraphicsContext graphicsContext, AndroidComposeView androidComposeView, Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        this.graphicsLayer = graphicsLayer;
        this.context = graphicsContext;
        this.ownerView = androidComposeView;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
    }

    private final void clipManually(Canvas canvas) {
        if (this.graphicsLayer.getClip()) {
            Outline outline = this.graphicsLayer.getOutline();
            if (outline instanceof Outline.Rectangle) {
                Canvas.m1475clipRectmtrdDE$default(canvas, ((Outline.Rectangle) outline).getRect(), 0, 2, null);
                return;
            }
            if (!(outline instanceof Outline.Rounded)) {
                if (outline instanceof Outline.Generic) {
                    Canvas.m1473clipPathmtrdDE$default(canvas, ((Outline.Generic) outline).getPath(), 0, 2, null);
                    return;
                }
                return;
            }
            Path path = this.tmpPath;
            if (path == null) {
                path = AndroidPath_androidKt.Path();
                this.tmpPath = path;
            }
            path.reset();
            Path.addRoundRect$default(path, ((Outline.Rounded) outline).getRoundRect(), null, 2, null);
            Canvas.m1473clipPathmtrdDE$default(canvas, path, 0, 2, null);
        }
    }

    /* renamed from: getInverseMatrix-3i98HWw, reason: not valid java name */
    private final float[] m2136getInverseMatrix3i98HWw() {
        float[] m2137getMatrixsQKQjiQ = m2137getMatrixsQKQjiQ();
        float[] fArr = this.inverseMatrixCache;
        if (fArr == null) {
            fArr = Matrix.m1547constructorimpl$default(null, 1, null);
            this.inverseMatrixCache = fArr;
        }
        if (InvertMatrixKt.m2138invertToJiSxe2E(m2137getMatrixsQKQjiQ, fArr)) {
            return fArr;
        }
        return null;
    }

    /* renamed from: getMatrix-sQKQjiQ, reason: not valid java name */
    private final float[] m2137getMatrixsQKQjiQ() {
        updateMatrix();
        return this.matrixCache;
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

    private final void updateMatrix() {
        GraphicsLayer graphicsLayer = this.graphicsLayer;
        long m1385getCenteruvyYCjk = OffsetKt.m1352isUnspecifiedk4lQ0M(graphicsLayer.getPivotOffset()) ? SizeKt.m1385getCenteruvyYCjk(IntSizeKt.m2668toSizeozmzZPI(this.size)) : graphicsLayer.getPivotOffset();
        Matrix.m1552resetimpl(this.matrixCache);
        float[] fArr = this.matrixCache;
        float[] m1547constructorimpl$default = Matrix.m1547constructorimpl$default(null, 1, null);
        Matrix.m1561translateimpl$default(m1547constructorimpl$default, -Offset.m1337getXimpl(m1385getCenteruvyYCjk), -Offset.m1338getYimpl(m1385getCenteruvyYCjk), 0.0f, 4, null);
        Matrix.m1558timesAssign58bKbWc(fArr, m1547constructorimpl$default);
        float[] fArr2 = this.matrixCache;
        float[] m1547constructorimpl$default2 = Matrix.m1547constructorimpl$default(null, 1, null);
        Matrix.m1561translateimpl$default(m1547constructorimpl$default2, graphicsLayer.getTranslationX(), graphicsLayer.getTranslationY(), 0.0f, 4, null);
        Matrix.m1553rotateXimpl(m1547constructorimpl$default2, graphicsLayer.getRotationX());
        Matrix.m1554rotateYimpl(m1547constructorimpl$default2, graphicsLayer.getRotationY());
        Matrix.m1555rotateZimpl(m1547constructorimpl$default2, graphicsLayer.getRotationZ());
        Matrix.m1557scaleimpl$default(m1547constructorimpl$default2, graphicsLayer.getScaleX(), graphicsLayer.getScaleY(), 0.0f, 4, null);
        Matrix.m1558timesAssign58bKbWc(fArr2, m1547constructorimpl$default2);
        float[] fArr3 = this.matrixCache;
        float[] m1547constructorimpl$default3 = Matrix.m1547constructorimpl$default(null, 1, null);
        Matrix.m1561translateimpl$default(m1547constructorimpl$default3, Offset.m1337getXimpl(m1385getCenteruvyYCjk), Offset.m1338getYimpl(m1385getCenteruvyYCjk), 0.0f, 4, null);
        Matrix.m1558timesAssign58bKbWc(fArr3, m1547constructorimpl$default3);
    }

    private final void updateOutline() {
        Function0<Unit> function0;
        Outline outline = this.outline;
        if (outline == null) {
            return;
        }
        GraphicsLayerKt.setOutline(this.graphicsLayer, outline);
        if (!(outline instanceof Outline.Generic) || Build.VERSION.SDK_INT >= 33 || (function0 = this.invalidateParentLayer) == null) {
            return;
        }
        function0.invoke();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext != null) {
            graphicsContext.releaseGraphicsLayer(this.graphicsLayer);
            this.ownerView.recycle$ui_release(this);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(Canvas canvas, GraphicsLayer parentLayer) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            this.drawnWithEnabledZ = this.graphicsLayer.getShadowElevation() > 0.0f;
            DrawContext drawContext = this.scope.getDrawContext();
            drawContext.setCanvas(canvas);
            drawContext.setGraphicsLayer(parentLayer);
            GraphicsLayerKt.drawLayer(this.scope, this.graphicsLayer);
            return;
        }
        float m2640getXimpl = IntOffset.m2640getXimpl(this.graphicsLayer.getTopLeft());
        float m2641getYimpl = IntOffset.m2641getYimpl(this.graphicsLayer.getTopLeft());
        float m2661getWidthimpl = m2640getXimpl + IntSize.m2661getWidthimpl(this.size);
        float m2660getHeightimpl = m2641getYimpl + IntSize.m2660getHeightimpl(this.size);
        if (this.graphicsLayer.getAlpha() < 1.0f) {
            Paint paint = this.softwareLayerPaint;
            if (paint == null) {
                paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = paint;
            }
            paint.setAlpha(this.graphicsLayer.getAlpha());
            nativeCanvas.saveLayer(m2640getXimpl, m2641getYimpl, m2661getWidthimpl, m2660getHeightimpl, paint.getInternalPaint());
        } else {
            canvas.save();
        }
        canvas.translate(m2640getXimpl, m2641getYimpl);
        canvas.mo1391concat58bKbWc(m2137getMatrixsQKQjiQ());
        if (this.graphicsLayer.getClip()) {
            clipManually(canvas);
        }
        Function2<? super Canvas, ? super GraphicsLayer, Unit> function2 = this.drawBlock;
        if (function2 != null) {
            function2.invoke(canvas, null);
        }
        canvas.restore();
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
        float[] m2136getInverseMatrix3i98HWw = m2136getInverseMatrix3i98HWw();
        if (m2136getInverseMatrix3i98HWw != null) {
            Matrix.m1558timesAssign58bKbWc(matrix, m2136getInverseMatrix3i98HWw);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: isInLayer-k-4lQ0M */
    public boolean mo2077isInLayerk4lQ0M(long position) {
        float m1337getXimpl = Offset.m1337getXimpl(position);
        float m1338getYimpl = Offset.m1338getYimpl(position);
        if (this.graphicsLayer.getClip()) {
            return ShapeContainingUtilKt.isInOutline$default(this.graphicsLayer.getOutline(), m1337getXimpl, m1338getYimpl, null, null, 24, null);
        }
        return true;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(MutableRect rect, boolean inverse) {
        if (!inverse) {
            Matrix.m1551mapimpl(m2137getMatrixsQKQjiQ(), rect);
            return;
        }
        float[] m2136getInverseMatrix3i98HWw = m2136getInverseMatrix3i98HWw();
        if (m2136getInverseMatrix3i98HWw == null) {
            rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            Matrix.m1551mapimpl(m2136getInverseMatrix3i98HWw, rect);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: mapOffset-8S9VItk */
    public long mo2078mapOffset8S9VItk(long point, boolean inverse) {
        if (!inverse) {
            return Matrix.m1550mapMKHz9U(m2137getMatrixsQKQjiQ(), point);
        }
        float[] m2136getInverseMatrix3i98HWw = m2136getInverseMatrix3i98HWw();
        return m2136getInverseMatrix3i98HWw != null ? Matrix.m1550mapMKHz9U(m2136getInverseMatrix3i98HWw, point) : Offset.INSTANCE.m1347getInfiniteF1C5BW0();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: move--gyyYBs */
    public void mo2079movegyyYBs(long position) {
        this.graphicsLayer.m1729setTopLeftgyyYBs(position);
        triggerRepaint();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: resize-ozmzZPI */
    public void mo2080resizeozmzZPI(long size) {
        if (IntSize.m2659equalsimpl0(size, this.size)) {
            return;
        }
        this.size = size;
        invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext == null) {
            throw new IllegalArgumentException("currently reuse is only supported when we manage the layer lifecycle");
        }
        if (!this.graphicsLayer.getIsReleased()) {
            throw new IllegalArgumentException("layer should have been released before reuse");
        }
        this.graphicsLayer = graphicsContext.createGraphicsLayer();
        this.isDestroyed = false;
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
        this.transformOrigin = TransformOrigin.INSTANCE.m1635getCenterSzJe1aQ();
        this.drawnWithEnabledZ = false;
        this.size = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.outline = null;
        this.mutatedFields = 0;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: transform-58bKbWc */
    public void mo2081transform58bKbWc(float[] matrix) {
        Matrix.m1558timesAssign58bKbWc(matrix, m2137getMatrixsQKQjiQ());
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.isDirty) {
            if (!TransformOrigin.m1629equalsimpl0(this.transformOrigin, TransformOrigin.INSTANCE.m1635getCenterSzJe1aQ()) && !IntSize.m2659equalsimpl0(this.graphicsLayer.getSize(), this.size)) {
                this.graphicsLayer.m1725setPivotOffsetk4lQ0M(OffsetKt.Offset(TransformOrigin.m1630getPivotFractionXimpl(this.transformOrigin) * IntSize.m2661getWidthimpl(this.size), TransformOrigin.m1631getPivotFractionYimpl(this.transformOrigin) * IntSize.m2660getHeightimpl(this.size)));
            }
            this.graphicsLayer.m1722recordmLhObY(this.density, this.layoutDirection, this.size, this.recordLambda);
            setDirty(false);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateLayerProperties(ReusableGraphicsLayerScope scope) {
        boolean z5;
        int m1713getModulateAlphake2Ky5w;
        Function0<Unit> function0;
        int mutatedFields = scope.getMutatedFields() | this.mutatedFields;
        this.layoutDirection = scope.getLayoutDirection();
        this.density = scope.getGraphicsDensity();
        int i5 = mutatedFields & 4096;
        if (i5 != 0) {
            this.transformOrigin = scope.getTransformOrigin();
        }
        if ((mutatedFields & 1) != 0) {
            this.graphicsLayer.setScaleX(scope.getScaleX());
        }
        if ((mutatedFields & 2) != 0) {
            this.graphicsLayer.setScaleY(scope.getScaleY());
        }
        if ((mutatedFields & 4) != 0) {
            this.graphicsLayer.setAlpha(scope.getAlpha());
        }
        if ((mutatedFields & 8) != 0) {
            this.graphicsLayer.setTranslationX(scope.getTranslationX());
        }
        if ((mutatedFields & 16) != 0) {
            this.graphicsLayer.setTranslationY(scope.getTranslationY());
        }
        if ((mutatedFields & 32) != 0) {
            this.graphicsLayer.setShadowElevation(scope.getShadowElevation());
            if (scope.getShadowElevation() > 0.0f && !this.drawnWithEnabledZ && (function0 = this.invalidateParentLayer) != null) {
                function0.invoke();
            }
        }
        if ((mutatedFields & 64) != 0) {
            this.graphicsLayer.m1723setAmbientShadowColor8_81llA(scope.getAmbientShadowColor());
        }
        if ((mutatedFields & 128) != 0) {
            this.graphicsLayer.m1728setSpotShadowColor8_81llA(scope.getSpotShadowColor());
        }
        if ((mutatedFields & 1024) != 0) {
            this.graphicsLayer.setRotationZ(scope.getRotationZ());
        }
        if ((mutatedFields & 256) != 0) {
            this.graphicsLayer.setRotationX(scope.getRotationX());
        }
        if ((mutatedFields & 512) != 0) {
            this.graphicsLayer.setRotationY(scope.getRotationY());
        }
        if ((mutatedFields & 2048) != 0) {
            this.graphicsLayer.setCameraDistance(scope.getCameraDistance());
        }
        if (i5 != 0) {
            if (TransformOrigin.m1629equalsimpl0(this.transformOrigin, TransformOrigin.INSTANCE.m1635getCenterSzJe1aQ())) {
                this.graphicsLayer.m1725setPivotOffsetk4lQ0M(Offset.INSTANCE.m1348getUnspecifiedF1C5BW0());
            } else {
                this.graphicsLayer.m1725setPivotOffsetk4lQ0M(OffsetKt.Offset(TransformOrigin.m1630getPivotFractionXimpl(this.transformOrigin) * IntSize.m2661getWidthimpl(this.size), TransformOrigin.m1631getPivotFractionYimpl(this.transformOrigin) * IntSize.m2660getHeightimpl(this.size)));
            }
        }
        if ((mutatedFields & 16384) != 0) {
            this.graphicsLayer.setClip(scope.getClip());
        }
        if ((131072 & mutatedFields) != 0) {
            GraphicsLayer graphicsLayer = this.graphicsLayer;
            scope.getRenderEffect();
            graphicsLayer.setRenderEffect(null);
        }
        if ((32768 & mutatedFields) != 0) {
            GraphicsLayer graphicsLayer2 = this.graphicsLayer;
            int compositingStrategy = scope.getCompositingStrategy();
            CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
            if (CompositingStrategy.m1510equalsimpl0(compositingStrategy, companion.m1513getAutoNrFUSI())) {
                m1713getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.INSTANCE.m1712getAutoke2Ky5w();
            } else if (CompositingStrategy.m1510equalsimpl0(compositingStrategy, companion.m1515getOffscreenNrFUSI())) {
                m1713getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.INSTANCE.m1714getOffscreenke2Ky5w();
            } else {
                if (!CompositingStrategy.m1510equalsimpl0(compositingStrategy, companion.m1514getModulateAlphaNrFUSI())) {
                    throw new IllegalStateException("Not supported composition strategy");
                }
                m1713getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.INSTANCE.m1713getModulateAlphake2Ky5w();
            }
            graphicsLayer2.m1724setCompositingStrategyWpw9cng(m1713getModulateAlphake2Ky5w);
        }
        if (Intrinsics.areEqual(this.outline, scope.getOutline())) {
            z5 = false;
        } else {
            this.outline = scope.getOutline();
            updateOutline();
            z5 = true;
        }
        this.mutatedFields = scope.getMutatedFields();
        if (mutatedFields != 0 || z5) {
            triggerRepaint();
        }
    }
}
