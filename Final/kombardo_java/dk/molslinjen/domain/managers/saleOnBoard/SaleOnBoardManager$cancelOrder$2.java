package dk.molslinjen.domain.managers.saleOnBoard;

import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager$cancelOrder$2", f = "SaleOnBoardManager.kt", l = {52}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardManager$cancelOrder$2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
    final /* synthetic */ SaleOnBoardOrder $saleOnBoardOrder;
    int label;
    final /* synthetic */ SaleOnBoardManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardManager$cancelOrder$2(SaleOnBoardManager saleOnBoardManager, SaleOnBoardOrder saleOnBoardOrder, Continuation<? super SaleOnBoardManager$cancelOrder$2> continuation) {
        super(2, continuation);
        this.this$0 = saleOnBoardManager;
        this.$saleOnBoardOrder = saleOnBoardOrder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SaleOnBoardManager$cancelOrder$2(this.this$0, this.$saleOnBoardOrder, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            SaleOnBoardManager saleOnBoardManager = this.this$0;
            List<SaleOnBoardOrder> listOf = CollectionsKt.listOf(this.$saleOnBoardOrder);
            this.label = 1;
            if (saleOnBoardManager.updateStatusForOrders(listOf, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
        return ((SaleOnBoardManager$cancelOrder$2) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
