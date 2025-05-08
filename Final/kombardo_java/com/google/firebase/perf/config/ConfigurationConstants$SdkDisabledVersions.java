package com.google.firebase.perf.config;

import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$SdkDisabledVersions extends ConfigurationFlag<String> {
    private static ConfigurationConstants$SdkDisabledVersions instance;

    protected ConfigurationConstants$SdkDisabledVersions() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized ConfigurationConstants$SdkDisabledVersions getInstance() {
        ConfigurationConstants$SdkDisabledVersions configurationConstants$SdkDisabledVersions;
        synchronized (ConfigurationConstants$SdkDisabledVersions.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$SdkDisabledVersions();
                }
                configurationConstants$SdkDisabledVersions = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$SdkDisabledVersions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getDefault() {
        return BuildConfig.FLAVOR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.SdkDisabledVersions";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_disabled_android_versions";
    }
}
