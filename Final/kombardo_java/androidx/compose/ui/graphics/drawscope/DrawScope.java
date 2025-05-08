package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 U2\u00020\u0001:\u0001UJ\u001e\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006Jj\u0010\u001a\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0003\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019Jj\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0003\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJX\u0010%\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&ø\u0001\u0000¢\u0006\u0004\b#\u0010$JX\u0010%\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&ø\u0001\u0000¢\u0006\u0004\b&\u0010'JN\u0010,\u001a\u00020\u00172\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&ø\u0001\u0000¢\u0006\u0004\b*\u0010+Jv\u0010,\u001a\u00020\u00172\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u00020-2\b\b\u0002\u00102\u001a\u00020/2\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u00104\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\b5\u00106Jb\u0010;\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u00108\u001a\u0002072\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&ø\u0001\u0000¢\u0006\u0004\b9\u0010:Jb\u0010;\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u00108\u001a\u0002072\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0003\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&ø\u0001\u0000¢\u0006\u0004\b<\u0010=JX\u0010B\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010>\u001a\u00020\f2\b\b\u0002\u0010?\u001a\u00020\u00032\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&ø\u0001\u0000¢\u0006\u0004\b@\u0010AJL\u0010G\u001a\u00020\u00172\u0006\u0010D\u001a\u00020C2\u0006\u0010\u001c\u001a\u00020\u001b2\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&ø\u0001\u0000¢\u0006\u0004\bE\u0010FJL\u0010G\u001a\u00020\u00172\u0006\u0010D\u001a\u00020C2\u0006\u0010\t\u001a\u00020\b2\b\b\u0003\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&ø\u0001\u0000¢\u0006\u0004\bH\u0010IR\u0014\u0010M\u001a\u00020J8&X¦\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u001a\u0010?\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bN\u0010OR\u001a\u0010 \u001a\u00020\u00028VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bP\u0010OR\u0014\u0010T\u001a\u00020Q8&X¦\u0004¢\u0006\u0006\u001a\u0004\bR\u0010Sø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006VÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/geometry/Offset;", "offset", "offsetSize-PENXr5M", "(JJ)J", "offsetSize", "Landroidx/compose/ui/graphics/Brush;", "brush", "start", "end", BuildConfig.FLAVOR, "strokeWidth", "Landroidx/compose/ui/graphics/StrokeCap;", "cap", "Landroidx/compose/ui/graphics/PathEffect;", "pathEffect", "alpha", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", BuildConfig.FLAVOR, "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine", "Landroidx/compose/ui/graphics/Color;", "color", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "topLeft", "size", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "style", "drawRect-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/graphics/ImageBitmap;", "image", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "Landroidx/compose/ui/unit/IntOffset;", "srcOffset", "Landroidx/compose/ui/unit/IntSize;", "srcSize", "dstOffset", "dstSize", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "Landroidx/compose/ui/geometry/CornerRadius;", "cornerRadius", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "radius", "center", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "Landroidx/compose/ui/graphics/Path;", "path", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawContext", "getCenter-F1C5BW0", "()J", "getSize-NH-jbRc", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DrawScope extends Density {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\n\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope$Companion;", BuildConfig.FLAVOR, "()V", "DefaultBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultBlendMode-0nO6VwU", "()I", "I", "DefaultFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getDefaultFilterQuality-f-v9h1I", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int DefaultBlendMode = BlendMode.INSTANCE.m1459getSrcOver0nO6VwU();
        private static final int DefaultFilterQuality = FilterQuality.INSTANCE.m1520getLowfv9h1I();

        private Companion() {
        }

        /* renamed from: getDefaultBlendMode-0nO6VwU, reason: not valid java name */
        public final int m1704getDefaultBlendMode0nO6VwU() {
            return DefaultBlendMode;
        }

        /* renamed from: getDefaultFilterQuality-f-v9h1I, reason: not valid java name */
        public final int m1705getDefaultFilterQualityfv9h1I() {
            return DefaultFilterQuality;
        }
    }

    /* renamed from: drawCircle-VaOC9Bg$default, reason: not valid java name */
    static /* synthetic */ void m1690drawCircleVaOC9Bg$default(DrawScope drawScope, long j5, float f5, long j6, float f6, DrawStyle drawStyle, ColorFilter colorFilter, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawCircle-VaOC9Bg");
        }
        drawScope.mo1668drawCircleVaOC9Bg(j5, (i6 & 2) != 0 ? Size.m1376getMinDimensionimpl(drawScope.mo1703getSizeNHjbRc()) / 2.0f : f5, (i6 & 4) != 0 ? drawScope.mo1702getCenterF1C5BW0() : j6, (i6 & 8) != 0 ? 1.0f : f6, (i6 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 32) != 0 ? null : colorFilter, (i6 & 64) != 0 ? INSTANCE.m1704getDefaultBlendMode0nO6VwU() : i5);
    }

    /* renamed from: drawImage-AZ2fEMs$default, reason: not valid java name */
    static /* synthetic */ void m1691drawImageAZ2fEMs$default(DrawScope drawScope, ImageBitmap imageBitmap, long j5, long j6, long j7, long j8, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i5, int i6, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-AZ2fEMs");
        }
        long m2648getZeronOccac = (i7 & 2) != 0 ? IntOffset.INSTANCE.m2648getZeronOccac() : j5;
        long IntSize = (i7 & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j6;
        drawScope.mo1669drawImageAZ2fEMs(imageBitmap, m2648getZeronOccac, IntSize, (i7 & 8) != 0 ? IntOffset.INSTANCE.m2648getZeronOccac() : j7, (i7 & 16) != 0 ? IntSize : j8, (i7 & 32) != 0 ? 1.0f : f5, (i7 & 64) != 0 ? Fill.INSTANCE : drawStyle, (i7 & 128) != 0 ? null : colorFilter, (i7 & 256) != 0 ? INSTANCE.m1704getDefaultBlendMode0nO6VwU() : i5, (i7 & 512) != 0 ? INSTANCE.m1705getDefaultFilterQualityfv9h1I() : i6);
    }

    /* renamed from: drawImage-gbVJVH8$default, reason: not valid java name */
    static /* synthetic */ void m1692drawImagegbVJVH8$default(DrawScope drawScope, ImageBitmap imageBitmap, long j5, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImage-gbVJVH8");
        }
        drawScope.mo1670drawImagegbVJVH8(imageBitmap, (i6 & 2) != 0 ? Offset.INSTANCE.m1349getZeroF1C5BW0() : j5, (i6 & 4) != 0 ? 1.0f : f5, (i6 & 8) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 16) != 0 ? null : colorFilter, (i6 & 32) != 0 ? INSTANCE.m1704getDefaultBlendMode0nO6VwU() : i5);
    }

    /* renamed from: drawLine-1RTmtNc$default, reason: not valid java name */
    static /* synthetic */ void m1693drawLine1RTmtNc$default(DrawScope drawScope, Brush brush, long j5, long j6, float f5, int i5, PathEffect pathEffect, float f6, ColorFilter colorFilter, int i6, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-1RTmtNc");
        }
        drawScope.mo1671drawLine1RTmtNc(brush, j5, j6, (i7 & 8) != 0 ? 0.0f : f5, (i7 & 16) != 0 ? Stroke.INSTANCE.m1709getDefaultCapKaPHkGw() : i5, (i7 & 32) != 0 ? null : pathEffect, (i7 & 64) != 0 ? 1.0f : f6, (i7 & 128) != 0 ? null : colorFilter, (i7 & 256) != 0 ? INSTANCE.m1704getDefaultBlendMode0nO6VwU() : i6);
    }

    /* renamed from: drawLine-NGM6Ib0$default, reason: not valid java name */
    static /* synthetic */ void m1694drawLineNGM6Ib0$default(DrawScope drawScope, long j5, long j6, long j7, float f5, int i5, PathEffect pathEffect, float f6, ColorFilter colorFilter, int i6, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawLine-NGM6Ib0");
        }
        drawScope.mo1672drawLineNGM6Ib0(j5, j6, j7, (i7 & 8) != 0 ? 0.0f : f5, (i7 & 16) != 0 ? Stroke.INSTANCE.m1709getDefaultCapKaPHkGw() : i5, (i7 & 32) != 0 ? null : pathEffect, (i7 & 64) != 0 ? 1.0f : f6, (i7 & 128) != 0 ? null : colorFilter, (i7 & 256) != 0 ? INSTANCE.m1704getDefaultBlendMode0nO6VwU() : i6);
    }

    /* renamed from: drawPath-GBMwjPU$default, reason: not valid java name */
    static /* synthetic */ void m1695drawPathGBMwjPU$default(DrawScope drawScope, Path path, Brush brush, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-GBMwjPU");
        }
        if ((i6 & 4) != 0) {
            f5 = 1.0f;
        }
        float f6 = f5;
        if ((i6 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i6 & 16) != 0) {
            colorFilter = null;
        }
        ColorFilter colorFilter2 = colorFilter;
        if ((i6 & 32) != 0) {
            i5 = INSTANCE.m1704getDefaultBlendMode0nO6VwU();
        }
        drawScope.mo1673drawPathGBMwjPU(path, brush, f6, drawStyle2, colorFilter2, i5);
    }

    /* renamed from: drawPath-LG529CI$default, reason: not valid java name */
    static /* synthetic */ void m1696drawPathLG529CI$default(DrawScope drawScope, Path path, long j5, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawPath-LG529CI");
        }
        drawScope.mo1674drawPathLG529CI(path, j5, (i6 & 4) != 0 ? 1.0f : f5, (i6 & 8) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 16) != 0 ? null : colorFilter, (i6 & 32) != 0 ? INSTANCE.m1704getDefaultBlendMode0nO6VwU() : i5);
    }

    /* renamed from: drawRect-AsUm42w$default, reason: not valid java name */
    static /* synthetic */ void m1697drawRectAsUm42w$default(DrawScope drawScope, Brush brush, long j5, long j6, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-AsUm42w");
        }
        long m1349getZeroF1C5BW0 = (i6 & 2) != 0 ? Offset.INSTANCE.m1349getZeroF1C5BW0() : j5;
        drawScope.mo1675drawRectAsUm42w(brush, m1349getZeroF1C5BW0, (i6 & 4) != 0 ? drawScope.m1701offsetSizePENXr5M(drawScope.mo1703getSizeNHjbRc(), m1349getZeroF1C5BW0) : j6, (i6 & 8) != 0 ? 1.0f : f5, (i6 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 32) != 0 ? null : colorFilter, (i6 & 64) != 0 ? INSTANCE.m1704getDefaultBlendMode0nO6VwU() : i5);
    }

    /* renamed from: drawRect-n-J9OG0$default, reason: not valid java name */
    static /* synthetic */ void m1698drawRectnJ9OG0$default(DrawScope drawScope, long j5, long j6, long j7, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRect-n-J9OG0");
        }
        long m1349getZeroF1C5BW0 = (i6 & 2) != 0 ? Offset.INSTANCE.m1349getZeroF1C5BW0() : j6;
        drawScope.mo1676drawRectnJ9OG0(j5, m1349getZeroF1C5BW0, (i6 & 4) != 0 ? drawScope.m1701offsetSizePENXr5M(drawScope.mo1703getSizeNHjbRc(), m1349getZeroF1C5BW0) : j7, (i6 & 8) != 0 ? 1.0f : f5, (i6 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 32) != 0 ? null : colorFilter, (i6 & 64) != 0 ? INSTANCE.m1704getDefaultBlendMode0nO6VwU() : i5);
    }

    /* renamed from: drawRoundRect-ZuiqVtQ$default, reason: not valid java name */
    static /* synthetic */ void m1699drawRoundRectZuiqVtQ$default(DrawScope drawScope, Brush brush, long j5, long j6, long j7, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-ZuiqVtQ");
        }
        long m1349getZeroF1C5BW0 = (i6 & 2) != 0 ? Offset.INSTANCE.m1349getZeroF1C5BW0() : j5;
        drawScope.mo1677drawRoundRectZuiqVtQ(brush, m1349getZeroF1C5BW0, (i6 & 4) != 0 ? drawScope.m1701offsetSizePENXr5M(drawScope.mo1703getSizeNHjbRc(), m1349getZeroF1C5BW0) : j6, (i6 & 8) != 0 ? CornerRadius.INSTANCE.m1327getZerokKHJgLs() : j7, (i6 & 16) != 0 ? 1.0f : f5, (i6 & 32) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 64) != 0 ? null : colorFilter, (i6 & 128) != 0 ? INSTANCE.m1704getDefaultBlendMode0nO6VwU() : i5);
    }

    /* renamed from: drawRoundRect-u-Aw5IA$default, reason: not valid java name */
    static /* synthetic */ void m1700drawRoundRectuAw5IA$default(DrawScope drawScope, long j5, long j6, long j7, long j8, DrawStyle drawStyle, float f5, ColorFilter colorFilter, int i5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawRoundRect-u-Aw5IA");
        }
        long m1349getZeroF1C5BW0 = (i6 & 2) != 0 ? Offset.INSTANCE.m1349getZeroF1C5BW0() : j6;
        drawScope.mo1678drawRoundRectuAw5IA(j5, m1349getZeroF1C5BW0, (i6 & 4) != 0 ? drawScope.m1701offsetSizePENXr5M(drawScope.mo1703getSizeNHjbRc(), m1349getZeroF1C5BW0) : j7, (i6 & 8) != 0 ? CornerRadius.INSTANCE.m1327getZerokKHJgLs() : j8, (i6 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 32) != 0 ? 1.0f : f5, (i6 & 64) != 0 ? null : colorFilter, (i6 & 128) != 0 ? INSTANCE.m1704getDefaultBlendMode0nO6VwU() : i5);
    }

    /* renamed from: offsetSize-PENXr5M, reason: not valid java name */
    private default long m1701offsetSizePENXr5M(long j5, long j6) {
        return SizeKt.Size(Size.m1377getWidthimpl(j5) - Offset.m1337getXimpl(j6), Size.m1375getHeightimpl(j5) - Offset.m1338getYimpl(j6));
    }

    /* renamed from: drawCircle-VaOC9Bg */
    void mo1668drawCircleVaOC9Bg(long color, float radius, long center, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawImage-AZ2fEMs */
    void mo1669drawImageAZ2fEMs(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality);

    /* renamed from: drawImage-gbVJVH8 */
    void mo1670drawImagegbVJVH8(ImageBitmap image, long topLeft, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawLine-1RTmtNc */
    void mo1671drawLine1RTmtNc(Brush brush, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawLine-NGM6Ib0 */
    void mo1672drawLineNGM6Ib0(long color, long start, long end, float strokeWidth, int cap, PathEffect pathEffect, float alpha, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawPath-GBMwjPU */
    void mo1673drawPathGBMwjPU(Path path, Brush brush, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawPath-LG529CI */
    void mo1674drawPathLG529CI(Path path, long color, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawRect-AsUm42w */
    void mo1675drawRectAsUm42w(Brush brush, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawRect-n-J9OG0 */
    void mo1676drawRectnJ9OG0(long color, long topLeft, long size, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawRoundRect-ZuiqVtQ */
    void mo1677drawRoundRectZuiqVtQ(Brush brush, long topLeft, long size, long cornerRadius, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode);

    /* renamed from: drawRoundRect-u-Aw5IA */
    void mo1678drawRoundRectuAw5IA(long color, long topLeft, long size, long cornerRadius, DrawStyle style, float alpha, ColorFilter colorFilter, int blendMode);

    /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
    default long mo1702getCenterF1C5BW0() {
        return SizeKt.m1385getCenteruvyYCjk(getDrawContext().mo1682getSizeNHjbRc());
    }

    DrawContext getDrawContext();

    LayoutDirection getLayoutDirection();

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    default long mo1703getSizeNHjbRc() {
        return getDrawContext().mo1682getSizeNHjbRc();
    }
}
