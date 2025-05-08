package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030#2\u0006\u0010\"\u001a\u00020!H\u0014¢\u0006\u0004\b$\u0010%J-\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020!2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R*\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\b3\u0010\u0019\u001a\u0004\b0\u00101\"\u0004\b2\u0010\tR\u0011\u00105\u001a\b\u0012\u0004\u0012\u00020\u0005048\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "initialState", "<init>", "(Ljava/lang/Object;)V", "expectedState", "newState", BuildConfig.FLAVOR, "updateState", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "expect", "update", "compareAndSet", "value", "tryEmit", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetReplayCache", "()V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", BuildConfig.FLAVOR, "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", BuildConfig.FLAVOR, "size", BuildConfig.FLAVOR, "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "sequence", "I", "getValue", "()Ljava/lang/Object;", "setValue", "getValue$annotations", "Lkotlinx/atomicfu/AtomicRef;", "_state", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, Flow, FusibleFlow<T> {
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");
    private volatile Object _state;
    private int sequence;

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    private final boolean updateState(Object expectedState, Object newState) {
        int i5;
        StateFlowSlot[] slots;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (expectedState != null && !Intrinsics.areEqual(obj, expectedState)) {
                return false;
            }
            if (Intrinsics.areEqual(obj, newState)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, newState);
            int i6 = this.sequence;
            if ((i6 & 1) != 0) {
                this.sequence = i6 + 2;
                return true;
            }
            int i7 = i6 + 1;
            this.sequence = i7;
            StateFlowSlot[] slots2 = getSlots();
            Unit unit = Unit.INSTANCE;
            while (true) {
                StateFlowSlot[] stateFlowSlotArr = slots2;
                if (stateFlowSlotArr != null) {
                    for (StateFlowSlot stateFlowSlot : stateFlowSlotArr) {
                        if (stateFlowSlot != null) {
                            stateFlowSlot.makePending();
                        }
                    }
                }
                synchronized (this) {
                    i5 = this.sequence;
                    if (i5 == i7) {
                        this.sequence = i7 + 1;
                        return true;
                    }
                    slots = getSlots();
                    Unit unit2 = Unit.INSTANCE;
                }
                slots2 = slots;
                i7 = i5;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0097 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:14:0x003e, B:15:0x008f, B:17:0x0097, B:19:0x009c, B:21:0x00bd, B:23:0x00c3, B:27:0x00a2, B:30:0x00a9, B:39:0x005f, B:41:0x0071, B:42:0x0080), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009c A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:14:0x003e, B:15:0x008f, B:17:0x0097, B:19:0x009c, B:21:0x00bd, B:23:0x00c3, B:27:0x00a2, B:30:0x00a9, B:39:0x005f, B:41:0x0071, B:42:0x0080), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c3 A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:14:0x003e, B:15:0x008f, B:17:0x0097, B:19:0x009c, B:21:0x00bd, B:23:0x00c3, B:27:0x00a2, B:30:0x00a9, B:39:0x005f, B:41:0x0071, B:42:0x0080), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00c1 -> B:15:0x008f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00d3 -> B:15:0x008f). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        StateFlowImpl$collect$1 stateFlowImpl$collect$1;
        Object coroutine_suspended;
        int i5;
        StateFlowImpl<T> stateFlowImpl;
        StateFlowSlot allocateSlot;
        FlowCollector flowCollector2;
        Job job;
        Object obj;
        Object obj2;
        T t5;
        try {
            if (continuation instanceof StateFlowImpl$collect$1) {
                stateFlowImpl$collect$1 = (StateFlowImpl$collect$1) continuation;
                int i6 = stateFlowImpl$collect$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    stateFlowImpl$collect$1.label = i6 - Integer.MIN_VALUE;
                    Object obj3 = stateFlowImpl$collect$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = stateFlowImpl$collect$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj3);
                        stateFlowImpl = this;
                        allocateSlot = allocateSlot();
                    } else if (i5 == 1) {
                        allocateSlot = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                        flowCollector = (FlowCollector) stateFlowImpl$collect$1.L$1;
                        stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                        ResultKt.throwOnFailure(obj3);
                    } else if (i5 == 2) {
                        obj = stateFlowImpl$collect$1.L$4;
                        job = (Job) stateFlowImpl$collect$1.L$3;
                        allocateSlot = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                        flowCollector2 = (FlowCollector) stateFlowImpl$collect$1.L$1;
                        stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                        ResultKt.throwOnFailure(obj3);
                        if (!allocateSlot.takePending()) {
                        }
                        obj2 = _state$FU.get(stateFlowImpl);
                        if (job != null) {
                        }
                        if (obj != null) {
                        }
                        if (obj2 == NullSurrogateKt.NULL) {
                        }
                        stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                        stateFlowImpl$collect$1.L$1 = flowCollector2;
                        stateFlowImpl$collect$1.L$2 = allocateSlot;
                        stateFlowImpl$collect$1.L$3 = job;
                        stateFlowImpl$collect$1.L$4 = obj2;
                        stateFlowImpl$collect$1.label = 2;
                        if (flowCollector2.emit(t5, stateFlowImpl$collect$1) == coroutine_suspended) {
                        }
                    } else {
                        if (i5 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        obj = stateFlowImpl$collect$1.L$4;
                        job = (Job) stateFlowImpl$collect$1.L$3;
                        allocateSlot = (StateFlowSlot) stateFlowImpl$collect$1.L$2;
                        flowCollector2 = (FlowCollector) stateFlowImpl$collect$1.L$1;
                        stateFlowImpl = (StateFlowImpl) stateFlowImpl$collect$1.L$0;
                        ResultKt.throwOnFailure(obj3);
                        obj2 = _state$FU.get(stateFlowImpl);
                        if (job != null) {
                            JobKt.ensureActive(job);
                        }
                        if (obj != null || !Intrinsics.areEqual(obj, obj2)) {
                            t5 = obj2 == NullSurrogateKt.NULL ? null : obj2;
                            stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                            stateFlowImpl$collect$1.L$1 = flowCollector2;
                            stateFlowImpl$collect$1.L$2 = allocateSlot;
                            stateFlowImpl$collect$1.L$3 = job;
                            stateFlowImpl$collect$1.L$4 = obj2;
                            stateFlowImpl$collect$1.label = 2;
                            if (flowCollector2.emit(t5, stateFlowImpl$collect$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj = obj2;
                        }
                        if (!allocateSlot.takePending()) {
                            stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                            stateFlowImpl$collect$1.L$1 = flowCollector2;
                            stateFlowImpl$collect$1.L$2 = allocateSlot;
                            stateFlowImpl$collect$1.L$3 = job;
                            stateFlowImpl$collect$1.L$4 = obj;
                            stateFlowImpl$collect$1.label = 3;
                            if (allocateSlot.awaitPending(stateFlowImpl$collect$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        obj2 = _state$FU.get(stateFlowImpl);
                        if (job != null) {
                        }
                        if (obj != null) {
                        }
                        if (obj2 == NullSurrogateKt.NULL) {
                        }
                        stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                        stateFlowImpl$collect$1.L$1 = flowCollector2;
                        stateFlowImpl$collect$1.L$2 = allocateSlot;
                        stateFlowImpl$collect$1.L$3 = job;
                        stateFlowImpl$collect$1.L$4 = obj2;
                        stateFlowImpl$collect$1.label = 2;
                        if (flowCollector2.emit(t5, stateFlowImpl$collect$1) == coroutine_suspended) {
                        }
                    }
                    flowCollector2 = flowCollector;
                    job = (Job) stateFlowImpl$collect$1.getContext().get(Job.INSTANCE);
                    obj = null;
                    obj2 = _state$FU.get(stateFlowImpl);
                    if (job != null) {
                    }
                    if (obj != null) {
                    }
                    if (obj2 == NullSurrogateKt.NULL) {
                    }
                    stateFlowImpl$collect$1.L$0 = stateFlowImpl;
                    stateFlowImpl$collect$1.L$1 = flowCollector2;
                    stateFlowImpl$collect$1.L$2 = allocateSlot;
                    stateFlowImpl$collect$1.L$3 = job;
                    stateFlowImpl$collect$1.L$4 = obj2;
                    stateFlowImpl$collect$1.label = 2;
                    if (flowCollector2.emit(t5, stateFlowImpl$collect$1) == coroutine_suspended) {
                    }
                }
            }
            if (i5 != 0) {
            }
            flowCollector2 = flowCollector;
            job = (Job) stateFlowImpl$collect$1.getContext().get(Job.INSTANCE);
            obj = null;
            obj2 = _state$FU.get(stateFlowImpl);
            if (job != null) {
            }
            if (obj != null) {
            }
            if (obj2 == NullSurrogateKt.NULL) {
            }
            stateFlowImpl$collect$1.L$0 = stateFlowImpl;
            stateFlowImpl$collect$1.L$1 = flowCollector2;
            stateFlowImpl$collect$1.L$2 = allocateSlot;
            stateFlowImpl$collect$1.L$3 = job;
            stateFlowImpl$collect$1.L$4 = obj2;
            stateFlowImpl$collect$1.label = 2;
            if (flowCollector2.emit(t5, stateFlowImpl$collect$1) == coroutine_suspended) {
            }
        } catch (Throwable th) {
            stateFlowImpl.freeSlot(allocateSlot);
            throw th;
        }
        stateFlowImpl$collect$1 = new StateFlowImpl$collect$1(this, continuation);
        Object obj32 = stateFlowImpl$collect$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = stateFlowImpl$collect$1.label;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(T expect, T update) {
        if (expect == null) {
            expect = (T) NullSurrogateKt.NULL;
        }
        if (update == null) {
            update = (T) NullSurrogateKt.NULL;
        }
        return updateState(expect, update);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t5, Continuation<? super Unit> continuation) {
        setValue(t5);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return StateFlowKt.fuseStateFlow(this, context, capacity, onBufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        Symbol symbol = NullSurrogateKt.NULL;
        T t5 = (T) _state$FU.get(this);
        if (t5 == symbol) {
            return null;
        }
        return t5;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(T t5) {
        if (t5 == null) {
            t5 = (T) NullSurrogateKt.NULL;
        }
        updateState(null, t5);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T value) {
        setValue(value);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public StateFlowSlot[] createSlotArray(int size) {
        return new StateFlowSlot[size];
    }
}
