package dk.molslinjen.api.services.account.booking;

import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.booking.AccountBookingsApi;
import dk.molslinjen.api.services.account.booking.response.AccountBookingHeadersResponseDTO;
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
import org.threeten.bp.LocalDate;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/account/booking/response/AccountBookingHeadersResponseDTO;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.account.booking.AccountBookingsService$getHistoricBookings$2", f = "AccountBookingsService.kt", l = {40}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class AccountBookingsService$getHistoricBookings$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends AccountBookingHeadersResponseDTO>>, Object> {
    final /* synthetic */ AuthTokenDTO $authToken;
    final /* synthetic */ int $skip;
    final /* synthetic */ int $take;
    int label;
    final /* synthetic */ AccountBookingsService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountBookingsService$getHistoricBookings$2(AccountBookingsService accountBookingsService, int i5, int i6, AuthTokenDTO authTokenDTO, Continuation<? super AccountBookingsService$getHistoricBookings$2> continuation) {
        super(2, continuation);
        this.this$0 = accountBookingsService;
        this.$take = i5;
        this.$skip = i6;
        this.$authToken = authTokenDTO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountBookingsService$getHistoricBookings$2(this.this$0, this.$take, this.$skip, this.$authToken, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends AccountBookingHeadersResponseDTO>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<AccountBookingHeadersResponseDTO>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AccountBookingsApi accountBookingsApi;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            accountBookingsApi = this.this$0.api;
            int i6 = this.$take;
            int i7 = this.$skip;
            LocalDate minusYears = LocalDate.now().minusYears(10L);
            LocalDate plusYears = LocalDate.now().plusYears(1L);
            String token = this.$authToken.getToken();
            this.label = 1;
            obj = AccountBookingsApi.DefaultImpls.getBookings$default(accountBookingsApi, false, i6, i7, minusYears, plusYears, token, null, this, 64, null);
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
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<AccountBookingHeadersResponseDTO>> continuation) {
        return ((AccountBookingsService$getHistoricBookings$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
