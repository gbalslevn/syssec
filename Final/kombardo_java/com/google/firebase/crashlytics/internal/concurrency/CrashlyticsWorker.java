package com.google.firebase.crashlytics.internal.concurrency;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class CrashlyticsWorker implements Executor {
    private final ExecutorService executor;
    private final Object tailLock = new Object();
    private Task<?> tail = Tasks.forResult(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public CrashlyticsWorker(ExecutorService executorService) {
        this.executor = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task lambda$submit$1(Runnable runnable, Task task) {
        runnable.run();
        return Tasks.forResult(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task lambda$submitTask$2(Callable callable, Task task) {
        return (Task) callable.call();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.executor.execute(runnable);
    }

    public ExecutorService getExecutor() {
        return this.executor;
    }

    public Task<Void> submit(final Runnable runnable) {
        Task continueWithTask;
        synchronized (this.tailLock) {
            continueWithTask = this.tail.continueWithTask(this.executor, new Continuation() { // from class: J0.c
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    Task lambda$submit$1;
                    lambda$submit$1 = CrashlyticsWorker.lambda$submit$1(runnable, task);
                    return lambda$submit$1;
                }
            });
            this.tail = continueWithTask;
        }
        return continueWithTask;
    }

    public <T> Task<T> submitTask(final Callable<Task<T>> callable) {
        zzw zzwVar;
        synchronized (this.tailLock) {
            zzwVar = (Task<T>) this.tail.continueWithTask(this.executor, new Continuation() { // from class: J0.b
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    Task lambda$submitTask$2;
                    lambda$submitTask$2 = CrashlyticsWorker.lambda$submitTask$2(callable, task);
                    return lambda$submitTask$2;
                }
            });
            this.tail = zzwVar;
        }
        return zzwVar;
    }
}
