package com.google.firebase.remoteconfig;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigFetchThrottledException extends FirebaseRemoteConfigException {
    private final long throttleEndTimeMillis;

    public FirebaseRemoteConfigFetchThrottledException(long j5) {
        this("Fetch was throttled.", j5);
    }

    public FirebaseRemoteConfigFetchThrottledException(String str, long j5) {
        super(str);
        this.throttleEndTimeMillis = j5;
    }
}
