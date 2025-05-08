package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000f\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0000¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "requestFocus", BuildConfig.FLAVOR, "focus$ui_release", "()Z", "focus", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusTargetNode;", "onFound", "findFocusTargetNode$ui_release", "(Lkotlin/jvm/functions/Function1;)Z", "findFocusTargetNode", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "focusRequesterNodes", "Landroidx/compose/runtime/collection/MutableVector;", "getFocusRequesterNodes$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusRequester {
    private final MutableVector<FocusRequesterModifierNode> focusRequesterNodes = new MutableVector<>(new FocusRequesterModifierNode[16], 0);

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final FocusRequester Default = new FocusRequester();
    private static final FocusRequester Cancel = new FocusRequester();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\u00020\u00048GX\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010\u0006\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\n\u0010\b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/focus/FocusRequester;", "Default", "Landroidx/compose/ui/focus/FocusRequester;", "getDefault", "()Landroidx/compose/ui/focus/FocusRequester;", "Cancel", "getCancel", "getCancel$annotations", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FocusRequester getCancel() {
            return FocusRequester.Cancel;
        }

        public final FocusRequester getDefault() {
            return FocusRequester.Default;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x005d, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean findFocusTargetNode$ui_release(Function1<? super FocusTargetNode, Boolean> onFound) {
        Companion companion = INSTANCE;
        if (this == companion.getDefault()) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
        }
        if (this == companion.getCancel()) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
        }
        if (!this.focusRequesterNodes.isNotEmpty()) {
            throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
        }
        MutableVector<FocusRequesterModifierNode> mutableVector = this.focusRequesterNodes;
        int size = mutableVector.getSize();
        if (size <= 0) {
            return false;
        }
        FocusRequesterModifierNode[] content = mutableVector.getContent();
        int i5 = 0;
        boolean z5 = false;
        do {
            FocusRequesterModifierNode focusRequesterModifierNode = content[i5];
            int m2074constructorimpl = NodeKind.m2074constructorimpl(1024);
            if (!focusRequesterModifierNode.getNode().getIsAttached()) {
                throw new IllegalStateException("visitChildren called on an unattached node");
            }
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child = focusRequesterModifierNode.getNode().getChild();
            if (child == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, focusRequesterModifierNode.getNode());
            } else {
                mutableVector2.add(child);
            }
            while (true) {
                if (!mutableVector2.isNotEmpty()) {
                    break;
                }
                Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
                if ((node.getAggregateChildKindSet() & m2074constructorimpl) == 0) {
                    DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node);
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
                                    if (focusTargetNode.fetchFocusProperties$ui_release().getCanFocus() ? onFound.invoke(focusTargetNode).booleanValue() : TwoDimensionalFocusSearchKt.m1316findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, FocusDirection.INSTANCE.m1280getEnterdhqQ8s(), onFound)) {
                                        z5 = true;
                                        break;
                                    }
                                } else if (((node.getKindSet() & m2074constructorimpl) != 0) && (node instanceof DelegatingNode)) {
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
                                node = DelegatableNodeKt.access$pop(mutableVector3);
                            }
                        } else {
                            node = node.getChild();
                        }
                    }
                }
            }
            i5++;
        } while (i5 < size);
        return z5;
    }

    public final boolean focus$ui_release() {
        return findFocusTargetNode$ui_release(new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusRequester$focus$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(FocusTransactionsKt.requestFocus(focusTargetNode));
            }
        });
    }

    public final MutableVector<FocusRequesterModifierNode> getFocusRequesterNodes$ui_release() {
        return this.focusRequesterNodes;
    }

    public final void requestFocus() {
        focus$ui_release();
    }
}
