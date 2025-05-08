package dk.molslinjen.domain.managers.saleOnBoard;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH¦@¢\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\u000f\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0012\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u0010R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;", BuildConfig.FLAVOR, "saleOnBoardState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardManager$SaleOnBoardState;", "getSaleOnBoardState", "()Lkotlinx/coroutines/flow/StateFlow;", "updateStatusForOrders", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "orders", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelOrder", BuildConfig.FLAVOR, "saleOnBoardOrder", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSaleOnBoardOrders", "timeTableId", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addOrder", "order", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ISaleOnBoardManager {
    Object addOrder(SaleOnBoardOrder saleOnBoardOrder, Continuation<? super Unit> continuation);

    Object cancelOrder(SaleOnBoardOrder saleOnBoardOrder, Continuation<? super ManagerResult<Unit>> continuation);

    Object getSaleOnBoardOrders(String str, Continuation<? super List<SaleOnBoardOrder>> continuation);

    StateFlow<SaleOnBoardManager.SaleOnBoardState> getSaleOnBoardState();

    Object updateStatusForOrders(List<SaleOnBoardOrder> list, Continuation<? super ManagerResult<? extends List<SaleOnBoardOrder>>> continuation);
}
