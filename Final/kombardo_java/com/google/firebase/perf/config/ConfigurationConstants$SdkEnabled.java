package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$SdkEnabled extends ConfigurationFlag<Boolean> {
    private static ConfigurationConstants$SdkEnabled instance;

    protected ConfigurationConstants$SdkEnabled() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized ConfigurationConstants$SdkEnabled getInstance() {
        ConfigurationConstants$SdkEnabled configurationConstants$SdkEnabled;
        synchronized (ConfigurationConstants$SdkEnabled.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$SdkEnabled();
                }
                configurationConstants$SdkEnabled = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$SdkEnabled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Boolean getDefault() {
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SdkEnabled";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_enabled";
    }
}
