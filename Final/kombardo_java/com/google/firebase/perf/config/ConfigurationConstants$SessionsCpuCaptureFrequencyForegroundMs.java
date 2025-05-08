package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {
    private static ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs instance;

    private ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs() {
    }

    public static synchronized ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs getInstance() {
        ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs configurationConstants$SessionsCpuCaptureFrequencyForegroundMs;
        synchronized (ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$SessionsCpuCaptureFrequencyForegroundMs();
                }
                configurationConstants$SessionsCpuCaptureFrequencyForegroundMs = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$SessionsCpuCaptureFrequencyForegroundMs;
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
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getMetadataFlag() {
        return "sessions_cpu_capture_frequency_fg_ms";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_session_gauge_cpu_capture_frequency_fg_ms";
    }
}
