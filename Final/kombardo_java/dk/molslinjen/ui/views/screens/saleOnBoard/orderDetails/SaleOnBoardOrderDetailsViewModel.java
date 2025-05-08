package dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardOrderDetailsScreenDestination;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardManager;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001 B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0016J\u0006\u0010\u001b\u001a\u00020\u0016J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/orderDetails/SaleOnBoardOrderDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "saleOnBoardManager", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;Landroidx/lifecycle/SavedStateHandle;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/saleOnBoard/orderDetails/SaleOnBoardOrderDetailsScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/saleOnBoard/orderDetails/SaleOnBoardOrderDetailsViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadOrder", BuildConfig.FLAVOR, "orderNumber", BuildConfig.FLAVOR, "updateOrderStatus", "startCancelOrder", "stopCancelOrder", "cancelOrder", "saleOnBoardOrder", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "showCancelOrderDisabledMessage", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardOrderDetailsViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final SaleOnBoardOrderDetailsScreenNavArgs navArgs;
    private final ISaleOnBoardManager saleOnBoardManager;
    private final ISnackbarService snackbarService;
    private final StateFlow<ViewState> viewState;

    public SaleOnBoardOrderDetailsViewModel(ISaleOnBoardManager saleOnBoardManager, SavedStateHandle savedStateHandle, ISnackbarService snackbarService, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(saleOnBoardManager, "saleOnBoardManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.saleOnBoardManager = saleOnBoardManager;
        this.snackbarService = snackbarService;
        this.analyticsTracker = analyticsTracker;
        SaleOnBoardOrderDetailsScreenNavArgs argsFrom = SaleOnBoardOrderDetailsScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, null, false, false, 15, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        loadOrder(argsFrom.getOrderNumber());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadOrder(String orderNumber) {
        Object obj;
        ViewState value;
        Iterator<T> it = this.saleOnBoardManager.getSaleOnBoardState().getValue().getOrders().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((SaleOnBoardOrder) obj).getOrderNumber(), orderNumber)) {
                    break;
                }
            }
        }
        SaleOnBoardOrder saleOnBoardOrder = (SaleOnBoardOrder) obj;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, saleOnBoardOrder, false, false, 12, null)));
    }

    public final void cancelOrder(SaleOnBoardOrder saleOnBoardOrder) {
        Intrinsics.checkNotNullParameter(saleOnBoardOrder, "saleOnBoardOrder");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardOrderDetailsViewModel$cancelOrder$1(this, saleOnBoardOrder, null), 3, null);
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void showCancelOrderDisabledMessage() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardOrderDetailsViewModel$showCancelOrderDisabledMessage$1(this, null), 3, null);
    }

    public final void startCancelOrder() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, null, true, false, 11, null)));
    }

    public final void stopCancelOrder() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, null, false, false, 11, null)));
    }

    public final void updateOrderStatus() {
        SaleOnBoardOrder order = this.viewState.getValue().getOrder();
        if (order == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardOrderDetailsViewModel$updateOrderStatus$1(this, order, null), 3, null);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ:\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0003\u0010\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0007\u0010\u0016¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/orderDetails/SaleOnBoardOrderDetailsViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "order", "showCancelOrderDialog", "isCancellingOrder", "<init>", "(ZLdk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;ZZ)V", "copy", "(ZLdk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;ZZ)Ldk/molslinjen/ui/views/screens/saleOnBoard/orderDetails/SaleOnBoardOrderDetailsViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "getOrder", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "getShowCancelOrderDialog", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isCancellingOrder;
        private final boolean isLoading;
        private final SaleOnBoardOrder order;
        private final boolean showCancelOrderDialog;

        public ViewState(boolean z5, SaleOnBoardOrder saleOnBoardOrder, boolean z6, boolean z7) {
            this.isLoading = z5;
            this.order = saleOnBoardOrder;
            this.showCancelOrderDialog = z6;
            this.isCancellingOrder = z7;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, SaleOnBoardOrder saleOnBoardOrder, boolean z6, boolean z7, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 2) != 0) {
                saleOnBoardOrder = viewState.order;
            }
            if ((i5 & 4) != 0) {
                z6 = viewState.showCancelOrderDialog;
            }
            if ((i5 & 8) != 0) {
                z7 = viewState.isCancellingOrder;
            }
            return viewState.copy(z5, saleOnBoardOrder, z6, z7);
        }

        public final ViewState copy(boolean isLoading, SaleOnBoardOrder order, boolean showCancelOrderDialog, boolean isCancellingOrder) {
            return new ViewState(isLoading, order, showCancelOrderDialog, isCancellingOrder);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.order, viewState.order) && this.showCancelOrderDialog == viewState.showCancelOrderDialog && this.isCancellingOrder == viewState.isCancellingOrder;
        }

        public final SaleOnBoardOrder getOrder() {
            return this.order;
        }

        public final boolean getShowCancelOrderDialog() {
            return this.showCancelOrderDialog;
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.isLoading) * 31;
            SaleOnBoardOrder saleOnBoardOrder = this.order;
            return ((((hashCode + (saleOnBoardOrder == null ? 0 : saleOnBoardOrder.hashCode())) * 31) + Boolean.hashCode(this.showCancelOrderDialog)) * 31) + Boolean.hashCode(this.isCancellingOrder);
        }

        /* renamed from: isCancellingOrder, reason: from getter */
        public final boolean getIsCancellingOrder() {
            return this.isCancellingOrder;
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", order=" + this.order + ", showCancelOrderDialog=" + this.showCancelOrderDialog + ", isCancellingOrder=" + this.isCancellingOrder + ")";
        }

        public /* synthetic */ ViewState(boolean z5, SaleOnBoardOrder saleOnBoardOrder, boolean z6, boolean z7, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? true : z5, (i5 & 2) != 0 ? null : saleOnBoardOrder, (i5 & 4) != 0 ? false : z6, (i5 & 8) != 0 ? false : z7);
        }
    }
}
