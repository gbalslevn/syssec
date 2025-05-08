package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {
    private static ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs instance;

    private ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs() {
    }

    public static synchronized ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs getInstance() {
        ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs;
        synchronized (ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$SessionsCpuCaptureFrequencyBackgroundMs();
                }
                configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$SessionsCpuCaptureFrequencyBackgroundMs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long getDefault() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getMetadataFlag() {
        return "sessions_cpu_capture_frequency_bg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_session_gauge_cpu_capture_frequency_bg_ms";
    }
}
