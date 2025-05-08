package com.facebook;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.sdk.growthbook.utils.Constants;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b8\u0018\u0000 k2\u00020\u0001:\u0007lmknopqBQ\b\u0017\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001f\u0010\u001dJ+\u0010%\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020#0\"H\u0002¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u0016¢\u0006\u0004\b(\u0010)J\r\u0010+\u001a\u00020*¢\u0006\u0004\b+\u0010,J\r\u0010.\u001a\u00020-¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0004H\u0016¢\u0006\u0004\b0\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00106\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010A\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u00106\u001a\u0004\bB\u0010\u0013\"\u0004\bC\u00109R$\u0010D\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u00106\u001a\u0004\bE\u0010\u0013\"\u0004\bF\u00109R\"\u0010G\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010\u001d\"\u0004\bJ\u0010)R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010P\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR$\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u00106\u001a\u0004\bV\u0010\u0013\"\u0004\bW\u00109R.\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R.\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010]\u001a\u0004\u0018\u00010\b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010HR\u0018\u0010d\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u00106R\u0016\u0010f\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\be\u0010\u0013R\u0011\u0010h\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bg\u0010\u0013R\u0011\u0010j\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bi\u0010\u0013¨\u0006r"}, d2 = {"Lcom/facebook/GraphRequest;", BuildConfig.FLAVOR, "Lcom/facebook/AccessToken;", "accessToken", BuildConfig.FLAVOR, "graphPath", "Landroid/os/Bundle;", "parameters", "Lcom/facebook/HttpMethod;", "httpMethod", "Lcom/facebook/GraphRequest$Callback;", com.sun.jna.Callback.METHOD_NAME, "version", "<init>", "(Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/HttpMethod;Lcom/facebook/GraphRequest$Callback;Ljava/lang/String;)V", BuildConfig.FLAVOR, "addCommonParameters", "()V", "getAccessTokenToUseForRequest", "()Ljava/lang/String;", "getClientTokenForRequest", "baseUrl", BuildConfig.FLAVOR, "isBatch", "appendParametersToBaseUrl", "(Ljava/lang/String;Z)Ljava/lang/String;", "getUrlWithGraphPath", "(Ljava/lang/String;)Ljava/lang/String;", "shouldForceClientTokenForRequest", "()Z", "isValidGraphRequestForDomain", "isApplicationRequest", "Lorg/json/JSONArray;", GraphRequest.BATCH_PARAM, BuildConfig.FLAVOR, "Lcom/facebook/GraphRequest$Attachment;", "attachments", "serializeToBatch", "(Lorg/json/JSONArray;Ljava/util/Map;)V", "forceOverride", "setForceApplicationRequest", "(Z)V", "Lcom/facebook/GraphResponse;", "executeAndWait", "()Lcom/facebook/GraphResponse;", "Lcom/facebook/GraphRequestAsyncTask;", "executeAsync", "()Lcom/facebook/GraphRequestAsyncTask;", "toString", "Lcom/facebook/AccessToken;", "getAccessToken", "()Lcom/facebook/AccessToken;", "setAccessToken", "(Lcom/facebook/AccessToken;)V", "Ljava/lang/String;", "getGraphPath", "setGraphPath", "(Ljava/lang/String;)V", "Lorg/json/JSONObject;", "graphObject", "Lorg/json/JSONObject;", "getGraphObject", "()Lorg/json/JSONObject;", "setGraphObject", "(Lorg/json/JSONObject;)V", "batchEntryName", "getBatchEntryName", "setBatchEntryName", "batchEntryDependsOn", "getBatchEntryDependsOn", "setBatchEntryDependsOn", "batchEntryOmitResultOnSuccess", "Z", "getBatchEntryOmitResultOnSuccess", "setBatchEntryOmitResultOnSuccess", "Landroid/os/Bundle;", "getParameters", "()Landroid/os/Bundle;", "setParameters", "(Landroid/os/Bundle;)V", "tag", "Ljava/lang/Object;", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "getVersion", "setVersion", "Lcom/facebook/GraphRequest$Callback;", "getCallback", "()Lcom/facebook/GraphRequest$Callback;", "setCallback", "(Lcom/facebook/GraphRequest$Callback;)V", "value", "Lcom/facebook/HttpMethod;", "getHttpMethod", "()Lcom/facebook/HttpMethod;", "setHttpMethod", "(Lcom/facebook/HttpMethod;)V", "forceApplicationRequest", "overriddenURL", "getGraphPathWithVersion", "graphPathWithVersion", "getRelativeUrlForBatchedRequest", "relativeUrlForBatchedRequest", "getUrlForSingleRequest", "urlForSingleRequest", "Companion", "Attachment", "Callback", "GraphJSONObjectCallback", "KeyValueSerializer", "ParcelableResourceWithMimeType", "Serializer", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class GraphRequest {
    private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
    private static final String ATTACHED_FILES_PARAM = "attached_files";
    private static final String ATTACHMENT_FILENAME_PREFIX = "file";
    private static final String BATCH_APP_ID_PARAM = "batch_app_id";
    private static final String BATCH_BODY_PARAM = "body";
    private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
    private static final String BATCH_ENTRY_NAME_PARAM = "name";
    private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
    private static final String BATCH_METHOD_PARAM = "method";
    private static final String BATCH_PARAM = "batch";
    private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
    private static final String CAPTION_PARAM = "caption";
    private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String DEBUG_KEY = "__debug__";
    private static final String DEBUG_MESSAGES_KEY = "messages";
    private static final String DEBUG_MESSAGE_KEY = "message";
    private static final String DEBUG_MESSAGE_LINK_KEY = "link";
    private static final String DEBUG_MESSAGE_TYPE_KEY = "type";
    private static final String DEBUG_PARAM = "debug";
    private static final String DEBUG_SEVERITY_INFO = "info";
    private static final String DEBUG_SEVERITY_WARNING = "warning";
    private static final String FORMAT_JSON = "json";
    private static final String FORMAT_PARAM = "format";
    private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    private static final String ME = "me";
    private static final String MIME_BOUNDARY;
    private static final String MY_FRIENDS = "me/friends";
    private static final String MY_PHOTOS = "me/photos";
    private static final String PICTURE_PARAM = "picture";
    private static final String SDK_ANDROID = "android";
    private static final String SDK_PARAM = "sdk";
    private static final String SEARCH = "search";
    private static final String USER_AGENT_BASE = "FBAndroidSDK";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private static final String VIDEOS_SUFFIX = "/videos";
    private static String defaultBatchApplicationId;
    private static volatile String userAgent;
    private static final Pattern versionPattern;
    private AccessToken accessToken;
    private String batchEntryDependsOn;
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess;
    private Callback callback;
    private boolean forceApplicationRequest;
    private JSONObject graphObject;
    private String graphPath;
    private HttpMethod httpMethod;
    private String overriddenURL;
    private Bundle parameters;
    private Object tag;
    private String version;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = GraphRequest.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/facebook/GraphRequest$Attachment;", BuildConfig.FLAVOR, "request", "Lcom/facebook/GraphRequest;", "value", "(Lcom/facebook/GraphRequest;Ljava/lang/Object;)V", "getRequest", "()Lcom/facebook/GraphRequest;", "getValue", "()Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Attachment {
        private final GraphRequest request;
        private final Object value;

        public Attachment(GraphRequest request, Object obj) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.request = request;
            this.value = obj;
        }

        public final GraphRequest getRequest() {
            return this.request;
        }

        public final Object getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/GraphRequest$Callback;", BuildConfig.FLAVOR, "onCompleted", BuildConfig.FLAVOR, "response", "Lcom/facebook/GraphResponse;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public interface Callback {
        void onCompleted(GraphResponse response);
    }

    @Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0010%\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\rJA\u0010\u001a\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010$\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J/\u0010)\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u000bH\u0002¢\u0006\u0004\b)\u0010*J'\u00100\u001a\u00020\u00102\u0006\u0010,\u001a\u00020+2\u0006\u0010#\u001a\u00020-2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J+\u00105\u001a\u00020\u00102\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u000203022\u0006\u0010#\u001a\u00020-H\u0002¢\u0006\u0004\b5\u00106J9\u00109\u001a\u00020\u00102\u0006\u0010#\u001a\u00020-2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020.072\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020308H\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020\tH\u0002¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b>\u0010?J\u0019\u0010@\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b@\u0010?J\u0019\u0010A\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\bA\u0010BJ#\u0010G\u001a\u00020.2\b\u0010D\u001a\u0004\u0018\u00010C2\b\u0010F\u001a\u0004\u0018\u00010EH\u0007¢\u0006\u0004\bG\u0010HJ7\u0010K\u001a\u00020.2\b\u0010D\u001a\u0004\u0018\u00010C2\b\u0010I\u001a\u0004\u0018\u00010\u001c2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010F\u001a\u0004\u0018\u00010JH\u0007¢\u0006\u0004\bK\u0010LJ7\u0010N\u001a\u00020.2\b\u0010D\u001a\u0004\u0018\u00010C2\b\u0010I\u001a\u0004\u0018\u00010\u001c2\b\u0010M\u001a\u0004\u0018\u00010+2\b\u0010F\u001a\u0004\u0018\u00010JH\u0007¢\u0006\u0004\bN\u0010OJ-\u0010P\u001a\u00020.2\b\u0010D\u001a\u0004\u0018\u00010C2\b\u0010I\u001a\u0004\u0018\u00010\u001c2\b\u0010F\u001a\u0004\u0018\u00010JH\u0007¢\u0006\u0004\bP\u0010QJ\u0017\u0010R\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020T2\u0006\u0010/\u001a\u00020.H\u0007¢\u0006\u0004\bU\u0010VJ)\u0010Y\u001a\b\u0012\u0004\u0012\u00020T0X2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020.0W\"\u00020.H\u0007¢\u0006\u0004\bY\u0010ZJ#\u0010Y\u001a\b\u0012\u0004\u0012\u00020T0X2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020.07H\u0007¢\u0006\u0004\bY\u0010[J\u001d\u0010Y\u001a\b\u0012\u0004\u0012\u00020T0X2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\bY\u0010\\J#\u0010^\u001a\u00020]2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020.0W\"\u00020.H\u0007¢\u0006\u0004\b^\u0010_J\u001d\u0010^\u001a\u00020]2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020.07H\u0007¢\u0006\u0004\b^\u0010`J\u0017\u0010^\u001a\u00020]2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b^\u0010aJ%\u0010b\u001a\b\u0012\u0004\u0012\u00020T0X2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\bb\u0010cJ%\u0010g\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020T0XH\u0001¢\u0006\u0004\be\u0010fJ\u0017\u0010j\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\bh\u0010iJ\u001f\u0010m\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0006H\u0001¢\u0006\u0004\bk\u0010lR\u0014\u0010p\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bn\u0010oR\u001e\u0010q\u001a\u0004\u0018\u00010\u001c8B@\u0002X\u0082\u000e¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010oR\u0014\u0010t\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\bt\u0010rR\u0014\u0010u\u001a\u00020\u001c8\u0006X\u0086T¢\u0006\u0006\n\u0004\bu\u0010rR\u0014\u0010v\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\bv\u0010rR\u0014\u0010w\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\bw\u0010rR\u0014\u0010x\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\bx\u0010rR\u0014\u0010y\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\by\u0010rR\u0014\u0010z\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\bz\u0010rR\u0014\u0010{\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\b{\u0010rR\u0014\u0010|\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\b|\u0010rR\u0014\u0010}\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\b}\u0010rR\u0014\u0010~\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\b~\u0010rR\u0014\u0010\u007f\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u007f\u0010rR\u0016\u0010\u0080\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010rR\u0016\u0010\u0081\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010rR\u0016\u0010\u0082\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010rR\u0016\u0010\u0083\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010rR\u0016\u0010\u0084\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010rR\u0016\u0010\u0085\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010rR\u0016\u0010\u0086\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010rR\u0016\u0010\u0087\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010rR\u0016\u0010\u0088\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010rR\u0016\u0010\u0089\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010rR\u0016\u0010\u008a\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010rR\u0016\u0010\u008b\u0001\u001a\u00020\u001c8\u0006X\u0086T¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010rR\u0016\u0010\u008c\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010rR\u0016\u0010\u008d\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010rR\u0016\u0010\u008e\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010rR\u0017\u0010\u008f\u0001\u001a\u00020\u00168\u0006X\u0086T¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0016\u0010\u0091\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010rR\u0016\u0010\u0092\u0001\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010rR\u0016\u0010\u0093\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010rR\u0016\u0010\u0094\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010rR\u0016\u0010\u0095\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010rR\u0016\u0010\u0096\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010rR\u0016\u0010\u0097\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010rR\u0016\u0010\u0098\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010rR\u0016\u0010\u0099\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010rR\u0016\u0010\u009a\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010rR\u0016\u0010\u009b\u0001\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010rR\u001a\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010rR\"\u0010\u009f\u0001\u001a\r \u009e\u0001*\u0005\u0018\u00010\u009d\u00010\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001¨\u0006¡\u0001"}, d2 = {"Lcom/facebook/GraphRequest$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Ljava/net/URL;", "url", "Ljava/net/HttpURLConnection;", "createConnection", "(Ljava/net/URL;)Ljava/net/HttpURLConnection;", "Lcom/facebook/GraphRequestBatch;", "requests", BuildConfig.FLAVOR, "hasOnProgressCallbacks", "(Lcom/facebook/GraphRequestBatch;)Z", "connection", "shouldUseGzip", BuildConfig.FLAVOR, "setConnectionContentType", "(Ljava/net/HttpURLConnection;Z)V", "isGzipCompressible", "Lcom/facebook/internal/Logger;", "logger", BuildConfig.FLAVOR, "numRequests", "Ljava/io/OutputStream;", "outputStream", "processRequest", "(Lcom/facebook/GraphRequestBatch;Lcom/facebook/internal/Logger;ILjava/net/URL;Ljava/io/OutputStream;Z)V", BuildConfig.FLAVOR, "path", "isMeRequest", "(Ljava/lang/String;)Z", "Lorg/json/JSONObject;", "graphObject", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "serializer", "processGraphObject", "(Lorg/json/JSONObject;Ljava/lang/String;Lcom/facebook/GraphRequest$KeyValueSerializer;)V", "key", "value", "passByValue", "processGraphObjectProperty", "(Ljava/lang/String;Ljava/lang/Object;Lcom/facebook/GraphRequest$KeyValueSerializer;Z)V", "Landroid/os/Bundle;", "bundle", "Lcom/facebook/GraphRequest$Serializer;", "Lcom/facebook/GraphRequest;", "request", "serializeParameters", "(Landroid/os/Bundle;Lcom/facebook/GraphRequest$Serializer;Lcom/facebook/GraphRequest;)V", BuildConfig.FLAVOR, "Lcom/facebook/GraphRequest$Attachment;", "attachments", "serializeAttachments", "(Ljava/util/Map;Lcom/facebook/GraphRequest$Serializer;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "serializeRequestsAsJSON", "(Lcom/facebook/GraphRequest$Serializer;Ljava/util/Collection;Ljava/util/Map;)V", GraphRequest.BATCH_PARAM, "getBatchAppId", "(Lcom/facebook/GraphRequestBatch;)Ljava/lang/String;", "isSupportedAttachmentType", "(Ljava/lang/Object;)Z", "isSupportedParameterType", "parameterToString", "(Ljava/lang/Object;)Ljava/lang/String;", "Lcom/facebook/AccessToken;", "accessToken", "Lcom/facebook/GraphRequest$GraphJSONObjectCallback;", com.sun.jna.Callback.METHOD_NAME, "newMeRequest", "(Lcom/facebook/AccessToken;Lcom/facebook/GraphRequest$GraphJSONObjectCallback;)Lcom/facebook/GraphRequest;", "graphPath", "Lcom/facebook/GraphRequest$Callback;", "newPostRequest", "(Lcom/facebook/AccessToken;Ljava/lang/String;Lorg/json/JSONObject;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;", "parameters", "newPostRequestWithBundle", "(Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;", "newGraphPathRequest", "(Lcom/facebook/AccessToken;Ljava/lang/String;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;", "toHttpConnection", "(Lcom/facebook/GraphRequestBatch;)Ljava/net/HttpURLConnection;", "Lcom/facebook/GraphResponse;", "executeAndWait", "(Lcom/facebook/GraphRequest;)Lcom/facebook/GraphResponse;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "executeBatchAndWait", "([Lcom/facebook/GraphRequest;)Ljava/util/List;", "(Ljava/util/Collection;)Ljava/util/List;", "(Lcom/facebook/GraphRequestBatch;)Ljava/util/List;", "Lcom/facebook/GraphRequestAsyncTask;", "executeBatchAsync", "([Lcom/facebook/GraphRequest;)Lcom/facebook/GraphRequestAsyncTask;", "(Ljava/util/Collection;)Lcom/facebook/GraphRequestAsyncTask;", "(Lcom/facebook/GraphRequestBatch;)Lcom/facebook/GraphRequestAsyncTask;", "executeConnectionAndWait", "(Ljava/net/HttpURLConnection;Lcom/facebook/GraphRequestBatch;)Ljava/util/List;", "responses", "runCallbacks$facebook_core_release", "(Lcom/facebook/GraphRequestBatch;Ljava/util/List;)V", "runCallbacks", "validateFieldsParamForGetRequests$facebook_core_release", "(Lcom/facebook/GraphRequestBatch;)V", "validateFieldsParamForGetRequests", "serializeToUrlConnection$facebook_core_release", "(Lcom/facebook/GraphRequestBatch;Ljava/net/HttpURLConnection;)V", "serializeToUrlConnection", "getMimeContentType", "()Ljava/lang/String;", "mimeContentType", "userAgent", "Ljava/lang/String;", "getUserAgent", "ACCEPT_LANGUAGE_HEADER", "ACCESS_TOKEN_PARAM", "ATTACHED_FILES_PARAM", "ATTACHMENT_FILENAME_PREFIX", "BATCH_APP_ID_PARAM", "BATCH_BODY_PARAM", "BATCH_ENTRY_DEPENDS_ON_PARAM", "BATCH_ENTRY_NAME_PARAM", "BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM", "BATCH_METHOD_PARAM", "BATCH_PARAM", "BATCH_RELATIVE_URL_PARAM", "CAPTION_PARAM", "CONTENT_ENCODING_HEADER", "CONTENT_TYPE_HEADER", "DEBUG_KEY", "DEBUG_MESSAGES_KEY", "DEBUG_MESSAGE_KEY", "DEBUG_MESSAGE_LINK_KEY", "DEBUG_MESSAGE_TYPE_KEY", "DEBUG_PARAM", "DEBUG_SEVERITY_INFO", "DEBUG_SEVERITY_WARNING", "FIELDS_PARAM", "FORMAT_JSON", "FORMAT_PARAM", "ISO_8601_FORMAT_STRING", "MAXIMUM_BATCH_SIZE", "I", "ME", "MIME_BOUNDARY", "MY_FRIENDS", "MY_PHOTOS", "PICTURE_PARAM", "SDK_ANDROID", "SDK_PARAM", "SEARCH", "USER_AGENT_BASE", "USER_AGENT_HEADER", "VIDEOS_SUFFIX", "defaultBatchApplicationId", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "versionPattern", "Ljava/util/regex/Pattern;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final HttpURLConnection createConnection(URL url) {
            URLConnection openConnection = url.openConnection();
            if (openConnection == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, getUserAgent());
            httpURLConnection.setRequestProperty(GraphRequest.ACCEPT_LANGUAGE_HEADER, Locale.getDefault().toString());
            httpURLConnection.setChunkedStreamingMode(0);
            return httpURLConnection;
        }

        private final String getBatchAppId(GraphRequestBatch batch) {
            String batchApplicationId = batch.getBatchApplicationId();
            if (batchApplicationId != null && !batch.isEmpty()) {
                return batchApplicationId;
            }
            Iterator<GraphRequest> it = batch.iterator();
            while (it.hasNext()) {
                AccessToken accessToken = it.next().getAccessToken();
                if (accessToken != null) {
                    return accessToken.getApplicationId();
                }
            }
            String str = GraphRequest.defaultBatchApplicationId;
            return (str == null || str.length() <= 0) ? FacebookSdk.getApplicationId() : str;
        }

        private final String getMimeContentType() {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("multipart/form-data; boundary=%s", Arrays.copyOf(new Object[]{GraphRequest.MIME_BOUNDARY}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            return format;
        }

        private final String getUserAgent() {
            if (GraphRequest.userAgent == null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%s.%s", Arrays.copyOf(new Object[]{GraphRequest.USER_AGENT_BASE, "18.0.0"}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                GraphRequest.userAgent = format;
                String customUserAgent = InternalSettings.getCustomUserAgent();
                if (!Utility.isNullOrEmpty(customUserAgent)) {
                    String format2 = String.format(Locale.ROOT, "%s/%s", Arrays.copyOf(new Object[]{GraphRequest.userAgent, customUserAgent}, 2));
                    Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, format, *args)");
                    GraphRequest.userAgent = format2;
                }
            }
            return GraphRequest.userAgent;
        }

        private final boolean hasOnProgressCallbacks(GraphRequestBatch requests) {
            for (GraphRequestBatch.Callback callback : requests.getCallbacks()) {
            }
            Iterator<GraphRequest> it = requests.iterator();
            while (it.hasNext()) {
                it.next().getCallback();
            }
            return false;
        }

        private final boolean isGzipCompressible(GraphRequestBatch requests) {
            Iterator<GraphRequest> it = requests.iterator();
            while (it.hasNext()) {
                GraphRequest next = it.next();
                Iterator<String> it2 = next.getParameters().keySet().iterator();
                while (it2.hasNext()) {
                    if (isSupportedAttachmentType(next.getParameters().get(it2.next()))) {
                        return false;
                    }
                }
            }
            return true;
        }

        private final boolean isMeRequest(String path) {
            Matcher matcher = GraphRequest.versionPattern.matcher(path);
            if (matcher.matches()) {
                path = matcher.group(1);
                Intrinsics.checkNotNullExpressionValue(path, "matcher.group(1)");
            }
            return StringsKt.startsWith$default(path, "me/", false, 2, (Object) null) || StringsKt.startsWith$default(path, "/me/", false, 2, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSupportedAttachmentType(Object value) {
            return (value instanceof Bitmap) || (value instanceof byte[]) || (value instanceof Uri) || (value instanceof ParcelFileDescriptor) || (value instanceof ParcelableResourceWithMimeType);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSupportedParameterType(Object value) {
            return (value instanceof String) || (value instanceof Boolean) || (value instanceof Number) || (value instanceof Date);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: newMeRequest$lambda-0, reason: not valid java name */
        public static final void m2784newMeRequest$lambda0(GraphJSONObjectCallback graphJSONObjectCallback, GraphResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            if (graphJSONObjectCallback == null) {
                return;
            }
            graphJSONObjectCallback.onCompleted(response.getGraphObject(), response);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String parameterToString(Object value) {
            if (value instanceof String) {
                return (String) value;
            }
            if ((value instanceof Boolean) || (value instanceof Number)) {
                return value.toString();
            }
            if (!(value instanceof Date)) {
                throw new IllegalArgumentException("Unsupported parameter type.");
            }
            String format = new SimpleDateFormat(GraphRequest.ISO_8601_FORMAT_STRING, Locale.US).format((Date) value);
            Intrinsics.checkNotNullExpressionValue(format, "iso8601DateFormat.format(value)");
            return format;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void processGraphObject(JSONObject graphObject, String path, KeyValueSerializer serializer) {
            boolean z5;
            Iterator<String> keys;
            if (isMeRequest(path)) {
                int indexOf$default = StringsKt.indexOf$default((CharSequence) path, ":", 0, false, 6, (Object) null);
                int indexOf$default2 = StringsKt.indexOf$default((CharSequence) path, "?", 0, false, 6, (Object) null);
                if (indexOf$default > 3 && (indexOf$default2 == -1 || indexOf$default < indexOf$default2)) {
                    z5 = true;
                    keys = graphObject.keys();
                    while (keys.hasNext()) {
                        String key = keys.next();
                        Object value = graphObject.opt(key);
                        boolean z6 = z5 && StringsKt.equals(key, "image", true);
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        Intrinsics.checkNotNullExpressionValue(value, "value");
                        processGraphObjectProperty(key, value, serializer, z6);
                    }
                }
            }
            z5 = false;
            keys = graphObject.keys();
            while (keys.hasNext()) {
            }
        }

        private final void processGraphObjectProperty(String key, Object value, KeyValueSerializer serializer, boolean passByValue) {
            Class<?> cls = value.getClass();
            if (JSONObject.class.isAssignableFrom(cls)) {
                JSONObject jSONObject = (JSONObject) value;
                if (passByValue) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("%s[%s]", Arrays.copyOf(new Object[]{key, next}, 2));
                        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                        Object opt = jSONObject.opt(next);
                        Intrinsics.checkNotNullExpressionValue(opt, "jsonObject.opt(propertyName)");
                        processGraphObjectProperty(format, opt, serializer, passByValue);
                    }
                    return;
                }
                if (jSONObject.has(Constants.ID_ATTRIBUTE_KEY)) {
                    String optString = jSONObject.optString(Constants.ID_ATTRIBUTE_KEY);
                    Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"id\")");
                    processGraphObjectProperty(key, optString, serializer, passByValue);
                    return;
                } else if (jSONObject.has("url")) {
                    String optString2 = jSONObject.optString("url");
                    Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"url\")");
                    processGraphObjectProperty(key, optString2, serializer, passByValue);
                    return;
                } else {
                    if (jSONObject.has("fbsdk:create_object")) {
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
                        processGraphObjectProperty(key, jSONObject2, serializer, passByValue);
                        return;
                    }
                    return;
                }
            }
            if (!JSONArray.class.isAssignableFrom(cls)) {
                if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
                    serializer.writeString(key, value.toString());
                    return;
                }
                if (Date.class.isAssignableFrom(cls)) {
                    String format2 = new SimpleDateFormat(GraphRequest.ISO_8601_FORMAT_STRING, Locale.US).format((Date) value);
                    Intrinsics.checkNotNullExpressionValue(format2, "iso8601DateFormat.format(date)");
                    serializer.writeString(key, format2);
                    return;
                }
                Utility utility = Utility.INSTANCE;
                Utility.logd(GraphRequest.TAG, "The type of property " + key + " in the graph object is unknown. It won't be sent in the request.");
                return;
            }
            JSONArray jSONArray = (JSONArray) value;
            int length = jSONArray.length();
            if (length <= 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format3 = String.format(Locale.ROOT, "%s[%d]", Arrays.copyOf(new Object[]{key, Integer.valueOf(i5)}, 2));
                Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(locale, format, *args)");
                Object opt2 = jSONArray.opt(i5);
                Intrinsics.checkNotNullExpressionValue(opt2, "jsonArray.opt(i)");
                processGraphObjectProperty(format3, opt2, serializer, passByValue);
                if (i6 >= length) {
                    return;
                } else {
                    i5 = i6;
                }
            }
        }

        private final void processRequest(GraphRequestBatch requests, Logger logger, int numRequests, URL url, OutputStream outputStream, boolean shouldUseGzip) {
            Serializer serializer = new Serializer(outputStream, logger, shouldUseGzip);
            if (numRequests != 1) {
                String batchAppId = getBatchAppId(requests);
                if (batchAppId.length() == 0) {
                    throw new FacebookException("App ID was not specified at the request or Settings.");
                }
                serializer.writeString(GraphRequest.BATCH_APP_ID_PARAM, batchAppId);
                HashMap hashMap = new HashMap();
                serializeRequestsAsJSON(serializer, requests, hashMap);
                if (logger != null) {
                    logger.append("  Attachments:\n");
                }
                serializeAttachments(hashMap, serializer);
                return;
            }
            GraphRequest graphRequest = requests.get(0);
            HashMap hashMap2 = new HashMap();
            for (String key : graphRequest.getParameters().keySet()) {
                Object obj = graphRequest.getParameters().get(key);
                if (isSupportedAttachmentType(obj)) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    hashMap2.put(key, new Attachment(graphRequest, obj));
                }
            }
            if (logger != null) {
                logger.append("  Parameters:\n");
            }
            serializeParameters(graphRequest.getParameters(), serializer, graphRequest);
            if (logger != null) {
                logger.append("  Attachments:\n");
            }
            serializeAttachments(hashMap2, serializer);
            JSONObject graphObject = graphRequest.getGraphObject();
            if (graphObject != null) {
                String path = url.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "url.path");
                processGraphObject(graphObject, path, serializer);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: runCallbacks$lambda-2, reason: not valid java name */
        public static final void m2785runCallbacks$lambda2(ArrayList callbacks, GraphRequestBatch requests) {
            Intrinsics.checkNotNullParameter(callbacks, "$callbacks");
            Intrinsics.checkNotNullParameter(requests, "$requests");
            Iterator it = callbacks.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                Callback callback = (Callback) pair.first;
                Object obj = pair.second;
                Intrinsics.checkNotNullExpressionValue(obj, "pair.second");
                callback.onCompleted((GraphResponse) obj);
            }
            Iterator<GraphRequestBatch.Callback> it2 = requests.getCallbacks().iterator();
            while (it2.hasNext()) {
                it2.next().onBatchCompleted(requests);
            }
        }

        private final void serializeAttachments(Map<String, Attachment> attachments, Serializer serializer) {
            for (Map.Entry<String, Attachment> entry : attachments.entrySet()) {
                if (GraphRequest.INSTANCE.isSupportedAttachmentType(entry.getValue().getValue())) {
                    serializer.writeObject(entry.getKey(), entry.getValue().getValue(), entry.getValue().getRequest());
                }
            }
        }

        private final void serializeParameters(Bundle bundle, Serializer serializer, GraphRequest request) {
            for (String key : bundle.keySet()) {
                Object obj = bundle.get(key);
                if (isSupportedParameterType(obj)) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    serializer.writeObject(key, obj, request);
                }
            }
        }

        private final void serializeRequestsAsJSON(Serializer serializer, Collection<GraphRequest> requests, Map<String, Attachment> attachments) {
            JSONArray jSONArray = new JSONArray();
            Iterator<GraphRequest> it = requests.iterator();
            while (it.hasNext()) {
                it.next().serializeToBatch(jSONArray, attachments);
            }
            serializer.writeRequestsAsJson(GraphRequest.BATCH_PARAM, jSONArray, requests);
        }

        private final void setConnectionContentType(HttpURLConnection connection, boolean shouldUseGzip) {
            if (!shouldUseGzip) {
                connection.setRequestProperty(GraphRequest.CONTENT_TYPE_HEADER, getMimeContentType());
            } else {
                connection.setRequestProperty(GraphRequest.CONTENT_TYPE_HEADER, "application/x-www-form-urlencoded");
                connection.setRequestProperty(GraphRequest.CONTENT_ENCODING_HEADER, "gzip");
            }
        }

        public final GraphResponse executeAndWait(GraphRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            List<GraphResponse> executeBatchAndWait = executeBatchAndWait(request);
            if (executeBatchAndWait.size() == 1) {
                return executeBatchAndWait.get(0);
            }
            throw new FacebookException("invalid state: expected a single response");
        }

        public final List<GraphResponse> executeBatchAndWait(GraphRequest... requests) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            return executeBatchAndWait(ArraysKt.toList(requests));
        }

        public final GraphRequestAsyncTask executeBatchAsync(GraphRequest... requests) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            return executeBatchAsync(ArraysKt.toList(requests));
        }

        public final List<GraphResponse> executeConnectionAndWait(HttpURLConnection connection, GraphRequestBatch requests) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(requests, "requests");
            List<GraphResponse> fromHttpConnection$facebook_core_release = GraphResponse.INSTANCE.fromHttpConnection$facebook_core_release(connection, requests);
            Utility.disconnectQuietly(connection);
            int size = requests.size();
            if (size == fromHttpConnection$facebook_core_release.size()) {
                runCallbacks$facebook_core_release(requests, fromHttpConnection$facebook_core_release);
                AccessTokenManager.INSTANCE.getInstance().extendAccessTokenIfNeeded();
                return fromHttpConnection$facebook_core_release;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "Received %d responses while expecting %d", Arrays.copyOf(new Object[]{Integer.valueOf(fromHttpConnection$facebook_core_release.size()), Integer.valueOf(size)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            throw new FacebookException(format);
        }

        public final GraphRequest newGraphPathRequest(AccessToken accessToken, String graphPath, Callback callback) {
            return new GraphRequest(accessToken, graphPath, null, null, callback, null, 32, null);
        }

        public final GraphRequest newMeRequest(AccessToken accessToken, final GraphJSONObjectCallback callback) {
            return new GraphRequest(accessToken, GraphRequest.ME, null, null, new Callback(callback) { // from class: d0.n
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    GraphRequest.Companion.m2784newMeRequest$lambda0(null, graphResponse);
                }
            }, null, 32, null);
        }

        public final GraphRequest newPostRequest(AccessToken accessToken, String graphPath, JSONObject graphObject, Callback callback) {
            GraphRequest graphRequest = new GraphRequest(accessToken, graphPath, null, HttpMethod.POST, callback, null, 32, null);
            graphRequest.setGraphObject(graphObject);
            return graphRequest;
        }

        public final GraphRequest newPostRequestWithBundle(AccessToken accessToken, String graphPath, Bundle parameters, Callback callback) {
            return new GraphRequest(accessToken, graphPath, parameters, HttpMethod.POST, callback, null, 32, null);
        }

        public final void runCallbacks$facebook_core_release(final GraphRequestBatch requests, List<GraphResponse> responses) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            Intrinsics.checkNotNullParameter(responses, "responses");
            int size = requests.size();
            final ArrayList arrayList = new ArrayList();
            if (size > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    GraphRequest graphRequest = requests.get(i5);
                    if (graphRequest.getCallback() != null) {
                        arrayList.add(new Pair(graphRequest.getCallback(), responses.get(i5)));
                    }
                    if (i6 >= size) {
                        break;
                    } else {
                        i5 = i6;
                    }
                }
            }
            if (arrayList.size() > 0) {
                Runnable runnable = new Runnable() { // from class: d0.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        GraphRequest.Companion.m2785runCallbacks$lambda2(arrayList, requests);
                    }
                };
                Handler callbackHandler = requests.getCallbackHandler();
                if ((callbackHandler == null ? null : Boolean.valueOf(callbackHandler.post(runnable))) == null) {
                    runnable.run();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00ef  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void serializeToUrlConnection$facebook_core_release(GraphRequestBatch requests, HttpURLConnection connection) {
            OutputStream outputStream;
            Intrinsics.checkNotNullParameter(requests, "requests");
            Intrinsics.checkNotNullParameter(connection, "connection");
            Logger logger = new Logger(LoggingBehavior.REQUESTS, "Request");
            int size = requests.size();
            boolean isGzipCompressible = isGzipCompressible(requests);
            OutputStream outputStream2 = null;
            HttpMethod httpMethod = size == 1 ? requests.get(0).getHttpMethod() : null;
            if (httpMethod == null) {
                httpMethod = HttpMethod.POST;
            }
            connection.setRequestMethod(httpMethod.name());
            setConnectionContentType(connection, isGzipCompressible);
            URL url = connection.getURL();
            logger.append("Request:\n");
            logger.appendKeyValue("Id", requests.getId());
            Intrinsics.checkNotNullExpressionValue(url, "url");
            logger.appendKeyValue("URL", url);
            Object requestMethod = connection.getRequestMethod();
            Intrinsics.checkNotNullExpressionValue(requestMethod, "connection.requestMethod");
            logger.appendKeyValue("Method", requestMethod);
            Object requestProperty = connection.getRequestProperty(GraphRequest.USER_AGENT_HEADER);
            Intrinsics.checkNotNullExpressionValue(requestProperty, "connection.getRequestProperty(\"User-Agent\")");
            logger.appendKeyValue(GraphRequest.USER_AGENT_HEADER, requestProperty);
            Object requestProperty2 = connection.getRequestProperty(GraphRequest.CONTENT_TYPE_HEADER);
            Intrinsics.checkNotNullExpressionValue(requestProperty2, "connection.getRequestProperty(\"Content-Type\")");
            logger.appendKeyValue(GraphRequest.CONTENT_TYPE_HEADER, requestProperty2);
            connection.setConnectTimeout(requests.getTimeoutInMilliseconds());
            connection.setReadTimeout(requests.getTimeoutInMilliseconds());
            if (httpMethod != HttpMethod.POST) {
                logger.log();
                return;
            }
            connection.setDoOutput(true);
            try {
                OutputStream bufferedOutputStream = new BufferedOutputStream(connection.getOutputStream());
                if (isGzipCompressible) {
                    try {
                        outputStream2 = new GZIPOutputStream(bufferedOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        outputStream2 = bufferedOutputStream;
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        throw th;
                    }
                } else {
                    outputStream2 = bufferedOutputStream;
                }
                if (hasOnProgressCallbacks(requests)) {
                    ProgressNoopOutputStream progressNoopOutputStream = new ProgressNoopOutputStream(requests.getCallbackHandler());
                    processRequest(requests, null, size, url, progressNoopOutputStream, isGzipCompressible);
                    outputStream = new ProgressOutputStream(outputStream2, requests, progressNoopOutputStream.getProgressMap(), progressNoopOutputStream.getMaxProgress());
                } else {
                    outputStream = outputStream2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                processRequest(requests, logger, size, url, outputStream, isGzipCompressible);
                outputStream.close();
                logger.log();
            } catch (Throwable th3) {
                th = th3;
                outputStream2 = outputStream;
                if (outputStream2 != null) {
                }
                throw th;
            }
        }

        public final HttpURLConnection toHttpConnection(GraphRequestBatch requests) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            validateFieldsParamForGetRequests$facebook_core_release(requests);
            try {
                HttpURLConnection httpURLConnection = null;
                try {
                    httpURLConnection = createConnection(requests.size() == 1 ? new URL(requests.get(0).getUrlForSingleRequest()) : new URL(ServerProtocol.getGraphUrlBase()));
                    serializeToUrlConnection$facebook_core_release(requests, httpURLConnection);
                    return httpURLConnection;
                } catch (IOException e5) {
                    Utility.disconnectQuietly(httpURLConnection);
                    throw new FacebookException("could not construct request body", e5);
                } catch (JSONException e6) {
                    Utility.disconnectQuietly(httpURLConnection);
                    throw new FacebookException("could not construct request body", e6);
                }
            } catch (MalformedURLException e7) {
                throw new FacebookException("could not construct URL for request", e7);
            }
        }

        public final void validateFieldsParamForGetRequests$facebook_core_release(GraphRequestBatch requests) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            Iterator<GraphRequest> it = requests.iterator();
            while (it.hasNext()) {
                GraphRequest next = it.next();
                if (HttpMethod.GET == next.getHttpMethod()) {
                    Utility utility = Utility.INSTANCE;
                    if (Utility.isNullOrEmpty(next.getParameters().getString("fields"))) {
                        Logger.Companion companion = Logger.INSTANCE;
                        LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
                        StringBuilder sb = new StringBuilder();
                        sb.append("GET requests for /");
                        String graphPath = next.getGraphPath();
                        if (graphPath == null) {
                            graphPath = BuildConfig.FLAVOR;
                        }
                        sb.append(graphPath);
                        sb.append(" should contain an explicit \"fields\" parameter.");
                        companion.log(loggingBehavior, 5, "Request", sb.toString());
                    }
                }
            }
        }

        private Companion() {
        }

        public final List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> requests) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            return executeBatchAndWait(new GraphRequestBatch(requests));
        }

        public final GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> requests) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            return executeBatchAsync(new GraphRequestBatch(requests));
        }

        public final List<GraphResponse> executeBatchAndWait(GraphRequestBatch requests) {
            Exception exc;
            HttpURLConnection httpURLConnection;
            List<GraphResponse> list;
            Intrinsics.checkNotNullParameter(requests, "requests");
            Validate.notEmptyAndContainsNoNulls(requests, "requests");
            HttpURLConnection httpURLConnection2 = null;
            try {
                httpURLConnection = toHttpConnection(requests);
                exc = null;
            } catch (Exception e5) {
                exc = e5;
                httpURLConnection = null;
            } catch (Throwable th) {
                th = th;
                Utility.disconnectQuietly(httpURLConnection2);
                throw th;
            }
            try {
                if (httpURLConnection != null) {
                    list = executeConnectionAndWait(httpURLConnection, requests);
                } else {
                    List<GraphResponse> constructErrorResponses = GraphResponse.INSTANCE.constructErrorResponses(requests.getRequests(), null, new FacebookException(exc));
                    runCallbacks$facebook_core_release(requests, constructErrorResponses);
                    list = constructErrorResponses;
                }
                Utility.disconnectQuietly(httpURLConnection);
                return list;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                Utility.disconnectQuietly(httpURLConnection2);
                throw th;
            }
        }

        public final GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch requests) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            Validate.notEmptyAndContainsNoNulls(requests, "requests");
            GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(requests);
            graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
            return graphRequestAsyncTask;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/facebook/GraphRequest$GraphJSONObjectCallback;", BuildConfig.FLAVOR, "onCompleted", BuildConfig.FLAVOR, "obj", "Lorg/json/JSONObject;", "response", "Lcom/facebook/GraphResponse;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public interface GraphJSONObjectCallback {
        void onCompleted(JSONObject obj, GraphResponse response);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bâ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/facebook/GraphRequest$KeyValueSerializer;", BuildConfig.FLAVOR, "writeString", BuildConfig.FLAVOR, "key", BuildConfig.FLAVOR, "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public interface KeyValueSerializer {
        void writeString(String key, String value);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u0015*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0002:\u0001\u0015B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0012\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType;", "RESOURCE", "Landroid/os/Parcelable;", "resource", "mimeType", BuildConfig.FLAVOR, "(Landroid/os/Parcelable;Ljava/lang/String;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getMimeType", "()Ljava/lang/String;", "getResource", "()Landroid/os/Parcelable;", "Landroid/os/Parcelable;", "describeContents", BuildConfig.FLAVOR, "writeToParcel", BuildConfig.FLAVOR, "out", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        private final String mimeType;
        private final RESOURCE resource;
        public static final Parcelable.Creator<ParcelableResourceWithMimeType<?>> CREATOR = new Parcelable.Creator<ParcelableResourceWithMimeType<?>>() { // from class: com.facebook.GraphRequest$ParcelableResourceWithMimeType$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GraphRequest.ParcelableResourceWithMimeType<?> createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                return new GraphRequest.ParcelableResourceWithMimeType<>(source, (DefaultConstructorMarker) null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GraphRequest.ParcelableResourceWithMimeType<?>[] newArray(int size) {
                return new GraphRequest.ParcelableResourceWithMimeType[size];
            }
        };

        public /* synthetic */ ParcelableResourceWithMimeType(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        public final RESOURCE getResource() {
            return this.resource;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.mimeType);
            out.writeParcelable(this.resource, flags);
        }

        public ParcelableResourceWithMimeType(RESOURCE resource, String str) {
            this.mimeType = str;
            this.resource = resource;
        }

        private ParcelableResourceWithMimeType(Parcel parcel) {
            this.mimeType = parcel.readString();
            this.resource = (RESOURCE) parcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150\u0014\"\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dJ$\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u00122\b\u0010 \u001a\u0004\u0018\u00010\u00122\b\u0010!\u001a\u0004\u0018\u00010\u0012J \u0010\"\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0012J \u0010&\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010\u0012J+\u0010)\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150\u0014\"\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\"\u0010*\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010\u00152\b\u0010,\u001a\u0004\u0018\u00010-J\u0006\u0010.\u001a\u00020\u0010J$\u0010/\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020-03J\u0018\u00104\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0012H\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\u00060\u000bj\u0002`\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/facebook/GraphRequest$Serializer;", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "outputStream", "Ljava/io/OutputStream;", "logger", "Lcom/facebook/internal/Logger;", "useUrlEncode", BuildConfig.FLAVOR, "(Ljava/io/OutputStream;Lcom/facebook/internal/Logger;Z)V", "firstWrite", "invalidTypeError", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "getInvalidTypeError", "()Ljava/lang/RuntimeException;", "write", BuildConfig.FLAVOR, GraphRequest.FORMAT_PARAM, BuildConfig.FLAVOR, "args", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "(Ljava/lang/String;[Ljava/lang/Object;)V", "writeBitmap", "key", "bitmap", "Landroid/graphics/Bitmap;", "writeBytes", "bytes", BuildConfig.FLAVOR, "writeContentDisposition", GraphRequest.BATCH_ENTRY_NAME_PARAM, "filename", "contentType", "writeContentUri", "contentUri", "Landroid/net/Uri;", "mimeType", "writeFile", "descriptor", "Landroid/os/ParcelFileDescriptor;", "writeLine", "writeObject", "value", "request", "Lcom/facebook/GraphRequest;", "writeRecordBoundary", "writeRequestsAsJson", "requestJsonArray", "Lorg/json/JSONArray;", "requests", BuildConfig.FLAVOR, "writeString", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Serializer implements KeyValueSerializer {
        private boolean firstWrite;
        private final Logger logger;
        private final OutputStream outputStream;
        private final boolean useUrlEncode;

        public Serializer(OutputStream outputStream, Logger logger, boolean z5) {
            Intrinsics.checkNotNullParameter(outputStream, "outputStream");
            this.outputStream = outputStream;
            this.logger = logger;
            this.firstWrite = true;
            this.useUrlEncode = z5;
        }

        private final RuntimeException getInvalidTypeError() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        public final void write(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            if (this.useUrlEncode) {
                OutputStream outputStream = this.outputStream;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Locale locale = Locale.US;
                Object[] copyOf = Arrays.copyOf(args, args.length);
                String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, format, *args)");
                String encode = URLEncoder.encode(format2, com.adjust.sdk.Constants.ENCODING);
                Intrinsics.checkNotNullExpressionValue(encode, "encode(String.format(Locale.US, format, *args), \"UTF-8\")");
                byte[] bytes = encode.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                outputStream.write(bytes);
                return;
            }
            if (this.firstWrite) {
                OutputStream outputStream2 = this.outputStream;
                Charset charset = Charsets.UTF_8;
                byte[] bytes2 = "--".getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                outputStream2.write(bytes2);
                OutputStream outputStream3 = this.outputStream;
                String str = GraphRequest.MIME_BOUNDARY;
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes3 = str.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes3, "(this as java.lang.String).getBytes(charset)");
                outputStream3.write(bytes3);
                OutputStream outputStream4 = this.outputStream;
                byte[] bytes4 = "\r\n".getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes4, "(this as java.lang.String).getBytes(charset)");
                outputStream4.write(bytes4);
                this.firstWrite = false;
            }
            OutputStream outputStream5 = this.outputStream;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            Object[] copyOf2 = Arrays.copyOf(args, args.length);
            String format3 = String.format(format, Arrays.copyOf(copyOf2, copyOf2.length));
            Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(format, *args)");
            byte[] bytes5 = format3.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes5, "(this as java.lang.String).getBytes(charset)");
            outputStream5.write(bytes5);
        }

        public final void writeBitmap(String key, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            writeContentDisposition(key, key, "image/png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.outputStream);
            writeLine(BuildConfig.FLAVOR, new Object[0]);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger == null) {
                return;
            }
            logger.appendKeyValue(Intrinsics.stringPlus("    ", key), "<Image>");
        }

        public final void writeBytes(String key, byte[] bytes) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            writeContentDisposition(key, key, "content/unknown");
            this.outputStream.write(bytes);
            writeLine(BuildConfig.FLAVOR, new Object[0]);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger == null) {
                return;
            }
            String stringPlus = Intrinsics.stringPlus("    ", key);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(bytes.length)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            logger.appendKeyValue(stringPlus, format);
        }

        public final void writeContentDisposition(String name, String filename, String contentType) {
            if (this.useUrlEncode) {
                OutputStream outputStream = this.outputStream;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%s=", Arrays.copyOf(new Object[]{name}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                byte[] bytes = format.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                outputStream.write(bytes);
                return;
            }
            write("Content-Disposition: form-data; name=\"%s\"", name);
            if (filename != null) {
                write("; filename=\"%s\"", filename);
            }
            writeLine(BuildConfig.FLAVOR, new Object[0]);
            if (contentType != null) {
                writeLine("%s: %s", GraphRequest.CONTENT_TYPE_HEADER, contentType);
            }
            writeLine(BuildConfig.FLAVOR, new Object[0]);
        }

        public final void writeContentUri(String key, Uri contentUri, String mimeType) {
            int copyAndCloseInputStream;
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(contentUri, "contentUri");
            if (mimeType == null) {
                mimeType = "content/unknown";
            }
            writeContentDisposition(key, key, mimeType);
            if (this.outputStream instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) this.outputStream).addProgress(Utility.getContentSize(contentUri));
                copyAndCloseInputStream = 0;
            } else {
                InputStream openInputStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(contentUri);
                Utility utility = Utility.INSTANCE;
                copyAndCloseInputStream = Utility.copyAndCloseInputStream(openInputStream, this.outputStream);
            }
            writeLine(BuildConfig.FLAVOR, new Object[0]);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger == null) {
                return;
            }
            String stringPlus = Intrinsics.stringPlus("    ", key);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(copyAndCloseInputStream)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            logger.appendKeyValue(stringPlus, format);
        }

        public final void writeFile(String key, ParcelFileDescriptor descriptor, String mimeType) {
            int copyAndCloseInputStream;
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            if (mimeType == null) {
                mimeType = "content/unknown";
            }
            writeContentDisposition(key, key, mimeType);
            OutputStream outputStream = this.outputStream;
            if (outputStream instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) outputStream).addProgress(descriptor.getStatSize());
                copyAndCloseInputStream = 0;
            } else {
                ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(descriptor);
                Utility utility = Utility.INSTANCE;
                copyAndCloseInputStream = Utility.copyAndCloseInputStream(autoCloseInputStream, this.outputStream);
            }
            writeLine(BuildConfig.FLAVOR, new Object[0]);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger == null) {
                return;
            }
            String stringPlus = Intrinsics.stringPlus("    ", key);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(copyAndCloseInputStream)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            logger.appendKeyValue(stringPlus, format);
        }

        public final void writeLine(String format, Object... args) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(args, "args");
            write(format, Arrays.copyOf(args, args.length));
            if (this.useUrlEncode) {
                return;
            }
            write("\r\n", new Object[0]);
        }

        public final void writeObject(String key, Object value, GraphRequest request) {
            Intrinsics.checkNotNullParameter(key, "key");
            Closeable closeable = this.outputStream;
            if (closeable instanceof RequestOutputStream) {
                ((RequestOutputStream) closeable).setCurrentRequest(request);
            }
            Companion companion = GraphRequest.INSTANCE;
            if (companion.isSupportedParameterType(value)) {
                writeString(key, companion.parameterToString(value));
                return;
            }
            if (value instanceof Bitmap) {
                writeBitmap(key, (Bitmap) value);
                return;
            }
            if (value instanceof byte[]) {
                writeBytes(key, (byte[]) value);
                return;
            }
            if (value instanceof Uri) {
                writeContentUri(key, (Uri) value, null);
                return;
            }
            if (value instanceof ParcelFileDescriptor) {
                writeFile(key, (ParcelFileDescriptor) value, null);
                return;
            }
            if (!(value instanceof ParcelableResourceWithMimeType)) {
                throw getInvalidTypeError();
            }
            ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) value;
            Parcelable resource = parcelableResourceWithMimeType.getResource();
            String mimeType = parcelableResourceWithMimeType.getMimeType();
            if (resource instanceof ParcelFileDescriptor) {
                writeFile(key, (ParcelFileDescriptor) resource, mimeType);
            } else {
                if (!(resource instanceof Uri)) {
                    throw getInvalidTypeError();
                }
                writeContentUri(key, (Uri) resource, mimeType);
            }
        }

        public final void writeRecordBoundary() {
            if (!this.useUrlEncode) {
                writeLine("--%s", GraphRequest.MIME_BOUNDARY);
                return;
            }
            OutputStream outputStream = this.outputStream;
            byte[] bytes = "&".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(bytes);
        }

        public final void writeRequestsAsJson(String key, JSONArray requestJsonArray, Collection<GraphRequest> requests) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(requestJsonArray, "requestJsonArray");
            Intrinsics.checkNotNullParameter(requests, "requests");
            Closeable closeable = this.outputStream;
            if (!(closeable instanceof RequestOutputStream)) {
                String jSONArray = requestJsonArray.toString();
                Intrinsics.checkNotNullExpressionValue(jSONArray, "requestJsonArray.toString()");
                writeString(key, jSONArray);
                return;
            }
            RequestOutputStream requestOutputStream = (RequestOutputStream) closeable;
            writeContentDisposition(key, null, null);
            write("[", new Object[0]);
            int i5 = 0;
            for (GraphRequest graphRequest : requests) {
                int i6 = i5 + 1;
                JSONObject jSONObject = requestJsonArray.getJSONObject(i5);
                requestOutputStream.setCurrentRequest(graphRequest);
                if (i5 > 0) {
                    write(",%s", jSONObject.toString());
                } else {
                    write("%s", jSONObject.toString());
                }
                i5 = i6;
            }
            write("]", new Object[0]);
            Logger logger = this.logger;
            if (logger == null) {
                return;
            }
            String stringPlus = Intrinsics.stringPlus("    ", key);
            String jSONArray2 = requestJsonArray.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "requestJsonArray.toString()");
            logger.appendKeyValue(stringPlus, jSONArray2);
        }

        @Override // com.facebook.GraphRequest.KeyValueSerializer
        public void writeString(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            writeContentDisposition(key, null, null);
            writeLine("%s", value);
            writeRecordBoundary();
            Logger logger = this.logger;
            if (logger == null) {
                return;
            }
            logger.appendKeyValue(Intrinsics.stringPlus("    ", key), value);
        }
    }

    static {
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "(this as java.lang.String).toCharArray()");
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt(11) + 30;
        if (nextInt > 0) {
            int i5 = 0;
            do {
                i5++;
                sb.append(charArray[secureRandom.nextInt(charArray.length)]);
            } while (i5 < nextInt);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "buffer.toString()");
        MIME_BOUNDARY = sb2;
        versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    }

    public /* synthetic */ GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, Callback callback, String str2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : accessToken, (i5 & 2) != 0 ? null : str, (i5 & 4) != 0 ? null : bundle, (i5 & 8) != 0 ? null : httpMethod, (i5 & 16) != 0 ? null : callback, (i5 & 32) != 0 ? null : str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _set_callback_$lambda-0, reason: not valid java name */
    public static final void m2783_set_callback_$lambda0(Callback callback, GraphResponse response) {
        int length;
        Intrinsics.checkNotNullParameter(response, "response");
        JSONObject graphObject = response.getGraphObject();
        JSONObject optJSONObject = graphObject == null ? null : graphObject.optJSONObject(DEBUG_KEY);
        JSONArray optJSONArray = optJSONObject == null ? null : optJSONObject.optJSONArray(DEBUG_MESSAGES_KEY);
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i5);
                String optString = optJSONObject2 == null ? null : optJSONObject2.optString(DEBUG_MESSAGE_KEY);
                String optString2 = optJSONObject2 == null ? null : optJSONObject2.optString(DEBUG_MESSAGE_TYPE_KEY);
                String optString3 = optJSONObject2 == null ? null : optJSONObject2.optString(DEBUG_MESSAGE_LINK_KEY);
                if (optString != null && optString2 != null) {
                    LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                    if (Intrinsics.areEqual(optString2, DEBUG_SEVERITY_WARNING)) {
                        loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                    }
                    if (!Utility.isNullOrEmpty(optString3)) {
                        optString = ((Object) optString) + " Link: " + ((Object) optString3);
                    }
                    Logger.Companion companion = Logger.INSTANCE;
                    String TAG2 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    companion.log(loggingBehavior, TAG2, optString);
                }
                if (i6 >= length) {
                    break;
                } else {
                    i5 = i6;
                }
            }
        }
        if (callback == null) {
            return;
        }
        callback.onCompleted(response);
    }

    private final void addCommonParameters() {
        Bundle bundle = this.parameters;
        if (shouldForceClientTokenForRequest()) {
            bundle.putString("access_token", getClientTokenForRequest());
        } else {
            String accessTokenToUseForRequest = getAccessTokenToUseForRequest();
            if (accessTokenToUseForRequest != null) {
                bundle.putString("access_token", accessTokenToUseForRequest);
            }
        }
        if (!bundle.containsKey("access_token")) {
            Utility utility = Utility.INSTANCE;
            if (Utility.isNullOrEmpty(FacebookSdk.getClientToken())) {
                Log.w(TAG, "Starting with v13 of the SDK, a client token must be embedded in your client code before making Graph API calls. Visit https://developers.facebook.com/docs/android/getting-started#client-token to learn how to implement this change.");
            }
        }
        bundle.putString(SDK_PARAM, SDK_ANDROID);
        bundle.putString(FORMAT_PARAM, FORMAT_JSON);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            bundle.putString(DEBUG_PARAM, DEBUG_SEVERITY_INFO);
        } else if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            bundle.putString(DEBUG_PARAM, DEBUG_SEVERITY_WARNING);
        }
    }

    private final String appendParametersToBaseUrl(String baseUrl, boolean isBatch) {
        if (!isBatch && this.httpMethod == HttpMethod.POST) {
            return baseUrl;
        }
        Uri.Builder buildUpon = Uri.parse(baseUrl).buildUpon();
        for (String str : this.parameters.keySet()) {
            Object obj = this.parameters.get(str);
            if (obj == null) {
                obj = BuildConfig.FLAVOR;
            }
            Companion companion = INSTANCE;
            if (companion.isSupportedParameterType(obj)) {
                buildUpon.appendQueryParameter(str, companion.parameterToString(obj).toString());
            } else if (this.httpMethod != HttpMethod.GET) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.US, "Unsupported parameter type for GET request: %s", Arrays.copyOf(new Object[]{obj.getClass().getSimpleName()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                throw new IllegalArgumentException(format);
            }
        }
        String builder = buildUpon.toString();
        Intrinsics.checkNotNullExpressionValue(builder, "uriBuilder.toString()");
        return builder;
    }

    private final String getAccessTokenToUseForRequest() {
        AccessToken accessToken = this.accessToken;
        if (accessToken != null) {
            if (!this.parameters.containsKey("access_token")) {
                String token = accessToken.getToken();
                Logger.INSTANCE.registerAccessToken(token);
                return token;
            }
        } else if (!this.parameters.containsKey("access_token")) {
            return getClientTokenForRequest();
        }
        return this.parameters.getString("access_token");
    }

    private final String getClientTokenForRequest() {
        String applicationId = FacebookSdk.getApplicationId();
        String clientToken = FacebookSdk.getClientToken();
        if (applicationId.length() <= 0 || clientToken.length() <= 0) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, "Warning: Request without access token missing application ID or client token.");
            return null;
        }
        return applicationId + '|' + clientToken;
    }

    private final String getGraphPathWithVersion() {
        if (versionPattern.matcher(this.graphPath).matches()) {
            return this.graphPath;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s/%s", Arrays.copyOf(new Object[]{this.version, this.graphPath}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    private final String getUrlWithGraphPath(String baseUrl) {
        if (!isValidGraphRequestForDomain()) {
            baseUrl = ServerProtocol.getFacebookGraphUrlBase();
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s/%s", Arrays.copyOf(new Object[]{baseUrl, getGraphPathWithVersion()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    private final boolean isApplicationRequest() {
        if (this.graphPath == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("^/?");
        sb.append(FacebookSdk.getApplicationId());
        sb.append("/?.*");
        return this.forceApplicationRequest || Pattern.matches(sb.toString(), this.graphPath) || Pattern.matches("^/?app/?.*", this.graphPath);
    }

    private final boolean isValidGraphRequestForDomain() {
        if (Intrinsics.areEqual(FacebookSdk.getGraphDomain(), "instagram.com")) {
            return !isApplicationRequest();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void serializeToBatch(JSONArray batch, Map<String, Attachment> attachments) {
        JSONObject jSONObject = new JSONObject();
        String str = this.batchEntryName;
        if (str != null) {
            jSONObject.put(BATCH_ENTRY_NAME_PARAM, str);
            jSONObject.put(BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM, this.batchEntryOmitResultOnSuccess);
        }
        String str2 = this.batchEntryDependsOn;
        if (str2 != null) {
            jSONObject.put(BATCH_ENTRY_DEPENDS_ON_PARAM, str2);
        }
        String relativeUrlForBatchedRequest = getRelativeUrlForBatchedRequest();
        jSONObject.put(BATCH_RELATIVE_URL_PARAM, relativeUrlForBatchedRequest);
        jSONObject.put(BATCH_METHOD_PARAM, this.httpMethod);
        AccessToken accessToken = this.accessToken;
        if (accessToken != null) {
            Logger.INSTANCE.registerAccessToken(accessToken.getToken());
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.parameters.keySet().iterator();
        while (it.hasNext()) {
            Object obj = this.parameters.get(it.next());
            if (INSTANCE.isSupportedAttachmentType(obj)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.ROOT, "%s%d", Arrays.copyOf(new Object[]{ATTACHMENT_FILENAME_PREFIX, Integer.valueOf(attachments.size())}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                arrayList.add(format);
                attachments.put(format, new Attachment(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put(ATTACHED_FILES_PARAM, TextUtils.join(",", arrayList));
        }
        JSONObject jSONObject2 = this.graphObject;
        if (jSONObject2 != null) {
            final ArrayList arrayList2 = new ArrayList();
            INSTANCE.processGraphObject(jSONObject2, relativeUrlForBatchedRequest, new KeyValueSerializer() { // from class: com.facebook.GraphRequest$serializeToBatch$1
                @Override // com.facebook.GraphRequest.KeyValueSerializer
                public void writeString(String key, String value) {
                    Intrinsics.checkNotNullParameter(key, "key");
                    Intrinsics.checkNotNullParameter(value, "value");
                    ArrayList<String> arrayList3 = arrayList2;
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String format2 = String.format(Locale.US, "%s=%s", Arrays.copyOf(new Object[]{key, URLEncoder.encode(value, com.adjust.sdk.Constants.ENCODING)}, 2));
                    Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, format, *args)");
                    arrayList3.add(format2);
                }
            });
            jSONObject.put("body", TextUtils.join("&", arrayList2));
        }
        batch.put(jSONObject);
    }

    private final boolean shouldForceClientTokenForRequest() {
        String accessTokenToUseForRequest = getAccessTokenToUseForRequest();
        boolean contains$default = accessTokenToUseForRequest == null ? false : StringsKt.contains$default((CharSequence) accessTokenToUseForRequest, (CharSequence) "|", false, 2, (Object) null);
        if (accessTokenToUseForRequest == null || !StringsKt.startsWith$default(accessTokenToUseForRequest, "IG", false, 2, (Object) null) || contains$default || !isApplicationRequest()) {
            return (isValidGraphRequestForDomain() || contains$default) ? false : true;
        }
        return true;
    }

    public final GraphResponse executeAndWait() {
        return INSTANCE.executeAndWait(this);
    }

    public final GraphRequestAsyncTask executeAsync() {
        return INSTANCE.executeBatchAsync(this);
    }

    public final AccessToken getAccessToken() {
        return this.accessToken;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final JSONObject getGraphObject() {
        return this.graphObject;
    }

    public final String getGraphPath() {
        return this.graphPath;
    }

    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public final Bundle getParameters() {
        return this.parameters;
    }

    public final String getRelativeUrlForBatchedRequest() {
        if (this.overriddenURL != null) {
            throw new FacebookException("Can't override URL for a batch request");
        }
        String urlWithGraphPath = getUrlWithGraphPath(ServerProtocol.getGraphUrlBase());
        addCommonParameters();
        Uri parse = Uri.parse(appendParametersToBaseUrl(urlWithGraphPath, true));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s?%s", Arrays.copyOf(new Object[]{parse.getPath(), parse.getQuery()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final String getUrlForSingleRequest() {
        String graphUrlBaseForSubdomain;
        String str = this.overriddenURL;
        if (str != null) {
            return String.valueOf(str);
        }
        String str2 = this.graphPath;
        if (this.httpMethod == HttpMethod.POST && str2 != null && StringsKt.endsWith$default(str2, VIDEOS_SUFFIX, false, 2, (Object) null)) {
            graphUrlBaseForSubdomain = ServerProtocol.getGraphVideoUrlBase();
        } else {
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            graphUrlBaseForSubdomain = ServerProtocol.getGraphUrlBaseForSubdomain(FacebookSdk.getGraphDomain());
        }
        String urlWithGraphPath = getUrlWithGraphPath(graphUrlBaseForSubdomain);
        addCommonParameters();
        return appendParametersToBaseUrl(urlWithGraphPath, false);
    }

    public final void setCallback(final Callback callback) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO) || FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.callback = new Callback() { // from class: d0.m
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    GraphRequest.m2783_set_callback_$lambda0(GraphRequest.Callback.this, graphResponse);
                }
            };
        } else {
            this.callback = callback;
        }
    }

    public final void setForceApplicationRequest(boolean forceOverride) {
        this.forceApplicationRequest = forceOverride;
    }

    public final void setGraphObject(JSONObject jSONObject) {
        this.graphObject = jSONObject;
    }

    public final void setHttpMethod(HttpMethod httpMethod) {
        if (this.overriddenURL != null && httpMethod != HttpMethod.GET) {
            throw new FacebookException("Can't change HTTP method on request with overridden URL.");
        }
        if (httpMethod == null) {
            httpMethod = HttpMethod.GET;
        }
        this.httpMethod = httpMethod;
    }

    public final void setParameters(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<set-?>");
        this.parameters = bundle;
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{Request: ");
        sb.append(" accessToken: ");
        Object obj = this.accessToken;
        if (obj == null) {
            obj = "null";
        }
        sb.append(obj);
        sb.append(", graphPath: ");
        sb.append(this.graphPath);
        sb.append(", graphObject: ");
        sb.append(this.graphObject);
        sb.append(", httpMethod: ");
        sb.append(this.httpMethod);
        sb.append(", parameters: ");
        sb.append(this.parameters);
        sb.append("}");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder()\n        .append(\"{Request: \")\n        .append(\" accessToken: \")\n        .append(if (accessToken == null) \"null\" else accessToken)\n        .append(\", graphPath: \")\n        .append(graphPath)\n        .append(\", graphObject: \")\n        .append(graphObject)\n        .append(\", httpMethod: \")\n        .append(httpMethod)\n        .append(\", parameters: \")\n        .append(parameters)\n        .append(\"}\")\n        .toString()");
        return sb2;
    }

    public GraphRequest(AccessToken accessToken, String str, Bundle bundle, HttpMethod httpMethod, Callback callback, String str2) {
        this.batchEntryOmitResultOnSuccess = true;
        this.accessToken = accessToken;
        this.graphPath = str;
        this.version = str2;
        setCallback(callback);
        setHttpMethod(httpMethod);
        if (bundle != null) {
            this.parameters = new Bundle(bundle);
        } else {
            this.parameters = new Bundle();
        }
        if (this.version == null) {
            this.version = FacebookSdk.getGraphApiVersion();
        }
    }
}
