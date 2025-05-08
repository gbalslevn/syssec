package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import androidx.fragment.app.Fragment;
import androidx.view.result.ActivityResultLauncher;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import com.facebook.login.NativeAppLoginMethodHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010#\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0014¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b%\u0010\u000fJ!\u0010&\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u0014H\u0014¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u0004\u0018\u00010\u001f2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u0004\u0018\u00010\u001f2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b*\u0010)J!\u0010+\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u0019H\u0014¢\u0006\u0004\b+\u0010,R\u001a\u0010.\u001a\u00020-8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/facebook/login/NativeAppLoginMethodHandler;", "Lcom/facebook/login/LoginMethodHandler;", "Lcom/facebook/login/LoginClient;", "loginClient", "<init>", "(Lcom/facebook/login/LoginClient;)V", "Landroid/os/Parcel;", "source", "(Landroid/os/Parcel;)V", "Lcom/facebook/login/LoginClient$Request;", "request", "Landroid/os/Bundle;", "extras", BuildConfig.FLAVOR, "processSuccessResponse", "(Lcom/facebook/login/LoginClient$Request;Landroid/os/Bundle;)V", "Lcom/facebook/login/LoginClient$Result;", "outcome", "completeLogin", "(Lcom/facebook/login/LoginClient$Result;)V", "Landroid/content/Intent;", "intent", BuildConfig.FLAVOR, "isCallable", "(Landroid/content/Intent;)Z", BuildConfig.FLAVOR, "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)Z", BuildConfig.FLAVOR, "error", "errorMessage", "errorCode", "handleResultError", "(Lcom/facebook/login/LoginClient$Request;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "handleResultOk", "handleResultCancel", "(Lcom/facebook/login/LoginClient$Request;Landroid/content/Intent;)V", "getError", "(Landroid/os/Bundle;)Ljava/lang/String;", "getErrorMessage", "tryIntent", "(Landroid/content/Intent;I)Z", "Lcom/facebook/AccessTokenSource;", "tokenSource", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
    private final AccessTokenSource tokenSource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        this.tokenSource = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    }

    private final void completeLogin(LoginClient.Result outcome) {
        if (outcome != null) {
            getLoginClient().completeAndValidate(outcome);
        } else {
            getLoginClient().tryNextHandler();
        }
    }

    private final boolean isCallable(Intent intent) {
        Intrinsics.checkNotNullExpressionValue(FacebookSdk.getApplicationContext().getPackageManager().queryIntentActivities(intent, 65536), "FacebookSdk.getApplicationContext()\n            .packageManager\n            .queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)");
        return !r3.isEmpty();
    }

    private final void processSuccessResponse(final LoginClient.Request request, final Bundle extras) {
        if (extras.containsKey("code")) {
            Utility utility = Utility.INSTANCE;
            if (!Utility.isNullOrEmpty(extras.getString("code"))) {
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: u0.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        NativeAppLoginMethodHandler.m2897processSuccessResponse$lambda0(NativeAppLoginMethodHandler.this, request, extras);
                    }
                });
                return;
            }
        }
        handleResultOk(request, extras);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processSuccessResponse$lambda-0, reason: not valid java name */
    public static final void m2897processSuccessResponse$lambda0(NativeAppLoginMethodHandler this$0, LoginClient.Request request, Bundle extras) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(extras, "$extras");
        try {
            this$0.handleResultOk(request, this$0.processCodeExchange(request, extras));
        } catch (FacebookServiceException e5) {
            FacebookRequestError requestError = e5.getRequestError();
            this$0.handleResultError(request, requestError.getErrorType(), requestError.getErrorMessage(), String.valueOf(requestError.getErrorCode()));
        } catch (FacebookException e6) {
            this$0.handleResultError(request, null, e6.getMessage(), null);
        }
    }

    protected String getError(Bundle extras) {
        String string = extras == null ? null : extras.getString("error");
        if (string != null) {
            return string;
        }
        if (extras == null) {
            return null;
        }
        return extras.getString("error_type");
    }

    protected String getErrorMessage(Bundle extras) {
        String string = extras == null ? null : extras.getString("error_message");
        if (string != null) {
            return string;
        }
        if (extras == null) {
            return null;
        }
        return extras.getString("error_description");
    }

    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    protected void handleResultCancel(LoginClient.Request request, Intent data) {
        Object obj;
        Intrinsics.checkNotNullParameter(data, "data");
        Bundle extras = data.getExtras();
        String error = getError(extras);
        String str = null;
        if (extras != null && (obj = extras.get("error_code")) != null) {
            str = obj.toString();
        }
        if (Intrinsics.areEqual(ServerProtocol.getErrorConnectionFailure(), str)) {
            completeLogin(LoginClient.Result.INSTANCE.createErrorResult(request, error, getErrorMessage(extras), str));
        } else {
            completeLogin(LoginClient.Result.INSTANCE.createCancelResult(request, error));
        }
    }

    protected void handleResultError(LoginClient.Request request, String error, String errorMessage, String errorCode) {
        if (error != null && Intrinsics.areEqual(error, "logged_out")) {
            CustomTabLoginMethodHandler.calledThroughLoggedOutAppSwitch = true;
            completeLogin(null);
        } else if (CollectionsKt.contains(ServerProtocol.getErrorsProxyAuthDisabled(), error)) {
            completeLogin(null);
        } else if (CollectionsKt.contains(ServerProtocol.getErrorsUserCanceled(), error)) {
            completeLogin(LoginClient.Result.INSTANCE.createCancelResult(request, null));
        } else {
            completeLogin(LoginClient.Result.INSTANCE.createErrorResult(request, error, errorMessage, errorCode));
        }
    }

    protected void handleResultOk(LoginClient.Request request, Bundle extras) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(extras, "extras");
        try {
            LoginMethodHandler.Companion companion = LoginMethodHandler.INSTANCE;
            completeLogin(LoginClient.Result.INSTANCE.createCompositeTokenResult(request, companion.createAccessTokenFromWebBundle(request.getPermissions(), extras, getTokenSource(), request.getApplicationId()), companion.createAuthenticationTokenFromWebBundle(extras, request.getNonce())));
        } catch (FacebookException e5) {
            completeLogin(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.INSTANCE, request, null, e5.getMessage(), null, 8, null));
        }
    }

    @Override // com.facebook.login.LoginMethodHandler
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        LoginClient.Request pendingRequest = getLoginClient().getPendingRequest();
        if (data == null) {
            completeLogin(LoginClient.Result.INSTANCE.createCancelResult(pendingRequest, "Operation canceled"));
        } else if (resultCode == 0) {
            handleResultCancel(pendingRequest, data);
        } else if (resultCode != -1) {
            completeLogin(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.INSTANCE, pendingRequest, "Unexpected resultCode from authorization.", null, null, 8, null));
        } else {
            Bundle extras = data.getExtras();
            if (extras == null) {
                completeLogin(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.INSTANCE, pendingRequest, "Unexpected null from returned authorization data.", null, null, 8, null));
                return true;
            }
            String error = getError(extras);
            Object obj = extras.get("error_code");
            String obj2 = obj == null ? null : obj.toString();
            String errorMessage = getErrorMessage(extras);
            String string = extras.getString("e2e");
            if (!Utility.isNullOrEmpty(string)) {
                logWebLoginCompleted(string);
            }
            if (error == null && obj2 == null && errorMessage == null && pendingRequest != null) {
                processSuccessResponse(pendingRequest, extras);
            } else {
                handleResultError(pendingRequest, error, errorMessage, obj2);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean tryIntent(Intent intent, int requestCode) {
        ActivityResultLauncher<Intent> launcher;
        if (intent == null || !isCallable(intent)) {
            return false;
        }
        Fragment fragment = getLoginClient().getFragment();
        Unit unit = null;
        LoginFragment loginFragment = fragment instanceof LoginFragment ? (LoginFragment) fragment : null;
        if (loginFragment != null && (launcher = loginFragment.getLauncher()) != null) {
            launcher.launch(intent);
            unit = Unit.INSTANCE;
        }
        return unit != null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAppLoginMethodHandler(Parcel source) {
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
        this.tokenSource = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    }
}
