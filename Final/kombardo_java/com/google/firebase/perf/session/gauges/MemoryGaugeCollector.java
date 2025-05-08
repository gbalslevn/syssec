package com.google.firebase.perf.session.gauges;

import android.annotation.SuppressLint;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.AndroidMemoryReading;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class MemoryGaugeCollector {
    private static final int UNSET_MEMORY_METRIC_COLLECTION_RATE = -1;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private long memoryMetricCollectionRateMs;
    private final ScheduledExecutorService memoryMetricCollectorExecutor;
    private ScheduledFuture memoryMetricCollectorJob;
    public final ConcurrentLinkedQueue<AndroidMemoryReading> memoryMetricReadings;
    private final Runtime runtime;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ThreadPoolCreation"})
    public MemoryGaugeCollector() {
        this(Executors.newSingleThreadScheduledExecutor(), Runtime.getRuntime());
    }

    private int getCurrentUsedAppJavaHeapMemoryKb() {
        return Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(this.runtime.totalMemory() - this.runtime.freeMemory()));
    }

    public static boolean isInvalidCollectionFrequency(long j5) {
        return j5 <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleMemoryMetricCollectionOnce$1(Timer timer) {
        AndroidMemoryReading syncCollectMemoryMetric = syncCollectMemoryMetric(timer);
        if (syncCollectMemoryMetric != null) {
            this.memoryMetricReadings.add(syncCollectMemoryMetric);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleMemoryMetricCollectionWithRate$0(Timer timer) {
        AndroidMemoryReading syncCollectMemoryMetric = syncCollectMemoryMetric(timer);
        if (syncCollectMemoryMetric != null) {
            this.memoryMetricReadings.add(syncCollectMemoryMetric);
        }
    }

    private synchronized void scheduleMemoryMetricCollectionOnce(final Timer timer) {
        try {
            this.memoryMetricCollectorExecutor.schedule(new Runnable() { // from class: com.google.firebase.perf.session.gauges.i
                @Override // java.lang.Runnable
                public final void run() {
                    MemoryGaugeCollector.this.lambda$scheduleMemoryMetricCollectionOnce$1(timer);
                }
            }, 0L, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e5) {
            logger.warn("Unable to collect Memory Metric: " + e5.getMessage());
        }
    }

    private synchronized void scheduleMemoryMetricCollectionWithRate(long j5, final Timer timer) {
        this.memoryMetricCollectionRateMs = j5;
        try {
            this.memoryMetricCollectorJob = this.memoryMetricCollectorExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.google.firebase.perf.session.gauges.h
                @Override // java.lang.Runnable
                public final void run() {
                    MemoryGaugeCollector.this.lambda$scheduleMemoryMetricCollectionWithRate$0(timer);
                }
            }, 0L, j5, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e5) {
            logger.warn("Unable to start collecting Memory Metrics: " + e5.getMessage());
        }
    }

    private AndroidMemoryReading syncCollectMemoryMetric(Timer timer) {
        if (timer == null) {
            return null;
        }
        return AndroidMemoryReading.newBuilder().setClientTimeUs(timer.getCurrentTimestampMicros()).setUsedAppJavaHeapMemoryKb(getCurrentUsedAppJavaHeapMemoryKb()).build();
    }

    public void collectOnce(Timer timer) {
        scheduleMemoryMetricCollectionOnce(timer);
    }

    public void startCollecting(long j5, Timer timer) {
        if (isInvalidCollectionFrequency(j5)) {
            return;
        }
        if (this.memoryMetricCollectorJob == null) {
            scheduleMemoryMetricCollectionWithRate(j5, timer);
        } else if (this.memoryMetricCollectionRateMs != j5) {
            stopCollecting();
            scheduleMemoryMetricCollectionWithRate(j5, timer);
        }
    }

    public void stopCollecting() {
        ScheduledFuture scheduledFuture = this.memoryMetricCollectorJob;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.memoryMetricCollectorJob = null;
        this.memoryMetricCollectionRateMs = -1L;
    }

    MemoryGaugeCollector(ScheduledExecutorService scheduledExecutorService, Runtime runtime) {
        this.memoryMetricCollectorJob = null;
        this.memoryMetricCollectionRateMs = -1L;
        this.memoryMetricCollectorExecutor = scheduledExecutorService;
        this.memoryMetricReadings = new ConcurrentLinkedQueue<>();
        this.runtime = runtime;
    }
}
