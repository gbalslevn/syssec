package com.facebook;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/facebook/FacebookServiceException;", "Lcom/facebook/FacebookException;", "requestError", "Lcom/facebook/FacebookRequestError;", "errorMessage", BuildConfig.FLAVOR, "(Lcom/facebook/FacebookRequestError;Ljava/lang/String;)V", "getRequestError", "()Lcom/facebook/FacebookRequestError;", "toString", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FacebookServiceException extends FacebookException {
    private static final long serialVersionUID = 1;
    private final FacebookRequestError requestError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FacebookServiceException(FacebookRequestError requestError, String str) {
        super(str);
        Intrinsics.checkNotNullParameter(requestError, "requestError");
        this.requestError = requestError;
    }

    public final FacebookRequestError getRequestError() {
        return this.requestError;
    }

    @Override // com.facebook.FacebookException, java.lang.Throwable
    public String toString() {
        String str = "{FacebookServiceException: httpResponseCode: " + this.requestError.getRequestStatusCode() + ", facebookErrorCode: " + this.requestError.getErrorCode() + ", facebookErrorType: " + this.requestError.getErrorType() + ", message: " + this.requestError.getErrorMessage() + "}";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        .append(\"{FacebookServiceException: \")\n        .append(\"httpResponseCode: \")\n        .append(requestError.requestStatusCode)\n        .append(\", facebookErrorCode: \")\n        .append(requestError.errorCode)\n        .append(\", facebookErrorType: \")\n        .append(requestError.errorType)\n        .append(\", message: \")\n        .append(requestError.errorMessage)\n        .append(\"}\")\n        .toString()");
        return str;
    }
}
