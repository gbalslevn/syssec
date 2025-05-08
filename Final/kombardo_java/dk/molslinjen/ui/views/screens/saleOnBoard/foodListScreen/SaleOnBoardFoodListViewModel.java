package dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCategory;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardTimeSlot;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001,B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\nJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\b0\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020!0$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020)0$8\u0006¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(¨\u0006-"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/foodListScreen/SaleOnBoardFoodListViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;", "saleOnBoardCheckoutManager", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "analyticsTracker", "<init>", "(Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", BuildConfig.FLAVOR, "setupTimeSlotListener", "()V", "setupCategoriesListener", "loadShopsAndProducts", "loadTimeSlots", "reloadShopsAndProducts", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCategory;", "category", "selectCategory", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCategory;)V", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", "product", BuildConfig.FLAVOR, "listIndex", "Lkotlin/Function1;", BuildConfig.FLAVOR, "proceed", "showProductDetails", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;ILkotlin/jvm/functions/Function1;)V", "seenProduct", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;I)V", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/saleOnBoard/foodListScreen/SaleOnBoardFoodListViewModel$ViewState;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "saleOnBoardCheckoutState", "getSaleOnBoardCheckoutState", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardFoodListViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final ISaleOnBoardCheckoutManager saleOnBoardCheckoutManager;
    private final StateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> saleOnBoardCheckoutState;
    private final StateFlow<ViewState> viewState;

    public SaleOnBoardFoodListViewModel(ISaleOnBoardCheckoutManager saleOnBoardCheckoutManager, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(saleOnBoardCheckoutManager, "saleOnBoardCheckoutManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.saleOnBoardCheckoutManager = saleOnBoardCheckoutManager;
        this.analyticsTracker = analyticsTracker;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, false, null, null, 15, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        this.saleOnBoardCheckoutState = saleOnBoardCheckoutManager.getSaleOnBoardCheckoutState();
        loadShopsAndProducts();
        loadTimeSlots();
        setupTimeSlotListener();
        setupCategoriesListener();
    }

    private final void loadShopsAndProducts() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardFoodListViewModel$loadShopsAndProducts$1(this, null), 3, null);
    }

    private final void loadTimeSlots() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardFoodListViewModel$loadTimeSlots$1(this, null), 3, null);
    }

    private final void setupCategoriesListener() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardFoodListViewModel$setupCategoriesListener$1(this, null), 3, null);
    }

    private final void setupTimeSlotListener() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardFoodListViewModel$setupTimeSlotListener$1(this, null), 3, null);
    }

    public final StateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> getSaleOnBoardCheckoutState() {
        return this.saleOnBoardCheckoutState;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void reloadShopsAndProducts() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, true, false, null, null, 14, null)));
        loadShopsAndProducts();
    }

    public final void seenProduct(SaleOnBoardProduct product, int listIndex) {
        Intrinsics.checkNotNullParameter(product, "product");
        this.analyticsTracker.trackSaleOnBoardEvent(new SaleOnBoardAnalyticsEvent.ViewListItem(this.saleOnBoardCheckoutState.getValue(), product, listIndex));
    }

    public final void selectCategory(SaleOnBoardCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        mutableStateFlow.setValue(ViewState.copy$default(mutableStateFlow.getValue(), false, false, category, null, 11, null));
    }

    public final void showProductDetails(SaleOnBoardProduct product, int listIndex, Function1<? super String, Unit> proceed) {
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        this.analyticsTracker.trackSaleOnBoardEvent(new SaleOnBoardAnalyticsEvent.SelectItem(this.saleOnBoardCheckoutState.getValue(), new SaleOnBoardLineItem(product), listIndex));
        proceed.invoke(product.getId());
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ@\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0003\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0004\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/foodListScreen/SaleOnBoardFoodListViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", "isLoadingTimeSlots", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCategory;", "selectedCategory", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;", "timeSlots", "<init>", "(ZZLdk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCategory;Ljava/util/List;)V", "copy", "(ZZLdk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCategory;Ljava/util/List;)Ldk/molslinjen/ui/views/screens/saleOnBoard/foodListScreen/SaleOnBoardFoodListViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCategory;", "getSelectedCategory", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCategory;", "Ljava/util/List;", "getTimeSlots", "()Ljava/util/List;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final boolean isLoadingTimeSlots;
        private final SaleOnBoardCategory selectedCategory;
        private final List<SaleOnBoardTimeSlot> timeSlots;

        public ViewState(boolean z5, boolean z6, SaleOnBoardCategory saleOnBoardCategory, List<SaleOnBoardTimeSlot> timeSlots) {
            Intrinsics.checkNotNullParameter(timeSlots, "timeSlots");
            this.isLoading = z5;
            this.isLoadingTimeSlots = z6;
            this.selectedCategory = saleOnBoardCategory;
            this.timeSlots = timeSlots;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, boolean z6, SaleOnBoardCategory saleOnBoardCategory, List list, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isLoading;
            }
            if ((i5 & 2) != 0) {
                z6 = viewState.isLoadingTimeSlots;
            }
            if ((i5 & 4) != 0) {
                saleOnBoardCategory = viewState.selectedCategory;
            }
            if ((i5 & 8) != 0) {
                list = viewState.timeSlots;
            }
            return viewState.copy(z5, z6, saleOnBoardCategory, list);
        }

        public final ViewState copy(boolean isLoading, boolean isLoadingTimeSlots, SaleOnBoardCategory selectedCategory, List<SaleOnBoardTimeSlot> timeSlots) {
            Intrinsics.checkNotNullParameter(timeSlots, "timeSlots");
            return new ViewState(isLoading, isLoadingTimeSlots, selectedCategory, timeSlots);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && this.isLoadingTimeSlots == viewState.isLoadingTimeSlots && Intrinsics.areEqual(this.selectedCategory, viewState.selectedCategory) && Intrinsics.areEqual(this.timeSlots, viewState.timeSlots);
        }

        public final SaleOnBoardCategory getSelectedCategory() {
            return this.selectedCategory;
        }

        public final List<SaleOnBoardTimeSlot> getTimeSlots() {
            return this.timeSlots;
        }

        public int hashCode() {
            int hashCode = ((Boolean.hashCode(this.isLoading) * 31) + Boolean.hashCode(this.isLoadingTimeSlots)) * 31;
            SaleOnBoardCategory saleOnBoardCategory = this.selectedCategory;
            return ((hashCode + (saleOnBoardCategory == null ? 0 : saleOnBoardCategory.hashCode())) * 31) + this.timeSlots.hashCode();
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* renamed from: isLoadingTimeSlots, reason: from getter */
        public final boolean getIsLoadingTimeSlots() {
            return this.isLoadingTimeSlots;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", isLoadingTimeSlots=" + this.isLoadingTimeSlots + ", selectedCategory=" + this.selectedCategory + ", timeSlots=" + this.timeSlots + ")";
        }

        public /* synthetic */ ViewState(boolean z5, boolean z6, SaleOnBoardCategory saleOnBoardCategory, List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? true : z5, (i5 & 2) != 0 ? true : z6, (i5 & 4) != 0 ? null : saleOnBoardCategory, (i5 & 8) != 0 ? CollectionsKt.emptyList() : list);
        }
    }
}
