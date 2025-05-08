package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0002cdB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJG\u0010\u0019\u001a\u00060\u0018R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJC\u0010!\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u000bJ\u0017\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\u000bJ\u001f\u0010(\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010*\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010+J'\u0010.\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00104\u001a\u00020\f2\u0006\u00101\u001a\u000200H\u0000¢\u0006\u0004\b2\u00103J\u000f\u00106\u001a\u00020\fH\u0000¢\u0006\u0004\b5\u0010\u000eJ\r\u00107\u001a\u00020\f¢\u0006\u0004\b7\u0010\u000eJ\r\u00108\u001a\u00020\f¢\u0006\u0004\b8\u0010\u000eJ\r\u00109\u001a\u00020\f¢\u0006\u0004\b9\u0010\u000eJ\u000f\u0010;\u001a\u00020\fH\u0000¢\u0006\u0004\b:\u0010\u000eJ\u000f\u0010=\u001a\u00020\fH\u0000¢\u0006\u0004\b<\u0010\u000eJ\u001e\u0010B\u001a\u00020\u00162\n\u0010?\u001a\u0006\u0012\u0002\b\u00030>H\u0000ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\u00162\u0006\u0010C\u001a\u00020\u0010H\u0000¢\u0006\u0004\bD\u0010AJ\u000f\u0010F\u001a\u00020EH\u0016¢\u0006\u0004\bF\u0010GR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010H\u001a\u0004\bI\u0010JR\u001a\u0010L\u001a\u00020K8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR$\u0010Q\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020\u001c8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u001a\u0010 \u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b \u0010U\u001a\u0004\bV\u0010\bR$\u0010\u000f\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u00068\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u000f\u0010U\u001a\u0004\bW\u0010\bR\u001e\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u001e\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010YR\u001c\u0010[\u001a\b\u0018\u00010\u0018R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010^\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010b\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b`\u0010a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006e"}, d2 = {"Landroidx/compose/ui/node/NodeChain;", BuildConfig.FLAVOR, "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", "Landroidx/compose/ui/Modifier$Node;", "padChain", "()Landroidx/compose/ui/Modifier$Node;", "paddedHead", "trimChain", "(Landroidx/compose/ui/Modifier$Node;)Landroidx/compose/ui/Modifier$Node;", BuildConfig.FLAVOR, "syncAggregateChildKindSet", "()V", "head", BuildConfig.FLAVOR, "offset", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "before", "after", BuildConfig.FLAVOR, "shouldAttachOnInsert", "Landroidx/compose/ui/node/NodeChain$Differ;", "getDiffer", "(Landroidx/compose/ui/Modifier$Node;ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/runtime/collection/MutableVector;Z)Landroidx/compose/ui/node/NodeChain$Differ;", "start", "Landroidx/compose/ui/node/NodeCoordinator;", "coordinator", "propagateCoordinator", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/node/NodeCoordinator;)V", "tail", "structuralUpdate", "(ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/runtime/collection/MutableVector;Landroidx/compose/ui/Modifier$Node;Z)V", "node", "detachAndRemoveNode", "removeNode", "element", "parent", "createAndInsertNodeAsChild", "(Landroidx/compose/ui/Modifier$Element;Landroidx/compose/ui/Modifier$Node;)Landroidx/compose/ui/Modifier$Node;", "insertChild", "(Landroidx/compose/ui/Modifier$Node;Landroidx/compose/ui/Modifier$Node;)Landroidx/compose/ui/Modifier$Node;", "prev", "next", "updateNode", "(Landroidx/compose/ui/Modifier$Element;Landroidx/compose/ui/Modifier$Element;Landroidx/compose/ui/Modifier$Node;)V", "Landroidx/compose/ui/Modifier;", "m", "updateFrom$ui_release", "(Landroidx/compose/ui/Modifier;)V", "updateFrom", "resetState$ui_release", "resetState", "syncCoordinators", "markAsAttached", "runAttachLifecycle", "markAsDetached$ui_release", "markAsDetached", "runDetachLifecycle$ui_release", "runDetachLifecycle", "Landroidx/compose/ui/node/NodeKind;", "type", "has-H91voCI$ui_release", "(I)Z", "has", "mask", "has$ui_release", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/InnerNodeCoordinator;", "innerCoordinator", "Landroidx/compose/ui/node/InnerNodeCoordinator;", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/InnerNodeCoordinator;", "<set-?>", "outerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getOuterCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/Modifier$Node;", "getTail$ui_release", "getHead$ui_release", "current", "Landroidx/compose/runtime/collection/MutableVector;", "buffer", "cachedDiffer", "Landroidx/compose/ui/node/NodeChain$Differ;", "Landroidx/compose/ui/node/NodeChain$Logger;", "logger", "Landroidx/compose/ui/node/NodeChain$Logger;", "getAggregateChildKindSet", "()I", "aggregateChildKindSet", "Differ", "Logger", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NodeChain {
    private MutableVector<Modifier.Element> buffer;
    private Differ cachedDiffer;
    private MutableVector<Modifier.Element> current;
    private Modifier.Node head;
    private final InnerNodeCoordinator innerCoordinator;
    private final LayoutNode layoutNode;
    private Logger logger;
    private NodeCoordinator outerCoordinator;
    private final Modifier.Node tail;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u001c\b\u0082\u0004\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0014R(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\"\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006."}, d2 = {"Landroidx/compose/ui/node/NodeChain$Differ;", "Landroidx/compose/ui/node/DiffCallback;", "Landroidx/compose/ui/Modifier$Node;", "node", BuildConfig.FLAVOR, "offset", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "before", "after", BuildConfig.FLAVOR, "shouldAttachOnInsert", "<init>", "(Landroidx/compose/ui/node/NodeChain;Landroidx/compose/ui/Modifier$Node;ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/runtime/collection/MutableVector;Z)V", "oldIndex", "newIndex", "areItemsTheSame", "(II)Z", BuildConfig.FLAVOR, "insert", "(I)V", "atIndex", "remove", "(II)V", "same", "Landroidx/compose/ui/Modifier$Node;", "getNode", "()Landroidx/compose/ui/Modifier$Node;", "setNode", "(Landroidx/compose/ui/Modifier$Node;)V", "I", "getOffset", "()I", "setOffset", "Landroidx/compose/runtime/collection/MutableVector;", "getBefore", "()Landroidx/compose/runtime/collection/MutableVector;", "setBefore", "(Landroidx/compose/runtime/collection/MutableVector;)V", "getAfter", "setAfter", "Z", "getShouldAttachOnInsert", "()Z", "setShouldAttachOnInsert", "(Z)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class Differ implements DiffCallback {
        private MutableVector<Modifier.Element> after;
        private MutableVector<Modifier.Element> before;
        private Modifier.Node node;
        private int offset;
        private boolean shouldAttachOnInsert;

        public Differ(Modifier.Node node, int i5, MutableVector<Modifier.Element> mutableVector, MutableVector<Modifier.Element> mutableVector2, boolean z5) {
            this.node = node;
            this.offset = i5;
            this.before = mutableVector;
            this.after = mutableVector2;
            this.shouldAttachOnInsert = z5;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public boolean areItemsTheSame(int oldIndex, int newIndex) {
            return NodeChainKt.actionForModifiers(this.before.getContent()[this.offset + oldIndex], this.after.getContent()[this.offset + newIndex]) != 0;
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void insert(int newIndex) {
            int i5 = this.offset + newIndex;
            this.node = NodeChain.this.createAndInsertNodeAsChild(this.after.getContent()[i5], this.node);
            NodeChain.access$getLogger$p(NodeChain.this);
            if (!this.shouldAttachOnInsert) {
                this.node.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
                return;
            }
            Modifier.Node child = this.node.getChild();
            Intrinsics.checkNotNull(child);
            NodeCoordinator coordinator = child.getCoordinator();
            Intrinsics.checkNotNull(coordinator);
            LayoutModifierNode asLayoutModifierNode = DelegatableNodeKt.asLayoutModifierNode(this.node);
            if (asLayoutModifierNode != null) {
                LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(NodeChain.this.getLayoutNode(), asLayoutModifierNode);
                this.node.updateCoordinator$ui_release(layoutModifierNodeCoordinator);
                NodeChain.this.propagateCoordinator(this.node, layoutModifierNodeCoordinator);
                layoutModifierNodeCoordinator.setWrappedBy$ui_release(coordinator.getWrappedBy());
                layoutModifierNodeCoordinator.setWrapped$ui_release(coordinator);
                coordinator.setWrappedBy$ui_release(layoutModifierNodeCoordinator);
            } else {
                this.node.updateCoordinator$ui_release(coordinator);
            }
            this.node.markAsAttached$ui_release();
            this.node.runAttachLifecycle$ui_release();
            NodeKindKt.autoInvalidateInsertedNode(this.node);
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void remove(int atIndex, int oldIndex) {
            Modifier.Node child = this.node.getChild();
            Intrinsics.checkNotNull(child);
            NodeChain.access$getLogger$p(NodeChain.this);
            if ((NodeKind.m2074constructorimpl(2) & child.getKindSet()) != 0) {
                NodeCoordinator coordinator = child.getCoordinator();
                Intrinsics.checkNotNull(coordinator);
                NodeCoordinator wrappedBy = coordinator.getWrappedBy();
                NodeCoordinator wrapped = coordinator.getWrapped();
                Intrinsics.checkNotNull(wrapped);
                if (wrappedBy != null) {
                    wrappedBy.setWrapped$ui_release(wrapped);
                }
                wrapped.setWrappedBy$ui_release(wrappedBy);
                NodeChain.this.propagateCoordinator(this.node, wrapped);
            }
            this.node = NodeChain.this.detachAndRemoveNode(child);
        }

        @Override // androidx.compose.ui.node.DiffCallback
        public void same(int oldIndex, int newIndex) {
            Modifier.Node child = this.node.getChild();
            Intrinsics.checkNotNull(child);
            this.node = child;
            MutableVector<Modifier.Element> mutableVector = this.before;
            Modifier.Element element = mutableVector.getContent()[this.offset + oldIndex];
            MutableVector<Modifier.Element> mutableVector2 = this.after;
            Modifier.Element element2 = mutableVector2.getContent()[this.offset + newIndex];
            if (Intrinsics.areEqual(element, element2)) {
                NodeChain.access$getLogger$p(NodeChain.this);
            } else {
                NodeChain.this.updateNode(element, element2, this.node);
                NodeChain.access$getLogger$p(NodeChain.this);
            }
        }

        public final void setAfter(MutableVector<Modifier.Element> mutableVector) {
            this.after = mutableVector;
        }

        public final void setBefore(MutableVector<Modifier.Element> mutableVector) {
            this.before = mutableVector;
        }

        public final void setNode(Modifier.Node node) {
            this.node = node;
        }

        public final void setOffset(int i5) {
            this.offset = i5;
        }

        public final void setShouldAttachOnInsert(boolean z5) {
            this.shouldAttachOnInsert = z5;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b`\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeChain$Logger;", BuildConfig.FLAVOR, "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Logger {
    }

    public NodeChain(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
        InnerNodeCoordinator innerNodeCoordinator = new InnerNodeCoordinator(layoutNode);
        this.innerCoordinator = innerNodeCoordinator;
        this.outerCoordinator = innerNodeCoordinator;
        TailModifierNode tail = innerNodeCoordinator.getTail();
        this.tail = tail;
        this.head = tail;
    }

    public static final /* synthetic */ Logger access$getLogger$p(NodeChain nodeChain) {
        nodeChain.getClass();
        return null;
    }

    public final Modifier.Node createAndInsertNodeAsChild(Modifier.Element element, Modifier.Node parent) {
        Modifier.Node backwardsCompatNode;
        if (element instanceof ModifierNodeElement) {
            backwardsCompatNode = ((ModifierNodeElement) element).getNode();
            backwardsCompatNode.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFromIncludingDelegates(backwardsCompatNode));
        } else {
            backwardsCompatNode = new BackwardsCompatNode(element);
        }
        if (backwardsCompatNode.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("A ModifierNodeElement cannot return an already attached node from create() ");
        }
        backwardsCompatNode.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
        return insertChild(backwardsCompatNode, parent);
    }

    public final Modifier.Node detachAndRemoveNode(Modifier.Node node) {
        if (node.getIsAttached()) {
            NodeKindKt.autoInvalidateRemovedNode(node);
            node.runDetachLifecycle$ui_release();
            node.markAsDetached$ui_release();
        }
        return removeNode(node);
    }

    public final int getAggregateChildKindSet() {
        return this.head.getAggregateChildKindSet();
    }

    private final Differ getDiffer(Modifier.Node head, int offset, MutableVector<Modifier.Element> before, MutableVector<Modifier.Element> after, boolean shouldAttachOnInsert) {
        Differ differ = this.cachedDiffer;
        if (differ == null) {
            Differ differ2 = new Differ(head, offset, before, after, shouldAttachOnInsert);
            this.cachedDiffer = differ2;
            return differ2;
        }
        differ.setNode(head);
        differ.setOffset(offset);
        differ.setBefore(before);
        differ.setAfter(after);
        differ.setShouldAttachOnInsert(shouldAttachOnInsert);
        return differ;
    }

    private final Modifier.Node insertChild(Modifier.Node node, Modifier.Node parent) {
        Modifier.Node child = parent.getChild();
        if (child != null) {
            child.setParent$ui_release(node);
            node.setChild$ui_release(child);
        }
        parent.setChild$ui_release(node);
        node.setParent$ui_release(parent);
        return node;
    }

    private final Modifier.Node padChain() {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$12;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$13;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$14;
        Modifier.Node node = this.head;
        nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
        if (!(node != nodeChainKt$SentinelHead$1)) {
            InlineClassHelperKt.throwIllegalStateException("padChain called on already padded chain");
        }
        Modifier.Node node2 = this.head;
        nodeChainKt$SentinelHead$12 = NodeChainKt.SentinelHead;
        node2.setParent$ui_release(nodeChainKt$SentinelHead$12);
        nodeChainKt$SentinelHead$13 = NodeChainKt.SentinelHead;
        nodeChainKt$SentinelHead$13.setChild$ui_release(node2);
        nodeChainKt$SentinelHead$14 = NodeChainKt.SentinelHead;
        return nodeChainKt$SentinelHead$14;
    }

    public final void propagateCoordinator(Modifier.Node start, NodeCoordinator coordinator) {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        for (Modifier.Node parent = start.getParent(); parent != null; parent = parent.getParent()) {
            nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
            if (parent == nodeChainKt$SentinelHead$1) {
                LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
                coordinator.setWrappedBy$ui_release(parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null);
                this.outerCoordinator = coordinator;
                return;
            } else {
                if ((NodeKind.m2074constructorimpl(2) & parent.getKindSet()) != 0) {
                    return;
                }
                parent.updateCoordinator$ui_release(coordinator);
            }
        }
    }

    private final Modifier.Node removeNode(Modifier.Node node) {
        Modifier.Node child = node.getChild();
        Modifier.Node parent = node.getParent();
        if (child != null) {
            child.setParent$ui_release(parent);
            node.setChild$ui_release(null);
        }
        if (parent != null) {
            parent.setChild$ui_release(child);
            node.setParent$ui_release(null);
        }
        Intrinsics.checkNotNull(parent);
        return parent;
    }

    private final void structuralUpdate(int offset, MutableVector<Modifier.Element> before, MutableVector<Modifier.Element> after, Modifier.Node tail, boolean shouldAttachOnInsert) {
        MyersDiffKt.executeDiff(before.getSize() - offset, after.getSize() - offset, getDiffer(tail, offset, before, after, shouldAttachOnInsert));
        syncAggregateChildKindSet();
    }

    private final void syncAggregateChildKindSet() {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        int i5 = 0;
        for (Modifier.Node parent = this.tail.getParent(); parent != null; parent = parent.getParent()) {
            nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
            if (parent == nodeChainKt$SentinelHead$1) {
                return;
            }
            i5 |= parent.getKindSet();
            parent.setAggregateChildKindSet$ui_release(i5);
        }
    }

    private final Modifier.Node trimChain(Modifier.Node paddedHead) {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$12;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$13;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$14;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$15;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$16;
        nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
        if (!(paddedHead == nodeChainKt$SentinelHead$1)) {
            InlineClassHelperKt.throwIllegalStateException("trimChain called on already trimmed chain");
        }
        nodeChainKt$SentinelHead$12 = NodeChainKt.SentinelHead;
        Modifier.Node child = nodeChainKt$SentinelHead$12.getChild();
        if (child == null) {
            child = this.tail;
        }
        child.setParent$ui_release(null);
        nodeChainKt$SentinelHead$13 = NodeChainKt.SentinelHead;
        nodeChainKt$SentinelHead$13.setChild$ui_release(null);
        nodeChainKt$SentinelHead$14 = NodeChainKt.SentinelHead;
        nodeChainKt$SentinelHead$14.setAggregateChildKindSet$ui_release(-1);
        nodeChainKt$SentinelHead$15 = NodeChainKt.SentinelHead;
        nodeChainKt$SentinelHead$15.updateCoordinator$ui_release(null);
        nodeChainKt$SentinelHead$16 = NodeChainKt.SentinelHead;
        if (!(child != nodeChainKt$SentinelHead$16)) {
            InlineClassHelperKt.throwIllegalStateException("trimChain did not update the head");
        }
        return child;
    }

    public final void updateNode(Modifier.Element prev, Modifier.Element next, Modifier.Node node) {
        if ((prev instanceof ModifierNodeElement) && (next instanceof ModifierNodeElement)) {
            NodeChainKt.updateUnsafe((ModifierNodeElement) next, node);
            if (node.getIsAttached()) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
                return;
            } else {
                node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                return;
            }
        }
        if (!(node instanceof BackwardsCompatNode)) {
            throw new IllegalStateException("Unknown Modifier.Node type");
        }
        ((BackwardsCompatNode) node).setElement(next);
        if (node.getIsAttached()) {
            NodeKindKt.autoInvalidateUpdatedNode(node);
        } else {
            node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
        }
    }

    /* renamed from: getHead$ui_release, reason: from getter */
    public final Modifier.Node getHead() {
        return this.head;
    }

    /* renamed from: getInnerCoordinator$ui_release, reason: from getter */
    public final InnerNodeCoordinator getInnerCoordinator() {
        return this.innerCoordinator;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    /* renamed from: getOuterCoordinator$ui_release, reason: from getter */
    public final NodeCoordinator getOuterCoordinator() {
        return this.outerCoordinator;
    }

    /* renamed from: getTail$ui_release, reason: from getter */
    public final Modifier.Node getTail() {
        return this.tail;
    }

    public final boolean has$ui_release(int mask) {
        return (mask & getAggregateChildKindSet()) != 0;
    }

    /* renamed from: has-H91voCI$ui_release */
    public final boolean m2042hasH91voCI$ui_release(int type) {
        return (type & getAggregateChildKindSet()) != 0;
    }

    public final void markAsAttached() {
        for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
            head.markAsAttached$ui_release();
        }
    }

    public final void markAsDetached$ui_release() {
        for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
            if (tail.getIsAttached()) {
                tail.markAsDetached$ui_release();
            }
        }
    }

    public final void resetState$ui_release() {
        for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
            if (tail.getIsAttached()) {
                tail.reset$ui_release();
            }
        }
        runDetachLifecycle$ui_release();
        markAsDetached$ui_release();
    }

    public final void runAttachLifecycle() {
        for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
            head.runAttachLifecycle$ui_release();
            if (head.getInsertedNodeAwaitingAttachForInvalidation()) {
                NodeKindKt.autoInvalidateInsertedNode(head);
            }
            if (head.getUpdatedNodeAwaitingAttachForInvalidation()) {
                NodeKindKt.autoInvalidateUpdatedNode(head);
            }
            head.setInsertedNodeAwaitingAttachForInvalidation$ui_release(false);
            head.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(false);
        }
    }

    public final void runDetachLifecycle$ui_release() {
        for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
            if (tail.getIsAttached()) {
                tail.runDetachLifecycle$ui_release();
            }
        }
    }

    public final void syncCoordinators() {
        NodeCoordinator layoutModifierNodeCoordinator;
        NodeCoordinator nodeCoordinator = this.innerCoordinator;
        for (Modifier.Node parent = this.tail.getParent(); parent != null; parent = parent.getParent()) {
            LayoutModifierNode asLayoutModifierNode = DelegatableNodeKt.asLayoutModifierNode(parent);
            if (asLayoutModifierNode != null) {
                if (parent.getCoordinator() != null) {
                    NodeCoordinator coordinator = parent.getCoordinator();
                    Intrinsics.checkNotNull(coordinator, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) coordinator;
                    LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.getLayoutModifierNode();
                    layoutModifierNodeCoordinator.setLayoutModifierNode$ui_release(asLayoutModifierNode);
                    if (layoutModifierNode != parent) {
                        layoutModifierNodeCoordinator.onLayoutModifierNodeChanged();
                    }
                } else {
                    layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(this.layoutNode, asLayoutModifierNode);
                    parent.updateCoordinator$ui_release(layoutModifierNodeCoordinator);
                }
                nodeCoordinator.setWrappedBy$ui_release(layoutModifierNodeCoordinator);
                layoutModifierNodeCoordinator.setWrapped$ui_release(nodeCoordinator);
                nodeCoordinator = layoutModifierNodeCoordinator;
            } else {
                parent.updateCoordinator$ui_release(nodeCoordinator);
            }
        }
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        nodeCoordinator.setWrappedBy$ui_release(parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null);
        this.outerCoordinator = nodeCoordinator;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (this.head != this.tail) {
            Modifier.Node head = getHead();
            while (true) {
                if (head == null || head == getTail()) {
                    break;
                }
                sb.append(String.valueOf(head));
                if (head.getChild() == this.tail) {
                    sb.append("]");
                    break;
                }
                sb.append(",");
                head = head.getChild();
            }
        } else {
            sb.append("]");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateFrom$ui_release(Modifier m5) {
        MutableVector<Modifier.Element> fillVector;
        Modifier.Node padChain = padChain();
        MutableVector<Modifier.Element> mutableVector = this.current;
        int i5 = 0;
        int size = mutableVector != null ? mutableVector.getSize() : 0;
        MutableVector<Modifier.Element> mutableVector2 = this.buffer;
        if (mutableVector2 == null) {
            mutableVector2 = new MutableVector<>(new Modifier.Element[16], 0);
        }
        fillVector = NodeChainKt.fillVector(m5, mutableVector2);
        MutableVector<Modifier.Element> mutableVector3 = null;
        if (fillVector.getSize() == size) {
            Modifier.Node child = padChain.getChild();
            int i6 = 0;
            while (true) {
                if (child == null || i6 >= size) {
                    break;
                }
                if (mutableVector == null) {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("expected prior modifier list to be non-empty");
                    throw new KotlinNothingValueException();
                }
                Modifier.Element element = mutableVector.getContent()[i6];
                Modifier.Element element2 = fillVector.getContent()[i6];
                int actionForModifiers = NodeChainKt.actionForModifiers(element, element2);
                if (actionForModifiers == 0) {
                    child = child.getParent();
                    break;
                }
                if (actionForModifiers == 1) {
                    updateNode(element, element2, child);
                }
                child = child.getChild();
                i6++;
            }
            Modifier.Node node = child;
            if (i6 < size) {
                if (mutableVector == null) {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("expected prior modifier list to be non-empty");
                    throw new KotlinNothingValueException();
                }
                if (node == null) {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("structuralUpdate requires a non-null tail");
                    throw new KotlinNothingValueException();
                }
                structuralUpdate(i6, mutableVector, fillVector, node, !this.layoutNode.getApplyingModifierOnAttach$ui_release());
                i5 = 1;
            }
            this.current = fillVector;
            if (mutableVector != null) {
                mutableVector.clear();
                mutableVector3 = mutableVector;
            }
            this.buffer = mutableVector3;
            this.head = trimChain(padChain);
            if (i5 != 0) {
                syncCoordinators();
                return;
            }
            return;
        }
        if (this.layoutNode.getApplyingModifierOnAttach$ui_release() && size == 0) {
            Modifier.Node node2 = padChain;
            while (i5 < fillVector.getSize()) {
                node2 = createAndInsertNodeAsChild(fillVector.getContent()[i5], node2);
                i5++;
            }
            syncAggregateChildKindSet();
        } else if (fillVector.getSize() != 0) {
            if (mutableVector == null) {
                mutableVector = new MutableVector<>(new Modifier.Element[16], 0);
            }
            structuralUpdate(0, mutableVector, fillVector, padChain, !this.layoutNode.getApplyingModifierOnAttach$ui_release());
        } else {
            if (mutableVector == null) {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("expected prior modifier list to be non-empty");
                throw new KotlinNothingValueException();
            }
            Modifier.Node child2 = padChain.getChild();
            for (int i7 = 0; child2 != null && i7 < mutableVector.getSize(); i7++) {
                child2 = detachAndRemoveNode(child2).getChild();
            }
            InnerNodeCoordinator innerNodeCoordinator = this.innerCoordinator;
            LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
            innerNodeCoordinator.setWrappedBy$ui_release(parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null);
            this.outerCoordinator = this.innerCoordinator;
            this.current = fillVector;
            if (mutableVector != null) {
            }
            this.buffer = mutableVector3;
            this.head = trimChain(padChain);
            if (i5 != 0) {
            }
        }
        i5 = 1;
        this.current = fillVector;
        if (mutableVector != null) {
        }
        this.buffer = mutableVector3;
        this.head = trimChain(padChain);
        if (i5 != 0) {
        }
    }
}
