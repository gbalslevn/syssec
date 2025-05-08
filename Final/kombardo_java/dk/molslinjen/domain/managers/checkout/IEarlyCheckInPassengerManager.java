package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.config.Transportation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\"\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u000bH¦@¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H¦@¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H¦@¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Ldk/molslinjen/domain/managers/checkout/IEarlyCheckInPassengerManager;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/Booking;", "booking", BuildConfig.FLAVOR, "load", "(Ldk/molslinjen/domain/model/booking/Booking;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "passenger", "toggleSelected", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;)V", BuildConfig.FLAVOR, "asSelected", "addPassenger", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatedPassenger", "updatePassenger", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "localPassengerId", "deletePassenger", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", "Ldk/molslinjen/domain/model/config/Transportation;", "transportation", "Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;", "calculatePassengerSelectionState", "(Ldk/molslinjen/domain/model/booking/PassengerInfo;Ldk/molslinjen/domain/model/config/Transportation;)Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", "getPassengerState", "()Lkotlinx/coroutines/flow/StateFlow;", "passengerState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IEarlyCheckInPassengerManager {
    Object addPassenger(BookingPassenger bookingPassenger, boolean z5, Continuation<? super Unit> continuation);

    ISharedPassengerSelectionViewState calculatePassengerSelectionState(PassengerInfo passengerInfo, Transportation transportation);

    Object deletePassenger(String str, Continuation<? super Unit> continuation);

    StateFlow<PassengerSelectionHelper.PassengerState> getPassengerState();

    Object load(Booking booking, Continuation<? super Unit> continuation);

    void toggleSelected(BookingPassenger passenger);

    Object updatePassenger(BookingPassenger bookingPassenger, Continuation<? super Unit> continuation);
}
