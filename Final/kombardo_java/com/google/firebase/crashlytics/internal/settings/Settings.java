package com.google.firebase.crashlytics.internal.settings;

/* loaded from: classes2.dex */
public class Settings {
    public final int cacheDuration;
    public final long expiresAtMillis;
    public final FeatureFlagData featureFlagData;
    public final double onDemandBackoffBase;
    public final int onDemandBackoffStepDurationSeconds;
    public final double onDemandUploadRatePerMinute;
    public final SessionData sessionData;
    public final int settingsVersion;

    /* loaded from: classes2.dex */
    public static class FeatureFlagData {
        public final boolean collectAnrs;
        public final boolean collectBuildIds;
        public final boolean collectReports;

        public FeatureFlagData(boolean z5, boolean z6, boolean z7) {
            this.collectReports = z5;
            this.collectAnrs = z6;
            this.collectBuildIds = z7;
        }
    }

    /* loaded from: classes2.dex */
    public static class SessionData {
        public final int maxCompleteSessionsCount;
        public final int maxCustomExceptionEvents;

        public SessionData(int i5, int i6) {
            this.maxCustomExceptionEvents = i5;
            this.maxCompleteSessionsCount = i6;
        }
    }

    public Settings(long j5, SessionData sessionData, FeatureFlagData featureFlagData, int i5, int i6, double d5, double d6, int i7) {
        this.expiresAtMillis = j5;
        this.sessionData = sessionData;
        this.featureFlagData = featureFlagData;
        this.settingsVersion = i5;
        this.cacheDuration = i6;
        this.onDemandUploadRatePerMinute = d5;
        this.onDemandBackoffBase = d6;
        this.onDemandBackoffStepDurationSeconds = i7;
    }

    public boolean isExpired(long j5) {
        return this.expiresAtMillis < j5;
    }
}
