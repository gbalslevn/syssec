package dk.molslinjen.api.services.config;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/api/services/config/IConfigService;", BuildConfig.FLAVOR, "getConfiguration", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IConfigService {
    Object getConfiguration(Continuation<? super ApiResult<ConfigurationResponseDTO>> continuation);
}
