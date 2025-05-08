package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$TraceEventCountBackground extends ConfigurationFlag<Long> {
    private static ConfigurationConstants$TraceEventCountBackground instance;

    private ConfigurationConstants$TraceEventCountBackground() {
    }

    public static synchronized ConfigurationConstants$TraceEventCountBackground getInstance() {
        ConfigurationConstants$TraceEventCountBackground configurationConstants$TraceEventCountBackground;
        synchronized (ConfigurationConstants$TraceEventCountBackground.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$TraceEventCountBackground();
                }
                configurationConstants$TraceEventCountBackground = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$TraceEventCountBackground;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long getDefault() {
        return 30L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.TraceEventCountBackground";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_rl_trace_event_count_bg";
    }
}
