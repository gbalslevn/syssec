package dk.molslinjen.domain.analytics;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import dk.molslinjen.domain.analytics.IFacebookTracker;
import dk.molslinjen.domain.extensions.AnalyticsExtensionsKt;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutManager;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCardSummaryInfo;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePriceStep;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePurchaseInfo;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.domain.model.site.SiteInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JP\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J|\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0019H\u0016JZ\u0010'\u001a\u00020(2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u0019H\u0002J \u0010,\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0019H\u0016J(\u0010,\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010-\u001a\u0002002\u0006\u0010/\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0015H\u0016Jb\u00102\u001a\u0012\u0012\u0004\u0012\u00020(03j\b\u0012\u0004\u0012\u00020(`42\u0006\u00105\u001a\u0002062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u00107\u001a\u0004\u0018\u00010\u00192\u0006\u00108\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00109\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010:\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020;H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsTrackingHelper;", "Ldk/molslinjen/domain/analytics/IAnalyticsTrackingHelper;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "adjustTracker", "Ldk/molslinjen/domain/analytics/IAdjustTracker;", "<init>", "(Ldk/molslinjen/domain/analytics/IFacebookTracker;Ldk/molslinjen/domain/analytics/IAdjustTracker;)V", "localScope", "Lkotlinx/coroutines/CoroutineScope;", "trackViewedDeparture", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "departure", "Ldk/molslinjen/domain/model/booking/Departure;", "transportation", "Ldk/molslinjen/domain/model/config/Transportation;", "passengerInfo", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "isEditingReservation", BuildConfig.FLAVOR, "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "itemId", BuildConfig.FLAVOR, "category", "site", "Ldk/molslinjen/domain/model/config/Site;", "trackAddToCart", "departureTicket", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "changeFee", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "price", "Ldk/molslinjen/domain/model/shared/Price;", "quantity", BuildConfig.FLAVOR, "eventName", "makeAddToCartBundleItem", "Landroid/os/Bundle;", "item", "direction", "brand", "trackCheckout", "checkoutManager", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager;", "analyticsEvent", "Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "isAuthenticated", "trackDepartureDirection", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "outboundDirectionState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;", "reservationNumber", "route", "departureItemPrice", "getRouteName", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AnalyticsTrackingHelper implements IAnalyticsTrackingHelper {
    private final IAdjustTracker adjustTracker;
    private final IFacebookTracker facebookTracker;
    private final CoroutineScope localScope;

    public AnalyticsTrackingHelper(IFacebookTracker facebookTracker, IAdjustTracker adjustTracker) {
        Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
        Intrinsics.checkNotNullParameter(adjustTracker, "adjustTracker");
        this.facebookTracker = facebookTracker;
        this.adjustTracker = adjustTracker;
        this.localScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
    }

    private final String getRouteName(IDepartureInfo departure) {
        return departure.getDepartureHarborName() + "-" + departure.getArrivalHarborName();
    }

    private final Bundle makeAddToCartBundleItem(Departure departure, DepartureTicket departureTicket, Transportation transportation, PassengerInfo passengerInfo, String item, String category, Price price, int quantity, String direction, String brand) {
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("quantity", Integer.valueOf(quantity)), TuplesKt.to("item_id", item), TuplesKt.to("item_name", item), TuplesKt.to("price", Integer.valueOf(AnalyticsExtensionsKt.toAnalyticsAmount(price))), TuplesKt.to("item_category", category), TuplesKt.to("start_date", LocalDateTimeExtensionsKt.toFormat(departure.getDepartureDateTime(), "yyyy-MM-dd")), TuplesKt.to("end_date", LocalDateTimeExtensionsKt.toFormat(departure.getArrivalDateTime(), "yyyy-MM-dd")), TuplesKt.to("origin", departure.getDepartureHarborName()), TuplesKt.to("destination", departure.getArrivalHarborName()), TuplesKt.to("direction", direction), TuplesKt.to("travel_type", AnalyticsTracker.INSTANCE.getTravelType$domain_kombardoProd(transportation)), TuplesKt.to("departure_time", LocalDateTimeExtensionsKt.toFormat(departure.getDepartureDateTime(), "HH:mm")), TuplesKt.to("item_brand", brand), TuplesKt.to("ticket_type", departureTicket.getCategory().getName()));
        if (transportation.isWalking()) {
            bundleOf.putInt("number_of_adults", passengerInfo.getAdultCount());
            bundleOf.putInt("number_of_children", passengerInfo.getChildCount());
            bundleOf.putInt("number_of_infants", passengerInfo.getInfantCount());
        }
        return bundleOf;
    }

    private final ArrayList<Bundle> trackDepartureDirection(CheckoutManager.CheckoutDirectionState outboundDirectionState, DepartureTicket departureTicket, Site site, String reservationNumber, String route, Departure departure, Transportation transportation, Price departureItemPrice, DepartureDirection departureDirection) {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        Pair pair = TuplesKt.to("reservation_number", reservationNumber == null ? "-" : reservationNumber);
        Pair pair2 = TuplesKt.to("line", site.trackingKey());
        Pair pair3 = TuplesKt.to("route", route);
        Pair pair4 = TuplesKt.to("date", LocalDateTimeExtensionsKt.toFormat(departure.getDepartureDateTime(), "yyyy-MM-dd"));
        Pair pair5 = TuplesKt.to("origin", departure.getDepartureHarborName());
        Pair pair6 = TuplesKt.to("destination", departure.getArrivalHarborName());
        Pair pair7 = TuplesKt.to("price", Integer.valueOf(AnalyticsExtensionsKt.toAnalyticsAmount(departureItemPrice)));
        Pair pair8 = TuplesKt.to("ticket_type", departureTicket.getCategory().getName());
        List<BookingPassenger> passengers = outboundDirectionState.getPassengers();
        if (passengers.isEmpty()) {
            passengers = null;
        }
        List<BookingPassenger> list = passengers;
        arrayList.add(BundleKt.bundleOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, TuplesKt.to("number_of_passengers", Integer.valueOf(list != null ? list.size() : outboundDirectionState.getPassengerInfo().getTotalPassengerCount())), TuplesKt.to("travel_type", AnalyticsTracker.INSTANCE.getTravelType$domain_kombardoProd(transportation)), TuplesKt.to("item_category", "ticket"), TuplesKt.to("item_category2", departureTicket.getCategory().getType().trackingKey()), TuplesKt.to("item_variant", departureTicket.getCategory().getType().trackingKey()), TuplesKt.to("quantity", 1), TuplesKt.to("item_brand", site.trackingKey()), TuplesKt.to("item_id", route), TuplesKt.to("item_name", route)));
        TrailerProduct trailer = outboundDirectionState.getTrailer();
        if (trailer != null) {
            PassengerInfo passengerInfo = outboundDirectionState.getPassengerInfo();
            String name = trailer.getName();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = name.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            arrayList.add(makeAddToCartBundleItem(departure, departureTicket, transportation, passengerInfo, lowerCase, "trailer", trailer.getPrice(), 1, departureDirection == DepartureDirection.Outbound ? "departure" : "return", site.trackingKey()));
        }
        for (Product product : outboundDirectionState.getAddons()) {
            PassengerInfo passengerInfo2 = outboundDirectionState.getPassengerInfo();
            String name2 = product.getName();
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
            String lowerCase2 = name2.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            arrayList.add(makeAddToCartBundleItem(departure, departureTicket, transportation, passengerInfo2, lowerCase2, "addon", product.getPrice(), product.getQuantity(), "departure", site.trackingKey()));
        }
        for (Product product2 : outboundDirectionState.getFood()) {
            PassengerInfo passengerInfo3 = outboundDirectionState.getPassengerInfo();
            String name3 = product2.getName();
            Locale locale3 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
            String lowerCase3 = name3.toLowerCase(locale3);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
            arrayList.add(makeAddToCartBundleItem(departure, departureTicket, transportation, passengerInfo3, lowerCase3, "food", product2.getPrice(), product2.getQuantity(), "departure", site.trackingKey()));
        }
        for (Product product3 : outboundDirectionState.getTransportProducts()) {
            PassengerInfo passengerInfo4 = outboundDirectionState.getPassengerInfo();
            String name4 = product3.getName();
            Locale locale4 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale4, "getDefault(...)");
            String lowerCase4 = name4.toLowerCase(locale4);
            Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
            arrayList.add(makeAddToCartBundleItem(departure, departureTicket, transportation, passengerInfo4, lowerCase4, "transport_product", product3.getPrice(), product3.getQuantity(), "departure", site.trackingKey()));
        }
        return arrayList;
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTrackingHelper
    public void trackAddToCart(FirebaseAnalytics firebaseAnalytics, Departure departure, DepartureTicket departureTicket, Transportation transportation, PassengerInfo passengerInfo, boolean isEditingReservation, DepartureDirection departureDirection, PriceWithCurrency changeFee, String itemId, String category, Price price, Site site, int quantity, String eventName) {
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(departureTicket, "departureTicket");
        Intrinsics.checkNotNullParameter(transportation, "transportation");
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(site, "site");
        Bundle makeAddToCartBundleItem = makeAddToCartBundleItem(departure, departureTicket, transportation, passengerInfo, itemId, category, price, quantity, departureDirection == DepartureDirection.Return ? "return" : "departure", site.trackingKey());
        String analyticsCurrency = AnalyticsExtensionsKt.toAnalyticsCurrency(price);
        int analyticsAmount = AnalyticsExtensionsKt.toAnalyticsAmount(price) * quantity;
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("booking_type", isEditingReservation ? "rebooking" : "booking"), TuplesKt.to("currency", analyticsCurrency), TuplesKt.to("value", Integer.valueOf(analyticsAmount)), TuplesKt.to("items", new Bundle[]{makeAddToCartBundleItem}));
        if (isEditingReservation) {
            int value = changeFee != null ? changeFee.getValue() : 0;
            bundleOf.putInt("change_fee", value);
            analyticsAmount += value;
        }
        if (quantity > 0) {
            this.facebookTracker.trackDepartureAdded(itemId, itemId, category, analyticsCurrency, analyticsAmount, quantity);
        }
        if (eventName != null) {
            firebaseAnalytics.logEvent(eventName, bundleOf);
        } else {
            firebaseAnalytics.logEvent(quantity > 0 ? "add_to_cart" : "remove_from_cart", bundleOf);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.os.Bundle[], java.io.Serializable] */
    @Override // dk.molslinjen.domain.analytics.IAnalyticsTrackingHelper
    public void trackCheckout(FirebaseAnalytics firebaseAnalytics, IMultiRideCardCheckoutManager checkoutManager, String analyticsEvent) {
        String str;
        String str2;
        String analyticsCurrency;
        String analyticsCurrency2;
        String multiRideId;
        Site site;
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(analyticsEvent, "analyticsEvent");
        IMultiRideCardCheckoutManager.CheckoutState value = checkoutManager.getCheckoutState().getValue();
        PriceWithCurrency totalPrice = value.getTotalPrice();
        if (totalPrice == null) {
            return;
        }
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("affiliation", "app"), TuplesKt.to("currency", totalPrice.getCurrencyType().name()));
        String str3 = value.getMultiRideCardToRefill() == null ? "purchase" : "refill";
        MultiRidePurchaseInfo selectedPurchaseInfo = value.getSelectedPurchaseInfo();
        if (selectedPurchaseInfo == null || (str = selectedPurchaseInfo.getTicketTypeName()) == null) {
            str = "-";
        }
        String str4 = str + " travel pass clip";
        MultiRidePriceStep selectedPriceStep = value.getSelectedPriceStep();
        PriceWithCurrency price = selectedPriceStep != null ? selectedPriceStep.getPrice() : null;
        Pair pair = TuplesKt.to("quantity", Integer.valueOf(value.getNumberOfCharges()));
        Pair pair2 = TuplesKt.to("item_id", str4);
        Pair pair3 = TuplesKt.to("item_name", str4);
        Pair pair4 = TuplesKt.to("price", Integer.valueOf(price != null ? AnalyticsExtensionsKt.toAnalyticsAmount(price) : 0));
        Pair pair5 = TuplesKt.to("item_category", "clips");
        SiteInfo siteInfo = value.getSiteInfo();
        String str5 = BuildConfig.FLAVOR;
        if (siteInfo == null || (site = siteInfo.getSite()) == null || (str2 = site.trackingKey()) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        Bundle bundleOf2 = BundleKt.bundleOf(pair, pair2, pair3, pair4, pair5, TuplesKt.to("item_brand", str2));
        bundleOf.putDouble("value", AnalyticsExtensionsKt.toAnalyticsAmount(totalPrice));
        bundleOf.putString("purchase_type", str3);
        MultiRideCardSummaryInfo summaryCardInfo = value.getSummaryCardInfo();
        if (summaryCardInfo != null && (multiRideId = summaryCardInfo.getMultiRideId()) != null) {
            str5 = multiRideId;
        }
        bundleOf.putString("transaction_id", str5);
        bundleOf.putSerializable("items", new Bundle[]{bundleOf2});
        firebaseAnalytics.logEvent(analyticsEvent, bundleOf);
        if (Intrinsics.areEqual(analyticsEvent, "purchase")) {
            IFacebookTracker.DefaultImpls.trackPurchase$default(this.facebookTracker, str4, str4, "turkort", (price == null || (analyticsCurrency2 = AnalyticsExtensionsKt.toAnalyticsCurrency(price)) == null) ? "-" : analyticsCurrency2, price != null ? AnalyticsExtensionsKt.toAnalyticsAmount(price) : 0, null, SettingsProperty.Tracking.MultiRideCardPurchasedCount.INSTANCE, 32, null);
        } else if (Intrinsics.areEqual(analyticsEvent, "begin_checkout")) {
            this.facebookTracker.trackBeginCheckout(str4, str4, "turkort", (price == null || (analyticsCurrency = AnalyticsExtensionsKt.toAnalyticsCurrency(price)) == null) ? "-" : analyticsCurrency, price != null ? AnalyticsExtensionsKt.toAnalyticsAmount(price) : 0);
        }
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsTrackingHelper
    public void trackViewedDeparture(FirebaseAnalytics firebaseAnalytics, Departure departure, Transportation transportation, PassengerInfo passengerInfo, boolean isEditingReservation, DepartureDirection departureDirection, String itemId, String category, Site site) {
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(transportation, "transportation");
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(departureDirection, "departureDirection");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(site, "site");
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("quantity", 1), TuplesKt.to("item_id", itemId), TuplesKt.to("item_name", itemId), TuplesKt.to("item_category", category), TuplesKt.to("start_date", LocalDateTimeExtensionsKt.toFormat(departure.getDepartureDateTime(), "yyyy-MM-dd")), TuplesKt.to("end_date", LocalDateTimeExtensionsKt.toFormat(departure.getArrivalDateTime(), "yyyy-MM-dd")), TuplesKt.to("origin", departure.getDepartureHarborName()), TuplesKt.to("destination", departure.getArrivalHarborName()), TuplesKt.to("direction", departureDirection == DepartureDirection.Return ? "return" : "departure"), TuplesKt.to("travel_type", AnalyticsTracker.INSTANCE.getTravelType$domain_kombardoProd(transportation)), TuplesKt.to("departure_time", LocalDateTimeExtensionsKt.toFormat(departure.getDepartureDateTime(), "HH:mm")), TuplesKt.to("item_brand", site.trackingKey()));
        if (transportation.isWalking()) {
            bundleOf.putInt("number_of_adults", passengerInfo.getAdultCount());
            bundleOf.putInt("number_of_children", passengerInfo.getChildCount());
            bundleOf.putInt("number_of_infants", passengerInfo.getInfantCount());
        }
        firebaseAnalytics.logEvent("view_item", BundleKt.bundleOf(TuplesKt.to("booking_type", isEditingReservation ? "rebooking" : "booking"), TuplesKt.to("items", new Bundle[]{bundleOf})));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v29, types: [T, dk.molslinjen.domain.managers.checkout.PriceTotal] */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.lang.Object[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r0v48, types: [T, dk.molslinjen.domain.managers.checkout.PriceTotal] */
    /* JADX WARN: Type inference failed for: r0v56, types: [T, dk.molslinjen.domain.managers.checkout.PriceTotal] */
    @Override // dk.molslinjen.domain.analytics.IAnalyticsTrackingHelper
    public void trackCheckout(FirebaseAnalytics firebaseAnalytics, ICheckoutManager checkoutManager, String analyticsEvent, boolean isAuthenticated) {
        CheckoutManager.CheckoutDirectionState value;
        Price price;
        List list;
        int i5;
        Price price2;
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
        Intrinsics.checkNotNullParameter(checkoutManager, "checkoutManager");
        Intrinsics.checkNotNullParameter(analyticsEvent, "analyticsEvent");
        CheckoutManager.CheckoutState value2 = checkoutManager.getCheckoutState().getValue();
        if (value2 == null || (value = checkoutManager.getOutboundDirectionState().getValue()) == null) {
            return;
        }
        CheckoutManager.CheckoutDirectionState value3 = checkoutManager.getReturnDirectionState().getValue();
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("affiliation", "app"));
        Departure departure = value.getDeparture();
        DepartureTicket departureTicket = value.getDepartureTicket();
        Departure departure2 = value3 != null ? value3.getDeparture() : null;
        Transportation transportation = value2.getTransportation();
        String routeName = getRouteName(departure);
        int max = Math.max(0, value2.getPriceDetails().getTotalPrice().getPrice().getValue());
        bundleOf.putString("booking_type", value2.getEditingBooking() != null ? "rebooking" : "booking");
        bundleOf.putString("single_return", departure2 != null ? "return" : "single");
        bundleOf.putString("transaction_id", value2.getReservationNumber());
        TrailerProduct trailer = value.getTrailer();
        PriceWithCurrency price3 = trailer != null ? trailer.getPrice() : null;
        if ((departureTicket.getPrice() instanceof PriceWithCurrency) && price3 != null) {
            price = PriceWithCurrency.copy$default((PriceWithCurrency) departureTicket.getPrice(), Math.max(0, ((PriceWithCurrency) departureTicket.getPrice()).getValue() - price3.getValue()), null, 2, null);
        } else {
            price = departureTicket.getPrice();
        }
        Price price4 = price;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new PriceTotal(price4);
        List mutableList = CollectionsKt.toMutableList((Collection) trackDepartureDirection(value, departureTicket, value2.getSite(), value2.getReservationNumber(), routeName, departure, transportation, price4, DepartureDirection.Outbound));
        if (departure2 != null) {
            DepartureTicket departureTicket2 = value3.getDepartureTicket();
            TrailerProduct trailer2 = value3.getTrailer();
            PriceWithCurrency price5 = trailer2 != null ? trailer2.getPrice() : null;
            if ((departureTicket2.getPrice() instanceof PriceWithCurrency) && price5 != null) {
                price2 = PriceWithCurrency.copy$default((PriceWithCurrency) departureTicket2.getPrice(), Math.max(0, ((PriceWithCurrency) departureTicket2.getPrice()).getValue() - price5.getValue()), null, 2, null);
            } else {
                price2 = departureTicket2.getPrice();
            }
            Price price6 = price2;
            ref$ObjectRef.element = ((PriceTotal) ref$ObjectRef.element).plus(new PriceTotal(price6));
            list = mutableList;
            list.addAll(trackDepartureDirection(value3, departureTicket2, value2.getSite(), value2.getReturnReservationNumber(), getRouteName(departure), departure2, transportation, price6, DepartureDirection.Return));
        } else {
            list = mutableList;
        }
        PriceWithCurrency changeFee = value2.getPriceDetails().getChangeFee();
        if (changeFee != null) {
            Bundle bundleOf2 = BundleKt.bundleOf(TuplesKt.to("item_id", "change-fee"), TuplesKt.to("item_name", "change-fee"), TuplesKt.to("item_category", "change fee"), TuplesKt.to("item_brand", value2.getSite().trackingKey()), TuplesKt.to("price", Integer.valueOf(AnalyticsExtensionsKt.toAnalyticsAmount(changeFee))), TuplesKt.to("quantity", 1));
            ref$ObjectRef.element = ((PriceTotal) ref$ObjectRef.element).plus(new PriceTotal(changeFee));
            list.add(bundleOf2);
        }
        bundleOf.putSerializable("items", list.toArray(new Bundle[0]));
        if (Intrinsics.areEqual(analyticsEvent, "purchase")) {
            this.facebookTracker.trackPurchase(routeName, routeName, "ticket", AnalyticsExtensionsKt.toAnalyticsCurrency((PriceTotal) ref$ObjectRef.element), max, Boolean.valueOf(isAuthenticated), SettingsProperty.Tracking.TicketsPurchasedCount.INSTANCE);
            i5 = max;
            BuildersKt__Builders_commonKt.launch$default(this.localScope, null, null, new AnalyticsTrackingHelper$trackCheckout$3(this, i5, ref$ObjectRef, null), 3, null);
        } else {
            i5 = max;
            if (Intrinsics.areEqual(analyticsEvent, "begin_checkout")) {
                this.facebookTracker.trackBeginCheckout(routeName, routeName, "ticket", AnalyticsExtensionsKt.toAnalyticsCurrency((PriceTotal) ref$ObjectRef.element), i5);
            }
        }
        bundleOf.putDouble("value", i5);
        bundleOf.putString("currency", AnalyticsExtensionsKt.toAnalyticsCurrency((PriceTotal) ref$ObjectRef.element));
        firebaseAnalytics.logEvent(analyticsEvent, bundleOf);
    }
}
