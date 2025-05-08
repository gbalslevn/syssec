package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0007\u001a\u00020\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0001H\u0000\u001aF\u0010\u0013\u001a\u0004\u0018\u00010\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0016H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"activeChild", "Landroidx/compose/ui/focus/FocusTargetNode;", "getActiveChild", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusTargetNode;", "isEligibleForFocusSearch", BuildConfig.FLAVOR, "(Landroidx/compose/ui/focus/FocusTargetNode;)Z", "customFocusSearch", "Landroidx/compose/ui/focus/FocusRequester;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "customFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/focus/FocusRequester;", "findActiveFocusNode", "findNonDeactivatedParent", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "focusSearch", "previouslyFocusedRect", "onFound", "Lkotlin/Function1;", "focusSearch-0X8WOeE", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class FocusTraversalKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* renamed from: customFocusSearch--OM-vw8, reason: not valid java name */
    public static final FocusRequester m1307customFocusSearchOMvw8(FocusTargetNode focusTargetNode, int i5, LayoutDirection layoutDirection) {
        FocusRequester end;
        FocusProperties fetchFocusProperties$ui_release = focusTargetNode.fetchFocusProperties$ui_release();
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1283getNextdhqQ8s())) {
            return fetchFocusProperties$ui_release.getNext();
        }
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1284getPreviousdhqQ8s())) {
            return fetchFocusProperties$ui_release.getPrevious();
        }
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1286getUpdhqQ8s())) {
            return fetchFocusProperties$ui_release.getUp();
        }
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1279getDowndhqQ8s())) {
            return fetchFocusProperties$ui_release.getDown();
        }
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1282getLeftdhqQ8s())) {
            int i6 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i6 == 1) {
                end = fetchFocusProperties$ui_release.getStart();
            } else {
                if (i6 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                end = fetchFocusProperties$ui_release.getEnd();
            }
            if (end == FocusRequester.INSTANCE.getDefault()) {
                end = null;
            }
            if (end == null) {
                return fetchFocusProperties$ui_release.getLeft();
            }
        } else {
            if (!FocusDirection.m1275equalsimpl0(i5, companion.m1285getRightdhqQ8s())) {
                if (FocusDirection.m1275equalsimpl0(i5, companion.m1280getEnterdhqQ8s())) {
                    return fetchFocusProperties$ui_release.getEnter().invoke(FocusDirection.m1272boximpl(i5));
                }
                if (FocusDirection.m1275equalsimpl0(i5, companion.m1281getExitdhqQ8s())) {
                    return fetchFocusProperties$ui_release.getExit().invoke(FocusDirection.m1272boximpl(i5));
                }
                throw new IllegalStateException("invalid FocusDirection");
            }
            int i7 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i7 == 1) {
                end = fetchFocusProperties$ui_release.getEnd();
            } else {
                if (i7 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                end = fetchFocusProperties$ui_release.getStart();
            }
            if (end == FocusRequester.INSTANCE.getDefault()) {
                end = null;
            }
            if (end == null) {
                return fetchFocusProperties$ui_release.getRight();
            }
        }
        return end;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x004f, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final FocusTargetNode findActiveFocusNode(FocusTargetNode focusTargetNode) {
        int i5 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i5 != 1) {
            if (i5 == 2) {
                int m2074constructorimpl = NodeKind.m2074constructorimpl(1024);
                if (!focusTargetNode.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitChildren called on an unattached node");
                }
                MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
                Modifier.Node child = focusTargetNode.getNode().getChild();
                if (child == null) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode.getNode());
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
                                        FocusTargetNode findActiveFocusNode = findActiveFocusNode((FocusTargetNode) node);
                                        if (findActiveFocusNode != null) {
                                            return findActiveFocusNode;
                                        }
                                    } else if ((node.getKindSet() & m2074constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                        int i6 = 0;
                                        for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                            if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                                i6++;
                                                if (i6 == 1) {
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
                                        if (i6 == 1) {
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
                return null;
            }
            if (i5 != 3) {
                if (i5 == 4) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return focusTargetNode;
    }

    private static final FocusTargetNode findNonDeactivatedParent(FocusTargetNode focusTargetNode) {
        NodeChain nodes;
        int m2074constructorimpl = NodeKind.m2074constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = focusTargetNode.getNode().getParent();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m2074constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & m2074constructorimpl) != 0) {
                        Modifier.Node node = parent;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) node;
                                if (focusTargetNode2.fetchFocusProperties$ui_release().getCanFocus()) {
                                    return focusTargetNode2;
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
                    parent = parent.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    public static final Rect focusRect(FocusTargetNode focusTargetNode) {
        Rect localBoundingBoxOf;
        NodeCoordinator coordinator = focusTargetNode.getCoordinator();
        return (coordinator == null || (localBoundingBoxOf = LayoutCoordinatesKt.findRootCoordinates(coordinator).localBoundingBoxOf(coordinator, false)) == null) ? Rect.INSTANCE.getZero() : localBoundingBoxOf;
    }

    /* renamed from: focusSearch-0X8WOeE, reason: not valid java name */
    public static final Boolean m1308focusSearch0X8WOeE(FocusTargetNode focusTargetNode, int i5, LayoutDirection layoutDirection, Rect rect, Function1<? super FocusTargetNode, Boolean> function1) {
        int m1285getRightdhqQ8s;
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1283getNextdhqQ8s()) ? true : FocusDirection.m1275equalsimpl0(i5, companion.m1284getPreviousdhqQ8s())) {
            return Boolean.valueOf(OneDimensionalFocusSearchKt.m1311oneDimensionalFocusSearchOMvw8(focusTargetNode, i5, function1));
        }
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1282getLeftdhqQ8s()) ? true : FocusDirection.m1275equalsimpl0(i5, companion.m1285getRightdhqQ8s()) ? true : FocusDirection.m1275equalsimpl0(i5, companion.m1286getUpdhqQ8s()) ? true : FocusDirection.m1275equalsimpl0(i5, companion.m1279getDowndhqQ8s())) {
            return TwoDimensionalFocusSearchKt.m1320twoDimensionalFocusSearchsMXa3k8(focusTargetNode, i5, rect, function1);
        }
        if (!FocusDirection.m1275equalsimpl0(i5, companion.m1280getEnterdhqQ8s())) {
            if (FocusDirection.m1275equalsimpl0(i5, companion.m1281getExitdhqQ8s())) {
                FocusTargetNode findActiveFocusNode = findActiveFocusNode(focusTargetNode);
                FocusTargetNode findNonDeactivatedParent = findActiveFocusNode != null ? findNonDeactivatedParent(findActiveFocusNode) : null;
                return Boolean.valueOf((findNonDeactivatedParent == null || Intrinsics.areEqual(findNonDeactivatedParent, focusTargetNode)) ? false : function1.invoke(findNonDeactivatedParent).booleanValue());
            }
            throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + ((Object) FocusDirection.m1277toStringimpl(i5))).toString());
        }
        int i6 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        if (i6 == 1) {
            m1285getRightdhqQ8s = companion.m1285getRightdhqQ8s();
        } else {
            if (i6 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            m1285getRightdhqQ8s = companion.m1282getLeftdhqQ8s();
        }
        FocusTargetNode findActiveFocusNode2 = findActiveFocusNode(focusTargetNode);
        if (findActiveFocusNode2 != null) {
            return TwoDimensionalFocusSearchKt.m1320twoDimensionalFocusSearchsMXa3k8(findActiveFocusNode2, m1285getRightdhqQ8s, rect, function1);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x003b, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final FocusTargetNode getActiveChild(FocusTargetNode focusTargetNode) {
        if (!focusTargetNode.getNode().getIsAttached()) {
            return null;
        }
        int m2074constructorimpl = NodeKind.m2074constructorimpl(1024);
        if (!focusTargetNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode.getNode());
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
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) node;
                                if (focusTargetNode2.getNode().getIsAttached()) {
                                    int i5 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode2.getFocusState().ordinal()];
                                    if (i5 == 1 || i5 == 2 || i5 == 3) {
                                        return focusTargetNode2;
                                    }
                                }
                            } else if ((node.getKindSet() & m2074constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i6 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                        i6++;
                                        if (i6 == 1) {
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
                                if (i6 == 1) {
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
        return null;
    }

    public static final boolean isEligibleForFocusSearch(FocusTargetNode focusTargetNode) {
        LayoutNode layoutNode;
        NodeCoordinator coordinator;
        LayoutNode layoutNode2;
        NodeCoordinator coordinator2 = focusTargetNode.getCoordinator();
        return (coordinator2 == null || (layoutNode = coordinator2.getLayoutNode()) == null || !layoutNode.isPlaced() || (coordinator = focusTargetNode.getCoordinator()) == null || (layoutNode2 = coordinator.getLayoutNode()) == null || !layoutNode2.isAttached()) ? false : true;
    }
}
