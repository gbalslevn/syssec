package com.google.firebase.crashlytics.internal.settings;

import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class DefaultSettingsSpiCall implements SettingsSpiCall {
    private final Logger logger;
    private final HttpRequestFactory requestFactory;
    private final String url;

    public DefaultSettingsSpiCall(String str, HttpRequestFactory httpRequestFactory) {
        this(str, httpRequestFactory, Logger.getLogger());
    }

    private HttpGetRequest applyHeadersTo(HttpGetRequest httpGetRequest, SettingsRequest settingsRequest) {
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-GOOGLE-APP-ID", settingsRequest.googleAppId);
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", CrashlyticsCore.getVersion());
        applyNonNullHeader(httpGetRequest, "Accept", "application/json");
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-DEVICE-MODEL", settingsRequest.deviceModel);
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", settingsRequest.osBuildVersion);
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", settingsRequest.osDisplayVersion);
        applyNonNullHeader(httpGetRequest, "X-CRASHLYTICS-INSTALLATION-ID", settingsRequest.installIdProvider.getInstallIds().getCrashlyticsInstallId());
        return httpGetRequest;
    }

    private void applyNonNullHeader(HttpGetRequest httpGetRequest, String str, String str2) {
        if (str2 != null) {
            httpGetRequest.header(str, str2);
        }
    }

    private JSONObject getJsonObjectFrom(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e5) {
            this.logger.w("Failed to parse settings JSON from " + this.url, e5);
            this.logger.w("Settings response " + str);
            return null;
        }
    }

    private Map<String, String> getQueryParamsFor(SettingsRequest settingsRequest) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", settingsRequest.buildVersion);
        hashMap.put("display_version", settingsRequest.displayVersion);
        hashMap.put("source", Integer.toString(settingsRequest.source));
        String str = settingsRequest.instanceId;
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    protected HttpGetRequest createHttpGetRequest(Map<String, String> map) {
        return this.requestFactory.buildHttpGetRequest(this.url, map).header("User-Agent", "Crashlytics Android SDK/" + CrashlyticsCore.getVersion()).header("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    JSONObject handleResponse(HttpResponse httpResponse) {
        int code = httpResponse.code();
        this.logger.v("Settings response code was: " + code);
        if (requestWasSuccessful(code)) {
            return getJsonObjectFrom(httpResponse.body());
        }
        this.logger.e("Settings request failed; (status: " + code + ") from " + this.url);
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsSpiCall
    public JSONObject invoke(SettingsRequest settingsRequest, boolean z5) {
        CrashlyticsWorkers.checkBlockingThread();
        if (!z5) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        try {
            Map<String, String> queryParamsFor = getQueryParamsFor(settingsRequest);
            HttpGetRequest applyHeadersTo = applyHeadersTo(createHttpGetRequest(queryParamsFor), settingsRequest);
            this.logger.d("Requesting settings from " + this.url);
            this.logger.v("Settings query params were: " + queryParamsFor);
            return handleResponse(applyHeadersTo.execute());
        } catch (IOException e5) {
            this.logger.e("Settings request failed.", e5);
            return null;
        }
    }

    boolean requestWasSuccessful(int i5) {
        return i5 == 200 || i5 == 201 || i5 == 202 || i5 == 203;
    }

    DefaultSettingsSpiCall(String str, HttpRequestFactory httpRequestFactory, Logger logger) {
        if (str != null) {
            this.logger = logger;
            this.requestFactory = httpRequestFactory;
            this.url = str;
            return;
        }
        throw new IllegalArgumentException("url must not be null.");
    }
}
