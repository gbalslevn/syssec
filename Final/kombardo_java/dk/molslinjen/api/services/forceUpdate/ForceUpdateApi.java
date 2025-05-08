package dk.molslinjen.api.services.forceUpdate;

import dk.molslinjen.api.helpers.retry.RetryInfinity;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.forceUpdate.response.ForceUpdateDTO;
import dk.molslinjen.core.Environment;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Ldk/molslinjen/api/services/forceUpdate/ForceUpdateApi;", BuildConfig.FLAVOR, "getRequiredAppVersion", "Lretrofit2/Response;", "Ldk/molslinjen/api/services/forceUpdate/response/ForceUpdateDTO;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "source", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/services/config/response/SiteDTO;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ForceUpdateApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getRequiredAppVersion$default(ForceUpdateApi forceUpdateApi, SiteDTO siteDTO, int i5, Continuation continuation, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRequiredAppVersion");
            }
            if ((i6 & 1) != 0) {
                siteDTO = Environment.INSTANCE.isMolslinjen() ? SiteDTO.Mols : SiteDTO.Kombardo;
            }
            if ((i6 & 2) != 0) {
                i5 = 0;
            }
            return forceUpdateApi.getRequiredAppVersion(siteDTO, i5, continuation);
        }
    }

    @GET("v1/app/getForceUpdateInfo")
    @RetryInfinity
    Object getRequiredAppVersion(@Header("Line") SiteDTO siteDTO, @Query("AppSource") int i5, Continuation<Response<ForceUpdateDTO>> continuation);
}
