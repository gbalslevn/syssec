package kotlinx.coroutines.flow;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u0001pB\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001d2\u0010\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00132\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J/\u0010-\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0013H\u0002¢\u0006\u0004\b/\u0010\u0015J\u0019\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u00100\u001a\u00020\u0003H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u0003H\u0002¢\u0006\u0004\b3\u00104J\u0019\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u00105\u001a\u00020\u0016H\u0002¢\u0006\u0004\b6\u00107J\u001b\u00108\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b8\u00109J3\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010:0\u001d2\u0014\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010:0\u001dH\u0002¢\u0006\u0004\b<\u0010=J!\u0010A\u001a\u00020@2\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000>H\u0096@ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\bC\u0010\u0011J\u001b\u0010D\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\bD\u0010$J\u000f\u0010G\u001a\u00020\u0016H\u0000¢\u0006\u0004\bE\u0010FJ%\u0010K\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010:0\u001d2\u0006\u0010H\u001a\u00020\u0016H\u0000¢\u0006\u0004\bI\u0010JJ\u000f\u0010L\u001a\u00020\u0003H\u0014¢\u0006\u0004\bL\u0010MJ\u001f\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001d2\u0006\u0010N\u001a\u00020\u0007H\u0014¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0013H\u0016¢\u0006\u0004\bQ\u0010\u0015J-\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00000U2\u0006\u0010S\u001a\u00020R2\u0006\u0010T\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\bV\u0010WR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010XR\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010XR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010YR \u0010Z\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010]R\u0016\u0010_\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010XR\u0016\u0010`\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010XR\u0014\u0010b\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\ba\u0010FR\u0014\u0010e\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0014\u0010g\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bf\u0010dR\u0014\u0010i\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010FR\u0014\u0010k\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u0010FR\u001a\u0010o\u001a\u00028\u00008DX\u0084\u0004¢\u0006\f\u0012\u0004\bn\u0010\u0015\u001a\u0004\bl\u0010m\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006q"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/flow/internal/FusibleFlow;", BuildConfig.FLAVOR, "replay", "bufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "value", BuildConfig.FLAVOR, "tryEmitLocked", "(Ljava/lang/Object;)Z", "tryEmitNoCollectorsLocked", BuildConfig.FLAVOR, "dropOldestLocked", "()V", BuildConfig.FLAVOR, "newHead", "correctCollectorIndexesOnDropOldest", "(J)V", "item", "enqueueLocked", "(Ljava/lang/Object;)V", BuildConfig.FLAVOR, "curBuffer", "curSize", "newSize", "growBuffer", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "emitSuspend", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "emitter", "cancelEmitter", "(Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;)V", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateBufferLocked", "(JJJJ)V", "cleanupTailLocked", "slot", "tryTakeValue", "(Lkotlinx/coroutines/flow/SharedFlowSlot;)Ljava/lang/Object;", "tryPeekLocked", "(Lkotlinx/coroutines/flow/SharedFlowSlot;)J", "index", "getPeekedValueLockedAt", "(J)Ljava/lang/Object;", "awaitValue", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "resumesIn", "findSlotsToResumeLocked", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", BuildConfig.FLAVOR, "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryEmit", "emit", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "()J", "updateNewCollectorIndexLocked", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateCollectorIndexLocked", "createSlot", "()Lkotlinx/coroutines/flow/SharedFlowSlot;", "size", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "resetReplayCache", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "I", "Lkotlinx/coroutines/channels/BufferOverflow;", "buffer", "[Ljava/lang/Object;", "replayIndex", "J", "minCollectorIndex", "bufferSize", "queueSize", "getHead", "head", "getReplaySize", "()I", "replaySize", "getTotalSize", "totalSize", "getBufferEndIndex", "bufferEndIndex", "getQueueEndIndex", "queueEndIndex", "getLastReplayedLocked", "()Ljava/lang/Object;", "getLastReplayedLocked$annotations", "lastReplayedLocked", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, Flow, FusibleFlow<T> {
    private Object[] buffer;
    private final int bufferCapacity;
    private int bufferSize;
    private long minCollectorIndex;
    private final BufferOverflow onBufferOverflow;
    private int queueSize;
    private final int replay;
    private long replayIndex;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\nH\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "index", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "cont", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Emitter implements DisposableHandle {
        public final Continuation<Unit> cont;
        public final SharedFlowImpl<?> flow;
        public long index;
        public final Object value;

        /* JADX WARN: Multi-variable type inference failed */
        public Emitter(SharedFlowImpl<?> sharedFlowImpl, long j5, Object obj, Continuation<? super Unit> continuation) {
            this.flow = sharedFlowImpl;
            this.index = j5;
            this.value = obj;
            this.cont = continuation;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.flow.cancelEmitter(this);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            try {
                iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SharedFlowImpl(int i5, int i6, BufferOverflow bufferOverflow) {
        this.replay = i5;
        this.bufferCapacity = i6;
        this.onBufferOverflow = bufferOverflow;
    }

    private final Object awaitValue(SharedFlowSlot sharedFlowSlot, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this) {
            try {
                if (tryPeekLocked(sharedFlowSlot) < 0) {
                    sharedFlowSlot.cont = cancellableContinuationImpl;
                } else {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m3567constructorimpl(Unit.INSTANCE));
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelEmitter(Emitter emitter) {
        Object bufferAt;
        synchronized (this) {
            if (emitter.index < getHead()) {
                return;
            }
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            bufferAt = SharedFlowKt.getBufferAt(objArr, emitter.index);
            if (bufferAt != emitter) {
                return;
            }
            SharedFlowKt.setBufferAt(objArr, emitter.index, SharedFlowKt.NO_VALUE);
            cleanupTailLocked();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void cleanupTailLocked() {
        Object bufferAt;
        if (this.bufferCapacity != 0 || this.queueSize > 1) {
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            while (this.queueSize > 0) {
                bufferAt = SharedFlowKt.getBufferAt(objArr, (getHead() + getTotalSize()) - 1);
                if (bufferAt != SharedFlowKt.NO_VALUE) {
                    return;
                }
                this.queueSize--;
                SharedFlowKt.setBufferAt(objArr, getHead() + getTotalSize(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009a A[Catch: all -> 0x0042, TryCatch #1 {all -> 0x0042, blocks: (B:14:0x003b, B:18:0x0092, B:20:0x009a, B:28:0x00ad, B:29:0x00b0, B:36:0x005d), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.flow.FlowCollector, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r5v1, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlow] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, kotlinx.coroutines.flow.SharedFlowImpl] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [kotlinx.coroutines.flow.FlowCollector<? super T>] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [kotlinx.coroutines.flow.SharedFlowSlot, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v9, types: [kotlinx.coroutines.flow.SharedFlowSlot] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00be -> B:15:0x003e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ <T> Object collect$suspendImpl(SharedFlowImpl<T> sharedFlowImpl, FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        SharedFlowImpl$collect$1 sharedFlowImpl$collect$1;
        Object coroutine_suspended;
        int i5;
        ?? r5;
        FlowCollector flowCollector2;
        Job job;
        Job job2;
        ?? r22;
        Object tryTakeValue;
        Object obj;
        try {
            try {
                if (continuation instanceof SharedFlowImpl$collect$1) {
                    sharedFlowImpl$collect$1 = (SharedFlowImpl$collect$1) continuation;
                    int i6 = sharedFlowImpl$collect$1.label;
                    if ((i6 & Integer.MIN_VALUE) != 0) {
                        sharedFlowImpl$collect$1.label = i6 - Integer.MIN_VALUE;
                        Object obj2 = sharedFlowImpl$collect$1.result;
                        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i5 = sharedFlowImpl$collect$1.label;
                        if (i5 != 0) {
                            ResultKt.throwOnFailure(obj2);
                            flowCollector2 = flowCollector;
                            flowCollector = sharedFlowImpl.allocateSlot();
                        } else {
                            if (i5 != 1) {
                                if (i5 == 2) {
                                    job2 = (Job) sharedFlowImpl$collect$1.L$3;
                                    boolean z5 = (FlowCollector<? super T>) ((SharedFlowSlot) sharedFlowImpl$collect$1.L$2);
                                    FlowCollector flowCollector3 = (FlowCollector) sharedFlowImpl$collect$1.L$1;
                                    SharedFlowImpl sharedFlowImpl2 = (SharedFlowImpl) sharedFlowImpl$collect$1.L$0;
                                    ResultKt.throwOnFailure(obj2);
                                    r22 = flowCollector3;
                                    r5 = sharedFlowImpl2;
                                    flowCollector = z5;
                                    do {
                                        tryTakeValue = r5.tryTakeValue((SharedFlowSlot) flowCollector);
                                        if (tryTakeValue == SharedFlowKt.NO_VALUE) {
                                        }
                                    } while (r5.awaitValue((SharedFlowSlot) flowCollector, sharedFlowImpl$collect$1) != coroutine_suspended);
                                    return coroutine_suspended;
                                }
                                if (i5 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                job2 = (Job) sharedFlowImpl$collect$1.L$3;
                                Object obj3 = (FlowCollector<? super T>) ((SharedFlowSlot) sharedFlowImpl$collect$1.L$2);
                                FlowCollector flowCollector4 = (FlowCollector) sharedFlowImpl$collect$1.L$1;
                                SharedFlowImpl<T> sharedFlowImpl3 = (SharedFlowImpl) sharedFlowImpl$collect$1.L$0;
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector5 = flowCollector4;
                                SharedFlowImpl<T> sharedFlowImpl4 = sharedFlowImpl3;
                                Object obj4 = obj3;
                                flowCollector2 = flowCollector5;
                                job = job2;
                                sharedFlowImpl = sharedFlowImpl4;
                                obj = obj4;
                                r5 = sharedFlowImpl;
                                job2 = job;
                                r22 = flowCollector2;
                                flowCollector = obj;
                                do {
                                    tryTakeValue = r5.tryTakeValue((SharedFlowSlot) flowCollector);
                                    if (tryTakeValue == SharedFlowKt.NO_VALUE) {
                                        if (job2 != null) {
                                            JobKt.ensureActive(job2);
                                        }
                                        sharedFlowImpl$collect$1.L$0 = r5;
                                        sharedFlowImpl$collect$1.L$1 = r22;
                                        sharedFlowImpl$collect$1.L$2 = (Object) flowCollector;
                                        sharedFlowImpl$collect$1.L$3 = job2;
                                        sharedFlowImpl$collect$1.label = 3;
                                        Object emit = r22.emit(tryTakeValue, sharedFlowImpl$collect$1);
                                        flowCollector5 = r22;
                                        sharedFlowImpl4 = r5;
                                        obj4 = flowCollector;
                                        if (emit == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        flowCollector2 = flowCollector5;
                                        job = job2;
                                        sharedFlowImpl = sharedFlowImpl4;
                                        obj = obj4;
                                        r5 = sharedFlowImpl;
                                        job2 = job;
                                        r22 = flowCollector2;
                                        flowCollector = obj;
                                        tryTakeValue = r5.tryTakeValue((SharedFlowSlot) flowCollector);
                                        if (tryTakeValue == SharedFlowKt.NO_VALUE) {
                                            sharedFlowImpl$collect$1.L$0 = r5;
                                            sharedFlowImpl$collect$1.L$1 = r22;
                                            sharedFlowImpl$collect$1.L$2 = (Object) flowCollector;
                                            sharedFlowImpl$collect$1.L$3 = job2;
                                            sharedFlowImpl$collect$1.label = 2;
                                        }
                                    }
                                } while (r5.awaitValue((SharedFlowSlot) flowCollector, sharedFlowImpl$collect$1) != coroutine_suspended);
                                return coroutine_suspended;
                            }
                            flowCollector = (SharedFlowSlot) sharedFlowImpl$collect$1.L$2;
                            FlowCollector flowCollector6 = (FlowCollector) sharedFlowImpl$collect$1.L$1;
                            SharedFlowImpl<T> sharedFlowImpl5 = (SharedFlowImpl) sharedFlowImpl$collect$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj2);
                                flowCollector2 = flowCollector6;
                                sharedFlowImpl = sharedFlowImpl5;
                                flowCollector = flowCollector;
                            } catch (Throwable th) {
                                th = th;
                                r5 = sharedFlowImpl5;
                                r5.freeSlot(flowCollector);
                                throw th;
                            }
                        }
                        job = (Job) sharedFlowImpl$collect$1.getContext().get(Job.INSTANCE);
                        obj = flowCollector;
                        r5 = sharedFlowImpl;
                        job2 = job;
                        r22 = flowCollector2;
                        flowCollector = obj;
                        do {
                            tryTakeValue = r5.tryTakeValue((SharedFlowSlot) flowCollector);
                            if (tryTakeValue == SharedFlowKt.NO_VALUE) {
                            }
                        } while (r5.awaitValue((SharedFlowSlot) flowCollector, sharedFlowImpl$collect$1) != coroutine_suspended);
                        return coroutine_suspended;
                    }
                }
                job = (Job) sharedFlowImpl$collect$1.getContext().get(Job.INSTANCE);
                obj = flowCollector;
                r5 = sharedFlowImpl;
                job2 = job;
                r22 = flowCollector2;
                flowCollector = obj;
                do {
                    tryTakeValue = r5.tryTakeValue((SharedFlowSlot) flowCollector);
                    if (tryTakeValue == SharedFlowKt.NO_VALUE) {
                    }
                } while (r5.awaitValue((SharedFlowSlot) flowCollector, sharedFlowImpl$collect$1) != coroutine_suspended);
                return coroutine_suspended;
            } catch (Throwable th2) {
                r5 = sharedFlowImpl;
                th = th2;
                r5.freeSlot(flowCollector);
                throw th;
            }
            if (i5 != 0) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
        sharedFlowImpl$collect$1 = new SharedFlowImpl$collect$1(sharedFlowImpl, continuation);
        Object obj22 = sharedFlowImpl$collect$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = sharedFlowImpl$collect$1.label;
    }

    private final void correctCollectorIndexesOnDropOldest(long newHead) {
        AbstractSharedFlowSlot[] access$getSlots;
        if (AbstractSharedFlow.access$getNCollectors(this) != 0 && (access$getSlots = AbstractSharedFlow.access$getSlots(this)) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : access$getSlots) {
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    long j5 = sharedFlowSlot.index;
                    if (j5 >= 0 && j5 < newHead) {
                        sharedFlowSlot.index = newHead;
                    }
                }
            }
        }
        this.minCollectorIndex = newHead;
    }

    private final void dropOldestLocked() {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        SharedFlowKt.setBufferAt(objArr, getHead(), null);
        this.bufferSize--;
        long head = getHead() + 1;
        if (this.replayIndex < head) {
            this.replayIndex = head;
        }
        if (this.minCollectorIndex < head) {
            correctCollectorIndexesOnDropOldest(head);
        }
    }

    static /* synthetic */ <T> Object emit$suspendImpl(SharedFlowImpl<T> sharedFlowImpl, T t5, Continuation<? super Unit> continuation) {
        Object emitSuspend;
        return (!sharedFlowImpl.tryEmit(t5) && (emitSuspend = sharedFlowImpl.emitSuspend(t5, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? emitSuspend : Unit.INSTANCE;
    }

    private final Object emitSuspend(T t5, Continuation<? super Unit> continuation) {
        Continuation<Unit>[] continuationArr;
        Emitter emitter;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Continuation<Unit>[] continuationArr2 = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            try {
                if (tryEmitLocked(t5)) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m3567constructorimpl(Unit.INSTANCE));
                    continuationArr = findSlotsToResumeLocked(continuationArr2);
                    emitter = null;
                } else {
                    Emitter emitter2 = new Emitter(this, getTotalSize() + getHead(), t5, cancellableContinuationImpl);
                    enqueueLocked(emitter2);
                    this.queueSize++;
                    if (this.bufferCapacity == 0) {
                        continuationArr2 = findSlotsToResumeLocked(continuationArr2);
                    }
                    continuationArr = continuationArr2;
                    emitter = emitter2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (emitter != null) {
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, emitter);
        }
        for (Continuation<Unit> continuation2 : continuationArr) {
            if (continuation2 != null) {
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m3567constructorimpl(Unit.INSTANCE));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enqueueLocked(Object item) {
        int totalSize = getTotalSize();
        Object[] objArr = this.buffer;
        if (objArr == null) {
            objArr = growBuffer(null, 0, 2);
        } else if (totalSize >= objArr.length) {
            objArr = growBuffer(objArr, totalSize, objArr.length * 2);
        }
        SharedFlowKt.setBufferAt(objArr, getHead() + totalSize, item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object[], java.lang.Object] */
    public final Continuation<Unit>[] findSlotsToResumeLocked(Continuation<Unit>[] resumesIn) {
        AbstractSharedFlowSlot[] access$getSlots;
        SharedFlowSlot sharedFlowSlot;
        Continuation<? super Unit> continuation;
        int length = resumesIn.length;
        if (AbstractSharedFlow.access$getNCollectors(this) != 0 && (access$getSlots = AbstractSharedFlow.access$getSlots(this)) != null) {
            int length2 = access$getSlots.length;
            int i5 = 0;
            resumesIn = resumesIn;
            while (i5 < length2) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = access$getSlots[i5];
                if (abstractSharedFlowSlot != null && (continuation = (sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot).cont) != null && tryPeekLocked(sharedFlowSlot) >= 0) {
                    int length3 = resumesIn.length;
                    resumesIn = resumesIn;
                    if (length >= length3) {
                        ?? copyOf = Arrays.copyOf(resumesIn, Math.max(2, resumesIn.length * 2));
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                        resumesIn = copyOf;
                    }
                    resumesIn[length] = continuation;
                    sharedFlowSlot.cont = null;
                    length++;
                }
                i5++;
                resumesIn = resumesIn;
            }
        }
        return resumesIn;
    }

    private final long getBufferEndIndex() {
        return getHead() + this.bufferSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    private final Object getPeekedValueLockedAt(long index) {
        Object bufferAt;
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        bufferAt = SharedFlowKt.getBufferAt(objArr, index);
        return bufferAt instanceof Emitter ? ((Emitter) bufferAt).value : bufferAt;
    }

    private final long getQueueEndIndex() {
        return getHead() + this.bufferSize + this.queueSize;
    }

    private final int getReplaySize() {
        return (int) ((getHead() + this.bufferSize) - this.replayIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTotalSize() {
        return this.bufferSize + this.queueSize;
    }

    private final Object[] growBuffer(Object[] curBuffer, int curSize, int newSize) {
        Object bufferAt;
        if (newSize <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr = new Object[newSize];
        this.buffer = objArr;
        if (curBuffer == null) {
            return objArr;
        }
        long head = getHead();
        for (int i5 = 0; i5 < curSize; i5++) {
            long j5 = i5 + head;
            bufferAt = SharedFlowKt.getBufferAt(curBuffer, j5);
            SharedFlowKt.setBufferAt(objArr, j5, bufferAt);
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean tryEmitLocked(T value) {
        if (getNCollectors() == 0) {
            return tryEmitNoCollectorsLocked(value);
        }
        if (this.bufferSize >= this.bufferCapacity && this.minCollectorIndex <= this.replayIndex) {
            int i5 = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
            if (i5 == 1) {
                return false;
            }
            if (i5 == 2) {
                return true;
            }
        }
        enqueueLocked(value);
        int i6 = this.bufferSize + 1;
        this.bufferSize = i6;
        if (i6 > this.bufferCapacity) {
            dropOldestLocked();
        }
        if (getReplaySize() > this.replay) {
            updateBufferLocked(this.replayIndex + 1, this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
        }
        return true;
    }

    private final boolean tryEmitNoCollectorsLocked(T value) {
        if (this.replay == 0) {
            return true;
        }
        enqueueLocked(value);
        int i5 = this.bufferSize + 1;
        this.bufferSize = i5;
        if (i5 > this.replay) {
            dropOldestLocked();
        }
        this.minCollectorIndex = getHead() + this.bufferSize;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long tryPeekLocked(SharedFlowSlot slot) {
        long j5 = slot.index;
        if (j5 < getBufferEndIndex()) {
            return j5;
        }
        if (this.bufferCapacity <= 0 && j5 <= getHead() && this.queueSize != 0) {
            return j5;
        }
        return -1L;
    }

    private final Object tryTakeValue(SharedFlowSlot slot) {
        Object obj;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            try {
                long tryPeekLocked = tryPeekLocked(slot);
                if (tryPeekLocked < 0) {
                    obj = SharedFlowKt.NO_VALUE;
                } else {
                    long j5 = slot.index;
                    Object peekedValueLockedAt = getPeekedValueLockedAt(tryPeekLocked);
                    slot.index = tryPeekLocked + 1;
                    continuationArr = updateCollectorIndexLocked$kotlinx_coroutines_core(j5);
                    obj = peekedValueLockedAt;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m3567constructorimpl(Unit.INSTANCE));
            }
        }
        return obj;
    }

    private final void updateBufferLocked(long newReplayIndex, long newMinCollectorIndex, long newBufferEndIndex, long newQueueEndIndex) {
        long min = Math.min(newMinCollectorIndex, newReplayIndex);
        for (long head = getHead(); head < min; head++) {
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            SharedFlowKt.setBufferAt(objArr, head, null);
        }
        this.replayIndex = newReplayIndex;
        this.minCollectorIndex = newMinCollectorIndex;
        this.bufferSize = (int) (newBufferEndIndex - min);
        this.queueSize = (int) (newQueueEndIndex - newBufferEndIndex);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return collect$suspendImpl(this, flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T t5, Continuation<? super Unit> continuation) {
        return emit$suspendImpl(this, t5, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext context, int capacity, BufferOverflow onBufferOverflow) {
        return SharedFlowKt.fuseSharedFlow(this, context, capacity, onBufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T getLastReplayedLocked() {
        Object bufferAt;
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNull(objArr);
        bufferAt = SharedFlowKt.getBufferAt(objArr, (this.replayIndex + getReplaySize()) - 1);
        return (T) bufferAt;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        synchronized (this) {
            updateBufferLocked(getBufferEndIndex(), this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T value) {
        int i5;
        boolean z5;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        synchronized (this) {
            if (tryEmitLocked(value)) {
                continuationArr = findSlotsToResumeLocked(continuationArr);
                z5 = true;
            } else {
                z5 = false;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m3567constructorimpl(Unit.INSTANCE));
            }
        }
        return z5;
    }

    public final Continuation<Unit>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long oldIndex) {
        long j5;
        long j6;
        Object bufferAt;
        Object bufferAt2;
        long j7;
        AbstractSharedFlowSlot[] access$getSlots;
        if (oldIndex > this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long head = getHead();
        long j8 = this.bufferSize + head;
        if (this.bufferCapacity == 0 && this.queueSize > 0) {
            j8++;
        }
        if (AbstractSharedFlow.access$getNCollectors(this) != 0 && (access$getSlots = AbstractSharedFlow.access$getSlots(this)) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : access$getSlots) {
                if (abstractSharedFlowSlot != null) {
                    long j9 = ((SharedFlowSlot) abstractSharedFlowSlot).index;
                    if (j9 >= 0 && j9 < j8) {
                        j8 = j9;
                    }
                }
            }
        }
        if (j8 <= this.minCollectorIndex) {
            return AbstractSharedFlowKt.EMPTY_RESUMES;
        }
        long bufferEndIndex = getBufferEndIndex();
        int min = getNCollectors() > 0 ? Math.min(this.queueSize, this.bufferCapacity - ((int) (bufferEndIndex - j8))) : this.queueSize;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.EMPTY_RESUMES;
        long j10 = this.queueSize + bufferEndIndex;
        if (min > 0) {
            continuationArr = new Continuation[min];
            Object[] objArr = this.buffer;
            Intrinsics.checkNotNull(objArr);
            long j11 = bufferEndIndex;
            int i5 = 0;
            while (true) {
                if (bufferEndIndex >= j10) {
                    j5 = j8;
                    j6 = j10;
                    break;
                }
                bufferAt2 = SharedFlowKt.getBufferAt(objArr, bufferEndIndex);
                j5 = j8;
                Symbol symbol = SharedFlowKt.NO_VALUE;
                if (bufferAt2 != symbol) {
                    Intrinsics.checkNotNull(bufferAt2, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    Emitter emitter = (Emitter) bufferAt2;
                    int i6 = i5 + 1;
                    j6 = j10;
                    continuationArr[i5] = emitter.cont;
                    SharedFlowKt.setBufferAt(objArr, bufferEndIndex, symbol);
                    SharedFlowKt.setBufferAt(objArr, j11, emitter.value);
                    j7 = 1;
                    j11++;
                    if (i6 >= min) {
                        break;
                    }
                    i5 = i6;
                } else {
                    j6 = j10;
                    j7 = 1;
                }
                bufferEndIndex += j7;
                j8 = j5;
                j10 = j6;
            }
            bufferEndIndex = j11;
        } else {
            j5 = j8;
            j6 = j10;
        }
        int i7 = (int) (bufferEndIndex - head);
        long j12 = getNCollectors() == 0 ? bufferEndIndex : j5;
        long max = Math.max(this.replayIndex, bufferEndIndex - Math.min(this.replay, i7));
        if (this.bufferCapacity == 0 && max < j6) {
            Object[] objArr2 = this.buffer;
            Intrinsics.checkNotNull(objArr2);
            bufferAt = SharedFlowKt.getBufferAt(objArr2, max);
            if (Intrinsics.areEqual(bufferAt, SharedFlowKt.NO_VALUE)) {
                bufferEndIndex++;
                max++;
            }
        }
        updateBufferLocked(max, j12, bufferEndIndex, j6);
        cleanupTailLocked();
        return !(continuationArr.length == 0) ? findSlotsToResumeLocked(continuationArr) : continuationArr;
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long j5 = this.replayIndex;
        if (j5 < this.minCollectorIndex) {
            this.minCollectorIndex = j5;
        }
        return j5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public SharedFlowSlot[] createSlotArray(int size) {
        return new SharedFlowSlot[size];
    }
}
