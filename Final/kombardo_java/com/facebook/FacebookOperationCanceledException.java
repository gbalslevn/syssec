package com.facebook;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/facebook/FacebookOperationCanceledException;", "Lcom/facebook/FacebookException;", "<init>", "()V", BuildConfig.FLAVOR, "message", "(Ljava/lang/String;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FacebookOperationCanceledException extends FacebookException {
    public static final long serialVersionUID = 1;

    public FacebookOperationCanceledException() {
    }

    public FacebookOperationCanceledException(String str) {
        super(str);
    }
}
