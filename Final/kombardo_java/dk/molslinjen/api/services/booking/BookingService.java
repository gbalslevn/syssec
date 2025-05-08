package dk.molslinjen.api.services.booking;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.booking.request.BookRequestParameters;
import dk.molslinjen.api.services.booking.request.BookingsRequestParameters;
import dk.molslinjen.api.services.booking.request.DepartureRequestParameters;
import dk.molslinjen.api.services.booking.request.DirectionDTO;
import dk.molslinjen.api.services.booking.response.DeparturesResponseDTO;
import dk.molslinjen.api.services.booking.response.ProductsResponseDTO;
import dk.molslinjen.api.services.booking.response.SummaryProductsResponseDTO;
import dk.molslinjen.api.services.booking.response.TrailersResponseDTO;
import dk.molslinjen.api.services.booking.response.TransportProductsResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.BookingCompletedResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.BookingHeadersResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.BookingWrapperResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J.\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0002\u0010\u0010J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\b2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0014JJ\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\b2\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ`\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\b2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\f\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u000f2\b\u0010&\u001a\u0004\u0018\u00010\u000f2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010*Jb\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\b2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u00010\u000f2\b\u00101\u001a\u0004\u0018\u00010\u000f2\b\u00102\u001a\u0004\u0018\u00010$2\u0006\u00103\u001a\u00020(2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u00104J,\u00105\u001a\b\u0012\u0004\u0012\u0002060\b2\u0006\u0010%\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u00108J$\u00109\u001a\b\u0012\u0004\u0012\u00020:0\b2\u0006\u0010%\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010;J\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020:0\b2\u0006\u0010\n\u001a\u00020=H\u0096@¢\u0006\u0002\u0010>J\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020:0\b2\u0006\u0010\n\u001a\u00020=H\u0096@¢\u0006\u0002\u0010>J8\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\b2\u0006\u0010\n\u001a\u00020B2\u0006\u0010\f\u001a\u00020\r2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0002\u0010EJ,\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\b2\u0006\u0010%\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u00108R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Ldk/molslinjen/api/services/booking/BookingService;", "Ldk/molslinjen/api/services/booking/IBookingService;", "Ldk/molslinjen/api/services/BaseService;", "api", "Ldk/molslinjen/api/services/booking/BookingApi;", "<init>", "(Ldk/molslinjen/api/services/booking/BookingApi;)V", "getDepartures", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO;", "requestParameters", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "sessionKey", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrailers", "Ldk/molslinjen/api/services/booking/response/TrailersResponseDTO;", "transportId", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTransportProducts", "Ldk/molslinjen/api/services/booking/response/TransportProductsResponseDTO;", "routeDirectionId", "fromRegionId", "toRegionId", "currencyType", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProducts", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO;", "carId", "departureId", "direction", "Ldk/molslinjen/api/services/booking/request/DirectionDTO;", "passengerCount", BuildConfig.FLAVOR, "reservationNumber", "editPhoneNumber", "includeSummaryProducts", BuildConfig.FLAVOR, "currency", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/request/DirectionDTO;ILdk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Ljava/lang/String;ZLdk/molslinjen/api/shared/response/CurrencyTypeDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSummaryProducts", "Ldk/molslinjen/api/services/booking/response/SummaryProductsResponseDTO;", "outboundDepartureId", "outboundCarId", "outboundPassengerCount", "returnDepartureId", "returnCarId", "returnPassengerCount", "isEditingBooking", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLdk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBooking", "Ldk/molslinjen/api/services/booking/response/booking/BookingWrapperResponseDTO;", "phone", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookingHeadersIncludingReturn", "Ldk/molslinjen/api/services/booking/response/booking/BookingHeadersResponseDTO;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookingHeadersWithoutRetry", "Ldk/molslinjen/api/services/booking/request/BookingsRequestParameters;", "(Ldk/molslinjen/api/services/booking/request/BookingsRequestParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookingHeaders", "book", "Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ldk/molslinjen/api/services/booking/request/BookRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refund", BuildConfig.FLAVOR, "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BookingService extends BaseService implements IBookingService {
    private final BookingApi api;

    public BookingService(BookingApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.booking.IBookingService
    public Object book(BookRequestParameters bookRequestParameters, SiteDTO siteDTO, AuthTokenDTO authTokenDTO, String str, Continuation<? super ApiResult<BookingCompletedResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new BookingService$book$2(this, bookRequestParameters, siteDTO, authTokenDTO, str, null), continuation);
    }

    @Override // dk.molslinjen.api.services.booking.IBookingService
    public Object getBooking(String str, String str2, SiteDTO siteDTO, Continuation<? super ApiResult<BookingWrapperResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new BookingService$getBooking$2(this, str, str2, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.booking.IBookingService
    public Object getBookingHeaders(BookingsRequestParameters bookingsRequestParameters, Continuation<? super ApiResult<BookingHeadersResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new BookingService$getBookingHeaders$2(this, bookingsRequestParameters, null), continuation);
    }

    @Override // dk.molslinjen.api.services.booking.IBookingService
    public Object getBookingHeadersIncludingReturn(String str, String str2, Continuation<? super ApiResult<BookingHeadersResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new BookingService$getBookingHeadersIncludingReturn$2(this, str, str2, null), continuation);
    }

    @Override // dk.molslinjen.api.services.booking.IBookingService
    public Object getBookingHeadersWithoutRetry(BookingsRequestParameters bookingsRequestParameters, Continuation<? super ApiResult<BookingHeadersResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new BookingService$getBookingHeadersWithoutRetry$2(this, bookingsRequestParameters, null), continuation);
    }

    @Override // dk.molslinjen.api.services.booking.IBookingService
    public Object getDepartures(DepartureRequestParameters departureRequestParameters, SiteDTO siteDTO, String str, Continuation<? super ApiResult<DeparturesResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new BookingService$getDepartures$2(this, departureRequestParameters, siteDTO, str, null), continuation);
    }

    @Override // dk.molslinjen.api.services.booking.IBookingService
    public Object getProducts(String str, String str2, DirectionDTO directionDTO, int i5, SiteDTO siteDTO, String str3, String str4, boolean z5, CurrencyTypeDTO currencyTypeDTO, Continuation<? super ApiResult<ProductsResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new BookingService$getProducts$2(str, str2, directionDTO, i5, str3, str4, z5, currencyTypeDTO, this, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.booking.IBookingService
    public Object getSummaryProducts(String str, String str2, int i5, String str3, String str4, Integer num, boolean z5, SiteDTO siteDTO, CurrencyTypeDTO currencyTypeDTO, Continuation<? super ApiResult<SummaryProductsResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new BookingService$getSummaryProducts$2(this, str, str2, i5, str3, str4, num, z5, currencyTypeDTO, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.booking.IBookingService
    public Object getTrailers(String str, SiteDTO siteDTO, Continuation<? super ApiResult<TrailersResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new BookingService$getTrailers$2(this, str, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.booking.IBookingService
    public Object getTransportProducts(String str, String str2, String str3, String str4, SiteDTO siteDTO, CurrencyTypeDTO currencyTypeDTO, Continuation<? super ApiResult<TransportProductsResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new BookingService$getTransportProducts$2(this, str, str2, str3, str4, siteDTO, currencyTypeDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.booking.IBookingService
    public Object refund(String str, String str2, SiteDTO siteDTO, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new BookingService$refund$2(str, str2, this, siteDTO, null), continuation);
    }
}
