package dk.molslinjen.ui.views.screens.tickets.barcodeDetails;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.ramcosta.composedestinations.generated.destinations.FoodBarcodeDetailsScreenDestination;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.LineItem;
import dk.molslinjen.domain.model.booking.ProductType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/FoodBarcodeDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "ticketsManager", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Ldk/molslinjen/domain/managers/ticket/ITicketsManager;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/FoodBarcodeDetailsScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/FoodBarcodeDetailsViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "onCleared", BuildConfig.FLAVOR, "loadData", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FoodBarcodeDetailsViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final FoodBarcodeDetailsScreenNavArgs navArgs;
    private final ITicketsManager ticketsManager;
    private final StateFlow<ViewState> viewState;

    /* JADX WARN: Multi-variable type inference failed */
    public FoodBarcodeDetailsViewModel(SavedStateHandle savedStateHandle, ITicketsManager ticketsManager) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(ticketsManager, "ticketsManager");
        this.ticketsManager = ticketsManager;
        this.navArgs = FoodBarcodeDetailsScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        loadData();
        ScreenBrightnessHelper.INSTANCE.changeBrightness(true);
    }

    private final void loadData() {
        ViewState value;
        Booking lastActiveBooking = this.ticketsManager.getTicketsState().getValue().getLastActiveBooking();
        if (lastActiveBooking == null) {
            return;
        }
        List<LineItem> products = lastActiveBooking.getTicket().getProducts();
        ArrayList arrayList = new ArrayList();
        for (Object obj : products) {
            if (((LineItem) obj).getProductType() == ProductType.Catering) {
                arrayList.add(obj);
            }
        }
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, value.copy(this.navArgs.getBarcode(), arrayList)));
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

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/FoodBarcodeDetailsViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "barcode", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/LineItem;", "lineItems", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "copy", "(Ljava/lang/String;Ljava/util/List;)Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/FoodBarcodeDetailsViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBarcode", "Ljava/util/List;", "getLineItems", "()Ljava/util/List;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final String barcode;
        private final List<LineItem> lineItems;

        public ViewState(String barcode, List<LineItem> lineItems) {
            Intrinsics.checkNotNullParameter(barcode, "barcode");
            Intrinsics.checkNotNullParameter(lineItems, "lineItems");
            this.barcode = barcode;
            this.lineItems = lineItems;
        }

        public final ViewState copy(String barcode, List<LineItem> lineItems) {
            Intrinsics.checkNotNullParameter(barcode, "barcode");
            Intrinsics.checkNotNullParameter(lineItems, "lineItems");
            return new ViewState(barcode, lineItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.barcode, viewState.barcode) && Intrinsics.areEqual(this.lineItems, viewState.lineItems);
        }

        public final String getBarcode() {
            return this.barcode;
        }

        public final List<LineItem> getLineItems() {
            return this.lineItems;
        }

        public int hashCode() {
            return (this.barcode.hashCode() * 31) + this.lineItems.hashCode();
        }

        public String toString() {
            return "ViewState(barcode=" + this.barcode + ", lineItems=" + this.lineItems + ")";
        }

        public /* synthetic */ ViewState(String str, List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? BuildConfig.FLAVOR : str, (i5 & 2) != 0 ? CollectionsKt.emptyList() : list);
        }
    }
}
