package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001e\b\u0000\u0018\u0000 @2\u00020\u0001:\u0001@B#\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ;\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b \u0010!J7\u0010(\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#H\u0014¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0016H\u0016¢\u0006\u0004\b*\u0010\u001bR\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010.\u001a\u0004\b/\u00100R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00101R\"\u00102\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b2\u0010\u001d\"\u0004\b4\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R*\u00109\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b8\u0000@@X\u0080\u000e¢\u0006\u0012\n\u0004\b9\u00103\u001a\u0004\b:\u0010\u001d\"\u0004\b;\u00105R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010<R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010=R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010>R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010?¨\u0006A"}, d2 = {"Landroidx/compose/ui/graphics/layer/ViewLayer;", "Landroid/view/View;", "ownerView", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "canvasDrawScope", "<init>", "(Landroid/view/View;Landroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "Landroid/graphics/Outline;", "outline", BuildConfig.FLAVOR, "setLayerOutline", "(Landroid/graphics/Outline;)Z", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", BuildConfig.FLAVOR, "drawBlock", "setDrawParams", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/jvm/functions/Function1;)V", "invalidate", "()V", "hasOverlappingRendering", "()Z", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "changed", BuildConfig.FLAVOR, "l", "t", "r", "b", "onLayout", "(ZIIII)V", "forceLayout", "Landroid/view/View;", "getOwnerView", "()Landroid/view/View;", "Landroidx/compose/ui/graphics/CanvasHolder;", "getCanvasHolder", "()Landroidx/compose/ui/graphics/CanvasHolder;", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "isInvalidated", "Z", "setInvalidated", "(Z)V", "layerOutline", "Landroid/graphics/Outline;", "value", "canUseCompositingLayer", "getCanUseCompositingLayer$ui_graphics_release", "setCanUseCompositingLayer$ui_graphics_release", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/LayoutDirection;", "Lkotlin/jvm/functions/Function1;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ViewLayer extends View {
    private static final ViewOutlineProvider LayerOutlineProvider = new ViewOutlineProvider() { // from class: androidx.compose.ui.graphics.layer.ViewLayer$Companion$LayerOutlineProvider$1
        /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
        
            r2 = ((androidx.compose.ui.graphics.layer.ViewLayer) r2).layerOutline;
         */
        @Override // android.view.ViewOutlineProvider
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void getOutline(View view, Outline outline) {
            Outline outline2;
            if (!(view instanceof ViewLayer) || outline2 == null) {
                return;
            }
            outline.set(outline2);
        }
    };
    private boolean canUseCompositingLayer;
    private final CanvasDrawScope canvasDrawScope;
    private final CanvasHolder canvasHolder;
    private Density density;
    private Function1<? super DrawScope, Unit> drawBlock;
    private boolean isInvalidated;
    private Outline layerOutline;
    private LayoutDirection layoutDirection;
    private final View ownerView;
    private GraphicsLayer parentLayer;

    public ViewLayer(View view, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        super(view.getContext());
        this.ownerView = view;
        this.canvasHolder = canvasHolder;
        this.canvasDrawScope = canvasDrawScope;
        setOutlineProvider(LayerOutlineProvider);
        this.canUseCompositingLayer = true;
        this.density = DrawContextKt.getDefaultDensity();
        this.layoutDirection = LayoutDirection.Ltr;
        this.drawBlock = GraphicsLayerImpl.INSTANCE.getDefaultDrawBlock();
        setWillNotDraw(false);
        setClipBounds(null);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        CanvasHolder canvasHolder = this.canvasHolder;
        Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
        AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
        CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
        Density density = this.density;
        LayoutDirection layoutDirection = this.layoutDirection;
        long Size = SizeKt.Size(getWidth(), getHeight());
        GraphicsLayer graphicsLayer = this.parentLayer;
        Function1<? super DrawScope, Unit> function1 = this.drawBlock;
        Density density2 = canvasDrawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = canvasDrawScope.getDrawContext().getLayoutDirection();
        androidx.compose.ui.graphics.Canvas canvas2 = canvasDrawScope.getDrawContext().getCanvas();
        long mo1682getSizeNHjbRc = canvasDrawScope.getDrawContext().mo1682getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = canvasDrawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = canvasDrawScope.getDrawContext();
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(androidCanvas);
        drawContext.mo1683setSizeuvyYCjk(Size);
        drawContext.setGraphicsLayer(graphicsLayer);
        androidCanvas.save();
        try {
            function1.invoke(canvasDrawScope);
            androidCanvas.restore();
            DrawContext drawContext2 = canvasDrawScope.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer2);
            canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
            this.isInvalidated = false;
        } catch (Throwable th) {
            androidCanvas.restore();
            DrawContext drawContext3 = canvasDrawScope.getDrawContext();
            drawContext3.setDensity(density2);
            drawContext3.setLayoutDirection(layoutDirection2);
            drawContext3.setCanvas(canvas2);
            drawContext3.mo1683setSizeuvyYCjk(mo1682getSizeNHjbRc);
            drawContext3.setGraphicsLayer(graphicsLayer2);
            throw th;
        }
    }

    @Override // android.view.View
    public void forceLayout() {
    }

    /* renamed from: getCanUseCompositingLayer$ui_graphics_release, reason: from getter */
    public final boolean getCanUseCompositingLayer() {
        return this.canUseCompositingLayer;
    }

    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    public final View getOwnerView() {
        return this.ownerView;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return this.canUseCompositingLayer;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.isInvalidated) {
            return;
        }
        this.isInvalidated = true;
        super.invalidate();
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int l5, int t5, int r5, int b5) {
    }

    public final void setCanUseCompositingLayer$ui_graphics_release(boolean z5) {
        if (this.canUseCompositingLayer != z5) {
            this.canUseCompositingLayer = z5;
            invalidate();
        }
    }

    public final void setDrawParams(Density density, LayoutDirection layoutDirection, GraphicsLayer parentLayer, Function1<? super DrawScope, Unit> drawBlock) {
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.drawBlock = drawBlock;
        this.parentLayer = parentLayer;
    }

    public final void setInvalidated(boolean z5) {
        this.isInvalidated = z5;
    }

    public final boolean setLayerOutline(Outline outline) {
        this.layerOutline = outline;
        return OutlineUtils.INSTANCE.rebuildOutline(this);
    }
}
