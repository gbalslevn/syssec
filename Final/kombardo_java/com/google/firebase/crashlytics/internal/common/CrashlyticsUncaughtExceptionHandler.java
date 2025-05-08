package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private final CrashListener crashListener;
    private final Thread.UncaughtExceptionHandler defaultHandler;
    private final AtomicBoolean isHandlingException = new AtomicBoolean(false);
    private final CrashlyticsNativeComponent nativeComponent;
    private final SettingsProvider settingsProvider;

    /* loaded from: classes2.dex */
    interface CrashListener {
        void onUncaughtException(SettingsProvider settingsProvider, Thread thread, Throwable th);
    }

    public CrashlyticsUncaughtExceptionHandler(CrashListener crashListener, SettingsProvider settingsProvider, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, CrashlyticsNativeComponent crashlyticsNativeComponent) {
        this.crashListener = crashListener;
        this.settingsProvider = settingsProvider;
        this.defaultHandler = uncaughtExceptionHandler;
        this.nativeComponent = crashlyticsNativeComponent;
    }

    private boolean shouldRecordUncaughtException(Thread thread, Throwable th) {
        if (thread == null) {
            Logger.getLogger().e("Crashlytics will not record uncaught exception; null thread");
            return false;
        }
        if (th == null) {
            Logger.getLogger().e("Crashlytics will not record uncaught exception; null throwable");
            return false;
        }
        if (!this.nativeComponent.hasCrashDataForCurrentSession()) {
            return true;
        }
        Logger.getLogger().d("Crashlytics will not record uncaught exception; native crash exists for session.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isHandlingException() {
        return this.isHandlingException.get();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
    
        r7.isHandlingException.set(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0055, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        com.google.firebase.crashlytics.internal.Logger.getLogger().d("Completed exception processing, but no default exception handler.");
        java.lang.System.exit(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
    
        if (r7.defaultHandler == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (r7.defaultHandler != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002a, code lost:
    
        com.google.firebase.crashlytics.internal.Logger.getLogger().d("Completed exception processing. Invoking default exception handler.");
        r7.defaultHandler.uncaughtException(r8, r9);
     */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uncaughtException(Thread thread, Throwable th) {
        this.isHandlingException.set(true);
        try {
            try {
                if (shouldRecordUncaughtException(thread, th)) {
                    this.crashListener.onUncaughtException(this.settingsProvider, thread, th);
                } else {
                    Logger.getLogger().d("Uncaught exception will not be recorded by Crashlytics.");
                }
            } catch (Exception e5) {
                Logger.getLogger().e("An error occurred in the uncaught exception handler", e5);
            }
        } catch (Throwable th2) {
            if (this.defaultHandler != null) {
                Logger.getLogger().d("Completed exception processing. Invoking default exception handler.");
                this.defaultHandler.uncaughtException(thread, th);
            } else {
                Logger.getLogger().d("Completed exception processing, but no default exception handler.");
                System.exit(1);
            }
            this.isHandlingException.set(false);
            throw th2;
        }
    }
}
