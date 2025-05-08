package dk.molslinjen.api.services.account.creditcard;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.creditcard.response.CreditCardDTO;
import dk.molslinjen.api.services.account.creditcard.response.CreditCardTypeDTO;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\rJD\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/api/services/account/creditcard/IAccountCreditCardsService;", BuildConfig.FLAVOR, "getCards", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/account/creditcard/response/CreditCardDTO;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCard", BuildConfig.FLAVOR, "cardId", BuildConfig.FLAVOR, "(Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerCard", "maskedNumber", "cardType", "Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTO;", "expirationMonth", "expirationYear", "creditCardToken", "(Ljava/lang/String;Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAccountCreditCardsService {
    Object deleteCard(String str, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<Unit>> continuation);

    Object getCards(AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<? extends List<CreditCardDTO>>> continuation);

    Object registerCard(String str, CreditCardTypeDTO creditCardTypeDTO, String str2, String str3, String str4, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<Unit>> continuation);
}
