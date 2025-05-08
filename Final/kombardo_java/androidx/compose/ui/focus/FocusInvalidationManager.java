package androidx.compose.ui.focus;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eJ%\u0010\u0013\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00150\t2\u0006\u0010\u0014\u001a\u0002H\u0015H\u0002¢\u0006\u0002\u0010\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/focus/FocusInvalidationManager;", BuildConfig.FLAVOR, "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "invalidateOwnerFocusState", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "focusEventNodes", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "focusPropertiesNodes", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "focusTargetNodes", "Landroidx/compose/ui/focus/FocusTargetNode;", "focusTargetsWithInvalidatedFocusEvents", "hasPendingInvalidation", BuildConfig.FLAVOR, "invalidateNodes", "scheduleInvalidation", "node", "T", "(Landroidx/collection/MutableScatterSet;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusInvalidationManager {
    private final Function0<Unit> invalidateOwnerFocusState;
    private final Function1<Function0<Unit>, Unit> onRequestApplyChangesListener;
    private final MutableScatterSet<FocusTargetNode> focusTargetNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusEventModifierNode> focusEventNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusPropertiesModifierNode> focusPropertiesNodes = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterSet<FocusTargetNode> focusTargetsWithInvalidatedFocusEvents = ScatterSetKt.mutableScatterSetOf();

    /* JADX WARN: Multi-variable type inference failed */
    public FocusInvalidationManager(Function1<? super Function0<Unit>, Unit> function1, Function0<Unit> function0) {
        this.onRequestApplyChangesListener = function1;
        this.invalidateOwnerFocusState = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateNodes() {
        int i5;
        long[] jArr;
        Object[] objArr;
        long[] jArr2;
        Object[] objArr2;
        FocusState focusState;
        MutableVector mutableVector;
        int i6;
        int i7;
        int i8;
        long[] jArr3;
        Object[] objArr3;
        boolean z5;
        Object[] objArr4;
        boolean z6;
        int i9;
        MutableVector mutableVector2;
        long[] jArr4;
        long[] jArr5;
        int i10;
        long[] jArr6;
        long[] jArr7;
        MutableScatterSet<FocusPropertiesModifierNode> mutableScatterSet = this.focusPropertiesNodes;
        Object[] objArr5 = mutableScatterSet.elements;
        long[] jArr8 = mutableScatterSet.metadata;
        int length = jArr8.length - 2;
        char c5 = 7;
        long j5 = -9187201950435737472L;
        int i11 = 8;
        int i12 = 1;
        if (length >= 0) {
            int i13 = 0;
            while (true) {
                long j6 = jArr8[i13];
                if ((((~j6) << c5) & j6 & j5) != j5) {
                    int i14 = 8 - ((~(i13 - length)) >>> 31);
                    int i15 = 0;
                    while (i15 < i14) {
                        if ((j6 & 255) < 128) {
                            FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) objArr5[(i13 << 3) + i15];
                            if (focusPropertiesModifierNode.getNode().getIsAttached()) {
                                int m2074constructorimpl = NodeKind.m2074constructorimpl(1024);
                                Modifier.Node node = focusPropertiesModifierNode.getNode();
                                MutableVector mutableVector3 = null;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        this.focusTargetNodes.add((FocusTargetNode) node);
                                    } else if ((node.getKindSet() & m2074constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                        Modifier.Node delegate = ((DelegatingNode) node).getDelegate();
                                        int i16 = 0;
                                        while (delegate != null) {
                                            if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                                i16++;
                                                if (i16 == i12) {
                                                    jArr7 = jArr8;
                                                    node = delegate;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        jArr7 = jArr8;
                                                        mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        jArr7 = jArr8;
                                                    }
                                                    if (node != null) {
                                                        mutableVector3.add(node);
                                                        node = null;
                                                    }
                                                    mutableVector3.add(delegate);
                                                }
                                            } else {
                                                jArr7 = jArr8;
                                            }
                                            delegate = delegate.getChild();
                                            jArr8 = jArr7;
                                            i12 = 1;
                                        }
                                        jArr6 = jArr8;
                                        int i17 = i12;
                                        if (i16 == i17) {
                                            i12 = i17;
                                            jArr8 = jArr6;
                                        }
                                        node = DelegatableNodeKt.pop(mutableVector3);
                                        jArr8 = jArr6;
                                        i12 = 1;
                                    }
                                    jArr6 = jArr8;
                                    node = DelegatableNodeKt.pop(mutableVector3);
                                    jArr8 = jArr6;
                                    i12 = 1;
                                }
                                jArr5 = jArr8;
                                if (!focusPropertiesModifierNode.getNode().getIsAttached()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node");
                                }
                                MutableVector mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                Modifier.Node child = focusPropertiesModifierNode.getNode().getChild();
                                if (child == null) {
                                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector4, focusPropertiesModifierNode.getNode());
                                } else {
                                    mutableVector4.add(child);
                                }
                                while (mutableVector4.isNotEmpty()) {
                                    Modifier.Node node2 = (Modifier.Node) mutableVector4.removeAt(mutableVector4.getSize() - 1);
                                    if ((node2.getAggregateChildKindSet() & m2074constructorimpl) == 0) {
                                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector4, node2);
                                    } else {
                                        while (true) {
                                            if (node2 == null) {
                                                break;
                                            }
                                            if ((node2.getKindSet() & m2074constructorimpl) != 0) {
                                                MutableVector mutableVector5 = null;
                                                while (node2 != null) {
                                                    if (node2 instanceof FocusTargetNode) {
                                                        this.focusTargetNodes.add((FocusTargetNode) node2);
                                                    } else if ((node2.getKindSet() & m2074constructorimpl) != 0 && (node2 instanceof DelegatingNode)) {
                                                        int i18 = 0;
                                                        for (Modifier.Node delegate2 = ((DelegatingNode) node2).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                                            if ((delegate2.getKindSet() & m2074constructorimpl) != 0) {
                                                                i18++;
                                                                if (i18 == 1) {
                                                                    node2 = delegate2;
                                                                } else {
                                                                    if (mutableVector5 == null) {
                                                                        mutableVector5 = new MutableVector(new Modifier.Node[16], 0);
                                                                    }
                                                                    if (node2 != null) {
                                                                        mutableVector5.add(node2);
                                                                        node2 = null;
                                                                    }
                                                                    mutableVector5.add(delegate2);
                                                                }
                                                            }
                                                        }
                                                        if (i18 == 1) {
                                                        }
                                                    }
                                                    node2 = DelegatableNodeKt.pop(mutableVector5);
                                                }
                                            } else {
                                                node2 = node2.getChild();
                                            }
                                        }
                                    }
                                }
                            } else {
                                jArr5 = jArr8;
                            }
                            i10 = 8;
                        } else {
                            jArr5 = jArr8;
                            i10 = i11;
                        }
                        j6 >>= i10;
                        i15++;
                        i11 = i10;
                        jArr8 = jArr5;
                        i12 = 1;
                    }
                    jArr4 = jArr8;
                    if (i14 != i11) {
                        break;
                    }
                } else {
                    jArr4 = jArr8;
                }
                if (i13 == length) {
                    break;
                }
                i13++;
                jArr8 = jArr4;
                c5 = 7;
                j5 = -9187201950435737472L;
                i12 = 1;
                i11 = 8;
            }
        }
        this.focusPropertiesNodes.clear();
        MutableScatterSet<FocusEventModifierNode> mutableScatterSet2 = this.focusEventNodes;
        Object[] objArr6 = mutableScatterSet2.elements;
        long[] jArr9 = mutableScatterSet2.metadata;
        int length2 = jArr9.length - 2;
        if (length2 >= 0) {
            int i19 = 0;
            while (true) {
                long j7 = jArr9[i19];
                if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i20 = 8 - ((~(i19 - length2)) >>> 31);
                    int i21 = 0;
                    while (i21 < i20) {
                        if ((j7 & 255) < 128) {
                            FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) objArr6[(i19 << 3) + i21];
                            if (focusEventModifierNode.getNode().getIsAttached()) {
                                int m2074constructorimpl2 = NodeKind.m2074constructorimpl(1024);
                                Modifier.Node node3 = focusEventModifierNode.getNode();
                                boolean z7 = false;
                                boolean z8 = true;
                                FocusTargetNode focusTargetNode = null;
                                MutableVector mutableVector6 = null;
                                while (node3 != null) {
                                    if (node3 instanceof FocusTargetNode) {
                                        FocusTargetNode focusTargetNode2 = (FocusTargetNode) node3;
                                        if (focusTargetNode != null) {
                                            z7 = true;
                                        }
                                        if (this.focusTargetNodes.contains(focusTargetNode2)) {
                                            this.focusTargetsWithInvalidatedFocusEvents.add(focusTargetNode2);
                                            z8 = false;
                                        }
                                        jArr3 = jArr9;
                                        objArr3 = objArr6;
                                        focusTargetNode = focusTargetNode2;
                                    } else {
                                        if ((node3.getKindSet() & m2074constructorimpl2) == 0 || !(node3 instanceof DelegatingNode)) {
                                            jArr3 = jArr9;
                                            objArr3 = objArr6;
                                            z5 = z7;
                                        } else {
                                            Modifier.Node delegate3 = ((DelegatingNode) node3).getDelegate();
                                            jArr3 = jArr9;
                                            int i22 = 0;
                                            while (delegate3 != null) {
                                                if ((delegate3.getKindSet() & m2074constructorimpl2) != 0) {
                                                    i22++;
                                                    objArr4 = objArr6;
                                                    if (i22 == 1) {
                                                        node3 = delegate3;
                                                    } else {
                                                        if (mutableVector6 == null) {
                                                            i9 = i22;
                                                            z6 = z7;
                                                            mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                        } else {
                                                            i9 = i22;
                                                            z6 = z7;
                                                            mutableVector2 = mutableVector6;
                                                        }
                                                        if (node3 != null) {
                                                            mutableVector2.add(node3);
                                                            node3 = null;
                                                        }
                                                        mutableVector2.add(delegate3);
                                                        mutableVector6 = mutableVector2;
                                                        i22 = i9;
                                                        delegate3 = delegate3.getChild();
                                                        objArr6 = objArr4;
                                                        z7 = z6;
                                                    }
                                                } else {
                                                    objArr4 = objArr6;
                                                }
                                                z6 = z7;
                                                delegate3 = delegate3.getChild();
                                                objArr6 = objArr4;
                                                z7 = z6;
                                            }
                                            objArr3 = objArr6;
                                            z5 = z7;
                                            if (i22 == 1) {
                                                jArr9 = jArr3;
                                                objArr6 = objArr3;
                                                z7 = z5;
                                            }
                                        }
                                        z7 = z5;
                                    }
                                    node3 = DelegatableNodeKt.pop(mutableVector6);
                                    jArr9 = jArr3;
                                    objArr6 = objArr3;
                                }
                                jArr2 = jArr9;
                                objArr2 = objArr6;
                                boolean z9 = z7;
                                if (!focusEventModifierNode.getNode().getIsAttached()) {
                                    throw new IllegalStateException("visitChildren called on an unattached node");
                                }
                                MutableVector mutableVector7 = new MutableVector(new Modifier.Node[16], 0);
                                Modifier.Node child2 = focusEventModifierNode.getNode().getChild();
                                if (child2 == null) {
                                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector7, focusEventModifierNode.getNode());
                                } else {
                                    mutableVector7.add(child2);
                                }
                                boolean z10 = z9;
                                while (mutableVector7.isNotEmpty()) {
                                    Modifier.Node node4 = (Modifier.Node) mutableVector7.removeAt(mutableVector7.getSize() - 1);
                                    if ((node4.getAggregateChildKindSet() & m2074constructorimpl2) == 0) {
                                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector7, node4);
                                    } else {
                                        while (node4 != null) {
                                            if ((node4.getKindSet() & m2074constructorimpl2) != 0) {
                                                MutableVector mutableVector8 = null;
                                                while (node4 != null) {
                                                    if (node4 instanceof FocusTargetNode) {
                                                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) node4;
                                                        if (focusTargetNode != null) {
                                                            z10 = true;
                                                        }
                                                        if (this.focusTargetNodes.contains(focusTargetNode3)) {
                                                            this.focusTargetsWithInvalidatedFocusEvents.add(focusTargetNode3);
                                                            z8 = false;
                                                        }
                                                        mutableVector = mutableVector7;
                                                        focusTargetNode = focusTargetNode3;
                                                    } else if ((node4.getKindSet() & m2074constructorimpl2) == 0 || !(node4 instanceof DelegatingNode)) {
                                                        mutableVector = mutableVector7;
                                                    } else {
                                                        Modifier.Node delegate4 = ((DelegatingNode) node4).getDelegate();
                                                        mutableVector = mutableVector7;
                                                        int i23 = 0;
                                                        while (delegate4 != null) {
                                                            if ((delegate4.getKindSet() & m2074constructorimpl2) != 0) {
                                                                i23++;
                                                                i7 = m2074constructorimpl2;
                                                                if (i23 == 1) {
                                                                    node4 = delegate4;
                                                                } else {
                                                                    if (mutableVector8 == null) {
                                                                        i8 = i23;
                                                                        mutableVector8 = new MutableVector(new Modifier.Node[16], 0);
                                                                    } else {
                                                                        i8 = i23;
                                                                    }
                                                                    if (node4 != null) {
                                                                        mutableVector8.add(node4);
                                                                        node4 = null;
                                                                    }
                                                                    mutableVector8.add(delegate4);
                                                                    i23 = i8;
                                                                    delegate4 = delegate4.getChild();
                                                                    m2074constructorimpl2 = i7;
                                                                }
                                                            } else {
                                                                i7 = m2074constructorimpl2;
                                                            }
                                                            delegate4 = delegate4.getChild();
                                                            m2074constructorimpl2 = i7;
                                                        }
                                                        i6 = m2074constructorimpl2;
                                                        if (i23 == 1) {
                                                            mutableVector7 = mutableVector;
                                                            m2074constructorimpl2 = i6;
                                                        }
                                                        node4 = DelegatableNodeKt.pop(mutableVector8);
                                                        mutableVector7 = mutableVector;
                                                        m2074constructorimpl2 = i6;
                                                    }
                                                    i6 = m2074constructorimpl2;
                                                    node4 = DelegatableNodeKt.pop(mutableVector8);
                                                    mutableVector7 = mutableVector;
                                                    m2074constructorimpl2 = i6;
                                                }
                                            } else {
                                                node4 = node4.getChild();
                                                m2074constructorimpl2 = m2074constructorimpl2;
                                            }
                                        }
                                    }
                                    mutableVector7 = mutableVector7;
                                    m2074constructorimpl2 = m2074constructorimpl2;
                                }
                                if (z8) {
                                    if (z10) {
                                        focusState = FocusEventModifierNodeKt.getFocusState(focusEventModifierNode);
                                    } else if (focusTargetNode == null || (focusState = focusTargetNode.getFocusState()) == null) {
                                        focusState = FocusStateImpl.Inactive;
                                    }
                                    focusEventModifierNode.onFocusEvent(focusState);
                                }
                                j7 >>= 8;
                                i21++;
                                jArr9 = jArr2;
                                objArr6 = objArr2;
                            } else {
                                focusEventModifierNode.onFocusEvent(FocusStateImpl.Inactive);
                            }
                        }
                        jArr2 = jArr9;
                        objArr2 = objArr6;
                        j7 >>= 8;
                        i21++;
                        jArr9 = jArr2;
                        objArr6 = objArr2;
                    }
                    jArr = jArr9;
                    objArr = objArr6;
                    i5 = 0;
                    if (i20 != 8) {
                        break;
                    }
                } else {
                    jArr = jArr9;
                    objArr = objArr6;
                    i5 = 0;
                }
                if (i19 == length2) {
                    break;
                }
                i19++;
                jArr9 = jArr;
                objArr6 = objArr;
            }
        } else {
            i5 = 0;
        }
        this.focusEventNodes.clear();
        MutableScatterSet<FocusTargetNode> mutableScatterSet3 = this.focusTargetNodes;
        Object[] objArr7 = mutableScatterSet3.elements;
        long[] jArr10 = mutableScatterSet3.metadata;
        int length3 = jArr10.length - 2;
        if (length3 >= 0) {
            int i24 = i5;
            while (true) {
                long j8 = jArr10[i24];
                if ((((~j8) << 7) & j8 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i25 = 8 - ((~(i24 - length3)) >>> 31);
                    for (int i26 = i5; i26 < i25; i26++) {
                        if ((j8 & 255) < 128) {
                            FocusTargetNode focusTargetNode4 = (FocusTargetNode) objArr7[(i24 << 3) + i26];
                            if (focusTargetNode4.getIsAttached()) {
                                FocusStateImpl focusState2 = focusTargetNode4.getFocusState();
                                focusTargetNode4.invalidateFocus$ui_release();
                                if (focusState2 != focusTargetNode4.getFocusState() || this.focusTargetsWithInvalidatedFocusEvents.contains(focusTargetNode4)) {
                                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode4);
                                }
                            }
                        }
                        j8 >>= 8;
                    }
                    if (i25 != 8) {
                        break;
                    }
                }
                if (i24 == length3) {
                    break;
                } else {
                    i24++;
                }
            }
        }
        this.focusTargetNodes.clear();
        this.focusTargetsWithInvalidatedFocusEvents.clear();
        this.invalidateOwnerFocusState.invoke();
        if (!this.focusPropertiesNodes.isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusProperties nodes");
        }
        if (!this.focusEventNodes.isEmpty()) {
            InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusEvent nodes");
        }
        if (this.focusTargetNodes.isEmpty()) {
            return;
        }
        InlineClassHelperKt.throwIllegalStateException("Unprocessed FocusTarget nodes");
    }

    public final boolean hasPendingInvalidation() {
        return this.focusTargetNodes.isNotEmpty() || this.focusPropertiesNodes.isNotEmpty() || this.focusEventNodes.isNotEmpty();
    }

    public final void scheduleInvalidation(FocusTargetNode node) {
        scheduleInvalidation(this.focusTargetNodes, node);
    }

    public final void scheduleInvalidation(FocusEventModifierNode node) {
        scheduleInvalidation(this.focusEventNodes, node);
    }

    public final void scheduleInvalidation(FocusPropertiesModifierNode node) {
        scheduleInvalidation(this.focusPropertiesNodes, node);
    }

    private final <T> void scheduleInvalidation(MutableScatterSet<T> mutableScatterSet, T t5) {
        if (mutableScatterSet.add(t5) && this.focusTargetNodes.get_size() + this.focusEventNodes.get_size() + this.focusPropertiesNodes.get_size() == 1) {
            this.onRequestApplyChangesListener.invoke(new FocusInvalidationManager$scheduleInvalidation$1(this));
        }
    }
}
