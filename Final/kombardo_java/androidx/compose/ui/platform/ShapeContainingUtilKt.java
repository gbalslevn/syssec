package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0000\u001a4\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002\u001a \u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a4\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0002\u001a:\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\u0001*\u00020\u001bH\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"isInOutline", BuildConfig.FLAVOR, "outline", "Landroidx/compose/ui/graphics/Outline;", "x", BuildConfig.FLAVOR, "y", "tmpTouchPointPath", "Landroidx/compose/ui/graphics/Path;", "tmpOpPath", "isInPath", "path", "isInRectangle", "rect", "Landroidx/compose/ui/geometry/Rect;", "isInRoundedRect", "Landroidx/compose/ui/graphics/Outline$Rounded;", "touchPointPath", "opPath", "isWithinEllipse", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "centerX", "centerY", "isWithinEllipse-VE1yxkc", "(FFJFF)Z", "cornersFit", "Landroidx/compose/ui/geometry/RoundRect;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ShapeContainingUtilKt {
    private static final boolean cornersFit(RoundRect roundRect) {
        return CornerRadius.m1323getXimpl(roundRect.getTopLeftCornerRadius()) + CornerRadius.m1323getXimpl(roundRect.getTopRightCornerRadius()) <= roundRect.getWidth() && CornerRadius.m1323getXimpl(roundRect.getBottomLeftCornerRadius()) + CornerRadius.m1323getXimpl(roundRect.getBottomRightCornerRadius()) <= roundRect.getWidth() && CornerRadius.m1324getYimpl(roundRect.getTopLeftCornerRadius()) + CornerRadius.m1324getYimpl(roundRect.getBottomLeftCornerRadius()) <= roundRect.getHeight() && CornerRadius.m1324getYimpl(roundRect.getTopRightCornerRadius()) + CornerRadius.m1324getYimpl(roundRect.getBottomRightCornerRadius()) <= roundRect.getHeight();
    }

    public static final boolean isInOutline(Outline outline, float f5, float f6, Path path, Path path2) {
        if (outline instanceof Outline.Rectangle) {
            return isInRectangle(((Outline.Rectangle) outline).getRect(), f5, f6);
        }
        if (outline instanceof Outline.Rounded) {
            return isInRoundedRect((Outline.Rounded) outline, f5, f6, path, path2);
        }
        if (outline instanceof Outline.Generic) {
            return isInPath(((Outline.Generic) outline).getPath(), f5, f6, path, path2);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ boolean isInOutline$default(Outline outline, float f5, float f6, Path path, Path path2, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            path = null;
        }
        if ((i5 & 16) != 0) {
            path2 = null;
        }
        return isInOutline(outline, f5, f6, path, path2);
    }

    private static final boolean isInPath(Path path, float f5, float f6, Path path2, Path path3) {
        Rect rect = new Rect(f5 - 0.005f, f6 - 0.005f, f5 + 0.005f, f6 + 0.005f);
        if (path2 == null) {
            path2 = AndroidPath_androidKt.Path();
        }
        Path.addRect$default(path2, rect, null, 2, null);
        if (path3 == null) {
            path3 = AndroidPath_androidKt.Path();
        }
        path3.mo1422opN5in7k0(path, path2, PathOperation.INSTANCE.m1583getIntersectb3I0S0c());
        boolean isEmpty = path3.isEmpty();
        path3.reset();
        path2.reset();
        return !isEmpty;
    }

    private static final boolean isInRectangle(Rect rect, float f5, float f6) {
        return rect.getLeft() <= f5 && f5 < rect.getRight() && rect.getTop() <= f6 && f6 < rect.getBottom();
    }

    private static final boolean isInRoundedRect(Outline.Rounded rounded, float f5, float f6, Path path, Path path2) {
        RoundRect roundRect = rounded.getRoundRect();
        if (f5 < roundRect.getLeft() || f5 >= roundRect.getRight() || f6 < roundRect.getTop() || f6 >= roundRect.getBottom()) {
            return false;
        }
        if (!cornersFit(roundRect)) {
            Path Path = path2 == null ? AndroidPath_androidKt.Path() : path2;
            Path.addRoundRect$default(Path, roundRect, null, 2, null);
            return isInPath(Path, f5, f6, path, path2);
        }
        float m1323getXimpl = CornerRadius.m1323getXimpl(roundRect.getTopLeftCornerRadius()) + roundRect.getLeft();
        float m1324getYimpl = CornerRadius.m1324getYimpl(roundRect.getTopLeftCornerRadius()) + roundRect.getTop();
        float right = roundRect.getRight() - CornerRadius.m1323getXimpl(roundRect.getTopRightCornerRadius());
        float m1324getYimpl2 = CornerRadius.m1324getYimpl(roundRect.getTopRightCornerRadius()) + roundRect.getTop();
        float right2 = roundRect.getRight() - CornerRadius.m1323getXimpl(roundRect.getBottomRightCornerRadius());
        float bottom = roundRect.getBottom() - CornerRadius.m1324getYimpl(roundRect.getBottomRightCornerRadius());
        float bottom2 = roundRect.getBottom() - CornerRadius.m1324getYimpl(roundRect.getBottomLeftCornerRadius());
        float m1323getXimpl2 = CornerRadius.m1323getXimpl(roundRect.getBottomLeftCornerRadius()) + roundRect.getLeft();
        if (f5 < m1323getXimpl && f6 < m1324getYimpl) {
            return m2152isWithinEllipseVE1yxkc(f5, f6, roundRect.getTopLeftCornerRadius(), m1323getXimpl, m1324getYimpl);
        }
        if (f5 < m1323getXimpl2 && f6 > bottom2) {
            return m2152isWithinEllipseVE1yxkc(f5, f6, roundRect.getBottomLeftCornerRadius(), m1323getXimpl2, bottom2);
        }
        if (f5 > right && f6 < m1324getYimpl2) {
            return m2152isWithinEllipseVE1yxkc(f5, f6, roundRect.getTopRightCornerRadius(), right, m1324getYimpl2);
        }
        if (f5 <= right2 || f6 <= bottom) {
            return true;
        }
        return m2152isWithinEllipseVE1yxkc(f5, f6, roundRect.getBottomRightCornerRadius(), right2, bottom);
    }

    /* renamed from: isWithinEllipse-VE1yxkc, reason: not valid java name */
    private static final boolean m2152isWithinEllipseVE1yxkc(float f5, float f6, long j5, float f7, float f8) {
        float f9 = f5 - f7;
        float f10 = f6 - f8;
        float m1323getXimpl = CornerRadius.m1323getXimpl(j5);
        float m1324getYimpl = CornerRadius.m1324getYimpl(j5);
        return ((f9 * f9) / (m1323getXimpl * m1323getXimpl)) + ((f10 * f10) / (m1324getYimpl * m1324getYimpl)) <= 1.0f;
    }
}
