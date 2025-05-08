package dk.molslinjen.api.services.account.vehicle;

import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.account.vehicle.request.RegisterVehicleRequestParameter;
import dk.molslinjen.api.services.account.vehicle.request.UpdateVehicleRequestParameter;
import dk.molslinjen.api.services.account.vehicle.request.ValidateVehicleRequestParameter;
import dk.molslinjen.api.services.account.vehicle.response.VehicleDTO;
import dk.molslinjen.api.services.account.vehicle.response.VehicleLicensePlateValidationDTO;
import dk.molslinjen.api.services.account.vehicle.response.VehicleValidationDTO;
import dk.molslinjen.api.services.account.vehicle.response.VehiclesResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
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

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ2\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u000eJ2\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\u00102\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u0011J2\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0014\u001a\u00020\b2\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u0015J(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\f\u001a\u00020\u00182\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0019J(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\b\b\u0001\u0010\u001c\u001a\u00020\b2\b\b\u0003\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/api/services/account/vehicle/AccountVehiclesApi;", BuildConfig.FLAVOR, "getVehicles", "Lretrofit2/Response;", "Ldk/molslinjen/api/services/account/vehicle/response/VehiclesResponseDTO;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "authToken", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerVehicle", "Ldk/molslinjen/api/services/account/vehicle/response/VehicleDTO;", "requestParameters", "Ldk/molslinjen/api/services/account/vehicle/request/RegisterVehicleRequestParameter;", "(Ldk/molslinjen/api/services/account/vehicle/request/RegisterVehicleRequestParameter;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateVehicle", "Ldk/molslinjen/api/services/account/vehicle/request/UpdateVehicleRequestParameter;", "(Ldk/molslinjen/api/services/account/vehicle/request/UpdateVehicleRequestParameter;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteVehicle", BuildConfig.FLAVOR, "vehicleId", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateVehicle", "Ldk/molslinjen/api/services/account/vehicle/response/VehicleValidationDTO;", "Ldk/molslinjen/api/services/account/vehicle/request/ValidateVehicleRequestParameter;", "(Ldk/molslinjen/api/services/account/vehicle/request/ValidateVehicleRequestParameter;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateLicensePlate", "Ldk/molslinjen/api/services/account/vehicle/response/VehicleLicensePlateValidationDTO;", "licensePlate", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AccountVehiclesApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object deleteVehicle$default(AccountVehiclesApi accountVehiclesApi, String str, SiteDTO siteDTO, String str2, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteVehicle");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountVehiclesApi.deleteVehicle(str, siteDTO, str2, continuation);
        }

        public static /* synthetic */ Object getVehicles$default(AccountVehiclesApi accountVehiclesApi, SiteDTO siteDTO, String str, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVehicles");
            }
            if ((i5 & 1) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountVehiclesApi.getVehicles(siteDTO, str, continuation);
        }

        public static /* synthetic */ Object registerVehicle$default(AccountVehiclesApi accountVehiclesApi, RegisterVehicleRequestParameter registerVehicleRequestParameter, SiteDTO siteDTO, String str, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerVehicle");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountVehiclesApi.registerVehicle(registerVehicleRequestParameter, siteDTO, str, continuation);
        }

        public static /* synthetic */ Object updateVehicle$default(AccountVehiclesApi accountVehiclesApi, UpdateVehicleRequestParameter updateVehicleRequestParameter, SiteDTO siteDTO, String str, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateVehicle");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountVehiclesApi.updateVehicle(updateVehicleRequestParameter, siteDTO, str, continuation);
        }

        public static /* synthetic */ Object validateLicensePlate$default(AccountVehiclesApi accountVehiclesApi, String str, SiteDTO siteDTO, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validateLicensePlate");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountVehiclesApi.validateLicensePlate(str, siteDTO, continuation);
        }
    }

    @DELETE("v1/accounts/assets/vehicles/{vehicleId}")
    @Retry
    Object deleteVehicle(@Path("vehicleId") String str, @Header("Line") SiteDTO siteDTO, @Header("token") String str2, Continuation<? super Response<Unit>> continuation);

    @GET("v1/accounts/assets/vehicles")
    @Retry
    Object getVehicles(@Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<VehiclesResponseDTO>> continuation);

    @POST("v1/accounts/assets/vehicles")
    @Retry
    Object registerVehicle(@Body RegisterVehicleRequestParameter registerVehicleRequestParameter, @Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<VehicleDTO>> continuation);

    @PUT("v1/accounts/assets/vehicles")
    @Retry
    Object updateVehicle(@Body UpdateVehicleRequestParameter updateVehicleRequestParameter, @Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<VehicleDTO>> continuation);

    @GET("v1/accounts/assets/vehicles/validation/licensePlate/{licensePlate}")
    Object validateLicensePlate(@Path("licensePlate") String str, @Header("Line") SiteDTO siteDTO, Continuation<? super Response<VehicleLicensePlateValidationDTO>> continuation);

    @POST("v1/accounts/assets/vehicles/validation/licensePlateToTransportId")
    Object validateVehicle(@Body ValidateVehicleRequestParameter validateVehicleRequestParameter, @Header("Line") SiteDTO siteDTO, Continuation<? super Response<VehicleValidationDTO>> continuation);
}
