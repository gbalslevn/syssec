package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.checkout.EditManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\bH&J<\u0010\r\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/IEditManager;", BuildConfig.FLAVOR, "editState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;", "getEditState", "()Lkotlinx/coroutines/flow/StateFlow;", "startEdit", BuildConfig.FLAVOR, "booking", "Ldk/molslinjen/domain/model/booking/Booking;", "clear", "stopEdit", "mergeWithEditingPassengers", "Lkotlin/Pair;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "localPassengers", "previouslySelectedPassengers", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IEditManager {
    void clear();

    StateFlow<EditManager.EditState> getEditState();

    Pair<List<BookingPassenger>, List<BookingPassenger>> mergeWithEditingPassengers(List<BookingPassenger> localPassengers, List<BookingPassenger> previouslySelectedPassengers);

    void startEdit(Booking booking);

    void stopEdit();
}
