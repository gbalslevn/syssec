package dk.molslinjen.api.services.info;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.info.response.InfoAlertsResponseDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/api/services/info/IInfoService;", BuildConfig.FLAVOR, "getInformationAlerts", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/info/response/InfoAlertsResponseDTO;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IInfoService {
    Object getInformationAlerts(Continuation<? super ApiResult<InfoAlertsResponseDTO>> continuation);
}
