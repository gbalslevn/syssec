package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigInfoImpl implements FirebaseRemoteConfigInfo {
    private final FirebaseRemoteConfigSettings configSettings;
    private final int lastFetchStatus;
    private final long lastSuccessfulFetchTimeInMillis;

    /* loaded from: classes2.dex */
    public static class Builder {
        private FirebaseRemoteConfigSettings builderConfigSettings;
        private int builderLastFetchStatus;
        private long builderLastSuccessfulFetchTimeInMillis;

        public FirebaseRemoteConfigInfoImpl build() {
            return new FirebaseRemoteConfigInfoImpl(this.builderLastSuccessfulFetchTimeInMillis, this.builderLastFetchStatus, this.builderConfigSettings);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder withConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
            this.builderConfigSettings = firebaseRemoteConfigSettings;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder withLastFetchStatus(int i5) {
            this.builderLastFetchStatus = i5;
            return this;
        }

        public Builder withLastSuccessfulFetchTimeInMillis(long j5) {
            this.builderLastSuccessfulFetchTimeInMillis = j5;
            return this;
        }

        private Builder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Builder newBuilder() {
        return new Builder();
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo
    public int getLastFetchStatus() {
        return this.lastFetchStatus;
    }

    private FirebaseRemoteConfigInfoImpl(long j5, int i5, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        this.lastSuccessfulFetchTimeInMillis = j5;
        this.lastFetchStatus = i5;
        this.configSettings = firebaseRemoteConfigSettings;
    }
}
