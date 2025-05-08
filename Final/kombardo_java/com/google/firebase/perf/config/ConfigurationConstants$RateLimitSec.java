package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$RateLimitSec extends ConfigurationFlag<Long> {
    private static ConfigurationConstants$RateLimitSec instance;

    private ConfigurationConstants$RateLimitSec() {
    }

    public static synchronized ConfigurationConstants$RateLimitSec getInstance() {
        ConfigurationConstants$RateLimitSec configurationConstants$RateLimitSec;
        synchronized (ConfigurationConstants$RateLimitSec.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$RateLimitSec();
                }
                configurationConstants$RateLimitSec = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$RateLimitSec;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long getDefault() {
        return 600L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.TimeLimitSec";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_rl_time_limit_sec";
    }
}
