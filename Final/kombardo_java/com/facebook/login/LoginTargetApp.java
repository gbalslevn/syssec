package com.facebook.login;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/login/LoginTargetApp;", BuildConfig.FLAVOR, "targetApp", BuildConfig.FLAVOR, "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "FACEBOOK", "INSTAGRAM", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public enum LoginTargetApp {
    FACEBOOK("facebook"),
    INSTAGRAM("instagram");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String targetApp;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/login/LoginTargetApp$Companion;", BuildConfig.FLAVOR, "()V", "fromString", "Lcom/facebook/login/LoginTargetApp;", "stringValue", BuildConfig.FLAVOR, "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LoginTargetApp fromString(String stringValue) {
            LoginTargetApp[] valuesCustom = LoginTargetApp.valuesCustom();
            int length = valuesCustom.length;
            int i5 = 0;
            while (i5 < length) {
                LoginTargetApp loginTargetApp = valuesCustom[i5];
                i5++;
                if (Intrinsics.areEqual(loginTargetApp.toString(), stringValue)) {
                    return loginTargetApp;
                }
            }
            return LoginTargetApp.FACEBOOK;
        }

        private Companion() {
        }
    }

    LoginTargetApp(String str) {
        this.targetApp = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static LoginTargetApp[] valuesCustom() {
        LoginTargetApp[] valuesCustom = values();
        return (LoginTargetApp[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.targetApp;
    }
}
