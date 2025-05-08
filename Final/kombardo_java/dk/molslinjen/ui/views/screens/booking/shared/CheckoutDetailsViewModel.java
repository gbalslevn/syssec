package dk.molslinjen.ui.views.screens.booking.shared;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.ramcosta.composedestinations.generated.destinations.CheckoutDetailsScreenDestination;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutManager;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.TicketSection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000e¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/shared/CheckoutDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "checkoutManager", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;Landroidx/lifecycle/SavedStateHandle;)V", "navArgs", "Ldk/molslinjen/ui/views/screens/booking/shared/CheckoutDetailsScreenNavArgs;", "checkoutState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "getCheckoutState", "()Lkotlinx/coroutines/flow/StateFlow;", "outboundCheckoutState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;", "getOutboundCheckoutState", "returnCheckoutState", "getReturnCheckoutState", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/shared/CheckoutDetailsViewModel$ViewState;", "viewState", "getViewState", "changedSelectedDirection", BuildConfig.FLAVOR, "direction", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckoutDetailsViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final StateFlow<CheckoutManager.CheckoutState> checkoutState;
    private final CheckoutDetailsScreenNavArgs navArgs;
    private final StateFlow<CheckoutManager.CheckoutDirectionState> outboundCheckoutState;
    private final StateFlow<CheckoutManager.CheckoutDirectionState> returnCheckoutState;

    /* JADX WARN: Multi-variable type inference failed */
    public CheckoutDetailsViewModel(ICheckoutManager checkoutManager, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        CheckoutDetailsScreenNavArgs argsFrom = CheckoutDetailsScreenDestination.INSTANCE.argsFrom(savedStateHandle);
        this.navArgs = argsFrom;
        this.checkoutState = checkoutManager.getCheckoutState();
        this.outboundCheckoutState = checkoutManager.getOutboundDirectionState();
        this.returnCheckoutState = checkoutManager.getReturnDirectionState();
        this._viewState = StateFlowKt.MutableStateFlow(new ViewState(argsFrom.getSection(), null, 2, 0 == true ? 1 : 0));
    }

    public final void changedSelectedDirection(DepartureDirection direction) {
        ViewState value;
        Intrinsics.checkNotNullParameter(direction, "direction");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, direction, 1, null)));
    }

    public final StateFlow<CheckoutManager.CheckoutState> getCheckoutState() {
        return this.checkoutState;
    }

    public final StateFlow<CheckoutManager.CheckoutDirectionState> getOutboundCheckoutState() {
        return this.outboundCheckoutState;
    }

    public final StateFlow<CheckoutManager.CheckoutDirectionState> getReturnCheckoutState() {
        return this.returnCheckoutState;
    }

    public final StateFlow<ViewState> getViewState() {
        return this._viewState;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/shared/CheckoutDetailsViewModel$ViewState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/TicketSection;", "ticketSection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "selectedDirection", "<init>", "(Ldk/molslinjen/domain/model/booking/TicketSection;Ldk/molslinjen/domain/model/booking/DepartureDirection;)V", "copy", "(Ldk/molslinjen/domain/model/booking/TicketSection;Ldk/molslinjen/domain/model/booking/DepartureDirection;)Ldk/molslinjen/ui/views/screens/booking/shared/CheckoutDetailsViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/booking/TicketSection;", "getTicketSection", "()Ldk/molslinjen/domain/model/booking/TicketSection;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getSelectedDirection", "()Ldk/molslinjen/domain/model/booking/DepartureDirection;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final DepartureDirection selectedDirection;
        private final TicketSection ticketSection;

        public ViewState(TicketSection ticketSection, DepartureDirection selectedDirection) {
            Intrinsics.checkNotNullParameter(ticketSection, "ticketSection");
            Intrinsics.checkNotNullParameter(selectedDirection, "selectedDirection");
            this.ticketSection = ticketSection;
            this.selectedDirection = selectedDirection;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, TicketSection ticketSection, DepartureDirection departureDirection, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                ticketSection = viewState.ticketSection;
            }
            if ((i5 & 2) != 0) {
                departureDirection = viewState.selectedDirection;
            }
            return viewState.copy(ticketSection, departureDirection);
        }

        public final ViewState copy(TicketSection ticketSection, DepartureDirection selectedDirection) {
            Intrinsics.checkNotNullParameter(ticketSection, "ticketSection");
            Intrinsics.checkNotNullParameter(selectedDirection, "selectedDirection");
            return new ViewState(ticketSection, selectedDirection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.ticketSection == viewState.ticketSection && this.selectedDirection == viewState.selectedDirection;
        }

        public final DepartureDirection getSelectedDirection() {
            return this.selectedDirection;
        }

        public final TicketSection getTicketSection() {
            return this.ticketSection;
        }

        public int hashCode() {
            return (this.ticketSection.hashCode() * 31) + this.selectedDirection.hashCode();
        }

        public String toString() {
            return "ViewState(ticketSection=" + this.ticketSection + ", selectedDirection=" + this.selectedDirection + ")";
        }

        public /* synthetic */ ViewState(TicketSection ticketSection, DepartureDirection departureDirection, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(ticketSection, (i5 & 2) != 0 ? DepartureDirection.Outbound : departureDirection);
        }
    }
}
