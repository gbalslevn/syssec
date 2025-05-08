package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.Job;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0019\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\n\u001a\u00020\t*\u00020\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\u0010\u001a\u00020\t*\u00020\f2\u0010\b\u0002\u0010\u000f\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0011\u0010\u0012\u001a\u00020\t*\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0012\u001a\u00020\t*\u00020\f¢\u0006\u0004\b\u0012\u0010\u0014\u001a%\u0010\u0010\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0010\u0010\u0018\"\u0015\u0010\u001a\u001a\u00020\u0019*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0015\u0010\u001e\u001a\u00020\u0000*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/CompletableJob;", "Job", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/DisposableHandle;", "handle", "disposeOnCompletion", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/DisposableHandle;)Lkotlinx/coroutines/DisposableHandle;", BuildConfig.FLAVOR, "cancelAndJoin", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "cancel", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/CancellationException;)V", "ensureActive", "(Lkotlinx/coroutines/Job;)V", "(Lkotlin/coroutines/CoroutineContext;)V", BuildConfig.FLAVOR, "message", BuildConfig.FLAVOR, "(Lkotlinx/coroutines/Job;Ljava/lang/String;Ljava/lang/Throwable;)V", BuildConfig.FLAVOR, "isActive", "(Lkotlin/coroutines/CoroutineContext;)Z", "getJob", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "job", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/JobKt")
/* loaded from: classes3.dex */
public abstract /* synthetic */ class JobKt__JobKt {
    public static final CompletableJob Job(Job job) {
        return new JobImpl(job);
    }

    public static /* synthetic */ CompletableJob Job$default(Job job, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            job = null;
        }
        return JobKt.Job(job);
    }

    public static final void cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }

    public static /* synthetic */ void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancel(coroutineContext, cancellationException);
    }

    public static final Object cancelAndJoin(Job job, Continuation<? super Unit> continuation) {
        Job.DefaultImpls.cancel$default(job, null, 1, null);
        Object join = job.join(continuation);
        return join == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? join : Unit.INSTANCE;
    }

    public static final DisposableHandle disposeOnCompletion(Job job, DisposableHandle disposableHandle) {
        return job.invokeOnCompletion(new DisposeOnCompletion(disposableHandle));
    }

    public static final void ensureActive(Job job) {
        if (!job.isActive()) {
            throw job.getCancellationException();
        }
    }

    public static final Job getJob(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static final boolean isActive(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    public static final void cancel(Job job, String str, Throwable th) {
        job.cancel(ExceptionsKt.CancellationException(str, th));
    }

    public static /* synthetic */ void cancel$default(Job job, String str, Throwable th, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            th = null;
        }
        JobKt.cancel(job, str, th);
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job != null) {
            JobKt.ensureActive(job);
        }
    }
}
