package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.sun.jna.Callback;
import e.AbstractC0321h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002tuB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u001b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u001d\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J1\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001c0\u001b0\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b!\u0010\"J#\u0010&\u001a\u0004\u0018\u00010%2\b\u0010#\u001a\u0004\u0018\u00010\u00172\u0006\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010'J)\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010*2\b\u0010(\u001a\u0004\u0018\u00010\u00172\u0006\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010,J[\u00101\u001a:\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060*0/\u0018\u00010.j\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060*0/\u0018\u0001`02\b\u0010(\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010-\u001a\u00020\u0011H\u0002¢\u0006\u0004\b1\u00102J'\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\u00103\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b4\u0010\u001eJ\u001f\u00107\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0017H\u0000¢\u0006\u0004\b5\u00106R\u001c\u00109\u001a\n 8*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u0010:R\u0014\u0010<\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010:R\u0014\u0010=\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u0010:R\u0014\u0010>\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u0010:R\u0014\u0010?\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u0010:R\u0014\u0010@\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u0010:R\u0014\u0010A\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u0010:R\u0014\u0010B\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u0010:R\u0014\u0010C\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u0010:R\u0014\u0010D\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u0010:R\u0014\u0010E\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010:R\u0014\u0010F\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u0010:R\u0014\u0010H\u001a\u00020G8\u0002X\u0082T¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010J\u001a\u00020G8\u0002X\u0082T¢\u0006\u0006\n\u0004\bJ\u0010IR\u0014\u0010K\u001a\u00020G8\u0002X\u0082T¢\u0006\u0006\n\u0004\bK\u0010IR\u0014\u0010L\u001a\u00020G8\u0002X\u0082T¢\u0006\u0006\n\u0004\bL\u0010IR\u0014\u0010M\u001a\u00020G8\u0002X\u0082T¢\u0006\u0006\n\u0004\bM\u0010IR\u0014\u0010N\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bN\u0010:R\u0014\u0010O\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bO\u0010:R\u0014\u0010P\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bP\u0010:R\u0014\u0010Q\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bQ\u0010:R\u0014\u0010R\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bR\u0010:R\u0014\u0010S\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bS\u0010:R\u0014\u0010T\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bT\u0010:R\u0014\u0010U\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bU\u0010:R\u0014\u0010V\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bV\u0010:R\u0014\u0010W\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bW\u0010:R\u0014\u0010X\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bX\u0010:R\u0014\u0010Y\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bY\u0010:R\u0014\u0010Z\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bZ\u0010:R\u0014\u0010[\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b[\u0010:R\u0014\u0010\\\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\\\u0010:R\u0014\u0010]\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b]\u0010:R\u0014\u0010^\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b^\u0010:R\u0014\u0010_\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b_\u0010:R\u0014\u0010`\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b`\u0010:R\u0014\u0010a\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\ba\u0010:R\u0014\u0010b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bb\u0010:R\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00060*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\be\u0010:R \u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\"\u0010j\u001a\u0010\u0012\f\u0012\n 8*\u0004\u0018\u00010i0i0h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u001a\u0010m\u001a\b\u0012\u0004\u0012\u00020\u000b0l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010o\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010q\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010pR\u0018\u0010r\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010s¨\u0006v"}, d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "loadAppSettingsAsync", BuildConfig.FLAVOR, "applicationId", "Lcom/facebook/internal/FetchedAppSettings;", "getAppSettingsWithoutQuery", "(Ljava/lang/String;)Lcom/facebook/internal/FetchedAppSettings;", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", Callback.METHOD_NAME, "getAppSettingsAsync", "(Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;)V", "pollCallbacks", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getCachedMigratedAutoLogValuesInAppSettings", "()Ljava/util/Map;", "forceRequery", "queryAppSettings", "(Ljava/lang/String;Z)Lcom/facebook/internal/FetchedAppSettings;", "Lorg/json/JSONObject;", "getAppSettingsQueryResponse", "(Ljava/lang/String;)Lorg/json/JSONObject;", "dialogConfigResponse", BuildConfig.FLAVOR, "Lcom/facebook/internal/FetchedAppSettings$DialogFeatureConfig;", "parseDialogConfigurations", "(Lorg/json/JSONObject;)Ljava/util/Map;", "parameters", BuildConfig.FLAVOR, "parseDedupeWindow", "(Lorg/json/JSONObject;)Ljava/lang/Long;", "protectedModeSettings", "ruleType", "Lorg/json/JSONArray;", "parseProtectedModeRules", "(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;", "originalJSON", FetchedAppSettingsManager.KEY, BuildConfig.FLAVOR, "parseCurrencyAndValueDedupeParameters", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/util/List;", "getTestValues", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "parseDedupeParameters", "(Lorg/json/JSONObject;Z)Ljava/util/ArrayList;", "settingsJSON", "parseMigratedAutoLogValues", "parseAppSettingsFromJSON$facebook_core_release", "(Ljava/lang/String;Lorg/json/JSONObject;)Lcom/facebook/internal/FetchedAppSettings;", "parseAppSettingsFromJSON", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "APP_SETTINGS_PREFS_STORE", "APP_SETTINGS_PREFS_KEY_FORMAT", "APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING", "APP_SETTING_NUX_CONTENT", "APP_SETTING_NUX_ENABLED", "APP_SETTING_DIALOG_CONFIGS", "APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES", "APP_SETTING_APP_EVENTS_SESSION_TIMEOUT", "APP_SETTING_APP_EVENTS_FEATURE_BITMASK", "APP_SETTING_APP_EVENTS_EVENT_BINDINGS", "APP_SETTING_APP_EVENTS_CONFIG", "APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD", BuildConfig.FLAVOR, "AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD", "I", "IAP_AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD", "CODELESS_EVENTS_ENABLED_BITMASK_FIELD", "TRACK_UNINSTALL_ENABLED_BITMASK_FIELD", "MONITOR_ENABLED_BITMASK_FIELD", "APP_SETTING_SMART_LOGIN_OPTIONS", "SMART_LOGIN_BOOKMARK_ICON_URL", "SMART_LOGIN_MENU_ICON_URL", "SDK_UPDATE_MESSAGE", "APP_SETTING_APP_EVENTS_AAM_RULE", "SUGGESTED_EVENTS_SETTING", "PROTECTED_MODE_RULES", "STANDARD_PARAMS_KEY", "MACA_RULES_KEY", "BLOCKLIST_EVENTS_KEY", "REDACTED_EVENTS_KEY", "SENSITIVE_PARAMS_KEY", "DEDUPE_KEY", "ANDROID_DEDUPE_KEY", "PROD_DEDUPE_KEY", "TEST_DEDUPE_KEY", "KEY", "VALUE", "DEDUPE_WINDOW", "STD_PARAMS_SCHEMA_KEY", "STD_PARAMS_BLOCKED_KEY", "APP_SETTING_FIELDS", "Ljava/util/List;", "APPLICATION_FIELDS", "fetchedAppSettings", "Ljava/util/Map;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchAppSettingState;", "loadingState", "Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "fetchedAppSettingsCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "printedSDKUpdatedMessage", "Z", "isUnityInit", "unityEventBindings", "Lorg/json/JSONArray;", "FetchAppSettingState", "FetchedAppSettingsCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FetchedAppSettingsManager {
    private static final String ANDROID_DEDUPE_KEY = "FBAndroidSDK";
    private static final String APPLICATION_FIELDS = "fields";
    private static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
    private static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
    private static final String APP_SETTING_APP_EVENTS_CONFIG = "app_events_config";
    private static final int AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 8;
    private static final String BLOCKLIST_EVENTS_KEY = "blocklist_events";
    private static final int CODELESS_EVENTS_ENABLED_BITMASK_FIELD = 32;
    private static final String DEDUPE_KEY = "iap_manual_and_auto_log_dedup_keys";
    private static final String DEDUPE_WINDOW = "iap_manual_and_auto_log_dedup_window_millis";
    private static final int IAP_AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 16;
    private static final String KEY = "key";
    private static final String MACA_RULES_KEY = "maca_rules";
    private static final int MONITOR_ENABLED_BITMASK_FIELD = 16384;
    private static final String PROD_DEDUPE_KEY = "prod_keys";
    private static final String REDACTED_EVENTS_KEY = "redacted_events";
    private static final String SDK_UPDATE_MESSAGE = "sdk_update_message";
    private static final String SENSITIVE_PARAMS_KEY = "sensitive_params";
    private static final String STANDARD_PARAMS_KEY = "standard_params";
    private static final String STD_PARAMS_BLOCKED_KEY = "standard_params_blocked";
    private static final String STD_PARAMS_SCHEMA_KEY = "standard_params_schema";
    private static final String TEST_DEDUPE_KEY = "test_keys";
    private static final int TRACK_UNINSTALL_ENABLED_BITMASK_FIELD = 256;
    private static final String VALUE = "value";
    private static boolean isUnityInit;
    private static boolean printedSDKUpdatedMessage;
    private static JSONArray unityEventBindings;
    public static final FetchedAppSettingsManager INSTANCE = new FetchedAppSettingsManager();
    private static final String TAG = FetchedAppSettingsManager.class.getSimpleName();
    private static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
    private static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
    private static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
    private static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
    private static final String APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES = "android_sdk_error_categories";
    private static final String APP_SETTING_APP_EVENTS_SESSION_TIMEOUT = "app_events_session_timeout";
    private static final String APP_SETTING_APP_EVENTS_FEATURE_BITMASK = "app_events_feature_bitmask";
    private static final String APP_SETTING_APP_EVENTS_EVENT_BINDINGS = "auto_event_mapping_android";
    private static final String APP_SETTING_SMART_LOGIN_OPTIONS = "seamless_login";
    private static final String SMART_LOGIN_BOOKMARK_ICON_URL = "smart_login_bookmark_icon_url";
    private static final String SMART_LOGIN_MENU_ICON_URL = "smart_login_menu_icon_url";
    private static final String APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD = "restrictive_data_filter_params";
    private static final String APP_SETTING_APP_EVENTS_AAM_RULE = "aam_rules";
    private static final String SUGGESTED_EVENTS_SETTING = "suggested_events_setting";
    private static final String PROTECTED_MODE_RULES = "protected_mode_rules";
    private static final List<String> APP_SETTING_FIELDS = CollectionsKt.listOf((Object[]) new String[]{APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, APP_SETTING_NUX_CONTENT, APP_SETTING_NUX_ENABLED, APP_SETTING_DIALOG_CONFIGS, APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES, APP_SETTING_APP_EVENTS_SESSION_TIMEOUT, APP_SETTING_APP_EVENTS_FEATURE_BITMASK, APP_SETTING_APP_EVENTS_EVENT_BINDINGS, APP_SETTING_SMART_LOGIN_OPTIONS, SMART_LOGIN_BOOKMARK_ICON_URL, SMART_LOGIN_MENU_ICON_URL, APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD, APP_SETTING_APP_EVENTS_AAM_RULE, SUGGESTED_EVENTS_SETTING, PROTECTED_MODE_RULES, "auto_log_app_events_default", "auto_log_app_events_enabled", "app_events_config.os_version(" + ((Object) Build.VERSION.RELEASE) + ')'});
    private static final Map<String, FetchedAppSettings> fetchedAppSettings = new ConcurrentHashMap();
    private static final AtomicReference<FetchAppSettingState> loadingState = new AtomicReference<>(FetchAppSettingState.NOT_LOADED);
    private static final ConcurrentLinkedQueue<FetchedAppSettingsCallback> fetchedAppSettingsCallbacks = new ConcurrentLinkedQueue<>();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager$FetchAppSettingState;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "NOT_LOADED", "LOADING", "SUCCESS", "ERROR", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public enum FetchAppSettingState {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static FetchAppSettingState[] valuesCustom() {
            FetchAppSettingState[] valuesCustom = values();
            return (FetchAppSettingState[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", BuildConfig.FLAVOR, "onError", BuildConfig.FLAVOR, "onSuccess", "fetchedAppSettings", "Lcom/facebook/internal/FetchedAppSettings;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public interface FetchedAppSettingsCallback {
        void onError();

        void onSuccess(FetchedAppSettings fetchedAppSettings);
    }

    private FetchedAppSettingsManager() {
    }

    public static final void getAppSettingsAsync(FetchedAppSettingsCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        fetchedAppSettingsCallbacks.add(callback);
        loadAppSettingsAsync();
    }

    private final JSONObject getAppSettingsQueryResponse(String applicationId) {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(APP_SETTING_FIELDS);
        bundle.putString(APPLICATION_FIELDS, TextUtils.join(",", arrayList));
        GraphRequest newGraphPathRequest = GraphRequest.INSTANCE.newGraphPathRequest(null, "app", null);
        newGraphPathRequest.setForceApplicationRequest(true);
        newGraphPathRequest.setParameters(bundle);
        JSONObject jsonObject = newGraphPathRequest.executeAndWait().getJsonObject();
        return jsonObject == null ? new JSONObject() : jsonObject;
    }

    public static final FetchedAppSettings getAppSettingsWithoutQuery(String applicationId) {
        if (applicationId != null) {
            return fetchedAppSettings.get(applicationId);
        }
        return null;
    }

    public static final Map<String, Boolean> getCachedMigratedAutoLogValuesInAppSettings() {
        JSONObject jSONObject;
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(APP_SETTINGS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        String string = applicationContext.getSharedPreferences(APP_SETTINGS_PREFS_STORE, 0).getString(format, null);
        if (!Utility.isNullOrEmpty(string)) {
            if (string == null) {
                throw new IllegalStateException("Required value was null.");
            }
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e5) {
                Utility.logd("FacebookSDK", e5);
                jSONObject = null;
            }
            if (jSONObject != null) {
                return INSTANCE.parseMigratedAutoLogValues(jSONObject);
            }
        }
        return null;
    }

    public static final void loadAppSettingsAsync() {
        final Context applicationContext = FacebookSdk.getApplicationContext();
        final String applicationId = FacebookSdk.getApplicationId();
        if (Utility.isNullOrEmpty(applicationId)) {
            loadingState.set(FetchAppSettingState.ERROR);
            INSTANCE.pollCallbacks();
            return;
        }
        if (fetchedAppSettings.containsKey(applicationId)) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            INSTANCE.pollCallbacks();
            return;
        }
        AtomicReference<FetchAppSettingState> atomicReference = loadingState;
        FetchAppSettingState fetchAppSettingState = FetchAppSettingState.NOT_LOADED;
        FetchAppSettingState fetchAppSettingState2 = FetchAppSettingState.LOADING;
        if (!AbstractC0321h.a(atomicReference, fetchAppSettingState, fetchAppSettingState2) && !AbstractC0321h.a(atomicReference, FetchAppSettingState.ERROR, fetchAppSettingState2)) {
            INSTANCE.pollCallbacks();
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        final String format = String.format(APP_SETTINGS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        FacebookSdk.getExecutor().execute(new Runnable() { // from class: o0.f
            @Override // java.lang.Runnable
            public final void run() {
                FetchedAppSettingsManager.m2857loadAppSettingsAsync$lambda0(applicationContext, format, applicationId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadAppSettingsAsync$lambda-0, reason: not valid java name */
    public static final void m2857loadAppSettingsAsync$lambda0(Context context, String settingsKey, String applicationId) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(settingsKey, "$settingsKey");
        Intrinsics.checkNotNullParameter(applicationId, "$applicationId");
        SharedPreferences sharedPreferences = context.getSharedPreferences(APP_SETTINGS_PREFS_STORE, 0);
        FetchedAppSettings fetchedAppSettings2 = null;
        String string = sharedPreferences.getString(settingsKey, null);
        if (!Utility.isNullOrEmpty(string)) {
            if (string == null) {
                throw new IllegalStateException("Required value was null.");
            }
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e5) {
                Utility.logd("FacebookSDK", e5);
                jSONObject = null;
            }
            if (jSONObject != null) {
                fetchedAppSettings2 = INSTANCE.parseAppSettingsFromJSON$facebook_core_release(applicationId, jSONObject);
            }
        }
        FetchedAppSettingsManager fetchedAppSettingsManager = INSTANCE;
        JSONObject appSettingsQueryResponse = fetchedAppSettingsManager.getAppSettingsQueryResponse(applicationId);
        if (appSettingsQueryResponse != null) {
            fetchedAppSettingsManager.parseAppSettingsFromJSON$facebook_core_release(applicationId, appSettingsQueryResponse);
            sharedPreferences.edit().putString(settingsKey, appSettingsQueryResponse.toString()).apply();
        }
        if (fetchedAppSettings2 != null) {
            String sdkUpdateMessage = fetchedAppSettings2.getSdkUpdateMessage();
            if (!printedSDKUpdatedMessage && sdkUpdateMessage != null && sdkUpdateMessage.length() > 0) {
                printedSDKUpdatedMessage = true;
                Log.w(TAG, sdkUpdateMessage);
            }
        }
        FetchedAppGateKeepersManager.queryAppGateKeepers(applicationId, true);
        AutomaticAnalyticsLogger.logActivateAppEvent();
        loadingState.set(fetchedAppSettings.containsKey(applicationId) ? FetchAppSettingState.SUCCESS : FetchAppSettingState.ERROR);
        fetchedAppSettingsManager.pollCallbacks();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
    
        r12 = r8.getJSONArray(com.facebook.internal.FetchedAppSettingsManager.VALUE);
        r13 = new java.util.ArrayList();
        r0 = r12.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r0 <= 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        r3 = r4 + 1;
        r13.add(r12.getJSONObject(r4).getString(com.facebook.internal.FetchedAppSettingsManager.VALUE));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006b, code lost:
    
        if (r3 < r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006e, code lost:
    
        r4 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0070, code lost:
    
        r12 = new java.util.ArrayList();
        r12.addAll(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0078, code lost:
    
        return r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<String> parseCurrencyAndValueDedupeParameters(JSONObject originalJSON, String key) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        int length;
        if (originalJSON == null) {
            jSONArray = null;
        } else {
            try {
                jSONArray = originalJSON.getJSONArray(DEDUPE_KEY);
            } catch (Exception unused) {
            }
        }
        if (jSONArray != null && (r3 = jSONArray.length()) > 0) {
            int i5 = 0;
            int i6 = 0;
            loop0: while (true) {
                int i7 = i6 + 1;
                JSONObject jSONObject = jSONArray.getJSONObject(i6);
                if (Intrinsics.areEqual(jSONObject.getString(KEY), PROD_DEDUPE_KEY) && (length = (jSONArray2 = jSONObject.getJSONArray(VALUE)).length()) > 0) {
                    int i8 = 0;
                    while (true) {
                        int i9 = i8 + 1;
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i8);
                        if (Intrinsics.areEqual(jSONObject2.getString(KEY), key)) {
                            break loop0;
                        }
                        if (i9 >= length) {
                            break;
                        }
                        i8 = i9;
                    }
                }
                i6 = i7;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
    
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ArrayList<Pair<String, List<String>>> parseDedupeParameters(JSONObject originalJSON, boolean getTestValues) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        if (originalJSON == null) {
            jSONArray = null;
        } else {
            try {
                jSONArray = originalJSON.getJSONArray(DEDUPE_KEY);
            } catch (Exception unused) {
                return null;
            }
        }
        if (jSONArray == null || (r4 = jSONArray.length()) <= 0) {
            return null;
        }
        ArrayList<Pair<String, List<String>>> arrayList = null;
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            JSONObject jSONObject = jSONArray.getJSONObject(i5);
            String string = jSONObject.getString(KEY);
            if ((!Intrinsics.areEqual(string, PROD_DEDUPE_KEY) || !getTestValues) && ((!Intrinsics.areEqual(string, TEST_DEDUPE_KEY) || getTestValues) && (r9 = (jSONArray2 = jSONObject.getJSONArray(VALUE)).length()) > 0)) {
                int i7 = 0;
                while (true) {
                    int i8 = i7 + 1;
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i7);
                    String string2 = jSONObject2.getString(KEY);
                    if (!Intrinsics.areEqual(string2, "_valueToSum") && !Intrinsics.areEqual(string2, "fb_currency")) {
                        JSONArray jSONArray3 = jSONObject2.getJSONArray(VALUE);
                        ArrayList arrayList2 = new ArrayList();
                        int length = jSONArray3.length();
                        if (length > 0) {
                            int i9 = 0;
                            while (true) {
                                int i10 = i9 + 1;
                                arrayList2.add(jSONArray3.getJSONObject(i9).getString(VALUE));
                                if (i10 >= length) {
                                    break;
                                }
                                i9 = i10;
                            }
                        }
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        arrayList.add(new Pair<>(string2, arrayList2));
                    }
                    i7 = i8;
                }
            }
            i5 = i6;
        }
    }

    static /* synthetic */ ArrayList parseDedupeParameters$default(FetchedAppSettingsManager fetchedAppSettingsManager, JSONObject jSONObject, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return fetchedAppSettingsManager.parseDedupeParameters(jSONObject, z5);
    }

    private final Long parseDedupeWindow(JSONObject parameters) {
        if (parameters != null) {
            try {
            } catch (Exception unused) {
                return null;
            }
        }
        return Long.valueOf(parameters.optLong(DEDUPE_WINDOW));
    }

    private final Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations(JSONObject dialogConfigResponse) {
        JSONArray optJSONArray;
        int length;
        HashMap hashMap = new HashMap();
        if (dialogConfigResponse != null && (optJSONArray = dialogConfigResponse.optJSONArray("data")) != null && (length = optJSONArray.length()) > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                FetchedAppSettings.DialogFeatureConfig.Companion companion = FetchedAppSettings.DialogFeatureConfig.INSTANCE;
                JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "dialogConfigData.optJSONObject(i)");
                FetchedAppSettings.DialogFeatureConfig parseDialogConfig = companion.parseDialogConfig(optJSONObject);
                if (parseDialogConfig != null) {
                    String dialogName = parseDialogConfig.getDialogName();
                    Map map = (Map) hashMap.get(dialogName);
                    if (map == null) {
                        map = new HashMap();
                        hashMap.put(dialogName, map);
                    }
                    map.put(parseDialogConfig.getFeatureName(), parseDialogConfig);
                }
                if (i6 >= length) {
                    break;
                }
                i5 = i6;
            }
        }
        return hashMap;
    }

    private final Map<String, Boolean> parseMigratedAutoLogValues(JSONObject settingsJSON) {
        if (settingsJSON == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (!settingsJSON.isNull("auto_log_app_events_default")) {
            try {
                hashMap.put("auto_log_app_events_default", Boolean.valueOf(settingsJSON.getBoolean("auto_log_app_events_default")));
            } catch (JSONException e5) {
                Utility.logd("FacebookSDK", e5);
            }
        }
        if (!settingsJSON.isNull("auto_log_app_events_enabled")) {
            try {
                hashMap.put("auto_log_app_events_enabled", Boolean.valueOf(settingsJSON.getBoolean("auto_log_app_events_enabled")));
            } catch (JSONException e6) {
                Utility.logd("FacebookSDK", e6);
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    private final JSONArray parseProtectedModeRules(JSONObject protectedModeSettings, String ruleType) {
        if (protectedModeSettings != null) {
            return protectedModeSettings.optJSONArray(ruleType);
        }
        return null;
    }

    private final synchronized void pollCallbacks() {
        FetchAppSettingState fetchAppSettingState = loadingState.get();
        if (FetchAppSettingState.NOT_LOADED != fetchAppSettingState && FetchAppSettingState.LOADING != fetchAppSettingState) {
            final FetchedAppSettings fetchedAppSettings2 = fetchedAppSettings.get(FacebookSdk.getApplicationId());
            Handler handler = new Handler(Looper.getMainLooper());
            if (FetchAppSettingState.ERROR == fetchAppSettingState) {
                while (true) {
                    ConcurrentLinkedQueue<FetchedAppSettingsCallback> concurrentLinkedQueue = fetchedAppSettingsCallbacks;
                    if (concurrentLinkedQueue.isEmpty()) {
                        return;
                    }
                    final FetchedAppSettingsCallback poll = concurrentLinkedQueue.poll();
                    handler.post(new Runnable() { // from class: o0.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            FetchedAppSettingsManager.FetchedAppSettingsCallback.this.onError();
                        }
                    });
                }
            } else {
                while (true) {
                    ConcurrentLinkedQueue<FetchedAppSettingsCallback> concurrentLinkedQueue2 = fetchedAppSettingsCallbacks;
                    if (concurrentLinkedQueue2.isEmpty()) {
                        return;
                    }
                    final FetchedAppSettingsCallback poll2 = concurrentLinkedQueue2.poll();
                    handler.post(new Runnable() { // from class: o0.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            FetchedAppSettingsManager.FetchedAppSettingsCallback.this.onSuccess(fetchedAppSettings2);
                        }
                    });
                }
            }
        }
    }

    public static final FetchedAppSettings queryAppSettings(String applicationId, boolean forceRequery) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        if (!forceRequery) {
            Map<String, FetchedAppSettings> map = fetchedAppSettings;
            if (map.containsKey(applicationId)) {
                return map.get(applicationId);
            }
        }
        FetchedAppSettingsManager fetchedAppSettingsManager = INSTANCE;
        JSONObject appSettingsQueryResponse = fetchedAppSettingsManager.getAppSettingsQueryResponse(applicationId);
        if (appSettingsQueryResponse == null) {
            return null;
        }
        FetchedAppSettings parseAppSettingsFromJSON$facebook_core_release = fetchedAppSettingsManager.parseAppSettingsFromJSON$facebook_core_release(applicationId, appSettingsQueryResponse);
        if (Intrinsics.areEqual(applicationId, FacebookSdk.getApplicationId())) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            fetchedAppSettingsManager.pollCallbacks();
        }
        return parseAppSettingsFromJSON$facebook_core_release;
    }

    public final FetchedAppSettings parseAppSettingsFromJSON$facebook_core_release(String applicationId, JSONObject settingsJSON) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(settingsJSON, "settingsJSON");
        JSONArray optJSONArray = settingsJSON.optJSONArray(APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES);
        FacebookRequestErrorClassification.Companion companion = FacebookRequestErrorClassification.INSTANCE;
        FacebookRequestErrorClassification createFromJSON = companion.createFromJSON(optJSONArray);
        if (createFromJSON == null) {
            createFromJSON = companion.getDefaultErrorClassification();
        }
        FacebookRequestErrorClassification facebookRequestErrorClassification = createFromJSON;
        int optInt = settingsJSON.optInt(APP_SETTING_APP_EVENTS_FEATURE_BITMASK, 0);
        boolean z5 = (optInt & 8) != 0;
        boolean z6 = (optInt & 16) != 0;
        boolean z7 = (optInt & 32) != 0;
        boolean z8 = (optInt & 256) != 0;
        boolean z9 = (optInt & MONITOR_ENABLED_BITMASK_FIELD) != 0;
        JSONArray optJSONArray2 = settingsJSON.optJSONArray(APP_SETTING_APP_EVENTS_EVENT_BINDINGS);
        unityEventBindings = optJSONArray2;
        if (optJSONArray2 != null && InternalSettings.isUnityApp()) {
            UnityReflection unityReflection = UnityReflection.INSTANCE;
            UnityReflection.sendEventMapping(optJSONArray2 == null ? null : optJSONArray2.toString());
        }
        JSONObject optJSONObject = settingsJSON.optJSONObject(APP_SETTING_APP_EVENTS_CONFIG);
        boolean optBoolean = settingsJSON.optBoolean(APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, false);
        String optString = settingsJSON.optString(APP_SETTING_NUX_CONTENT, BuildConfig.FLAVOR);
        Intrinsics.checkNotNullExpressionValue(optString, "settingsJSON.optString(APP_SETTING_NUX_CONTENT, \"\")");
        boolean optBoolean2 = settingsJSON.optBoolean(APP_SETTING_NUX_ENABLED, false);
        int optInt2 = settingsJSON.optInt(APP_SETTING_APP_EVENTS_SESSION_TIMEOUT, Constants.getDefaultAppEventsSessionTimeoutInSeconds());
        EnumSet<SmartLoginOption> parseOptions = SmartLoginOption.INSTANCE.parseOptions(settingsJSON.optLong(APP_SETTING_SMART_LOGIN_OPTIONS));
        Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations = parseDialogConfigurations(settingsJSON.optJSONObject(APP_SETTING_DIALOG_CONFIGS));
        String optString2 = settingsJSON.optString(SMART_LOGIN_BOOKMARK_ICON_URL);
        Intrinsics.checkNotNullExpressionValue(optString2, "settingsJSON.optString(SMART_LOGIN_BOOKMARK_ICON_URL)");
        String optString3 = settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL);
        Intrinsics.checkNotNullExpressionValue(optString3, "settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL)");
        String optString4 = settingsJSON.optString(SDK_UPDATE_MESSAGE);
        Intrinsics.checkNotNullExpressionValue(optString4, "settingsJSON.optString(SDK_UPDATE_MESSAGE)");
        FetchedAppSettings fetchedAppSettings2 = new FetchedAppSettings(optBoolean, optString, optBoolean2, optInt2, parseOptions, parseDialogConfigurations, z5, facebookRequestErrorClassification, optString2, optString3, z6, z7, optJSONArray2, optString4, z8, z9, settingsJSON.optString(APP_SETTING_APP_EVENTS_AAM_RULE), settingsJSON.optString(SUGGESTED_EVENTS_SETTING), settingsJSON.optString(APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD), parseProtectedModeRules(settingsJSON.optJSONObject(PROTECTED_MODE_RULES), STANDARD_PARAMS_KEY), parseProtectedModeRules(settingsJSON.optJSONObject(PROTECTED_MODE_RULES), MACA_RULES_KEY), parseMigratedAutoLogValues(settingsJSON), parseProtectedModeRules(settingsJSON.optJSONObject(PROTECTED_MODE_RULES), BLOCKLIST_EVENTS_KEY), parseProtectedModeRules(settingsJSON.optJSONObject(PROTECTED_MODE_RULES), REDACTED_EVENTS_KEY), parseProtectedModeRules(settingsJSON.optJSONObject(PROTECTED_MODE_RULES), SENSITIVE_PARAMS_KEY), parseProtectedModeRules(settingsJSON.optJSONObject(PROTECTED_MODE_RULES), STD_PARAMS_SCHEMA_KEY), parseProtectedModeRules(settingsJSON.optJSONObject(PROTECTED_MODE_RULES), STD_PARAMS_BLOCKED_KEY), parseCurrencyAndValueDedupeParameters(optJSONObject, "fb_currency"), parseCurrencyAndValueDedupeParameters(optJSONObject, "_valueToSum"), parseDedupeParameters$default(this, optJSONObject, false, 2, null), parseDedupeParameters(optJSONObject, true), parseDedupeWindow(settingsJSON.optJSONObject(APP_SETTING_APP_EVENTS_CONFIG)));
        fetchedAppSettings.put(applicationId, fetchedAppSettings2);
        return fetchedAppSettings2;
    }
}
