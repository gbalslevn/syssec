package dk.molslinjen.domain.managers.ticket;

import dk.molslinjen.domain.model.booking.BookingHeader;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingHeader;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.ticket.TicketsManager$getReturnReservationNumber$2", f = "TicketsManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TicketsManager$getReturnReservationNumber$2 extends SuspendLambda implements Function2<List<? extends BookingHeader>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reservationNumber;
    final /* synthetic */ Ref$ObjectRef<String> $returnReservationNumber;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketsManager$getReturnReservationNumber$2(Ref$ObjectRef<String> ref$ObjectRef, String str, Continuation<? super TicketsManager$getReturnReservationNumber$2> continuation) {
        super(2, continuation);
        this.$returnReservationNumber = ref$ObjectRef;
        this.$reservationNumber = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TicketsManager$getReturnReservationNumber$2 ticketsManager$getReturnReservationNumber$2 = new TicketsManager$getReturnReservationNumber$2(this.$returnReservationNumber, this.$reservationNumber, continuation);
        ticketsManager$getReturnReservationNumber$2.L$0 = obj;
        return ticketsManager$getReturnReservationNumber$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends BookingHeader> list, Continuation<? super Unit> continuation) {
        return invoke2((List<BookingHeader>) list, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List list = (List) this.L$0;
        if (list.size() > 1) {
            Ref$ObjectRef<String> ref$ObjectRef = this.$returnReservationNumber;
            String str = this.$reservationNumber;
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (!Intrinsics.areEqual(((BookingHeader) obj2).getReservationId(), str)) {
                    break;
                }
            }
            BookingHeader bookingHeader = (BookingHeader) obj2;
            ref$ObjectRef.element = bookingHeader != null ? bookingHeader.getReservationId() : 0;
        }
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<BookingHeader> list, Continuation<? super Unit> continuation) {
        return ((TicketsManager$getReturnReservationNumber$2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
