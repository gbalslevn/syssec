package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.EventLoopImplBase;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u001b\u0010\u0010\u001a\u00020\u00062\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u00122\n\u0010\u001a\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u0005R\u0014\u0010!\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\u001e\u0010$\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b$\u0010%\u0012\u0004\b&\u0010\u0005R\u0014\u0010(\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010)R\u0014\u0010+\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010)R\u0014\u0010,\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010)R\u0014\u0010-\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010)R\u0016\u0010.\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010)R\u0014\u0010/\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\rR\u0014\u00100\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\rR\u0014\u00102\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\n¨\u00063"}, d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "<init>", "()V", BuildConfig.FLAVOR, "shutdownError", "Ljava/lang/Thread;", "createThreadSync", "()Ljava/lang/Thread;", BuildConfig.FLAVOR, "notifyStartup", "()Z", "acknowledgeShutdownIfNeeded", "task", "enqueue", "(Ljava/lang/Runnable;)V", BuildConfig.FLAVOR, "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "reschedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "shutdown", "timeMillis", "block", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "run", "DEFAULT_KEEP_ALIVE_MS", "J", "KEEP_ALIVE_NANOS", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", BuildConfig.FLAVOR, "FRESH", "I", "ACTIVE", "SHUTDOWN_REQ", "SHUTDOWN_ACK", "SHUTDOWN", "debugStatus", "isShutDown", "isShutdownRequested", "getThread", "thread", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    private static final int ACTIVE = 1;
    private static final long DEFAULT_KEEP_ALIVE_MS = 1000;
    private static final int FRESH = 0;
    public static final DefaultExecutor INSTANCE;
    private static final long KEEP_ALIVE_NANOS;
    private static final int SHUTDOWN = 4;
    private static final int SHUTDOWN_ACK = 3;
    private static final int SHUTDOWN_REQ = 2;
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    static {
        Long valueOf;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        INSTANCE = defaultExecutor;
        EventLoop.incrementUseCount$default(defaultExecutor, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            valueOf = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", DEFAULT_KEEP_ALIVE_MS);
        } catch (SecurityException unused) {
            valueOf = Long.valueOf(DEFAULT_KEEP_ALIVE_MS);
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(valueOf.longValue());
    }

    private DefaultExecutor() {
    }

    private final synchronized void acknowledgeShutdownIfNeeded() {
        if (isShutdownRequested()) {
            debugStatus = 3;
            resetAll();
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    private final synchronized Thread createThreadSync() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean isShutDown() {
        return debugStatus == 4;
    }

    private final boolean isShutdownRequested() {
        int i5 = debugStatus;
        return i5 == 2 || i5 == 3;
    }

    private final synchronized boolean notifyStartup() {
        if (isShutdownRequested()) {
            return false;
        }
        debugStatus = 1;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    private final void shutdownError() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public void enqueue(Runnable task) {
        if (isShutDown()) {
            shutdownError();
        }
        super.enqueue(task);
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected Thread getThread() {
        Thread thread = _thread;
        return thread == null ? createThreadSync() : thread;
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long timeMillis, Runnable block, CoroutineContext context) {
        return scheduleInvokeOnTimeout(timeMillis, block);
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected void reschedule(long now, EventLoopImplBase.DelayedTask delayedTask) {
        shutdownError();
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean isEmpty;
        ThreadLocalEventLoop.INSTANCE.setEventLoop$kotlinx_coroutines_core(this);
        AbstractTimeSourceKt.getTimeSource();
        try {
            if (!notifyStartup()) {
                if (isEmpty) {
                    return;
                } else {
                    return;
                }
            }
            long j5 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long processNextEvent = processNextEvent();
                if (processNextEvent == Long.MAX_VALUE) {
                    AbstractTimeSourceKt.getTimeSource();
                    long nanoTime = System.nanoTime();
                    if (j5 == Long.MAX_VALUE) {
                        j5 = KEEP_ALIVE_NANOS + nanoTime;
                    }
                    long j6 = j5 - nanoTime;
                    if (j6 <= 0) {
                        _thread = null;
                        acknowledgeShutdownIfNeeded();
                        AbstractTimeSourceKt.getTimeSource();
                        if (isEmpty()) {
                            return;
                        }
                        getThread();
                        return;
                    }
                    processNextEvent = RangesKt.coerceAtMost(processNextEvent, j6);
                } else {
                    j5 = Long.MAX_VALUE;
                }
                if (processNextEvent > 0) {
                    if (isShutdownRequested()) {
                        _thread = null;
                        acknowledgeShutdownIfNeeded();
                        AbstractTimeSourceKt.getTimeSource();
                        if (isEmpty()) {
                            return;
                        }
                        getThread();
                        return;
                    }
                    AbstractTimeSourceKt.getTimeSource();
                    LockSupport.parkNanos(this, processNextEvent);
                }
            }
        } finally {
            _thread = null;
            acknowledgeShutdownIfNeeded();
            AbstractTimeSourceKt.getTimeSource();
            if (!isEmpty()) {
                getThread();
            }
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.EventLoop
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
