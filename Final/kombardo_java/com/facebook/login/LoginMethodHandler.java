package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u000e\b'\u0018\u0000 B2\u00020\u0001:\u0001BB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0014\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001eH\u0014¢\u0006\u0004\b\"\u0010#J#\u0010'\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\u001e2\b\u0010&\u001a\u0004\u0018\u00010%H\u0014¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010\u001eH\u0014¢\u0006\u0004\b*\u0010+J\u001f\u0010.\u001a\u00020,2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010-\u001a\u00020,H\u0014¢\u0006\u0004\b.\u0010/J\u001f\u00102\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u000bH\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0012H\u0016¢\u0006\u0004\b4\u0010\u0016R4\u00106\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010\u0005R\u0014\u0010A\u001a\u00020\u001e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010 ¨\u0006C"}, d2 = {"Lcom/facebook/login/LoginMethodHandler;", "Landroid/os/Parcelable;", "Lcom/facebook/login/LoginClient;", "loginClient", "<init>", "(Lcom/facebook/login/LoginClient;)V", "Landroid/os/Parcel;", "source", "(Landroid/os/Parcel;)V", "Lcom/facebook/login/LoginClient$Request;", "request", BuildConfig.FLAVOR, "tryAuthorize", "(Lcom/facebook/login/LoginClient$Request;)I", "requestCode", "resultCode", "Landroid/content/Intent;", "data", BuildConfig.FLAVOR, "onActivityResult", "(IILandroid/content/Intent;)Z", "needsInternetPermission", "()Z", BuildConfig.FLAVOR, "cancel", "()V", "Lorg/json/JSONObject;", "param", "putChallengeParam", "(Lorg/json/JSONObject;)V", BuildConfig.FLAVOR, "getRedirectUrl", "()Ljava/lang/String;", "authId", "getClientState", "(Ljava/lang/String;)Ljava/lang/String;", "key", BuildConfig.FLAVOR, "value", "addLoggingExtra", "(Ljava/lang/String;Ljava/lang/Object;)V", "e2e", "logWebLoginCompleted", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "values", "processCodeExchange", "(Lcom/facebook/login/LoginClient$Request;Landroid/os/Bundle;)Landroid/os/Bundle;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "shouldKeepTrackOfMultipleIntents", BuildConfig.FLAVOR, "methodLoggingExtras", "Ljava/util/Map;", "getMethodLoggingExtras", "()Ljava/util/Map;", "setMethodLoggingExtras", "(Ljava/util/Map;)V", "Lcom/facebook/login/LoginClient;", "getLoginClient", "()Lcom/facebook/login/LoginClient;", "setLoginClient", "getNameForLogging", "nameForLogging", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class LoginMethodHandler implements Parcelable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public LoginClient loginClient;
    private Map<String, String> methodLoggingExtras;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J6\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/facebook/login/LoginMethodHandler$Companion;", BuildConfig.FLAVOR, "()V", "NO_SIGNED_REQUEST_ERROR_MESSAGE", BuildConfig.FLAVOR, "NO_USER_ID_ERROR_MESSAGE", "USER_CANCELED_LOG_IN_ERROR_MESSAGE", "createAccessTokenFromNativeLogin", "Lcom/facebook/AccessToken;", "bundle", "Landroid/os/Bundle;", "source", "Lcom/facebook/AccessTokenSource;", "applicationId", "createAccessTokenFromWebBundle", "requestedPermissions", BuildConfig.FLAVOR, "createAuthenticationTokenFromNativeLogin", "Lcom/facebook/AuthenticationToken;", "expectedNonce", "createAuthenticationTokenFromWebBundle", "getUserIDFromSignedRequest", "signedRequest", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AccessToken createAccessTokenFromNativeLogin(Bundle bundle, AccessTokenSource source, String applicationId) {
            String string;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Utility utility = Utility.INSTANCE;
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L));
            ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            String string2 = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", new Date(0L));
            if (string2 == null || string2.length() == 0 || (string = bundle.getString("com.facebook.platform.extra.USER_ID")) == null || string.length() == 0) {
                return null;
            }
            return new AccessToken(string2, applicationId, string, stringArrayList, null, null, source, bundleLongAsDate, new Date(), bundleLongAsDate2, bundle.getString("graph_domain"));
        }

        public final AccessToken createAccessTokenFromWebBundle(Collection<String> requestedPermissions, Bundle bundle, AccessTokenSource source, String applicationId) {
            Collection<String> collection;
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Utility utility = Utility.INSTANCE;
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, "expires_in", new Date());
            String string = bundle.getString("access_token");
            if (string == null) {
                return null;
            }
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, "data_access_expiration_time", new Date(0L));
            String string2 = bundle.getString("granted_scopes");
            if (string2 == null || string2.length() <= 0) {
                collection = requestedPermissions;
            } else {
                Object[] array = StringsKt.split$default((CharSequence) string2, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                String[] strArr = (String[]) array;
                collection = CollectionsKt.arrayListOf(Arrays.copyOf(strArr, strArr.length));
            }
            String string3 = bundle.getString("denied_scopes");
            if (string3 == null || string3.length() <= 0) {
                arrayList = null;
            } else {
                Object[] array2 = StringsKt.split$default((CharSequence) string3, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                String[] strArr2 = (String[]) array2;
                arrayList = CollectionsKt.arrayListOf(Arrays.copyOf(strArr2, strArr2.length));
            }
            String string4 = bundle.getString("expired_scopes");
            if (string4 == null || string4.length() <= 0) {
                arrayList2 = null;
            } else {
                Object[] array3 = StringsKt.split$default((CharSequence) string4, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                String[] strArr3 = (String[]) array3;
                arrayList2 = CollectionsKt.arrayListOf(Arrays.copyOf(strArr3, strArr3.length));
            }
            if (Utility.isNullOrEmpty(string)) {
                return null;
            }
            return new AccessToken(string, applicationId, getUserIDFromSignedRequest(bundle.getString("signed_request")), collection, arrayList, arrayList2, source, bundleLongAsDate, new Date(), bundleLongAsDate2, bundle.getString("graph_domain"));
        }

        public final AuthenticationToken createAuthenticationTokenFromNativeLogin(Bundle bundle, String expectedNonce) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString("com.facebook.platform.extra.ID_TOKEN");
            if (string == null || string.length() == 0 || expectedNonce == null || expectedNonce.length() == 0) {
                return null;
            }
            try {
                return new AuthenticationToken(string, expectedNonce);
            } catch (Exception e5) {
                throw new FacebookException(e5.getMessage());
            }
        }

        public final AuthenticationToken createAuthenticationTokenFromWebBundle(Bundle bundle, String expectedNonce) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString("id_token");
            if (string == null || string.length() == 0 || expectedNonce == null || expectedNonce.length() == 0) {
                return null;
            }
            try {
                return new AuthenticationToken(string, expectedNonce);
            } catch (Exception e5) {
                throw new FacebookException(e5.getMessage(), e5);
            }
        }

        public final String getUserIDFromSignedRequest(String signedRequest) {
            Object[] array;
            if (signedRequest == null || signedRequest.length() == 0) {
                throw new FacebookException("Authorization response does not contain the signed_request");
            }
            try {
                array = StringsKt.split$default((CharSequence) signedRequest, new String[]{"."}, false, 0, 6, (Object) null).toArray(new String[0]);
            } catch (UnsupportedEncodingException | JSONException unused) {
            }
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            if (strArr.length == 2) {
                byte[] data = Base64.decode(strArr[1], 0);
                Intrinsics.checkNotNullExpressionValue(data, "data");
                String string = new JSONObject(new String(data, Charsets.UTF_8)).getString("user_id");
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"user_id\")");
                return string;
            }
            throw new FacebookException("Failed to retrieve user_id from signed_request");
        }

        private Companion() {
        }
    }

    public LoginMethodHandler(LoginClient loginClient) {
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        setLoginClient(loginClient);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addLoggingExtra(String key, Object value) {
        if (this.methodLoggingExtras == null) {
            this.methodLoggingExtras = new HashMap();
        }
        Map<String, String> map = this.methodLoggingExtras;
        if (map == null) {
            return;
        }
        map.put(key, value == null ? null : value.toString());
    }

    public void cancel() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getClientState(String authId) {
        Intrinsics.checkNotNullParameter(authId, "authId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0_auth_logger_id", authId);
            jSONObject.put("3_method", getNameForLogging());
            putChallengeParam(jSONObject);
        } catch (JSONException e5) {
            Log.w("LoginMethodHandler", Intrinsics.stringPlus("Error creating client state json: ", e5.getMessage()));
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "param.toString()");
        return jSONObject2;
    }

    public final LoginClient getLoginClient() {
        LoginClient loginClient = this.loginClient;
        if (loginClient != null) {
            return loginClient;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loginClient");
        throw null;
    }

    public final Map<String, String> getMethodLoggingExtras() {
        return this.methodLoggingExtras;
    }

    public abstract String getNameForLogging();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: getRedirectUrl */
    public String getValidRedirectURI() {
        return "fb" + FacebookSdk.getApplicationId() + "://authorize/";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void logWebLoginCompleted(String e2e) {
        LoginClient.Request pendingRequest = getLoginClient().getPendingRequest();
        String applicationId = pendingRequest == null ? null : pendingRequest.getApplicationId();
        if (applicationId == null) {
            applicationId = FacebookSdk.getApplicationId();
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(getLoginClient().getActivity(), applicationId);
        Bundle bundle = new Bundle();
        bundle.putString("fb_web_login_e2e", e2e);
        bundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        bundle.putString("app_id", applicationId);
        internalAppEventsLogger.logEventImplicitly("fb_dialogs_web_login_dialog_complete", null, bundle);
    }

    public boolean needsInternetPermission() {
        return false;
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle processCodeExchange(LoginClient.Request request, Bundle values) {
        GraphRequest createCodeExchangeRequest;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(values, "values");
        String string = values.getString("code");
        if (Utility.isNullOrEmpty(string)) {
            throw new FacebookException("No code param found from the request");
        }
        if (string == null) {
            createCodeExchangeRequest = null;
        } else {
            PKCEUtil pKCEUtil = PKCEUtil.INSTANCE;
            String validRedirectURI = getValidRedirectURI();
            String codeVerifier = request.getCodeVerifier();
            if (codeVerifier == null) {
                codeVerifier = BuildConfig.FLAVOR;
            }
            createCodeExchangeRequest = PKCEUtil.createCodeExchangeRequest(string, validRedirectURI, codeVerifier);
        }
        if (createCodeExchangeRequest == null) {
            throw new FacebookException("Failed to create code exchange request");
        }
        GraphResponse executeAndWait = createCodeExchangeRequest.executeAndWait();
        FacebookRequestError error = executeAndWait.getError();
        if (error != null) {
            throw new FacebookServiceException(error, error.getErrorMessage());
        }
        try {
            JSONObject graphObject = executeAndWait.getGraphObject();
            String string2 = graphObject != null ? graphObject.getString("access_token") : null;
            if (graphObject == null || Utility.isNullOrEmpty(string2)) {
                throw new FacebookException("No access token found from result");
            }
            values.putString("access_token", string2);
            if (graphObject.has("id_token")) {
                values.putString("id_token", graphObject.getString("id_token"));
            }
            return values;
        } catch (JSONException e5) {
            throw new FacebookException(Intrinsics.stringPlus("Fail to process code exchange response: ", e5.getMessage()));
        }
    }

    public void putChallengeParam(JSONObject param) {
        Intrinsics.checkNotNullParameter(param, "param");
    }

    public final void setLoginClient(LoginClient loginClient) {
        Intrinsics.checkNotNullParameter(loginClient, "<set-?>");
        this.loginClient = loginClient;
    }

    public boolean shouldKeepTrackOfMultipleIntents() {
        return false;
    }

    public abstract int tryAuthorize(LoginClient.Request request);

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        Utility utility = Utility.INSTANCE;
        Utility.writeStringMapToParcel(dest, this.methodLoggingExtras);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LoginMethodHandler(Parcel source) {
        Intrinsics.checkNotNullParameter(source, "source");
        Map<String, String> readStringMapFromParcel = Utility.readStringMapFromParcel(source);
        this.methodLoggingExtras = readStringMapFromParcel == null ? null : MapsKt.toMutableMap(readStringMapFromParcel);
    }
}
