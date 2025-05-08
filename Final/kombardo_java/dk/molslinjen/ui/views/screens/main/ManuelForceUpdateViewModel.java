package dk.molslinjen.ui.views.screens.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"Ldk/molslinjen/ui/views/screens/main/ManuelForceUpdateViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "openPlayStore", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "getBundleId", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ManuelForceUpdateViewModel extends ViewModel {
    private final String getBundleId() {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default("dk.molslinjen.kombardo", ".dev", BuildConfig.FLAVOR, false, 4, (Object) null), ".prodtest", BuildConfig.FLAVOR, false, 4, (Object) null), ".test", BuildConfig.FLAVOR, false, 4, (Object) null), ".v2", BuildConfig.FLAVOR, false, 4, (Object) null);
    }

    public final void openPlayStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + getBundleId()));
        intent.addFlags(268435456);
        context.startActivity(intent);
    }
}
