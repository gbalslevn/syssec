package dk.molslinjen.domain.managers.ticket;

import dk.molslinjen.api.services.account.booking.response.AccountBookingHeadersResponseDTO;
import dk.molslinjen.api.services.booking.response.booking.BookingHeaderResponseDTO;
import dk.molslinjen.domain.managers.ticket.helper.BookingHeaderMapper;
import dk.molslinjen.domain.managers.ticket.helper.IBookingHeaderMapper;
import dk.molslinjen.domain.model.booking.BookingHeader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingHeader;", "it", "Ldk/molslinjen/api/services/account/booking/response/AccountBookingHeadersResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.ticket.TicketsManager$updateLocalBookings$result$1", f = "TicketsManager.kt", l = {291}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TicketsManager$updateLocalBookings$result$1 extends SuspendLambda implements Function2<AccountBookingHeadersResponseDTO, Continuation<? super List<? extends BookingHeader>>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ TicketsManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketsManager$updateLocalBookings$result$1(TicketsManager ticketsManager, Continuation<? super TicketsManager$updateLocalBookings$result$1> continuation) {
        super(2, continuation);
        this.this$0 = ticketsManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TicketsManager$updateLocalBookings$result$1 ticketsManager$updateLocalBookings$result$1 = new TicketsManager$updateLocalBookings$result$1(this.this$0, continuation);
        ticketsManager$updateLocalBookings$result$1.L$0 = obj;
        return ticketsManager$updateLocalBookings$result$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(AccountBookingHeadersResponseDTO accountBookingHeadersResponseDTO, Continuation<? super List<BookingHeader>> continuation) {
        return ((TicketsManager$updateLocalBookings$result$1) create(accountBookingHeadersResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0067 -> B:5:0x006a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Map<String, BookingHeaderMapper.SiteCacheEntry> map;
        Iterator it;
        TicketsManager ticketsManager;
        Collection collection;
        IBookingHeaderMapper iBookingHeaderMapper;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            AccountBookingHeadersResponseDTO accountBookingHeadersResponseDTO = (AccountBookingHeadersResponseDTO) this.L$0;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<BookingHeaderResponseDTO> bookings = accountBookingHeadersResponseDTO.getBookings();
            TicketsManager ticketsManager2 = this.this$0;
            ArrayList arrayList = new ArrayList();
            map = linkedHashMap;
            it = bookings.iterator();
            ticketsManager = ticketsManager2;
            collection = arrayList;
            if (it.hasNext()) {
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) this.L$3;
            collection = (Collection) this.L$2;
            ticketsManager = (TicketsManager) this.L$1;
            map = (Map) this.L$0;
            ResultKt.throwOnFailure(obj);
            BookingHeader bookingHeader = (BookingHeader) obj;
            if (bookingHeader != null) {
                collection.add(bookingHeader);
            }
            if (it.hasNext()) {
                BookingHeaderResponseDTO bookingHeaderResponseDTO = (BookingHeaderResponseDTO) it.next();
                iBookingHeaderMapper = ticketsManager.bookingHeaderMapper;
                this.L$0 = map;
                this.L$1 = ticketsManager;
                this.L$2 = collection;
                this.L$3 = it;
                this.label = 1;
                obj = iBookingHeaderMapper.mapBookingHeader(bookingHeaderResponseDTO, map, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                BookingHeader bookingHeader2 = (BookingHeader) obj;
                if (bookingHeader2 != null) {
                }
                if (it.hasNext()) {
                    return CollectionsKt.sortedWith((List) collection, ComparisonsKt.compareBy(new Function1() { // from class: dk.molslinjen.domain.managers.ticket.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Comparable date;
                            date = ((BookingHeader) obj2).getDate();
                            return date;
                        }
                    }, new Function1() { // from class: dk.molslinjen.domain.managers.ticket.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Comparable departureTime;
                            departureTime = ((BookingHeader) obj2).getDepartureTime();
                            return departureTime;
                        }
                    }));
                }
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(AccountBookingHeadersResponseDTO accountBookingHeadersResponseDTO, Continuation<? super List<? extends BookingHeader>> continuation) {
        return invoke2(accountBookingHeadersResponseDTO, (Continuation<? super List<BookingHeader>>) continuation);
    }
}
