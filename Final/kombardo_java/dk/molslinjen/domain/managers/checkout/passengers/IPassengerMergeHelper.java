package dk.molslinjen.domain.managers.checkout.passengers;

import dk.molslinjen.domain.model.booking.BookingPassenger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J<\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/passengers/IPassengerMergeHelper;", BuildConfig.FLAVOR, "mergeWithEditingPassengers", "Lkotlin/Pair;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "isEditing", BuildConfig.FLAVOR, "passengersFromBooking", "localPassengers", "mergeWithPassengersBeforeProfileChange", "previousSelectedPassengers", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IPassengerMergeHelper {
    Pair<List<BookingPassenger>, List<BookingPassenger>> mergeWithEditingPassengers(boolean isEditing, List<BookingPassenger> passengersFromBooking, List<BookingPassenger> localPassengers);

    Pair<List<BookingPassenger>, List<BookingPassenger>> mergeWithPassengersBeforeProfileChange(List<BookingPassenger> previousSelectedPassengers, List<BookingPassenger> localPassengers);
}
