package dk.molslinjen.domain.analytics;

import com.google.firebase.analytics.FirebaseAnalytics;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutManager;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0082\u0001\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0011H&J \u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0011H&J(\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020#2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\rH&¨\u0006%"}, d2 = {"Ldk/molslinjen/domain/analytics/IAnalyticsTrackingHelper;", BuildConfig.FLAVOR, "trackViewedDeparture", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "departure", "Ldk/molslinjen/domain/model/booking/Departure;", "transportation", "Ldk/molslinjen/domain/model/config/Transportation;", "passengerInfo", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "isEditingReservation", BuildConfig.FLAVOR, "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "itemId", BuildConfig.FLAVOR, "category", "site", "Ldk/molslinjen/domain/model/config/Site;", "trackAddToCart", "departureTicket", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "changeFee", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "price", "Ldk/molslinjen/domain/model/shared/Price;", "quantity", BuildConfig.FLAVOR, "eventName", "trackCheckout", "checkoutManager", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager;", "analyticsEvent", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "isAuthenticated", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAnalyticsTrackingHelper {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void trackAddToCart$default(IAnalyticsTrackingHelper iAnalyticsTrackingHelper, FirebaseAnalytics firebaseAnalytics, Departure departure, DepartureTicket departureTicket, Transportation transportation, PassengerInfo passengerInfo, boolean z5, DepartureDirection departureDirection, PriceWithCurrency priceWithCurrency, String str, String str2, Price price, Site site, int i5, String str3, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackAddToCart");
            }
            iAnalyticsTrackingHelper.trackAddToCart(firebaseAnalytics, departure, departureTicket, transportation, passengerInfo, z5, departureDirection, (i6 & 128) != 0 ? null : priceWithCurrency, str, str2, price, site, (i6 & 4096) != 0 ? 1 : i5, (i6 & 8192) != 0 ? null : str3);
        }
    }

    void trackAddToCart(FirebaseAnalytics firebaseAnalytics, Departure departure, DepartureTicket departureTicket, Transportation transportation, PassengerInfo passengerInfo, boolean isEditingReservation, DepartureDirection departureDirection, PriceWithCurrency changeFee, String itemId, String category, Price price, Site site, int quantity, String eventName);

    void trackCheckout(FirebaseAnalytics firebaseAnalytics, IMultiRideCardCheckoutManager checkoutManager, String analyticsEvent);

    void trackCheckout(FirebaseAnalytics firebaseAnalytics, ICheckoutManager checkoutManager, String analyticsEvent, boolean isAuthenticated);

    void trackViewedDeparture(FirebaseAnalytics firebaseAnalytics, Departure departure, Transportation transportation, PassengerInfo passengerInfo, boolean isEditingReservation, DepartureDirection departureDirection, String itemId, String category, Site site);
}
