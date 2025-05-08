package com.google.firebase.remoteconfig;

/* loaded from: classes2.dex */
public interface ConfigUpdateListener {
    void onError(FirebaseRemoteConfigException firebaseRemoteConfigException);

    void onUpdate(ConfigUpdate configUpdate);
}
