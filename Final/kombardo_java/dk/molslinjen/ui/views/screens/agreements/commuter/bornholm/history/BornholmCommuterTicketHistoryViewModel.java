package dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.history;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.CommuterTicketHistoryScreenDestination;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.IBornholmCommuterManager;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterBooking;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/history/BornholmCommuterTicketHistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "commuterManager", "Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Ldk/molslinjen/domain/managers/agreement/commuter/bornholm/IBornholmCommuterManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Landroidx/lifecycle/SavedStateHandle;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/history/CommuterTicketHistoryScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/history/BornholmCommuterTicketHistoryViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadHistory", BuildConfig.FLAVOR, "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BornholmCommuterTicketHistoryViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IBornholmCommuterManager commuterManager;
    private final CommuterTicketHistoryScreenNavArgs navArgs;
    private final ISnackbarService snackbarService;

    public BornholmCommuterTicketHistoryViewModel(IBornholmCommuterManager commuterManager, ISnackbarService snackbarService, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(commuterManager, "commuterManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.commuterManager = commuterManager;
        this.snackbarService = snackbarService;
        CommuterTicketHistoryScreenNavArgs argsFrom = CommuterTicketHistoryScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        this._viewState = StateFlowKt.MutableStateFlow(new ViewState(false, argsFrom.getCommuterAgreementId(), null, null, 13, null));
        loadHistory();
    }

    private final void loadHistory() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BornholmCommuterTicketHistoryViewModel$loadHistory$1(this, null), 3, null);
    }

    public final StateFlow<ViewState> getViewState() {
        return this._viewState;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ@\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0003\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001f\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/history/BornholmCommuterTicketHistoryViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "commuterAgreementId", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "ticketCategoryType", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterBooking;", "tickets", "<init>", "(ZLjava/lang/String;Ldk/molslinjen/domain/model/booking/TicketCategoryType;Ljava/util/List;)V", "copy", "(ZLjava/lang/String;Ldk/molslinjen/domain/model/booking/TicketCategoryType;Ljava/util/List;)Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/history/BornholmCommuterTicketHistoryViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ljava/lang/String;", "getCommuterAgreementId", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "getTicketCategoryType", "()Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "Ljava/util/List;", "getTickets", "()Ljava/util/List;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final String commuterAgreementId;
        private final boolean isLoading;
        private final TicketCategoryType ticketCategoryType;
        private final List<BornholmCommuterBooking> tickets;

        public ViewState(boolean z5, String commuterAgreementId, TicketCategoryType ticketCategoryType, List<BornholmCommuterBooking> list) {
            Intrinsics.checkNotNullParameter(commuterAgreementId, "commuterAgreementId");
            Intrinsics.checkNotNullParameter(ticketCategoryType, "ticketCategoryType");
            this.isLoading = z5;
            this.commuterAgreementId = commuterAgreementId;
            this.ticketCategoryType = ticketCategoryType;
            this.tickets = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, String str, TicketCategoryType ticketCategoryType, List list, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 2) != 0) {
                str = viewState.commuterAgreementId;
            }
            if ((i5 & 4) != 0) {
                ticketCategoryType = viewState.ticketCategoryType;
            }
            if ((i5 & 8) != 0) {
                list = viewState.tickets;
            }
            return viewState.copy(z5, str, ticketCategoryType, list);
        }

        public final ViewState copy(boolean isLoading, String commuterAgreementId, TicketCategoryType ticketCategoryType, List<BornholmCommuterBooking> tickets) {
            Intrinsics.checkNotNullParameter(commuterAgreementId, "commuterAgreementId");
            Intrinsics.checkNotNullParameter(ticketCategoryType, "ticketCategoryType");
            return new ViewState(isLoading, commuterAgreementId, ticketCategoryType, tickets);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.commuterAgreementId, viewState.commuterAgreementId) && this.ticketCategoryType == viewState.ticketCategoryType && Intrinsics.areEqual(this.tickets, viewState.tickets);
        }

        public final String getCommuterAgreementId() {
            return this.commuterAgreementId;
        }

        public final TicketCategoryType getTicketCategoryType() {
            return this.ticketCategoryType;
        }

        public final List<BornholmCommuterBooking> getTickets() {
            return this.tickets;
        }

        public int hashCode() {
            int hashCode = ((((Boolean.hashCode(this.isLoading) * 31) + this.commuterAgreementId.hashCode()) * 31) + this.ticketCategoryType.hashCode()) * 31;
            List<BornholmCommuterBooking> list = this.tickets;
            return hashCode + (list == null ? 0 : list.hashCode());
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", commuterAgreementId=" + this.commuterAgreementId + ", ticketCategoryType=" + this.ticketCategoryType + ", tickets=" + this.tickets + ")";
        }

        public /* synthetic */ ViewState(boolean z5, String str, TicketCategoryType ticketCategoryType, List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? true : z5, str, (i5 & 4) != 0 ? TicketCategoryType.Commuter : ticketCategoryType, (i5 & 8) != 0 ? null : list);
        }
    }
}
