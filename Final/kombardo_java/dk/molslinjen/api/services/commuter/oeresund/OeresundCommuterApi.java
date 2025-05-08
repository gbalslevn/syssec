package dk.molslinjen.api.services.commuter.oeresund;

import dk.molslinjen.api.services.commuter.oeresund.response.OeresundCommuterAgreementDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/api/services/commuter/oeresund/OeresundCommuterApi;", BuildConfig.FLAVOR, "getAgreements", "Lretrofit2/Response;", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/commuter/oeresund/response/OeresundCommuterAgreementDTO;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "authToken", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface OeresundCommuterApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getAgreements$default(OeresundCommuterApi oeresundCommuterApi, SiteDTO siteDTO, String str, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAgreements");
            }
            if ((i5 & 1) != 0) {
                siteDTO = SiteDTO.Oeresund;
            }
            return oeresundCommuterApi.getAgreements(siteDTO, str, continuation);
        }
    }

    @GET("v1/Commute/GetCommuteAgreements")
    Object getAgreements(@Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<List<OeresundCommuterAgreementDTO>>> continuation);
}
