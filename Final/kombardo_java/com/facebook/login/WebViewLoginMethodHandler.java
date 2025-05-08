package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.login.LoginClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 52\u00020\u0001:\u000265B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020'8\u0016X\u0096D¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+R\u001a\u00101\u001a\u0002008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/facebook/login/WebViewLoginMethodHandler;", "Lcom/facebook/login/WebLoginMethodHandler;", "Lcom/facebook/login/LoginClient;", "loginClient", "<init>", "(Lcom/facebook/login/LoginClient;)V", "Landroid/os/Parcel;", "source", "(Landroid/os/Parcel;)V", BuildConfig.FLAVOR, "needsInternetPermission", "()Z", BuildConfig.FLAVOR, "cancel", "()V", "Lcom/facebook/login/LoginClient$Request;", "request", BuildConfig.FLAVOR, "tryAuthorize", "(Lcom/facebook/login/LoginClient$Request;)I", "Landroid/os/Bundle;", "values", "Lcom/facebook/FacebookException;", "error", "onWebDialogComplete", "(Lcom/facebook/login/LoginClient$Request;Landroid/os/Bundle;Lcom/facebook/FacebookException;)V", "describeContents", "()I", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/facebook/internal/WebDialog;", "loginDialog", "Lcom/facebook/internal/WebDialog;", "getLoginDialog", "()Lcom/facebook/internal/WebDialog;", "setLoginDialog", "(Lcom/facebook/internal/WebDialog;)V", BuildConfig.FLAVOR, "e2e", "Ljava/lang/String;", "getE2e", "()Ljava/lang/String;", "setE2e", "(Ljava/lang/String;)V", "nameForLogging", "getNameForLogging", "Lcom/facebook/AccessTokenSource;", "tokenSource", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "Companion", "AuthDialogBuilder", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    private static final String OAUTH_DIALOG = "oauth";
    private String e2e;
    private WebDialog loginDialog;
    private final String nameForLogging;
    private final AccessTokenSource tokenSource;
    public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new Parcelable.Creator<WebViewLoginMethodHandler>() { // from class: com.facebook.login.WebViewLoginMethodHandler$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WebViewLoginMethodHandler createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new WebViewLoginMethodHandler(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WebViewLoginMethodHandler[] newArray(int size) {
            return new WebViewLoginMethodHandler[size];
        }
    };

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0004\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00060\u0000R\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00060\u0000R\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00060\u0000R\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\rJ\u0019\u0010\u0016\u001a\u00060\u0000R\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00060\u0000R\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00060\u0000R\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u0011J\u0019\u0010\u001f\u001a\u00060\u0000R\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\b\u001f\u0010\u0011J\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010%R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010&R\u0016\u0010\u001c\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010'R\u0016\u0010(\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010'R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\n\u0010$\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0012\u0010$\u001a\u0004\b-\u0010*\"\u0004\b\u0013\u0010,¨\u0006."}, d2 = {"Lcom/facebook/login/WebViewLoginMethodHandler$AuthDialogBuilder;", "Lcom/facebook/internal/WebDialog$Builder;", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "applicationId", "Landroid/os/Bundle;", "parameters", "<init>", "(Lcom/facebook/login/WebViewLoginMethodHandler;Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V", "e2e", "Lcom/facebook/login/WebViewLoginMethodHandler;", "setE2E", "(Ljava/lang/String;)Lcom/facebook/login/WebViewLoginMethodHandler$AuthDialogBuilder;", BuildConfig.FLAVOR, "isChromeOS", "setIsChromeOS", "(Z)Lcom/facebook/login/WebViewLoginMethodHandler$AuthDialogBuilder;", "authType", "setAuthType", "Lcom/facebook/login/LoginBehavior;", "loginBehavior", "setLoginBehavior", "(Lcom/facebook/login/LoginBehavior;)Lcom/facebook/login/WebViewLoginMethodHandler$AuthDialogBuilder;", "Lcom/facebook/login/LoginTargetApp;", "targetApp", "setLoginTargetApp", "(Lcom/facebook/login/LoginTargetApp;)Lcom/facebook/login/WebViewLoginMethodHandler$AuthDialogBuilder;", "isFamilyLogin", "setFamilyLogin", "shouldSkip", "setShouldSkipDedupe", "Lcom/facebook/internal/WebDialog;", "build", "()Lcom/facebook/internal/WebDialog;", "redirect_uri", "Ljava/lang/String;", "Lcom/facebook/login/LoginBehavior;", "Lcom/facebook/login/LoginTargetApp;", "Z", "shouldSkipDedupe", "getE2e", "()Ljava/lang/String;", "setE2e", "(Ljava/lang/String;)V", "getAuthType", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public final class AuthDialogBuilder extends WebDialog.Builder {
        public String authType;
        public String e2e;
        private boolean isFamilyLogin;
        private LoginBehavior loginBehavior;
        private String redirect_uri;
        private boolean shouldSkipDedupe;
        private LoginTargetApp targetApp;
        final /* synthetic */ WebViewLoginMethodHandler this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthDialogBuilder(WebViewLoginMethodHandler this$0, Context context, String applicationId, Bundle parameters) {
            super(context, applicationId, WebViewLoginMethodHandler.OAUTH_DIALOG, parameters);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            this.this$0 = this$0;
            this.redirect_uri = "fbconnect://success";
            this.loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
            this.targetApp = LoginTargetApp.FACEBOOK;
        }

        @Override // com.facebook.internal.WebDialog.Builder
        public WebDialog build() {
            Bundle parameters = getParameters();
            if (parameters == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
            }
            parameters.putString("redirect_uri", this.redirect_uri);
            parameters.putString("client_id", getApplicationId());
            parameters.putString("e2e", getE2e());
            parameters.putString("response_type", this.targetApp == LoginTargetApp.INSTAGRAM ? "token,signed_request,graph_domain,granted_scopes" : "token,signed_request,graph_domain");
            parameters.putString("return_scopes", "true");
            parameters.putString("auth_type", getAuthType());
            parameters.putString("login_behavior", this.loginBehavior.name());
            if (this.isFamilyLogin) {
                parameters.putString("fx_app", this.targetApp.getTargetApp());
            }
            if (this.shouldSkipDedupe) {
                parameters.putString("skip_dedupe", "true");
            }
            WebDialog.Companion companion = WebDialog.INSTANCE;
            Context context = getContext();
            if (context != null) {
                return companion.newInstance(context, WebViewLoginMethodHandler.OAUTH_DIALOG, parameters, getTheme(), this.targetApp, getListener());
            }
            throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
        }

        public final String getAuthType() {
            String str = this.authType;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("authType");
            throw null;
        }

        public final String getE2e() {
            String str = this.e2e;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("e2e");
            throw null;
        }

        /* renamed from: setAuthType, reason: collision with other method in class */
        public final void m2898setAuthType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.authType = str;
        }

        public final AuthDialogBuilder setE2E(String e2e) {
            Intrinsics.checkNotNullParameter(e2e, "e2e");
            setE2e(e2e);
            return this;
        }

        public final void setE2e(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.e2e = str;
        }

        public final AuthDialogBuilder setFamilyLogin(boolean isFamilyLogin) {
            this.isFamilyLogin = isFamilyLogin;
            return this;
        }

        public final AuthDialogBuilder setIsChromeOS(boolean isChromeOS) {
            this.redirect_uri = isChromeOS ? "fbconnect://chrome_os_success" : "fbconnect://success";
            return this;
        }

        public final AuthDialogBuilder setLoginBehavior(LoginBehavior loginBehavior) {
            Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
            this.loginBehavior = loginBehavior;
            return this;
        }

        public final AuthDialogBuilder setLoginTargetApp(LoginTargetApp targetApp) {
            Intrinsics.checkNotNullParameter(targetApp, "targetApp");
            this.targetApp = targetApp;
            return this;
        }

        public final AuthDialogBuilder setShouldSkipDedupe(boolean shouldSkip) {
            this.shouldSkipDedupe = shouldSkip;
            return this;
        }

        public final AuthDialogBuilder setAuthType(String authType) {
            Intrinsics.checkNotNullParameter(authType, "authType");
            m2898setAuthType(authType);
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        this.nameForLogging = "web_view";
        this.tokenSource = AccessTokenSource.WEB_VIEW;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public void cancel() {
        WebDialog webDialog = this.loginDialog;
        if (webDialog != null) {
            if (webDialog != null) {
                webDialog.cancel();
            }
            this.loginDialog = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public String getNameForLogging() {
        return this.nameForLogging;
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public boolean needsInternetPermission() {
        return true;
    }

    public final void onWebDialogComplete(LoginClient.Request request, Bundle values, FacebookException error) {
        Intrinsics.checkNotNullParameter(request, "request");
        super.onComplete(request, values, error);
    }

    @Override // com.facebook.login.LoginMethodHandler
    public int tryAuthorize(final LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Bundle parameters = getParameters(request);
        WebDialog.OnCompleteListener onCompleteListener = new WebDialog.OnCompleteListener() { // from class: com.facebook.login.WebViewLoginMethodHandler$tryAuthorize$listener$1
            @Override // com.facebook.internal.WebDialog.OnCompleteListener
            public void onComplete(Bundle values, FacebookException error) {
                WebViewLoginMethodHandler.this.onWebDialogComplete(request, values, error);
            }
        };
        String e2e = LoginClient.INSTANCE.getE2E();
        this.e2e = e2e;
        addLoggingExtra("e2e", e2e);
        FragmentActivity activity = getLoginClient().getActivity();
        if (activity == null) {
            return 0;
        }
        boolean isChromeOS = Utility.isChromeOS(activity);
        AuthDialogBuilder authDialogBuilder = new AuthDialogBuilder(this, activity, request.getApplicationId(), parameters);
        String str = this.e2e;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        this.loginDialog = authDialogBuilder.setE2E(str).setIsChromeOS(isChromeOS).setAuthType(request.getAuthType()).setLoginBehavior(request.getLoginBehavior()).setLoginTargetApp(request.getLoginTargetApp()).setFamilyLogin(request.getIsFamilyLogin()).setShouldSkipDedupe(request.getShouldSkipAccountDeduplication()).setOnCompleteListener(onCompleteListener).build();
        FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
        facebookDialogFragment.setRetainInstance(true);
        facebookDialogFragment.setInnerDialog(this.loginDialog);
        facebookDialogFragment.show(activity.getSupportFragmentManager(), "FacebookDialogFragment");
        return 1;
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        super.writeToParcel(dest, flags);
        dest.writeString(this.e2e);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewLoginMethodHandler(Parcel source) {
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
        this.nameForLogging = "web_view";
        this.tokenSource = AccessTokenSource.WEB_VIEW;
        this.e2e = source.readString();
    }
}
