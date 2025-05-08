package com.adjust.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Process;
import com.adjust.sdk.network.ActivityPackageSender;
import com.adjust.sdk.network.UtilNetworking;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import com.adjust.sdk.scheduler.TimerCycle;
import com.adjust.sdk.scheduler.TimerOnce;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ActivityHandler implements IActivityHandler {
    private static final String ACTIVITY_STATE_NAME = "Activity state";
    private static final String ATTRIBUTION_NAME = "Attribution";
    private static long BACKGROUND_TIMER_INTERVAL = 0;
    private static final String BACKGROUND_TIMER_NAME = "Background timer";
    private static final String DELAY_START_TIMER_NAME = "Delay Start timer";
    private static long FOREGROUND_TIMER_INTERVAL = 0;
    private static final String FOREGROUND_TIMER_NAME = "Foreground timer";
    private static long FOREGROUND_TIMER_START = 0;
    private static final String SESSION_CALLBACK_PARAMETERS_NAME = "Session Callback parameters";
    private static long SESSION_INTERVAL = 0;
    private static final String SESSION_PARAMETERS_NAME = "Session parameters";
    private static final String SESSION_PARTNER_PARAMETERS_NAME = "Session Partner parameters";
    private static long SUBSESSION_INTERVAL = 0;
    private static final String TIME_TRAVEL = "Time travel!";
    private ActivityState activityState;
    private AdjustConfig adjustConfig;
    private AdjustAttribution attribution;
    private IAttributionHandler attributionHandler;
    private TimerOnce backgroundTimer;
    private String basePath;
    private TimerOnce delayStartTimer;
    private com.adjust.sdk.a deviceInfo;
    private ThreadExecutor executor;
    private TimerCycle foregroundTimer;
    private String gdprPath;
    private InstallReferrer installReferrer;
    private InstallReferrerHuawei installReferrerHuawei;
    private InternalState internalState;
    private ILogger logger;
    private IPackageHandler packageHandler;
    private ISdkClickHandler sdkClickHandler;
    private SessionParameters sessionParameters;
    private String subscriptionPath;

    /* loaded from: classes.dex */
    public class InternalState {
        public boolean background;
        public boolean delayStart;
        public boolean enabled;
        public boolean firstLaunch;
        public boolean firstSdkStart;
        public boolean offline;
        public boolean preinstallHasBeenRead;
        public boolean sessionResponseProcessed;
        public boolean updatePackages;

        public InternalState() {
        }

        public boolean hasFirstSdkStartNotOcurred() {
            return !this.firstSdkStart;
        }

        public boolean hasFirstSdkStartOcurred() {
            return this.firstSdkStart;
        }

        public boolean hasPreinstallBeenRead() {
            return this.preinstallHasBeenRead;
        }

        public boolean hasSessionResponseNotBeenProcessed() {
            return !this.sessionResponseProcessed;
        }

        public boolean isDisabled() {
            return !this.enabled;
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public boolean isFirstLaunch() {
            return this.firstLaunch;
        }

        public boolean isInBackground() {
            return this.background;
        }

        public boolean isInDelayedStart() {
            return this.delayStart;
        }

        public boolean isInForeground() {
            return !this.background;
        }

        public boolean isNotFirstLaunch() {
            return !this.firstLaunch;
        }

        public boolean isNotInDelayedStart() {
            return !this.delayStart;
        }

        public boolean isOffline() {
            return this.offline;
        }

        public boolean isOnline() {
            return !this.offline;
        }

        public boolean itHasToUpdatePackages() {
            return this.updatePackages;
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.sendPreinstallReferrerI();
        }
    }

    /* loaded from: classes.dex */
    public class a0 implements IRunActivityHandler {
        public a0() {
        }

        @Override // com.adjust.sdk.IRunActivityHandler
        public final void run(ActivityHandler activityHandler) {
            activityHandler.setEnabledI(ActivityHandler.this.adjustConfig.startEnabled.booleanValue());
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReferrerDetails f4039a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4040b;

        public b(ReferrerDetails referrerDetails, String str) {
            this.f4039a = referrerDetails;
            this.f4040b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.sendInstallReferrerI(this.f4039a, this.f4040b);
        }
    }

    /* loaded from: classes.dex */
    public class b0 implements Runnable {
        public b0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.foregroundTimerFired();
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventResponseData f4043a;

        public c(EventResponseData eventResponseData) {
            this.f4043a = eventResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.launchEventResponseTasksI(this.f4043a);
        }
    }

    /* loaded from: classes.dex */
    public class c0 implements Runnable {
        public c0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.backgroundTimerFired();
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SdkClickResponseData f4046a;

        public d(SdkClickResponseData sdkClickResponseData) {
            this.f4046a = sdkClickResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.launchSdkClickResponseTasksI(this.f4046a);
        }
    }

    /* loaded from: classes.dex */
    public class d0 implements Runnable {
        public d0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.sendFirstPackages();
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SessionResponseData f4049a;

        public e(SessionResponseData sessionResponseData) {
            this.f4049a = sessionResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.launchSessionResponseTasksI(this.f4049a);
        }
    }

    /* loaded from: classes.dex */
    public class e0 implements InstallReferrerReadListener {
        public e0() {
        }

        @Override // com.adjust.sdk.InstallReferrerReadListener
        public final void onInstallReferrerRead(ReferrerDetails referrerDetails, String str) {
            ActivityHandler.this.sendInstallReferrer(referrerDetails, str);
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttributionResponseData f4052a;

        public f(AttributionResponseData attributionResponseData) {
            this.f4052a = attributionResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.launchAttributionResponseTasksI(this.f4052a);
        }
    }

    /* loaded from: classes.dex */
    public class f0 implements InstallReferrerReadListener {
        public f0() {
        }

        @Override // com.adjust.sdk.InstallReferrerReadListener
        public final void onInstallReferrerRead(ReferrerDetails referrerDetails, String str) {
            ActivityHandler.this.sendInstallReferrer(referrerDetails, str);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.sendFirstPackagesI();
        }
    }

    /* loaded from: classes.dex */
    public class g0 implements Runnable {
        public g0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.stopForegroundTimerI();
            ActivityHandler.this.startBackgroundTimerI();
            ActivityHandler.this.logger.verbose("Subsession end", new Object[0]);
            ActivityHandler.this.endI();
        }
    }

    /* loaded from: classes.dex */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4057a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4058b;

        public h(String str, String str2) {
            this.f4057a = str;
            this.f4058b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.addSessionCallbackParameterI(this.f4057a, this.f4058b);
        }
    }

    /* loaded from: classes.dex */
    public class h0 implements Runnable {
        public h0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReferrerDetails samsungReferrer = Reflection.getSamsungReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.logger);
            if (samsungReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(samsungReferrer, Constants.REFERRER_API_SAMSUNG);
            }
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4061a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4062b;

        public i(String str, String str2) {
            this.f4061a = str;
            this.f4062b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.addSessionPartnerParameterI(this.f4061a, this.f4062b);
        }
    }

    /* loaded from: classes.dex */
    public class i0 implements Runnable {
        public i0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReferrerDetails xiaomiReferrer = Reflection.getXiaomiReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.logger);
            if (xiaomiReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(xiaomiReferrer, Constants.REFERRER_API_XIAOMI);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4065a;

        public j(String str) {
            this.f4065a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.removeSessionCallbackParameterI(this.f4065a);
        }
    }

    /* loaded from: classes.dex */
    public class j0 implements Runnable {
        public j0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReferrerDetails vivoReferrer = Reflection.getVivoReferrer(ActivityHandler.this.getContext(), ActivityHandler.this.logger);
            if (vivoReferrer != null) {
                ActivityHandler.this.sendInstallReferrer(vivoReferrer, Constants.REFERRER_API_VIVO);
            }
        }
    }

    /* loaded from: classes.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.initI();
        }
    }

    /* loaded from: classes.dex */
    public class k0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventResponseData f4069a;

        public k0(EventResponseData eventResponseData) {
            this.f4069a = eventResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ActivityHandler.this.adjustConfig == null || ActivityHandler.this.adjustConfig.onEventTrackingSucceededListener == null) {
                return;
            }
            ActivityHandler.this.adjustConfig.onEventTrackingSucceededListener.onFinishedEventTrackingSucceeded(this.f4069a.getSuccessResponseData());
        }
    }

    /* loaded from: classes.dex */
    public class l implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4071a;

        public l(String str) {
            this.f4071a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.removeSessionPartnerParameterI(this.f4071a);
        }
    }

    /* loaded from: classes.dex */
    public class l0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventResponseData f4073a;

        public l0(EventResponseData eventResponseData) {
            this.f4073a = eventResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ActivityHandler.this.adjustConfig == null || ActivityHandler.this.adjustConfig.onEventTrackingFailedListener == null) {
                return;
            }
            ActivityHandler.this.adjustConfig.onEventTrackingFailedListener.onFinishedEventTrackingFailed(this.f4073a.getFailureResponseData());
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.resetSessionCallbackParametersI();
        }
    }

    /* loaded from: classes.dex */
    public class m0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SessionResponseData f4076a;

        public m0(SessionResponseData sessionResponseData) {
            this.f4076a = sessionResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ActivityHandler.this.adjustConfig == null || ActivityHandler.this.adjustConfig.onSessionTrackingSucceededListener == null) {
                return;
            }
            ActivityHandler.this.adjustConfig.onSessionTrackingSucceededListener.onFinishedSessionTrackingSucceeded(this.f4076a.getSuccessResponseData());
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.resetSessionPartnerParametersI();
        }
    }

    /* loaded from: classes.dex */
    public class n0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SessionResponseData f4079a;

        public n0(SessionResponseData sessionResponseData) {
            this.f4079a = sessionResponseData;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ActivityHandler.this.adjustConfig == null || ActivityHandler.this.adjustConfig.onSessionTrackingFailedListener == null) {
                return;
            }
            ActivityHandler.this.adjustConfig.onSessionTrackingFailedListener.onFinishedSessionTrackingFailed(this.f4079a.getFailureResponseData());
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f4081a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4082b;

        public o(boolean z5, String str) {
            this.f4081a = z5;
            this.f4082b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!this.f4081a) {
                SharedPreferencesManager.getDefaultInstance(ActivityHandler.this.getContext()).savePushToken(this.f4082b);
            }
            if (ActivityHandler.this.internalState.hasFirstSdkStartNotOcurred()) {
                return;
            }
            ActivityHandler.this.setPushTokenI(this.f4082b);
        }
    }

    /* loaded from: classes.dex */
    public class o0 implements Runnable {
        public o0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ActivityHandler.this.adjustConfig == null || ActivityHandler.this.adjustConfig.onAttributionChangedListener == null) {
                return;
            }
            ActivityHandler.this.adjustConfig.onAttributionChangedListener.onAttributionChanged(ActivityHandler.this.attribution);
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.gdprForgetMeI();
        }
    }

    /* loaded from: classes.dex */
    public class p0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f4086a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent f4087b;

        public p0(Uri uri, Intent intent) {
            this.f4086a = uri;
            this.f4087b = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ActivityHandler.this.adjustConfig == null) {
                return;
            }
            if (ActivityHandler.this.adjustConfig.onDeeplinkResponseListener != null ? ActivityHandler.this.adjustConfig.onDeeplinkResponseListener.launchReceivedDeeplink(this.f4086a) : true) {
                ActivityHandler.this.launchDeeplinkMain(this.f4087b, this.f4086a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class q implements Runnable {
        public q() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.disableThirdPartySharingI();
        }
    }

    /* loaded from: classes.dex */
    public class q0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustEvent f4090a;

        public q0(AdjustEvent adjustEvent) {
            this.f4090a = adjustEvent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ActivityHandler.this.internalState.hasFirstSdkStartNotOcurred()) {
                ActivityHandler.this.logger.warn("Event tracked before first activity resumed.\nIf it was triggered in the Application class, it might timestamp or even send an install long before the user opens the app.\nPlease check https://github.com/adjust/android_sdk#can-i-trigger-an-event-at-application-launch for more information.", new Object[0]);
                ActivityHandler.this.startI();
            }
            ActivityHandler.this.trackEventI(this.f4090a);
        }
    }

    /* loaded from: classes.dex */
    public class r implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustThirdPartySharing f4092a;

        public r(AdjustThirdPartySharing adjustThirdPartySharing) {
            this.f4092a = adjustThirdPartySharing;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.trackThirdPartySharingI(this.f4092a);
        }
    }

    /* loaded from: classes.dex */
    public class r0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f4094a;

        public r0(boolean z5) {
            this.f4094a = z5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.setEnabledI(this.f4094a);
        }
    }

    /* loaded from: classes.dex */
    public class s implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f4096a;

        public s(boolean z5) {
            this.f4096a = z5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.trackMeasurementConsentI(this.f4096a);
        }
    }

    /* loaded from: classes.dex */
    public class s0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f4098a;

        public s0(boolean z5) {
            this.f4098a = z5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.setOfflineModeI(this.f4098a);
        }
    }

    /* loaded from: classes.dex */
    public class t implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4100a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f4101b;

        public t(String str, JSONObject jSONObject) {
            this.f4100a = str;
            this.f4101b = jSONObject;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.trackAdRevenueI(this.f4100a, this.f4101b);
        }
    }

    /* loaded from: classes.dex */
    public class t0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f4103a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f4104b;

        public t0(Uri uri, long j5) {
            this.f4103a = uri;
            this.f4104b = j5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.readOpenUrlI(this.f4103a, this.f4104b);
        }
    }

    /* loaded from: classes.dex */
    public class u implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustAdRevenue f4106a;

        public u(AdjustAdRevenue adjustAdRevenue) {
            this.f4106a = adjustAdRevenue;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.trackAdRevenueI(this.f4106a);
        }
    }

    /* loaded from: classes.dex */
    public class u0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f4108a;

        public u0(boolean z5) {
            this.f4108a = z5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.setAskingAttributionI(this.f4108a);
        }
    }

    /* loaded from: classes.dex */
    public class v implements Runnable {
        public v() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.delayStartI();
            ActivityHandler.this.stopBackgroundTimerI();
            ActivityHandler.this.startForegroundTimerI();
            ActivityHandler.this.logger.verbose("Subsession start", new Object[0]);
            ActivityHandler.this.startI();
        }
    }

    /* loaded from: classes.dex */
    public class v0 implements Runnable {
        public v0() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.sendReftagReferrerI();
        }
    }

    /* loaded from: classes.dex */
    public class w implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdjustPlayStoreSubscription f4112a;

        public w(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
            this.f4112a = adjustPlayStoreSubscription;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.trackSubscriptionI(this.f4112a);
        }
    }

    /* loaded from: classes.dex */
    public class x implements Runnable {
        public x() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.gotOptOutResponseI();
        }
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.foregroundTimerFiredI();
        }
    }

    /* loaded from: classes.dex */
    public class z implements Runnable {
        public z() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ActivityHandler.this.backgroundTimerFiredI();
        }
    }

    private ActivityHandler(AdjustConfig adjustConfig) {
        init(adjustConfig);
        ILogger logger = AdjustFactory.getLogger();
        this.logger = logger;
        logger.lockLogLevel();
        this.executor = new SingleThreadCachedScheduler("ActivityHandler");
        InternalState internalState = new InternalState();
        this.internalState = internalState;
        Boolean bool = adjustConfig.startEnabled;
        internalState.enabled = bool != null ? bool.booleanValue() : true;
        InternalState internalState2 = this.internalState;
        internalState2.offline = adjustConfig.startOffline;
        internalState2.background = true;
        internalState2.delayStart = false;
        internalState2.updatePackages = false;
        internalState2.sessionResponseProcessed = false;
        internalState2.firstSdkStart = false;
        internalState2.preinstallHasBeenRead = false;
        this.executor.submit(new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void backgroundTimerFiredI() {
        if (toSendI()) {
            this.packageHandler.sendFirstPackage();
        }
    }

    private boolean checkActivityStateI(ActivityState activityState) {
        if (!this.internalState.hasFirstSdkStartNotOcurred()) {
            return true;
        }
        this.logger.error("Sdk did not yet start", new Object[0]);
        return false;
    }

    private boolean checkAdjustAdRevenue(AdjustAdRevenue adjustAdRevenue) {
        if (adjustAdRevenue == null) {
            this.logger.error("Ad revenue object missing", new Object[0]);
            return false;
        }
        if (adjustAdRevenue.isValid()) {
            return true;
        }
        this.logger.error("Ad revenue object not initialized correctly", new Object[0]);
        return false;
    }

    private void checkAfterNewStartI() {
        checkAfterNewStartI(SharedPreferencesManager.getDefaultInstance(getContext()));
    }

    private void checkAttributionStateI() {
        if (checkActivityStateI(this.activityState)) {
            if (this.internalState.isFirstLaunch() && this.internalState.hasSessionResponseNotBeenProcessed()) {
                return;
            }
            if (this.attribution == null || this.activityState.askingAttribution) {
                this.attributionHandler.getAttribution();
            }
        }
    }

    private boolean checkEventI(AdjustEvent adjustEvent) {
        if (adjustEvent == null) {
            this.logger.error("Event missing", new Object[0]);
            return false;
        }
        if (adjustEvent.isValid()) {
            return true;
        }
        this.logger.error("Event not initialized correctly", new Object[0]);
        return false;
    }

    private void checkForInstallReferrerInfo(SdkClickResponseData sdkClickResponseData) {
        if (sdkClickResponseData.isInstallReferrer) {
            String str = sdkClickResponseData.referrerApi;
            if (str == null || !str.equalsIgnoreCase(Constants.REFERRER_API_HUAWEI_ADS)) {
                String str2 = sdkClickResponseData.referrerApi;
                if (str2 == null || !str2.equalsIgnoreCase(Constants.REFERRER_API_HUAWEI_APP_GALLERY)) {
                    String str3 = sdkClickResponseData.referrerApi;
                    if (str3 == null || !str3.equalsIgnoreCase(Constants.REFERRER_API_SAMSUNG)) {
                        String str4 = sdkClickResponseData.referrerApi;
                        if (str4 == null || !str4.equalsIgnoreCase(Constants.REFERRER_API_XIAOMI)) {
                            String str5 = sdkClickResponseData.referrerApi;
                            if (str5 == null || !str5.equalsIgnoreCase(Constants.REFERRER_API_VIVO)) {
                                ActivityState activityState = this.activityState;
                                activityState.clickTime = sdkClickResponseData.clickTime;
                                activityState.installBegin = sdkClickResponseData.installBegin;
                                activityState.installReferrer = sdkClickResponseData.installReferrer;
                                activityState.clickTimeServer = sdkClickResponseData.clickTimeServer;
                                activityState.installBeginServer = sdkClickResponseData.installBeginServer;
                                activityState.installVersion = sdkClickResponseData.installVersion;
                                activityState.googlePlayInstant = sdkClickResponseData.googlePlayInstant;
                            } else {
                                ActivityState activityState2 = this.activityState;
                                activityState2.clickTimeVivo = sdkClickResponseData.clickTime;
                                activityState2.installBeginVivo = sdkClickResponseData.installBegin;
                                activityState2.installReferrerVivo = sdkClickResponseData.installReferrer;
                                activityState2.installVersionVivo = sdkClickResponseData.installVersion;
                            }
                        } else {
                            ActivityState activityState3 = this.activityState;
                            activityState3.clickTimeXiaomi = sdkClickResponseData.clickTime;
                            activityState3.installBeginXiaomi = sdkClickResponseData.installBegin;
                            activityState3.installReferrerXiaomi = sdkClickResponseData.installReferrer;
                            activityState3.clickTimeServerXiaomi = sdkClickResponseData.clickTimeServer;
                            activityState3.installBeginServerXiaomi = sdkClickResponseData.installBeginServer;
                            activityState3.installVersionXiaomi = sdkClickResponseData.installVersion;
                        }
                    } else {
                        ActivityState activityState4 = this.activityState;
                        activityState4.clickTimeSamsung = sdkClickResponseData.clickTime;
                        activityState4.installBeginSamsung = sdkClickResponseData.installBegin;
                        activityState4.installReferrerSamsung = sdkClickResponseData.installReferrer;
                    }
                } else {
                    ActivityState activityState5 = this.activityState;
                    activityState5.clickTimeHuawei = sdkClickResponseData.clickTime;
                    activityState5.installBeginHuawei = sdkClickResponseData.installBegin;
                    activityState5.installReferrerHuaweiAppGallery = sdkClickResponseData.installReferrer;
                }
            } else {
                ActivityState activityState6 = this.activityState;
                activityState6.clickTimeHuawei = sdkClickResponseData.clickTime;
                activityState6.installBeginHuawei = sdkClickResponseData.installBegin;
                activityState6.installReferrerHuawei = sdkClickResponseData.installReferrer;
            }
            writeActivityStateI();
        }
    }

    private void checkForPreinstallI() {
        ActivityState activityState = this.activityState;
        if (activityState == null || !activityState.enabled || activityState.isGdprForgotten) {
            return;
        }
        sendPreinstallReferrerI();
        if (this.adjustConfig.preinstallTrackingEnabled && !this.internalState.hasPreinstallBeenRead()) {
            String str = this.deviceInfo.f4189i;
            if (str == null || str.isEmpty()) {
                this.logger.debug("Can't read preinstall payload, invalid package name", new Object[0]);
                return;
            }
            SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
            long preinstallPayloadReadStatus = defaultInstance.getPreinstallPayloadReadStatus();
            if (PreinstallUtil.hasAllLocationsBeenRead(preinstallPayloadReadStatus)) {
                this.internalState.preinstallHasBeenRead = true;
                return;
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES, preinstallPayloadReadStatus)) {
                String payloadFromSystemProperty = PreinstallUtil.getPayloadFromSystemProperty(this.deviceInfo.f4189i, this.logger);
                if (payloadFromSystemProperty == null || payloadFromSystemProperty.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemProperty, Constants.SYSTEM_PROPERTIES);
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES_REFLECTION, preinstallPayloadReadStatus)) {
                String payloadFromSystemPropertyReflection = PreinstallUtil.getPayloadFromSystemPropertyReflection(this.deviceInfo.f4189i, this.logger);
                if (payloadFromSystemPropertyReflection == null || payloadFromSystemPropertyReflection.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES_REFLECTION, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemPropertyReflection, Constants.SYSTEM_PROPERTIES_REFLECTION);
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES_PATH, preinstallPayloadReadStatus)) {
                String payloadFromSystemPropertyFilePath = PreinstallUtil.getPayloadFromSystemPropertyFilePath(this.deviceInfo.f4189i, this.logger);
                if (payloadFromSystemPropertyFilePath == null || payloadFromSystemPropertyFilePath.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES_PATH, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemPropertyFilePath, Constants.SYSTEM_PROPERTIES_PATH);
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.SYSTEM_PROPERTIES_PATH_REFLECTION, preinstallPayloadReadStatus)) {
                String payloadFromSystemPropertyFilePathReflection = PreinstallUtil.getPayloadFromSystemPropertyFilePathReflection(this.deviceInfo.f4189i, this.logger);
                if (payloadFromSystemPropertyFilePathReflection == null || payloadFromSystemPropertyFilePathReflection.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.SYSTEM_PROPERTIES_PATH_REFLECTION, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromSystemPropertyFilePathReflection, Constants.SYSTEM_PROPERTIES_PATH_REFLECTION);
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.CONTENT_PROVIDER, preinstallPayloadReadStatus)) {
                String payloadFromContentProviderDefault = PreinstallUtil.getPayloadFromContentProviderDefault(this.adjustConfig.context, this.deviceInfo.f4189i, this.logger);
                if (payloadFromContentProviderDefault == null || payloadFromContentProviderDefault.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.CONTENT_PROVIDER, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromContentProviderDefault, Constants.CONTENT_PROVIDER);
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.CONTENT_PROVIDER_INTENT_ACTION, preinstallPayloadReadStatus)) {
                List<String> payloadsFromContentProviderIntentAction = PreinstallUtil.getPayloadsFromContentProviderIntentAction(this.adjustConfig.context, this.deviceInfo.f4189i, this.logger);
                if (payloadsFromContentProviderIntentAction == null || payloadsFromContentProviderIntentAction.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.CONTENT_PROVIDER_INTENT_ACTION, preinstallPayloadReadStatus);
                } else {
                    Iterator<String> it = payloadsFromContentProviderIntentAction.iterator();
                    while (it.hasNext()) {
                        this.sdkClickHandler.sendPreinstallPayload(it.next(), Constants.CONTENT_PROVIDER_INTENT_ACTION);
                    }
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.CONTENT_PROVIDER_NO_PERMISSION, preinstallPayloadReadStatus)) {
                List<String> payloadsFromContentProviderNoPermission = PreinstallUtil.getPayloadsFromContentProviderNoPermission(this.adjustConfig.context, this.deviceInfo.f4189i, this.logger);
                if (payloadsFromContentProviderNoPermission == null || payloadsFromContentProviderNoPermission.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.CONTENT_PROVIDER_NO_PERMISSION, preinstallPayloadReadStatus);
                } else {
                    Iterator<String> it2 = payloadsFromContentProviderNoPermission.iterator();
                    while (it2.hasNext()) {
                        this.sdkClickHandler.sendPreinstallPayload(it2.next(), Constants.CONTENT_PROVIDER_NO_PERMISSION);
                    }
                }
            }
            if (PreinstallUtil.hasNotBeenRead(Constants.FILE_SYSTEM, preinstallPayloadReadStatus)) {
                String payloadFromFileSystem = PreinstallUtil.getPayloadFromFileSystem(this.deviceInfo.f4189i, this.adjustConfig.preinstallFilePath, this.logger);
                if (payloadFromFileSystem == null || payloadFromFileSystem.isEmpty()) {
                    preinstallPayloadReadStatus = PreinstallUtil.markAsRead(Constants.FILE_SYSTEM, preinstallPayloadReadStatus);
                } else {
                    this.sdkClickHandler.sendPreinstallPayload(payloadFromFileSystem, Constants.FILE_SYSTEM);
                }
            }
            defaultInstance.setPreinstallPayloadReadStatus(preinstallPayloadReadStatus);
            this.internalState.preinstallHasBeenRead = true;
        }
    }

    private boolean checkOrderIdI(String str) {
        if (str != null && !str.isEmpty()) {
            if (this.activityState.findOrderId(str)) {
                this.logger.info("Skipping duplicated order ID '%s'", str);
                return false;
            }
            this.activityState.addOrderId(str);
            this.logger.verbose("Added order ID '%s'", str);
        }
        return true;
    }

    private Intent createDeeplinkIntentI(Uri uri) {
        Intent intent;
        if (this.adjustConfig.deepLinkComponent == null) {
            intent = new Intent("android.intent.action.VIEW", uri);
        } else {
            AdjustConfig adjustConfig = this.adjustConfig;
            intent = new Intent("android.intent.action.VIEW", uri, adjustConfig.context, adjustConfig.deepLinkComponent);
        }
        intent.setFlags(268435456);
        intent.setPackage(this.adjustConfig.context.getPackageName());
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delayStartI() {
        if (this.internalState.isNotInDelayedStart() || isToUpdatePackagesI()) {
            return;
        }
        Double d5 = this.adjustConfig.delayStart;
        double doubleValue = d5 != null ? d5.doubleValue() : 0.0d;
        long maxDelayStart = AdjustFactory.getMaxDelayStart();
        long j5 = (long) (1000.0d * doubleValue);
        if (j5 > maxDelayStart) {
            double d6 = maxDelayStart / 1000;
            DecimalFormat decimalFormat = Util.SecondsDisplayFormat;
            this.logger.warn("Delay start of %s seconds bigger than max allowed value of %s seconds", decimalFormat.format(doubleValue), decimalFormat.format(d6));
            doubleValue = d6;
        } else {
            maxDelayStart = j5;
        }
        this.logger.info("Waiting %s seconds before starting first session", Util.SecondsDisplayFormat.format(doubleValue));
        this.delayStartTimer.startIn(maxDelayStart);
        this.internalState.updatePackages = true;
        ActivityState activityState = this.activityState;
        if (activityState != null) {
            activityState.updatePackages = true;
            writeActivityStateI();
        }
    }

    public static boolean deleteActivityState(Context context) {
        return context.deleteFile(Constants.ACTIVITY_STATE_FILENAME);
    }

    public static boolean deleteAttribution(Context context) {
        return context.deleteFile(Constants.ATTRIBUTION_FILENAME);
    }

    public static boolean deleteSessionCallbackParameters(Context context) {
        return context.deleteFile(Constants.SESSION_CALLBACK_PARAMETERS_FILENAME);
    }

    public static boolean deleteSessionPartnerParameters(Context context) {
        return context.deleteFile(Constants.SESSION_PARTNER_PARAMETERS_FILENAME);
    }

    public static void deleteState(Context context) {
        deleteActivityState(context);
        deleteAttribution(context);
        deleteSessionCallbackParameters(context);
        deleteSessionPartnerParameters(context);
        SharedPreferencesManager.getDefaultInstance(context).clear();
    }

    private void disableThirdPartySharingForCoppaEnabledI() {
        if (shouldDisableThirdPartySharingWhenCoppaEnabled()) {
            this.activityState.isThirdPartySharingDisabledForCoppa = true;
            writeActivityStateI();
            ActivityPackage buildThirdPartySharingPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildThirdPartySharingPackage(new AdjustThirdPartySharing(Boolean.FALSE));
            this.packageHandler.addPackage(buildThirdPartySharingPackage);
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildThirdPartySharingPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disableThirdPartySharingI() {
        SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
        defaultInstance.setDisableThirdPartySharing();
        if (checkActivityStateI(this.activityState) && isEnabledI()) {
            ActivityState activityState = this.activityState;
            if (activityState.isGdprForgotten || activityState.isThirdPartySharingDisabled) {
                return;
            }
            if (this.adjustConfig.coppaCompliantEnabled) {
                this.logger.warn("Call to disable third party sharing API ignored, already done when COPPA enabled", new Object[0]);
                return;
            }
            activityState.isThirdPartySharingDisabled = true;
            writeActivityStateI();
            ActivityPackage buildDisableThirdPartySharingPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildDisableThirdPartySharingPackage();
            this.packageHandler.addPackage(buildDisableThirdPartySharingPackage);
            defaultInstance.removeDisableThirdPartySharing();
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildDisableThirdPartySharingPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endI() {
        if (!toSendI()) {
            pauseSendingI();
        }
        if (updateActivityStateI(System.currentTimeMillis())) {
            writeActivityStateI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void foregroundTimerFiredI() {
        if (!isEnabledI()) {
            stopForegroundTimerI();
            return;
        }
        if (toSendI()) {
            this.packageHandler.sendFirstPackage();
        }
        if (updateActivityStateI(System.currentTimeMillis())) {
            writeActivityStateI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gdprForgetMeI() {
        if (checkActivityStateI(this.activityState) && isEnabledI()) {
            ActivityState activityState = this.activityState;
            if (activityState.isGdprForgotten) {
                return;
            }
            activityState.isGdprForgotten = true;
            writeActivityStateI();
            ActivityPackage buildGdprPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildGdprPackage();
            this.packageHandler.addPackage(buildGdprPackage);
            SharedPreferencesManager.getDefaultInstance(getContext()).removeGdprForgetMe();
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildGdprPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    public static ActivityHandler getInstance(AdjustConfig adjustConfig) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (adjustConfig == null) {
            AdjustFactory.getLogger().error("AdjustConfig missing", new Object[0]);
            return null;
        }
        if (!adjustConfig.isValid()) {
            AdjustFactory.getLogger().error("AdjustConfig not initialized correctly", new Object[0]);
            return null;
        }
        if (adjustConfig.processName != null) {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) adjustConfig.context.getSystemService("activity");
            if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        if (!next.processName.equalsIgnoreCase(adjustConfig.processName)) {
                            AdjustFactory.getLogger().info("Skipping initialization in background process (%s)", next.processName);
                            return null;
                        }
                    }
                }
            } else {
                return null;
            }
        }
        return new ActivityHandler(adjustConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotOptOutResponseI() {
        this.activityState.isGdprForgotten = true;
        writeActivityStateI();
        this.packageHandler.flush();
        setEnabledI(false);
    }

    private boolean hasChangedStateI(boolean z5, boolean z6, String str, String str2) {
        if (z5 != z6) {
            return true;
        }
        if (z5) {
            this.logger.debug(str, new Object[0]);
        } else {
            this.logger.debug(str2, new Object[0]);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initI() {
        String pushToken;
        Double d5;
        SESSION_INTERVAL = AdjustFactory.getSessionInterval();
        SUBSESSION_INTERVAL = AdjustFactory.getSubsessionInterval();
        FOREGROUND_TIMER_INTERVAL = AdjustFactory.getTimerInterval();
        FOREGROUND_TIMER_START = AdjustFactory.getTimerStart();
        BACKGROUND_TIMER_INTERVAL = AdjustFactory.getTimerInterval();
        readAttributionI(this.adjustConfig.context);
        readActivityStateI(this.adjustConfig.context);
        this.sessionParameters = new SessionParameters();
        readSessionCallbackParametersI(this.adjustConfig.context);
        readSessionPartnerParametersI(this.adjustConfig.context);
        AdjustConfig adjustConfig = this.adjustConfig;
        if (adjustConfig.startEnabled != null) {
            adjustConfig.preLaunchActions.preLaunchActionsArray.add(new a0());
        }
        if (this.internalState.hasFirstSdkStartOcurred()) {
            InternalState internalState = this.internalState;
            ActivityState activityState = this.activityState;
            internalState.enabled = activityState.enabled;
            internalState.updatePackages = activityState.updatePackages;
            internalState.firstLaunch = false;
        } else {
            this.internalState.firstLaunch = true;
        }
        readConfigFile(this.adjustConfig.context);
        AdjustConfig adjustConfig2 = this.adjustConfig;
        this.deviceInfo = new com.adjust.sdk.a(adjustConfig2.context, adjustConfig2.sdkPrefix);
        if (this.adjustConfig.eventBufferingEnabled) {
            this.logger.info("Event buffering is enabled", new Object[0]);
        }
        this.deviceInfo.b(this.adjustConfig);
        if (this.deviceInfo.f4181a == null) {
            if (Util.canReadPlayIds(this.adjustConfig)) {
                this.logger.warn("Unable to get Google Play Services Advertising ID at start time", new Object[0]);
            } else {
                if (this.adjustConfig.coppaCompliantEnabled) {
                    this.logger.info("Cannot read Google Play Services Advertising ID with COPPA enabled", new Object[0]);
                }
                if (this.adjustConfig.playStoreKidsAppEnabled) {
                    this.logger.info("Cannot read Google Play Services Advertising ID with play store kids app enabled", new Object[0]);
                }
            }
            if (this.deviceInfo.f4186f == null) {
                if (Util.canReadNonPlayIds(this.adjustConfig)) {
                    this.logger.error("Unable to get any Device IDs. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
                } else {
                    if (this.adjustConfig.coppaCompliantEnabled) {
                        this.logger.info("Cannot read non Play IDs with COPPA enabled", new Object[0]);
                    }
                    if (this.adjustConfig.playStoreKidsAppEnabled) {
                        this.logger.info("Cannot read non Play IDs with play store kids app enabled", new Object[0]);
                    }
                }
            }
        } else {
            this.logger.info("Google Play Services Advertising ID read correctly at start time", new Object[0]);
        }
        String str = this.adjustConfig.defaultTracker;
        if (str != null) {
            this.logger.info("Default tracker: '%s'", str);
        }
        String str2 = this.adjustConfig.pushToken;
        if (str2 != null) {
            this.logger.info("Push token: '%s'", str2);
            if (this.internalState.hasFirstSdkStartOcurred()) {
                setPushToken(this.adjustConfig.pushToken, false);
            } else {
                SharedPreferencesManager.getDefaultInstance(getContext()).savePushToken(this.adjustConfig.pushToken);
            }
        } else if (this.internalState.hasFirstSdkStartOcurred() && (pushToken = SharedPreferencesManager.getDefaultInstance(getContext()).getPushToken()) != null) {
            setPushToken(pushToken, true);
        }
        if (this.internalState.hasFirstSdkStartOcurred()) {
            SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
            if (defaultInstance.getGdprForgetMe()) {
                gdprForgetMe();
            } else {
                if (defaultInstance.getDisableThirdPartySharing()) {
                    disableThirdPartySharing();
                }
                Iterator<AdjustThirdPartySharing> it = this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray.iterator();
                while (it.hasNext()) {
                    trackThirdPartySharing(it.next());
                }
                Boolean bool = this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked;
                if (bool != null) {
                    trackMeasurementConsent(bool.booleanValue());
                }
                this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray = new ArrayList();
                this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = null;
            }
        }
        this.foregroundTimer = new TimerCycle(new b0(), FOREGROUND_TIMER_START, FOREGROUND_TIMER_INTERVAL, FOREGROUND_TIMER_NAME);
        if (this.adjustConfig.sendInBackground) {
            this.logger.info("Send in background configured", new Object[0]);
            this.backgroundTimer = new TimerOnce(new c0(), BACKGROUND_TIMER_NAME);
        }
        if (this.internalState.hasFirstSdkStartNotOcurred() && (d5 = this.adjustConfig.delayStart) != null && d5.doubleValue() > 0.0d) {
            this.logger.info("Delay start configured", new Object[0]);
            this.internalState.delayStart = true;
            this.delayStartTimer = new TimerOnce(new d0(), DELAY_START_TIMER_NAME);
        }
        UtilNetworking.setUserAgent(this.adjustConfig.userAgent);
        AdjustConfig adjustConfig3 = this.adjustConfig;
        this.packageHandler = AdjustFactory.getPackageHandler(this, this.adjustConfig.context, toSendI(false), new ActivityPackageSender(adjustConfig3.urlStrategy, adjustConfig3.basePath, adjustConfig3.gdprPath, adjustConfig3.subscriptionPath, this.deviceInfo.f4188h));
        AdjustConfig adjustConfig4 = this.adjustConfig;
        this.attributionHandler = AdjustFactory.getAttributionHandler(this, toSendI(false), new ActivityPackageSender(adjustConfig4.urlStrategy, adjustConfig4.basePath, adjustConfig4.gdprPath, adjustConfig4.subscriptionPath, this.deviceInfo.f4188h));
        AdjustConfig adjustConfig5 = this.adjustConfig;
        this.sdkClickHandler = AdjustFactory.getSdkClickHandler(this, toSendI(true), new ActivityPackageSender(adjustConfig5.urlStrategy, adjustConfig5.basePath, adjustConfig5.gdprPath, adjustConfig5.subscriptionPath, this.deviceInfo.f4188h));
        if (isToUpdatePackagesI()) {
            updatePackagesI();
        }
        this.installReferrer = new InstallReferrer(this.adjustConfig.context, new e0());
        this.installReferrerHuawei = new InstallReferrerHuawei(this.adjustConfig.context, new f0());
        preLaunchActionsI(this.adjustConfig.preLaunchActions.preLaunchActionsArray);
        sendReftagReferrerI();
    }

    private boolean isEnabledI() {
        ActivityState activityState = this.activityState;
        return activityState != null ? activityState.enabled : this.internalState.isEnabled();
    }

    private boolean isToUpdatePackagesI() {
        ActivityState activityState = this.activityState;
        return activityState != null ? activityState.updatePackages : this.internalState.itHasToUpdatePackages();
    }

    private boolean isValidReferrerDetails(ReferrerDetails referrerDetails) {
        String str;
        return (referrerDetails == null || (str = referrerDetails.installReferrer) == null || str.length() == 0) ? false : true;
    }

    private void launchAttributionListenerI(Handler handler) {
        if (this.adjustConfig.onAttributionChangedListener == null) {
            return;
        }
        handler.post(new o0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchAttributionResponseTasksI(AttributionResponseData attributionResponseData) {
        updateAdidI(attributionResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(attributionResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
        prepareDeeplinkI(attributionResponseData.deeplink, handler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchDeeplinkMain(Intent intent, Uri uri) {
        if (this.adjustConfig.context.getPackageManager().queryIntentActivities(intent, 0).size() <= 0) {
            this.logger.error("Unable to open deferred deep link (%s)", uri);
        } else {
            this.logger.info("Open deferred deep link (%s)", uri);
            this.adjustConfig.context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchEventResponseTasksI(EventResponseData eventResponseData) {
        Runnable l0Var;
        updateAdidI(eventResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        boolean z5 = eventResponseData.success;
        if (z5 && this.adjustConfig.onEventTrackingSucceededListener != null) {
            this.logger.debug("Launching success event tracking listener", new Object[0]);
            l0Var = new k0(eventResponseData);
        } else {
            if (z5 || this.adjustConfig.onEventTrackingFailedListener == null) {
                return;
            }
            this.logger.debug("Launching failed event tracking listener", new Object[0]);
            l0Var = new l0(eventResponseData);
        }
        handler.post(l0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchSdkClickResponseTasksI(SdkClickResponseData sdkClickResponseData) {
        updateAdidI(sdkClickResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(sdkClickResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
    }

    private void launchSessionResponseListenerI(SessionResponseData sessionResponseData, Handler handler) {
        Runnable n0Var;
        boolean z5 = sessionResponseData.success;
        if (z5 && this.adjustConfig.onSessionTrackingSucceededListener != null) {
            this.logger.debug("Launching success session tracking listener", new Object[0]);
            n0Var = new m0(sessionResponseData);
        } else {
            if (z5 || this.adjustConfig.onSessionTrackingFailedListener == null) {
                return;
            }
            this.logger.debug("Launching failed session tracking listener", new Object[0]);
            n0Var = new n0(sessionResponseData);
        }
        handler.post(n0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchSessionResponseTasksI(SessionResponseData sessionResponseData) {
        this.logger.debug("Launching SessionResponse tasks", new Object[0]);
        updateAdidI(sessionResponseData.adid);
        Handler handler = new Handler(this.adjustConfig.context.getMainLooper());
        if (updateAttributionI(sessionResponseData.attribution)) {
            launchAttributionListenerI(handler);
        }
        if (this.attribution == null && !this.activityState.askingAttribution) {
            this.attributionHandler.getAttribution();
        }
        if (sessionResponseData.success) {
            SharedPreferencesManager.getDefaultInstance(getContext()).setInstallTracked();
        }
        launchSessionResponseListenerI(sessionResponseData, handler);
        this.internalState.sessionResponseProcessed = true;
    }

    private void pauseSendingI() {
        this.attributionHandler.pauseSending();
        this.packageHandler.pauseSending();
        if (toSendI(true)) {
            this.sdkClickHandler.resumeSending();
        } else {
            this.sdkClickHandler.pauseSending();
        }
    }

    private boolean pausedI() {
        return pausedI(false);
    }

    private void preLaunchActionsI(List<IRunActivityHandler> list) {
        if (list == null) {
            return;
        }
        Iterator<IRunActivityHandler> it = list.iterator();
        while (it.hasNext()) {
            it.next().run(this);
        }
    }

    private void prepareDeeplinkI(Uri uri, Handler handler) {
        if (uri == null) {
            return;
        }
        this.logger.info("Deferred deeplink received (%s)", uri);
        handler.post(new p0(uri, createDeeplinkIntentI(uri)));
    }

    private void processCachedDeeplinkI() {
        if (checkActivityStateI(this.activityState)) {
            SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
            String deeplinkUrl = defaultInstance.getDeeplinkUrl();
            long deeplinkClickTime = defaultInstance.getDeeplinkClickTime();
            if (deeplinkUrl == null || deeplinkClickTime == -1) {
                return;
            }
            readOpenUrl(Uri.parse(deeplinkUrl), deeplinkClickTime);
            defaultInstance.removeDeeplink();
        }
    }

    private void processCoppaComplianceI() {
        if (this.adjustConfig.coppaCompliantEnabled) {
            disableThirdPartySharingForCoppaEnabledI();
        } else {
            resetThirdPartySharingCoppaActivityStateI();
        }
    }

    private void processSessionI() {
        if (this.activityState.isGdprForgotten) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ActivityState activityState = this.activityState;
        long j5 = currentTimeMillis - activityState.lastActivity;
        if (j5 < 0) {
            this.logger.error(TIME_TRAVEL, new Object[0]);
            this.activityState.lastActivity = currentTimeMillis;
            writeActivityStateI();
            return;
        }
        if (j5 > SESSION_INTERVAL) {
            trackNewSessionI(currentTimeMillis);
            checkAfterNewStartI();
            return;
        }
        if (j5 <= SUBSESSION_INTERVAL) {
            this.logger.verbose("Time span since last activity too short for a new subsession", new Object[0]);
            return;
        }
        int i5 = activityState.subsessionCount + 1;
        activityState.subsessionCount = i5;
        activityState.sessionLength += j5;
        activityState.lastActivity = currentTimeMillis;
        this.logger.verbose("Started subsession %d of session %d", Integer.valueOf(i5), Integer.valueOf(this.activityState.sessionCount));
        writeActivityStateI();
        checkForPreinstallI();
        this.installReferrer.startConnection();
        this.installReferrerHuawei.readReferrer();
        readInstallReferrerSamsung();
        readInstallReferrerXiaomi();
        readInstallReferrerVivo();
    }

    private void readActivityStateI(Context context) {
        try {
            this.activityState = (ActivityState) Util.readObject(context, Constants.ACTIVITY_STATE_FILENAME, ACTIVITY_STATE_NAME, ActivityState.class);
        } catch (Exception e5) {
            this.logger.error("Failed to read %s file (%s)", ACTIVITY_STATE_NAME, e5.getMessage());
            this.activityState = null;
        }
        if (this.activityState != null) {
            this.internalState.firstSdkStart = true;
        }
    }

    private void readAttributionI(Context context) {
        try {
            this.attribution = (AdjustAttribution) Util.readObject(context, Constants.ATTRIBUTION_FILENAME, ATTRIBUTION_NAME, AdjustAttribution.class);
        } catch (Exception e5) {
            this.logger.error("Failed to read %s file (%s)", ATTRIBUTION_NAME, e5.getMessage());
            this.attribution = null;
        }
    }

    private void readConfigFile(Context context) {
        try {
            InputStream open = context.getAssets().open("adjust_config.properties");
            Properties properties = new Properties();
            properties.load(open);
            this.logger.verbose("adjust_config.properties file read and loaded", new Object[0]);
            String property = properties.getProperty("defaultTracker");
            if (property != null) {
                this.adjustConfig.defaultTracker = property;
            }
        } catch (Exception e5) {
            this.logger.debug("%s file not found in this app", e5.getMessage());
        }
    }

    private void readInstallReferrerSamsung() {
        this.executor.submit(new h0());
    }

    private void readInstallReferrerVivo() {
        this.executor.submit(new j0());
    }

    private void readInstallReferrerXiaomi() {
        this.executor.submit(new i0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readOpenUrlI(Uri uri, long j5) {
        if (isEnabledI()) {
            if (!Util.isUrlFilteredOut(uri)) {
                ActivityPackage buildDeeplinkSdkClickPackage = PackageFactory.buildDeeplinkSdkClickPackage(uri, j5, this.activityState, this.adjustConfig, this.deviceInfo, this.sessionParameters);
                if (buildDeeplinkSdkClickPackage == null) {
                    return;
                }
                this.sdkClickHandler.sendSdkClick(buildDeeplinkSdkClickPackage);
                return;
            }
            this.logger.debug("Deep link (" + uri.toString() + ") processing skipped", new Object[0]);
        }
    }

    private void readSessionCallbackParametersI(Context context) {
        try {
            this.sessionParameters.callbackParameters = (Map) Util.readObject(context, Constants.SESSION_CALLBACK_PARAMETERS_FILENAME, SESSION_CALLBACK_PARAMETERS_NAME, Map.class);
        } catch (Exception e5) {
            this.logger.error("Failed to read %s file (%s)", SESSION_CALLBACK_PARAMETERS_NAME, e5.getMessage());
            this.sessionParameters.callbackParameters = null;
        }
    }

    private void readSessionPartnerParametersI(Context context) {
        try {
            this.sessionParameters.partnerParameters = (Map) Util.readObject(context, Constants.SESSION_PARTNER_PARAMETERS_FILENAME, SESSION_PARTNER_PARAMETERS_NAME, Map.class);
        } catch (Exception e5) {
            this.logger.error("Failed to read %s file (%s)", SESSION_PARTNER_PARAMETERS_NAME, e5.getMessage());
            this.sessionParameters.partnerParameters = null;
        }
    }

    private void resetThirdPartySharingCoppaActivityStateI() {
        ActivityState activityState = this.activityState;
        if (activityState != null && activityState.isThirdPartySharingDisabledForCoppa) {
            activityState.isThirdPartySharingDisabledForCoppa = false;
            writeActivityStateI();
        }
    }

    private void resumeSendingI() {
        this.attributionHandler.resumeSending();
        this.packageHandler.resumeSending();
        this.sdkClickHandler.resumeSending();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFirstPackagesI() {
        if (this.internalState.isNotInDelayedStart()) {
            this.logger.info("Start delay expired or never configured", new Object[0]);
            return;
        }
        updatePackagesI();
        this.internalState.delayStart = false;
        this.delayStartTimer.cancel();
        this.delayStartTimer = null;
        updateHandlersStatusAndSendI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendInstallReferrerI(ReferrerDetails referrerDetails, String str) {
        if (isEnabledI() && isValidReferrerDetails(referrerDetails) && !Util.isEqualReferrerDetails(referrerDetails, str, this.activityState)) {
            this.sdkClickHandler.sendSdkClick(PackageFactory.buildInstallReferrerSdkClickPackage(referrerDetails, str, this.activityState, this.adjustConfig, this.deviceInfo, this.sessionParameters));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPreinstallReferrerI() {
        String preinstallReferrer;
        if (!isEnabledI() || this.internalState.hasFirstSdkStartNotOcurred() || (preinstallReferrer = SharedPreferencesManager.getDefaultInstance(getContext()).getPreinstallReferrer()) == null || preinstallReferrer.isEmpty()) {
            return;
        }
        this.sdkClickHandler.sendPreinstallPayload(preinstallReferrer, Constants.SYSTEM_INSTALLER_REFERRER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendReftagReferrerI() {
        if (isEnabledI() && !this.internalState.hasFirstSdkStartNotOcurred()) {
            this.sdkClickHandler.sendReftagReferrers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAskingAttributionI(boolean z5) {
        this.activityState.askingAttribution = z5;
        writeActivityStateI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnabledI(boolean z5) {
        ActivityState activityState;
        if (hasChangedStateI(isEnabledI(), z5, "Adjust already enabled", "Adjust already disabled")) {
            if (z5 && (activityState = this.activityState) != null && activityState.isGdprForgotten) {
                this.logger.error("Re-enabling SDK not possible for forgotten user", new Object[0]);
                return;
            }
            InternalState internalState = this.internalState;
            internalState.enabled = z5;
            if (internalState.hasFirstSdkStartNotOcurred()) {
                updateStatusI(!z5, "Handlers will start as paused due to the SDK being disabled", "Handlers will still start as paused", "Handlers will start as active due to the SDK being enabled");
                return;
            }
            this.activityState.enabled = z5;
            writeActivityStateI();
            if (z5) {
                SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
                if (defaultInstance.getGdprForgetMe()) {
                    gdprForgetMeI();
                } else {
                    processCoppaComplianceI();
                    if (defaultInstance.getDisableThirdPartySharing()) {
                        disableThirdPartySharingI();
                    }
                    Iterator<AdjustThirdPartySharing> it = this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray.iterator();
                    while (it.hasNext()) {
                        trackThirdPartySharingI(it.next());
                    }
                    Boolean bool = this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked;
                    if (bool != null) {
                        trackMeasurementConsentI(bool.booleanValue());
                    }
                    this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray = new ArrayList();
                    this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = null;
                }
                if (!defaultInstance.getInstallTracked()) {
                    this.logger.debug("Detected that install was not tracked at enable time", new Object[0]);
                    trackNewSessionI(System.currentTimeMillis());
                }
                checkAfterNewStartI(defaultInstance);
            }
            updateStatusI(!z5, "Pausing handlers due to SDK being disabled", "Handlers remain paused", "Resuming handlers due to SDK being enabled");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOfflineModeI(boolean z5) {
        String str;
        String str2;
        String str3;
        if (hasChangedStateI(this.internalState.isOffline(), z5, "Adjust already in offline mode", "Adjust already in online mode")) {
            InternalState internalState = this.internalState;
            internalState.offline = z5;
            if (internalState.hasFirstSdkStartNotOcurred()) {
                str = "Handlers will still start as paused";
                str2 = "Handlers will start as active due to SDK being online";
                str3 = "Handlers will start paused due to SDK being offline";
            } else {
                str = "Handlers remain paused";
                str2 = "Resuming handlers to put SDK in online mode";
                str3 = "Pausing handlers to put SDK offline mode";
            }
            updateStatusI(z5, str3, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPushTokenI(String str) {
        if (checkActivityStateI(this.activityState) && isEnabledI()) {
            ActivityState activityState = this.activityState;
            if (activityState.isGdprForgotten || str == null || str.equals(activityState.pushToken)) {
                return;
            }
            this.activityState.pushToken = str;
            writeActivityStateI();
            ActivityPackage buildInfoPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildInfoPackage(Constants.PUSH);
            this.packageHandler.addPackage(buildInfoPackage);
            SharedPreferencesManager.getDefaultInstance(getContext()).removePushToken();
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildInfoPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    private boolean shouldDisableThirdPartySharingWhenCoppaEnabled() {
        if (this.activityState == null || !isEnabledI()) {
            return false;
        }
        if (this.activityState.isGdprForgotten) {
            return false;
        }
        return !r0.isThirdPartySharingDisabledForCoppa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBackgroundTimerI() {
        if (this.backgroundTimer != null && toSendI() && this.backgroundTimer.getFireIn() <= 0) {
            this.backgroundTimer.startIn(BACKGROUND_TIMER_INTERVAL);
        }
    }

    private void startFirstSessionI() {
        this.activityState = new ActivityState();
        this.internalState.firstSdkStart = true;
        updateHandlersStatusAndSendI();
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(getContext());
        this.activityState.pushToken = defaultInstance.getPushToken();
        if (this.internalState.isEnabled()) {
            if (defaultInstance.getGdprForgetMe()) {
                gdprForgetMeI();
            } else {
                processCoppaComplianceI();
                if (defaultInstance.getDisableThirdPartySharing()) {
                    disableThirdPartySharingI();
                }
                Iterator<AdjustThirdPartySharing> it = this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray.iterator();
                while (it.hasNext()) {
                    trackThirdPartySharingI(it.next());
                }
                Boolean bool = this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked;
                if (bool != null) {
                    trackMeasurementConsentI(bool.booleanValue());
                }
                this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray = new ArrayList();
                this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = null;
                this.activityState.sessionCount = 1;
                transferSessionPackageI(currentTimeMillis);
                checkAfterNewStartI(defaultInstance);
            }
        }
        this.activityState.resetSessionAttributes(currentTimeMillis);
        this.activityState.enabled = this.internalState.isEnabled();
        this.activityState.updatePackages = this.internalState.itHasToUpdatePackages();
        writeActivityStateI();
        defaultInstance.removePushToken();
        defaultInstance.removeGdprForgetMe();
        defaultInstance.removeDisableThirdPartySharing();
        processCachedDeeplinkI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startForegroundTimerI() {
        if (isEnabledI()) {
            this.foregroundTimer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startI() {
        if (this.internalState.hasFirstSdkStartNotOcurred()) {
            AdjustSigner.onResume(this.adjustConfig.logger);
            startFirstSessionI();
        } else if (this.activityState.enabled) {
            AdjustSigner.onResume(this.adjustConfig.logger);
            updateHandlersStatusAndSendI();
            processCoppaComplianceI();
            processSessionI();
            checkAttributionStateI();
            processCachedDeeplinkI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopBackgroundTimerI() {
        TimerOnce timerOnce = this.backgroundTimer;
        if (timerOnce == null) {
            return;
        }
        timerOnce.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopForegroundTimerI() {
        this.foregroundTimer.suspend();
    }

    private void teardownActivityStateS() {
        synchronized (ActivityState.class) {
            try {
                if (this.activityState == null) {
                    return;
                }
                this.activityState = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void teardownAllSessionParametersS() {
        synchronized (SessionParameters.class) {
            try {
                if (this.sessionParameters == null) {
                    return;
                }
                this.sessionParameters = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void teardownAttributionS() {
        synchronized (AdjustAttribution.class) {
            try {
                if (this.attribution == null) {
                    return;
                }
                this.attribution = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean toSendI() {
        return toSendI(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackAdRevenueI(AdjustAdRevenue adjustAdRevenue) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && checkAdjustAdRevenue(adjustAdRevenue) && !this.activityState.isGdprForgotten) {
            this.packageHandler.addPackage(new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildAdRevenuePackage(adjustAdRevenue, this.internalState.isInDelayedStart()));
            this.packageHandler.sendFirstPackage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackEventI(AdjustEvent adjustEvent) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && checkEventI(adjustEvent) && checkOrderIdI(adjustEvent.orderId) && !this.activityState.isGdprForgotten) {
            long currentTimeMillis = System.currentTimeMillis();
            this.activityState.eventCount++;
            updateActivityStateI(currentTimeMillis);
            ActivityPackage buildEventPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, currentTimeMillis).buildEventPackage(adjustEvent, this.internalState.isInDelayedStart());
            this.packageHandler.addPackage(buildEventPackage);
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildEventPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
            if (this.adjustConfig.sendInBackground && this.internalState.isInBackground()) {
                startBackgroundTimerI();
            }
            writeActivityStateI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackMeasurementConsentI(boolean z5) {
        if (!checkActivityStateI(this.activityState)) {
            this.adjustConfig.preLaunchActions.lastMeasurementConsentTracked = Boolean.valueOf(z5);
        } else if (isEnabledI() && !this.activityState.isGdprForgotten) {
            ActivityPackage buildMeasurementConsentPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildMeasurementConsentPackage(z5);
            this.packageHandler.addPackage(buildMeasurementConsentPackage);
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildMeasurementConsentPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    private void trackNewSessionI(long j5) {
        ActivityState activityState = this.activityState;
        long j6 = j5 - activityState.lastActivity;
        activityState.sessionCount++;
        activityState.lastInterval = j6;
        transferSessionPackageI(j5);
        this.activityState.resetSessionAttributes(j5);
        writeActivityStateI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackSubscriptionI(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && !this.activityState.isGdprForgotten) {
            this.packageHandler.addPackage(new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildSubscriptionPackage(adjustPlayStoreSubscription, this.internalState.isInDelayedStart()));
            this.packageHandler.sendFirstPackage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackThirdPartySharingI(AdjustThirdPartySharing adjustThirdPartySharing) {
        if (!checkActivityStateI(this.activityState)) {
            this.adjustConfig.preLaunchActions.preLaunchAdjustThirdPartySharingArray.add(adjustThirdPartySharing);
            return;
        }
        if (isEnabledI() && !this.activityState.isGdprForgotten) {
            if (this.adjustConfig.coppaCompliantEnabled) {
                this.logger.warn("Calling third party sharing API not allowed when COPPA enabled", new Object[0]);
                return;
            }
            ActivityPackage buildThirdPartySharingPackage = new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildThirdPartySharingPackage(adjustThirdPartySharing);
            this.packageHandler.addPackage(buildThirdPartySharingPackage);
            if (this.adjustConfig.eventBufferingEnabled) {
                this.logger.info("Buffered event %s", buildThirdPartySharingPackage.getSuffix());
            } else {
                this.packageHandler.sendFirstPackage();
            }
        }
    }

    private void transferSessionPackageI(long j5) {
        this.packageHandler.addPackage(new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, j5).buildSessionPackage(this.internalState.isInDelayedStart()));
        this.packageHandler.sendFirstPackage();
    }

    private boolean updateActivityStateI(long j5) {
        if (!checkActivityStateI(this.activityState)) {
            return false;
        }
        ActivityState activityState = this.activityState;
        long j6 = j5 - activityState.lastActivity;
        if (j6 > SESSION_INTERVAL) {
            return false;
        }
        activityState.lastActivity = j5;
        if (j6 < 0) {
            this.logger.error(TIME_TRAVEL, new Object[0]);
            return true;
        }
        activityState.sessionLength += j6;
        activityState.timeSpent += j6;
        return true;
    }

    private void updateAdidI(String str) {
        if (str == null || str.equals(this.activityState.adid)) {
            return;
        }
        this.activityState.adid = str;
        writeActivityStateI();
    }

    private void updateHandlersStatusAndSendI() {
        if (!toSendI()) {
            pauseSendingI();
            return;
        }
        resumeSendingI();
        if (!this.adjustConfig.eventBufferingEnabled || (this.internalState.isFirstLaunch() && this.internalState.hasSessionResponseNotBeenProcessed())) {
            this.packageHandler.sendFirstPackage();
        }
    }

    private void updatePackagesI() {
        this.packageHandler.updatePackages(this.sessionParameters);
        this.internalState.updatePackages = false;
        ActivityState activityState = this.activityState;
        if (activityState != null) {
            activityState.updatePackages = false;
            writeActivityStateI();
        }
    }

    private void updateStatusI(boolean z5, String str, String str2, String str3) {
        if (z5) {
            this.logger.info(str, new Object[0]);
        } else if (!pausedI(false)) {
            this.logger.info(str3, new Object[0]);
        } else if (pausedI(true)) {
            this.logger.info(str2, new Object[0]);
        } else {
            this.logger.info(str2 + ", except the Sdk Click Handler", new Object[0]);
        }
        updateHandlersStatusAndSendI();
    }

    private void writeActivityStateI() {
        synchronized (ActivityState.class) {
            try {
                ActivityState activityState = this.activityState;
                if (activityState == null) {
                    return;
                }
                Util.writeObject(activityState, this.adjustConfig.context, Constants.ACTIVITY_STATE_FILENAME, ACTIVITY_STATE_NAME);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void writeAttributionI() {
        synchronized (AdjustAttribution.class) {
            try {
                AdjustAttribution adjustAttribution = this.attribution;
                if (adjustAttribution == null) {
                    return;
                }
                Util.writeObject(adjustAttribution, this.adjustConfig.context, Constants.ATTRIBUTION_FILENAME, ATTRIBUTION_NAME);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void writeSessionCallbackParametersI() {
        synchronized (SessionParameters.class) {
            try {
                SessionParameters sessionParameters = this.sessionParameters;
                if (sessionParameters == null) {
                    return;
                }
                Util.writeObject(sessionParameters.callbackParameters, this.adjustConfig.context, Constants.SESSION_CALLBACK_PARAMETERS_FILENAME, SESSION_CALLBACK_PARAMETERS_NAME);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void writeSessionPartnerParametersI() {
        synchronized (SessionParameters.class) {
            try {
                SessionParameters sessionParameters = this.sessionParameters;
                if (sessionParameters == null) {
                    return;
                }
                Util.writeObject(sessionParameters.partnerParameters, this.adjustConfig.context, Constants.SESSION_PARTNER_PARAMETERS_FILENAME, SESSION_PARTNER_PARAMETERS_NAME);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void addSessionCallbackParameter(String str, String str2) {
        this.executor.submit(new h(str, str2));
    }

    public void addSessionCallbackParameterI(String str, String str2) {
        if (Util.isValidParameter(str, "key", "Session Callback") && Util.isValidParameter(str2, "value", "Session Callback")) {
            SessionParameters sessionParameters = this.sessionParameters;
            if (sessionParameters.callbackParameters == null) {
                sessionParameters.callbackParameters = new LinkedHashMap();
            }
            String str3 = this.sessionParameters.callbackParameters.get(str);
            if (str2.equals(str3)) {
                this.logger.verbose("Key %s already present with the same value", str);
                return;
            }
            if (str3 != null) {
                this.logger.warn("Key %s will be overwritten", str);
            }
            this.sessionParameters.callbackParameters.put(str, str2);
            writeSessionCallbackParametersI();
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void addSessionPartnerParameter(String str, String str2) {
        this.executor.submit(new i(str, str2));
    }

    public void addSessionPartnerParameterI(String str, String str2) {
        if (Util.isValidParameter(str, "key", "Session Partner") && Util.isValidParameter(str2, "value", "Session Partner")) {
            SessionParameters sessionParameters = this.sessionParameters;
            if (sessionParameters.partnerParameters == null) {
                sessionParameters.partnerParameters = new LinkedHashMap();
            }
            String str3 = this.sessionParameters.partnerParameters.get(str);
            if (str2.equals(str3)) {
                this.logger.verbose("Key %s already present with the same value", str);
                return;
            }
            if (str3 != null) {
                this.logger.warn("Key %s will be overwritten", str);
            }
            this.sessionParameters.partnerParameters.put(str, str2);
            writeSessionPartnerParametersI();
        }
    }

    public void backgroundTimerFired() {
        this.executor.submit(new z());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void disableThirdPartySharing() {
        this.executor.submit(new q());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void finishedTrackingActivity(ResponseData responseData) {
        if (responseData instanceof SessionResponseData) {
            this.logger.debug("Finished tracking session", new Object[0]);
            this.attributionHandler.checkSessionResponse((SessionResponseData) responseData);
        } else if (responseData instanceof SdkClickResponseData) {
            SdkClickResponseData sdkClickResponseData = (SdkClickResponseData) responseData;
            checkForInstallReferrerInfo(sdkClickResponseData);
            this.attributionHandler.checkSdkClickResponse(sdkClickResponseData);
        } else if (responseData instanceof EventResponseData) {
            launchEventResponseTasks((EventResponseData) responseData);
        }
    }

    public void foregroundTimerFired() {
        this.executor.submit(new y());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void gdprForgetMe() {
        this.executor.submit(new p());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public ActivityState getActivityState() {
        return this.activityState;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public String getAdid() {
        ActivityState activityState = this.activityState;
        if (activityState == null) {
            return null;
        }
        return activityState.adid;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public AdjustConfig getAdjustConfig() {
        return this.adjustConfig;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public AdjustAttribution getAttribution() {
        return this.attribution;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public Context getContext() {
        return this.adjustConfig.context;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public com.adjust.sdk.a getDeviceInfo() {
        return this.deviceInfo;
    }

    public InternalState getInternalState() {
        return this.internalState;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public SessionParameters getSessionParameters() {
        return this.sessionParameters;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void gotOptOutResponse() {
        this.executor.submit(new x());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void init(AdjustConfig adjustConfig) {
        this.adjustConfig = adjustConfig;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public boolean isEnabled() {
        return isEnabledI();
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchAttributionResponseTasks(AttributionResponseData attributionResponseData) {
        this.executor.submit(new f(attributionResponseData));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchEventResponseTasks(EventResponseData eventResponseData) {
        this.executor.submit(new c(eventResponseData));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchSdkClickResponseTasks(SdkClickResponseData sdkClickResponseData) {
        this.executor.submit(new d(sdkClickResponseData));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void launchSessionResponseTasks(SessionResponseData sessionResponseData) {
        this.executor.submit(new e(sessionResponseData));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void onPause() {
        this.internalState.background = true;
        this.executor.submit(new g0());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void onResume() {
        this.internalState.background = false;
        this.executor.submit(new v());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void readOpenUrl(Uri uri, long j5) {
        this.executor.submit(new t0(uri, j5));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void removeSessionCallbackParameter(String str) {
        this.executor.submit(new j(str));
    }

    public void removeSessionCallbackParameterI(String str) {
        if (Util.isValidParameter(str, "key", "Session Callback")) {
            Map<String, String> map = this.sessionParameters.callbackParameters;
            if (map == null) {
                this.logger.warn("Session Callback parameters are not set", new Object[0]);
            } else if (map.remove(str) == null) {
                this.logger.warn("Key %s does not exist", str);
            } else {
                this.logger.debug("Key %s will be removed", str);
                writeSessionCallbackParametersI();
            }
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void removeSessionPartnerParameter(String str) {
        this.executor.submit(new l(str));
    }

    public void removeSessionPartnerParameterI(String str) {
        if (Util.isValidParameter(str, "key", "Session Partner")) {
            Map<String, String> map = this.sessionParameters.partnerParameters;
            if (map == null) {
                this.logger.warn("Session Partner parameters are not set", new Object[0]);
            } else if (map.remove(str) == null) {
                this.logger.warn("Key %s does not exist", str);
            } else {
                this.logger.debug("Key %s will be removed", str);
                writeSessionPartnerParametersI();
            }
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void resetSessionCallbackParameters() {
        this.executor.submit(new m());
    }

    public void resetSessionCallbackParametersI() {
        if (this.sessionParameters.callbackParameters == null) {
            this.logger.warn("Session Callback parameters are not set", new Object[0]);
        }
        this.sessionParameters.callbackParameters = null;
        writeSessionCallbackParametersI();
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void resetSessionPartnerParameters() {
        this.executor.submit(new n());
    }

    public void resetSessionPartnerParametersI() {
        if (this.sessionParameters.partnerParameters == null) {
            this.logger.warn("Session Partner parameters are not set", new Object[0]);
        }
        this.sessionParameters.partnerParameters = null;
        writeSessionPartnerParametersI();
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void sendFirstPackages() {
        this.executor.submit(new g());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void sendInstallReferrer(ReferrerDetails referrerDetails, String str) {
        this.executor.submit(new b(referrerDetails, str));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void sendPreinstallReferrer() {
        this.executor.submit(new a());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void sendReftagReferrer() {
        this.executor.submit(new v0());
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void setAskingAttribution(boolean z5) {
        this.executor.submit(new u0(z5));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void setEnabled(boolean z5) {
        this.executor.submit(new r0(z5));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void setOfflineMode(boolean z5) {
        this.executor.submit(new s0(z5));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void setPushToken(String str, boolean z5) {
        this.executor.submit(new o(z5, str));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void teardown() {
        TimerOnce timerOnce = this.backgroundTimer;
        if (timerOnce != null) {
            timerOnce.teardown();
        }
        TimerCycle timerCycle = this.foregroundTimer;
        if (timerCycle != null) {
            timerCycle.teardown();
        }
        TimerOnce timerOnce2 = this.delayStartTimer;
        if (timerOnce2 != null) {
            timerOnce2.teardown();
        }
        ThreadExecutor threadExecutor = this.executor;
        if (threadExecutor != null) {
            threadExecutor.teardown();
        }
        IPackageHandler iPackageHandler = this.packageHandler;
        if (iPackageHandler != null) {
            iPackageHandler.teardown();
        }
        IAttributionHandler iAttributionHandler = this.attributionHandler;
        if (iAttributionHandler != null) {
            iAttributionHandler.teardown();
        }
        ISdkClickHandler iSdkClickHandler = this.sdkClickHandler;
        if (iSdkClickHandler != null) {
            iSdkClickHandler.teardown();
        }
        SessionParameters sessionParameters = this.sessionParameters;
        if (sessionParameters != null) {
            Map<String, String> map = sessionParameters.callbackParameters;
            if (map != null) {
                map.clear();
            }
            Map<String, String> map2 = this.sessionParameters.partnerParameters;
            if (map2 != null) {
                map2.clear();
            }
        }
        teardownActivityStateS();
        teardownAttributionS();
        teardownAllSessionParametersS();
        this.packageHandler = null;
        this.logger = null;
        this.foregroundTimer = null;
        this.executor = null;
        this.backgroundTimer = null;
        this.delayStartTimer = null;
        this.internalState = null;
        this.deviceInfo = null;
        this.adjustConfig = null;
        this.attributionHandler = null;
        this.sdkClickHandler = null;
        this.sessionParameters = null;
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackAdRevenue(AdjustAdRevenue adjustAdRevenue) {
        this.executor.submit(new u(adjustAdRevenue));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackEvent(AdjustEvent adjustEvent) {
        this.executor.submit(new q0(adjustEvent));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackMeasurementConsent(boolean z5) {
        this.executor.submit(new s(z5));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        this.executor.submit(new w(adjustPlayStoreSubscription));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackThirdPartySharing(AdjustThirdPartySharing adjustThirdPartySharing) {
        this.executor.submit(new r(adjustThirdPartySharing));
    }

    @Override // com.adjust.sdk.IActivityHandler
    public boolean updateAttributionI(AdjustAttribution adjustAttribution) {
        if (adjustAttribution == null || adjustAttribution.equals(this.attribution)) {
            return false;
        }
        this.attribution = adjustAttribution;
        writeAttributionI();
        return true;
    }

    private void checkAfterNewStartI(SharedPreferencesManager sharedPreferencesManager) {
        String pushToken = sharedPreferencesManager.getPushToken();
        if (pushToken != null && !pushToken.equals(this.activityState.pushToken)) {
            setPushToken(pushToken, true);
        }
        if (sharedPreferencesManager.getRawReferrerArray() != null) {
            sendReftagReferrer();
        }
        checkForPreinstallI();
        this.installReferrer.startConnection();
        this.installReferrerHuawei.readReferrer();
        readInstallReferrerSamsung();
        readInstallReferrerXiaomi();
        readInstallReferrerVivo();
    }

    private boolean pausedI(boolean z5) {
        return z5 ? this.internalState.isOffline() || !isEnabledI() : this.internalState.isOffline() || !isEnabledI() || this.internalState.isInDelayedStart();
    }

    private boolean toSendI(boolean z5) {
        if (pausedI(z5)) {
            return false;
        }
        if (this.adjustConfig.sendInBackground) {
            return true;
        }
        return this.internalState.isInForeground();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackAdRevenueI(String str, JSONObject jSONObject) {
        if (checkActivityStateI(this.activityState) && isEnabledI() && !this.activityState.isGdprForgotten) {
            this.packageHandler.addPackage(new PackageBuilder(this.adjustConfig, this.deviceInfo, this.activityState, this.sessionParameters, System.currentTimeMillis()).buildAdRevenuePackage(str, jSONObject));
            this.packageHandler.sendFirstPackage();
        }
    }

    @Override // com.adjust.sdk.IActivityHandler
    public void trackAdRevenue(String str, JSONObject jSONObject) {
        this.executor.submit(new t(str, jSONObject));
    }
}
