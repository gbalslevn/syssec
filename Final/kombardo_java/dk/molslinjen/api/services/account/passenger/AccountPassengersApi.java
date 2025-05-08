package dk.molslinjen.api.services.account.passenger;

import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.account.passenger.request.RegisterPassengerRequestParameter;
import dk.molslinjen.api.services.account.passenger.request.UpdatePassengerRequestParameter;
import dk.molslinjen.api.services.account.passenger.response.AccountPassengerDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ2\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\u000eJ2\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\f\u001a\u00020\u00102\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0011J2\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0014\u001a\u00020\t2\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/api/services/account/passenger/AccountPassengersApi;", BuildConfig.FLAVOR, "getPassengers", "Lretrofit2/Response;", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/account/passenger/response/AccountPassengerDTO;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "authToken", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerPassenger", "requestParameters", "Ldk/molslinjen/api/services/account/passenger/request/RegisterPassengerRequestParameter;", "(Ldk/molslinjen/api/services/account/passenger/request/RegisterPassengerRequestParameter;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePassenger", "Ldk/molslinjen/api/services/account/passenger/request/UpdatePassengerRequestParameter;", "(Ldk/molslinjen/api/services/account/passenger/request/UpdatePassengerRequestParameter;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePassenger", BuildConfig.FLAVOR, "passengerId", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AccountPassengersApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object deletePassenger$default(AccountPassengersApi accountPassengersApi, String str, SiteDTO siteDTO, String str2, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deletePassenger");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountPassengersApi.deletePassenger(str, siteDTO, str2, continuation);
        }

        public static /* synthetic */ Object getPassengers$default(AccountPassengersApi accountPassengersApi, SiteDTO siteDTO, String str, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPassengers");
            }
            if ((i5 & 1) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountPassengersApi.getPassengers(siteDTO, str, continuation);
        }

        public static /* synthetic */ Object registerPassenger$default(AccountPassengersApi accountPassengersApi, RegisterPassengerRequestParameter registerPassengerRequestParameter, SiteDTO siteDTO, String str, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerPassenger");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountPassengersApi.registerPassenger(registerPassengerRequestParameter, siteDTO, str, continuation);
        }

        public static /* synthetic */ Object updatePassenger$default(AccountPassengersApi accountPassengersApi, UpdatePassengerRequestParameter updatePassengerRequestParameter, SiteDTO siteDTO, String str, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updatePassenger");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountPassengersApi.updatePassenger(updatePassengerRequestParameter, siteDTO, str, continuation);
        }
    }

    @DELETE("v1/accounts/assets/passengers/{passengerId}")
    @Retry
    Object deletePassenger(@Path("passengerId") String str, @Header("Line") SiteDTO siteDTO, @Header("token") String str2, Continuation<? super Response<Unit>> continuation);

    @GET("v1/accounts/assets/passengers")
    @Retry
    Object getPassengers(@Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<List<AccountPassengerDTO>>> continuation);

    @POST("v1/accounts/assets/passengers")
    @Retry
    Object registerPassenger(@Body RegisterPassengerRequestParameter registerPassengerRequestParameter, @Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<AccountPassengerDTO>> continuation);

    @PUT("v1/accounts/assets/passengers")
    @Retry
    Object updatePassenger(@Body UpdatePassengerRequestParameter updatePassengerRequestParameter, @Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<AccountPassengerDTO>> continuation);
}
