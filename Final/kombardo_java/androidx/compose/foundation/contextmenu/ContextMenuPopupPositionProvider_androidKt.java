package androidx.compose.foundation.contextmenu;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a*\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001\u001a \u0010\b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\t\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a(\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a(\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\r"}, d2 = {"alignEndEdges", BuildConfig.FLAVOR, "popupLength", "windowLength", "closeAffinity", BuildConfig.FLAVOR, "alignPopupAxis", "position", "alignPopupEndEdgeToPosition", "alignPopupStartEdgeToPosition", "alignStartEdges", "popupFitsBetweenPositionAndEndEdge", "popupFitsBetweenPositionAndStartEdge", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ContextMenuPopupPositionProvider_androidKt {
    private static final int alignEndEdges(int i5, int i6, boolean z5) {
        return alignStartEdges(i5, i6, !z5);
    }

    public static final int alignPopupAxis(int i5, int i6, int i7, boolean z5) {
        return i6 >= i7 ? alignStartEdges(i6, i7, z5) : popupFitsBetweenPositionAndEndEdge(i5, i6, i7, z5) ? alignPopupStartEdgeToPosition(i5, i6, z5) : popupFitsBetweenPositionAndStartEdge(i5, i6, i7, z5) ? alignPopupEndEdgeToPosition(i5, i6, z5) : alignEndEdges(i6, i7, z5);
    }

    public static /* synthetic */ int alignPopupAxis$default(int i5, int i6, int i7, boolean z5, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            z5 = true;
        }
        return alignPopupAxis(i5, i6, i7, z5);
    }

    private static final int alignPopupEndEdgeToPosition(int i5, int i6, boolean z5) {
        return alignPopupStartEdgeToPosition(i5, i6, !z5);
    }

    private static final int alignPopupStartEdgeToPosition(int i5, int i6, boolean z5) {
        return z5 ? i5 : i5 - i6;
    }

    private static final int alignStartEdges(int i5, int i6, boolean z5) {
        if (z5) {
            return 0;
        }
        return i6 - i5;
    }

    private static final boolean popupFitsBetweenPositionAndEndEdge(int i5, int i6, int i7, boolean z5) {
        return popupFitsBetweenPositionAndStartEdge(i5, i6, i7, !z5);
    }

    private static final boolean popupFitsBetweenPositionAndStartEdge(int i5, int i6, int i7, boolean z5) {
        if (z5) {
            if (i6 > i5) {
                return false;
            }
        } else if (i7 - i6 <= i5) {
            return false;
        }
        return true;
    }
}
