package dk.molslinjen.ui.views.screens.booking.shared.expiration;

import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.departure.IDepartureManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.constants.Constants;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.chrono.ChronoLocalDate;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006 "}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/shared/expiration/ExpirableCheckoutHandler;", "Ldk/molslinjen/ui/views/screens/booking/shared/expiration/IExpirableCheckout;", "routeManager", "Ldk/molslinjen/domain/managers/route/IRouteManager;", "departureManager", "Ldk/molslinjen/domain/managers/departure/IDepartureManager;", "editManager", "Ldk/molslinjen/domain/managers/checkout/IEditManager;", "returnManager", "Ldk/molslinjen/domain/managers/checkout/IReturnManager;", "paymentManager", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "minExpirationTime", "Lorg/threeten/bp/Duration;", "enabled", BuildConfig.FLAVOR, "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "<init>", "(Ldk/molslinjen/domain/managers/route/IRouteManager;Ldk/molslinjen/domain/managers/departure/IDepartureManager;Ldk/molslinjen/domain/managers/checkout/IEditManager;Ldk/molslinjen/domain/managers/checkout/IReturnManager;Ldk/molslinjen/domain/managers/checkout/IPaymentManager;Lorg/threeten/bp/Duration;ZLdk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "expirableHandlerStarted", "Lorg/threeten/bp/LocalDateTime;", "kotlin.jvm.PlatformType", "Lorg/threeten/bp/LocalDateTime;", "isExpired", "resetCheckoutAfterExpiredDepartures", BuildConfig.FLAVOR, "isEditing", "isMultiRide", "isCommuter", "showReloadDialog", "isInCheckoutFlow", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExpirableCheckoutHandler implements IExpirableCheckout {
    private final IAnalyticsTracker analyticsTracker;
    private final IDepartureManager departureManager;
    private final IEditManager editManager;
    private final boolean enabled;
    private LocalDateTime expirableHandlerStarted;
    private final Duration minExpirationTime;
    private final IPaymentManager paymentManager;
    private final IReturnManager returnManager;
    private final IRouteManager routeManager;

    public ExpirableCheckoutHandler(IRouteManager routeManager, IDepartureManager departureManager, IEditManager editManager, IReturnManager returnManager, IPaymentManager paymentManager, Duration duration, boolean z5, IAnalyticsTracker analyticsTracker) {
        Intrinsics.checkNotNullParameter(routeManager, "routeManager");
        Intrinsics.checkNotNullParameter(departureManager, "departureManager");
        Intrinsics.checkNotNullParameter(editManager, "editManager");
        Intrinsics.checkNotNullParameter(returnManager, "returnManager");
        Intrinsics.checkNotNullParameter(paymentManager, "paymentManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.routeManager = routeManager;
        this.departureManager = departureManager;
        this.editManager = editManager;
        this.returnManager = returnManager;
        this.paymentManager = paymentManager;
        this.minExpirationTime = duration;
        this.enabled = z5;
        this.analyticsTracker = analyticsTracker;
        this.expirableHandlerStarted = LocalDateTime.now();
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean isCommuter() {
        RouteSharedSelectedState value = this.routeManager.getSharedSelectedState().getValue();
        return (value != null ? value.getCommuterBookingData() : null) != null;
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean isEditing() {
        return this.editManager.getEditState().getValue().getEditingReservationNumber() != null;
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean isExpired() {
        LocalDateTime startedLoadingTime;
        LocalDateTime plus;
        if (this.paymentManager.getPaymentState().getValue().getPaymentCallbackReceived() || !this.enabled || (startedLoadingTime = this.departureManager.getOutboundState().getValue().getStartedLoadingTime()) == null || (plus = startedLoadingTime.plus(Constants.Data.INSTANCE.getDeparturesExpirationTime())) == null) {
            return false;
        }
        Duration duration = this.minExpirationTime;
        if (duration == null) {
            return plus.isBefore(LocalDateTime.now());
        }
        LocalDateTime plus2 = this.expirableHandlerStarted.plus(duration);
        Intrinsics.checkNotNull(plus2);
        return ((LocalDateTime) ComparisonsKt.maxOf(plus, plus2)).isBefore(LocalDateTime.now());
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean isInCheckoutFlow() {
        return this.departureManager.getOutboundState().getValue().getSelectedDeparture() != null && (this.routeManager.getBookingTypeState().getValue() == BookingType.Single || this.departureManager.getReturnState().getValue().getSelectedDeparture() != null || this.returnManager.getReturnState().getValue().getIsAddingReturnFromBookingSummary());
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean isMultiRide() {
        RouteSharedSelectedState value = this.routeManager.getSharedSelectedState().getValue();
        return (value != null ? value.getMultiRideBookingData() : null) != null;
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public void resetCheckoutAfterExpiredDepartures() {
        this.analyticsTracker.trackEvent(AnalyticsEvent.TimeoutEvent.INSTANCE);
        RouteSelectedState value = this.routeManager.getOutboundSelectedState().getValue();
        LocalDate selectedStartDate = value != null ? value.getSelectedStartDate() : null;
        if (selectedStartDate == null || selectedStartDate.compareTo((ChronoLocalDate) LocalDate.now()) < 0) {
            IRouteManager iRouteManager = this.routeManager;
            LocalDate now = LocalDate.now();
            Intrinsics.checkNotNullExpressionValue(now, "now(...)");
            iRouteManager.dateSelected(now);
        }
        IRouteManager iRouteManager2 = this.routeManager;
        DepartureDirection departureDirection = DepartureDirection.Outbound;
        iRouteManager2.updateDepartureDirection(departureDirection, null);
        this.returnManager.stopAddingReturnFromBookingSummary();
        this.departureManager.clear();
        this.departureManager.reloadDepartures(departureDirection);
    }

    @Override // dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout
    public boolean showReloadDialog() {
        return this.departureManager.getOutboundState().getValue().getSelectedDeparture() != null;
    }

    public /* synthetic */ ExpirableCheckoutHandler(IRouteManager iRouteManager, IDepartureManager iDepartureManager, IEditManager iEditManager, IReturnManager iReturnManager, IPaymentManager iPaymentManager, Duration duration, boolean z5, IAnalyticsTracker iAnalyticsTracker, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(iRouteManager, iDepartureManager, iEditManager, iReturnManager, iPaymentManager, (i5 & 32) != 0 ? null : duration, (i5 & 64) != 0 ? true : z5, iAnalyticsTracker);
    }
}
