package androidx.compose.ui.viewinterop;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionManager;
import androidx.compose.ui.focus.FocusTransactionsKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0013J#\u0010\u001a\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001c\u0010\u0006J\u000f\u0010\u001d\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001d\u0010\u0006J\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0017H\u0016¢\u0006\u0004\b!\u0010 R$\u0010\"\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010 \u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Landroidx/compose/ui/viewinterop/FocusGroupPropertiesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "Landroid/view/View$OnAttachStateChangeListener;", "<init>", "()V", "Landroidx/compose/ui/focus/FocusTargetNode;", "getFocusTargetOfEmbeddedViewWrapper", "()Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/focus/FocusProperties;", "focusProperties", BuildConfig.FLAVOR, "applyFocusProperties", "(Landroidx/compose/ui/focus/FocusProperties;)V", "Landroidx/compose/ui/focus/FocusDirection;", "focusDirection", "Landroidx/compose/ui/focus/FocusRequester;", "onEnter-3ESFkO8", "(I)Landroidx/compose/ui/focus/FocusRequester;", "onEnter", "onExit-3ESFkO8", "onExit", "Landroid/view/View;", "oldFocus", "newFocus", "onGlobalFocusChanged", "(Landroid/view/View;Landroid/view/View;)V", "onAttach", "onDetach", "v", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "focusedChild", "Landroid/view/View;", "getFocusedChild", "()Landroid/view/View;", "setFocusedChild", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusGroupPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode, ViewTreeObserver.OnGlobalFocusChangeListener, View.OnAttachStateChangeListener {
    private View focusedChild;

    private final FocusTargetNode getFocusTargetOfEmbeddedViewWrapper() {
        int m2074constructorimpl = NodeKind.m2074constructorimpl(1024);
        if (!getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = getNode();
        if ((node.getAggregateChildKindSet() & m2074constructorimpl) != 0) {
            boolean z5 = false;
            for (Modifier.Node child = node.getChild(); child != null; child = child.getChild()) {
                if ((child.getKindSet() & m2074constructorimpl) != 0) {
                    Modifier.Node node2 = child;
                    MutableVector mutableVector = null;
                    while (node2 != null) {
                        if (node2 instanceof FocusTargetNode) {
                            FocusTargetNode focusTargetNode = (FocusTargetNode) node2;
                            if (z5) {
                                return focusTargetNode;
                            }
                            z5 = true;
                        } else if ((node2.getKindSet() & m2074constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
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
            }
        }
        throw new IllegalStateException("Could not find focus target of embedded view wrapper");
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
        focusProperties.setEnter(new FocusGroupPropertiesNode$applyFocusProperties$1(this));
        focusProperties.setExit(new FocusGroupPropertiesNode$applyFocusProperties$2(this));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        View view;
        super.onAttach();
        view = FocusGroupNode_androidKt.getView(this);
        view.addOnAttachStateChangeListener(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        View view;
        view = FocusGroupNode_androidKt.getView(this);
        view.removeOnAttachStateChangeListener(this);
        this.focusedChild = null;
        super.onDetach();
    }

    /* renamed from: onEnter-3ESFkO8, reason: not valid java name */
    public final FocusRequester m2711onEnter3ESFkO8(int focusDirection) {
        View view;
        Rect currentlyFocusedRect;
        view = FocusGroupNode_androidKt.getView(this);
        if (view.isFocused() || view.hasFocus()) {
            return FocusRequester.INSTANCE.getDefault();
        }
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Object requireOwner = DelegatableNodeKt.requireOwner(this);
        Intrinsics.checkNotNull(requireOwner, "null cannot be cast to non-null type android.view.View");
        Integer m1287toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m1287toAndroidFocusDirection3ESFkO8(focusDirection);
        currentlyFocusedRect = FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, (View) requireOwner, view);
        return FocusInteropUtils_androidKt.requestInteropFocus(view, m1287toAndroidFocusDirection3ESFkO8, currentlyFocusedRect) ? FocusRequester.INSTANCE.getDefault() : FocusRequester.INSTANCE.getCancel();
    }

    /* renamed from: onExit-3ESFkO8, reason: not valid java name */
    public final FocusRequester m2712onExit3ESFkO8(int focusDirection) {
        View view;
        Rect currentlyFocusedRect;
        boolean containsDescendant;
        view = FocusGroupNode_androidKt.getView(this);
        if (!view.hasFocus()) {
            return FocusRequester.INSTANCE.getDefault();
        }
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Object requireOwner = DelegatableNodeKt.requireOwner(this);
        Intrinsics.checkNotNull(requireOwner, "null cannot be cast to non-null type android.view.View");
        View view2 = (View) requireOwner;
        if (!(view instanceof ViewGroup)) {
            if (view2.requestFocus()) {
                return FocusRequester.INSTANCE.getDefault();
            }
            throw new IllegalStateException("host view did not take focus");
        }
        currentlyFocusedRect = FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, view2, view);
        Integer m1287toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m1287toAndroidFocusDirection3ESFkO8(focusDirection);
        int intValue = m1287toAndroidFocusDirection3ESFkO8 != null ? m1287toAndroidFocusDirection3ESFkO8.intValue() : 130;
        FocusFinder focusFinder = FocusFinder.getInstance();
        View view3 = this.focusedChild;
        View findNextFocus = view3 != null ? focusFinder.findNextFocus((ViewGroup) view2, view3, intValue) : focusFinder.findNextFocusFromRect((ViewGroup) view2, currentlyFocusedRect, intValue);
        if (findNextFocus != null) {
            containsDescendant = FocusGroupNode_androidKt.containsDescendant(view, findNextFocus);
            if (containsDescendant) {
                findNextFocus.requestFocus(intValue, currentlyFocusedRect);
                return FocusRequester.INSTANCE.getCancel();
            }
        }
        if (view2.requestFocus()) {
            return FocusRequester.INSTANCE.getDefault();
        }
        throw new IllegalStateException("host view did not take focus");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0076  */
    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        View view;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean containsDescendant;
        boolean containsDescendant2;
        if (DelegatableNodeKt.requireLayoutNode(this).getOwner() == null) {
            return;
        }
        view = FocusGroupNode_androidKt.getView(this);
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(this).getFocusOwner();
        Owner requireOwner = DelegatableNodeKt.requireOwner(this);
        if (oldFocus != null && !Intrinsics.areEqual(oldFocus, requireOwner)) {
            containsDescendant2 = FocusGroupNode_androidKt.containsDescendant(view, oldFocus);
            if (containsDescendant2) {
                z5 = true;
                if (newFocus != null && !Intrinsics.areEqual(newFocus, requireOwner)) {
                    containsDescendant = FocusGroupNode_androidKt.containsDescendant(view, newFocus);
                    if (containsDescendant) {
                        z6 = true;
                        if (!z5 && z6) {
                            this.focusedChild = newFocus;
                            return;
                        }
                        if (!z6) {
                            if (!z5) {
                                this.focusedChild = null;
                                return;
                            }
                            this.focusedChild = null;
                            if (getFocusTargetOfEmbeddedViewWrapper().getFocusState().isFocused()) {
                                focusOwner.mo1290clearFocusI7lrPNg(false, true, false, FocusDirection.INSTANCE.m1281getExitdhqQ8s());
                                return;
                            }
                            return;
                        }
                        this.focusedChild = newFocus;
                        FocusTargetNode focusTargetOfEmbeddedViewWrapper = getFocusTargetOfEmbeddedViewWrapper();
                        if (focusTargetOfEmbeddedViewWrapper.getFocusState().getHasFocus()) {
                            return;
                        }
                        FocusTransactionManager focusTransactionManager = focusOwner.getFocusTransactionManager();
                        try {
                            z7 = focusTransactionManager.ongoingTransaction;
                            if (z7) {
                                focusTransactionManager.cancelTransaction();
                            }
                            focusTransactionManager.beginTransaction();
                            FocusTransactionsKt.performRequestFocus(focusTargetOfEmbeddedViewWrapper);
                            focusTransactionManager.commitTransaction();
                            return;
                        } catch (Throwable th) {
                            focusTransactionManager.commitTransaction();
                            throw th;
                        }
                    }
                }
                z6 = false;
                if (!z5) {
                }
                if (!z6) {
                }
            }
        }
        z5 = false;
        if (newFocus != null) {
            containsDescendant = FocusGroupNode_androidKt.containsDescendant(view, newFocus);
            if (containsDescendant) {
            }
        }
        z6 = false;
        if (!z5) {
        }
        if (!z6) {
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v5) {
        v5.getViewTreeObserver().addOnGlobalFocusChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v5) {
        v5.getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
    }
}
