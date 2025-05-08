package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.net.HttpURLConnection;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 H2\u00020\u0001:\u0003IHJB\u0083\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017B#\b\u0017\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u000e\u0010\u001a\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019¢\u0006\u0004\b\u0016\u0010\u001bB%\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0016\u0010\u001dB\u0011\b\u0012\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u0016\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0002H\u0016¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010)R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010*\u001a\u0004\b,\u0010)R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b-\u0010)R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010.\u001a\u0004\b/\u0010\"R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010.\u001a\u0004\b0\u0010\"R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010.\u001a\u0004\b1\u0010\"R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u00102\u001a\u0004\b3\u00104R\u0019\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\r\u00102\u001a\u0004\b5\u00104R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u00106\u001a\u0004\b7\u00108R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u00109\u001a\u0004\b:\u0010;R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00068F¢\u0006\f\n\u0004\b\u001c\u0010.\u001a\u0004\b<\u0010\"R(\u0010\u001a\u001a\u0004\u0018\u00010\u00122\b\u0010=\u001a\u0004\u0018\u00010\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010B\u001a\u00020A8\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0019\u0010F\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\bF\u0010.\u001a\u0004\bG\u0010\"¨\u0006K"}, d2 = {"Lcom/facebook/FacebookRequestError;", "Landroid/os/Parcelable;", BuildConfig.FLAVOR, "requestStatusCode", "errorCode", "subErrorCode", BuildConfig.FLAVOR, "errorType", "errorMessageField", "errorUserTitle", "errorUserMessage", "Lorg/json/JSONObject;", "requestResultBody", "requestResult", BuildConfig.FLAVOR, "batchRequestResult", "Ljava/net/HttpURLConnection;", "connection", "Lcom/facebook/FacebookException;", "exceptionField", BuildConfig.FLAVOR, "errorIsTransient", "<init>", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/Object;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;Z)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "(Ljava/net/HttpURLConnection;Ljava/lang/Exception;)V", "errorMessage", "(ILjava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "toString", "()Ljava/lang/String;", "out", "flags", BuildConfig.FLAVOR, "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "I", "getRequestStatusCode", "getErrorCode", "getSubErrorCode", "Ljava/lang/String;", "getErrorType", "getErrorUserTitle", "getErrorUserMessage", "Lorg/json/JSONObject;", "getRequestResultBody", "()Lorg/json/JSONObject;", "getRequestResult", "Ljava/lang/Object;", "getBatchRequestResult", "()Ljava/lang/Object;", "Ljava/net/HttpURLConnection;", "getConnection", "()Ljava/net/HttpURLConnection;", "getErrorMessage", "<set-?>", "Lcom/facebook/FacebookException;", "getException", "()Lcom/facebook/FacebookException;", "Lcom/facebook/FacebookRequestError$Category;", "category", "Lcom/facebook/FacebookRequestError$Category;", "getCategory", "()Lcom/facebook/FacebookRequestError$Category;", "errorRecoveryMessage", "getErrorRecoveryMessage", "Companion", "Category", "Range", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FacebookRequestError implements Parcelable {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    private static final String ERROR_CODE_FIELD_KEY = "code";
    private static final String ERROR_CODE_KEY = "error_code";
    private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
    private static final String ERROR_KEY = "error";
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";
    private static final String ERROR_MSG_KEY = "error_msg";
    private static final String ERROR_REASON_KEY = "error_reason";
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";
    private static final String ERROR_TYPE_FIELD_KEY = "type";
    private static final String ERROR_USER_MSG_KEY = "error_user_msg";
    private static final String ERROR_USER_TITLE_KEY = "error_user_title";
    private final Object batchRequestResult;
    private final Category category;
    private final HttpURLConnection connection;
    private final int errorCode;
    private final String errorMessage;
    private final String errorRecoveryMessage;
    private final String errorType;
    private final String errorUserMessage;
    private final String errorUserTitle;
    private FacebookException exception;
    private final JSONObject requestResult;
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final int subErrorCode;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Range HTTP_RANGE_SUCCESS = new Range(200, 299);
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new Parcelable.Creator<FacebookRequestError>() { // from class: com.facebook.FacebookRequestError$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FacebookRequestError createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FacebookRequestError(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FacebookRequestError[] newArray(int size) {
            return new FacebookRequestError[size];
        }
    };

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/FacebookRequestError$Category;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "LOGIN_RECOVERABLE", "OTHER", "TRANSIENT", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Category[] valuesCustom() {
            Category[] valuesCustom = values();
            return (Category[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00012\b\u0010#\u001a\u0004\u0018\u00010$H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006%"}, d2 = {"Lcom/facebook/FacebookRequestError$Companion;", BuildConfig.FLAVOR, "()V", "BODY_KEY", BuildConfig.FLAVOR, "CODE_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/FacebookRequestError;", "ERROR_CODE_FIELD_KEY", "ERROR_CODE_KEY", "ERROR_IS_TRANSIENT_KEY", "ERROR_KEY", "ERROR_MESSAGE_FIELD_KEY", "ERROR_MSG_KEY", "ERROR_REASON_KEY", "ERROR_SUB_CODE_KEY", "ERROR_TYPE_FIELD_KEY", "ERROR_USER_MSG_KEY", "ERROR_USER_TITLE_KEY", "HTTP_RANGE_SUCCESS", "Lcom/facebook/FacebookRequestError$Range;", "getHTTP_RANGE_SUCCESS$facebook_core_release", "()Lcom/facebook/FacebookRequestError$Range;", "INVALID_ERROR_CODE", BuildConfig.FLAVOR, "INVALID_HTTP_STATUS_CODE", "errorClassification", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "getErrorClassification", "()Lcom/facebook/internal/FacebookRequestErrorClassification;", "checkResponseAndCreateError", "singleResult", "Lorg/json/JSONObject;", "batchResult", "connection", "Ljava/net/HttpURLConnection;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00d2 A[Catch: JSONException -> 0x0127, TryCatch #0 {JSONException -> 0x0127, blocks: (B:3:0x0013, B:5:0x0019, B:7:0x0023, B:9:0x0027, B:12:0x0035, B:30:0x00d2, B:33:0x0079, B:34:0x0070, B:35:0x0066, B:36:0x005e, B:37:0x0057, B:38:0x004d, B:39:0x0042, B:40:0x0086, B:43:0x0093, B:45:0x009c, B:49:0x00ad, B:50:0x00f3, B:52:0x00fd, B:54:0x0105, B:55:0x010e), top: B:2:0x0013 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final FacebookRequestError checkResponseAndCreateError(JSONObject singleResult, Object batchResult, HttpURLConnection connection) {
            String optString;
            int optInt;
            boolean z5;
            String str;
            String str2;
            String str3;
            String str4;
            Intrinsics.checkNotNullParameter(singleResult, "singleResult");
            try {
                if (singleResult.has("code")) {
                    int i5 = singleResult.getInt("code");
                    Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(singleResult, "body", "FACEBOOK_NON_JSON_RESULT");
                    if (stringPropertyAsJSON != null && (stringPropertyAsJSON instanceof JSONObject)) {
                        boolean z6 = false;
                        int i6 = -1;
                        if (((JSONObject) stringPropertyAsJSON).has(FacebookRequestError.ERROR_KEY)) {
                            JSONObject jSONObject = (JSONObject) Utility.getStringPropertyAsJSON((JSONObject) stringPropertyAsJSON, FacebookRequestError.ERROR_KEY, null);
                            optString = jSONObject == null ? null : jSONObject.optString(FacebookRequestError.ERROR_TYPE_FIELD_KEY, null);
                            String optString2 = jSONObject == null ? null : jSONObject.optString(FacebookRequestError.ERROR_MESSAGE_FIELD_KEY, null);
                            int optInt2 = jSONObject == null ? -1 : jSONObject.optInt("code", -1);
                            if (jSONObject != null) {
                                i6 = jSONObject.optInt(FacebookRequestError.ERROR_SUB_CODE_KEY, -1);
                            }
                            str = jSONObject == null ? null : jSONObject.optString(FacebookRequestError.ERROR_USER_MSG_KEY, null);
                            str2 = jSONObject == null ? null : jSONObject.optString(FacebookRequestError.ERROR_USER_TITLE_KEY, null);
                            if (jSONObject != null) {
                                z6 = jSONObject.optBoolean(FacebookRequestError.ERROR_IS_TRANSIENT_KEY, false);
                            }
                            z5 = z6;
                            z6 = true;
                            str3 = optString2;
                            optInt = i6;
                            i6 = optInt2;
                        } else {
                            if (!((JSONObject) stringPropertyAsJSON).has(FacebookRequestError.ERROR_CODE_KEY) && !((JSONObject) stringPropertyAsJSON).has(FacebookRequestError.ERROR_MSG_KEY) && !((JSONObject) stringPropertyAsJSON).has(FacebookRequestError.ERROR_REASON_KEY)) {
                                z5 = false;
                                optInt = -1;
                                str4 = null;
                                str3 = null;
                                str = null;
                                str2 = null;
                                if (z6) {
                                    return new FacebookRequestError(i5, i6, optInt, str4, str3, str2, str, (JSONObject) stringPropertyAsJSON, singleResult, batchResult, connection, null, z5, null);
                                }
                            }
                            optString = ((JSONObject) stringPropertyAsJSON).optString(FacebookRequestError.ERROR_REASON_KEY, null);
                            String optString3 = ((JSONObject) stringPropertyAsJSON).optString(FacebookRequestError.ERROR_MSG_KEY, null);
                            int optInt3 = ((JSONObject) stringPropertyAsJSON).optInt(FacebookRequestError.ERROR_CODE_KEY, -1);
                            optInt = ((JSONObject) stringPropertyAsJSON).optInt(FacebookRequestError.ERROR_SUB_CODE_KEY, -1);
                            i6 = optInt3;
                            z5 = false;
                            str = null;
                            str2 = null;
                            z6 = true;
                            str3 = optString3;
                        }
                        str4 = optString;
                        if (z6) {
                        }
                    }
                    if (!getHTTP_RANGE_SUCCESS$facebook_core_release().contains(i5)) {
                        return new FacebookRequestError(i5, -1, -1, null, null, null, null, singleResult.has("body") ? (JSONObject) Utility.getStringPropertyAsJSON(singleResult, "body", "FACEBOOK_NON_JSON_RESULT") : null, singleResult, batchResult, connection, null, false, null);
                    }
                }
            } catch (JSONException unused) {
            }
            return null;
        }

        public final synchronized FacebookRequestErrorClassification getErrorClassification() {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                return FacebookRequestErrorClassification.INSTANCE.getDefaultErrorClassification();
            }
            return appSettingsWithoutQuery.getErrorClassification();
        }

        public final Range getHTTP_RANGE_SUCCESS$facebook_core_release() {
            return FacebookRequestError.HTTP_RANGE_SUCCESS;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0086\u0002R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/FacebookRequestError$Range;", BuildConfig.FLAVOR, "start", BuildConfig.FLAVOR, "end", "(II)V", "contains", BuildConfig.FLAVOR, "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Range {
        private final int end;
        private final int start;

        public Range(int i5, int i6) {
            this.start = i5;
            this.end = i6;
        }

        public final boolean contains(int value) {
            return value <= this.end && this.start <= value;
        }
    }

    public /* synthetic */ FacebookRequestError(int i5, int i6, int i7, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5, i6, i7, str, str2, str3, str4, jSONObject, jSONObject2, obj, httpURLConnection, facebookException, z5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        String str = this.errorMessage;
        if (str != null) {
            return str;
        }
        FacebookException facebookException = this.exception;
        if (facebookException == null) {
            return null;
        }
        return facebookException.getLocalizedMessage();
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final FacebookException getException() {
        return this.exception;
    }

    public final int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public final int getSubErrorCode() {
        return this.subErrorCode;
    }

    public String toString() {
        String str = "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", subErrorCode: " + this.subErrorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder(\"{HttpStatus: \")\n        .append(requestStatusCode)\n        .append(\", errorCode: \")\n        .append(errorCode)\n        .append(\", subErrorCode: \")\n        .append(subErrorCode)\n        .append(\", errorType: \")\n        .append(errorType)\n        .append(\", errorMessage: \")\n        .append(errorMessage)\n        .append(\"}\")\n        .toString()");
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.requestStatusCode);
        out.writeInt(this.errorCode);
        out.writeInt(this.subErrorCode);
        out.writeString(this.errorType);
        out.writeString(getErrorMessage());
        out.writeString(this.errorUserTitle);
        out.writeString(this.errorUserMessage);
    }

    public /* synthetic */ FacebookRequestError(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private FacebookRequestError(int i5, int i6, int i7, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException, boolean z5) {
        Category classify;
        this.requestStatusCode = i5;
        this.errorCode = i6;
        this.subErrorCode = i7;
        this.errorType = str;
        this.errorUserTitle = str3;
        this.errorUserMessage = str4;
        this.requestResultBody = jSONObject;
        this.requestResult = jSONObject2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        this.errorMessage = str2;
        if (facebookException != null) {
            this.exception = facebookException;
            classify = Category.OTHER;
        } else {
            this.exception = new FacebookServiceException(this, getErrorMessage());
            classify = INSTANCE.getErrorClassification().classify(i6, i7, z5);
        }
        this.category = classify;
        this.errorRecoveryMessage = INSTANCE.getErrorClassification().getRecoveryMessage(classify);
    }

    public FacebookRequestError(HttpURLConnection httpURLConnection, Exception exc) {
        this(-1, -1, -1, null, null, null, null, null, null, null, httpURLConnection, exc instanceof FacebookException ? (FacebookException) exc : new FacebookException(exc), false);
    }

    public FacebookRequestError(int i5, String str, String str2) {
        this(-1, i5, -1, str, str2, null, null, null, null, null, null, null, false);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), null, null, null, null, null, false);
    }
}
