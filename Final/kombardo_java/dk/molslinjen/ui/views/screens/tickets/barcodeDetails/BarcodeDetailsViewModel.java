package dk.molslinjen.ui.views.screens.tickets.barcodeDetails;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.ramcosta.composedestinations.generated.destinations.BarcodeDetailsScreenDestination;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.ui.views.reusable.barcode.BarcodeViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeDetailsScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeDetailsViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "onCleared", BuildConfig.FLAVOR, "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BarcodeDetailsViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final BarcodeDetailsScreenNavArgs navArgs;
    private final StateFlow<ViewState> viewState;

    public BarcodeDetailsViewModel(SavedStateHandle savedStateHandle) {
        ViewState value;
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        BarcodeDetailsScreenNavArgs argsFrom = BarcodeDetailsScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, null, null, null, 15, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        Logger.log$default(Logger.INSTANCE, "Barcode: " + argsFrom.getType() + ", text: " + argsFrom.getText(), null, 0, 6, null);
        do {
            value = MutableStateFlow.getValue();
        } while (!MutableStateFlow.compareAndSet(value, value.copy(this.navArgs.getBarcode(), this.navArgs.getText(), this.navArgs.getType(), this.navArgs.getValidity())));
        ScreenBrightnessHelper.INSTANCE.changeBrightness(true);
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

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ:\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeDetailsViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "barcode", "description", "Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;", "barcodeType", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;", "barcodeValidity", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;)V", "copy", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;)Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeDetailsViewModel$ViewState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBarcode", "getDescription", "Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;", "getBarcodeType", "()Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;", "getBarcodeValidity", "()Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final String barcode;
        private final BarcodeViewType barcodeType;
        private final BarcodeValidity barcodeValidity;
        private final String description;

        public ViewState(String barcode, String str, BarcodeViewType barcodeType, BarcodeValidity barcodeValidity) {
            Intrinsics.checkNotNullParameter(barcode, "barcode");
            Intrinsics.checkNotNullParameter(barcodeType, "barcodeType");
            Intrinsics.checkNotNullParameter(barcodeValidity, "barcodeValidity");
            this.barcode = barcode;
            this.description = str;
            this.barcodeType = barcodeType;
            this.barcodeValidity = barcodeValidity;
        }

        public final ViewState copy(String barcode, String description, BarcodeViewType barcodeType, BarcodeValidity barcodeValidity) {
            Intrinsics.checkNotNullParameter(barcode, "barcode");
            Intrinsics.checkNotNullParameter(barcodeType, "barcodeType");
            Intrinsics.checkNotNullParameter(barcodeValidity, "barcodeValidity");
            return new ViewState(barcode, description, barcodeType, barcodeValidity);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.barcode, viewState.barcode) && Intrinsics.areEqual(this.description, viewState.description) && this.barcodeType == viewState.barcodeType && this.barcodeValidity == viewState.barcodeValidity;
        }

        public final String getBarcode() {
            return this.barcode;
        }

        public final BarcodeViewType getBarcodeType() {
            return this.barcodeType;
        }

        public final BarcodeValidity getBarcodeValidity() {
            return this.barcodeValidity;
        }

        public final String getDescription() {
            return this.description;
        }

        public int hashCode() {
            int hashCode = this.barcode.hashCode() * 31;
            String str = this.description;
            return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.barcodeType.hashCode()) * 31) + this.barcodeValidity.hashCode();
        }

        public String toString() {
            return "ViewState(barcode=" + this.barcode + ", description=" + this.description + ", barcodeType=" + this.barcodeType + ", barcodeValidity=" + this.barcodeValidity + ")";
        }

        public /* synthetic */ ViewState(String str, String str2, BarcodeViewType barcodeViewType, BarcodeValidity barcodeValidity, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? BuildConfig.FLAVOR : str, (i5 & 2) != 0 ? null : str2, (i5 & 4) != 0 ? BarcodeViewType.CODE_128 : barcodeViewType, (i5 & 8) != 0 ? BarcodeValidity.Valid : barcodeValidity);
        }
    }
}
