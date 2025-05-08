package dk.molslinjen.ui.views.screens.agreements.multiride.details.history;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.MultiRideTicketHistoryScreenDestination;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideBookingTicket;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/details/history/MultiRideTicketHistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "multiRideManager", "Ldk/molslinjen/domain/managers/agreement/multiride/MultiRideManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Ldk/molslinjen/domain/managers/agreement/multiride/MultiRideManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Landroidx/lifecycle/SavedStateHandle;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/agreements/multiride/details/history/MultiRideTicketHistoryScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/agreements/multiride/details/history/MultiRideTicketHistoryViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadTickets", BuildConfig.FLAVOR, "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiRideTicketHistoryViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final MultiRideManager multiRideManager;
    private final MultiRideTicketHistoryScreenNavArgs navArgs;
    private final ISnackbarService snackbarService;

    public MultiRideTicketHistoryViewModel(MultiRideManager multiRideManager, ISnackbarService snackbarService, SavedStateHandle savedStateHandle) {
        ViewState value;
        ViewState viewState;
        Object obj;
        MultiRideCard multiRideCard;
        Intrinsics.checkNotNullParameter(multiRideManager, "multiRideManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.multiRideManager = multiRideManager;
        this.snackbarService = snackbarService;
        MultiRideTicketHistoryScreenNavArgs argsFrom = MultiRideTicketHistoryScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(argsFrom.getMultiRideId(), false, null, null, 14, null));
        this._viewState = MutableStateFlow;
        loadTickets();
        do {
            value = MutableStateFlow.getValue();
            viewState = value;
            Iterator<T> it = this.multiRideManager.getState().getValue().getMultiRideCards().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual(((MultiRideCard) obj).getId(), this.navArgs.getMultiRideId())) {
                        break;
                    }
                }
            }
            multiRideCard = (MultiRideCard) obj;
        } while (!MutableStateFlow.compareAndSet(value, ViewState.copy$default(viewState, null, false, null, multiRideCard != null ? multiRideCard.getTicketType() : null, 7, null)));
    }

    private final void loadTickets() {
        ViewState value;
        String multiRideId = getViewState().getValue().getMultiRideId();
        if (multiRideId == null) {
            return;
        }
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, true, null, null, 13, null)));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new MultiRideTicketHistoryViewModel$loadTickets$2(this, multiRideId, null), 3, null);
    }

    public final StateFlow<ViewState> getViewState() {
        return this._viewState;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJD\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u0005\u0010\u001aR\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/details/history/MultiRideTicketHistoryViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "multiRideId", BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideBookingTicket;", "tickets", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "ticketCategory", "<init>", "(Ljava/lang/String;ZLjava/util/List;Ldk/molslinjen/domain/model/booking/TicketCategoryType;)V", "copy", "(Ljava/lang/String;ZLjava/util/List;Ldk/molslinjen/domain/model/booking/TicketCategoryType;)Ldk/molslinjen/ui/views/screens/agreements/multiride/details/history/MultiRideTicketHistoryViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMultiRideId", "Z", "()Z", "Ljava/util/List;", "getTickets", "()Ljava/util/List;", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "getTicketCategory", "()Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final String multiRideId;
        private final TicketCategoryType ticketCategory;
        private final List<MultiRideBookingTicket> tickets;

        public ViewState(String str, boolean z5, List<MultiRideBookingTicket> list, TicketCategoryType ticketCategoryType) {
            this.multiRideId = str;
            this.isLoading = z5;
            this.tickets = list;
            this.ticketCategory = ticketCategoryType;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, String str, boolean z5, List list, TicketCategoryType ticketCategoryType, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = viewState.multiRideId;
            }
            if ((i5 & 2) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 4) != 0) {
                list = viewState.tickets;
            }
            if ((i5 & 8) != 0) {
                ticketCategoryType = viewState.ticketCategory;
            }
            return viewState.copy(str, z5, list, ticketCategoryType);
        }

        public final ViewState copy(String multiRideId, boolean isLoading, List<MultiRideBookingTicket> tickets, TicketCategoryType ticketCategory) {
            return new ViewState(multiRideId, isLoading, tickets, ticketCategory);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.multiRideId, viewState.multiRideId) && this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.tickets, viewState.tickets) && this.ticketCategory == viewState.ticketCategory;
        }

        public final String getMultiRideId() {
            return this.multiRideId;
        }

        public final TicketCategoryType getTicketCategory() {
            return this.ticketCategory;
        }

        public final List<MultiRideBookingTicket> getTickets() {
            return this.tickets;
        }

        public int hashCode() {
            String str = this.multiRideId;
            int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.isLoading)) * 31;
            List<MultiRideBookingTicket> list = this.tickets;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            TicketCategoryType ticketCategoryType = this.ticketCategory;
            return hashCode2 + (ticketCategoryType != null ? ticketCategoryType.hashCode() : 0);
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(multiRideId=" + this.multiRideId + ", isLoading=" + this.isLoading + ", tickets=" + this.tickets + ", ticketCategory=" + this.ticketCategory + ")";
        }

        public /* synthetic */ ViewState(String str, boolean z5, List list, TicketCategoryType ticketCategoryType, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : str, (i5 & 2) != 0 ? true : z5, (i5 & 4) != 0 ? null : list, (i5 & 8) != 0 ? null : ticketCategoryType);
        }
    }
}
