package dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardProductDetailsScreenDestination;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProductAddOn;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProductAddOnOption;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardVariant;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001)B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 J\u001c\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190%J\u0014\u0010&\u001a\u00020\u00192\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190%J\b\u0010'\u001a\u00020\u0019H\u0002J\u0006\u0010(\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006*"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/produdctDetails/SaleOnBoardProductDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "saleOnBoardCheckoutManager", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;Landroidx/lifecycle/SavedStateHandle;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/saleOnBoard/produdctDetails/SaleOnBoardProductDetailsScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/saleOnBoard/produdctDetails/SaleOnBoardProductDetailsViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "saleOnBoardState", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "getSaleOnBoardState", "selectOption", BuildConfig.FLAVOR, "addOn", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOn;", "option", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOnOption;", "selectVariant", "variant", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;", "onAddToBasket", "quantity", BuildConfig.FLAVOR, "dismiss", "Lkotlin/Function0;", "removeFromBasket", "updateLineItemPrice", "showSoldOutMessage", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardProductDetailsViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final SaleOnBoardProductDetailsScreenNavArgs navArgs;
    private final ISaleOnBoardCheckoutManager saleOnBoardCheckoutManager;
    private final StateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> saleOnBoardState;
    private final ISnackbarService snackbarService;
    private final StateFlow<ViewState> viewState;

    /* JADX WARN: Multi-variable type inference failed */
    public SaleOnBoardProductDetailsViewModel(ISaleOnBoardCheckoutManager saleOnBoardCheckoutManager, SavedStateHandle savedStateHandle, ISnackbarService snackbarService, IAnalyticsTracker analyticsTracker) {
        Object obj;
        ViewState value;
        ViewState value2;
        Intrinsics.checkNotNullParameter(saleOnBoardCheckoutManager, "saleOnBoardCheckoutManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.saleOnBoardCheckoutManager = saleOnBoardCheckoutManager;
        this.snackbarService = snackbarService;
        this.analyticsTracker = analyticsTracker;
        SaleOnBoardProductDetailsScreenNavArgs argsFrom = SaleOnBoardProductDetailsScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, false, 3, 0 == true ? 1 : 0));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        StateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> saleOnBoardCheckoutState = saleOnBoardCheckoutManager.getSaleOnBoardCheckoutState();
        this.saleOnBoardState = saleOnBoardCheckoutState;
        String productId = argsFrom.getProductId();
        String nullIfEmpty = StringExtensionsKt.nullIfEmpty(argsFrom.getLineItemId());
        Iterator<T> it = saleOnBoardCheckoutState.getValue().getBasketLineItems().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((SaleOnBoardLineItem) obj).getId(), nullIfEmpty)) {
                    break;
                }
            }
        }
        SaleOnBoardLineItem saleOnBoardLineItem = (SaleOnBoardLineItem) obj;
        if (nullIfEmpty != null) {
            MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
            do {
                value2 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value2, value2.copy(saleOnBoardLineItem, true)));
        } else {
            SaleOnBoardProduct product = this.saleOnBoardCheckoutManager.getProduct(productId);
            if (product != null) {
                MutableStateFlow<ViewState> mutableStateFlow2 = this._viewState;
                do {
                    value = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value, ViewState.copy$default(value, new SaleOnBoardLineItem(product), false, 2, null)));
            }
        }
        SaleOnBoardLineItem lineItem = this.viewState.getValue().getLineItem();
        if (lineItem != null) {
            this.analyticsTracker.trackSaleOnBoardEvent(new SaleOnBoardAnalyticsEvent.ViewLineItem(this.saleOnBoardState.getValue(), lineItem));
        }
    }

    private final void updateLineItemPrice() {
        ViewState value;
        ViewState viewState;
        SaleOnBoardLineItem saleOnBoardLineItem;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
            viewState = value;
            SaleOnBoardLineItem lineItem = viewState.getLineItem();
            if (lineItem != null) {
                PriceWithCurrency price = viewState.getLineItem().getProduct().getPrice();
                int value2 = viewState.getLineItem().getProduct().getPrice().getValue();
                Iterator<T> it = viewState.getLineItem().getAddOns().iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    i5 += ((SaleOnBoardProductAddOnOption) it.next()).getPrice().getValue();
                }
                saleOnBoardLineItem = SaleOnBoardLineItem.copy$default(lineItem, null, null, PriceWithCurrency.copy$default(price, value2 + i5, null, 2, null), 0, null, null, 59, null);
            } else {
                saleOnBoardLineItem = null;
            }
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(viewState, saleOnBoardLineItem, false, 2, null)));
    }

    public final StateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> getSaleOnBoardState() {
        return this.saleOnBoardState;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void onAddToBasket(int quantity, Function0<Unit> dismiss) {
        ViewState value;
        ViewState viewState;
        SaleOnBoardLineItem lineItem;
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
            viewState = value;
            lineItem = viewState.getLineItem();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(viewState, lineItem != null ? SaleOnBoardLineItem.copy$default(lineItem, null, null, null, quantity, null, null, 55, null) : null, false, 2, null)));
        updateLineItemPrice();
        SaleOnBoardLineItem lineItem2 = this.viewState.getValue().getLineItem();
        if (lineItem2 == null) {
            return;
        }
        this.saleOnBoardCheckoutManager.addToBasket(lineItem2, this.viewState.getValue().getIsEditing());
        dismiss.invoke();
    }

    public final void removeFromBasket(Function0<Unit> dismiss) {
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        SaleOnBoardLineItem lineItem = this.viewState.getValue().getLineItem();
        if (lineItem == null) {
            return;
        }
        this.saleOnBoardCheckoutManager.removeLineItem(lineItem.getId());
        dismiss.invoke();
    }

    public final void selectOption(SaleOnBoardProductAddOn addOn, SaleOnBoardProductAddOnOption option) {
        ViewState value;
        ViewState viewState;
        SaleOnBoardLineItem saleOnBoardLineItem;
        ViewState value2;
        ViewState viewState2;
        Intrinsics.checkNotNullParameter(addOn, "addOn");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
            viewState = value;
            SaleOnBoardLineItem lineItem = viewState.getLineItem();
            if (lineItem != null) {
                List<SaleOnBoardProductAddOnOption> addOns = viewState.getLineItem().getAddOns();
                ArrayList arrayList = new ArrayList();
                for (Object obj : addOns) {
                    SaleOnBoardProductAddOnOption saleOnBoardProductAddOnOption = (SaleOnBoardProductAddOnOption) obj;
                    List<SaleOnBoardProductAddOnOption> options = addOn.getOptions();
                    if (!(options instanceof Collection) || !options.isEmpty()) {
                        Iterator<T> it = options.iterator();
                        while (it.hasNext()) {
                            if (Intrinsics.areEqual(((SaleOnBoardProductAddOnOption) it.next()).getId(), saleOnBoardProductAddOnOption.getId())) {
                                break;
                            }
                        }
                    }
                    arrayList.add(obj);
                }
                saleOnBoardLineItem = SaleOnBoardLineItem.copy$default(lineItem, null, null, null, 0, null, arrayList, 31, null);
            } else {
                saleOnBoardLineItem = null;
            }
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(viewState, saleOnBoardLineItem, false, 2, null)));
        if (option != null) {
            MutableStateFlow<ViewState> mutableStateFlow2 = this._viewState;
            do {
                value2 = mutableStateFlow2.getValue();
                viewState2 = value2;
                if (viewState2.getLineItem() != null) {
                    viewState2 = ViewState.copy$default(viewState2, SaleOnBoardLineItem.copy$default(viewState2.getLineItem(), null, null, null, 0, null, CollectionsKt.plus((Collection<? extends SaleOnBoardProductAddOnOption>) viewState2.getLineItem().getAddOns(), option), 31, null), false, 2, null);
                }
            } while (!mutableStateFlow2.compareAndSet(value2, viewState2));
        }
        updateLineItemPrice();
    }

    public final void selectVariant(SaleOnBoardVariant variant) {
        ViewState value;
        ViewState viewState;
        SaleOnBoardLineItem lineItem;
        Intrinsics.checkNotNullParameter(variant, "variant");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
            viewState = value;
            lineItem = viewState.getLineItem();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(viewState, lineItem != null ? SaleOnBoardLineItem.copy$default(lineItem, null, null, null, 0, variant, null, 47, null) : null, false, 2, null)));
    }

    public final void showSoldOutMessage() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardProductDetailsViewModel$showSoldOutMessage$1(this, null), 3, null);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0005\u0010\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/produdctDetails/SaleOnBoardProductDetailsViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "lineItem", BuildConfig.FLAVOR, "isEditing", "<init>", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;Z)V", "copy", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;Z)Ldk/molslinjen/ui/views/screens/saleOnBoard/produdctDetails/SaleOnBoardProductDetailsViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "getLineItem", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "Z", "()Z", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isEditing;
        private final SaleOnBoardLineItem lineItem;

        public ViewState(SaleOnBoardLineItem saleOnBoardLineItem, boolean z5) {
            this.lineItem = saleOnBoardLineItem;
            this.isEditing = z5;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, SaleOnBoardLineItem saleOnBoardLineItem, boolean z5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                saleOnBoardLineItem = viewState.lineItem;
            }
            if ((i5 & 2) != 0) {
                z5 = viewState.isEditing;
            }
            return viewState.copy(saleOnBoardLineItem, z5);
        }

        public final ViewState copy(SaleOnBoardLineItem lineItem, boolean isEditing) {
            return new ViewState(lineItem, isEditing);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.lineItem, viewState.lineItem) && this.isEditing == viewState.isEditing;
        }

        public final SaleOnBoardLineItem getLineItem() {
            return this.lineItem;
        }

        public int hashCode() {
            SaleOnBoardLineItem saleOnBoardLineItem = this.lineItem;
            return ((saleOnBoardLineItem == null ? 0 : saleOnBoardLineItem.hashCode()) * 31) + Boolean.hashCode(this.isEditing);
        }

        /* renamed from: isEditing, reason: from getter */
        public final boolean getIsEditing() {
            return this.isEditing;
        }

        public String toString() {
            return "ViewState(lineItem=" + this.lineItem + ", isEditing=" + this.isEditing + ")";
        }

        public /* synthetic */ ViewState(SaleOnBoardLineItem saleOnBoardLineItem, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : saleOnBoardLineItem, (i5 & 2) != 0 ? false : z5);
        }
    }
}
