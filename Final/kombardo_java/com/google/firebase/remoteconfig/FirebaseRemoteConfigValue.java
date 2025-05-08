package com.google.firebase.remoteconfig;

/* loaded from: classes2.dex */
public interface FirebaseRemoteConfigValue {
    boolean asBoolean();

    double asDouble();

    long asLong();

    String asString();

    int getSource();
}
