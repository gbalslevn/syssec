package dk.molslinjen.domain.managers.checkout;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.CheckoutManager", f = "CheckoutManager.kt", l = {487, 492}, m = "cancelExistingSaleOnBoardOrders")
/* loaded from: classes2.dex */
public final class CheckoutManager$cancelExistingSaleOnBoardOrders$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckoutManager$cancelExistingSaleOnBoardOrders$1(CheckoutManager checkoutManager, Continuation<? super CheckoutManager$cancelExistingSaleOnBoardOrders$1> continuation) {
        super(continuation);
        this.this$0 = checkoutManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object cancelExistingSaleOnBoardOrders;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        cancelExistingSaleOnBoardOrders = this.this$0.cancelExistingSaleOnBoardOrders(null, null, this);
        return cancelExistingSaleOnBoardOrders;
    }
}
