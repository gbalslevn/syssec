package com.facebook.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\bR\u001a\u0010\u000b\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/InternalSettings;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "getCustomUserAgent", "()Ljava/lang/String;", "UNITY_PREFIX", "Ljava/lang/String;", "customUserAgent", BuildConfig.FLAVOR, "isUnityApp", "()Z", "isUnityApp$annotations", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class InternalSettings {
    public static final InternalSettings INSTANCE = new InternalSettings();
    private static final String UNITY_PREFIX = "Unity.";
    private static volatile String customUserAgent;

    private InternalSettings() {
    }

    public static final String getCustomUserAgent() {
        return customUserAgent;
    }

    public static final boolean isUnityApp() {
        String str = customUserAgent;
        return Intrinsics.areEqual(str != null ? Boolean.valueOf(StringsKt.startsWith$default(str, UNITY_PREFIX, false, 2, (Object) null)) : null, Boolean.TRUE);
    }
}
