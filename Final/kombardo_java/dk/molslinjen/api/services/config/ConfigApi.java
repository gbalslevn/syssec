package dk.molslinjen.api.services.config;

import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.core.Environment;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/api/services/config/ConfigApi;", BuildConfig.FLAVOR, "getConfiguration", "Lretrofit2/Response;", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ConfigApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getConfiguration$default(ConfigApi configApi, SiteDTO siteDTO, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConfiguration");
            }
            if ((i5 & 1) != 0) {
                siteDTO = Environment.INSTANCE.isMolslinjen() ? SiteDTO.Mols : SiteDTO.Kombardo;
            }
            return configApi.getConfiguration(siteDTO, continuation);
        }
    }

    @GET("v2/config")
    @Retry
    Object getConfiguration(@Header("Line") SiteDTO siteDTO, Continuation<Response<ConfigurationResponseDTO>> continuation);
}
