package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b`\u0018\u0000 s2\u00020\u0001:\u0001sJ*\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ$\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J;\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00070\u001bH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0007H&¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H&¢\u0006\u0004\b#\u0010$R\"\u0010*\u001a\u00020%8&@&X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00100\u001a\u00020+8&@&X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00106\u001a\u0002018&@&X¦\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010:\u001a\u0002078&@&X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b8\u0010'\"\u0004\b9\u0010)R\u001e\u0010@\u001a\u0004\u0018\u00010;8&@&X¦\u000e¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010C\u001a\u0002018&@&X¦\u000e¢\u0006\f\u001a\u0004\bA\u00103\"\u0004\bB\u00105R\u001c\u0010F\u001a\u0002018&@&X¦\u000e¢\u0006\f\u001a\u0004\bD\u00103\"\u0004\bE\u00105R\u001c\u0010I\u001a\u0002018&@&X¦\u000e¢\u0006\f\u001a\u0004\bG\u00103\"\u0004\bH\u00105R\u001c\u0010L\u001a\u0002018&@&X¦\u000e¢\u0006\f\u001a\u0004\bJ\u00103\"\u0004\bK\u00105R\u001c\u0010O\u001a\u0002018&@&X¦\u000e¢\u0006\f\u001a\u0004\bM\u00103\"\u0004\bN\u00105R\"\u0010S\u001a\u00020P8&@&X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bQ\u0010-\"\u0004\bR\u0010/R\"\u0010V\u001a\u00020P8&@&X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\bT\u0010-\"\u0004\bU\u0010/R\u001c\u0010Y\u001a\u0002018&@&X¦\u000e¢\u0006\f\u001a\u0004\bW\u00103\"\u0004\bX\u00105R\u001c\u0010\\\u001a\u0002018&@&X¦\u000e¢\u0006\f\u001a\u0004\bZ\u00103\"\u0004\b[\u00105R\u001c\u0010_\u001a\u0002018&@&X¦\u000e¢\u0006\f\u001a\u0004\b]\u00103\"\u0004\b^\u00105R\u001c\u0010b\u001a\u0002018&@&X¦\u000e¢\u0006\f\u001a\u0004\b`\u00103\"\u0004\ba\u00105R\u001c\u0010h\u001a\u00020c8&@&X¦\u000e¢\u0006\f\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001e\u0010n\u001a\u0004\u0018\u00010i8&@&X¦\u000e¢\u0006\f\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001c\u0010o\u001a\u00020c8&@&X¦\u000e¢\u0006\f\u001a\u0004\bo\u0010e\"\u0004\bp\u0010gR\u0014\u0010r\u001a\u00020c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bq\u0010eø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006tÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "x", "y", "Landroidx/compose/ui/unit/IntSize;", "size", BuildConfig.FLAVOR, "setPosition-H0pRuoY", "(IIJ)V", "setPosition", "Landroid/graphics/Outline;", "outline", "outlineSize", "setOutline-O0kMr_c", "(Landroid/graphics/Outline;J)V", "setOutline", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "draw", "(Landroidx/compose/ui/graphics/Canvas;)V", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "record", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/jvm/functions/Function1;)V", "discardDisplayList", "()V", "Landroid/graphics/Matrix;", "calculateMatrix", "()Landroid/graphics/Matrix;", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "getCompositingStrategy-ke2Ky5w", "()I", "setCompositingStrategy-Wpw9cng", "(I)V", "compositingStrategy", "Landroidx/compose/ui/geometry/Offset;", "getPivotOffset-F1C5BW0", "()J", "setPivotOffset-k-4lQ0M", "(J)V", "pivotOffset", BuildConfig.FLAVOR, "getAlpha", "()F", "setAlpha", "(F)V", "alpha", "Landroidx/compose/ui/graphics/BlendMode;", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "blendMode", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter", "getScaleX", "setScaleX", "scaleX", "getScaleY", "setScaleY", "scaleY", "getTranslationX", "setTranslationX", "translationX", "getTranslationY", "setTranslationY", "translationY", "getShadowElevation", "setShadowElevation", "shadowElevation", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "ambientShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "spotShadowColor", "getRotationX", "setRotationX", "rotationX", "getRotationY", "setRotationY", "rotationY", "getRotationZ", "setRotationZ", "rotationZ", "getCameraDistance", "setCameraDistance", "cameraDistance", BuildConfig.FLAVOR, "getClip", "()Z", "setClip", "(Z)V", "clip", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderEffect", "isInvalidated", "setInvalidated", "getHasDisplayList", "hasDisplayList", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface GraphicsLayerImpl {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", BuildConfig.FLAVOR, "DefaultDrawBlock", "Lkotlin/jvm/functions/Function1;", "getDefaultDrawBlock", "()Lkotlin/jvm/functions/Function1;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Function1<DrawScope, Unit> DefaultDrawBlock = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayerImpl$Companion$DefaultDrawBlock$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                DrawScope.m1698drawRectnJ9OG0$default(drawScope, Color.INSTANCE.m1500getTransparent0d7_KjU(), 0L, 0L, 0.0f, null, null, 0, 126, null);
            }
        };

        private Companion() {
        }

        public final Function1<DrawScope, Unit> getDefaultDrawBlock() {
            return DefaultDrawBlock;
        }
    }

    Matrix calculateMatrix();

    void discardDisplayList();

    void draw(Canvas canvas);

    float getAlpha();

    /* renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    long getAmbientShadowColor();

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    int getBlendMode();

    float getCameraDistance();

    ColorFilter getColorFilter();

    /* renamed from: getCompositingStrategy-ke2Ky5w, reason: not valid java name */
    int getCompositingStrategy();

    default boolean getHasDisplayList() {
        return true;
    }

    RenderEffect getRenderEffect();

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    float getShadowElevation();

    /* renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    long getSpotShadowColor();

    float getTranslationX();

    float getTranslationY();

    void record(Density density, LayoutDirection layoutDirection, GraphicsLayer layer, Function1<? super DrawScope, Unit> block);

    void setAlpha(float f5);

    /* renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    void mo1734setAmbientShadowColor8_81llA(long j5);

    void setCameraDistance(float f5);

    void setClip(boolean z5);

    /* renamed from: setCompositingStrategy-Wpw9cng, reason: not valid java name */
    void mo1735setCompositingStrategyWpw9cng(int i5);

    void setInvalidated(boolean z5);

    /* renamed from: setOutline-O0kMr_c, reason: not valid java name */
    void mo1736setOutlineO0kMr_c(Outline outline, long outlineSize);

    /* renamed from: setPivotOffset-k-4lQ0M, reason: not valid java name */
    void mo1737setPivotOffsetk4lQ0M(long j5);

    /* renamed from: setPosition-H0pRuoY, reason: not valid java name */
    void mo1738setPositionH0pRuoY(int x5, int y5, long size);

    void setRenderEffect(RenderEffect renderEffect);

    void setRotationX(float f5);

    void setRotationY(float f5);

    void setRotationZ(float f5);

    void setScaleX(float f5);

    void setScaleY(float f5);

    void setShadowElevation(float f5);

    /* renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    void mo1739setSpotShadowColor8_81llA(long j5);

    void setTranslationX(float f5);

    void setTranslationY(float f5);
}
