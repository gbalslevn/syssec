package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import com.facebook.login.GetTokenLoginMethodHandler;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import com.sdk.growthbook.utils.Constants;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/facebook/login/GetTokenLoginMethodHandler;", "Lcom/facebook/login/LoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getTokenClient", "Lcom/facebook/login/GetTokenClient;", "nameForLogging", BuildConfig.FLAVOR, "getNameForLogging", "()Ljava/lang/String;", "cancel", BuildConfig.FLAVOR, "complete", "request", "Lcom/facebook/login/LoginClient$Request;", "result", "Landroid/os/Bundle;", "describeContents", BuildConfig.FLAVOR, "getTokenCompleted", "onComplete", "tryAuthorize", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class GetTokenLoginMethodHandler extends LoginMethodHandler {
    private GetTokenClient getTokenClient;
    private final String nameForLogging;
    public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR = new Parcelable.Creator<GetTokenLoginMethodHandler>() { // from class: com.facebook.login.GetTokenLoginMethodHandler$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetTokenLoginMethodHandler createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new GetTokenLoginMethodHandler(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GetTokenLoginMethodHandler[] newArray(int size) {
            return new GetTokenLoginMethodHandler[size];
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        Intrinsics.checkNotNullParameter(loginClient, "loginClient");
        this.nameForLogging = "get_token";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: tryAuthorize$lambda-1, reason: not valid java name */
    public static final void m2894tryAuthorize$lambda1(GetTokenLoginMethodHandler this$0, LoginClient.Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        this$0.getTokenCompleted(request, bundle);
    }

    @Override // com.facebook.login.LoginMethodHandler
    public void cancel() {
        GetTokenClient getTokenClient = this.getTokenClient;
        if (getTokenClient == null) {
            return;
        }
        getTokenClient.cancel();
        getTokenClient.setCompletedListener(null);
        this.getTokenClient = null;
    }

    public final void complete(final LoginClient.Request request, final Bundle result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        String string = result.getString("com.facebook.platform.extra.USER_ID");
        if (string != null && string.length() != 0) {
            onComplete(request, result);
            return;
        }
        getLoginClient().notifyBackgroundProcessingStart();
        String string2 = result.getString("com.facebook.platform.extra.ACCESS_TOKEN");
        if (string2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Utility utility = Utility.INSTANCE;
        Utility.getGraphMeRequestWithCacheAsync(string2, new Utility.GraphMeRequestWithCacheCallback() { // from class: com.facebook.login.GetTokenLoginMethodHandler$complete$1
            @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
            public void onFailure(FacebookException error) {
                this.getLoginClient().complete(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.INSTANCE, this.getLoginClient().getPendingRequest(), "Caught exception", error == null ? null : error.getMessage(), null, 8, null));
            }

            @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
            public void onSuccess(JSONObject userInfo) {
                try {
                    result.putString("com.facebook.platform.extra.USER_ID", userInfo == null ? null : userInfo.getString(Constants.ID_ATTRIBUTE_KEY));
                    this.onComplete(request, result);
                } catch (JSONException e5) {
                    this.getLoginClient().complete(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.INSTANCE, this.getLoginClient().getPendingRequest(), "Caught exception", e5.getMessage(), null, 8, null));
                }
            }
        });
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public final void getTokenCompleted(LoginClient.Request request, Bundle result) {
        Intrinsics.checkNotNullParameter(request, "request");
        GetTokenClient getTokenClient = this.getTokenClient;
        if (getTokenClient != null) {
            getTokenClient.setCompletedListener(null);
        }
        this.getTokenClient = null;
        getLoginClient().notifyBackgroundProcessingStop();
        if (result != null) {
            List stringArrayList = result.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            if (stringArrayList == null) {
                stringArrayList = CollectionsKt.emptyList();
            }
            Set<String> permissions = request.getPermissions();
            if (permissions == null) {
                permissions = SetsKt.emptySet();
            }
            String string = result.getString("com.facebook.platform.extra.ID_TOKEN");
            if (permissions.contains("openid") && (string == null || string.length() == 0)) {
                getLoginClient().tryNextHandler();
                return;
            }
            if (stringArrayList.containsAll(permissions)) {
                complete(request, result);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String str : permissions) {
                if (!stringArrayList.contains(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                addLoggingExtra("new_permissions", TextUtils.join(",", hashSet));
            }
            request.setPermissions(hashSet);
        }
        getLoginClient().tryNextHandler();
    }

    public final void onComplete(LoginClient.Request request, Bundle result) {
        LoginClient.Result createErrorResult$default;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            LoginMethodHandler.Companion companion = LoginMethodHandler.INSTANCE;
            createErrorResult$default = LoginClient.Result.INSTANCE.createCompositeTokenResult(request, companion.createAccessTokenFromNativeLogin(result, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, request.getApplicationId()), companion.createAuthenticationTokenFromNativeLogin(result, request.getNonce()));
        } catch (FacebookException e5) {
            createErrorResult$default = LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.INSTANCE, getLoginClient().getPendingRequest(), null, e5.getMessage(), null, 8, null);
        }
        getLoginClient().completeAndValidate(createErrorResult$default);
    }

    @Override // com.facebook.login.LoginMethodHandler
    public int tryAuthorize(final LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Context activity = getLoginClient().getActivity();
        if (activity == null) {
            activity = FacebookSdk.getApplicationContext();
        }
        GetTokenClient getTokenClient = new GetTokenClient(activity, request);
        this.getTokenClient = getTokenClient;
        if (Intrinsics.areEqual(Boolean.valueOf(getTokenClient.start()), Boolean.FALSE)) {
            return 0;
        }
        getLoginClient().notifyBackgroundProcessingStart();
        PlatformServiceClient.CompletedListener completedListener = new PlatformServiceClient.CompletedListener() { // from class: u0.h
            @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
            public final void completed(Bundle bundle) {
                GetTokenLoginMethodHandler.m2894tryAuthorize$lambda1(GetTokenLoginMethodHandler.this, request, bundle);
            }
        };
        GetTokenClient getTokenClient2 = this.getTokenClient;
        if (getTokenClient2 == null) {
            return 1;
        }
        getTokenClient2.setCompletedListener(completedListener);
        return 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(Parcel source) {
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
        this.nameForLogging = "get_token";
    }
}
