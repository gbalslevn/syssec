package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$NetworkRequestSamplingRate extends ConfigurationFlag<Double> {
    private static ConfigurationConstants$NetworkRequestSamplingRate instance;

    private ConfigurationConstants$NetworkRequestSamplingRate() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized ConfigurationConstants$NetworkRequestSamplingRate getInstance() {
        ConfigurationConstants$NetworkRequestSamplingRate configurationConstants$NetworkRequestSamplingRate;
        synchronized (ConfigurationConstants$NetworkRequestSamplingRate.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$NetworkRequestSamplingRate();
                }
                configurationConstants$NetworkRequestSamplingRate = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$NetworkRequestSamplingRate;
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
        return "com.google.firebase.perf.NetworkRequestSamplingRate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_vc_network_request_sampling_rate";
    }
}
