package com.google.firebase.installations;

import com.google.firebase.installations.InstallationTokenResult;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
final class AutoValue_InstallationTokenResult extends InstallationTokenResult {
    private final String token;
    private final long tokenCreationTimestamp;
    private final long tokenExpirationTimestamp;

    /* loaded from: classes2.dex */
    static final class Builder extends InstallationTokenResult.Builder {
        private String token;
        private Long tokenCreationTimestamp;
        private Long tokenExpirationTimestamp;

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult build() {
            String str = this.token;
            String str2 = BuildConfig.FLAVOR;
            if (str == null) {
                str2 = BuildConfig.FLAVOR + " token";
            }
            if (this.tokenExpirationTimestamp == null) {
                str2 = str2 + " tokenExpirationTimestamp";
            }
            if (this.tokenCreationTimestamp == null) {
                str2 = str2 + " tokenCreationTimestamp";
            }
            if (str2.isEmpty()) {
                return new AutoValue_InstallationTokenResult(this.token, this.tokenExpirationTimestamp.longValue(), this.tokenCreationTimestamp.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult.Builder setToken(String str) {
            if (str == null) {
                throw new NullPointerException("Null token");
            }
            this.token = str;
            return this;
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult.Builder setTokenCreationTimestamp(long j5) {
            this.tokenCreationTimestamp = Long.valueOf(j5);
            return this;
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public InstallationTokenResult.Builder setTokenExpirationTimestamp(long j5) {
            this.tokenExpirationTimestamp = Long.valueOf(j5);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationTokenResult)) {
            return false;
        }
        InstallationTokenResult installationTokenResult = (InstallationTokenResult) obj;
        return this.token.equals(installationTokenResult.getToken()) && this.tokenExpirationTimestamp == installationTokenResult.getTokenExpirationTimestamp() && this.tokenCreationTimestamp == installationTokenResult.getTokenCreationTimestamp();
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public String getToken() {
        return this.token;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public long getTokenCreationTimestamp() {
        return this.tokenCreationTimestamp;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public long getTokenExpirationTimestamp() {
        return this.tokenExpirationTimestamp;
    }

    public int hashCode() {
        int hashCode = (this.token.hashCode() ^ 1000003) * 1000003;
        long j5 = this.tokenExpirationTimestamp;
        long j6 = this.tokenCreationTimestamp;
        return ((hashCode ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.token + ", tokenExpirationTimestamp=" + this.tokenExpirationTimestamp + ", tokenCreationTimestamp=" + this.tokenCreationTimestamp + "}";
    }

    private AutoValue_InstallationTokenResult(String str, long j5, long j6) {
        this.token = str;
        this.tokenExpirationTimestamp = j5;
        this.tokenCreationTimestamp = j6;
    }
}
