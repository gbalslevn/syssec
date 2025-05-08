package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$NetworkEventCountBackground extends ConfigurationFlag<Long> {
    private static ConfigurationConstants$NetworkEventCountBackground instance;

    private ConfigurationConstants$NetworkEventCountBackground() {
    }

    public static synchronized ConfigurationConstants$NetworkEventCountBackground getInstance() {
        ConfigurationConstants$NetworkEventCountBackground configurationConstants$NetworkEventCountBackground;
        synchronized (ConfigurationConstants$NetworkEventCountBackground.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$NetworkEventCountBackground();
                }
                configurationConstants$NetworkEventCountBackground = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$NetworkEventCountBackground;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long getDefault() {
        return 70L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.NetworkEventCountBackground";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_rl_network_event_count_bg";
    }
}
