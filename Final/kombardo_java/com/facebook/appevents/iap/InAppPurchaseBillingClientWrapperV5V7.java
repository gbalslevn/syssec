package com.facebook.appevents.iap;

import android.content.Context;
import android.util.Log;
import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapperV5V7;
import com.facebook.appevents.iap.InAppPurchaseUtils;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.conscrypt.BuildConfig;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0015\b\u0007\u0018\u0000 S2\u00020\u0001:\u0002STB\u0085\u0003\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u0016\u0012\u0006\u0010 \u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020\u0016\u0012\u0006\u0010\"\u001a\u00020\u0016\u0012\u0006\u0010#\u001a\u00020\u0016\u0012\u0006\u0010$\u001a\u00020\u0016\u0012\u0006\u0010%\u001a\u00020\u0016\u0012\u0006\u0010&\u001a\u00020\u0016\u0012\u0006\u0010'\u001a\u00020\u0016\u0012\u0006\u0010(\u001a\u00020\u0016\u0012\u0006\u0010)\u001a\u00020\u0016\u0012\u0006\u0010*\u001a\u00020\u0016\u0012\u0006\u0010+\u001a\u00020\u0016¢\u0006\u0004\b,\u0010-J\u0019\u00100\u001a\u0004\u0018\u00010\u00022\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J)\u00105\u001a\u0004\u0018\u00010\u00022\u0006\u0010/\u001a\u00020.2\u000e\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010302H\u0002¢\u0006\u0004\b5\u00106J-\u0010:\u001a\u0002092\u0006\u0010/\u001a\u00020.2\f\u00104\u001a\b\u0012\u0004\u0012\u000203022\u0006\u00108\u001a\u000207H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u0002092\u0006\u0010<\u001a\u000207H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u0002092\u0006\u0010<\u001a\u000207H\u0002¢\u0006\u0004\b?\u0010>J/\u0010C\u001a\u0002092\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010@2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010@H\u0002¢\u0006\u0004\bC\u0010DJ/\u0010E\u001a\u0002092\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010@2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010@H\u0002¢\u0006\u0004\bE\u0010DJ/\u0010F\u001a\u0002092\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010@2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010@H\u0002¢\u0006\u0004\bF\u0010DJ/\u0010G\u001a\u0002092\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010@2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010@H\u0002¢\u0006\u0004\bG\u0010DJ/\u0010H\u001a\u0002092\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010@2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010@H\u0002¢\u0006\u0004\bH\u0010DJ\u001f\u0010I\u001a\u0002092\u0006\u0010/\u001a\u00020.2\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\bI\u0010JJ\u0017\u0010L\u001a\u0004\u0018\u0001032\u0006\u0010K\u001a\u000203¢\u0006\u0004\bL\u0010MR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010N\u001a\u0004\bO\u0010PR\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010QR\u0018\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010QR\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010QR\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010QR\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010QR\u0018\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010QR\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010QR\u0018\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010QR\u0018\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010QR\u0018\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010QR\u0018\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010QR\u0018\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010QR\u0018\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010QR\u0018\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010QR\u0018\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010QR\u0018\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010QR\u0018\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010QR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010RR\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010RR\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010RR\u0014\u0010\u001a\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010RR\u0014\u0010\u001b\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010RR\u0014\u0010\u001c\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010RR\u0014\u0010\u001d\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010RR\u0014\u0010\u001e\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010RR\u0014\u0010\u001f\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010RR\u0014\u0010 \u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010RR\u0014\u0010!\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010RR\u0014\u0010\"\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010RR\u0014\u0010#\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010RR\u0014\u0010$\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010RR\u0014\u0010%\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010RR\u0014\u0010&\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010RR\u0014\u0010'\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010RR\u0014\u0010(\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010RR\u0014\u0010)\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010RR\u0014\u0010*\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010RR\u0014\u0010+\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010R¨\u0006U"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7;", "Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;", BuildConfig.FLAVOR, "billingClient", "Ljava/lang/Class;", "billingClientClazz", "purchaseClazz", "productDetailsClazz", "purchaseHistoryRecordClazz", "queryProductDetailsParamsProductClazz", "billingResultClazz", "queryProductDetailsParamsClazz", "queryPurchaseHistoryParamsClazz", "queryPurchasesParamsClazz", "queryProductDetailsParamsBuilderClazz", "queryPurchaseHistoryParamsBuilderClazz", "queryPurchasesParamsBuilderClazz", "queryProductDetailsParamsProductBuilderClazz", "billingClientStateListenerClazz", "productDetailsResponseListenerClazz", "purchasesResponseListenerClazz", "purchaseHistoryResponseListenerClazz", "Ljava/lang/reflect/Method;", "queryPurchasesAsyncMethod", "queryPurchasesParamsNewBuilderMethod", "queryPurchasesParamsBuilderBuildMethod", "queryPurchasesParamsBuilderSetProductTypeMethod", "purchaseGetOriginalJsonMethod", "queryPurchaseHistoryAsyncMethod", "queryPurchaseHistoryParamsNewBuilderMethod", "queryPurchaseHistoryParamsBuilderBuildMethod", "queryPurchaseHistoryParamsBuilderSetProductTypeMethod", "purchaseHistoryRecordGetOriginalJsonMethod", "queryProductDetailsAsyncMethod", "queryProductDetailsParamsNewBuilderMethod", "queryProductDetailsParamsBuilderBuildMethod", "queryProductDetailsParamsBuilderSetProductListMethod", "queryProductDetailsParamsProductNewBuilderMethod", "queryProductDetailsParamsProductBuilderBuildMethod", "queryProductDetailsParamsProductBuilderSetProductIdMethod", "queryProductDetailsParamsProductBuilderSetProductTypeMethod", "productDetailsToStringMethod", "billingClientStartConnectionMethod", "billingResultGetResponseCodeMethod", "<init>", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;", "productType", "getQueryPurchaseHistoryParams", "(Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;)Ljava/lang/Object;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "productIds", "getQueryProductDetailsParams", "(Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;Ljava/util/List;)Ljava/lang/Object;", "Ljava/lang/Runnable;", "completionHandler", BuildConfig.FLAVOR, "queryProductDetailsAsync", "(Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;Ljava/util/List;Ljava/lang/Runnable;)V", "runnable", "executeServiceRequest", "(Ljava/lang/Runnable;)V", "startConnection", BuildConfig.FLAVOR, "wrapperArgs", "listenerArgs", "onQueryPurchasesResponse", "([Ljava/lang/Object;[Ljava/lang/Object;)V", "onPurchaseHistoryResponse", "onProductDetailsResponse", "onBillingSetupFinished", "onBillingServiceDisconnected", "queryPurchaseHistory", "(Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;Ljava/lang/Runnable;)V", "productDetailsString", "getOriginalJson", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/lang/Object;", "getBillingClient", "()Ljava/lang/Object;", "Ljava/lang/Class;", "Ljava/lang/reflect/Method;", "Companion", "ListenerWrapper", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class InAppPurchaseBillingClientWrapperV5V7 implements InAppPurchaseBillingClientWrapper {
    private static InAppPurchaseBillingClientWrapperV5V7 instance;
    private final Object billingClient;
    private final Class<?> billingClientClazz;
    private final Method billingClientStartConnectionMethod;
    private final Class<?> billingClientStateListenerClazz;
    private final Class<?> billingResultClazz;
    private final Method billingResultGetResponseCodeMethod;
    private final Class<?> productDetailsClazz;
    private final Class<?> productDetailsResponseListenerClazz;
    private final Method productDetailsToStringMethod;
    private final Class<?> purchaseClazz;
    private final Method purchaseGetOriginalJsonMethod;
    private final Class<?> purchaseHistoryRecordClazz;
    private final Method purchaseHistoryRecordGetOriginalJsonMethod;
    private final Class<?> purchaseHistoryResponseListenerClazz;
    private final Class<?> purchasesResponseListenerClazz;
    private final Method queryProductDetailsAsyncMethod;
    private final Method queryProductDetailsParamsBuilderBuildMethod;
    private final Class<?> queryProductDetailsParamsBuilderClazz;
    private final Method queryProductDetailsParamsBuilderSetProductListMethod;
    private final Class<?> queryProductDetailsParamsClazz;
    private final Method queryProductDetailsParamsNewBuilderMethod;
    private final Method queryProductDetailsParamsProductBuilderBuildMethod;
    private final Class<?> queryProductDetailsParamsProductBuilderClazz;
    private final Method queryProductDetailsParamsProductBuilderSetProductIdMethod;
    private final Method queryProductDetailsParamsProductBuilderSetProductTypeMethod;
    private final Class<?> queryProductDetailsParamsProductClazz;
    private final Method queryProductDetailsParamsProductNewBuilderMethod;
    private final Method queryPurchaseHistoryAsyncMethod;
    private final Method queryPurchaseHistoryParamsBuilderBuildMethod;
    private final Class<?> queryPurchaseHistoryParamsBuilderClazz;
    private final Method queryPurchaseHistoryParamsBuilderSetProductTypeMethod;
    private final Class<?> queryPurchaseHistoryParamsClazz;
    private final Method queryPurchaseHistoryParamsNewBuilderMethod;
    private final Method queryPurchasesAsyncMethod;
    private final Method queryPurchasesParamsBuilderBuildMethod;
    private final Class<?> queryPurchasesParamsBuilderClazz;
    private final Method queryPurchasesParamsBuilderSetProductTypeMethod;
    private final Class<?> queryPurchasesParamsClazz;
    private final Method queryPurchasesParamsNewBuilderMethod;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = InAppPurchaseBillingClientWrapperV5V7.class.getCanonicalName();
    private static final AtomicBoolean isServiceConnected = new AtomicBoolean(false);
    private static final Map<String, JSONObject> iapPurchaseDetailsMap = new ConcurrentHashMap();
    private static final Map<String, JSONObject> subsPurchaseDetailsMap = new ConcurrentHashMap();
    private static final Map<String, JSONObject> productDetailsMap = new ConcurrentHashMap();

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ=\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\t2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\bJ2\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017R#\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00188\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR#\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00188\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR#\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00188\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u001c\u0010$\u001a\n #*\u0004\u0018\u00010\u00190\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7$Companion;", "Ljava/lang/reflect/InvocationHandler;", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7;", "createInstance", "(Landroid/content/Context;)Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7;", "Ljava/lang/Class;", "billingClientClazz", "billingClientBuilderClazz", "purchasesUpdatedListenerClazz", BuildConfig.FLAVOR, "createBillingClient", "(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/Object;", "getOrCreateInstance", "proxy", "Ljava/lang/reflect/Method;", "m", BuildConfig.FLAVOR, "args", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lorg/json/JSONObject;", "iapPurchaseDetailsMap", "Ljava/util/Map;", "getIapPurchaseDetailsMap", "()Ljava/util/Map;", "subsPurchaseDetailsMap", "getSubsPurchaseDetailsMap", "productDetailsMap", "getProductDetailsMap", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "instance", "Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion implements InvocationHandler {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object createBillingClient(Context context, Class<?> billingClientClazz, Class<?> billingClientBuilderClazz, Class<?> purchasesUpdatedListenerClazz) {
            Object invokeMethod;
            Method method = InAppPurchaseUtils.getMethod(billingClientClazz, "newBuilder", Context.class);
            Method method2 = InAppPurchaseUtils.getMethod(billingClientBuilderClazz, "setListener", purchasesUpdatedListenerClazz);
            Method method3 = InAppPurchaseUtils.getMethod(billingClientBuilderClazz, "enablePendingPurchases", new Class[0]);
            Method method4 = InAppPurchaseUtils.getMethod(billingClientBuilderClazz, "build", new Class[0]);
            if (method4 == null || method2 == null || method == null || method3 == null || (invokeMethod = InAppPurchaseUtils.invokeMethod(billingClientBuilderClazz, method2, InAppPurchaseUtils.invokeMethod(billingClientClazz, method, null, context), Proxy.newProxyInstance(purchasesUpdatedListenerClazz.getClassLoader(), new Class[]{purchasesUpdatedListenerClazz}, this))) == null) {
                return null;
            }
            return InAppPurchaseUtils.invokeMethod(billingClientBuilderClazz, method4, InAppPurchaseUtils.invokeMethod(billingClientBuilderClazz, method3, invokeMethod, new Object[0]), new Object[0]);
        }

        private final InAppPurchaseBillingClientWrapperV5V7 createInstance(Context context) {
            Class<?> cls = InAppPurchaseUtils.getClass("com.android.billingclient.api.BillingClient");
            Class<?> cls2 = InAppPurchaseUtils.getClass("com.android.billingclient.api.Purchase");
            Class<?> cls3 = InAppPurchaseUtils.getClass("com.android.billingclient.api.ProductDetails");
            Class<?> cls4 = InAppPurchaseUtils.getClass("com.android.billingclient.api.PurchaseHistoryRecord");
            Class<?> cls5 = InAppPurchaseUtils.getClass("com.android.billingclient.api.QueryProductDetailsParams$Product");
            Class<?> cls6 = InAppPurchaseUtils.getClass("com.android.billingclient.api.BillingResult");
            Class<?> cls7 = InAppPurchaseUtils.getClass("com.android.billingclient.api.QueryProductDetailsParams");
            Class<?> cls8 = InAppPurchaseUtils.getClass("com.android.billingclient.api.QueryPurchaseHistoryParams");
            Class<?> cls9 = InAppPurchaseUtils.getClass("com.android.billingclient.api.QueryPurchasesParams");
            Class<?> cls10 = InAppPurchaseUtils.getClass("com.android.billingclient.api.QueryProductDetailsParams$Builder");
            Class<?> cls11 = InAppPurchaseUtils.getClass("com.android.billingclient.api.QueryPurchaseHistoryParams$Builder");
            Class<?> cls12 = InAppPurchaseUtils.getClass("com.android.billingclient.api.QueryPurchasesParams$Builder");
            Class<?> cls13 = InAppPurchaseUtils.getClass("com.android.billingclient.api.QueryProductDetailsParams$Product$Builder");
            Class<?> cls14 = InAppPurchaseUtils.getClass("com.android.billingclient.api.BillingClient$Builder");
            Class<?> cls15 = InAppPurchaseUtils.getClass("com.android.billingclient.api.PurchasesUpdatedListener");
            Class<?> cls16 = InAppPurchaseUtils.getClass("com.android.billingclient.api.BillingClientStateListener");
            Class<?> cls17 = InAppPurchaseUtils.getClass("com.android.billingclient.api.ProductDetailsResponseListener");
            Class<?> cls18 = InAppPurchaseUtils.getClass("com.android.billingclient.api.PurchasesResponseListener");
            Class<?> cls19 = InAppPurchaseUtils.getClass("com.android.billingclient.api.PurchaseHistoryResponseListener");
            if (cls == null || cls2 == null || cls3 == null || cls4 == null || cls5 == null || cls6 == null || cls7 == null || cls8 == null || cls9 == null || cls10 == null || cls11 == null || cls12 == null || cls13 == null || cls14 == null || cls15 == null || cls16 == null || cls17 == null || cls18 == null || cls19 == null) {
                Log.w(InAppPurchaseBillingClientWrapperV5V7.access$getTAG$cp(), "Failed to create Google Play billing library wrapper for in-app purchase auto-logging");
                return null;
            }
            Method method = InAppPurchaseUtils.getMethod(cls, "queryPurchasesAsync", cls9, cls18);
            Method method2 = InAppPurchaseUtils.getMethod(cls9, "newBuilder", new Class[0]);
            Method method3 = InAppPurchaseUtils.getMethod(cls12, "build", new Class[0]);
            Method method4 = InAppPurchaseUtils.getMethod(cls12, "setProductType", String.class);
            Method method5 = InAppPurchaseUtils.getMethod(cls2, "getOriginalJson", new Class[0]);
            Method method6 = InAppPurchaseUtils.getMethod(cls, "queryPurchaseHistoryAsync", cls8, cls19);
            Method method7 = InAppPurchaseUtils.getMethod(cls8, "newBuilder", new Class[0]);
            Method method8 = InAppPurchaseUtils.getMethod(cls11, "build", new Class[0]);
            Method method9 = InAppPurchaseUtils.getMethod(cls11, "setProductType", String.class);
            Method method10 = InAppPurchaseUtils.getMethod(cls4, "getOriginalJson", new Class[0]);
            Method method11 = InAppPurchaseUtils.getMethod(cls, "queryProductDetailsAsync", cls7, cls17);
            Method method12 = InAppPurchaseUtils.getMethod(cls7, "newBuilder", new Class[0]);
            Method method13 = InAppPurchaseUtils.getMethod(cls10, "build", new Class[0]);
            Method method14 = InAppPurchaseUtils.getMethod(cls10, "setProductList", List.class);
            Method method15 = InAppPurchaseUtils.getMethod(cls5, "newBuilder", new Class[0]);
            Method method16 = InAppPurchaseUtils.getMethod(cls13, "build", new Class[0]);
            Method method17 = InAppPurchaseUtils.getMethod(cls13, "setProductId", String.class);
            Method method18 = InAppPurchaseUtils.getMethod(cls13, "setProductType", String.class);
            Method method19 = InAppPurchaseUtils.getMethod(cls3, "toString", new Class[0]);
            Method method20 = InAppPurchaseUtils.getMethod(cls, "startConnection", cls16);
            Method method21 = InAppPurchaseUtils.getMethod(cls6, "getResponseCode", new Class[0]);
            if (method == null || method2 == null || method3 == null || method4 == null || method5 == null || method6 == null || method7 == null || method8 == null || method9 == null || method10 == null || method11 == null || method12 == null || method13 == null || method14 == null || method15 == null || method16 == null || method17 == null || method18 == null || method19 == null || method20 == null || method21 == null) {
                Log.w(InAppPurchaseBillingClientWrapperV5V7.access$getTAG$cp(), "Failed to create Google Play billing library wrapper for in-app purchase auto-logging");
                return null;
            }
            Object createBillingClient = createBillingClient(context, cls, cls14, cls15);
            if (createBillingClient == null) {
                Log.w(InAppPurchaseBillingClientWrapperV5V7.access$getTAG$cp(), "Failed to build a Google Play billing library wrapper for in-app purchase auto-logging");
                return null;
            }
            InAppPurchaseBillingClientWrapperV5V7.access$setInstance$cp(new InAppPurchaseBillingClientWrapperV5V7(createBillingClient, cls, cls2, cls3, cls4, cls5, cls6, cls7, cls8, cls9, cls10, cls11, cls12, cls13, cls16, cls17, cls18, cls19, method, method2, method3, method4, method5, method6, method7, method8, method9, method10, method11, method12, method13, method14, method15, method16, method17, method18, method19, method20, method21, null));
            return InAppPurchaseBillingClientWrapperV5V7.access$getInstance$cp();
        }

        public final Map<String, JSONObject> getIapPurchaseDetailsMap() {
            return InAppPurchaseBillingClientWrapperV5V7.access$getIapPurchaseDetailsMap$cp();
        }

        public final synchronized InAppPurchaseBillingClientWrapperV5V7 getOrCreateInstance(Context context) {
            InAppPurchaseBillingClientWrapperV5V7 access$getInstance$cp;
            Intrinsics.checkNotNullParameter(context, "context");
            access$getInstance$cp = InAppPurchaseBillingClientWrapperV5V7.access$getInstance$cp();
            if (access$getInstance$cp == null) {
                access$getInstance$cp = createInstance(context);
            }
            return access$getInstance$cp;
        }

        public final Map<String, JSONObject> getProductDetailsMap() {
            return InAppPurchaseBillingClientWrapperV5V7.access$getProductDetailsMap$cp();
        }

        public final Map<String, JSONObject> getSubsPurchaseDetailsMap() {
            return InAppPurchaseBillingClientWrapperV5V7.access$getSubsPurchaseDetailsMap$cp();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method m5, Object[] args) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            Intrinsics.checkNotNullParameter(m5, "m");
            return null;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J0\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0002\u0010\fR\u0018\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7$ListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "wrapperArgs", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "(Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7;[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "invoke", "proxy", "m", "Ljava/lang/reflect/Method;", "listenerArgs", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public final class ListenerWrapper implements InvocationHandler {
        final /* synthetic */ InAppPurchaseBillingClientWrapperV5V7 this$0;
        private Object[] wrapperArgs;

        public ListenerWrapper(InAppPurchaseBillingClientWrapperV5V7 this$0, Object[] objArr) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
            this.wrapperArgs = objArr;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method m5, Object[] listenerArgs) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            Intrinsics.checkNotNullParameter(m5, "m");
            String name = m5.getName();
            if (name == null) {
                return null;
            }
            switch (name.hashCode()) {
                case -1642587947:
                    if (!name.equals("onPurchaseHistoryResponse")) {
                        return null;
                    }
                    InAppPurchaseBillingClientWrapperV5V7.access$onPurchaseHistoryResponse(this.this$0, this.wrapperArgs, listenerArgs);
                    return null;
                case -1599362358:
                    if (!name.equals("onQueryPurchasesResponse")) {
                        return null;
                    }
                    InAppPurchaseBillingClientWrapperV5V7.access$onQueryPurchasesResponse(this.this$0, this.wrapperArgs, listenerArgs);
                    return null;
                case -79406125:
                    if (!name.equals("onBillingSetupFinished")) {
                        return null;
                    }
                    InAppPurchaseBillingClientWrapperV5V7.access$onBillingSetupFinished(this.this$0, this.wrapperArgs, listenerArgs);
                    return null;
                case 1227540564:
                    if (!name.equals("onBillingServiceDisconnected")) {
                        return null;
                    }
                    InAppPurchaseBillingClientWrapperV5V7.access$onBillingServiceDisconnected(this.this$0, this.wrapperArgs, listenerArgs);
                    return null;
                case 1940131955:
                    if (!name.equals("onProductDetailsResponse")) {
                        return null;
                    }
                    InAppPurchaseBillingClientWrapperV5V7.access$onProductDetailsResponse(this.this$0, this.wrapperArgs, listenerArgs);
                    return null;
                default:
                    return null;
            }
        }
    }

    public /* synthetic */ InAppPurchaseBillingClientWrapperV5V7(Object obj, Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, Class cls8, Class cls9, Class cls10, Class cls11, Class cls12, Class cls13, Class cls14, Class cls15, Class cls16, Class cls17, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, Method method8, Method method9, Method method10, Method method11, Method method12, Method method13, Method method14, Method method15, Method method16, Method method17, Method method18, Method method19, Method method20, Method method21, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, cls, cls2, cls3, cls4, cls5, cls6, cls7, cls8, cls9, cls10, cls11, cls12, cls13, cls14, cls15, cls16, cls17, method, method2, method3, method4, method5, method6, method7, method8, method9, method10, method11, method12, method13, method14, method15, method16, method17, method18, method19, method20, method21);
    }

    public static final /* synthetic */ Map access$getIapPurchaseDetailsMap$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return iapPurchaseDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ InAppPurchaseBillingClientWrapperV5V7 access$getInstance$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ Map access$getProductDetailsMap$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return productDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ Map access$getSubsPurchaseDetailsMap$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return subsPurchaseDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$onBillingServiceDisconnected(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, Object[] objArr, Object[] objArr2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.onBillingServiceDisconnected(objArr, objArr2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    public static final /* synthetic */ void access$onBillingSetupFinished(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, Object[] objArr, Object[] objArr2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.onBillingSetupFinished(objArr, objArr2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    public static final /* synthetic */ void access$onProductDetailsResponse(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, Object[] objArr, Object[] objArr2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.onProductDetailsResponse(objArr, objArr2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    public static final /* synthetic */ void access$onPurchaseHistoryResponse(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, Object[] objArr, Object[] objArr2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.onPurchaseHistoryResponse(objArr, objArr2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    public static final /* synthetic */ void access$onQueryPurchasesResponse(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, Object[] objArr, Object[] objArr2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.onQueryPurchasesResponse(objArr, objArr2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    public static final /* synthetic */ void access$setInstance$cp(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            instance = inAppPurchaseBillingClientWrapperV5V7;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    private final void executeServiceRequest(Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (isServiceConnected.get()) {
                runnable.run();
            } else {
                startConnection(runnable);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final Object getQueryProductDetailsParams(InAppPurchaseUtils.IAPProductType productType, List<String> productIds) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (productIds.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : productIds) {
                InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                Object invokeMethod = InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsProductBuilderClazz, this.queryProductDetailsParamsProductBuilderBuildMethod, InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsProductBuilderClazz, this.queryProductDetailsParamsProductBuilderSetProductTypeMethod, InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsProductBuilderClazz, this.queryProductDetailsParamsProductBuilderSetProductIdMethod, InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsProductClazz, this.queryProductDetailsParamsProductNewBuilderMethod, null, new Object[0]), str), productType.getType()), new Object[0]);
                if (invokeMethod != null) {
                    arrayList.add(invokeMethod);
                }
            }
            InAppPurchaseUtils inAppPurchaseUtils2 = InAppPurchaseUtils.INSTANCE;
            return InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsBuilderClazz, this.queryProductDetailsParamsBuilderBuildMethod, InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsBuilderClazz, this.queryProductDetailsParamsBuilderSetProductListMethod, InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsClazz, this.queryProductDetailsParamsNewBuilderMethod, null, new Object[0]), arrayList), new Object[0]);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Object getQueryPurchaseHistoryParams(InAppPurchaseUtils.IAPProductType productType) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            return InAppPurchaseUtils.invokeMethod(this.queryPurchaseHistoryParamsBuilderClazz, this.queryPurchaseHistoryParamsBuilderBuildMethod, InAppPurchaseUtils.invokeMethod(this.queryPurchaseHistoryParamsBuilderClazz, this.queryPurchaseHistoryParamsBuilderSetProductTypeMethod, InAppPurchaseUtils.invokeMethod(this.queryPurchaseHistoryParamsClazz, this.queryPurchaseHistoryParamsNewBuilderMethod, null, new Object[0]), productType.getType()), new Object[0]);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void onBillingServiceDisconnected(Object[] wrapperArgs, Object[] listenerArgs) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            isServiceConnected.set(false);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void onBillingSetupFinished(Object[] wrapperArgs, Object[] listenerArgs) {
        Runnable runnable;
        if (CrashShieldHandler.isObjectCrashing(this) || listenerArgs == null) {
            return;
        }
        try {
            if (listenerArgs.length == 0) {
                return;
            }
            Object obj = listenerArgs[0];
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            if (Intrinsics.areEqual(InAppPurchaseUtils.invokeMethod(this.billingResultClazz, this.billingResultGetResponseCodeMethod, obj, new Object[0]), (Object) 0)) {
                isServiceConnected.set(true);
                if (wrapperArgs != null && wrapperArgs.length != 0) {
                    Object obj2 = wrapperArgs[0];
                    if ((obj2 instanceof Runnable) && (runnable = (Runnable) obj2) != null) {
                        runnable.run();
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void onProductDetailsResponse(Object[] wrapperArgs, Object[] listenerArgs) {
        Object orNull;
        String originalJson;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (wrapperArgs == null) {
            orNull = null;
        } else {
            try {
                orNull = ArraysKt.getOrNull(wrapperArgs, 0);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return;
            }
        }
        Object orNull2 = listenerArgs == null ? null : ArraysKt.getOrNull(listenerArgs, 1);
        if (orNull2 != null && (orNull2 instanceof List)) {
            for (Object obj : (List) orNull2) {
                try {
                    InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                    Object invokeMethod = InAppPurchaseUtils.invokeMethod(this.productDetailsClazz, this.productDetailsToStringMethod, obj, new Object[0]);
                    String str = invokeMethod instanceof String ? (String) invokeMethod : null;
                    if (str != null && (originalJson = getOriginalJson(str)) != null) {
                        JSONObject jSONObject = new JSONObject(originalJson);
                        if (jSONObject.has("productId")) {
                            String productId = jSONObject.getString("productId");
                            Map<String, JSONObject> map = productDetailsMap;
                            Intrinsics.checkNotNullExpressionValue(productId, "productId");
                            map.put(productId, jSONObject);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (orNull == null || !(orNull instanceof Runnable)) {
                return;
            }
            ((Runnable) orNull).run();
        }
    }

    private final void onPurchaseHistoryResponse(Object[] wrapperArgs, Object[] listenerArgs) {
        Object orNull;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (wrapperArgs == null) {
            orNull = null;
        } else {
            try {
                orNull = ArraysKt.getOrNull(wrapperArgs, 0);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return;
            }
        }
        if (orNull != null && (orNull instanceof InAppPurchaseUtils.IAPProductType)) {
            Object orNull2 = ArraysKt.getOrNull(wrapperArgs, 1);
            if (orNull2 instanceof Runnable) {
                Object orNull3 = listenerArgs == null ? null : ArraysKt.getOrNull(listenerArgs, 1);
                if (orNull3 != null && (orNull3 instanceof List)) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : (List) orNull3) {
                        try {
                            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                            Object invokeMethod = InAppPurchaseUtils.invokeMethod(this.purchaseHistoryRecordClazz, this.purchaseHistoryRecordGetOriginalJsonMethod, obj, new Object[0]);
                            String str = invokeMethod instanceof String ? (String) invokeMethod : null;
                            if (str != null) {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.has("productId")) {
                                    String productId = jSONObject.getString("productId");
                                    if (!productDetailsMap.containsKey(productId)) {
                                        Intrinsics.checkNotNullExpressionValue(productId, "productId");
                                        arrayList.add(productId);
                                    }
                                    if (orNull == InAppPurchaseUtils.IAPProductType.INAPP) {
                                        Map<String, JSONObject> map = iapPurchaseDetailsMap;
                                        Intrinsics.checkNotNullExpressionValue(productId, "productId");
                                        map.put(productId, jSONObject);
                                    } else {
                                        Map<String, JSONObject> map2 = subsPurchaseDetailsMap;
                                        Intrinsics.checkNotNullExpressionValue(productId, "productId");
                                        map2.put(productId, jSONObject);
                                    }
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (arrayList.isEmpty()) {
                        ((Runnable) orNull2).run();
                    } else {
                        queryProductDetailsAsync((InAppPurchaseUtils.IAPProductType) orNull, arrayList, (Runnable) orNull2);
                    }
                }
            }
        }
    }

    private final void onQueryPurchasesResponse(Object[] wrapperArgs, Object[] listenerArgs) {
        Object orNull;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (wrapperArgs == null) {
            orNull = null;
        } else {
            try {
                orNull = ArraysKt.getOrNull(wrapperArgs, 0);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return;
            }
        }
        if (orNull != null && (orNull instanceof InAppPurchaseUtils.IAPProductType)) {
            Object orNull2 = ArraysKt.getOrNull(wrapperArgs, 1);
            if (orNull2 instanceof Runnable) {
                Object orNull3 = listenerArgs == null ? null : ArraysKt.getOrNull(listenerArgs, 1);
                if (orNull3 != null && (orNull3 instanceof List)) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : (List) orNull3) {
                        InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                        Object invokeMethod = InAppPurchaseUtils.invokeMethod(this.purchaseClazz, this.purchaseGetOriginalJsonMethod, obj, new Object[0]);
                        String str = invokeMethod instanceof String ? (String) invokeMethod : null;
                        if (str != null) {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("productId")) {
                                String productId = jSONObject.getString("productId");
                                if (!productDetailsMap.containsKey(productId)) {
                                    Intrinsics.checkNotNullExpressionValue(productId, "productId");
                                    arrayList.add(productId);
                                }
                                if (orNull == InAppPurchaseUtils.IAPProductType.INAPP) {
                                    Map<String, JSONObject> map = iapPurchaseDetailsMap;
                                    Intrinsics.checkNotNullExpressionValue(productId, "productId");
                                    map.put(productId, jSONObject);
                                } else {
                                    Map<String, JSONObject> map2 = subsPurchaseDetailsMap;
                                    Intrinsics.checkNotNullExpressionValue(productId, "productId");
                                    map2.put(productId, jSONObject);
                                }
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        ((Runnable) orNull2).run();
                    } else {
                        queryProductDetailsAsync((InAppPurchaseUtils.IAPProductType) orNull, arrayList, (Runnable) orNull2);
                    }
                }
            }
        }
    }

    private final void queryProductDetailsAsync(final InAppPurchaseUtils.IAPProductType productType, final List<String> productIds, final Runnable completionHandler) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            executeServiceRequest(new Runnable() { // from class: j0.i
                @Override // java.lang.Runnable
                public final void run() {
                    InAppPurchaseBillingClientWrapperV5V7.m2833queryProductDetailsAsync$lambda2(InAppPurchaseBillingClientWrapperV5V7.this, completionHandler, productType, productIds);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: queryProductDetailsAsync$lambda-2, reason: not valid java name */
    public static final void m2833queryProductDetailsAsync$lambda2(InAppPurchaseBillingClientWrapperV5V7 this$0, Runnable completionHandler, InAppPurchaseUtils.IAPProductType productType, List productIds) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(completionHandler, "$completionHandler");
            Intrinsics.checkNotNullParameter(productType, "$productType");
            Intrinsics.checkNotNullParameter(productIds, "$productIds");
            Object newProxyInstance = Proxy.newProxyInstance(this$0.productDetailsResponseListenerClazz.getClassLoader(), new Class[]{this$0.productDetailsResponseListenerClazz}, new ListenerWrapper(this$0, new Object[]{completionHandler}));
            Object queryProductDetailsParams = this$0.getQueryProductDetailsParams(productType, productIds);
            if (queryProductDetailsParams != null) {
                InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                InAppPurchaseUtils.invokeMethod(this$0.billingClientClazz, this$0.queryProductDetailsAsyncMethod, this$0.getBillingClient(), queryProductDetailsParams, newProxyInstance);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: queryPurchaseHistory$lambda-1, reason: not valid java name */
    public static final void m2834queryPurchaseHistory$lambda1(InAppPurchaseBillingClientWrapperV5V7 this$0, InAppPurchaseUtils.IAPProductType productType, Runnable completionHandler) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(productType, "$productType");
            Intrinsics.checkNotNullParameter(completionHandler, "$completionHandler");
            Object newProxyInstance = Proxy.newProxyInstance(this$0.purchaseHistoryResponseListenerClazz.getClassLoader(), new Class[]{this$0.purchaseHistoryResponseListenerClazz}, new ListenerWrapper(this$0, new Object[]{productType, completionHandler}));
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            InAppPurchaseUtils.invokeMethod(this$0.billingClientClazz, this$0.queryPurchaseHistoryAsyncMethod, this$0.getBillingClient(), this$0.getQueryPurchaseHistoryParams(productType), newProxyInstance);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    private final void startConnection(Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Object newProxyInstance = Proxy.newProxyInstance(this.billingClientStateListenerClazz.getClassLoader(), new Class[]{this.billingClientStateListenerClazz}, new ListenerWrapper(this, new Object[]{runnable}));
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.billingClientStartConnectionMethod, getBillingClient(), newProxyInstance);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public Object getBillingClient() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.billingClient;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final String getOriginalJson(String productDetailsString) {
        List<String> groupValues;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(productDetailsString, "productDetailsString");
            MatchResult find$default = Regex.find$default(new Regex("jsonString='(.*?)'"), productDetailsString, 0, 2, null);
            if (find$default != null && (groupValues = find$default.getGroupValues()) != null) {
                return (String) CollectionsKt.getOrNull(groupValues, 1);
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @Override // com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper
    public void queryPurchaseHistory(final InAppPurchaseUtils.IAPProductType productType, final Runnable completionHandler) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(productType, "productType");
            Intrinsics.checkNotNullParameter(completionHandler, "completionHandler");
            executeServiceRequest(new Runnable() { // from class: j0.h
                @Override // java.lang.Runnable
                public final void run() {
                    InAppPurchaseBillingClientWrapperV5V7.m2834queryPurchaseHistory$lambda1(InAppPurchaseBillingClientWrapperV5V7.this, productType, completionHandler);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private InAppPurchaseBillingClientWrapperV5V7(Object obj, Class<?> cls, Class<?> cls2, Class<?> cls3, Class<?> cls4, Class<?> cls5, Class<?> cls6, Class<?> cls7, Class<?> cls8, Class<?> cls9, Class<?> cls10, Class<?> cls11, Class<?> cls12, Class<?> cls13, Class<?> cls14, Class<?> cls15, Class<?> cls16, Class<?> cls17, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, Method method8, Method method9, Method method10, Method method11, Method method12, Method method13, Method method14, Method method15, Method method16, Method method17, Method method18, Method method19, Method method20, Method method21) {
        this.billingClient = obj;
        this.billingClientClazz = cls;
        this.purchaseClazz = cls2;
        this.productDetailsClazz = cls3;
        this.purchaseHistoryRecordClazz = cls4;
        this.queryProductDetailsParamsProductClazz = cls5;
        this.billingResultClazz = cls6;
        this.queryProductDetailsParamsClazz = cls7;
        this.queryPurchaseHistoryParamsClazz = cls8;
        this.queryPurchasesParamsClazz = cls9;
        this.queryProductDetailsParamsBuilderClazz = cls10;
        this.queryPurchaseHistoryParamsBuilderClazz = cls11;
        this.queryPurchasesParamsBuilderClazz = cls12;
        this.queryProductDetailsParamsProductBuilderClazz = cls13;
        this.billingClientStateListenerClazz = cls14;
        this.productDetailsResponseListenerClazz = cls15;
        this.purchasesResponseListenerClazz = cls16;
        this.purchaseHistoryResponseListenerClazz = cls17;
        this.queryPurchasesAsyncMethod = method;
        this.queryPurchasesParamsNewBuilderMethod = method2;
        this.queryPurchasesParamsBuilderBuildMethod = method3;
        this.queryPurchasesParamsBuilderSetProductTypeMethod = method4;
        this.purchaseGetOriginalJsonMethod = method5;
        this.queryPurchaseHistoryAsyncMethod = method6;
        this.queryPurchaseHistoryParamsNewBuilderMethod = method7;
        this.queryPurchaseHistoryParamsBuilderBuildMethod = method8;
        this.queryPurchaseHistoryParamsBuilderSetProductTypeMethod = method9;
        this.purchaseHistoryRecordGetOriginalJsonMethod = method10;
        this.queryProductDetailsAsyncMethod = method11;
        this.queryProductDetailsParamsNewBuilderMethod = method12;
        this.queryProductDetailsParamsBuilderBuildMethod = method13;
        this.queryProductDetailsParamsBuilderSetProductListMethod = method14;
        this.queryProductDetailsParamsProductNewBuilderMethod = method15;
        this.queryProductDetailsParamsProductBuilderBuildMethod = method16;
        this.queryProductDetailsParamsProductBuilderSetProductIdMethod = method17;
        this.queryProductDetailsParamsProductBuilderSetProductTypeMethod = method18;
        this.productDetailsToStringMethod = method19;
        this.billingClientStartConnectionMethod = method20;
        this.billingResultGetResponseCodeMethod = method21;
    }
}
