package com.google.firebase.perf.metrics;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Keep;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.google.firebase.FirebaseApp;
import com.google.firebase.StartupTime;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.FirstDrawDoneListener;
import com.google.firebase.perf.util.PreDrawListener;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class AppStartTrace implements Application.ActivityLifecycleCallbacks, LifecycleObserver {
    private static final int CORE_POOL_SIZE = 0;
    private static final int MAX_POOL_SIZE = 1;
    private static ExecutorService executorService;
    private static volatile AppStartTrace instance;
    private Context appContext;
    private WeakReference<Activity> appStartActivity;
    private final Clock clock;
    private final ConfigResolver configResolver;
    private final TraceMetric.Builder experimentTtid;
    private final Timer firebaseClassLoadTime;
    private WeakReference<Activity> launchActivity;
    private final Timer processStartTime;
    private PerfSession startSession;
    private final TransportManager transportManager;
    private static final Timer PERF_CLASS_LOAD_TIME = new Clock().getTime();
    private static final long MAX_LATENCY_BEFORE_UI_INIT = TimeUnit.MINUTES.toMicros(1);
    private boolean isRegisteredForLifecycleCallbacks = false;
    private boolean isTooLateToInitUI = false;
    private Timer onCreateTime = null;
    private Timer onStartTime = null;
    private Timer onResumeTime = null;
    private Timer firstForegroundTime = null;
    private Timer firstBackgroundTime = null;
    private Timer preDrawPostTime = null;
    private Timer preDrawPostAtFrontOfQueueTime = null;
    private Timer onDrawPostAtFrontOfQueueTime = null;
    private boolean isStartedFromBackground = false;
    private int onDrawCount = 0;
    private final DrawCounter onDrawCounterListener = new DrawCounter();
    private boolean systemForegroundCheck = false;

    /* loaded from: classes2.dex */
    private final class DrawCounter implements ViewTreeObserver.OnDrawListener {
        private DrawCounter() {
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            AppStartTrace.access$308(AppStartTrace.this);
        }
    }

    /* loaded from: classes2.dex */
    public static class StartFromBackgroundRunnable implements Runnable {
        private final AppStartTrace trace;

        public StartFromBackgroundRunnable(AppStartTrace appStartTrace) {
            this.trace = appStartTrace;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.trace.onCreateTime == null) {
                this.trace.isStartedFromBackground = true;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    AppStartTrace(TransportManager transportManager, Clock clock, ConfigResolver configResolver, ExecutorService executorService2) {
        this.transportManager = transportManager;
        this.clock = clock;
        this.configResolver = configResolver;
        executorService = executorService2;
        this.experimentTtid = TraceMetric.newBuilder().setName("_experiment_app_start_ttid");
        this.processStartTime = Timer.ofElapsedRealtime(Process.getStartElapsedRealtime());
        StartupTime startupTime = (StartupTime) FirebaseApp.getInstance().get(StartupTime.class);
        this.firebaseClassLoadTime = startupTime != null ? Timer.ofElapsedRealtime(startupTime.getElapsedRealtime()) : null;
    }

    static /* synthetic */ int access$308(AppStartTrace appStartTrace) {
        int i5 = appStartTrace.onDrawCount;
        appStartTrace.onDrawCount = i5 + 1;
        return i5;
    }

    private Timer getClassLoadTimeCompat() {
        Timer timer = this.firebaseClassLoadTime;
        return timer != null ? timer : PERF_CLASS_LOAD_TIME;
    }

    public static AppStartTrace getInstance() {
        return instance != null ? instance : getInstance(TransportManager.getInstance(), new Clock());
    }

    private Timer getStartTimerCompat() {
        Timer timer = this.processStartTime;
        return timer != null ? timer : getClassLoadTimeCompat();
    }

    public static boolean isAnyAppProcessInForeground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        String packageName = context.getPackageName();
        String str = packageName + ":";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && (runningAppProcessInfo.processName.equals(packageName) || runningAppProcessInfo.processName.startsWith(str))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$logExperimentTrace$0(TraceMetric.Builder builder) {
        this.transportManager.log(builder.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logAppStartTrace() {
        TraceMetric.Builder durationUs = TraceMetric.newBuilder().setName(Constants$TraceNames.APP_START_TRACE_NAME.toString()).setClientStartTimeUs(getClassLoadTimeCompat().getMicros()).setDurationUs(getClassLoadTimeCompat().getDurationMicros(this.onResumeTime));
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(TraceMetric.newBuilder().setName(Constants$TraceNames.ON_CREATE_TRACE_NAME.toString()).setClientStartTimeUs(getClassLoadTimeCompat().getMicros()).setDurationUs(getClassLoadTimeCompat().getDurationMicros(this.onCreateTime)).build());
        if (this.onStartTime != null) {
            TraceMetric.Builder newBuilder = TraceMetric.newBuilder();
            newBuilder.setName(Constants$TraceNames.ON_START_TRACE_NAME.toString()).setClientStartTimeUs(this.onCreateTime.getMicros()).setDurationUs(this.onCreateTime.getDurationMicros(this.onStartTime));
            arrayList.add(newBuilder.build());
            TraceMetric.Builder newBuilder2 = TraceMetric.newBuilder();
            newBuilder2.setName(Constants$TraceNames.ON_RESUME_TRACE_NAME.toString()).setClientStartTimeUs(this.onStartTime.getMicros()).setDurationUs(this.onStartTime.getDurationMicros(this.onResumeTime));
            arrayList.add(newBuilder2.build());
        }
        durationUs.addAllSubtraces(arrayList).addPerfSessions(this.startSession.build());
        this.transportManager.log((TraceMetric) durationUs.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
    }

    private void logExperimentTrace(final TraceMetric.Builder builder) {
        if (this.preDrawPostTime == null || this.preDrawPostAtFrontOfQueueTime == null || this.onDrawPostAtFrontOfQueueTime == null) {
            return;
        }
        executorService.execute(new Runnable() { // from class: T0.e
            @Override // java.lang.Runnable
            public final void run() {
                AppStartTrace.this.lambda$logExperimentTrace$0(builder);
            }
        });
        unregisterActivityLifecycleCallbacks();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordOnDrawFrontOfQueue() {
        if (this.onDrawPostAtFrontOfQueueTime != null) {
            return;
        }
        this.onDrawPostAtFrontOfQueueTime = this.clock.getTime();
        this.experimentTtid.addSubtraces(TraceMetric.newBuilder().setName("_experiment_onDrawFoQ").setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(this.onDrawPostAtFrontOfQueueTime)).build());
        if (this.processStartTime != null) {
            this.experimentTtid.addSubtraces(TraceMetric.newBuilder().setName("_experiment_procStart_to_classLoad").setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(getClassLoadTimeCompat())).build());
        }
        this.experimentTtid.putCustomAttributes("systemDeterminedForeground", this.systemForegroundCheck ? "true" : "false");
        this.experimentTtid.putCounters("onDrawCount", this.onDrawCount);
        this.experimentTtid.addPerfSessions(this.startSession.build());
        logExperimentTrace(this.experimentTtid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordPreDraw() {
        if (this.preDrawPostTime != null) {
            return;
        }
        this.preDrawPostTime = this.clock.getTime();
        this.experimentTtid.setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(this.preDrawPostTime));
        logExperimentTrace(this.experimentTtid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordPreDrawFrontOfQueue() {
        if (this.preDrawPostAtFrontOfQueueTime != null) {
            return;
        }
        this.preDrawPostAtFrontOfQueueTime = this.clock.getTime();
        this.experimentTtid.addSubtraces(TraceMetric.newBuilder().setName("_experiment_preDrawFoQ").setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(this.preDrawPostAtFrontOfQueueTime)).build());
        logExperimentTrace(this.experimentTtid);
    }

    @Keep
    public static void setLauncherActivityOnCreateTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnResumeTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnStartTime(String str) {
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e A[Catch: all -> 0x001a, TRY_LEAVE, TryCatch #0 {all -> 0x001a, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000a, B:10:0x000f, B:14:0x001d, B:16:0x003e), top: B:2:0x0001 }] */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void onActivityCreated(Activity activity, Bundle bundle) {
        boolean z5;
        try {
            if (!this.isStartedFromBackground && this.onCreateTime == null) {
                if (!this.systemForegroundCheck && !isAnyAppProcessInForeground(this.appContext)) {
                    z5 = false;
                    this.systemForegroundCheck = z5;
                    this.launchActivity = new WeakReference<>(activity);
                    this.onCreateTime = this.clock.getTime();
                    if (getStartTimerCompat().getDurationMicros(this.onCreateTime) > MAX_LATENCY_BEFORE_UI_INIT) {
                        this.isTooLateToInitUI = true;
                    }
                }
                z5 = true;
                this.systemForegroundCheck = z5;
                this.launchActivity = new WeakReference<>(activity);
                this.onCreateTime = this.clock.getTime();
                if (getStartTimerCompat().getDurationMicros(this.onCreateTime) > MAX_LATENCY_BEFORE_UI_INIT) {
                }
            }
        } finally {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        View findViewById;
        if (this.isStartedFromBackground || this.isTooLateToInitUI || !this.configResolver.getIsExperimentTTIDEnabled() || (findViewById = activity.findViewById(R.id.content)) == null) {
            return;
        }
        findViewById.getViewTreeObserver().removeOnDrawListener(this.onDrawCounterListener);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
        View findViewById;
        try {
            if (!this.isStartedFromBackground && !this.isTooLateToInitUI) {
                boolean isExperimentTTIDEnabled = this.configResolver.getIsExperimentTTIDEnabled();
                if (isExperimentTTIDEnabled && (findViewById = activity.findViewById(R.id.content)) != null) {
                    findViewById.getViewTreeObserver().addOnDrawListener(this.onDrawCounterListener);
                    FirstDrawDoneListener.registerForNextDraw(findViewById, new Runnable() { // from class: T0.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            AppStartTrace.this.recordOnDrawFrontOfQueue();
                        }
                    });
                    PreDrawListener.registerForNextDraw(findViewById, new Runnable() { // from class: T0.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            AppStartTrace.this.recordPreDraw();
                        }
                    }, new Runnable() { // from class: T0.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            AppStartTrace.this.recordPreDrawFrontOfQueue();
                        }
                    });
                }
                if (this.onResumeTime != null) {
                    return;
                }
                this.appStartActivity = new WeakReference<>(activity);
                this.onResumeTime = this.clock.getTime();
                this.startSession = SessionManager.getInstance().perfSession();
                AndroidLogger.getInstance().debug("onResume(): " + activity.getClass().getName() + ": " + getClassLoadTimeCompat().getDurationMicros(this.onResumeTime) + " microseconds");
                executorService.execute(new Runnable() { // from class: T0.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppStartTrace.this.logAppStartTrace();
                    }
                });
                if (!isExperimentTTIDEnabled) {
                    unregisterActivityLifecycleCallbacks();
                }
            }
        } finally {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStarted(Activity activity) {
        if (!this.isStartedFromBackground && this.onStartTime == null && !this.isTooLateToInitUI) {
            this.onStartTime = this.clock.getTime();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Keep
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onAppEnteredBackground() {
        if (this.isStartedFromBackground || this.isTooLateToInitUI || this.firstBackgroundTime != null) {
            return;
        }
        this.firstBackgroundTime = this.clock.getTime();
        this.experimentTtid.addSubtraces(TraceMetric.newBuilder().setName("_experiment_firstBackgrounding").setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(this.firstBackgroundTime)).build());
    }

    @Keep
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onAppEnteredForeground() {
        if (this.isStartedFromBackground || this.isTooLateToInitUI || this.firstForegroundTime != null) {
            return;
        }
        this.firstForegroundTime = this.clock.getTime();
        this.experimentTtid.addSubtraces(TraceMetric.newBuilder().setName("_experiment_firstForegrounding").setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(this.firstForegroundTime)).build());
    }

    public synchronized void registerActivityLifecycleCallbacks(Context context) {
        boolean z5;
        try {
            if (this.isRegisteredForLifecycleCallbacks) {
                return;
            }
            ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
                if (!this.systemForegroundCheck && !isAnyAppProcessInForeground(applicationContext)) {
                    z5 = false;
                    this.systemForegroundCheck = z5;
                    this.isRegisteredForLifecycleCallbacks = true;
                    this.appContext = applicationContext;
                }
                z5 = true;
                this.systemForegroundCheck = z5;
                this.isRegisteredForLifecycleCallbacks = true;
                this.appContext = applicationContext;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void unregisterActivityLifecycleCallbacks() {
        if (this.isRegisteredForLifecycleCallbacks) {
            ProcessLifecycleOwner.get().getLifecycle().removeObserver(this);
            ((Application) this.appContext).unregisterActivityLifecycleCallbacks(this);
            this.isRegisteredForLifecycleCallbacks = false;
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    static AppStartTrace getInstance(TransportManager transportManager, Clock clock) {
        if (instance == null) {
            synchronized (AppStartTrace.class) {
                try {
                    if (instance == null) {
                        instance = new AppStartTrace(transportManager, clock, ConfigResolver.getInstance(), new ThreadPoolExecutor(0, 1, MAX_LATENCY_BEFORE_UI_INIT + 10, TimeUnit.SECONDS, new LinkedBlockingQueue()));
                    }
                } finally {
                }
            }
        }
        return instance;
    }
}
