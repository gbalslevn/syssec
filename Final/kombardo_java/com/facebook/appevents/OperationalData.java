package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.FacebookException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.conscrypt.BuildConfig;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0001J\u0006\u0010\f\u001a\u00020\u0000J\u0018\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u000fR&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/appevents/OperationalData;", BuildConfig.FLAVOR, "()V", "operationalData", BuildConfig.FLAVOR, "Lcom/facebook/appevents/OperationalDataEnum;", BuildConfig.FLAVOR, "addParameter", BuildConfig.FLAVOR, "type", "key", "value", "copy", "getParameter", "toJSON", "Lorg/json/JSONObject;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class OperationalData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> iapOperationalAndCustomParameters;
    private static final Set<String> iapOperationalParameters;
    private static final Map<OperationalDataEnum, Pair<Set<String>, Set<String>>> parameterClassifications;
    private final Map<OperationalDataEnum, Map<String, Object>> operationalData = new LinkedHashMap();

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013JB\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\n2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J,\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0007\u001a&\u0012\u0004\u0012\u00020\t\u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/appevents/OperationalData$Companion;", BuildConfig.FLAVOR, "()V", "iapOperationalAndCustomParameters", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "iapOperationalParameters", "parameterClassifications", BuildConfig.FLAVOR, "Lcom/facebook/appevents/OperationalDataEnum;", "Lkotlin/Pair;", "addParameter", BuildConfig.FLAVOR, "typeOfParameter", "key", "value", "customEventsParams", "Landroid/os/Bundle;", "operationalData", "Lcom/facebook/appevents/OperationalData;", "addParameterAndReturn", "getParameter", "params", "getParameterClassification", "Lcom/facebook/appevents/ParameterClassification;", "parameter", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ParameterClassification.valuesCustom().length];
                iArr[ParameterClassification.CustomData.ordinal()] = 1;
                iArr[ParameterClassification.OperationalData.ordinal()] = 2;
                iArr[ParameterClassification.CustomAndOperationalData.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void addParameter(OperationalDataEnum typeOfParameter, String key, String value, Bundle customEventsParams, OperationalData operationalData) {
            Intrinsics.checkNotNullParameter(typeOfParameter, "typeOfParameter");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(customEventsParams, "customEventsParams");
            Intrinsics.checkNotNullParameter(operationalData, "operationalData");
            int i5 = WhenMappings.$EnumSwitchMapping$0[getParameterClassification(typeOfParameter, key).ordinal()];
            if (i5 == 1) {
                customEventsParams.putCharSequence(key, value);
                return;
            }
            if (i5 == 2) {
                operationalData.addParameter(typeOfParameter, key, value);
            } else {
                if (i5 != 3) {
                    return;
                }
                operationalData.addParameter(typeOfParameter, key, value);
                customEventsParams.putCharSequence(key, value);
            }
        }

        public final Pair<Bundle, OperationalData> addParameterAndReturn(OperationalDataEnum typeOfParameter, String key, String value, Bundle customEventsParams, OperationalData operationalData) {
            Intrinsics.checkNotNullParameter(typeOfParameter, "typeOfParameter");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            int i5 = WhenMappings.$EnumSwitchMapping$0[getParameterClassification(typeOfParameter, key).ordinal()];
            if (i5 == 1) {
                if (customEventsParams == null) {
                    customEventsParams = new Bundle();
                }
                customEventsParams.putCharSequence(key, value);
            } else if (i5 == 2) {
                if (operationalData == null) {
                    operationalData = new OperationalData();
                }
                operationalData.addParameter(typeOfParameter, key, value);
            } else if (i5 == 3) {
                if (operationalData == null) {
                    operationalData = new OperationalData();
                }
                if (customEventsParams == null) {
                    customEventsParams = new Bundle();
                }
                operationalData.addParameter(typeOfParameter, key, value);
                customEventsParams.putCharSequence(key, value);
            }
            return new Pair<>(customEventsParams, operationalData);
        }

        public final Object getParameter(OperationalDataEnum typeOfParameter, String key, Bundle params, OperationalData operationalData) {
            Intrinsics.checkNotNullParameter(typeOfParameter, "typeOfParameter");
            Intrinsics.checkNotNullParameter(key, "key");
            Object parameter = operationalData == null ? null : operationalData.getParameter(typeOfParameter, key);
            return parameter == null ? params != null ? params.getCharSequence(key) : null : parameter;
        }

        public final ParameterClassification getParameterClassification(OperationalDataEnum typeOfParameter, String parameter) {
            Intrinsics.checkNotNullParameter(typeOfParameter, "typeOfParameter");
            Intrinsics.checkNotNullParameter(parameter, "parameter");
            Pair pair = (Pair) OperationalData.parameterClassifications.get(typeOfParameter);
            Set set = pair == null ? null : (Set) pair.getFirst();
            Pair pair2 = (Pair) OperationalData.parameterClassifications.get(typeOfParameter);
            Set set2 = pair2 != null ? (Set) pair2.getSecond() : null;
            return (set == null || !set.contains(parameter)) ? (set2 == null || !set2.contains(parameter)) ? ParameterClassification.CustomData : ParameterClassification.CustomAndOperationalData : ParameterClassification.OperationalData;
        }

        private Companion() {
        }
    }

    static {
        Set<String> of = SetsKt.setOf((Object[]) new String[]{"fb_iap_package_name", "fb_iap_subs_auto_renewing", "fb_free_trial_period", "fb_intro_price_amount_micros", "fb_intro_price_cycles", "fb_iap_base_plan", "is_implicit_purchase_logging_enabled", "fb_iap_sdk_supported_library_versions", "is_autolog_app_events_enabled", "fb_iap_client_library_version", "fb_iap_subs_period", "fb_iap_purchase_token", "fb_iap_non_deduped_event_time", "fb_iap_actual_dedup_result", "fb_iap_actual_dedup_key_used", "fb_iap_test_dedup_result", "fb_iap_test_dedup_key_used"});
        iapOperationalParameters = of;
        Set<String> of2 = SetsKt.setOf((Object[]) new String[]{"fb_iap_product_id", "fb_iap_product_type", "fb_iap_purchase_time"});
        iapOperationalAndCustomParameters = of2;
        parameterClassifications = MapsKt.mapOf(TuplesKt.to(OperationalDataEnum.IAPParameters, new Pair(of, of2)));
    }

    public final void addParameter(OperationalDataEnum type, String key, Object value) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            AppEvent.INSTANCE.validateIdentifier(key);
            if (!(value instanceof String) && !(value instanceof Number)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", Arrays.copyOf(new Object[]{value, key}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                throw new FacebookException(format);
            }
            if (!this.operationalData.containsKey(type)) {
                this.operationalData.put(type, new LinkedHashMap());
            }
            Map<String, Object> map = this.operationalData.get(type);
            if (map == null) {
                return;
            }
            map.put(key, value);
        } catch (Exception unused) {
        }
    }

    public final OperationalData copy() {
        OperationalData operationalData = new OperationalData();
        for (OperationalDataEnum operationalDataEnum : this.operationalData.keySet()) {
            Map<String, Object> map = this.operationalData.get(operationalDataEnum);
            if (map != null) {
                for (String str : map.keySet()) {
                    Object obj = map.get(str);
                    if (obj != null) {
                        operationalData.addParameter(operationalDataEnum, str, obj);
                    }
                }
            }
        }
        return operationalData;
    }

    public final Object getParameter(OperationalDataEnum type, String key) {
        Map<String, Object> map;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.operationalData.containsKey(type) && (map = this.operationalData.get(type)) != null) {
            return map.get(key);
        }
        return null;
    }

    public final JSONObject toJSON() {
        JSONObject jSONObject;
        try {
            Map<OperationalDataEnum, Map<String, Object>> map = this.operationalData;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            for (Object obj : map.entrySet()) {
                linkedHashMap.put(((OperationalDataEnum) ((Map.Entry) obj).getKey()).getValue(), ((Map.Entry) obj).getValue());
            }
            jSONObject = new JSONObject(MapsKt.toMap(linkedHashMap));
        } catch (Exception unused) {
            jSONObject = null;
        }
        return jSONObject == null ? new JSONObject() : jSONObject;
    }
}
