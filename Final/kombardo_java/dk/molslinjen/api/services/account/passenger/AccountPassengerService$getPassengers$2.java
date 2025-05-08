package dk.molslinjen.api.services.account.passenger;

import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.passenger.AccountPassengersApi;
import dk.molslinjen.api.services.account.passenger.response.AccountPassengerDTO;
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

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/account/passenger/response/AccountPassengerDTO;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.account.passenger.AccountPassengerService$getPassengers$2", f = "AccountPassengerService.kt", l = {18}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class AccountPassengerService$getPassengers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends List<? extends AccountPassengerDTO>>>, Object> {
    final /* synthetic */ AuthTokenDTO $authToken;
    int label;
    final /* synthetic */ AccountPassengerService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountPassengerService$getPassengers$2(AccountPassengerService accountPassengerService, AuthTokenDTO authTokenDTO, Continuation<? super AccountPassengerService$getPassengers$2> continuation) {
        super(2, continuation);
        this.this$0 = accountPassengerService;
        this.$authToken = authTokenDTO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountPassengerService$getPassengers$2(this.this$0, this.$authToken, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends List<? extends AccountPassengerDTO>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<? extends List<AccountPassengerDTO>>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AccountPassengersApi accountPassengersApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            accountPassengersApi = this.this$0.api;
            String token = this.$authToken.getToken();
            this.label = 1;
            obj = AccountPassengersApi.DefaultImpls.getPassengers$default(accountPassengersApi, null, token, this, 1, null);
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
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends List<AccountPassengerDTO>>> continuation) {
        return ((AccountPassengerService$getPassengers$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
