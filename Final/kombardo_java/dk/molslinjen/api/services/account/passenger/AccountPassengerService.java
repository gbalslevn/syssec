package dk.molslinjen.api.services.account.passenger;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.account.passenger.request.RegisterPassengerRequestParameter;
import dk.molslinjen.api.services.account.passenger.request.UpdatePassengerRequestParameter;
import dk.molslinjen.api.services.account.passenger.response.AccountPassengerDTO;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000f\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0014J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/api/services/account/passenger/AccountPassengerService;", "Ldk/molslinjen/api/services/account/passenger/IAccountPassengerService;", "Ldk/molslinjen/api/services/BaseService;", "api", "Ldk/molslinjen/api/services/account/passenger/AccountPassengersApi;", "<init>", "(Ldk/molslinjen/api/services/account/passenger/AccountPassengersApi;)V", "getPassengers", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/account/passenger/response/AccountPassengerDTO;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerPassenger", "requestParameters", "Ldk/molslinjen/api/services/account/passenger/request/RegisterPassengerRequestParameter;", "(Ldk/molslinjen/api/services/account/passenger/request/RegisterPassengerRequestParameter;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePassenger", "Ldk/molslinjen/api/services/account/passenger/request/UpdatePassengerRequestParameter;", "(Ldk/molslinjen/api/services/account/passenger/request/UpdatePassengerRequestParameter;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePassenger", BuildConfig.FLAVOR, "passengerId", BuildConfig.FLAVOR, "(Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AccountPassengerService extends BaseService implements IAccountPassengerService {
    private final AccountPassengersApi api;

    public AccountPassengerService(AccountPassengersApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.account.passenger.IAccountPassengerService
    public Object deletePassenger(String str, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountPassengerService$deletePassenger$2(this, str, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.passenger.IAccountPassengerService
    public Object getPassengers(AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<? extends List<AccountPassengerDTO>>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountPassengerService$getPassengers$2(this, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.passenger.IAccountPassengerService
    public Object registerPassenger(RegisterPassengerRequestParameter registerPassengerRequestParameter, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AccountPassengerDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountPassengerService$registerPassenger$2(this, registerPassengerRequestParameter, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.passenger.IAccountPassengerService
    public Object updatePassenger(UpdatePassengerRequestParameter updatePassengerRequestParameter, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AccountPassengerDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountPassengerService$updatePassenger$2(this, updatePassengerRequestParameter, authTokenDTO, null), continuation);
    }
}
