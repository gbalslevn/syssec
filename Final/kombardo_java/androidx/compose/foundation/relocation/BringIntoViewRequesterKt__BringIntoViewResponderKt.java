package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a#\u0010\n\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/node/DelegatableNode;", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "findBringIntoViewParent", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/foundation/relocation/BringIntoViewParent;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "sourceCoordinates", "Landroidx/compose/ui/geometry/Rect;", "rect", "localRectOf$BringIntoViewRequesterKt__BringIntoViewResponderKt", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "localRectOf", "foundation_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/foundation/relocation/BringIntoViewRequesterKt")
/* loaded from: classes.dex */
public abstract /* synthetic */ class BringIntoViewRequesterKt__BringIntoViewResponderKt {
    public static final BringIntoViewParent findBringIntoViewParent(DelegatableNode delegatableNode) {
        if (!delegatableNode.getNode().getIsAttached()) {
            return null;
        }
        BringIntoViewParent bringIntoViewParent = (BringIntoViewParent) TraversableNodeKt.findNearestAncestor(delegatableNode, BringIntoViewResponderNode.TraverseKey);
        return bringIntoViewParent == null ? BringIntoViewResponder_androidKt.defaultBringIntoViewParent(delegatableNode) : bringIntoViewParent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect localRectOf$BringIntoViewRequesterKt__BringIntoViewResponderKt(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, Rect rect) {
        return rect.m1359translatek4lQ0M(layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, false).m1358getTopLeftF1C5BW0());
    }
}
