package dk.molslinjen.domain.managers.checkout;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.CheckoutManager", f = "CheckoutManager.kt", l = {406}, m = "handlePurchaseCompleted")
/* loaded from: classes2.dex */
public final class CheckoutManager$handlePurchaseCompleted$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckoutManager$handlePurchaseCompleted$1(CheckoutManager checkoutManager, Continuation<? super CheckoutManager$handlePurchaseCompleted$1> continuation) {
        super(continuation);
        this.this$0 = checkoutManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object handlePurchaseCompleted;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handlePurchaseCompleted = this.this$0.handlePurchaseCompleted(this);
        return handlePurchaseCompleted;
    }
}
