package dk.molslinjen.ui.views.screens.agreements.multiride.purchase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.MultiRidePurchaseSummaryViewModel", f = "MultiRidePurchaseSummaryViewModel.kt", l = {55, 59, 60}, m = "loadPaymentMethods")
/* loaded from: classes2.dex */
public final class MultiRidePurchaseSummaryViewModel$loadPaymentMethods$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiRidePurchaseSummaryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRidePurchaseSummaryViewModel$loadPaymentMethods$1(MultiRidePurchaseSummaryViewModel multiRidePurchaseSummaryViewModel, Continuation<? super MultiRidePurchaseSummaryViewModel$loadPaymentMethods$1> continuation) {
        super(continuation);
        this.this$0 = multiRidePurchaseSummaryViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadPaymentMethods(this);
    }
}
