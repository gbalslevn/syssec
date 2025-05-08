package androidx.work.impl;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/work/impl/ToContinuation;", "T", "Ljava/lang/Runnable;", "Lcom/google/common/util/concurrent/ListenableFuture;", "futureToObserve", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "<init>", "(Lcom/google/common/util/concurrent/ListenableFuture;Lkotlinx/coroutines/CancellableContinuation;)V", BuildConfig.FLAVOR, "run", "()V", "Lcom/google/common/util/concurrent/ListenableFuture;", "getFutureToObserve", "()Lcom/google/common/util/concurrent/ListenableFuture;", "Lkotlinx/coroutines/CancellableContinuation;", "getContinuation", "()Lkotlinx/coroutines/CancellableContinuation;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ToContinuation<T> implements Runnable {
    private final CancellableContinuation<T> continuation;
    private final ListenableFuture<T> futureToObserve;

    /* JADX WARN: Multi-variable type inference failed */
    public ToContinuation(ListenableFuture<T> futureToObserve, CancellableContinuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(futureToObserve, "futureToObserve");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        this.futureToObserve = futureToObserve;
        this.continuation = continuation;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable nonNullCause;
        Object uninterruptibly;
        if (this.futureToObserve.isCancelled()) {
            CancellableContinuation.DefaultImpls.cancel$default(this.continuation, null, 1, null);
            return;
        }
        try {
            CancellableContinuation<T> cancellableContinuation = this.continuation;
            Result.Companion companion = Result.INSTANCE;
            uninterruptibly = WorkerWrapperKt.getUninterruptibly(this.futureToObserve);
            cancellableContinuation.resumeWith(Result.m3567constructorimpl(uninterruptibly));
        } catch (ExecutionException e5) {
            CancellableContinuation<T> cancellableContinuation2 = this.continuation;
            Result.Companion companion2 = Result.INSTANCE;
            nonNullCause = WorkerWrapperKt.nonNullCause(e5);
            cancellableContinuation2.resumeWith(Result.m3567constructorimpl(ResultKt.createFailure(nonNullCause)));
        }
    }
}
