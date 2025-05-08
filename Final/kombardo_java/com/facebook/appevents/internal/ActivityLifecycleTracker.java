package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\n \"*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010%\u001a\n \"*\u0004\u0018\u00010!0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$R\u001c\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0016\u00104\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010 R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010;\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010\u001cR\u0014\u0010>\u001a\u0002058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lcom/facebook/appevents/internal/ActivityLifecycleTracker;", BuildConfig.FLAVOR, "<init>", "()V", "Landroid/app/Application;", "application", BuildConfig.FLAVOR, "appId", BuildConfig.FLAVOR, "startTracking", "(Landroid/app/Application;Ljava/lang/String;)V", BuildConfig.FLAVOR, "isInBackground", "()Z", "Ljava/util/UUID;", "getCurrentSessionGuid", "()Ljava/util/UUID;", "Landroid/app/Activity;", "activity", "onActivityCreated", "(Landroid/app/Activity;)V", "onActivityResumed", "onActivityPaused", "onActivityDestroyed", "cancelCurrentTask", "getCurrentActivity", "()Landroid/app/Activity;", "TAG", "Ljava/lang/String;", "INCORRECT_IMPL_WARNING", BuildConfig.FLAVOR, "INTERRUPTION_THRESHOLD_MILLISECONDS", "J", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "singleThreadExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "iapExecutor", "Ljava/util/concurrent/ScheduledFuture;", "currentFuture", "Ljava/util/concurrent/ScheduledFuture;", "currentFutureLock", "Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicInteger;", "foregroundActivityCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lcom/facebook/appevents/internal/SessionInfo;", "currentSession", "Lcom/facebook/appevents/internal/SessionInfo;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "tracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "currentActivityAppearTime", BuildConfig.FLAVOR, "activityReferences", "I", "Ljava/lang/ref/WeakReference;", "currActivity", "Ljava/lang/ref/WeakReference;", "previousActivityName", "getSessionTimeoutInSeconds", "()I", "sessionTimeoutInSeconds", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ActivityLifecycleTracker {
    private static final String INCORRECT_IMPL_WARNING = "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method";
    public static final ActivityLifecycleTracker INSTANCE = new ActivityLifecycleTracker();
    private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000;
    private static final String TAG;
    private static int activityReferences;
    private static String appId;
    private static WeakReference<Activity> currActivity;
    private static long currentActivityAppearTime;
    private static volatile ScheduledFuture<?> currentFuture;
    private static final Object currentFutureLock;
    private static volatile SessionInfo currentSession;
    private static final AtomicInteger foregroundActivityCount;
    private static final ScheduledExecutorService iapExecutor;
    private static String previousActivityName;
    private static final ScheduledExecutorService singleThreadExecutor;
    private static final AtomicBoolean tracking;

    static {
        String canonicalName = ActivityLifecycleTracker.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "com.facebook.appevents.internal.ActivityLifecycleTracker";
        }
        TAG = canonicalName;
        singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
        iapExecutor = Executors.newSingleThreadScheduledExecutor();
        currentFutureLock = new Object();
        foregroundActivityCount = new AtomicInteger(0);
        tracking = new AtomicBoolean(false);
    }

    private ActivityLifecycleTracker() {
    }

    private final void cancelCurrentTask() {
        ScheduledFuture<?> scheduledFuture;
        synchronized (currentFutureLock) {
            try {
                if (currentFuture != null && (scheduledFuture = currentFuture) != null) {
                    scheduledFuture.cancel(false);
                }
                currentFuture = null;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = currActivity;
        if (weakReference == null || weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static final UUID getCurrentSessionGuid() {
        SessionInfo sessionInfo;
        if (currentSession == null || (sessionInfo = currentSession) == null) {
            return null;
        }
        return sessionInfo.getSessionId();
    }

    private final int getSessionTimeoutInSeconds() {
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return appSettingsWithoutQuery == null ? Constants.getDefaultAppEventsSessionTimeoutInSeconds() : appSettingsWithoutQuery.getSessionTimeoutInSeconds();
    }

    public static final boolean isInBackground() {
        return activityReferences == 0;
    }

    public static final void onActivityCreated(Activity activity) {
        singleThreadExecutor.execute(new Runnable() { // from class: k0.e
            @Override // java.lang.Runnable
            public final void run() {
                ActivityLifecycleTracker.m2835onActivityCreated$lambda1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-1, reason: not valid java name */
    public static final void m2835onActivityCreated$lambda1() {
        if (currentSession == null) {
            currentSession = SessionInfo.INSTANCE.getStoredSessionInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onActivityDestroyed(Activity activity) {
        CodelessManager.onActivityDestroyed(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onActivityPaused(Activity activity) {
        AtomicInteger atomicInteger = foregroundActivityCount;
        if (atomicInteger.decrementAndGet() < 0) {
            atomicInteger.set(0);
            Log.w(TAG, INCORRECT_IMPL_WARNING);
        }
        cancelCurrentTask();
        final long currentTimeMillis = System.currentTimeMillis();
        final String activityName = Utility.getActivityName(activity);
        CodelessManager.onActivityPaused(activity);
        singleThreadExecutor.execute(new Runnable() { // from class: k0.d
            @Override // java.lang.Runnable
            public final void run() {
                ActivityLifecycleTracker.m2836onActivityPaused$lambda7(currentTimeMillis, activityName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onActivityPaused$lambda-7, reason: not valid java name */
    public static final void m2836onActivityPaused$lambda7(final long j5, final String activityName) {
        Intrinsics.checkNotNullParameter(activityName, "$activityName");
        if (currentSession == null) {
            currentSession = new SessionInfo(Long.valueOf(j5), null, null, 4, null);
        }
        SessionInfo sessionInfo = currentSession;
        if (sessionInfo != null) {
            sessionInfo.setSessionLastEventTime(Long.valueOf(j5));
        }
        if (foregroundActivityCount.get() <= 0) {
            Runnable runnable = new Runnable() { // from class: k0.f
                @Override // java.lang.Runnable
                public final void run() {
                    ActivityLifecycleTracker.m2837onActivityPaused$lambda7$lambda5(j5, activityName);
                }
            };
            synchronized (currentFutureLock) {
                currentFuture = singleThreadExecutor.schedule(runnable, INSTANCE.getSessionTimeoutInSeconds(), TimeUnit.SECONDS);
                Unit unit = Unit.INSTANCE;
            }
        }
        long j6 = currentActivityAppearTime;
        AutomaticAnalyticsLogger.logActivityTimeSpentEvent(activityName, j6 > 0 ? (j5 - j6) / com.adjust.sdk.Constants.ONE_SECOND : 0L);
        SessionInfo sessionInfo2 = currentSession;
        if (sessionInfo2 == null) {
            return;
        }
        sessionInfo2.writeSessionToDisk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onActivityPaused$lambda-7$lambda-5, reason: not valid java name */
    public static final void m2837onActivityPaused$lambda7$lambda5(long j5, String activityName) {
        Intrinsics.checkNotNullParameter(activityName, "$activityName");
        if (currentSession == null) {
            currentSession = new SessionInfo(Long.valueOf(j5), null, null, 4, null);
        }
        if (foregroundActivityCount.get() <= 0) {
            SessionLogger sessionLogger = SessionLogger.INSTANCE;
            SessionLogger.logDeactivateApp(activityName, currentSession, appId);
            SessionInfo.INSTANCE.clearSavedSessionFromDisk();
            currentSession = null;
        }
        synchronized (currentFutureLock) {
            currentFuture = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        currActivity = new WeakReference<>(activity);
        foregroundActivityCount.incrementAndGet();
        INSTANCE.cancelCurrentTask();
        final long currentTimeMillis = System.currentTimeMillis();
        currentActivityAppearTime = currentTimeMillis;
        final String activityName = Utility.getActivityName(activity);
        CodelessManager.onActivityResumed(activity);
        MetadataIndexer.onActivityResumed(activity);
        SuggestedEventsManager.trackActivity(activity);
        String str = previousActivityName;
        if (Intrinsics.areEqual(str != null ? Boolean.valueOf(StringsKt.contains$default((CharSequence) str, (CharSequence) "ProxyBillingActivity", false, 2, (Object) null)) : null, Boolean.TRUE) && !Intrinsics.areEqual(activityName, "ProxyBillingActivity")) {
            iapExecutor.execute(new Runnable() { // from class: k0.b
                @Override // java.lang.Runnable
                public final void run() {
                    InAppPurchaseManager.startTracking();
                }
            });
        }
        final Context applicationContext = activity.getApplicationContext();
        singleThreadExecutor.execute(new Runnable() { // from class: k0.c
            @Override // java.lang.Runnable
            public final void run() {
                ActivityLifecycleTracker.m2839onActivityResumed$lambda3(currentTimeMillis, activityName, applicationContext);
            }
        });
        previousActivityName = activityName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onActivityResumed$lambda-3, reason: not valid java name */
    public static final void m2839onActivityResumed$lambda3(long j5, String activityName, Context appContext) {
        SessionInfo sessionInfo;
        Intrinsics.checkNotNullParameter(activityName, "$activityName");
        SessionInfo sessionInfo2 = currentSession;
        Long sessionLastEventTime = sessionInfo2 == null ? null : sessionInfo2.getSessionLastEventTime();
        if (currentSession == null) {
            currentSession = new SessionInfo(Long.valueOf(j5), null, null, 4, null);
            SessionLogger sessionLogger = SessionLogger.INSTANCE;
            String str = appId;
            Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
            SessionLogger.logActivateApp(activityName, null, str, appContext);
        } else if (sessionLastEventTime != null) {
            long longValue = j5 - sessionLastEventTime.longValue();
            if (longValue > INSTANCE.getSessionTimeoutInSeconds() * com.adjust.sdk.Constants.ONE_SECOND) {
                SessionLogger sessionLogger2 = SessionLogger.INSTANCE;
                SessionLogger.logDeactivateApp(activityName, currentSession, appId);
                String str2 = appId;
                Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
                SessionLogger.logActivateApp(activityName, null, str2, appContext);
                currentSession = new SessionInfo(Long.valueOf(j5), null, null, 4, null);
            } else if (longValue > INTERRUPTION_THRESHOLD_MILLISECONDS && (sessionInfo = currentSession) != null) {
                sessionInfo.incrementInterruptionCount();
            }
        }
        SessionInfo sessionInfo3 = currentSession;
        if (sessionInfo3 != null) {
            sessionInfo3.setSessionLastEventTime(Long.valueOf(j5));
        }
        SessionInfo sessionInfo4 = currentSession;
        if (sessionInfo4 == null) {
            return;
        }
        sessionInfo4.writeSessionToDisk();
    }

    public static final void startTracking(Application application, String appId2) {
        Intrinsics.checkNotNullParameter(application, "application");
        if (tracking.compareAndSet(false, true)) {
            FeatureManager featureManager = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(FeatureManager.Feature.CodelessEvents, new FeatureManager.Callback() { // from class: k0.a
                @Override // com.facebook.internal.FeatureManager.Callback
                public final void onCompleted(boolean z5) {
                    ActivityLifecycleTracker.m2840startTracking$lambda0(z5);
                }
            });
            appId = appId2;
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.facebook.appevents.internal.ActivityLifecycleTracker$startTracking$2
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                    String str;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Logger.Companion companion = Logger.INSTANCE;
                    LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                    str = ActivityLifecycleTracker.TAG;
                    companion.log(loggingBehavior, str, "onActivityCreated");
                    AppEventUtility.assertIsMainThread();
                    ActivityLifecycleTracker.onActivityCreated(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    String str;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Logger.Companion companion = Logger.INSTANCE;
                    LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                    str = ActivityLifecycleTracker.TAG;
                    companion.log(loggingBehavior, str, "onActivityDestroyed");
                    ActivityLifecycleTracker.INSTANCE.onActivityDestroyed(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    String str;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Logger.Companion companion = Logger.INSTANCE;
                    LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                    str = ActivityLifecycleTracker.TAG;
                    companion.log(loggingBehavior, str, "onActivityPaused");
                    AppEventUtility.assertIsMainThread();
                    ActivityLifecycleTracker.INSTANCE.onActivityPaused(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    String str;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Logger.Companion companion = Logger.INSTANCE;
                    LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                    str = ActivityLifecycleTracker.TAG;
                    companion.log(loggingBehavior, str, "onActivityResumed");
                    AppEventUtility.assertIsMainThread();
                    ActivityLifecycleTracker.onActivityResumed(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                    String str;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Intrinsics.checkNotNullParameter(outState, "outState");
                    Logger.Companion companion = Logger.INSTANCE;
                    LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                    str = ActivityLifecycleTracker.TAG;
                    companion.log(loggingBehavior, str, "onActivitySaveInstanceState");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    int i5;
                    String str;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    i5 = ActivityLifecycleTracker.activityReferences;
                    ActivityLifecycleTracker.activityReferences = i5 + 1;
                    Logger.Companion companion = Logger.INSTANCE;
                    LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                    str = ActivityLifecycleTracker.TAG;
                    companion.log(loggingBehavior, str, "onActivityStarted");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    String str;
                    int i5;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Logger.Companion companion = Logger.INSTANCE;
                    LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                    str = ActivityLifecycleTracker.TAG;
                    companion.log(loggingBehavior, str, "onActivityStopped");
                    AppEventsLogger.INSTANCE.onContextStop();
                    i5 = ActivityLifecycleTracker.activityReferences;
                    ActivityLifecycleTracker.activityReferences = i5 - 1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startTracking$lambda-0, reason: not valid java name */
    public static final void m2840startTracking$lambda0(boolean z5) {
        if (z5) {
            CodelessManager.enable();
        } else {
            CodelessManager.disable();
        }
    }
}
