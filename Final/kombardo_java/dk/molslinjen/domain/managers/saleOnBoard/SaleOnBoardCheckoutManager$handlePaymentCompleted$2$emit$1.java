package dk.molslinjen.domain.managers.saleOnBoard;

import dk.molslinjen.domain.managers.checkout.PaymentManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager$handlePaymentCompleted$2", f = "SaleOnBoardCheckoutManager.kt", l = {332, 335, 365}, m = "emit")
/* loaded from: classes2.dex */
public final class SaleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SaleOnBoardCheckoutManager$handlePaymentCompleted$2<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SaleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1(SaleOnBoardCheckoutManager$handlePaymentCompleted$2<? super T> saleOnBoardCheckoutManager$handlePaymentCompleted$2, Continuation<? super SaleOnBoardCheckoutManager$handlePaymentCompleted$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = saleOnBoardCheckoutManager$handlePaymentCompleted$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((PaymentManager.PaymentState) null, (Continuation<? super Unit>) this);
    }
}
