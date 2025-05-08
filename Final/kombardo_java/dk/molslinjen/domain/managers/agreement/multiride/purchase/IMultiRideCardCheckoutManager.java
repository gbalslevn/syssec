package dk.molslinjen.domain.managers.agreement.multiride.purchase;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.ICreateBooking;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCardSummaryInfo;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePriceStep;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePurchaseInfo;
import dk.molslinjen.domain.model.booking.CheckoutContactInfo;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.domain.model.site.SiteInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001(J0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bH¦@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\rH&J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\rH&J\u001a\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006)"}, d2 = {"Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager;", "Ldk/molslinjen/domain/managers/checkout/ICreateBooking;", "checkoutState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager$CheckoutState;", "getCheckoutState", "()Lkotlinx/coroutines/flow/StateFlow;", "setup", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/domain/model/config/Site;", "multiRideIdToRefill", BuildConfig.FLAVOR, "flowOrigin", "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "(Ldk/molslinjen/domain/model/config/Site;Ljava/lang/String;Ldk/molslinjen/domain/model/payment/PaymentOrigin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadSummaryInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSelectedPurchaseInfo", "purchaseInfo", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePurchaseInfo;", "updateSelectedPriceStep", "priceStep", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;", "updateChargeCount", "chargeCount", BuildConfig.FLAVOR, "updatePhoneNumber", "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "updateEmail", "email", "updatePostalCode", "postalCode", "selectPaymentMethod", "paymentType", "Ldk/molslinjen/domain/model/payment/PaymentType;", "creditCard", "Ldk/molslinjen/domain/model/account/CreditCard;", "CheckoutState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IMultiRideCardCheckoutManager extends ICreateBooking {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object setup$default(IMultiRideCardCheckoutManager iMultiRideCardCheckoutManager, Site site, String str, PaymentOrigin paymentOrigin, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setup");
            }
            if ((i5 & 2) != 0) {
                str = null;
            }
            return iMultiRideCardCheckoutManager.setup(site, str, paymentOrigin, continuation);
        }
    }

    StateFlow<CheckoutState> getCheckoutState();

    Object loadSummaryInfo(Continuation<? super ManagerResult<Unit>> continuation);

    void selectPaymentMethod(PaymentType paymentType, CreditCard creditCard);

    Object setup(Site site, String str, PaymentOrigin paymentOrigin, Continuation<? super ManagerResult<Unit>> continuation);

    void updateChargeCount(int chargeCount);

    void updateEmail(String email);

    void updatePhoneNumber(PhoneNumber phoneNumber);

    void updatePostalCode(String postalCode);

    void updateSelectedPriceStep(MultiRidePriceStep priceStep);

    void updateSelectedPurchaseInfo(MultiRidePurchaseInfo purchaseInfo);

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ \u0001\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010-\u001a\u0004\b.\u0010/R\u001f\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u00100\u001a\u0004\b1\u00102R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u00103\u001a\u0004\b4\u00105R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u00106\u001a\u0004\b7\u0010\"R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u00108\u001a\u0004\b9\u0010:R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010A\u001a\u0004\bB\u0010CR\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010D\u001a\u0004\bE\u0010FR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010G\u001a\u0004\bH\u0010I¨\u0006J"}, d2 = {"Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager$CheckoutState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "flowOrigin", "Ldk/molslinjen/domain/model/site/SiteInfo;", "siteInfo", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "multiRideCardToRefill", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePurchaseInfo;", "purchaseInfos", "selectedPurchaseInfo", BuildConfig.FLAVOR, "numberOfCharges", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;", "selectedPriceStep", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "totalPrice", "Ldk/molslinjen/domain/model/booking/CheckoutContactInfo;", "personalInfo", "Ldk/molslinjen/domain/model/payment/PaymentType;", "selectedPaymentType", "Ldk/molslinjen/domain/model/account/CreditCard;", "selectedCreditCard", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardSummaryInfo;", "summaryCardInfo", "<init>", "(Ldk/molslinjen/domain/model/payment/PaymentOrigin;Ldk/molslinjen/domain/model/site/SiteInfo;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;Ljava/util/List;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePurchaseInfo;ILdk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ldk/molslinjen/domain/model/booking/CheckoutContactInfo;Ldk/molslinjen/domain/model/payment/PaymentType;Ldk/molslinjen/domain/model/account/CreditCard;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardSummaryInfo;)V", "copy", "(Ldk/molslinjen/domain/model/payment/PaymentOrigin;Ldk/molslinjen/domain/model/site/SiteInfo;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;Ljava/util/List;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePurchaseInfo;ILdk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ldk/molslinjen/domain/model/booking/CheckoutContactInfo;Ldk/molslinjen/domain/model/payment/PaymentType;Ldk/molslinjen/domain/model/account/CreditCard;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardSummaryInfo;)Ldk/molslinjen/domain/managers/agreement/multiride/purchase/IMultiRideCardCheckoutManager$CheckoutState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "getFlowOrigin", "()Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "Ldk/molslinjen/domain/model/site/SiteInfo;", "getSiteInfo", "()Ldk/molslinjen/domain/model/site/SiteInfo;", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "getMultiRideCardToRefill", "()Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "Ljava/util/List;", "getPurchaseInfos", "()Ljava/util/List;", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePurchaseInfo;", "getSelectedPurchaseInfo", "()Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePurchaseInfo;", "I", "getNumberOfCharges", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;", "getSelectedPriceStep", "()Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getTotalPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "Ldk/molslinjen/domain/model/booking/CheckoutContactInfo;", "getPersonalInfo", "()Ldk/molslinjen/domain/model/booking/CheckoutContactInfo;", "Ldk/molslinjen/domain/model/payment/PaymentType;", "getSelectedPaymentType", "()Ldk/molslinjen/domain/model/payment/PaymentType;", "Ldk/molslinjen/domain/model/account/CreditCard;", "getSelectedCreditCard", "()Ldk/molslinjen/domain/model/account/CreditCard;", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardSummaryInfo;", "getSummaryCardInfo", "()Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardSummaryInfo;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class CheckoutState {
        private final PaymentOrigin flowOrigin;
        private final MultiRideCard multiRideCardToRefill;
        private final int numberOfCharges;
        private final CheckoutContactInfo personalInfo;
        private final List<MultiRidePurchaseInfo> purchaseInfos;
        private final CreditCard selectedCreditCard;
        private final PaymentType selectedPaymentType;
        private final MultiRidePriceStep selectedPriceStep;
        private final MultiRidePurchaseInfo selectedPurchaseInfo;
        private final SiteInfo siteInfo;
        private final MultiRideCardSummaryInfo summaryCardInfo;
        private final PriceWithCurrency totalPrice;

        public CheckoutState(PaymentOrigin paymentOrigin, SiteInfo siteInfo, MultiRideCard multiRideCard, List<MultiRidePurchaseInfo> list, MultiRidePurchaseInfo multiRidePurchaseInfo, int i5, MultiRidePriceStep multiRidePriceStep, PriceWithCurrency priceWithCurrency, CheckoutContactInfo personalInfo, PaymentType selectedPaymentType, CreditCard creditCard, MultiRideCardSummaryInfo multiRideCardSummaryInfo) {
            Intrinsics.checkNotNullParameter(personalInfo, "personalInfo");
            Intrinsics.checkNotNullParameter(selectedPaymentType, "selectedPaymentType");
            this.flowOrigin = paymentOrigin;
            this.siteInfo = siteInfo;
            this.multiRideCardToRefill = multiRideCard;
            this.purchaseInfos = list;
            this.selectedPurchaseInfo = multiRidePurchaseInfo;
            this.numberOfCharges = i5;
            this.selectedPriceStep = multiRidePriceStep;
            this.totalPrice = priceWithCurrency;
            this.personalInfo = personalInfo;
            this.selectedPaymentType = selectedPaymentType;
            this.selectedCreditCard = creditCard;
            this.summaryCardInfo = multiRideCardSummaryInfo;
        }

        public final CheckoutState copy(PaymentOrigin flowOrigin, SiteInfo siteInfo, MultiRideCard multiRideCardToRefill, List<MultiRidePurchaseInfo> purchaseInfos, MultiRidePurchaseInfo selectedPurchaseInfo, int numberOfCharges, MultiRidePriceStep selectedPriceStep, PriceWithCurrency totalPrice, CheckoutContactInfo personalInfo, PaymentType selectedPaymentType, CreditCard selectedCreditCard, MultiRideCardSummaryInfo summaryCardInfo) {
            Intrinsics.checkNotNullParameter(personalInfo, "personalInfo");
            Intrinsics.checkNotNullParameter(selectedPaymentType, "selectedPaymentType");
            return new CheckoutState(flowOrigin, siteInfo, multiRideCardToRefill, purchaseInfos, selectedPurchaseInfo, numberOfCharges, selectedPriceStep, totalPrice, personalInfo, selectedPaymentType, selectedCreditCard, summaryCardInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CheckoutState)) {
                return false;
            }
            CheckoutState checkoutState = (CheckoutState) other;
            return this.flowOrigin == checkoutState.flowOrigin && Intrinsics.areEqual(this.siteInfo, checkoutState.siteInfo) && Intrinsics.areEqual(this.multiRideCardToRefill, checkoutState.multiRideCardToRefill) && Intrinsics.areEqual(this.purchaseInfos, checkoutState.purchaseInfos) && Intrinsics.areEqual(this.selectedPurchaseInfo, checkoutState.selectedPurchaseInfo) && this.numberOfCharges == checkoutState.numberOfCharges && Intrinsics.areEqual(this.selectedPriceStep, checkoutState.selectedPriceStep) && Intrinsics.areEqual(this.totalPrice, checkoutState.totalPrice) && Intrinsics.areEqual(this.personalInfo, checkoutState.personalInfo) && this.selectedPaymentType == checkoutState.selectedPaymentType && Intrinsics.areEqual(this.selectedCreditCard, checkoutState.selectedCreditCard) && Intrinsics.areEqual(this.summaryCardInfo, checkoutState.summaryCardInfo);
        }

        public final PaymentOrigin getFlowOrigin() {
            return this.flowOrigin;
        }

        public final MultiRideCard getMultiRideCardToRefill() {
            return this.multiRideCardToRefill;
        }

        public final int getNumberOfCharges() {
            return this.numberOfCharges;
        }

        public final CheckoutContactInfo getPersonalInfo() {
            return this.personalInfo;
        }

        public final List<MultiRidePurchaseInfo> getPurchaseInfos() {
            return this.purchaseInfos;
        }

        public final CreditCard getSelectedCreditCard() {
            return this.selectedCreditCard;
        }

        public final PaymentType getSelectedPaymentType() {
            return this.selectedPaymentType;
        }

        public final MultiRidePriceStep getSelectedPriceStep() {
            return this.selectedPriceStep;
        }

        public final MultiRidePurchaseInfo getSelectedPurchaseInfo() {
            return this.selectedPurchaseInfo;
        }

        public final SiteInfo getSiteInfo() {
            return this.siteInfo;
        }

        public final MultiRideCardSummaryInfo getSummaryCardInfo() {
            return this.summaryCardInfo;
        }

        public final PriceWithCurrency getTotalPrice() {
            return this.totalPrice;
        }

        public int hashCode() {
            PaymentOrigin paymentOrigin = this.flowOrigin;
            int hashCode = (paymentOrigin == null ? 0 : paymentOrigin.hashCode()) * 31;
            SiteInfo siteInfo = this.siteInfo;
            int hashCode2 = (hashCode + (siteInfo == null ? 0 : siteInfo.hashCode())) * 31;
            MultiRideCard multiRideCard = this.multiRideCardToRefill;
            int hashCode3 = (hashCode2 + (multiRideCard == null ? 0 : multiRideCard.hashCode())) * 31;
            List<MultiRidePurchaseInfo> list = this.purchaseInfos;
            int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
            MultiRidePurchaseInfo multiRidePurchaseInfo = this.selectedPurchaseInfo;
            int hashCode5 = (((hashCode4 + (multiRidePurchaseInfo == null ? 0 : multiRidePurchaseInfo.hashCode())) * 31) + Integer.hashCode(this.numberOfCharges)) * 31;
            MultiRidePriceStep multiRidePriceStep = this.selectedPriceStep;
            int hashCode6 = (hashCode5 + (multiRidePriceStep == null ? 0 : multiRidePriceStep.hashCode())) * 31;
            PriceWithCurrency priceWithCurrency = this.totalPrice;
            int hashCode7 = (((((hashCode6 + (priceWithCurrency == null ? 0 : priceWithCurrency.hashCode())) * 31) + this.personalInfo.hashCode()) * 31) + this.selectedPaymentType.hashCode()) * 31;
            CreditCard creditCard = this.selectedCreditCard;
            int hashCode8 = (hashCode7 + (creditCard == null ? 0 : creditCard.hashCode())) * 31;
            MultiRideCardSummaryInfo multiRideCardSummaryInfo = this.summaryCardInfo;
            return hashCode8 + (multiRideCardSummaryInfo != null ? multiRideCardSummaryInfo.hashCode() : 0);
        }

        public String toString() {
            return "CheckoutState(flowOrigin=" + this.flowOrigin + ", siteInfo=" + this.siteInfo + ", multiRideCardToRefill=" + this.multiRideCardToRefill + ", purchaseInfos=" + this.purchaseInfos + ", selectedPurchaseInfo=" + this.selectedPurchaseInfo + ", numberOfCharges=" + this.numberOfCharges + ", selectedPriceStep=" + this.selectedPriceStep + ", totalPrice=" + this.totalPrice + ", personalInfo=" + this.personalInfo + ", selectedPaymentType=" + this.selectedPaymentType + ", selectedCreditCard=" + this.selectedCreditCard + ", summaryCardInfo=" + this.summaryCardInfo + ")";
        }

        public /* synthetic */ CheckoutState(PaymentOrigin paymentOrigin, SiteInfo siteInfo, MultiRideCard multiRideCard, List list, MultiRidePurchaseInfo multiRidePurchaseInfo, int i5, MultiRidePriceStep multiRidePriceStep, PriceWithCurrency priceWithCurrency, CheckoutContactInfo checkoutContactInfo, PaymentType paymentType, CreditCard creditCard, MultiRideCardSummaryInfo multiRideCardSummaryInfo, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? null : paymentOrigin, (i6 & 2) != 0 ? null : siteInfo, (i6 & 4) != 0 ? null : multiRideCard, (i6 & 8) != 0 ? null : list, (i6 & 16) != 0 ? null : multiRidePurchaseInfo, (i6 & 32) != 0 ? 0 : i5, (i6 & 64) != 0 ? null : multiRidePriceStep, (i6 & 128) != 0 ? null : priceWithCurrency, checkoutContactInfo, (i6 & 512) != 0 ? PaymentType.Card : paymentType, (i6 & 1024) != 0 ? null : creditCard, (i6 & 2048) != 0 ? null : multiRideCardSummaryInfo);
        }
    }
}
