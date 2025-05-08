package androidx.view;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.view.ComponentActivity$activityResultRegistry$1;
import androidx.view.result.ActivityResultRegistry;
import androidx.view.result.IntentSenderRequest;
import androidx.view.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t2\u0006\u0010\n\u001a\u0002H\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"androidx/activity/ComponentActivity$activityResultRegistry$1", "Landroidx/activity/result/ActivityResultRegistry;", "onLaunch", BuildConfig.FLAVOR, "I", "O", "requestCode", BuildConfig.FLAVOR, "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "input", "options", "Landroidx/core/app/ActivityOptionsCompat;", "(ILandroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Landroidx/core/app/ActivityOptionsCompat;)V", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComponentActivity$activityResultRegistry$1 extends ActivityResultRegistry {
    final /* synthetic */ ComponentActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ComponentActivity$activityResultRegistry$1(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLaunch$lambda$0(ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1, int i5, ActivityResultContract.SynchronousResult synchronousResult) {
        componentActivity$activityResultRegistry$1.dispatchResult(i5, synchronousResult.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLaunch$lambda$1(ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1, int i5, IntentSender.SendIntentException sendIntentException) {
        componentActivity$activityResultRegistry$1.dispatchResult(i5, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", sendIntentException));
    }

    @Override // androidx.view.result.ActivityResultRegistry
    public <I, O> void onLaunch(final int requestCode, ActivityResultContract<I, O> contract, I input, ActivityOptionsCompat options) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(contract, "contract");
        ComponentActivity componentActivity = this.this$0;
        final ActivityResultContract.SynchronousResult<O> synchronousResult = contract.getSynchronousResult(componentActivity, input);
        if (synchronousResult != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: a.g
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentActivity$activityResultRegistry$1.onLaunch$lambda$0(ComponentActivity$activityResultRegistry$1.this, requestCode, synchronousResult);
                }
            });
            return;
        }
        Intent createIntent = contract.createIntent(componentActivity, input);
        if (createIntent.getExtras() != null) {
            Bundle extras = createIntent.getExtras();
            Intrinsics.checkNotNull(extras);
            if (extras.getClassLoader() == null) {
                createIntent.setExtrasClassLoader(componentActivity.getClassLoader());
            }
        }
        if (createIntent.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            Bundle bundleExtra = createIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            createIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            bundle = bundleExtra;
        } else {
            bundle = null;
        }
        if (Intrinsics.areEqual("androidx.activity.result.contract.action.REQUEST_PERMISSIONS", createIntent.getAction())) {
            String[] stringArrayExtra = createIntent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            ActivityCompat.requestPermissions(componentActivity, stringArrayExtra, requestCode);
            return;
        }
        if (!Intrinsics.areEqual("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST", createIntent.getAction())) {
            ActivityCompat.startActivityForResult(componentActivity, createIntent, requestCode, bundle);
            return;
        }
        IntentSenderRequest intentSenderRequest = (IntentSenderRequest) createIntent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            Intrinsics.checkNotNull(intentSenderRequest);
            ActivityCompat.startIntentSenderForResult(componentActivity, intentSenderRequest.getIntentSender(), requestCode, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle);
        } catch (IntentSender.SendIntentException e5) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: a.h
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentActivity$activityResultRegistry$1.onLaunch$lambda$1(ComponentActivity$activityResultRegistry$1.this, requestCode, e5);
                }
            });
        }
    }
}
