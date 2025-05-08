package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002¨\u0006\r"}, d2 = {"Landroidx/compose/ui/focus/FocusableChildrenComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/focus/FocusTargetNode;", "Lkotlin/Comparator;", "()V", "compare", BuildConfig.FLAVOR, "a", "b", "pathFromRoot", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusableChildrenComparator implements Comparator<FocusTargetNode> {
    public static final FocusableChildrenComparator INSTANCE = new FocusableChildrenComparator();

    private FocusableChildrenComparator() {
    }

    private final MutableVector<LayoutNode> pathFromRoot(LayoutNode layoutNode) {
        MutableVector<LayoutNode> mutableVector = new MutableVector<>(new LayoutNode[16], 0);
        while (layoutNode != null) {
            mutableVector.add(0, layoutNode);
            layoutNode = layoutNode.getParent$ui_release();
        }
        return mutableVector;
    }

    @Override // java.util.Comparator
    public int compare(FocusTargetNode a5, FocusTargetNode b5) {
        int i5 = 0;
        if (FocusTraversalKt.isEligibleForFocusSearch(a5) && FocusTraversalKt.isEligibleForFocusSearch(b5)) {
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(a5);
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(b5);
            if (Intrinsics.areEqual(requireLayoutNode, requireLayoutNode2)) {
                return 0;
            }
            MutableVector<LayoutNode> pathFromRoot = pathFromRoot(requireLayoutNode);
            MutableVector<LayoutNode> pathFromRoot2 = pathFromRoot(requireLayoutNode2);
            int min = Math.min(pathFromRoot.getSize() - 1, pathFromRoot2.getSize() - 1);
            if (min >= 0) {
                while (Intrinsics.areEqual(pathFromRoot.getContent()[i5], pathFromRoot2.getContent()[i5])) {
                    if (i5 != min) {
                        i5++;
                    }
                }
                return Intrinsics.compare(pathFromRoot.getContent()[i5].getPlaceOrder$ui_release(), pathFromRoot2.getContent()[i5].getPlaceOrder$ui_release());
            }
            throw new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.");
        }
        if (FocusTraversalKt.isEligibleForFocusSearch(a5)) {
            return -1;
        }
        return FocusTraversalKt.isEligibleForFocusSearch(b5) ? 1 : 0;
    }
}
