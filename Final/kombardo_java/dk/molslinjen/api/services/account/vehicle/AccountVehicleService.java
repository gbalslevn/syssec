package dk.molslinjen.api.services.account.vehicle;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0016J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\b2\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u001aJ,\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/account/vehicle/AccountVehicleService;", "Ldk/molslinjen/api/services/account/vehicle/IAccountVehicleService;", "Ldk/molslinjen/api/services/BaseService;", "api", "Ldk/molslinjen/api/services/account/vehicle/AccountVehiclesApi;", "<init>", "(Ldk/molslinjen/api/services/account/vehicle/AccountVehiclesApi;)V", "getVehicles", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/account/vehicle/response/VehiclesResponseDTO;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerVehicle", "Ldk/molslinjen/api/services/account/vehicle/response/VehicleDTO;", "name", BuildConfig.FLAVOR, "licensePlate", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateVehicle", "requestParameters", "Ldk/molslinjen/api/services/account/vehicle/request/UpdateVehicleRequestParameter;", "(Ldk/molslinjen/api/services/account/vehicle/request/UpdateVehicleRequestParameter;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteVehicle", BuildConfig.FLAVOR, "vehicleId", "(Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateVehicle", "Ldk/molslinjen/api/services/account/vehicle/response/VehicleValidationDTO;", "carId", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateLicensePlate", "Ldk/molslinjen/api/services/account/vehicle/response/VehicleLicensePlateValidationDTO;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AccountVehicleService extends BaseService implements IAccountVehicleService {
    private final AccountVehiclesApi api;

    public AccountVehicleService(AccountVehiclesApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.account.vehicle.IAccountVehicleService
    public Object deleteVehicle(String str, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountVehicleService$deleteVehicle$2(this, str, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.vehicle.IAccountVehicleService
    public Object getVehicles(AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<VehiclesResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountVehicleService$getVehicles$2(this, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.vehicle.IAccountVehicleService
    public Object registerVehicle(String str, String str2, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<VehicleDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountVehicleService$registerVehicle$2(str, str2, this, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.vehicle.IAccountVehicleService
    public Object updateVehicle(UpdateVehicleRequestParameter updateVehicleRequestParameter, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<VehicleDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountVehicleService$updateVehicle$2(this, updateVehicleRequestParameter, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.vehicle.IAccountVehicleService
    public Object validateLicensePlate(String str, Continuation<? super ApiResult<VehicleLicensePlateValidationDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountVehicleService$validateLicensePlate$2(this, str, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.vehicle.IAccountVehicleService
    public Object validateVehicle(String str, String str2, SiteDTO siteDTO, Continuation<? super ApiResult<VehicleValidationDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountVehicleService$validateVehicle$2(str, str2, this, siteDTO, null), continuation);
    }
}
