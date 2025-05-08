package dk.molslinjen.ui.views.screens.developer.inputs;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ldk/molslinjen/ui/views/screens/developer/inputs/DeveloperInputComponentsViewModel;", "Landroidx/lifecycle/ViewModel;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "<init>", "(Ldk/molslinjen/core/snackbar/ISnackbarService;)V", "showSnackbar", BuildConfig.FLAVOR, "event", "Ldk/molslinjen/core/snackbar/SnackbarEvent;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeveloperInputComponentsViewModel extends ViewModel {
    private final ISnackbarService snackbarService;

    public DeveloperInputComponentsViewModel(ISnackbarService snackbarService) {
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        this.snackbarService = snackbarService;
    }

    public final void showSnackbar(SnackbarEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DeveloperInputComponentsViewModel$showSnackbar$1(this, event, null), 3, null);
    }
}
