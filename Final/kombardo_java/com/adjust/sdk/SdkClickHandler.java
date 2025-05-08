package com.adjust.sdk;

import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadScheduler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public class SdkClickHandler implements ISdkClickHandler {
    private static final double MILLISECONDS_TO_SECONDS_DIVISOR = 1000.0d;
    private static final String SCHEDULED_EXECUTOR_SOURCE = "SdkClickHandler";
    private static final String SOURCE_INSTALL_REFERRER = "install_referrer";
    private static final String SOURCE_REFTAG = "reftag";
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
    private IActivityPackageSender activityPackageSender;
    private BackoffStrategy backoffStrategy;
    private ILogger logger;
    private List<ActivityPackage> packageQueue;
    private boolean paused;
    private ThreadScheduler scheduler;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityPackage f4163a;

        public a(ActivityPackage activityPackage) {
            this.f4163a = activityPackage;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SdkClickHandler.this.packageQueue.add(this.f4163a);
            SdkClickHandler.this.logger.debug("Added sdk_click %d", Integer.valueOf(SdkClickHandler.this.packageQueue.size()));
            SdkClickHandler.this.logger.verbose("%s", this.f4163a.getExtendedString());
            SdkClickHandler.this.sendNextSdkClick();
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) SdkClickHandler.this.activityHandlerWeakRef.get();
            SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(iActivityHandler.getContext());
            try {
                JSONArray rawReferrerArray = defaultInstance.getRawReferrerArray();
                boolean z5 = false;
                for (int i5 = 0; i5 < rawReferrerArray.length(); i5++) {
                    JSONArray jSONArray = rawReferrerArray.getJSONArray(i5);
                    if (jSONArray.optInt(2, -1) == 0) {
                        String optString = jSONArray.optString(0, null);
                        z5 = true;
                        long optLong = jSONArray.optLong(1, -1L);
                        jSONArray.put(2, 1);
                        SdkClickHandler.this.sendSdkClick(PackageFactory.buildReftagSdkClickPackage(optString, optLong, iActivityHandler.getActivityState(), iActivityHandler.getAdjustConfig(), iActivityHandler.getDeviceInfo(), iActivityHandler.getSessionParameters()));
                    }
                }
                if (z5) {
                    defaultInstance.saveRawReferrerArray(rawReferrerArray);
                }
            } catch (JSONException e5) {
                SdkClickHandler.this.logger.error("Send saved raw referrers error (%s)", e5.getMessage());
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4166a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4167b;

        public c(String str, String str2) {
            this.f4166a = str;
            this.f4167b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IActivityHandler iActivityHandler = (IActivityHandler) SdkClickHandler.this.activityHandlerWeakRef.get();
            if (iActivityHandler == null) {
                return;
            }
            SdkClickHandler.this.sendSdkClick(PackageFactory.buildPreinstallSdkClickPackage(this.f4166a, this.f4167b, iActivityHandler.getActivityState(), iActivityHandler.getAdjustConfig(), iActivityHandler.getDeviceInfo(), iActivityHandler.getSessionParameters()));
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SdkClickHandler.this.sendNextSdkClickI();
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityPackage f4170a;

        public e(ActivityPackage activityPackage) {
            this.f4170a = activityPackage;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SdkClickHandler.this.sendSdkClickI(this.f4170a);
            SdkClickHandler.this.sendNextSdkClick();
        }
    }

    public SdkClickHandler(IActivityHandler iActivityHandler, boolean z5, IActivityPackageSender iActivityPackageSender) {
        init(iActivityHandler, z5, iActivityPackageSender);
        this.logger = AdjustFactory.getLogger();
        this.backoffStrategy = AdjustFactory.getSdkClickBackoffStrategy();
        this.scheduler = new SingleThreadCachedScheduler(SCHEDULED_EXECUTOR_SOURCE);
    }

    private Map<String, String> generateSendingParametersI() {
        HashMap hashMap = new HashMap();
        PackageBuilder.addString(hashMap, "sent_at", Util.dateFormatter.format(Long.valueOf(System.currentTimeMillis())));
        int size = this.packageQueue.size() - 1;
        if (size > 0) {
            PackageBuilder.addLong(hashMap, "queue_size", size);
        }
        return hashMap;
    }

    private void logErrorMessageI(ActivityPackage activityPackage, String str, Throwable th) {
        this.logger.error(Util.formatString("%s. (%s)", activityPackage.getFailureMessage(), Util.getReasonString(str, th)), new Object[0]);
    }

    private void retrySendingI(ActivityPackage activityPackage) {
        this.logger.error("Retrying sdk_click package for the %d time", Integer.valueOf(activityPackage.increaseRetries()));
        sendSdkClick(activityPackage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextSdkClick() {
        this.scheduler.submit(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextSdkClickI() {
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        if (iActivityHandler.getActivityState() == null || iActivityHandler.getActivityState().isGdprForgotten || this.paused || this.packageQueue.isEmpty()) {
            return;
        }
        ActivityPackage remove = this.packageQueue.remove(0);
        int retries = remove.getRetries();
        e eVar = new e(remove);
        if (retries <= 0) {
            eVar.run();
            return;
        }
        long waitingTime = Util.getWaitingTime(retries, this.backoffStrategy);
        this.logger.verbose("Waiting for %s seconds before retrying sdk_click for the %d time", Util.SecondsDisplayFormat.format(waitingTime / MILLISECONDS_TO_SECONDS_DIVISOR), Integer.valueOf(retries));
        this.scheduler.schedule(eVar, waitingTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSdkClickI(ActivityPackage activityPackage) {
        String str;
        long j5;
        long j6;
        long j7;
        long j8;
        String str2;
        String str3;
        Boolean bool;
        long j9;
        String str4;
        IActivityHandler iActivityHandler = this.activityHandlerWeakRef.get();
        String str5 = activityPackage.getParameters().get("source");
        boolean z5 = str5 != null && str5.equals("reftag");
        String str6 = activityPackage.getParameters().get("raw_referrer");
        if (z5 && SharedPreferencesManager.getDefaultInstance(iActivityHandler.getContext()).getRawReferrer(str6, activityPackage.getClickTimeInMilliseconds()) == null) {
            return;
        }
        boolean z6 = str5 != null && str5.equals("install_referrer");
        if (z6) {
            j5 = activityPackage.getClickTimeInSeconds();
            j7 = activityPackage.getInstallBeginTimeInSeconds();
            str = activityPackage.getParameters().get(Constants.REFERRER);
            j8 = activityPackage.getClickTimeServerInSeconds();
            long installBeginTimeServerInSeconds = activityPackage.getInstallBeginTimeServerInSeconds();
            String installVersion = activityPackage.getInstallVersion();
            bool = activityPackage.getGooglePlayInstant();
            str3 = activityPackage.getParameters().get("referrer_api");
            j6 = installBeginTimeServerInSeconds;
            str2 = installVersion;
        } else {
            str = null;
            j5 = -1;
            j6 = -1;
            j7 = -1;
            j8 = -1;
            str2 = null;
            str3 = null;
            bool = null;
        }
        String str7 = str2;
        boolean z7 = str5 != null && str5.equals(Constants.PREINSTALL);
        ResponseData sendActivityPackageSync = this.activityPackageSender.sendActivityPackageSync(activityPackage, generateSendingParametersI());
        if (sendActivityPackageSync instanceof SdkClickResponseData) {
            SdkClickResponseData sdkClickResponseData = (SdkClickResponseData) sendActivityPackageSync;
            if (sdkClickResponseData.willRetry) {
                retrySendingI(activityPackage);
                return;
            }
            if (iActivityHandler == null) {
                return;
            }
            if (sdkClickResponseData.trackingState == TrackingState.OPTED_OUT) {
                iActivityHandler.gotOptOutResponse();
                return;
            }
            if (z5) {
                j9 = j6;
                SharedPreferencesManager.getDefaultInstance(iActivityHandler.getContext()).removeRawReferrer(str6, activityPackage.getClickTimeInMilliseconds());
            } else {
                j9 = j6;
            }
            if (z6) {
                sdkClickResponseData.clickTime = j5;
                sdkClickResponseData.installBegin = j7;
                sdkClickResponseData.installReferrer = str;
                sdkClickResponseData.clickTimeServer = j8;
                sdkClickResponseData.installBeginServer = j9;
                sdkClickResponseData.installVersion = str7;
                sdkClickResponseData.googlePlayInstant = bool;
                sdkClickResponseData.referrerApi = str3;
                sdkClickResponseData.isInstallReferrer = true;
            }
            if (z7 && (str4 = activityPackage.getParameters().get("found_location")) != null && !str4.isEmpty()) {
                SharedPreferencesManager defaultInstance = SharedPreferencesManager.getDefaultInstance(iActivityHandler.getContext());
                if (Constants.SYSTEM_INSTALLER_REFERRER.equalsIgnoreCase(str4)) {
                    defaultInstance.removePreinstallReferrer();
                } else {
                    defaultInstance.setPreinstallPayloadReadStatus(PreinstallUtil.markAsRead(str4, defaultInstance.getPreinstallPayloadReadStatus()));
                }
            }
            iActivityHandler.finishedTrackingActivity(sdkClickResponseData);
        }
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void init(IActivityHandler iActivityHandler, boolean z5, IActivityPackageSender iActivityPackageSender) {
        this.paused = !z5;
        this.packageQueue = new ArrayList();
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
        this.activityPackageSender = iActivityPackageSender;
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void pauseSending() {
        this.paused = true;
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void resumeSending() {
        this.paused = false;
        sendNextSdkClick();
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void sendPreinstallPayload(String str, String str2) {
        this.scheduler.submit(new c(str, str2));
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void sendReftagReferrers() {
        this.scheduler.submit(new b());
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void sendSdkClick(ActivityPackage activityPackage) {
        this.scheduler.submit(new a(activityPackage));
    }

    @Override // com.adjust.sdk.ISdkClickHandler
    public void teardown() {
        this.logger.verbose("SdkClickHandler teardown", new Object[0]);
        ThreadScheduler threadScheduler = this.scheduler;
        if (threadScheduler != null) {
            threadScheduler.teardown();
        }
        List<ActivityPackage> list = this.packageQueue;
        if (list != null) {
            list.clear();
        }
        WeakReference<IActivityHandler> weakReference = this.activityHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.logger = null;
        this.packageQueue = null;
        this.backoffStrategy = null;
        this.scheduler = null;
    }
}
