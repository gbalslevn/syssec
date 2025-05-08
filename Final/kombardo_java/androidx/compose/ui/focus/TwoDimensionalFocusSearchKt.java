package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a2\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\f\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0013H\u0002\u001a\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a\u001a\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019H\u0002\u001a.\u0010\u001a\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00130\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a2\u0010\u001e\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0000ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a:\u0010#\u001a\u00020\u0004*\u00020\u00132\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a:\u0010'\u001a\u00020\u0004*\u00020\u00132\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010&\u001a\f\u0010)\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a>\u0010*\u001a\u0004\u0018\u00010\u0004*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0000ø\u0001\u0000¢\u0006\u0004\b,\u0010-\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"InvalidFocusDirection", BuildConfig.FLAVOR, "NoActiveChild", "beamBeats", BuildConfig.FLAVOR, "source", "Landroidx/compose/ui/geometry/Rect;", "rect1", "rect2", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "beamBeats-I7lrPNg", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;I)Z", "isBetterCandidate", "proposedCandidate", "currentCandidate", "focusedRect", "isBetterCandidate-I7lrPNg", "activeNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "bottomRight", "collectAccessibleChildren", BuildConfig.FLAVOR, "Landroidx/compose/ui/node/DelegatableNode;", "accessibleChildren", "Landroidx/compose/runtime/collection/MutableVector;", "findBestCandidate", "focusRect", "findBestCandidate-4WY_MpI", "(Landroidx/compose/runtime/collection/MutableVector;Landroidx/compose/ui/geometry/Rect;I)Landroidx/compose/ui/focus/FocusTargetNode;", "findChildCorrespondingToFocusEnter", "onFound", "Lkotlin/Function1;", "findChildCorrespondingToFocusEnter--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "generateAndSearchChildren", "focusedItem", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/geometry/Rect;ILkotlin/jvm/functions/Function1;)Z", "searchChildren", "searchChildren-4C6V_qg", "topLeft", "twoDimensionalFocusSearch", "previouslyFocusedRect", "twoDimensionalFocusSearch-sMXa3k8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TwoDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 2-D focus search";
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

    private static final FocusTargetNode activeNode(FocusTargetNode focusTargetNode) {
        if (focusTargetNode.getFocusState() != FocusStateImpl.ActiveParent) {
            throw new IllegalStateException("Searching for active node in inactive hierarchy");
        }
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusTargetNode);
        if (findActiveFocusNode != null) {
            return findActiveFocusNode;
        }
        throw new IllegalStateException(NoActiveChild);
    }

    /* renamed from: beamBeats-I7lrPNg, reason: not valid java name */
    private static final boolean m1314beamBeatsI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i5) {
        if (beamBeats_I7lrPNg$inSourceBeam(rect3, i5, rect) || !beamBeats_I7lrPNg$inSourceBeam(rect2, i5, rect)) {
            return false;
        }
        if (beamBeats_I7lrPNg$isInDirectionOfSearch(rect3, i5, rect)) {
            FocusDirection.Companion companion = FocusDirection.INSTANCE;
            if (!FocusDirection.m1275equalsimpl0(i5, companion.m1282getLeftdhqQ8s()) && !FocusDirection.m1275equalsimpl0(i5, companion.m1285getRightdhqQ8s()) && beamBeats_I7lrPNg$majorAxisDistance$6(rect2, i5, rect) >= beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(rect3, i5, rect)) {
                return false;
            }
        }
        return true;
    }

    private static final boolean beamBeats_I7lrPNg$inSourceBeam(Rect rect, int i5, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (!(FocusDirection.m1275equalsimpl0(i5, companion.m1282getLeftdhqQ8s()) ? true : FocusDirection.m1275equalsimpl0(i5, companion.m1285getRightdhqQ8s()))) {
            if (!(FocusDirection.m1275equalsimpl0(i5, companion.m1286getUpdhqQ8s()) ? true : FocusDirection.m1275equalsimpl0(i5, companion.m1279getDowndhqQ8s()))) {
                throw new IllegalStateException(InvalidFocusDirection);
            }
            if (rect.getRight() > rect2.getLeft() && rect.getLeft() < rect2.getRight()) {
                return true;
            }
        } else if (rect.getBottom() > rect2.getTop() && rect.getTop() < rect2.getBottom()) {
            return true;
        }
        return false;
    }

    private static final boolean beamBeats_I7lrPNg$isInDirectionOfSearch(Rect rect, int i5, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1282getLeftdhqQ8s())) {
            if (rect2.getLeft() < rect.getRight()) {
                return false;
            }
        } else if (FocusDirection.m1275equalsimpl0(i5, companion.m1285getRightdhqQ8s())) {
            if (rect2.getRight() > rect.getLeft()) {
                return false;
            }
        } else if (FocusDirection.m1275equalsimpl0(i5, companion.m1286getUpdhqQ8s())) {
            if (rect2.getTop() < rect.getBottom()) {
                return false;
            }
        } else {
            if (!FocusDirection.m1275equalsimpl0(i5, companion.m1279getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection);
            }
            if (rect2.getBottom() > rect.getTop()) {
                return false;
            }
        }
        return true;
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistance$6(Rect rect, int i5, Rect rect2) {
        float top;
        float bottom;
        float top2;
        float bottom2;
        float f5;
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (!FocusDirection.m1275equalsimpl0(i5, companion.m1282getLeftdhqQ8s())) {
            if (FocusDirection.m1275equalsimpl0(i5, companion.m1285getRightdhqQ8s())) {
                top = rect.getLeft();
                bottom = rect2.getRight();
            } else if (FocusDirection.m1275equalsimpl0(i5, companion.m1286getUpdhqQ8s())) {
                top2 = rect2.getTop();
                bottom2 = rect.getBottom();
            } else {
                if (!FocusDirection.m1275equalsimpl0(i5, companion.m1279getDowndhqQ8s())) {
                    throw new IllegalStateException(InvalidFocusDirection);
                }
                top = rect.getTop();
                bottom = rect2.getBottom();
            }
            f5 = top - bottom;
            return Math.max(0.0f, f5);
        }
        top2 = rect2.getLeft();
        bottom2 = rect.getRight();
        f5 = top2 - bottom2;
        return Math.max(0.0f, f5);
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(Rect rect, int i5, Rect rect2) {
        float bottom;
        float bottom2;
        float top;
        float top2;
        float f5;
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (!FocusDirection.m1275equalsimpl0(i5, companion.m1282getLeftdhqQ8s())) {
            if (FocusDirection.m1275equalsimpl0(i5, companion.m1285getRightdhqQ8s())) {
                bottom = rect.getRight();
                bottom2 = rect2.getRight();
            } else if (FocusDirection.m1275equalsimpl0(i5, companion.m1286getUpdhqQ8s())) {
                top = rect2.getTop();
                top2 = rect.getTop();
            } else {
                if (!FocusDirection.m1275equalsimpl0(i5, companion.m1279getDowndhqQ8s())) {
                    throw new IllegalStateException(InvalidFocusDirection);
                }
                bottom = rect.getBottom();
                bottom2 = rect2.getBottom();
            }
            f5 = bottom - bottom2;
            return Math.max(1.0f, f5);
        }
        top = rect2.getLeft();
        top2 = rect.getLeft();
        f5 = top - top2;
        return Math.max(1.0f, f5);
    }

    private static final Rect bottomRight(Rect rect) {
        return new Rect(rect.getRight(), rect.getBottom(), rect.getRight(), rect.getBottom());
    }

    private static final void collectAccessibleChildren(DelegatableNode delegatableNode, MutableVector<FocusTargetNode> mutableVector) {
        int m2074constructorimpl = NodeKind.m2074constructorimpl(1024);
        if (!delegatableNode.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = delegatableNode.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, delegatableNode.getNode());
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
                                FocusTargetNode focusTargetNode = (FocusTargetNode) node;
                                if (focusTargetNode.getIsAttached() && !DelegatableNodeKt.requireLayoutNode(focusTargetNode).getIsDeactivated()) {
                                    if (focusTargetNode.fetchFocusProperties$ui_release().getCanFocus()) {
                                        mutableVector.add(focusTargetNode);
                                    } else {
                                        collectAccessibleChildren(focusTargetNode, mutableVector);
                                    }
                                }
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
    }

    /* renamed from: findBestCandidate-4WY_MpI, reason: not valid java name */
    private static final FocusTargetNode m1315findBestCandidate4WY_MpI(MutableVector<FocusTargetNode> mutableVector, Rect rect, int i5) {
        Rect translate;
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1282getLeftdhqQ8s())) {
            translate = rect.translate(rect.getWidth() + 1, 0.0f);
        } else if (FocusDirection.m1275equalsimpl0(i5, companion.m1285getRightdhqQ8s())) {
            translate = rect.translate(-(rect.getWidth() + 1), 0.0f);
        } else if (FocusDirection.m1275equalsimpl0(i5, companion.m1286getUpdhqQ8s())) {
            translate = rect.translate(0.0f, rect.getHeight() + 1);
        } else {
            if (!FocusDirection.m1275equalsimpl0(i5, companion.m1279getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection);
            }
            translate = rect.translate(0.0f, -(rect.getHeight() + 1));
        }
        int size = mutableVector.getSize();
        FocusTargetNode focusTargetNode = null;
        if (size > 0) {
            FocusTargetNode[] content = mutableVector.getContent();
            int i6 = 0;
            do {
                FocusTargetNode focusTargetNode2 = content[i6];
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2)) {
                    Rect focusRect = FocusTraversalKt.focusRect(focusTargetNode2);
                    if (m1318isBetterCandidateI7lrPNg(focusRect, translate, rect, i5)) {
                        focusTargetNode = focusTargetNode2;
                        translate = focusRect;
                    }
                }
                i6++;
            } while (i6 < size);
        }
        return focusTargetNode;
    }

    /* renamed from: findChildCorrespondingToFocusEnter--OM-vw8, reason: not valid java name */
    public static final boolean m1316findChildCorrespondingToFocusEnterOMvw8(FocusTargetNode focusTargetNode, int i5, Function1<? super FocusTargetNode, Boolean> function1) {
        Rect bottomRight;
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        collectAccessibleChildren(focusTargetNode, mutableVector);
        if (mutableVector.getSize() <= 1) {
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) (mutableVector.isEmpty() ? null : mutableVector.getContent()[0]);
            if (focusTargetNode2 != null) {
                return function1.invoke(focusTargetNode2).booleanValue();
            }
            return false;
        }
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1280getEnterdhqQ8s())) {
            i5 = companion.m1285getRightdhqQ8s();
        }
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1285getRightdhqQ8s()) ? true : FocusDirection.m1275equalsimpl0(i5, companion.m1279getDowndhqQ8s())) {
            bottomRight = topLeft(FocusTraversalKt.focusRect(focusTargetNode));
        } else {
            if (!(FocusDirection.m1275equalsimpl0(i5, companion.m1282getLeftdhqQ8s()) ? true : FocusDirection.m1275equalsimpl0(i5, companion.m1286getUpdhqQ8s()))) {
                throw new IllegalStateException(InvalidFocusDirection);
            }
            bottomRight = bottomRight(FocusTraversalKt.focusRect(focusTargetNode));
        }
        FocusTargetNode m1315findBestCandidate4WY_MpI = m1315findBestCandidate4WY_MpI(mutableVector, bottomRight, i5);
        if (m1315findBestCandidate4WY_MpI != null) {
            return function1.invoke(m1315findBestCandidate4WY_MpI).booleanValue();
        }
        return false;
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    private static final boolean m1317generateAndSearchChildren4C6V_qg(final FocusTargetNode focusTargetNode, final Rect rect, final int i5, final Function1<? super FocusTargetNode, Boolean> function1) {
        if (m1319searchChildren4C6V_qg(focusTargetNode, rect, i5, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m1271searchBeyondBoundsOMvw8(focusTargetNode, i5, new Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean>() { // from class: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope beyondBoundsScope) {
                boolean m1319searchChildren4C6V_qg;
                m1319searchChildren4C6V_qg = TwoDimensionalFocusSearchKt.m1319searchChildren4C6V_qg(FocusTargetNode.this, rect, i5, function1);
                Boolean valueOf = Boolean.valueOf(m1319searchChildren4C6V_qg);
                if (m1319searchChildren4C6V_qg || !beyondBoundsScope.getHasMoreContent()) {
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

    /* renamed from: isBetterCandidate-I7lrPNg, reason: not valid java name */
    private static final boolean m1318isBetterCandidateI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i5) {
        if (isBetterCandidate_I7lrPNg$isCandidate(rect, i5, rect3)) {
            return !isBetterCandidate_I7lrPNg$isCandidate(rect2, i5, rect3) || m1314beamBeatsI7lrPNg(rect3, rect, rect2, i5) || (!m1314beamBeatsI7lrPNg(rect3, rect2, rect, i5) && isBetterCandidate_I7lrPNg$weightedDistance(i5, rect3, rect) < isBetterCandidate_I7lrPNg$weightedDistance(i5, rect3, rect2));
        }
        return false;
    }

    private static final boolean isBetterCandidate_I7lrPNg$isCandidate(Rect rect, int i5, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1282getLeftdhqQ8s())) {
            if ((rect2.getRight() <= rect.getRight() && rect2.getLeft() < rect.getRight()) || rect2.getLeft() <= rect.getLeft()) {
                return false;
            }
        } else if (FocusDirection.m1275equalsimpl0(i5, companion.m1285getRightdhqQ8s())) {
            if ((rect2.getLeft() >= rect.getLeft() && rect2.getRight() > rect.getLeft()) || rect2.getRight() >= rect.getRight()) {
                return false;
            }
        } else if (FocusDirection.m1275equalsimpl0(i5, companion.m1286getUpdhqQ8s())) {
            if ((rect2.getBottom() <= rect.getBottom() && rect2.getTop() < rect.getBottom()) || rect2.getTop() <= rect.getTop()) {
                return false;
            }
        } else {
            if (!FocusDirection.m1275equalsimpl0(i5, companion.m1279getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection);
            }
            if ((rect2.getTop() >= rect.getTop() && rect2.getBottom() > rect.getTop()) || rect2.getBottom() >= rect.getBottom()) {
                return false;
            }
        }
        return true;
    }

    private static final float isBetterCandidate_I7lrPNg$majorAxisDistance(Rect rect, int i5, Rect rect2) {
        float top;
        float bottom;
        float top2;
        float bottom2;
        float f5;
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (!FocusDirection.m1275equalsimpl0(i5, companion.m1282getLeftdhqQ8s())) {
            if (FocusDirection.m1275equalsimpl0(i5, companion.m1285getRightdhqQ8s())) {
                top = rect.getLeft();
                bottom = rect2.getRight();
            } else if (FocusDirection.m1275equalsimpl0(i5, companion.m1286getUpdhqQ8s())) {
                top2 = rect2.getTop();
                bottom2 = rect.getBottom();
            } else {
                if (!FocusDirection.m1275equalsimpl0(i5, companion.m1279getDowndhqQ8s())) {
                    throw new IllegalStateException(InvalidFocusDirection);
                }
                top = rect.getTop();
                bottom = rect2.getBottom();
            }
            f5 = top - bottom;
            return Math.max(0.0f, f5);
        }
        top2 = rect2.getLeft();
        bottom2 = rect.getRight();
        f5 = top2 - bottom2;
        return Math.max(0.0f, f5);
    }

    private static final float isBetterCandidate_I7lrPNg$minorAxisDistance(Rect rect, int i5, Rect rect2) {
        float f5;
        float left;
        float left2;
        float width;
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m1275equalsimpl0(i5, companion.m1282getLeftdhqQ8s()) ? true : FocusDirection.m1275equalsimpl0(i5, companion.m1285getRightdhqQ8s())) {
            f5 = 2;
            left = rect2.getTop() + (rect2.getHeight() / f5);
            left2 = rect.getTop();
            width = rect.getHeight();
        } else {
            if (!(FocusDirection.m1275equalsimpl0(i5, companion.m1286getUpdhqQ8s()) ? true : FocusDirection.m1275equalsimpl0(i5, companion.m1279getDowndhqQ8s()))) {
                throw new IllegalStateException(InvalidFocusDirection);
            }
            f5 = 2;
            left = rect2.getLeft() + (rect2.getWidth() / f5);
            left2 = rect.getLeft();
            width = rect.getWidth();
        }
        return left - (left2 + (width / f5));
    }

    private static final long isBetterCandidate_I7lrPNg$weightedDistance(int i5, Rect rect, Rect rect2) {
        long abs = Math.abs(isBetterCandidate_I7lrPNg$majorAxisDistance(rect2, i5, rect));
        long abs2 = Math.abs(isBetterCandidate_I7lrPNg$minorAxisDistance(rect2, i5, rect));
        return (13 * abs * abs) + (abs2 * abs2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m1319searchChildren4C6V_qg(FocusTargetNode focusTargetNode, Rect rect, int i5, Function1<? super FocusTargetNode, Boolean> function1) {
        FocusTargetNode m1315findBestCandidate4WY_MpI;
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
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) node;
                                if (focusTargetNode2.getIsAttached()) {
                                    mutableVector.add(focusTargetNode2);
                                }
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
        while (mutableVector.isNotEmpty() && (m1315findBestCandidate4WY_MpI = m1315findBestCandidate4WY_MpI(mutableVector, rect, i5)) != null) {
            if (m1315findBestCandidate4WY_MpI.fetchFocusProperties$ui_release().getCanFocus()) {
                return function1.invoke(m1315findBestCandidate4WY_MpI).booleanValue();
            }
            if (m1317generateAndSearchChildren4C6V_qg(m1315findBestCandidate4WY_MpI, rect, i5, function1)) {
                return true;
            }
            mutableVector.remove(m1315findBestCandidate4WY_MpI);
        }
        return false;
    }

    private static final Rect topLeft(Rect rect) {
        return new Rect(rect.getLeft(), rect.getTop(), rect.getLeft(), rect.getTop());
    }

    /* renamed from: twoDimensionalFocusSearch-sMXa3k8, reason: not valid java name */
    public static final Boolean m1320twoDimensionalFocusSearchsMXa3k8(FocusTargetNode focusTargetNode, int i5, Rect rect, Function1<? super FocusTargetNode, Boolean> function1) {
        FocusStateImpl focusState = focusTargetNode.getFocusState();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i6 = iArr[focusState.ordinal()];
        if (i6 != 1) {
            if (i6 == 2 || i6 == 3) {
                return Boolean.valueOf(m1316findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, i5, function1));
            }
            if (i6 == 4) {
                return focusTargetNode.fetchFocusProperties$ui_release().getCanFocus() ? function1.invoke(focusTargetNode) : rect == null ? Boolean.valueOf(m1316findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, i5, function1)) : Boolean.valueOf(m1319searchChildren4C6V_qg(focusTargetNode, rect, i5, function1));
            }
            throw new NoWhenBranchMatchedException();
        }
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild == null) {
            throw new IllegalStateException(NoActiveChild);
        }
        int i7 = iArr[activeChild.getFocusState().ordinal()];
        if (i7 == 1) {
            Boolean m1320twoDimensionalFocusSearchsMXa3k8 = m1320twoDimensionalFocusSearchsMXa3k8(activeChild, i5, rect, function1);
            if (!Intrinsics.areEqual(m1320twoDimensionalFocusSearchsMXa3k8, Boolean.FALSE)) {
                return m1320twoDimensionalFocusSearchsMXa3k8;
            }
            if (rect == null) {
                rect = FocusTraversalKt.focusRect(activeNode(activeChild));
            }
            return Boolean.valueOf(m1317generateAndSearchChildren4C6V_qg(focusTargetNode, rect, i5, function1));
        }
        if (i7 == 2 || i7 == 3) {
            if (rect == null) {
                rect = FocusTraversalKt.focusRect(activeChild);
            }
            return Boolean.valueOf(m1317generateAndSearchChildren4C6V_qg(focusTargetNode, rect, i5, function1));
        }
        if (i7 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException(NoActiveChild);
    }
}
