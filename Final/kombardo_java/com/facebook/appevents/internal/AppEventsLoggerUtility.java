package com.facebook.appevents.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/internal/AppEventsLoggerUtility;", BuildConfig.FLAVOR, "()V", "API_ACTIVITY_TYPE_TO_STRING", BuildConfig.FLAVOR, "Lcom/facebook/appevents/internal/AppEventsLoggerUtility$GraphAPIActivityType;", BuildConfig.FLAVOR, "getJSONObjectForGraphAPICall", "Lorg/json/JSONObject;", "activityType", "attributionIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "anonymousAppDeviceGUID", "limitEventUsage", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "GraphAPIActivityType", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AppEventsLoggerUtility {
    public static final AppEventsLoggerUtility INSTANCE = new AppEventsLoggerUtility();
    private static final Map<GraphAPIActivityType, String> API_ACTIVITY_TYPE_TO_STRING = MapsKt.hashMapOf(TuplesKt.to(GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL"), TuplesKt.to(GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS"));

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/internal/AppEventsLoggerUtility$GraphAPIActivityType;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "MOBILE_INSTALL_EVENT", "CUSTOM_APP_EVENTS", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public enum GraphAPIActivityType {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static GraphAPIActivityType[] valuesCustom() {
            GraphAPIActivityType[] valuesCustom = values();
            return (GraphAPIActivityType[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    private AppEventsLoggerUtility() {
    }

    public static final JSONObject getJSONObjectForGraphAPICall(GraphAPIActivityType activityType, AttributionIdentifiers attributionIdentifiers, String anonymousAppDeviceGUID, boolean limitEventUsage, Context context) {
        Intrinsics.checkNotNullParameter(activityType, "activityType");
        Intrinsics.checkNotNullParameter(context, "context");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", API_ACTIVITY_TYPE_TO_STRING.get(activityType));
        String userID = AppEventsLogger.INSTANCE.getUserID();
        if (userID != null) {
            jSONObject.put("app_user_id", userID);
        }
        Utility.setAppEventAttributionParameters(jSONObject, attributionIdentifiers, anonymousAppDeviceGUID, limitEventUsage, context);
        try {
            Utility.setAppEventExtendedDeviceInfoParameters(jSONObject, context);
        } catch (Exception e5) {
            Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e5.toString());
        }
        JSONObject dataProcessingOptions = Utility.getDataProcessingOptions();
        if (dataProcessingOptions != null) {
            Iterator<String> keys = dataProcessingOptions.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, dataProcessingOptions.get(next));
            }
        }
        jSONObject.put("application_package_name", context.getPackageName());
        return jSONObject;
    }
}
