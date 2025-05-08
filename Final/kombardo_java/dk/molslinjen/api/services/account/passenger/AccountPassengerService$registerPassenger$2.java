package dk.molslinjen.api.services.account.passenger;

import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.passenger.AccountPassengersApi;
import dk.molslinjen.api.services.account.passenger.request.RegisterPassengerRequestParameter;
import dk.molslinjen.api.services.account.passenger.response.AccountPassengerDTO;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/account/passenger/response/AccountPassengerDTO;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.account.passenger.AccountPassengerService$registerPassenger$2", f = "AccountPassengerService.kt", l = {28}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class AccountPassengerService$registerPassenger$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends AccountPassengerDTO>>, Object> {
    final /* synthetic */ AuthTokenDTO $authToken;
    final /* synthetic */ RegisterPassengerRequestParameter $requestParameters;
    int label;
    final /* synthetic */ AccountPassengerService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountPassengerService$registerPassenger$2(AccountPassengerService accountPassengerService, RegisterPassengerRequestParameter registerPassengerRequestParameter, AuthTokenDTO authTokenDTO, Continuation<? super AccountPassengerService$registerPassenger$2> continuation) {
        super(2, continuation);
        this.this$0 = accountPassengerService;
        this.$requestParameters = registerPassengerRequestParameter;
        this.$authToken = authTokenDTO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountPassengerService$registerPassenger$2(this.this$0, this.$requestParameters, this.$authToken, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends AccountPassengerDTO>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<AccountPassengerDTO>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AccountPassengersApi accountPassengersApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            accountPassengersApi = this.this$0.api;
            RegisterPassengerRequestParameter registerPassengerRequestParameter = this.$requestParameters;
            String token = this.$authToken.getToken();
            this.label = 1;
            obj = AccountPassengersApi.DefaultImpls.registerPassenger$default(accountPassengersApi, registerPassengerRequestParameter, null, token, this, 2, null);
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
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<AccountPassengerDTO>> continuation) {
        return ((AccountPassengerService$registerPassenger$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
