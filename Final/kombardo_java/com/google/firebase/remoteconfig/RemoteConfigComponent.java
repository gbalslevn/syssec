package com.google.firebase.remoteconfig;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHandler;
import com.google.firebase.remoteconfig.internal.ConfigSharedPrefsClient;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.google.firebase.remoteconfig.internal.Personalization;
import com.google.firebase.remoteconfig.internal.rollouts.RolloutsStateFactory;
import com.google.firebase.remoteconfig.internal.rollouts.RolloutsStateSubscriptionsHandler;
import com.google.firebase.remoteconfig.interop.FirebaseRemoteConfigInterop;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;
import e.AbstractC0321h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class RemoteConfigComponent implements FirebaseRemoteConfigInterop {
    private static final String FIREBASE_REMOTE_CONFIG_FILE_NAME_PREFIX = "frc";
    private static final String PREFERENCES_FILE_NAME = "settings";
    private final Provider<AnalyticsConnector> analyticsConnector;
    private final String appId;
    private final Context context;
    private Map<String, String> customHeaders;
    private final ScheduledExecutorService executor;
    private final FirebaseABTesting firebaseAbt;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Map<String, FirebaseRemoteConfig> frcNamespaceInstances;
    private static final Clock DEFAULT_CLOCK = DefaultClock.getInstance();
    private static final Random DEFAULT_RANDOM = new Random();
    private static final Map<String, FirebaseRemoteConfig> frcNamespaceInstancesStatic = new HashMap();

    /* loaded from: classes2.dex */
    private static class GlobalBackgroundListener implements BackgroundDetector.BackgroundStateChangeListener {
        private static final AtomicReference<GlobalBackgroundListener> INSTANCE = new AtomicReference<>();

        private GlobalBackgroundListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void ensureBackgroundListenerIsRegistered(Context context) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference<GlobalBackgroundListener> atomicReference = INSTANCE;
            if (atomicReference.get() == null) {
                GlobalBackgroundListener globalBackgroundListener = new GlobalBackgroundListener();
                if (AbstractC0321h.a(atomicReference, null, globalBackgroundListener)) {
                    BackgroundDetector.initialize(application);
                    BackgroundDetector.getInstance().addListener(globalBackgroundListener);
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public void onBackgroundStateChanged(boolean z5) {
            RemoteConfigComponent.notifyRCInstances(z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteConfigComponent(Context context, @Blocking ScheduledExecutorService scheduledExecutorService, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Provider<AnalyticsConnector> provider) {
        this(context, scheduledExecutorService, firebaseApp, firebaseInstallationsApi, firebaseABTesting, provider, true);
    }

    private ConfigCacheClient getCacheClient(String str, String str2) {
        return ConfigCacheClient.getInstance(this.executor, ConfigStorageClient.getInstance(this.context, String.format("%s_%s_%s_%s.json", FIREBASE_REMOTE_CONFIG_FILE_NAME_PREFIX, this.appId, str, str2)));
    }

    private ConfigGetParameterHandler getGetHandler(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        return new ConfigGetParameterHandler(this.executor, configCacheClient, configCacheClient2);
    }

    private static Personalization getPersonalization(FirebaseApp firebaseApp, String str, Provider<AnalyticsConnector> provider) {
        if (isPrimaryApp(firebaseApp) && str.equals("firebase")) {
            return new Personalization(provider);
        }
        return null;
    }

    private RolloutsStateSubscriptionsHandler getRolloutsStateSubscriptionsHandler(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        return new RolloutsStateSubscriptionsHandler(configCacheClient, RolloutsStateFactory.create(configCacheClient, configCacheClient2), this.executor);
    }

    static ConfigSharedPrefsClient getSharedPrefsClient(Context context, String str, String str2) {
        return new ConfigSharedPrefsClient(context.getSharedPreferences(String.format("%s_%s_%s_%s", FIREBASE_REMOTE_CONFIG_FILE_NAME_PREFIX, str, str2, PREFERENCES_FILE_NAME), 0));
    }

    private static boolean isAbtSupported(FirebaseApp firebaseApp, String str) {
        return str.equals("firebase") && isPrimaryApp(firebaseApp);
    }

    private static boolean isPrimaryApp(FirebaseApp firebaseApp) {
        return firebaseApp.getName().equals("[DEFAULT]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnalyticsConnector lambda$getFetchHandler$0() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void notifyRCInstances(boolean z5) {
        synchronized (RemoteConfigComponent.class) {
            Iterator<FirebaseRemoteConfig> it = frcNamespaceInstancesStatic.values().iterator();
            while (it.hasNext()) {
                it.next().setConfigUpdateBackgroundState(z5);
            }
        }
    }

    public synchronized FirebaseRemoteConfig get(String str) {
        ConfigCacheClient cacheClient;
        ConfigCacheClient cacheClient2;
        ConfigCacheClient cacheClient3;
        ConfigSharedPrefsClient sharedPrefsClient;
        ConfigGetParameterHandler getHandler;
        try {
            cacheClient = getCacheClient(str, "fetch");
            cacheClient2 = getCacheClient(str, "activate");
            cacheClient3 = getCacheClient(str, "defaults");
            sharedPrefsClient = getSharedPrefsClient(this.context, this.appId, str);
            getHandler = getGetHandler(cacheClient2, cacheClient3);
            final Personalization personalization = getPersonalization(this.firebaseApp, str, this.analyticsConnector);
            if (personalization != null) {
                getHandler.addListener(new BiConsumer() { // from class: Y0.e
                    @Override // com.google.android.gms.common.util.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        Personalization.this.logArmActive((String) obj, (ConfigContainer) obj2);
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
        return get(this.firebaseApp, str, this.firebaseInstallations, this.firebaseAbt, this.executor, cacheClient, cacheClient2, cacheClient3, getFetchHandler(str, cacheClient, sharedPrefsClient), getHandler, sharedPrefsClient, getRolloutsStateSubscriptionsHandler(cacheClient2, cacheClient3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseRemoteConfig getDefault() {
        return get("firebase");
    }

    synchronized ConfigFetchHandler getFetchHandler(String str, ConfigCacheClient configCacheClient, ConfigSharedPrefsClient configSharedPrefsClient) {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return new ConfigFetchHandler(this.firebaseInstallations, isPrimaryApp(this.firebaseApp) ? this.analyticsConnector : new Provider() { // from class: Y0.f
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                AnalyticsConnector lambda$getFetchHandler$0;
                lambda$getFetchHandler$0 = RemoteConfigComponent.lambda$getFetchHandler$0();
                return lambda$getFetchHandler$0;
            }
        }, this.executor, DEFAULT_CLOCK, DEFAULT_RANDOM, configCacheClient, getFrcBackendApiClient(this.firebaseApp.getOptions().getApiKey(), str, configSharedPrefsClient), configSharedPrefsClient, this.customHeaders);
    }

    ConfigFetchHttpClient getFrcBackendApiClient(String str, String str2, ConfigSharedPrefsClient configSharedPrefsClient) {
        return new ConfigFetchHttpClient(this.context, this.firebaseApp.getOptions().getApplicationId(), str, str2, configSharedPrefsClient.getFetchTimeoutInSeconds(), configSharedPrefsClient.getFetchTimeoutInSeconds());
    }

    synchronized ConfigRealtimeHandler getRealtime(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Context context, String str, ConfigSharedPrefsClient configSharedPrefsClient) {
        return new ConfigRealtimeHandler(firebaseApp, firebaseInstallationsApi, configFetchHandler, configCacheClient, context, str, configSharedPrefsClient, this.executor);
    }

    @Override // com.google.firebase.remoteconfig.interop.FirebaseRemoteConfigInterop
    public void registerRolloutsStateSubscriber(String str, RolloutsStateSubscriber rolloutsStateSubscriber) {
        get(str).getRolloutsStateSubscriptionsHandler().registerRolloutsStateSubscriber(rolloutsStateSubscriber);
    }

    protected RemoteConfigComponent(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Provider<AnalyticsConnector> provider, boolean z5) {
        this.frcNamespaceInstances = new HashMap();
        this.customHeaders = new HashMap();
        this.context = context;
        this.executor = scheduledExecutorService;
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.firebaseAbt = firebaseABTesting;
        this.analyticsConnector = provider;
        this.appId = firebaseApp.getOptions().getApplicationId();
        GlobalBackgroundListener.ensureBackgroundListenerIsRegistered(context);
        if (z5) {
            Tasks.call(scheduledExecutorService, new Callable() { // from class: com.google.firebase.remoteconfig.a
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return RemoteConfigComponent.this.getDefault();
                }
            });
        }
    }

    synchronized FirebaseRemoteConfig get(FirebaseApp firebaseApp, String str, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigSharedPrefsClient configSharedPrefsClient, RolloutsStateSubscriptionsHandler rolloutsStateSubscriptionsHandler) {
        try {
            if (!this.frcNamespaceInstances.containsKey(str)) {
                FirebaseRemoteConfig firebaseRemoteConfig = new FirebaseRemoteConfig(this.context, firebaseApp, firebaseInstallationsApi, isAbtSupported(firebaseApp, str) ? firebaseABTesting : null, executor, configCacheClient, configCacheClient2, configCacheClient3, configFetchHandler, configGetParameterHandler, configSharedPrefsClient, getRealtime(firebaseApp, firebaseInstallationsApi, configFetchHandler, configCacheClient2, this.context, str, configSharedPrefsClient), rolloutsStateSubscriptionsHandler);
                firebaseRemoteConfig.startLoadingConfigsFromDisk();
                this.frcNamespaceInstances.put(str, firebaseRemoteConfig);
                frcNamespaceInstancesStatic.put(str, firebaseRemoteConfig);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.frcNamespaceInstances.get(str);
    }
}
