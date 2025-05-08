package dk.molslinjen.api.services.multiRide;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.multiRide.response.AccountMultiRidesResponseDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J4\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/api/services/multiRide/AccountMultiRideService;", "Ldk/molslinjen/api/services/multiRide/IAccountMultiRideService;", "Ldk/molslinjen/api/services/BaseService;", "api", "Ldk/molslinjen/api/services/multiRide/AccountMultiRideApi;", "<init>", "(Ldk/molslinjen/api/services/multiRide/AccountMultiRideApi;)V", "linkExistingMultiRide", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "multiRideAgreementId", BuildConfig.FLAVOR, "email", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMultiRides", "Ldk/molslinjen/api/services/multiRide/response/AccountMultiRidesResponseDTO;", "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AccountMultiRideService extends BaseService implements IAccountMultiRideService {
    private final AccountMultiRideApi api;

    public AccountMultiRideService(AccountMultiRideApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.multiRide.IAccountMultiRideService
    public Object getMultiRides(SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AccountMultiRidesResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountMultiRideService$getMultiRides$2(this, siteDTO, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.multiRide.IAccountMultiRideService
    public Object linkExistingMultiRide(String str, String str2, SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountMultiRideService$linkExistingMultiRide$2(str, str2, this, siteDTO, authTokenDTO, null), continuation);
    }
}
