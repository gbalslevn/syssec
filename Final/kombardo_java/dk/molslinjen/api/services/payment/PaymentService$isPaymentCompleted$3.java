package dk.molslinjen.api.services.payment;

import dk.molslinjen.api.extensions.ResponseExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.payment.response.PaymentStatusResponseDTO;
import dk.molslinjen.core.log.Logger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.threeten.bp.LocalDateTime;
import retrofit2.Response;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/payment/response/PaymentStatusResponseDTO;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.api.services.payment.PaymentService$isPaymentCompleted$3", f = "PaymentService.kt", l = {72, 82, 83}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class PaymentService$isPaymentCompleted$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends PaymentStatusResponseDTO>>, Object> {
    final /* synthetic */ LocalDateTime $firstRequestTime;
    final /* synthetic */ boolean $paymentCapturedLater;
    final /* synthetic */ String $reservationNumber;
    int label;
    final /* synthetic */ PaymentService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentService$isPaymentCompleted$3(PaymentService paymentService, String str, boolean z5, LocalDateTime localDateTime, Continuation<? super PaymentService$isPaymentCompleted$3> continuation) {
        super(2, continuation);
        this.this$0 = paymentService;
        this.$reservationNumber = str;
        this.$paymentCapturedLater = z5;
        this.$firstRequestTime = localDateTime;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentService$isPaymentCompleted$3(this.this$0, this.$reservationNumber, this.$paymentCapturedLater, this.$firstRequestTime, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends PaymentStatusResponseDTO>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super ApiResult<PaymentStatusResponseDTO>>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00c5 A[PHI: r14
      0x00c5: PHI (r14v15 java.lang.Object) = (r14v14 java.lang.Object), (r14v0 java.lang.Object) binds: [B:13:0x00c2, B:6:0x0011] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        PaymentApi paymentApi;
        PaymentStatusResponseDTO copy;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            paymentApi = this.this$0.api;
            String str = this.$reservationNumber;
            this.label = 1;
            obj = paymentApi.isPaymentCompleted(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 == 3) {
                        ResultKt.throwOnFailure(obj);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                PaymentService paymentService = this.this$0;
                String str2 = this.$reservationNumber;
                LocalDateTime localDateTime = this.$firstRequestTime;
                this.label = 3;
                obj = paymentService.isPaymentCompleted(str2, false, localDateTime, this);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
            ResultKt.throwOnFailure(obj);
        }
        ApiResult response = ResponseExtensionsKt.response((Response) obj);
        if (response instanceof ApiResult.Error) {
            return (ApiResult.Error) response;
        }
        if (!(response instanceof ApiResult.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        ApiResult.Success success = (ApiResult.Success) response;
        if (((PaymentStatusResponseDTO) success.getData()).isPending()) {
            if (this.$paymentCapturedLater) {
                copy = r2.copy((r18 & 1) != 0 ? r2.cardExpiryDate : null, (r18 & 2) != 0 ? r2.cardNumber : null, (r18 & 4) != 0 ? r2.creditCardToken : null, (r18 & 8) != 0 ? r2.isCompleted : true, (r18 & 16) != 0 ? r2.isPending : false, (r18 & 32) != 0 ? r2.paymentId : null, (r18 & 64) != 0 ? r2.paymentType : null, (r18 & 128) != 0 ? ((PaymentStatusResponseDTO) success.getData()).transactionId : null);
                return success.copy(copy);
            }
            Logger logger = Logger.INSTANCE;
            Logger.log$default(logger, "Payment completed check - payment is not completed #" + this.$reservationNumber, "PaymentProcess", 0, 4, null);
            if (this.$firstRequestTime.isAfter(LocalDateTime.now().minusMinutes(2L))) {
                this.label = 2;
                if (DelayKt.delay(2000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                PaymentService paymentService2 = this.this$0;
                String str22 = this.$reservationNumber;
                LocalDateTime localDateTime2 = this.$firstRequestTime;
                this.label = 3;
                obj = paymentService2.isPaymentCompleted(str22, false, localDateTime2, this);
                if (obj != coroutine_suspended) {
                }
            } else {
                Logger.log$default(logger, "Is Payment completed check timed out while isPending for reservation #" + this.$reservationNumber, "PaymentProcess", 0, 4, null);
            }
        }
        Logger.log$default(Logger.INSTANCE, "Payment is completed #" + this.$reservationNumber, null, 0, 6, null);
        return response;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super ApiResult<PaymentStatusResponseDTO>> continuation) {
        return ((PaymentService$isPaymentCompleted$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
