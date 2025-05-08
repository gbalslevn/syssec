package androidx.compose.ui.focus;

import android.support.v4.media.session.a;
import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u007f\u0012\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u001c\u0010\n\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0015*\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ&\u0010!\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J$\u0010$\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0004\b%\u0010\u0013J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\tH\u0016¢\u0006\u0004\b'\u0010(J2\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001a\u0010/\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b-\u0010.J:\u00105\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010\b2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\t0\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b3\u00104J(\u00109\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\f\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001a\u0010;\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b:\u0010\u001bJ\u0017\u0010>\u001a\u00020\t2\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u00042\u0006\u0010@\u001a\u000201H\u0016¢\u0006\u0004\bA\u0010BJ\u0017\u0010A\u001a\u00020\u00042\u0006\u0010@\u001a\u00020CH\u0016¢\u0006\u0004\bA\u0010DJ\u0017\u0010A\u001a\u00020\u00042\u0006\u0010@\u001a\u00020EH\u0016¢\u0006\u0004\bA\u0010FJ\u0011\u0010G\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\bG\u0010HR*\u0010\n\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010IR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010JR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010KR\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010KR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010KR\"\u0010L\u001a\u0002018\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010BR\u0014\u0010R\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u001a\u0010U\u001a\u00020T8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u001a\u0010Z\u001a\u00020Y8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010d\u001a\u00020a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010c\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006e"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "Lkotlin/Function1;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onRequestApplyChangesListener", "Lkotlin/Function2;", "Landroidx/compose/ui/focus/FocusDirection;", "Landroidx/compose/ui/geometry/Rect;", BuildConfig.FLAVOR, "onRequestFocusForOwner", "onMoveFocusInterop", "onClearFocusForOwner", "onFocusRectInterop", "Landroidx/compose/ui/unit/LayoutDirection;", "onLayoutDirection", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "invalidateOwnerFocusState", "()V", "Landroidx/compose/ui/node/DelegatableNode;", "Landroidx/compose/ui/Modifier$Node;", "lastLocalKeyInputNode", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/input/key/KeyEvent;", "keyEvent", "validateKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "validateKeyEvent", "focusDirection", "previouslyFocusedRect", "requestFocusForOwner-7o62pno", "(Landroidx/compose/ui/focus/FocusDirection;Landroidx/compose/ui/geometry/Rect;)Z", "requestFocusForOwner", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "takeFocus", "releaseFocus", "force", "clearFocus", "(Z)V", "refreshFocusEvents", "clearOwnerFocus", "clearFocus-I7lrPNg", "(ZZZI)Z", "moveFocus-3ESFkO8", "(I)Z", "moveFocus", "focusedRect", "Landroidx/compose/ui/focus/FocusTargetNode;", "onFound", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "focusSearch", "onFocusedItem", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchKeyEvent", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "dispatchInterceptedSoftKeyboardEvent", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "event", "dispatchRotaryEvent", "(Landroidx/compose/ui/input/rotary/RotaryScrollEvent;)Z", "node", "scheduleInvalidation", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "(Landroidx/compose/ui/focus/FocusEventModifierNode;)V", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "(Landroidx/compose/ui/focus/FocusPropertiesModifierNode;)V", "getFocusRect", "()Landroidx/compose/ui/geometry/Rect;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function0;", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui_release", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui_release", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "Landroidx/compose/ui/focus/FocusTransactionManager;", "focusTransactionManager", "Landroidx/compose/ui/focus/FocusTransactionManager;", "getFocusTransactionManager", "()Landroidx/compose/ui/focus/FocusTransactionManager;", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "Landroidx/collection/MutableLongSet;", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "rootState", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusOwnerImpl implements FocusOwner {
    private final FocusInvalidationManager focusInvalidationManager;
    private MutableLongSet keysCurrentlyDown;
    private final Function0<Unit> onClearFocusForOwner;
    private final Function0<Rect> onFocusRectInterop;
    private final Function0<LayoutDirection> onLayoutDirection;
    private final Function1<FocusDirection, Boolean> onMoveFocusInterop;
    private final Function2<FocusDirection, Rect, Boolean> onRequestFocusForOwner;
    private FocusTargetNode rootFocusNode = new FocusTargetNode();
    private final FocusTransactionManager focusTransactionManager = new FocusTransactionManager();
    private final Modifier modifier = FocusPropertiesKt.focusProperties(Modifier.INSTANCE, new Function1<FocusProperties, Unit>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FocusProperties focusProperties) {
            invoke2(focusProperties);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FocusProperties focusProperties) {
            focusProperties.setCanFocus(false);
        }
    }).then(new ModifierNodeElement<FocusTargetNode>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$2
        public boolean equals(Object other) {
            return other == this;
        }

        public int hashCode() {
            return FocusOwnerImpl.this.getRootFocusNode().hashCode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(FocusTargetNode node) {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* renamed from: create, reason: avoid collision after fix types in other method */
        public FocusTargetNode getNode() {
            return FocusOwnerImpl.this.getRootFocusNode();
        }
    });

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FocusOwnerImpl(Function1<? super Function0<Unit>, Unit> function1, Function2<? super FocusDirection, ? super Rect, Boolean> function2, Function1<? super FocusDirection, Boolean> function12, Function0<Unit> function0, Function0<Rect> function02, Function0<? extends LayoutDirection> function03) {
        this.onRequestFocusForOwner = function2;
        this.onMoveFocusInterop = function12;
        this.onClearFocusForOwner = function0;
        this.onFocusRectInterop = function02;
        this.onLayoutDirection = function03;
        this.focusInvalidationManager = new FocusInvalidationManager(function1, new FocusOwnerImpl$focusInvalidationManager$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOwnerFocusState() {
        if (this.rootFocusNode.getFocusState() == FocusStateImpl.Inactive) {
            this.onClearFocusForOwner.invoke();
        }
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int m2074constructorimpl = NodeKind.m2074constructorimpl(1024) | NodeKind.m2074constructorimpl(8192);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        Modifier.Node node2 = null;
        if ((node.getAggregateChildKindSet() & m2074constructorimpl) != 0) {
            for (Modifier.Node child = node.getChild(); child != null; child = child.getChild()) {
                if ((child.getKindSet() & m2074constructorimpl) != 0) {
                    if ((NodeKind.m2074constructorimpl(1024) & child.getKindSet()) != 0) {
                        return node2;
                    }
                    node2 = child;
                }
            }
        }
        return node2;
    }

    /* renamed from: validateKeyEvent-ZmokQxo, reason: not valid java name */
    private final boolean m1295validateKeyEventZmokQxo(KeyEvent keyEvent) {
        long m1826getKeyZmokQxo = KeyEvent_androidKt.m1826getKeyZmokQxo(keyEvent);
        int m1827getTypeZmokQxo = KeyEvent_androidKt.m1827getTypeZmokQxo(keyEvent);
        KeyEventType.Companion companion = KeyEventType.INSTANCE;
        if (KeyEventType.m1822equalsimpl0(m1827getTypeZmokQxo, companion.m1823getKeyDownCS__XNY())) {
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (mutableLongSet == null) {
                mutableLongSet = new MutableLongSet(3);
                this.keysCurrentlyDown = mutableLongSet;
            }
            mutableLongSet.plusAssign(m1826getKeyZmokQxo);
        } else if (KeyEventType.m1822equalsimpl0(m1827getTypeZmokQxo, companion.m1824getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 == null || !mutableLongSet2.contains(m1826getKeyZmokQxo)) {
                return false;
            }
            MutableLongSet mutableLongSet3 = this.keysCurrentlyDown;
            if (mutableLongSet3 != null) {
                mutableLongSet3.remove(m1826getKeyZmokQxo);
            }
        }
        return true;
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void clearFocus(boolean force) {
        mo1290clearFocusI7lrPNg(force, true, true, FocusDirection.INSTANCE.m1281getExitdhqQ8s());
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: clearFocus-I7lrPNg */
    public boolean mo1290clearFocusI7lrPNg(boolean force, boolean refreshFocusEvents, boolean clearOwnerFocus, int focusDirection) {
        boolean z5;
        boolean clearFocus;
        MutableVector mutableVector;
        FocusTransactionManager focusTransactionManager = getFocusTransactionManager();
        FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        try {
            z5 = focusTransactionManager.ongoingTransaction;
            if (z5) {
                focusTransactionManager.cancelTransaction();
            }
            focusTransactionManager.beginTransaction();
            if (focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 != null) {
                mutableVector = focusTransactionManager.cancellationListener;
                mutableVector.add(focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1);
            }
            if (!force) {
                int i5 = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m1302performCustomClearFocusMxy_nc0(this.rootFocusNode, focusDirection).ordinal()];
                if (i5 == 1 || i5 == 2 || i5 == 3) {
                    clearFocus = false;
                    if (clearFocus && clearOwnerFocus) {
                        this.onClearFocusForOwner.invoke();
                    }
                    return clearFocus;
                }
            }
            clearFocus = FocusTransactionsKt.clearFocus(this.rootFocusNode, force, refreshFocusEvents);
            if (clearFocus) {
                this.onClearFocusForOwner.invoke();
            }
            return clearFocus;
        } finally {
            focusTransactionManager.commitTransaction();
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    public boolean mo1291dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent) {
        NodeChain nodes;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            int m2074constructorimpl = NodeKind.m2074constructorimpl(131072);
            if (!findActiveFocusNode.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = findActiveFocusNode.getNode();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(findActiveFocusNode);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m2074constructorimpl) != 0) {
                    while (node != null) {
                        if ((node.getKindSet() & m2074constructorimpl) != 0) {
                            Modifier.Node node2 = node;
                            MutableVector mutableVector = null;
                            while (node2 != null) {
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
                        node = node.getParent();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                node = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
            }
            a.a(null);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v28, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v30, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r11v31, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v32 */
    /* JADX WARN: Type inference failed for: r11v33 */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v64 */
    /* JADX WARN: Type inference failed for: r11v65 */
    /* JADX WARN: Type inference failed for: r11v66 */
    /* JADX WARN: Type inference failed for: r11v67 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r5v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v48 */
    /* JADX WARN: Type inference failed for: r5v49 */
    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v9, types: [androidx.compose.ui.Modifier$Node] */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchKeyEvent-YhN2O0w */
    public boolean mo1292dispatchKeyEventYhN2O0w(KeyEvent keyEvent, Function0<Boolean> onFocusedItem) {
        DelegatingNode delegatingNode;
        Modifier.Node node;
        NodeChain nodes;
        DelegatingNode delegatingNode2;
        NodeChain nodes2;
        NodeChain nodes3;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching key event while focus system is invalidated.");
            return false;
        }
        if (!m1295validateKeyEventZmokQxo(keyEvent)) {
            return false;
        }
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode == null || (node = lastLocalKeyInputNode(findActiveFocusNode)) == null) {
            if (findActiveFocusNode != null) {
                int m2074constructorimpl = NodeKind.m2074constructorimpl(8192);
                if (!findActiveFocusNode.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node node2 = findActiveFocusNode.getNode();
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(findActiveFocusNode);
                loop10: while (true) {
                    if (requireLayoutNode == null) {
                        delegatingNode2 = 0;
                        break;
                    }
                    if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m2074constructorimpl) != 0) {
                        while (node2 != null) {
                            if ((node2.getKindSet() & m2074constructorimpl) != 0) {
                                MutableVector mutableVector = null;
                                delegatingNode2 = node2;
                                while (delegatingNode2 != 0) {
                                    if (delegatingNode2 instanceof KeyInputModifierNode) {
                                        break loop10;
                                    }
                                    if ((delegatingNode2.getKindSet() & m2074constructorimpl) != 0 && (delegatingNode2 instanceof DelegatingNode)) {
                                        Modifier.Node delegate = delegatingNode2.getDelegate();
                                        int i5 = 0;
                                        delegatingNode2 = delegatingNode2;
                                        while (delegate != null) {
                                            if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                                i5++;
                                                if (i5 == 1) {
                                                    delegatingNode2 = delegate;
                                                } else {
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (delegatingNode2 != 0) {
                                                        mutableVector.add(delegatingNode2);
                                                        delegatingNode2 = 0;
                                                    }
                                                    mutableVector.add(delegate);
                                                }
                                            }
                                            delegate = delegate.getChild();
                                            delegatingNode2 = delegatingNode2;
                                        }
                                        if (i5 == 1) {
                                        }
                                    }
                                    delegatingNode2 = DelegatableNodeKt.pop(mutableVector);
                                }
                            }
                            node2 = node2.getParent();
                        }
                    }
                    requireLayoutNode = requireLayoutNode.getParent$ui_release();
                    node2 = (requireLayoutNode == null || (nodes2 = requireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
                }
                KeyInputModifierNode keyInputModifierNode = (KeyInputModifierNode) delegatingNode2;
                if (keyInputModifierNode != null) {
                    node = keyInputModifierNode.getNode();
                }
            }
            FocusTargetNode focusTargetNode = this.rootFocusNode;
            int m2074constructorimpl2 = NodeKind.m2074constructorimpl(8192);
            if (!focusTargetNode.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = focusTargetNode.getNode().getParent();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop14: while (true) {
                if (requireLayoutNode2 == null) {
                    delegatingNode = 0;
                    break;
                }
                if ((requireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & m2074constructorimpl2) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & m2074constructorimpl2) != 0) {
                            MutableVector mutableVector2 = null;
                            delegatingNode = parent;
                            while (delegatingNode != 0) {
                                if (delegatingNode instanceof KeyInputModifierNode) {
                                    break loop14;
                                }
                                if ((delegatingNode.getKindSet() & m2074constructorimpl2) != 0 && (delegatingNode instanceof DelegatingNode)) {
                                    Modifier.Node delegate2 = delegatingNode.getDelegate();
                                    int i6 = 0;
                                    delegatingNode = delegatingNode;
                                    while (delegate2 != null) {
                                        if ((delegate2.getKindSet() & m2074constructorimpl2) != 0) {
                                            i6++;
                                            if (i6 == 1) {
                                                delegatingNode = delegate2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (delegatingNode != 0) {
                                                    mutableVector2.add(delegatingNode);
                                                    delegatingNode = 0;
                                                }
                                                mutableVector2.add(delegate2);
                                            }
                                        }
                                        delegate2 = delegate2.getChild();
                                        delegatingNode = delegatingNode;
                                    }
                                    if (i6 == 1) {
                                    }
                                }
                                delegatingNode = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                parent = (requireLayoutNode2 == null || (nodes = requireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            }
            KeyInputModifierNode keyInputModifierNode2 = (KeyInputModifierNode) delegatingNode;
            node = keyInputModifierNode2 != null ? keyInputModifierNode2.getNode() : null;
        }
        if (node != null) {
            int m2074constructorimpl3 = NodeKind.m2074constructorimpl(8192);
            if (!node.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent2 = node.getNode().getParent();
            LayoutNode requireLayoutNode3 = DelegatableNodeKt.requireLayoutNode(node);
            ArrayList arrayList = null;
            while (requireLayoutNode3 != null) {
                if ((requireLayoutNode3.getNodes().getHead().getAggregateChildKindSet() & m2074constructorimpl3) != 0) {
                    while (parent2 != null) {
                        if ((parent2.getKindSet() & m2074constructorimpl3) != 0) {
                            Modifier.Node node3 = parent2;
                            MutableVector mutableVector3 = null;
                            while (node3 != null) {
                                if (node3 instanceof KeyInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(node3);
                                } else if ((node3.getKindSet() & m2074constructorimpl3) != 0 && (node3 instanceof DelegatingNode)) {
                                    int i7 = 0;
                                    for (Modifier.Node delegate3 = ((DelegatingNode) node3).getDelegate(); delegate3 != null; delegate3 = delegate3.getChild()) {
                                        if ((delegate3.getKindSet() & m2074constructorimpl3) != 0) {
                                            i7++;
                                            if (i7 == 1) {
                                                node3 = delegate3;
                                            } else {
                                                if (mutableVector3 == null) {
                                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node3 != null) {
                                                    mutableVector3.add(node3);
                                                    node3 = null;
                                                }
                                                mutableVector3.add(delegate3);
                                            }
                                        }
                                    }
                                    if (i7 == 1) {
                                    }
                                }
                                node3 = DelegatableNodeKt.pop(mutableVector3);
                            }
                        }
                        parent2 = parent2.getParent();
                    }
                }
                requireLayoutNode3 = requireLayoutNode3.getParent$ui_release();
                parent2 = (requireLayoutNode3 == null || (nodes3 = requireLayoutNode3.getNodes()) == null) ? null : nodes3.getTail();
            }
            if (arrayList != null) {
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i8 = size - 1;
                        if (((KeyInputModifierNode) arrayList.get(size)).mo92onPreKeyEventZmokQxo(keyEvent)) {
                            return true;
                        }
                        if (i8 < 0) {
                            break;
                        }
                        size = i8;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            DelegatingNode node4 = node.getNode();
            MutableVector mutableVector4 = null;
            while (node4 != 0) {
                if (node4 instanceof KeyInputModifierNode) {
                    if (((KeyInputModifierNode) node4).mo92onPreKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node4.getKindSet() & m2074constructorimpl3) != 0 && (node4 instanceof DelegatingNode)) {
                    Modifier.Node delegate4 = node4.getDelegate();
                    int i9 = 0;
                    node4 = node4;
                    while (delegate4 != null) {
                        if ((delegate4.getKindSet() & m2074constructorimpl3) != 0) {
                            i9++;
                            if (i9 == 1) {
                                node4 = delegate4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node4 != 0) {
                                    mutableVector4.add(node4);
                                    node4 = 0;
                                }
                                mutableVector4.add(delegate4);
                            }
                        }
                        delegate4 = delegate4.getChild();
                        node4 = node4;
                    }
                    if (i9 == 1) {
                    }
                }
                node4 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (onFocusedItem.invoke().booleanValue()) {
                return true;
            }
            DelegatingNode node5 = node.getNode();
            MutableVector mutableVector5 = null;
            while (node5 != 0) {
                if (node5 instanceof KeyInputModifierNode) {
                    if (((KeyInputModifierNode) node5).mo90onKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                } else if ((node5.getKindSet() & m2074constructorimpl3) != 0 && (node5 instanceof DelegatingNode)) {
                    Modifier.Node delegate5 = node5.getDelegate();
                    int i10 = 0;
                    node5 = node5;
                    while (delegate5 != null) {
                        if ((delegate5.getKindSet() & m2074constructorimpl3) != 0) {
                            i10++;
                            if (i10 == 1) {
                                node5 = delegate5;
                            } else {
                                if (mutableVector5 == null) {
                                    mutableVector5 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node5 != 0) {
                                    mutableVector5.add(node5);
                                    node5 = 0;
                                }
                                mutableVector5.add(delegate5);
                            }
                        }
                        delegate5 = delegate5.getChild();
                        node5 = node5;
                    }
                    if (i10 == 1) {
                    }
                }
                node5 = DelegatableNodeKt.pop(mutableVector5);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    if (((KeyInputModifierNode) arrayList.get(i11)).mo90onKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                }
                Unit unit2 = Unit.INSTANCE;
            }
            Unit unit3 = Unit.INSTANCE;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(RotaryScrollEvent event) {
        RotaryInputModifierNode rotaryInputModifierNode;
        int size;
        NodeChain nodes;
        DelegatingNode delegatingNode;
        NodeChain nodes2;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            throw new IllegalStateException("Dispatching rotary event while focus system is invalidated.");
        }
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            int m2074constructorimpl = NodeKind.m2074constructorimpl(16384);
            if (!findActiveFocusNode.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node node = findActiveFocusNode.getNode();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(findActiveFocusNode);
            loop0: while (true) {
                if (requireLayoutNode == null) {
                    delegatingNode = 0;
                    break;
                }
                if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m2074constructorimpl) != 0) {
                    while (node != null) {
                        if ((node.getKindSet() & m2074constructorimpl) != 0) {
                            MutableVector mutableVector = null;
                            delegatingNode = node;
                            while (delegatingNode != 0) {
                                if (delegatingNode instanceof RotaryInputModifierNode) {
                                    break loop0;
                                }
                                if ((delegatingNode.getKindSet() & m2074constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                                    Modifier.Node delegate = delegatingNode.getDelegate();
                                    int i5 = 0;
                                    delegatingNode = delegatingNode;
                                    while (delegate != null) {
                                        if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                            i5++;
                                            if (i5 == 1) {
                                                delegatingNode = delegate;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (delegatingNode != 0) {
                                                    mutableVector.add(delegatingNode);
                                                    delegatingNode = 0;
                                                }
                                                mutableVector.add(delegate);
                                            }
                                        }
                                        delegate = delegate.getChild();
                                        delegatingNode = delegatingNode;
                                    }
                                    if (i5 == 1) {
                                    }
                                }
                                delegatingNode = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                        node = node.getParent();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                node = (requireLayoutNode == null || (nodes2 = requireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
            }
            rotaryInputModifierNode = (RotaryInputModifierNode) delegatingNode;
        } else {
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode != null) {
            int m2074constructorimpl2 = NodeKind.m2074constructorimpl(16384);
            if (!rotaryInputModifierNode.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = rotaryInputModifierNode.getNode().getParent();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(rotaryInputModifierNode);
            ArrayList arrayList = null;
            while (requireLayoutNode2 != null) {
                if ((requireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & m2074constructorimpl2) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & m2074constructorimpl2) != 0) {
                            Modifier.Node node2 = parent;
                            MutableVector mutableVector2 = null;
                            while (node2 != null) {
                                if (node2 instanceof RotaryInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(node2);
                                } else if ((node2.getKindSet() & m2074constructorimpl2) != 0 && (node2 instanceof DelegatingNode)) {
                                    int i6 = 0;
                                    for (Modifier.Node delegate2 = ((DelegatingNode) node2).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                        if ((delegate2.getKindSet() & m2074constructorimpl2) != 0) {
                                            i6++;
                                            if (i6 == 1) {
                                                node2 = delegate2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node2 != null) {
                                                    mutableVector2.add(node2);
                                                    node2 = null;
                                                }
                                                mutableVector2.add(delegate2);
                                            }
                                        }
                                    }
                                    if (i6 == 1) {
                                    }
                                }
                                node2 = DelegatableNodeKt.pop(mutableVector2);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                parent = (requireLayoutNode2 == null || (nodes = requireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i7 = size - 1;
                    if (((RotaryInputModifierNode) arrayList.get(size)).onPreRotaryScrollEvent(event)) {
                        return true;
                    }
                    if (i7 < 0) {
                        break;
                    }
                    size = i7;
                }
            }
            DelegatingNode node3 = rotaryInputModifierNode.getNode();
            MutableVector mutableVector3 = null;
            while (node3 != 0) {
                if (node3 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node3).onPreRotaryScrollEvent(event)) {
                        return true;
                    }
                } else if ((node3.getKindSet() & m2074constructorimpl2) != 0 && (node3 instanceof DelegatingNode)) {
                    Modifier.Node delegate3 = node3.getDelegate();
                    int i8 = 0;
                    node3 = node3;
                    while (delegate3 != null) {
                        if ((delegate3.getKindSet() & m2074constructorimpl2) != 0) {
                            i8++;
                            if (i8 == 1) {
                                node3 = delegate3;
                            } else {
                                if (mutableVector3 == null) {
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != 0) {
                                    mutableVector3.add(node3);
                                    node3 = 0;
                                }
                                mutableVector3.add(delegate3);
                            }
                        }
                        delegate3 = delegate3.getChild();
                        node3 = node3;
                    }
                    if (i8 == 1) {
                    }
                }
                node3 = DelegatableNodeKt.pop(mutableVector3);
            }
            DelegatingNode node4 = rotaryInputModifierNode.getNode();
            MutableVector mutableVector4 = null;
            while (node4 != 0) {
                if (node4 instanceof RotaryInputModifierNode) {
                    if (((RotaryInputModifierNode) node4).onRotaryScrollEvent(event)) {
                        return true;
                    }
                } else if ((node4.getKindSet() & m2074constructorimpl2) != 0 && (node4 instanceof DelegatingNode)) {
                    Modifier.Node delegate4 = node4.getDelegate();
                    int i9 = 0;
                    node4 = node4;
                    while (delegate4 != null) {
                        if ((delegate4.getKindSet() & m2074constructorimpl2) != 0) {
                            i9++;
                            if (i9 == 1) {
                                node4 = delegate4;
                            } else {
                                if (mutableVector4 == null) {
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node4 != 0) {
                                    mutableVector4.add(node4);
                                    node4 = 0;
                                }
                                mutableVector4.add(delegate4);
                            }
                        }
                        delegate4 = delegate4.getChild();
                        node4 = node4;
                    }
                    if (i9 == 1) {
                    }
                }
                node4 = DelegatableNodeKt.pop(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    if (((RotaryInputModifierNode) arrayList.get(i10)).onRotaryScrollEvent(event)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: focusSearch-ULY8qGw */
    public Boolean mo1293focusSearchULY8qGw(int focusDirection, Rect focusedRect, final Function1<? super FocusTargetNode, Boolean> onFound) {
        final FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            FocusRequester m1307customFocusSearchOMvw8 = FocusTraversalKt.m1307customFocusSearchOMvw8(findActiveFocusNode, focusDirection, this.onLayoutDirection.invoke());
            FocusRequester.Companion companion = FocusRequester.INSTANCE;
            if (Intrinsics.areEqual(m1307customFocusSearchOMvw8, companion.getCancel())) {
                return null;
            }
            if (!Intrinsics.areEqual(m1307customFocusSearchOMvw8, companion.getDefault())) {
                return Boolean.valueOf(m1307customFocusSearchOMvw8.findFocusTargetNode$ui_release(onFound));
            }
        } else {
            findActiveFocusNode = null;
        }
        return FocusTraversalKt.m1308focusSearch0X8WOeE(this.rootFocusNode, focusDirection, this.onLayoutDirection.invoke(), focusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusSearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                boolean booleanValue;
                if (Intrinsics.areEqual(focusTargetNode, FocusTargetNode.this)) {
                    booleanValue = false;
                } else if (!Intrinsics.areEqual(focusTargetNode, this.getRootFocusNode())) {
                    booleanValue = onFound.invoke(focusTargetNode).booleanValue();
                } else {
                    throw new IllegalStateException("Focus search landed at the root.");
                }
                return Boolean.valueOf(booleanValue);
            }
        });
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Rect getFocusRect() {
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(findActiveFocusNode);
        }
        return null;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusTransactionManager getFocusTransactionManager() {
        return this.focusTransactionManager;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    /* renamed from: getRootFocusNode$ui_release, reason: from getter */
    public final FocusTargetNode getRootFocusNode() {
        return this.rootFocusNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusState getRootState() {
        return this.rootFocusNode.getFocusState();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Boolean] */
    @Override // androidx.compose.ui.focus.FocusManager
    /* renamed from: moveFocus-3ESFkO8 */
    public boolean mo1288moveFocus3ESFkO8(final int focusDirection) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = Boolean.FALSE;
        Boolean mo1293focusSearchULY8qGw = mo1293focusSearchULY8qGw(focusDirection, this.onFocusRectInterop.invoke(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$focusSearchSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Boolean] */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                ref$ObjectRef.element = FocusTransactionsKt.m1306requestFocusMxy_nc0(focusTargetNode, focusDirection);
                Boolean bool = ref$ObjectRef.element;
                return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
            }
        });
        if (mo1293focusSearchULY8qGw == null || ref$ObjectRef.element == 0) {
            return false;
        }
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(mo1293focusSearchULY8qGw, bool) && Intrinsics.areEqual(ref$ObjectRef.element, bool)) {
            return true;
        }
        return FocusOwnerImplKt.m1297is1dFocusSearch3ESFkO8(focusDirection) ? mo1290clearFocusI7lrPNg(false, true, false, focusDirection) && m1296takeFocusaToIllA(focusDirection, null) : this.onMoveFocusInterop.invoke(FocusDirection.m1272boximpl(focusDirection)).booleanValue();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void releaseFocus() {
        boolean z5;
        FocusTransactionManager focusTransactionManager = getFocusTransactionManager();
        z5 = focusTransactionManager.ongoingTransaction;
        if (z5) {
            FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
            return;
        }
        try {
            focusTransactionManager.beginTransaction();
            FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
        } finally {
            focusTransactionManager.commitTransaction();
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: requestFocusForOwner-7o62pno */
    public boolean mo1294requestFocusForOwner7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect) {
        return this.onRequestFocusForOwner.invoke(focusDirection, previouslyFocusedRect).booleanValue();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusTargetNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    /* renamed from: takeFocus-aToIllA, reason: not valid java name */
    public boolean m1296takeFocusaToIllA(final int focusDirection, Rect previouslyFocusedRect) {
        Boolean mo1293focusSearchULY8qGw = mo1293focusSearchULY8qGw(focusDirection, previouslyFocusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$takeFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                Boolean m1306requestFocusMxy_nc0 = FocusTransactionsKt.m1306requestFocusMxy_nc0(focusTargetNode, focusDirection);
                return Boolean.valueOf(m1306requestFocusMxy_nc0 != null ? m1306requestFocusMxy_nc0.booleanValue() : false);
            }
        });
        if (mo1293focusSearchULY8qGw != null) {
            return mo1293focusSearchULY8qGw.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusEventModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusPropertiesModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }
}
