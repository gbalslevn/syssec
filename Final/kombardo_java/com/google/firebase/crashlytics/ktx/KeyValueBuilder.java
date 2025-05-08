package com.google.firebase.crashlytics.ktx;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Deprecated
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0007\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u0007\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0007\u0010\rJ\u001f\u0010\u0007\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/google/firebase/crashlytics/ktx/KeyValueBuilder;", BuildConfig.FLAVOR, "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "crashlytics", "<init>", "(Lcom/google/firebase/crashlytics/FirebaseCrashlytics;)V", BuildConfig.FLAVOR, "key", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "(Ljava/lang/String;Z)V", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "com.google.firebase-firebase-crashlytics"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KeyValueBuilder {
    private final FirebaseCrashlytics crashlytics;

    public KeyValueBuilder(FirebaseCrashlytics crashlytics) {
        Intrinsics.checkNotNullParameter(crashlytics, "crashlytics");
        this.crashlytics = crashlytics;
    }

    @Deprecated
    public final void key(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.crashlytics.setCustomKey(key, value);
    }

    @Deprecated
    public final void key(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.crashlytics.setCustomKey(key, value);
    }

    @Deprecated
    public final void key(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.crashlytics.setCustomKey(key, value);
    }
}
