package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007JD\u0010\u0014\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0010ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bR*\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b#\u0010\u0003\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010)R\u001c\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u000b\u0010*R\u001c\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\t\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Landroidx/compose/ui/graphics/vector/DrawCache;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", BuildConfig.FLAVOR, "clear", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;)V", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "config", "Landroidx/compose/ui/unit/IntSize;", "size", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Lkotlin/Function1;", "block", "drawCachedImage-FqjB98A", "(IJLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function1;)V", "drawCachedImage", "target", BuildConfig.FLAVOR, "alpha", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "drawInto", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FLandroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/ImageBitmap;", "mCachedImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "getMCachedImage", "()Landroidx/compose/ui/graphics/ImageBitmap;", "setMCachedImage", "(Landroidx/compose/ui/graphics/ImageBitmap;)V", "getMCachedImage$annotations", "Landroidx/compose/ui/graphics/Canvas;", "cachedCanvas", "Landroidx/compose/ui/graphics/Canvas;", "scopeDensity", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/LayoutDirection;", "J", "I", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "cacheScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DrawCache {
    private Canvas cachedCanvas;
    private ImageBitmap mCachedImage;
    private Density scopeDensity;
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private long size = IntSize.INSTANCE.m2665getZeroYbymL2g();
    private int config = ImageBitmapConfig.INSTANCE.m1539getArgb8888_sVssgQ();
    private final CanvasDrawScope cacheScope = new CanvasDrawScope();

    private final void clear(DrawScope drawScope) {
        DrawScope.m1698drawRectnJ9OG0$default(drawScope, Color.INSTANCE.m1496getBlack0d7_KjU(), 0L, 0L, 0.0f, null, null, BlendMode.INSTANCE.m1432getClear0nO6VwU(), 62, null);
    }

    /* renamed from: drawCachedImage-FqjB98A, reason: not valid java name */
    public final void m1750drawCachedImageFqjB98A(int config, long size, Density density, LayoutDirection layoutDirection, Function1<? super DrawScope, Unit> block) {
        this.scopeDensity = density;
        this.layoutDirection = layoutDirection;
        ImageBitmap imageBitmap = this.mCachedImage;
        Canvas canvas = this.cachedCanvas;
        if (imageBitmap == null || canvas == null || IntSize.m2661getWidthimpl(size) > imageBitmap.getWidth() || IntSize.m2660getHeightimpl(size) > imageBitmap.getHeight() || !ImageBitmapConfig.m1534equalsimpl0(this.config, config)) {
            imageBitmap = ImageBitmapKt.m1544ImageBitmapx__hDU$default(IntSize.m2661getWidthimpl(size), IntSize.m2660getHeightimpl(size), config, false, null, 24, null);
            canvas = CanvasKt.Canvas(imageBitmap);
            this.mCachedImage = imageBitmap;
            this.cachedCanvas = canvas;
            this.config = config;
        }
        this.size = size;
        CanvasDrawScope canvasDrawScope = this.cacheScope;
        long m2668toSizeozmzZPI = IntSizeKt.m2668toSizeozmzZPI(size);
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
        Density density2 = drawParams.getDensity();
        LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
        Canvas canvas2 = drawParams.getCanvas();
        long size2 = drawParams.getSize();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
        drawParams2.setDensity(density);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m1681setSizeuvyYCjk(m2668toSizeozmzZPI);
        canvas.save();
        clear(canvasDrawScope);
        block.invoke(canvasDrawScope);
        canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
        drawParams3.setDensity(density2);
        drawParams3.setLayoutDirection(layoutDirection2);
        drawParams3.setCanvas(canvas2);
        drawParams3.m1681setSizeuvyYCjk(size2);
        imageBitmap.prepareToDraw();
    }

    public final void drawInto(DrawScope target, float alpha, ColorFilter colorFilter) {
        ImageBitmap imageBitmap = this.mCachedImage;
        if (!(imageBitmap != null)) {
            InlineClassHelperKt.throwIllegalStateException("drawCachedImage must be invoked first before attempting to draw the result into another destination");
        }
        DrawScope.m1691drawImageAZ2fEMs$default(target, imageBitmap, 0L, this.size, 0L, 0L, alpha, null, colorFilter, 0, 0, 858, null);
    }

    public final ImageBitmap getMCachedImage() {
        return this.mCachedImage;
    }
}
