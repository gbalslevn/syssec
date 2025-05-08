package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.AddonHelper;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.SummaryAddonHelper;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.product.CheckoutSeatReservation;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\u0010J\u0019\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001eH&¢\u0006\u0004\b#\u0010!J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0016H&¢\u0006\u0004\b%\u0010\u0019J\u001f\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b(\u0010)J\u001f\u0010*\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b*\u0010)J\u0017\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+H&¢\u0006\u0004\b-\u0010.J\u001f\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020/2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b1\u00102J'\u00107\u001a\b\u0012\u0004\u0012\u00020\u0006062\b\u00104\u001a\u0004\u0018\u0001032\u0006\u00105\u001a\u00020\tH&¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0006H&¢\u0006\u0004\b9\u0010\u0010R\u001c\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:0\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001c\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010<R\u001c\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010<¨\u0006B"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/ICheckoutManager;", "Ldk/molslinjen/domain/managers/checkout/ICreateBooking;", "Ldk/molslinjen/domain/model/payment/PaymentType;", "paymentType", "Ldk/molslinjen/domain/model/account/CreditCard;", "creditCard", BuildConfig.FLAVOR, "selectPaymentMethod", "(Ldk/molslinjen/domain/model/payment/PaymentType;Ldk/molslinjen/domain/model/account/CreditCard;)V", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "departureDirection", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;", "directionState", "(Ldk/molslinjen/domain/model/booking/DepartureDirection;)Lkotlinx/coroutines/flow/StateFlow;", "toggleNewsletterSignup", "()V", "toggleAcceptMarketing", "Ldk/molslinjen/domain/model/account/UserVehicle;", "vehicle", "updateSelectedVehicle", "(Ldk/molslinjen/domain/model/account/UserVehicle;)V", BuildConfig.FLAVOR, "earlyCheckIn", "updateEarlyCheckIn", "(Z)V", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "phoneNumber", "updatePhoneNumber", "(Ldk/molslinjen/domain/model/shared/PhoneNumber;)V", BuildConfig.FLAVOR, "email", "updateEmail", "(Ljava/lang/String;)V", "postalCode", "updatePostalCode", "isAddingReturnFromBookingSummary", "setup", "Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;", "addonState", "updateAddons", "(Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;Ldk/molslinjen/domain/model/booking/DepartureDirection;)V", "updateFood", "Ldk/molslinjen/domain/managers/checkout/SummaryAddonHelper$SummaryAddonState;", "summaryAddonState", "updateSummaryAddons", "(Ldk/molslinjen/domain/managers/checkout/SummaryAddonHelper$SummaryAddonState;)V", BuildConfig.FLAVOR, "passengerCount", "updatePassengerCount", "(ILdk/molslinjen/domain/model/booking/DepartureDirection;)V", "Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;", "seatReservation", "direction", "Ldk/molslinjen/domain/managers/ManagerResult;", "setSeatReservation", "(Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;Ldk/molslinjen/domain/model/booking/DepartureDirection;)Ldk/molslinjen/domain/managers/ManagerResult;", "clearReturnState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "getCheckoutState", "()Lkotlinx/coroutines/flow/StateFlow;", "checkoutState", "getOutboundDirectionState", "outboundDirectionState", "getReturnDirectionState", "returnDirectionState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ICheckoutManager extends ICreateBooking {
    void clearReturnState();

    StateFlow<CheckoutManager.CheckoutDirectionState> directionState(DepartureDirection departureDirection);

    StateFlow<CheckoutManager.CheckoutState> getCheckoutState();

    StateFlow<CheckoutManager.CheckoutDirectionState> getOutboundDirectionState();

    StateFlow<CheckoutManager.CheckoutDirectionState> getReturnDirectionState();

    void selectPaymentMethod(PaymentType paymentType, CreditCard creditCard);

    ManagerResult<Unit> setSeatReservation(CheckoutSeatReservation seatReservation, DepartureDirection direction);

    void setup(boolean isAddingReturnFromBookingSummary);

    void toggleAcceptMarketing();

    void toggleNewsletterSignup();

    void updateAddons(AddonHelper.AddonState addonState, DepartureDirection departureDirection);

    void updateEarlyCheckIn(boolean earlyCheckIn);

    void updateEmail(String email);

    void updateFood(AddonHelper.AddonState addonState, DepartureDirection departureDirection);

    void updatePassengerCount(int passengerCount, DepartureDirection departureDirection);

    void updatePhoneNumber(PhoneNumber phoneNumber);

    void updatePostalCode(String postalCode);

    void updateSelectedVehicle(UserVehicle vehicle);

    void updateSummaryAddons(SummaryAddonHelper.SummaryAddonState summaryAddonState);
}
