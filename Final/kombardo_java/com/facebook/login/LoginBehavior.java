package com.facebook.login;

import java.util.Arrays;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BA\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\fJ\r\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\fJ\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\fJ\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\fJ\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\fJ\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\rR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/facebook/login/LoginBehavior;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "allowsGetTokenAuth", "allowsKatanaAuth", "allowsWebViewAuth", "allowsDeviceAuth", "allowsCustomTabAuth", "allowsFacebookLiteAuth", "allowsInstagramAppAuth", "<init>", "(Ljava/lang/String;IZZZZZZZ)V", "()Z", "Z", "NATIVE_WITH_FALLBACK", "NATIVE_ONLY", "KATANA_ONLY", "WEB_ONLY", "DIALOG_ONLY", "DEVICE_AUTH", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public enum LoginBehavior {
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true, true),
    NATIVE_ONLY(true, true, false, false, false, true, true),
    KATANA_ONLY(false, true, false, false, false, false, false),
    WEB_ONLY(false, false, true, false, true, false, false),
    DIALOG_ONLY(false, true, true, false, true, true, true),
    DEVICE_AUTH(false, false, false, true, false, false, false);

    private final boolean allowsCustomTabAuth;
    private final boolean allowsDeviceAuth;
    private final boolean allowsFacebookLiteAuth;
    private final boolean allowsGetTokenAuth;
    private final boolean allowsInstagramAppAuth;
    private final boolean allowsKatanaAuth;
    private final boolean allowsWebViewAuth;

    LoginBehavior(boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        this.allowsGetTokenAuth = z5;
        this.allowsKatanaAuth = z6;
        this.allowsWebViewAuth = z7;
        this.allowsDeviceAuth = z8;
        this.allowsCustomTabAuth = z9;
        this.allowsFacebookLiteAuth = z10;
        this.allowsInstagramAppAuth = z11;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static LoginBehavior[] valuesCustom() {
        LoginBehavior[] valuesCustom = values();
        return (LoginBehavior[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    /* renamed from: allowsCustomTabAuth, reason: from getter */
    public final boolean getAllowsCustomTabAuth() {
        return this.allowsCustomTabAuth;
    }

    /* renamed from: allowsDeviceAuth, reason: from getter */
    public final boolean getAllowsDeviceAuth() {
        return this.allowsDeviceAuth;
    }

    /* renamed from: allowsGetTokenAuth, reason: from getter */
    public final boolean getAllowsGetTokenAuth() {
        return this.allowsGetTokenAuth;
    }

    /* renamed from: allowsInstagramAppAuth, reason: from getter */
    public final boolean getAllowsInstagramAppAuth() {
        return this.allowsInstagramAppAuth;
    }

    /* renamed from: allowsKatanaAuth, reason: from getter */
    public final boolean getAllowsKatanaAuth() {
        return this.allowsKatanaAuth;
    }

    /* renamed from: allowsWebViewAuth, reason: from getter */
    public final boolean getAllowsWebViewAuth() {
        return this.allowsWebViewAuth;
    }
}
