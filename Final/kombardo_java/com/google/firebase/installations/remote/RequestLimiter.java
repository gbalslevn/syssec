package com.google.firebase.installations.remote;

import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
class RequestLimiter {
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS = TimeUnit.HOURS.toMillis(24);
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS = TimeUnit.MINUTES.toMillis(30);
    private int attemptCount;
    private long nextRequestTime;
    private final Utils utils = Utils.getInstance();

    private synchronized long getBackoffDuration(int i5) {
        if (isRetryableError(i5)) {
            return (long) Math.min(Math.pow(2.0d, this.attemptCount) + this.utils.getRandomDelayForSyncPrevention(), MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS);
        }
        return MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS;
    }

    private static boolean isRetryableError(int i5) {
        return i5 == 429 || (i5 >= 500 && i5 < 600);
    }

    private static boolean isSuccessfulOrRequiresNewFidCreation(int i5) {
        return (i5 >= 200 && i5 < 300) || i5 == 401 || i5 == 404;
    }

    private synchronized void resetBackoffStrategy() {
        this.attemptCount = 0;
    }

    public synchronized boolean isRequestAllowed() {
        boolean z5;
        if (this.attemptCount != 0) {
            z5 = this.utils.currentTimeInMillis() > this.nextRequestTime;
        }
        return z5;
    }

    public synchronized void setNextRequestTime(int i5) {
        if (isSuccessfulOrRequiresNewFidCreation(i5)) {
            resetBackoffStrategy();
            return;
        }
        this.attemptCount++;
        this.nextRequestTime = this.utils.currentTimeInMillis() + getBackoffDuration(i5);
    }
}
