package dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.details;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.OeresundCommuterDetailsScreenDestination;
import dk.molslinjen.domain.managers.agreement.commuter.oeresund.IOeresundCommuterManager;
import dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/oeresund/details/OeresundCommuterDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "oeresundCommuterManager", "Ldk/molslinjen/domain/managers/agreement/commuter/oeresund/IOeresundCommuterManager;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Ldk/molslinjen/domain/managers/agreement/commuter/oeresund/IOeresundCommuterManager;Landroidx/lifecycle/SavedStateHandle;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/agreements/commuter/oeresund/details/OeresundCommuterDetailsScreenNavArgs;", "agreement", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;", "getAgreement", "()Lkotlinx/coroutines/flow/StateFlow;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OeresundCommuterDetailsViewModel extends ViewModel {
    private final StateFlow<OeresundCommuterAgreement> agreement;
    private final OeresundCommuterDetailsScreenNavArgs navArgs;

    public OeresundCommuterDetailsViewModel(IOeresundCommuterManager oeresundCommuterManager, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(oeresundCommuterManager, "oeresundCommuterManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.navArgs = OeresundCommuterDetailsScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.agreement = FlowKt.stateIn(FlowKt.mapLatest(oeresundCommuterManager.getState(), new OeresundCommuterDetailsViewModel$agreement$1(this, null)), ViewModelKt.getViewModelScope(this), SharingStarted.INSTANCE.getEagerly(), null);
    }

    public final StateFlow<OeresundCommuterAgreement> getAgreement() {
        return this.agreement;
    }
}
