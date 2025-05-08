package dk.molslinjen.domain.localstorage.bookings;

import dk.molslinjen.domain.model.booking.BookingHeader;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\tJ\u000e\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\u0005¨\u0006\r"}, d2 = {"Ldk/molslinjen/domain/localstorage/bookings/IBookingsRepository;", BuildConfig.FLAVOR, "getBookings", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingHeader;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addBookings", BuildConfig.FLAVOR, "bookings", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAll", "clear", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IBookingsRepository {
    Object addBookings(List<BookingHeader> list, Continuation<? super Unit> continuation);

    Object clear(Continuation<? super Boolean> continuation);

    Object getBookings(Continuation<? super List<BookingHeader>> continuation);

    Object saveAll(List<BookingHeader> list, Continuation<? super Unit> continuation);
}
