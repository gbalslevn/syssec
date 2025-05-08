package dk.molslinjen.domain.managers.departure;

import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardRouteState;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.DayDepartures;
import dk.molslinjen.domain.model.booking.Departure;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJX\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H¦@¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/domain/managers/departure/IDepartureRequestHandler;", BuildConfig.FLAVOR, "getDepartures", "Ldk/molslinjen/domain/model/booking/DayDepartures;", "requestId", BuildConfig.FLAVOR, "sessionKey", "date", "Lorg/threeten/bp/LocalDate;", "state", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardRouteState;", "(Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardRouteState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldk/molslinjen/domain/managers/route/RouteSelectedState;", "sharedState", "Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;", "outboundTripDepartureForReturn", "Ldk/molslinjen/domain/model/booking/Departure;", "outboundTripRouteStateForReturn", "existingBooking", "Ldk/molslinjen/domain/model/booking/Booking;", "(Ljava/lang/String;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/domain/managers/route/RouteSelectedState;Ldk/molslinjen/domain/managers/route/RouteSharedSelectedState;Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/managers/route/RouteSelectedState;Ldk/molslinjen/domain/model/booking/Booking;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IDepartureRequestHandler {
    Object getDepartures(String str, String str2, LocalDate localDate, RouteSelectedState routeSelectedState, RouteSharedSelectedState routeSharedSelectedState, Departure departure, RouteSelectedState routeSelectedState2, Booking booking, Continuation<? super DayDepartures> continuation);

    Object getDepartures(String str, String str2, LocalDate localDate, SaleOnBoardRouteState saleOnBoardRouteState, Continuation<? super DayDepartures> continuation);
}
