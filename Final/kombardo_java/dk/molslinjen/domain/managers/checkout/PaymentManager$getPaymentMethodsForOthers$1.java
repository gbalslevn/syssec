package dk.molslinjen.domain.managers.checkout;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.PaymentManager", f = "PaymentManager.kt", l = {233}, m = "getPaymentMethodsForOthers")
/* loaded from: classes2.dex */
public final class PaymentManager$getPaymentMethodsForOthers$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PaymentManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentManager$getPaymentMethodsForOthers$1(PaymentManager paymentManager, Continuation<? super PaymentManager$getPaymentMethodsForOthers$1> continuation) {
        super(continuation);
        this.this$0 = paymentManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getPaymentMethodsForOthers(null, null, this);
    }
}
