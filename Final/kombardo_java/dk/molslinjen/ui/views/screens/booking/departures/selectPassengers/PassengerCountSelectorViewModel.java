package dk.molslinjen.ui.views.screens.booking.departures.selectPassengers;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.config.Transportation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002,-B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u0014\u0010\u001d\u001a\u00020\u00192\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u001fJ\u0016\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0016\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0016\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u000e\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006."}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel;", "Landroidx/lifecycle/ViewModel;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "returnManager", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "<init>", "(Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/checkout/IReturnManager;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "_outboundPassengerState", "Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel$PassengerSelectionState;", "outboundPassengerState", "getOutboundPassengerState", "_returnPassengerState", "returnPassengerState", "getReturnPassengerState", "load", BuildConfig.FLAVOR, "showValidationMessage", "errorMessage", BuildConfig.FLAVOR, "saveAndClose", "proceed", "Lkotlin/Function0;", "onAdultsChange", "adults", BuildConfig.FLAVOR, "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "onChildrenChange", "children", "onInfantsChange", "infants", "onChangedSamePassengerForBothDirections", "samePassengersForBothDirections", BuildConfig.FLAVOR, "PassengerSelectionState", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PassengerCountSelectorViewModel extends ViewModel {
    private final MutableStateFlow<PassengerSelectionState> _outboundPassengerState;
    private final MutableStateFlow<PassengerSelectionState> _returnPassengerState;
    private final MutableStateFlow<ViewState> _viewState;
    private final StateFlow<PassengerSelectionState> outboundPassengerState;
    private final IReturnManager returnManager;
    private final StateFlow<PassengerSelectionState> returnPassengerState;
    private final IRouteManager routeManager;
    private final ISnackbarService snackbarService;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJL\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b \u0010\u0011R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u000b\u0010\u001d¨\u0006$"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", BuildConfig.FLAVOR, "samePassengersForBothDirections", BuildConfig.FLAVOR, "childAgeRange", "infantAgeRange", "Ldk/molslinjen/domain/model/config/Transportation;", "transportation", "isAddingReturnFromBookingSummary", "<init>", "(Ldk/molslinjen/domain/model/booking/BookingType;ZLjava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Transportation;Z)V", "copy", "(Ldk/molslinjen/domain/model/booking/BookingType;ZLjava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Transportation;Z)Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/booking/BookingType;", "getBookingType", "()Ldk/molslinjen/domain/model/booking/BookingType;", "Z", "getSamePassengersForBothDirections", "()Z", "Ljava/lang/String;", "getChildAgeRange", "getInfantAgeRange", "Ldk/molslinjen/domain/model/config/Transportation;", "getTransportation", "()Ldk/molslinjen/domain/model/config/Transportation;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final BookingType bookingType;
        private final String childAgeRange;
        private final String infantAgeRange;
        private final boolean isAddingReturnFromBookingSummary;
        private final boolean samePassengersForBothDirections;
        private final Transportation transportation;

        public ViewState(BookingType bookingType, boolean z5, String childAgeRange, String infantAgeRange, Transportation transportation, boolean z6) {
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            Intrinsics.checkNotNullParameter(childAgeRange, "childAgeRange");
            Intrinsics.checkNotNullParameter(infantAgeRange, "infantAgeRange");
            Intrinsics.checkNotNullParameter(transportation, "transportation");
            this.bookingType = bookingType;
            this.samePassengersForBothDirections = z5;
            this.childAgeRange = childAgeRange;
            this.infantAgeRange = infantAgeRange;
            this.transportation = transportation;
            this.isAddingReturnFromBookingSummary = z6;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, BookingType bookingType, boolean z5, String str, String str2, Transportation transportation, boolean z6, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                bookingType = viewState.bookingType;
            }
            if ((i5 & 2) != 0) {
                z5 = viewState.samePassengersForBothDirections;
            }
            boolean z7 = z5;
            if ((i5 & 4) != 0) {
                str = viewState.childAgeRange;
            }
            String str3 = str;
            if ((i5 & 8) != 0) {
                str2 = viewState.infantAgeRange;
            }
            String str4 = str2;
            if ((i5 & 16) != 0) {
                transportation = viewState.transportation;
            }
            Transportation transportation2 = transportation;
            if ((i5 & 32) != 0) {
                z6 = viewState.isAddingReturnFromBookingSummary;
            }
            return viewState.copy(bookingType, z7, str3, str4, transportation2, z6);
        }

        public final ViewState copy(BookingType bookingType, boolean samePassengersForBothDirections, String childAgeRange, String infantAgeRange, Transportation transportation, boolean isAddingReturnFromBookingSummary) {
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            Intrinsics.checkNotNullParameter(childAgeRange, "childAgeRange");
            Intrinsics.checkNotNullParameter(infantAgeRange, "infantAgeRange");
            Intrinsics.checkNotNullParameter(transportation, "transportation");
            return new ViewState(bookingType, samePassengersForBothDirections, childAgeRange, infantAgeRange, transportation, isAddingReturnFromBookingSummary);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.bookingType == viewState.bookingType && this.samePassengersForBothDirections == viewState.samePassengersForBothDirections && Intrinsics.areEqual(this.childAgeRange, viewState.childAgeRange) && Intrinsics.areEqual(this.infantAgeRange, viewState.infantAgeRange) && Intrinsics.areEqual(this.transportation, viewState.transportation) && this.isAddingReturnFromBookingSummary == viewState.isAddingReturnFromBookingSummary;
        }

        public final BookingType getBookingType() {
            return this.bookingType;
        }

        public final String getChildAgeRange() {
            return this.childAgeRange;
        }

        public final String getInfantAgeRange() {
            return this.infantAgeRange;
        }

        public final boolean getSamePassengersForBothDirections() {
            return this.samePassengersForBothDirections;
        }

        public final Transportation getTransportation() {
            return this.transportation;
        }

        public int hashCode() {
            return (((((((((this.bookingType.hashCode() * 31) + Boolean.hashCode(this.samePassengersForBothDirections)) * 31) + this.childAgeRange.hashCode()) * 31) + this.infantAgeRange.hashCode()) * 31) + this.transportation.hashCode()) * 31) + Boolean.hashCode(this.isAddingReturnFromBookingSummary);
        }

        /* renamed from: isAddingReturnFromBookingSummary, reason: from getter */
        public final boolean getIsAddingReturnFromBookingSummary() {
            return this.isAddingReturnFromBookingSummary;
        }

        public String toString() {
            return "ViewState(bookingType=" + this.bookingType + ", samePassengersForBothDirections=" + this.samePassengersForBothDirections + ", childAgeRange=" + this.childAgeRange + ", infantAgeRange=" + this.infantAgeRange + ", transportation=" + this.transportation + ", isAddingReturnFromBookingSummary=" + this.isAddingReturnFromBookingSummary + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DepartureDirection.values().length];
            try {
                iArr[DepartureDirection.Outbound.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DepartureDirection.Return.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PassengerCountSelectorViewModel(ISnackbarService snackbarService, IRouteManager routeManager, IReturnManager returnManager) {
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(returnManager, "returnManager");
        this.snackbarService = snackbarService;
        this.routeManager = routeManager;
        this.returnManager = returnManager;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        MutableStateFlow<PassengerSelectionState> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new PassengerSelectionState(0, 0, 0, 7, null));
        this._outboundPassengerState = MutableStateFlow2;
        this.outboundPassengerState = MutableStateFlow2;
        MutableStateFlow<PassengerSelectionState> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this._returnPassengerState = MutableStateFlow3;
        this.returnPassengerState = MutableStateFlow3;
        load();
    }

    private final void load() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PassengerCountSelectorViewModel$load$1(this, null), 3, null);
    }

    public final StateFlow<PassengerSelectionState> getOutboundPassengerState() {
        return this.outboundPassengerState;
    }

    public final StateFlow<PassengerSelectionState> getReturnPassengerState() {
        return this.returnPassengerState;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void onAdultsChange(int adults, DepartureDirection departureDirection) {
        PassengerSelectionState value;
        PassengerSelectionState value2;
        PassengerSelectionState passengerSelectionState;
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        int i5 = WhenMappings.$EnumSwitchMapping$0[departureDirection.ordinal()];
        if (i5 == 1) {
            MutableStateFlow<PassengerSelectionState> mutableStateFlow = this._outboundPassengerState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, PassengerSelectionState.copy$default(value, adults, 0, 0, 6, null)));
        } else {
            if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            MutableStateFlow<PassengerSelectionState> mutableStateFlow2 = this._returnPassengerState;
            do {
                value2 = mutableStateFlow2.getValue();
                passengerSelectionState = value2;
            } while (!mutableStateFlow2.compareAndSet(value2, passengerSelectionState != null ? PassengerSelectionState.copy$default(passengerSelectionState, adults, 0, 0, 6, null) : null));
        }
    }

    public final void onChangedSamePassengerForBothDirections(boolean samePassengersForBothDirections) {
        ViewState value;
        ViewState viewState;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
            viewState = value;
        } while (!mutableStateFlow.compareAndSet(value, viewState != null ? ViewState.copy$default(viewState, null, samePassengersForBothDirections, null, null, null, false, 61, null) : null));
        if (samePassengersForBothDirections) {
            return;
        }
        MutableStateFlow<PassengerSelectionState> mutableStateFlow2 = this._returnPassengerState;
        do {
        } while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), this.outboundPassengerState.getValue()));
    }

    public final void onChildrenChange(int children, DepartureDirection departureDirection) {
        PassengerSelectionState value;
        PassengerSelectionState value2;
        PassengerSelectionState passengerSelectionState;
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        int i5 = WhenMappings.$EnumSwitchMapping$0[departureDirection.ordinal()];
        if (i5 == 1) {
            MutableStateFlow<PassengerSelectionState> mutableStateFlow = this._outboundPassengerState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, PassengerSelectionState.copy$default(value, 0, children, 0, 5, null)));
        } else {
            if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            MutableStateFlow<PassengerSelectionState> mutableStateFlow2 = this._returnPassengerState;
            do {
                value2 = mutableStateFlow2.getValue();
                passengerSelectionState = value2;
            } while (!mutableStateFlow2.compareAndSet(value2, passengerSelectionState != null ? PassengerSelectionState.copy$default(passengerSelectionState, 0, children, 0, 5, null) : null));
        }
    }

    public final void onInfantsChange(int infants, DepartureDirection departureDirection) {
        PassengerSelectionState value;
        PassengerSelectionState value2;
        PassengerSelectionState passengerSelectionState;
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        int i5 = WhenMappings.$EnumSwitchMapping$0[departureDirection.ordinal()];
        if (i5 == 1) {
            MutableStateFlow<PassengerSelectionState> mutableStateFlow = this._outboundPassengerState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, PassengerSelectionState.copy$default(value, 0, 0, infants, 3, null)));
        } else {
            if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            MutableStateFlow<PassengerSelectionState> mutableStateFlow2 = this._returnPassengerState;
            do {
                value2 = mutableStateFlow2.getValue();
                passengerSelectionState = value2;
            } while (!mutableStateFlow2.compareAndSet(value2, passengerSelectionState != null ? PassengerSelectionState.copy$default(passengerSelectionState, 0, 0, infants, 3, null) : null));
        }
    }

    public final void saveAndClose(Function0<Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PassengerCountSelectorViewModel$saveAndClose$1(this, proceed, null), 3, null);
    }

    public final void showValidationMessage(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PassengerCountSelectorViewModel$showValidationMessage$1(this, errorMessage, null), 3, null);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel$PassengerSelectionState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "adults", "children", "infants", "<init>", "(III)V", "copy", "(III)Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel$PassengerSelectionState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "I", "getAdults", "getChildren", "getInfants", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class PassengerSelectionState {
        private final int adults;
        private final int children;
        private final int infants;

        public PassengerSelectionState(int i5, int i6, int i7) {
            this.adults = i5;
            this.children = i6;
            this.infants = i7;
        }

        public static /* synthetic */ PassengerSelectionState copy$default(PassengerSelectionState passengerSelectionState, int i5, int i6, int i7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i5 = passengerSelectionState.adults;
            }
            if ((i8 & 2) != 0) {
                i6 = passengerSelectionState.children;
            }
            if ((i8 & 4) != 0) {
                i7 = passengerSelectionState.infants;
            }
            return passengerSelectionState.copy(i5, i6, i7);
        }

        public final PassengerSelectionState copy(int adults, int children, int infants) {
            return new PassengerSelectionState(adults, children, infants);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PassengerSelectionState)) {
                return false;
            }
            PassengerSelectionState passengerSelectionState = (PassengerSelectionState) other;
            return this.adults == passengerSelectionState.adults && this.children == passengerSelectionState.children && this.infants == passengerSelectionState.infants;
        }

        public final int getAdults() {
            return this.adults;
        }

        public final int getChildren() {
            return this.children;
        }

        public final int getInfants() {
            return this.infants;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.adults) * 31) + Integer.hashCode(this.children)) * 31) + Integer.hashCode(this.infants);
        }

        public String toString() {
            return "PassengerSelectionState(adults=" + this.adults + ", children=" + this.children + ", infants=" + this.infants + ")";
        }

        public /* synthetic */ PassengerSelectionState(int i5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? 1 : i5, (i8 & 2) != 0 ? 0 : i6, (i8 & 4) != 0 ? 0 : i7);
        }
    }
}
