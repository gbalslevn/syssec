package dk.molslinjen.domain.managers.saleOnBoard;

import com.sun.jna.Function;
import dk.molslinjen.api.services.saleOnBoard.response.SaleOnBoardOrderResponseDTO;
import dk.molslinjen.domain.localstorage.saleOnBoardOrders.ISaleOnBoardOrdersRepository;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager$updateStatusForOrders$2", f = "SaleOnBoardManager.kt", l = {Function.ALT_CONVENTION}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardManager$updateStatusForOrders$2 extends SuspendLambda implements Function2<SaleOnBoardOrderResponseDTO, Continuation<? super Unit>, Object> {
    final /* synthetic */ SaleOnBoardOrder $order;
    final /* synthetic */ List<SaleOnBoardOrder> $updatedOrders;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SaleOnBoardManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardManager$updateStatusForOrders$2(SaleOnBoardOrder saleOnBoardOrder, List<SaleOnBoardOrder> list, SaleOnBoardManager saleOnBoardManager, Continuation<? super SaleOnBoardManager$updateStatusForOrders$2> continuation) {
        super(2, continuation);
        this.$order = saleOnBoardOrder;
        this.$updatedOrders = list;
        this.this$0 = saleOnBoardManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SaleOnBoardManager$updateStatusForOrders$2 saleOnBoardManager$updateStatusForOrders$2 = new SaleOnBoardManager$updateStatusForOrders$2(this.$order, this.$updatedOrders, this.this$0, continuation);
        saleOnBoardManager$updateStatusForOrders$2.L$0 = obj;
        return saleOnBoardManager$updateStatusForOrders$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SaleOnBoardOrderResponseDTO saleOnBoardOrderResponseDTO, Continuation<? super Unit> continuation) {
        return ((SaleOnBoardManager$updateStatusForOrders$2) create(saleOnBoardOrderResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            SaleOnBoardOrder invoke = SaleOnBoardOrder.INSTANCE.invoke((SaleOnBoardOrderResponseDTO) this.L$0, this.$order);
            this.$updatedOrders.add(invoke);
            ISaleOnBoardOrdersRepository iSaleOnBoardOrdersRepository = this.this$0.saleOnBoardOrdersRepository;
            this.label = 1;
            if (iSaleOnBoardOrdersRepository.update(invoke, this) == coroutine_suspended) {
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
}
