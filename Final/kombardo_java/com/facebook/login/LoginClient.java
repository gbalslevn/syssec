package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.common.R$string;
import com.facebook.internal.CallbackManagerImpl$RequestCodeOffset;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u0000 \u0080\u00012\u00020\u0001:\n\u0081\u0001\u0080\u0001\u0082\u0001\u0083\u0001\u0084\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00132\u0018\u0010\u001a\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJM\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\u0018\u0010\u001a\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001fJ\u0017\u0010\"\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b$\u0010#J\r\u0010%\u001a\u00020\t¢\u0006\u0004\b%\u0010\u000bJ\u000f\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b'\u0010(J'\u0010.\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b.\u0010/J\u001f\u00101\u001a\n\u0012\u0004\u0012\u00020&\u0018\u0001002\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u000f¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\t¢\u0006\u0004\b5\u0010\u000bJ\r\u00106\u001a\u00020\u000f¢\u0006\u0004\b6\u00104J\u0015\u00107\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b7\u0010\u0016J\u0015\u00108\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b8\u0010\u0016J\u0015\u0010:\u001a\u00020)2\u0006\u00109\u001a\u00020\f¢\u0006\u0004\b:\u0010;J\u0015\u0010=\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u0013¢\u0006\u0004\b=\u0010\u0016J\r\u0010>\u001a\u00020\t¢\u0006\u0004\b>\u0010\u000bJ\r\u0010?\u001a\u00020\t¢\u0006\u0004\b?\u0010\u000bJ\u000f\u0010@\u001a\u00020)H\u0016¢\u0006\u0004\b@\u0010AJ\u001f\u0010D\u001a\u00020\t2\u0006\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020)H\u0016¢\u0006\u0004\bD\u0010ER*\u0010F\u001a\n\u0012\u0004\u0012\u00020&\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\b1\u0010H\"\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR.\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010\u0005R$\u0010R\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010Y\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010_\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u00104\"\u0004\bb\u0010cR$\u0010d\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010#R0\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010i8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR0\u0010o\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010i8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010j\u001a\u0004\bp\u0010l\"\u0004\bq\u0010nR\u0018\u0010s\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010u\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010LR\u0016\u0010v\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010LR\u0014\u0010y\u001a\u00020r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bw\u0010xR\u0013\u0010}\u001a\u0004\u0018\u00010z8F¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0011\u0010\u007f\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b~\u00104¨\u0006\u0085\u0001"}, d2 = {"Lcom/facebook/login/LoginClient;", "Landroid/os/Parcelable;", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "Landroid/os/Parcel;", "source", "(Landroid/os/Parcel;)V", BuildConfig.FLAVOR, "completeWithFailure", "()V", BuildConfig.FLAVOR, "key", "value", BuildConfig.FLAVOR, "accumulate", "addLoggingExtra", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Lcom/facebook/login/LoginClient$Result;", "outcome", "notifyOnCompleteListener", "(Lcom/facebook/login/LoginClient$Result;)V", "method", "result", BuildConfig.FLAVOR, "loggingExtras", "logAuthorizationMethodComplete", "(Ljava/lang/String;Lcom/facebook/login/LoginClient$Result;Ljava/util/Map;)V", "errorMessage", "errorCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "Lcom/facebook/login/LoginClient$Request;", "request", "startOrContinueAuth", "(Lcom/facebook/login/LoginClient$Request;)V", "authorize", "cancelCurrentHandler", "Lcom/facebook/login/LoginMethodHandler;", "getCurrentHandler", "()Lcom/facebook/login/LoginMethodHandler;", BuildConfig.FLAVOR, "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)Z", BuildConfig.FLAVOR, "getHandlersToTry", "(Lcom/facebook/login/LoginClient$Request;)[Lcom/facebook/login/LoginMethodHandler;", "checkInternetPermission", "()Z", "tryNextHandler", "tryCurrentHandler", "completeAndValidate", "complete", "permission", "checkPermission", "(Ljava/lang/String;)I", "pendingResult", "validateSameFbidAndFinish", "notifyBackgroundProcessingStart", "notifyBackgroundProcessingStop", "describeContents", "()I", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "handlersToTry", "[Lcom/facebook/login/LoginMethodHandler;", "()[Lcom/facebook/login/LoginMethodHandler;", "setHandlersToTry", "([Lcom/facebook/login/LoginMethodHandler;)V", "currentHandler", "I", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "Lcom/facebook/login/LoginClient$OnCompletedListener;", "onCompletedListener", "Lcom/facebook/login/LoginClient$OnCompletedListener;", "getOnCompletedListener", "()Lcom/facebook/login/LoginClient$OnCompletedListener;", "setOnCompletedListener", "(Lcom/facebook/login/LoginClient$OnCompletedListener;)V", "Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "backgroundProcessingListener", "Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "getBackgroundProcessingListener", "()Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", "setBackgroundProcessingListener", "(Lcom/facebook/login/LoginClient$BackgroundProcessingListener;)V", "checkedInternetPermission", "Z", "getCheckedInternetPermission", "setCheckedInternetPermission", "(Z)V", "pendingRequest", "Lcom/facebook/login/LoginClient$Request;", "getPendingRequest", "()Lcom/facebook/login/LoginClient$Request;", "setPendingRequest", BuildConfig.FLAVOR, "Ljava/util/Map;", "getLoggingExtras", "()Ljava/util/Map;", "setLoggingExtras", "(Ljava/util/Map;)V", "extraData", "getExtraData", "setExtraData", "Lcom/facebook/login/LoginLogger;", "loginLogger", "Lcom/facebook/login/LoginLogger;", "numActivitiesReturned", "numTotalIntentsFired", "getLogger", "()Lcom/facebook/login/LoginLogger;", "logger", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity", "getInProgress", "inProgress", "Companion", "BackgroundProcessingListener", "OnCompletedListener", "Request", "Result", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public class LoginClient implements Parcelable {
    private BackgroundProcessingListener backgroundProcessingListener;
    private boolean checkedInternetPermission;
    private int currentHandler;
    private Map<String, String> extraData;
    private Fragment fragment;
    private LoginMethodHandler[] handlersToTry;
    private Map<String, String> loggingExtras;
    private LoginLogger loginLogger;
    private int numActivitiesReturned;
    private int numTotalIntentsFired;
    private OnCompletedListener onCompletedListener;
    private Request pendingRequest;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<LoginClient> CREATOR = new Parcelable.Creator<LoginClient>() { // from class: com.facebook.login.LoginClient$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoginClient createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new LoginClient(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoginClient[] newArray(int size) {
            return new LoginClient[size];
        }
    };

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/facebook/login/LoginClient$BackgroundProcessingListener;", BuildConfig.FLAVOR, "onBackgroundProcessingStarted", BuildConfig.FLAVOR, "onBackgroundProcessingStopped", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public interface BackgroundProcessingListener {
        void onBackgroundProcessingStarted();

        void onBackgroundProcessingStopped();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\tH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/login/LoginClient$Companion;", BuildConfig.FLAVOR, "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/LoginClient;", "getE2E", BuildConfig.FLAVOR, "getLoginRequestCode", BuildConfig.FLAVOR, "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getE2E() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("init", System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "e2e.toString()");
            return jSONObject2;
        }

        public final int getLoginRequestCode() {
            return CallbackManagerImpl$RequestCodeOffset.Login.toRequestCode();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/LoginClient$OnCompletedListener;", BuildConfig.FLAVOR, "onCompleted", BuildConfig.FLAVOR, "result", "Lcom/facebook/login/LoginClient$Result;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public interface OnCompletedListener {
        void onCompleted(Result result);
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 R2\u00020\u0001:\u0001RB\u0011\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010 \u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010%\u001a\u0004\b)\u0010'\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b,\u0010\b\"\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010%\u001a\u0004\b1\u0010'\"\u0004\b2\u0010+R\"\u00103\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010%\u001a\u0004\b4\u0010'\"\u0004\b5\u0010+R$\u00106\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010%\u001a\u0004\b7\u0010'\"\u0004\b8\u0010+R$\u00109\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010%\u001a\u0004\b:\u0010'\"\u0004\b;\u0010+R\"\u0010<\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010-\u001a\u0004\b=\u0010\b\"\u0004\b>\u0010/R\u0017\u0010@\u001a\u00020?8\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\"\u0010D\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010-\u001a\u0004\bD\u0010\b\"\u0004\bE\u0010/R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010-R\u0017\u0010F\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\bF\u0010%\u001a\u0004\bG\u0010'R\u0019\u0010H\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\bH\u0010%\u001a\u0004\bI\u0010'R\u0019\u0010J\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\bJ\u0010%\u001a\u0004\bK\u0010'R\u0019\u0010M\u001a\u0004\u0018\u00010L8\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0011\u0010Q\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bQ\u0010\b¨\u0006S"}, d2 = {"Lcom/facebook/login/LoginClient$Request;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "<init>", "(Landroid/os/Parcel;)V", BuildConfig.FLAVOR, "shouldSkipAccountDeduplication", "()Z", "hasPublishPermission", BuildConfig.FLAVOR, "describeContents", "()I", "dest", "flags", BuildConfig.FLAVOR, "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/facebook/login/LoginBehavior;", "loginBehavior", "Lcom/facebook/login/LoginBehavior;", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "permissions", "Ljava/util/Set;", "getPermissions", "()Ljava/util/Set;", "setPermissions", "(Ljava/util/Set;)V", "Lcom/facebook/login/DefaultAudience;", "defaultAudience", "Lcom/facebook/login/DefaultAudience;", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "applicationId", "Ljava/lang/String;", "getApplicationId", "()Ljava/lang/String;", "authId", "getAuthId", "setAuthId", "(Ljava/lang/String;)V", "isRerequest", "Z", "setRerequest", "(Z)V", "deviceRedirectUriString", "getDeviceRedirectUriString", "setDeviceRedirectUriString", "authType", "getAuthType", "setAuthType", "deviceAuthTargetUserId", "getDeviceAuthTargetUserId", "setDeviceAuthTargetUserId", "messengerPageId", "getMessengerPageId", "setMessengerPageId", "resetMessengerState", "getResetMessengerState", "setResetMessengerState", "Lcom/facebook/login/LoginTargetApp;", "loginTargetApp", "Lcom/facebook/login/LoginTargetApp;", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "isFamilyLogin", "setFamilyLogin", "nonce", "getNonce", "codeVerifier", "getCodeVerifier", "codeChallenge", "getCodeChallenge", "Lcom/facebook/login/CodeChallengeMethod;", "codeChallengeMethod", "Lcom/facebook/login/CodeChallengeMethod;", "getCodeChallengeMethod", "()Lcom/facebook/login/CodeChallengeMethod;", "isInstagramLogin", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Request implements Parcelable {
        private final String applicationId;
        private String authId;
        private String authType;
        private final String codeChallenge;
        private final CodeChallengeMethod codeChallengeMethod;
        private final String codeVerifier;
        private final DefaultAudience defaultAudience;
        private String deviceAuthTargetUserId;
        private String deviceRedirectUriString;
        private boolean isFamilyLogin;
        private boolean isRerequest;
        private final LoginBehavior loginBehavior;
        private final LoginTargetApp loginTargetApp;
        private String messengerPageId;
        private final String nonce;
        private Set<String> permissions;
        private boolean resetMessengerState;
        private boolean shouldSkipAccountDeduplication;
        public static final Parcelable.Creator<Request> CREATOR = new Parcelable.Creator<Request>() { // from class: com.facebook.login.LoginClient$Request$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LoginClient.Request createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                return new LoginClient.Request(source, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LoginClient.Request[] newArray(int size) {
                return new LoginClient.Request[size];
            }
        };

        public /* synthetic */ Request(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final String getApplicationId() {
            return this.applicationId;
        }

        public final String getAuthId() {
            return this.authId;
        }

        public final String getAuthType() {
            return this.authType;
        }

        public final String getCodeChallenge() {
            return this.codeChallenge;
        }

        public final CodeChallengeMethod getCodeChallengeMethod() {
            return this.codeChallengeMethod;
        }

        public final String getCodeVerifier() {
            return this.codeVerifier;
        }

        public final DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        public final String getDeviceAuthTargetUserId() {
            return this.deviceAuthTargetUserId;
        }

        public final String getDeviceRedirectUriString() {
            return this.deviceRedirectUriString;
        }

        public final LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        public final LoginTargetApp getLoginTargetApp() {
            return this.loginTargetApp;
        }

        public final String getMessengerPageId() {
            return this.messengerPageId;
        }

        public final String getNonce() {
            return this.nonce;
        }

        public final Set<String> getPermissions() {
            return this.permissions;
        }

        public final boolean getResetMessengerState() {
            return this.resetMessengerState;
        }

        public final boolean hasPublishPermission() {
            Iterator<String> it = this.permissions.iterator();
            while (it.hasNext()) {
                if (LoginManager.INSTANCE.isPublishPermission(it.next())) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: isFamilyLogin, reason: from getter */
        public final boolean getIsFamilyLogin() {
            return this.isFamilyLogin;
        }

        public final boolean isInstagramLogin() {
            return this.loginTargetApp == LoginTargetApp.INSTAGRAM;
        }

        /* renamed from: isRerequest, reason: from getter */
        public final boolean getIsRerequest() {
            return this.isRerequest;
        }

        public final void setPermissions(Set<String> set) {
            Intrinsics.checkNotNullParameter(set, "<set-?>");
            this.permissions = set;
        }

        /* renamed from: shouldSkipAccountDeduplication, reason: from getter */
        public final boolean getShouldSkipAccountDeduplication() {
            return this.shouldSkipAccountDeduplication;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.loginBehavior.name());
            dest.writeStringList(new ArrayList(this.permissions));
            dest.writeString(this.defaultAudience.name());
            dest.writeString(this.applicationId);
            dest.writeString(this.authId);
            dest.writeByte(this.isRerequest ? (byte) 1 : (byte) 0);
            dest.writeString(this.deviceRedirectUriString);
            dest.writeString(this.authType);
            dest.writeString(this.deviceAuthTargetUserId);
            dest.writeString(this.messengerPageId);
            dest.writeByte(this.resetMessengerState ? (byte) 1 : (byte) 0);
            dest.writeString(this.loginTargetApp.name());
            dest.writeByte(this.isFamilyLogin ? (byte) 1 : (byte) 0);
            dest.writeByte(this.shouldSkipAccountDeduplication ? (byte) 1 : (byte) 0);
            dest.writeString(this.nonce);
            dest.writeString(this.codeVerifier);
            dest.writeString(this.codeChallenge);
            CodeChallengeMethod codeChallengeMethod = this.codeChallengeMethod;
            dest.writeString(codeChallengeMethod == null ? null : codeChallengeMethod.name());
        }

        private Request(Parcel parcel) {
            DefaultAudience defaultAudience;
            LoginTargetApp loginTargetApp;
            Validate validate = Validate.INSTANCE;
            this.loginBehavior = LoginBehavior.valueOf(Validate.notNullOrEmpty(parcel.readString(), "loginBehavior"));
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.permissions = new HashSet(arrayList);
            String readString = parcel.readString();
            if (readString != null) {
                defaultAudience = DefaultAudience.valueOf(readString);
            } else {
                defaultAudience = DefaultAudience.NONE;
            }
            this.defaultAudience = defaultAudience;
            this.applicationId = Validate.notNullOrEmpty(parcel.readString(), "applicationId");
            this.authId = Validate.notNullOrEmpty(parcel.readString(), "authId");
            this.isRerequest = parcel.readByte() != 0;
            this.deviceRedirectUriString = parcel.readString();
            this.authType = Validate.notNullOrEmpty(parcel.readString(), "authType");
            this.deviceAuthTargetUserId = parcel.readString();
            this.messengerPageId = parcel.readString();
            this.resetMessengerState = parcel.readByte() != 0;
            String readString2 = parcel.readString();
            if (readString2 != null) {
                loginTargetApp = LoginTargetApp.valueOf(readString2);
            } else {
                loginTargetApp = LoginTargetApp.FACEBOOK;
            }
            this.loginTargetApp = loginTargetApp;
            this.isFamilyLogin = parcel.readByte() != 0;
            this.shouldSkipAccountDeduplication = parcel.readByte() != 0;
            this.nonce = Validate.notNullOrEmpty(parcel.readString(), "nonce");
            this.codeVerifier = parcel.readString();
            this.codeChallenge = parcel.readString();
            String readString3 = parcel.readString();
            this.codeChallengeMethod = readString3 == null ? null : CodeChallengeMethod.valueOf(readString3);
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB7\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bBA\b\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000fB\u000f\b\u0012\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0017H\u0016R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/facebook/login/LoginClient$Result;", "Landroid/os/Parcelable;", "request", "Lcom/facebook/login/LoginClient$Request;", "code", "Lcom/facebook/login/LoginClient$Result$Code;", "token", "Lcom/facebook/AccessToken;", "errorMessage", BuildConfig.FLAVOR, "errorCode", "(Lcom/facebook/login/LoginClient$Request;Lcom/facebook/login/LoginClient$Result$Code;Lcom/facebook/AccessToken;Ljava/lang/String;Ljava/lang/String;)V", "accessToken", "authenticationToken", "Lcom/facebook/AuthenticationToken;", "(Lcom/facebook/login/LoginClient$Request;Lcom/facebook/login/LoginClient$Result$Code;Lcom/facebook/AccessToken;Lcom/facebook/AuthenticationToken;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "extraData", BuildConfig.FLAVOR, "loggingExtras", "describeContents", BuildConfig.FLAVOR, "writeToParcel", BuildConfig.FLAVOR, "dest", "flags", "Code", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Result implements Parcelable {
        public final AuthenticationToken authenticationToken;
        public final Code code;
        public final String errorCode;
        public final String errorMessage;
        public Map<String, String> extraData;
        public Map<String, String> loggingExtras;
        public final Request request;
        public final AccessToken token;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() { // from class: com.facebook.login.LoginClient$Result$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LoginClient.Result createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                return new LoginClient.Result(source, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LoginClient.Result[] newArray(int size) {
                return new LoginClient.Result[size];
            }
        };

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/facebook/login/LoginClient$Result$Code;", BuildConfig.FLAVOR, "loggingValue", BuildConfig.FLAVOR, "(Ljava/lang/String;ILjava/lang/String;)V", "getLoggingValue", "()Ljava/lang/String;", "SUCCESS", "CANCEL", "ERROR", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes.dex */
        public enum Code {
            SUCCESS("success"),
            CANCEL("cancel"),
            ERROR("error");

            private final String loggingValue;

            Code(String str) {
                this.loggingValue = str;
            }

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static Code[] valuesCustom() {
                Code[] valuesCustom = values();
                return (Code[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
            }

            public final String getLoggingValue() {
                return this.loggingValue;
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J&\u0010\u000b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J2\u0010\u0010\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\rH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/login/LoginClient$Result$Companion;", BuildConfig.FLAVOR, "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/LoginClient$Result;", "createCancelResult", "request", "Lcom/facebook/login/LoginClient$Request;", "message", BuildConfig.FLAVOR, "createCompositeTokenResult", "accessToken", "Lcom/facebook/AccessToken;", "authenticationToken", "Lcom/facebook/AuthenticationToken;", "createErrorResult", "errorType", "errorDescription", "errorCode", "createTokenResult", "token", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ Result createErrorResult$default(Companion companion, Request request, String str, String str2, String str3, int i5, Object obj) {
                if ((i5 & 8) != 0) {
                    str3 = null;
                }
                return companion.createErrorResult(request, str, str2, str3);
            }

            public final Result createCancelResult(Request request, String message) {
                return new Result(request, Code.CANCEL, null, message, null);
            }

            public final Result createCompositeTokenResult(Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
                return new Result(request, Code.SUCCESS, accessToken, authenticationToken, null, null);
            }

            public final Result createErrorResult(Request request, String errorType, String errorDescription, String errorCode) {
                ArrayList arrayList = new ArrayList();
                if (errorType != null) {
                    arrayList.add(errorType);
                }
                if (errorDescription != null) {
                    arrayList.add(errorDescription);
                }
                return new Result(request, Code.ERROR, null, TextUtils.join(": ", arrayList), errorCode);
            }

            public final Result createTokenResult(Request request, AccessToken token) {
                Intrinsics.checkNotNullParameter(token, "token");
                return new Result(request, Code.SUCCESS, token, null, null);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Result(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.code.name());
            dest.writeParcelable(this.token, flags);
            dest.writeParcelable(this.authenticationToken, flags);
            dest.writeString(this.errorMessage);
            dest.writeString(this.errorCode);
            dest.writeParcelable(this.request, flags);
            Utility utility = Utility.INSTANCE;
            Utility.writeNonnullStringMapToParcel(dest, this.loggingExtras);
            Utility.writeNonnullStringMapToParcel(dest, this.extraData);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Result(Request request, Code code, AccessToken accessToken, String str, String str2) {
            this(request, code, accessToken, null, str, str2);
            Intrinsics.checkNotNullParameter(code, "code");
        }

        public Result(Request request, Code code, AccessToken accessToken, AuthenticationToken authenticationToken, String str, String str2) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.request = request;
            this.token = accessToken;
            this.authenticationToken = authenticationToken;
            this.errorMessage = str;
            this.code = code;
            this.errorCode = str2;
        }

        private Result(Parcel parcel) {
            String readString = parcel.readString();
            this.code = Code.valueOf(readString == null ? "error" : readString);
            this.token = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.authenticationToken = (AuthenticationToken) parcel.readParcelable(AuthenticationToken.class.getClassLoader());
            this.errorMessage = parcel.readString();
            this.errorCode = parcel.readString();
            this.request = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.loggingExtras = Utility.readNonnullStringMapFromParcel(parcel);
            this.extraData = Utility.readNonnullStringMapFromParcel(parcel);
        }
    }

    public LoginClient(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.currentHandler = -1;
        setFragment(fragment);
    }

    private final void addLoggingExtra(String key, String value, boolean accumulate) {
        Map<String, String> map = this.loggingExtras;
        if (map == null) {
            map = new HashMap<>();
        }
        if (this.loggingExtras == null) {
            this.loggingExtras = map;
        }
        if (map.containsKey(key) && accumulate) {
            value = ((Object) map.get(key)) + ',' + value;
        }
        map.put(key, value);
    }

    private final void completeWithFailure() {
        complete(Result.Companion.createErrorResult$default(Result.INSTANCE, this.pendingRequest, "Login attempt failed.", null, null, 8, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1, r2 == null ? null : r2.getApplicationId()) == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final LoginLogger getLogger() {
        LoginLogger loginLogger = this.loginLogger;
        if (loginLogger != null) {
            String applicationId = loginLogger.getApplicationId();
            Request request = this.pendingRequest;
        }
        Context activity = getActivity();
        if (activity == null) {
            activity = FacebookSdk.getApplicationContext();
        }
        Request request2 = this.pendingRequest;
        loginLogger = new LoginLogger(activity, request2 == null ? FacebookSdk.getApplicationId() : request2.getApplicationId());
        this.loginLogger = loginLogger;
        return loginLogger;
    }

    private final void logAuthorizationMethodComplete(String method, Result result, Map<String, String> loggingExtras) {
        logAuthorizationMethodComplete(method, result.code.getLoggingValue(), result.errorMessage, result.errorCode, loggingExtras);
    }

    private final void notifyOnCompleteListener(Result outcome) {
        OnCompletedListener onCompletedListener = this.onCompletedListener;
        if (onCompletedListener == null) {
            return;
        }
        onCompletedListener.onCompleted(outcome);
    }

    public final void authorize(Request request) {
        if (request == null) {
            return;
        }
        if (this.pendingRequest != null) {
            throw new FacebookException("Attempted to authorize while a request is pending.");
        }
        if (!AccessToken.INSTANCE.isCurrentAccessTokenActive() || checkInternetPermission()) {
            this.pendingRequest = request;
            this.handlersToTry = getHandlersToTry(request);
            tryNextHandler();
        }
    }

    public final void cancelCurrentHandler() {
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (currentHandler == null) {
            return;
        }
        currentHandler.cancel();
    }

    public final boolean checkInternetPermission() {
        if (this.checkedInternetPermission) {
            return true;
        }
        if (checkPermission("android.permission.INTERNET") == 0) {
            this.checkedInternetPermission = true;
            return true;
        }
        FragmentActivity activity = getActivity();
        complete(Result.Companion.createErrorResult$default(Result.INSTANCE, this.pendingRequest, activity == null ? null : activity.getString(R$string.com_facebook_internet_permission_error_title), activity != null ? activity.getString(R$string.com_facebook_internet_permission_error_message) : null, null, 8, null));
        return false;
    }

    public final int checkPermission(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return -1;
        }
        return activity.checkCallingOrSelfPermission(permission);
    }

    public final void complete(Result outcome) {
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (currentHandler != null) {
            logAuthorizationMethodComplete(currentHandler.getNameForLogging(), outcome, currentHandler.getMethodLoggingExtras());
        }
        Map<String, String> map = this.loggingExtras;
        if (map != null) {
            outcome.loggingExtras = map;
        }
        Map<String, String> map2 = this.extraData;
        if (map2 != null) {
            outcome.extraData = map2;
        }
        this.handlersToTry = null;
        this.currentHandler = -1;
        this.pendingRequest = null;
        this.loggingExtras = null;
        this.numActivitiesReturned = 0;
        this.numTotalIntentsFired = 0;
        notifyOnCompleteListener(outcome);
    }

    public final void completeAndValidate(Result outcome) {
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        if (outcome.token == null || !AccessToken.INSTANCE.isCurrentAccessTokenActive()) {
            complete(outcome);
        } else {
            validateSameFbidAndFinish(outcome);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final FragmentActivity getActivity() {
        Fragment fragment = this.fragment;
        if (fragment == null) {
            return null;
        }
        return fragment.getActivity();
    }

    public final LoginMethodHandler getCurrentHandler() {
        LoginMethodHandler[] loginMethodHandlerArr;
        int i5 = this.currentHandler;
        if (i5 < 0 || (loginMethodHandlerArr = this.handlersToTry) == null) {
            return null;
        }
        return loginMethodHandlerArr[i5];
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public LoginMethodHandler[] getHandlersToTry(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ArrayList arrayList = new ArrayList();
        LoginBehavior loginBehavior = request.getLoginBehavior();
        if (!request.isInstagramLogin()) {
            if (loginBehavior.getAllowsGetTokenAuth()) {
                arrayList.add(new GetTokenLoginMethodHandler(this));
            }
            if (!FacebookSdk.bypassAppSwitch && loginBehavior.getAllowsKatanaAuth()) {
                arrayList.add(new KatanaProxyLoginMethodHandler(this));
            }
        } else if (!FacebookSdk.bypassAppSwitch && loginBehavior.getAllowsInstagramAppAuth()) {
            arrayList.add(new InstagramAppLoginMethodHandler(this));
        }
        if (loginBehavior.getAllowsCustomTabAuth()) {
            arrayList.add(new CustomTabLoginMethodHandler(this));
        }
        if (loginBehavior.getAllowsWebViewAuth()) {
            arrayList.add(new WebViewLoginMethodHandler(this));
        }
        if (!request.isInstagramLogin() && loginBehavior.getAllowsDeviceAuth()) {
            arrayList.add(new DeviceAuthMethodHandler(this));
        }
        Object[] array = arrayList.toArray(new LoginMethodHandler[0]);
        if (array != null) {
            return (LoginMethodHandler[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final boolean getInProgress() {
        return this.pendingRequest != null && this.currentHandler >= 0;
    }

    public final Request getPendingRequest() {
        return this.pendingRequest;
    }

    public final void notifyBackgroundProcessingStart() {
        BackgroundProcessingListener backgroundProcessingListener = this.backgroundProcessingListener;
        if (backgroundProcessingListener == null) {
            return;
        }
        backgroundProcessingListener.onBackgroundProcessingStarted();
    }

    public final void notifyBackgroundProcessingStop() {
        BackgroundProcessingListener backgroundProcessingListener = this.backgroundProcessingListener;
        if (backgroundProcessingListener == null) {
            return;
        }
        backgroundProcessingListener.onBackgroundProcessingStopped();
    }

    public final boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        this.numActivitiesReturned++;
        if (this.pendingRequest != null) {
            if (data != null && data.getBooleanExtra(CustomTabMainActivity.NO_ACTIVITY_EXCEPTION, false)) {
                tryNextHandler();
                return false;
            }
            LoginMethodHandler currentHandler = getCurrentHandler();
            if (currentHandler != null && (!currentHandler.shouldKeepTrackOfMultipleIntents() || data != null || this.numActivitiesReturned >= this.numTotalIntentsFired)) {
                return currentHandler.onActivityResult(requestCode, resultCode, data);
            }
        }
        return false;
    }

    public final void setBackgroundProcessingListener(BackgroundProcessingListener backgroundProcessingListener) {
        this.backgroundProcessingListener = backgroundProcessingListener;
    }

    public final void setFragment(Fragment fragment) {
        if (this.fragment != null) {
            throw new FacebookException("Can't set fragment once it is already set.");
        }
        this.fragment = fragment;
    }

    public final void setOnCompletedListener(OnCompletedListener onCompletedListener) {
        this.onCompletedListener = onCompletedListener;
    }

    public final void startOrContinueAuth(Request request) {
        if (getInProgress()) {
            return;
        }
        authorize(request);
    }

    public final boolean tryCurrentHandler() {
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (currentHandler == null) {
            return false;
        }
        if (currentHandler.needsInternetPermission() && !checkInternetPermission()) {
            addLoggingExtra("no_internet_permission", "1", false);
            return false;
        }
        Request request = this.pendingRequest;
        if (request == null) {
            return false;
        }
        int tryAuthorize = currentHandler.tryAuthorize(request);
        this.numActivitiesReturned = 0;
        if (tryAuthorize > 0) {
            getLogger().logAuthorizationMethodStart(request.getAuthId(), currentHandler.getNameForLogging(), request.getIsFamilyLogin() ? "foa_mobile_login_method_start" : "fb_mobile_login_method_start");
            this.numTotalIntentsFired = tryAuthorize;
        } else {
            getLogger().logAuthorizationMethodNotTried(request.getAuthId(), currentHandler.getNameForLogging(), request.getIsFamilyLogin() ? "foa_mobile_login_method_not_tried" : "fb_mobile_login_method_not_tried");
            addLoggingExtra("not_tried", currentHandler.getNameForLogging(), true);
        }
        return tryAuthorize > 0;
    }

    public final void tryNextHandler() {
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (currentHandler != null) {
            logAuthorizationMethodComplete(currentHandler.getNameForLogging(), "skipped", null, null, currentHandler.getMethodLoggingExtras());
        }
        LoginMethodHandler[] loginMethodHandlerArr = this.handlersToTry;
        while (loginMethodHandlerArr != null) {
            int i5 = this.currentHandler;
            if (i5 >= loginMethodHandlerArr.length - 1) {
                break;
            }
            this.currentHandler = i5 + 1;
            if (tryCurrentHandler()) {
                return;
            }
        }
        if (this.pendingRequest != null) {
            completeWithFailure();
        }
    }

    public final void validateSameFbidAndFinish(Result pendingResult) {
        Result createCompositeTokenResult;
        Intrinsics.checkNotNullParameter(pendingResult, "pendingResult");
        if (pendingResult.token == null) {
            throw new FacebookException("Can't validate without a token");
        }
        AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
        AccessToken accessToken = pendingResult.token;
        if (currentAccessToken != null) {
            try {
                if (Intrinsics.areEqual(currentAccessToken.getUserId(), accessToken.getUserId())) {
                    createCompositeTokenResult = Result.INSTANCE.createCompositeTokenResult(this.pendingRequest, pendingResult.token, pendingResult.authenticationToken);
                    complete(createCompositeTokenResult);
                }
            } catch (Exception e5) {
                complete(Result.Companion.createErrorResult$default(Result.INSTANCE, this.pendingRequest, "Caught exception", e5.getMessage(), null, 8, null));
                return;
            }
        }
        createCompositeTokenResult = Result.Companion.createErrorResult$default(Result.INSTANCE, this.pendingRequest, "User logged in as different Facebook user.", null, null, 8, null);
        complete(createCompositeTokenResult);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelableArray(this.handlersToTry, flags);
        dest.writeInt(this.currentHandler);
        dest.writeParcelable(this.pendingRequest, flags);
        Utility utility = Utility.INSTANCE;
        Utility.writeNonnullStringMapToParcel(dest, this.loggingExtras);
        Utility.writeNonnullStringMapToParcel(dest, this.extraData);
    }

    private final void logAuthorizationMethodComplete(String method, String result, String errorMessage, String errorCode, Map<String, String> loggingExtras) {
        Request request = this.pendingRequest;
        if (request == null) {
            getLogger().logUnexpectedError("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", method);
        } else {
            getLogger().logAuthorizationMethodComplete(request.getAuthId(), method, result, errorMessage, errorCode, loggingExtras, request.getIsFamilyLogin() ? "foa_mobile_login_method_complete" : "fb_mobile_login_method_complete");
        }
    }

    public LoginClient(Parcel source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.currentHandler = -1;
        Parcelable[] readParcelableArray = source.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        readParcelableArray = readParcelableArray == null ? new Parcelable[0] : readParcelableArray;
        ArrayList arrayList = new ArrayList();
        int length = readParcelableArray.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            }
            Parcelable parcelable = readParcelableArray[i5];
            LoginMethodHandler loginMethodHandler = parcelable instanceof LoginMethodHandler ? (LoginMethodHandler) parcelable : null;
            if (loginMethodHandler != null) {
                loginMethodHandler.setLoginClient(this);
            }
            if (loginMethodHandler != null) {
                arrayList.add(loginMethodHandler);
            }
            i5++;
        }
        Object[] array = arrayList.toArray(new LoginMethodHandler[0]);
        if (array != null) {
            this.handlersToTry = (LoginMethodHandler[]) array;
            this.currentHandler = source.readInt();
            this.pendingRequest = (Request) source.readParcelable(Request.class.getClassLoader());
            Map<String, String> readNonnullStringMapFromParcel = Utility.readNonnullStringMapFromParcel(source);
            this.loggingExtras = readNonnullStringMapFromParcel == null ? null : MapsKt.toMutableMap(readNonnullStringMapFromParcel);
            Map<String, String> readNonnullStringMapFromParcel2 = Utility.readNonnullStringMapFromParcel(source);
            this.extraData = readNonnullStringMapFromParcel2 != null ? MapsKt.toMutableMap(readNonnullStringMapFromParcel2) : null;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
