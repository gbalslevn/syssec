package com.facebook;

import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 *2\u00020\u0001:\u0001*BC\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fB-\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u0010B+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u0012B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u0013J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010\u0017R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010 R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010!R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010%\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\u0015R\u0019\u0010'\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b'\u0010!\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/facebook/GraphResponse;", BuildConfig.FLAVOR, "Lcom/facebook/GraphRequest;", "request", "Ljava/net/HttpURLConnection;", "connection", BuildConfig.FLAVOR, "rawResponse", "Lorg/json/JSONObject;", "graphObject", "Lorg/json/JSONArray;", "graphObjectArray", "Lcom/facebook/FacebookRequestError;", "error", "<init>", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONArray;Lcom/facebook/FacebookRequestError;)V", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/JSONObject;)V", "graphObjects", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/JSONArray;)V", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookRequestError;)V", "getJSONObject", "()Lorg/json/JSONObject;", "toString", "()Ljava/lang/String;", "Lcom/facebook/GraphRequest;", "getRequest", "()Lcom/facebook/GraphRequest;", "Ljava/net/HttpURLConnection;", "getConnection", "()Ljava/net/HttpURLConnection;", "Ljava/lang/String;", "getRawResponse", "Lorg/json/JSONObject;", "Lorg/json/JSONArray;", "Lcom/facebook/FacebookRequestError;", "getError", "()Lcom/facebook/FacebookRequestError;", "jsonObject", "getJsonObject", "jsonArray", "getJsonArray", "()Lorg/json/JSONArray;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class GraphResponse {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    private static final String RESPONSE_LOG_TAG = "Response";
    private final HttpURLConnection connection;
    private final FacebookRequestError error;
    private final JSONObject graphObject;
    private final JSONArray graphObjectArray;
    private final JSONArray jsonArray;
    private final JSONObject jsonObject;
    private final String rawResponse;
    private final GraphRequest request;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = GraphResponse.class.getCanonicalName();

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J*\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001H\u0002J.\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\u0015\u001a\u00020\u0001H\u0002J/\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001cJ-\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001fJ#\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u001bH\u0001¢\u0006\u0002\b!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/facebook/GraphResponse$Companion;", BuildConfig.FLAVOR, "()V", "BODY_KEY", BuildConfig.FLAVOR, "CODE_KEY", "NON_JSON_RESPONSE_PROPERTY", "RESPONSE_LOG_TAG", "SUCCESS_KEY", "TAG", "constructErrorResponses", BuildConfig.FLAVOR, "Lcom/facebook/GraphResponse;", "requests", "Lcom/facebook/GraphRequest;", "connection", "Ljava/net/HttpURLConnection;", "error", "Lcom/facebook/FacebookException;", "createResponseFromObject", "request", "sourceObject", "originalResult", "createResponsesFromObject", "createResponsesFromStream", "stream", "Ljava/io/InputStream;", "Lcom/facebook/GraphRequestBatch;", "createResponsesFromStream$facebook_core_release", "createResponsesFromString", "responseString", "createResponsesFromString$facebook_core_release", "fromHttpConnection", "fromHttpConnection$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GraphResponse createResponseFromObject(GraphRequest request, HttpURLConnection connection, Object sourceObject, Object originalResult) {
            if (sourceObject instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) sourceObject;
                FacebookRequestError checkResponseAndCreateError = FacebookRequestError.INSTANCE.checkResponseAndCreateError(jSONObject, originalResult, connection);
                if (checkResponseAndCreateError != null) {
                    Log.e(GraphResponse.TAG, checkResponseAndCreateError.toString());
                    if (checkResponseAndCreateError.getErrorCode() == 190) {
                        Utility utility = Utility.INSTANCE;
                        if (Utility.isCurrentAccessToken(request.getAccessToken())) {
                            if (checkResponseAndCreateError.getSubErrorCode() != 493) {
                                AccessToken.INSTANCE.setCurrentAccessToken(null);
                            } else {
                                AccessToken.Companion companion = AccessToken.INSTANCE;
                                AccessToken currentAccessToken = companion.getCurrentAccessToken();
                                if (Intrinsics.areEqual(currentAccessToken != null ? Boolean.valueOf(currentAccessToken.isExpired()) : null, Boolean.FALSE)) {
                                    companion.expireCurrentAccessToken();
                                }
                            }
                        }
                    }
                    return new GraphResponse(request, connection, checkResponseAndCreateError);
                }
                Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
                if (stringPropertyAsJSON instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject) stringPropertyAsJSON;
                    return new GraphResponse(request, connection, jSONObject2.toString(), jSONObject2);
                }
                if (stringPropertyAsJSON instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) stringPropertyAsJSON;
                    return new GraphResponse(request, connection, jSONArray.toString(), jSONArray);
                }
                sourceObject = JSONObject.NULL;
                Intrinsics.checkNotNullExpressionValue(sourceObject, "NULL");
            }
            if (sourceObject == JSONObject.NULL) {
                return new GraphResponse(request, connection, sourceObject.toString(), (JSONObject) null);
            }
            throw new FacebookException(Intrinsics.stringPlus("Got unexpected object type in response, class: ", sourceObject.getClass().getSimpleName()));
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final List<GraphResponse> createResponsesFromObject(HttpURLConnection connection, List<GraphRequest> requests, Object sourceObject) {
            Object obj;
            int size = requests.size();
            ArrayList arrayList = new ArrayList(size);
            int i5 = 0;
            if (size == 1) {
                GraphRequest graphRequest = requests.get(0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("body", sourceObject);
                    jSONObject.put(GraphResponse.CODE_KEY, connection == null ? 200 : connection.getResponseCode());
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    obj = jSONArray;
                } catch (IOException e5) {
                    arrayList.add(new GraphResponse(graphRequest, connection, new FacebookRequestError(connection, e5)));
                } catch (JSONException e6) {
                    arrayList.add(new GraphResponse(graphRequest, connection, new FacebookRequestError(connection, e6)));
                }
                if (obj instanceof JSONArray) {
                    JSONArray jSONArray2 = (JSONArray) obj;
                    if (jSONArray2.length() == size) {
                        int length = jSONArray2.length();
                        if (length > 0) {
                            while (true) {
                                int i6 = i5 + 1;
                                GraphRequest graphRequest2 = requests.get(i5);
                                try {
                                    Object obj2 = ((JSONArray) obj).get(i5);
                                    Intrinsics.checkNotNullExpressionValue(obj2, "obj");
                                    arrayList.add(createResponseFromObject(graphRequest2, connection, obj2, sourceObject));
                                } catch (FacebookException e7) {
                                    arrayList.add(new GraphResponse(graphRequest2, connection, new FacebookRequestError(connection, e7)));
                                } catch (JSONException e8) {
                                    arrayList.add(new GraphResponse(graphRequest2, connection, new FacebookRequestError(connection, e8)));
                                }
                                if (i6 >= length) {
                                    break;
                                }
                                i5 = i6;
                            }
                        }
                        return arrayList;
                    }
                }
                throw new FacebookException("Unexpected number of results");
            }
            obj = sourceObject;
            if (obj instanceof JSONArray) {
            }
            throw new FacebookException("Unexpected number of results");
        }

        public final List<GraphResponse> constructErrorResponses(List<GraphRequest> requests, HttpURLConnection connection, FacebookException error) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            List<GraphRequest> list = requests;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new GraphResponse((GraphRequest) it.next(), connection, new FacebookRequestError(connection, error)));
            }
            return arrayList;
        }

        public final List<GraphResponse> createResponsesFromStream$facebook_core_release(InputStream stream, HttpURLConnection connection, GraphRequestBatch requests) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            String readStreamToString = Utility.readStreamToString(stream);
            Logger.INSTANCE.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, GraphResponse.RESPONSE_LOG_TAG, "Response (raw)\n  Size: %d\n  Response:\n%s\n", Integer.valueOf(readStreamToString.length()), readStreamToString);
            return createResponsesFromString$facebook_core_release(readStreamToString, connection, requests);
        }

        public final List<GraphResponse> createResponsesFromString$facebook_core_release(String responseString, HttpURLConnection connection, GraphRequestBatch requests) {
            Intrinsics.checkNotNullParameter(responseString, "responseString");
            Intrinsics.checkNotNullParameter(requests, "requests");
            Object resultObject = new JSONTokener(responseString).nextValue();
            Intrinsics.checkNotNullExpressionValue(resultObject, "resultObject");
            List<GraphResponse> createResponsesFromObject = createResponsesFromObject(connection, requests, resultObject);
            Logger.INSTANCE.log(LoggingBehavior.REQUESTS, GraphResponse.RESPONSE_LOG_TAG, "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", requests.getId(), Integer.valueOf(responseString.length()), createResponsesFromObject);
            return createResponsesFromObject;
        }

        public final List<GraphResponse> fromHttpConnection$facebook_core_release(HttpURLConnection connection, GraphRequestBatch requests) {
            List<GraphResponse> constructErrorResponses;
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(requests, "requests");
            InputStream inputStream = null;
            try {
                try {
                    try {
                    } catch (FacebookException e5) {
                        Logger.INSTANCE.log(LoggingBehavior.REQUESTS, GraphResponse.RESPONSE_LOG_TAG, "Response <Error>: %s", e5);
                        constructErrorResponses = constructErrorResponses(requests, connection, e5);
                    }
                } catch (Exception e6) {
                    Logger.INSTANCE.log(LoggingBehavior.REQUESTS, GraphResponse.RESPONSE_LOG_TAG, "Response <Error>: %s", e6);
                    constructErrorResponses = constructErrorResponses(requests, connection, new FacebookException(e6));
                }
                if (!FacebookSdk.isFullyInitialized()) {
                    Log.e(GraphResponse.TAG, "GraphRequest can't be used when Facebook SDK isn't fully initialized");
                    throw new FacebookException("GraphRequest can't be used when Facebook SDK isn't fully initialized");
                }
                inputStream = connection.getResponseCode() >= 400 ? connection.getErrorStream() : connection.getInputStream();
                constructErrorResponses = createResponsesFromStream$facebook_core_release(inputStream, connection, requests);
                Utility.closeQuietly(inputStream);
                return constructErrorResponses;
            } catch (Throwable th) {
                Utility.closeQuietly(null);
                throw th;
            }
        }

        private Companion() {
        }
    }

    public GraphResponse(GraphRequest request, HttpURLConnection httpURLConnection, String str, JSONObject jSONObject, JSONArray jSONArray, FacebookRequestError facebookRequestError) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.request = request;
        this.connection = httpURLConnection;
        this.rawResponse = str;
        this.graphObject = jSONObject;
        this.graphObjectArray = jSONArray;
        this.error = facebookRequestError;
        this.jsonObject = jSONObject;
        this.jsonArray = jSONArray;
    }

    public final FacebookRequestError getError() {
        return this.error;
    }

    /* renamed from: getJSONObject, reason: from getter */
    public final JSONObject getGraphObject() {
        return this.graphObject;
    }

    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public String toString() {
        String str;
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.US;
            HttpURLConnection httpURLConnection = this.connection;
            str = String.format(locale, "%d", Arrays.copyOf(new Object[]{Integer.valueOf(httpURLConnection == null ? 200 : httpURLConnection.getResponseCode())}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(locale, format, *args)");
        } catch (IOException unused) {
            str = "unknown";
        }
        String str2 = "{Response:  responseCode: " + str + ", graphObject: " + this.graphObject + ", error: " + this.error + "}";
        Intrinsics.checkNotNullExpressionValue(str2, "StringBuilder()\n        .append(\"{Response: \")\n        .append(\" responseCode: \")\n        .append(responseCode)\n        .append(\", graphObject: \")\n        .append(graphObject)\n        .append(\", error: \")\n        .append(error)\n        .append(\"}\")\n        .toString()");
        return str2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphResponse(GraphRequest request, HttpURLConnection httpURLConnection, String rawResponse, JSONObject jSONObject) {
        this(request, httpURLConnection, rawResponse, jSONObject, null, null);
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(rawResponse, "rawResponse");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphResponse(GraphRequest request, HttpURLConnection httpURLConnection, String rawResponse, JSONArray graphObjects) {
        this(request, httpURLConnection, rawResponse, null, graphObjects, null);
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(rawResponse, "rawResponse");
        Intrinsics.checkNotNullParameter(graphObjects, "graphObjects");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphResponse(GraphRequest request, HttpURLConnection httpURLConnection, FacebookRequestError error) {
        this(request, httpURLConnection, null, null, null, error);
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(error, "error");
    }
}
