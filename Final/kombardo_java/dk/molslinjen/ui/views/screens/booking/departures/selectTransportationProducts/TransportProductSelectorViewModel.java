package dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.product.Product;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002)*B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J&\u0010!\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bH\u0002J\u0014\u0010#\u001a\u00020\u00192\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190%J\u000e\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006+"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportationProducts/TransportProductSelectorViewModel;", "Landroidx/lifecycle/ViewModel;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "returnManager", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "<init>", "(Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/domain/managers/checkout/IReturnManager;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportationProducts/TransportProductSelectorViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "_outboundProductsState", "Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportationProducts/TransportProductSelectorViewModel$TransportProductsState;", "outboundProductsState", "getOutboundProductsState", "_returnProductsState", "returnProductsState", "getReturnProductsState", "load", BuildConfig.FLAVOR, "changeQuantity", "quantity", BuildConfig.FLAVOR, "product", "Ldk/molslinjen/domain/model/booking/product/Product;", "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "updateProductQuantity", "state", "saveAndClose", "proceed", "Lkotlin/Function0;", "onChangedSameForBothDirections", "sameForBothDirections", BuildConfig.FLAVOR, "TransportProductsState", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransportProductSelectorViewModel extends ViewModel {
    private final MutableStateFlow<TransportProductsState> _outboundProductsState;
    private final MutableStateFlow<TransportProductsState> _returnProductsState;
    private final MutableStateFlow<ViewState> _viewState;
    private final StateFlow<TransportProductsState> outboundProductsState;
    private final IReturnManager returnManager;
    private final StateFlow<TransportProductsState> returnProductsState;
    private final IRouteManager routeManager;
    private final ISnackbarService snackbarService;
    private final StateFlow<ViewState> viewState;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DepartureDirection.values().length];
            try {
                iArr[DepartureDirection.Outbound.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DepartureDirection.Return.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransportProductSelectorViewModel(IRouteManager routeManager, ISnackbarService snackbarService, IReturnManager returnManager) {
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(returnManager, "returnManager");
        this.routeManager = routeManager;
        this.snackbarService = snackbarService;
        this.returnManager = returnManager;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, false, false, false, 15, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        int i5 = 1;
        MutableStateFlow<TransportProductsState> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new TransportProductsState(null, i5, 0 == true ? 1 : 0));
        this._outboundProductsState = MutableStateFlow2;
        this.outboundProductsState = MutableStateFlow2;
        MutableStateFlow<TransportProductsState> MutableStateFlow3 = StateFlowKt.MutableStateFlow(new TransportProductsState(0 == true ? 1 : 0, i5, 0 == true ? 1 : 0));
        this._returnProductsState = MutableStateFlow3;
        this.returnProductsState = MutableStateFlow3;
        load();
    }

    private final void load() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TransportProductSelectorViewModel$load$1(this, null), 3, null);
    }

    private final void updateProductQuantity(Product product, int quantity, MutableStateFlow<TransportProductsState> state) {
        TransportProductsState value;
        TransportProductsState transportProductsState;
        List<? extends Product> mutableList;
        do {
            value = state.getValue();
            transportProductsState = value;
            mutableList = CollectionsKt.toMutableList((Collection) transportProductsState.getProducts());
            Iterator<? extends Product> it = mutableList.iterator();
            int i5 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i5 = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().getId(), product.getId())) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 != -1) {
                mutableList.set(i5, product.copyQuantity(quantity));
            }
        } while (!state.compareAndSet(value, transportProductsState.copy(mutableList)));
    }

    public final void changeQuantity(int quantity, Product product, DepartureDirection departureDirection) {
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        int i5 = WhenMappings.$EnumSwitchMapping$0[departureDirection.ordinal()];
        if (i5 == 1) {
            updateProductQuantity(product, quantity, this._outboundProductsState);
        } else {
            if (i5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            updateProductQuantity(product, quantity, this._returnProductsState);
        }
    }

    public final StateFlow<TransportProductsState> getOutboundProductsState() {
        return this.outboundProductsState;
    }

    public final StateFlow<TransportProductsState> getReturnProductsState() {
        return this.returnProductsState;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void onChangedSameForBothDirections(boolean sameForBothDirections) {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, sameForBothDirections, false, false, 13, null)));
        if (sameForBothDirections) {
            return;
        }
        MutableStateFlow<TransportProductsState> mutableStateFlow2 = this._returnProductsState;
        do {
        } while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), this.outboundProductsState.getValue()));
    }

    public final void saveAndClose(Function0<Unit> proceed) {
        List<? extends Product> arrayList;
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        List<Product> products = this.outboundProductsState.getValue().getProducts();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : products) {
            if (((Product) obj).getQuantity() > 0) {
                arrayList2.add(obj);
            }
        }
        if (this.viewState.getValue().getSameForBothDirections()) {
            arrayList = arrayList2;
        } else {
            List<Product> products2 = this.returnProductsState.getValue().getProducts();
            arrayList = new ArrayList<>();
            for (Object obj2 : products2) {
                if (((Product) obj2).getQuantity() > 0) {
                    arrayList.add(obj2);
                }
            }
        }
        IRouteManager iRouteManager = this.routeManager;
        if (this.viewState.getValue().getBookingType() != BookingType.TwoWay) {
            arrayList = CollectionsKt.emptyList();
        }
        iRouteManager.setTransportProducts(arrayList2, arrayList, this.returnManager.getReturnState().getValue().getIsAddingReturnFromBookingSummary());
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TransportProductSelectorViewModel$saveAndClose$1(proceed, null), 3, null);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportationProducts/TransportProductSelectorViewModel$TransportProductsState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/Product;", "products", "<init>", "(Ljava/util/List;)V", "copy", "(Ljava/util/List;)Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportationProducts/TransportProductSelectorViewModel$TransportProductsState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getProducts", "()Ljava/util/List;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class TransportProductsState {
        private final List<Product> products;

        /* JADX WARN: Multi-variable type inference failed */
        public TransportProductsState(List<? extends Product> products) {
            Intrinsics.checkNotNullParameter(products, "products");
            this.products = products;
        }

        public final TransportProductsState copy(List<? extends Product> products) {
            Intrinsics.checkNotNullParameter(products, "products");
            return new TransportProductsState(products);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TransportProductsState) && Intrinsics.areEqual(this.products, ((TransportProductsState) other).products);
        }

        public final List<Product> getProducts() {
            return this.products;
        }

        public int hashCode() {
            return this.products.hashCode();
        }

        public String toString() {
            return "TransportProductsState(products=" + this.products + ")";
        }

        public /* synthetic */ TransportProductsState(List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? CollectionsKt.emptyList() : list);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ8\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0006\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0007\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportationProducts/TransportProductSelectorViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", BuildConfig.FLAVOR, "sameForBothDirections", "isEditing", "isAddingReturnFromBookingSummary", "<init>", "(Ldk/molslinjen/domain/model/booking/BookingType;ZZZ)V", "copy", "(Ldk/molslinjen/domain/model/booking/BookingType;ZZZ)Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportationProducts/TransportProductSelectorViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/booking/BookingType;", "getBookingType", "()Ldk/molslinjen/domain/model/booking/BookingType;", "Z", "getSameForBothDirections", "()Z", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final BookingType bookingType;
        private final boolean isAddingReturnFromBookingSummary;
        private final boolean isEditing;
        private final boolean sameForBothDirections;

        public ViewState(BookingType bookingType, boolean z5, boolean z6, boolean z7) {
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            this.bookingType = bookingType;
            this.sameForBothDirections = z5;
            this.isEditing = z6;
            this.isAddingReturnFromBookingSummary = z7;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, BookingType bookingType, boolean z5, boolean z6, boolean z7, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                bookingType = viewState.bookingType;
            }
            if ((i5 & 2) != 0) {
                z5 = viewState.sameForBothDirections;
            }
            if ((i5 & 4) != 0) {
                z6 = viewState.isEditing;
            }
            if ((i5 & 8) != 0) {
                z7 = viewState.isAddingReturnFromBookingSummary;
            }
            return viewState.copy(bookingType, z5, z6, z7);
        }

        public final ViewState copy(BookingType bookingType, boolean sameForBothDirections, boolean isEditing, boolean isAddingReturnFromBookingSummary) {
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            return new ViewState(bookingType, sameForBothDirections, isEditing, isAddingReturnFromBookingSummary);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.bookingType == viewState.bookingType && this.sameForBothDirections == viewState.sameForBothDirections && this.isEditing == viewState.isEditing && this.isAddingReturnFromBookingSummary == viewState.isAddingReturnFromBookingSummary;
        }

        public final BookingType getBookingType() {
            return this.bookingType;
        }

        public final boolean getSameForBothDirections() {
            return this.sameForBothDirections;
        }

        public int hashCode() {
            return (((((this.bookingType.hashCode() * 31) + Boolean.hashCode(this.sameForBothDirections)) * 31) + Boolean.hashCode(this.isEditing)) * 31) + Boolean.hashCode(this.isAddingReturnFromBookingSummary);
        }

        /* renamed from: isAddingReturnFromBookingSummary, reason: from getter */
        public final boolean getIsAddingReturnFromBookingSummary() {
            return this.isAddingReturnFromBookingSummary;
        }

        /* renamed from: isEditing, reason: from getter */
        public final boolean getIsEditing() {
            return this.isEditing;
        }

        public String toString() {
            return "ViewState(bookingType=" + this.bookingType + ", sameForBothDirections=" + this.sameForBothDirections + ", isEditing=" + this.isEditing + ", isAddingReturnFromBookingSummary=" + this.isAddingReturnFromBookingSummary + ")";
        }

        public /* synthetic */ ViewState(BookingType bookingType, boolean z5, boolean z6, boolean z7, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? BookingType.Single : bookingType, (i5 & 2) != 0 ? true : z5, (i5 & 4) != 0 ? false : z6, (i5 & 8) != 0 ? false : z7);
        }
    }
}
