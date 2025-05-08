package com.facebook.appevents.iap;

import android.content.Context;
import com.facebook.appevents.iap.InAppPurchaseAutoLogger;
import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapperV2V4;
import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapperV5V7;
import com.facebook.appevents.iap.InAppPurchaseUtils;
import com.facebook.appevents.integrity.ProtectedModeManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseAutoLogger;", BuildConfig.FLAVOR, "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;", "billingClientVersion", BuildConfig.FLAVOR, "startIapLogging", "(Landroid/content/Context;Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;)V", BuildConfig.FLAVOR, "packageName", "logPurchase", "(Lcom/facebook/appevents/iap/InAppPurchaseUtils$BillingClientVersion;Ljava/lang/String;)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "failedToCreateWrapper", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getFailedToCreateWrapper", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class InAppPurchaseAutoLogger {
    public static final InAppPurchaseAutoLogger INSTANCE = new InAppPurchaseAutoLogger();
    private static final AtomicBoolean failedToCreateWrapper = new AtomicBoolean(false);

    private InAppPurchaseAutoLogger() {
    }

    private final void logPurchase(InAppPurchaseUtils.BillingClientVersion billingClientVersion, String packageName) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            boolean isFirstAppLaunchWithNewIAP = InAppPurchaseLoggerManager.getIsFirstAppLaunchWithNewIAP();
            if (isFirstAppLaunchWithNewIAP) {
                InAppPurchaseLoggerManager.migrateOldCacheHistory();
            }
            if (billingClientVersion == InAppPurchaseUtils.BillingClientVersion.V2_V4) {
                InAppPurchaseBillingClientWrapperV2V4.Companion companion = InAppPurchaseBillingClientWrapperV2V4.INSTANCE;
                InAppPurchaseLoggerManager.filterPurchaseLogging(companion.getIapPurchaseDetailsMap(), companion.getSkuDetailsMap(), false, packageName, billingClientVersion, isFirstAppLaunchWithNewIAP);
                InAppPurchaseLoggerManager.filterPurchaseLogging(companion.getSubsPurchaseDetailsMap(), companion.getSkuDetailsMap(), true, packageName, billingClientVersion, isFirstAppLaunchWithNewIAP);
                companion.getIapPurchaseDetailsMap().clear();
                companion.getSubsPurchaseDetailsMap().clear();
            } else {
                InAppPurchaseBillingClientWrapperV5V7.Companion companion2 = InAppPurchaseBillingClientWrapperV5V7.INSTANCE;
                InAppPurchaseLoggerManager.filterPurchaseLogging(companion2.getIapPurchaseDetailsMap(), companion2.getProductDetailsMap(), false, packageName, billingClientVersion, isFirstAppLaunchWithNewIAP);
                InAppPurchaseLoggerManager.filterPurchaseLogging(companion2.getSubsPurchaseDetailsMap(), companion2.getProductDetailsMap(), true, packageName, billingClientVersion, isFirstAppLaunchWithNewIAP);
                companion2.getIapPurchaseDetailsMap().clear();
                companion2.getSubsPurchaseDetailsMap().clear();
            }
            if (isFirstAppLaunchWithNewIAP) {
                InAppPurchaseLoggerManager.setAppHasBeenLaunchedWithNewIAP();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [T, com.facebook.appevents.iap.InAppPurchaseBillingClientWrapperV5V7] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.facebook.appevents.iap.InAppPurchaseBillingClientWrapperV2V4, T] */
    public static final synchronized void startIapLogging(final Context context, final InAppPurchaseUtils.BillingClientVersion billingClientVersion) {
        synchronized (InAppPurchaseAutoLogger.class) {
            if (CrashShieldHandler.isObjectCrashing(InAppPurchaseAutoLogger.class)) {
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(billingClientVersion, "billingClientVersion");
                AtomicBoolean atomicBoolean = failedToCreateWrapper;
                if (atomicBoolean.get()) {
                    return;
                }
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                InAppPurchaseUtils.BillingClientVersion billingClientVersion2 = InAppPurchaseUtils.BillingClientVersion.V2_V4;
                if (billingClientVersion == billingClientVersion2) {
                    ref$ObjectRef.element = InAppPurchaseBillingClientWrapperV2V4.INSTANCE.getOrCreateInstance(context);
                } else if (billingClientVersion == InAppPurchaseUtils.BillingClientVersion.V5_V7) {
                    ref$ObjectRef.element = InAppPurchaseBillingClientWrapperV5V7.INSTANCE.getOrCreateInstance(context);
                }
                if (ref$ObjectRef.element == 0) {
                    atomicBoolean.set(true);
                    return;
                }
                FeatureManager featureManager = FeatureManager.INSTANCE;
                if (!FeatureManager.isEnabled(FeatureManager.Feature.AndroidIAPSubscriptionAutoLogging) || (ProtectedModeManager.isEnabled() && billingClientVersion != billingClientVersion2)) {
                    ((InAppPurchaseBillingClientWrapper) ref$ObjectRef.element).queryPurchaseHistory(InAppPurchaseUtils.IAPProductType.INAPP, new Runnable() { // from class: j0.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            InAppPurchaseAutoLogger.m2830startIapLogging$lambda2(InAppPurchaseUtils.BillingClientVersion.this, context);
                        }
                    });
                } else {
                    ((InAppPurchaseBillingClientWrapper) ref$ObjectRef.element).queryPurchaseHistory(InAppPurchaseUtils.IAPProductType.INAPP, new Runnable() { // from class: j0.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            InAppPurchaseAutoLogger.m2828startIapLogging$lambda1(Ref$ObjectRef.this, billingClientVersion, context);
                        }
                    });
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, InAppPurchaseAutoLogger.class);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startIapLogging$lambda-1, reason: not valid java name */
    public static final void m2828startIapLogging$lambda1(Ref$ObjectRef billingClientWrapper, final InAppPurchaseUtils.BillingClientVersion billingClientVersion, final Context context) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseAutoLogger.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(billingClientWrapper, "$billingClientWrapper");
            Intrinsics.checkNotNullParameter(billingClientVersion, "$billingClientVersion");
            Intrinsics.checkNotNullParameter(context, "$context");
            ((InAppPurchaseBillingClientWrapper) billingClientWrapper.element).queryPurchaseHistory(InAppPurchaseUtils.IAPProductType.SUBS, new Runnable() { // from class: j0.e
                @Override // java.lang.Runnable
                public final void run() {
                    InAppPurchaseAutoLogger.m2829startIapLogging$lambda1$lambda0(InAppPurchaseUtils.BillingClientVersion.this, context);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseAutoLogger.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startIapLogging$lambda-1$lambda-0, reason: not valid java name */
    public static final void m2829startIapLogging$lambda1$lambda0(InAppPurchaseUtils.BillingClientVersion billingClientVersion, Context context) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseAutoLogger.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(billingClientVersion, "$billingClientVersion");
            Intrinsics.checkNotNullParameter(context, "$context");
            InAppPurchaseAutoLogger inAppPurchaseAutoLogger = INSTANCE;
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
            inAppPurchaseAutoLogger.logPurchase(billingClientVersion, packageName);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseAutoLogger.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startIapLogging$lambda-2, reason: not valid java name */
    public static final void m2830startIapLogging$lambda2(InAppPurchaseUtils.BillingClientVersion billingClientVersion, Context context) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseAutoLogger.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(billingClientVersion, "$billingClientVersion");
            Intrinsics.checkNotNullParameter(context, "$context");
            InAppPurchaseAutoLogger inAppPurchaseAutoLogger = INSTANCE;
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
            inAppPurchaseAutoLogger.logPurchase(billingClientVersion, packageName);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseAutoLogger.class);
        }
    }
}
