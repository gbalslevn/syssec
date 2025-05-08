package dk.molslinjen.api.services.account.creditcard;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.account.creditcard.response.CreditCardDTO;
import dk.molslinjen.api.services.account.creditcard.response.CreditCardTypeDTO;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0012JD\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/api/services/account/creditcard/AccountCreditCardsService;", "Ldk/molslinjen/api/services/account/creditcard/IAccountCreditCardsService;", "Ldk/molslinjen/api/services/BaseService;", "api", "Ldk/molslinjen/api/services/account/creditcard/AccountCreditCardsApi;", "<init>", "(Ldk/molslinjen/api/services/account/creditcard/AccountCreditCardsApi;)V", "getCards", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/account/creditcard/response/CreditCardDTO;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCard", BuildConfig.FLAVOR, "cardId", BuildConfig.FLAVOR, "(Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerCard", "maskedNumber", "cardType", "Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTO;", "expirationMonth", "expirationYear", "creditCardToken", "(Ljava/lang/String;Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AccountCreditCardsService extends BaseService implements IAccountCreditCardsService {
    private final AccountCreditCardsApi api;

    public AccountCreditCardsService(AccountCreditCardsApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.account.creditcard.IAccountCreditCardsService
    public Object deleteCard(String str, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountCreditCardsService$deleteCard$2(this, str, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.creditcard.IAccountCreditCardsService
    public Object getCards(AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<? extends List<CreditCardDTO>>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountCreditCardsService$getCards$2(this, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.account.creditcard.IAccountCreditCardsService
    public Object registerCard(String str, CreditCardTypeDTO creditCardTypeDTO, String str2, String str3, String str4, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new AccountCreditCardsService$registerCard$2(str, creditCardTypeDTO, str2, str3, str4, this, authTokenDTO, null), continuation);
    }
}
