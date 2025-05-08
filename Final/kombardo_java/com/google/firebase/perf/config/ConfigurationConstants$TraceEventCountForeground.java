package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$TraceEventCountForeground extends ConfigurationFlag<Long> {
    private static ConfigurationConstants$TraceEventCountForeground instance;

    private ConfigurationConstants$TraceEventCountForeground() {
    }

    public static synchronized ConfigurationConstants$TraceEventCountForeground getInstance() {
        ConfigurationConstants$TraceEventCountForeground configurationConstants$TraceEventCountForeground;
        synchronized (ConfigurationConstants$TraceEventCountForeground.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$TraceEventCountForeground();
                }
                configurationConstants$TraceEventCountForeground = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$TraceEventCountForeground;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Long getDefault() {
        return 300L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.TraceEventCountForeground";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_rl_trace_event_count_fg";
    }
}
