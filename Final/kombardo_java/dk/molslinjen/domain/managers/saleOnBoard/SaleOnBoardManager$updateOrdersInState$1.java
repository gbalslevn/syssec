package dk.molslinjen.domain.managers.saleOnBoard;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager", f = "SaleOnBoardManager.kt", l = {39}, m = "updateOrdersInState")
/* loaded from: classes2.dex */
public final class SaleOnBoardManager$updateOrdersInState$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SaleOnBoardManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardManager$updateOrdersInState$1(SaleOnBoardManager saleOnBoardManager, Continuation<? super SaleOnBoardManager$updateOrdersInState$1> continuation) {
        super(continuation);
        this.this$0 = saleOnBoardManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object updateOrdersInState;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        updateOrdersInState = this.this$0.updateOrdersInState(this);
        return updateOrdersInState;
    }
}
