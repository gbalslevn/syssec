package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.checkout.PaymentManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager$handlePurchaseCompleted$2", f = "SimpleChangeCheckoutManager.kt", l = {125}, m = "emit")
/* loaded from: classes2.dex */
public final class SimpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SimpleChangeCheckoutManager$handlePurchaseCompleted$2<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1(SimpleChangeCheckoutManager$handlePurchaseCompleted$2<? super T> simpleChangeCheckoutManager$handlePurchaseCompleted$2, Continuation<? super SimpleChangeCheckoutManager$handlePurchaseCompleted$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = simpleChangeCheckoutManager$handlePurchaseCompleted$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((PaymentManager.PaymentState) null, (Continuation<? super Unit>) this);
    }
}
