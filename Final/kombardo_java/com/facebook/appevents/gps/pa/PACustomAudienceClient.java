package com.facebook.appevents.gps.pa;

import android.adservices.common.AdData;
import android.adservices.common.AdSelectionSignals;
import android.adservices.common.AdTechIdentifier;
import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.CustomAudienceManager;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import android.annotation.TargetApi;
import android.net.Uri;
import android.os.OutcomeReceiver;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import z.AbstractC0869a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/appevents/gps/pa/PACustomAudienceClient;", BuildConfig.FLAVOR, "()V", "BASE_URI", BuildConfig.FLAVOR, "BUYER", "DELIMITER", "REPLACEMENT_STRING", "TAG", "customAudienceManager", "Landroid/adservices/customaudience/CustomAudienceManager;", "enabled", BuildConfig.FLAVOR, "enable", BuildConfig.FLAVOR, "joinCustomAudience", "appId", "event", "Lcom/facebook/appevents/AppEvent;", "validateAndCreateCAName", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class PACustomAudienceClient {
    private static final String BASE_URI = "https://www.facebook.com/privacy_sandbox/pa/logic";
    private static final String BUYER = "facebook.com";
    private static final String DELIMITER = "@";
    private static final String REPLACEMENT_STRING = "_removed_";
    private static CustomAudienceManager customAudienceManager;
    private static boolean enabled;
    public static final PACustomAudienceClient INSTANCE = new PACustomAudienceClient();
    private static final String TAG = Intrinsics.stringPlus("Fledge: ", PACustomAudienceClient.class.getSimpleName());

    private PACustomAudienceClient() {
    }

    public static final /* synthetic */ String access$getTAG$p() {
        if (CrashShieldHandler.isObjectCrashing(PACustomAudienceClient.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PACustomAudienceClient.class);
            return null;
        }
    }

    @TargetApi(34)
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(PACustomAudienceClient.class)) {
            return;
        }
        try {
            try {
                try {
                    CustomAudienceManager.get(FacebookSdk.getApplicationContext());
                } catch (Exception e5) {
                    Log.w(TAG, Intrinsics.stringPlus("Failed to get CustomAudienceManager: ", e5.getMessage()));
                }
            } catch (NoClassDefFoundError e6) {
                Log.w(TAG, Intrinsics.stringPlus("Failed to get CustomAudienceManager: ", e6.getMessage()));
            } catch (NoSuchMethodError e7) {
                Log.w(TAG, Intrinsics.stringPlus("Failed to get CustomAudienceManager: ", e7.getMessage()));
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, PACustomAudienceClient.class);
        }
    }

    private final String validateAndCreateCAName(String appId, AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Object obj = event.getJsonObject().get("_eventName");
            if (Intrinsics.areEqual(obj, REPLACEMENT_STRING)) {
                return null;
            }
            return appId + '@' + obj;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @TargetApi(34)
    public final void joinCustomAudience(String appId, AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(event, "event");
            if (enabled) {
                AbstractC0869a.a(new OutcomeReceiver() { // from class: com.facebook.appevents.gps.pa.PACustomAudienceClient$joinCustomAudience$callback$1
                    public void onResult(Object result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        Log.i(PACustomAudienceClient.access$getTAG$p(), "Successfully joined custom audience");
                    }

                    public void onError(Exception error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        Log.e(PACustomAudienceClient.access$getTAG$p(), error.toString());
                    }
                });
                try {
                    String validateAndCreateCAName = validateAndCreateCAName(appId, event);
                    if (validateAndCreateCAName == null) {
                        return;
                    }
                    new AdData.Builder().setRenderUri(Uri.parse("https://www.facebook.com/privacy_sandbox/pa/logic/ad")).setMetadata("{'isRealAd': false}").build();
                    new TrustedBiddingData.Builder().setTrustedBiddingUri(Uri.parse("https://www.facebook.com/privacy_sandbox/pa/logic?trusted_bidding")).setTrustedBiddingKeys(CollectionsKt.listOf(BuildConfig.FLAVOR)).build();
                    CustomAudience.Builder name = new CustomAudience.Builder().setName(validateAndCreateCAName);
                    AdTechIdentifier.fromString(BUYER);
                    CustomAudience.Builder trustedBiddingData = name.setBuyer(null).setDailyUpdateUri(Uri.parse("https://www.facebook.com/privacy_sandbox/pa/logic?daily")).setBiddingLogicUri(Uri.parse("https://www.facebook.com/privacy_sandbox/pa/logic?bidding")).setTrustedBiddingData(null);
                    AdSelectionSignals.fromString("{}");
                    trustedBiddingData.setUserBiddingSignals(null).setAds(CollectionsKt.listOf((Object) null)).build();
                    Intrinsics.checkNotNullExpressionValue(null, "Builder()\n                    .setName(caName)\n                    .setBuyer(AdTechIdentifier.fromString(BUYER))\n                    .setDailyUpdateUri(Uri.parse(\"$BASE_URI?daily\"))\n                    .setBiddingLogicUri(Uri.parse(\"$BASE_URI?bidding\"))\n                    .setTrustedBiddingData(trustedBiddingData)\n                    .setUserBiddingSignals(AdSelectionSignals.fromString(\"{}\"))\n                    .setAds(listOf(dummyAd)).build()");
                    new JoinCustomAudienceRequest.Builder().setCustomAudience(null).build();
                    Intrinsics.checkNotNullExpressionValue(null, "Builder().setCustomAudience(ca).build()");
                } catch (Exception e5) {
                    Log.w(TAG, Intrinsics.stringPlus("Failed to join Custom Audience: ", e5.getMessage()));
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
