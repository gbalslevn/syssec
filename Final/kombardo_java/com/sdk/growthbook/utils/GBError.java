package com.sdk.growthbook.utils;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/sdk/growthbook/utils/GBError;", BuildConfig.FLAVOR, "error", BuildConfig.FLAVOR, "(Ljava/lang/Throwable;)V", "errorMessage", BuildConfig.FLAVOR, "getErrorMessage", "()Ljava/lang/String;", "stackTrace", "getStackTrace", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GBError {
    private final String errorMessage;
    private final String stackTrace;

    public GBError(Throwable th) {
        String message;
        this.errorMessage = (th == null || (message = th.getMessage()) == null) ? BuildConfig.FLAVOR : message;
        this.stackTrace = th != null ? ExceptionsKt.stackTraceToString(th) : null;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getStackTrace() {
        return this.stackTrace;
    }
}
