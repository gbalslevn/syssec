package dk.molslinjen.domain.managers.checkout.passengers;

import dk.molslinjen.domain.model.booking.BookingPassenger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u0004\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J<\u0010\f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/passengers/PassengerMergeHelper;", "Ldk/molslinjen/domain/managers/checkout/passengers/IPassengerMergeHelper;", "<init>", "()V", "mergeWithEditingPassengers", "Lkotlin/Pair;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "isEditing", BuildConfig.FLAVOR, "passengersFromBooking", "localPassengers", "mergeWithPassengersBeforeProfileChange", "previousSelectedPassengers", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PassengerMergeHelper implements IPassengerMergeHelper {
    @Override // dk.molslinjen.domain.managers.checkout.passengers.IPassengerMergeHelper
    public Pair<List<BookingPassenger>, List<BookingPassenger>> mergeWithEditingPassengers(boolean isEditing, List<BookingPassenger> passengersFromBooking, List<BookingPassenger> localPassengers) {
        Object obj;
        Intrinsics.checkNotNullParameter(passengersFromBooking, "passengersFromBooking");
        Intrinsics.checkNotNullParameter(localPassengers, "localPassengers");
        if (!isEditing) {
            return TuplesKt.to(localPassengers, CollectionsKt.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (BookingPassenger bookingPassenger : passengersFromBooking) {
            Iterator<T> it = localPassengers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((BookingPassenger) obj, bookingPassenger)) {
                    break;
                }
            }
            BookingPassenger bookingPassenger2 = (BookingPassenger) obj;
            if (bookingPassenger2 != null) {
                arrayList.add(bookingPassenger2);
            } else {
                arrayList2.add(bookingPassenger);
            }
        }
        List plus = CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
        return TuplesKt.to(CollectionsKt.distinct(CollectionsKt.plus((Collection) localPassengers, (Iterable) plus)), plus);
    }

    @Override // dk.molslinjen.domain.managers.checkout.passengers.IPassengerMergeHelper
    public Pair<List<BookingPassenger>, List<BookingPassenger>> mergeWithPassengersBeforeProfileChange(List<BookingPassenger> previousSelectedPassengers, List<BookingPassenger> localPassengers) {
        Object obj;
        Intrinsics.checkNotNullParameter(previousSelectedPassengers, "previousSelectedPassengers");
        Intrinsics.checkNotNullParameter(localPassengers, "localPassengers");
        if (previousSelectedPassengers.isEmpty()) {
            return TuplesKt.to(localPassengers, CollectionsKt.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (BookingPassenger bookingPassenger : previousSelectedPassengers) {
            Iterator<T> it = localPassengers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((BookingPassenger) obj, bookingPassenger)) {
                    break;
                }
            }
            BookingPassenger bookingPassenger2 = (BookingPassenger) obj;
            if (bookingPassenger2 != null) {
                arrayList.add(bookingPassenger2);
            } else {
                arrayList2.add(bookingPassenger);
            }
        }
        List plus = CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
        return TuplesKt.to(CollectionsKt.distinct(CollectionsKt.plus((Collection) localPassengers, (Iterable) plus)), plus);
    }
}
