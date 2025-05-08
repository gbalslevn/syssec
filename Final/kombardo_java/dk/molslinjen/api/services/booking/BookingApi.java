package dk.molslinjen.api.services.booking;

import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.booking.request.BookRequestParameters;
import dk.molslinjen.api.services.booking.request.BookingsRequestParameters;
import dk.molslinjen.api.services.booking.request.DepartureRequestParameters;
import dk.molslinjen.api.services.booking.request.ProductsRequestParameters;
import dk.molslinjen.api.services.booking.request.RefundRequestParameters;
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
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\nH§@¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u000fJV\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u000e\u001a\u00020\n2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0015\u001a\u00020\u0016H§@¢\u0006\u0002\u0010\u0017J(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001a2\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u001bJt\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u001e\u001a\u00020\n2\b\b\u0001\u0010\u001f\u001a\u00020\n2\b\b\u0001\u0010 \u001a\u00020!2\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010$\u001a\u0004\u0018\u00010!2\b\b\u0001\u0010%\u001a\u00020&2\b\b\u0001\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010'J2\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00032\b\b\u0001\u0010*\u001a\u00020\n2\b\b\u0001\u0010+\u001a\u00020\n2\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010,J<\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00032\b\b\u0001\u0010*\u001a\u00020\n2\b\b\u0001\u0010+\u001a\u00020\n2\b\b\u0003\u0010/\u001a\u00020&2\b\b\u0003\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u00100J(\u00101\u001a\b\u0012\u0004\u0012\u00020.0\u00032\b\b\u0001\u0010\u0005\u001a\u0002022\b\b\u0003\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u00103J(\u00104\u001a\b\u0012\u0004\u0012\u00020.0\u00032\b\b\u0001\u0010\u0005\u001a\u0002022\b\b\u0003\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u00103J@\u00105\u001a\b\u0012\u0004\u0012\u0002060\u00032\b\b\u0001\u0010\u0005\u001a\u0002072\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u00108\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\nH§@¢\u0006\u0002\u00109J(\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00032\b\b\u0001\u0010\u0005\u001a\u00020<2\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010=¨\u0006>"}, d2 = {"Ldk/molslinjen/api/services/booking/BookingApi;", BuildConfig.FLAVOR, "getDepartures", "Lretrofit2/Response;", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO;", "requestParameters", "Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "sessionKey", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/services/booking/request/DepartureRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrailers", "Ldk/molslinjen/api/services/booking/response/TrailersResponseDTO;", "transportId", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTransportProducts", "Ldk/molslinjen/api/services/booking/response/TransportProductsResponseDTO;", "routeId", "fromRegionId", "toRegionId", "currency", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProducts", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO;", "Ldk/molslinjen/api/services/booking/request/ProductsRequestParameters;", "(Ldk/molslinjen/api/services/booking/request/ProductsRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSummaryProducts", "Ldk/molslinjen/api/services/booking/response/SummaryProductsResponseDTO;", "outboundDepartureId", "outboundCarId", "outboundPassengerCount", BuildConfig.FLAVOR, "returnDepartureId", "returnCarId", "returnPassengerCount", "isEditingBooking", BuildConfig.FLAVOR, "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLdk/molslinjen/api/shared/response/CurrencyTypeDTO;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBooking", "Ldk/molslinjen/api/services/booking/response/booking/BookingWrapperResponseDTO;", "reservationNumber", "phone", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookingHeadersIncludingReturn", "Ldk/molslinjen/api/services/booking/response/booking/BookingHeadersResponseDTO;", "includeLinkedReservations", "(Ljava/lang/String;Ljava/lang/String;ZLdk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookingHeadersWithoutRetry", "Ldk/molslinjen/api/services/booking/request/BookingsRequestParameters;", "(Ldk/molslinjen/api/services/booking/request/BookingsRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookingHeaders", "book", "Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO;", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters;", "authToken", "(Ldk/molslinjen/api/services/booking/request/BookRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refund", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/booking/request/RefundRequestParameters;", "(Ldk/molslinjen/api/services/booking/request/RefundRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface BookingApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getBookingHeaders$default(BookingApi bookingApi, BookingsRequestParameters bookingsRequestParameters, SiteDTO siteDTO, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBookingHeaders");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return bookingApi.getBookingHeaders(bookingsRequestParameters, siteDTO, continuation);
        }

        public static /* synthetic */ Object getBookingHeadersIncludingReturn$default(BookingApi bookingApi, String str, String str2, boolean z5, SiteDTO siteDTO, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBookingHeadersIncludingReturn");
            }
            if ((i5 & 4) != 0) {
                z5 = true;
            }
            boolean z6 = z5;
            if ((i5 & 8) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return bookingApi.getBookingHeadersIncludingReturn(str, str2, z6, siteDTO, continuation);
        }

        public static /* synthetic */ Object getBookingHeadersWithoutRetry$default(BookingApi bookingApi, BookingsRequestParameters bookingsRequestParameters, SiteDTO siteDTO, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBookingHeadersWithoutRetry");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return bookingApi.getBookingHeadersWithoutRetry(bookingsRequestParameters, siteDTO, continuation);
        }
    }

    @POST("v1/booking/steps/summary/app/book")
    @Retry
    Object book(@Body BookRequestParameters bookRequestParameters, @Header("Line") SiteDTO siteDTO, @Header("token") String str, @Header("sessionKey") String str2, Continuation<Response<BookingCompletedResponseDTO>> continuation);

    @GET("v1/app/booking")
    @Retry
    Object getBooking(@Query("reservationId") String str, @Query("phone") String str2, @Header("Line") SiteDTO siteDTO, Continuation<Response<BookingWrapperResponseDTO>> continuation);

    @POST("v1/app/booking/simplified")
    @Retry
    Object getBookingHeaders(@Body BookingsRequestParameters bookingsRequestParameters, @Header("Line") SiteDTO siteDTO, Continuation<Response<BookingHeadersResponseDTO>> continuation);

    @GET("v1/app/booking/simplified")
    Object getBookingHeadersIncludingReturn(@Query("reservationId") String str, @Query("phone") String str2, @Query("includeLinkedReservations") boolean z5, @Header("Line") SiteDTO siteDTO, Continuation<Response<BookingHeadersResponseDTO>> continuation);

    @POST("v1/app/booking/simplified")
    Object getBookingHeadersWithoutRetry(@Body BookingsRequestParameters bookingsRequestParameters, @Header("Line") SiteDTO siteDTO, Continuation<Response<BookingHeadersResponseDTO>> continuation);

    @POST("v1/booking/steps/departure/app/departures")
    @Retry
    Object getDepartures(@Body DepartureRequestParameters departureRequestParameters, @Header("Line") SiteDTO siteDTO, @Header("sessionKey") String str, Continuation<Response<DeparturesResponseDTO>> continuation);

    @POST("v1/booking/steps/optional/app/productGroups")
    @Retry
    Object getProducts(@Body ProductsRequestParameters productsRequestParameters, @Header("Line") SiteDTO siteDTO, Continuation<Response<ProductsResponseDTO>> continuation);

    @GET("v1/booking/steps/summary/products")
    @Retry
    Object getSummaryProducts(@Query("request.outboundDepartureId") String str, @Query("request.outboundCarId") String str2, @Query("request.outboundPassengerCount") int i5, @Query("request.returnDepartureId") String str3, @Query("request.returnCarId") String str4, @Query("request.returnPassengerCount") Integer num, @Query("request.isEditingBooking") boolean z5, @Query("request.currency") CurrencyTypeDTO currencyTypeDTO, @Header("Line") SiteDTO siteDTO, Continuation<Response<SummaryProductsResponseDTO>> continuation);

    @GET("v1/booking/steps/details/trailers")
    @Retry
    Object getTrailers(@Query("transportId") String str, @Header("Line") SiteDTO siteDTO, Continuation<Response<TrailersResponseDTO>> continuation);

    @GET("v1/booking/steps/details/app/transportProducts")
    @Retry
    Object getTransportProducts(@Query("transportId") String str, @Query("routeId") String str2, @Query("fromRegionId") String str3, @Query("toRegionId") String str4, @Header("Line") SiteDTO siteDTO, @Query("currency") CurrencyTypeDTO currencyTypeDTO, Continuation<Response<TransportProductsResponseDTO>> continuation);

    @POST("v1/booking/refund")
    Object refund(@Body RefundRequestParameters refundRequestParameters, @Header("Line") SiteDTO siteDTO, Continuation<Response<Unit>> continuation);
}
