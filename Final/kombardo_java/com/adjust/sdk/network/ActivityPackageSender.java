package com.adjust.sdk.network;

import android.net.Uri;
import com.adjust.sdk.ActivityKind;
import com.adjust.sdk.ActivityPackage;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.Constants;
import com.adjust.sdk.ILogger;
import com.adjust.sdk.ResponseData;
import com.adjust.sdk.TrackingState;
import com.adjust.sdk.Util;
import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.network.UtilNetworking;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import org.conscrypt.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ActivityPackageSender implements IActivityPackageSender {
    private String basePath;
    private String clientSdk;
    private String gdprPath;
    private String subscriptionPath;
    private UrlStrategy urlStrategy;
    private ILogger logger = AdjustFactory.getLogger();
    private ThreadExecutor executor = new SingleThreadCachedScheduler("ActivityPackageSender");
    private UtilNetworking.IHttpsURLConnectionProvider httpsURLConnectionProvider = AdjustFactory.getHttpsURLConnectionProvider();
    private UtilNetworking.IConnectionOptions connectionOptions = AdjustFactory.getConnectionOptions();

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IActivityPackageSender.ResponseDataCallbackSubscriber f4207a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActivityPackage f4208b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f4209c;

        public a(IActivityPackageSender.ResponseDataCallbackSubscriber responseDataCallbackSubscriber, ActivityPackage activityPackage, Map map) {
            this.f4207a = responseDataCallbackSubscriber;
            this.f4208b = activityPackage;
            this.f4209c = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f4207a.onResponseDataCallback(ActivityPackageSender.this.sendActivityPackageSync(this.f4208b, this.f4209c));
        }
    }

    public ActivityPackageSender(String str, String str2, String str3, String str4, String str5) {
        this.basePath = str2;
        this.gdprPath = str3;
        this.subscriptionPath = str4;
        this.clientSdk = str5;
        this.urlStrategy = new UrlStrategy(AdjustFactory.getBaseUrl(), AdjustFactory.getGdprUrl(), AdjustFactory.getSubscriptionUrl(), str);
    }

    private String buildAndExtractAuthorizationHeader(Map<String, String> map, ActivityKind activityKind) {
        String activityKind2 = activityKind.toString();
        String extractSecretId = extractSecretId(map);
        String buildAuthorizationHeaderV2 = buildAuthorizationHeaderV2(extractSignature(map), extractSecretId, extractHeadersId(map), extractAlgorithm(map), extractNativeVersion(map));
        return buildAuthorizationHeaderV2 != null ? buildAuthorizationHeaderV2 : buildAuthorizationHeaderV1(map, extractAppSecret(map), extractSecretId, activityKind2);
    }

    private String buildAuthorizationHeaderV1(Map<String, String> map, String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Map<String, String> signature = getSignature(map, str3, str);
        String formatString = Util.formatString("Signature %s,%s,%s,%s", Util.formatString("secret_id=\"%s\"", str2), Util.formatString("signature=\"%s\"", Util.sha256(signature.get("clear_signature"))), Util.formatString("algorithm=\"%s\"", "sha256"), Util.formatString("headers=\"%s\"", signature.get("fields")));
        this.logger.verbose("authorizationHeader: %s", formatString);
        return formatString;
    }

    private String buildAuthorizationHeaderV2(String str, String str2, String str3, String str4, String str5) {
        if (str2 == null || str == null || str3 == null) {
            return null;
        }
        String formatString = Util.formatString("signature=\"%s\"", str);
        String formatString2 = Util.formatString("secret_id=\"%s\"", str2);
        String formatString3 = Util.formatString("headers_id=\"%s\"", str3);
        if (str4 == null) {
            str4 = "adj1";
        }
        String formatString4 = Util.formatString("algorithm=\"%s\"", str4);
        if (str5 == null) {
            str5 = BuildConfig.FLAVOR;
        }
        String formatString5 = Util.formatString("Signature %s,%s,%s,%s,%s", formatString, formatString2, formatString4, formatString3, Util.formatString("native_version=\"%s\"", str5));
        this.logger.verbose("authorizationHeader: %s", formatString5);
        return formatString5;
    }

    private DataOutputStream configConnectionForGET(HttpsURLConnection httpsURLConnection) {
        httpsURLConnection.setRequestMethod("GET");
        return null;
    }

    private DataOutputStream configConnectionForPOST(HttpsURLConnection httpsURLConnection, Map<String, String> map, Map<String, String> map2) {
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setDoOutput(true);
        String generatePOSTBodyString = generatePOSTBodyString(map, map2);
        if (generatePOSTBodyString == null) {
            return null;
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        dataOutputStream.writeBytes(generatePOSTBodyString);
        return dataOutputStream;
    }

    private String errorMessage(Throwable th, String str, ActivityPackage activityPackage) {
        return Util.formatString("%s. (%s)", activityPackage.getFailureMessage(), Util.getReasonString(str, th));
    }

    private static String extractAlgorithm(Map<String, String> map) {
        return map.remove("algorithm");
    }

    private static String extractAppSecret(Map<String, String> map) {
        return map.remove("app_secret");
    }

    private static void extractEventCallbackId(Map<String, String> map) {
        map.remove("event_callback_id");
    }

    private static String extractHeadersId(Map<String, String> map) {
        return map.remove("headers_id");
    }

    private static String extractNativeVersion(Map<String, String> map) {
        return map.remove("native_version");
    }

    private static String extractSecretId(Map<String, String> map) {
        return map.remove("secret_id");
    }

    private static String extractSignature(Map<String, String> map) {
        return map.remove("signature");
    }

    private String generatePOSTBodyString(Map<String, String> map, Map<String, String> map2) {
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        injectParametersToPOSTStringBuilder(map, sb);
        injectParametersToPOSTStringBuilder(map2, sb);
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '&') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private String generateUrlStringForGET(ActivityKind activityKind, String str, Map<String, String> map, Map<String, String> map2) {
        URL url = new URL(urlWithExtraPathByActivityKind(activityKind, this.urlStrategy.targetUrlByActivityKind(activityKind)));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(url.getProtocol());
        builder.encodedAuthority(url.getAuthority());
        builder.path(url.getPath());
        builder.appendPath(str);
        this.logger.debug("Making request to url: %s", builder.toString());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        if (map2 != null) {
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                builder.appendQueryParameter(entry2.getKey(), entry2.getValue());
            }
        }
        return builder.build().toString();
    }

    private String generateUrlStringForPOST(ActivityKind activityKind, String str) {
        String formatString = Util.formatString("%s%s", urlWithExtraPathByActivityKind(activityKind, this.urlStrategy.targetUrlByActivityKind(activityKind)), str);
        this.logger.debug("Making request to url : %s", formatString);
        return formatString;
    }

    private Map<String, String> getSignature(Map<String, String> map, String str, String str2) {
        String str3 = map.get("created_at");
        String validIdentifier = getValidIdentifier(map);
        String str4 = map.get(validIdentifier);
        String str5 = map.get("source");
        String str6 = map.get("payload");
        HashMap hashMap = new HashMap();
        hashMap.put("app_secret", str2);
        hashMap.put("created_at", str3);
        hashMap.put("activity_kind", str);
        hashMap.put(validIdentifier, str4);
        if (str5 != null) {
            hashMap.put("source", str5);
        }
        if (str6 != null) {
            hashMap.put("payload", str6);
        }
        String str7 = BuildConfig.FLAVOR;
        String str8 = BuildConfig.FLAVOR;
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry.getValue() != null) {
                str7 = str7 + ((String) entry.getKey()) + " ";
                str8 = str8 + ((String) entry.getValue());
            }
        }
        String substring = str7.substring(0, str7.length() - 1);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("clear_signature", str8);
        hashMap2.put("fields", substring);
        return hashMap2;
    }

    private String getValidIdentifier(Map<String, String> map) {
        if (map.get("gps_adid") != null) {
            return "gps_adid";
        }
        if (map.get("fire_adid") != null) {
            return "fire_adid";
        }
        if (map.get("android_id") != null) {
            return "android_id";
        }
        if (map.get("android_uuid") != null) {
            return "android_uuid";
        }
        return null;
    }

    private void injectParametersToPOSTStringBuilder(Map<String, String> map, StringBuilder sb) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String encode = URLEncoder.encode(entry.getKey(), Constants.ENCODING);
            String value = entry.getValue();
            String encode2 = value != null ? URLEncoder.encode(value, Constants.ENCODING) : BuildConfig.FLAVOR;
            sb.append(encode);
            sb.append("=");
            sb.append(encode2);
            sb.append("&");
        }
    }

    private void localError(Throwable th, String str, ResponseData responseData) {
        String errorMessage = errorMessage(th, str, responseData.activityPackage);
        this.logger.error(errorMessage, new Object[0]);
        responseData.message = errorMessage;
        responseData.willRetry = false;
    }

    private void parseResponse(ResponseData responseData, String str) {
        JSONObject jSONObject;
        if (str.length() == 0) {
            this.logger.error("Empty response string", new Object[0]);
            return;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e5) {
            this.logger.error(errorMessage(e5, "Failed to parse JSON response", responseData.activityPackage), new Object[0]);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        responseData.jsonResponse = jSONObject;
        responseData.message = UtilNetworking.extractJsonString(jSONObject, "message");
        responseData.adid = UtilNetworking.extractJsonString(jSONObject, "adid");
        responseData.timestamp = UtilNetworking.extractJsonString(jSONObject, "timestamp");
        String extractJsonString = UtilNetworking.extractJsonString(jSONObject, "tracking_state");
        if (extractJsonString != null && extractJsonString.equals("opted_out")) {
            responseData.trackingState = TrackingState.OPTED_OUT;
        }
        responseData.askIn = UtilNetworking.extractJsonLong(jSONObject, "ask_in");
        responseData.retryIn = UtilNetworking.extractJsonLong(jSONObject, "retry_in");
        responseData.continueIn = UtilNetworking.extractJsonLong(jSONObject, "continue_in");
        responseData.attribution = AdjustAttribution.fromJson(jSONObject.optJSONObject("attribution"), responseData.adid, Util.getSdkPrefixPlatform(this.clientSdk));
    }

    private void remoteError(Throwable th, String str, ResponseData responseData) {
        String str2 = errorMessage(th, str, responseData.activityPackage) + " Will retry later";
        this.logger.error(str2, new Object[0]);
        responseData.message = str2;
        responseData.willRetry = true;
    }

    private boolean shouldRetryToSend(ResponseData responseData) {
        if (!responseData.willRetry) {
            this.logger.debug("Will not retry with current url strategy", new Object[0]);
            this.urlStrategy.resetAfterSuccess();
            return false;
        }
        if (this.urlStrategy.shouldRetryAfterFailure(responseData.activityKind)) {
            this.logger.error("Failed with current url strategy, but it will retry with new", new Object[0]);
            return true;
        }
        this.logger.error("Failed with current url strategy and it will not retry", new Object[0]);
        return false;
    }

    private void tryToGetResponse(ResponseData responseData) {
        String generateUrlStringForPOST;
        DataOutputStream dataOutputStream = null;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    ActivityPackage activityPackage = responseData.activityPackage;
                                    HashMap hashMap = new HashMap(activityPackage.getParameters());
                                    Map<String, String> map = responseData.sendingParameters;
                                    String buildAndExtractAuthorizationHeader = buildAndExtractAuthorizationHeader(hashMap, activityPackage.getActivityKind());
                                    boolean z5 = true;
                                    boolean z6 = responseData.activityPackage.getActivityKind() == ActivityKind.ATTRIBUTION;
                                    if (z6) {
                                        extractEventCallbackId(hashMap);
                                        generateUrlStringForPOST = generateUrlStringForGET(activityPackage.getActivityKind(), activityPackage.getPath(), hashMap, map);
                                    } else {
                                        generateUrlStringForPOST = generateUrlStringForPOST(activityPackage.getActivityKind(), activityPackage.getPath());
                                    }
                                    HttpsURLConnection generateHttpsURLConnection = this.httpsURLConnectionProvider.generateHttpsURLConnection(new URL(generateUrlStringForPOST));
                                    this.connectionOptions.applyConnectionOptions(generateHttpsURLConnection, activityPackage.getClientSdk());
                                    if (buildAndExtractAuthorizationHeader != null) {
                                        generateHttpsURLConnection.setRequestProperty("Authorization", buildAndExtractAuthorizationHeader);
                                    }
                                    if (z6) {
                                        dataOutputStream = configConnectionForGET(generateHttpsURLConnection);
                                    } else {
                                        extractEventCallbackId(hashMap);
                                        dataOutputStream = configConnectionForPOST(generateHttpsURLConnection, hashMap, map);
                                    }
                                    Integer readConnectionResponse = readConnectionResponse(generateHttpsURLConnection, responseData);
                                    responseData.success = responseData.jsonResponse != null && responseData.retryIn == null && readConnectionResponse != null && readConnectionResponse.intValue() == 200;
                                    if (responseData.jsonResponse != null && responseData.retryIn == null) {
                                        z5 = false;
                                    }
                                    responseData.willRetry = z5;
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.flush();
                                            dataOutputStream.close();
                                        } catch (IOException e5) {
                                            this.logger.error(errorMessage(e5, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                                        }
                                    }
                                } catch (Throwable th) {
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.flush();
                                            dataOutputStream.close();
                                        } catch (IOException e6) {
                                            this.logger.error(errorMessage(e6, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (ProtocolException e7) {
                                localError(e7, "Protocol Error", responseData);
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.flush();
                                        dataOutputStream.close();
                                    } catch (IOException e8) {
                                        this.logger.error(errorMessage(e8, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                                    }
                                }
                            }
                        } catch (UnsupportedEncodingException e9) {
                            localError(e9, "Failed to encode parameters", responseData);
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.flush();
                                    dataOutputStream.close();
                                } catch (IOException e10) {
                                    this.logger.error(errorMessage(e10, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        localError(th2, "Sending SDK package", responseData);
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.flush();
                                dataOutputStream.close();
                            } catch (IOException e11) {
                                this.logger.error(errorMessage(e11, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                            }
                        }
                    }
                } catch (SSLHandshakeException e12) {
                    remoteError(e12, "Certificate failed", responseData);
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.flush();
                            dataOutputStream.close();
                        } catch (IOException e13) {
                            this.logger.error(errorMessage(e13, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                        }
                    }
                }
            } catch (IOException e14) {
                remoteError(e14, "Request failed", responseData);
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.flush();
                        dataOutputStream.close();
                    } catch (IOException e15) {
                        this.logger.error(errorMessage(e15, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                    }
                }
            }
        } catch (MalformedURLException e16) {
            localError(e16, "Malformed URL", responseData);
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } catch (IOException e17) {
                    this.logger.error(errorMessage(e17, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        } catch (SocketTimeoutException e18) {
            remoteError(e18, "Request timed out", responseData);
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } catch (IOException e19) {
                    this.logger.error(errorMessage(e19, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
        }
    }

    private String urlWithExtraPathByActivityKind(ActivityKind activityKind, String str) {
        if (activityKind == ActivityKind.GDPR) {
            if (this.gdprPath == null) {
                return str;
            }
            return str + this.gdprPath;
        }
        if (activityKind == ActivityKind.SUBSCRIPTION) {
            if (this.subscriptionPath == null) {
                return str;
            }
            return str + this.subscriptionPath;
        }
        if (this.basePath == null) {
            return str;
        }
        return str + this.basePath;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0047, code lost:
    
        if (r7 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Integer readConnectionResponse(HttpsURLConnection httpsURLConnection, ResponseData responseData) {
        StringBuilder sb = new StringBuilder();
        Integer num = null;
        try {
            try {
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                num = Integer.valueOf(responseCode);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(responseCode >= 400 ? httpsURLConnection.getErrorStream() : httpsURLConnection.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
            } catch (IOException e5) {
                this.logger.error(errorMessage(e5, "Connecting and reading response", responseData.activityPackage), new Object[0]);
            }
            httpsURLConnection.disconnect();
            if (sb.length() == 0) {
                this.logger.error("Empty response string buffer", new Object[0]);
                return num;
            }
            if (num.intValue() == 429) {
                this.logger.error("Too frequent requests to the endpoint (429)", new Object[0]);
                return num;
            }
            String sb2 = sb.toString();
            this.logger.debug("Response string: %s", sb2);
            parseResponse(responseData, sb2);
            String str = responseData.message;
            if (str == null) {
                return num;
            }
            if (num.intValue() == 200) {
                this.logger.info("Response message: %s", str);
            } else {
                this.logger.error("Response message: %s", str);
            }
            return num;
        } catch (Throwable th) {
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            throw th;
        }
    }

    @Override // com.adjust.sdk.network.IActivityPackageSender
    public void sendActivityPackage(ActivityPackage activityPackage, Map<String, String> map, IActivityPackageSender.ResponseDataCallbackSubscriber responseDataCallbackSubscriber) {
        this.executor.submit(new a(responseDataCallbackSubscriber, activityPackage, map));
    }

    @Override // com.adjust.sdk.network.IActivityPackageSender
    public ResponseData sendActivityPackageSync(ActivityPackage activityPackage, Map<String, String> map) {
        ResponseData buildResponseData;
        do {
            buildResponseData = ResponseData.buildResponseData(activityPackage, map);
            tryToGetResponse(buildResponseData);
        } while (shouldRetryToSend(buildResponseData));
        return buildResponseData;
    }
}
