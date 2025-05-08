package kotlinx.coroutines.sync;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0016\u001a\u00020\u0010*\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u0013\u0010\u0019\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\tJ\u001d\u0010\u0019\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u001aH\u0005¢\u0006\u0004\b\u0019\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00070\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u000bR\u000b\u0010%\u001a\u00020$8\u0002X\u0082\u0004R\u000b\u0010'\u001a\u00020&8\u0002X\u0082\u0004R\u000b\u0010(\u001a\u00020&8\u0002X\u0082\u0004R\u0011\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002X\u0082\u0004R\u0011\u0010,\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Semaphore;", BuildConfig.FLAVOR, "permits", "acquiredPermits", "<init>", "(II)V", BuildConfig.FLAVOR, "acquireSlowPath", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decPermits", "()I", "coerceAvailablePermitsAtMaximum", "()V", "Lkotlinx/coroutines/Waiter;", "waiter", BuildConfig.FLAVOR, "addAcquireToQueue", "(Lkotlinx/coroutines/Waiter;)Z", "tryResumeNextFromQueue", "()Z", BuildConfig.FLAVOR, "tryResumeAcquire", "(Ljava/lang/Object;)Z", "tryAcquire", "acquire", "Lkotlinx/coroutines/CancellableContinuation;", "(Lkotlinx/coroutines/CancellableContinuation;)V", "release", "I", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onCancellationRelease", "Lkotlin/jvm/functions/Function1;", "getAvailablePermits", "availablePermits", "Lkotlinx/atomicfu/AtomicInt;", "_availablePermits", "Lkotlinx/atomicfu/AtomicLong;", "deqIdx", "enqIdx", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "head", "tail", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public class SemaphoreImpl implements Semaphore {
    private volatile int _availablePermits;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private final Function1<Throwable, Unit> onCancellationRelease;
    private final int permits;
    private volatile Object tail;
    private static final AtomicReferenceFieldUpdater head$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "head");
    private static final AtomicLongFieldUpdater deqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "deqIdx");
    private static final AtomicReferenceFieldUpdater tail$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreImpl.class, Object.class, "tail");
    private static final AtomicLongFieldUpdater enqIdx$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreImpl.class, "enqIdx");
    private static final AtomicIntegerFieldUpdater _availablePermits$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreImpl.class, "_availablePermits");

    public SemaphoreImpl(int i5, int i6) {
        this.permits = i5;
        if (i5 <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i5).toString());
        }
        if (i6 < 0 || i6 > i5) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i5).toString());
        }
        SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
        this.head = semaphoreSegment;
        this.tail = semaphoreSegment;
        this._availablePermits = i5 - i6;
        this.onCancellationRelease = new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.sync.SemaphoreImpl$onCancellationRelease$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                SemaphoreImpl.this.release();
            }
        };
    }

    static /* synthetic */ Object acquire$suspendImpl(SemaphoreImpl semaphoreImpl, Continuation<? super Unit> continuation) {
        Object acquireSlowPath;
        return (semaphoreImpl.decPermits() <= 0 && (acquireSlowPath = semaphoreImpl.acquireSlowPath(continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? acquireSlowPath : Unit.INSTANCE;
    }

    private final Object acquireSlowPath(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            if (!addAcquireToQueue(orCreateCancellableContinuation)) {
                acquire((CancellableContinuation<? super Unit>) orCreateCancellableContinuation);
            }
            Object result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean addAcquireToQueue(Waiter waiter) {
        int i5;
        Object findSegmentInternal;
        int i6;
        Symbol symbol;
        Symbol symbol2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = tail$FU;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) atomicReferenceFieldUpdater.get(this);
        long andIncrement = enqIdx$FU.getAndIncrement(this);
        SemaphoreImpl$addAcquireToQueue$createNewSegment$1 semaphoreImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        i5 = SemaphoreKt.SEGMENT_SIZE;
        long j5 = andIncrement / i5;
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(semaphoreSegment, j5, semaphoreImpl$addAcquireToQueue$createNewSegment$1);
            if (!SegmentOrClosed.m3792isClosedimpl(findSegmentInternal)) {
                Segment m3791getSegmentimpl = SegmentOrClosed.m3791getSegmentimpl(findSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= m3791getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!m3791getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (a.a(atomicReferenceFieldUpdater, this, segment, m3791getSegmentimpl)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (m3791getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        m3791getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.m3791getSegmentimpl(findSegmentInternal);
        i6 = SemaphoreKt.SEGMENT_SIZE;
        int i7 = (int) (andIncrement % i6);
        if (I4.a.a(semaphoreSegment2.getAcquirers(), i7, null, waiter)) {
            waiter.invokeOnCancellation(semaphoreSegment2, i7);
            return true;
        }
        symbol = SemaphoreKt.PERMIT;
        symbol2 = SemaphoreKt.TAKEN;
        if (!I4.a.a(semaphoreSegment2.getAcquirers(), i7, symbol, symbol2)) {
            return false;
        }
        if (waiter instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(waiter, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((CancellableContinuation) waiter).resume(Unit.INSTANCE, this.onCancellationRelease);
        } else {
            if (!(waiter instanceof SelectInstance)) {
                throw new IllegalStateException(("unexpected: " + waiter).toString());
            }
            ((SelectInstance) waiter).selectInRegistrationPhase(Unit.INSTANCE);
        }
        return true;
    }

    private final void coerceAvailablePermitsAtMaximum() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i5;
        int i6;
        do {
            atomicIntegerFieldUpdater = _availablePermits$FU;
            i5 = atomicIntegerFieldUpdater.get(this);
            i6 = this.permits;
            if (i5 <= i6) {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, i6));
    }

    private final int decPermits() {
        int andDecrement;
        do {
            andDecrement = _availablePermits$FU.getAndDecrement(this);
        } while (andDecrement > this.permits);
        return andDecrement;
    }

    private final boolean tryResumeAcquire(Object obj) {
        if (!(obj instanceof CancellableContinuation)) {
            if (obj instanceof SelectInstance) {
                return ((SelectInstance) obj).trySelect(this, Unit.INSTANCE);
            }
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
        Object tryResume = cancellableContinuation.tryResume(Unit.INSTANCE, null, this.onCancellationRelease);
        if (tryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(tryResume);
        return true;
    }

    private final boolean tryResumeNextFromQueue() {
        int i5;
        Object findSegmentInternal;
        int i6;
        Symbol symbol;
        Symbol symbol2;
        int i7;
        Symbol symbol3;
        Symbol symbol4;
        Symbol symbol5;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = head$FU;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) atomicReferenceFieldUpdater.get(this);
        long andIncrement = deqIdx$FU.getAndIncrement(this);
        i5 = SemaphoreKt.SEGMENT_SIZE;
        long j5 = andIncrement / i5;
        SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
        loop0: while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(semaphoreSegment, j5, semaphoreImpl$tryResumeNextFromQueue$createNewSegment$1);
            if (SegmentOrClosed.m3792isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment m3791getSegmentimpl = SegmentOrClosed.m3791getSegmentimpl(findSegmentInternal);
            while (true) {
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                if (segment.id >= m3791getSegmentimpl.id) {
                    break loop0;
                }
                if (!m3791getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                if (a.a(atomicReferenceFieldUpdater, this, segment, m3791getSegmentimpl)) {
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                } else if (m3791getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                    m3791getSegmentimpl.remove();
                }
            }
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.m3791getSegmentimpl(findSegmentInternal);
        semaphoreSegment2.cleanPrev();
        if (semaphoreSegment2.id > j5) {
            return false;
        }
        i6 = SemaphoreKt.SEGMENT_SIZE;
        int i8 = (int) (andIncrement % i6);
        symbol = SemaphoreKt.PERMIT;
        Object andSet = semaphoreSegment2.getAcquirers().getAndSet(i8, symbol);
        if (andSet != null) {
            symbol2 = SemaphoreKt.CANCELLED;
            if (andSet == symbol2) {
                return false;
            }
            return tryResumeAcquire(andSet);
        }
        i7 = SemaphoreKt.MAX_SPIN_CYCLES;
        for (int i9 = 0; i9 < i7; i9++) {
            Object obj = semaphoreSegment2.getAcquirers().get(i8);
            symbol5 = SemaphoreKt.TAKEN;
            if (obj == symbol5) {
                return true;
            }
        }
        symbol3 = SemaphoreKt.PERMIT;
        symbol4 = SemaphoreKt.BROKEN;
        return !I4.a.a(semaphoreSegment2.getAcquirers(), i8, symbol3, symbol4);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public Object acquire(Continuation<? super Unit> continuation) {
        return acquire$suspendImpl(this, continuation);
    }

    public int getAvailablePermits() {
        return Math.max(_availablePermits$FU.get(this), 0);
    }

    @Override // kotlinx.coroutines.sync.Semaphore
    public void release() {
        do {
            int andIncrement = _availablePermits$FU.getAndIncrement(this);
            if (andIncrement >= this.permits) {
                coerceAvailablePermitsAtMaximum();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!tryResumeNextFromQueue());
    }

    public boolean tryAcquire() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _availablePermits$FU;
            int i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 > this.permits) {
                coerceAvailablePermitsAtMaximum();
            } else {
                if (i5 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i5, i5 - 1)) {
                    return true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void acquire(CancellableContinuation<? super Unit> waiter) {
        while (decPermits() <= 0) {
            Intrinsics.checkNotNull(waiter, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (addAcquireToQueue((Waiter) waiter)) {
                return;
            }
        }
        waiter.resume(Unit.INSTANCE, this.onCancellationRelease);
    }
}
