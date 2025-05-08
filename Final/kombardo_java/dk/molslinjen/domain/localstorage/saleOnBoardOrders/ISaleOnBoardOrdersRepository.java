package dk.molslinjen.domain.localstorage.saleOnBoardOrders;

import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H¦@¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H¦@¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0003H¦@¢\u0006\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/localstorage/saleOnBoardOrders/ISaleOnBoardOrdersRepository;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "getOrders", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "order", BuildConfig.FLAVOR, "add", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "update", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ISaleOnBoardOrdersRepository {
    Object add(SaleOnBoardOrder saleOnBoardOrder, Continuation<? super Boolean> continuation);

    Object getOrders(Continuation<? super List<SaleOnBoardOrder>> continuation);

    Object update(SaleOnBoardOrder saleOnBoardOrder, Continuation<? super Unit> continuation);
}
