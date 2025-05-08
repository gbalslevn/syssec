package dk.molslinjen.api.services.booking;

import dk.molslinjen.api.helpers.ApiResult;
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
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0002\u0010\u000bJ$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u000fJJ\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H¦@¢\u0006\u0002\u0010\u0017Jd\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0016H¦@¢\u0006\u0002\u0010%Jh\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00032\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u001f2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001f2\u0006\u0010.\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0016H¦@¢\u0006\u0002\u0010/J,\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00032\u0006\u0010 \u001a\u00020\n2\u0006\u00102\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u00103J$\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00032\u0006\u0010 \u001a\u00020\n2\u0006\u00102\u001a\u00020\nH¦@¢\u0006\u0002\u00106J\u001c\u00107\u001a\b\u0012\u0004\u0012\u0002050\u00032\u0006\u0010\u0005\u001a\u000208H¦@¢\u0006\u0002\u00109J\u001c\u0010:\u001a\b\u0012\u0004\u0012\u0002050\u00032\u0006\u0010\u0005\u001a\u000208H¦@¢\u0006\u0002\u00109J8\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u00032\u0006\u0010\u0005\u001a\u00020=2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010\t\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0002\u0010@J,\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u00032\u0006\u0010 \u001a\u00020\n2\u0006\u00102\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u00103¨\u0006C"}, d2 = {"Ldk/molslinjen/api/services/booking/IBookingService;", BuildConfig.FLAVOR, "getDepartures", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO;", "requestParameters", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "sessionKey", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrailers", "Ldk/molslinjen/api/services/booking/response/TrailersResponseDTO;", "transportId", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTransportProducts", "Ldk/molslinjen/api/services/booking/response/TransportProductsResponseDTO;", "routeDirectionId", "fromRegionId", "toRegionId", "currencyType", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProducts", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO;", "carId", "departureId", "direction", "Ldk/molslinjen/api/services/booking/request/DirectionDTO;", "passengerCount", BuildConfig.FLAVOR, "reservationNumber", "editPhoneNumber", "includeSummaryProducts", BuildConfig.FLAVOR, "currency", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/request/DirectionDTO;ILdk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Ljava/lang/String;ZLdk/molslinjen/api/shared/response/CurrencyTypeDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSummaryProducts", "Ldk/molslinjen/api/services/booking/response/SummaryProductsResponseDTO;", "outboundDepartureId", "outboundCarId", "outboundPassengerCount", "returnDepartureId", "returnCarId", "returnPassengerCount", "isEditingBooking", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLdk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBooking", "Ldk/molslinjen/api/services/booking/response/booking/BookingWrapperResponseDTO;", "phone", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookingHeadersIncludingReturn", "Ldk/molslinjen/api/services/booking/response/booking/BookingHeadersResponseDTO;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookingHeadersWithoutRetry", "Ldk/molslinjen/api/services/booking/request/BookingsRequestParameters;", "(Ldk/molslinjen/api/services/booking/request/BookingsRequestParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookingHeaders", "book", "Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ldk/molslinjen/api/services/booking/request/BookRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refund", BuildConfig.FLAVOR, "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IBookingService {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getProducts$default(IBookingService iBookingService, String str, String str2, DirectionDTO directionDTO, int i5, SiteDTO siteDTO, String str3, String str4, boolean z5, CurrencyTypeDTO currencyTypeDTO, Continuation continuation, int i6, Object obj) {
            if (obj == null) {
                return iBookingService.getProducts(str, str2, directionDTO, i5, siteDTO, (i6 & 32) != 0 ? null : str3, (i6 & 64) != 0 ? null : str4, z5, currencyTypeDTO, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getProducts");
        }

        public static /* synthetic */ Object getSummaryProducts$default(IBookingService iBookingService, String str, String str2, int i5, String str3, String str4, Integer num, boolean z5, SiteDTO siteDTO, CurrencyTypeDTO currencyTypeDTO, Continuation continuation, int i6, Object obj) {
            if (obj == null) {
                return iBookingService.getSummaryProducts(str, str2, i5, (i6 & 8) != 0 ? null : str3, (i6 & 16) != 0 ? null : str4, (i6 & 32) != 0 ? null : num, z5, siteDTO, currencyTypeDTO, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSummaryProducts");
        }
    }

    Object book(BookRequestParameters bookRequestParameters, SiteDTO siteDTO, AuthTokenDTO authTokenDTO, String str, Continuation<? super ApiResult<BookingCompletedResponseDTO>> continuation);

    Object getBooking(String str, String str2, SiteDTO siteDTO, Continuation<? super ApiResult<BookingWrapperResponseDTO>> continuation);

    Object getBookingHeaders(BookingsRequestParameters bookingsRequestParameters, Continuation<? super ApiResult<BookingHeadersResponseDTO>> continuation);

    Object getBookingHeadersIncludingReturn(String str, String str2, Continuation<? super ApiResult<BookingHeadersResponseDTO>> continuation);

    Object getBookingHeadersWithoutRetry(BookingsRequestParameters bookingsRequestParameters, Continuation<? super ApiResult<BookingHeadersResponseDTO>> continuation);

    Object getDepartures(DepartureRequestParameters departureRequestParameters, SiteDTO siteDTO, String str, Continuation<? super ApiResult<DeparturesResponseDTO>> continuation);

    Object getProducts(String str, String str2, DirectionDTO directionDTO, int i5, SiteDTO siteDTO, String str3, String str4, boolean z5, CurrencyTypeDTO currencyTypeDTO, Continuation<? super ApiResult<ProductsResponseDTO>> continuation);

    Object getSummaryProducts(String str, String str2, int i5, String str3, String str4, Integer num, boolean z5, SiteDTO siteDTO, CurrencyTypeDTO currencyTypeDTO, Continuation<? super ApiResult<SummaryProductsResponseDTO>> continuation);

    Object getTrailers(String str, SiteDTO siteDTO, Continuation<? super ApiResult<TrailersResponseDTO>> continuation);

    Object getTransportProducts(String str, String str2, String str3, String str4, SiteDTO siteDTO, CurrencyTypeDTO currencyTypeDTO, Continuation<? super ApiResult<TransportProductsResponseDTO>> continuation);

    Object refund(String str, String str2, SiteDTO siteDTO, Continuation<? super ApiResult<Unit>> continuation);
}
