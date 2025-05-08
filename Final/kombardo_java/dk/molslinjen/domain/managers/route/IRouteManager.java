package dk.molslinjen.domain.managers.route;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.CommuterBookingData;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.LineItem;
import dk.molslinjen.domain.model.booking.MultiRideBookingData;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.config.TransportationSelectionModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0003H&J\b\u0010\u0016\u001a\u00020\u0017H&J\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019H¦@¢\u0006\u0002\u0010\u001cJ&\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00192\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001aH¦@¢\u0006\u0002\u0010!J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00192\u0006\u0010\"\u001a\u00020#H¦@¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'H&J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'H&J\u000e\u0010)\u001a\u00020\u001eH¦@¢\u0006\u0002\u0010\u001cJ&\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020'H¦@¢\u0006\u0002\u0010/J$\u00100\u001a\u00020\u001e2\b\u00101\u001a\u0004\u0018\u00010\u001b2\b\u00102\u001a\u0004\u0018\u00010\u001b2\u0006\u0010.\u001a\u00020'H&J\u0016\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u000205H¦@¢\u0006\u0002\u00106J.\u00103\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u00107\u001a\u0004\u0018\u0001082\n\b\u0002\u00109\u001a\u0004\u0018\u000108H¦@¢\u0006\u0002\u0010:J,\u0010;\u001a\u00020\u001e2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u001a2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u001a2\u0006\u0010.\u001a\u00020'H&J\u0010\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020AH&J.\u0010B\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020#H¦@¢\u0006\u0002\u0010JJ\u001a\u0010K\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020M0L0\u001aH&J\u001a\u0010N\u001a\u00020\u001e2\u0006\u0010O\u001a\u00020\u00042\b\u0010P\u001a\u0004\u0018\u00010AH&J\u001a\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020\b2\b\u0010S\u001a\u0004\u0018\u00010AH&J\b\u0010T\u001a\u00020\u001eH&J\u0016\u0010U\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020WH¦@¢\u0006\u0002\u0010XJ\u001e\u0010Y\u001a\u00020\u001e2\u0006\u0010Z\u001a\u00020[2\u0006\u0010C\u001a\u00020DH¦@¢\u0006\u0002\u0010\\J\u001e\u0010]\u001a\u00020\u001e2\u0006\u0010^\u001a\u00020_2\u0006\u0010C\u001a\u00020DH¦@¢\u0006\u0002\u0010`R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006¨\u0006a"}, d2 = {"Ldk/molslinjen/domain/managers/route/IRouteManager;", BuildConfig.FLAVOR, "activeDepartureDirectionState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getActiveDepartureDirectionState", "()Lkotlinx/coroutines/flow/StateFlow;", "bookingTypeState", "Ldk/molslinjen/domain/model/booking/BookingType;", "getBookingTypeState", "sharedSelectedState", "Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;", "getSharedSelectedState", "routeState", "Ldk/molslinjen/domain/managers/route/RouteState;", "getRouteState", "outboundSelectedState", "Ldk/molslinjen/domain/managers/route/RouteSelectedState;", "getOutboundSelectedState", "returnSelectedState", "getReturnSelectedState", "getActiveSelectedState", "getTransportationSelectionModel", "Ldk/molslinjen/domain/model/config/TransportationSelectionModel;", "loadTrailers", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadTransportProducts", BuildConfig.FLAVOR, "selectedEditProductsAfterLoad", "Ldk/molslinjen/domain/model/booking/LineItem;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transportationId", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeSelectedTrailer", "onlyActiveDirection", BuildConfig.FLAVOR, "removeAllSelectedTransportProducts", "flipDirection", "updatePassengers", "outboundPassengerInfo", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "returnPassengerInfo", "isAddingReturnFromBookingSummary", "(Ldk/molslinjen/domain/model/booking/PassengerInfo;Ldk/molslinjen/domain/model/booking/PassengerInfo;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTrailer", "outboundTrailer", "returnTrailer", "setTransportation", "transportation", "Ldk/molslinjen/domain/model/config/Transportation;", "(Ldk/molslinjen/domain/model/config/Transportation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "outboundCargoInfo", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "returnCargoInfo", "(Ljava/lang/String;Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTransportProducts", "outboundProducts", "Ldk/molslinjen/domain/model/booking/product/Product;", "returnProducts", "dateSelected", "date", "Lorg/threeten/bp/LocalDate;", "selectRoute", "site", "Ldk/molslinjen/domain/model/config/Site;", "route", "Ldk/molslinjen/domain/model/config/Route;", "routeDirection", "Ldk/molslinjen/domain/model/booking/RouteDirection;", "defaultTransportationId", "(Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/config/Route;Ldk/molslinjen/domain/model/booking/RouteDirection;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchaseCountPerCityId", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "updateDepartureDirection", "departureDirection", "outboundDepartureDate", "updateBookingType", "bookingType", "outboundSelectedDepartureDate", "reload", "setupForEdit", "booking", "Ldk/molslinjen/domain/model/booking/Booking;", "(Ldk/molslinjen/domain/model/booking/Booking;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupForMultiRide", "multiRideBookingData", "Ldk/molslinjen/domain/model/booking/MultiRideBookingData;", "(Ldk/molslinjen/domain/model/booking/MultiRideBookingData;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupForCommuter", "commuterBookingData", "Ldk/molslinjen/domain/model/booking/CommuterBookingData;", "(Ldk/molslinjen/domain/model/booking/CommuterBookingData;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IRouteManager {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object loadTransportProducts$default(IRouteManager iRouteManager, List list, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadTransportProducts");
            }
            if ((i5 & 1) != 0) {
                list = null;
            }
            return iRouteManager.loadTransportProducts((List<LineItem>) list, (Continuation<? super ManagerResult<Unit>>) continuation);
        }

        public static /* synthetic */ Object setTransportation$default(IRouteManager iRouteManager, String str, TransportationCargoInfo transportationCargoInfo, TransportationCargoInfo transportationCargoInfo2, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTransportation");
            }
            if ((i5 & 2) != 0) {
                transportationCargoInfo = null;
            }
            if ((i5 & 4) != 0) {
                transportationCargoInfo2 = null;
            }
            return iRouteManager.setTransportation(str, transportationCargoInfo, transportationCargoInfo2, continuation);
        }
    }

    void dateSelected(LocalDate date);

    Object flipDirection(Continuation<? super Unit> continuation);

    StateFlow<DepartureDirection> getActiveDepartureDirectionState();

    StateFlow<RouteSelectedState> getActiveSelectedState();

    StateFlow<BookingType> getBookingTypeState();

    StateFlow<RouteSelectedState> getOutboundSelectedState();

    StateFlow<RouteSelectedState> getReturnSelectedState();

    StateFlow<RouteState> getRouteState();

    StateFlow<RouteSharedSelectedState> getSharedSelectedState();

    TransportationSelectionModel getTransportationSelectionModel();

    Object loadTrailers(Continuation<? super ManagerResult<? extends List<TrailerProduct>>> continuation);

    Object loadTransportProducts(String str, Continuation<? super ManagerResult<Unit>> continuation);

    Object loadTransportProducts(List<LineItem> list, Continuation<? super ManagerResult<Unit>> continuation);

    List<Map.Entry<String, Integer>> purchaseCountPerCityId();

    void reload();

    void removeAllSelectedTransportProducts(boolean onlyActiveDirection);

    void removeSelectedTrailer(boolean onlyActiveDirection);

    Object selectRoute(Site site, Route route, RouteDirection routeDirection, String str, Continuation<? super Unit> continuation);

    void setTrailer(TrailerProduct outboundTrailer, TrailerProduct returnTrailer, boolean isAddingReturnFromBookingSummary);

    void setTransportProducts(List<? extends Product> outboundProducts, List<? extends Product> returnProducts, boolean isAddingReturnFromBookingSummary);

    Object setTransportation(Transportation transportation, Continuation<? super Unit> continuation);

    Object setTransportation(String str, TransportationCargoInfo transportationCargoInfo, TransportationCargoInfo transportationCargoInfo2, Continuation<? super Unit> continuation);

    Object setupForCommuter(CommuterBookingData commuterBookingData, Site site, Continuation<? super Unit> continuation);

    Object setupForEdit(Booking booking, Continuation<? super Unit> continuation);

    Object setupForMultiRide(MultiRideBookingData multiRideBookingData, Site site, Continuation<? super Unit> continuation);

    void updateBookingType(BookingType bookingType, LocalDate outboundSelectedDepartureDate);

    void updateDepartureDirection(DepartureDirection departureDirection, LocalDate outboundDepartureDate);

    Object updatePassengers(PassengerInfo passengerInfo, PassengerInfo passengerInfo2, boolean z5, Continuation<? super Unit> continuation);
}
