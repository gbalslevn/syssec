package dk.molslinjen.api.services.account.brobizz;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.account.brobizz.response.BrobizzDTO;
import dk.molslinjen.api.services.account.brobizz.response.BrobizzResponseDTO;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/api/services/account/brobizz/AccountBrobizzService;", "Ldk/molslinjen/api/services/account/brobizz/IAccountBrobizzService;", "Ldk/molslinjen/api/services/BaseService;", "api", "Ldk/molslinjen/api/services/account/brobizz/AccountBrobizzApi;", "<init>", "(Ldk/molslinjen/api/services/account/brobizz/AccountBrobizzApi;)V", "getBrobizz", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/account/brobizz/response/BrobizzResponseDTO;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerBrobizz", "Ldk/molslinjen/api/services/account/brobizz/response/BrobizzDTO;", "brobizzNumber", BuildConfig.FLAVOR, "(Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeBrobizz", BuildConfig.FLAVOR, "brobizzId", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AccountBrobizzService extends BaseService implements IAccountBrobizzService {
    private final AccountBrobizzApi api;

    public AccountBrobizzService(AccountBrobizzApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.account.brobizz.IAccountBrobizzService
    public Object getBrobizz(AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<BrobizzResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountBrobizzService$getBrobizz$2(this, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.brobizz.IAccountBrobizzService
    public Object registerBrobizz(String str, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<BrobizzDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountBrobizzService$registerBrobizz$2(str, this, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.brobizz.IAccountBrobizzService
    public Object removeBrobizz(String str, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountBrobizzService$removeBrobizz$2(this, str, authTokenDTO, null), continuation);
    }
}
