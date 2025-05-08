package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\u0011J5\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00040\u0017H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH&¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0004H&¢\u0006\u0004\b'\u0010(R\u0014\u0010\b\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010\t\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010*R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010\u000b\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010*R\u0014\u0010/\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R\u0014\u00101\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010*R\u001c\u00107\u001a\u0002028&@&X¦\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010:\u001a\u0002028&@&X¦\u000e¢\u0006\f\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\u001c\u0010=\u001a\u0002028&@&X¦\u000e¢\u0006\f\u001a\u0004\b;\u00104\"\u0004\b<\u00106R\u001c\u0010@\u001a\u0002028&@&X¦\u000e¢\u0006\f\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\u001c\u0010C\u001a\u0002028&@&X¦\u000e¢\u0006\f\u001a\u0004\bA\u00104\"\u0004\bB\u00106R\u001c\u0010F\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\bD\u0010*\"\u0004\bE\u0010\u0011R\u001c\u0010I\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\bG\u0010*\"\u0004\bH\u0010\u0011R\u001c\u0010L\u001a\u0002028&@&X¦\u000e¢\u0006\f\u001a\u0004\bJ\u00104\"\u0004\bK\u00106R\u001c\u0010O\u001a\u0002028&@&X¦\u000e¢\u0006\f\u001a\u0004\bM\u00104\"\u0004\bN\u00106R\u001c\u0010R\u001a\u0002028&@&X¦\u000e¢\u0006\f\u001a\u0004\bP\u00104\"\u0004\bQ\u00106R\u001c\u0010U\u001a\u0002028&@&X¦\u000e¢\u0006\f\u001a\u0004\bS\u00104\"\u0004\bT\u00106R\u001c\u0010X\u001a\u0002028&@&X¦\u000e¢\u0006\f\u001a\u0004\bV\u00104\"\u0004\bW\u00106R\u001c\u0010[\u001a\u0002028&@&X¦\u000e¢\u0006\f\u001a\u0004\bY\u00104\"\u0004\bZ\u00106R\u001c\u0010`\u001a\u00020\f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001c\u0010c\u001a\u00020\f8&@&X¦\u000e¢\u0006\f\u001a\u0004\ba\u0010]\"\u0004\bb\u0010_R\u001c\u0010f\u001a\u0002028&@&X¦\u000e¢\u0006\f\u001a\u0004\bd\u00104\"\u0004\be\u00106R\u001e\u0010l\u001a\u0004\u0018\u00010g8&@&X¦\u000e¢\u0006\f\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0014\u0010n\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\bm\u0010]R\"\u0010r\u001a\u00020o8&@&X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bp\u0010*\"\u0004\bq\u0010\u0011ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006sÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/DeviceRenderNode;", BuildConfig.FLAVOR, "Landroid/graphics/Outline;", "outline", BuildConfig.FLAVOR, "setOutline", "(Landroid/graphics/Outline;)V", BuildConfig.FLAVOR, "left", "top", "right", "bottom", BuildConfig.FLAVOR, "setPosition", "(IIII)Z", "offset", "offsetLeftAndRight", "(I)V", "offsetTopAndBottom", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/Path;", "clipPath", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "drawBlock", "record", "(Landroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/Path;Lkotlin/jvm/functions/Function1;)V", "Landroid/graphics/Matrix;", "matrix", "getMatrix", "(Landroid/graphics/Matrix;)V", "Landroid/graphics/Canvas;", "canvas", "drawInto", "(Landroid/graphics/Canvas;)V", "hasOverlappingRendering", "setHasOverlappingRendering", "(Z)Z", "discardDisplayList", "()V", "getLeft", "()I", "getTop", "getRight", "getBottom", "getWidth", "width", "getHeight", "height", BuildConfig.FLAVOR, "getScaleX", "()F", "setScaleX", "(F)V", "scaleX", "getScaleY", "setScaleY", "scaleY", "getTranslationX", "setTranslationX", "translationX", "getTranslationY", "setTranslationY", "translationY", "getElevation", "setElevation", "elevation", "getAmbientShadowColor", "setAmbientShadowColor", "ambientShadowColor", "getSpotShadowColor", "setSpotShadowColor", "spotShadowColor", "getRotationZ", "setRotationZ", "rotationZ", "getRotationX", "setRotationX", "rotationX", "getRotationY", "setRotationY", "rotationY", "getCameraDistance", "setCameraDistance", "cameraDistance", "getPivotX", "setPivotX", "pivotX", "getPivotY", "setPivotY", "pivotY", "getClipToOutline", "()Z", "setClipToOutline", "(Z)V", "clipToOutline", "getClipToBounds", "setClipToBounds", "clipToBounds", "getAlpha", "setAlpha", "alpha", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderEffect", "getHasDisplayList", "hasDisplayList", "Landroidx/compose/ui/graphics/CompositingStrategy;", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "compositingStrategy", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DeviceRenderNode {
    void discardDisplayList();

    void drawInto(Canvas canvas);

    float getAlpha();

    int getBottom();

    boolean getClipToBounds();

    boolean getClipToOutline();

    float getElevation();

    boolean getHasDisplayList();

    int getHeight();

    int getLeft();

    void getMatrix(Matrix matrix);

    int getRight();

    int getTop();

    int getWidth();

    void offsetLeftAndRight(int offset);

    void offsetTopAndBottom(int offset);

    void record(CanvasHolder canvasHolder, Path clipPath, Function1<? super androidx.compose.ui.graphics.Canvas, Unit> drawBlock);

    void setAlpha(float f5);

    void setAmbientShadowColor(int i5);

    void setCameraDistance(float f5);

    void setClipToBounds(boolean z5);

    void setClipToOutline(boolean z5);

    /* renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
    void mo2129setCompositingStrategyaDBOjCE(int i5);

    void setElevation(float f5);

    boolean setHasOverlappingRendering(boolean hasOverlappingRendering);

    void setOutline(Outline outline);

    void setPivotX(float f5);

    void setPivotY(float f5);

    boolean setPosition(int left, int top, int right, int bottom);

    void setRenderEffect(RenderEffect renderEffect);

    void setRotationX(float f5);

    void setRotationY(float f5);

    void setRotationZ(float f5);

    void setScaleX(float f5);

    void setScaleY(float f5);

    void setSpotShadowColor(int i5);

    void setTranslationX(float f5);

    void setTranslationY(float f5);
}
