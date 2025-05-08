package com.facebook.appevents.cloudbridge;

import com.adjust.sdk.Constants;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001DB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0011\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0010\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J=\u0010\u0019\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0018\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00100\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001d\u001a\u00020\b2\u001a\u0010\u001a\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0010\u0018\u00010\u000fH\u0000¢\u0006\u0004\b\u001b\u0010\u001cJi\u0010'\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00102\b\b\u0002\u0010\"\u001a\u00020\u00132\u001e\u0010$\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\b\u0018\u00010#H\u0000¢\u0006\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010+R$\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00130-j\b\u0012\u0004\u0012\u00020\u0013`.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u00130-j\b\u0012\u0004\u0012\u00020\u0013`.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00100R\"\u00103\u001a\u0002028\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R4\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0010098\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010\u001cR\"\u0010?\u001a\u00020\u00138\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b?\u0010+\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "datasetID", "url", "accessKey", BuildConfig.FLAVOR, "configure", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/facebook/GraphRequest;", "request", "transformGraphRequestAndSendToCAPIGEndPoint", "(Lcom/facebook/GraphRequest;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "transformAppEventRequestForCAPIG", "(Lcom/facebook/GraphRequest;)Ljava/util/List;", BuildConfig.FLAVOR, "responseCode", "processedEvents", "maxRetryCount", "handleError$facebook_core_release", "(Ljava/lang/Integer;Ljava/util/List;I)V", "handleError", "events", "appendEvents$facebook_core_release", "(Ljava/util/List;)V", "appendEvents", "urlStr", "requestMethod", "jsonBodyStr", "requestProperties", "timeOutInterval", "Lkotlin/Function2;", "requestCallback", "makeHttpRequest$facebook_core_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILkotlin/jvm/functions/Function2;)V", "makeHttpRequest", "TAG", "Ljava/lang/String;", "MAX_PROCESSED_TRANSFORMED_EVENTS", "I", "TIMEOUT_INTERVAL", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "ACCEPTABLE_HTTP_RESPONSE", "Ljava/util/HashSet;", "RETRY_EVENTS_HTTP_RESPONSE", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "credentials", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "getCredentials$facebook_core_release", "()Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "setCredentials$facebook_core_release", "(Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;)V", BuildConfig.FLAVOR, "transformedEvents", "Ljava/util/List;", "getTransformedEvents$facebook_core_release", "()Ljava/util/List;", "setTransformedEvents$facebook_core_release", "currentRetryCount", "getCurrentRetryCount$facebook_core_release", "()I", "setCurrentRetryCount$facebook_core_release", "(I)V", "CloudBridgeCredentials", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AppEventsConversionsAPITransformerWebRequests {
    private static final int MAX_PROCESSED_TRANSFORMED_EVENTS = 10;
    private static final String TAG = "CAPITransformerWebRequests";
    private static final int TIMEOUT_INTERVAL = 60000;
    public static CloudBridgeCredentials credentials;
    private static int currentRetryCount;
    public static List<Map<String, Object>> transformedEvents;
    public static final AppEventsConversionsAPITransformerWebRequests INSTANCE = new AppEventsConversionsAPITransformerWebRequests();
    private static final HashSet<Integer> ACCEPTABLE_HTTP_RESPONSE = SetsKt.hashSetOf(200, 202);
    private static final HashSet<Integer> RETRY_EVENTS_HTTP_RESPONSE = SetsKt.hashSetOf(503, 504, 429);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "datasetID", "cloudBridgeURL", "accessKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDatasetID", "getCloudBridgeURL", "getAccessKey", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* data */ class CloudBridgeCredentials {
        private final String accessKey;
        private final String cloudBridgeURL;
        private final String datasetID;

        public CloudBridgeCredentials(String datasetID, String cloudBridgeURL, String accessKey) {
            Intrinsics.checkNotNullParameter(datasetID, "datasetID");
            Intrinsics.checkNotNullParameter(cloudBridgeURL, "cloudBridgeURL");
            Intrinsics.checkNotNullParameter(accessKey, "accessKey");
            this.datasetID = datasetID;
            this.cloudBridgeURL = cloudBridgeURL;
            this.accessKey = accessKey;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CloudBridgeCredentials)) {
                return false;
            }
            CloudBridgeCredentials cloudBridgeCredentials = (CloudBridgeCredentials) other;
            return Intrinsics.areEqual(this.datasetID, cloudBridgeCredentials.datasetID) && Intrinsics.areEqual(this.cloudBridgeURL, cloudBridgeCredentials.cloudBridgeURL) && Intrinsics.areEqual(this.accessKey, cloudBridgeCredentials.accessKey);
        }

        public final String getAccessKey() {
            return this.accessKey;
        }

        public final String getCloudBridgeURL() {
            return this.cloudBridgeURL;
        }

        public final String getDatasetID() {
            return this.datasetID;
        }

        public int hashCode() {
            return (((this.datasetID.hashCode() * 31) + this.cloudBridgeURL.hashCode()) * 31) + this.accessKey.hashCode();
        }

        public String toString() {
            return "CloudBridgeCredentials(datasetID=" + this.datasetID + ", cloudBridgeURL=" + this.cloudBridgeURL + ", accessKey=" + this.accessKey + ')';
        }
    }

    private AppEventsConversionsAPITransformerWebRequests() {
    }

    public static final void configure(String datasetID, String url, String accessKey) {
        Intrinsics.checkNotNullParameter(datasetID, "datasetID");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, TAG, " \n\nCloudbridge Configured: \n================\ndatasetID: %s\nurl: %s\naccessKey: %s\n\n", datasetID, url, accessKey);
        AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = INSTANCE;
        appEventsConversionsAPITransformerWebRequests.setCredentials$facebook_core_release(new CloudBridgeCredentials(datasetID, url, accessKey));
        appEventsConversionsAPITransformerWebRequests.setTransformedEvents$facebook_core_release(new ArrayList());
    }

    private final List<Map<String, Object>> transformAppEventRequestForCAPIG(GraphRequest request) {
        JSONObject graphObject = request.getGraphObject();
        if (graphObject == null) {
            return null;
        }
        Map<String, ? extends Object> mutableMap = MapsKt.toMutableMap(Utility.convertJSONObjectToHashMap(graphObject));
        Object tag = request.getTag();
        if (tag == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
        }
        mutableMap.put("custom_events", tag);
        StringBuilder sb = new StringBuilder();
        for (String str : mutableMap.keySet()) {
            sb.append(str);
            sb.append(" : ");
            sb.append(mutableMap.get(str));
            sb.append(System.getProperty("line.separator"));
        }
        Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, TAG, "\nGraph Request data: \n\n%s \n\n", sb);
        return AppEventsConversionsAPITransformer.INSTANCE.conversionsAPICompatibleEvent$facebook_core_release(mutableMap);
    }

    public static final void transformGraphRequestAndSendToCAPIGEndPoint(final GraphRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Utility utility = Utility.INSTANCE;
        Utility.runOnNonUiThread(new Runnable() { // from class: g0.b
            @Override // java.lang.Runnable
            public final void run() {
                AppEventsConversionsAPITransformerWebRequests.m2816transformGraphRequestAndSendToCAPIGEndPoint$lambda0(GraphRequest.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: transformGraphRequestAndSendToCAPIGEndPoint$lambda-0, reason: not valid java name */
    public static final void m2816transformGraphRequestAndSendToCAPIGEndPoint$lambda0(GraphRequest request) {
        Intrinsics.checkNotNullParameter(request, "$request");
        String graphPath = request.getGraphPath();
        List split$default = graphPath == null ? null : StringsKt.split$default((CharSequence) graphPath, new String[]{"/"}, false, 0, 6, (Object) null);
        if (split$default == null || split$default.size() != 2) {
            Logger.INSTANCE.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "\n GraphPathComponents Error when logging: \n%s", request);
            return;
        }
        try {
            AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = INSTANCE;
            String str = appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getCloudBridgeURL() + "/capi/" + appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getDatasetID() + "/events";
            List<Map<String, Object>> transformAppEventRequestForCAPIG = appEventsConversionsAPITransformerWebRequests.transformAppEventRequestForCAPIG(request);
            if (transformAppEventRequestForCAPIG == null) {
                return;
            }
            appEventsConversionsAPITransformerWebRequests.appendEvents$facebook_core_release(transformAppEventRequestForCAPIG);
            int min = Math.min(appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().size(), 10);
            List slice = CollectionsKt.slice(appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release(), new IntRange(0, min - 1));
            appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().subList(0, min).clear();
            JSONArray jSONArray = new JSONArray((Collection) slice);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("data", jSONArray);
            linkedHashMap.put("accessKey", appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getAccessKey());
            JSONObject jSONObject = new JSONObject(linkedHashMap);
            Logger.Companion companion = Logger.INSTANCE;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String jSONObject2 = jSONObject.toString(2);
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonBodyStr.toString(2)");
            companion.log(loggingBehavior, TAG, "\nTransformed_CAPI_JSON:\nURL: %s\nFROM=========\n%s\n>>>>>>TO>>>>>>\n%s\n=============\n", str, request, jSONObject2);
            appEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(str, "POST", jSONObject.toString(), MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json")), 60000, new AppEventsConversionsAPITransformerWebRequests$transformGraphRequestAndSendToCAPIGEndPoint$1$1(slice));
        } catch (UninitializedPropertyAccessException e5) {
            Logger.INSTANCE.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "\n Credentials not initialized Error when logging: \n%s", e5);
        }
    }

    public final void appendEvents$facebook_core_release(List<? extends Map<String, ? extends Object>> events) {
        if (events != null) {
            getTransformedEvents$facebook_core_release().addAll(events);
        }
        int max = Math.max(0, getTransformedEvents$facebook_core_release().size() - 1000);
        if (max > 0) {
            setTransformedEvents$facebook_core_release(TypeIntrinsics.asMutableList(CollectionsKt.drop(getTransformedEvents$facebook_core_release(), max)));
        }
    }

    public final CloudBridgeCredentials getCredentials$facebook_core_release() {
        CloudBridgeCredentials cloudBridgeCredentials = credentials;
        if (cloudBridgeCredentials != null) {
            return cloudBridgeCredentials;
        }
        Intrinsics.throwUninitializedPropertyAccessException("credentials");
        throw null;
    }

    public final List<Map<String, Object>> getTransformedEvents$facebook_core_release() {
        List<Map<String, Object>> list = transformedEvents;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("transformedEvents");
        throw null;
    }

    public final void handleError$facebook_core_release(Integer responseCode, List<? extends Map<String, ? extends Object>> processedEvents, int maxRetryCount) {
        Intrinsics.checkNotNullParameter(processedEvents, "processedEvents");
        if (CollectionsKt.contains(RETRY_EVENTS_HTTP_RESPONSE, responseCode)) {
            if (currentRetryCount >= maxRetryCount) {
                getTransformedEvents$facebook_core_release().clear();
                currentRetryCount = 0;
            } else {
                getTransformedEvents$facebook_core_release().addAll(0, processedEvents);
                currentRetryCount++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a3 A[Catch: IOException -> 0x0047, UnknownHostException -> 0x004a, TRY_LEAVE, TryCatch #4 {UnknownHostException -> 0x004a, IOException -> 0x0047, blocks: (B:3:0x0011, B:5:0x001c, B:8:0x004d, B:10:0x0059, B:14:0x0069, B:16:0x00a3, B:23:0x00bf, B:31:0x00c5, B:32:0x00c8, B:34:0x00c9, B:36:0x00e9, B:40:0x0024, B:43:0x002b, B:44:0x0031, B:46:0x0037, B:48:0x00f5, B:49:0x00fc), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e9 A[Catch: IOException -> 0x0047, UnknownHostException -> 0x004a, TryCatch #4 {UnknownHostException -> 0x004a, IOException -> 0x0047, blocks: (B:3:0x0011, B:5:0x001c, B:8:0x004d, B:10:0x0059, B:14:0x0069, B:16:0x00a3, B:23:0x00bf, B:31:0x00c5, B:32:0x00c8, B:34:0x00c9, B:36:0x00e9, B:40:0x0024, B:43:0x002b, B:44:0x0031, B:46:0x0037, B:48:0x00f5, B:49:0x00fc), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void makeHttpRequest$facebook_core_release(String urlStr, String requestMethod, String jsonBodyStr, Map<String, String> requestProperties, int timeOutInterval, Function2<? super String, ? super Integer, Unit> requestCallback) {
        Set<String> keySet;
        boolean z5;
        Intrinsics.checkNotNullParameter(urlStr, "urlStr");
        Intrinsics.checkNotNullParameter(requestMethod, "requestMethod");
        try {
            URLConnection openConnection = new URL(urlStr).openConnection();
            if (openConnection == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestMethod(requestMethod);
            if (requestProperties != null && (keySet = requestProperties.keySet()) != null) {
                for (String str : keySet) {
                    httpURLConnection.setRequestProperty(str, requestProperties.get(str));
                }
            }
            if (!httpURLConnection.getRequestMethod().equals("POST") && !httpURLConnection.getRequestMethod().equals("PUT")) {
                z5 = false;
                httpURLConnection.setDoOutput(z5);
                httpURLConnection.setConnectTimeout(timeOutInterval);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(bufferedOutputStream, Constants.ENCODING));
                bufferedWriter.write(jsonBodyStr);
                bufferedWriter.flush();
                bufferedWriter.close();
                bufferedOutputStream.close();
                StringBuilder sb = new StringBuilder();
                if (ACCEPTABLE_HTTP_RESPONSE.contains(Integer.valueOf(httpURLConnection.getResponseCode()))) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), Constants.ENCODING));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            } else {
                                sb.append(readLine);
                            }
                        } finally {
                            try {
                                throw th;
                            } catch (Throwable th) {
                                CloseableKt.closeFinally(bufferedReader, th);
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedReader, null);
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "connResponseSB.toString()");
                Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, TAG, "\nResponse Received: \n%s\n%s", sb2, Integer.valueOf(httpURLConnection.getResponseCode()));
                if (requestCallback == null) {
                    requestCallback.invoke(sb2, Integer.valueOf(httpURLConnection.getResponseCode()));
                    return;
                }
                return;
            }
            z5 = true;
            httpURLConnection.setDoOutput(z5);
            httpURLConnection.setConnectTimeout(timeOutInterval);
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(bufferedOutputStream2, Constants.ENCODING));
            bufferedWriter2.write(jsonBodyStr);
            bufferedWriter2.flush();
            bufferedWriter2.close();
            bufferedOutputStream2.close();
            StringBuilder sb3 = new StringBuilder();
            if (ACCEPTABLE_HTTP_RESPONSE.contains(Integer.valueOf(httpURLConnection.getResponseCode()))) {
            }
            String sb22 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb22, "connResponseSB.toString()");
            Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, TAG, "\nResponse Received: \n%s\n%s", sb22, Integer.valueOf(httpURLConnection.getResponseCode()));
            if (requestCallback == null) {
            }
        } catch (UnknownHostException e5) {
            Logger.INSTANCE.log(LoggingBehavior.APP_EVENTS, TAG, "Connection failed, retrying: \n%s", e5.toString());
            if (requestCallback != null) {
                requestCallback.invoke(null, 503);
            }
        } catch (IOException e6) {
            Logger.INSTANCE.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Send to server failed: \n%s", e6.toString());
        }
    }

    public final void setCredentials$facebook_core_release(CloudBridgeCredentials cloudBridgeCredentials) {
        Intrinsics.checkNotNullParameter(cloudBridgeCredentials, "<set-?>");
        credentials = cloudBridgeCredentials;
    }

    public final void setTransformedEvents$facebook_core_release(List<Map<String, Object>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        transformedEvents = list;
    }
}
