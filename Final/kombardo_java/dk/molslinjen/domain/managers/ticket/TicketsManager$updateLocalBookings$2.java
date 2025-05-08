package dk.molslinjen.domain.managers.ticket;

import dk.molslinjen.domain.localstorage.bookings.IBookingsRepository;
import dk.molslinjen.domain.managers.ticket.TicketsManager;
import dk.molslinjen.domain.model.booking.BookingHeader;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingHeader;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.ticket.TicketsManager$updateLocalBookings$2", f = "TicketsManager.kt", l = {295}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TicketsManager$updateLocalBookings$2 extends SuspendLambda implements Function2<List<? extends BookingHeader>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TicketsManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketsManager$updateLocalBookings$2(TicketsManager ticketsManager, Continuation<? super TicketsManager$updateLocalBookings$2> continuation) {
        super(2, continuation);
        this.this$0 = ticketsManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TicketsManager$updateLocalBookings$2 ticketsManager$updateLocalBookings$2 = new TicketsManager$updateLocalBookings$2(this.this$0, continuation);
        ticketsManager$updateLocalBookings$2.L$0 = obj;
        return ticketsManager$updateLocalBookings$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends BookingHeader> list, Continuation<? super Unit> continuation) {
        return invoke2((List<BookingHeader>) list, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<BookingHeader> list;
        TicketsManager.TicketsState value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            List<BookingHeader> list2 = (List) this.L$0;
            IBookingsRepository iBookingsRepository = this.this$0.bookingsRepository;
            this.L$0 = list2;
            this.label = 1;
            if (iBookingsRepository.saveAll(list2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            list = list2;
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        MutableStateFlow<TicketsManager.TicketsState> ticketsState = this.this$0.getTicketsState();
        do {
            value = ticketsState.getValue();
        } while (!ticketsState.compareAndSet(value, TicketsManager.TicketsState.copy$default(value, list, null, 2, null)));
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<BookingHeader> list, Continuation<? super Unit> continuation) {
        return ((TicketsManager$updateLocalBookings$2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
