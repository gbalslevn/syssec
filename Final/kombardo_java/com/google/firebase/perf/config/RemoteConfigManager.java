package com.google.firebase.perf.config;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Keep;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.StartupTime;
import com.google.firebase.inject.Provider;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Keep
/* loaded from: classes2.dex */
public class RemoteConfigManager {
    private static final long FETCH_NEVER_HAPPENED_TIMESTAMP_MS = 0;
    private static final String FIREPERF_FRC_NAMESPACE_NAME = "fireperf";
    private static final long MIN_APP_START_CONFIG_FETCH_DELAY_MS = 5000;
    private static final int RANDOM_APP_START_CONFIG_FETCH_DELAY_MS = 25000;
    private final ConcurrentHashMap<String, FirebaseRemoteConfigValue> allRcConfigMap;
    private final long appStartConfigFetchDelayInMs;
    private final long appStartTimeInMs;
    private final DeviceCacheManager cache;
    private final Executor executor;
    private FirebaseRemoteConfig firebaseRemoteConfig;
    private long firebaseRemoteConfigLastFetchTimestampMs;
    private Provider<RemoteConfigComponent> firebaseRemoteConfigProvider;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static final RemoteConfigManager instance = new RemoteConfigManager();
    private static final long TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS = TimeUnit.HOURS.toMillis(12);

    @SuppressLint({"ThreadPoolCreation"})
    private RemoteConfigManager() {
        this(DeviceCacheManager.getInstance(), new ThreadPoolExecutor(0, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue()), null, MIN_APP_START_CONFIG_FETCH_DELAY_MS + new Random().nextInt(RANDOM_APP_START_CONFIG_FETCH_DELAY_MS), getInitialStartupMillis());
    }

    static long getInitialStartupMillis() {
        StartupTime startupTime;
        try {
            startupTime = (StartupTime) FirebaseApp.getInstance().get(StartupTime.class);
        } catch (IllegalStateException unused) {
            logger.debug("Unable to get StartupTime instance.");
            startupTime = null;
        }
        return startupTime != null ? startupTime.getEpochMillis() : System.currentTimeMillis();
    }

    public static RemoteConfigManager getInstance() {
        return instance;
    }

