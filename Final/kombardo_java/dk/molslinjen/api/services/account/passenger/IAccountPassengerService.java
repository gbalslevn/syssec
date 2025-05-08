package dk.molslinjen.api.services.account.passenger;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.passenger.request.RegisterPassengerRequestParameter;
import dk.molslinjen.api.services.account.passenger.request.UpdatePassengerRequestParameter;
import dk.molslinjen.api.services.account.passenger.response.AccountPassengerDTO;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\fJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u000fJ$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/api/services/account/passenger/IAccountPassengerService;", BuildConfig.FLAVOR, "getPassengers", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/account/passenger/response/AccountPassengerDTO;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerPassenger", "requestParameters", "Ldk/molslinjen/api/services/account/passenger/request/RegisterPassengerRequestParameter;", "(Ldk/molslinjen/api/services/account/passenger/request/RegisterPassengerRequestParameter;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePassenger", "Ldk/molslinjen/api/services/account/passenger/request/UpdatePassengerRequestParameter;", "(Ldk/molslinjen/api/services/account/passenger/request/UpdatePassengerRequestParameter;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePassenger", BuildConfig.FLAVOR, "passengerId", BuildConfig.FLAVOR, "(Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAccountPassengerService {
    Object deletePassenger(String str, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<Unit>> continuation);

    Object getPassengers(AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<? extends List<AccountPassengerDTO>>> continuation);

    Object registerPassenger(RegisterPassengerRequestParameter registerPassengerRequestParameter, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AccountPassengerDTO>> continuation);

    Object updatePassenger(UpdatePassengerRequestParameter updatePassengerRequestParameter, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AccountPassengerDTO>> continuation);
}
