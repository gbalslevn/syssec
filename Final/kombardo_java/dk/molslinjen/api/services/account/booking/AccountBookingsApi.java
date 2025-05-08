package dk.molslinjen.api.services.account.booking;

import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.account.booking.request.AddExistingBookingRequestParameters;
import dk.molslinjen.api.services.account.booking.response.AccountBookingHeadersResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import okhttp3.ResponseBody;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J^\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0003\u0010\u000f\u001a\u00020\u0010H§@¢\u0006\u0002\u0010\u0011J2\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00152\b\b\u0003\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u0016J<\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u000e2\b\b\u0001\u0010\u001a\u001a\u00020\u000e2\b\b\u0003\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u001b¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/api/services/account/booking/AccountBookingsApi;", BuildConfig.FLAVOR, "getBookings", "Lretrofit2/Response;", "Ldk/molslinjen/api/services/account/booking/response/AccountBookingHeadersResponseDTO;", "active", BuildConfig.FLAVOR, "take", BuildConfig.FLAVOR, "skip", "startDate", "Lorg/threeten/bp/LocalDate;", "endDate", "authToken", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(ZIILorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addExistingBooking", BuildConfig.FLAVOR, "requestParameters", "Ldk/molslinjen/api/services/account/booking/request/AddExistingBookingRequestParameters;", "(Ldk/molslinjen/api/services/account/booking/request/AddExistingBookingRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadReceiptPdf", "Lokhttp3/ResponseBody;", "reservationId", "phone", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AccountBookingsApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object addExistingBooking$default(AccountBookingsApi accountBookingsApi, AddExistingBookingRequestParameters addExistingBookingRequestParameters, SiteDTO siteDTO, String str, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addExistingBooking");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountBookingsApi.addExistingBooking(addExistingBookingRequestParameters, siteDTO, str, continuation);
        }

        public static /* synthetic */ Object downloadReceiptPdf$default(AccountBookingsApi accountBookingsApi, String str, String str2, SiteDTO siteDTO, String str3, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadReceiptPdf");
            }
            if ((i5 & 4) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountBookingsApi.downloadReceiptPdf(str, str2, siteDTO, str3, continuation);
        }

        public static /* synthetic */ Object getBookings$default(AccountBookingsApi accountBookingsApi, boolean z5, int i5, int i6, LocalDate localDate, LocalDate localDate2, String str, SiteDTO siteDTO, Continuation continuation, int i7, Object obj) {
            if (obj == null) {
                return accountBookingsApi.getBookings(z5, i5, i6, localDate, localDate2, str, (i7 & 64) != 0 ? SiteDTO.Mols : siteDTO, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBookings");
        }
    }

    @POST("v1/accounts/purchases/orders/link")
    Object addExistingBooking(@Body AddExistingBookingRequestParameters addExistingBookingRequestParameters, @Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<Unit>> continuation);

    @Streaming
    @GET("v1/accounts/purchases/orders/pdf")
    @Retry
    Object downloadReceiptPdf(@Query("reservationId") String str, @Query("phone") String str2, @Header("Line") SiteDTO siteDTO, @Header("token") String str3, Continuation<? super Response<ResponseBody>> continuation);

    @GET("v1/accounts/purchases/orders/simplifiedOrders")
    @Retry
    Object getBookings(@Query("activeOrders") boolean z5, @Query("take") int i5, @Query("skip") int i6, @Query("startDate") LocalDate localDate, @Query("endDate") LocalDate localDate2, @Header("token") String str, @Header("Line") SiteDTO siteDTO, Continuation<? super Response<AccountBookingHeadersResponseDTO>> continuation);
}
