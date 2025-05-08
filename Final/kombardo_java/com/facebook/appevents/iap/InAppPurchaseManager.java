package com.facebook.appevents.iap;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.adjust.sdk.Constants;
import com.facebook.FacebookSdk;
import com.facebook.appevents.OperationalData;
import com.facebook.appevents.OperationalDataEnum;
import com.facebook.appevents.iap.InAppPurchaseUtils;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0002JB\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\n\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0007JF\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0 2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u001b2\u001c\u0010#\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f0 H\u0007J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0004H\u0003J\b\u0010&\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R<\u0010\b\u001a0\u0012\u0004\u0012\u00020\n\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f0\f0\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R<\u0010\u0010\u001a0\u0012\u0004\u0012\u00020\n\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f0\f0\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseManager;", BuildConfig.FLAVOR, "()V", "GOOGLE_BILLINGCLIENT_VERSION", BuildConfig.FLAVOR, "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "specificBillingLibraryVersion", "timesOfImplicitPurchases", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/facebook/appevents/iap/InAppPurchase;", BuildConfig.FLAVOR, "Lkotlin/Pair;", BuildConfig.FLAVOR, "Landroid/os/Bundle;", "Lcom/facebook/appevents/OperationalData;", "timesOfManualPurchases", "enableAutoLogging", BuildConfig.FLAVOR, "getBillingClientVersion", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;", "getDedupeParameter", "newPurchaseParameters", "newPurchaseOperationalData", "oldPurchaseParameters", "oldPurchaseOperationalData", "dedupingWithImplicitlyLoggedHistory", BuildConfig.FLAVOR, "withTestDedupeKeys", "getSpecificBillingLibraryVersion", "performDedupe", "purchases", BuildConfig.FLAVOR, "time", "isImplicitlyLogged", "purchaseParameters", "setSpecificBillingLibraryVersion", "version", "startTracking", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class InAppPurchaseManager {
    private static final String GOOGLE_BILLINGCLIENT_VERSION = "com.google.android.play.billingclient.version";
    private static String specificBillingLibraryVersion;
    public static final InAppPurchaseManager INSTANCE = new InAppPurchaseManager();
    private static final ConcurrentHashMap<InAppPurchase, List<Pair<Long, Pair<Bundle, OperationalData>>>> timesOfManualPurchases = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<InAppPurchase, List<Pair<Long, Pair<Bundle, OperationalData>>>> timesOfImplicitPurchases = new ConcurrentHashMap<>();
    private static final AtomicBoolean enabled = new AtomicBoolean(false);

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InAppPurchaseUtils.BillingClientVersion.valuesCustom().length];
            iArr[InAppPurchaseUtils.BillingClientVersion.NONE.ordinal()] = 1;
            iArr[InAppPurchaseUtils.BillingClientVersion.V1.ordinal()] = 2;
            iArr[InAppPurchaseUtils.BillingClientVersion.V2_V4.ordinal()] = 3;
            iArr[InAppPurchaseUtils.BillingClientVersion.V5_V7.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private InAppPurchaseManager() {
    }

    public static final void enableAutoLogging() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return;
        }
        try {
            if (!AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
                InAppPurchaseLoggerManager.updateLatestPossiblePurchaseTime();
            } else {
                enabled.set(true);
                startTracking();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
        }
    }

    private final InAppPurchaseUtils.BillingClientVersion getBillingClientVersion() {
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Context applicationContext = FacebookSdk.getApplicationContext();
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "context.packageManager.getApplicationInfo(\n                    context.packageName, PackageManager.GET_META_DATA\n                )");
                String string = applicationInfo.metaData.getString(GOOGLE_BILLINGCLIENT_VERSION);
                if (string == null) {
                    return InAppPurchaseUtils.BillingClientVersion.NONE;
                }
                List split$default = StringsKt.split$default((CharSequence) string, new String[]{"."}, false, 3, 2, (Object) null);
                if (string.length() == 0) {
                    return InAppPurchaseUtils.BillingClientVersion.V5_V7;
                }
                setSpecificBillingLibraryVersion(Intrinsics.stringPlus("GPBL.", string));
                Integer intOrNull = StringsKt.toIntOrNull((String) split$default.get(0));
                if (intOrNull == null) {
                    return InAppPurchaseUtils.BillingClientVersion.V5_V7;
                }
                int intValue = intOrNull.intValue();
                return intValue == 1 ? InAppPurchaseUtils.BillingClientVersion.V1 : intValue < 5 ? InAppPurchaseUtils.BillingClientVersion.V2_V4 : InAppPurchaseUtils.BillingClientVersion.V5_V7;
            } catch (Exception unused) {
                return InAppPurchaseUtils.BillingClientVersion.V5_V7;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static /* synthetic */ String getDedupeParameter$default(InAppPurchaseManager inAppPurchaseManager, Bundle bundle, OperationalData operationalData, Bundle bundle2, OperationalData operationalData2, boolean z5, boolean z6, int i5, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return null;
        }
        try {
            return inAppPurchaseManager.getDedupeParameter(bundle, operationalData, bundle2, operationalData2, z5, (i5 & 32) != 0 ? false : z6);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
            return null;
        }
    }

    public static final String getSpecificBillingLibraryVersion() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return null;
        }
        try {
            return specificBillingLibraryVersion;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final synchronized Bundle performDedupe(List<InAppPurchase> purchases, long time, boolean isImplicitlyLogged, List<Pair<Bundle, OperationalData>> purchaseParameters) {
        Bundle bundle;
        InAppPurchase inAppPurchase;
        String str;
        String str2;
        Long l5;
        boolean z5;
        List<InAppPurchase> purchases2 = purchases;
        List<Pair<Bundle, OperationalData>> purchaseParameters2 = purchaseParameters;
        synchronized (InAppPurchaseManager.class) {
            String str3 = null;
            if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(purchases2, "purchases");
                Intrinsics.checkNotNullParameter(purchaseParameters2, "purchaseParameters");
                if (purchaseParameters2.isEmpty()) {
                    return null;
                }
                if (purchases.size() != purchaseParameters.size()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                int size = purchases.size() - 1;
                if (size >= 0) {
                    bundle = null;
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        InAppPurchase inAppPurchase2 = purchases2.get(i5);
                        Pair<Bundle, OperationalData> pair = purchaseParameters2.get(i5);
                        Bundle component1 = pair.component1();
                        OperationalData component2 = pair.component2();
                        InAppPurchase inAppPurchase3 = new InAppPurchase(inAppPurchase2.getEventName(), new BigDecimal(String.valueOf(inAppPurchase2.getAmount())).setScale(2, RoundingMode.HALF_UP).doubleValue(), inAppPurchase2.getCurrency());
                        List<Pair<Long, Pair<Bundle, OperationalData>>> list = isImplicitlyLogged ? timesOfManualPurchases.get(inAppPurchase3) : timesOfImplicitPurchases.get(inAppPurchase3);
                        List<Pair<Long, Pair<Bundle, OperationalData>>> list2 = list;
                        if (list2 == null || list2.isEmpty()) {
                            inAppPurchase = inAppPurchase3;
                            str = null;
                            str2 = null;
                            l5 = null;
                            z5 = false;
                        } else {
                            str = str3;
                            str2 = str;
                            Long l6 = str2;
                            z5 = false;
                            for (Pair<Long, Pair<Bundle, OperationalData>> pair2 : list) {
                                long longValue = pair2.getFirst().longValue();
                                Pair<Bundle, OperationalData> second = pair2.getSecond();
                                Bundle component12 = second.component1();
                                OperationalData component22 = second.component2();
                                if (Math.abs(time - longValue) <= InAppPurchaseDedupeConfig.INSTANCE.getDedupeWindow() && (l6 == 0 || longValue < l6.longValue())) {
                                    InAppPurchaseManager inAppPurchaseManager = INSTANCE;
                                    InAppPurchase inAppPurchase4 = inAppPurchase3;
                                    String dedupeParameter$default = getDedupeParameter$default(inAppPurchaseManager, component1, component2, component12, component22, !isImplicitlyLogged, false, 32, null);
                                    String dedupeParameter = inAppPurchaseManager.getDedupeParameter(component1, component2, component12, component22, !isImplicitlyLogged, true);
                                    if (dedupeParameter != null) {
                                        str = dedupeParameter;
                                    }
                                    if (dedupeParameter$default != null) {
                                        Long valueOf = Long.valueOf(longValue);
                                        arrayList.add(new Pair(inAppPurchase4, Long.valueOf(longValue)));
                                        inAppPurchase3 = inAppPurchase4;
                                        str2 = dedupeParameter$default;
                                        z5 = true;
                                        l6 = valueOf;
                                    } else {
                                        inAppPurchase3 = inAppPurchase4;
                                        str2 = dedupeParameter$default;
                                        l6 = l6;
                                    }
                                }
                            }
                            inAppPurchase = inAppPurchase3;
                            l5 = l6;
                        }
                        if (str != null) {
                            if (bundle == null) {
                                bundle = new Bundle();
                            }
                            bundle.putString("fb_iap_test_dedup_result", "1");
                            bundle.putString("fb_iap_test_dedup_key_used", str);
                        }
                        if (z5) {
                            if (bundle == null) {
                                bundle = new Bundle();
                            }
                            bundle.putString("fb_iap_non_deduped_event_time", String.valueOf(l5 == null ? 0L : l5.longValue() / Constants.ONE_SECOND));
                            bundle.putString("fb_iap_actual_dedup_result", "1");
                            bundle.putString("fb_iap_actual_dedup_key_used", str2);
                        }
                        if (isImplicitlyLogged && !z5) {
                            ConcurrentHashMap<InAppPurchase, List<Pair<Long, Pair<Bundle, OperationalData>>>> concurrentHashMap = timesOfImplicitPurchases;
                            if (concurrentHashMap.get(inAppPurchase) == null) {
                                concurrentHashMap.put(inAppPurchase, new ArrayList());
                            }
                            List<Pair<Long, Pair<Bundle, OperationalData>>> list3 = concurrentHashMap.get(inAppPurchase);
                            if (list3 != null) {
                                list3.add(new Pair<>(Long.valueOf(time), new Pair(component1, component2)));
                            }
                        } else if (!isImplicitlyLogged && !z5) {
                            ConcurrentHashMap<InAppPurchase, List<Pair<Long, Pair<Bundle, OperationalData>>>> concurrentHashMap2 = timesOfManualPurchases;
                            if (concurrentHashMap2.get(inAppPurchase) == null) {
                                concurrentHashMap2.put(inAppPurchase, new ArrayList());
                            }
                            List<Pair<Long, Pair<Bundle, OperationalData>>> list4 = concurrentHashMap2.get(inAppPurchase);
                            if (list4 != null) {
                                list4.add(new Pair<>(Long.valueOf(time), new Pair(component1, component2)));
                            }
                        }
                        if (i6 > size) {
                            break;
                        }
                        purchases2 = purchases;
                        purchaseParameters2 = purchaseParameters;
                        i5 = i6;
                        str3 = null;
                    }
                } else {
                    bundle = null;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Pair pair3 = (Pair) it.next();
                    List<Pair<Long, Pair<Bundle, OperationalData>>> list5 = isImplicitlyLogged ? timesOfManualPurchases.get(pair3.getFirst()) : timesOfImplicitPurchases.get(pair3.getFirst());
                    if (list5 != null) {
                        Iterator<Pair<Long, Pair<Bundle, OperationalData>>> it2 = list5.iterator();
                        int i7 = 0;
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            int i8 = i7 + 1;
                            if (it2.next().getFirst().longValue() == ((Number) pair3.getSecond()).longValue()) {
                                list5.remove(i7);
                                break;
                            }
                            i7 = i8;
                        }
                        if (isImplicitlyLogged) {
                            if (list5.isEmpty()) {
                                timesOfManualPurchases.remove(pair3.getFirst());
                            } else {
                                timesOfManualPurchases.put(pair3.getFirst(), list5);
                            }
                        } else if (list5.isEmpty()) {
                            timesOfImplicitPurchases.remove(pair3.getFirst());
                        } else {
                            timesOfImplicitPurchases.put(pair3.getFirst(), list5);
                        }
                    }
                }
                return bundle;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
                return null;
            }
        }
    }

    private static final void setSpecificBillingLibraryVersion(String version) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return;
        }
        try {
            specificBillingLibraryVersion = version;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
        }
    }

    public static final void startTracking() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return;
        }
        try {
            if (enabled.get()) {
                InAppPurchaseUtils.BillingClientVersion billingClientVersion = INSTANCE.getBillingClientVersion();
                int i5 = WhenMappings.$EnumSwitchMapping$0[billingClientVersion.ordinal()];
                if (i5 == 2) {
                    InAppPurchaseActivityLifecycleTracker inAppPurchaseActivityLifecycleTracker = InAppPurchaseActivityLifecycleTracker.INSTANCE;
                    InAppPurchaseActivityLifecycleTracker.startIapLogging(InAppPurchaseUtils.BillingClientVersion.V1);
                    return;
                }
                if (i5 != 3) {
                    if (i5 != 4) {
                        return;
                    }
                    FeatureManager featureManager = FeatureManager.INSTANCE;
                    if (FeatureManager.isEnabled(FeatureManager.Feature.IapLoggingLib5To7)) {
                        InAppPurchaseAutoLogger inAppPurchaseAutoLogger = InAppPurchaseAutoLogger.INSTANCE;
                        InAppPurchaseAutoLogger.startIapLogging(FacebookSdk.getApplicationContext(), billingClientVersion);
                        return;
                    }
                    return;
                }
                FeatureManager featureManager2 = FeatureManager.INSTANCE;
                if (FeatureManager.isEnabled(FeatureManager.Feature.IapLoggingLib2)) {
                    InAppPurchaseAutoLogger inAppPurchaseAutoLogger2 = InAppPurchaseAutoLogger.INSTANCE;
                    InAppPurchaseAutoLogger.startIapLogging(FacebookSdk.getApplicationContext(), billingClientVersion);
                } else {
                    InAppPurchaseActivityLifecycleTracker inAppPurchaseActivityLifecycleTracker2 = InAppPurchaseActivityLifecycleTracker.INSTANCE;
                    InAppPurchaseActivityLifecycleTracker.startIapLogging(InAppPurchaseUtils.BillingClientVersion.V2_V4);
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
        }
    }

    public final String getDedupeParameter(Bundle newPurchaseParameters, OperationalData newPurchaseOperationalData, Bundle oldPurchaseParameters, OperationalData oldPurchaseOperationalData, boolean dedupingWithImplicitlyLoggedHistory, boolean withTestDedupeKeys) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            List<Pair<String, List<String>>> testDedupeParameters = withTestDedupeKeys ? InAppPurchaseDedupeConfig.INSTANCE.getTestDedupeParameters(dedupingWithImplicitlyLoggedHistory) : InAppPurchaseDedupeConfig.INSTANCE.getDedupeParameters(dedupingWithImplicitlyLoggedHistory);
            if (testDedupeParameters == null) {
                return null;
            }
            for (Pair<String, List<String>> pair : testDedupeParameters) {
                Object parameter = OperationalData.INSTANCE.getParameter(OperationalDataEnum.IAPParameters, pair.getFirst(), newPurchaseParameters, newPurchaseOperationalData);
                String str = parameter instanceof String ? (String) parameter : null;
                if (str != null && str.length() != 0) {
                    for (String str2 : pair.getSecond()) {
                        Object parameter2 = OperationalData.INSTANCE.getParameter(OperationalDataEnum.IAPParameters, str2, oldPurchaseParameters, oldPurchaseOperationalData);
                        String str3 = parameter2 instanceof String ? (String) parameter2 : null;
                        if (str3 != null && str3.length() != 0 && Intrinsics.areEqual(str3, str)) {
                            return dedupingWithImplicitlyLoggedHistory ? pair.getFirst() : str2;
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
