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
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a2\u0010\b\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\t\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\u000b\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\n\u001a:\u0010\u000f\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a:\u0010\u0011\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a'\u0010\u0012\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\n\u001a'\u0010\u0013\u001a\u00020\u0004*\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\n\u001a\u0013\u0010\u0014\u001a\u00020\u0004*\u00020\u0000H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\"\u001a\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u0019\u0010\u001a\"\u001a\u0010\u001b\u001a\u00020\u00168\u0002X\u0082T¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u0012\u0004\b\u001c\u0010\u001a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/focus/FocusDirection;", "direction", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onFound", "oneDimensionalFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "oneDimensionalFocusSearch", "forwardFocusSearch", "(Landroidx/compose/ui/focus/FocusTargetNode;Lkotlin/jvm/functions/Function1;)Z", "backwardFocusSearch", "focusedItem", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "generateAndSearchChildren", "searchChildren-4C6V_qg", "searchChildren", "pickChildForForwardSearch", "pickChildForBackwardSearch", "isRoot", "(Landroidx/compose/ui/focus/FocusTargetNode;)Z", BuildConfig.FLAVOR, "InvalidFocusDirection", "Ljava/lang/String;", "getInvalidFocusDirection$annotations", "()V", "NoActiveChild", "getNoActiveChild$annotations", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class OneDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 1-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final boolean backwardFocusSearch(FocusTargetNode focusTargetNode, Function1<? super FocusTargetNode, Boolean> function1) {
        FocusStateImpl focusState = focusTargetNode.getFocusState();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i5 = iArr[focusState.ordinal()];
        if (i5 == 1) {
            FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
            if (activeChild == null) {
                throw new IllegalStateException(NoActiveChild);
            }
            int i6 = iArr[activeChild.getFocusState().ordinal()];
            if (i6 != 1) {
                if (i6 == 2 || i6 == 3) {
                    return m1310generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, FocusDirection.INSTANCE.m1284getPreviousdhqQ8s(), function1);
                }
                if (i6 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new IllegalStateException(NoActiveChild);
            }
            if (!backwardFocusSearch(activeChild, function1) && !m1310generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, FocusDirection.INSTANCE.m1284getPreviousdhqQ8s(), function1) && (!activeChild.fetchFocusProperties$ui_release().getCanFocus() || !function1.invoke(activeChild).booleanValue())) {
                return false;
            }
        } else {
            if (i5 == 2 || i5 == 3) {
                return pickChildForBackwardSearch(focusTargetNode, function1);
            }
            if (i5 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (!pickChildForBackwardSearch(focusTargetNode, function1)) {
                if (!(focusTargetNode.fetchFocusProperties$ui_release().getCanFocus() ? function1.invoke(focusTargetNode).booleanValue() : false)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static final boolean forwardFocusSearch(FocusTargetNode focusTargetNode, Function1<? super FocusTargetNode, Boolean> function1) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i5 == 1) {
            FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
            if (activeChild != null) {
                return forwardFocusSearch(activeChild, function1) || m1310generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, FocusDirection.INSTANCE.m1283getNextdhqQ8s(), function1);
            }
            throw new IllegalStateException(NoActiveChild);
        }
        if (i5 == 2 || i5 == 3) {
            return pickChildForForwardSearch(focusTargetNode, function1);
        }
        if (i5 == 4) {
            return focusTargetNode.fetchFocusProperties$ui_release().getCanFocus() ? function1.invoke(focusTargetNode).booleanValue() : pickChildForForwardSearch(focusTargetNode, function1);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    private static final boolean m1310generateAndSearchChildren4C6V_qg(final FocusTargetNode focusTargetNode, final FocusTargetNode focusTargetNode2, final int i5, final Function1<? super FocusTargetNode, Boolean> function1) {
        if (m1312searchChildren4C6V_qg(focusTargetNode, focusTargetNode2, i5, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m1271searchBeyondBoundsOMvw8(focusTargetNode, i5, new Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean>() { // from class: androidx.compose.ui.focus.OneDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope beyondBoundsScope) {
                boolean m1312searchChildren4C6V_qg;
                m1312searchChildren4C6V_qg = OneDimensionalFocusSearchKt.m1312searchChildren4C6V_qg(FocusTargetNode.this, focusTargetNode2, i5, function1);
                Boolean valueOf = Boolean.valueOf(m1312searchChildren4C6V_qg);
                if (m1312searchChildren4C6V_qg || !beyondBoundsScope.getHasMoreContent()) {
                    return valueOf;
                }
                return null;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static final boolean isRoot(FocusTargetNode focusTargetNode) {
        Modifier.Node node;
        NodeChain nodes;
        int m2074constructorimpl = NodeKind.m2074constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = focusTargetNode.getNode().getParent();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
        loop0: while (true) {
            node = null;
            if (requireLayoutNode == null) {
                break;
            }
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m2074constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & m2074constructorimpl) != 0) {
                        Modifier.Node node2 = parent;
                        MutableVector mutableVector = null;
                        while (node2 != null) {
                            if (node2 instanceof FocusTargetNode) {
                                node = node2;
                                break loop0;
                            }
                            if ((node2.getKindSet() & m2074constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                int i5 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node2).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                        i5++;
                                        if (i5 == 1) {
                                            node2 = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node2 != null) {
                                                mutableVector.add(node2);
                                                node2 = null;
                                            }
                                            mutableVector.add(delegate);
                                        }
                                    }
                                }
                                if (i5 == 1) {
                                }
                            }
                            node2 = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return node == null;
    }

    /* renamed from: oneDimensionalFocusSearch--OM-vw8, reason: not valid java name */
    public static final boolean m1311oneDimensionalFocusSearchOMvw8(FocusTargetNode focusTargetNode, int i5, Function1<? super FocusTargetNode, Boolean> function1) {
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1283getNextdhqQ8s())) {
            return forwardFocusSearch(focusTargetNode, function1);
        }
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1284getPreviousdhqQ8s())) {
            return backwardFocusSearch(focusTargetNode, function1);
        }
        throw new IllegalStateException(InvalidFocusDirection);
    }

    private static final boolean pickChildForBackwardSearch(FocusTargetNode focusTargetNode, Function1<? super FocusTargetNode, Boolean> function1) {
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        int m2074constructorimpl = NodeKind.m2074constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusTargetNode.getNode());
        } else {
            mutableVector2.add(child);
        }
        while (mutableVector2.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node.getAggregateChildKindSet() & m2074constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    }
                    if ((node.getKindSet() & m2074constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                mutableVector.add((FocusTargetNode) node);
                            } else if ((node.getKindSet() & m2074constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i5 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                        i5++;
                                        if (i5 == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                mutableVector3.add(node);
                                                node = null;
                                            }
                                            mutableVector3.add(delegate);
                                        }
                                    }
                                }
                                if (i5 == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector3);
                        }
                    } else {
                        node = node.getChild();
                    }
                }
            }
        }
        mutableVector.sortWith(FocusableChildrenComparator.INSTANCE);
        int size = mutableVector.getSize();
        if (size > 0) {
            int i6 = size - 1;
            Object[] content = mutableVector.getContent();
            do {
                FocusTargetNode focusTargetNode2 = (FocusTargetNode) content[i6];
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2) && backwardFocusSearch(focusTargetNode2, function1)) {
                    return true;
                }
                i6--;
            } while (i6 >= 0);
        }
        return false;
    }

    private static final boolean pickChildForForwardSearch(FocusTargetNode focusTargetNode, Function1<? super FocusTargetNode, Boolean> function1) {
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        int m2074constructorimpl = NodeKind.m2074constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusTargetNode.getNode());
        } else {
            mutableVector2.add(child);
        }
        while (mutableVector2.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node.getAggregateChildKindSet() & m2074constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    }
                    if ((node.getKindSet() & m2074constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                mutableVector.add((FocusTargetNode) node);
                            } else if ((node.getKindSet() & m2074constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i5 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                        i5++;
                                        if (i5 == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                mutableVector3.add(node);
                                                node = null;
                                            }
                                            mutableVector3.add(delegate);
                                        }
                                    }
                                }
                                if (i5 == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector3);
                        }
                    } else {
                        node = node.getChild();
                    }
                }
            }
        }
        mutableVector.sortWith(FocusableChildrenComparator.INSTANCE);
        int size = mutableVector.getSize();
        if (size <= 0) {
            return false;
        }
        Object[] content = mutableVector.getContent();
        int i6 = 0;
        do {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) content[i6];
            if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2) && forwardFocusSearch(focusTargetNode2, function1)) {
                return true;
            }
            i6++;
        } while (i6 < size);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m1312searchChildren4C6V_qg(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int i5, Function1<? super FocusTargetNode, Boolean> function1) {
        if (focusTargetNode.getFocusState() != FocusStateImpl.ActiveParent) {
            throw new IllegalStateException("This function should only be used within a parent that has focus.");
        }
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        int m2074constructorimpl = NodeKind.m2074constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusTargetNode.getNode());
        } else {
            mutableVector2.add(child);
        }
        while (mutableVector2.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node.getAggregateChildKindSet() & m2074constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    }
                    if ((node.getKindSet() & m2074constructorimpl) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                mutableVector.add((FocusTargetNode) node);
                            } else if ((node.getKindSet() & m2074constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i6 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                        i6++;
                                        if (i6 == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                mutableVector3.add(node);
                                                node = null;
                                            }
                                            mutableVector3.add(delegate);
                                        }
                                    }
                                }
                                if (i6 == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector3);
                        }
                    } else {
                        node = node.getChild();
                    }
                }
            }
        }
        mutableVector.sortWith(FocusableChildrenComparator.INSTANCE);
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1283getNextdhqQ8s())) {
            IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
            int first = intRange.getFirst();
            int last = intRange.getLast();
            if (first <= last) {
                boolean z5 = false;
                while (true) {
                    if (z5) {
                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) mutableVector.getContent()[first];
                        if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode3) && forwardFocusSearch(focusTargetNode3, function1)) {
                            return true;
                        }
                    }
                    if (Intrinsics.areEqual(mutableVector.getContent()[first], focusTargetNode2)) {
                        z5 = true;
                    }
                    if (first == last) {
                        break;
                    }
                    first++;
                }
            }
        } else {
            if (!FocusDirection.m1275equalsimpl0(i5, companion.m1284getPreviousdhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection);
            }
            IntRange intRange2 = new IntRange(0, mutableVector.getSize() - 1);
            int first2 = intRange2.getFirst();
            int last2 = intRange2.getLast();
            if (first2 <= last2) {
                boolean z6 = false;
                while (true) {
                    if (z6) {
                        FocusTargetNode focusTargetNode4 = (FocusTargetNode) mutableVector.getContent()[last2];
                        if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode4) && backwardFocusSearch(focusTargetNode4, function1)) {
                            return true;
                        }
                    }
                    if (Intrinsics.areEqual(mutableVector.getContent()[last2], focusTargetNode2)) {
                        z6 = true;
                    }
                    if (last2 == first2) {
                        break;
                    }
                    last2--;
                }
            }
        }
        if (FocusDirection.m1275equalsimpl0(i5, FocusDirection.INSTANCE.m1283getNextdhqQ8s()) || !focusTargetNode.fetchFocusProperties$ui_release().getCanFocus() || isRoot(focusTargetNode)) {
            return false;
        }
        return function1.invoke(focusTargetNode).booleanValue();
    }
}
