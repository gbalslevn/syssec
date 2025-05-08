package com.google.firebase.perf.logging;

import android.util.Log;

/* loaded from: classes2.dex */
class LogWrapper {
    private static final String LOG_TAG = "FirebasePerformance";
    private static LogWrapper instance;

    private LogWrapper() {
    }

    public static synchronized LogWrapper getInstance() {
        LogWrapper logWrapper;
        synchronized (LogWrapper.class) {
            try {
                if (instance == null) {
                    instance = new LogWrapper();
                }
                logWrapper = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return logWrapper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        Log.d(LOG_TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str) {
        Log.e(LOG_TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str) {
        Log.i(LOG_TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(String str) {
        Log.w(LOG_TAG, str);
    }
}
