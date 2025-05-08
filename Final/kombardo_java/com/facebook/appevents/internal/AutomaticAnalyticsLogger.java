package com.facebook.appevents.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.OperationalData;
import com.facebook.appevents.OperationalDataEnum;
import com.facebook.appevents.iap.InAppPurchase;
import com.facebook.appevents.iap.InAppPurchaseDedupeConfig;
import com.facebook.appevents.iap.InAppPurchaseEventManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.iap.InAppPurchaseUtils;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import dk.molslinjen.domain.model.constants.Constants;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001+B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J>\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J0\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J0\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J \u0010\u001e\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u001f\u001a\u00020\u0004H\u0007J\b\u0010 \u001a\u00020!H\u0007J\b\u0010\"\u001a\u00020#H\u0007J\u001a\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020'H\u0007J4\u0010(\u001a\u00020#2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010)\u001a\u00020!2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010*\u001a\u00020!H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger;", BuildConfig.FLAVOR, "()V", "APP_EVENTS_IF_AUTO_LOG_SUBS", BuildConfig.FLAVOR, "TAG", "kotlin.jvm.PlatformType", "internalAppEventsLogger", "Lcom/facebook/appevents/InternalAppEventsLogger;", "getPurchaseDedupeParameters", "Landroid/os/Bundle;", "purchaseLoggingParametersList", BuildConfig.FLAVOR, "Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger$PurchaseLoggingParameters;", "getPurchaseLoggingParameters", "purchase", "skuDetails", "billingClientVersion", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;", "extraParameter", BuildConfig.FLAVOR, "getPurchaseParametersGPBLV2V4", "type", "params", "operationalData", "Lcom/facebook/appevents/OperationalData;", "purchaseJSON", "Lorg/json/JSONObject;", "skuDetailsJSON", "getPurchaseParametersGPBLV5V7", "getSubscriptionDedupeParameters", "eventName", "isImplicitPurchaseLoggingEnabled", BuildConfig.FLAVOR, "logActivateAppEvent", BuildConfig.FLAVOR, "logActivityTimeSpentEvent", "activityName", "timeSpentInSeconds", BuildConfig.FLAVOR, "logPurchase", "isSubscription", "isFirstAppLaunch", "PurchaseLoggingParameters", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AutomaticAnalyticsLogger {
    private static final String APP_EVENTS_IF_AUTO_LOG_SUBS = "app_events_if_auto_log_subs";
    public static final AutomaticAnalyticsLogger INSTANCE = new AutomaticAnalyticsLogger();
    private static final String TAG = AutomaticAnalyticsLogger.class.getCanonicalName();
    private static final InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger$PurchaseLoggingParameters;", BuildConfig.FLAVOR, "Ljava/math/BigDecimal;", "purchaseAmount", "Ljava/util/Currency;", "currency", "Landroid/os/Bundle;", "param", "Lcom/facebook/appevents/OperationalData;", "operationalData", "<init>", "(Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;)V", "Ljava/math/BigDecimal;", "getPurchaseAmount", "()Ljava/math/BigDecimal;", "setPurchaseAmount", "(Ljava/math/BigDecimal;)V", "Ljava/util/Currency;", "getCurrency", "()Ljava/util/Currency;", "setCurrency", "(Ljava/util/Currency;)V", "Landroid/os/Bundle;", "getParam", "()Landroid/os/Bundle;", "setParam", "(Landroid/os/Bundle;)V", "Lcom/facebook/appevents/OperationalData;", "getOperationalData", "()Lcom/facebook/appevents/OperationalData;", "setOperationalData", "(Lcom/facebook/appevents/OperationalData;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class PurchaseLoggingParameters {
        private Currency currency;
        private OperationalData operationalData;
        private Bundle param;
        private BigDecimal purchaseAmount;

        public PurchaseLoggingParameters(BigDecimal purchaseAmount, Currency currency, Bundle param, OperationalData operationalData) {
            Intrinsics.checkNotNullParameter(purchaseAmount, "purchaseAmount");
            Intrinsics.checkNotNullParameter(currency, "currency");
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(operationalData, "operationalData");
            this.purchaseAmount = purchaseAmount;
            this.currency = currency;
            this.param = param;
            this.operationalData = operationalData;
        }

        public final Currency getCurrency() {
            return this.currency;
        }

        public final OperationalData getOperationalData() {
            return this.operationalData;
        }

        public final Bundle getParam() {
            return this.param;
        }

        public final BigDecimal getPurchaseAmount() {
            return this.purchaseAmount;
        }
    }

    private AutomaticAnalyticsLogger() {
    }

    public static final synchronized Bundle getPurchaseDedupeParameters(List<PurchaseLoggingParameters> purchaseLoggingParametersList) {
        Bundle performDedupe;
        synchronized (AutomaticAnalyticsLogger.class) {
            Intrinsics.checkNotNullParameter(purchaseLoggingParametersList, "purchaseLoggingParametersList");
            PurchaseLoggingParameters purchaseLoggingParameters = purchaseLoggingParametersList.get(0);
            InAppPurchase inAppPurchase = new InAppPurchase("fb_mobile_purchase", purchaseLoggingParameters.getPurchaseAmount().doubleValue(), purchaseLoggingParameters.getCurrency());
            InAppPurchaseManager inAppPurchaseManager = InAppPurchaseManager.INSTANCE;
            performDedupe = InAppPurchaseManager.performDedupe(CollectionsKt.listOf(inAppPurchase), System.currentTimeMillis(), true, CollectionsKt.listOf(new Pair(purchaseLoggingParameters.getParam(), purchaseLoggingParameters.getOperationalData())));
        }
        return performDedupe;
    }

    private final List<PurchaseLoggingParameters> getPurchaseLoggingParameters(String purchase, String skuDetails, InAppPurchaseUtils.BillingClientVersion billingClientVersion) {
        return getPurchaseLoggingParameters(purchase, skuDetails, new HashMap(), billingClientVersion);
    }

    private final PurchaseLoggingParameters getPurchaseParametersGPBLV2V4(String type, Bundle params, OperationalData operationalData, JSONObject purchaseJSON, JSONObject skuDetailsJSON) {
        if (Intrinsics.areEqual(type, InAppPurchaseUtils.IAPProductType.SUBS.getType())) {
            OperationalData.Companion companion = OperationalData.INSTANCE;
            OperationalDataEnum operationalDataEnum = OperationalDataEnum.IAPParameters;
            String bool = Boolean.toString(purchaseJSON.optBoolean("autoRenewing", false));
            Intrinsics.checkNotNullExpressionValue(bool, "toString(\n                    purchaseJSON.optBoolean(\n                        Constants.GP_IAP_AUTORENEWING,\n                        false\n                    )\n                )");
            companion.addParameter(operationalDataEnum, "fb_iap_subs_auto_renewing", bool, params, operationalData);
            String optString = skuDetailsJSON.optString("subscriptionPeriod");
            Intrinsics.checkNotNullExpressionValue(optString, "skuDetailsJSON.optString(Constants.GP_IAP_SUBSCRIPTION_PERIOD)");
            companion.addParameter(operationalDataEnum, "fb_iap_subs_period", optString, params, operationalData);
            String optString2 = skuDetailsJSON.optString("freeTrialPeriod");
            Intrinsics.checkNotNullExpressionValue(optString2, "skuDetailsJSON.optString(Constants.GP_IAP_FREE_TRIAL_PERIOD)");
            companion.addParameter(operationalDataEnum, "fb_free_trial_period", optString2, params, operationalData);
            String introductoryPriceCycles = skuDetailsJSON.optString("introductoryPriceCycles");
            Intrinsics.checkNotNullExpressionValue(introductoryPriceCycles, "introductoryPriceCycles");
            if (introductoryPriceCycles.length() > 0) {
                companion.addParameter(operationalDataEnum, "fb_intro_price_cycles", introductoryPriceCycles, params, operationalData);
            }
            String introductoryPricePeriod = skuDetailsJSON.optString("introductoryPricePeriod");
            Intrinsics.checkNotNullExpressionValue(introductoryPricePeriod, "introductoryPricePeriod");
            if (introductoryPricePeriod.length() > 0) {
                companion.addParameter(operationalDataEnum, "fb_intro_period", introductoryPricePeriod, params, operationalData);
            }
            String introductoryPriceAmountMicros = skuDetailsJSON.optString("introductoryPriceAmountMicros");
            Intrinsics.checkNotNullExpressionValue(introductoryPriceAmountMicros, "introductoryPriceAmountMicros");
            if (introductoryPriceAmountMicros.length() > 0) {
                companion.addParameter(operationalDataEnum, "fb_intro_price_amount_micros", introductoryPriceAmountMicros, params, operationalData);
            }
        }
        BigDecimal bigDecimal = new BigDecimal(skuDetailsJSON.getLong("price_amount_micros") / 1000000.0d);
        Currency currency = Currency.getInstance(skuDetailsJSON.getString("price_currency_code"));
        Intrinsics.checkNotNullExpressionValue(currency, "getInstance(skuDetailsJSON.getString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V2V4))");
        return new PurchaseLoggingParameters(bigDecimal, currency, params, operationalData);
    }

    private final List<PurchaseLoggingParameters> getPurchaseParametersGPBLV5V7(String type, Bundle params, OperationalData operationalData, JSONObject skuDetailsJSON) {
        if (!Intrinsics.areEqual(type, InAppPurchaseUtils.IAPProductType.SUBS.getType())) {
            JSONObject jSONObject = skuDetailsJSON.getJSONObject("oneTimePurchaseOfferDetails");
            if (jSONObject == null) {
                return null;
            }
            BigDecimal bigDecimal = new BigDecimal(jSONObject.getLong("priceAmountMicros") / 1000000.0d);
            Currency currency = Currency.getInstance(jSONObject.getString("priceCurrencyCode"));
            Intrinsics.checkNotNullExpressionValue(currency, "getInstance(oneTimePurchaseOfferDetailsJSON.getString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V5V7))");
            return CollectionsKt.mutableListOf(new PurchaseLoggingParameters(bigDecimal, currency, params, operationalData));
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = skuDetailsJSON.getJSONArray("subscriptionOfferDetails");
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        if (length > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                JSONObject jSONObject2 = skuDetailsJSON.getJSONArray("subscriptionOfferDetails").getJSONObject(i5);
                if (jSONObject2 == null) {
                    return null;
                }
                Bundle bundle = new Bundle(params);
                OperationalData copy = operationalData.copy();
                String basePlanId = jSONObject2.getString("basePlanId");
                OperationalData.Companion companion = OperationalData.INSTANCE;
                OperationalDataEnum operationalDataEnum = OperationalDataEnum.IAPParameters;
                Intrinsics.checkNotNullExpressionValue(basePlanId, "basePlanId");
                companion.addParameter(operationalDataEnum, "fb_iap_base_plan", basePlanId, bundle, copy);
                JSONObject jSONObject3 = jSONObject2.getJSONArray("pricingPhases").getJSONObject(r10.length() - 1);
                if (jSONObject3 == null) {
                    return null;
                }
                String optString = jSONObject3.optString("billingPeriod");
                Intrinsics.checkNotNullExpressionValue(optString, "subscriptionJSON.optString(\n                        Constants.GP_IAP_BILLING_PERIOD\n                    )");
                companion.addParameter(operationalDataEnum, "fb_iap_subs_period", optString, bundle, copy);
                if (!jSONObject3.has("recurrenceMode") || jSONObject3.getInt("recurrenceMode") == 3) {
                    companion.addParameter(operationalDataEnum, "fb_iap_subs_auto_renewing", "false", bundle, copy);
                } else {
                    companion.addParameter(operationalDataEnum, "fb_iap_subs_auto_renewing", "true", bundle, copy);
                }
                BigDecimal bigDecimal2 = new BigDecimal(jSONObject3.getLong("priceAmountMicros") / 1000000.0d);
                Currency currency2 = Currency.getInstance(jSONObject3.getString("priceCurrencyCode"));
                Intrinsics.checkNotNullExpressionValue(currency2, "getInstance(subscriptionJSON.getString(Constants.GP_IAP_PRICE_CURRENCY_CODE_V5V7))");
                arrayList.add(new PurchaseLoggingParameters(bigDecimal2, currency2, bundle, copy));
                if (i6 >= length) {
                    break;
                }
                i5 = i6;
            }
        }
        return arrayList;
    }

    public static final synchronized Bundle getSubscriptionDedupeParameters(List<PurchaseLoggingParameters> purchaseLoggingParametersList, String eventName) {
        Bundle performDedupe;
        synchronized (AutomaticAnalyticsLogger.class) {
            try {
                Intrinsics.checkNotNullParameter(purchaseLoggingParametersList, "purchaseLoggingParametersList");
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                ArrayList arrayList = new ArrayList();
                for (PurchaseLoggingParameters purchaseLoggingParameters : purchaseLoggingParametersList) {
                    arrayList.add(new InAppPurchase(eventName, purchaseLoggingParameters.getPurchaseAmount().doubleValue(), purchaseLoggingParameters.getCurrency()));
                }
                InAppPurchaseManager inAppPurchaseManager = InAppPurchaseManager.INSTANCE;
                long currentTimeMillis = System.currentTimeMillis();
                List<PurchaseLoggingParameters> list = purchaseLoggingParametersList;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (PurchaseLoggingParameters purchaseLoggingParameters2 : list) {
                    arrayList2.add(new Pair(purchaseLoggingParameters2.getParam(), purchaseLoggingParameters2.getOperationalData()));
                }
                performDedupe = InAppPurchaseManager.performDedupe(arrayList, currentTimeMillis, true, arrayList2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return performDedupe;
    }

    public static final boolean isImplicitPurchaseLoggingEnabled() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return appSettingsWithoutQuery != null && FacebookSdk.getAutoLogAppEventsEnabled() && appSettingsWithoutQuery.getIAPAutomaticLoggingEnabled();
    }

    public static final void logActivateAppEvent() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            if (applicationContext instanceof Application) {
                AppEventsLogger.INSTANCE.activateApp((Application) applicationContext, applicationId);
            } else {
                Log.w(TAG, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
            }
        }
    }

    public static final void logActivityTimeSpentEvent(String activityName, long timeSpentInSeconds) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
        if (queryAppSettings == null || !queryAppSettings.getAutomaticLoggingEnabled() || timeSpentInSeconds <= 0) {
            return;
        }
        InternalAppEventsLogger internalAppEventsLogger2 = new InternalAppEventsLogger(applicationContext);
        Bundle bundle = new Bundle(1);
        bundle.putCharSequence("fb_aa_time_spent_view_name", activityName);
        internalAppEventsLogger2.logEvent("fb_aa_time_spent_on_view", timeSpentInSeconds, bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void logPurchase(String purchase, String skuDetails, boolean isSubscription, InAppPurchaseUtils.BillingClientVersion billingClientVersion, boolean isFirstAppLaunch) {
        List<PurchaseLoggingParameters> purchaseLoggingParameters;
        String str;
        String str2;
        Bundle bundle;
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        Intrinsics.checkNotNullParameter(skuDetails, "skuDetails");
        if (!isImplicitPurchaseLoggingEnabled() || (purchaseLoggingParameters = INSTANCE.getPurchaseLoggingParameters(purchase, skuDetails, billingClientVersion)) == null || purchaseLoggingParameters.isEmpty()) {
            return;
        }
        if (isSubscription) {
            FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
            if (FetchedAppGateKeepersManager.getGateKeeperForKey(APP_EVENTS_IF_AUTO_LOG_SUBS, FacebookSdk.getApplicationId(), false)) {
                str2 = isFirstAppLaunch ? "SubscriptionRestore" : InAppPurchaseEventManager.INSTANCE.hasFreeTrialPeirod(skuDetails) ? "StartTrial" : "Subscribe";
                str = str2;
                if (isSubscription) {
                    FeatureManager featureManager = FeatureManager.INSTANCE;
                    if (FeatureManager.isEnabled(FeatureManager.Feature.AndroidManualImplicitSubsDedupe)) {
                        bundle = getSubscriptionDedupeParameters(purchaseLoggingParameters, str);
                        InAppPurchaseDedupeConfig.INSTANCE.addDedupeParameters(bundle, purchaseLoggingParameters.get(0).getParam(), purchaseLoggingParameters.get(0).getOperationalData());
                        if (Intrinsics.areEqual(str, "fb_mobile_purchase")) {
                            internalAppEventsLogger.logPurchaseImplicitly(purchaseLoggingParameters.get(0).getPurchaseAmount(), purchaseLoggingParameters.get(0).getCurrency(), purchaseLoggingParameters.get(0).getParam(), purchaseLoggingParameters.get(0).getOperationalData());
                            return;
                        } else {
                            internalAppEventsLogger.logEventImplicitly(str, purchaseLoggingParameters.get(0).getPurchaseAmount(), purchaseLoggingParameters.get(0).getCurrency(), purchaseLoggingParameters.get(0).getParam(), purchaseLoggingParameters.get(0).getOperationalData());
                            return;
                        }
                    }
                }
                if (!isSubscription) {
                    FeatureManager featureManager2 = FeatureManager.INSTANCE;
                    if (FeatureManager.isEnabled(FeatureManager.Feature.AndroidManualImplicitPurchaseDedupe)) {
                        bundle = getPurchaseDedupeParameters(purchaseLoggingParameters);
                        InAppPurchaseDedupeConfig.INSTANCE.addDedupeParameters(bundle, purchaseLoggingParameters.get(0).getParam(), purchaseLoggingParameters.get(0).getOperationalData());
                        if (Intrinsics.areEqual(str, "fb_mobile_purchase")) {
                        }
                    }
                }
                bundle = null;
                InAppPurchaseDedupeConfig.INSTANCE.addDedupeParameters(bundle, purchaseLoggingParameters.get(0).getParam(), purchaseLoggingParameters.get(0).getOperationalData());
                if (Intrinsics.areEqual(str, "fb_mobile_purchase")) {
                }
            }
        }
        if (isFirstAppLaunch) {
            str2 = "fb_mobile_purchase_restored";
            str = str2;
            if (isSubscription) {
            }
            if (!isSubscription) {
            }
            bundle = null;
            InAppPurchaseDedupeConfig.INSTANCE.addDedupeParameters(bundle, purchaseLoggingParameters.get(0).getParam(), purchaseLoggingParameters.get(0).getOperationalData());
            if (Intrinsics.areEqual(str, "fb_mobile_purchase")) {
            }
        } else {
            str = "fb_mobile_purchase";
            if (isSubscription) {
            }
            if (!isSubscription) {
            }
            bundle = null;
            InAppPurchaseDedupeConfig.INSTANCE.addDedupeParameters(bundle, purchaseLoggingParameters.get(0).getParam(), purchaseLoggingParameters.get(0).getOperationalData());
            if (Intrinsics.areEqual(str, "fb_mobile_purchase")) {
            }
        }
    }

    public static /* synthetic */ void logPurchase$default(String str, String str2, boolean z5, InAppPurchaseUtils.BillingClientVersion billingClientVersion, boolean z6, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            z6 = false;
        }
        logPurchase(str, str2, z5, billingClientVersion, z6);
    }

    private final List<PurchaseLoggingParameters> getPurchaseLoggingParameters(String purchase, String skuDetails, Map<String, String> extraParameter, InAppPurchaseUtils.BillingClientVersion billingClientVersion) {
        List<PurchaseLoggingParameters> list = null;
        try {
            JSONObject jSONObject = new JSONObject(purchase);
            JSONObject jSONObject2 = new JSONObject(skuDetails);
            Bundle bundle = new Bundle(1);
            OperationalData operationalData = new OperationalData();
            if (billingClientVersion != null) {
                OperationalData.INSTANCE.addParameter(OperationalDataEnum.IAPParameters, "fb_iap_sdk_supported_library_versions", billingClientVersion.getType(), bundle, operationalData);
            }
            OperationalData.Companion companion = OperationalData.INSTANCE;
            OperationalDataEnum operationalDataEnum = OperationalDataEnum.IAPParameters;
            String string = jSONObject.getString("productId");
            Intrinsics.checkNotNullExpressionValue(string, "purchaseJSON.getString(Constants.GP_IAP_PRODUCT_ID)");
            companion.addParameter(operationalDataEnum, "fb_iap_product_id", string, bundle, operationalData);
            String string2 = jSONObject.getString("purchaseTime");
            Intrinsics.checkNotNullExpressionValue(string2, "purchaseJSON.getString(Constants.GP_IAP_PURCHASE_TIME)");
            companion.addParameter(operationalDataEnum, "fb_iap_purchase_time", string2, bundle, operationalData);
            String string3 = jSONObject.getString("purchaseToken");
            Intrinsics.checkNotNullExpressionValue(string3, "purchaseJSON.getString(Constants.GP_IAP_PURCHASE_TOKEN)");
            companion.addParameter(operationalDataEnum, "fb_iap_purchase_token", string3, bundle, operationalData);
            String optString = jSONObject.optString("packageName");
            Intrinsics.checkNotNullExpressionValue(optString, "purchaseJSON.optString(Constants.GP_IAP_PACKAGE_NAME)");
            companion.addParameter(operationalDataEnum, "fb_iap_package_name", optString, bundle, operationalData);
            String optString2 = jSONObject2.optString(Constants.IntentExtra.PushTitle);
            Intrinsics.checkNotNullExpressionValue(optString2, "skuDetailsJSON.optString(Constants.GP_IAP_TITLE)");
            companion.addParameter(operationalDataEnum, "fb_iap_product_title", optString2, bundle, operationalData);
            String optString3 = jSONObject2.optString("description");
            Intrinsics.checkNotNullExpressionValue(optString3, "skuDetailsJSON.optString(Constants.GP_IAP_DESCRIPTION)");
            companion.addParameter(operationalDataEnum, "fb_iap_product_description", optString3, bundle, operationalData);
            String type = jSONObject2.optString("type");
            Intrinsics.checkNotNullExpressionValue(type, "type");
            companion.addParameter(operationalDataEnum, "fb_iap_product_type", type, bundle, operationalData);
            String specificBillingLibraryVersion = InAppPurchaseManager.getSpecificBillingLibraryVersion();
            if (specificBillingLibraryVersion != null) {
                companion.addParameter(operationalDataEnum, "fb_iap_client_library_version", specificBillingLibraryVersion, bundle, operationalData);
            }
            for (Map.Entry<String, String> entry : extraParameter.entrySet()) {
                OperationalData.INSTANCE.addParameter(OperationalDataEnum.IAPParameters, entry.getKey(), entry.getValue(), bundle, operationalData);
            }
            if (jSONObject2.has("price_amount_micros")) {
                list = CollectionsKt.mutableListOf(getPurchaseParametersGPBLV2V4(type, bundle, operationalData, jSONObject, jSONObject2));
            } else if (jSONObject2.has("subscriptionOfferDetails") || jSONObject2.has("oneTimePurchaseOfferDetails")) {
                try {
                    return getPurchaseParametersGPBLV5V7(type, bundle, operationalData, jSONObject2);
                } catch (JSONException e5) {
                    e = e5;
                    Log.e(TAG, "Error parsing in-app purchase/subscription data.", e);
                    return null;
                } catch (Exception e6) {
                    e = e6;
                    Log.e(TAG, "Failed to get purchase logging parameters,", e);
                    return null;
                }
            }
            return list;
        } catch (JSONException e7) {
            e = e7;
        } catch (Exception e8) {
            e = e8;
        }
    }
}
