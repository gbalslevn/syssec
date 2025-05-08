package dk.molslinjen.api.services.config;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/api/services/config/ConfigService;", "Ldk/molslinjen/api/services/config/IConfigService;", "Ldk/molslinjen/api/services/BaseService;", "api", "Ldk/molslinjen/api/services/config/ConfigApi;", "<init>", "(Ldk/molslinjen/api/services/config/ConfigApi;)V", "getConfiguration", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConfigService extends BaseService implements IConfigService {
    private final ConfigApi api;

    public ConfigService(ConfigApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.config.IConfigService
    public Object getConfiguration(Continuation<? super ApiResult<ConfigurationResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new ConfigService$getConfiguration$2(this, null), continuation);
    }
}
