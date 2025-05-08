package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.FacebookWebFallbackDialog;
import com.facebook.internal.WebDialog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u0010\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000f\u0010\u0003J\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u0003R$\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/facebook/internal/FacebookDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "Landroid/os/Bundle;", "values", "Lcom/facebook/FacebookException;", "error", BuildConfig.FLAVOR, "onCompleteWebDialog", "(Landroid/os/Bundle;Lcom/facebook/FacebookException;)V", "onCompleteWebFallbackDialog", "(Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "initDialog$facebook_common_release", "initDialog", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onResume", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onDestroyView", "innerDialog", "Landroid/app/Dialog;", "getInnerDialog", "()Landroid/app/Dialog;", "setInnerDialog", "(Landroid/app/Dialog;)V", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FacebookDialogFragment extends DialogFragment {
    private Dialog innerDialog;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initDialog$lambda-0, reason: not valid java name */
    public static final void m2852initDialog$lambda0(FacebookDialogFragment this$0, Bundle bundle, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onCompleteWebDialog(bundle, facebookException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initDialog$lambda-1, reason: not valid java name */
    public static final void m2853initDialog$lambda1(FacebookDialogFragment this$0, Bundle bundle, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onCompleteWebFallbackDialog(bundle);
    }

    private final void onCompleteWebDialog(Bundle values, FacebookException error) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "fragmentActivity.intent");
        activity.setResult(error == null ? -1 : 0, NativeProtocol.createProtocolResultIntent(intent, values, error));
        activity.finish();
    }

    private final void onCompleteWebFallbackDialog(Bundle values) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent();
        if (values == null) {
            values = new Bundle();
        }
        intent.putExtras(values);
        activity.setResult(-1, intent);
        activity.finish();
    }

    public final void initDialog$facebook_common_release() {
        FragmentActivity activity;
        WebDialog newInstance;
        if (this.innerDialog == null && (activity = getActivity()) != null) {
            Intent intent = activity.getIntent();
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            Bundle methodArgumentsFromIntent = NativeProtocol.getMethodArgumentsFromIntent(intent);
            if (methodArgumentsFromIntent != null ? methodArgumentsFromIntent.getBoolean("is_fallback", false) : false) {
                String string = methodArgumentsFromIntent != null ? methodArgumentsFromIntent.getString("url") : null;
                if (Utility.isNullOrEmpty(string)) {
                    Utility.logd("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                    return;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("fb%s://bridge/", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                FacebookWebFallbackDialog.Companion companion = FacebookWebFallbackDialog.INSTANCE;
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                newInstance = companion.newInstance(activity, string, format);
                newInstance.setOnCompleteListener(new WebDialog.OnCompleteListener() { // from class: o0.b
                    @Override // com.facebook.internal.WebDialog.OnCompleteListener
                    public final void onComplete(Bundle bundle, FacebookException facebookException) {
                        FacebookDialogFragment.m2853initDialog$lambda1(FacebookDialogFragment.this, bundle, facebookException);
                    }
                });
            } else {
                String string2 = methodArgumentsFromIntent == null ? null : methodArgumentsFromIntent.getString("action");
                Bundle bundle = methodArgumentsFromIntent != null ? methodArgumentsFromIntent.getBundle("params") : null;
                if (Utility.isNullOrEmpty(string2)) {
                    Utility.logd("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    return;
                } else {
                    if (string2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    newInstance = new WebDialog.Builder(activity, string2, bundle).setOnCompleteListener(new WebDialog.OnCompleteListener() { // from class: o0.a
                        @Override // com.facebook.internal.WebDialog.OnCompleteListener
                        public final void onComplete(Bundle bundle2, FacebookException facebookException) {
                            FacebookDialogFragment.m2852initDialog$lambda0(FacebookDialogFragment.this, bundle2, facebookException);
                        }
                    }).build();
                }
            }
            this.innerDialog = newInstance;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if ((this.innerDialog instanceof WebDialog) && isResumed()) {
            Dialog dialog = this.innerDialog;
            if (dialog == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.WebDialog");
            }
            ((WebDialog) dialog).resize();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDialog$facebook_common_release();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = this.innerDialog;
        if (dialog != null) {
            if (dialog != null) {
                return dialog;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.Dialog");
        }
        onCompleteWebDialog(null, null);
        setShowsDialog(false);
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Dialog dialog = this.innerDialog;
        if (dialog instanceof WebDialog) {
            if (dialog == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.WebDialog");
            }
            ((WebDialog) dialog).resize();
        }
    }

    public final void setInnerDialog(Dialog dialog) {
        this.innerDialog = dialog;
    }
}
