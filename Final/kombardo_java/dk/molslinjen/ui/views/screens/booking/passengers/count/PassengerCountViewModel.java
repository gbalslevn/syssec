package dk.molslinjen.ui.views.screens.booking.passengers.count;

import androidx.lifecycle.ViewModel;
import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.core.navigation.ICheckoutNavigator;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.EditManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutManager;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.departure.IDepartureManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.TicketSection;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.ExpirableCheckoutHandler;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001:BI\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010&H\u0002J\u001a\u0010(\u001a\u00020$2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020$0)J\u0016\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020$2\u0006\u00101\u001a\u000202J\t\u00103\u001a\u000202H\u0096\u0001J\t\u00104\u001a\u000202H\u0096\u0001J\t\u00105\u001a\u000202H\u0096\u0001J\t\u00106\u001a\u000202H\u0096\u0001J\t\u00107\u001a\u000202H\u0096\u0001J\t\u00108\u001a\u00020$H\u0096\u0001J\t\u00109\u001a\u000202H\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006;"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/count/PassengerCountViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/ui/views/screens/booking/shared/expiration/IExpirableCheckout;", "checkoutManager", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "checkoutNavigator", "Ldk/molslinjen/core/navigation/ICheckoutNavigator;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "departureManager", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "returnManager", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "editManager", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "paymentManager", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;Ldk/molslinjen/core/navigation/ICheckoutNavigator;Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/departure/IDepartureManager;Ldk/molslinjen/domain/managers/checkout/IReturnManager;Ldk/molslinjen/domain/managers/checkout/IEditManager;Ldk/molslinjen/domain/managers/checkout/IPaymentManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "checkoutState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "getCheckoutState", "()Lkotlinx/coroutines/flow/StateFlow;", "editState", "Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;", "getEditState", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/passengers/count/PassengerCountViewModel$ViewState;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setup", BuildConfig.FLAVOR, "outboundCheckoutDirectionState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;", "returnCheckoutDirectionState", "proceed", "Lkotlin/Function1;", "Lcom/ramcosta/composedestinations/spec/Direction;", "passengerCountChanged", "count", BuildConfig.FLAVOR, "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "changeSameReturnPassengersAsOutbound", "sameAsOutbound", BuildConfig.FLAVOR, "isCommuter", "isEditing", "isExpired", "isInCheckoutFlow", "isMultiRide", "resetCheckoutAfterExpiredDepartures", "showReloadDialog", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PassengerCountViewModel extends ViewModel implements IExpirableCheckout {
    private final /* synthetic */ ExpirableCheckoutHandler $$delegate_0;
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final ICheckoutManager checkoutManager;
    private final ICheckoutNavigator checkoutNavigator;
    private final StateFlow<CheckoutManager.CheckoutState> checkoutState;
    private final IDepartureManager departureManager;
    private final IEditManager editManager;
    private final StateFlow<EditManager.EditState> editState;
    private final IPaymentManager paymentManager;
    private final IReturnManager returnManager;
    private final IRouteManager routeManager;
    private final MutableStateFlow<ViewState> viewState;

    public PassengerCountViewModel(ICheckoutManager checkoutManager, ICheckoutNavigator checkoutNavigator, IRouteManager routeManager, IDepartureManager departureManager, IReturnManager returnManager, IEditManager editManager, IPaymentManager paymentManager, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(checkoutNavigator, "checkoutNavigator");
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(departureManager, "departureManager");
        Intrinsics.checkNotNullParameter(returnManager, "returnManager");
        Intrinsics.checkNotNullParameter(editManager, "editManager");
        Intrinsics.checkNotNullParameter(paymentManager, "paymentManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.$$delegate_0 = new ExpirableCheckoutHandler(routeManager, departureManager, editManager, returnManager, paymentManager, null, false, analyticsTracker, 96, null);
        this.checkoutManager = checkoutManager;
        this.checkoutNavigator = checkoutNavigator;
        this.routeManager = routeManager;
        this.departureManager = departureManager;
        this.returnManager = returnManager;
        this.editManager = editManager;
        this.paymentManager = paymentManager;
        this.analyticsTracker = analyticsTracker;
        this.checkoutState = checkoutManager.getCheckoutState();
        this.editState = editManager.getEditState();
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, 0, 0, false, null, false, 63, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        setup(checkoutManager.directionState(DepartureDirection.Outbound).getValue(), checkoutManager.directionState(DepartureDirection.Return).getValue());
    }

    private final void setup(CheckoutManager.CheckoutDirectionState outboundCheckoutDirectionState, CheckoutManager.CheckoutDirectionState returnCheckoutDirectionState) {
        ViewState value;
        PassengerInfo passengerInfo;
        PassengerInfo passengerInfo2;
        CheckoutManager.CheckoutState value2 = this.checkoutManager.getCheckoutState().getValue();
        if (value2 == null) {
            return;
        }
        int totalPassengerCount = (outboundCheckoutDirectionState == null || (passengerInfo2 = outboundCheckoutDirectionState.getPassengerInfo()) == null) ? 0 : passengerInfo2.getTotalPassengerCount();
        int totalPassengerCount2 = (returnCheckoutDirectionState == null || (passengerInfo = returnCheckoutDirectionState.getPassengerInfo()) == null) ? totalPassengerCount : passengerInfo.getTotalPassengerCount();
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, totalPassengerCount, totalPassengerCount2, false, value2.getBookingType(), this.returnManager.getReturnState().getValue().getIsAddingReturnFromBookingSummary(), 9, null)));
    }

    public final void changeSameReturnPassengersAsOutbound(boolean sameAsOutbound) {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, 0, 0, sameAsOutbound, null, false, 55, null)));
        passengerCountChanged(this.viewState.getValue().getOutboundPassengerCount(), DepartureDirection.Return);
    }

    public final StateFlow<CheckoutManager.CheckoutState> getCheckoutState() {
        return this.checkoutState;
    }

    public final StateFlow<EditManager.EditState> getEditState() {
        return this.editState;
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean isCommuter() {
        return this.$$delegate_0.isCommuter();
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean isEditing() {
        return this.$$delegate_0.isEditing();
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean isExpired() {
        return this.$$delegate_0.isExpired();
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean isInCheckoutFlow() {
        return this.$$delegate_0.isInCheckoutFlow();
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean isMultiRide() {
        return this.$$delegate_0.isMultiRide();
    }

    public final void passengerCountChanged(int count, DepartureDirection departureDirection) {
        ViewState value;
        ViewState value2;
        ViewState value3;
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        CheckoutManager.CheckoutState value4 = this.checkoutState.getValue();
        if (value4 == null) {
            return;
        }
        int min = Math.min(count, value4.getTransportation().getMaxPassengers());
        if (departureDirection == DepartureDirection.Outbound) {
            MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
            do {
                value2 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value2, ViewState.copy$default(value2, false, min, 0, false, null, false, 61, null)));
            if (this._viewState.getValue().getSameReturnPassengersAsOutbound()) {
                MutableStateFlow<ViewState> mutableStateFlow2 = this._viewState;
                do {
                    value3 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value3, ViewState.copy$default(value3, false, 0, min, false, null, false, 59, null)));
                this.checkoutManager.updatePassengerCount(min, DepartureDirection.Return);
            }
        } else {
            MutableStateFlow<ViewState> mutableStateFlow3 = this._viewState;
            do {
                value = mutableStateFlow3.getValue();
            } while (!mutableStateFlow3.compareAndSet(value, ViewState.copy$default(value, false, 0, min, false, null, false, 59, null)));
        }
        this.checkoutManager.updatePassengerCount(min, departureDirection);
    }

    public final void proceed(Function1<? super Direction, Unit> proceed) {
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        Direction nextStep = this.checkoutNavigator.nextStep(TicketSection.Passenger, this.viewState.getValue().getBookingType(), DepartureDirection.Return);
        if (nextStep == null) {
            return;
        }
        proceed.invoke(nextStep);
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public void resetCheckoutAfterExpiredDepartures() {
        this.$$delegate_0.resetCheckoutAfterExpiredDepartures();
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean showReloadDialog() {
        return this.$$delegate_0.showReloadDialog();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJL\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0003\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001c\u0010\u0018R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b \u0010\u0018¨\u0006!"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/count/PassengerCountViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "outboundPassengerCount", "returnPassengerCount", "sameReturnPassengersAsOutbound", "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", "lockOutbound", "<init>", "(ZIIZLdk/molslinjen/domain/model/booking/BookingType;Z)V", "copy", "(ZIIZLdk/molslinjen/domain/model/booking/BookingType;Z)Ldk/molslinjen/ui/views/screens/booking/passengers/count/PassengerCountViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "I", "getOutboundPassengerCount", "getReturnPassengerCount", "getSameReturnPassengersAsOutbound", "Ldk/molslinjen/domain/model/booking/BookingType;", "getBookingType", "()Ldk/molslinjen/domain/model/booking/BookingType;", "getLockOutbound", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final BookingType bookingType;
        private final boolean isLoading;
        private final boolean lockOutbound;
        private final int outboundPassengerCount;
        private final int returnPassengerCount;
        private final boolean sameReturnPassengersAsOutbound;

        public ViewState(boolean z5, int i5, int i6, boolean z6, BookingType bookingType, boolean z7) {
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            this.isLoading = z5;
            this.outboundPassengerCount = i5;
            this.returnPassengerCount = i6;
            this.sameReturnPassengersAsOutbound = z6;
            this.bookingType = bookingType;
            this.lockOutbound = z7;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, int i5, int i6, boolean z6, BookingType bookingType, boolean z7, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i7 & 2) != 0) {
                i5 = viewState.outboundPassengerCount;
            }
            int i8 = i5;
            if ((i7 & 4) != 0) {
                i6 = viewState.returnPassengerCount;
            }
            int i9 = i6;
            if ((i7 & 8) != 0) {
                z6 = viewState.sameReturnPassengersAsOutbound;
            }
            boolean z8 = z6;
            if ((i7 & 16) != 0) {
                bookingType = viewState.bookingType;
            }
            BookingType bookingType2 = bookingType;
            if ((i7 & 32) != 0) {
                z7 = viewState.lockOutbound;
            }
            return viewState.copy(z5, i8, i9, z8, bookingType2, z7);
        }

        public final ViewState copy(boolean isLoading, int outboundPassengerCount, int returnPassengerCount, boolean sameReturnPassengersAsOutbound, BookingType bookingType, boolean lockOutbound) {
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            return new ViewState(isLoading, outboundPassengerCount, returnPassengerCount, sameReturnPassengersAsOutbound, bookingType, lockOutbound);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && this.outboundPassengerCount == viewState.outboundPassengerCount && this.returnPassengerCount == viewState.returnPassengerCount && this.sameReturnPassengersAsOutbound == viewState.sameReturnPassengersAsOutbound && this.bookingType == viewState.bookingType && this.lockOutbound == viewState.lockOutbound;
        }

        public final BookingType getBookingType() {
            return this.bookingType;
        }

        public final boolean getLockOutbound() {
            return this.lockOutbound;
        }

        public final int getOutboundPassengerCount() {
            return this.outboundPassengerCount;
        }

        public final int getReturnPassengerCount() {
            return this.returnPassengerCount;
        }

        public final boolean getSameReturnPassengersAsOutbound() {
            return this.sameReturnPassengersAsOutbound;
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.isLoading) * 31) + Integer.hashCode(this.outboundPassengerCount)) * 31) + Integer.hashCode(this.returnPassengerCount)) * 31) + Boolean.hashCode(this.sameReturnPassengersAsOutbound)) * 31) + this.bookingType.hashCode()) * 31) + Boolean.hashCode(this.lockOutbound);
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", outboundPassengerCount=" + this.outboundPassengerCount + ", returnPassengerCount=" + this.returnPassengerCount + ", sameReturnPassengersAsOutbound=" + this.sameReturnPassengersAsOutbound + ", bookingType=" + this.bookingType + ", lockOutbound=" + this.lockOutbound + ")";
        }

        public /* synthetic */ ViewState(boolean z5, int i5, int i6, boolean z6, BookingType bookingType, boolean z7, int i7, DefaultConstructorMarker defaultConstructorMarker) {
            this((i7 & 1) != 0 ? true : z5, (i7 & 2) != 0 ? 0 : i5, (i7 & 4) != 0 ? 0 : i6, (i7 & 8) == 0 ? z6 : true, (i7 & 16) != 0 ? BookingType.Single : bookingType, (i7 & 32) != 0 ? false : z7);
        }
    }
}
