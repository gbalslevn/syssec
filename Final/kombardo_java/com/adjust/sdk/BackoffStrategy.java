package com.adjust.sdk;

/* loaded from: classes.dex */
public enum BackoffStrategy {
    LONG_WAIT(1, 120000, 86400000, 0.5d, 1.0d),
    SHORT_WAIT(1, 200, 3600000, 0.5d, 1.0d),
    TEST_WAIT(1, 200, 1000, 0.5d, 1.0d),
    NO_WAIT(100, 1, 1000, 1.0d, 1.0d);

    public double maxRange;
    public long maxWait;
    public long milliSecondMultiplier;
    public double minRange;
    public int minRetries;

    BackoffStrategy(int i5, long j5, long j6, double d5, double d6) {
        this.minRetries = i5;
        this.milliSecondMultiplier = j5;
        this.maxWait = j6;
        this.minRange = d5;
        this.maxRange = d6;
    }
}
