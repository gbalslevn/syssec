package com.google.firebase.crashlytics.internal.common;

import android.os.Looper;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.Utils;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public abstract class Utils {
    private static final int BACKGROUND_TIMEOUT_MILLIS = 4000;
    private static final int MAIN_TIMEOUT_MILLIS = 3000;
    private static final ExecutorService TASK_CONTINUATION_EXECUTOR_SERVICE = ExecutorUtils.buildSingleThreadExecutorService("awaitEvenIfOnMainThread task continuation executor");

    @Deprecated
    public static <T> T awaitEvenIfOnMainThread(Task<T> task) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        task.continueWith(TASK_CONTINUATION_EXECUTOR_SERVICE, new Continuation() { // from class: I0.u
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                Object lambda$awaitEvenIfOnMainThread$0;
                lambda$awaitEvenIfOnMainThread$0 = Utils.lambda$awaitEvenIfOnMainThread$0(countDownLatch, task2);
                return lambda$awaitEvenIfOnMainThread$0;
            }
        });
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(3000L, TimeUnit.MILLISECONDS);
        } else {
            countDownLatch.await(4000L, TimeUnit.MILLISECONDS);
        }
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        if (task.isComplete()) {
            throw new IllegalStateException(task.getException());
        }
        throw new TimeoutException();
    }

    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j5, TimeUnit timeUnit) {
        boolean z5 = false;
        try {
            long nanos = timeUnit.toNanos(j5);
            while (true) {
                try {
                    break;
                } catch (InterruptedException unused) {
                    z5 = true;
                    nanos = (System.nanoTime() + nanos) - System.nanoTime();
                }
            }
            return countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
        } finally {
            if (z5) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$awaitEvenIfOnMainThread$0(CountDownLatch countDownLatch, Task task) {
        countDownLatch.countDown();
        return null;
    }
}
