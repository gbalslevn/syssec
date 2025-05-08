package dk.molslinjen.api.services.account.vehicle;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.account.vehicle.request.UpdateVehicleRequestParameter;
import dk.molslinjen.api.services.account.vehicle.response.VehicleDTO;
import dk.molslinjen.api.services.account.vehicle.response.VehicleLicensePlateValidationDTO;
import dk.molslinjen.api.services.account.vehicle.response.VehicleValidationDTO;
import dk.molslinjen.api.services.account.vehicle.response.VehiclesResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\rJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0015J,\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH¦@¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\u0006\u0010\f\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u001e¨\u0006\u001f"}, d2 = {"Ldk/molslinjen/api/services/account/vehicle/IAccountVehicleService;", BuildConfig.FLAVOR, "getVehicles", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/account/vehicle/response/VehiclesResponseDTO;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerVehicle", "Ldk/molslinjen/api/services/account/vehicle/response/VehicleDTO;", "name", BuildConfig.FLAVOR, "licensePlate", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateVehicle", "requestParameters", "Ldk/molslinjen/api/services/account/vehicle/request/UpdateVehicleRequestParameter;", "(Ldk/molslinjen/api/services/account/vehicle/request/UpdateVehicleRequestParameter;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteVehicle", BuildConfig.FLAVOR, "vehicleId", "(Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateVehicle", "Ldk/molslinjen/api/services/account/vehicle/response/VehicleValidationDTO;", "carId", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateLicensePlate", "Ldk/molslinjen/api/services/account/vehicle/response/VehicleLicensePlateValidationDTO;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAccountVehicleService {
    Object deleteVehicle(String str, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<Unit>> continuation);

    Object getVehicles(AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<VehiclesResponseDTO>> continuation);

    Object registerVehicle(String str, String str2, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<VehicleDTO>> continuation);

    Object updateVehicle(UpdateVehicleRequestParameter updateVehicleRequestParameter, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<VehicleDTO>> continuation);

    Object validateLicensePlate(String str, Continuation<? super ApiResult<VehicleLicensePlateValidationDTO>> continuation);

    Object validateVehicle(String str, String str2, SiteDTO siteDTO, Continuation<? super ApiResult<VehicleValidationDTO>> continuation);
}
