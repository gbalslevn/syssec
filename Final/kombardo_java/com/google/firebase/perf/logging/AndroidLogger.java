package com.google.firebase.perf.logging;

import java.util.Locale;

/* loaded from: classes2.dex */
public class AndroidLogger {
    private static volatile AndroidLogger instance;
    private boolean isLogcatEnabled;
    private final LogWrapper logWrapper;

    public AndroidLogger(LogWrapper logWrapper) {
        this.isLogcatEnabled = false;
        this.logWrapper = logWrapper == null ? LogWrapper.getInstance() : logWrapper;
    }

    public static AndroidLogger getInstance() {
        if (instance == null) {
            synchronized (AndroidLogger.class) {
                try {
                    if (instance == null) {
                        instance = new AndroidLogger();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public void debug(String str) {
        if (this.isLogcatEnabled) {
            this.logWrapper.d(str);
        }
    }

    public void error(String str) {
        if (this.isLogcatEnabled) {
            this.logWrapper.e(str);
        }
    }

    public void info(String str) {
        if (this.isLogcatEnabled) {
            this.logWrapper.i(str);
        }
    }

    public boolean isLogcatEnabled() {
        return this.isLogcatEnabled;
    }

    public void setLogcatEnabled(boolean z5) {
        this.isLogcatEnabled = z5;
    }

    public void warn(String str) {
        if (this.isLogcatEnabled) {
            this.logWrapper.w(str);
        }
    }

    public void debug(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            this.logWrapper.d(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public void error(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            this.logWrapper.e(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public void info(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            this.logWrapper.i(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public void warn(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            this.logWrapper.w(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    private AndroidLogger() {
        this(null);
    }
}
