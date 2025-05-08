package dk.molslinjen.ui.views.screens.tickets.barcodeDetails;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.ramcosta.composedestinations.generated.destinations.LoungeBarcodeDetailsScreenDestination;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/LoungeBarcodeDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/LoungeBarcodeDetailsScreenNavArgs;", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/LoungeBarcodeDetailsViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "onCleared", BuildConfig.FLAVOR, "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoungeBarcodeDetailsViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final LoungeBarcodeDetailsScreenNavArgs navArgs;
    private final StateFlow<ViewState> viewState;

    public LoungeBarcodeDetailsViewModel(SavedStateHandle savedStateHandle) {
        ViewState value;
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.navArgs = LoungeBarcodeDetailsScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, 0, null, 7, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        do {
            value = MutableStateFlow.getValue();
        } while (!MutableStateFlow.compareAndSet(value, value.copy(this.navArgs.getBarcode(), this.navArgs.getPersons(), this.navArgs.getDepartureTime())));
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

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/LoungeBarcodeDetailsViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "barcode", BuildConfig.FLAVOR, "numberOfPersons", "Lorg/threeten/bp/LocalDateTime;", "departureTime", "<init>", "(Ljava/lang/String;ILorg/threeten/bp/LocalDateTime;)V", "copy", "(Ljava/lang/String;ILorg/threeten/bp/LocalDateTime;)Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/LoungeBarcodeDetailsViewModel$ViewState;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBarcode", "I", "getNumberOfPersons", "Lorg/threeten/bp/LocalDateTime;", "getDepartureTime", "()Lorg/threeten/bp/LocalDateTime;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final String barcode;
        private final LocalDateTime departureTime;
        private final int numberOfPersons;

        public ViewState(String barcode, int i5, LocalDateTime localDateTime) {
            Intrinsics.checkNotNullParameter(barcode, "barcode");
            this.barcode = barcode;
            this.numberOfPersons = i5;
            this.departureTime = localDateTime;
        }

        public final ViewState copy(String barcode, int numberOfPersons, LocalDateTime departureTime) {
            Intrinsics.checkNotNullParameter(barcode, "barcode");
            return new ViewState(barcode, numberOfPersons, departureTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.barcode, viewState.barcode) && this.numberOfPersons == viewState.numberOfPersons && Intrinsics.areEqual(this.departureTime, viewState.departureTime);
        }

        public final String getBarcode() {
            return this.barcode;
        }

        public final LocalDateTime getDepartureTime() {
            return this.departureTime;
        }

        public final int getNumberOfPersons() {
            return this.numberOfPersons;
        }

        public int hashCode() {
            int hashCode = ((this.barcode.hashCode() * 31) + Integer.hashCode(this.numberOfPersons)) * 31;
            LocalDateTime localDateTime = this.departureTime;
            return hashCode + (localDateTime == null ? 0 : localDateTime.hashCode());
        }

        public String toString() {
            return "ViewState(barcode=" + this.barcode + ", numberOfPersons=" + this.numberOfPersons + ", departureTime=" + this.departureTime + ")";
        }

        public /* synthetic */ ViewState(String str, int i5, LocalDateTime localDateTime, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? BuildConfig.FLAVOR : str, (i6 & 2) != 0 ? 1 : i5, (i6 & 4) != 0 ? null : localDateTime);
        }
    }
}
