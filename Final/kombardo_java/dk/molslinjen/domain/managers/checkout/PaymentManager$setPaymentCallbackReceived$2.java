package dk.molslinjen.domain.managers.checkout;

import androidx.appcompat.R$styleable;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.payment.IPaymentService;
import dk.molslinjen.api.services.payment.response.PaymentStatusResponseDTO;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.extensions.PaymentStatusResponseDTOExtensionsKt;
import dk.molslinjen.domain.managers.checkout.PaymentManager;
import dk.molslinjen.domain.model.account.CreditCardType;
import dk.molslinjen.domain.model.booking.BookingProcessingResult;
import dk.molslinjen.domain.model.payment.PaymentType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.PaymentManager$setPaymentCallbackReceived$2", f = "PaymentManager.kt", l = {R$styleable.AppCompatTheme_windowActionBar, 122, 149}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class PaymentManager$setPaymentCallbackReceived$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reservationNumber;
    int label;
    final /* synthetic */ PaymentManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentManager$setPaymentCallbackReceived$2(PaymentManager paymentManager, String str, Continuation<? super PaymentManager$setPaymentCallbackReceived$2> continuation) {
        super(2, continuation);
        this.this$0 = paymentManager;
        this.$reservationNumber = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentManager$setPaymentCallbackReceived$2(this.this$0, this.$reservationNumber, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x014c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        IAnalyticsTracker iAnalyticsTracker;
        IPaymentService iPaymentService;
        IPaymentService iPaymentService2;
        Object isPaymentCompleted;
        ApiResult apiResult;
        Object saveCreditCard;
        PaymentManager.PaymentState value;
        IAnalyticsTracker iAnalyticsTracker2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iAnalyticsTracker = this.this$0.analyticsTracker;
            iAnalyticsTracker.trackPaymentEntered();
            if (this.this$0.getPaymentState().getValue().getBookingProcessingResult() == BookingProcessingResult.Free) {
                Logger.log$default(Logger.INSTANCE, "setPaymentCallbackReceived Free", "PaymentProcess", 0, 4, null);
                this.this$0.paymentSucceeded(true, null, CreditCardType.Other);
                return Unit.INSTANCE;
            }
            if (this.this$0.getPaymentState().getValue().getPaymentType() == PaymentType.MobilePay) {
                Logger.log$default(Logger.INSTANCE, "will call updateOrderPaymentStatus for mobilepay order", "PaymentProcess", 0, 4, null);
                iPaymentService = this.this$0.paymentService;
                String str = this.$reservationNumber;
                this.label = 1;
                if (iPaymentService.updateOrderPaymentStatus(str, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                isPaymentCompleted = obj;
                apiResult = (ApiResult) isPaymentCompleted;
                if (!(apiResult instanceof ApiResult.Error)) {
                    ApiResult.Error error = (ApiResult.Error) apiResult;
                    Logger.log$default(Logger.INSTANCE, "isPaymentCompleted Failed '" + error.getErrorMessage() + "'", "PaymentProcess", 0, 4, null);
                    MutableStateFlow<PaymentManager.PaymentState> paymentState = this.this$0.getPaymentState();
                    do {
                        value = paymentState.getValue();
                    } while (!paymentState.compareAndSet(value, PaymentManager.PaymentState.copy$default(value, false, Boxing.boxBoolean(false), Boxing.boxBoolean(false), null, null, false, null, null, null, null, 1017, null)));
                    iAnalyticsTracker2 = this.this$0.analyticsTracker;
                    iAnalyticsTracker2.trackEvent(new AnalyticsEvent.PaymentFailed(error.getErrorMessage()));
                } else {
                    if (!(apiResult instanceof ApiResult.Success)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ApiResult.Success success = (ApiResult.Success) apiResult;
                    Logger.log$default(Logger.INSTANCE, "isPaymentCompleted Success isCompleted: " + ((PaymentStatusResponseDTO) success.getData()).isCompleted() + ", transactionId: " + ((PaymentStatusResponseDTO) success.getData()).getTransactionId(), "PaymentProcess", 0, 4, null);
                    this.this$0.paymentSucceeded(((PaymentStatusResponseDTO) success.getData()).isCompleted(), ((PaymentStatusResponseDTO) success.getData()).getTransactionId(), PaymentStatusResponseDTOExtensionsKt.getCardType((PaymentStatusResponseDTO) success.getData()));
                    PaymentManager paymentManager = this.this$0;
                    PaymentStatusResponseDTO paymentStatusResponseDTO = (PaymentStatusResponseDTO) success.getData();
                    this.label = 3;
                    saveCreditCard = paymentManager.saveCreditCard(paymentStatusResponseDTO, this);
                    if (saveCreditCard == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        Logger.log$default(Logger.INSTANCE, "After possible updateOrderPaymentStatus call: " + this.this$0.getPaymentState().getValue().getPaymentType(), "PaymentProcess", 0, 4, null);
        iPaymentService2 = this.this$0.paymentService;
        String str2 = this.$reservationNumber;
        boolean paymentCapturedLater = this.this$0.getPaymentState().getValue().getPaymentCapturedLater();
        this.label = 2;
        isPaymentCompleted = iPaymentService2.isPaymentCompleted(str2, paymentCapturedLater, this);
        if (isPaymentCompleted == coroutine_suspended) {
            return coroutine_suspended;
        }
        apiResult = (ApiResult) isPaymentCompleted;
        if (!(apiResult instanceof ApiResult.Error)) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaymentManager$setPaymentCallbackReceived$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
