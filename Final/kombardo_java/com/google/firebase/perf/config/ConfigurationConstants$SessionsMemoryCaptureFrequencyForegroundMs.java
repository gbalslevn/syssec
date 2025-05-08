package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {
    private static ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs instance;

    private ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs() {
    }

    public static synchronized ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs getInstance() {
        ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs;
        synchronized (ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$SessionsMemoryCaptureFrequencyForegroundMs();
                }
                configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$SessionsMemoryCaptureFrequencyForegroundMs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long getDefault() {
        return 100L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long getDefaultOnRcFetchFail() {
        return Long.valueOf(getDefault().longValue() * 3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getMetadataFlag() {
        return "sessions_memory_capture_frequency_fg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_session_gauge_memory_capture_frequency_fg_ms";
    }
}
