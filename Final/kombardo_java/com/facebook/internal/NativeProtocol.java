package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginTargetApp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0007uvwxyz{B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0007J!\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\u0014\u0010\u0013J\u0083\u0001\u0010$\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\n2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0019H\u0007¢\u0006\u0004\b$\u0010%J©\u0001\u0010,\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\n2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010(\u001a\u00020'2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010\n2\b\u0010*\u001a\u0004\u0018\u00010\n2\b\u0010+\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b,\u0010-J±\u0001\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\n2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010\n2\b\u0010*\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u000200H\u0007¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00192\u0006\u00103\u001a\u000200H\u0007¢\u0006\u0004\b4\u00105J-\u0010;\u001a\u0004\u0018\u00010\u000f2\u0006\u00106\u001a\u00020\u000f2\b\u00108\u001a\u0004\u0018\u0001072\b\u0010:\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0004\b;\u0010<J\u0019\u0010=\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u0002002\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b?\u0010@J\u001b\u0010B\u001a\u0004\u0018\u00010A2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\bB\u0010CJ\u0019\u0010D\u001a\u0004\u0018\u0001072\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\bD\u0010EJ\u001b\u0010G\u001a\u0004\u0018\u0001092\b\u0010F\u001a\u0004\u0018\u000107H\u0007¢\u0006\u0004\bG\u0010HJ\u001b\u0010J\u001a\u0004\u0018\u0001072\b\u0010I\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0004\bJ\u0010KJ\u0017\u0010M\u001a\u0002002\u0006\u0010L\u001a\u000200H\u0007¢\u0006\u0004\bM\u0010NJ'\u0010S\u001a\u00020R2\u000e\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010Q\u001a\u00020PH\u0002¢\u0006\u0004\bS\u0010TJ\u000f\u0010V\u001a\u00020UH\u0007¢\u0006\u0004\bV\u0010\u0003J\u001d\u0010X\u001a\b\u0012\u0004\u0012\u0002000W2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\bX\u0010YJ/\u0010\\\u001a\u0002002\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010W2\u0006\u0010[\u001a\u0002002\u0006\u0010Q\u001a\u00020PH\u0007¢\u0006\u0004\b\\\u0010]J\u0017\u0010_\u001a\u00020^2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b_\u0010`R\u001c\u0010b\u001a\n a*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010d\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bd\u0010cR\u0014\u0010e\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\be\u0010cR\u0014\u0010f\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bf\u0010cR\u0014\u0010g\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bg\u0010cR\u0014\u0010h\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bh\u0010cR\u0014\u0010i\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bi\u0010cR\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u001a\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010kR&\u0010m\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010p\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u001a\u0010s\u001a\b\u0012\u0004\u0012\u0002000r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010t¨\u0006|"}, d2 = {"Lcom/facebook/internal/NativeProtocol;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "buildFacebookAppList", "()Ljava/util/List;", "buildEffectCameraAppInfoList", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "buildActionToAppInfoMap", "()Ljava/util/Map;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "appInfo", "validateActivityIntent", "(Landroid/content/Context;Landroid/content/Intent;Lcom/facebook/internal/NativeProtocol$NativeAppInfo;)Landroid/content/Intent;", "validateServiceIntent", "applicationId", BuildConfig.FLAVOR, "permissions", "e2e", BuildConfig.FLAVOR, "isRerequest", "isForPublish", "Lcom/facebook/login/DefaultAudience;", "defaultAudience", "clientState", "authType", "messengerPageId", "resetMessengerState", "isFamilyLogin", "shouldSkipAccountDedupe", "createInstagramIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;ZZLcom/facebook/login/DefaultAudience;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)Landroid/content/Intent;", "ignoreAppSwitchToLoggedOut", "Lcom/facebook/login/LoginTargetApp;", "targetApp", "nonce", "codeChallenge", "codeChallengeMethod", "createNativeAppIntent", "(Lcom/facebook/internal/NativeProtocol$NativeAppInfo;Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;ZLcom/facebook/login/DefaultAudience;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLcom/facebook/login/LoginTargetApp;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "createProxyAuthIntents", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;ZZLcom/facebook/login/DefaultAudience;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", BuildConfig.FLAVOR, "getLatestKnownVersion", "()I", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "isVersionCompatibleWithBucketedIntent", "(I)Z", "requestIntent", "Landroid/os/Bundle;", "results", "Lcom/facebook/FacebookException;", "error", "createProtocolResultIntent", "(Landroid/content/Intent;Landroid/os/Bundle;Lcom/facebook/FacebookException;)Landroid/content/Intent;", "createPlatformServiceIntent", "(Landroid/content/Context;)Landroid/content/Intent;", "getProtocolVersionFromIntent", "(Landroid/content/Intent;)I", "Ljava/util/UUID;", "getCallIdFromIntent", "(Landroid/content/Intent;)Ljava/util/UUID;", "getMethodArgumentsFromIntent", "(Landroid/content/Intent;)Landroid/os/Bundle;", "errorData", "getExceptionFromErrorData", "(Landroid/os/Bundle;)Lcom/facebook/FacebookException;", "e", "createBundleForException", "(Lcom/facebook/FacebookException;)Landroid/os/Bundle;", "minimumVersion", "getLatestAvailableProtocolVersionForService", "(I)I", "appInfoList", BuildConfig.FLAVOR, "versionSpec", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "getLatestAvailableProtocolVersionForAppInfoList", "(Ljava/util/List;[I)Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", BuildConfig.FLAVOR, "updateAllAvailableProtocolVersionsAsync", "Ljava/util/TreeSet;", "fetchAllAvailableProtocolVersionsForAppInfo", "(Lcom/facebook/internal/NativeProtocol$NativeAppInfo;)Ljava/util/TreeSet;", "allAvailableFacebookAppVersions", "latestSdkVersion", "computeLatestAvailableVersionFromVersionSpec", "(Ljava/util/TreeSet;I[I)I", "Landroid/net/Uri;", "buildPlatformProviderVersionURI", "(Lcom/facebook/internal/NativeProtocol$NativeAppInfo;)Landroid/net/Uri;", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "FACEBOOK_PROXY_AUTH_ACTIVITY", "FACEBOOK_TOKEN_REFRESH_ACTIVITY", "CONTENT_SCHEME", "PLATFORM_PROVIDER", "PLATFORM_PROVIDER_VERSIONS", "PLATFORM_PROVIDER_VERSION_COLUMN", "facebookAppInfoList", "Ljava/util/List;", "effectCameraAppInfoList", "actionToAppInfoMap", "Ljava/util/Map;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "protocolVersionsAsyncUpdating", "Ljava/util/concurrent/atomic/AtomicBoolean;", BuildConfig.FLAVOR, "KNOWN_PROTOCOL_VERSIONS", "[Ljava/lang/Integer;", "EffectTestAppInfo", "InstagramAppInfo", "KatanaAppInfo", "MessengerAppInfo", "NativeAppInfo", "ProtocolVersionQueryResult", "WakizashiAppInfo", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class NativeProtocol {
    private static final String CONTENT_SCHEME = "content://";
    private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
    private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
    public static final NativeProtocol INSTANCE;
    private static final Integer[] KNOWN_PROTOCOL_VERSIONS;
    private static final String PLATFORM_PROVIDER = ".provider.PlatformProvider";
    private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
    private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
    private static final String TAG;
    private static final Map<String, List<NativeAppInfo>> actionToAppInfoMap;
    private static final List<NativeAppInfo> effectCameraAppInfoList;
    private static final List<NativeAppInfo> facebookAppInfoList;
    private static final AtomicBoolean protocolVersionsAsyncUpdating;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$EffectTestAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", BuildConfig.FLAVOR, "getPackage", BuildConfig.FLAVOR, "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class EffectTestAppInfo extends NativeAppInfo {
        /* renamed from: getLoginActivity, reason: collision with other method in class */
        public Void m2862getLoginActivity() {
            return null;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return "com.facebook.arstudio.player";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public /* bridge */ /* synthetic */ String getLoginActivity() {
            return (String) m2862getLoginActivity();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$InstagramAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", BuildConfig.FLAVOR, "getPackage", "getResponseType", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    private static final class InstagramAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getLoginActivity() {
            return "com.instagram.platform.AppAuthorizeActivity";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return "com.instagram.android";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getResponseType() {
            return "token,signed_request,graph_domain,granted_scopes";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/facebook/internal/NativeProtocol$KatanaAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", BuildConfig.FLAVOR, "getPackage", "isAndroidAPIVersionNotLessThan30", BuildConfig.FLAVOR, "onAvailableVersionsNullOrEmpty", BuildConfig.FLAVOR, "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class KatanaAppInfo extends NativeAppInfo {
        private final boolean isAndroidAPIVersionNotLessThan30() {
            return FacebookSdk.getApplicationContext().getApplicationInfo().targetSdkVersion >= 30;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return "com.facebook.katana";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public void onAvailableVersionsNullOrEmpty() {
            if (isAndroidAPIVersionNotLessThan30()) {
                Log.w(NativeProtocol.access$getTAG$p(), "Apps that target Android API 30+ (Android 11+) cannot call Facebook native apps unless the package visibility needs are declared. Please follow https://developers.facebook.com/docs/android/troubleshooting/#faq_267321845055988 to make the declaration.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$MessengerAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", BuildConfig.FLAVOR, "getPackage", BuildConfig.FLAVOR, "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class MessengerAppInfo extends NativeAppInfo {
        /* renamed from: getLoginActivity, reason: collision with other method in class */
        public Void m2863getLoginActivity() {
            return null;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return "com.facebook.orca";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public /* bridge */ /* synthetic */ String getLoginActivity() {
            return (String) m2863getLoginActivity();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", BuildConfig.FLAVOR, "()V", "availableVersions", "Ljava/util/TreeSet;", BuildConfig.FLAVOR, "fetchAvailableVersions", BuildConfig.FLAVOR, "force", BuildConfig.FLAVOR, "getAvailableVersions", "getLoginActivity", BuildConfig.FLAVOR, "getPackage", "getResponseType", "onAvailableVersionsNullOrEmpty", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static abstract class NativeAppInfo {
        private TreeSet<Integer> availableVersions;

        public final synchronized void fetchAvailableVersions(boolean force) {
            TreeSet<Integer> treeSet;
            if (!force) {
                try {
                    TreeSet<Integer> treeSet2 = this.availableVersions;
                    if (treeSet2 != null) {
                        if (!Intrinsics.areEqual(treeSet2 == null ? null : Boolean.valueOf(treeSet2.isEmpty()), Boolean.FALSE)) {
                        }
                        treeSet = this.availableVersions;
                        if (treeSet != null || treeSet.isEmpty()) {
                            onAvailableVersionsNullOrEmpty();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.availableVersions = NativeProtocol.access$fetchAllAvailableProtocolVersionsForAppInfo(NativeProtocol.INSTANCE, this);
            treeSet = this.availableVersions;
            if (treeSet != null) {
            }
            onAvailableVersionsNullOrEmpty();
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
        
            if (kotlin.jvm.internal.Intrinsics.areEqual(r0 == null ? null : java.lang.Boolean.valueOf(r0.isEmpty()), java.lang.Boolean.FALSE) == false) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final TreeSet<Integer> getAvailableVersions() {
            TreeSet<Integer> treeSet = this.availableVersions;
            if (treeSet != null) {
            }
            fetchAvailableVersions(false);
            return this.availableVersions;
        }

        public abstract String getLoginActivity();

        public abstract String getPackage();

        public String getResponseType() {
            return "id_token,token,signed_request,graph_domain";
        }

        public void onAvailableVersionsNullOrEmpty() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", BuildConfig.FLAVOR, "<init>", "()V", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "<set-?>", "appInfo", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "getAppInfo", "()Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", BuildConfig.FLAVOR, "protocolVersion", "I", "getProtocolVersion", "()I", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class ProtocolVersionQueryResult {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private NativeAppInfo appInfo;
        private int protocolVersion;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult$Companion;", BuildConfig.FLAVOR, "()V", "create", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "nativeAppInfo", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "protocolVersion", BuildConfig.FLAVOR, "createEmpty", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ProtocolVersionQueryResult create(NativeAppInfo nativeAppInfo, int protocolVersion) {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult(null);
                protocolVersionQueryResult.appInfo = nativeAppInfo;
                protocolVersionQueryResult.protocolVersion = protocolVersion;
                return protocolVersionQueryResult;
            }

            public final ProtocolVersionQueryResult createEmpty() {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult(null);
                protocolVersionQueryResult.protocolVersion = -1;
                return protocolVersionQueryResult;
            }

            private Companion() {
            }
        }

        public /* synthetic */ ProtocolVersionQueryResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getProtocolVersion() {
            return this.protocolVersion;
        }

        private ProtocolVersionQueryResult() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/NativeProtocol$WakizashiAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", BuildConfig.FLAVOR, "getPackage", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class WakizashiAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return "com.facebook.wakizashi";
        }
    }

    static {
        NativeProtocol nativeProtocol = new NativeProtocol();
        INSTANCE = nativeProtocol;
        TAG = NativeProtocol.class.getName();
        facebookAppInfoList = nativeProtocol.buildFacebookAppList();
        effectCameraAppInfoList = nativeProtocol.buildEffectCameraAppInfoList();
        actionToAppInfoMap = nativeProtocol.buildActionToAppInfoMap();
        protocolVersionsAsyncUpdating = new AtomicBoolean(false);
        KNOWN_PROTOCOL_VERSIONS = new Integer[]{20210906, 20171115, 20170417, 20170411, 20170213, 20161017, 20160327, 20150702, 20150401, 20141218, 20141107, 20141028, 20141001, 20140701, 20140324, 20140313, 20140204, 20131107, 20131024, 20130618, 20130502, 20121101};
    }

    private NativeProtocol() {
    }

    public static final /* synthetic */ TreeSet access$fetchAllAvailableProtocolVersionsForAppInfo(NativeProtocol nativeProtocol, NativeAppInfo nativeAppInfo) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return nativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(nativeAppInfo);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$p() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final Map<String, List<NativeAppInfo>> buildActionToAppInfoMap() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MessengerAppInfo());
            List<NativeAppInfo> list = facebookAppInfoList;
            hashMap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", list);
            hashMap.put("com.facebook.platform.action.request.FEED_DIALOG", list);
            hashMap.put("com.facebook.platform.action.request.LIKE_DIALOG", list);
            hashMap.put("com.facebook.platform.action.request.APPINVITES_DIALOG", list);
            hashMap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", arrayList);
            hashMap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arrayList);
            hashMap.put("com.facebook.platform.action.request.CAMERA_EFFECT", effectCameraAppInfoList);
            hashMap.put("com.facebook.platform.action.request.SHARE_STORY", list);
            return hashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final List<NativeAppInfo> buildEffectCameraAppInfoList() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayListOf = CollectionsKt.arrayListOf(new EffectTestAppInfo());
            arrayListOf.addAll(buildFacebookAppList());
            return arrayListOf;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final List<NativeAppInfo> buildFacebookAppList() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return CollectionsKt.arrayListOf(new KatanaAppInfo(), new WakizashiAppInfo());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Uri buildPlatformProviderVersionURI(NativeAppInfo appInfo) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Uri parse = Uri.parse(CONTENT_SCHEME + appInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(CONTENT_SCHEME + appInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS)");
            return parse;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final int computeLatestAvailableVersionFromVersionSpec(TreeSet<Integer> allAvailableFacebookAppVersions, int latestSdkVersion, int[] versionSpec) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            Intrinsics.checkNotNullParameter(versionSpec, "versionSpec");
            if (allAvailableFacebookAppVersions == null) {
                return -1;
            }
            int length = versionSpec.length - 1;
            Iterator<Integer> descendingIterator = allAvailableFacebookAppVersions.descendingIterator();
            int i5 = -1;
            while (descendingIterator.hasNext()) {
                Integer fbAppVersion = descendingIterator.next();
                Intrinsics.checkNotNullExpressionValue(fbAppVersion, "fbAppVersion");
                i5 = Math.max(i5, fbAppVersion.intValue());
                while (length >= 0 && versionSpec[length] > fbAppVersion.intValue()) {
                    length--;
                }
                if (length < 0) {
                    return -1;
                }
                if (versionSpec[length] == fbAppVersion.intValue()) {
                    if (length % 2 == 0) {
                        return Math.min(i5, latestSdkVersion);
                    }
                    return -1;
                }
            }
            return -1;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    public static final Bundle createBundleForException(FacebookException e5) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || e5 == null) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("error_description", e5.toString());
            if (e5 instanceof FacebookOperationCanceledException) {
                bundle.putString("error_type", "UserCanceled");
            }
            return bundle;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final Intent createInstagramIntent(Context context, String applicationId, Collection<String> permissions, String e2e, boolean isRerequest, boolean isForPublish, DefaultAudience defaultAudience, String clientState, String authType, String messengerPageId, boolean resetMessengerState, boolean isFamilyLogin, boolean shouldSkipAccountDedupe) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(e2e, "e2e");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(clientState, "clientState");
            Intrinsics.checkNotNullParameter(authType, "authType");
            InstagramAppInfo instagramAppInfo = new InstagramAppInfo();
            return validateActivityIntent(context, INSTANCE.createNativeAppIntent(instagramAppInfo, applicationId, permissions, e2e, isForPublish, defaultAudience, clientState, authType, false, messengerPageId, resetMessengerState, LoginTargetApp.INSTAGRAM, isFamilyLogin, shouldSkipAccountDedupe, BuildConfig.FLAVOR, null, null), instagramAppInfo);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final Intent createNativeAppIntent(NativeAppInfo appInfo, String applicationId, Collection<String> permissions, String e2e, boolean isForPublish, DefaultAudience defaultAudience, String clientState, String authType, boolean ignoreAppSwitchToLoggedOut, String messengerPageId, boolean resetMessengerState, LoginTargetApp targetApp, boolean isFamilyLogin, boolean shouldSkipAccountDedupe, String nonce, String codeChallenge, String codeChallengeMethod) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            String loginActivity = appInfo.getLoginActivity();
            if (loginActivity == null) {
                return null;
            }
            Intent putExtra = new Intent().setClassName(appInfo.getPackage(), loginActivity).putExtra("client_id", applicationId);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent()\n            .setClassName(appInfo.getPackage(), activityName)\n            .putExtra(FACEBOOK_PROXY_AUTH_APP_ID_KEY, applicationId)");
            putExtra.putExtra("facebook_sdk_version", FacebookSdk.getSdkVersion());
            if (!Utility.isNullOrEmpty(permissions)) {
                putExtra.putExtra("scope", TextUtils.join(",", permissions));
            }
            if (!Utility.isNullOrEmpty(e2e)) {
                putExtra.putExtra("e2e", e2e);
            }
            putExtra.putExtra("state", clientState);
            putExtra.putExtra("response_type", appInfo.getResponseType());
            putExtra.putExtra("nonce", nonce);
            putExtra.putExtra("return_scopes", "true");
            if (isForPublish) {
                putExtra.putExtra("default_audience", defaultAudience.getNativeProtocolAudience());
            }
            putExtra.putExtra("legacy_override", FacebookSdk.getGraphApiVersion());
            putExtra.putExtra("auth_type", authType);
            if (ignoreAppSwitchToLoggedOut) {
                putExtra.putExtra("fail_on_logged_out", true);
            }
            putExtra.putExtra("messenger_page_id", messengerPageId);
            putExtra.putExtra("reset_messenger_state", resetMessengerState);
            if (isFamilyLogin) {
                putExtra.putExtra("fx_app", targetApp.getTargetApp());
            }
            if (shouldSkipAccountDedupe) {
                putExtra.putExtra("skip_dedupe", true);
            }
            return putExtra;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final Intent createPlatformServiceIntent(Context context) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
                Intent validateServiceIntent = validateServiceIntent(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(nativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), nativeAppInfo);
                if (validateServiceIntent != null) {
                    return validateServiceIntent;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final Intent createProtocolResultIntent(Intent requestIntent, Bundle results, FacebookException error) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(requestIntent, "requestIntent");
            UUID callIdFromIntent = getCallIdFromIntent(requestIntent);
            if (callIdFromIntent == null) {
                return null;
            }
            Intent intent = new Intent();
            intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", getProtocolVersionFromIntent(requestIntent));
            Bundle bundle = new Bundle();
            bundle.putString("action_id", callIdFromIntent.toString());
            if (error != null) {
                bundle.putBundle("error", createBundleForException(error));
            }
            intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle);
            if (results != null) {
                intent.putExtra("com.facebook.platform.protocol.RESULT_ARGS", results);
            }
            return intent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final List<Intent> createProxyAuthIntents(Context context, String applicationId, Collection<String> permissions, String e2e, boolean isRerequest, boolean isForPublish, DefaultAudience defaultAudience, String clientState, String authType, boolean ignoreAppSwitchToLoggedOut, String messengerPageId, boolean resetMessengerState, boolean isFamilyLogin, boolean shouldSkipAccountDedupe, String nonce, String codeChallenge, String codeChallengeMethod) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(e2e, "e2e");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(clientState, "clientState");
            Intrinsics.checkNotNullParameter(authType, "authType");
            List<NativeAppInfo> list = facebookAppInfoList;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ArrayList arrayList2 = arrayList;
                Intent createNativeAppIntent = INSTANCE.createNativeAppIntent((NativeAppInfo) it.next(), applicationId, permissions, e2e, isForPublish, defaultAudience, clientState, authType, ignoreAppSwitchToLoggedOut, messengerPageId, resetMessengerState, LoginTargetApp.FACEBOOK, isFamilyLogin, shouldSkipAccountDedupe, nonce, codeChallenge, codeChallengeMethod);
                if (createNativeAppIntent != null) {
                    arrayList2.add(createNativeAppIntent);
                }
                arrayList = arrayList2;
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0082 A[Catch: all -> 0x0086, TRY_ENTER, TryCatch #3 {all -> 0x0086, blocks: (B:6:0x000d, B:30:0x008e, B:31:0x008b, B:18:0x0082), top: B:5:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063 A[EXC_TOP_SPLITTER, LOOP:0: B:20:0x0063->B:23:0x0069, LOOP_START, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b A[Catch: all -> 0x0086, TryCatch #3 {all -> 0x0086, blocks: (B:6:0x000d, B:30:0x008e, B:31:0x008b, B:18:0x0082), top: B:5:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final TreeSet<Integer> fetchAllAvailableProtocolVersionsForAppInfo(NativeAppInfo appInfo) {
        Cursor cursor;
        ProviderInfo providerInfo;
        Cursor cursor2;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            TreeSet<Integer> treeSet = new TreeSet<>();
            ContentResolver contentResolver = FacebookSdk.getApplicationContext().getContentResolver();
            String[] strArr = {PLATFORM_PROVIDER_VERSION_COLUMN};
            Uri buildPlatformProviderVersionURI = buildPlatformProviderVersionURI(appInfo);
            try {
                try {
                    providerInfo = FacebookSdk.getApplicationContext().getPackageManager().resolveContentProvider(Intrinsics.stringPlus(appInfo.getPackage(), PLATFORM_PROVIDER), 0);
                } catch (RuntimeException e5) {
                    Log.e(TAG, "Failed to query content resolver.", e5);
                    providerInfo = null;
                }
                if (providerInfo != null) {
                    try {
                        cursor2 = contentResolver.query(buildPlatformProviderVersionURI, strArr, null, null, null);
                    } catch (IllegalArgumentException unused) {
                        Log.e(TAG, "Failed to query content resolver.");
                        cursor2 = null;
                        if (cursor2 != null) {
                        }
                        if (cursor2 != null) {
                        }
                        return treeSet;
                    } catch (NullPointerException unused2) {
                        Log.e(TAG, "Failed to query content resolver.");
                        cursor2 = null;
                        if (cursor2 != null) {
                        }
                        if (cursor2 != null) {
                        }
                        return treeSet;
                    } catch (SecurityException unused3) {
                        Log.e(TAG, "Failed to query content resolver.");
                        cursor2 = null;
                        if (cursor2 != null) {
                        }
                        if (cursor2 != null) {
                        }
                        return treeSet;
                    }
                    if (cursor2 != null) {
                        while (cursor2.moveToNext()) {
                            try {
                                treeSet.add(Integer.valueOf(cursor2.getInt(cursor2.getColumnIndex(PLATFORM_PROVIDER_VERSION_COLUMN))));
                            } catch (Throwable th) {
                                cursor = cursor2;
                                th = th;
                                if (cursor == null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        }
                    }
                } else {
                    cursor2 = null;
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                return treeSet;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor == null) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            CrashShieldHandler.handleThrowable(th3, this);
            return null;
        }
    }

    public static final UUID getCallIdFromIntent(Intent intent) {
        String stringExtra;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || intent == null) {
            return null;
        }
        try {
            if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                Bundle bundleExtra = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
                stringExtra = bundleExtra != null ? bundleExtra.getString("action_id") : null;
            } else {
                stringExtra = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
            }
            if (stringExtra == null) {
                return null;
            }
            try {
                return UUID.fromString(stringExtra);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final FacebookException getExceptionFromErrorData(Bundle errorData) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || errorData == null) {
            return null;
        }
        try {
            String string = errorData.getString("error_type");
            if (string == null) {
                string = errorData.getString("com.facebook.platform.status.ERROR_TYPE");
            }
            String string2 = errorData.getString("error_description");
            if (string2 == null) {
                string2 = errorData.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
            }
            return (string == null || !StringsKt.equals(string, "UserCanceled", true)) ? new FacebookException(string2) : new FacebookOperationCanceledException(string2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAppInfoList(List<? extends NativeAppInfo> appInfoList, int[] versionSpec) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            updateAllAvailableProtocolVersionsAsync();
            if (appInfoList == null) {
                return ProtocolVersionQueryResult.INSTANCE.createEmpty();
            }
            for (NativeAppInfo nativeAppInfo : appInfoList) {
                int computeLatestAvailableVersionFromVersionSpec = computeLatestAvailableVersionFromVersionSpec(nativeAppInfo.getAvailableVersions(), getLatestKnownVersion(), versionSpec);
                if (computeLatestAvailableVersionFromVersionSpec != -1) {
                    return ProtocolVersionQueryResult.INSTANCE.create(nativeAppInfo, computeLatestAvailableVersionFromVersionSpec);
                }
            }
            return ProtocolVersionQueryResult.INSTANCE.createEmpty();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final int getLatestAvailableProtocolVersionForService(int minimumVersion) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            return INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[]{minimumVersion}).getProtocolVersion();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    public static final int getLatestKnownVersion() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            return KNOWN_PROTOCOL_VERSIONS[0].intValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    public static final Bundle getMethodArgumentsFromIntent(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return !isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent)) ? intent.getExtras() : intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final int getProtocolVersionFromIntent(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    public static final boolean isVersionCompatibleWithBucketedIntent(int version) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return false;
        }
        try {
            return ArraysKt.contains(KNOWN_PROTOCOL_VERSIONS, Integer.valueOf(version)) && version >= 20140701;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return false;
        }
    }

    public static final void updateAllAvailableProtocolVersionsAsync() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return;
        }
        try {
            if (protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: o0.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        NativeProtocol.m2861updateAllAvailableProtocolVersionsAsync$lambda1();
                    }
                });
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateAllAvailableProtocolVersionsAsync$lambda-1, reason: not valid java name */
    public static final void m2861updateAllAvailableProtocolVersionsAsync$lambda1() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return;
        }
        try {
            try {
                Iterator<NativeAppInfo> it = facebookAppInfoList.iterator();
                while (it.hasNext()) {
                    it.next().fetchAvailableVersions(true);
                }
            } finally {
                protocolVersionsAsyncUpdating.set(false);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
        }
    }

    public static final Intent validateActivityIntent(Context context, Intent intent, NativeAppInfo appInfo) {
        ResolveInfo resolveActivity;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            if (intent == null || (resolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null) {
                return null;
            }
            FacebookSignatureValidator facebookSignatureValidator = FacebookSignatureValidator.INSTANCE;
            String str = resolveActivity.activityInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(str, "resolveInfo.activityInfo.packageName");
            if (FacebookSignatureValidator.validateSignature(context, str)) {
                return intent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final Intent validateServiceIntent(Context context, Intent intent, NativeAppInfo appInfo) {
        ResolveInfo resolveService;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            if (intent == null || (resolveService = context.getPackageManager().resolveService(intent, 0)) == null) {
                return null;
            }
            FacebookSignatureValidator facebookSignatureValidator = FacebookSignatureValidator.INSTANCE;
            String str = resolveService.serviceInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(str, "resolveInfo.serviceInfo.packageName");
            if (FacebookSignatureValidator.validateSignature(context, str)) {
                return intent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }
}
