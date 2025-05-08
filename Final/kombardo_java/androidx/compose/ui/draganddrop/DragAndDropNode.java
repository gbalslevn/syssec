package androidx.compose.ui.draganddrop;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\n\b\u0000\u0018\u0000 #2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001#B\u001d\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0010J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0013R\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "onDragAndDropStart", "<init>", "(Lkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "onDetach", "()V", "startEvent", BuildConfig.FLAVOR, "acceptDragAndDropTransfer", "(Landroidx/compose/ui/draganddrop/DragAndDropEvent;)Z", "event", "onStarted", "(Landroidx/compose/ui/draganddrop/DragAndDropEvent;)V", "onEntered", "onMoved", "onExited", "onDrop", "onEnded", "Lkotlin/jvm/functions/Function1;", BuildConfig.FLAVOR, "traverseKey", "Ljava/lang/Object;", "getTraverseKey", "()Ljava/lang/Object;", "lastChildDragAndDropModifierNode", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "thisDragAndDropTarget", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragAndDropNode extends Modifier.Node implements TraversableNode, DragAndDropModifierNode {
    private DragAndDropModifierNode lastChildDragAndDropModifierNode;
    private final Function1<DragAndDropEvent, DragAndDropTarget> onDragAndDropStart;
    private DragAndDropTarget thisDragAndDropTarget;
    private final Object traverseKey = Companion.DragAndDropTraversableKey.INSTANCE;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public DragAndDropNode(Function1<? super DragAndDropEvent, ? extends DragAndDropTarget> function1) {
        this.onDragAndDropStart = function1;
    }

    public boolean acceptDragAndDropTransfer(final DragAndDropEvent startEvent) {
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        DragAndDropNodeKt.traverseSelfAndDescendants(this, new Function1<DragAndDropNode, TraversableNode$Companion$TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$acceptDragAndDropTransfer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TraversableNode$Companion$TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
                DragAndDropTarget dragAndDropTarget;
                Function1 function1;
                DragAndDropTarget dragAndDropTarget2;
                if (!dragAndDropNode.getIsAttached()) {
                    return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
                }
                dragAndDropTarget = dragAndDropNode.thisDragAndDropTarget;
                if (!(dragAndDropTarget == null)) {
                    InlineClassHelperKt.throwIllegalStateException("DragAndDropTarget self reference must be null at the start of a drag and drop session");
                }
                function1 = dragAndDropNode.onDragAndDropStart;
                dragAndDropNode.thisDragAndDropTarget = (DragAndDropTarget) function1.invoke(DragAndDropEvent.this);
                dragAndDropTarget2 = dragAndDropNode.thisDragAndDropTarget;
                boolean z5 = dragAndDropTarget2 != null;
                if (z5) {
                    DelegatableNodeKt.requireOwner(this).getDragAndDropManager().registerNodeInterest(dragAndDropNode);
                }
                Ref$BooleanRef ref$BooleanRef2 = ref$BooleanRef;
                ref$BooleanRef2.element = ref$BooleanRef2.element || z5;
                return TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
            }
        });
        return ref$BooleanRef.element;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.thisDragAndDropTarget = null;
        this.lastChildDragAndDropModifierNode = null;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public boolean onDrop(DragAndDropEvent event) {
        DragAndDropModifierNode dragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
        if (dragAndDropModifierNode != null) {
            return dragAndDropModifierNode.onDrop(event);
        }
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget != null) {
            return dragAndDropTarget.onDrop(event);
        }
        return false;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onEnded(final DragAndDropEvent event) {
        DragAndDropNodeKt.traverseSelfAndDescendants(this, new Function1<DragAndDropNode, TraversableNode$Companion$TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$onEnded$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TraversableNode$Companion$TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
                DragAndDropTarget dragAndDropTarget;
                if (!dragAndDropNode.getNode().getIsAttached()) {
                    return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
                }
                dragAndDropTarget = dragAndDropNode.thisDragAndDropTarget;
                if (dragAndDropTarget != null) {
                    dragAndDropTarget.onEnded(DragAndDropEvent.this);
                }
                dragAndDropNode.thisDragAndDropTarget = null;
                dragAndDropNode.lastChildDragAndDropModifierNode = null;
                return TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
            }
        });
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onEntered(DragAndDropEvent event) {
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget != null) {
            dragAndDropTarget.onEntered(event);
            return;
        }
        DragAndDropModifierNode dragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
        if (dragAndDropModifierNode != null) {
            dragAndDropModifierNode.onEntered(event);
        }
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onExited(DragAndDropEvent event) {
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget != null) {
            dragAndDropTarget.onExited(event);
        }
        DragAndDropModifierNode dragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
        if (dragAndDropModifierNode != null) {
            dragAndDropModifierNode.onExited(event);
        }
        this.lastChildDragAndDropModifierNode = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMoved(final DragAndDropEvent event) {
        TraversableNode traversableNode;
        DragAndDropModifierNode dragAndDropModifierNode;
        boolean m1259containsUv8p0NA;
        DragAndDropModifierNode dragAndDropModifierNode2 = this.lastChildDragAndDropModifierNode;
        if (dragAndDropModifierNode2 != null) {
            m1259containsUv8p0NA = DragAndDropNodeKt.m1259containsUv8p0NA(dragAndDropModifierNode2, DragAndDrop_androidKt.getPositionInRoot(event));
            if (m1259containsUv8p0NA) {
                dragAndDropModifierNode = dragAndDropModifierNode2;
                if (dragAndDropModifierNode == null && dragAndDropModifierNode2 == null) {
                    DragAndDropNodeKt.dispatchEntered(dragAndDropModifierNode, event);
                    DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
                    if (dragAndDropTarget != null) {
                        dragAndDropTarget.onExited(event);
                    }
                } else if (dragAndDropModifierNode != null && dragAndDropModifierNode2 != null) {
                    DragAndDropTarget dragAndDropTarget2 = this.thisDragAndDropTarget;
                    if (dragAndDropTarget2 != null) {
                        DragAndDropNodeKt.dispatchEntered(dragAndDropTarget2, event);
                    }
                    dragAndDropModifierNode2.onExited(event);
                } else if (Intrinsics.areEqual(dragAndDropModifierNode, dragAndDropModifierNode2)) {
                    if (dragAndDropModifierNode != null) {
                        DragAndDropNodeKt.dispatchEntered(dragAndDropModifierNode, event);
                    }
                    if (dragAndDropModifierNode2 != null) {
                        dragAndDropModifierNode2.onExited(event);
                    }
                } else if (dragAndDropModifierNode != null) {
                    dragAndDropModifierNode.onMoved(event);
                } else {
                    DragAndDropTarget dragAndDropTarget3 = this.thisDragAndDropTarget;
                    if (dragAndDropTarget3 != null) {
                        dragAndDropTarget3.onMoved(event);
                    }
                }
                this.lastChildDragAndDropModifierNode = dragAndDropModifierNode;
            }
        }
        if (getNode().getIsAttached()) {
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            TraversableNodeKt.traverseDescendants(this, new Function1<DragAndDropNode, TraversableNode$Companion$TraverseDescendantsAction>() { // from class: androidx.compose.ui.draganddrop.DragAndDropNode$onMoved$$inlined$firstDescendantOrNull$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final TraversableNode$Companion$TraverseDescendantsAction invoke(DragAndDropNode dragAndDropNode) {
                    boolean m1259containsUv8p0NA2;
                    DragAndDropNode dragAndDropNode2 = dragAndDropNode;
                    if (DelegatableNodeKt.requireOwner(this).getDragAndDropManager().isInterestedNode(dragAndDropNode2)) {
                        m1259containsUv8p0NA2 = DragAndDropNodeKt.m1259containsUv8p0NA(dragAndDropNode2, DragAndDrop_androidKt.getPositionInRoot(event));
                        if (m1259containsUv8p0NA2) {
                            Ref$ObjectRef.this.element = dragAndDropNode;
                            return TraversableNode$Companion$TraverseDescendantsAction.CancelTraversal;
                        }
                    }
                    return TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                }
            });
            traversableNode = (TraversableNode) ref$ObjectRef.element;
        } else {
            traversableNode = null;
        }
        dragAndDropModifierNode = (DragAndDropModifierNode) traversableNode;
        if (dragAndDropModifierNode == null) {
        }
        if (dragAndDropModifierNode != null) {
        }
        if (Intrinsics.areEqual(dragAndDropModifierNode, dragAndDropModifierNode2)) {
        }
        this.lastChildDragAndDropModifierNode = dragAndDropModifierNode;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onStarted(DragAndDropEvent event) {
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget != null) {
            dragAndDropTarget.onStarted(event);
            return;
        }
        DragAndDropModifierNode dragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
        if (dragAndDropModifierNode != null) {
            dragAndDropModifierNode.onStarted(event);
        }
    }
}
