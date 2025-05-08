package com.google.firebase.perf.transport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.logging.ConsoleUrlGenerator;
import com.google.firebase.perf.metrics.validator.PerfMetricValidator;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Constants$CounterNames;
import com.google.firebase.perf.util.Rate;
import com.google.firebase.perf.v1.AndroidApplicationInfo;
import com.google.firebase.perf.v1.ApplicationInfo;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.perf.v1.PerfMetricOrBuilder;
import com.google.firebase.perf.v1.TraceMetric;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class TransportManager implements AppStateMonitor.AppStateCallback {
    private static final int CORE_POOL_SIZE = 0;
    private static final String KEY_AVAILABLE_GAUGES_FOR_CACHING = "KEY_AVAILABLE_GAUGES_FOR_CACHING";
    private static final String KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING = "KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING";
    private static final String KEY_AVAILABLE_TRACES_FOR_CACHING = "KEY_AVAILABLE_TRACES_FOR_CACHING";
    private static final int MAX_GAUGE_METRICS_CACHE_SIZE = 50;
    private static final int MAX_NETWORK_REQUEST_METRICS_CACHE_SIZE = 50;
    private static final int MAX_POOL_SIZE = 1;
    private static final int MAX_TRACE_METRICS_CACHE_SIZE = 50;
    private Context appContext;
    private AppStateMonitor appStateMonitor;
    private ApplicationInfo.Builder applicationInfoBuilder;
    private final Map<String, Integer> cacheMap;
    private ConfigResolver configResolver;
    private FirebaseApp firebaseApp;
    private FirebaseInstallationsApi firebaseInstallationsApi;
    private FirebasePerformance firebasePerformance;
    private FlgTransport flgTransport;
    private Provider<TransportFactory> flgTransportFactoryProvider;
    private String packageName;
    private String projectId;
    private RateLimiter rateLimiter;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static final TransportManager instance = new TransportManager();
    private final ConcurrentLinkedQueue<PendingPerfEvent> pendingEventsQueue = new ConcurrentLinkedQueue<>();
    private final AtomicBoolean isTransportInitialized = new AtomicBoolean(false);
    private boolean isForegroundState = false;
    private ExecutorService executorService = new ThreadPoolExecutor(0, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());

    @SuppressLint({"ThreadPoolCreation"})
    private TransportManager() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.cacheMap = concurrentHashMap;
        concurrentHashMap.put(KEY_AVAILABLE_TRACES_FOR_CACHING, 50);
        concurrentHashMap.put(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING, 50);
        concurrentHashMap.put(KEY_AVAILABLE_GAUGES_FOR_CACHING, 50);
    }

    private void dispatchLog(PerfMetric perfMetric) {
        if (perfMetric.hasTraceMetric()) {
            logger.info("Logging %s. In a minute, visit the Firebase console to view your data: %s", getLogcatMsg(perfMetric), getConsoleUrl(perfMetric.getTraceMetric()));
        } else {
            logger.info("Logging %s", getLogcatMsg(perfMetric));
        }
        this.flgTransport.log(perfMetric);
    }

    private void finishInitialization() {
        this.appStateMonitor.registerForAppState(new WeakReference<>(instance));
        ApplicationInfo.Builder newBuilder = ApplicationInfo.newBuilder();
        this.applicationInfoBuilder = newBuilder;
        newBuilder.setGoogleAppId(this.firebaseApp.getOptions().getApplicationId()).setAndroidAppInfo(AndroidApplicationInfo.newBuilder().setPackageName(this.packageName).setSdkVersion(BuildConfig.FIREPERF_VERSION_NAME).setVersionName(getVersionName(this.appContext)));
        this.isTransportInitialized.set(true);
        while (!this.pendingEventsQueue.isEmpty()) {
            final PendingPerfEvent poll = this.pendingEventsQueue.poll();
            if (poll != null) {
                this.executorService.execute(new Runnable() { // from class: com.google.firebase.perf.transport.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        TransportManager.this.lambda$finishInitialization$0(poll);
                    }
                });
            }
        }
    }

    private String getConsoleUrl(TraceMetric traceMetric) {
        String name = traceMetric.getName();
        return name.startsWith("_st_") ? ConsoleUrlGenerator.generateScreenTraceUrl(this.projectId, this.packageName, name) : ConsoleUrlGenerator.generateCustomTraceUrl(this.projectId, this.packageName, name);
    }

    private Map<String, String> getGlobalCustomAttributes() {
        updateFirebasePerformanceIfPossibleAndNeeded();
        FirebasePerformance firebasePerformance = this.firebasePerformance;
        return firebasePerformance != null ? firebasePerformance.getAttributes() : Collections.emptyMap();
    }

    public static TransportManager getInstance() {
        return instance;
    }

    private static String getLogcatMsg(PerfMetricOrBuilder perfMetricOrBuilder) {
        if (perfMetricOrBuilder.hasTraceMetric()) {
            return getLogcatMsg(perfMetricOrBuilder.getTraceMetric());
        }
        if (perfMetricOrBuilder.hasNetworkRequestMetric()) {
            return getLogcatMsg(perfMetricOrBuilder.getNetworkRequestMetric());
        }
        if (perfMetricOrBuilder.hasGaugeMetric()) {
            return getLogcatMsg(perfMetricOrBuilder.getGaugeMetric());
        }
        return "log";
    }

    private static String getVersionName(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return str == null ? org.conscrypt.BuildConfig.FLAVOR : str;
        } catch (PackageManager.NameNotFoundException unused) {
            return org.conscrypt.BuildConfig.FLAVOR;
        }
    }

    private void incrementDropCount(PerfMetric perfMetric) {
        if (perfMetric.hasTraceMetric()) {
            this.appStateMonitor.incrementCount(Constants$CounterNames.TRACE_EVENT_RATE_LIMITED.toString(), 1L);
        } else if (perfMetric.hasNetworkRequestMetric()) {
            this.appStateMonitor.incrementCount(Constants$CounterNames.NETWORK_TRACE_EVENT_RATE_LIMITED.toString(), 1L);
        }
    }

    private boolean isAllowedToCache(PerfMetricOrBuilder perfMetricOrBuilder) {
        Integer num = this.cacheMap.get(KEY_AVAILABLE_TRACES_FOR_CACHING);
        int intValue = num.intValue();
        Integer num2 = this.cacheMap.get(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING);
        int intValue2 = num2.intValue();
        Integer num3 = this.cacheMap.get(KEY_AVAILABLE_GAUGES_FOR_CACHING);
        int intValue3 = num3.intValue();
        if (perfMetricOrBuilder.hasTraceMetric() && intValue > 0) {
            this.cacheMap.put(KEY_AVAILABLE_TRACES_FOR_CACHING, Integer.valueOf(intValue - 1));
            return true;
        }
        if (perfMetricOrBuilder.hasNetworkRequestMetric() && intValue2 > 0) {
            this.cacheMap.put(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING, Integer.valueOf(intValue2 - 1));
            return true;
        }
        if (!perfMetricOrBuilder.hasGaugeMetric() || intValue3 <= 0) {
            logger.debug("%s is not allowed to cache. Cache exhausted the limit (availableTracesForCaching: %d, availableNetworkRequestsForCaching: %d, availableGaugesForCaching: %d).", getLogcatMsg(perfMetricOrBuilder), num, num2, num3);
            return false;
        }
        this.cacheMap.put(KEY_AVAILABLE_GAUGES_FOR_CACHING, Integer.valueOf(intValue3 - 1));
        return true;
    }

    private boolean isAllowedToDispatch(PerfMetric perfMetric) {
        if (!this.configResolver.isPerformanceMonitoringEnabled()) {
            logger.info("Performance collection is not enabled, dropping %s", getLogcatMsg(perfMetric));
            return false;
        }
        if (!perfMetric.getApplicationInfo().hasAppInstanceId()) {
            logger.warn("App Instance ID is null or empty, dropping %s", getLogcatMsg(perfMetric));
            return false;
        }
        if (!PerfMetricValidator.isValid(perfMetric, this.appContext)) {
            logger.warn("Unable to process the PerfMetric (%s) due to missing or invalid values. See earlier log statements for additional information on the specific missing/invalid values.", getLogcatMsg(perfMetric));
            return false;
        }
        if (!this.rateLimiter.isEventSampled(perfMetric)) {
            incrementDropCount(perfMetric);
            logger.info("Event dropped due to device sampling - %s", getLogcatMsg(perfMetric));
            return false;
        }
        if (!this.rateLimiter.isEventRateLimited(perfMetric)) {
            return true;
        }
        incrementDropCount(perfMetric);
        logger.info("Rate limited (per device) - %s", getLogcatMsg(perfMetric));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finishInitialization$0(PendingPerfEvent pendingPerfEvent) {
        syncLog(pendingPerfEvent.perfMetricBuilder, pendingPerfEvent.appState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$log$2(TraceMetric traceMetric, ApplicationProcessState applicationProcessState) {
        syncLog(PerfMetric.newBuilder().setTraceMetric(traceMetric), applicationProcessState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$log$3(NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState) {
        syncLog(PerfMetric.newBuilder().setNetworkRequestMetric(networkRequestMetric), applicationProcessState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$log$4(GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState) {
        syncLog(PerfMetric.newBuilder().setGaugeMetric(gaugeMetric), applicationProcessState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUpdateAppState$1() {
        this.rateLimiter.changeRate(this.isForegroundState);
    }

    private PerfMetric setApplicationInfoAndBuild(PerfMetric.Builder builder, ApplicationProcessState applicationProcessState) {
        updateFirebaseInstallationIdIfPossibleAndNeeded();
        ApplicationInfo.Builder applicationProcessState2 = this.applicationInfoBuilder.setApplicationProcessState(applicationProcessState);
        if (builder.hasTraceMetric() || builder.hasNetworkRequestMetric()) {
            applicationProcessState2 = applicationProcessState2.m2922clone().putAllCustomAttributes(getGlobalCustomAttributes());
        }
        return builder.setApplicationInfo(applicationProcessState2).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncInit() {
        Context applicationContext = this.firebaseApp.getApplicationContext();
        this.appContext = applicationContext;
        this.packageName = applicationContext.getPackageName();
        this.configResolver = ConfigResolver.getInstance();
        this.rateLimiter = new RateLimiter(this.appContext, new Rate(100L, 1L, TimeUnit.MINUTES), 500L);
        this.appStateMonitor = AppStateMonitor.getInstance();
        this.flgTransport = new FlgTransport(this.flgTransportFactoryProvider, this.configResolver.getAndCacheLogSourceName());
        finishInitialization();
    }

    private void syncLog(PerfMetric.Builder builder, ApplicationProcessState applicationProcessState) {
        if (!isInitialized()) {
            if (isAllowedToCache(builder)) {
                logger.debug("Transport is not initialized yet, %s will be queued for to be dispatched later", getLogcatMsg(builder));
                this.pendingEventsQueue.add(new PendingPerfEvent(builder, applicationProcessState));
                return;
            }
            return;
        }
        PerfMetric applicationInfoAndBuild = setApplicationInfoAndBuild(builder, applicationProcessState);
        if (isAllowedToDispatch(applicationInfoAndBuild)) {
            dispatchLog(applicationInfoAndBuild);
            SessionManager.getInstance().stopGaugeCollectionIfSessionRunningTooLong();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateFirebaseInstallationIdIfPossibleAndNeeded() {
        String str;
        if (this.configResolver.isPerformanceMonitoringEnabled()) {
            if (!this.applicationInfoBuilder.hasAppInstanceId() || this.isForegroundState) {
                try {
                    str = (String) Tasks.await(this.firebaseInstallationsApi.getId(), 60000L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e5) {
                    logger.error("Task to retrieve Installation Id is interrupted: %s", e5.getMessage());
                    str = null;
                    if (TextUtils.isEmpty(str)) {
                    }
                } catch (ExecutionException e6) {
                    logger.error("Unable to retrieve Installation Id: %s", e6.getMessage());
                    str = null;
                    if (TextUtils.isEmpty(str)) {
                    }
                } catch (TimeoutException e7) {
                    logger.error("Task to retrieve Installation Id is timed out: %s", e7.getMessage());
                    str = null;
                    if (TextUtils.isEmpty(str)) {
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    this.applicationInfoBuilder.setAppInstanceId(str);
                } else {
                    logger.warn("Firebase Installation Id is empty, contact Firebase Support for debugging.");
                }
            }
        }
    }

    private void updateFirebasePerformanceIfPossibleAndNeeded() {
        if (this.firebasePerformance == null && isInitialized()) {
            this.firebasePerformance = FirebasePerformance.getInstance();
        }
    }

    public void initialize(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Provider<TransportFactory> provider) {
        this.firebaseApp = firebaseApp;
        this.projectId = firebaseApp.getOptions().getProjectId();
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.flgTransportFactoryProvider = provider;
        this.executorService.execute(new Runnable() { // from class: V0.f
            @Override // java.lang.Runnable
            public final void run() {
                TransportManager.this.syncInit();
            }
        });
    }

    public boolean isInitialized() {
        return this.isTransportInitialized.get();
    }

    public void log(final TraceMetric traceMetric, final ApplicationProcessState applicationProcessState) {
        this.executorService.execute(new Runnable() { // from class: V0.d
            @Override // java.lang.Runnable
            public final void run() {
                TransportManager.this.lambda$log$2(traceMetric, applicationProcessState);
            }
        });
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor.AppStateCallback
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        this.isForegroundState = applicationProcessState == ApplicationProcessState.FOREGROUND;
        if (isInitialized()) {
            this.executorService.execute(new Runnable() { // from class: V0.b
                @Override // java.lang.Runnable
                public final void run() {
                    TransportManager.this.lambda$onUpdateAppState$1();
                }
            });
        }
    }

    public void log(final NetworkRequestMetric networkRequestMetric, final ApplicationProcessState applicationProcessState) {
        this.executorService.execute(new Runnable() { // from class: V0.e
            @Override // java.lang.Runnable
            public final void run() {
                TransportManager.this.lambda$log$3(networkRequestMetric, applicationProcessState);
            }
        });
    }

    public void log(final GaugeMetric gaugeMetric, final ApplicationProcessState applicationProcessState) {
        this.executorService.execute(new Runnable() { // from class: V0.c
            @Override // java.lang.Runnable
            public final void run() {
                TransportManager.this.lambda$log$4(gaugeMetric, applicationProcessState);
            }
        });
    }

    private static String getLogcatMsg(TraceMetric traceMetric) {
        return String.format(Locale.ENGLISH, "trace metric: %s (duration: %sms)", traceMetric.getName(), new DecimalFormat("#.####").format(traceMetric.getDurationUs() / 1000.0d));
    }

    private static String getLogcatMsg(NetworkRequestMetric networkRequestMetric) {
        String str;
        long timeToResponseCompletedUs = networkRequestMetric.hasTimeToResponseCompletedUs() ? networkRequestMetric.getTimeToResponseCompletedUs() : 0L;
        if (networkRequestMetric.hasHttpResponseCode()) {
            str = String.valueOf(networkRequestMetric.getHttpResponseCode());
        } else {
            str = "UNKNOWN";
        }
        return String.format(Locale.ENGLISH, "network request trace: %s (responseCode: %s, responseTime: %sms)", networkRequestMetric.getUrl(), str, new DecimalFormat("#.####").format(timeToResponseCompletedUs / 1000.0d));
    }

    private static String getLogcatMsg(GaugeMetric gaugeMetric) {
        return String.format(Locale.ENGLISH, "gauges (hasMetadata: %b, cpuGaugeCount: %d, memoryGaugeCount: %d)", Boolean.valueOf(gaugeMetric.hasGaugeMetadata()), Integer.valueOf(gaugeMetric.getCpuMetricReadingsCount()), Integer.valueOf(gaugeMetric.getAndroidMemoryReadingsCount()));
    }
}
