package dk.molslinjen.api.services.account.creditcard;

import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.account.creditcard.request.RegisterCreditCardRequestParameter;
import dk.molslinjen.api.services.account.creditcard.response.CreditCardDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import java.util.List;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ2\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\t2\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\u000eJ2\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u00112\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/api/services/account/creditcard/AccountCreditCardsApi;", BuildConfig.FLAVOR, "getCreditCards", "Lretrofit2/Response;", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/account/creditcard/response/CreditCardDTO;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "authToken", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCreditCard", BuildConfig.FLAVOR, "cardId", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerCreditCard", "requestParameters", "Ldk/molslinjen/api/services/account/creditcard/request/RegisterCreditCardRequestParameter;", "(Ldk/molslinjen/api/services/account/creditcard/request/RegisterCreditCardRequestParameter;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AccountCreditCardsApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object deleteCreditCard$default(AccountCreditCardsApi accountCreditCardsApi, String str, SiteDTO siteDTO, String str2, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteCreditCard");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountCreditCardsApi.deleteCreditCard(str, siteDTO, str2, continuation);
        }

        public static /* synthetic */ Object getCreditCards$default(AccountCreditCardsApi accountCreditCardsApi, SiteDTO siteDTO, String str, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCreditCards");
            }
            if ((i5 & 1) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountCreditCardsApi.getCreditCards(siteDTO, str, continuation);
        }

        public static /* synthetic */ Object registerCreditCard$default(AccountCreditCardsApi accountCreditCardsApi, RegisterCreditCardRequestParameter registerCreditCardRequestParameter, SiteDTO siteDTO, String str, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerCreditCard");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return accountCreditCardsApi.registerCreditCard(registerCreditCardRequestParameter, siteDTO, str, continuation);
        }
    }

    @DELETE("v1/accounts/assets/creditCards/{cardId}")
    @Retry
    Object deleteCreditCard(@Path("cardId") String str, @Header("Line") SiteDTO siteDTO, @Header("token") String str2, Continuation<? super Response<Unit>> continuation);

    @GET("v1/accounts/assets/creditCards")
    @Retry
    Object getCreditCards(@Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<List<CreditCardDTO>>> continuation);

    @POST("v1/accounts/assets/creditCards")
    @Retry
    Object registerCreditCard(@Body RegisterCreditCardRequestParameter registerCreditCardRequestParameter, @Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<Unit>> continuation);
}
