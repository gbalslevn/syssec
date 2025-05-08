package com.facebook.appevents;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.OperationalData;
import com.facebook.appevents.gps.ara.GpsAraTriggersManager;
import com.facebook.appevents.gps.pa.PACustomAudienceClient;
import com.facebook.appevents.iap.InAppPurchase;
import com.facebook.appevents.iap.InAppPurchaseDedupeConfig;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.integrity.BannedParamManager;
import com.facebook.appevents.integrity.BlocklistEventsManager;
import com.facebook.appevents.integrity.MACARuleMatchingManager;
import com.facebook.appevents.integrity.ProtectedModeManager;
import com.facebook.appevents.integrity.SensitiveParamsManager;
import com.facebook.appevents.integrity.StdParamsEnforcementManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InstallReferrerUtil;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONException;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 22\u00020\u0001:\u00012B%\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB'\b\u0010\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\u000bJ#\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0014J!\u0010\u0016\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001c\u0010\u001dJ7\u0010 \u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J?\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010#\u001a\u00020\"2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001c\u0010$J\r\u0010%\u001a\u00020\u000f¢\u0006\u0004\b%\u0010&J+\u0010'\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b'\u0010(JA\u0010'\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b'\u0010)JI\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010#\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u0010\u0010,R\u0014\u0010-\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/facebook/appevents/AppEventsLoggerImpl;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "activityName", "applicationId", "Lcom/facebook/AccessToken;", "accessToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "eventName", "Landroid/os/Bundle;", "parameters", BuildConfig.FLAVOR, "logEvent", "(Ljava/lang/String;Landroid/os/Bundle;)V", BuildConfig.FLAVOR, "valueToSum", "(Ljava/lang/String;DLandroid/os/Bundle;)V", "buttonText", "logEventFromSE", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/math/BigDecimal;", "purchaseAmount", "Ljava/util/Currency;", "currency", "logPurchase", "(Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;)V", "Lcom/facebook/appevents/OperationalData;", "operationalData", "logPurchaseImplicitly", "(Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;)V", BuildConfig.FLAVOR, "isImplicitlyLogged", "(Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;ZLcom/facebook/appevents/OperationalData;)V", "flush", "()V", "logEventImplicitly", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;)V", "(Ljava/lang/String;Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;)V", "Ljava/util/UUID;", "currentSessionId", "(Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;ZLjava/util/UUID;Lcom/facebook/appevents/OperationalData;)V", "contextName", "Ljava/lang/String;", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "accessTokenAppId", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AppEventsLoggerImpl {
    private static final String ACCOUNT_KIT_EVENT_NAME_PREFIX = "fb_ak";
    private static final String APP_EVENT_NAME_PUSH_OPENED = "fb_mobile_push_opened";
    private static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    private static final String APP_EVENT_PUSH_PARAMETER_ACTION = "fb_push_action";
    private static final String APP_EVENT_PUSH_PARAMETER_CAMPAIGN = "fb_push_campaign";
    private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PUSH_PAYLOAD_CAMPAIGN_KEY = "campaign";
    private static final String PUSH_PAYLOAD_KEY = "fb_push_payload";
    private static final String TAG;
    private static String anonymousAppDeviceGUID;
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    private static AppEventsLogger.FlushBehavior flushBehaviorField;
    private static boolean isActivateAppEventRequested;
    private static String pushNotificationsRegistrationIdField;
    private static final Object staticLock;
    private AccessTokenAppIdPair accessTokenAppId;
    private final String contextName;

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0018\u0010\u0019J3\u0010\u001f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0004\b\u001f\u0010 J!\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0004H\u0007¢\u0006\u0004\b%\u0010\u0003J\u0011\u0010&\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b&\u0010\u0014J\u0019\u0010(\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b(\u0010\u000fJ\r\u0010)\u001a\u00020\u0004¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010+\u001a\u00020*H\u0007¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u00100R\u0014\u00102\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00100R\u0014\u00103\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u00100R\u0014\u00104\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00100R\u0014\u00105\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00100R\u0014\u00107\u001a\u0002068\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u00109\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00100R\u0014\u0010:\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u00100R\u0014\u0010;\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00100R\u0018\u0010<\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00100R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010E\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00100R\u0014\u0010F\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006H"}, d2 = {"Lcom/facebook/appevents/AppEventsLoggerImpl$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "initializeTimersIfNeeded", "Lcom/facebook/appevents/AppEvent;", "event", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "accessTokenAppId", "logEvent", "(Lcom/facebook/appevents/AppEvent;Lcom/facebook/appevents/AccessTokenAppIdPair;)V", BuildConfig.FLAVOR, "message", "notifyDeveloperError", "(Ljava/lang/String;)V", "Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "getFlushBehavior", "()Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "getPushNotificationsRegistrationId", "()Ljava/lang/String;", "Landroid/app/Application;", "application", "applicationId", "activateApp", "(Landroid/app/Application;Ljava/lang/String;)V", "Landroid/os/Bundle;", "params", "Lcom/facebook/appevents/OperationalData;", "operationalData", "Lkotlin/Pair;", "addImplicitPurchaseParameters", "(Landroid/os/Bundle;Lcom/facebook/appevents/OperationalData;)Lkotlin/Pair;", "Landroid/content/Context;", "context", "initializeLib", "(Landroid/content/Context;Ljava/lang/String;)V", "onContextStop", "getInstallReferrer", Constants.REFERRER, "setInstallReferrer", "eagerFlush", "Ljava/util/concurrent/Executor;", "getAnalyticsExecutor", "()Ljava/util/concurrent/Executor;", "getAnonymousAppDeviceGUID", "(Landroid/content/Context;)Ljava/lang/String;", "ACCOUNT_KIT_EVENT_NAME_PREFIX", "Ljava/lang/String;", "APP_EVENTS_KILLSWITCH", "APP_EVENT_NAME_PUSH_OPENED", "APP_EVENT_PREFERENCES", "APP_EVENT_PUSH_PARAMETER_ACTION", "APP_EVENT_PUSH_PARAMETER_CAMPAIGN", BuildConfig.FLAVOR, "APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS", "I", "PUSH_PAYLOAD_CAMPAIGN_KEY", "PUSH_PAYLOAD_KEY", "TAG", "anonymousAppDeviceGUID", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "backgroundExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "flushBehaviorField", "Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", BuildConfig.FLAVOR, "isActivateAppEventRequested", "Z", "pushNotificationsRegistrationIdField", "staticLock", "Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: initializeLib$lambda-4, reason: not valid java name */
        public static final void m2795initializeLib$lambda4(Context context, AppEventsLoggerImpl logger) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(logger, "$logger");
            Bundle bundle = new Bundle();
            String[] strArr = {"com.facebook.core.Core", "com.facebook.login.Login", "com.facebook.share.Share", "com.facebook.places.Places", "com.facebook.messenger.Messenger", "com.facebook.applinks.AppLinks", "com.facebook.marketing.Marketing", "com.facebook.gamingservices.GamingServices", "com.facebook.all.All", "com.android.billingclient.api.BillingClient", "com.android.vending.billing.IInAppBillingService"};
            String[] strArr2 = {"core_lib_included", "login_lib_included", "share_lib_included", "places_lib_included", "messenger_lib_included", "applinks_lib_included", "marketing_lib_included", "gamingservices_lib_included", "all_lib_included", "billing_client_lib_included", "billing_service_lib_included"};
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = i5 + 1;
                String str = strArr[i5];
                String str2 = strArr2[i5];
                try {
                    Class.forName(str);
                    bundle.putInt(str2, 1);
                    i6 |= 1 << i5;
                } catch (ClassNotFoundException unused) {
                }
                if (i7 > 10) {
                    break;
                } else {
                    i5 = i7;
                }
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(AppEventsLoggerImpl.APP_EVENT_PREFERENCES, 0);
            if (sharedPreferences.getInt("kitsBitmask", 0) != i6) {
                sharedPreferences.edit().putInt("kitsBitmask", i6).apply();
                logger.logEventImplicitly("fb_sdk_initialize", null, bundle);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void initializeTimersIfNeeded() {
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                if (AppEventsLoggerImpl.access$getBackgroundExecutor$cp() != null) {
                    return;
                }
                AppEventsLoggerImpl.access$setBackgroundExecutor$cp(new ScheduledThreadPoolExecutor(1));
                Unit unit = Unit.INSTANCE;
                Runnable runnable = new Runnable() { // from class: e0.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppEventsLoggerImpl.Companion.m2796initializeTimersIfNeeded$lambda6();
                    }
                };
                ScheduledThreadPoolExecutor access$getBackgroundExecutor$cp = AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
                if (access$getBackgroundExecutor$cp == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                access$getBackgroundExecutor$cp.scheduleAtFixedRate(runnable, 0L, 86400L, TimeUnit.SECONDS);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: initializeTimersIfNeeded$lambda-6, reason: not valid java name */
        public static final void m2796initializeTimersIfNeeded$lambda6() {
            HashSet hashSet = new HashSet();
            Iterator<AccessTokenAppIdPair> it = AppEventQueue.getKeySet().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().getApplicationId());
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                FetchedAppSettingsManager.queryAppSettings((String) it2.next(), true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void logEvent(AppEvent event, AccessTokenAppIdPair accessTokenAppId) {
            AppEventQueue.add(accessTokenAppId, event);
            FeatureManager featureManager = FeatureManager.INSTANCE;
            if (FeatureManager.isEnabled(FeatureManager.Feature.OnDevicePostInstallEventProcessing) && OnDeviceProcessingManager.isOnDeviceProcessingEnabled()) {
                OnDeviceProcessingManager.sendCustomEventAsync(accessTokenAppId.getApplicationId(), event);
            }
            if (FeatureManager.isEnabled(FeatureManager.Feature.GPSARATriggers)) {
                GpsAraTriggersManager.INSTANCE.registerTriggerAsync(accessTokenAppId.getApplicationId(), event);
            }
            if (FeatureManager.isEnabled(FeatureManager.Feature.GPSPACAProcessing)) {
                PACustomAudienceClient.INSTANCE.joinCustomAudience(accessTokenAppId.getApplicationId(), event);
            }
            if (event.getIsImplicit() || AppEventsLoggerImpl.access$isActivateAppEventRequested$cp()) {
                return;
            }
            if (Intrinsics.areEqual(event.getName(), "fb_mobile_activate_app")) {
                AppEventsLoggerImpl.access$setActivateAppEventRequested$cp(true);
            } else {
                Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void notifyDeveloperError(String message) {
            Logger.INSTANCE.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", message);
        }

        public final void activateApp(Application application, String applicationId) {
            Intrinsics.checkNotNullParameter(application, "application");
            if (!FacebookSdk.isInitialized()) {
                throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
            }
            AnalyticsUserIDStore.initStore();
            UserDataStore.initStore();
            if (applicationId == null) {
                applicationId = FacebookSdk.getApplicationId();
            }
            FacebookSdk.publishInstallAsync(application, applicationId);
            ActivityLifecycleTracker.startTracking(application, applicationId);
        }

        public final Pair<Bundle, OperationalData> addImplicitPurchaseParameters(Bundle params, OperationalData operationalData) {
            String str = AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled() ? "1" : "0";
            OperationalData.Companion companion = OperationalData.INSTANCE;
            OperationalDataEnum operationalDataEnum = OperationalDataEnum.IAPParameters;
            Pair<Bundle, OperationalData> addParameterAndReturn = companion.addParameterAndReturn(operationalDataEnum, "is_implicit_purchase_logging_enabled", str, params, operationalData);
            Pair<Bundle, OperationalData> addParameterAndReturn2 = companion.addParameterAndReturn(operationalDataEnum, "is_autolog_app_events_enabled", UserSettingsManager.getAutoLogAppEventsEnabled() ? "1" : "0", addParameterAndReturn.getFirst(), addParameterAndReturn.getSecond());
            return new Pair<>(addParameterAndReturn2.getFirst(), addParameterAndReturn2.getSecond());
        }

        public final void eagerFlush() {
            if (getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                AppEventQueue appEventQueue = AppEventQueue.INSTANCE;
                AppEventQueue.flush(FlushReason.EAGER_FLUSHING_EVENT);
            }
        }

        public final Executor getAnalyticsExecutor() {
            if (AppEventsLoggerImpl.access$getBackgroundExecutor$cp() == null) {
                initializeTimersIfNeeded();
            }
            ScheduledThreadPoolExecutor access$getBackgroundExecutor$cp = AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
            if (access$getBackgroundExecutor$cp != null) {
                return access$getBackgroundExecutor$cp;
            }
            throw new IllegalStateException("Required value was null.");
        }

        public final String getAnonymousAppDeviceGUID(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp() == null) {
                synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                    try {
                        if (AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp() == null) {
                            AppEventsLoggerImpl.access$setAnonymousAppDeviceGUID$cp(context.getSharedPreferences(AppEventsLoggerImpl.APP_EVENT_PREFERENCES, 0).getString("anonymousAppDeviceGUID", null));
                            if (AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp() == null) {
                                UUID randomUUID = UUID.randomUUID();
                                Intrinsics.checkNotNullExpressionValue(randomUUID, "randomUUID()");
                                AppEventsLoggerImpl.access$setAnonymousAppDeviceGUID$cp(Intrinsics.stringPlus("XZ", randomUUID));
                                context.getSharedPreferences(AppEventsLoggerImpl.APP_EVENT_PREFERENCES, 0).edit().putString("anonymousAppDeviceGUID", AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp()).apply();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            String access$getAnonymousAppDeviceGUID$cp = AppEventsLoggerImpl.access$getAnonymousAppDeviceGUID$cp();
            if (access$getAnonymousAppDeviceGUID$cp != null) {
                return access$getAnonymousAppDeviceGUID$cp;
            }
            throw new IllegalStateException("Required value was null.");
        }

        public final AppEventsLogger.FlushBehavior getFlushBehavior() {
            AppEventsLogger.FlushBehavior access$getFlushBehaviorField$cp;
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                access$getFlushBehaviorField$cp = AppEventsLoggerImpl.access$getFlushBehaviorField$cp();
            }
            return access$getFlushBehaviorField$cp;
        }

        public final String getInstallReferrer() {
            InstallReferrerUtil installReferrerUtil = InstallReferrerUtil.INSTANCE;
            InstallReferrerUtil.tryUpdateReferrerInfo(new InstallReferrerUtil.Callback() { // from class: com.facebook.appevents.AppEventsLoggerImpl$Companion$getInstallReferrer$1
                @Override // com.facebook.internal.InstallReferrerUtil.Callback
                public void onReceiveReferrerUrl(String s5) {
                    AppEventsLoggerImpl.INSTANCE.setInstallReferrer(s5);
                }
            });
            return FacebookSdk.getApplicationContext().getSharedPreferences(AppEventsLoggerImpl.APP_EVENT_PREFERENCES, 0).getString(Constants.INSTALL_REFERRER, null);
        }

        public final String getPushNotificationsRegistrationId() {
            String access$getPushNotificationsRegistrationIdField$cp;
            synchronized (AppEventsLoggerImpl.access$getStaticLock$cp()) {
                access$getPushNotificationsRegistrationIdField$cp = AppEventsLoggerImpl.access$getPushNotificationsRegistrationIdField$cp();
            }
            return access$getPushNotificationsRegistrationIdField$cp;
        }

        public final void initializeLib(final Context context, String applicationId) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                final AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(context, applicationId, (AccessToken) null);
                ScheduledThreadPoolExecutor access$getBackgroundExecutor$cp = AppEventsLoggerImpl.access$getBackgroundExecutor$cp();
                if (access$getBackgroundExecutor$cp == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                access$getBackgroundExecutor$cp.execute(new Runnable() { // from class: e0.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppEventsLoggerImpl.Companion.m2795initializeLib$lambda4(context, appEventsLoggerImpl);
                    }
                });
            }
        }

        public final void onContextStop() {
            AppEventQueue.persistToDisk();
        }

        public final void setInstallReferrer(String referrer) {
            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(AppEventsLoggerImpl.APP_EVENT_PREFERENCES, 0);
            if (referrer != null) {
                sharedPreferences.edit().putString(Constants.INSTALL_REFERRER, referrer).apply();
            }
        }

        private Companion() {
        }
    }

    static {
        String canonicalName = AppEventsLoggerImpl.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "com.facebook.appevents.AppEventsLoggerImpl";
        }
        TAG = canonicalName;
        flushBehaviorField = AppEventsLogger.FlushBehavior.AUTO;
        staticLock = new Object();
    }

    public AppEventsLoggerImpl(String activityName, String str, AccessToken accessToken) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Validate.sdkInitialized();
        this.contextName = activityName;
        accessToken = accessToken == null ? AccessToken.INSTANCE.getCurrentAccessToken() : accessToken;
        if (accessToken == null || accessToken.isExpired() || !(str == null || Intrinsics.areEqual(str, accessToken.getApplicationId()))) {
            if (str == null) {
                Utility utility = Utility.INSTANCE;
                str = Utility.getMetadataApplicationId(FacebookSdk.getApplicationContext());
            }
            if (str != null) {
                this.accessTokenAppId = new AccessTokenAppIdPair(null, str);
            } else {
                throw new IllegalStateException("Required value was null.");
            }
        } else {
            this.accessTokenAppId = new AccessTokenAppIdPair(accessToken);
        }
        INSTANCE.initializeTimersIfNeeded();
    }

    public static final /* synthetic */ String access$getAnonymousAppDeviceGUID$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return anonymousAppDeviceGUID;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    public static final /* synthetic */ ScheduledThreadPoolExecutor access$getBackgroundExecutor$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return backgroundExecutor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    public static final /* synthetic */ AppEventsLogger.FlushBehavior access$getFlushBehaviorField$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return flushBehaviorField;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getPushNotificationsRegistrationIdField$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return pushNotificationsRegistrationIdField;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    public static final /* synthetic */ Object access$getStaticLock$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return null;
        }
        try {
            return staticLock;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return null;
        }
    }

    public static final /* synthetic */ boolean access$isActivateAppEventRequested$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return false;
        }
        try {
            return isActivateAppEventRequested;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
            return false;
        }
    }

    public static final /* synthetic */ void access$setActivateAppEventRequested$cp(boolean z5) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            isActivateAppEventRequested = z5;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    public static final /* synthetic */ void access$setAnonymousAppDeviceGUID$cp(String str) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            anonymousAppDeviceGUID = str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    public static final /* synthetic */ void access$setBackgroundExecutor$cp(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        try {
            backgroundExecutor = scheduledThreadPoolExecutor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    public static /* synthetic */ void logEvent$default(AppEventsLoggerImpl appEventsLoggerImpl, String str, Double d5, Bundle bundle, boolean z5, UUID uuid, OperationalData operationalData, int i5, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        if ((i5 & 32) != 0) {
            operationalData = null;
        }
        try {
            appEventsLoggerImpl.logEvent(str, d5, bundle, z5, uuid, operationalData);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    public static /* synthetic */ void logPurchase$default(AppEventsLoggerImpl appEventsLoggerImpl, BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z5, OperationalData operationalData, int i5, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(AppEventsLoggerImpl.class)) {
            return;
        }
        if ((i5 & 16) != 0) {
            operationalData = null;
        }
        try {
            appEventsLoggerImpl.logPurchase(bigDecimal, currency, bundle, z5, operationalData);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsLoggerImpl.class);
        }
    }

    public final void flush() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            AppEventQueue appEventQueue = AppEventQueue.INSTANCE;
            AppEventQueue.flush(FlushReason.EXPLICIT);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logEvent(String eventName, Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logEvent$default(this, eventName, null, parameters, false, ActivityLifecycleTracker.getCurrentSessionGuid(), null, 32, null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logEventFromSE(String eventName, String buttonText) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("_is_suggested_event", "1");
            bundle.putString("_button_text", buttonText);
            logEvent(eventName, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logEventImplicitly(String eventName, Double valueToSum, Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logEvent$default(this, eventName, valueToSum, parameters, true, ActivityLifecycleTracker.getCurrentSessionGuid(), null, 32, null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logPurchase(BigDecimal purchaseAmount, Currency currency, Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logPurchase$default(this, purchaseAmount, currency, parameters, false, null, 16, null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logPurchaseImplicitly(BigDecimal purchaseAmount, Currency currency, Bundle parameters, OperationalData operationalData) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logPurchase(purchaseAmount, currency, parameters, true, operationalData);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logEvent(String eventName, double valueToSum, Bundle parameters) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logEvent$default(this, eventName, Double.valueOf(valueToSum), parameters, false, ActivityLifecycleTracker.getCurrentSessionGuid(), null, 32, null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logEventImplicitly(String eventName, BigDecimal purchaseAmount, Currency currency, Bundle parameters, OperationalData operationalData) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (purchaseAmount != null && currency != null) {
                if (parameters == null) {
                    parameters = new Bundle();
                }
                Bundle bundle = parameters;
                bundle.putString("fb_currency", currency.getCurrencyCode());
                logEvent(eventName, Double.valueOf(purchaseAmount.doubleValue()), bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid(), operationalData);
                return;
            }
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, "purchaseAmount and currency cannot be null");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logPurchase(BigDecimal purchaseAmount, Currency currency, Bundle parameters, boolean isImplicitlyLogged, OperationalData operationalData) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (purchaseAmount == null) {
                INSTANCE.notifyDeveloperError("purchaseAmount cannot be null");
                return;
            }
            if (currency == null) {
                INSTANCE.notifyDeveloperError("currency cannot be null");
                return;
            }
            if (parameters == null) {
                parameters = new Bundle();
            }
            Bundle bundle = parameters;
            bundle.putString("fb_currency", currency.getCurrencyCode());
            logEvent("fb_mobile_purchase", Double.valueOf(purchaseAmount.doubleValue()), bundle, isImplicitlyLogged, ActivityLifecycleTracker.getCurrentSessionGuid(), operationalData);
            INSTANCE.eagerFlush();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf A[Catch: all -> 0x003e, TRY_ENTER, TryCatch #2 {all -> 0x003e, blocks: (B:7:0x0012, B:13:0x001d, B:15:0x0023, B:18:0x002d, B:20:0x0033, B:23:0x0041, B:25:0x0052, B:27:0x006c, B:30:0x007c, B:31:0x00af, B:34:0x00bf, B:36:0x00cd, B:39:0x00d4, B:41:0x00e8, B:43:0x00f0, B:44:0x00f8, B:49:0x011f, B:53:0x0131, B:55:0x0058, B:57:0x0060, B:59:0x0066), top: B:6:0x0012, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cd A[Catch: all -> 0x003e, TryCatch #2 {all -> 0x003e, blocks: (B:7:0x0012, B:13:0x001d, B:15:0x0023, B:18:0x002d, B:20:0x0033, B:23:0x0041, B:25:0x0052, B:27:0x006c, B:30:0x007c, B:31:0x00af, B:34:0x00bf, B:36:0x00cd, B:39:0x00d4, B:41:0x00e8, B:43:0x00f0, B:44:0x00f8, B:49:0x011f, B:53:0x0131, B:55:0x0058, B:57:0x0060, B:59:0x0066), top: B:6:0x0012, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void logEvent(String eventName, Double valueToSum, Bundle parameters, boolean isImplicitlyLogged, UUID currentSessionId, OperationalData operationalData) {
        Bundle bundle = parameters;
        OperationalData operationalData2 = operationalData;
        if (CrashShieldHandler.isObjectCrashing(this) || eventName == null) {
            return;
        }
        try {
            if (eventName.length() == 0) {
                return;
            }
            if (!isImplicitlyLogged) {
                if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
                    if (!Intrinsics.areEqual(eventName, "fb_mobile_purchase")) {
                        if (!Intrinsics.areEqual(eventName, "Subscribe")) {
                            if (Intrinsics.areEqual(eventName, "StartTrial")) {
                            }
                        }
                    }
                    Log.w(TAG, "You are logging purchase events while auto-logging of in-app purchase is enabled in the SDK. Make sure you don't log duplicate events");
                    FeatureManager featureManager = FeatureManager.INSTANCE;
                    if ((FeatureManager.isEnabled(FeatureManager.Feature.AndroidManualImplicitPurchaseDedupe) && Intrinsics.areEqual(eventName, "fb_mobile_purchase")) || (FeatureManager.isEnabled(FeatureManager.Feature.AndroidManualImplicitSubsDedupe) && (Intrinsics.areEqual(eventName, "Subscribe") || Intrinsics.areEqual(eventName, "StartTrial")))) {
                        InAppPurchaseDedupeConfig inAppPurchaseDedupeConfig = InAppPurchaseDedupeConfig.INSTANCE;
                        Double valueOfManualEvent = inAppPurchaseDedupeConfig.getValueOfManualEvent(valueToSum, bundle);
                        Currency currencyOfManualEvent = inAppPurchaseDedupeConfig.getCurrencyOfManualEvent(bundle);
                        if (valueOfManualEvent != null && currencyOfManualEvent != null) {
                            InAppPurchase inAppPurchase = new InAppPurchase(eventName, valueOfManualEvent.doubleValue(), currencyOfManualEvent);
                            InAppPurchaseManager inAppPurchaseManager = InAppPurchaseManager.INSTANCE;
                            Pair<Bundle, OperationalData> addDedupeParameters = inAppPurchaseDedupeConfig.addDedupeParameters(InAppPurchaseManager.performDedupe(CollectionsKt.listOf(inAppPurchase), System.currentTimeMillis(), false, CollectionsKt.listOf(new Pair(bundle, operationalData2))), bundle, operationalData2);
                            Bundle component1 = addDedupeParameters.component1();
                            operationalData2 = addDedupeParameters.component2();
                            bundle = component1;
                        }
                        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
                        if (!FetchedAppGateKeepersManager.getGateKeeperForKey("app_events_killswitch", FacebookSdk.getApplicationId(), false)) {
                            Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, "AppEvents", "KillSwitch is enabled and fail to log app event: %s", eventName);
                            return;
                        }
                        if (BlocklistEventsManager.isInBlocklist(eventName)) {
                            return;
                        }
                        Companion companion = INSTANCE;
                        Pair<Bundle, OperationalData> addImplicitPurchaseParameters = companion.addImplicitPurchaseParameters(bundle, operationalData2);
                        Bundle component12 = addImplicitPurchaseParameters.component1();
                        OperationalData component2 = addImplicitPurchaseParameters.component2();
                        try {
                            if (!ProtectedModeManager.INSTANCE.protectedModeIsApplied(component12)) {
                                SensitiveParamsManager.processFilterSensitiveParams(component12, eventName);
                            }
                            BannedParamManager.processFilterBannedParams(component12);
                            MACARuleMatchingManager.processParameters(component12, eventName);
                            StdParamsEnforcementManager.processFilterParamSchemaBlocking(component12);
                            ProtectedModeManager.processParametersForProtectedMode(component12);
                            companion.logEvent(new AppEvent(this.contextName, eventName, valueToSum, component12, isImplicitlyLogged, ActivityLifecycleTracker.isInBackground(), currentSessionId, component2), this.accessTokenAppId);
                            return;
                        } catch (FacebookException e5) {
                            Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event: %s", e5.toString());
                            return;
                        } catch (JSONException e6) {
                            Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e6.toString());
                            return;
                        }
                    }
                }
            }
            FetchedAppGateKeepersManager fetchedAppGateKeepersManager2 = FetchedAppGateKeepersManager.INSTANCE;
            if (!FetchedAppGateKeepersManager.getGateKeeperForKey("app_events_killswitch", FacebookSdk.getApplicationId(), false)) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public AppEventsLoggerImpl(Context context, String str, AccessToken accessToken) {
        this(Utility.getActivityName(context), str, accessToken);
    }
}
