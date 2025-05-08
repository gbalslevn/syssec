package com.facebook.appevents.iap;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.OperationalData;
import com.facebook.appevents.OperationalDataEnum;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u000b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J&\u0010\u0015\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00070\u00042\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\tJ(\u0010\u0019\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0007\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0017J!\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u001dJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseDedupeConfig;", BuildConfig.FLAVOR, "()V", "defaultCurrencyParameterEquivalents", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "defaultDedupeParameters", "Lkotlin/Pair;", "defaultDedupeWindow", BuildConfig.FLAVOR, "defaultValueParameterEquivalents", "addDedupeParameters", "Landroid/os/Bundle;", "Lcom/facebook/appevents/OperationalData;", "dedupeParameters", "originalParameters", "originalOperationalData", "getCurrencyOfManualEvent", "Ljava/util/Currency;", "parameters", "getCurrencyParameterEquivalents", "getDedupeParameters", "dedupingWithImplicitlyLoggedHistory", BuildConfig.FLAVOR, "getDedupeWindow", "getTestDedupeParameters", "getValueOfManualEvent", BuildConfig.FLAVOR, "valueToSum", "(Ljava/lang/Double;Landroid/os/Bundle;)Ljava/lang/Double;", "getValueParameterEquivalents", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class InAppPurchaseDedupeConfig {
    public static final InAppPurchaseDedupeConfig INSTANCE = new InAppPurchaseDedupeConfig();
    private static final List<String> defaultCurrencyParameterEquivalents = CollectionsKt.listOf("fb_currency");
    private static final List<String> defaultValueParameterEquivalents = CollectionsKt.listOf("_valueToSum");
    private static final long defaultDedupeWindow = TimeUnit.MINUTES.toMillis(1);
    private static final List<Pair<String, List<String>>> defaultDedupeParameters = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("fb_iap_product_id", CollectionsKt.listOf("fb_iap_product_id")), TuplesKt.to("fb_iap_product_description", CollectionsKt.listOf("fb_iap_product_description")), TuplesKt.to("fb_iap_product_title", CollectionsKt.listOf("fb_iap_product_title")), TuplesKt.to("fb_iap_purchase_token", CollectionsKt.listOf("fb_iap_purchase_token"))});

    private InAppPurchaseDedupeConfig() {
    }

    public final Pair<Bundle, OperationalData> addDedupeParameters(Bundle dedupeParameters, Bundle originalParameters, OperationalData originalOperationalData) {
        if (dedupeParameters == null) {
            return new Pair<>(originalParameters, originalOperationalData);
        }
        try {
            for (String key : dedupeParameters.keySet()) {
                String string = dedupeParameters.getString(key);
                if (string != null) {
                    OperationalData.Companion companion = OperationalData.INSTANCE;
                    OperationalDataEnum operationalDataEnum = OperationalDataEnum.IAPParameters;
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    Pair<Bundle, OperationalData> addParameterAndReturn = companion.addParameterAndReturn(operationalDataEnum, key, string, originalParameters, originalOperationalData);
                    Bundle component1 = addParameterAndReturn.component1();
                    originalOperationalData = addParameterAndReturn.component2();
                    originalParameters = component1;
                }
            }
        } catch (Exception unused) {
        }
        return new Pair<>(originalParameters, originalOperationalData);
    }

    public final Currency getCurrencyOfManualEvent(Bundle parameters) {
        Iterator<String> it = getCurrencyParameterEquivalents().iterator();
        while (true) {
            String str = null;
            if (!it.hasNext()) {
                return null;
            }
            String next = it.next();
            if (parameters != null) {
                try {
                    str = parameters.getString(next);
                } catch (Exception unused) {
                    continue;
                }
            }
            if (str != null && str.length() != 0) {
                return Currency.getInstance(str);
            }
        }
    }

    public final List<String> getCurrencyParameterEquivalents() {
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return ((appSettingsWithoutQuery == null ? null : appSettingsWithoutQuery.getCurrencyDedupeParameters()) == null || appSettingsWithoutQuery.getCurrencyDedupeParameters().isEmpty()) ? defaultCurrencyParameterEquivalents : appSettingsWithoutQuery.getCurrencyDedupeParameters();
    }

    public final List<Pair<String, List<String>>> getDedupeParameters(boolean dedupingWithImplicitlyLoggedHistory) {
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if ((appSettingsWithoutQuery == null ? null : appSettingsWithoutQuery.getProdDedupeParameters()) == null || appSettingsWithoutQuery.getProdDedupeParameters().isEmpty()) {
            return defaultDedupeParameters;
        }
        if (!dedupingWithImplicitlyLoggedHistory) {
            return appSettingsWithoutQuery.getProdDedupeParameters();
        }
        ArrayList arrayList = new ArrayList();
        for (Pair<String, List<String>> pair : appSettingsWithoutQuery.getProdDedupeParameters()) {
            Iterator<String> it = pair.getSecond().iterator();
            while (it.hasNext()) {
                arrayList.add(new Pair(it.next(), CollectionsKt.listOf(pair.getFirst())));
            }
        }
        return arrayList;
    }

    public final long getDedupeWindow() {
        Long dedupeWindow;
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return ((appSettingsWithoutQuery == null ? null : appSettingsWithoutQuery.getDedupeWindow()) == null || ((dedupeWindow = appSettingsWithoutQuery.getDedupeWindow()) != null && dedupeWindow.longValue() == 0)) ? defaultDedupeWindow : appSettingsWithoutQuery.getDedupeWindow().longValue();
    }

    public final List<Pair<String, List<String>>> getTestDedupeParameters(boolean dedupingWithImplicitlyLoggedHistory) {
        List<Pair<String, List<String>>> testDedupeParameters;
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery == null || (testDedupeParameters = appSettingsWithoutQuery.getTestDedupeParameters()) == null || testDedupeParameters.isEmpty()) {
            return null;
        }
        if (!dedupingWithImplicitlyLoggedHistory) {
            return appSettingsWithoutQuery.getTestDedupeParameters();
        }
        ArrayList arrayList = new ArrayList();
        for (Pair<String, List<String>> pair : appSettingsWithoutQuery.getTestDedupeParameters()) {
            Iterator<String> it = pair.getSecond().iterator();
            while (it.hasNext()) {
                arrayList.add(new Pair(it.next(), CollectionsKt.listOf(pair.getFirst())));
            }
        }
        return arrayList;
    }

    public final Double getValueOfManualEvent(Double valueToSum, Bundle parameters) {
        Double d5;
        if (valueToSum != null) {
            return valueToSum;
        }
        Iterator<String> it = getValueParameterEquivalents().iterator();
        while (true) {
            d5 = null;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (parameters != null) {
                try {
                    d5 = Double.valueOf(parameters.getDouble(next));
                } catch (Exception unused) {
                    continue;
                }
            }
            if (d5 != null) {
                break;
            }
        }
        return d5;
    }

    public final List<String> getValueParameterEquivalents() {
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return ((appSettingsWithoutQuery == null ? null : appSettingsWithoutQuery.getPurchaseValueDedupeParameters()) == null || appSettingsWithoutQuery.getPurchaseValueDedupeParameters().isEmpty()) ? defaultValueParameterEquivalents : appSettingsWithoutQuery.getPurchaseValueDedupeParameters();
    }
}
