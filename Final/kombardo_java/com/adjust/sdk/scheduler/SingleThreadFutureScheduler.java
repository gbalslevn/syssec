package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class SingleThreadFutureScheduler implements FutureScheduler {
    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    /* loaded from: classes.dex */
    public class a implements RejectedExecutionHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4222a;

        public a(String str) {
            this.f4222a = str;
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            AdjustFactory.getLogger().warn("Runnable [%s] rejected from [%s] ", runnable.toString(), this.f4222a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    /* loaded from: classes.dex */
    public class b<V> implements Callable<V> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callable f4223a;

        public b(Callable callable) {
            this.f4223a = callable;
        }

        @Override // java.util.concurrent.Callable
        public final V call() {
            try {
                return (V) this.f4223a.call();
            } catch (Throwable th) {
                AdjustFactory.getLogger().error("Callable error [%s] of type [%s]", th.getMessage(), th.getClass().getCanonicalName());
                return null;
            }
        }
    }

    public SingleThreadFutureScheduler(String str, boolean z5) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactoryWrapper(str), new a(str));
        this.scheduledThreadPoolExecutor = scheduledThreadPoolExecutor;
        if (z5) {
            return;
        }
        scheduledThreadPoolExecutor.setKeepAliveTime(10L, TimeUnit.MILLISECONDS);
        this.scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    @Override // com.adjust.sdk.scheduler.FutureScheduler
    public ScheduledFuture<?> scheduleFuture(Runnable runnable, long j5) {
        return this.scheduledThreadPoolExecutor.schedule(new RunnableWrapper(runnable), j5, TimeUnit.MILLISECONDS);
    }

    @Override // com.adjust.sdk.scheduler.FutureScheduler
    public ScheduledFuture<?> scheduleFutureWithFixedDelay(Runnable runnable, long j5, long j6) {
        return this.scheduledThreadPoolExecutor.scheduleWithFixedDelay(new RunnableWrapper(runnable), j5, j6, TimeUnit.MILLISECONDS);
    }

    @Override // com.adjust.sdk.scheduler.FutureScheduler
    public <V> ScheduledFuture<V> scheduleFutureWithReturn(Callable<V> callable, long j5) {
        return this.scheduledThreadPoolExecutor.schedule(new b(callable), j5, TimeUnit.MILLISECONDS);
    }

    @Override // com.adjust.sdk.scheduler.FutureScheduler
    public void teardown() {
        this.scheduledThreadPoolExecutor.shutdownNow();
    }
}
