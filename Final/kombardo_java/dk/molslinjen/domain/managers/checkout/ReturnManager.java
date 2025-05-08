package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.departure.IDepartureManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/ReturnManager;", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "departureManager", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "checkoutManager", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/departure/IDepartureManager;Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "returnState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/checkout/ReturnManager$ReturnState;", "getReturnState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "startAddingReturnFromBookingSummary", BuildConfig.FLAVOR, "stopAddingReturnFromBookingSummary", "clear", "ReturnState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ReturnManager implements IReturnManager {
    private final IAnalyticsTracker analyticsTracker;
    private final ICheckoutManager checkoutManager;
    private final IDepartureManager departureManager;
    private final MutableStateFlow<ReturnState> returnState;
    private final IRouteManager routeManager;

    public ReturnManager(IRouteManager routeManager, IDepartureManager departureManager, ICheckoutManager checkoutManager, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(departureManager, "departureManager");
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.routeManager = routeManager;
        this.departureManager = departureManager;
        this.checkoutManager = checkoutManager;
        this.analyticsTracker = analyticsTracker;
        this.returnState = StateFlowKt.MutableStateFlow(new ReturnState(false, 1, null));
    }

    @Override // dk.molslinjen.domain.managers.checkout.IReturnManager
    public void clear() {
        MutableStateFlow<ReturnState> returnState = getReturnState();
        do {
        } while (!returnState.compareAndSet(returnState.getValue(), new ReturnState(false, 1, null)));
    }

    @Override // dk.molslinjen.domain.managers.checkout.IReturnManager
    public void startAddingReturnFromBookingSummary() {
        ReturnState value;
        MutableStateFlow<ReturnState> returnState = getReturnState();
        do {
            value = returnState.getValue();
        } while (!returnState.compareAndSet(value, value.copy(true)));
        IRouteManager iRouteManager = this.routeManager;
        BookingType bookingType = BookingType.TwoWay;
        Departure selectedDeparture = this.departureManager.getOutboundState().getValue().getSelectedDeparture();
        iRouteManager.updateBookingType(bookingType, selectedDeparture != null ? selectedDeparture.getDate() : null);
        IRouteManager iRouteManager2 = this.routeManager;
        DepartureDirection departureDirection = DepartureDirection.Return;
        Departure selectedDeparture2 = this.departureManager.getOutboundState().getValue().getSelectedDeparture();
        iRouteManager2.updateDepartureDirection(departureDirection, selectedDeparture2 != null ? selectedDeparture2.getDate() : null);
        this.analyticsTracker.trackEvent(AnalyticsEvent.StartAddReturnTripFromSummaryEvent.INSTANCE);
    }

    @Override // dk.molslinjen.domain.managers.checkout.IReturnManager
    public void stopAddingReturnFromBookingSummary() {
        ReturnState value;
        MutableStateFlow<ReturnState> returnState = getReturnState();
        do {
            value = returnState.getValue();
        } while (!returnState.compareAndSet(value, value.copy(false)));
        this.routeManager.updateBookingType(BookingType.Single, null);
        this.checkoutManager.clearReturnState();
        this.analyticsTracker.trackEvent(AnalyticsEvent.StopAddingReturnTripEvent.INSTANCE);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0003\u0010\u0012¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/ReturnManager$ReturnState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isAddingReturnFromBookingSummary", "<init>", "(Z)V", "copy", "(Z)Ldk/molslinjen/domain/managers/checkout/ReturnManager$ReturnState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ReturnState {
        private final boolean isAddingReturnFromBookingSummary;

        public ReturnState(boolean z5) {
            this.isAddingReturnFromBookingSummary = z5;
        }

        public final ReturnState copy(boolean isAddingReturnFromBookingSummary) {
            return new ReturnState(isAddingReturnFromBookingSummary);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ReturnState) && this.isAddingReturnFromBookingSummary == ((ReturnState) other).isAddingReturnFromBookingSummary;
        }

        public int hashCode() {
            return Boolean.hashCode(this.isAddingReturnFromBookingSummary);
        }

        /* renamed from: isAddingReturnFromBookingSummary, reason: from getter */
        public final boolean getIsAddingReturnFromBookingSummary() {
            return this.isAddingReturnFromBookingSummary;
        }

        public String toString() {
            return "ReturnState(isAddingReturnFromBookingSummary=" + this.isAddingReturnFromBookingSummary + ")";
        }

        public /* synthetic */ ReturnState(boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? false : z5);
        }
    }

    @Override // dk.molslinjen.domain.managers.checkout.IReturnManager
    public MutableStateFlow<ReturnState> getReturnState() {
        return this.returnState;
    }
}
