package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsTasks;

/* loaded from: classes2.dex */
public class DataCollectionArbiter {
    private static final String FIREBASE_CRASHLYTICS_COLLECTION_ENABLED = "firebase_crashlytics_collection_enabled";
    private Boolean crashlyticsDataCollectionEnabled;
    TaskCompletionSource<Void> dataCollectionEnabledTask;
    private final TaskCompletionSource<Void> dataCollectionExplicitlyApproved;
    private final FirebaseApp firebaseApp;
    private boolean setInManifest;
    private final SharedPreferences sharedPreferences;
    private final Object taskLock;
    boolean taskResolved;

    public DataCollectionArbiter(FirebaseApp firebaseApp) {
        Object obj = new Object();
        this.taskLock = obj;
        this.dataCollectionEnabledTask = new TaskCompletionSource<>();
        this.taskResolved = false;
        this.setInManifest = false;
        this.dataCollectionExplicitlyApproved = new TaskCompletionSource<>();
        Context applicationContext = firebaseApp.getApplicationContext();
        this.firebaseApp = firebaseApp;
        this.sharedPreferences = CommonUtils.getSharedPrefs(applicationContext);
        Boolean dataCollectionValueFromSharedPreferences = getDataCollectionValueFromSharedPreferences();
        this.crashlyticsDataCollectionEnabled = dataCollectionValueFromSharedPreferences == null ? getDataCollectionValueFromManifest(applicationContext) : dataCollectionValueFromSharedPreferences;
        synchronized (obj) {
            try {
                if (isAutomaticDataCollectionEnabled()) {
                    this.dataCollectionEnabledTask.trySetResult(null);
                    this.taskResolved = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private Boolean getDataCollectionValueFromManifest(Context context) {
        Boolean readCrashlyticsDataCollectionEnabledFromManifest = readCrashlyticsDataCollectionEnabledFromManifest(context);
        if (readCrashlyticsDataCollectionEnabledFromManifest == null) {
            this.setInManifest = false;
            return null;
        }
        this.setInManifest = true;
        return Boolean.valueOf(Boolean.TRUE.equals(readCrashlyticsDataCollectionEnabledFromManifest));
    }

    private Boolean getDataCollectionValueFromSharedPreferences() {
        if (!this.sharedPreferences.contains(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED)) {
            return null;
        }
        this.setInManifest = false;
        return Boolean.valueOf(this.sharedPreferences.getBoolean(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED, true));
    }

    private boolean isFirebaseDataCollectionDefaultEnabled() {
        try {
            return this.firebaseApp.isDataCollectionDefaultEnabled();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    private void logDataCollectionState(boolean z5) {
        Logger.getLogger().d(String.format("Crashlytics automatic data collection %s by %s.", z5 ? "ENABLED" : "DISABLED", this.crashlyticsDataCollectionEnabled == null ? "global Firebase setting" : this.setInManifest ? "firebase_crashlytics_collection_enabled manifest flag" : "API"));
    }

    private static Boolean readCrashlyticsDataCollectionEnabledFromManifest(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED)) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean(FIREBASE_CRASHLYTICS_COLLECTION_ENABLED));
        } catch (PackageManager.NameNotFoundException e5) {
            Logger.getLogger().e("Could not read data collection permission from manifest", e5);
            return null;
        }
    }

    public void grantDataCollectionPermission(boolean z5) {
        if (!z5) {
            throw new IllegalStateException("An invalid data collection token was used.");
        }
        this.dataCollectionExplicitlyApproved.trySetResult(null);
    }

    public synchronized boolean isAutomaticDataCollectionEnabled() {
        boolean booleanValue;
        try {
            Boolean bool = this.crashlyticsDataCollectionEnabled;
            booleanValue = bool != null ? bool.booleanValue() : isFirebaseDataCollectionDefaultEnabled();
            logDataCollectionState(booleanValue);
        } catch (Throwable th) {
            throw th;
        }
        return booleanValue;
    }

    public Task<Void> waitForAutomaticDataCollectionEnabled() {
        Task<Void> task;
        synchronized (this.taskLock) {
            task = this.dataCollectionEnabledTask.getTask();
        }
        return task;
    }

    public Task<Void> waitForDataCollectionPermission() {
        return CrashlyticsTasks.race(this.dataCollectionExplicitlyApproved.getTask(), waitForAutomaticDataCollectionEnabled());
    }
}
