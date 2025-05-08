package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\t\u0010\u0003\u001a\u0011\u0010\n\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\n\u0010\u0007\u001a\u0011\u0010\u000b\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Offset;", "positionInRoot", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInWindow", "Landroidx/compose/ui/geometry/Rect;", "boundsInRoot", "(Landroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/geometry/Rect;", "boundsInWindow", "positionInParent", "boundsInParent", "findRootCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/layout/LayoutCoordinates;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LayoutCoordinatesKt {
    public static final Rect boundsInParent(LayoutCoordinates layoutCoordinates) {
        Rect localBoundingBoxOf$default;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return (parentLayoutCoordinates == null || (localBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(parentLayoutCoordinates, layoutCoordinates, false, 2, null)) == null) ? new Rect(0.0f, 0.0f, IntSize.m2661getWidthimpl(layoutCoordinates.mo1948getSizeYbymL2g()), IntSize.m2660getHeightimpl(layoutCoordinates.mo1948getSizeYbymL2g())) : localBoundingBoxOf$default;
    }

    public static final Rect boundsInRoot(LayoutCoordinates layoutCoordinates) {
        return LayoutCoordinates.localBoundingBoxOf$default(findRootCoordinates(layoutCoordinates), layoutCoordinates, false, 2, null);
    }

    public static final Rect boundsInWindow(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates findRootCoordinates = findRootCoordinates(layoutCoordinates);
        float m2661getWidthimpl = IntSize.m2661getWidthimpl(findRootCoordinates.mo1948getSizeYbymL2g());
        float m2660getHeightimpl = IntSize.m2660getHeightimpl(findRootCoordinates.mo1948getSizeYbymL2g());
        Rect boundsInRoot = boundsInRoot(layoutCoordinates);
        float left = boundsInRoot.getLeft();
        if (left < 0.0f) {
            left = 0.0f;
        }
        if (left > m2661getWidthimpl) {
            left = m2661getWidthimpl;
        }
        float top = boundsInRoot.getTop();
        if (top < 0.0f) {
            top = 0.0f;
        }
        if (top > m2660getHeightimpl) {
            top = m2660getHeightimpl;
        }
        float right = boundsInRoot.getRight();
        if (right < 0.0f) {
            right = 0.0f;
        }
        if (right <= m2661getWidthimpl) {
            m2661getWidthimpl = right;
        }
        float bottom = boundsInRoot.getBottom();
        float f5 = bottom >= 0.0f ? bottom : 0.0f;
        if (f5 <= m2660getHeightimpl) {
            m2660getHeightimpl = f5;
        }
        if (left == m2661getWidthimpl || top == m2660getHeightimpl) {
            return Rect.INSTANCE.getZero();
        }
        long mo1952localToWindowMKHz9U = findRootCoordinates.mo1952localToWindowMKHz9U(OffsetKt.Offset(left, top));
        long mo1952localToWindowMKHz9U2 = findRootCoordinates.mo1952localToWindowMKHz9U(OffsetKt.Offset(m2661getWidthimpl, top));
        long mo1952localToWindowMKHz9U3 = findRootCoordinates.mo1952localToWindowMKHz9U(OffsetKt.Offset(m2661getWidthimpl, m2660getHeightimpl));
        long mo1952localToWindowMKHz9U4 = findRootCoordinates.mo1952localToWindowMKHz9U(OffsetKt.Offset(left, m2660getHeightimpl));
        float m1337getXimpl = Offset.m1337getXimpl(mo1952localToWindowMKHz9U);
        float m1337getXimpl2 = Offset.m1337getXimpl(mo1952localToWindowMKHz9U2);
        float m1337getXimpl3 = Offset.m1337getXimpl(mo1952localToWindowMKHz9U4);
        float m1337getXimpl4 = Offset.m1337getXimpl(mo1952localToWindowMKHz9U3);
        float min = Math.min(m1337getXimpl, Math.min(m1337getXimpl2, Math.min(m1337getXimpl3, m1337getXimpl4)));
        float max = Math.max(m1337getXimpl, Math.max(m1337getXimpl2, Math.max(m1337getXimpl3, m1337getXimpl4)));
        float m1338getYimpl = Offset.m1338getYimpl(mo1952localToWindowMKHz9U);
        float m1338getYimpl2 = Offset.m1338getYimpl(mo1952localToWindowMKHz9U2);
        float m1338getYimpl3 = Offset.m1338getYimpl(mo1952localToWindowMKHz9U4);
        float m1338getYimpl4 = Offset.m1338getYimpl(mo1952localToWindowMKHz9U3);
        return new Rect(min, Math.min(m1338getYimpl, Math.min(m1338getYimpl2, Math.min(m1338getYimpl3, m1338getYimpl4))), max, Math.max(m1338getYimpl, Math.max(m1338getYimpl2, Math.max(m1338getYimpl3, m1338getYimpl4))));
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates2 instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates2 : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator wrappedBy = nodeCoordinator.getWrappedBy();
        while (true) {
            NodeCoordinator nodeCoordinator2 = wrappedBy;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator == null) {
                return nodeCoordinator3;
            }
            wrappedBy = nodeCoordinator.getWrappedBy();
        }
    }

    public static final long positionInParent(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.mo1949localPositionOfR5De75A(layoutCoordinates, Offset.INSTANCE.m1349getZeroF1C5BW0()) : Offset.INSTANCE.m1349getZeroF1C5BW0();
    }

    public static final long positionInRoot(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo1951localToRootMKHz9U(Offset.INSTANCE.m1349getZeroF1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo1952localToWindowMKHz9U(Offset.INSTANCE.m1349getZeroF1C5BW0());
    }
}
