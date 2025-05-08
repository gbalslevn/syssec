package dk.molslinjen.api.services.commuter.oeresund;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.commuter.oeresund.response.OeresundCommuterAgreementDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/api/services/commuter/oeresund/OeresundCommuterService;", "Ldk/molslinjen/api/services/commuter/oeresund/IOeresundCommuterService;", "Ldk/molslinjen/api/services/BaseService;", "api", "Ldk/molslinjen/api/services/commuter/oeresund/OeresundCommuterApi;", "<init>", "(Ldk/molslinjen/api/services/commuter/oeresund/OeresundCommuterApi;)V", "getAgreements", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/commuter/oeresund/response/OeresundCommuterAgreementDTO;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OeresundCommuterService extends BaseService implements IOeresundCommuterService {
    private final OeresundCommuterApi api;

    public OeresundCommuterService(OeresundCommuterApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.commuter.oeresund.IOeresundCommuterService
    public Object getAgreements(AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<? extends List<OeresundCommuterAgreementDTO>>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new OeresundCommuterService$getAgreements$2(this, authTokenDTO, null), continuation);
    }
}
