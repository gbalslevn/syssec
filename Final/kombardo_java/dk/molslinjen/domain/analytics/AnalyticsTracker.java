package dk.molslinjen.domain.analytics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import dk.molslinjen.core.Environment;
import dk.molslinjen.domain.analytics.AnalyticsStateTrackingHelper;
import dk.molslinjen.domain.analytics.IAnalyticsTrackingHelper;
import dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent;
import dk.molslinjen.domain.extensions.AnalyticsExtensionsKt;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutManager;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager;
import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePriceStep;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePurchaseInfo;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.domain.providers.IPushHandlerProvider;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 U2\u00020\u0001:\u0001UB3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016JB\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020-H\u0016J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010/\u001a\u00020\u00112\u0006\u0010)\u001a\u00020-H\u0016J\u0018\u0010/\u001a\u00020\u00112\u0006\u0010)\u001a\u00020.2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0011H\u0016JJ\u00103\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00104\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0017JH\u00106\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00104\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J@\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010$\u001a\u00020%2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020#2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010A\u001a\u00020\u00112\u0006\u0010)\u001a\u00020-H\u0016J \u0010B\u001a\u00020\u00112\u0006\u0010)\u001a\u00020.2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020?H\u0016J\u001a\u0010F\u001a\u00020\u00112\u0006\u0010+\u001a\u00020,2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0010\u0010I\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u0018H\u0016J\u0018\u0010K\u001a\u00020\u00112\u0006\u0010L\u001a\u00020#2\u0006\u0010M\u001a\u00020NH\u0016J\"\u0010O\u001a\u00020\u00112\u0006\u0010P\u001a\u00020'2\u0006\u0010Q\u001a\u00020R2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010S\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020TH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000f8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsTracker;", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "analyticsTrackingHelper", "Ldk/molslinjen/domain/analytics/IAnalyticsTrackingHelper;", "analyticsStateTrackingHelper", "Ldk/molslinjen/domain/analytics/IAnalyticsStateTrackingHelper;", "locationManager", "Ldk/molslinjen/domain/analytics/ILocationManagerProvider;", "context", "Landroid/content/Context;", "<init>", "(Ldk/molslinjen/domain/analytics/IFacebookTracker;Ldk/molslinjen/domain/analytics/IAnalyticsTrackingHelper;Ldk/molslinjen/domain/analytics/IAnalyticsStateTrackingHelper;Ldk/molslinjen/domain/analytics/ILocationManagerProvider;Landroid/content/Context;)V", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "trackEvent", BuildConfig.FLAVOR, "event", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "trackSaleOnBoardEvent", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent;", "trackScreen", "screenRouteTrackingKey", BuildConfig.FLAVOR, "trackViewedDeparture", "departure", "Ldk/molslinjen/domain/model/booking/Departure;", "transportation", "Ldk/molslinjen/domain/model/config/Transportation;", "passengerInfo", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "trailer", "Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "isEditingReservation", BuildConfig.FLAVOR, "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "site", "Ldk/molslinjen/domain/model/config/Site;", "trackBeginCheckout", "checkoutManager", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager;", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;", "trackPurchase", "order", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "trackPaymentEntered", "trackAddDeparture", "departureTicket", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "trackAddTrailer", "trackAddAddon", "product", "Ldk/molslinjen/domain/model/booking/product/Product;", "checkoutState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "checkoutDirectionState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;", "quantityChange", BuildConfig.FLAVOR, "isFood", "trackAddMultiRideToCart", "trackAddSaleOnBoardProductToCart", "lineItem", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "existingQuantity", "updateStateTracking", "pushHandler", "Ldk/molslinjen/domain/providers/IPushHandlerProvider;", "updateActiveTab", "activeTab", "updateBookingTypeStateTracking", "isEditing", "bookingFlowType", "Ldk/molslinjen/domain/analytics/AnalyticsStateTrackingHelper$BookingFlowTypeTracking;", "updateBookingStateTracking", "activeDepartureSite", "bookingType", "Ldk/molslinjen/domain/model/booking/BookingType;", "getRouteName", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AnalyticsTracker implements IAnalyticsTracker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final IAnalyticsStateTrackingHelper analyticsStateTrackingHelper;
    private final IAnalyticsTrackingHelper analyticsTrackingHelper;
    private final IFacebookTracker facebookTracker;

    @SuppressLint({"MissingPermission"})
    private final FirebaseAnalytics firebaseAnalytics;
    private final ILocationManagerProvider locationManager;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsTracker$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Ldk/molslinjen/domain/model/config/Transportation;", "transportation", BuildConfig.FLAVOR, "getTravelType$domain_kombardoProd", "(Ldk/molslinjen/domain/model/config/Transportation;)Ljava/lang/String;", "getTravelType", "dateFormat", "Ljava/lang/String;", "timeFormat", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTravelType$domain_kombardoProd(Transportation transportation) {
            String name;
            return Environment.INSTANCE.isKombardo() ? "bus" : (transportation == null || (name = transportation.getName()) == null) ? "none" : name;
        }

        private Companion() {
        }
    }

    public AnalyticsTracker(IFacebookTracker facebookTracker, IAnalyticsTrackingHelper analyticsTrackingHelper, IAnalyticsStateTrackingHelper analyticsStateTrackingHelper, ILocationManagerProvider locationManager, Context context) {
        Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
        Intrinsics.checkNotNullParameter(analyticsTrackingHelper, "analyticsTrackingHelper");
        Intrinsics.checkNotNullParameter(analyticsStateTrackingHelper, "analyticsStateTrackingHelper");
        Intrinsics.checkNotNullParameter(locationManager, "locationManager");
        Intrinsics.checkNotNullParameter(context, "context");
        this.facebookTracker = facebookTracker;
        this.analyticsTrackingHelper = analyticsTrackingHelper;
        this.analyticsStateTrackingHelper = analyticsStateTrackingHelper;
        this.locationManager = locationManager;
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        this.firebaseAnalytics = firebaseAnalytics;
    }

    private final String getRouteName(IDepartureInfo departure) {
        String departureHarborName = departure.getDepartureHarborName();
        Locale locale = Locale.ROOT;
        String lowerCase = departureHarborName.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = departure.getArrivalHarborName().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return lowerCase + "-" + lowerCase2;
    }

    private final void trackAddTrailer(TrailerProduct trailer, Departure departure, DepartureTicket departureTicket, Transportation transportation, PassengerInfo passengerInfo, boolean isEditingReservation, DepartureDirection departureDirection, Site site) {
        IAnalyticsTrackingHelper iAnalyticsTrackingHelper = this.analyticsTrackingHelper;
        FirebaseAnalytics firebaseAnalytics = this.firebaseAnalytics;
        String lowerCase = trailer.getName().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        IAnalyticsTrackingHelper.DefaultImpls.trackAddToCart$default(iAnalyticsTrackingHelper, firebaseAnalytics, departure, departureTicket, transportation, passengerInfo, isEditingReservation, departureDirection, null, lowerCase, "trailer", trailer.getPrice(), site, 0, null, 12416, null);
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void trackAddAddon(Product product, CheckoutManager.CheckoutState checkoutState, CheckoutManager.CheckoutDirectionState checkoutDirectionState, DepartureDirection departureDirection, int quantityChange, boolean isFood, Site site) {
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(checkoutState, "checkoutState");
        Intrinsics.checkNotNullParameter(checkoutDirectionState, "checkoutDirectionState");
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        Intrinsics.checkNotNullParameter(site, "site");
        String str = quantityChange < 0 ? "remove_from_cart" : "add_to_cart";
        IAnalyticsTrackingHelper iAnalyticsTrackingHelper = this.analyticsTrackingHelper;
        FirebaseAnalytics firebaseAnalytics = this.firebaseAnalytics;
        Departure departure = checkoutDirectionState.getDeparture();
        DepartureTicket departureTicket = checkoutDirectionState.getDepartureTicket();
        Transportation transportation = checkoutState.getTransportation();
        PassengerInfo passengerInfo = checkoutDirectionState.getPassengerInfo();
        boolean z5 = checkoutState.getEditingBooking() != null;
        String lowerCase = product.getName().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        IAnalyticsTrackingHelper.DefaultImpls.trackAddToCart$default(iAnalyticsTrackingHelper, firebaseAnalytics, departure, departureTicket, transportation, passengerInfo, z5, departureDirection, null, lowerCase, isFood ? "catering" : "addon", product.getPrice(), site, quantityChange, str, 128, null);
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    @SuppressLint({"DefaultLocale"})
    public void trackAddDeparture(Departure departure, DepartureTicket departureTicket, Transportation transportation, PassengerInfo passengerInfo, TrailerProduct trailer, boolean isEditingReservation, DepartureDirection departureDirection, Site site) {
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(departureTicket, "departureTicket");
        Intrinsics.checkNotNullParameter(transportation, "transportation");
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        Intrinsics.checkNotNullParameter(site, "site");
        IAnalyticsTrackingHelper.DefaultImpls.trackAddToCart$default(this.analyticsTrackingHelper, this.firebaseAnalytics, departure, departureTicket, transportation, passengerInfo, isEditingReservation, departureDirection, departureTicket.getChangeFee(), getRouteName(departure), "ticket", departureTicket.getPrice(), site, 0, null, 12288, null);
        if (trailer != null) {
            trackAddTrailer(trailer, departure, departureTicket, transportation, passengerInfo, isEditingReservation, departureDirection, site);
        }
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void trackAddMultiRideToCart(IMultiRideCardCheckoutManager checkoutManager) {
        String str;
        String str2;
        String analyticsCurrency;
        Site site;
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        IMultiRideCardCheckoutManager.CheckoutState value = checkoutManager.getCheckoutState().getValue();
        MultiRidePurchaseInfo selectedPurchaseInfo = value.getSelectedPurchaseInfo();
        if (selectedPurchaseInfo == null || (str = selectedPurchaseInfo.getTicketTypeName()) == null) {
            str = "-";
        }
        String str3 = str + " travel pass clip";
        MultiRidePriceStep selectedPriceStep = value.getSelectedPriceStep();
        PriceWithCurrency price = selectedPriceStep != null ? selectedPriceStep.getPrice() : null;
        Pair pair = TuplesKt.to("quantity", Integer.valueOf(value.getNumberOfCharges()));
        Pair pair2 = TuplesKt.to("item_id", str3);
        Pair pair3 = TuplesKt.to("item_name", str3);
        Pair pair4 = TuplesKt.to("price", Integer.valueOf(price != null ? AnalyticsExtensionsKt.toAnalyticsAmount(price) : 0));
        Pair pair5 = TuplesKt.to("item_category", "clips");
        SiteInfo siteInfo = value.getSiteInfo();
        if (siteInfo == null || (site = siteInfo.getSite()) == null || (str2 = site.trackingKey()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        Bundle bundleOf = BundleKt.bundleOf(pair, pair2, pair3, pair4, pair5, TuplesKt.to("item_brand", str2));
        PriceWithCurrency totalPrice = value.getTotalPrice();
        Pair pair6 = TuplesKt.to("currency", totalPrice != null ? AnalyticsExtensionsKt.toAnalyticsCurrency(totalPrice) : null);
        PriceWithCurrency totalPrice2 = value.getTotalPrice();
        this.firebaseAnalytics.logEvent(value.getNumberOfCharges() > 0 ? "add_to_cart" : "remove_from_cart", BundleKt.bundleOf(pair6, TuplesKt.to("value", totalPrice2 != null ? Integer.valueOf(AnalyticsExtensionsKt.toAnalyticsAmount(totalPrice2)) : null), TuplesKt.to("items", new Bundle[]{bundleOf})));
        IFacebookTracker iFacebookTracker = this.facebookTracker;
        String lowerCase = str3.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        iFacebookTracker.trackMultiRideCardAdded(str3, lowerCase, "turkort", (price == null || (analyticsCurrency = AnalyticsExtensionsKt.toAnalyticsCurrency(price)) == null) ? BuildConfig.FLAVOR : analyticsCurrency, price != null ? AnalyticsExtensionsKt.toAnalyticsAmount(price) : 0, value.getNumberOfCharges());
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void trackAddSaleOnBoardProductToCart(ISaleOnBoardCheckoutManager checkoutManager, SaleOnBoardLineItem lineItem, int existingQuantity) {
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(lineItem, "lineItem");
        SaleOnBoardAnalyticsEvent.AddToCart addToCart = new SaleOnBoardAnalyticsEvent.AddToCart(checkoutManager.getSaleOnBoardCheckoutState().getValue(), lineItem, Integer.valueOf(lineItem.getQuantity() - existingQuantity));
        trackSaleOnBoardEvent(addToCart);
        addToCart.track(this.facebookTracker);
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void trackBeginCheckout(ICheckoutManager checkoutManager, IUserManager userManager) {
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        this.analyticsTrackingHelper.trackCheckout(this.firebaseAnalytics, checkoutManager, "begin_checkout", !Intrinsics.areEqual(userManager.getAuthenticationType().getValue(), AuthenticationType.None.INSTANCE));
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void trackEvent(AnalyticsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.track(this.firebaseAnalytics, this.facebookTracker);
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void trackPaymentEntered() {
        this.firebaseAnalytics.logEvent("add_payment_info", null);
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void trackPurchase(ICheckoutManager checkoutManager, IUserManager userManager) {
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        this.analyticsTrackingHelper.trackCheckout(this.firebaseAnalytics, checkoutManager, "purchase", !Intrinsics.areEqual(userManager.getAuthenticationType().getValue(), AuthenticationType.None.INSTANCE));
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void trackSaleOnBoardEvent(SaleOnBoardAnalyticsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.track(this.firebaseAnalytics);
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void trackScreen(String screenRouteTrackingKey) {
        Intrinsics.checkNotNullParameter(screenRouteTrackingKey, "screenRouteTrackingKey");
        this.firebaseAnalytics.logEvent("screen_view", BundleKt.bundleOf(TuplesKt.to("screen_name", screenRouteTrackingKey)));
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void trackViewedDeparture(Departure departure, Transportation transportation, PassengerInfo passengerInfo, TrailerProduct trailer, boolean isEditingReservation, DepartureDirection departureDirection, Site site) {
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(transportation, "transportation");
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        Intrinsics.checkNotNullParameter(site, "site");
        this.analyticsTrackingHelper.trackViewedDeparture(this.firebaseAnalytics, departure, transportation, passengerInfo, isEditingReservation, departureDirection, getRouteName(departure), "ticket", site);
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void updateActiveTab(String activeTab) {
        Intrinsics.checkNotNullParameter(activeTab, "activeTab");
        this.analyticsStateTrackingHelper.updateActiveTab(this.firebaseAnalytics, activeTab);
        this.facebookTracker.trackTabChanged(activeTab);
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void updateBookingStateTracking(Site activeDepartureSite, BookingType bookingType, Transportation transportation) {
        Intrinsics.checkNotNullParameter(activeDepartureSite, "activeDepartureSite");
        Intrinsics.checkNotNullParameter(bookingType, "bookingType");
        this.analyticsStateTrackingHelper.updateBookingStateTracking(this.firebaseAnalytics, activeDepartureSite, bookingType, transportation);
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void updateBookingTypeStateTracking(boolean isEditing, AnalyticsStateTrackingHelper.BookingFlowTypeTracking bookingFlowType) {
        Intrinsics.checkNotNullParameter(bookingFlowType, "bookingFlowType");
        this.analyticsStateTrackingHelper.updateBookingTypeStateTracking(this.firebaseAnalytics, isEditing, bookingFlowType);
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void updateStateTracking(IUserManager userManager, IPushHandlerProvider pushHandler) {
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        this.analyticsStateTrackingHelper.updateStateTracking(this.firebaseAnalytics, userManager, this.locationManager.isAuthorized(), pushHandler != null ? Boolean.valueOf(pushHandler.isPushEnabled()) : null);
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void trackBeginCheckout(IMultiRideCardCheckoutManager checkoutManager) {
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        this.analyticsTrackingHelper.trackCheckout(this.firebaseAnalytics, checkoutManager, "begin_checkout");
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void trackPurchase(IMultiRideCardCheckoutManager checkoutManager) {
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        this.analyticsTrackingHelper.trackCheckout(this.firebaseAnalytics, checkoutManager, "purchase");
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void trackBeginCheckout(ISaleOnBoardCheckoutManager checkoutManager) {
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        SaleOnBoardAnalyticsEvent.BeginCheckout beginCheckout = new SaleOnBoardAnalyticsEvent.BeginCheckout(checkoutManager.getSaleOnBoardCheckoutState().getValue());
        trackSaleOnBoardEvent(beginCheckout);
        beginCheckout.track(this.facebookTracker);
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTracker
    public void trackPurchase(ISaleOnBoardCheckoutManager checkoutManager, SaleOnBoardOrder order) {
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(order, "order");
        SaleOnBoardAnalyticsEvent.Purchase purchase = new SaleOnBoardAnalyticsEvent.Purchase(checkoutManager.getSaleOnBoardCheckoutState().getValue(), order);
        trackSaleOnBoardEvent(purchase);
        purchase.track(this.facebookTracker);
    }
}
