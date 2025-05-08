package dk.molslinjen.domain.managers.ticket;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.ticket.TicketsManager;
import dk.molslinjen.domain.managers.user.merge.IAssetsMerger;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingHeader;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\n\u0010\tJ(\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\u000b\u0010\tJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H¦@¢\u0006\u0004\b\f\u0010\rJ,\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH¦@¢\u0006\u0004\b\u0013\u0010\u0014J.\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H¦@¢\u0006\u0004\b\u0019\u0010\u001aJ.\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH¦@¢\u0006\u0004\b\u001d\u0010\u001eJ&\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H¦@¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0&8&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0&8&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(¨\u0006,"}, d2 = {"Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "Ldk/molslinjen/domain/managers/user/merge/IAssetsMerger;", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "phoneNumber", BuildConfig.FLAVOR, "reservationNumber", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "addTicket", "(Ldk/molslinjen/domain/model/shared/PhoneNumber;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReturnReservationNumber", "addTicketsAfterPurchase", "updateLocalBookings", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "page", "pageSize", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingHeader;", "getTicketHistory", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "phone", "Ldk/molslinjen/domain/model/config/Site;", "site", "Ldk/molslinjen/domain/model/booking/Booking;", "getBooking", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/File;", "outputFile", "downloadReceipt", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "booking", "refund", "(Ldk/molslinjen/domain/model/booking/Booking;Ldk/molslinjen/domain/model/config/Site;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldk/molslinjen/domain/managers/ticket/TicketsManager$TicketsState;", "state", "updateActiveTicketCount", "(Ldk/molslinjen/domain/managers/ticket/TicketsManager$TicketsState;)V", "Lkotlinx/coroutines/flow/StateFlow;", "getTicketsState", "()Lkotlinx/coroutines/flow/StateFlow;", "ticketsState", "getActiveTicketsCount", "activeTicketsCount", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ITicketsManager extends IAssetsMerger {
    Object addTicket(PhoneNumber phoneNumber, String str, Continuation<? super ManagerResult<Unit>> continuation);

    Object addTicketsAfterPurchase(PhoneNumber phoneNumber, String str, Continuation<? super ManagerResult<String>> continuation);

    Object downloadReceipt(String str, String str2, File file, Continuation<? super ManagerResult<Unit>> continuation);

    StateFlow<Integer> getActiveTicketsCount();

    Object getBooking(String str, String str2, Site site, Continuation<? super ManagerResult<Booking>> continuation);

    Object getReturnReservationNumber(PhoneNumber phoneNumber, String str, Continuation<? super ManagerResult<String>> continuation);

    Object getTicketHistory(int i5, int i6, Continuation<? super ManagerResult<? extends List<BookingHeader>>> continuation);

    StateFlow<TicketsManager.TicketsState> getTicketsState();

    Object refund(Booking booking, Site site, Continuation<? super ManagerResult<Unit>> continuation);

    void updateActiveTicketCount(TicketsManager.TicketsState state);

    Object updateLocalBookings(Continuation<? super ManagerResult<Unit>> continuation);
}
