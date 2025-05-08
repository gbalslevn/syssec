package com.facebook.appevents.integrity;

import com.facebook.FacebookSdk;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J#\u0010\t\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/facebook/appevents/integrity/IntegrityManager;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "enable", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "parameters", "processParameters", "(Ljava/util/Map;)V", "input", BuildConfig.FLAVOR, "shouldFilter", "(Ljava/lang/String;)Z", "textFeature", "getIntegrityPredictionResult", "(Ljava/lang/String;)Ljava/lang/String;", "RESTRICTIVE_ON_DEVICE_PARAMS_KEY", "Ljava/lang/String;", "enabled", "Z", "isSampleEnabled", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class IntegrityManager {
    public static final IntegrityManager INSTANCE = new IntegrityManager();
    private static final String RESTRICTIVE_ON_DEVICE_PARAMS_KEY = "_onDeviceParams";
    private static boolean enabled;
    private static boolean isSampleEnabled;

    private IntegrityManager() {
    }

    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(IntegrityManager.class)) {
            return;
        }
        try {
            enabled = true;
            FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
            isSampleEnabled = FetchedAppGateKeepersManager.getGateKeeperForKey("FBSDKFeatureIntegritySample", FacebookSdk.getApplicationId(), false);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, IntegrityManager.class);
        }
    }

    private final String getIntegrityPredictionResult(String textFeature) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            for (int i5 = 0; i5 < 30; i5++) {
                fArr[i5] = 0.0f;
            }
            ModelManager modelManager = ModelManager.INSTANCE;
            String[] predict = ModelManager.predict(ModelManager.Task.MTML_INTEGRITY_DETECT, new float[][]{fArr}, new String[]{textFeature});
            if (predict == null) {
                return "none";
            }
            String str = predict[0];
            return str == null ? "none" : str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final void processParameters(Map<String, String> parameters) {
        if (CrashShieldHandler.isObjectCrashing(IntegrityManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            if (enabled && !parameters.isEmpty()) {
                try {
                    List<String> list = CollectionsKt.toList(parameters.keySet());
                    JSONObject jSONObject = new JSONObject();
                    for (String str : list) {
                        String str2 = parameters.get(str);
                        if (str2 == null) {
                            throw new IllegalStateException("Required value was null.");
                        }
                        String str3 = str2;
                        IntegrityManager integrityManager = INSTANCE;
                        if (!integrityManager.shouldFilter(str) && !integrityManager.shouldFilter(str3)) {
                        }
                        parameters.remove(str);
                        if (!isSampleEnabled) {
                            str3 = BuildConfig.FLAVOR;
                        }
                        jSONObject.put(str, str3);
                    }
                    if (jSONObject.length() == 0) {
                        return;
                    }
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "restrictiveParamJson.toString()");
                    parameters.put(RESTRICTIVE_ON_DEVICE_PARAMS_KEY, jSONObject2);
                } catch (Exception unused) {
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, IntegrityManager.class);
        }
    }

    private final boolean shouldFilter(String input) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return !Intrinsics.areEqual("none", getIntegrityPredictionResult(input));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
