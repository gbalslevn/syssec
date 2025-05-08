package androidx.compose.ui.geometry;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a\"\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/geometry/Offset;", "offset", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/geometry/Rect;", "Rect-tz77jQw", "(JJ)Landroidx/compose/ui/geometry/Rect;", "Rect", "topLeft", "bottomRight", "Rect-0a9Yr6o", "center", BuildConfig.FLAVOR, "radius", "Rect-3MmeM6k", "(JF)Landroidx/compose/ui/geometry/Rect;", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RectKt {
    /* renamed from: Rect-0a9Yr6o, reason: not valid java name */
    public static final Rect m1360Rect0a9Yr6o(long j5, long j6) {
        return new Rect(Offset.m1337getXimpl(j5), Offset.m1338getYimpl(j5), Offset.m1337getXimpl(j6), Offset.m1338getYimpl(j6));
    }

    /* renamed from: Rect-3MmeM6k, reason: not valid java name */
    public static final Rect m1361Rect3MmeM6k(long j5, float f5) {
        return new Rect(Offset.m1337getXimpl(j5) - f5, Offset.m1338getYimpl(j5) - f5, Offset.m1337getXimpl(j5) + f5, Offset.m1338getYimpl(j5) + f5);
    }

    /* renamed from: Rect-tz77jQw, reason: not valid java name */
    public static final Rect m1362Recttz77jQw(long j5, long j6) {
        return new Rect(Offset.m1337getXimpl(j5), Offset.m1338getYimpl(j5), Offset.m1337getXimpl(j5) + Size.m1377getWidthimpl(j6), Offset.m1338getYimpl(j5) + Size.m1375getHeightimpl(j6));
    }
}
