package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$TraceSamplingRate extends ConfigurationFlag<Double> {
    private static ConfigurationConstants$TraceSamplingRate instance;

    private ConfigurationConstants$TraceSamplingRate() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized ConfigurationConstants$TraceSamplingRate getInstance() {
        ConfigurationConstants$TraceSamplingRate configurationConstants$TraceSamplingRate;
        synchronized (ConfigurationConstants$TraceSamplingRate.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$TraceSamplingRate();
                }
                configurationConstants$TraceSamplingRate = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$TraceSamplingRate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Double getDefault() {
        return Double.valueOf(1.0d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Double getDefaultOnRcFetchFail() {
        return Double.valueOf(getDefault().doubleValue() / 1000.0d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.TraceSamplingRate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_vc_trace_sampling_rate";
    }
}
