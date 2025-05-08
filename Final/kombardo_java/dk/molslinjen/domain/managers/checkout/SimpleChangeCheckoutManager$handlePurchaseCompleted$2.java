package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.checkout.PaymentManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SimpleChangeCheckoutManager$handlePurchaseCompleted$2<T> implements FlowCollector {
    final /* synthetic */ SimpleChangeCheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleChangeCheckoutManager$handlePurchaseCompleted$2(SimpleChangeCheckoutManager simpleChangeCheckoutManager) {
        this.this$0 = simpleChangeCheckoutManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(PaymentManager.PaymentState paymentState, Continuation<? super Unit> continuation) {
        SimpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1 simpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1;
        int i5;
        ITicketsManager iTicketsManager;
        SimpleChangeCheckoutManager$handlePurchaseCompleted$2<T> simpleChangeCheckoutManager$handlePurchaseCompleted$2;
        IPaymentManager iPaymentManager;
        if (continuation instanceof SimpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1) {
            simpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1 = (SimpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1) continuation;
            int i6 = simpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                simpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1.label = i6 - Integer.MIN_VALUE;
                Object obj = simpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = simpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (Intrinsics.areEqual(paymentState.getPaymentSucceeded(), Boxing.boxBoolean(true)) && paymentState.getPaymentOrigin() == PaymentOrigin.SimpleChangeOrEarlyCheckInTicket) {
                        iTicketsManager = this.this$0.ticketsManager;
                        simpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1.L$0 = this;
                        simpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1.label = 1;
                        if (iTicketsManager.updateLocalBookings(simpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        simpleChangeCheckoutManager$handlePurchaseCompleted$2 = this;
                    }
                    return Unit.INSTANCE;
                }
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                simpleChangeCheckoutManager$handlePurchaseCompleted$2 = (SimpleChangeCheckoutManager$handlePurchaseCompleted$2) simpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1.L$0;
                ResultKt.throwOnFailure(obj);
                iPaymentManager = simpleChangeCheckoutManager$handlePurchaseCompleted$2.this$0.paymentManager;
                iPaymentManager.resetPaymentState();
                return Unit.INSTANCE;
            }
        }
        simpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1 = new SimpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1(this, continuation);
        Object obj2 = simpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = simpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1.label;
        if (i5 != 0) {
        }
        iPaymentManager = simpleChangeCheckoutManager$handlePurchaseCompleted$2.this$0.paymentManager;
        iPaymentManager.resetPaymentState();
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((PaymentManager.PaymentState) obj, (Continuation<? super Unit>) continuation);
    }
}
