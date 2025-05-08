package dk.molslinjen.api.services.account.creditcard;

import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.creditcard.AccountCreditCardsApi;
import dk.molslinjen.api.services.account.creditcard.response.CreditCardDTO;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/account/creditcard/response/CreditCardDTO;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.account.creditcard.AccountCreditCardsService$getCards$2", f = "AccountCreditCardsService.kt", l = {18}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class AccountCreditCardsService$getCards$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends List<? extends CreditCardDTO>>>, Object> {
    final /* synthetic */ AuthTokenDTO $authToken;
    int label;
    final /* synthetic */ AccountCreditCardsService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountCreditCardsService$getCards$2(AccountCreditCardsService accountCreditCardsService, AuthTokenDTO authTokenDTO, Continuation<? super AccountCreditCardsService$getCards$2> continuation) {
        super(2, continuation);
        this.this$0 = accountCreditCardsService;
        this.$authToken = authTokenDTO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountCreditCardsService$getCards$2(this.this$0, this.$authToken, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends List<? extends CreditCardDTO>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<? extends List<CreditCardDTO>>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AccountCreditCardsApi accountCreditCardsApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            accountCreditCardsApi = this.this$0.api;
            String token = this.$authToken.getToken();
            this.label = 1;
            obj = AccountCreditCardsApi.DefaultImpls.getCreditCards$default(accountCreditCardsApi, null, token, this, 1, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return ResponseExtensionsKt.response((Response) obj);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends List<CreditCardDTO>>> continuation) {
        return ((AccountCreditCardsService$getCards$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
