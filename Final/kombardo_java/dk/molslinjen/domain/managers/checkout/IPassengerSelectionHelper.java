package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.config.AgeClassifications;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJª\u0001\u0010\u001d\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112@\b\u0002\u0010\u0017\u001a:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0016\u0018\u00010\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015H¦@¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0015H&¢\u0006\u0004\b \u0010!J\"\u0010#\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u000eH¦@¢\u0006\u0004\b#\u0010$J\u0018\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0015H¦@¢\u0006\u0004\b&\u0010'J\u0018\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020(H¦@¢\u0006\u0004\b*\u0010+R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020-0,8&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/IPassengerSelectionHelper;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", "Ldk/molslinjen/domain/model/config/Transportation;", "transportation", "Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;", "calculatePassengerSelectionState", "(Ldk/molslinjen/domain/model/booking/PassengerInfo;Ldk/molslinjen/domain/model/config/Transportation;)Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;", BuildConfig.FLAVOR, "clear", "()V", "Ldk/molslinjen/domain/model/config/Site;", "site", BuildConfig.FLAVOR, "showAgeGroup", "onlySelectMe", "Ldk/molslinjen/domain/model/config/AgeClassifications;", "ageClassifications", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "Lkotlin/Pair;", "mergeWithPassengers", "enforceCurrentUserSelected", "enforceSelectedPassengers", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "departureDirection", "currentUserFallback", "loadPassengerState", "(Ldk/molslinjen/domain/model/config/Site;ZLdk/molslinjen/domain/model/booking/PassengerInfo;ZLdk/molslinjen/domain/model/config/AgeClassifications;Lkotlin/jvm/functions/Function2;ZLjava/util/List;Ldk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/domain/model/booking/BookingPassenger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "passenger", "toggleSelected", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;)V", "asSelected", "addPassenger", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatedPassenger", "updatePassenger", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "localPassengerId", "deletePassenger", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", "getPassengerState", "()Lkotlinx/coroutines/flow/StateFlow;", "passengerState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IPassengerSelectionHelper {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object loadPassengerState$default(IPassengerSelectionHelper iPassengerSelectionHelper, Site site, boolean z5, PassengerInfo passengerInfo, boolean z6, AgeClassifications ageClassifications, Function2 function2, boolean z7, List list, DepartureDirection departureDirection, BookingPassenger bookingPassenger, Continuation continuation, int i5, Object obj) {
            if (obj == null) {
                return iPassengerSelectionHelper.loadPassengerState(site, z5, passengerInfo, (i5 & 8) != 0 ? false : z6, ageClassifications, (i5 & 32) != 0 ? null : function2, (i5 & 64) != 0 ? false : z7, (i5 & 128) != 0 ? null : list, departureDirection, bookingPassenger, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadPassengerState");
        }
    }

    Object addPassenger(BookingPassenger bookingPassenger, boolean z5, Continuation<? super Unit> continuation);

    ISharedPassengerSelectionViewState calculatePassengerSelectionState(PassengerInfo passengerInfo, Transportation transportation);

    void clear();

    Object deletePassenger(String str, Continuation<? super Unit> continuation);

    StateFlow<PassengerSelectionHelper.PassengerState> getPassengerState();

    Object loadPassengerState(Site site, boolean z5, PassengerInfo passengerInfo, boolean z6, AgeClassifications ageClassifications, Function2<? super List<BookingPassenger>, ? super List<BookingPassenger>, ? extends Pair<? extends List<BookingPassenger>, ? extends List<BookingPassenger>>> function2, boolean z7, List<BookingPassenger> list, DepartureDirection departureDirection, BookingPassenger bookingPassenger, Continuation<? super Unit> continuation);

    void toggleSelected(BookingPassenger passenger);

    Object updatePassenger(BookingPassenger bookingPassenger, Continuation<? super Unit> continuation);
}
