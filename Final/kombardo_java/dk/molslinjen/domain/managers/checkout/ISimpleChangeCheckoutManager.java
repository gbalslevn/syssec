package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.AddonHelper;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingCompleted;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.payment.PaymentType;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J \u0010\r\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u001a\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH&J$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H¦@¢\u0006\u0002\u0010\"R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006#"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/ISimpleChangeCheckoutManager;", "Ldk/molslinjen/domain/managers/checkout/ICreateBooking;", "simpleChangeCheckoutState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/SimpleChangeCheckoutManager$SimpleChangeCheckoutState;", "getSimpleChangeCheckoutState", "()Lkotlinx/coroutines/flow/StateFlow;", "setup", BuildConfig.FLAVOR, "existingBooking", "Ldk/molslinjen/domain/model/booking/Booking;", "earlyCheckIn", BuildConfig.FLAVOR, "setEarlyCheckIn", "passengers", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "vehicle", "Ldk/molslinjen/domain/model/account/UserVehicle;", "selectPaymentMethod", "paymentType", "Ldk/molslinjen/domain/model/payment/PaymentType;", "creditCard", "Ldk/molslinjen/domain/model/account/CreditCard;", "updateAddons", "addonState", "Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;", "updateFood", "createBooking", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/model/booking/BookingCompleted;", "screenWidth", BuildConfig.FLAVOR, "screenHeight", "(FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ISimpleChangeCheckoutManager extends ICreateBooking {
    @Override // dk.molslinjen.domain.managers.checkout.ICreateBooking
    Object createBooking(float f5, float f6, Continuation<? super ManagerResult<BookingCompleted>> continuation);

    StateFlow<SimpleChangeCheckoutManager.SimpleChangeCheckoutState> getSimpleChangeCheckoutState();

    void selectPaymentMethod(PaymentType paymentType, CreditCard creditCard);

    void setEarlyCheckIn(List<BookingPassenger> passengers, UserVehicle vehicle);

    void setup(Booking existingBooking, boolean earlyCheckIn);

    void updateAddons(AddonHelper.AddonState addonState);

    void updateFood(AddonHelper.AddonState addonState);
}
