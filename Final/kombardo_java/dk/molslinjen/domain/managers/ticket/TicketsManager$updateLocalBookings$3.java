package dk.molslinjen.domain.managers.ticket;

import dk.molslinjen.domain.localstorage.bookings.IBookingsRepository;
import dk.molslinjen.domain.managers.ticket.TicketsManager;
import dk.molslinjen.domain.model.booking.BookingHeader;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "updatedBookings", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingHeader;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.ticket.TicketsManager$updateLocalBookings$3", f = "TicketsManager.kt", l = {314, 320}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TicketsManager$updateLocalBookings$3 extends SuspendLambda implements Function2<List<? extends BookingHeader>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TicketsManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketsManager$updateLocalBookings$3(TicketsManager ticketsManager, Continuation<? super TicketsManager$updateLocalBookings$3> continuation) {
        super(2, continuation);
        this.this$0 = ticketsManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$2$lambda$0(BookingHeader bookingHeader, BookingHeader bookingHeader2) {
        return Intrinsics.areEqual(bookingHeader2.getReservationId(), bookingHeader.getReservationId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$2$lambda$1(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TicketsManager$updateLocalBookings$3 ticketsManager$updateLocalBookings$3 = new TicketsManager$updateLocalBookings$3(this.this$0, continuation);
        ticketsManager$updateLocalBookings$3.L$0 = obj;
        return ticketsManager$updateLocalBookings$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends BookingHeader> list, Continuation<? super Unit> continuation) {
        return invoke2((List<BookingHeader>) list, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<BookingHeader> list;
        List<BookingHeader> list2;
        MutableStateFlow<TicketsManager.TicketsState> ticketsState;
        TicketsManager.TicketsState value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            list = (List) this.L$0;
            IBookingsRepository iBookingsRepository = this.this$0.bookingsRepository;
            this.L$0 = list;
            this.label = 1;
            obj = iBookingsRepository.getBookings(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list2 = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                ticketsState = this.this$0.getTicketsState();
                do {
                    value = ticketsState.getValue();
                } while (!ticketsState.compareAndSet(value, TicketsManager.TicketsState.copy$default(value, list2, null, 2, null)));
                return Unit.INSTANCE;
            }
            list = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        List<BookingHeader> mutableList = CollectionsKt.toMutableList((Collection) obj);
        for (final BookingHeader bookingHeader : list) {
            final Function1 function1 = new Function1() { // from class: dk.molslinjen.domain.managers.ticket.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    boolean invokeSuspend$lambda$2$lambda$0;
                    invokeSuspend$lambda$2$lambda$0 = TicketsManager$updateLocalBookings$3.invokeSuspend$lambda$2$lambda$0(BookingHeader.this, (BookingHeader) obj2);
                    return Boolean.valueOf(invokeSuspend$lambda$2$lambda$0);
                }
            };
            mutableList.removeIf(new Predicate() { // from class: dk.molslinjen.domain.managers.ticket.f
                @Override // java.util.function.Predicate
                public final boolean test(Object obj2) {
                    boolean invokeSuspend$lambda$2$lambda$1;
                    invokeSuspend$lambda$2$lambda$1 = TicketsManager$updateLocalBookings$3.invokeSuspend$lambda$2$lambda$1(Function1.this, obj2);
                    return invokeSuspend$lambda$2$lambda$1;
                }
            });
            mutableList.add(bookingHeader);
        }
        if (mutableList.size() > 1) {
            CollectionsKt.sortWith(mutableList, new Comparator() { // from class: dk.molslinjen.domain.managers.ticket.TicketsManager$updateLocalBookings$3$invokeSuspend$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t5, T t6) {
                    return ComparisonsKt.compareValues(((BookingHeader) t5).departureDateTime(), ((BookingHeader) t6).departureDateTime());
                }
            });
        }
        IBookingsRepository iBookingsRepository2 = this.this$0.bookingsRepository;
        this.L$0 = mutableList;
        this.label = 2;
        if (iBookingsRepository2.saveAll(mutableList, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        list2 = mutableList;
        ticketsState = this.this$0.getTicketsState();
        do {
            value = ticketsState.getValue();
        } while (!ticketsState.compareAndSet(value, TicketsManager.TicketsState.copy$default(value, list2, null, 2, null)));
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<BookingHeader> list, Continuation<? super Unit> continuation) {
        return ((TicketsManager$updateLocalBookings$3) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
