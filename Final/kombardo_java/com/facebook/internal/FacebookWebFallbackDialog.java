package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.facebook.internal.FacebookWebFallbackDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/internal/FacebookWebFallbackDialog;", "Lcom/facebook/internal/WebDialog;", "context", "Landroid/content/Context;", "url", BuildConfig.FLAVOR, "expectedRedirectUrl", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "waitingForDialogToClose", BuildConfig.FLAVOR, "cancel", BuildConfig.FLAVOR, "parseResponseUri", "Landroid/os/Bundle;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FacebookWebFallbackDialog extends WebDialog {
    private static final int OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS = 1500;
    private boolean waitingForDialogToClose;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = FacebookWebFallbackDialog.class.getName();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/FacebookWebFallbackDialog$Companion;", BuildConfig.FLAVOR, "()V", "OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS", BuildConfig.FLAVOR, "TAG", BuildConfig.FLAVOR, "kotlin.jvm.PlatformType", "newInstance", "Lcom/facebook/internal/FacebookWebFallbackDialog;", "context", "Landroid/content/Context;", "url", "expectedRedirectUrl", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FacebookWebFallbackDialog newInstance(Context context, String url, String expectedRedirectUrl) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(expectedRedirectUrl, "expectedRedirectUrl");
            WebDialog.initDefaultTheme(context);
            return new FacebookWebFallbackDialog(context, url, expectedRedirectUrl, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ FacebookWebFallbackDialog(Context context, String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cancel$lambda-0, reason: not valid java name */
    public static final void m2854cancel$lambda0(FacebookWebFallbackDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.cancel();
    }

    @Override // com.facebook.internal.WebDialog, android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        WebView webView = getWebView();
        if (!getIsPageFinished() || getIsListenerCalled() || webView == null || !webView.isShown()) {
            super.cancel();
        } else {
            if (this.waitingForDialogToClose) {
                return;
            }
            this.waitingForDialogToClose = true;
            webView.loadUrl(Intrinsics.stringPlus("javascript:", "(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();"));
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: o0.c
                @Override // java.lang.Runnable
                public final void run() {
                    FacebookWebFallbackDialog.m2854cancel$lambda0(FacebookWebFallbackDialog.this);
                }
            }, 1500L);
        }
    }

    @Override // com.facebook.internal.WebDialog
    public Bundle parseResponseUri(String url) {
        Uri parse = Uri.parse(url);
        Utility utility = Utility.INSTANCE;
        Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
        String string = parseUrlQueryString.getString("bridge_args");
        parseUrlQueryString.remove("bridge_args");
        if (!Utility.isNullOrEmpty(string)) {
            try {
                parseUrlQueryString.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", BundleJSONConverter.convertToBundle(new JSONObject(string)));
            } catch (JSONException e5) {
                Utility utility2 = Utility.INSTANCE;
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e5);
            }
        }
        String string2 = parseUrlQueryString.getString("method_results");
        parseUrlQueryString.remove("method_results");
        if (!Utility.isNullOrEmpty(string2)) {
            try {
                parseUrlQueryString.putBundle("com.facebook.platform.protocol.RESULT_ARGS", BundleJSONConverter.convertToBundle(new JSONObject(string2)));
            } catch (JSONException e6) {
                Utility utility3 = Utility.INSTANCE;
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e6);
            }
        }
        parseUrlQueryString.remove("version");
        parseUrlQueryString.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", NativeProtocol.getLatestKnownVersion());
        return parseUrlQueryString;
    }

    private FacebookWebFallbackDialog(Context context, String str, String str2) {
        super(context, str);
        setExpectedRedirectUrl(str2);
    }
}
