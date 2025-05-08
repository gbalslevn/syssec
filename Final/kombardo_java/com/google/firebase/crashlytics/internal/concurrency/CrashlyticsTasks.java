package com.google.firebase.crashlytics.internal.concurrency;

import K.d;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsTasks;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public abstract class CrashlyticsTasks {
    private static final Executor DIRECT = new d();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task lambda$race$0(TaskCompletionSource taskCompletionSource, AtomicBoolean atomicBoolean, CancellationTokenSource cancellationTokenSource, Task task) {
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(task.getResult());
        } else if (task.getException() != null) {
            taskCompletionSource.trySetException(task.getException());
        } else if (atomicBoolean.getAndSet(true)) {
            cancellationTokenSource.cancel();
        }
        return Tasks.forResult(null);
    }

    public static <T> Task<T> race(Task<T> task, Task<T> task2) {
        final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Continuation<T, Task<TContinuationResult>> continuation = new Continuation() { // from class: J0.a
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task3) {
                Task lambda$race$0;
                lambda$race$0 = CrashlyticsTasks.lambda$race$0(TaskCompletionSource.this, atomicBoolean, cancellationTokenSource, task3);
                return lambda$race$0;
            }
        };
        Executor executor = DIRECT;
        task.continueWithTask(executor, continuation);
        task2.continueWithTask(executor, continuation);
        return taskCompletionSource.getTask();
    }
}
