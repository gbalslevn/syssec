package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$CollectionDeactivated extends ConfigurationFlag<Boolean> {
    private static ConfigurationConstants$CollectionDeactivated instance;

    private ConfigurationConstants$CollectionDeactivated() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized ConfigurationConstants$CollectionDeactivated getInstance() {
        ConfigurationConstants$CollectionDeactivated configurationConstants$CollectionDeactivated;
        synchronized (ConfigurationConstants$CollectionDeactivated.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$CollectionDeactivated();
                }
                configurationConstants$CollectionDeactivated = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$CollectionDeactivated;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Boolean getDefault() {
        return Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getMetadataFlag() {
        return "firebase_performance_collection_deactivated";
    }
}
