package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\tJ\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/facebook/AccessTokenCache;", BuildConfig.FLAVOR, "()V", "sharedPreferences", "Landroid/content/SharedPreferences;", "tokenCachingStrategyFactory", "Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;", "(Landroid/content/SharedPreferences;Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;)V", "cachedAccessToken", "Lcom/facebook/AccessToken;", "getCachedAccessToken", "()Lcom/facebook/AccessToken;", "legacyAccessToken", "getLegacyAccessToken", "tokenCachingStrategy", "Lcom/facebook/LegacyTokenHelper;", "getTokenCachingStrategy", "()Lcom/facebook/LegacyTokenHelper;", "tokenCachingStrategyField", "clear", BuildConfig.FLAVOR, "hasCachedAccessToken", BuildConfig.FLAVOR, "load", "save", "accessToken", "shouldCheckLegacyToken", "Companion", "SharedPreferencesTokenCachingStrategyFactory", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AccessTokenCache {
    private final SharedPreferences sharedPreferences;
    private final SharedPreferencesTokenCachingStrategyFactory tokenCachingStrategyFactory;
    private LegacyTokenHelper tokenCachingStrategyField;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;", BuildConfig.FLAVOR, "()V", "create", "Lcom/facebook/LegacyTokenHelper;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class SharedPreferencesTokenCachingStrategyFactory {
        public final LegacyTokenHelper create() {
            return new LegacyTokenHelper(FacebookSdk.getApplicationContext(), null, 2, null);
        }
    }

    public AccessTokenCache(SharedPreferences sharedPreferences, SharedPreferencesTokenCachingStrategyFactory tokenCachingStrategyFactory) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(tokenCachingStrategyFactory, "tokenCachingStrategyFactory");
        this.sharedPreferences = sharedPreferences;
        this.tokenCachingStrategyFactory = tokenCachingStrategyFactory;
    }

    private final AccessToken getCachedAccessToken() {
        String string = this.sharedPreferences.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
        if (string == null) {
            return null;
        }
        try {
            return AccessToken.INSTANCE.createFromJSONObject$facebook_core_release(new JSONObject(string));
        } catch (JSONException unused) {
            return null;
        }
    }

    private final AccessToken getLegacyAccessToken() {
        Bundle load = getTokenCachingStrategy().load();
        if (load == null || !LegacyTokenHelper.INSTANCE.hasTokenInformation(load)) {
            return null;
        }
        return AccessToken.INSTANCE.createFromLegacyCache$facebook_core_release(load);
    }

    private final LegacyTokenHelper getTokenCachingStrategy() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (this.tokenCachingStrategyField == null) {
                synchronized (this) {
                    try {
                        if (this.tokenCachingStrategyField == null) {
                            this.tokenCachingStrategyField = this.tokenCachingStrategyFactory.create();
                        }
                        Unit unit = Unit.INSTANCE;
                    } finally {
                    }
                }
            }
            LegacyTokenHelper legacyTokenHelper = this.tokenCachingStrategyField;
            if (legacyTokenHelper != null) {
                return legacyTokenHelper;
            }
            throw new IllegalStateException("Required value was null.");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final boolean hasCachedAccessToken() {
        return this.sharedPreferences.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    private final boolean shouldCheckLegacyToken() {
        return FacebookSdk.isLegacyTokenUpgradeSupported();
    }

    public final void clear() {
        this.sharedPreferences.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (shouldCheckLegacyToken()) {
            getTokenCachingStrategy().clear();
        }
    }

    public final AccessToken load() {
        if (hasCachedAccessToken()) {
            return getCachedAccessToken();
        }
        if (!shouldCheckLegacyToken()) {
            return null;
        }
        AccessToken legacyAccessToken = getLegacyAccessToken();
        if (legacyAccessToken == null) {
            return legacyAccessToken;
        }
        save(legacyAccessToken);
        getTokenCachingStrategy().clear();
        return legacyAccessToken;
    }

    public final void save(AccessToken accessToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        try {
            this.sharedPreferences.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken.toJSONObject$facebook_core_release().toString()).apply();
        } catch (JSONException unused) {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AccessTokenCache() {
        this(r0, new SharedPreferencesTokenCachingStrategyFactory());
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "FacebookSdk.getApplicationContext()\n              .getSharedPreferences(\n                  AccessTokenManager.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)");
    }
}
