package dk.molslinjen.domain.managers.saleOnBoard;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager", f = "SaleOnBoardCheckoutManager.kt", l = {292}, m = "handlePaymentCompleted")
/* loaded from: classes2.dex */
public final class SaleOnBoardCheckoutManager$handlePaymentCompleted$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SaleOnBoardCheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardCheckoutManager$handlePaymentCompleted$1(SaleOnBoardCheckoutManager saleOnBoardCheckoutManager, Continuation<? super SaleOnBoardCheckoutManager$handlePaymentCompleted$1> continuation) {
        super(continuation);
        this.this$0 = saleOnBoardCheckoutManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object handlePaymentCompleted;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handlePaymentCompleted = this.this$0.handlePaymentCompleted(this);
        return handlePaymentCompleted;
    }
}
