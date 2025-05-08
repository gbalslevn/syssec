package dk.molslinjen.ui.views.screens.booking.ticketType;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.TicketTypeScreenDestination;
import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.core.navigation.ICheckoutNavigator;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.departure.IDepartureManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001'B9\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001aR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006¢\u0006\f\n\u0004\b$\u0010#\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeMolslinjenViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "departureManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "routeManager", "Ldk/molslinjen/core/navigation/ICheckoutNavigator;", "checkoutNavigator", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "editManager", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "analyticsTracker", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Ldk/molslinjen/domain/managers/departure/IDepartureManager;Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/core/navigation/ICheckoutNavigator;Ldk/molslinjen/domain/managers/checkout/IEditManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "ticket", "Lkotlin/Function2;", "Lcom/ramcosta/composedestinations/spec/Direction;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "proceed", "(Ldk/molslinjen/domain/model/booking/DepartureTicket;Lkotlin/jvm/functions/Function2;)V", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "Ldk/molslinjen/core/navigation/ICheckoutNavigator;", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeScreenNavArgs;", "navArgs", "Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeScreenNavArgs;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeMolslinjenViewModel$ViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TicketTypeMolslinjenViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final ICheckoutNavigator checkoutNavigator;
    private final IDepartureManager departureManager;
    private final IEditManager editManager;
    private final TicketTypeScreenNavArgs navArgs;
    private final IRouteManager routeManager;
    private final MutableStateFlow<ViewState> viewState;

    public TicketTypeMolslinjenViewModel(SavedStateHandle savedStateHandle, IDepartureManager departureManager, IRouteManager routeManager, ICheckoutNavigator checkoutNavigator, IEditManager editManager, IAnalyticsTracker analyticsTracker) {
        ViewState value;
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(departureManager, "departureManager");
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(checkoutNavigator, "checkoutNavigator");
        Intrinsics.checkNotNullParameter(editManager, "editManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.departureManager = departureManager;
        this.routeManager = routeManager;
        this.checkoutNavigator = checkoutNavigator;
        this.editManager = editManager;
        this.analyticsTracker = analyticsTracker;
        TicketTypeScreenNavArgs argsFrom = TicketTypeScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, null, null, null, null, 31, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        DepartureDirection direction = argsFrom.getDirection();
        BookingType value2 = routeManager.getBookingTypeState().getValue();
        RouteSharedSelectedState value3 = routeManager.getSharedSelectedState().getValue();
        Site site = value3 != null ? value3.getSite() : null;
        Pair<Departure, DepartureTicket> departure = departureManager.getDeparture(argsFrom.getDepartureId(), direction);
        if (departure != null) {
            Departure component1 = departure.component1();
            DepartureTicket component2 = departure.component2();
            do {
                value = MutableStateFlow.getValue();
            } while (!MutableStateFlow.compareAndSet(value, value.copy(component1, component2, direction, value2, site)));
        }
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void proceed(DepartureTicket ticket, Function2<? super Direction, ? super Boolean, Unit> proceed) {
        DepartureDirection departureDirection;
        BookingType bookingType;
        ViewState value;
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        Departure departure = this._viewState.getValue().getDeparture();
        if (departure == null || (departureDirection = this._viewState.getValue().getDepartureDirection()) == null || (bookingType = this._viewState.getValue().getBookingType()) == null) {
            return;
        }
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, ticket, null, null, null, 29, null)));
        this.departureManager.departureTicketSelected(departure, ticket, departureDirection);
        boolean z5 = true;
        boolean z6 = bookingType == BookingType.TwoWay && departureDirection == DepartureDirection.Outbound;
        if (!this.editManager.getEditState().getValue().getIsEditing() && !z6) {
            z5 = false;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TicketTypeMolslinjenViewModel$proceed$2(this, departure, ticket, departureDirection, bookingType, null), 3, null);
        Direction startCheckout = this.checkoutNavigator.startCheckout();
        if (startCheckout == null) {
            return;
        }
        proceed.invoke(startCheckout, Boolean.valueOf(z5));
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJL\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeMolslinjenViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/Departure;", "departure", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "selectedTicket", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "departureDirection", "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", "Ldk/molslinjen/domain/model/config/Site;", "site", "<init>", "(Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/model/booking/DepartureTicket;Ldk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/domain/model/config/Site;)V", "copy", "(Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/model/booking/DepartureTicket;Ldk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/domain/model/config/Site;)Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeMolslinjenViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/booking/Departure;", "getDeparture", "()Ldk/molslinjen/domain/model/booking/Departure;", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "getSelectedTicket", "()Ldk/molslinjen/domain/model/booking/DepartureTicket;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getDepartureDirection", "()Ldk/molslinjen/domain/model/booking/DepartureDirection;", "Ldk/molslinjen/domain/model/booking/BookingType;", "getBookingType", "()Ldk/molslinjen/domain/model/booking/BookingType;", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final BookingType bookingType;
        private final Departure departure;
        private final DepartureDirection departureDirection;
        private final DepartureTicket selectedTicket;
        private final Site site;

        public ViewState(Departure departure, DepartureTicket departureTicket, DepartureDirection departureDirection, BookingType bookingType, Site site) {
            this.departure = departure;
            this.selectedTicket = departureTicket;
            this.departureDirection = departureDirection;
            this.bookingType = bookingType;
            this.site = site;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, Departure departure, DepartureTicket departureTicket, DepartureDirection departureDirection, BookingType bookingType, Site site, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                departure = viewState.departure;
            }
            if ((i5 & 2) != 0) {
                departureTicket = viewState.selectedTicket;
            }
            DepartureTicket departureTicket2 = departureTicket;
            if ((i5 & 4) != 0) {
                departureDirection = viewState.departureDirection;
            }
            DepartureDirection departureDirection2 = departureDirection;
            if ((i5 & 8) != 0) {
                bookingType = viewState.bookingType;
            }
            BookingType bookingType2 = bookingType;
            if ((i5 & 16) != 0) {
                site = viewState.site;
            }
            return viewState.copy(departure, departureTicket2, departureDirection2, bookingType2, site);
        }

        public final ViewState copy(Departure departure, DepartureTicket selectedTicket, DepartureDirection departureDirection, BookingType bookingType, Site site) {
            return new ViewState(departure, selectedTicket, departureDirection, bookingType, site);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.departure, viewState.departure) && Intrinsics.areEqual(this.selectedTicket, viewState.selectedTicket) && this.departureDirection == viewState.departureDirection && this.bookingType == viewState.bookingType && this.site == viewState.site;
        }

        public final BookingType getBookingType() {
            return this.bookingType;
        }

        public final Departure getDeparture() {
            return this.departure;
        }

        public final DepartureDirection getDepartureDirection() {
            return this.departureDirection;
        }

        public final DepartureTicket getSelectedTicket() {
            return this.selectedTicket;
        }

        public final Site getSite() {
            return this.site;
        }

        public int hashCode() {
            Departure departure = this.departure;
            int hashCode = (departure == null ? 0 : departure.hashCode()) * 31;
            DepartureTicket departureTicket = this.selectedTicket;
            int hashCode2 = (hashCode + (departureTicket == null ? 0 : departureTicket.hashCode())) * 31;
            DepartureDirection departureDirection = this.departureDirection;
            int hashCode3 = (hashCode2 + (departureDirection == null ? 0 : departureDirection.hashCode())) * 31;
            BookingType bookingType = this.bookingType;
            int hashCode4 = (hashCode3 + (bookingType == null ? 0 : bookingType.hashCode())) * 31;
            Site site = this.site;
            return hashCode4 + (site != null ? site.hashCode() : 0);
        }

        public String toString() {
            return "ViewState(departure=" + this.departure + ", selectedTicket=" + this.selectedTicket + ", departureDirection=" + this.departureDirection + ", bookingType=" + this.bookingType + ", site=" + this.site + ")";
        }

        public /* synthetic */ ViewState(Departure departure, DepartureTicket departureTicket, DepartureDirection departureDirection, BookingType bookingType, Site site, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : departure, (i5 & 2) != 0 ? null : departureTicket, (i5 & 4) != 0 ? null : departureDirection, (i5 & 8) != 0 ? null : bookingType, (i5 & 16) != 0 ? null : site);
        }
    }
}
