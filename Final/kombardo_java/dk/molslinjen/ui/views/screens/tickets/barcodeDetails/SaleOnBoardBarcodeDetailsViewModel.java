package dk.molslinjen.ui.views.screens.tickets.barcodeDetails;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardBarcodeDetailsScreenDestination;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardManager;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/SaleOnBoardBarcodeDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "saleOnBoardManager", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/SaleOnBoardBarcodeDetailsScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/SaleOnBoardBarcodeDetailsViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "onCleared", BuildConfig.FLAVOR, "loadData", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardBarcodeDetailsViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final SaleOnBoardBarcodeDetailsScreenNavArgs navArgs;
    private final ISaleOnBoardManager saleOnBoardManager;
    private final StateFlow<ViewState> viewState;

    /* JADX WARN: Multi-variable type inference failed */
    public SaleOnBoardBarcodeDetailsViewModel(SavedStateHandle savedStateHandle, ISaleOnBoardManager saleOnBoardManager) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(saleOnBoardManager, "saleOnBoardManager");
        this.saleOnBoardManager = saleOnBoardManager;
        this.navArgs = SaleOnBoardBarcodeDetailsScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, 1, 0 == true ? 1 : 0));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        loadData();
        ScreenBrightnessHelper.INSTANCE.changeBrightness(true);
    }

    private final void loadData() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardBarcodeDetailsViewModel$loadData$1(this, null), 3, null);
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        ScreenBrightnessHelper.INSTANCE.changeBrightness(false);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/SaleOnBoardBarcodeDetailsViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "order", "<init>", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;)V", "copy", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;)Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/SaleOnBoardBarcodeDetailsViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "getOrder", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final SaleOnBoardOrder order;

        public ViewState(SaleOnBoardOrder saleOnBoardOrder) {
            this.order = saleOnBoardOrder;
        }

        public final ViewState copy(SaleOnBoardOrder order) {
            return new ViewState(order);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ViewState) && Intrinsics.areEqual(this.order, ((ViewState) other).order);
        }

        public final SaleOnBoardOrder getOrder() {
            return this.order;
        }

        public int hashCode() {
            SaleOnBoardOrder saleOnBoardOrder = this.order;
            if (saleOnBoardOrder == null) {
                return 0;
            }
            return saleOnBoardOrder.hashCode();
        }

        public String toString() {
            return "ViewState(order=" + this.order + ")";
        }

        public /* synthetic */ ViewState(SaleOnBoardOrder saleOnBoardOrder, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : saleOnBoardOrder);
        }
    }
}
