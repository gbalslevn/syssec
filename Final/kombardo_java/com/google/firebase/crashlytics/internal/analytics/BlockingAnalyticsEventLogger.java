package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {
    private final CrashlyticsOriginAnalyticsEventLogger baseAnalyticsEventLogger;
    private CountDownLatch eventLatch;
    private final TimeUnit timeUnit;
    private final int timeout;
    private final Object latchLock = new Object();
    private boolean callbackReceived = false;

    public BlockingAnalyticsEventLogger(CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int i5, TimeUnit timeUnit) {
        this.baseAnalyticsEventLogger = crashlyticsOriginAnalyticsEventLogger;
        this.timeout = i5;
        this.timeUnit = timeUnit;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public void logEvent(String str, Bundle bundle) {
        synchronized (this.latchLock) {
            try {
                Logger.getLogger().v("Logging event " + str + " to Firebase Analytics with params " + bundle);
                this.eventLatch = new CountDownLatch(1);
                this.callbackReceived = false;
                this.baseAnalyticsEventLogger.logEvent(str, bundle);
                Logger.getLogger().v("Awaiting app exception callback from Analytics...");
                try {
                    if (this.eventLatch.await(this.timeout, this.timeUnit)) {
                        this.callbackReceived = true;
                        Logger.getLogger().v("App exception callback received from Analytics listener.");
                    } else {
                        Logger.getLogger().w("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                    }
                } catch (InterruptedException unused) {
                    Logger.getLogger().e("Interrupted while awaiting app exception callback from Analytics listener.");
                }
                this.eventLatch = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public void onEvent(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.eventLatch;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
