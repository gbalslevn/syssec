package dk.molslinjen.domain.analytics;

import dk.molslinjen.domain.analytics.AnalyticsStateTrackingHelper;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutManager;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.domain.providers.IPushHandlerProvider;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&JB\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&JJ\u0010\u001a\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J@\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H&J \u0010*\u001a\u00020\u00032\u0006\u0010(\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020%H&J\u0018\u0010/\u001a\u00020\u00032\u0006\u0010(\u001a\u0002002\u0006\u00101\u001a\u000202H&J\u0010\u0010/\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H&J\u0010\u0010/\u001a\u00020\u00032\u0006\u0010(\u001a\u00020+H&J\u0018\u00103\u001a\u00020\u00032\u0006\u0010(\u001a\u0002002\u0006\u00101\u001a\u000202H&J\u0010\u00103\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H&J\u0018\u00103\u001a\u00020\u00032\u0006\u0010(\u001a\u00020+2\u0006\u00104\u001a\u000205H&J\b\u00106\u001a\u00020\u0003H&J\u001a\u00107\u001a\u00020\u00032\u0006\u00101\u001a\u0002022\b\u00108\u001a\u0004\u0018\u000109H&J\u0010\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\nH&J\u0018\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020?H&J\"\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00192\u0006\u0010B\u001a\u00020C2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006D"}, d2 = {"Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", BuildConfig.FLAVOR, "trackEvent", BuildConfig.FLAVOR, "event", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "trackSaleOnBoardEvent", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent;", "trackScreen", "screenRouteTrackingKey", BuildConfig.FLAVOR, "trackViewedDeparture", "departure", "Ldk/molslinjen/domain/model/booking/Departure;", "transportation", "Ldk/molslinjen/domain/model/config/Transportation;", "passengerInfo", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "trailer", "Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "isEditingReservation", BuildConfig.FLAVOR, "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "site", "Ldk/molslinjen/domain/model/config/Site;", "trackAddDeparture", "departureTicket", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "trackAddAddon", "product", "Ldk/molslinjen/domain/model/booking/product/Product;", "checkoutState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "checkoutDirectionState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;", "quantityChange", BuildConfig.FLAVOR, "isFood", "trackAddMultiRideToCart", "checkoutManager", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager;", "trackAddSaleOnBoardProductToCart", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;", "lineItem", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "existingQuantity", "trackBeginCheckout", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "trackPurchase", "order", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "trackPaymentEntered", "updateStateTracking", "pushHandler", "Ldk/molslinjen/domain/providers/IPushHandlerProvider;", "updateActiveTab", "activeTab", "updateBookingTypeStateTracking", "isEditing", "bookingFlowType", "Ldk/molslinjen/domain/analytics/AnalyticsStateTrackingHelper$BookingFlowTypeTracking;", "updateBookingStateTracking", "activeDepartureSite", "bookingType", "Ldk/molslinjen/domain/model/booking/BookingType;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAnalyticsTracker {
    void trackAddAddon(Product product, CheckoutManager.CheckoutState checkoutState, CheckoutManager.CheckoutDirectionState checkoutDirectionState, DepartureDirection departureDirection, int quantityChange, boolean isFood, Site site);

    void trackAddDeparture(Departure departure, DepartureTicket departureTicket, Transportation transportation, PassengerInfo passengerInfo, TrailerProduct trailer, boolean isEditingReservation, DepartureDirection departureDirection, Site site);

    void trackAddMultiRideToCart(IMultiRideCardCheckoutManager checkoutManager);

    void trackAddSaleOnBoardProductToCart(ISaleOnBoardCheckoutManager checkoutManager, SaleOnBoardLineItem lineItem, int existingQuantity);

    void trackBeginCheckout(IMultiRideCardCheckoutManager checkoutManager);

    void trackBeginCheckout(ICheckoutManager checkoutManager, IUserManager userManager);

    void trackBeginCheckout(ISaleOnBoardCheckoutManager checkoutManager);

    void trackEvent(AnalyticsEvent event);

    void trackPaymentEntered();

    void trackPurchase(IMultiRideCardCheckoutManager checkoutManager);

    void trackPurchase(ICheckoutManager checkoutManager, IUserManager userManager);

    void trackPurchase(ISaleOnBoardCheckoutManager checkoutManager, SaleOnBoardOrder order);

    void trackSaleOnBoardEvent(SaleOnBoardAnalyticsEvent event);

    void trackScreen(String screenRouteTrackingKey);

    void trackViewedDeparture(Departure departure, Transportation transportation, PassengerInfo passengerInfo, TrailerProduct trailer, boolean isEditingReservation, DepartureDirection departureDirection, Site site);

    void updateActiveTab(String activeTab);

    void updateBookingStateTracking(Site activeDepartureSite, BookingType bookingType, Transportation transportation);

    void updateBookingTypeStateTracking(boolean isEditing, AnalyticsStateTrackingHelper.BookingFlowTypeTracking bookingFlowType);

    void updateStateTracking(IUserManager userManager, IPushHandlerProvider pushHandler);
}
