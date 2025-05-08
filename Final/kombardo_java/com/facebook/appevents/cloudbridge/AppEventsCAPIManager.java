package com.facebook.appevents.cloudbridge;

import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\"\u0010\u0011\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R@\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00178A@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsCAPIManager;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "enable", "Lcom/facebook/GraphResponse;", "response", "getCAPIGSettingsFromGraphResponse$facebook_core_release", "(Lcom/facebook/GraphResponse;)V", "getCAPIGSettingsFromGraphResponse", BuildConfig.FLAVOR, "SETTINGS_PATH", "Ljava/lang/String;", "kotlin.jvm.PlatformType", "TAG", BuildConfig.FLAVOR, "isEnabled", "Z", "isEnabled$facebook_core_release", "()Z", "setEnabled$facebook_core_release", "(Z)V", BuildConfig.FLAVOR, "valuesToSave", "getSavedCloudBridgeCredentials$facebook_core_release", "()Ljava/util/Map;", "setSavedCloudBridgeCredentials$facebook_core_release", "(Ljava/util/Map;)V", "savedCloudBridgeCredentials", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AppEventsCAPIManager {
    private static final String SETTINGS_PATH = "/cloudbridge_settings";
    private static boolean isEnabled;
    public static final AppEventsCAPIManager INSTANCE = new AppEventsCAPIManager();
    private static final String TAG = AppEventsCAPIManager.class.getCanonicalName();

    private AppEventsCAPIManager() {
    }

    public static final void enable() {
        try {
            GraphRequest graphRequest = new GraphRequest(null, Intrinsics.stringPlus(FacebookSdk.getApplicationId(), SETTINGS_PATH), null, HttpMethod.GET, new GraphRequest.Callback() { // from class: g0.a
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    AppEventsCAPIManager.m2815enable$lambda0(graphResponse);
                }
            }, null, 32, null);
            Logger.Companion companion = Logger.INSTANCE;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String str = TAG;
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            companion.log(loggingBehavior, str, " \n\nCreating Graph Request: \n=============\n%s\n\n ", graphRequest);
            graphRequest.executeAsync();
        } catch (JSONException e5) {
            Logger.Companion companion2 = Logger.INSTANCE;
            LoggingBehavior loggingBehavior2 = LoggingBehavior.APP_EVENTS;
            String str2 = TAG;
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            companion2.log(loggingBehavior2, str2, " \n\nGraph Request Exception: \n=============\n%s\n\n ", ExceptionsKt.stackTraceToString(e5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: enable$lambda-0, reason: not valid java name */
    public static final void m2815enable$lambda0(GraphResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        INSTANCE.getCAPIGSettingsFromGraphResponse$facebook_core_release(response);
    }

    public static final Map<String, Object> getSavedCloudBridgeCredentials$facebook_core_release() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsCAPIManager.class)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.CloudBridgeSavedCredentials", 0);
            if (sharedPreferences == null) {
                return null;
            }
            SettingsAPIFields settingsAPIFields = SettingsAPIFields.DATASETID;
            String string = sharedPreferences.getString(settingsAPIFields.getRawValue(), null);
            SettingsAPIFields settingsAPIFields2 = SettingsAPIFields.URL;
            String string2 = sharedPreferences.getString(settingsAPIFields2.getRawValue(), null);
            SettingsAPIFields settingsAPIFields3 = SettingsAPIFields.ACCESSKEY;
            String string3 = sharedPreferences.getString(settingsAPIFields3.getRawValue(), null);
            if (string != null && !StringsKt.isBlank(string) && string2 != null && !StringsKt.isBlank(string2) && string3 != null && !StringsKt.isBlank(string3)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(settingsAPIFields2.getRawValue(), string2);
                linkedHashMap.put(settingsAPIFields.getRawValue(), string);
                linkedHashMap.put(settingsAPIFields3.getRawValue(), string3);
                Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, TAG.toString(), " \n\nLoading Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", string, string2, string3);
                return linkedHashMap;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsCAPIManager.class);
            return null;
        }
    }

    public final void getCAPIGSettingsFromGraphResponse$facebook_core_release(GraphResponse response) {
        boolean z5;
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.getError() != null) {
            Logger.Companion companion = Logger.INSTANCE;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String str = TAG;
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            companion.log(loggingBehavior, str, " \n\nGraph Response Error: \n================\nResponse Error: %s\nResponse Error Exception: %s\n\n ", response.getError().toString(), String.valueOf(response.getError().getException()));
            Map<String, Object> savedCloudBridgeCredentials$facebook_core_release = getSavedCloudBridgeCredentials$facebook_core_release();
            if (savedCloudBridgeCredentials$facebook_core_release != null) {
                URL url = new URL(String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.URL.getRawValue())));
                AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = AppEventsConversionsAPITransformerWebRequests.INSTANCE;
                AppEventsConversionsAPITransformerWebRequests.configure(String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.DATASETID.getRawValue())), url.getProtocol() + "://" + ((Object) url.getHost()), String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.ACCESSKEY.getRawValue())));
                isEnabled = true;
                return;
            }
            return;
        }
        Logger.Companion companion2 = Logger.INSTANCE;
        LoggingBehavior loggingBehavior2 = LoggingBehavior.APP_EVENTS;
        String TAG2 = TAG;
        if (TAG2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        companion2.log(loggingBehavior2, TAG2, " \n\nGraph Response Received: \n================\n%s\n\n ", response);
        JSONObject graphObject = response.getGraphObject();
        try {
            Utility utility = Utility.INSTANCE;
            Object obj = graphObject == null ? null : graphObject.get("data");
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
            }
            Map<String, ? extends Object> convertJSONObjectToHashMap = Utility.convertJSONObjectToHashMap(new JSONObject((String) CollectionsKt.firstOrNull((List) Utility.convertJSONArrayToList((JSONArray) obj))));
            String str2 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.URL.getRawValue());
            String str3 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.DATASETID.getRawValue());
            String str4 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.ACCESSKEY.getRawValue());
            if (str2 == null || str3 == null || str4 == null) {
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                companion2.log(loggingBehavior2, TAG2, "CloudBridge Settings API response doesn't have valid data");
                return;
            }
            try {
                AppEventsConversionsAPITransformerWebRequests.configure(str3, str2, str4);
                setSavedCloudBridgeCredentials$facebook_core_release(convertJSONObjectToHashMap);
                SettingsAPIFields settingsAPIFields = SettingsAPIFields.ENABLED;
                if (convertJSONObjectToHashMap.get(settingsAPIFields.getRawValue()) != null) {
                    Object obj2 = convertJSONObjectToHashMap.get(settingsAPIFields.getRawValue());
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    z5 = ((Boolean) obj2).booleanValue();
                } else {
                    z5 = false;
                }
                isEnabled = z5;
            } catch (MalformedURLException e5) {
                Logger.Companion companion3 = Logger.INSTANCE;
                LoggingBehavior loggingBehavior3 = LoggingBehavior.APP_EVENTS;
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                companion3.log(loggingBehavior3, TAG3, "CloudBridge Settings API response doesn't have valid url\n %s ", ExceptionsKt.stackTraceToString(e5));
            }
        } catch (NullPointerException e6) {
            Logger.Companion companion4 = Logger.INSTANCE;
            LoggingBehavior loggingBehavior4 = LoggingBehavior.APP_EVENTS;
            String TAG4 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            companion4.log(loggingBehavior4, TAG4, "CloudBridge Settings API response is not a valid json: \n%s ", ExceptionsKt.stackTraceToString(e6));
        } catch (JSONException e7) {
            Logger.Companion companion5 = Logger.INSTANCE;
            LoggingBehavior loggingBehavior5 = LoggingBehavior.APP_EVENTS;
            String TAG5 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
            companion5.log(loggingBehavior5, TAG5, "CloudBridge Settings API response is not a valid json: \n%s ", ExceptionsKt.stackTraceToString(e7));
        }
    }

    public final boolean isEnabled$facebook_core_release() {
        return isEnabled;
    }

    public final void setSavedCloudBridgeCredentials$facebook_core_release(Map<String, ? extends Object> map) {
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.CloudBridgeSavedCredentials", 0);
        if (sharedPreferences == null) {
            return;
        }
        if (map == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.clear();
            edit.apply();
            return;
        }
        SettingsAPIFields settingsAPIFields = SettingsAPIFields.DATASETID;
        Object obj = map.get(settingsAPIFields.getRawValue());
        SettingsAPIFields settingsAPIFields2 = SettingsAPIFields.URL;
        Object obj2 = map.get(settingsAPIFields2.getRawValue());
        SettingsAPIFields settingsAPIFields3 = SettingsAPIFields.ACCESSKEY;
        Object obj3 = map.get(settingsAPIFields3.getRawValue());
        if (obj == null || obj2 == null || obj3 == null) {
            return;
        }
        SharedPreferences.Editor edit2 = sharedPreferences.edit();
        edit2.putString(settingsAPIFields.getRawValue(), obj.toString());
        edit2.putString(settingsAPIFields2.getRawValue(), obj2.toString());
        edit2.putString(settingsAPIFields3.getRawValue(), obj3.toString());
        edit2.apply();
        Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, TAG.toString(), " \n\nSaving Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", obj, obj2, obj3);
    }
}
