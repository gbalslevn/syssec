package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\n\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0014J\n\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0002J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0017J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/facebook/login/WebLoginMethodHandler;", "Lcom/facebook/login/LoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "e2e", BuildConfig.FLAVOR, "tokenSource", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "addExtraParameters", "Landroid/os/Bundle;", "parameters", "request", "Lcom/facebook/login/LoginClient$Request;", "getParameters", "getSSODevice", "loadCookieToken", "onComplete", BuildConfig.FLAVOR, "values", "error", "Lcom/facebook/FacebookException;", "saveCookieToken", "token", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class WebLoginMethodHandler extends LoginMethodHandler {
    private static final String WEB_VIEW_AUTH_HANDLER_STORE = "com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY";
    private static final String WEB_VIEW_AUTH_HANDLER_TOKEN_KEY = "TOKEN";
    private String e2e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
    }

    private final String loadCookieToken() {
        Context activity = getLoginClient().getActivity();
        if (activity == null) {
            activity = FacebookSdk.getApplicationContext();
        }
        return activity.getSharedPreferences(WEB_VIEW_AUTH_HANDLER_STORE, 0).getString(WEB_VIEW_AUTH_HANDLER_TOKEN_KEY, BuildConfig.FLAVOR);
    }

    private final void saveCookieToken(String token) {
        Context activity = getLoginClient().getActivity();
        if (activity == null) {
            activity = FacebookSdk.getApplicationContext();
        }
        activity.getSharedPreferences(WEB_VIEW_AUTH_HANDLER_STORE, 0).edit().putString(WEB_VIEW_AUTH_HANDLER_TOKEN_KEY, token).apply();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle addExtraParameters(Bundle parameters, LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(request, "request");
        parameters.putString("redirect_uri", getValidRedirectURI());
        if (request.isInstagramLogin()) {
            parameters.putString("app_id", request.getApplicationId());
        } else {
            parameters.putString("client_id", request.getApplicationId());
        }
        parameters.putString("e2e", LoginClient.INSTANCE.getE2E());
        if (request.isInstagramLogin()) {
            parameters.putString("response_type", "token,signed_request,graph_domain,granted_scopes");
        } else {
            if (request.getPermissions().contains("openid")) {
                parameters.putString("nonce", request.getNonce());
            }
            parameters.putString("response_type", "id_token,token,signed_request,graph_domain");
        }
        parameters.putString("code_challenge", request.getCodeChallenge());
        CodeChallengeMethod codeChallengeMethod = request.getCodeChallengeMethod();
        parameters.putString("code_challenge_method", codeChallengeMethod == null ? null : codeChallengeMethod.name());
        parameters.putString("return_scopes", "true");
        parameters.putString("auth_type", request.getAuthType());
        parameters.putString("login_behavior", request.getLoginBehavior().name());
        parameters.putString("sdk", Intrinsics.stringPlus("android-", FacebookSdk.getSdkVersion()));
        if (getSSODevice() != null) {
            parameters.putString("sso", getSSODevice());
        }
        parameters.putString("cct_prefetching", FacebookSdk.hasCustomTabsPrefetching ? "1" : "0");
        if (request.getIsFamilyLogin()) {
            parameters.putString("fx_app", request.getLoginTargetApp().getTargetApp());
        }
        if (request.getShouldSkipAccountDeduplication()) {
            parameters.putString("skip_dedupe", "true");
        }
        if (request.getMessengerPageId() != null) {
            parameters.putString("messenger_page_id", request.getMessengerPageId());
            parameters.putString("reset_messenger_state", request.getResetMessengerState() ? "1" : "0");
        }
        return parameters;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle getParameters(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Bundle bundle = new Bundle();
        Utility utility = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(request.getPermissions())) {
            String join = TextUtils.join(",", request.getPermissions());
            bundle.putString("scope", join);
            addLoggingExtra("scope", join);
        }
        DefaultAudience defaultAudience = request.getDefaultAudience();
        if (defaultAudience == null) {
            defaultAudience = DefaultAudience.NONE;
        }
        bundle.putString("default_audience", defaultAudience.getNativeProtocolAudience());
        bundle.putString("state", getClientState(request.getAuthId()));
        AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
        String token = currentAccessToken == null ? null : currentAccessToken.getToken();
        if (token == null || !Intrinsics.areEqual(token, loadCookieToken())) {
            FragmentActivity activity = getLoginClient().getActivity();
            if (activity != null) {
                Utility.clearFacebookCookies(activity);
            }
            addLoggingExtra("access_token", "0");
        } else {
            bundle.putString("access_token", token);
            addLoggingExtra("access_token", "1");
        }
        bundle.putString("cbt", String.valueOf(System.currentTimeMillis()));
        bundle.putString("ies", FacebookSdk.getAutoLogAppEventsEnabled() ? "1" : "0");
        return bundle;
    }

    protected String getSSODevice() {
        return null;
    }

    public abstract AccessTokenSource getTokenSource();

    public void onComplete(LoginClient.Request request, Bundle values, FacebookException error) {
        String str;
        LoginClient.Result createErrorResult;
        Intrinsics.checkNotNullParameter(request, "request");
        LoginClient loginClient = getLoginClient();
        this.e2e = null;
        if (values != null) {
            if (values.containsKey("e2e")) {
                this.e2e = values.getString("e2e");
            }
            try {
                LoginMethodHandler.Companion companion = LoginMethodHandler.INSTANCE;
                AccessToken createAccessTokenFromWebBundle = companion.createAccessTokenFromWebBundle(request.getPermissions(), values, getTokenSource(), request.getApplicationId());
                createErrorResult = LoginClient.Result.INSTANCE.createCompositeTokenResult(loginClient.getPendingRequest(), createAccessTokenFromWebBundle, companion.createAuthenticationTokenFromWebBundle(values, request.getNonce()));
                if (loginClient.getActivity() != null) {
                    try {
                        CookieSyncManager.createInstance(loginClient.getActivity()).sync();
                    } catch (Exception unused) {
                    }
                    if (createAccessTokenFromWebBundle != null) {
                        saveCookieToken(createAccessTokenFromWebBundle.getToken());
                    }
                }
            } catch (FacebookException e5) {
                createErrorResult = LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.INSTANCE, loginClient.getPendingRequest(), null, e5.getMessage(), null, 8, null);
            }
        } else if (error instanceof FacebookOperationCanceledException) {
            createErrorResult = LoginClient.Result.INSTANCE.createCancelResult(loginClient.getPendingRequest(), "User canceled log in.");
        } else {
            this.e2e = null;
            String message = error == null ? null : error.getMessage();
            if (error instanceof FacebookServiceException) {
                FacebookRequestError requestError = ((FacebookServiceException) error).getRequestError();
                str = String.valueOf(requestError.getErrorCode());
                message = requestError.toString();
            } else {
                str = null;
            }
            createErrorResult = LoginClient.Result.INSTANCE.createErrorResult(loginClient.getPendingRequest(), null, message, str);
        }
        Utility utility = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(this.e2e)) {
            logWebLoginCompleted(this.e2e);
        }
        loginClient.completeAndValidate(createErrorResult);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebLoginMethodHandler(Parcel source) {
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
    }
}
