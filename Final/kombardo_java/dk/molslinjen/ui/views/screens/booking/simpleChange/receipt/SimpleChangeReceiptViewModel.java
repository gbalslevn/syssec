package dk.molslinjen.ui.views.screens.booking.simpleChange.receipt;

import androidx.lifecycle.ViewModel;
import dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/simpleChange/receipt/SimpleChangeReceiptViewModel;", "Landroidx/lifecycle/ViewModel;", "simpleChangeCheckoutManager", "Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;", "<init>", "(Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;)V", "simpleChangeCheckoutState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager$SimpleChangeCheckoutState;", "getSimpleChangeCheckoutState", "()Lkotlinx/coroutines/flow/StateFlow;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SimpleChangeReceiptViewModel extends ViewModel {
    private final StateFlow<SimpleChangeCheckoutManager.SimpleChangeCheckoutState> simpleChangeCheckoutState;

    public SimpleChangeReceiptViewModel(ISimpleChangeCheckoutManager simpleChangeCheckoutManager) {
        Intrinsics.checkNotNullParameter(simpleChangeCheckoutManager, "simpleChangeCheckoutManager");
        this.simpleChangeCheckoutState = simpleChangeCheckoutManager.getSimpleChangeCheckoutState();
    }

    public final StateFlow<SimpleChangeCheckoutManager.SimpleChangeCheckoutState> getSimpleChangeCheckoutState() {
        return this.simpleChangeCheckoutState;
    }
}
