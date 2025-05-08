package com.facebook.appevents.integrity;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J-\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR+\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR*\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/facebook/appevents/integrity/ProtectedModeManager;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "enable", BuildConfig.FLAVOR, "isEnabled", "()Z", "loadStandardParams", "Lorg/json/JSONArray;", "jsonArray", "Ljava/util/HashSet;", BuildConfig.FLAVOR, "Lkotlin/collections/HashSet;", "convertJSONArrayToHashSet", "(Lorg/json/JSONArray;)Ljava/util/HashSet;", "Landroid/os/Bundle;", "parameters", "processParametersForProtectedMode", "(Landroid/os/Bundle;)V", "protectedModeIsApplied", "(Landroid/os/Bundle;)Z", "enabled", "Z", "PROTECTED_MODE_IS_APPLIED_KEY", "Ljava/lang/String;", "PROTECTED_MODE_IS_APPLIED_VALUE", "defaultStandardParameterNames$delegate", "Lkotlin/Lazy;", "getDefaultStandardParameterNames", "()Ljava/util/HashSet;", "defaultStandardParameterNames", "standardParams", "Ljava/util/HashSet;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ProtectedModeManager {
    private static final String PROTECTED_MODE_IS_APPLIED_KEY = "pm";
    private static final String PROTECTED_MODE_IS_APPLIED_VALUE = "1";
    private static boolean enabled;
    private static HashSet<String> standardParams;
    public static final ProtectedModeManager INSTANCE = new ProtectedModeManager();

    /* renamed from: defaultStandardParameterNames$delegate, reason: from kotlin metadata */
    private static final Lazy defaultStandardParameterNames = LazyKt.lazy(new Function0<HashSet<String>>() { // from class: com.facebook.appevents.integrity.ProtectedModeManager$defaultStandardParameterNames$2
        @Override // kotlin.jvm.functions.Function0
        public final HashSet<String> invoke() {
            return SetsKt.hashSetOf("_currency", "_valueToSum", "fb_availability", "fb_body_style", "fb_checkin_date", "fb_checkout_date", "fb_city", "fb_condition_of_vehicle", "fb_content_ids", "fb_content_type", "fb_contents", "fb_country", "fb_currency", "fb_delivery_category", "fb_departing_arrival_date", "fb_departing_departure_date", "fb_destination_airport", "fb_destination_ids", "fb_dma_code", "fb_drivetrain", "fb_exterior_color", "fb_fuel_type", "fb_hotel_score", "fb_interior_color", "fb_lease_end_date", "fb_lease_start_date", "fb_listing_type", "fb_make", "fb_mileage.unit", "fb_mileage.value", "fb_model", "fb_neighborhood", "fb_num_adults", "fb_num_children", "fb_num_infants", "fb_num_items", "fb_order_id", "fb_origin_airport", "fb_postal_code", "fb_predicted_ltv", "fb_preferred_baths_range", "fb_preferred_beds_range", "fb_preferred_neighborhoods", "fb_preferred_num_stops", "fb_preferred_price_range", "fb_preferred_star_ratings", "fb_price", "fb_property_type", "fb_region", "fb_returning_arrival_date", "fb_returning_departure_date", "fb_state_of_vehicle", "fb_suggested_destinations", "fb_suggested_home_listings", "fb_suggested_hotels", "fb_suggested_jobs", "fb_suggested_local_service_businesses", "fb_suggested_location_based_items", "fb_suggested_vehicles", "fb_transmission", "fb_travel_class", "fb_travel_end", "fb_travel_start", "fb_trim", "fb_user_bucket", "fb_value", "fb_vin", "fb_year", "lead_event_source", "predicted_ltv", "product_catalog_id", "app_user_id", "appVersion", "_eventName", "_eventName_md5", "_implicitlyLogged", "_inBackground", "_isTimedEvent", "_logTime", "_session_id", "_ui", "_valueToUpdate", "_is_fb_codeless", "_is_suggested_event", "_fb_pixel_referral_id", "fb_pixel_id", "trace_id", "subscription_id", "event_id", "_restrictedParams", "_onDeviceParams", "purchase_valid_result_type", "core_lib_included", "login_lib_included", "share_lib_included", "place_lib_included", "messenger_lib_included", "applinks_lib_included", "marketing_lib_included", "_codeless_action", "sdk_initialized", "billing_client_lib_included", "billing_service_lib_included", "user_data_keys", "device_push_token", "fb_mobile_pckg_fp", "fb_mobile_app_cert_hash", "aggregate_id", "anonymous_id", "campaign_ids", "fb_post_attachment", "receipt_data", "ad_type", "fb_content", "fb_content_id", "fb_description", "fb_level", "fb_max_rating_value", "fb_payment_info_available", "fb_registration_method", "fb_success", "pm", "_audiencePropertyIds", "cs_maca");
        }
    });

    private ProtectedModeManager() {
    }

    private final HashSet<String> convertJSONArrayToHashSet(JSONArray jsonArray) {
        if (!CrashShieldHandler.isObjectCrashing(this) && jsonArray != null) {
            try {
                if (jsonArray.length() != 0) {
                    HashSet<String> hashSet = new HashSet<>();
                    int length = jsonArray.length();
                    if (length > 0) {
                        int i5 = 0;
                        while (true) {
                            int i6 = i5 + 1;
                            String string = jsonArray.getString(i5);
                            Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                            hashSet.add(string);
                            if (i6 >= length) {
                                break;
                            }
                            i5 = i6;
                        }
                    }
                    return hashSet;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
        return null;
    }

    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(ProtectedModeManager.class)) {
            return;
        }
        try {
            enabled = true;
            INSTANCE.loadStandardParams();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ProtectedModeManager.class);
        }
    }

    public static final boolean isEnabled() {
        if (CrashShieldHandler.isObjectCrashing(ProtectedModeManager.class)) {
            return false;
        }
        try {
            return enabled;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ProtectedModeManager.class);
            return false;
        }
    }

    private final void loadStandardParams() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (queryAppSettings == null) {
                return;
            }
            HashSet<String> convertJSONArrayToHashSet = convertJSONArrayToHashSet(queryAppSettings.getProtectedModeStandardParamsSetting());
            if (convertJSONArrayToHashSet == null) {
                convertJSONArrayToHashSet = getDefaultStandardParameterNames();
            }
            standardParams = convertJSONArrayToHashSet;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public static final void processParametersForProtectedMode(Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(ProtectedModeManager.class)) {
            return;
        }
        try {
            if (enabled && parameters != null && !parameters.isEmpty() && standardParams != null) {
                ArrayList arrayList = new ArrayList();
                Set<String> keySet = parameters.keySet();
                Intrinsics.checkNotNullExpressionValue(keySet, "parameters.keySet()");
                for (String param : keySet) {
                    HashSet<String> hashSet = standardParams;
                    Intrinsics.checkNotNull(hashSet);
                    if (!hashSet.contains(param)) {
                        Intrinsics.checkNotNullExpressionValue(param, "param");
                        arrayList.add(param);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    parameters.remove((String) it.next());
                }
                parameters.putString(PROTECTED_MODE_IS_APPLIED_KEY, PROTECTED_MODE_IS_APPLIED_VALUE);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ProtectedModeManager.class);
        }
    }

    public final HashSet<String> getDefaultStandardParameterNames() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return (HashSet) defaultStandardParameterNames.getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final boolean protectedModeIsApplied(Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(this) || parameters == null) {
            return false;
        }
        try {
            if (parameters.containsKey(PROTECTED_MODE_IS_APPLIED_KEY)) {
                return Intrinsics.areEqual(parameters.get(PROTECTED_MODE_IS_APPLIED_KEY), PROTECTED_MODE_IS_APPLIED_VALUE);
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
