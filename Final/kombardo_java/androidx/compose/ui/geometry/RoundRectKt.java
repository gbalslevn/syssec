package androidx.compose.ui.geometry;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a=\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a8\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a%\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\u0010\u001a \u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a@\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\"\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0015\u0010\u001d\u001a\u00020\u001c*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {BuildConfig.FLAVOR, "left", "top", "right", "bottom", "radiusX", "radiusY", "Landroidx/compose/ui/geometry/RoundRect;", "RoundRect", "(FFFFFF)Landroidx/compose/ui/geometry/RoundRect;", "Landroidx/compose/ui/geometry/CornerRadius;", "cornerRadius", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "Landroidx/compose/ui/geometry/Rect;", "rect", "(Landroidx/compose/ui/geometry/Rect;FF)Landroidx/compose/ui/geometry/RoundRect;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "boundingRect", BuildConfig.FLAVOR, "isSimple", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RoundRectKt {
    public static final RoundRect RoundRect(float f5, float f6, float f7, float f8, float f9, float f10) {
        long CornerRadius = CornerRadiusKt.CornerRadius(f9, f10);
        return new RoundRect(f5, f6, f7, f8, CornerRadius, CornerRadius, CornerRadius, CornerRadius, null);
    }

    /* renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m1367RoundRectZAM2FJo(Rect rect, long j5, long j6, long j7, long j8) {
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j5, j6, j7, j8, null);
    }

    /* renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m1368RoundRectgG7oq9Y(float f5, float f6, float f7, float f8, long j5) {
        return RoundRect(f5, f6, f7, f8, CornerRadius.m1323getXimpl(j5), CornerRadius.m1324getYimpl(j5));
    }

    /* renamed from: RoundRect-sniSvfs, reason: not valid java name */
    public static final RoundRect m1369RoundRectsniSvfs(Rect rect, long j5) {
        return RoundRect(rect, CornerRadius.m1323getXimpl(j5), CornerRadius.m1324getYimpl(j5));
    }

    public static final Rect getBoundingRect(RoundRect roundRect) {
        return new Rect(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
    }

    public static final boolean isSimple(RoundRect roundRect) {
        return CornerRadius.m1323getXimpl(roundRect.getTopLeftCornerRadius()) == CornerRadius.m1324getYimpl(roundRect.getTopLeftCornerRadius()) && CornerRadius.m1323getXimpl(roundRect.getTopLeftCornerRadius()) == CornerRadius.m1323getXimpl(roundRect.getTopRightCornerRadius()) && CornerRadius.m1323getXimpl(roundRect.getTopLeftCornerRadius()) == CornerRadius.m1324getYimpl(roundRect.getTopRightCornerRadius()) && CornerRadius.m1323getXimpl(roundRect.getTopLeftCornerRadius()) == CornerRadius.m1323getXimpl(roundRect.getBottomRightCornerRadius()) && CornerRadius.m1323getXimpl(roundRect.getTopLeftCornerRadius()) == CornerRadius.m1324getYimpl(roundRect.getBottomRightCornerRadius()) && CornerRadius.m1323getXimpl(roundRect.getTopLeftCornerRadius()) == CornerRadius.m1323getXimpl(roundRect.getBottomLeftCornerRadius()) && CornerRadius.m1323getXimpl(roundRect.getTopLeftCornerRadius()) == CornerRadius.m1324getYimpl(roundRect.getBottomLeftCornerRadius());
    }

    public static final RoundRect RoundRect(Rect rect, float f5, float f6) {
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), f5, f6);
    }
}
