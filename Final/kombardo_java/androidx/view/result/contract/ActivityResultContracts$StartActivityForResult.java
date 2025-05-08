package androidx.view.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.view.result.ActivityResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"androidx/activity/result/contract/ActivityResultContracts$StartActivityForResult", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResult;", "<init>", "()V", "Landroid/content/Context;", "context", "input", "createIntent", "(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/Intent;", BuildConfig.FLAVOR, "resultCode", "intent", "parseResult", "(ILandroid/content/Intent;)Landroidx/activity/result/ActivityResult;", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ActivityResultContracts$StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
    @Override // androidx.view.result.contract.ActivityResultContract
    public Intent createIntent(Context context, Intent input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        return input;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.view.result.contract.ActivityResultContract
    public ActivityResult parseResult(int resultCode, Intent intent) {
        return new ActivityResult(resultCode, intent);
    }
}
