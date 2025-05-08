package com.google.android.gms.common.api;

import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public class ApiException extends Exception {

    @Deprecated
    protected final Status mStatus;

    public ApiException(Status status) {
        super(status.getStatusCode() + ": " + (status.getStatusMessage() != null ? status.getStatusMessage() : BuildConfig.FLAVOR));
        this.mStatus = status;
    }

    public Status getStatus() {
        return this.mStatus;
    }
}
