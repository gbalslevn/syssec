package androidx.work;

/* loaded from: classes.dex */
public interface RunnableScheduler {
    void cancel(Runnable runnable);

    void scheduleWithDelay(long j5, Runnable runnable);
}
