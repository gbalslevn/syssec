package com.google.firebase.perf.session.gauges;

import android.annotation.SuppressLint;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.CpuMetricReading;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class CpuGaugeCollector {
    private static final int CSTIME_POSITION_IN_PROC_PID_STAT = 16;
    private static final int CUTIME_POSITION_IN_PROC_PID_STAT = 15;
    private static final int INVALID_SC_PER_CPU_CLOCK_TICK = -1;
    private static final int STIME_POSITION_IN_PROC_PID_STAT = 14;
    private static final int UNSET_CPU_METRIC_COLLECTION_RATE = -1;
    private static final int UTIME_POSITION_IN_PROC_PID_STAT = 13;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static final long MICROSECONDS_PER_SECOND = TimeUnit.SECONDS.toMicros(1);
    private ScheduledFuture cpuMetricCollectorJob = null;
    private long cpuMetricCollectionRateMs = -1;
    public final ConcurrentLinkedQueue<CpuMetricReading> cpuMetricReadings = new ConcurrentLinkedQueue<>();
    private final ScheduledExecutorService cpuMetricCollectorExecutor = Executors.newSingleThreadScheduledExecutor();
    private final String procFileName = "/proc/" + Integer.toString(Process.myPid()) + "/stat";
    private final long clockTicksPerSecond = getClockTicksPerSecond();

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ThreadPoolCreation"})
    public CpuGaugeCollector() {
    }

    private long convertClockTicksToMicroseconds(long j5) {
        return Math.round((j5 / this.clockTicksPerSecond) * MICROSECONDS_PER_SECOND);
    }

    private long getClockTicksPerSecond() {
        return Os.sysconf(OsConstants._SC_CLK_TCK);
    }

    public static boolean isInvalidCollectionFrequency(long j5) {
        return j5 <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleCpuMetricCollectionOnce$1(Timer timer) {
        CpuMetricReading syncCollectCpuMetric = syncCollectCpuMetric(timer);
        if (syncCollectCpuMetric != null) {
            this.cpuMetricReadings.add(syncCollectCpuMetric);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleCpuMetricCollectionWithRate$0(Timer timer) {
        CpuMetricReading syncCollectCpuMetric = syncCollectCpuMetric(timer);
        if (syncCollectCpuMetric != null) {
            this.cpuMetricReadings.add(syncCollectCpuMetric);
        }
    }

    private synchronized void scheduleCpuMetricCollectionOnce(final Timer timer) {
        try {
            this.cpuMetricCollectorExecutor.schedule(new Runnable() { // from class: com.google.firebase.perf.session.gauges.b
                @Override // java.lang.Runnable
                public final void run() {
                    CpuGaugeCollector.this.lambda$scheduleCpuMetricCollectionOnce$1(timer);
                }
            }, 0L, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e5) {
            logger.warn("Unable to collect Cpu Metric: " + e5.getMessage());
        }
    }

    private synchronized void scheduleCpuMetricCollectionWithRate(long j5, final Timer timer) {
        this.cpuMetricCollectionRateMs = j5;
        try {
            this.cpuMetricCollectorJob = this.cpuMetricCollectorExecutor.scheduleAtFixedRate(new Runnable() { // from class: com.google.firebase.perf.session.gauges.a
                @Override // java.lang.Runnable
                public final void run() {
                    CpuGaugeCollector.this.lambda$scheduleCpuMetricCollectionWithRate$0(timer);
                }
            }, 0L, j5, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e5) {
            logger.warn("Unable to start collecting Cpu Metrics: " + e5.getMessage());
        }
    }

    private CpuMetricReading syncCollectCpuMetric(Timer timer) {
        if (timer == null) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.procFileName));
            try {
                long currentTimestampMicros = timer.getCurrentTimestampMicros();
                String[] split = bufferedReader.readLine().split(" ");
                CpuMetricReading build = CpuMetricReading.newBuilder().setClientTimeUs(currentTimestampMicros).setSystemTimeUs(convertClockTicksToMicroseconds(Long.parseLong(split[14]) + Long.parseLong(split[16]))).setUserTimeUs(convertClockTicksToMicroseconds(Long.parseLong(split[13]) + Long.parseLong(split[15]))).build();
                bufferedReader.close();
                return build;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e5) {
            logger.warn("Unable to read 'proc/[pid]/stat' file: " + e5.getMessage());
            return null;
        } catch (ArrayIndexOutOfBoundsException e6) {
            e = e6;
            logger.warn("Unexpected '/proc/[pid]/stat' file format encountered: " + e.getMessage());
            return null;
        } catch (NullPointerException e7) {
            e = e7;
            logger.warn("Unexpected '/proc/[pid]/stat' file format encountered: " + e.getMessage());
            return null;
        } catch (NumberFormatException e8) {
            e = e8;
            logger.warn("Unexpected '/proc/[pid]/stat' file format encountered: " + e.getMessage());
            return null;
        }
    }

    public void collectOnce(Timer timer) {
        scheduleCpuMetricCollectionOnce(timer);
    }

    public void startCollecting(long j5, Timer timer) {
        long j6 = this.clockTicksPerSecond;
        if (j6 == -1 || j6 == 0 || isInvalidCollectionFrequency(j5)) {
            return;
        }
        if (this.cpuMetricCollectorJob == null) {
            scheduleCpuMetricCollectionWithRate(j5, timer);
        } else if (this.cpuMetricCollectionRateMs != j5) {
            stopCollecting();
            scheduleCpuMetricCollectionWithRate(j5, timer);
        }
    }

    public void stopCollecting() {
        ScheduledFuture scheduledFuture = this.cpuMetricCollectorJob;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.cpuMetricCollectorJob = null;
        this.cpuMetricCollectionRateMs = -1L;
    }
}
