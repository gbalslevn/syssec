package dk.molslinjen.api.services.commuter.bornholm;

import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.commuter.bornholm.request.BornholmCommuterLoginRequestParameters;
import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterAgreementResponseDTO;
import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterBookingResponseDTO;
import dk.molslinjen.api.services.commuter.bornholm.response.BornholmCommuterLoginResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ.\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0003\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u000fJB\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000b0\u00032\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0012\u001a\u00020\u000e2\b\b\u0001\u0010\u0013\u001a\u00020\u000e2\b\b\u0003\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/api/services/commuter/bornholm/BornholmCommuterApi;", BuildConfig.FLAVOR, "loginBornholmCommuter", "Lretrofit2/Response;", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterLoginResponseDTO;", "requestParameters", "Ldk/molslinjen/api/services/commuter/bornholm/request/BornholmCommuterLoginRequestParameters;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(Ldk/molslinjen/api/services/commuter/bornholm/request/BornholmCommuterLoginRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBornholmCommuterAgreements", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterAgreementResponseDTO;", "commuterId", BuildConfig.FLAVOR, "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBornholmCommuterHistory", "Ldk/molslinjen/api/services/commuter/bornholm/response/BornholmCommuterBookingResponseDTO;", "commuteAgreementId", "textId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface BornholmCommuterApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getBornholmCommuterAgreements$default(BornholmCommuterApi bornholmCommuterApi, String str, SiteDTO siteDTO, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBornholmCommuterAgreements");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Bornholm;
            }
            return bornholmCommuterApi.getBornholmCommuterAgreements(str, siteDTO, continuation);
        }

        public static /* synthetic */ Object getBornholmCommuterHistory$default(BornholmCommuterApi bornholmCommuterApi, String str, String str2, String str3, SiteDTO siteDTO, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBornholmCommuterHistory");
            }
            if ((i5 & 8) != 0) {
                siteDTO = SiteDTO.Bornholm;
            }
            return bornholmCommuterApi.getBornholmCommuterHistory(str, str2, str3, siteDTO, continuation);
        }

        public static /* synthetic */ Object loginBornholmCommuter$default(BornholmCommuterApi bornholmCommuterApi, BornholmCommuterLoginRequestParameters bornholmCommuterLoginRequestParameters, SiteDTO siteDTO, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loginBornholmCommuter");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Bornholm;
            }
            return bornholmCommuterApi.loginBornholmCommuter(bornholmCommuterLoginRequestParameters, siteDTO, continuation);
        }
    }

    @GET("v1/commute/{commuterId}/agreements")
    @Retry
    Object getBornholmCommuterAgreements(@Path("commuterId") String str, @Header("Line") SiteDTO siteDTO, Continuation<? super Response<List<BornholmCommuterAgreementResponseDTO>>> continuation);

    @GET("v1/commute/{commuterId}/agreements/{commuteAgreementId}/history")
    @Retry
    Object getBornholmCommuterHistory(@Path("commuterId") String str, @Path("commuteAgreementId") String str2, @Query("textId") String str3, @Header("Line") SiteDTO siteDTO, Continuation<? super Response<List<BornholmCommuterBookingResponseDTO>>> continuation);

    @POST("v1/commute/app/login")
    @Retry
    Object loginBornholmCommuter(@Body BornholmCommuterLoginRequestParameters bornholmCommuterLoginRequestParameters, @Header("Line") SiteDTO siteDTO, Continuation<? super Response<BornholmCommuterLoginResponseDTO>> continuation);
}
