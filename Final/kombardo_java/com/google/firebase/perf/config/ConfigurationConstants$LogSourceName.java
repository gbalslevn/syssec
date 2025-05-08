package com.google.firebase.perf.config;

import com.google.firebase.perf.BuildConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$LogSourceName extends ConfigurationFlag<String> {
    private static final Map<Long, String> LOG_SOURCE_MAP = Collections.unmodifiableMap(new HashMap<Long, String>() { // from class: com.google.firebase.perf.config.ConfigurationConstants$LogSourceName.1
        {
            put(461L, "FIREPERF_AUTOPUSH");
            put(462L, "FIREPERF");
            put(675L, "FIREPERF_INTERNAL_LOW");
            put(676L, "FIREPERF_INTERNAL_HIGH");
        }
    });
    private static ConfigurationConstants$LogSourceName instance;

    private ConfigurationConstants$LogSourceName() {
    }

    public static synchronized ConfigurationConstants$LogSourceName getInstance() {
        ConfigurationConstants$LogSourceName configurationConstants$LogSourceName;
        synchronized (ConfigurationConstants$LogSourceName.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$LogSourceName();
                }
                configurationConstants$LogSourceName = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$LogSourceName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getLogSourceName(long j5) {
        return LOG_SOURCE_MAP.get(Long.valueOf(j5));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isLogSourceKnown(long j5) {
        return LOG_SOURCE_MAP.containsKey(Long.valueOf(j5));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getDefault() {
        return BuildConfig.TRANSPORT_LOG_SRC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.LogSourceName";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_log_source";
    }
}
