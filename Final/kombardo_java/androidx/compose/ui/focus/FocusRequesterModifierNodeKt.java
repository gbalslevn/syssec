package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/focus/FocusRequesterModifierNode;", BuildConfig.FLAVOR, "requestFocus", "(Landroidx/compose/ui/focus/FocusRequesterModifierNode;)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class FocusRequesterModifierNodeKt {
    /* JADX WARN: Code restructure failed: missing block: B:102:0x009b, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean requestFocus(FocusRequesterModifierNode focusRequesterModifierNode) {
        int m2074constructorimpl = NodeKind.m2074constructorimpl(1024);
        Modifier.Node node = focusRequesterModifierNode.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof FocusTargetNode) {
                FocusTargetNode focusTargetNode = (FocusTargetNode) node;
                return focusTargetNode.fetchFocusProperties$ui_release().getCanFocus() ? FocusTransactionsKt.requestFocus(focusTargetNode) : TwoDimensionalFocusSearchKt.m1316findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, FocusDirection.INSTANCE.m1280getEnterdhqQ8s(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusRequesterModifierNodeKt$requestFocus$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(FocusTargetNode focusTargetNode2) {
                        return Boolean.valueOf(FocusTransactionsKt.requestFocus(focusTargetNode2));
                    }
                });
            }
            if ((node.getKindSet() & m2074constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                int i5 = 0;
                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                    if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                        i5++;
                        if (i5 == 1) {
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
                if (i5 == 1) {
                }
            }
            node = DelegatableNodeKt.pop(mutableVector);
        }
        if (!focusRequesterModifierNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusRequesterModifierNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusRequesterModifierNode.getNode());
        } else {
            mutableVector2.add(child);
        }
        while (mutableVector2.isNotEmpty()) {
            Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node2.getAggregateChildKindSet() & m2074constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node2);
            } else {
                while (true) {
                    if (node2 == null) {
                        break;
                    }
                    if ((node2.getKindSet() & m2074constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node2 != null) {
                            if (node2 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) node2;
                                return focusTargetNode2.fetchFocusProperties$ui_release().getCanFocus() ? FocusTransactionsKt.requestFocus(focusTargetNode2) : TwoDimensionalFocusSearchKt.m1316findChildCorrespondingToFocusEnterOMvw8(focusTargetNode2, FocusDirection.INSTANCE.m1280getEnterdhqQ8s(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusRequesterModifierNodeKt$requestFocus$1$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(FocusTargetNode focusTargetNode22) {
                                        return Boolean.valueOf(FocusTransactionsKt.requestFocus(focusTargetNode22));
                                    }
                                });
                            }
                            if ((node2.getKindSet() & m2074constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                int i6 = 0;
                                for (Modifier.Node delegate2 = ((DelegatingNode) node2).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                    if ((delegate2.getKindSet() & m2074constructorimpl) != 0) {
                                        i6++;
                                        if (i6 == 1) {
                                            node2 = delegate2;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node2 != null) {
                                                mutableVector3.add(node2);
                                                node2 = null;
                                            }
                                            mutableVector3.add(delegate2);
                                        }
                                    }
                                }
                                if (i6 == 1) {
                                }
                            }
                            node2 = DelegatableNodeKt.pop(mutableVector3);
                        }
                    } else {
                        node2 = node2.getChild();
                    }
                }
            }
        }
        return false;
    }
}
