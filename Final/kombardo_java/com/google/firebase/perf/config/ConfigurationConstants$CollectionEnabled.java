package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$CollectionEnabled extends ConfigurationFlag<Boolean> {
    private static ConfigurationConstants$CollectionEnabled instance;

    private ConfigurationConstants$CollectionEnabled() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized ConfigurationConstants$CollectionEnabled getInstance() {
        ConfigurationConstants$CollectionEnabled configurationConstants$CollectionEnabled;
        synchronized (ConfigurationConstants$CollectionEnabled.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$CollectionEnabled();
                }
                configurationConstants$CollectionEnabled = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$CollectionEnabled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "isEnabled";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getMetadataFlag() {
        return "firebase_performance_collection_enabled";
    }
}
