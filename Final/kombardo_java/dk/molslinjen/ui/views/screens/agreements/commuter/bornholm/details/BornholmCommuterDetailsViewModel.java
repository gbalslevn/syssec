package dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.BornholmCommuterDetailsScreenDestination;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterAgreement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R%\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00158\u0006¢\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/details/BornholmCommuterDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "routeManager", "Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;", "commuterManager", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "<init>", "(Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;Landroidx/lifecycle/SavedStateHandle;)V", "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;", "agreement", "Lkotlin/Function0;", BuildConfig.FLAVOR, "proceed", "startCommuterBooking", "(Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;Lkotlin/jvm/functions/Function0;)V", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/details/BornholmCommuterDetailsScreenNavArgs;", "navArgs", "Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/details/BornholmCommuterDetailsScreenNavArgs;", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "getAgreement", "()Lkotlinx/coroutines/flow/StateFlow;", "getAgreement$annotations", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BornholmCommuterDetailsViewModel extends ViewModel {
    private final StateFlow<BornholmCommuterAgreement> agreement;
    private final BornholmCommuterDetailsScreenNavArgs navArgs;
    private final IRouteManager routeManager;

    public BornholmCommuterDetailsViewModel(IRouteManager routeManager, IBornholmCommuterManager commuterManager, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(commuterManager, "commuterManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.routeManager = routeManager;
        this.navArgs = BornholmCommuterDetailsScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.agreement = FlowKt.stateIn(FlowKt.mapLatest(commuterManager.getState(), new BornholmCommuterDetailsViewModel$agreement$1(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.INSTANCE.getEagerly(), null);
    }

    public final StateFlow<BornholmCommuterAgreement> getAgreement() {
        return this.agreement;
    }

    public final void startCommuterBooking(BornholmCommuterAgreement agreement, Function0<Unit> proceed) {
        Intrinsics.checkNotNullParameter(agreement, "agreement");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BornholmCommuterDetailsViewModel$startCommuterBooking$1(this, agreement, proceed, null), 3, null);
    }
}
