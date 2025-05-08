package dk.molslinjen.domain.managers.saleOnBoard;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH&J\u000e\u0010\r\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tR\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardRouteManager;", BuildConfig.FLAVOR, "routeState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardRouteState;", "getRouteState", "()Lkotlinx/coroutines/flow/StateFlow;", "flipDirection", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dateSelected", "date", "Lorg/threeten/bp/LocalDate;", "setup", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ISaleOnBoardRouteManager {
    void dateSelected(LocalDate date);

    Object flipDirection(Continuation<? super Unit> continuation);

    StateFlow<SaleOnBoardRouteState> getRouteState();

    Object setup(Continuation<? super Unit> continuation);
}
