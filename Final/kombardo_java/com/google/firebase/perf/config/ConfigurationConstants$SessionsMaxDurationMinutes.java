package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$SessionsMaxDurationMinutes extends ConfigurationFlag<Long> {
    private static ConfigurationConstants$SessionsMaxDurationMinutes instance;

    private ConfigurationConstants$SessionsMaxDurationMinutes() {
    }

    public static synchronized ConfigurationConstants$SessionsMaxDurationMinutes getInstance() {
        ConfigurationConstants$SessionsMaxDurationMinutes configurationConstants$SessionsMaxDurationMinutes;
        synchronized (ConfigurationConstants$SessionsMaxDurationMinutes.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$SessionsMaxDurationMinutes();
                }
                configurationConstants$SessionsMaxDurationMinutes = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$SessionsMaxDurationMinutes;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long getDefault() {
        return 240L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionsMaxDurationMinutes";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getMetadataFlag() {
        return "sessions_max_length_minutes";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_session_max_duration_min";
    }
}
