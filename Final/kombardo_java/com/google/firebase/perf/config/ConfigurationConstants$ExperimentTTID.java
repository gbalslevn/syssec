package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
public final class ConfigurationConstants$ExperimentTTID extends ConfigurationFlag<Boolean> {
    private static ConfigurationConstants$ExperimentTTID instance;

    private ConfigurationConstants$ExperimentTTID() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized ConfigurationConstants$ExperimentTTID getInstance() {
        ConfigurationConstants$ExperimentTTID configurationConstants$ExperimentTTID;
        synchronized (ConfigurationConstants$ExperimentTTID.class) {
            try {
                if (instance == null) {
                    instance = new ConfigurationConstants$ExperimentTTID();
                }
                configurationConstants$ExperimentTTID = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return configurationConstants$ExperimentTTID;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Boolean getDefault() {
        return Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getDeviceCacheFlag() {
        return "com.google.firebase.perf.ExperimentTTID";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getMetadataFlag() {
        return "experiment_app_start_ttid";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.perf.config.ConfigurationFlag
    public String getRemoteConfigFlag() {
        return "fpr_experiment_app_start_ttid";
    }
}
