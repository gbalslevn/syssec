package com.adjust.sdk.scheduler;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes.dex */
public interface FutureScheduler {
    ScheduledFuture<?> scheduleFuture(Runnable runnable, long j5);

    ScheduledFuture<?> scheduleFutureWithFixedDelay(Runnable runnable, long j5, long j6);

    <V> ScheduledFuture<V> scheduleFutureWithReturn(Callable<V> callable, long j5);

    void teardown();
}
