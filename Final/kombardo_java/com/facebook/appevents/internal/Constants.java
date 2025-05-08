package com.facebook.appevents.internal;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/internal/Constants;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "getDefaultAppEventsSessionTimeoutInSeconds", "()I", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class Constants {
    public static final Constants INSTANCE = new Constants();

    private Constants() {
    }

    public static final int getDefaultAppEventsSessionTimeoutInSeconds() {
        return 60;
    }
}
