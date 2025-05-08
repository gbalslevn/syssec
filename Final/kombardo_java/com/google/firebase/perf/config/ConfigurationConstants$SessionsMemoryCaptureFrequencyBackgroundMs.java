package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {
    private static ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs instance;

    private ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs() {
    }

    public static synchronized ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs getInstance() {
        ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs;
        synchronized (ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs();
                }
                configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$SessionsMemoryCaptureFrequencyBackgroundMs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long getDefault() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getMetadataFlag() {
        return "sessions_memory_capture_frequency_bg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_session_gauge_memory_capture_frequency_bg_ms";
    }
}
