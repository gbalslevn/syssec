package com.adjust.sdk;

import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AdjustInstance {
    private IActivityHandler activityHandler;
    private String basePath;
    private String gdprPath;
    private String pushToken;
    private String subscriptionPath;
    private Boolean startEnabled = null;
    private boolean startOffline = false;
    private PreLaunchActions preLaunchActions = new PreLaunchActions();

    /* loaded from: classes.dex */
    public static class PreLaunchActions {
        public List<IRunActivityHandler> preLaunchActionsArray = new ArrayList();
        public List<AdjustThirdPartySharing> preLaunchAdjustThirdPartySharingArray = new ArrayList();
        public Boolean lastMeasurementConsentTracked = null;
    }

    /* loaded from: classes.dex */
    public class a implements IRunActivityHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4118a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4119b;

        public a(String str, String str2) {
            this.f4118a = str;
            this.f4119b = str2;
        }

        @Override // com.adjust.sdk.IRunActivityHandler
        public final void run(ActivityHandler activityHandler) {
            activityHandler.addSessionCallbackParameterI(this.f4118a, this.f4119b);
        }
    }

    /* loaded from: classes.dex */
    public class b implements IRunActivityHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4120a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4121b;

        public b(String str, String str2) {
            this.f4120a = str;
            this.f4121b = str2;
        }

        @Override // com.adjust.sdk.IRunActivityHandler
        public final void run(ActivityHandler activityHandler) {
            activityHandler.addSessionPartnerParameterI(this.f4120a, this.f4121b);
        }
    }

    /* loaded from: classes.dex */
    public class c implements IRunActivityHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4122a;

        public c(String str) {
            this.f4122a = str;
        }

        @Override // com.adjust.sdk.IRunActivityHandler
        public final void run(ActivityHandler activityHandler) {
            activityHandler.removeSessionCallbackParameterI(this.f4122a);
        }
    }

    /* loaded from: classes.dex */
    public class d implements IRunActivityHandler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4123a;

        public d(String str) {
            this.f4123a = str;
        }

        @Override // com.adjust.sdk.IRunActivityHandler
        public final void run(ActivityHandler activityHandler) {
            activityHandler.removeSessionPartnerParameterI(this.f4123a);
        }
    }

    /* loaded from: classes.dex */
    public class e implements IRunActivityHandler {
        @Override // com.adjust.sdk.IRunActivityHandler
        public final void run(ActivityHandler activityHandler) {
            activityHandler.resetSessionCallbackParametersI();
        }
    }

    /* loaded from: classes.dex */
    public class f implements IRunActivityHandler {
        @Override // com.adjust.sdk.IRunActivityHandler
        public final void run(ActivityHandler activityHandler) {
            activityHandler.resetSessionPartnerParametersI();
        }
    }

    private boolean checkActivityHandler(String str) {
        return checkActivityHandler(str, false);
    }

    private boolean isInstanceEnabled() {
        Boolean bool = this.startEnabled;
        return bool == null || bool.booleanValue();
    }

    private void saveDeeplink(Uri uri, long j5, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).saveDeeplink(uri, j5);
    }

    private void saveDisableThirdPartySharing(Context context) {
        SharedPreferencesManager.getDefaultInstance(context).setDisableThirdPartySharing();
    }

    private void saveGdprForgetMe(Context context) {
        SharedPreferencesManager.getDefaultInstance(context).setGdprForgetMe();
    }

    private void savePreinstallReferrer(String str, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).savePreinstallReferrer(str);
    }

    private void savePushToken(String str, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).savePushToken(str);
    }

    private void saveRawReferrer(String str, long j5, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).saveRawReferrer(str, j5);
    }

    private void setSendingReferrersAsNotSent(Context context) {
        SharedPreferencesManager.getDefaultInstance(context).setSendingReferrersAsNotSent();
    }

    public void addSessionCallbackParameter(String str, String str2) {
        if (checkActivityHandler("adding session callback parameter", true)) {
            this.activityHandler.addSessionCallbackParameter(str, str2);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new a(str, str2));
        }
    }

    public void addSessionPartnerParameter(String str, String str2) {
        if (checkActivityHandler("adding session partner parameter", true)) {
            this.activityHandler.addSessionPartnerParameter(str, str2);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new b(str, str2));
        }
    }

    public void appWillOpenUrl(Uri uri) {
        if (checkActivityHandler("appWillOpenUrl")) {
            this.activityHandler.readOpenUrl(uri, System.currentTimeMillis());
        }
    }

    public void disableThirdPartySharing(Context context) {
        if (checkActivityHandler("disable third party sharing", true)) {
            this.activityHandler.disableThirdPartySharing();
        } else {
            saveDisableThirdPartySharing(context);
        }
    }

    public void gdprForgetMe(Context context) {
        saveGdprForgetMe(context);
        if (checkActivityHandler("gdpr", true) && this.activityHandler.isEnabled()) {
            this.activityHandler.gdprForgetMe();
        }
    }

    public String getAdid() {
        if (checkActivityHandler("getAdid")) {
            return this.activityHandler.getAdid();
        }
        return null;
    }

    public AdjustAttribution getAttribution() {
        if (checkActivityHandler("getAttribution")) {
            return this.activityHandler.getAttribution();
        }
        return null;
    }

    public String getSdkVersion() {
        return Util.getSdkVersion();
    }

    public boolean isEnabled() {
        return !checkActivityHandler("isEnabled") ? isInstanceEnabled() : this.activityHandler.isEnabled();
    }

    public void onCreate(AdjustConfig adjustConfig) {
        if (adjustConfig == null) {
            AdjustFactory.getLogger().error("AdjustConfig missing", new Object[0]);
            return;
        }
        if (!adjustConfig.isValid()) {
            AdjustFactory.getLogger().error("AdjustConfig not initialized correctly", new Object[0]);
            return;
        }
        if (this.activityHandler != null) {
            AdjustFactory.getLogger().error("Adjust already initialized", new Object[0]);
            return;
        }
        adjustConfig.preLaunchActions = this.preLaunchActions;
        adjustConfig.pushToken = this.pushToken;
        adjustConfig.startEnabled = this.startEnabled;
        adjustConfig.startOffline = this.startOffline;
        adjustConfig.basePath = this.basePath;
        adjustConfig.gdprPath = this.gdprPath;
        adjustConfig.subscriptionPath = this.subscriptionPath;
        this.activityHandler = AdjustFactory.getActivityHandler(adjustConfig);
        setSendingReferrersAsNotSent(adjustConfig.context);
    }

    public void onPause() {
        if (checkActivityHandler("onPause")) {
            this.activityHandler.onPause();
        }
    }

    public void onResume() {
        if (checkActivityHandler("onResume")) {
            this.activityHandler.onResume();
        }
    }

    public void removeSessionCallbackParameter(String str) {
        if (checkActivityHandler("removing session callback parameter", true)) {
            this.activityHandler.removeSessionCallbackParameter(str);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new c(str));
        }
    }

    public void removeSessionPartnerParameter(String str) {
        if (checkActivityHandler("removing session partner parameter", true)) {
            this.activityHandler.removeSessionPartnerParameter(str);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new d(str));
        }
    }

    public void resetSessionCallbackParameters() {
        if (checkActivityHandler("resetting session callback parameters", true)) {
            this.activityHandler.resetSessionCallbackParameters();
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new e());
        }
    }

    public void resetSessionPartnerParameters() {
        if (checkActivityHandler("resetting session partner parameters", true)) {
            this.activityHandler.resetSessionPartnerParameters();
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new f());
        }
    }

    public void sendFirstPackages() {
        if (checkActivityHandler("sendFirstPackages")) {
            this.activityHandler.sendFirstPackages();
        }
    }

    public void sendPreinstallReferrer(String str, Context context) {
        if (str == null || str.length() == 0) {
            AdjustFactory.getLogger().warn("Skipping SYSTEM_INSTALLER_REFERRER preinstall referrer processing (null or empty)", new Object[0]);
            return;
        }
        savePreinstallReferrer(str, context);
        if (checkActivityHandler("preinstall referrer", true) && this.activityHandler.isEnabled()) {
            this.activityHandler.sendPreinstallReferrer();
        }
    }

    public void sendReferrer(String str, Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            AdjustFactory.getLogger().warn("Skipping INSTALL_REFERRER intent referrer processing (null or empty)", new Object[0]);
            return;
        }
        saveRawReferrer(str, currentTimeMillis, context);
        if (checkActivityHandler(Constants.REFERRER, true) && this.activityHandler.isEnabled()) {
            this.activityHandler.sendReftagReferrer();
        }
    }

    public void setEnabled(boolean z5) {
        this.startEnabled = Boolean.valueOf(z5);
        if (checkActivityHandler(z5, "enabled mode", "disabled mode")) {
            this.activityHandler.setEnabled(z5);
        }
    }

    public void setOfflineMode(boolean z5) {
        if (checkActivityHandler(z5, "offline mode", "online mode")) {
            this.activityHandler.setOfflineMode(z5);
        } else {
            this.startOffline = z5;
        }
    }

    public void setPushToken(String str) {
        if (checkActivityHandler("push token", true)) {
            this.activityHandler.setPushToken(str, false);
        } else {
            this.pushToken = str;
        }
    }

    public void setTestOptions(AdjustTestOptions adjustTestOptions) {
        String str = adjustTestOptions.basePath;
        if (str != null) {
            this.basePath = str;
        }
        String str2 = adjustTestOptions.gdprPath;
        if (str2 != null) {
            this.gdprPath = str2;
        }
        String str3 = adjustTestOptions.subscriptionPath;
        if (str3 != null) {
            this.subscriptionPath = str3;
        }
        String str4 = adjustTestOptions.baseUrl;
        if (str4 != null) {
            AdjustFactory.setBaseUrl(str4);
        }
        String str5 = adjustTestOptions.gdprUrl;
        if (str5 != null) {
            AdjustFactory.setGdprUrl(str5);
        }
        String str6 = adjustTestOptions.subscriptionUrl;
        if (str6 != null) {
            AdjustFactory.setSubscriptionUrl(str6);
        }
        Long l5 = adjustTestOptions.timerIntervalInMilliseconds;
        if (l5 != null) {
            AdjustFactory.setTimerInterval(l5.longValue());
        }
        if (adjustTestOptions.timerStartInMilliseconds != null) {
            AdjustFactory.setTimerStart(adjustTestOptions.timerIntervalInMilliseconds.longValue());
        }
        Long l6 = adjustTestOptions.sessionIntervalInMilliseconds;
        if (l6 != null) {
            AdjustFactory.setSessionInterval(l6.longValue());
        }
        Long l7 = adjustTestOptions.subsessionIntervalInMilliseconds;
        if (l7 != null) {
            AdjustFactory.setSubsessionInterval(l7.longValue());
        }
        Boolean bool = adjustTestOptions.tryInstallReferrer;
        if (bool != null) {
            AdjustFactory.setTryInstallReferrer(bool.booleanValue());
        }
        if (adjustTestOptions.noBackoffWait != null) {
            BackoffStrategy backoffStrategy = BackoffStrategy.NO_WAIT;
            AdjustFactory.setPackageHandlerBackoffStrategy(backoffStrategy);
            AdjustFactory.setSdkClickBackoffStrategy(backoffStrategy);
        }
        Boolean bool2 = adjustTestOptions.enableSigning;
        if (bool2 != null && bool2.booleanValue()) {
            AdjustFactory.enableSigning();
        }
        Boolean bool3 = adjustTestOptions.disableSigning;
        if (bool3 == null || !bool3.booleanValue()) {
            return;
        }
        AdjustFactory.disableSigning();
    }

    public void teardown() {
        if (checkActivityHandler("teardown")) {
            this.activityHandler.teardown();
            this.activityHandler = null;
        }
    }

    public void trackAdRevenue(AdjustAdRevenue adjustAdRevenue) {
        if (checkActivityHandler("trackAdRevenue")) {
            this.activityHandler.trackAdRevenue(adjustAdRevenue);
        }
    }

    public void trackEvent(AdjustEvent adjustEvent) {
        if (checkActivityHandler("trackEvent")) {
            this.activityHandler.trackEvent(adjustEvent);
        }
    }

    public void trackMeasurementConsent(boolean z5) {
        if (checkActivityHandler("measurement consent", true)) {
            this.activityHandler.trackMeasurementConsent(z5);
        } else {
            this.preLaunchActions.lastMeasurementConsentTracked = Boolean.valueOf(z5);
        }
    }

    public void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        if (checkActivityHandler("trackPlayStoreSubscription")) {
            this.activityHandler.trackPlayStoreSubscription(adjustPlayStoreSubscription);
        }
    }

    public void trackThirdPartySharing(AdjustThirdPartySharing adjustThirdPartySharing) {
        if (checkActivityHandler("third party sharing", true)) {
            this.activityHandler.trackThirdPartySharing(adjustThirdPartySharing);
        } else {
            this.preLaunchActions.preLaunchAdjustThirdPartySharingArray.add(adjustThirdPartySharing);
        }
    }

    private boolean checkActivityHandler(String str, boolean z5) {
        if (this.activityHandler != null) {
            return true;
        }
        if (str == null) {
            AdjustFactory.getLogger().error("Adjust not initialized correctly", new Object[0]);
            return false;
        }
        if (z5) {
            AdjustFactory.getLogger().warn("Adjust not initialized, but %s saved for launch", str);
        } else {
            AdjustFactory.getLogger().warn("Adjust not initialized, can't perform %s", str);
        }
        return false;
    }

    public void appWillOpenUrl(Uri uri, Context context) {
        if (uri == null || uri.toString().length() == 0) {
            AdjustFactory.getLogger().warn("Skipping deep link processing (null or empty)", new Object[0]);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (checkActivityHandler("appWillOpenUrl", true)) {
            this.activityHandler.readOpenUrl(uri, currentTimeMillis);
        } else {
            saveDeeplink(uri, currentTimeMillis, context);
        }
    }

    public void setPushToken(String str, Context context) {
        savePushToken(str, context);
        if (checkActivityHandler("push token", true) && this.activityHandler.isEnabled()) {
            this.activityHandler.setPushToken(str, true);
        }
    }

    public void trackAdRevenue(String str, JSONObject jSONObject) {
        if (checkActivityHandler("trackAdRevenue")) {
            this.activityHandler.trackAdRevenue(str, jSONObject);
        }
    }

    private boolean checkActivityHandler(boolean z5, String str, String str2) {
        return z5 ? checkActivityHandler(str, true) : checkActivityHandler(str2, true);
    }
}
