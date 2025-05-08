package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class JobKt {
    public static final CompletableJob Job(Job job) {
        return JobKt__JobKt.Job(job);
    }

    public static /* synthetic */ CompletableJob Job$default(Job job, int i5, Object obj) {
        return JobKt__JobKt.Job$default(job, i5, obj);
    }

    public static final void cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        JobKt__JobKt.cancel(coroutineContext, cancellationException);
    }

    public static final Object cancelAndJoin(Job job, Continuation<? super Unit> continuation) {
        return JobKt__JobKt.cancelAndJoin(job, continuation);
    }

    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        JobKt__FutureKt.cancelFutureOnCancellation(cancellableContinuation, future);
    }

    public static final DisposableHandle disposeOnCompletion(Job job, DisposableHandle disposableHandle) {
        return JobKt__JobKt.disposeOnCompletion(job, disposableHandle);
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        JobKt__JobKt.ensureActive(coroutineContext);
    }

    public static final Job getJob(CoroutineContext coroutineContext) {
        return JobKt__JobKt.getJob(coroutineContext);
    }

    public static final boolean isActive(CoroutineContext coroutineContext) {
        return JobKt__JobKt.isActive(coroutineContext);
    }

    public static final void cancel(Job job, String str, Throwable th) {
        JobKt__JobKt.cancel(job, str, th);
    }

    public static final void ensureActive(Job job) {
        JobKt__JobKt.ensureActive(job);
    }
}
