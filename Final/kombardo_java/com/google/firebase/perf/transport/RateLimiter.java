package com.google.firebase.perf.transport;

import android.content.Context;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Rate;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.SessionVerbosity;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class RateLimiter {
    private final ConfigResolver configResolver;
    private final double fragmentBucketId;
    private boolean isLogcatEnabled;
    private RateLimiterImpl networkLimiter;
    private final double samplingBucketId;
    private RateLimiterImpl traceLimiter;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class RateLimiterImpl {
        private long backgroundCapacity;
        private Rate backgroundRate;
        private long capacity;
        private final Clock clock;
        private long foregroundCapacity;
        private Rate foregroundRate;
        private final boolean isLogcatEnabled;
        private Timer lastTimeTokenReplenished;
        private Rate rate;
        private double tokenCount;
        private static final AndroidLogger logger = AndroidLogger.getInstance();
        private static final long MICROS_IN_A_SECOND = TimeUnit.SECONDS.toMicros(1);

        RateLimiterImpl(Rate rate, long j5, Clock clock, ConfigResolver configResolver, String str, boolean z5) {
            this.clock = clock;
            this.capacity = j5;
            this.rate = rate;
            this.tokenCount = j5;
            this.lastTimeTokenReplenished = clock.getTime();
            setRateByReadingRemoteConfigValues(configResolver, str, z5);
            this.isLogcatEnabled = z5;
        }

        private static long getBlimitEvents(ConfigResolver configResolver, String str) {
            return str == "Trace" ? configResolver.getTraceEventCountBackground() : configResolver.getNetworkEventCountBackground();
        }

        private static long getBlimitSec(ConfigResolver configResolver, String str) {
            return str == "Trace" ? configResolver.getRateLimitSec() : configResolver.getRateLimitSec();
        }

        private static long getFlimitEvents(ConfigResolver configResolver, String str) {
            return str == "Trace" ? configResolver.getTraceEventCountForeground() : configResolver.getNetworkEventCountForeground();
        }

        private static long getFlimitSec(ConfigResolver configResolver, String str) {
            return str == "Trace" ? configResolver.getRateLimitSec() : configResolver.getRateLimitSec();
        }

        private void setRateByReadingRemoteConfigValues(ConfigResolver configResolver, String str, boolean z5) {
            long flimitSec = getFlimitSec(configResolver, str);
            long flimitEvents = getFlimitEvents(configResolver, str);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Rate rate = new Rate(flimitEvents, flimitSec, timeUnit);
            this.foregroundRate = rate;
            this.foregroundCapacity = flimitEvents;
            if (z5) {
                logger.debug("Foreground %s logging rate:%f, burst capacity:%d", str, rate, Long.valueOf(flimitEvents));
            }
            long blimitSec = getBlimitSec(configResolver, str);
            long blimitEvents = getBlimitEvents(configResolver, str);
            Rate rate2 = new Rate(blimitEvents, blimitSec, timeUnit);
            this.backgroundRate = rate2;
            this.backgroundCapacity = blimitEvents;
            if (z5) {
                logger.debug("Background %s logging rate:%f, capacity:%d", str, rate2, Long.valueOf(blimitEvents));
            }
        }

        synchronized void changeRate(boolean z5) {
            try {
                this.rate = z5 ? this.foregroundRate : this.backgroundRate;
                this.capacity = z5 ? this.foregroundCapacity : this.backgroundCapacity;
            } catch (Throwable th) {
                throw th;
            }
        }

        synchronized boolean check(PerfMetric perfMetric) {
            try {
                Timer time = this.clock.getTime();
                double durationMicros = (this.lastTimeTokenReplenished.getDurationMicros(time) * this.rate.getTokensPerSeconds()) / MICROS_IN_A_SECOND;
                if (durationMicros > 0.0d) {
                    this.tokenCount = Math.min(this.tokenCount + durationMicros, this.capacity);
                    this.lastTimeTokenReplenished = time;
                }
                double d5 = this.tokenCount;
                if (d5 >= 1.0d) {
                    this.tokenCount = d5 - 1.0d;
                    return true;
                }
                if (this.isLogcatEnabled) {
                    logger.warn("Exceeded log rate limit, dropping the log.");
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public RateLimiter(Context context, Rate rate, long j5) {
        this(rate, j5, new Clock(), getSamplingBucketId(), getSamplingBucketId(), ConfigResolver.getInstance());
        this.isLogcatEnabled = Utils.isDebugLoggingEnabled(context);
    }

    static double getSamplingBucketId() {
        return new Random().nextDouble();
    }

    private boolean hasVerboseSessions(List<PerfSession> list) {
        return list.size() > 0 && list.get(0).getSessionVerbosityCount() > 0 && list.get(0).getSessionVerbosity(0) == SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS;
    }

    private boolean isDeviceAllowedToSendFragmentScreenTraces() {
        return this.fragmentBucketId < this.configResolver.getFragmentSamplingRate();
    }

    private boolean isDeviceAllowedToSendNetworkEvents() {
        return this.samplingBucketId < this.configResolver.getNetworkRequestSamplingRate();
    }

    private boolean isDeviceAllowedToSendTraces() {
        return this.samplingBucketId < this.configResolver.getTraceSamplingRate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void changeRate(boolean z5) {
        this.traceLimiter.changeRate(z5);
        this.networkLimiter.changeRate(z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEventRateLimited(PerfMetric perfMetric) {
        if (!isRateLimitApplicable(perfMetric)) {
            return false;
        }
        if (perfMetric.hasNetworkRequestMetric()) {
            return !this.networkLimiter.check(perfMetric);
        }
        if (perfMetric.hasTraceMetric()) {
            return !this.traceLimiter.check(perfMetric);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEventSampled(PerfMetric perfMetric) {
        if (perfMetric.hasTraceMetric() && !isDeviceAllowedToSendTraces() && !hasVerboseSessions(perfMetric.getTraceMetric().getPerfSessionsList())) {
            return false;
        }
        if (!isFragmentScreenTrace(perfMetric) || isDeviceAllowedToSendFragmentScreenTraces() || hasVerboseSessions(perfMetric.getTraceMetric().getPerfSessionsList())) {
            return !perfMetric.hasNetworkRequestMetric() || isDeviceAllowedToSendNetworkEvents() || hasVerboseSessions(perfMetric.getNetworkRequestMetric().getPerfSessionsList());
        }
        return false;
    }

    protected boolean isFragmentScreenTrace(PerfMetric perfMetric) {
        return perfMetric.hasTraceMetric() && perfMetric.getTraceMetric().getName().startsWith("_st_") && perfMetric.getTraceMetric().containsCustomAttributes("Hosting_activity");
    }

    boolean isRateLimitApplicable(PerfMetric perfMetric) {
        return (!perfMetric.hasTraceMetric() || (!(perfMetric.getTraceMetric().getName().equals(Constants$TraceNames.FOREGROUND_TRACE_NAME.toString()) || perfMetric.getTraceMetric().getName().equals(Constants$TraceNames.BACKGROUND_TRACE_NAME.toString())) || perfMetric.getTraceMetric().getCountersCount() <= 0)) && !perfMetric.hasGaugeMetric();
    }

    RateLimiter(Rate rate, long j5, Clock clock, double d5, double d6, ConfigResolver configResolver) {
        this.traceLimiter = null;
        this.networkLimiter = null;
        boolean z5 = false;
        this.isLogcatEnabled = false;
        Utils.checkArgument(0.0d <= d5 && d5 < 1.0d, "Sampling bucket ID should be in range [0.0, 1.0).");
        if (0.0d <= d6 && d6 < 1.0d) {
            z5 = true;
        }
        Utils.checkArgument(z5, "Fragment sampling bucket ID should be in range [0.0, 1.0).");
        this.samplingBucketId = d5;
        this.fragmentBucketId = d6;
        this.configResolver = configResolver;
        this.traceLimiter = new RateLimiterImpl(rate, j5, clock, configResolver, "Trace", this.isLogcatEnabled);
        this.networkLimiter = new RateLimiterImpl(rate, j5, clock, configResolver, "Network", this.isLogcatEnabled);
    }
}
