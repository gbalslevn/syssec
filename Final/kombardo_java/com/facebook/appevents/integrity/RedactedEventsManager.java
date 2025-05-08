package com.facebook.appevents.integrity;

import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR2\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0010j\b\u0012\u0004\u0012\u00020\u0007`\u00110\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/facebook/appevents/integrity/RedactedEventsManager;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "enable", "loadRedactedEvents", BuildConfig.FLAVOR, "eventName", "processEventsRedaction", "(Ljava/lang/String;)Ljava/lang/String;", "getRedactionString", BuildConfig.FLAVOR, "enabled", "Z", BuildConfig.FLAVOR, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "redactedEvents", "Ljava/util/Map;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class RedactedEventsManager {
    private static boolean enabled;
    public static final RedactedEventsManager INSTANCE = new RedactedEventsManager();
    private static Map<String, HashSet<String>> redactedEvents = new HashMap();

    private RedactedEventsManager() {
    }

    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(RedactedEventsManager.class)) {
            return;
        }
        try {
            INSTANCE.loadRedactedEvents();
            if (redactedEvents.isEmpty()) {
                return;
            }
            enabled = true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RedactedEventsManager.class);
        }
    }

    private final String getRedactionString(String eventName) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            for (String str : redactedEvents.keySet()) {
                HashSet<String> hashSet = redactedEvents.get(str);
                if (hashSet != null && hashSet.contains(eventName)) {
                    return str;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void loadRedactedEvents() {
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
                redactedEvents = new HashMap();
                JSONArray redactedEvents2 = queryAppSettings.getRedactedEvents();
                if (redactedEvents2 == null || redactedEvents2.length() == 0 || (length = redactedEvents2.length()) <= 0) {
                    return;
                }
                while (true) {
                    int i6 = i5 + 1;
                    JSONObject jSONObject = redactedEvents2.getJSONObject(i5);
                    boolean has = jSONObject.has("key");
                    boolean has2 = jSONObject.has("value");
                    if (has && has2) {
                        String redactedString = jSONObject.getString("key");
                        JSONArray jSONArray = jSONObject.getJSONArray("value");
                        if (redactedString != null && (convertJSONArrayToHashSet = Utility.convertJSONArrayToHashSet(jSONArray)) != null) {
                            Map<String, HashSet<String>> map = redactedEvents;
                            Intrinsics.checkNotNullExpressionValue(redactedString, "redactedString");
                            map.put(redactedString, convertJSONArrayToHashSet);
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

    public static final String processEventsRedaction(String eventName) {
        if (CrashShieldHandler.isObjectCrashing(RedactedEventsManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            if (enabled) {
                String redactionString = INSTANCE.getRedactionString(eventName);
                if (redactionString != null) {
                    return redactionString;
                }
            }
            return eventName;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RedactedEventsManager.class);
            return null;
        }
    }
}
