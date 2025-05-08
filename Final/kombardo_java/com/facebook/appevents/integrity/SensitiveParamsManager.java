package com.facebook.appevents.integrity;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J!\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\t2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000ej\b\u0012\u0004\u0012\u00020\t`\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R2\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\u000ej\b\u0012\u0004\u0012\u00020\t`\u000f0\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/facebook/appevents/integrity/SensitiveParamsManager;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "enable", "loadSensitiveParameters", "Landroid/os/Bundle;", "parameters", BuildConfig.FLAVOR, "eventName", "processFilterSensitiveParams", "(Landroid/os/Bundle;Ljava/lang/String;)V", "parameterKey", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "sensitiveParamsForEvent", BuildConfig.FLAVOR, "shouldFilterOut", "(Ljava/lang/String;Ljava/util/HashSet;)Z", "enabled", "Z", "defaultSensitiveParameters", "Ljava/util/HashSet;", BuildConfig.FLAVOR, "sensitiveParameters", "Ljava/util/Map;", "DEFAULT_SENSITIVE_PARAMS_KEY", "Ljava/lang/String;", "SENSITIVE_PARAMS_KEY", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SensitiveParamsManager {
    private static final String DEFAULT_SENSITIVE_PARAMS_KEY = "_MTSDK_Default_";
    private static final String SENSITIVE_PARAMS_KEY = "_filteredKey";
    private static boolean enabled;
    public static final SensitiveParamsManager INSTANCE = new SensitiveParamsManager();
    private static HashSet<String> defaultSensitiveParameters = new HashSet<>();
    private static Map<String, HashSet<String>> sensitiveParameters = new HashMap();

    private SensitiveParamsManager() {
    }

    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(SensitiveParamsManager.class)) {
            return;
        }
        try {
            INSTANCE.loadSensitiveParameters();
            if (defaultSensitiveParameters.isEmpty() && sensitiveParameters.isEmpty()) {
                enabled = false;
            } else {
                enabled = true;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SensitiveParamsManager.class);
        }
    }

    private final void loadSensitiveParameters() {
        int length;
        HashSet<String> convertJSONArrayToHashSet;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            int i5 = 0;
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings == null) {
                return;
            }
            try {
                defaultSensitiveParameters = new HashSet<>();
                sensitiveParameters = new HashMap();
                JSONArray sensitiveParams = queryAppSettings.getSensitiveParams();
                if (sensitiveParams == null || sensitiveParams.length() == 0 || (length = sensitiveParams.length()) <= 0) {
                    return;
                }
                while (true) {
                    int i6 = i5 + 1;
                    JSONObject jSONObject = sensitiveParams.getJSONObject(i5);
                    boolean has = jSONObject.has("key");
                    boolean has2 = jSONObject.has("value");
                    if (has && has2) {
                        String sensitiveParamsScope = jSONObject.getString("key");
                        JSONArray jSONArray = jSONObject.getJSONArray("value");
                        if (jSONArray != null && (convertJSONArrayToHashSet = Utility.convertJSONArrayToHashSet(jSONArray)) != null) {
                            if (sensitiveParamsScope.equals(DEFAULT_SENSITIVE_PARAMS_KEY)) {
                                defaultSensitiveParameters = convertJSONArrayToHashSet;
                            } else {
                                Map<String, HashSet<String>> map = sensitiveParameters;
                                Intrinsics.checkNotNullExpressionValue(sensitiveParamsScope, "sensitiveParamsScope");
                                map.put(sensitiveParamsScope, convertJSONArrayToHashSet);
                            }
                        }
                    }
                    if (i6 >= length) {
                        return;
                    } else {
                        i5 = i6;
                    }
                }
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public static final void processFilterSensitiveParams(Bundle parameters, String eventName) {
        if (CrashShieldHandler.isObjectCrashing(SensitiveParamsManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            if (enabled && parameters != null) {
                if (!defaultSensitiveParameters.isEmpty() || sensitiveParameters.containsKey(eventName)) {
                    JSONArray jSONArray = new JSONArray();
                    try {
                        HashSet<String> hashSet = sensitiveParameters.get(eventName);
                        Iterator it = new ArrayList(parameters.keySet()).iterator();
                        while (it.hasNext()) {
                            String key = (String) it.next();
                            SensitiveParamsManager sensitiveParamsManager = INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(key, "key");
                            if (sensitiveParamsManager.shouldFilterOut(key, hashSet)) {
                                parameters.remove(key);
                                jSONArray.put(key);
                            }
                        }
                    } catch (Exception unused) {
                    }
                    if (jSONArray.length() > 0) {
                        parameters.putString(SENSITIVE_PARAMS_KEY, jSONArray.toString());
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SensitiveParamsManager.class);
        }
    }

    private final boolean shouldFilterOut(String parameterKey, HashSet<String> sensitiveParamsForEvent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (!defaultSensitiveParameters.contains(parameterKey)) {
                if (sensitiveParamsForEvent != null && !sensitiveParamsForEvent.isEmpty()) {
                    if (!sensitiveParamsForEvent.contains(parameterKey)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
