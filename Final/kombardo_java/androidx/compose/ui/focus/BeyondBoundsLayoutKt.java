package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a<\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"T", "Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/focus/FocusDirection;", "direction", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "block", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "searchBeyondBounds", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BeyondBoundsLayoutKt {
    /* renamed from: searchBeyondBounds--OM-vw8, reason: not valid java name */
    public static final <T> T m1271searchBeyondBoundsOMvw8(FocusTargetNode focusTargetNode, int i5, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> function1) {
        Modifier.Node node;
        BeyondBoundsLayout beyondBoundsLayoutParent;
        int m1932getBeforehoxUOeE;
        NodeChain nodes;
        int m2074constructorimpl = NodeKind.m2074constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = focusTargetNode.getNode().getParent();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
        loop0: while (true) {
            if (requireLayoutNode == null) {
                node = null;
                break;
            }
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m2074constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & m2074constructorimpl) != 0) {
                        node = parent;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((node.getKindSet() & m2074constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i6 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                        i6++;
                                        if (i6 == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                mutableVector.add(node);
                                                node = null;
                                            }
                                            mutableVector.add(delegate);
                                        }
                                    }
                                }
                                if (i6 == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        FocusTargetNode focusTargetNode2 = (FocusTargetNode) node;
        if ((focusTargetNode2 != null && Intrinsics.areEqual(focusTargetNode2.getBeyondBoundsLayoutParent(), focusTargetNode.getBeyondBoundsLayoutParent())) || (beyondBoundsLayoutParent = focusTargetNode.getBeyondBoundsLayoutParent()) == null) {
            return null;
        }
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1286getUpdhqQ8s())) {
            m1932getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m1930getAbovehoxUOeE();
        } else if (FocusDirection.m1275equalsimpl0(i5, companion.m1279getDowndhqQ8s())) {
            m1932getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m1933getBelowhoxUOeE();
        } else if (FocusDirection.m1275equalsimpl0(i5, companion.m1282getLeftdhqQ8s())) {
            m1932getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m1934getLefthoxUOeE();
        } else if (FocusDirection.m1275equalsimpl0(i5, companion.m1285getRightdhqQ8s())) {
            m1932getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m1935getRighthoxUOeE();
        } else if (FocusDirection.m1275equalsimpl0(i5, companion.m1283getNextdhqQ8s())) {
            m1932getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m1931getAfterhoxUOeE();
        } else {
            if (!FocusDirection.m1275equalsimpl0(i5, companion.m1284getPreviousdhqQ8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout");
            }
            m1932getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.INSTANCE.m1932getBeforehoxUOeE();
        }
        return (T) beyondBoundsLayoutParent.mo407layouto7g1Pn8(m1932getBeforehoxUOeE, function1);
    }
}
