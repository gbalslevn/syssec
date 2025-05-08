package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.checkout.PaymentManager;
import dk.molslinjen.domain.model.booking.BookingProcessingResult;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.shared.CurrencyType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 (2\u00020\u0001:\u0001(J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J*\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0003H&J%\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u001eJ$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH¦@¢\u0006\u0002\u0010 J\b\u0010&\u001a\u00020\u0003H&J\b\u0010'\u001a\u00020\u0003H&R\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", BuildConfig.FLAVOR, "restartPaymentFlow", BuildConfig.FLAVOR, "setPaymentOrigin", "paymentOrigin", "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "setPaymentData", "reservationNumber", BuildConfig.FLAVOR, "paymentType", "Ldk/molslinjen/domain/model/payment/PaymentType;", "bookingProcessingResult", "Ldk/molslinjen/domain/model/booking/BookingProcessingResult;", "paymentCapturedLater", BuildConfig.FLAVOR, "setPaymentCallbackReceived", "readyForPaymentStateReset", "ticketLoaded", "navigatedToReceipt", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "resetPaymentState", "clearPaymentError", "getPaymentMethodsForBooking", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/domain/model/config/Site;", "currency", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "routeId", "(Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/shared/CurrencyType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPaymentMethodsForOthers", "(Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/shared/CurrencyType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paymentState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/PaymentManager$PaymentState;", "getPaymentState", "()Lkotlinx/coroutines/flow/StateFlow;", "setPaymentCompletedAfterOrderProcessingPostPayment", "setPaymentFailedAfterOrderProcessingPostPayment", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IPaymentManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/IPaymentManager$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "defaultPaymentMethods", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/payment/PaymentType;", "getDefaultPaymentMethods", "()Ljava/util/List;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final List<PaymentType> defaultPaymentMethods = CollectionsKt.listOf(PaymentType.Card);

        private Companion() {
        }

        public final List<PaymentType> getDefaultPaymentMethods() {
            return defaultPaymentMethods;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void readyForPaymentStateReset$default(IPaymentManager iPaymentManager, Boolean bool, Boolean bool2, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readyForPaymentStateReset");
            }
            if ((i5 & 1) != 0) {
                bool = null;
            }
            if ((i5 & 2) != 0) {
                bool2 = null;
            }
            iPaymentManager.readyForPaymentStateReset(bool, bool2);
        }

        public static /* synthetic */ void setPaymentData$default(IPaymentManager iPaymentManager, String str, PaymentType paymentType, BookingProcessingResult bookingProcessingResult, boolean z5, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPaymentData");
            }
            if ((i5 & 8) != 0) {
                z5 = false;
            }
            iPaymentManager.setPaymentData(str, paymentType, bookingProcessingResult, z5);
        }
    }

    void clearPaymentError();

    Object getPaymentMethodsForBooking(Site site, CurrencyType currencyType, String str, Continuation<? super List<? extends PaymentType>> continuation);

    Object getPaymentMethodsForOthers(Site site, CurrencyType currencyType, Continuation<? super List<? extends PaymentType>> continuation);

    StateFlow<PaymentManager.PaymentState> getPaymentState();

    void readyForPaymentStateReset(Boolean ticketLoaded, Boolean navigatedToReceipt);

    void resetPaymentState();

    void restartPaymentFlow();

    void setPaymentCallbackReceived();

    void setPaymentCompletedAfterOrderProcessingPostPayment();

    void setPaymentData(String reservationNumber, PaymentType paymentType, BookingProcessingResult bookingProcessingResult, boolean paymentCapturedLater);

    void setPaymentFailedAfterOrderProcessingPostPayment();

    void setPaymentOrigin(PaymentOrigin paymentOrigin);
}
