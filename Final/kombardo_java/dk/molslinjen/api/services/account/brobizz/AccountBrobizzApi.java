package dk.molslinjen.api.services.account.brobizz;

import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.account.brobizz.request.RegisterBrobizzRequestParameter;
import dk.molslinjen.api.services.account.brobizz.response.BrobizzDTO;
import dk.molslinjen.api.services.account.brobizz.response.BrobizzResponseDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ2\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u000eJ2\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0011\u001a\u00020\b2\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/api/services/account/brobizz/AccountBrobizzApi;", BuildConfig.FLAVOR, "getBrobizz", "Lretrofit2/Response;", "Ldk/molslinjen/api/services/account/brobizz/response/BrobizzResponseDTO;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "authToken", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addBrobizz", "Ldk/molslinjen/api/services/account/brobizz/response/BrobizzDTO;", "requestParameters", "Ldk/molslinjen/api/services/account/brobizz/request/RegisterBrobizzRequestParameter;", "(Ldk/molslinjen/api/services/account/brobizz/request/RegisterBrobizzRequestParameter;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBrobizz", BuildConfig.FLAVOR, "brobizzId", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AccountBrobizzApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object addBrobizz$default(AccountBrobizzApi accountBrobizzApi, RegisterBrobizzRequestParameter registerBrobizzRequestParameter, SiteDTO siteDTO, String str, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addBrobizz");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountBrobizzApi.addBrobizz(registerBrobizzRequestParameter, siteDTO, str, continuation);
        }

        public static /* synthetic */ Object deleteBrobizz$default(AccountBrobizzApi accountBrobizzApi, String str, SiteDTO siteDTO, String str2, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteBrobizz");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountBrobizzApi.deleteBrobizz(str, siteDTO, str2, continuation);
        }

        public static /* synthetic */ Object getBrobizz$default(AccountBrobizzApi accountBrobizzApi, SiteDTO siteDTO, String str, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBrobizz");
            }
            if ((i5 & 1) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountBrobizzApi.getBrobizz(siteDTO, str, continuation);
        }
    }

    @POST("v1/accounts/assets/brobizzes")
    @Retry
    Object addBrobizz(@Body RegisterBrobizzRequestParameter registerBrobizzRequestParameter, @Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<BrobizzDTO>> continuation);

    @DELETE("v1/accounts/assets/brobizzes/{brobizzId}")
    @Retry
    Object deleteBrobizz(@Path("brobizzId") String str, @Header("Line") SiteDTO siteDTO, @Header("token") String str2, Continuation<? super Response<Unit>> continuation);

    @GET("v1/accounts/assets/brobizzes")
    @Retry
    Object getBrobizz(@Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<BrobizzResponseDTO>> continuation);
}
