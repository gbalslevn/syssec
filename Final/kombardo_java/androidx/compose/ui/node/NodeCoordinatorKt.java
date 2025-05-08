package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\b"}, d2 = {"nextUntil", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "stopType", "nextUntil-hw7D004", "(Landroidx/compose/ui/node/DelegatableNode;II)Landroidx/compose/ui/Modifier$Node;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NodeCoordinatorKt {
    /* renamed from: access$nextUntil-hw7D004, reason: not valid java name */
    public static final /* synthetic */ Modifier.Node m2072access$nextUntilhw7D004(DelegatableNode delegatableNode, int i5, int i6) {
        return m2073nextUntilhw7D004(delegatableNode, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: nextUntil-hw7D004, reason: not valid java name */
    public static final Modifier.Node m2073nextUntilhw7D004(DelegatableNode delegatableNode, int i5, int i6) {
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null || (child.getAggregateChildKindSet() & i5) == 0) {
            return null;
        }
        while (child != null) {
            int kindSet = child.getKindSet();
            if ((kindSet & i6) != 0) {
                return null;
            }
            if ((kindSet & i5) != 0) {
                return child;
            }
            child = child.getChild();
        }
        return null;
    }
}
