package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInScreenDestination;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.checkout.IEarlyCheckInPassengerManager;
import dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager;
import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.Iterator;
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

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001/B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020 2\b\u0010'\u001a\u0004\u0018\u00010\"H\u0002J\"\u0010(\u001a\u00020 2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020 0*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020 0*J\u000e\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020.R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018¨\u00060"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/EarlyCheckInViewModel;", "Landroidx/lifecycle/ViewModel;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "ticketsManager", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "userVehiclesManager", "Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;", "earlyCheckInPassengerManager", "Ldk/molslinjen/domain/managers/checkout/IEarlyCheckInPassengerManager;", "simpleChangeCheckoutManager", "Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/managers/ticket/ITicketsManager;Ldk/molslinjen/domain/managers/user/vehicles/IUserVehiclesManager;Ldk/molslinjen/domain/managers/checkout/IEarlyCheckInPassengerManager;Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;Landroidx/lifecycle/SavedStateHandle;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/EarlyCheckInScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/EarlyCheckInViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "passengerState", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", "getPassengerState", "simpleChangeCheckoutState", "Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager$SimpleChangeCheckoutState;", "getSimpleChangeCheckoutState", "loadTicket", BuildConfig.FLAVOR, "reservationNumber", BuildConfig.FLAVOR, "phone", "site", "Ldk/molslinjen/domain/model/config/Site;", "setPreselectedVehicle", "licensePlate", "checkIn", "proceedToSummary", "Lkotlin/Function0;", "proceedToOnlyEarlyCheckIn", "updateSelectedVehicle", "vehicle", "Ldk/molslinjen/domain/model/account/UserVehicle;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EarlyCheckInViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IEarlyCheckInPassengerManager earlyCheckInPassengerManager;
    private final EarlyCheckInScreenNavArgs navArgs;
    private final StateFlow<PassengerSelectionHelper.PassengerState> passengerState;
    private final ISimpleChangeCheckoutManager simpleChangeCheckoutManager;
    private final StateFlow<SimpleChangeCheckoutManager.SimpleChangeCheckoutState> simpleChangeCheckoutState;
    private final ISnackbarService snackbarService;
    private final ITicketsManager ticketsManager;
    private final IUserVehiclesManager userVehiclesManager;
    private final StateFlow<ViewState> viewState;

    public EarlyCheckInViewModel(ISnackbarService snackbarService, ITicketsManager ticketsManager, IUserVehiclesManager userVehiclesManager, IEarlyCheckInPassengerManager earlyCheckInPassengerManager, ISimpleChangeCheckoutManager simpleChangeCheckoutManager, SavedStateHandle savedStateHandle) {
        ViewState value;
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(ticketsManager, "ticketsManager");
        Intrinsics.checkNotNullParameter(userVehiclesManager, "userVehiclesManager");
        Intrinsics.checkNotNullParameter(earlyCheckInPassengerManager, "earlyCheckInPassengerManager");
        Intrinsics.checkNotNullParameter(simpleChangeCheckoutManager, "simpleChangeCheckoutManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.snackbarService = snackbarService;
        this.ticketsManager = ticketsManager;
        this.userVehiclesManager = userVehiclesManager;
        this.earlyCheckInPassengerManager = earlyCheckInPassengerManager;
        this.simpleChangeCheckoutManager = simpleChangeCheckoutManager;
        this.navArgs = EarlyCheckInScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, null, null, null, null, null, 63, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        this.passengerState = earlyCheckInPassengerManager.getPassengerState();
        this.simpleChangeCheckoutState = simpleChangeCheckoutManager.getSimpleChangeCheckoutState();
        do {
            value = MutableStateFlow.getValue();
        } while (!MutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, this.navArgs.getReservationNumber(), this.navArgs.getPhone(), this.navArgs.getSite(), null, null, 49, null)));
        loadTicket(this.navArgs.getReservationNumber(), this.navArgs.getPhone(), this.navArgs.getSite());
    }

    private final void loadTicket(String reservationNumber, String phone, Site site) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new EarlyCheckInViewModel$loadTicket$1(this, reservationNumber, phone, site, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPreselectedVehicle(String licensePlate) {
        Object obj;
        ViewState value;
        Iterator<T> it = this.userVehiclesManager.getVehiclesState().getValue().getVehicles().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((UserVehicle) obj).getLicensePlate(), licensePlate)) {
                    break;
                }
            }
        }
        UserVehicle userVehicle = (UserVehicle) obj;
        if (userVehicle != null) {
            MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, null, null, null, null, userVehicle, 31, null)));
        }
    }

    public final void checkIn(Function0<Unit> proceedToSummary, Function0<Unit> proceedToOnlyEarlyCheckIn) {
        Intrinsics.checkNotNullParameter(proceedToSummary, "proceedToSummary");
        Intrinsics.checkNotNullParameter(proceedToOnlyEarlyCheckIn, "proceedToOnlyEarlyCheckIn");
        SimpleChangeCheckoutManager.SimpleChangeCheckoutState value = this.simpleChangeCheckoutManager.getSimpleChangeCheckoutState().getValue();
        this.simpleChangeCheckoutManager.setEarlyCheckIn(this.passengerState.getValue().getAllSelectedPassengers(), this.viewState.getValue().getSelectedVehicle());
        PriceWithCurrency totalPrice = value.getTotalPrice();
        if ((totalPrice != null ? totalPrice.getValue() : 0) > 0) {
            proceedToSummary.invoke();
        } else {
            proceedToOnlyEarlyCheckIn.invoke();
        }
    }

    public final StateFlow<PassengerSelectionHelper.PassengerState> getPassengerState() {
        return this.passengerState;
    }

    public final StateFlow<SimpleChangeCheckoutManager.SimpleChangeCheckoutState> getSimpleChangeCheckoutState() {
        return this.simpleChangeCheckoutState;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void updateSelectedVehicle(UserVehicle vehicle) {
        ViewState value;
        Intrinsics.checkNotNullParameter(vehicle, "vehicle");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, null, null, null, null, vehicle, 31, null)));
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJP\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u0003\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001d\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/EarlyCheckInViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "reservationNumber", "phone", "Ldk/molslinjen/domain/model/config/Site;", "site", "Ldk/molslinjen/domain/model/booking/Booking;", "booking", "Ldk/molslinjen/domain/model/account/UserVehicle;", "selectedVehicle", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/booking/Booking;Ldk/molslinjen/domain/model/account/UserVehicle;)V", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/booking/Booking;Ldk/molslinjen/domain/model/account/UserVehicle;)Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/EarlyCheckInViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ljava/lang/String;", "getReservationNumber", "getPhone", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "Ldk/molslinjen/domain/model/booking/Booking;", "getBooking", "()Ldk/molslinjen/domain/model/booking/Booking;", "Ldk/molslinjen/domain/model/account/UserVehicle;", "getSelectedVehicle", "()Ldk/molslinjen/domain/model/account/UserVehicle;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final Booking booking;
        private final boolean isLoading;
        private final String phone;
        private final String reservationNumber;
        private final UserVehicle selectedVehicle;
        private final Site site;

        public ViewState(boolean z5, String reservationNumber, String phone, Site site, Booking booking, UserVehicle userVehicle) {
            Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(site, "site");
            this.isLoading = z5;
            this.reservationNumber = reservationNumber;
            this.phone = phone;
            this.site = site;
            this.booking = booking;
            this.selectedVehicle = userVehicle;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, String str, String str2, Site site, Booking booking, UserVehicle userVehicle, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 2) != 0) {
                str = viewState.reservationNumber;
            }
            String str3 = str;
            if ((i5 & 4) != 0) {
                str2 = viewState.phone;
            }
            String str4 = str2;
            if ((i5 & 8) != 0) {
                site = viewState.site;
            }
            Site site2 = site;
            if ((i5 & 16) != 0) {
                booking = viewState.booking;
            }
            Booking booking2 = booking;
            if ((i5 & 32) != 0) {
                userVehicle = viewState.selectedVehicle;
            }
            return viewState.copy(z5, str3, str4, site2, booking2, userVehicle);
        }

        public final ViewState copy(boolean isLoading, String reservationNumber, String phone, Site site, Booking booking, UserVehicle selectedVehicle) {
            Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(site, "site");
            return new ViewState(isLoading, reservationNumber, phone, site, booking, selectedVehicle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.reservationNumber, viewState.reservationNumber) && Intrinsics.areEqual(this.phone, viewState.phone) && this.site == viewState.site && Intrinsics.areEqual(this.booking, viewState.booking) && Intrinsics.areEqual(this.selectedVehicle, viewState.selectedVehicle);
        }

        public final Booking getBooking() {
            return this.booking;
        }

        public final UserVehicle getSelectedVehicle() {
            return this.selectedVehicle;
        }

        public int hashCode() {
            int hashCode = ((((((Boolean.hashCode(this.isLoading) * 31) + this.reservationNumber.hashCode()) * 31) + this.phone.hashCode()) * 31) + this.site.hashCode()) * 31;
            Booking booking = this.booking;
            int hashCode2 = (hashCode + (booking == null ? 0 : booking.hashCode())) * 31;
            UserVehicle userVehicle = this.selectedVehicle;
            return hashCode2 + (userVehicle != null ? userVehicle.hashCode() : 0);
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", reservationNumber=" + this.reservationNumber + ", phone=" + this.phone + ", site=" + this.site + ", booking=" + this.booking + ", selectedVehicle=" + this.selectedVehicle + ")";
        }

        public /* synthetic */ ViewState(boolean z5, String str, String str2, Site site, Booking booking, UserVehicle userVehicle, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? true : z5, (i5 & 2) != 0 ? BuildConfig.FLAVOR : str, (i5 & 4) == 0 ? str2 : BuildConfig.FLAVOR, (i5 & 8) != 0 ? Site.Mols : site, (i5 & 16) != 0 ? null : booking, (i5 & 32) != 0 ? null : userVehicle);
        }
    }
}