    private FirebaseRemoteConfigValue getRemoteConfigValue(String str) {
        triggerRemoteConfigFetchIfNecessary();
        if (!isFirebaseRemoteConfigAvailable() || !this.allRcConfigMap.containsKey(str)) {
            return null;
        }
        FirebaseRemoteConfigValue firebaseRemoteConfigValue = this.allRcConfigMap.get(str);
        if (firebaseRemoteConfigValue.getSource() != 2) {
            return null;
        }
        logger.debug("Fetched value: '%s' for key: '%s' from Firebase Remote Config.", firebaseRemoteConfigValue.asString(), str);
        return firebaseRemoteConfigValue;
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    private boolean hasAppStartConfigFetchDelayElapsed(long j5) {
        return j5 - this.appStartTimeInMs >= this.appStartConfigFetchDelayInMs;
    }

    private boolean hasLastFetchBecomeStale(long j5) {
        return j5 - this.firebaseRemoteConfigLastFetchTimestampMs > TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$0(Boolean bool) {
        syncConfigValues(this.firebaseRemoteConfig.getAll());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$1(Exception exc) {
        logger.warn("Call to Remote Config failed: %s. This may cause a degraded experience with Firebase Performance. Please reach out to Firebase Support https://firebase.google.com/support/", exc);
        this.firebaseRemoteConfigLastFetchTimestampMs = 0L;
    }

    private boolean shouldFetchAndActivateRemoteConfigValues() {
        long currentSystemTimeMillis = getCurrentSystemTimeMillis();
        return hasAppStartConfigFetchDelayElapsed(currentSystemTimeMillis) && hasLastFetchBecomeStale(currentSystemTimeMillis);
    }

    private void triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch() {
        this.firebaseRemoteConfigLastFetchTimestampMs = getCurrentSystemTimeMillis();
        this.firebaseRemoteConfig.fetchAndActivate().addOnSuccessListener(this.executor, new OnSuccessListener() { // from class: com.google.firebase.perf.config.b
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                RemoteConfigManager.this.lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$0((Boolean) obj);
            }
        }).addOnFailureListener(this.executor, new OnFailureListener() { // from class: com.google.firebase.perf.config.c
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                RemoteConfigManager.this.lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$1(exc);
            }
        });
    }

    private void triggerRemoteConfigFetchIfNecessary() {
        if (isFirebaseRemoteConfigAvailable()) {
            if (this.allRcConfigMap.isEmpty()) {
                this.allRcConfigMap.putAll(this.firebaseRemoteConfig.getAll());
            }
            if (shouldFetchAndActivateRemoteConfigValues()) {
                triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch();
            }
        }
    }

    public Optional<Boolean> getBoolean(String str) {
        if (str == null) {
            logger.debug("The key to get Remote Config boolean value is null.");
            return Optional.absent();
        }
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return Optional.of(Boolean.valueOf(remoteConfigValue.asBoolean()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.asString().isEmpty()) {
                    logger.debug("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.asString(), str);
                }
            }
        }
        return Optional.absent();
    }

    protected long getCurrentSystemTimeMillis() {
        return System.currentTimeMillis();
    }

    public Optional<Double> getDouble(String str) {
        if (str == null) {
            logger.debug("The key to get Remote Config double value is null.");
            return Optional.absent();
        }
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return Optional.of(Double.valueOf(remoteConfigValue.asDouble()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.asString().isEmpty()) {
                    logger.debug("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.asString(), str);
                }
            }
        }
        return Optional.absent();
    }

    public Optional<Long> getLong(String str) {
        if (str == null) {
            logger.debug("The key to get Remote Config long value is null.");
            return Optional.absent();
        }
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return Optional.of(Long.valueOf(remoteConfigValue.asLong()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.asString().isEmpty()) {
                    logger.debug("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.asString(), str);
                }
            }
        }
        return Optional.absent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getRemoteConfigValueOrDefault(String str, T t5) {
        Object obj;
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue == null) {
            return t5;
        }
        try {
            if (t5 instanceof Boolean) {
                obj = Boolean.valueOf(remoteConfigValue.asBoolean());
            } else if (t5 instanceof Double) {
                obj = Double.valueOf(remoteConfigValue.asDouble());
            } else {
                if (!(t5 instanceof Long) && !(t5 instanceof Integer)) {
                    if (!(t5 instanceof String)) {
                        T t6 = (T) remoteConfigValue.asString();
                        try {
                            logger.debug("No matching type found for the defaultValue: '%s', using String.", t5);
                            return t6;
                        } catch (IllegalArgumentException unused) {
                            t5 = t6;
                            if (remoteConfigValue.asString().isEmpty()) {
                                return t5;
                            }
                            logger.debug("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.asString(), str);
                            return t5;
                        }
                    }
                    obj = remoteConfigValue.asString();
                }
                obj = Long.valueOf(remoteConfigValue.asLong());
            }
            return obj;
        } catch (IllegalArgumentException unused2) {
        }
    }

    public Optional<String> getString(String str) {
        if (str == null) {
            logger.debug("The key to get Remote Config String value is null.");
            return Optional.absent();
        }
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        return remoteConfigValue != null ? Optional.of(remoteConfigValue.asString()) : Optional.absent();
    }

    public boolean isFirebaseRemoteConfigAvailable() {
        Provider<RemoteConfigComponent> provider;
        RemoteConfigComponent remoteConfigComponent;
        if (this.firebaseRemoteConfig == null && (provider = this.firebaseRemoteConfigProvider) != null && (remoteConfigComponent = provider.get()) != null) {
            this.firebaseRemoteConfig = remoteConfigComponent.get(FIREPERF_FRC_NAMESPACE_NAME);
        }
        return this.firebaseRemoteConfig != null;
    }

    public boolean isLastFetchFailed() {
        FirebaseRemoteConfig firebaseRemoteConfig = this.firebaseRemoteConfig;
        return firebaseRemoteConfig == null || firebaseRemoteConfig.getInfo().getLastFetchStatus() == 1 || this.firebaseRemoteConfig.getInfo().getLastFetchStatus() == 2;
    }

    public void setFirebaseRemoteConfigProvider(Provider<RemoteConfigComponent> provider) {
        this.firebaseRemoteConfigProvider = provider;
    }

    protected void syncConfigValues(Map<String, FirebaseRemoteConfigValue> map) {
        this.allRcConfigMap.putAll(map);
        for (String str : this.allRcConfigMap.keySet()) {
            if (!map.containsKey(str)) {
                this.allRcConfigMap.remove(str);
            }
        }
        ConfigurationConstants$ExperimentTTID configurationConstants$ExperimentTTID = ConfigurationConstants$ExperimentTTID.getInstance();
        FirebaseRemoteConfigValue firebaseRemoteConfigValue = this.allRcConfigMap.get(configurationConstants$ExperimentTTID.getRemoteConfigFlag());
        if (firebaseRemoteConfigValue == null) {
            logger.debug("ExperimentTTID remote config flag does not exist.");
            return;
        }
        try {
            this.cache.setValue(configurationConstants$ExperimentTTID.getDeviceCacheFlag(), firebaseRemoteConfigValue.asBoolean());
        } catch (Exception unused) {
            logger.debug("ExperimentTTID remote config flag has invalid value, expected boolean.");
        }
    }

    RemoteConfigManager(DeviceCacheManager deviceCacheManager, Executor executor, FirebaseRemoteConfig firebaseRemoteConfig, long j5, long j6) {
        ConcurrentHashMap<String, FirebaseRemoteConfigValue> concurrentHashMap;
        this.firebaseRemoteConfigLastFetchTimestampMs = 0L;
        this.cache = deviceCacheManager;
        this.executor = executor;
        this.firebaseRemoteConfig = firebaseRemoteConfig;
        if (firebaseRemoteConfig == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap = new ConcurrentHashMap<>(firebaseRemoteConfig.getAll());
        }
        this.allRcConfigMap = concurrentHashMap;
        this.appStartTimeInMs = j6;
        this.appStartConfigFetchDelayInMs = j5;
    }
}
