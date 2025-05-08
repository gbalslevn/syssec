package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$FragmentSamplingRate extends ConfigurationFlag<Double> {
    private static ConfigurationConstants$FragmentSamplingRate instance;

    private ConfigurationConstants$FragmentSamplingRate() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized ConfigurationConstants$FragmentSamplingRate getInstance() {
        ConfigurationConstants$FragmentSamplingRate configurationConstants$FragmentSamplingRate;
        synchronized (ConfigurationConstants$FragmentSamplingRate.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$FragmentSamplingRate();
                }
                configurationConstants$FragmentSamplingRate = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$FragmentSamplingRate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Double getDefault() {
        return Double.valueOf(0.0d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.FragmentSamplingRate";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getMetadataFlag() {
        return "fragment_sampling_percentage";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_vc_fragment_sampling_rate";
    }
}
