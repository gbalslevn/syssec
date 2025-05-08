package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.checkout.PaymentManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.CheckoutManager$handlePurchaseCompleted$2", f = "CheckoutManager.kt", l = {428, 444, 460, 467, 470}, m = "emit")
/* loaded from: classes2.dex */
public final class CheckoutManager$handlePurchaseCompleted$2$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CheckoutManager$handlePurchaseCompleted$2<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CheckoutManager$handlePurchaseCompleted$2$emit$1(CheckoutManager$handlePurchaseCompleted$2<? super T> checkoutManager$handlePurchaseCompleted$2, Continuation<? super CheckoutManager$handlePurchaseCompleted$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = checkoutManager$handlePurchaseCompleted$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((PaymentManager.PaymentState) null, (Continuation<? super Unit>) this);
    }
}
