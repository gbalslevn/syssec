package dk.molslinjen.core;

import android.app.Activity;
import dk.molslinjen.core.AppUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J \u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/core/IAppUpdater;", BuildConfig.FLAVOR, "appUpdateState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/core/AppUpdater$AppUpdateState;", "getAppUpdateState", "()Lkotlinx/coroutines/flow/StateFlow;", "checkForUpdates", BuildConfig.FLAVOR, "activity", "Landroid/app/Activity;", "checkUpdateStatus", "requestCode", BuildConfig.FLAVOR, "resultCode", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAppUpdater {
    void checkForUpdates(Activity activity);

    void checkUpdateStatus(Activity activity, int requestCode, int resultCode);

    StateFlow<AppUpdater.AppUpdateState> getAppUpdateState();
}
