package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusEventModifierNodeKt;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusPropertiesModifierNodeKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTargetNodeKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.semantics.SemanticsModifier;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u000b\u0010\n\u001a\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\f\u0010\n\u001a'\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0010\u001a\u0013\u0010\u0014\u001a\u00020\b*\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0019\u0010\u0007\"\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\"\u001a\u0010\u001e\u001a\u00020\u00028\u0002X\u0082T¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b \u0010!\"\u001a\u0010\"\u001a\u00020\u00028\u0002X\u0082T¢\u0006\f\n\u0004\b\"\u0010\u001f\u0012\u0004\b#\u0010!\"\u001a\u0010$\u001a\u00020\u00028\u0002X\u0082T¢\u0006\f\n\u0004\b$\u0010\u001f\u0012\u0004\b%\u0010!\"\u001c\u0010)\u001a\u00020\u0016*\u0006\u0012\u0002\b\u00030&8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Landroidx/compose/ui/Modifier$Element;", "element", BuildConfig.FLAVOR, "calculateNodeKindSetFrom", "(Landroidx/compose/ui/Modifier$Element;)I", "Landroidx/compose/ui/Modifier$Node;", "node", "(Landroidx/compose/ui/Modifier$Node;)I", BuildConfig.FLAVOR, "autoInvalidateRemovedNode", "(Landroidx/compose/ui/Modifier$Node;)V", "autoInvalidateInsertedNode", "autoInvalidateUpdatedNode", "remainingSet", "phase", "autoInvalidateNodeIncludingDelegates", "(Landroidx/compose/ui/Modifier$Node;II)V", "selfKindSet", "autoInvalidateNodeSelf", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "scheduleInvalidationOfAssociatedFocusTargets", "(Landroidx/compose/ui/focus/FocusPropertiesModifierNode;)V", BuildConfig.FLAVOR, "specifiesCanFocusProperty", "(Landroidx/compose/ui/focus/FocusPropertiesModifierNode;)Z", "calculateNodeKindSetFromIncludingDelegates", "Landroidx/collection/MutableObjectIntMap;", BuildConfig.FLAVOR, "classToKindSetMap", "Landroidx/collection/MutableObjectIntMap;", "Updated", "I", "getUpdated$annotations", "()V", "Inserted", "getInserted$annotations", "Removed", "getRemoved$annotations", "Landroidx/compose/ui/node/NodeKind;", "getIncludeSelfInTraversal-H91voCI", "(I)Z", "includeSelfInTraversal", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class NodeKindKt {
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private static final int Updated = 0;
    private static final MutableObjectIntMap<Object> classToKindSetMap = ObjectIntMapKt.mutableObjectIntMapOf();

    public static final void autoInvalidateInsertedNode(Modifier.Node node) {
        if (!node.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateInsertedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 1);
    }

    public static final void autoInvalidateNodeIncludingDelegates(Modifier.Node node, int i5, int i6) {
        if (!(node instanceof DelegatingNode)) {
            autoInvalidateNodeSelf(node, i5 & node.getKindSet(), i6);
            return;
        }
        DelegatingNode delegatingNode = (DelegatingNode) node;
        autoInvalidateNodeSelf(node, delegatingNode.getSelfKindSet() & i5, i6);
        int i7 = (~delegatingNode.getSelfKindSet()) & i5;
        for (Modifier.Node delegate = delegatingNode.getDelegate(); delegate != null; delegate = delegate.getChild()) {
            autoInvalidateNodeIncludingDelegates(delegate, i7, i6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void autoInvalidateNodeSelf(Modifier.Node node, int i5, int i6) {
        if (i6 != 0 || node.getShouldAutoInvalidate()) {
            if ((NodeKind.m2074constructorimpl(2) & i5) != 0 && (node instanceof LayoutModifierNode)) {
                LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode) node);
                if (i6 == 2) {
                    DelegatableNodeKt.m1990requireCoordinator64DMado(node, NodeKind.m2074constructorimpl(2)).onRelease();
                }
            }
            if ((NodeKind.m2074constructorimpl(128) & i5) != 0 && (node instanceof LayoutAwareModifierNode) && i6 != 2) {
                DelegatableNodeKt.requireLayoutNode(node).invalidateMeasurements$ui_release();
            }
            if ((NodeKind.m2074constructorimpl(256) & i5) != 0 && (node instanceof GlobalPositionAwareModifierNode) && i6 != 2) {
                DelegatableNodeKt.requireLayoutNode(node).invalidateOnPositioned$ui_release();
            }
            if ((NodeKind.m2074constructorimpl(4) & i5) != 0 && (node instanceof DrawModifierNode)) {
                DrawModifierNodeKt.invalidateDraw((DrawModifierNode) node);
            }
            if ((NodeKind.m2074constructorimpl(8) & i5) != 0 && (node instanceof SemanticsModifierNode)) {
                SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode) node);
            }
            if ((NodeKind.m2074constructorimpl(64) & i5) != 0 && (node instanceof ParentDataModifierNode)) {
                ParentDataModifierNodeKt.invalidateParentData((ParentDataModifierNode) node);
            }
            if ((NodeKind.m2074constructorimpl(1024) & i5) != 0 && (node instanceof FocusTargetNode) && i6 != 2) {
                FocusTargetNodeKt.invalidateFocusTarget((FocusTargetNode) node);
            }
            if ((NodeKind.m2074constructorimpl(2048) & i5) != 0 && (node instanceof FocusPropertiesModifierNode)) {
                FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) node;
                if (specifiesCanFocusProperty(focusPropertiesModifierNode)) {
                    if (i6 == 2) {
                        scheduleInvalidationOfAssociatedFocusTargets(focusPropertiesModifierNode);
                    } else {
                        FocusPropertiesModifierNodeKt.invalidateFocusProperties(focusPropertiesModifierNode);
                    }
                }
            }
            if ((i5 & NodeKind.m2074constructorimpl(4096)) == 0 || !(node instanceof FocusEventModifierNode)) {
                return;
            }
            FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode) node);
        }
    }

    public static final void autoInvalidateRemovedNode(Modifier.Node node) {
        if (!node.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateRemovedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 2);
    }

    public static final void autoInvalidateUpdatedNode(Modifier.Node node) {
        if (!node.getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateUpdatedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 0);
    }

    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        if (node.getKindSet() != 0) {
            return node.getKindSet();
        }
        MutableObjectIntMap<Object> mutableObjectIntMap = classToKindSetMap;
        Object classKeyForObject = Actual_jvmKt.classKeyForObject(node);
        int findKeyIndex = mutableObjectIntMap.findKeyIndex(classKeyForObject);
        if (findKeyIndex >= 0) {
            return mutableObjectIntMap.values[findKeyIndex];
        }
        int m2074constructorimpl = NodeKind.m2074constructorimpl(1);
        if (node instanceof LayoutModifierNode) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(2);
        }
        if (node instanceof DrawModifierNode) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(4);
        }
        if (node instanceof SemanticsModifierNode) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(8);
        }
        if (node instanceof PointerInputModifierNode) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(16);
        }
        if (node instanceof ModifierLocalModifierNode) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(32);
        }
        if (node instanceof ParentDataModifierNode) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(64);
        }
        if (node instanceof LayoutAwareModifierNode) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(128);
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(256);
        }
        if (node instanceof FocusTargetNode) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(1024);
        }
        if (node instanceof FocusPropertiesModifierNode) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(2048);
        }
        if (node instanceof FocusEventModifierNode) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(4096);
        }
        if (node instanceof KeyInputModifierNode) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(8192);
        }
        if (node instanceof RotaryInputModifierNode) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(16384);
        }
        if (node instanceof CompositionLocalConsumerModifierNode) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(32768);
        }
        int m2074constructorimpl2 = node instanceof TraversableNode ? NodeKind.m2074constructorimpl(262144) | m2074constructorimpl : m2074constructorimpl;
        mutableObjectIntMap.set(classKeyForObject, m2074constructorimpl2);
        return m2074constructorimpl2;
    }

    public static final int calculateNodeKindSetFromIncludingDelegates(Modifier.Node node) {
        if (!(node instanceof DelegatingNode)) {
            return calculateNodeKindSetFrom(node);
        }
        DelegatingNode delegatingNode = (DelegatingNode) node;
        int selfKindSet = delegatingNode.getSelfKindSet();
        for (Modifier.Node delegate = delegatingNode.getDelegate(); delegate != null; delegate = delegate.getChild()) {
            selfKindSet |= calculateNodeKindSetFromIncludingDelegates(delegate);
        }
        return selfKindSet;
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI, reason: not valid java name */
    public static final boolean m2075getIncludeSelfInTraversalH91voCI(int i5) {
        return (i5 & NodeKind.m2074constructorimpl(128)) != 0;
    }

    private static final void scheduleInvalidationOfAssociatedFocusTargets(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        int m2074constructorimpl = NodeKind.m2074constructorimpl(1024);
        if (!focusPropertiesModifierNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusPropertiesModifierNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusPropertiesModifierNode.getNode());
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & m2074constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    }
                    if ((node.getKindSet() & m2074constructorimpl) != 0) {
                        MutableVector mutableVector2 = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNodeKt.invalidateFocusTarget((FocusTargetNode) node);
                            } else if ((node.getKindSet() & m2074constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i5 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                        i5++;
                                        if (i5 == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                mutableVector2.add(node);
                                                node = null;
                                            }
                                            mutableVector2.add(delegate);
                                        }
                                    }
                                }
                                if (i5 == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector2);
                        }
                    } else {
                        node = node.getChild();
                    }
                }
            }
        }
    }

    private static final boolean specifiesCanFocusProperty(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        CanFocusChecker canFocusChecker = CanFocusChecker.INSTANCE;
        canFocusChecker.reset();
        focusPropertiesModifierNode.applyFocusProperties(canFocusChecker);
        return canFocusChecker.isCanFocusSet();
    }

    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        int m2074constructorimpl = NodeKind.m2074constructorimpl(1);
        if (element instanceof LayoutModifier) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(2);
        }
        if (element instanceof DrawModifier) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(4);
        }
        if (element instanceof SemanticsModifier) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(8);
        }
        if (element instanceof PointerInputModifier) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(16);
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider)) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(32);
        }
        if (element instanceof OnGloballyPositionedModifier) {
            m2074constructorimpl |= NodeKind.m2074constructorimpl(256);
        }
        return element instanceof ParentDataModifier ? m2074constructorimpl | NodeKind.m2074constructorimpl(64) : m2074constructorimpl;
    }
}
