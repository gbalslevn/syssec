package dk.molslinjen.domain.analytics;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import dk.molslinjen.domain.analytics.IFacebookTracker;
import dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent;
import dk.molslinjen.domain.extensions.AnalyticsExtensionsKt;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProductAddOnOption;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStore;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardVariant;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u001b\u001c\u001d\u001e\u001f !\"#$%B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J,\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0004JS\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0004¢\u0006\u0002\u0010\u001a\u0082\u0001\u000b&'()*+,-./0¨\u00061"}, d2 = {"Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent;", BuildConfig.FLAVOR, "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "trackCateringCheckout", "checkoutState", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "analyticsEvent", BuildConfig.FLAVOR, "transactionId", "buildCateringBasketItemsParameters", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "lineItems", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "includeQuantity", BuildConfig.FLAVOR, "includeVariant", "includeAddOns", "quantityChange", BuildConfig.FLAVOR, "(Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;Ljava/util/List;ZZZLjava/lang/Integer;)Ljava/util/ArrayList;", "AddToCart", "RemoveFromCart", "ViewCart", "ViewLineItem", "SelectItem", "ViewListItem", "ViewReorderPromotion", "SelectReorderPromotion", "RefundOrder", "BeginCheckout", "Purchase", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$AddToCart;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$BeginCheckout;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$Purchase;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$RefundOrder;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$RemoveFromCart;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$SelectItem;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$SelectReorderPromotion;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$ViewCart;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$ViewLineItem;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$ViewListItem;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$ViewReorderPromotion;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardAnalyticsEvent {

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$RefundOrder;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "order", "<init>", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class RefundOrder extends SaleOnBoardAnalyticsEvent {
        private final SaleOnBoardOrder order;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RefundOrder(SaleOnBoardOrder order) {
            super(null);
            Intrinsics.checkNotNullParameter(order, "order");
            this.order = order;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RefundOrder) && Intrinsics.areEqual(this.order, ((RefundOrder) other).order);
        }

        public int hashCode() {
            return this.order.hashCode();
        }

        public String toString() {
            return "RefundOrder(order=" + this.order + ")";
        }

        @Override // dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            PriceWithCurrency priceWithCurrency = this.order.totalPrice();
            firebaseAnalytics.logEvent("refund", BundleKt.bundleOf(TuplesKt.to("transaction_id", this.order.getOrderNumber()), TuplesKt.to("affiliation", "app"), TuplesKt.to("currency", AnalyticsExtensionsKt.toAnalyticsCurrency(priceWithCurrency)), TuplesKt.to("value", Integer.valueOf(AnalyticsExtensionsKt.toAnalyticsAmount(priceWithCurrency)))));
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001b¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$RemoveFromCart;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "checkoutState", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "lineItem", BuildConfig.FLAVOR, "quantity", "<init>", "(Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;I)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "I", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class RemoveFromCart extends SaleOnBoardAnalyticsEvent {
        private final SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState;
        private final SaleOnBoardLineItem lineItem;
        private final int quantity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoveFromCart(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState, SaleOnBoardLineItem lineItem, int i5) {
            super(null);
            Intrinsics.checkNotNullParameter(checkoutState, "checkoutState");
            Intrinsics.checkNotNullParameter(lineItem, "lineItem");
            this.checkoutState = checkoutState;
            this.lineItem = lineItem;
            this.quantity = i5;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RemoveFromCart)) {
                return false;
            }
            RemoveFromCart removeFromCart = (RemoveFromCart) other;
            return Intrinsics.areEqual(this.checkoutState, removeFromCart.checkoutState) && Intrinsics.areEqual(this.lineItem, removeFromCart.lineItem) && this.quantity == removeFromCart.quantity;
        }

        public int hashCode() {
            return (((this.checkoutState.hashCode() * 31) + this.lineItem.hashCode()) * 31) + Integer.hashCode(this.quantity);
        }

        public String toString() {
            return "RemoveFromCart(checkoutState=" + this.checkoutState + ", lineItem=" + this.lineItem + ", quantity=" + this.quantity + ")";
        }

        @Override // dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            ArrayList<Bundle> buildCateringBasketItemsParameters = buildCateringBasketItemsParameters(this.checkoutState, CollectionsKt.listOf(this.lineItem), true, true, true, Integer.valueOf(this.quantity));
            PriceWithCurrency copy$default = PriceWithCurrency.copy$default(this.lineItem.getUnitPrice(), this.lineItem.getUnitPrice().getValue() * this.quantity, null, 2, null);
            firebaseAnalytics.logEvent("remove_from_cart", BundleKt.bundleOf(TuplesKt.to("currency", AnalyticsExtensionsKt.toAnalyticsCurrency(copy$default)), TuplesKt.to("value", Integer.valueOf(AnalyticsExtensionsKt.toAnalyticsAmount(copy$default))), TuplesKt.to("items", buildCateringBasketItemsParameters)));
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001b¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$SelectItem;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "checkoutState", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "lineItem", BuildConfig.FLAVOR, "listIndex", "<init>", "(Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;I)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "I", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SelectItem extends SaleOnBoardAnalyticsEvent {
        private final SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState;
        private final SaleOnBoardLineItem lineItem;
        private final int listIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectItem(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState, SaleOnBoardLineItem lineItem, int i5) {
            super(null);
            Intrinsics.checkNotNullParameter(checkoutState, "checkoutState");
            Intrinsics.checkNotNullParameter(lineItem, "lineItem");
            this.checkoutState = checkoutState;
            this.lineItem = lineItem;
            this.listIndex = i5;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectItem)) {
                return false;
            }
            SelectItem selectItem = (SelectItem) other;
            return Intrinsics.areEqual(this.checkoutState, selectItem.checkoutState) && Intrinsics.areEqual(this.lineItem, selectItem.lineItem) && this.listIndex == selectItem.listIndex;
        }

        public int hashCode() {
            return (((this.checkoutState.hashCode() * 31) + this.lineItem.hashCode()) * 31) + Integer.hashCode(this.listIndex);
        }

        public String toString() {
            return "SelectItem(checkoutState=" + this.checkoutState + ", lineItem=" + this.lineItem + ", listIndex=" + this.listIndex + ")";
        }

        @Override // dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Pair pair = TuplesKt.to("items", SaleOnBoardAnalyticsEvent.buildCateringBasketItemsParameters$default(this, this.checkoutState, CollectionsKt.listOf(this.lineItem), false, false, false, null, 32, null));
            String lowerCase = ("menu - " + this.lineItem.getProduct().getCategoryName()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            firebaseAnalytics.logEvent("select_item", BundleKt.bundleOf(pair, TuplesKt.to("item_list_name", lowerCase), TuplesKt.to("item_list_id", this.lineItem.getProduct().getCategoryId()), TuplesKt.to("index", Integer.valueOf(this.listIndex))));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$SelectReorderPromotion;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent;", "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class SelectReorderPromotion extends SaleOnBoardAnalyticsEvent {
        public static final SelectReorderPromotion INSTANCE = new SelectReorderPromotion();

        private SelectReorderPromotion() {
            super(null);
        }

        @Override // dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            firebaseAnalytics.logEvent("select_promotion", BundleKt.bundleOf(TuplesKt.to("promotion_id", "you_had_ordered_food"), TuplesKt.to("promotion_name", "you had ordered food"), TuplesKt.to("creative_name", "default"), TuplesKt.to("creative_slot", "reorder"), TuplesKt.to("location_id", "reorder")));
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$ViewCart;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "checkoutState", "<init>", "(Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewCart extends SaleOnBoardAnalyticsEvent {
        private final SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewCart(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState) {
            super(null);
            Intrinsics.checkNotNullParameter(checkoutState, "checkoutState");
            this.checkoutState = checkoutState;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ViewCart) && Intrinsics.areEqual(this.checkoutState, ((ViewCart) other).checkoutState);
        }

        public int hashCode() {
            return this.checkoutState.hashCode();
        }

        public String toString() {
            return "ViewCart(checkoutState=" + this.checkoutState + ")";
        }

        @Override // dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            PriceWithCurrency totalPrice = this.checkoutState.getTotalPrice();
            Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("currency", AnalyticsExtensionsKt.toAnalyticsCurrency(totalPrice)), TuplesKt.to("value", Integer.valueOf(AnalyticsExtensionsKt.toAnalyticsAmount(totalPrice))));
            SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState = this.checkoutState;
            bundleOf.putSerializable("items", SaleOnBoardAnalyticsEvent.buildCateringBasketItemsParameters$default(this, saleOnBoardCheckoutState, saleOnBoardCheckoutState.getBasketLineItems(), false, false, false, null, 60, null));
            firebaseAnalytics.logEvent("view_cart", bundleOf);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$ViewLineItem;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "checkoutState", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "lineItem", "<init>", "(Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewLineItem extends SaleOnBoardAnalyticsEvent {
        private final SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState;
        private final SaleOnBoardLineItem lineItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewLineItem(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState, SaleOnBoardLineItem lineItem) {
            super(null);
            Intrinsics.checkNotNullParameter(checkoutState, "checkoutState");
            Intrinsics.checkNotNullParameter(lineItem, "lineItem");
            this.checkoutState = checkoutState;
            this.lineItem = lineItem;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewLineItem)) {
                return false;
            }
            ViewLineItem viewLineItem = (ViewLineItem) other;
            return Intrinsics.areEqual(this.checkoutState, viewLineItem.checkoutState) && Intrinsics.areEqual(this.lineItem, viewLineItem.lineItem);
        }

        public int hashCode() {
            return (this.checkoutState.hashCode() * 31) + this.lineItem.hashCode();
        }

        public String toString() {
            return "ViewLineItem(checkoutState=" + this.checkoutState + ", lineItem=" + this.lineItem + ")";
        }

        @Override // dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            firebaseAnalytics.logEvent("view_item", BundleKt.bundleOf(TuplesKt.to("currency", AnalyticsExtensionsKt.toAnalyticsCurrency(this.lineItem.getUnitPrice())), TuplesKt.to("value", Integer.valueOf(AnalyticsExtensionsKt.toAnalyticsAmount(this.lineItem.getUnitPrice()))), TuplesKt.to("items", SaleOnBoardAnalyticsEvent.buildCateringBasketItemsParameters$default(this, this.checkoutState, CollectionsKt.listOf(this.lineItem), false, false, false, null, 32, null))));
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001b¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$ViewListItem;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "checkoutState", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", "product", BuildConfig.FLAVOR, "listIndex", "<init>", "(Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;I)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", "I", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewListItem extends SaleOnBoardAnalyticsEvent {
        private final SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState;
        private final int listIndex;
        private final SaleOnBoardProduct product;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewListItem(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState, SaleOnBoardProduct product, int i5) {
            super(null);
            Intrinsics.checkNotNullParameter(checkoutState, "checkoutState");
            Intrinsics.checkNotNullParameter(product, "product");
            this.checkoutState = checkoutState;
            this.product = product;
            this.listIndex = i5;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewListItem)) {
                return false;
            }
            ViewListItem viewListItem = (ViewListItem) other;
            return Intrinsics.areEqual(this.checkoutState, viewListItem.checkoutState) && Intrinsics.areEqual(this.product, viewListItem.product) && this.listIndex == viewListItem.listIndex;
        }

        public int hashCode() {
            return (((this.checkoutState.hashCode() * 31) + this.product.hashCode()) * 31) + Integer.hashCode(this.listIndex);
        }

        public String toString() {
            return "ViewListItem(checkoutState=" + this.checkoutState + ", product=" + this.product + ", listIndex=" + this.listIndex + ")";
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0045, code lost:
        
            if (r0 == null) goto L8;
         */
        @Override // dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void track(FirebaseAnalytics firebaseAnalytics) {
            String str;
            String storeName;
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Pair pair = TuplesKt.to("item_id", this.product.getItemNumber());
            String name = this.product.getName();
            Locale locale = Locale.ROOT;
            String lowerCase = name.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Pair pair2 = TuplesKt.to("item_name", lowerCase);
            Pair pair3 = TuplesKt.to("item_category", "food & drinks");
            SaleOnBoardStore selectedStore = this.checkoutState.getSelectedStore();
            if (selectedStore != null && (storeName = selectedStore.getStoreName()) != null) {
                str = storeName.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
            }
            str = "-";
            Pair pair4 = TuplesKt.to("item_category2", str);
            String lowerCase2 = this.product.getCategoryName().toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            Bundle bundleOf = BundleKt.bundleOf(pair, pair2, pair3, pair4, TuplesKt.to("item_category3", lowerCase2), TuplesKt.to("item_brand", this.checkoutState.getSite().trackingKey()), TuplesKt.to("price", Integer.valueOf(AnalyticsExtensionsKt.toAnalyticsAmount(this.product.getPrice()))), TuplesKt.to("index", Integer.valueOf(this.listIndex)));
            String lowerCase3 = ("menu - " + this.product.getCategoryName()).toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
            firebaseAnalytics.logEvent("view_item_list", BundleKt.bundleOf(TuplesKt.to("item_list_name", lowerCase3), TuplesKt.to("item_list_id", this.product.getCategoryId()), TuplesKt.to("items", CollectionsKt.arrayListOf(bundleOf))));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$ViewReorderPromotion;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent;", "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ViewReorderPromotion extends SaleOnBoardAnalyticsEvent {
        public static final ViewReorderPromotion INSTANCE = new ViewReorderPromotion();

        private ViewReorderPromotion() {
            super(null);
        }

        @Override // dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            firebaseAnalytics.logEvent("view_promotion", BundleKt.bundleOf(TuplesKt.to("promotion_id", "you_had_ordered_food"), TuplesKt.to("promotion_name", "you had ordered food"), TuplesKt.to("creative_name", "default"), TuplesKt.to("creative_slot", "reorder"), TuplesKt.to("location_id", "reorder")));
        }
    }

    public /* synthetic */ SaleOnBoardAnalyticsEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ ArrayList buildCateringBasketItemsParameters$default(SaleOnBoardAnalyticsEvent saleOnBoardAnalyticsEvent, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, List list, boolean z5, boolean z6, boolean z7, Integer num, int i5, Object obj) {
        if (obj == null) {
            return saleOnBoardAnalyticsEvent.buildCateringBasketItemsParameters(saleOnBoardCheckoutState, list, (i5 & 4) != 0 ? true : z5, (i5 & 8) != 0 ? true : z6, (i5 & 16) != 0 ? true : z7, (i5 & 32) != 0 ? null : num);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildCateringBasketItemsParameters");
    }

    public static /* synthetic */ void trackCateringCheckout$default(SaleOnBoardAnalyticsEvent saleOnBoardAnalyticsEvent, FirebaseAnalytics firebaseAnalytics, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, String str, String str2, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackCateringCheckout");
        }
        if ((i5 & 8) != 0) {
            str2 = null;
        }
        saleOnBoardAnalyticsEvent.trackCateringCheckout(firebaseAnalytics, saleOnBoardCheckoutState, str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x002a, code lost:
    
        if (r3 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final ArrayList<Bundle> buildCateringBasketItemsParameters(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState, List<SaleOnBoardLineItem> lineItems, boolean includeQuantity, boolean includeVariant, boolean includeAddOns, Integer quantityChange) {
        String str;
        Object obj;
        String storeName;
        Intrinsics.checkNotNullParameter(checkoutState, "checkoutState");
        Intrinsics.checkNotNullParameter(lineItems, "lineItems");
        ArrayList<Bundle> arrayList = new ArrayList<>();
        SaleOnBoardStore selectedStore = checkoutState.getSelectedStore();
        if (selectedStore != null && (storeName = selectedStore.getStoreName()) != null) {
            str = storeName.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        }
        str = "-";
        Iterator it = lineItems.iterator();
        while (it.hasNext()) {
            SaleOnBoardLineItem saleOnBoardLineItem = (SaleOnBoardLineItem) it.next();
            Pair pair = TuplesKt.to("item_id", saleOnBoardLineItem.getProduct().getId());
            String name = saleOnBoardLineItem.getProduct().getName();
            Locale locale = Locale.ROOT;
            String lowerCase = name.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Pair pair2 = TuplesKt.to("item_name", lowerCase);
            Pair pair3 = TuplesKt.to("item_category", "food & drinks");
            Pair pair4 = TuplesKt.to("item_category2", str);
            Iterator it2 = it;
            String lowerCase2 = saleOnBoardLineItem.getProduct().getCategoryName().toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            Object obj2 = "item_category2";
            Object obj3 = "item_category3";
            Object obj4 = "item_brand";
            Object obj5 = "price";
            Object obj6 = "currency";
            Object obj7 = "food & drinks";
            String str2 = str;
            Bundle bundleOf = BundleKt.bundleOf(pair, pair2, pair3, pair4, TuplesKt.to("item_category3", lowerCase2), TuplesKt.to("item_brand", checkoutState.getSite().trackingKey()), TuplesKt.to("price", Integer.valueOf(AnalyticsExtensionsKt.toAnalyticsAmount(saleOnBoardLineItem.getUnitPrice()))), TuplesKt.to("currency", AnalyticsExtensionsKt.toAnalyticsCurrency(saleOnBoardLineItem.getUnitPrice())));
            if (includeQuantity) {
                bundleOf.putInt("quantity", quantityChange != null ? quantityChange.intValue() : saleOnBoardLineItem.getQuantity());
            }
            SaleOnBoardVariant variant = saleOnBoardLineItem.getVariant();
            if (includeVariant && variant != null) {
                String lowerCase3 = variant.getName().toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                bundleOf.putString("item_variant", lowerCase3);
            }
            arrayList.add(bundleOf);
            if (includeAddOns) {
                for (SaleOnBoardProductAddOnOption saleOnBoardProductAddOnOption : saleOnBoardLineItem.getAddOns()) {
                    Pair pair5 = TuplesKt.to("item_id", saleOnBoardProductAddOnOption.getItemNumber());
                    String name2 = saleOnBoardProductAddOnOption.getName();
                    Locale locale2 = Locale.ROOT;
                    String lowerCase4 = name2.toLowerCase(locale2);
                    Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                    Pair pair6 = TuplesKt.to("item_name", lowerCase4);
                    Pair pair7 = TuplesKt.to("item_category", obj7);
                    Object obj8 = obj2;
                    String str3 = str2;
                    Pair pair8 = TuplesKt.to(obj8, str3);
                    String lowerCase5 = saleOnBoardLineItem.getProduct().getCategoryName().toLowerCase(locale2);
                    Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                    Object obj9 = obj3;
                    Object obj10 = obj4;
                    Object obj11 = obj5;
                    Object obj12 = obj6;
                    Bundle bundleOf2 = BundleKt.bundleOf(pair5, pair6, pair7, pair8, TuplesKt.to(obj9, lowerCase5), TuplesKt.to(obj10, checkoutState.getSite().trackingKey()), TuplesKt.to(obj11, Integer.valueOf(AnalyticsExtensionsKt.toAnalyticsAmount(saleOnBoardProductAddOnOption.getPrice()))), TuplesKt.to(obj12, AnalyticsExtensionsKt.toAnalyticsCurrency(saleOnBoardProductAddOnOption.getPrice())));
                    if (includeQuantity) {
                        obj = obj7;
                        bundleOf2.putInt("quantity", quantityChange != null ? quantityChange.intValue() : saleOnBoardLineItem.getQuantity());
                    } else {
                        obj = obj7;
                    }
                    arrayList.add(bundleOf2);
                    str2 = str3;
                    obj6 = obj12;
                    obj3 = obj9;
                    obj4 = obj10;
                    obj5 = obj11;
                    obj7 = obj;
                    obj2 = obj8;
                }
            }
            it = it2;
            str = str2;
        }
        return arrayList;
    }

    public abstract void track(FirebaseAnalytics firebaseAnalytics);

    protected final void trackCateringCheckout(FirebaseAnalytics firebaseAnalytics, SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState, String analyticsEvent, String transactionId) {
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
        Intrinsics.checkNotNullParameter(checkoutState, "checkoutState");
        Intrinsics.checkNotNullParameter(analyticsEvent, "analyticsEvent");
        PriceWithCurrency totalPrice = checkoutState.getTotalPrice();
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("affiliation", "app"), TuplesKt.to("currency", AnalyticsExtensionsKt.toAnalyticsCurrency(totalPrice)), TuplesKt.to("value", Integer.valueOf(AnalyticsExtensionsKt.toAnalyticsAmount(totalPrice))));
        if (transactionId != null) {
            bundleOf.putString("transaction_id", transactionId);
        }
        bundleOf.putSerializable("items", buildCateringBasketItemsParameters$default(this, checkoutState, checkoutState.getBasketLineItems(), false, false, false, null, 60, null));
        firebaseAnalytics.logEvent(analyticsEvent, bundleOf);
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$BeginCheckout;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "checkoutState", "<init>", "(Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", "(Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class BeginCheckout extends SaleOnBoardAnalyticsEvent {
        private final SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BeginCheckout(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState) {
            super(null);
            Intrinsics.checkNotNullParameter(checkoutState, "checkoutState");
            this.checkoutState = checkoutState;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence track$lambda$0(SaleOnBoardLineItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getProduct().getName() + "=" + it.getQuantity() + ";";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BeginCheckout) && Intrinsics.areEqual(this.checkoutState, ((BeginCheckout) other).checkoutState);
        }

        public int hashCode() {
            return this.checkoutState.hashCode();
        }

        public String toString() {
            return "BeginCheckout(checkoutState=" + this.checkoutState + ")";
        }

        @Override // dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            SaleOnBoardAnalyticsEvent.trackCateringCheckout$default(this, firebaseAnalytics, this.checkoutState, "begin_checkout", null, 8, null);
        }

        public final void track(IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            PriceWithCurrency totalPrice = this.checkoutState.getTotalPrice();
            facebookTracker.trackBeginCheckout(CollectionsKt.joinToString$default(this.checkoutState.getBasketLineItems(), null, null, null, 0, null, new Function1() { // from class: w1.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    CharSequence track$lambda$0;
                    track$lambda$0 = SaleOnBoardAnalyticsEvent.BeginCheckout.track$lambda$0((SaleOnBoardLineItem) obj);
                    return track$lambda$0;
                }
            }, 31, null), String.valueOf(this.checkoutState.getBasketLineItems().hashCode()), "saleOnBoard", AnalyticsExtensionsKt.toAnalyticsCurrency(totalPrice), AnalyticsExtensionsKt.toAnalyticsAmount(totalPrice));
        }
    }

    private SaleOnBoardAnalyticsEvent() {
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001c¨\u0006\u001d"}, d2 = {"Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$Purchase;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "checkoutState", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "order", "<init>", "(Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", "(Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Purchase extends SaleOnBoardAnalyticsEvent {
        private final SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState;
        private final SaleOnBoardOrder order;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Purchase(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState, SaleOnBoardOrder order) {
            super(null);
            Intrinsics.checkNotNullParameter(checkoutState, "checkoutState");
            Intrinsics.checkNotNullParameter(order, "order");
            this.checkoutState = checkoutState;
            this.order = order;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Purchase)) {
                return false;
            }
            Purchase purchase = (Purchase) other;
            return Intrinsics.areEqual(this.checkoutState, purchase.checkoutState) && Intrinsics.areEqual(this.order, purchase.order);
        }

        public int hashCode() {
            return (this.checkoutState.hashCode() * 31) + this.order.hashCode();
        }

        public String toString() {
            return "Purchase(checkoutState=" + this.checkoutState + ", order=" + this.order + ")";
        }

        @Override // dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            trackCateringCheckout(firebaseAnalytics, this.checkoutState, "purchase", this.order.getOrderNumber());
        }

        public final void track(IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            PriceWithCurrency priceWithCurrency = this.order.totalPrice();
            IFacebookTracker.DefaultImpls.trackPurchase$default(facebookTracker, this.order.getOrderNumber(), this.order.getOrderNumber(), "saleOnBoard", AnalyticsExtensionsKt.toAnalyticsCurrency(priceWithCurrency), AnalyticsExtensionsKt.toAnalyticsAmount(priceWithCurrency), null, SettingsProperty.Tracking.SaleOnBoardPurchasedCount.INSTANCE, 32, null);
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\r\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001e¨\u0006\u001f"}, d2 = {"Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent$AddToCart;", "Ldk/molslinjen/domain/analytics/SaleOnBoardAnalyticsEvent;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "checkoutState", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "lineItem", BuildConfig.FLAVOR, "quantityChange", "<init>", "(Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;Ljava/lang/Integer;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", "(Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "Ljava/lang/Integer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class AddToCart extends SaleOnBoardAnalyticsEvent {
        private final SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState;
        private final SaleOnBoardLineItem lineItem;
        private final Integer quantityChange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddToCart(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState checkoutState, SaleOnBoardLineItem lineItem, Integer num) {
            super(null);
            Intrinsics.checkNotNullParameter(checkoutState, "checkoutState");
            Intrinsics.checkNotNullParameter(lineItem, "lineItem");
            this.checkoutState = checkoutState;
            this.lineItem = lineItem;
            this.quantityChange = num;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddToCart)) {
                return false;
            }
            AddToCart addToCart = (AddToCart) other;
            return Intrinsics.areEqual(this.checkoutState, addToCart.checkoutState) && Intrinsics.areEqual(this.lineItem, addToCart.lineItem) && Intrinsics.areEqual(this.quantityChange, addToCart.quantityChange);
        }

        public int hashCode() {
            int hashCode = ((this.checkoutState.hashCode() * 31) + this.lineItem.hashCode()) * 31;
            Integer num = this.quantityChange;
            return hashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "AddToCart(checkoutState=" + this.checkoutState + ", lineItem=" + this.lineItem + ", quantityChange=" + this.quantityChange + ")";
        }

        @Override // dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            ArrayList<Bundle> buildCateringBasketItemsParameters = buildCateringBasketItemsParameters(this.checkoutState, CollectionsKt.listOf(this.lineItem), true, true, true, this.quantityChange);
            PriceWithCurrency copy$default = this.quantityChange == null ? this.lineItem.totalPrice() : PriceWithCurrency.copy$default(this.lineItem.getUnitPrice(), this.lineItem.getUnitPrice().getValue() * this.quantityChange.intValue(), null, 2, null);
            firebaseAnalytics.logEvent("add_to_cart", BundleKt.bundleOf(TuplesKt.to("currency", AnalyticsExtensionsKt.toAnalyticsCurrency(copy$default)), TuplesKt.to("value", Integer.valueOf(AnalyticsExtensionsKt.toAnalyticsAmount(copy$default))), TuplesKt.to("items", buildCateringBasketItemsParameters)));
        }

        public final void track(IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            PriceWithCurrency copy$default = this.quantityChange == null ? this.lineItem.totalPrice() : PriceWithCurrency.copy$default(this.lineItem.getUnitPrice(), this.lineItem.getUnitPrice().getValue() * this.quantityChange.intValue(), null, 2, null);
            String name = this.lineItem.getProduct().getName();
            String itemNumber = this.lineItem.getProduct().getItemNumber();
            String analyticsCurrency = AnalyticsExtensionsKt.toAnalyticsCurrency(copy$default);
            int analyticsAmount = AnalyticsExtensionsKt.toAnalyticsAmount(copy$default);
            Integer num = this.quantityChange;
            facebookTracker.trackSaleOnBoardAdded(name, itemNumber, "saleOnBoard", analyticsCurrency, analyticsAmount, num != null ? num.intValue() : 1);
        }
    }
}
