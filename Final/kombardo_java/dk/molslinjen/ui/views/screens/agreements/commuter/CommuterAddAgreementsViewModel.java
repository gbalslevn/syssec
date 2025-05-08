package dk.molslinjen.ui.views.screens.agreements.commuter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager;
import dk.molslinjen.domain.managers.agreement.commuter.oeresund.IOeresundCommuterManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterAddAgreementsViewModel;", "Landroidx/lifecycle/ViewModel;", "bornholmCommuterManager", "Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;", "oeresundCommuterManager", "Ldk/molslinjen/domain/managers/agreement/commuter/oeresund/IOeresundCommuterManager;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "<init>", "(Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;Ldk/molslinjen/domain/managers/agreement/commuter/oeresund/IOeresundCommuterManager;Ldk/molslinjen/domain/managers/user/IUserManager;)V", "type", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterAddAgreementsViewModel$State;", "getType", "()Lkotlinx/coroutines/flow/StateFlow;", "State", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CommuterAddAgreementsViewModel extends ViewModel {
    private final StateFlow<State> type;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterAddAgreementsViewModel$State;", BuildConfig.FLAVOR, "showOeresund", BuildConfig.FLAVOR, "<init>", "(Z)V", "getShowOeresund", "()Z", "Large", "Small", "Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterAddAgreementsViewModel$State$Large;", "Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterAddAgreementsViewModel$State$Small;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class State {
        private final boolean showOeresund;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterAddAgreementsViewModel$State$Large;", "Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterAddAgreementsViewModel$State;", "showOeresund", BuildConfig.FLAVOR, "<init>", "(Z)V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Large extends State {
            public Large(boolean z5) {
                super(z5, null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterAddAgreementsViewModel$State$Small;", "Ldk/molslinjen/ui/views/screens/agreements/commuter/CommuterAddAgreementsViewModel$State;", "showOeresund", BuildConfig.FLAVOR, "<init>", "(Z)V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Small extends State {
            public Small(boolean z5) {
                super(z5, null);
            }
        }

        public /* synthetic */ State(boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
            this(z5);
        }

        public final boolean getShowOeresund() {
            return this.showOeresund;
        }

        private State(boolean z5) {
            this.showOeresund = z5;
        }
    }

    public CommuterAddAgreementsViewModel(IBornholmCommuterManager bornholmCommuterManager, IOeresundCommuterManager oeresundCommuterManager, IUserManager userManager) {
        Intrinsics.checkNotNullParameter(bornholmCommuterManager, "bornholmCommuterManager");
        Intrinsics.checkNotNullParameter(oeresundCommuterManager, "oeresundCommuterManager");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        this.type = FlowKt.stateIn(FlowKt.combine(bornholmCommuterManager.getState(), oeresundCommuterManager.getState(), userManager.getAuthenticationType(), new CommuterAddAgreementsViewModel$type$1(null)), ViewModelKt.getViewModelScope(this), SharingStarted.INSTANCE.getLazily(), null);
    }

    public final StateFlow<State> getType() {
        return this.type;
    }
}
