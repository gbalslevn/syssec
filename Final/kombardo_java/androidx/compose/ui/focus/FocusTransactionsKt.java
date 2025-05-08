package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a \u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\b\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\u0003\u001a%\u0010\u000b\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\r\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u0003\u001a'\u0010\u000e\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000e\u0010\f\u001a\u001b\u0010\u0010\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0013\u0010\u0012\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0003\u001a\u0013\u0010\u0013\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0018\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001e\u0010\u001a\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017\u001a\u001e\u0010\u001c\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0017\u001a\u001e\u0010\u001e\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0017\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetNode;", BuildConfig.FLAVOR, "requestFocus", "(Landroidx/compose/ui/focus/FocusTargetNode;)Z", "Landroidx/compose/ui/focus/FocusDirection;", "focusDirection", "requestFocus-Mxy_nc0", "(Landroidx/compose/ui/focus/FocusTargetNode;I)Ljava/lang/Boolean;", "performRequestFocus", "forced", "refreshFocusEvents", "clearFocus", "(Landroidx/compose/ui/focus/FocusTargetNode;ZZ)Z", "grantFocus", "clearChildFocus", "childNode", "requestFocusForChild", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/focus/FocusTargetNode;)Z", "requestFocusForOwner", "requireActiveChild", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/focus/CustomDestinationResult;", "performCustomRequestFocus-Mxy_nc0", "(Landroidx/compose/ui/focus/FocusTargetNode;I)Landroidx/compose/ui/focus/CustomDestinationResult;", "performCustomRequestFocus", "performCustomClearFocus-Mxy_nc0", "performCustomClearFocus", "performCustomEnter-Mxy_nc0", "performCustomEnter", "performCustomExit-Mxy_nc0", "performCustomExit", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class FocusTransactionsKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private static final boolean clearChildFocus(FocusTargetNode focusTargetNode, boolean z5, boolean z6) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            return clearFocus(activeChild, z5, z6);
        }
        return true;
    }

    static /* synthetic */ boolean clearChildFocus$default(FocusTargetNode focusTargetNode, boolean z5, boolean z6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        if ((i5 & 2) != 0) {
            z6 = true;
        }
        return clearChildFocus(focusTargetNode, z5, z6);
    }

    public static final boolean clearFocus(FocusTargetNode focusTargetNode, boolean z5, boolean z6) {
        int i5 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i5 == 1) {
            focusTargetNode.setFocusState(FocusStateImpl.Inactive);
            if (z6) {
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            }
        } else {
            if (i5 == 2) {
                if (!z5) {
                    return z5;
                }
                focusTargetNode.setFocusState(FocusStateImpl.Inactive);
                if (!z6) {
                    return z5;
                }
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                return z5;
            }
            if (i5 != 3) {
                if (i5 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (!clearChildFocus(focusTargetNode, z5, z6)) {
                    return false;
                }
                focusTargetNode.setFocusState(FocusStateImpl.Inactive);
                if (z6) {
                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                }
            }
        }
        return true;
    }

    private static final boolean grantFocus(final FocusTargetNode focusTargetNode) {
        ObserverModifierNodeKt.observeReads(focusTargetNode, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$grantFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FocusTargetNode.this.fetchFocusProperties$ui_release();
            }
        });
        int i5 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i5 != 3 && i5 != 4) {
            return true;
        }
        focusTargetNode.setFocusState(FocusStateImpl.Active);
        return true;
    }

    /* renamed from: performCustomClearFocus-Mxy_nc0, reason: not valid java name */
    public static final CustomDestinationResult m1302performCustomClearFocusMxy_nc0(FocusTargetNode focusTargetNode, int i5) {
        int i6 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i6 != 1) {
            if (i6 == 2) {
                return CustomDestinationResult.Cancelled;
            }
            if (i6 == 3) {
                CustomDestinationResult m1302performCustomClearFocusMxy_nc0 = m1302performCustomClearFocusMxy_nc0(requireActiveChild(focusTargetNode), i5);
                if (m1302performCustomClearFocusMxy_nc0 == CustomDestinationResult.None) {
                    m1302performCustomClearFocusMxy_nc0 = null;
                }
                return m1302performCustomClearFocusMxy_nc0 == null ? m1304performCustomExitMxy_nc0(focusTargetNode, i5) : m1302performCustomClearFocusMxy_nc0;
            }
            if (i6 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return CustomDestinationResult.None;
    }

    /* renamed from: performCustomEnter-Mxy_nc0, reason: not valid java name */
    private static final CustomDestinationResult m1303performCustomEnterMxy_nc0(FocusTargetNode focusTargetNode, int i5) {
        boolean z5;
        z5 = focusTargetNode.isProcessingCustomEnter;
        if (!z5) {
            focusTargetNode.isProcessingCustomEnter = true;
            try {
                FocusRequester invoke = focusTargetNode.fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m1272boximpl(i5));
                FocusRequester.Companion companion = FocusRequester.INSTANCE;
                if (invoke != companion.getDefault()) {
                    if (invoke == companion.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    return invoke.focus$ui_release() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.isProcessingCustomEnter = false;
            }
        }
        return CustomDestinationResult.None;
    }

    /* renamed from: performCustomExit-Mxy_nc0, reason: not valid java name */
    private static final CustomDestinationResult m1304performCustomExitMxy_nc0(FocusTargetNode focusTargetNode, int i5) {
        boolean z5;
        z5 = focusTargetNode.isProcessingCustomExit;
        if (!z5) {
            focusTargetNode.isProcessingCustomExit = true;
            try {
                FocusRequester invoke = focusTargetNode.fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.m1272boximpl(i5));
                FocusRequester.Companion companion = FocusRequester.INSTANCE;
                if (invoke != companion.getDefault()) {
                    if (invoke == companion.getCancel()) {
                        return CustomDestinationResult.Cancelled;
                    }
                    return invoke.focus$ui_release() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                }
            } finally {
                focusTargetNode.isProcessingCustomExit = false;
            }
        }
        return CustomDestinationResult.None;
    }

    /* renamed from: performCustomRequestFocus-Mxy_nc0, reason: not valid java name */
    public static final CustomDestinationResult m1305performCustomRequestFocusMxy_nc0(FocusTargetNode focusTargetNode, int i5) {
        Modifier.Node node;
        NodeChain nodes;
        int i6 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i6 == 1 || i6 == 2) {
            return CustomDestinationResult.None;
        }
        if (i6 == 3) {
            return m1302performCustomClearFocusMxy_nc0(requireActiveChild(focusTargetNode), i5);
        }
        if (i6 != 4) {
            throw new NoWhenBranchMatchedException();
        }
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
                                int i7 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                        i7++;
                                        if (i7 == 1) {
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
                                if (i7 == 1) {
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
        if (focusTargetNode2 == null) {
            return CustomDestinationResult.None;
        }
        int i8 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode2.getFocusState().ordinal()];
        if (i8 == 1) {
            return m1303performCustomEnterMxy_nc0(focusTargetNode2, i5);
        }
        if (i8 == 2) {
            return CustomDestinationResult.Cancelled;
        }
        if (i8 == 3) {
            return m1305performCustomRequestFocusMxy_nc0(focusTargetNode2, i5);
        }
        if (i8 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        CustomDestinationResult m1305performCustomRequestFocusMxy_nc0 = m1305performCustomRequestFocusMxy_nc0(focusTargetNode2, i5);
        CustomDestinationResult customDestinationResult = m1305performCustomRequestFocusMxy_nc0 != CustomDestinationResult.None ? m1305performCustomRequestFocusMxy_nc0 : null;
        return customDestinationResult == null ? m1303performCustomEnterMxy_nc0(focusTargetNode2, i5) : customDestinationResult;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d7, code lost:
    
        if (grantFocus(r11) != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00f5, code lost:
    
        if (grantFocus(r11) != false) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean performRequestFocus(FocusTargetNode focusTargetNode) {
        NodeChain nodes;
        int i5 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        boolean z5 = true;
        if (i5 != 1 && i5 != 2) {
            Modifier.Node node = null;
            if (i5 == 3) {
                if (clearChildFocus$default(focusTargetNode, false, false, 3, null)) {
                }
                z5 = false;
            } else {
                if (i5 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                int m2074constructorimpl = NodeKind.m2074constructorimpl(1024);
                if (!focusTargetNode.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node parent = focusTargetNode.getNode().getParent();
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                loop0: while (true) {
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
                                        int i6 = 0;
                                        for (Modifier.Node delegate = ((DelegatingNode) node2).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                            if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                                i6++;
                                                if (i6 == 1) {
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
                                        if (i6 == 1) {
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
                FocusTargetNode focusTargetNode2 = (FocusTargetNode) node;
                if (focusTargetNode2 != null) {
                    FocusStateImpl focusState = focusTargetNode2.getFocusState();
                    z5 = requestFocusForChild(focusTargetNode2, focusTargetNode);
                    if (z5 && focusState != focusTargetNode2.getFocusState()) {
                        FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode2);
                    }
                } else {
                    if (requestFocusForOwner(focusTargetNode)) {
                    }
                    z5 = false;
                }
            }
        }
        if (z5) {
            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
        }
        return z5;
    }

    public static final boolean requestFocus(FocusTargetNode focusTargetNode) {
        Boolean m1306requestFocusMxy_nc0 = m1306requestFocusMxy_nc0(focusTargetNode, FocusDirection.INSTANCE.m1280getEnterdhqQ8s());
        if (m1306requestFocusMxy_nc0 != null) {
            return m1306requestFocusMxy_nc0.booleanValue();
        }
        return false;
    }

    /* renamed from: requestFocus-Mxy_nc0, reason: not valid java name */
    public static final Boolean m1306requestFocusMxy_nc0(final FocusTargetNode focusTargetNode, int i5) {
        boolean z5;
        MutableVector mutableVector;
        Boolean valueOf;
        FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(focusTargetNode);
        Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$requestFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (FocusTargetNode.this.getNode().getIsAttached()) {
                    FocusEventModifierNodeKt.refreshFocusEventNodes(FocusTargetNode.this);
                }
            }
        };
        try {
            z5 = requireTransactionManager.ongoingTransaction;
            if (z5) {
                requireTransactionManager.cancelTransaction();
            }
            requireTransactionManager.beginTransaction();
            mutableVector = requireTransactionManager.cancellationListener;
            mutableVector.add(function0);
            int i6 = WhenMappings.$EnumSwitchMapping$0[m1305performCustomRequestFocusMxy_nc0(focusTargetNode, i5).ordinal()];
            if (i6 == 1) {
                valueOf = Boolean.valueOf(performRequestFocus(focusTargetNode));
            } else if (i6 != 2) {
                if (i6 != 3 && i6 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                valueOf = null;
            } else {
                valueOf = Boolean.TRUE;
            }
            return valueOf;
        } finally {
            requireTransactionManager.commitTransaction();
        }
    }

    private static final boolean requestFocusForChild(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        Modifier.Node node;
        Modifier.Node node2;
        NodeChain nodes;
        NodeChain nodes2;
        int m2074constructorimpl = NodeKind.m2074constructorimpl(1024);
        if (!focusTargetNode2.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = focusTargetNode2.getNode().getParent();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
        loop0: while (true) {
            node = null;
            if (requireLayoutNode == null) {
                node2 = null;
                break;
            }
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m2074constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & m2074constructorimpl) != 0) {
                        node2 = parent;
                        MutableVector mutableVector = null;
                        while (node2 != null) {
                            if (node2 instanceof FocusTargetNode) {
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
            parent = (requireLayoutNode == null || (nodes2 = requireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
        }
        if (!Intrinsics.areEqual(node2, focusTargetNode)) {
            throw new IllegalStateException("Non child node cannot request focus.");
        }
        int i6 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i6 == 1) {
            boolean grantFocus = grantFocus(focusTargetNode2);
            if (!grantFocus) {
                return grantFocus;
            }
            focusTargetNode.setFocusState(FocusStateImpl.ActiveParent);
            return grantFocus;
        }
        if (i6 != 2) {
            if (i6 == 3) {
                requireActiveChild(focusTargetNode);
                if (clearChildFocus$default(focusTargetNode, false, false, 3, null) && grantFocus(focusTargetNode2)) {
                    return true;
                }
            } else {
                if (i6 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                int m2074constructorimpl2 = NodeKind.m2074constructorimpl(1024);
                if (!focusTargetNode.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node parent2 = focusTargetNode.getNode().getParent();
                LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                loop4: while (true) {
                    if (requireLayoutNode2 == null) {
                        break;
                    }
                    if ((requireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & m2074constructorimpl2) != 0) {
                        while (parent2 != null) {
                            if ((parent2.getKindSet() & m2074constructorimpl2) != 0) {
                                Modifier.Node node3 = parent2;
                                MutableVector mutableVector2 = null;
                                while (node3 != null) {
                                    if (node3 instanceof FocusTargetNode) {
                                        node = node3;
                                        break loop4;
                                    }
                                    if ((node3.getKindSet() & m2074constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                                        int i7 = 0;
                                        for (Modifier.Node delegate2 = ((DelegatingNode) node3).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                            if ((delegate2.getKindSet() & m2074constructorimpl2) != 0) {
                                                i7++;
                                                if (i7 == 1) {
                                                    node3 = delegate2;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (node3 != null) {
                                                        mutableVector2.add(node3);
                                                        node3 = null;
                                                    }
                                                    mutableVector2.add(delegate2);
                                                }
                                            }
                                        }
                                        if (i7 == 1) {
                                        }
                                    }
                                    node3 = DelegatableNodeKt.pop(mutableVector2);
                                }
                            }
                            parent2 = parent2.getParent();
                        }
                    }
                    requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                    parent2 = (requireLayoutNode2 == null || (nodes = requireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
                }
                FocusTargetNode focusTargetNode3 = (FocusTargetNode) node;
                if (focusTargetNode3 == null && requestFocusForOwner(focusTargetNode)) {
                    boolean grantFocus2 = grantFocus(focusTargetNode2);
                    if (!grantFocus2) {
                        return grantFocus2;
                    }
                    focusTargetNode.setFocusState(FocusStateImpl.ActiveParent);
                    return grantFocus2;
                }
                if (focusTargetNode3 != null && requestFocusForChild(focusTargetNode3, focusTargetNode)) {
                    boolean requestFocusForChild = requestFocusForChild(focusTargetNode, focusTargetNode2);
                    if (focusTargetNode.getFocusState() != FocusStateImpl.ActiveParent) {
                        throw new IllegalStateException("Deactivated node is focused");
                    }
                    if (!requestFocusForChild) {
                        return requestFocusForChild;
                    }
                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode3);
                    return requestFocusForChild;
                }
            }
        }
        return false;
    }

    private static final boolean requestFocusForOwner(FocusTargetNode focusTargetNode) {
        return DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().mo1294requestFocusForOwner7o62pno(null, null);
    }

    private static final FocusTargetNode requireActiveChild(FocusTargetNode focusTargetNode) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            return activeChild;
        }
        throw new IllegalArgumentException("ActiveParent with no focused child");
    }
}
