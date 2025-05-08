package androidx.view.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import androidx.view.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"androidx/activity/result/contract/ActivityResultContracts$RequestPermission", "Landroidx/activity/result/contract/ActivityResultContract;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "()V", "Landroid/content/Context;", "context", "input", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", BuildConfig.FLAVOR, "resultCode", "intent", "parseResult", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "getSynchronousResult", "(Landroid/content/Context;Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ActivityResultContracts$RequestPermission extends ActivityResultContract<String, Boolean> {
    @Override // androidx.view.result.contract.ActivityResultContract
    public Intent createIntent(Context context, String input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        return ActivityResultContracts$RequestMultiplePermissions.INSTANCE.createIntent$activity_release(new String[]{input});
    }

    @Override // androidx.view.result.contract.ActivityResultContract
    public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, String input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        if (ContextCompat.checkSelfPermission(context, input) == 0) {
            return new ActivityResultContract.SynchronousResult<>(Boolean.TRUE);
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.view.result.contract.ActivityResultContract
    public Boolean parseResult(int resultCode, Intent intent) {
        if (intent != null && resultCode == -1) {
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            boolean z5 = false;
            if (intArrayExtra != null) {
                int length = intArrayExtra.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    if (intArrayExtra[i5] == 0) {
                        z5 = true;
                        break;
                    }
                    i5++;
                }
            }
            return Boolean.valueOf(z5);
        }
        return Boolean.FALSE;
    }
}
