package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$NetworkEventCountForeground extends ConfigurationFlag<Long> {
    private static ConfigurationConstants$NetworkEventCountForeground instance;

    private ConfigurationConstants$NetworkEventCountForeground() {
    }

    public static synchronized ConfigurationConstants$NetworkEventCountForeground getInstance() {
        ConfigurationConstants$NetworkEventCountForeground configurationConstants$NetworkEventCountForeground;
        synchronized (ConfigurationConstants$NetworkEventCountForeground.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$NetworkEventCountForeground();
                }
                configurationConstants$NetworkEventCountForeground = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$NetworkEventCountForeground;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long getDefault() {
        return 700L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.NetworkEventCountForeground";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_rl_network_event_count_fg";
    }
}
