package dk.molslinjen.api.services.account.brobizz;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.brobizz.response.BrobizzDTO;
import dk.molslinjen.api.services.account.brobizz.response.BrobizzResponseDTO;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\fJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\f¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/api/services/account/brobizz/IAccountBrobizzService;", BuildConfig.FLAVOR, "getBrobizz", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/account/brobizz/response/BrobizzResponseDTO;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerBrobizz", "Ldk/molslinjen/api/services/account/brobizz/response/BrobizzDTO;", "brobizzNumber", BuildConfig.FLAVOR, "(Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeBrobizz", BuildConfig.FLAVOR, "brobizzId", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAccountBrobizzService {
    Object getBrobizz(AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<BrobizzResponseDTO>> continuation);

    Object registerBrobizz(String str, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<BrobizzDTO>> continuation);

    Object removeBrobizz(String str, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<Unit>> continuation);
}
