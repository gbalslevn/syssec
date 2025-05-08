package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigServerException extends FirebaseRemoteConfigException {
    private final int httpStatusCode;

    public FirebaseRemoteConfigServerException(int i5, String str) {
        super(str);
        this.httpStatusCode = i5;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public FirebaseRemoteConfigServerException(int i5, String str, Throwable th) {
        super(str, th);
        this.httpStatusCode = i5;
    }

    public FirebaseRemoteConfigServerException(String str, FirebaseRemoteConfigException.Code code) {
        super(str, code);
        this.httpStatusCode = -1;
    }

    public FirebaseRemoteConfigServerException(int i5, String str, FirebaseRemoteConfigException.Code code) {
        super(str, code);
        this.httpStatusCode = i5;
    }
}
