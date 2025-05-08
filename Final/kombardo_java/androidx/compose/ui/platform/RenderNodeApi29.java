package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import f.AbstractC0339a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b@\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0015J5\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\b0\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\bH\u0016¢\u0006\u0004\b+\u0010,R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001c\u00107\u001a\u0002068\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010\f\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010\r\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010:R\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010:R\u0014\u0010\u000f\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010:R\u0014\u0010?\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010:R\u0014\u0010A\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010:R$\u0010H\u001a\u00020B2\u0006\u0010C\u001a\u00020B8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010K\u001a\u00020B2\u0006\u0010C\u001a\u00020B8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010GR$\u0010N\u001a\u00020B2\u0006\u0010C\u001a\u00020B8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bL\u0010E\"\u0004\bM\u0010GR$\u0010Q\u001a\u00020B2\u0006\u0010C\u001a\u00020B8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bO\u0010E\"\u0004\bP\u0010GR$\u0010T\u001a\u00020B2\u0006\u0010C\u001a\u00020B8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bR\u0010E\"\u0004\bS\u0010GR$\u0010W\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bU\u0010:\"\u0004\bV\u0010\u0015R$\u0010Z\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bX\u0010:\"\u0004\bY\u0010\u0015R$\u0010]\u001a\u00020B2\u0006\u0010C\u001a\u00020B8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b[\u0010E\"\u0004\b\\\u0010GR$\u0010`\u001a\u00020B2\u0006\u0010C\u001a\u00020B8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b^\u0010E\"\u0004\b_\u0010GR$\u0010c\u001a\u00020B2\u0006\u0010C\u001a\u00020B8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\ba\u0010E\"\u0004\bb\u0010GR$\u0010f\u001a\u00020B2\u0006\u0010C\u001a\u00020B8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bd\u0010E\"\u0004\be\u0010GR$\u0010i\u001a\u00020B2\u0006\u0010C\u001a\u00020B8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bg\u0010E\"\u0004\bh\u0010GR$\u0010l\u001a\u00020B2\u0006\u0010C\u001a\u00020B8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bj\u0010E\"\u0004\bk\u0010GR$\u0010q\u001a\u00020\u00102\u0006\u0010C\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR$\u0010t\u001a\u00020\u00102\u0006\u0010C\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\f\u001a\u0004\br\u0010n\"\u0004\bs\u0010pR$\u0010w\u001a\u00020B2\u0006\u0010C\u001a\u00020B8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bu\u0010E\"\u0004\bv\u0010GR(\u0010|\u001a\u0004\u0018\u0001032\b\u0010C\u001a\u0004\u0018\u0001038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R*\u0010\u007f\u001a\u0002062\u0006\u0010C\u001a\u0002068V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b}\u0010:\"\u0004\b~\u0010\u0015R\u0016\u0010\u0081\u0001\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0082\u0001"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeApi29;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "Landroidx/compose/ui/platform/AndroidComposeView;", "ownerView", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "Landroid/graphics/Outline;", "outline", BuildConfig.FLAVOR, "setOutline", "(Landroid/graphics/Outline;)V", BuildConfig.FLAVOR, "left", "top", "right", "bottom", BuildConfig.FLAVOR, "setPosition", "(IIII)Z", "offset", "offsetLeftAndRight", "(I)V", "offsetTopAndBottom", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/Path;", "clipPath", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "drawBlock", "record", "(Landroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/Path;Lkotlin/jvm/functions/Function1;)V", "Landroid/graphics/Matrix;", "matrix", "getMatrix", "(Landroid/graphics/Matrix;)V", "Landroid/graphics/Canvas;", "canvas", "drawInto", "(Landroid/graphics/Canvas;)V", "hasOverlappingRendering", "setHasOverlappingRendering", "(Z)Z", "discardDisplayList", "()V", "Landroidx/compose/ui/platform/AndroidComposeView;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/graphics/RenderNode;", "renderNode", "Landroid/graphics/RenderNode;", "Landroidx/compose/ui/graphics/RenderEffect;", "internalRenderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "Landroidx/compose/ui/graphics/CompositingStrategy;", "internalCompositingStrategy", "I", "getLeft", "()I", "getTop", "getRight", "getBottom", "getWidth", "width", "getHeight", "height", BuildConfig.FLAVOR, "value", "getScaleX", "()F", "setScaleX", "(F)V", "scaleX", "getScaleY", "setScaleY", "scaleY", "getTranslationX", "setTranslationX", "translationX", "getTranslationY", "setTranslationY", "translationY", "getElevation", "setElevation", "elevation", "getAmbientShadowColor", "setAmbientShadowColor", "ambientShadowColor", "getSpotShadowColor", "setSpotShadowColor", "spotShadowColor", "getRotationZ", "setRotationZ", "rotationZ", "getRotationX", "setRotationX", "rotationX", "getRotationY", "setRotationY", "rotationY", "getCameraDistance", "setCameraDistance", "cameraDistance", "getPivotX", "setPivotX", "pivotX", "getPivotY", "setPivotY", "pivotY", "getClipToOutline", "()Z", "setClipToOutline", "(Z)V", "clipToOutline", "getClipToBounds", "setClipToBounds", "clipToBounds", "getAlpha", "setAlpha", "alpha", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderEffect", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "compositingStrategy", "getHasDisplayList", "hasDisplayList", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RenderNodeApi29 implements DeviceRenderNode {
    private RenderEffect internalRenderEffect;
    private final AndroidComposeView ownerView;
    private final RenderNode renderNode = AbstractC0339a.a("Compose");
    private int internalCompositingStrategy = CompositingStrategy.INSTANCE.m1513getAutoNrFUSI();

    public RenderNodeApi29(AndroidComposeView androidComposeView) {
        this.ownerView = androidComposeView;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void discardDisplayList() {
        this.renderNode.discardDisplayList();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void drawInto(Canvas canvas) {
        canvas.drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getAlpha() {
        float alpha;
        alpha = this.renderNode.getAlpha();
        return alpha;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getBottom() {
        int bottom;
        bottom = this.renderNode.getBottom();
        return bottom;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getClipToBounds() {
        boolean clipToBounds;
        clipToBounds = this.renderNode.getClipToBounds();
        return clipToBounds;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getClipToOutline() {
        boolean clipToOutline;
        clipToOutline = this.renderNode.getClipToOutline();
        return clipToOutline;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getElevation() {
        float elevation;
        elevation = this.renderNode.getElevation();
        return elevation;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getHasDisplayList() {
        boolean hasDisplayList;
        hasDisplayList = this.renderNode.hasDisplayList();
        return hasDisplayList;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getHeight() {
        int height;
        height = this.renderNode.getHeight();
        return height;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getLeft() {
        int left;
        left = this.renderNode.getLeft();
        return left;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void getMatrix(Matrix matrix) {
        this.renderNode.getMatrix(matrix);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getRight() {
        int right;
        right = this.renderNode.getRight();
        return right;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getTop() {
        int top;
        top = this.renderNode.getTop();
        return top;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getWidth() {
        int width;
        width = this.renderNode.getWidth();
        return width;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetLeftAndRight(int offset) {
        this.renderNode.offsetLeftAndRight(offset);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetTopAndBottom(int offset) {
        this.renderNode.offsetTopAndBottom(offset);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void record(CanvasHolder canvasHolder, Path clipPath, Function1<? super androidx.compose.ui.graphics.Canvas, Unit> drawBlock) {
        RecordingCanvas beginRecording;
        beginRecording = this.renderNode.beginRecording();
        Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(beginRecording);
        AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
        if (clipPath != null) {
            androidCanvas.save();
            androidx.compose.ui.graphics.Canvas.m1473clipPathmtrdDE$default(androidCanvas, clipPath, 0, 2, null);
        }
        drawBlock.invoke(androidCanvas);
        if (clipPath != null) {
            androidCanvas.restore();
        }
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        this.renderNode.endRecording();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAlpha(float f5) {
        this.renderNode.setAlpha(f5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAmbientShadowColor(int i5) {
        this.renderNode.setAmbientShadowColor(i5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setCameraDistance(float f5) {
        this.renderNode.setCameraDistance(f5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setClipToBounds(boolean z5) {
        this.renderNode.setClipToBounds(z5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setClipToOutline(boolean z5) {
        this.renderNode.setClipToOutline(z5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    /* renamed from: setCompositingStrategy-aDBOjCE */
    public void mo2129setCompositingStrategyaDBOjCE(int i5) {
        RenderNode renderNode = this.renderNode;
        CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
        if (CompositingStrategy.m1510equalsimpl0(i5, companion.m1515getOffscreenNrFUSI())) {
            renderNode.setUseCompositingLayer(true, null);
            renderNode.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.m1510equalsimpl0(i5, companion.m1514getModulateAlphaNrFUSI())) {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(true);
        }
        this.internalCompositingStrategy = i5;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setElevation(float f5) {
        this.renderNode.setElevation(f5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean setHasOverlappingRendering(boolean hasOverlappingRendering) {
        boolean hasOverlappingRendering2;
        hasOverlappingRendering2 = this.renderNode.setHasOverlappingRendering(hasOverlappingRendering);
        return hasOverlappingRendering2;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setOutline(Outline outline) {
        this.renderNode.setOutline(outline);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setPivotX(float f5) {
        this.renderNode.setPivotX(f5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setPivotY(float f5) {
        this.renderNode.setPivotY(f5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean setPosition(int left, int top, int right, int bottom) {
        boolean position;
        position = this.renderNode.setPosition(left, top, right, bottom);
        return position;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRenderEffect(RenderEffect renderEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            RenderNodeApi29VerificationHelper.INSTANCE.setRenderEffect(this.renderNode, renderEffect);
        }
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRotationX(float f5) {
        this.renderNode.setRotationX(f5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRotationY(float f5) {
        this.renderNode.setRotationY(f5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRotationZ(float f5) {
        this.renderNode.setRotationZ(f5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setScaleX(float f5) {
        this.renderNode.setScaleX(f5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setScaleY(float f5) {
        this.renderNode.setScaleY(f5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setSpotShadowColor(int i5) {
        this.renderNode.setSpotShadowColor(i5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setTranslationX(float f5) {
        this.renderNode.setTranslationX(f5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setTranslationY(float f5) {
        this.renderNode.setTranslationY(f5);
    }
}
