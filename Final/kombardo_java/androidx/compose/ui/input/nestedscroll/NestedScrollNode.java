package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\"\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J*\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010!\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010\u000eJ\u000f\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b#\u0010\u000eJ!\u0010%\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b$\u0010\bR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010.\u001a\u00020-8\u0016X\u0096D¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0016\u00103\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u0010(R\u0014\u00107\u001a\u0002048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0016\u0010:\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b8\u00109\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006;"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/ui/Modifier$Node;", "connection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "dispatcher", "<init>", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "newDispatcher", BuildConfig.FLAVOR, "updateDispatcher", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "updateDispatcherFields", "()V", "resetDispatcherFields", "Landroidx/compose/ui/geometry/Offset;", "available", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "source", "onPreScroll-OzD1aCk", "(JI)J", "onPreScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPostScroll", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onAttach", "onDetach", "updateNode$ui_release", "updateNode", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "resolvedDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", BuildConfig.FLAVOR, "traverseKey", "Ljava/lang/Object;", "getTraverseKey", "()Ljava/lang/Object;", "getParentConnection", "parentConnection", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "nestedCoroutineScope", "getParentNestedScrollNode$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "parentNestedScrollNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NestedScrollNode extends Modifier.Node implements TraversableNode, NestedScrollConnection {
    private NestedScrollConnection connection;
    private NestedScrollDispatcher resolvedDispatcher;
    private final Object traverseKey;

    public NestedScrollNode(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        this.connection = nestedScrollConnection;
        this.resolvedDispatcher = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        this.traverseKey = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope getNestedCoroutineScope() {
        CoroutineScope scope;
        NestedScrollNode parentNestedScrollNode$ui_release = getParentNestedScrollNode$ui_release();
        if ((parentNestedScrollNode$ui_release == null || (scope = parentNestedScrollNode$ui_release.getNestedCoroutineScope()) == null) && (scope = this.resolvedDispatcher.getScope()) == null) {
            throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        }
        return scope;
    }

    private final NestedScrollConnection getParentConnection() {
        if (getIsAttached()) {
            return getParentNestedScrollNode$ui_release();
        }
        return null;
    }

    private final void resetDispatcherFields() {
        if (this.resolvedDispatcher.getNestedScrollNode() == this) {
            this.resolvedDispatcher.setNestedScrollNode$ui_release(null);
        }
    }

    private final void updateDispatcher(NestedScrollDispatcher newDispatcher) {
        resetDispatcherFields();
        if (newDispatcher == null) {
            this.resolvedDispatcher = new NestedScrollDispatcher();
        } else if (!Intrinsics.areEqual(newDispatcher, this.resolvedDispatcher)) {
            this.resolvedDispatcher = newDispatcher;
        }
        if (getIsAttached()) {
            updateDispatcherFields();
        }
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setNestedScrollNode$ui_release(this);
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui_release(new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollNode$updateDispatcherFields$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                CoroutineScope nestedCoroutineScope;
                nestedCoroutineScope = NestedScrollNode.this.getNestedCoroutineScope();
                return nestedCoroutineScope;
            }
        });
        this.resolvedDispatcher.setScope$ui_release(getCoroutineScope());
    }

    public final NestedScrollNode getParentNestedScrollNode$ui_release() {
        if (getIsAttached()) {
            return (NestedScrollNode) TraversableNodeKt.findNearestAncestor(this);
        }
        return null;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDispatcherFields();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        resetDispatcherFields();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo218onPostFlingRZ2iAVY(long j5, long j6, Continuation<? super Velocity> continuation) {
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$1;
        int i5;
        long j7;
        long j8;
        NestedScrollNode nestedScrollNode;
        NestedScrollConnection parentConnection;
        long j9;
        long m2709getZero9UxMQ8M;
        long j10;
        if (continuation instanceof NestedScrollNode$onPostFling$1) {
            nestedScrollNode$onPostFling$1 = (NestedScrollNode$onPostFling$1) continuation;
            int i6 = nestedScrollNode$onPostFling$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPostFling$1.label = i6 - Integer.MIN_VALUE;
                Object obj = nestedScrollNode$onPostFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = nestedScrollNode$onPostFling$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    NestedScrollConnection nestedScrollConnection = this.connection;
                    nestedScrollNode$onPostFling$1.L$0 = this;
                    j7 = j5;
                    nestedScrollNode$onPostFling$1.J$0 = j7;
                    j8 = j6;
                    nestedScrollNode$onPostFling$1.J$1 = j8;
                    nestedScrollNode$onPostFling$1.label = 1;
                    obj = nestedScrollConnection.mo218onPostFlingRZ2iAVY(j5, j6, nestedScrollNode$onPostFling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nestedScrollNode = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        j10 = nestedScrollNode$onPostFling$1.J$0;
                        ResultKt.throwOnFailure(obj);
                        m2709getZero9UxMQ8M = ((Velocity) obj).getPackedValue();
                        j9 = j10;
                        return Velocity.m2695boximpl(Velocity.m2705plusAH228Gc(j9, m2709getZero9UxMQ8M));
                    }
                    long j11 = nestedScrollNode$onPostFling$1.J$1;
                    long j12 = nestedScrollNode$onPostFling$1.J$0;
                    nestedScrollNode = (NestedScrollNode) nestedScrollNode$onPostFling$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    j8 = j11;
                    j7 = j12;
                }
                long packedValue = ((Velocity) obj).getPackedValue();
                parentConnection = nestedScrollNode.getParentConnection();
                if (parentConnection != null) {
                    j9 = packedValue;
                    m2709getZero9UxMQ8M = Velocity.INSTANCE.m2709getZero9UxMQ8M();
                    return Velocity.m2695boximpl(Velocity.m2705plusAH228Gc(j9, m2709getZero9UxMQ8M));
                }
                long m2705plusAH228Gc = Velocity.m2705plusAH228Gc(j7, packedValue);
                long m2704minusAH228Gc = Velocity.m2704minusAH228Gc(j8, packedValue);
                nestedScrollNode$onPostFling$1.L$0 = null;
                nestedScrollNode$onPostFling$1.J$0 = packedValue;
                nestedScrollNode$onPostFling$1.label = 2;
                obj = parentConnection.mo218onPostFlingRZ2iAVY(m2705plusAH228Gc, m2704minusAH228Gc, nestedScrollNode$onPostFling$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j10 = packedValue;
                m2709getZero9UxMQ8M = ((Velocity) obj).getPackedValue();
                j9 = j10;
                return Velocity.m2695boximpl(Velocity.m2705plusAH228Gc(j9, m2709getZero9UxMQ8M));
            }
        }
        nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, continuation);
        Object obj2 = nestedScrollNode$onPostFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = nestedScrollNode$onPostFling$1.label;
        if (i5 != 0) {
        }
        long packedValue2 = ((Velocity) obj2).getPackedValue();
        parentConnection = nestedScrollNode.getParentConnection();
        if (parentConnection != null) {
        }
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo219onPostScrollDzOQY0M(long consumed, long available, int source) {
        long mo219onPostScrollDzOQY0M = this.connection.mo219onPostScrollDzOQY0M(consumed, available, source);
        NestedScrollConnection parentConnection = getParentConnection();
        return Offset.m1342plusMKHz9U(mo219onPostScrollDzOQY0M, parentConnection != null ? parentConnection.mo219onPostScrollDzOQY0M(Offset.m1342plusMKHz9U(consumed, mo219onPostScrollDzOQY0M), Offset.m1341minusMKHz9U(available, mo219onPostScrollDzOQY0M), source) : Offset.INSTANCE.m1349getZeroF1C5BW0());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo711onPreFlingQWom1Mo(long j5, Continuation<? super Velocity> continuation) {
        NestedScrollNode$onPreFling$1 nestedScrollNode$onPreFling$1;
        Object obj;
        Object coroutine_suspended;
        int i5;
        long m2709getZero9UxMQ8M;
        NestedScrollNode nestedScrollNode;
        long j6;
        if (continuation instanceof NestedScrollNode$onPreFling$1) {
            nestedScrollNode$onPreFling$1 = (NestedScrollNode$onPreFling$1) continuation;
            int i6 = nestedScrollNode$onPreFling$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPreFling$1.label = i6 - Integer.MIN_VALUE;
                obj = nestedScrollNode$onPreFling$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = nestedScrollNode$onPreFling$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    NestedScrollConnection parentConnection = getParentConnection();
                    if (parentConnection == null) {
                        m2709getZero9UxMQ8M = Velocity.INSTANCE.m2709getZero9UxMQ8M();
                        nestedScrollNode = this;
                        long j7 = j5;
                        j6 = m2709getZero9UxMQ8M;
                        NestedScrollConnection nestedScrollConnection = nestedScrollNode.connection;
                        long m2704minusAH228Gc = Velocity.m2704minusAH228Gc(j7, j6);
                        nestedScrollNode$onPreFling$1.L$0 = null;
                        nestedScrollNode$onPreFling$1.J$0 = j6;
                        nestedScrollNode$onPreFling$1.label = 2;
                        obj = nestedScrollConnection.mo711onPreFlingQWom1Mo(m2704minusAH228Gc, nestedScrollNode$onPreFling$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Velocity.m2695boximpl(Velocity.m2705plusAH228Gc(j6, ((Velocity) obj).getPackedValue()));
                    }
                    nestedScrollNode$onPreFling$1.L$0 = this;
                    nestedScrollNode$onPreFling$1.J$0 = j5;
                    nestedScrollNode$onPreFling$1.label = 1;
                    obj = parentConnection.mo711onPreFlingQWom1Mo(j5, nestedScrollNode$onPreFling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    nestedScrollNode = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        j6 = nestedScrollNode$onPreFling$1.J$0;
                        ResultKt.throwOnFailure(obj);
                        return Velocity.m2695boximpl(Velocity.m2705plusAH228Gc(j6, ((Velocity) obj).getPackedValue()));
                    }
                    j5 = nestedScrollNode$onPreFling$1.J$0;
                    nestedScrollNode = (NestedScrollNode) nestedScrollNode$onPreFling$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                m2709getZero9UxMQ8M = ((Velocity) obj).getPackedValue();
                long j72 = j5;
                j6 = m2709getZero9UxMQ8M;
                NestedScrollConnection nestedScrollConnection2 = nestedScrollNode.connection;
                long m2704minusAH228Gc2 = Velocity.m2704minusAH228Gc(j72, j6);
                nestedScrollNode$onPreFling$1.L$0 = null;
                nestedScrollNode$onPreFling$1.J$0 = j6;
                nestedScrollNode$onPreFling$1.label = 2;
                obj = nestedScrollConnection2.mo711onPreFlingQWom1Mo(m2704minusAH228Gc2, nestedScrollNode$onPreFling$1);
                if (obj == coroutine_suspended) {
                }
                return Velocity.m2695boximpl(Velocity.m2705plusAH228Gc(j6, ((Velocity) obj).getPackedValue()));
            }
        }
        nestedScrollNode$onPreFling$1 = new NestedScrollNode$onPreFling$1(this, continuation);
        obj = nestedScrollNode$onPreFling$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = nestedScrollNode$onPreFling$1.label;
        if (i5 != 0) {
        }
        m2709getZero9UxMQ8M = ((Velocity) obj).getPackedValue();
        long j722 = j5;
        j6 = m2709getZero9UxMQ8M;
        NestedScrollConnection nestedScrollConnection22 = nestedScrollNode.connection;
        long m2704minusAH228Gc22 = Velocity.m2704minusAH228Gc(j722, j6);
        nestedScrollNode$onPreFling$1.L$0 = null;
        nestedScrollNode$onPreFling$1.J$0 = j6;
        nestedScrollNode$onPreFling$1.label = 2;
        obj = nestedScrollConnection22.mo711onPreFlingQWom1Mo(m2704minusAH228Gc22, nestedScrollNode$onPreFling$1);
        if (obj == coroutine_suspended) {
        }
        return Velocity.m2695boximpl(Velocity.m2705plusAH228Gc(j6, ((Velocity) obj).getPackedValue()));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo435onPreScrollOzD1aCk(long available, int source) {
        NestedScrollConnection parentConnection = getParentConnection();
        long mo435onPreScrollOzD1aCk = parentConnection != null ? parentConnection.mo435onPreScrollOzD1aCk(available, source) : Offset.INSTANCE.m1349getZeroF1C5BW0();
        return Offset.m1342plusMKHz9U(mo435onPreScrollOzD1aCk, this.connection.mo435onPreScrollOzD1aCk(Offset.m1341minusMKHz9U(available, mo435onPreScrollOzD1aCk), source));
    }

    public final void updateNode$ui_release(NestedScrollConnection connection, NestedScrollDispatcher dispatcher) {
        this.connection = connection;
        updateDispatcher(dispatcher);
    }
}
