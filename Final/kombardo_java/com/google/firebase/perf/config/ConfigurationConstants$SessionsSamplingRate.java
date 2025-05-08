package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$SessionsSamplingRate extends ConfigurationFlag<Double> {
    private static ConfigurationConstants$SessionsSamplingRate instance;

    private ConfigurationConstants$SessionsSamplingRate() {
    }

    public static synchronized ConfigurationConstants$SessionsSamplingRate getInstance() {
        ConfigurationConstants$SessionsSamplingRate configurationConstants$SessionsSamplingRate;
        synchronized (ConfigurationConstants$SessionsSamplingRate.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$SessionsSamplingRate();
                }
                configurationConstants$SessionsSamplingRate = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$SessionsSamplingRate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Double getDefault() {
        return Double.valueOf(0.01d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Double getDefaultOnRcFetchFail() {
        return Double.valueOf(getDefault().doubleValue() / 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SessionSamplingRate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getMetadataFlag() {
        return "sessions_sampling_percentage";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_vc_session_sampling_rate";
    }
}
