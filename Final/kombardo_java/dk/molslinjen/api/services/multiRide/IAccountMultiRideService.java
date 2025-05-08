package dk.molslinjen.api.services.multiRide;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.multiRide.response.AccountMultiRidesResponseDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/api/services/multiRide/IAccountMultiRideService;", BuildConfig.FLAVOR, "linkExistingMultiRide", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "multiRideAgreementId", BuildConfig.FLAVOR, "email", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMultiRides", "Ldk/molslinjen/api/services/multiRide/response/AccountMultiRidesResponseDTO;", "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAccountMultiRideService {
    Object getMultiRides(SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<AccountMultiRidesResponseDTO>> continuation);

    Object linkExistingMultiRide(String str, String str2, SiteDTO siteDTO, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<Unit>> continuation);
}
