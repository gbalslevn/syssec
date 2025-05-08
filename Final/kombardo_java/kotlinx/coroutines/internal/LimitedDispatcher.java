package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001,B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ,\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0011\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J&\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00122\n\u0010\u0011\u001a\u00060\u000bj\u0002`\fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010 \u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00122\n\u0010\u0011\u001a\u00060\u000bj\u0002`\fH\u0017¢\u0006\u0004\b \u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010!R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\"R\u001e\u0010$\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u00060&j\u0002`'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u000b\u0010+\u001a\u00020*8\u0002X\u0082\u0004¨\u0006-"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "dispatcher", BuildConfig.FLAVOR, "parallelism", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", BuildConfig.FLAVOR, "tryAllocateWorker", "()Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "obtainTaskOrDeallocateWorker", "()Ljava/lang/Runnable;", BuildConfig.FLAVOR, "timeMillis", "block", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", BuildConfig.FLAVOR, "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "limitedParallelism", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", "Lkotlinx/coroutines/CoroutineDispatcher;", "I", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "queue", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/internal/SynchronizedObject;", "workerAllocationLock", "Ljava/lang/Object;", "Lkotlinx/atomicfu/AtomicInt;", "runningWorkers", "Worker", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LimitedDispatcher extends CoroutineDispatcher implements Delay {
    private static final AtomicIntegerFieldUpdater runningWorkers$FU = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers");
    private final /* synthetic */ Delay $$delegate_0;
    private final CoroutineDispatcher dispatcher;
    private final int parallelism;
    private final LockFreeTaskQueue<Runnable> queue;
    private volatile int runningWorkers;
    private final Object workerAllocationLock;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher$Worker;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "currentTask", "(Lkotlinx/coroutines/internal/LimitedDispatcher;Ljava/lang/Runnable;)V", "run", BuildConfig.FLAVOR, "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private final class Worker implements Runnable {
        private Runnable currentTask;

        public Worker(Runnable runnable) {
            this.currentTask = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i5 = 0;
            while (true) {
                try {
                    this.currentTask.run();
                } catch (Throwable th) {
                    CoroutineExceptionHandlerKt.handleCoroutineException(EmptyCoroutineContext.INSTANCE, th);
                }
                Runnable obtainTaskOrDeallocateWorker = LimitedDispatcher.this.obtainTaskOrDeallocateWorker();
                if (obtainTaskOrDeallocateWorker == null) {
                    return;
                }
                this.currentTask = obtainTaskOrDeallocateWorker;
                i5++;
                if (i5 >= 16 && LimitedDispatcher.this.dispatcher.isDispatchNeeded(LimitedDispatcher.this)) {
                    LimitedDispatcher.this.dispatcher.dispatch(LimitedDispatcher.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LimitedDispatcher(CoroutineDispatcher coroutineDispatcher, int i5) {
        this.dispatcher = coroutineDispatcher;
        this.parallelism = i5;
        Delay delay = coroutineDispatcher instanceof Delay ? (Delay) coroutineDispatcher : null;
        this.$$delegate_0 = delay == null ? DefaultExecutorKt.getDefaultDelay() : delay;
        this.queue = new LockFreeTaskQueue<>(false);
        this.workerAllocationLock = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable obtainTaskOrDeallocateWorker() {
        while (true) {
            Runnable removeFirstOrNull = this.queue.removeFirstOrNull();
            if (removeFirstOrNull != null) {
                return removeFirstOrNull;
            }
            synchronized (this.workerAllocationLock) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = runningWorkers$FU;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.queue.getSize() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    private final boolean tryAllocateWorker() {
        synchronized (this.workerAllocationLock) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = runningWorkers$FU;
            if (atomicIntegerFieldUpdater.get(this) >= this.parallelism) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext context, Runnable block) {
        Runnable obtainTaskOrDeallocateWorker;
        this.queue.addLast(block);
        if (runningWorkers$FU.get(this) >= this.parallelism || !tryAllocateWorker() || (obtainTaskOrDeallocateWorker = obtainTaskOrDeallocateWorker()) == null) {
            return;
        }
        this.dispatcher.dispatch(this, new Worker(obtainTaskOrDeallocateWorker));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext context, Runnable block) {
        Runnable obtainTaskOrDeallocateWorker;
        this.queue.addLast(block);
        if (runningWorkers$FU.get(this) >= this.parallelism || !tryAllocateWorker() || (obtainTaskOrDeallocateWorker = obtainTaskOrDeallocateWorker()) == null) {
            return;
        }
        this.dispatcher.dispatchYield(this, new Worker(obtainTaskOrDeallocateWorker));
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long timeMillis, Runnable block, CoroutineContext context) {
        return this.$$delegate_0.invokeOnTimeout(timeMillis, block, context);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int parallelism) {
        LimitedDispatcherKt.checkParallelism(parallelism);
        return parallelism >= this.parallelism ? this : super.limitedParallelism(parallelism);
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long timeMillis, CancellableContinuation<? super Unit> continuation) {
        this.$$delegate_0.scheduleResumeAfterDelay(timeMillis, continuation);
    }
}
