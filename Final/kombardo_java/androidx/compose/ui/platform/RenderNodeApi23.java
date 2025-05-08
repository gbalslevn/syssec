package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b6\b\u0001\u0018\u0000 \u0089\u00012\u00020\u0001:\u0002\u0089\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ5\u0010$\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00060!H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u0016H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b1\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00102\u001a\u0004\b3\u00104R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u00105R\u001c\u00107\u001a\u0002068\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010\u001bR\"\u0010\u0013\u001a\u00020\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u00108\u001a\u0004\b<\u0010:\"\u0004\b=\u0010\u001bR\"\u0010\u0014\u001a\u00020\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u00108\u001a\u0004\b>\u0010:\"\u0004\b?\u0010\u001bR\"\u0010\u0015\u001a\u00020\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u00108\u001a\u0004\b@\u0010:\"\u0004\bA\u0010\u001bR$\u0010C\u001a\u0004\u0018\u00010B8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR*\u0010J\u001a\u00020\u00162\u0006\u0010I\u001a\u00020\u00168\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010:R\u0014\u0010S\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010:R$\u0010Y\u001a\u00020T2\u0006\u0010I\u001a\u00020T8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010\\\u001a\u00020T2\u0006\u0010I\u001a\u00020T8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bZ\u0010V\"\u0004\b[\u0010XR$\u0010_\u001a\u00020T2\u0006\u0010I\u001a\u00020T8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b]\u0010V\"\u0004\b^\u0010XR$\u0010b\u001a\u00020T2\u0006\u0010I\u001a\u00020T8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b`\u0010V\"\u0004\ba\u0010XR$\u0010e\u001a\u00020T2\u0006\u0010I\u001a\u00020T8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bc\u0010V\"\u0004\bd\u0010XR$\u0010h\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bf\u0010:\"\u0004\bg\u0010\u001bR$\u0010k\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bi\u0010:\"\u0004\bj\u0010\u001bR$\u0010n\u001a\u00020T2\u0006\u0010I\u001a\u00020T8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bl\u0010V\"\u0004\bm\u0010XR$\u0010q\u001a\u00020T2\u0006\u0010I\u001a\u00020T8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bo\u0010V\"\u0004\bp\u0010XR$\u0010t\u001a\u00020T2\u0006\u0010I\u001a\u00020T8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\br\u0010V\"\u0004\bs\u0010XR$\u0010w\u001a\u00020T2\u0006\u0010I\u001a\u00020T8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bu\u0010V\"\u0004\bv\u0010XR$\u0010z\u001a\u00020T2\u0006\u0010I\u001a\u00020T8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bx\u0010V\"\u0004\by\u0010XR$\u0010}\u001a\u00020T2\u0006\u0010I\u001a\u00020T8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b{\u0010V\"\u0004\b|\u0010XR%\u0010\u0080\u0001\u001a\u00020\u00162\u0006\u0010I\u001a\u00020\u00168V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b~\u0010M\"\u0004\b\u007f\u0010OR'\u0010\u0083\u0001\u001a\u00020T2\u0006\u0010I\u001a\u00020T8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0081\u0001\u0010V\"\u0005\b\u0082\u0001\u0010XR-\u0010\u0086\u0001\u001a\u0002062\u0006\u0010I\u001a\u0002068V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\u001a\u0005\b\u0084\u0001\u0010:\"\u0005\b\u0085\u0001\u0010\u001bR\u0016\u0010\u0088\u0001\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010M\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u008a\u0001"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeApi23;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "Landroidx/compose/ui/platform/AndroidComposeView;", "ownerView", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", BuildConfig.FLAVOR, "discardDisplayListInternal", "()V", "Landroid/view/RenderNode;", "renderNode", "verifyShadowColorProperties", "(Landroid/view/RenderNode;)V", "Landroid/graphics/Outline;", "outline", "setOutline", "(Landroid/graphics/Outline;)V", BuildConfig.FLAVOR, "left", "top", "right", "bottom", BuildConfig.FLAVOR, "setPosition", "(IIII)Z", "offset", "offsetLeftAndRight", "(I)V", "offsetTopAndBottom", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/Path;", "clipPath", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "drawBlock", "record", "(Landroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/Path;Lkotlin/jvm/functions/Function1;)V", "Landroid/graphics/Matrix;", "matrix", "getMatrix", "(Landroid/graphics/Matrix;)V", "Landroid/graphics/Canvas;", "canvas", "drawInto", "(Landroid/graphics/Canvas;)V", "hasOverlappingRendering", "setHasOverlappingRendering", "(Z)Z", "discardDisplayList", "Landroidx/compose/ui/platform/AndroidComposeView;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/RenderNode;", "Landroidx/compose/ui/graphics/CompositingStrategy;", "internalCompositingStrategy", "I", "getLeft", "()I", "setLeft", "getTop", "setTop", "getRight", "setRight", "getBottom", "setBottom", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "value", "clipToBounds", "Z", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "getWidth", "width", "getHeight", "height", BuildConfig.FLAVOR, "getScaleX", "()F", "setScaleX", "(F)V", "scaleX", "getScaleY", "setScaleY", "scaleY", "getTranslationX", "setTranslationX", "translationX", "getTranslationY", "setTranslationY", "translationY", "getElevation", "setElevation", "elevation", "getAmbientShadowColor", "setAmbientShadowColor", "ambientShadowColor", "getSpotShadowColor", "setSpotShadowColor", "spotShadowColor", "getRotationZ", "setRotationZ", "rotationZ", "getRotationX", "setRotationX", "rotationX", "getRotationY", "setRotationY", "rotationY", "getCameraDistance", "setCameraDistance", "cameraDistance", "getPivotX", "setPivotX", "pivotX", "getPivotY", "setPivotY", "pivotY", "getClipToOutline", "setClipToOutline", "clipToOutline", "getAlpha", "setAlpha", "alpha", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "compositingStrategy", "getHasDisplayList", "hasDisplayList", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RenderNodeApi23 implements DeviceRenderNode {
    private static boolean testFailCreateRenderNode;
    private int bottom;
    private boolean clipToBounds;
    private int internalCompositingStrategy;
    private int left;
    private final AndroidComposeView ownerView;
    private RenderEffect renderEffect;
    private final RenderNode renderNode;
    private int right;
    private int top;
    public static final int $stable = 8;
    private static boolean needToValidateAccess = true;

    public RenderNodeApi23(AndroidComposeView androidComposeView) {
        this.ownerView = androidComposeView;
        RenderNode create = RenderNode.create("Compose", androidComposeView);
        this.renderNode = create;
        this.internalCompositingStrategy = CompositingStrategy.INSTANCE.m1513getAutoNrFUSI();
        if (needToValidateAccess) {
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
            discardDisplayListInternal();
            create.setLayerType(0);
            create.setHasOverlappingRendering(create.hasOverlappingRendering());
            needToValidateAccess = false;
        }
        if (testFailCreateRenderNode) {
            throw new NoClassDefFoundError();
        }
    }

    private final void discardDisplayListInternal() {
        RenderNodeVerificationHelper24.INSTANCE.discardDisplayList(this.renderNode);
    }

    private final void verifyShadowColorProperties(RenderNode renderNode) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28 renderNodeVerificationHelper28 = RenderNodeVerificationHelper28.INSTANCE;
            renderNodeVerificationHelper28.setAmbientShadowColor(renderNode, renderNodeVerificationHelper28.getAmbientShadowColor(renderNode));
            renderNodeVerificationHelper28.setSpotShadowColor(renderNode, renderNodeVerificationHelper28.getSpotShadowColor(renderNode));
        }
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void discardDisplayList() {
        discardDisplayListInternal();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void drawInto(Canvas canvas) {
        Intrinsics.checkNotNull(canvas, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        ((DisplayListCanvas) canvas).drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getBottom() {
        return this.bottom;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getClipToBounds() {
        return this.clipToBounds;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getClipToOutline() {
        return this.renderNode.getClipToOutline();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getElevation() {
        return this.renderNode.getElevation();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getHasDisplayList() {
        return this.renderNode.isValid();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getHeight() {
        return getBottom() - getTop();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getLeft() {
        return this.left;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void getMatrix(Matrix matrix) {
        this.renderNode.getMatrix(matrix);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getRight() {
        return this.right;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getTop() {
        return this.top;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getWidth() {
        return getRight() - getLeft();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetLeftAndRight(int offset) {
        setLeft(getLeft() + offset);
        setRight(getRight() + offset);
        this.renderNode.offsetLeftAndRight(offset);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetTopAndBottom(int offset) {
        setTop(getTop() + offset);
        setBottom(getBottom() + offset);
        this.renderNode.offsetTopAndBottom(offset);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void record(CanvasHolder canvasHolder, Path clipPath, Function1<? super androidx.compose.ui.graphics.Canvas, Unit> drawBlock) {
        DisplayListCanvas start = this.renderNode.start(getWidth(), getHeight());
        Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas((Canvas) start);
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
        this.renderNode.end(start);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAlpha(float f5) {
        this.renderNode.setAlpha(f5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAmbientShadowColor(int i5) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(this.renderNode, i5);
        }
    }

    public void setBottom(int i5) {
        this.bottom = i5;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setCameraDistance(float f5) {
        this.renderNode.setCameraDistance(-f5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setClipToBounds(boolean z5) {
        this.clipToBounds = z5;
        this.renderNode.setClipToBounds(z5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setClipToOutline(boolean z5) {
        this.renderNode.setClipToOutline(z5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    /* renamed from: setCompositingStrategy-aDBOjCE */
    public void mo2129setCompositingStrategyaDBOjCE(int i5) {
        CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
        if (CompositingStrategy.m1510equalsimpl0(i5, companion.m1515getOffscreenNrFUSI())) {
            this.renderNode.setLayerType(2);
            this.renderNode.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.m1510equalsimpl0(i5, companion.m1514getModulateAlphaNrFUSI())) {
            this.renderNode.setLayerType(0);
            this.renderNode.setHasOverlappingRendering(false);
        } else {
            this.renderNode.setLayerType(0);
            this.renderNode.setHasOverlappingRendering(true);
        }
        this.internalCompositingStrategy = i5;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setElevation(float f5) {
        this.renderNode.setElevation(f5);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean setHasOverlappingRendering(boolean hasOverlappingRendering) {
        return this.renderNode.setHasOverlappingRendering(hasOverlappingRendering);
    }

    public void setLeft(int i5) {
        this.left = i5;
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
        setLeft(left);
        setTop(top);
        setRight(right);
        setBottom(bottom);
        return this.renderNode.setLeftTopRightBottom(left, top, right, bottom);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRenderEffect(RenderEffect renderEffect) {
    }

    public void setRight(int i5) {
        this.right = i5;
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
        this.renderNode.setRotation(f5);
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
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(this.renderNode, i5);
        }
    }

    public void setTop(int i5) {
        this.top = i5;
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
