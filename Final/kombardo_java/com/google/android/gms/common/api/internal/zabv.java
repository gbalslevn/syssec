package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApi;

/* loaded from: classes.dex */
public final class zabv extends zaag {
    private final GoogleApi zaa;

    public zabv(GoogleApi googleApi) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.zaa = googleApi;
    }
}
