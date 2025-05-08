package dk.molslinjen.ui.views.screens.booking.ticketType;

import android.content.Context;
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
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteState;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.config.Harbor;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.RouteDirectionDetails;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import dk.molslinjen.domain.model.config.Subline;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.KombardoTravelDetailsHandler;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.TravelDetailsState;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u00019BC\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001b\u001a\u00020\u00152\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00150\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ>\u0010#\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0!H\u0096\u0001¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010%R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010&R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010'R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010(R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020.0-8\u0006¢\u0006\f\n\u0004\b1\u00100\u001a\u0004\b2\u00103R\u001a\u00108\u001a\b\u0012\u0004\u0012\u000205048\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006:"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeKombardoViewModel;", "Landroidx/lifecycle/ViewModel;", BuildConfig.FLAVOR, "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "departureManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "routeManager", "Landroid/content/Context;", "context", "Ldk/molslinjen/core/navigation/ICheckoutNavigator;", "checkoutNavigator", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "analyticsTracker", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "editManager", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Ldk/molslinjen/domain/managers/departure/IDepartureManager;Ldk/molslinjen/domain/managers/route/IRouteManager;Landroid/content/Context;Ldk/molslinjen/core/navigation/ICheckoutNavigator;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;Ldk/molslinjen/domain/managers/checkout/IEditManager;)V", "Ldk/molslinjen/domain/model/booking/Departure;", "departure", BuildConfig.FLAVOR, "buildRouteDetailsModel", "(Landroid/content/Context;Ldk/molslinjen/domain/model/booking/Departure;)V", "Lkotlin/Function2;", "Lcom/ramcosta/composedestinations/spec/Direction;", BuildConfig.FLAVOR, "proceed", "(Lkotlin/jvm/functions/Function2;)V", "Ldk/molslinjen/domain/model/config/Harbor;", "departureHarbor", "arrivalHarbor", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", BuildConfig.FLAVOR, "harbors", "buildTravelDetails", "(Landroid/content/Context;Ldk/molslinjen/domain/model/config/Harbor;Ldk/molslinjen/domain/model/config/Harbor;Ldk/molslinjen/domain/model/booking/IDepartureInfo;Ljava/util/List;)V", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "Ldk/molslinjen/core/navigation/ICheckoutNavigator;", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeScreenNavArgs;", "navArgs", "Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeScreenNavArgs;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeKombardoViewModel$ViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/ui/views/screens/booking/shared/kombardoTravelDetails/IKombardoTravelDetailsHandler$TravelDetailsState;", "getTravelDetailsState", "()Lkotlinx/coroutines/flow/StateFlow;", "travelDetailsState", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TicketTypeKombardoViewModel extends ViewModel {
    private final /* synthetic */ KombardoTravelDetailsHandler $$delegate_0;
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final ICheckoutNavigator checkoutNavigator;
    private final IDepartureManager departureManager;
    private final IEditManager editManager;
    private final TicketTypeScreenNavArgs navArgs;
    private final IRouteManager routeManager;
    private final MutableStateFlow<ViewState> viewState;

    public TicketTypeKombardoViewModel(SavedStateHandle savedStateHandle, IDepartureManager departureManager, IRouteManager routeManager, Context context, ICheckoutNavigator checkoutNavigator, IAnalyticsTracker analyticsTracker, IEditManager editManager) {
        RouteDirectionGroup selectedRouteDirectionGroup;
        List<RouteDirectionDetails> routes;
        RouteDirectionDetails routeDirectionDetails;
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(departureManager, "departureManager");
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(checkoutNavigator, "checkoutNavigator");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(editManager, "editManager");
        this.$$delegate_0 = new KombardoTravelDetailsHandler();
        this.departureManager = departureManager;
        this.routeManager = routeManager;
        this.checkoutNavigator = checkoutNavigator;
        this.analyticsTracker = analyticsTracker;
        this.editManager = editManager;
        TicketTypeScreenNavArgs argsFrom = TicketTypeScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, null, null, null, null, null, 63, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        DepartureDirection direction = argsFrom.getDirection();
        Pair<Departure, DepartureTicket> departure = departureManager.getDeparture(argsFrom.getDepartureId(), direction);
        Subline subline = null;
        Departure first = departure != null ? departure.getFirst() : null;
        RouteSelectedState value = routeManager.getActiveSelectedState().getValue();
        PassengerInfo passengerInfo = value != null ? value.getPassengerInfo() : null;
        BookingType value2 = routeManager.getBookingTypeState().getValue();
        if (value != null && (selectedRouteDirectionGroup = value.getSelectedRouteDirectionGroup()) != null && (routes = selectedRouteDirectionGroup.getRoutes()) != null && (routeDirectionDetails = (RouteDirectionDetails) CollectionsKt.firstOrNull((List) routes)) != null) {
            subline = routeDirectionDetails.getSubline();
        }
        while (true) {
            ViewState value3 = MutableStateFlow.getValue();
            Subline subline2 = subline;
            if (MutableStateFlow.compareAndSet(value3, ViewState.copy$default(value3, passengerInfo, null, first, direction, value2, subline, 2, null))) {
                buildRouteDetailsModel(context, first);
                return;
            }
            subline = subline2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    private final void buildRouteDetailsModel(Context context, Departure departure) {
        RouteDirectionGroup selectedRouteDirectionGroup;
        RouteState value;
        LocalizedSiteConfiguration configuration;
        Harbor harbor;
        Harbor harbor2;
        RouteSelectedState value2 = this.routeManager.getActiveSelectedState().getValue();
        if (value2 == null || (selectedRouteDirectionGroup = value2.getSelectedRouteDirectionGroup()) == null || (value = this.routeManager.getRouteState().getValue()) == null || (configuration = value.getConfiguration()) == null) {
            return;
        }
        Iterator it = configuration.getHarbors().iterator();
        while (true) {
            harbor = null;
            if (!it.hasNext()) {
                harbor2 = 0;
                break;
            } else {
                harbor2 = it.next();
                if (Intrinsics.areEqual(((Harbor) harbor2).getId(), selectedRouteDirectionGroup.getDepartureHarbor().getId())) {
                    break;
                }
            }
        }
        Harbor harbor3 = harbor2;
        if (harbor3 == null) {
            return;
        }
        Iterator it2 = configuration.getHarbors().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            ?? next = it2.next();
            if (Intrinsics.areEqual(((Harbor) next).getId(), selectedRouteDirectionGroup.getArrivalHarbor().getId())) {
                harbor = next;
                break;
            }
        }
        Harbor harbor4 = harbor;
        if (harbor4 == null || departure == null) {
            return;
        }
        buildTravelDetails(context, harbor3, harbor4, departure, configuration.getHarbors());
    }

    public void buildTravelDetails(Context context, Harbor departureHarbor, Harbor arrivalHarbor, IDepartureInfo departure, List<Harbor> harbors) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
        Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(harbors, "harbors");
        this.$$delegate_0.buildTravelDetails(context, departureHarbor, arrivalHarbor, departure, harbors);
    }

    public StateFlow<TravelDetailsState> getTravelDetailsState() {
        return this.$$delegate_0.getTravelDetailsState();
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void proceed(Function2<? super Direction, ? super Boolean, Unit> proceed) {
        DepartureDirection departureDirection;
        BookingType bookingType;
        ViewState value;
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        Departure departure = this.viewState.getValue().getDeparture();
        if (departure == null || (departureDirection = this.viewState.getValue().getDepartureDirection()) == null || (bookingType = this._viewState.getValue().getBookingType()) == null) {
            return;
        }
        DepartureTicket departureTicket = (DepartureTicket) CollectionsKt.first((List) departure.getTickets());
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, departureTicket, null, null, null, null, 61, null)));
        this.departureManager.departureTicketSelected(departure, departureTicket, departureDirection);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TicketTypeKombardoViewModel$proceed$2(this, departure, departureTicket, departureDirection, null), 3, null);
        Direction startCheckout = this.checkoutNavigator.startCheckout();
        if (startCheckout == null) {
            return;
        }
        proceed.invoke(startCheckout, Boolean.valueOf(bookingType == BookingType.TwoWay && departureDirection == DepartureDirection.Outbound));
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJX\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010+\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeKombardoViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "selectedTicket", "Ldk/molslinjen/domain/model/booking/Departure;", "departure", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "departureDirection", "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", "Ldk/molslinjen/domain/model/config/Subline;", "subline", "<init>", "(Ldk/molslinjen/domain/model/booking/PassengerInfo;Ldk/molslinjen/domain/model/booking/DepartureTicket;Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/domain/model/config/Subline;)V", "copy", "(Ldk/molslinjen/domain/model/booking/PassengerInfo;Ldk/molslinjen/domain/model/booking/DepartureTicket;Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/domain/model/booking/BookingType;Ldk/molslinjen/domain/model/config/Subline;)Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeKombardoViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "getPassengerInfo", "()Ldk/molslinjen/domain/model/booking/PassengerInfo;", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "getSelectedTicket", "()Ldk/molslinjen/domain/model/booking/DepartureTicket;", "Ldk/molslinjen/domain/model/booking/Departure;", "getDeparture", "()Ldk/molslinjen/domain/model/booking/Departure;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getDepartureDirection", "()Ldk/molslinjen/domain/model/booking/DepartureDirection;", "Ldk/molslinjen/domain/model/booking/BookingType;", "getBookingType", "()Ldk/molslinjen/domain/model/booking/BookingType;", "Ldk/molslinjen/domain/model/config/Subline;", "getSubline", "()Ldk/molslinjen/domain/model/config/Subline;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final BookingType bookingType;
        private final Departure departure;
        private final DepartureDirection departureDirection;
        private final PassengerInfo passengerInfo;
        private final DepartureTicket selectedTicket;
        private final Subline subline;

        public ViewState(PassengerInfo passengerInfo, DepartureTicket departureTicket, Departure departure, DepartureDirection departureDirection, BookingType bookingType, Subline subline) {
            this.passengerInfo = passengerInfo;
            this.selectedTicket = departureTicket;
            this.departure = departure;
            this.departureDirection = departureDirection;
            this.bookingType = bookingType;
            this.subline = subline;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, PassengerInfo passengerInfo, DepartureTicket departureTicket, Departure departure, DepartureDirection departureDirection, BookingType bookingType, Subline subline, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                passengerInfo = viewState.passengerInfo;
            }
            if ((i5 & 2) != 0) {
                departureTicket = viewState.selectedTicket;
            }
            DepartureTicket departureTicket2 = departureTicket;
            if ((i5 & 4) != 0) {
                departure = viewState.departure;
            }
            Departure departure2 = departure;
            if ((i5 & 8) != 0) {
                departureDirection = viewState.departureDirection;
            }
            DepartureDirection departureDirection2 = departureDirection;
            if ((i5 & 16) != 0) {
                bookingType = viewState.bookingType;
            }
            BookingType bookingType2 = bookingType;
            if ((i5 & 32) != 0) {
                subline = viewState.subline;
            }
            return viewState.copy(passengerInfo, departureTicket2, departure2, departureDirection2, bookingType2, subline);
        }

        public final ViewState copy(PassengerInfo passengerInfo, DepartureTicket selectedTicket, Departure departure, DepartureDirection departureDirection, BookingType bookingType, Subline subline) {
            return new ViewState(passengerInfo, selectedTicket, departure, departureDirection, bookingType, subline);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.passengerInfo, viewState.passengerInfo) && Intrinsics.areEqual(this.selectedTicket, viewState.selectedTicket) && Intrinsics.areEqual(this.departure, viewState.departure) && this.departureDirection == viewState.departureDirection && this.bookingType == viewState.bookingType && Intrinsics.areEqual(this.subline, viewState.subline);
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

        public final PassengerInfo getPassengerInfo() {
            return this.passengerInfo;
        }

        public final Subline getSubline() {
            return this.subline;
        }

        public int hashCode() {
            PassengerInfo passengerInfo = this.passengerInfo;
            int hashCode = (passengerInfo == null ? 0 : passengerInfo.hashCode()) * 31;
            DepartureTicket departureTicket = this.selectedTicket;
            int hashCode2 = (hashCode + (departureTicket == null ? 0 : departureTicket.hashCode())) * 31;
            Departure departure = this.departure;
            int hashCode3 = (hashCode2 + (departure == null ? 0 : departure.hashCode())) * 31;
            DepartureDirection departureDirection = this.departureDirection;
            int hashCode4 = (hashCode3 + (departureDirection == null ? 0 : departureDirection.hashCode())) * 31;
            BookingType bookingType = this.bookingType;
            int hashCode5 = (hashCode4 + (bookingType == null ? 0 : bookingType.hashCode())) * 31;
            Subline subline = this.subline;
            return hashCode5 + (subline != null ? subline.hashCode() : 0);
        }

        public String toString() {
            return "ViewState(passengerInfo=" + this.passengerInfo + ", selectedTicket=" + this.selectedTicket + ", departure=" + this.departure + ", departureDirection=" + this.departureDirection + ", bookingType=" + this.bookingType + ", subline=" + this.subline + ")";
        }

        public /* synthetic */ ViewState(PassengerInfo passengerInfo, DepartureTicket departureTicket, Departure departure, DepartureDirection departureDirection, BookingType bookingType, Subline subline, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : passengerInfo, (i5 & 2) != 0 ? null : departureTicket, (i5 & 4) != 0 ? null : departure, (i5 & 8) != 0 ? null : departureDirection, (i5 & 16) != 0 ? null : bookingType, (i5 & 32) != 0 ? null : subline);
        }
    }
}
