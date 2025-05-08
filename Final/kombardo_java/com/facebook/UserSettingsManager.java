package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001CB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J#\u0010\t\u001a\u00020\u00042\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001d\u0010\u001aJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010 \u001a\u0004\u0018\u00010\u0015H\u0003¢\u0006\u0004\b \u0010\u001fJ\u0011\u0010!\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b!\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\"\u0010\u0018J\u000f\u0010#\u001a\u00020\u0015H\u0007¢\u0006\u0004\b#\u0010\u001aJ\u000f\u0010$\u001a\u00020\u0015H\u0007¢\u0006\u0004\b$\u0010\u001aR\u001c\u0010'\u001a\n &*\u0004\u0018\u00010%0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010-\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010(R\u0014\u0010/\u001a\u00020.8\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010(R\u0014\u00102\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u0010(R\u0014\u00103\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00104R\u0014\u00106\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00104R\u0014\u00107\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00104R\u0014\u00108\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00104R\u0014\u00109\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u0010(R\u0014\u0010:\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u0010(R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u0010(R\u0014\u0010?\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u0010(R\u0014\u0010@\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u0010(R\u0014\u0010A\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u0010(R\u0014\u0010B\u001a\u00020%8\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u0010(¨\u0006D"}, d2 = {"Lcom/facebook/UserSettingsManager;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "initializeIfNotInitialized", BuildConfig.FLAVOR, "Lcom/facebook/UserSettingsManager$UserSetting;", "userSettings", "initializeUserSetting", "([Lcom/facebook/UserSettingsManager$UserSetting;)V", "initializeCodelessSetupEnabledAsync", "userSetting", "writeSettingToCache", "(Lcom/facebook/UserSettingsManager$UserSetting;)V", "readSettingFromCache", "loadSettingFromManifest", "logWarnings", "logIfSDKSettingsChanged", "logIfAutoAppLinkEnabled", "validateInitialized", BuildConfig.FLAVOR, "flag", "setAutoInitEnabled", "(Z)V", "getAutoInitEnabled", "()Z", "setAutoLogAppEventsEnabled", "getAutoLogAppEventsEnabled", "checkAutoLogAppEventsEnabled", "checkClientSideConfiguration", "()Ljava/lang/Boolean;", "readAutoLogAppEventsSettingFromCache", "loadAutoLogAppEventsSettingFromManifest", "setAdvertiserIDCollectionEnabled", "getAdvertiserIDCollectionEnabled", "getCodelessSetupEnabled", BuildConfig.FLAVOR, "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isFetchingCodelessStatus", "EVENTS_CODELESS_SETUP_ENABLED", BuildConfig.FLAVOR, "TIMEOUT_7D", "J", "ADVERTISER_ID_KEY", "APPLICATION_FIELDS", "autoInitEnabled", "Lcom/facebook/UserSettingsManager$UserSetting;", "autoLogAppEventsEnabledLocally", "advertiserIDCollectionEnabled", "codelessSetupEnabled", "monitorEnabled", "USER_SETTINGS", "USER_SETTINGS_BITMASK", "Landroid/content/SharedPreferences;", "userSettingPref", "Landroid/content/SharedPreferences;", "LAST_TIMESTAMP", "VALUE", "ADVERTISERID_COLLECTION_NOT_SET_WARNING", "ADVERTISERID_COLLECTION_FALSE_WARNING", "AUTO_APP_LINK_WARNING", "UserSetting", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class UserSettingsManager {
    private static final String ADVERTISERID_COLLECTION_FALSE_WARNING = "The value for AdvertiserIDCollectionEnabled is currently set to FALSE so you're sending app events without collecting Advertiser ID. This can affect the quality of your advertising and analytics results.";
    private static final String ADVERTISERID_COLLECTION_NOT_SET_WARNING = "You haven't set a value for AdvertiserIDCollectionEnabled. Set the flag to TRUE if you want to collect Advertiser ID for better advertising and analytics results. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.";
    private static final String ADVERTISER_ID_KEY = "advertiser_id";
    private static final String APPLICATION_FIELDS = "fields";
    private static final String AUTO_APP_LINK_WARNING = "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest";
    private static final String LAST_TIMESTAMP = "last_timestamp";
    private static final long TIMEOUT_7D = 604800000;
    private static final String USER_SETTINGS = "com.facebook.sdk.USER_SETTINGS";
    private static final String USER_SETTINGS_BITMASK = "com.facebook.sdk.USER_SETTINGS_BITMASK";
    private static final String VALUE = "value";
    private static SharedPreferences userSettingPref;
    public static final UserSettingsManager INSTANCE = new UserSettingsManager();
    private static final String TAG = UserSettingsManager.class.getName();
    private static final AtomicBoolean isInitialized = new AtomicBoolean(false);
    private static final AtomicBoolean isFetchingCodelessStatus = new AtomicBoolean(false);
    private static final UserSetting autoInitEnabled = new UserSetting(true, "com.facebook.sdk.AutoInitEnabled");
    private static final UserSetting autoLogAppEventsEnabledLocally = new UserSetting(true, "com.facebook.sdk.AutoLogAppEventsEnabled");
    private static final UserSetting advertiserIDCollectionEnabled = new UserSetting(true, "com.facebook.sdk.AdvertiserIDCollectionEnabled");
    private static final String EVENTS_CODELESS_SETUP_ENABLED = "auto_event_setup_enabled";
    private static final UserSetting codelessSetupEnabled = new UserSetting(false, EVENTS_CODELESS_SETUP_ENABLED);
    private static final UserSetting monitorEnabled = new UserSetting(true, "com.facebook.sdk.MonitorEnabled");

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\b\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/facebook/UserSettingsManager$UserSetting;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "defaultVal", BuildConfig.FLAVOR, "key", "<init>", "(ZLjava/lang/String;)V", "getValue", "()Z", "Z", "getDefaultVal", "setDefaultVal", "(Z)V", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", UserSettingsManager.VALUE, "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setValue", "(Ljava/lang/Boolean;)V", BuildConfig.FLAVOR, "lastTS", "J", "getLastTS", "()J", "setLastTS", "(J)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class UserSetting {
        private boolean defaultVal;
        private String key;
        private long lastTS;
        private Boolean value;

        public UserSetting(boolean z5, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.defaultVal = z5;
            this.key = key;
        }

        public final boolean getDefaultVal() {
            return this.defaultVal;
        }

        public final String getKey() {
            return this.key;
        }

        public final long getLastTS() {
            return this.lastTS;
        }

        public final Boolean getValue() {
            return this.value;
        }

        public final void setLastTS(long j5) {
            this.lastTS = j5;
        }

        public final void setValue(Boolean bool) {
            this.value = bool;
        }

        /* renamed from: getValue, reason: collision with other method in class */
        public final boolean m2787getValue() {
            Boolean bool = this.value;
            return bool == null ? this.defaultVal : bool.booleanValue();
        }
    }

    private UserSettingsManager() {
    }

    private final boolean checkAutoLogAppEventsEnabled() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Map<String, Boolean> cachedMigratedAutoLogValuesInAppSettings = FetchedAppSettingsManager.getCachedMigratedAutoLogValuesInAppSettings();
            if (cachedMigratedAutoLogValuesInAppSettings != null && !cachedMigratedAutoLogValuesInAppSettings.isEmpty()) {
                Boolean bool = cachedMigratedAutoLogValuesInAppSettings.get("auto_log_app_events_enabled");
                Boolean bool2 = cachedMigratedAutoLogValuesInAppSettings.get("auto_log_app_events_default");
                if (bool != null) {
                    return bool.booleanValue();
                }
                Boolean checkClientSideConfiguration = checkClientSideConfiguration();
                if (checkClientSideConfiguration != null) {
                    return checkClientSideConfiguration.booleanValue();
                }
                if (bool2 == null) {
                    return true;
                }
                return bool2.booleanValue();
            }
            return autoLogAppEventsEnabledLocally.m2787getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final Boolean checkClientSideConfiguration() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Boolean readAutoLogAppEventsSettingFromCache = readAutoLogAppEventsSettingFromCache();
            if (readAutoLogAppEventsSettingFromCache != null) {
                return readAutoLogAppEventsSettingFromCache;
            }
            Boolean loadAutoLogAppEventsSettingFromManifest = loadAutoLogAppEventsSettingFromManifest();
            if (loadAutoLogAppEventsSettingFromManifest == null) {
                return null;
            }
            return loadAutoLogAppEventsSettingFromManifest;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final boolean getAdvertiserIDCollectionEnabled() {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return advertiserIDCollectionEnabled.m2787getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
            return false;
        }
    }

    public static final boolean getAutoInitEnabled() {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return autoInitEnabled.m2787getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
            return false;
        }
    }

    public static final boolean getAutoLogAppEventsEnabled() {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return false;
        }
        try {
            UserSettingsManager userSettingsManager = INSTANCE;
            userSettingsManager.initializeIfNotInitialized();
            return userSettingsManager.checkAutoLogAppEventsEnabled();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
            return false;
        }
    }

    public static final boolean getCodelessSetupEnabled() {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return codelessSetupEnabled.m2787getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
            return false;
        }
    }

    private final void initializeCodelessSetupEnabledAsync() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            UserSetting userSetting = codelessSetupEnabled;
            readSettingFromCache(userSetting);
            final long currentTimeMillis = System.currentTimeMillis();
            if (userSetting.getValue() == null || currentTimeMillis - userSetting.getLastTS() >= TIMEOUT_7D) {
                userSetting.setValue(null);
                userSetting.setLastTS(0L);
                if (isFetchingCodelessStatus.compareAndSet(false, true)) {
                    FacebookSdk.getExecutor().execute(new Runnable() { // from class: d0.p
                        @Override // java.lang.Runnable
                        public final void run() {
                            UserSettingsManager.m2786initializeCodelessSetupEnabledAsync$lambda0(currentTimeMillis);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initializeCodelessSetupEnabledAsync$lambda-0, reason: not valid java name */
    public static final void m2786initializeCodelessSetupEnabledAsync$lambda0(long j5) {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return;
        }
        try {
            if (advertiserIDCollectionEnabled.m2787getValue()) {
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if (queryAppSettings != null && queryAppSettings.getCodelessEventsEnabled()) {
                    AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.INSTANCE.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                    String androidAdvertiserId = (attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) ? null : attributionIdentifiers.getAndroidAdvertiserId();
                    if (androidAdvertiserId != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString(ADVERTISER_ID_KEY, androidAdvertiserId);
                        bundle.putString(APPLICATION_FIELDS, EVENTS_CODELESS_SETUP_ENABLED);
                        GraphRequest newGraphPathRequest = GraphRequest.INSTANCE.newGraphPathRequest(null, "app", null);
                        newGraphPathRequest.setParameters(bundle);
                        JSONObject graphObject = newGraphPathRequest.executeAndWait().getGraphObject();
                        if (graphObject != null) {
                            UserSetting userSetting = codelessSetupEnabled;
                            userSetting.setValue(Boolean.valueOf(graphObject.optBoolean(EVENTS_CODELESS_SETUP_ENABLED, false)));
                            userSetting.setLastTS(j5);
                            INSTANCE.writeSettingToCache(userSetting);
                        }
                    }
                }
            }
            isFetchingCodelessStatus.set(false);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
        }
    }

    private final void initializeIfNotInitialized() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (FacebookSdk.isInitialized() && isInitialized.compareAndSet(false, true)) {
                SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(USER_SETTINGS, 0);
                Intrinsics.checkNotNullExpressionValue(sharedPreferences, "FacebookSdk.getApplicationContext()\n            .getSharedPreferences(USER_SETTINGS, Context.MODE_PRIVATE)");
                userSettingPref = sharedPreferences;
                initializeUserSetting(autoLogAppEventsEnabledLocally, advertiserIDCollectionEnabled, autoInitEnabled);
                initializeCodelessSetupEnabledAsync();
                logWarnings();
                logIfSDKSettingsChanged();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void initializeUserSetting(UserSetting... userSettings) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            int length = userSettings.length;
            int i5 = 0;
            while (i5 < length) {
                UserSetting userSetting = userSettings[i5];
                i5++;
                if (userSetting == codelessSetupEnabled) {
                    initializeCodelessSetupEnabledAsync();
                } else if (userSetting.getValue() == null) {
                    readSettingFromCache(userSetting);
                    if (userSetting.getValue() == null) {
                        loadSettingFromManifest(userSetting);
                    }
                } else {
                    writeSettingToCache(userSetting);
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final Boolean loadAutoLogAppEventsSettingFromManifest() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            validateInitialized();
            try {
                Context applicationContext = FacebookSdk.getApplicationContext();
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    UserSetting userSetting = autoLogAppEventsEnabledLocally;
                    if (bundle.containsKey(userSetting.getKey())) {
                        return Boolean.valueOf(applicationInfo.metaData.getBoolean(userSetting.getKey()));
                    }
                }
            } catch (PackageManager.NameNotFoundException e5) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, e5);
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void loadSettingFromManifest(UserSetting userSetting) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            validateInitialized();
            try {
                Context applicationContext = FacebookSdk.getApplicationContext();
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
                Bundle bundle = applicationInfo.metaData;
                if (bundle == null || !bundle.containsKey(userSetting.getKey())) {
                    return;
                }
                userSetting.setValue(Boolean.valueOf(applicationInfo.metaData.getBoolean(userSetting.getKey(), userSetting.getDefaultVal())));
            } catch (PackageManager.NameNotFoundException e5) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, e5);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public static final void logIfAutoAppLinkEnabled() {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return;
        }
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
            Bundle bundle = applicationInfo.metaData;
            if (bundle == null || !bundle.getBoolean("com.facebook.sdk.AutoAppLinkEnabled", false)) {
                return;
            }
            InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(applicationContext);
            Bundle bundle2 = new Bundle();
            if (!Utility.isAutoAppLinkSetup()) {
                bundle2.putString("SchemeWarning", AUTO_APP_LINK_WARNING);
                Log.w(TAG, AUTO_APP_LINK_WARNING);
            }
            internalAppEventsLogger.logEvent("fb_auto_applink", bundle2);
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
        }
    }

    private final void logIfSDKSettingsChanged() {
        int i5;
        int i6;
        ApplicationInfo applicationInfo;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (isInitialized.get() && FacebookSdk.isInitialized()) {
                Context applicationContext = FacebookSdk.getApplicationContext();
                int i7 = 0;
                int i8 = (autoInitEnabled.m2787getValue() ? 1 : 0) | ((autoLogAppEventsEnabledLocally.m2787getValue() ? 1 : 0) << 1) | ((advertiserIDCollectionEnabled.m2787getValue() ? 1 : 0) << 2) | ((monitorEnabled.m2787getValue() ? 1 : 0) << 3);
                SharedPreferences sharedPreferences = userSettingPref;
                if (sharedPreferences == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                    throw null;
                }
                int i9 = sharedPreferences.getInt(USER_SETTINGS_BITMASK, 0);
                if (i9 != i8) {
                    SharedPreferences sharedPreferences2 = userSettingPref;
                    if (sharedPreferences2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                        throw null;
                    }
                    sharedPreferences2.edit().putInt(USER_SETTINGS_BITMASK, i8).apply();
                    try {
                        applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                        Intrinsics.checkNotNullExpressionValue(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
                    } catch (PackageManager.NameNotFoundException unused) {
                        i5 = 0;
                    }
                    if (applicationInfo.metaData == null) {
                        i6 = 0;
                        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(applicationContext);
                        Bundle bundle = new Bundle();
                        bundle.putInt("usage", i7);
                        bundle.putInt("initial", i6);
                        bundle.putInt("previous", i9);
                        bundle.putInt("current", i8);
                        internalAppEventsLogger.logChangedSettingsEvent(bundle);
                    }
                    String[] strArr = {"com.facebook.sdk.AutoInitEnabled", "com.facebook.sdk.AutoLogAppEventsEnabled", "com.facebook.sdk.AdvertiserIDCollectionEnabled", "com.facebook.sdk.MonitorEnabled"};
                    boolean[] zArr = {true, true, true, true};
                    i5 = 0;
                    i6 = 0;
                    while (true) {
                        int i10 = i7 + 1;
                        try {
                            i5 |= (applicationInfo.metaData.containsKey(strArr[i7]) ? 1 : 0) << i7;
                            i6 |= (applicationInfo.metaData.getBoolean(strArr[i7], zArr[i7]) ? 1 : 0) << i7;
                            if (i10 > 3) {
                                break;
                            } else {
                                i7 = i10;
                            }
                        } catch (PackageManager.NameNotFoundException unused2) {
                            i7 = i6;
                            i6 = i7;
                            i7 = i5;
                            InternalAppEventsLogger internalAppEventsLogger2 = new InternalAppEventsLogger(applicationContext);
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt("usage", i7);
                            bundle2.putInt("initial", i6);
                            bundle2.putInt("previous", i9);
                            bundle2.putInt("current", i8);
                            internalAppEventsLogger2.logChangedSettingsEvent(bundle2);
                        }
                    }
                    i7 = i5;
                    InternalAppEventsLogger internalAppEventsLogger22 = new InternalAppEventsLogger(applicationContext);
                    Bundle bundle22 = new Bundle();
                    bundle22.putInt("usage", i7);
                    bundle22.putInt("initial", i6);
                    bundle22.putInt("previous", i9);
                    bundle22.putInt("current", i8);
                    internalAppEventsLogger22.logChangedSettingsEvent(bundle22);
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void logWarnings() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "ctx.packageManager.getApplicationInfo(ctx.packageName, PackageManager.GET_META_DATA)");
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                if (!bundle.containsKey("com.facebook.sdk.AdvertiserIDCollectionEnabled")) {
                    Log.w(TAG, ADVERTISERID_COLLECTION_NOT_SET_WARNING);
                }
                if (getAdvertiserIDCollectionEnabled()) {
                    return;
                }
                Log.w(TAG, ADVERTISERID_COLLECTION_FALSE_WARNING);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private static final Boolean readAutoLogAppEventsSettingFromCache() {
        SharedPreferences sharedPreferences;
        String str = BuildConfig.FLAVOR;
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return null;
        }
        try {
            INSTANCE.validateInitialized();
            try {
                sharedPreferences = userSettingPref;
            } catch (JSONException e5) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, e5);
            }
            if (sharedPreferences == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                throw null;
            }
            String string = sharedPreferences.getString(autoLogAppEventsEnabledLocally.getKey(), BuildConfig.FLAVOR);
            if (string != null) {
                str = string;
            }
            if (str.length() > 0) {
                return Boolean.valueOf(new JSONObject(str).getBoolean(VALUE));
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
            return null;
        }
    }

    private final void readSettingFromCache(UserSetting userSetting) {
        String str = BuildConfig.FLAVOR;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            validateInitialized();
            try {
                SharedPreferences sharedPreferences = userSettingPref;
                if (sharedPreferences == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                    throw null;
                }
                String string = sharedPreferences.getString(userSetting.getKey(), BuildConfig.FLAVOR);
                if (string != null) {
                    str = string;
                }
                if (str.length() > 0) {
                    JSONObject jSONObject = new JSONObject(str);
                    userSetting.setValue(Boolean.valueOf(jSONObject.getBoolean(VALUE)));
                    userSetting.setLastTS(jSONObject.getLong(LAST_TIMESTAMP));
                }
            } catch (JSONException e5) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, e5);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public static final void setAdvertiserIDCollectionEnabled(boolean flag) {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return;
        }
        try {
            UserSetting userSetting = advertiserIDCollectionEnabled;
            userSetting.setValue(Boolean.valueOf(flag));
            userSetting.setLastTS(System.currentTimeMillis());
            if (isInitialized.get()) {
                INSTANCE.writeSettingToCache(userSetting);
            } else {
                INSTANCE.initializeIfNotInitialized();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
        }
    }

    public static final void setAutoInitEnabled(boolean flag) {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return;
        }
        try {
            UserSetting userSetting = autoInitEnabled;
            userSetting.setValue(Boolean.valueOf(flag));
            userSetting.setLastTS(System.currentTimeMillis());
            if (isInitialized.get()) {
                INSTANCE.writeSettingToCache(userSetting);
            } else {
                INSTANCE.initializeIfNotInitialized();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
        }
    }

    public static final void setAutoLogAppEventsEnabled(boolean flag) {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return;
        }
        try {
            UserSetting userSetting = autoLogAppEventsEnabledLocally;
            userSetting.setValue(Boolean.valueOf(flag));
            userSetting.setLastTS(System.currentTimeMillis());
            if (isInitialized.get()) {
                INSTANCE.writeSettingToCache(userSetting);
            } else {
                INSTANCE.initializeIfNotInitialized();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
        }
    }

    private final void validateInitialized() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (isInitialized.get()) {
            } else {
                throw new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void writeSettingToCache(UserSetting userSetting) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            validateInitialized();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(VALUE, userSetting.getValue());
                jSONObject.put(LAST_TIMESTAMP, userSetting.getLastTS());
                SharedPreferences sharedPreferences = userSettingPref;
                if (sharedPreferences == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userSettingPref");
                    throw null;
                }
                sharedPreferences.edit().putString(userSetting.getKey(), jSONObject.toString()).apply();
                logIfSDKSettingsChanged();
            } catch (Exception e5) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, e5);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
