package dk.molslinjen.ui.views.screens.saleOnBoard.receipt;

import androidx.lifecycle.ViewModel;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/receipt/SaleOnBoardReceiptViewModel;", "Landroidx/lifecycle/ViewModel;", "saleOnBoardCheckoutManager", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;", "<init>", "(Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;)V", "saleOnBoardCheckoutState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "getSaleOnBoardCheckoutState", "()Lkotlinx/coroutines/flow/StateFlow;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardReceiptViewModel extends ViewModel {
    private final StateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> saleOnBoardCheckoutState;

    public SaleOnBoardReceiptViewModel(ISaleOnBoardCheckoutManager saleOnBoardCheckoutManager) {
        Intrinsics.checkNotNullParameter(saleOnBoardCheckoutManager, "saleOnBoardCheckoutManager");
        this.saleOnBoardCheckoutState = saleOnBoardCheckoutManager.getSaleOnBoardCheckoutState();
    }

    public final StateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> getSaleOnBoardCheckoutState() {
        return this.saleOnBoardCheckoutState;
    }
}
