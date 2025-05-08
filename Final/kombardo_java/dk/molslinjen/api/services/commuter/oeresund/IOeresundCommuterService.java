package dk.molslinjen.api.services.commuter.oeresund;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.commuter.oeresund.response.OeresundCommuterAgreementDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/api/services/commuter/oeresund/IOeresundCommuterService;", BuildConfig.FLAVOR, "getAgreements", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/commuter/oeresund/response/OeresundCommuterAgreementDTO;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IOeresundCommuterService {
    Object getAgreements(AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<? extends List<OeresundCommuterAgreementDTO>>> continuation);
}
