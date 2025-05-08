package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.SemanticsModifierNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\t\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\f\u001a\u00020\u000b*\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u000e\u001a\u00020\u000b*\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\r\"\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000f*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u0013*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/node/LayoutNode;", "layoutNode", BuildConfig.FLAVOR, "mergingEnabled", "Landroidx/compose/ui/semantics/SemanticsNode;", "SemanticsNode", "(Landroidx/compose/ui/node/LayoutNode;Z)Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Function1;", "selector", "findClosestParentNode", "(Landroidx/compose/ui/node/LayoutNode;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/node/LayoutNode;", BuildConfig.FLAVOR, "contentDescriptionFakeNodeId", "(Landroidx/compose/ui/semantics/SemanticsNode;)I", "roleFakeNodeId", "Landroidx/compose/ui/node/SemanticsModifierNode;", "getOuterMergingSemantics", "(Landroidx/compose/ui/node/LayoutNode;)Landroidx/compose/ui/node/SemanticsModifierNode;", "outerMergingSemantics", "Landroidx/compose/ui/semantics/Role;", "getRole", "(Landroidx/compose/ui/semantics/SemanticsNode;)Landroidx/compose/ui/semantics/Role;", "role", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SemanticsNodeKt {
    public static final SemanticsNode SemanticsNode(LayoutNode layoutNode, boolean z5) {
        int aggregateChildKindSet;
        NodeChain nodes = layoutNode.getNodes();
        int m2074constructorimpl = NodeKind.m2074constructorimpl(8);
        aggregateChildKindSet = nodes.getAggregateChildKindSet();
        Object obj = null;
        if ((aggregateChildKindSet & m2074constructorimpl) != 0) {
            Modifier.Node head = nodes.getHead();
            loop0: while (true) {
                if (head == null) {
                    break;
                }
                if ((head.getKindSet() & m2074constructorimpl) != 0) {
                    Modifier.Node node = head;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof SemanticsModifierNode) {
                            obj = node;
                            break loop0;
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
                }
                if ((head.getAggregateChildKindSet() & m2074constructorimpl) == 0) {
                    break;
                }
                head = head.getChild();
            }
        }
        Intrinsics.checkNotNull(obj);
        Modifier.Node node2 = ((SemanticsModifierNode) obj).getNode();
        SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
        Intrinsics.checkNotNull(collapsedSemantics$ui_release);
        return new SemanticsNode(node2, z5, layoutNode, collapsedSemantics$ui_release);
    }

    public static final int contentDescriptionFakeNodeId(SemanticsNode semanticsNode) {
        return semanticsNode.getId() + 2000000000;
    }

    public static final LayoutNode findClosestParentNode(LayoutNode layoutNode, Function1<? super LayoutNode, Boolean> function1) {
        for (LayoutNode parent$ui_release = layoutNode.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (function1.invoke(parent$ui_release).booleanValue()) {
                return parent$ui_release;
            }
        }
        return null;
    }

    public static final SemanticsModifierNode getOuterMergingSemantics(LayoutNode layoutNode) {
        int aggregateChildKindSet;
        NodeChain nodes = layoutNode.getNodes();
        int m2074constructorimpl = NodeKind.m2074constructorimpl(8);
        aggregateChildKindSet = nodes.getAggregateChildKindSet();
        Object obj = null;
        if ((aggregateChildKindSet & m2074constructorimpl) != 0) {
            Modifier.Node head = nodes.getHead();
            loop0: while (true) {
                if (head == null) {
                    break;
                }
                if ((head.getKindSet() & m2074constructorimpl) != 0) {
                    Modifier.Node node = head;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof SemanticsModifierNode) {
                            if (((SemanticsModifierNode) node).getMergeDescendants()) {
                                obj = node;
                                break loop0;
                            }
                        } else if ((node.getKindSet() & m2074constructorimpl) != 0 && (node instanceof DelegatingNode)) {
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
                }
                if ((head.getAggregateChildKindSet() & m2074constructorimpl) == 0) {
                    break;
                }
                head = head.getChild();
            }
        }
        return (SemanticsModifierNode) obj;
    }

    public static final Role getRole(SemanticsNode semanticsNode) {
        return (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
    }

    public static final int roleFakeNodeId(SemanticsNode semanticsNode) {
        return semanticsNode.getId() + 1000000000;
    }
}
