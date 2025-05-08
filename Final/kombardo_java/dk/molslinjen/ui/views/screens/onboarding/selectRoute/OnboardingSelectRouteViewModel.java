package dk.molslinjen.ui.views.screens.onboarding.selectRoute;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.domain.model.settings.ISettings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ldk/molslinjen/ui/views/screens/onboarding/selectRoute/OnboardingSelectRouteViewModel;", "Landroidx/lifecycle/ViewModel;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "<init>", "(Ldk/molslinjen/domain/model/settings/ISettings;)V", "routeSelected", BuildConfig.FLAVOR, "proceed", "Lkotlin/Function0;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OnboardingSelectRouteViewModel extends ViewModel {
    private final ISettings settings;

    public OnboardingSelectRouteViewModel(ISettings settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.settings = settings;
    }

    public final void routeSelected(Function0<Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OnboardingSelectRouteViewModel$routeSelected$1(this, proceed, null), 3, null);
    }
}
