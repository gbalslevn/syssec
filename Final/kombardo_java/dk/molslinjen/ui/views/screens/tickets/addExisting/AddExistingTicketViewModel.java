package dk.molslinjen.ui.views.screens.tickets.addExisting;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0015J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/addExisting/AddExistingTicketViewModel;", "Landroidx/lifecycle/ViewModel;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "ticketsManager", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "<init>", "(Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/managers/ticket/ITicketsManager;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/tickets/addExisting/AddExistingTicketViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "addTicket", BuildConfig.FLAVOR, "proceed", "Lkotlin/Function0;", "updatePhoneNumberCode", "phoneNumberCode", BuildConfig.FLAVOR, "onPhoneNumberChange", "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "onReservationNumberChange", "reservationNumber", "showValidationMessage", "errorMessage", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AddExistingTicketViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final ISnackbarService snackbarService;
    private final ITicketsManager ticketsManager;
    private final StateFlow<ViewState> viewState;

    public AddExistingTicketViewModel(ISnackbarService snackbarService, ITicketsManager ticketsManager) {
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(ticketsManager, "ticketsManager");
        this.snackbarService = snackbarService;
        this.ticketsManager = ticketsManager;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, null, false, 7, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
    }

    public final void addTicket(Function0<Unit> proceed) {
        ViewState value;
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        PhoneNumber phoneNumber = this._viewState.getValue().getPhoneNumber();
        String reservationNumber = this._viewState.getValue().getReservationNumber();
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, null, true, 3, null)));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AddExistingTicketViewModel$addTicket$2(this, phoneNumber, reservationNumber, proceed, null), 3, null);
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void onPhoneNumberChange(PhoneNumber phoneNumber) {
        ViewState value;
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, phoneNumber, null, false, 6, null)));
    }

    public final void onReservationNumberChange(String reservationNumber) {
        ViewState value;
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, reservationNumber, false, 5, null)));
    }

    public final void showValidationMessage(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AddExistingTicketViewModel$showValidationMessage$1(this, errorMessage, null), 3, null);
    }

    public final void updatePhoneNumberCode(String phoneNumberCode) {
        ViewState value;
        ViewState viewState;
        Intrinsics.checkNotNullParameter(phoneNumberCode, "phoneNumberCode");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
            viewState = value;
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(viewState, PhoneNumber.copy$default(viewState.getPhoneNumber(), phoneNumberCode, null, 2, null), null, false, 6, null)));
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u0007\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/addExisting/AddExistingTicketViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "phoneNumber", BuildConfig.FLAVOR, "reservationNumber", BuildConfig.FLAVOR, "isLoading", "<init>", "(Ldk/molslinjen/domain/model/shared/PhoneNumber;Ljava/lang/String;Z)V", "copy", "(Ldk/molslinjen/domain/model/shared/PhoneNumber;Ljava/lang/String;Z)Ldk/molslinjen/ui/views/screens/tickets/addExisting/AddExistingTicketViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "getPhoneNumber", "()Ldk/molslinjen/domain/model/shared/PhoneNumber;", "Ljava/lang/String;", "getReservationNumber", "Z", "()Z", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final PhoneNumber phoneNumber;
        private final String reservationNumber;

        public ViewState(PhoneNumber phoneNumber, String reservationNumber, boolean z5) {
            Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
            Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
            this.phoneNumber = phoneNumber;
            this.reservationNumber = reservationNumber;
            this.isLoading = z5;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, PhoneNumber phoneNumber, String str, boolean z5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                phoneNumber = viewState.phoneNumber;
            }
            if ((i5 & 2) != 0) {
                str = viewState.reservationNumber;
            }
            if ((i5 & 4) != 0) {
                z5 = viewState.isLoading;
            }
            return viewState.copy(phoneNumber, str, z5);
        }

        public final ViewState copy(PhoneNumber phoneNumber, String reservationNumber, boolean isLoading) {
            Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
            Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
            return new ViewState(phoneNumber, reservationNumber, isLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.phoneNumber, viewState.phoneNumber) && Intrinsics.areEqual(this.reservationNumber, viewState.reservationNumber) && this.isLoading == viewState.isLoading;
        }

        public final PhoneNumber getPhoneNumber() {
            return this.phoneNumber;
        }

        public final String getReservationNumber() {
            return this.reservationNumber;
        }

        public int hashCode() {
            return (((this.phoneNumber.hashCode() * 31) + this.reservationNumber.hashCode()) * 31) + Boolean.hashCode(this.isLoading);
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(phoneNumber=" + this.phoneNumber + ", reservationNumber=" + this.reservationNumber + ", isLoading=" + this.isLoading + ")";
        }

        public /* synthetic */ ViewState(PhoneNumber phoneNumber, String str, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? PhoneNumber.Companion.default$default(PhoneNumber.INSTANCE, null, 1, null) : phoneNumber, (i5 & 2) != 0 ? BuildConfig.FLAVOR : str, (i5 & 4) != 0 ? false : z5);
        }
    }
}
