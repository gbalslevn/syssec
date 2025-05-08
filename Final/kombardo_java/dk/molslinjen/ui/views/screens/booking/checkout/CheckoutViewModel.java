package dk.molslinjen.ui.views.screens.booking.checkout;

import androidx.lifecycle.ViewModel;
import com.ramcosta.composedestinations.generated.destinations.AddonsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.BookingSummaryScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.FoodScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PassengersScreenDestination;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import dk.molslinjen.core.navigation.ICheckoutNavigator;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.AnalyticsTracker;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.checkout.ReturnManager;
import dk.molslinjen.domain.managers.splitTest.ISplitTestManager;
import dk.molslinjen.domain.model.booking.TicketSection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001#B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u001b2\u000e\u0010\u001d\u001a\n\u0012\u0002\b\u00030\u001ej\u0002`\u001fJ\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006$"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/checkout/CheckoutViewModel;", "Landroidx/lifecycle/ViewModel;", "checkoutNavigator", "Ldk/molslinjen/core/navigation/ICheckoutNavigator;", "returnManager", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "splitTestManager", "Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/AnalyticsTracker;", "<init>", "(Ldk/molslinjen/core/navigation/ICheckoutNavigator;Ldk/molslinjen/domain/managers/checkout/IReturnManager;Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;Ldk/molslinjen/domain/analytics/AnalyticsTracker;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/booking/checkout/CheckoutViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "showClickableTopBar", BuildConfig.FLAVOR, "getShowClickableTopBar", "()Z", "returnState", "Ldk/molslinjen/domain/managers/checkout/ReturnManager$ReturnState;", "getReturnState", "setup", BuildConfig.FLAVOR, "updateCurrentSection", "destination", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;", "trackNavigatingBackToSection", "section", "Ldk/molslinjen/domain/model/booking/TicketSection;", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckoutViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final AnalyticsTracker analyticsTracker;
    private final ICheckoutNavigator checkoutNavigator;
    private final StateFlow<ReturnManager.ReturnState> returnState;
    private final boolean showClickableTopBar;
    private final StateFlow<ViewState> viewState;

    /* JADX WARN: Multi-variable type inference failed */
    public CheckoutViewModel(ICheckoutNavigator checkoutNavigator, IReturnManager returnManager, ISplitTestManager splitTestManager, AnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(checkoutNavigator, "checkoutNavigator");
        Intrinsics.checkNotNullParameter(returnManager, "returnManager");
        Intrinsics.checkNotNullParameter(splitTestManager, "splitTestManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.checkoutNavigator = checkoutNavigator;
        this.analyticsTracker = analyticsTracker;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        this.showClickableTopBar = splitTestManager.getEnableNavigateProgressBar();
        this.returnState = returnManager.getReturnState();
    }

    public final StateFlow<ReturnManager.ReturnState> getReturnState() {
        return this.returnState;
    }

    public final boolean getShowClickableTopBar() {
        return this.showClickableTopBar;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void setup() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, this.checkoutNavigator.sections(), null, 2, null)));
    }

    public final void trackNavigatingBackToSection(TicketSection section) {
        Intrinsics.checkNotNullParameter(section, "section");
        this.analyticsTracker.trackEvent(new AnalyticsEvent.NavigatedBackThroughCheckoutTopBar(section));
    }

    public final void updateCurrentSection(TypedDestinationSpec<?> destination) {
        TicketSection ticketSection;
        ViewState value;
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (Intrinsics.areEqual(destination, PassengersScreenDestination.INSTANCE)) {
            ticketSection = TicketSection.Passenger;
        } else if (Intrinsics.areEqual(destination, AddonsScreenDestination.INSTANCE)) {
            ticketSection = TicketSection.Addons;
        } else if (Intrinsics.areEqual(destination, FoodScreenDestination.INSTANCE)) {
            ticketSection = TicketSection.Food;
        } else if (Intrinsics.areEqual(destination, BookingSummaryScreenDestination.INSTANCE)) {
            ticketSection = TicketSection.Summary;
        } else {
            ticketSection = (TicketSection) CollectionsKt.firstOrNull((List) this.viewState.getValue().getCheckoutSections());
            if (ticketSection == null) {
                return;
            }
        }
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, null, ticketSection, 1, null)));
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/checkout/CheckoutViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/TicketSection;", "checkoutSections", "activeSection", "<init>", "(Ljava/util/List;Ldk/molslinjen/domain/model/booking/TicketSection;)V", "copy", "(Ljava/util/List;Ldk/molslinjen/domain/model/booking/TicketSection;)Ldk/molslinjen/ui/views/screens/booking/checkout/CheckoutViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getCheckoutSections", "()Ljava/util/List;", "Ldk/molslinjen/domain/model/booking/TicketSection;", "getActiveSection", "()Ldk/molslinjen/domain/model/booking/TicketSection;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final TicketSection activeSection;
        private final List<TicketSection> checkoutSections;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(List<? extends TicketSection> checkoutSections, TicketSection activeSection) {
            Intrinsics.checkNotNullParameter(checkoutSections, "checkoutSections");
            Intrinsics.checkNotNullParameter(activeSection, "activeSection");
            this.checkoutSections = checkoutSections;
            this.activeSection = activeSection;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, TicketSection ticketSection, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                list = viewState.checkoutSections;
            }
            if ((i5 & 2) != 0) {
                ticketSection = viewState.activeSection;
            }
            return viewState.copy(list, ticketSection);
        }

        public final ViewState copy(List<? extends TicketSection> checkoutSections, TicketSection activeSection) {
            Intrinsics.checkNotNullParameter(checkoutSections, "checkoutSections");
            Intrinsics.checkNotNullParameter(activeSection, "activeSection");
            return new ViewState(checkoutSections, activeSection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics.areEqual(this.checkoutSections, viewState.checkoutSections) && this.activeSection == viewState.activeSection;
        }

        public final TicketSection getActiveSection() {
            return this.activeSection;
        }

        public final List<TicketSection> getCheckoutSections() {
            return this.checkoutSections;
        }

        public int hashCode() {
            return (this.checkoutSections.hashCode() * 31) + this.activeSection.hashCode();
        }

        public String toString() {
            return "ViewState(checkoutSections=" + this.checkoutSections + ", activeSection=" + this.activeSection + ")";
        }

        public /* synthetic */ ViewState(List list, TicketSection ticketSection, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? CollectionsKt.emptyList() : list, (i5 & 2) != 0 ? TicketSection.Passenger : ticketSection);
        }
    }
}
