package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0010\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001aN\u0010\u0010\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0013\u0010\u001a\u001a\u00020\u0019*\u00020\u0015H\u0002¢\u0006\u0004\b\u001a\u0010\u0018\u001a\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\u001bH\u0002¢\u0006\u0004\b\u0017\u0010\u001c\u001a\u0013\u0010\u001a\u001a\u00020\u0019*\u00020\u001bH\u0002¢\u0006\u0004\b\u001a\u0010\u001c\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/Outline;", "outline", "Landroidx/compose/ui/graphics/Color;", "color", BuildConfig.FLAVOR, "alpha", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "style", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", BuildConfig.FLAVOR, "drawOutline-wDX37Ww", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOutline", "Landroidx/compose/ui/graphics/Brush;", "brush", "drawOutline-hn5TExg", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/Offset;", "topLeft", "(Landroidx/compose/ui/geometry/Rect;)J", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/geometry/RoundRect;", "(Landroidx/compose/ui/geometry/RoundRect;)J", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class OutlineKt {
    /* renamed from: drawOutline-hn5TExg */
    public static final void m1566drawOutlinehn5TExg(DrawScope drawScope, Outline outline, Brush brush, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i5) {
        Path path;
        if (outline instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline).getRect();
            drawScope.mo1675drawRectAsUm42w(brush, topLeft(rect), size(rect), f5, drawStyle, colorFilter, i5);
            return;
        }
        if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            path = rounded.getRoundRectPath();
            if (path == null) {
                RoundRect roundRect = rounded.getRoundRect();
                drawScope.mo1677drawRoundRectZuiqVtQ(brush, topLeft(roundRect), size(roundRect), CornerRadiusKt.CornerRadius$default(CornerRadius.m1323getXimpl(roundRect.getBottomLeftCornerRadius()), 0.0f, 2, null), f5, drawStyle, colorFilter, i5);
                return;
            }
        } else {
            if (!(outline instanceof Outline.Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            path = ((Outline.Generic) outline).getPath();
        }
        drawScope.mo1673drawPathGBMwjPU(path, brush, f5, drawStyle, colorFilter, i5);
    }

    /* renamed from: drawOutline-hn5TExg$default */
    public static /* synthetic */ void m1567drawOutlinehn5TExg$default(DrawScope drawScope, Outline outline, Brush brush, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i5, int i6, Object obj) {
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
            i5 = DrawScope.INSTANCE.m1704getDefaultBlendMode0nO6VwU();
        }
        m1566drawOutlinehn5TExg(drawScope, outline, brush, f6, drawStyle2, colorFilter2, i5);
    }

    /* renamed from: drawOutline-wDX37Ww */
    public static final void m1568drawOutlinewDX37Ww(DrawScope drawScope, Outline outline, long j5, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i5) {
        Path path;
        if (outline instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline).getRect();
            drawScope.mo1676drawRectnJ9OG0(j5, topLeft(rect), size(rect), f5, drawStyle, colorFilter, i5);
            return;
        }
        if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            path = rounded.getRoundRectPath();
            if (path == null) {
                RoundRect roundRect = rounded.getRoundRect();
                drawScope.mo1678drawRoundRectuAw5IA(j5, topLeft(roundRect), size(roundRect), CornerRadiusKt.CornerRadius$default(CornerRadius.m1323getXimpl(roundRect.getBottomLeftCornerRadius()), 0.0f, 2, null), drawStyle, f5, colorFilter, i5);
                return;
            }
        } else {
            if (!(outline instanceof Outline.Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            path = ((Outline.Generic) outline).getPath();
        }
        drawScope.mo1674drawPathLG529CI(path, j5, f5, drawStyle, colorFilter, i5);
    }

    /* renamed from: drawOutline-wDX37Ww$default */
    public static /* synthetic */ void m1569drawOutlinewDX37Ww$default(DrawScope drawScope, Outline outline, long j5, float f5, DrawStyle drawStyle, ColorFilter colorFilter, int i5, int i6, Object obj) {
        m1568drawOutlinewDX37Ww(drawScope, outline, j5, (i6 & 4) != 0 ? 1.0f : f5, (i6 & 8) != 0 ? Fill.INSTANCE : drawStyle, (i6 & 16) != 0 ? null : colorFilter, (i6 & 32) != 0 ? DrawScope.INSTANCE.m1704getDefaultBlendMode0nO6VwU() : i5);
    }

    private static final long size(Rect rect) {
        return SizeKt.Size(rect.getWidth(), rect.getHeight());
    }

    private static final long topLeft(Rect rect) {
        return OffsetKt.Offset(rect.getLeft(), rect.getTop());
    }

    private static final long size(RoundRect roundRect) {
        return SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
    }

    private static final long topLeft(RoundRect roundRect) {
        return OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
    }
}
