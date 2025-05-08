package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001e\u0010\t\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\"\u0014\u0010\n\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "visibleBounds", "(Landroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/Offset;", "offset", BuildConfig.FLAVOR, "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "containsInclusive", "invertedInfiniteRect", "Landroidx/compose/ui/geometry/Rect;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SelectionManagerKt {
    private static final Rect invertedInfiniteRect = new Rect(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    /* renamed from: containsInclusive-Uv8p0NA, reason: not valid java name */
    public static final boolean m635containsInclusiveUv8p0NA(Rect rect, long j5) {
        float left = rect.getLeft();
        float right = rect.getRight();
        float m1337getXimpl = Offset.m1337getXimpl(j5);
        if (left <= m1337getXimpl && m1337getXimpl <= right) {
            float top = rect.getTop();
            float bottom = rect.getBottom();
            float m1338getYimpl = Offset.m1338getYimpl(j5);
            if (top <= m1338getYimpl && m1338getYimpl <= bottom) {
                return true;
            }
        }
        return false;
    }

    public static final Rect visibleBounds(LayoutCoordinates layoutCoordinates) {
        Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
        return RectKt.m1360Rect0a9Yr6o(layoutCoordinates.mo1956windowToLocalMKHz9U(boundsInWindow.m1358getTopLeftF1C5BW0()), layoutCoordinates.mo1956windowToLocalMKHz9U(boundsInWindow.m1355getBottomRightF1C5BW0()));
    }
}
