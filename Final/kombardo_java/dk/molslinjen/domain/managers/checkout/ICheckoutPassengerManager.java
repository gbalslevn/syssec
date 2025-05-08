package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J>\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000bH&J(\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010$J \u0010%\u001a\u00020&2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(2\u0006\u0010\n\u001a\u00020\u000bH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006)"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/ICheckoutPassengerManager;", BuildConfig.FLAVOR, "outboundPassengerState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", "getOutboundPassengerState", "()Lkotlinx/coroutines/flow/StateFlow;", "returnPassengerState", "getReturnPassengerState", "passengerState", "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "clear", BuildConfig.FLAVOR, "load", "site", "Ldk/molslinjen/domain/model/config/Site;", "showAgeGroup", BuildConfig.FLAVOR, "passengerInfo", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "onlySelectMe", "mergeAfterProfileChange", "(Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/booking/DepartureDirection;ZLdk/molslinjen/domain/model/booking/PassengerInfo;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleSelected", "passenger", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "addPassenger", "asSelected", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;Ldk/molslinjen/domain/model/booking/DepartureDirection;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePassenger", "updatedPassenger", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;Ldk/molslinjen/domain/model/booking/DepartureDirection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePassenger", "localPassengerId", BuildConfig.FLAVOR, "(Ljava/lang/String;Ldk/molslinjen/domain/model/booking/DepartureDirection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculatePassengerSelectionState", "Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;", "transportation", "Ldk/molslinjen/domain/model/config/Transportation;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ICheckoutPassengerManager {
    Object addPassenger(BookingPassenger bookingPassenger, DepartureDirection departureDirection, boolean z5, Continuation<? super Unit> continuation);

    ISharedPassengerSelectionViewState calculatePassengerSelectionState(PassengerInfo passengerInfo, Transportation transportation, DepartureDirection departureDirection);

    void clear();

    Object deletePassenger(String str, DepartureDirection departureDirection, Continuation<? super Unit> continuation);

    StateFlow<PassengerSelectionHelper.PassengerState> getOutboundPassengerState();

    StateFlow<PassengerSelectionHelper.PassengerState> getReturnPassengerState();

    Object load(Site site, DepartureDirection departureDirection, boolean z5, PassengerInfo passengerInfo, boolean z6, boolean z7, Continuation<? super Unit> continuation);

    StateFlow<PassengerSelectionHelper.PassengerState> passengerState(DepartureDirection departureDirection);

    void toggleSelected(BookingPassenger passenger, DepartureDirection departureDirection);

    Object updatePassenger(BookingPassenger bookingPassenger, DepartureDirection departureDirection, Continuation<? super Unit> continuation);
}
