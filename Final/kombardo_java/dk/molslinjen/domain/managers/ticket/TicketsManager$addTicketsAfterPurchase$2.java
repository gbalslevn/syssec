package dk.molslinjen.domain.managers.ticket;

import dk.molslinjen.domain.model.booking.BookingHeader;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingHeader;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.ticket.TicketsManager$addTicketsAfterPurchase$2", f = "TicketsManager.kt", l = {250, 253}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TicketsManager$addTicketsAfterPurchase$2 extends SuspendLambda implements Function2<List<? extends BookingHeader>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reservationNumber;
    final /* synthetic */ Ref$ObjectRef<String> $returnReservationNumber;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ TicketsManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketsManager$addTicketsAfterPurchase$2(Ref$ObjectRef<String> ref$ObjectRef, TicketsManager ticketsManager, String str, Continuation<? super TicketsManager$addTicketsAfterPurchase$2> continuation) {
        super(2, continuation);
        this.$returnReservationNumber = ref$ObjectRef;
        this.this$0 = ticketsManager;
        this.$reservationNumber = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TicketsManager$addTicketsAfterPurchase$2 ticketsManager$addTicketsAfterPurchase$2 = new TicketsManager$addTicketsAfterPurchase$2(this.$returnReservationNumber, this.this$0, this.$reservationNumber, continuation);
        ticketsManager$addTicketsAfterPurchase$2.L$0 = obj;
        return ticketsManager$addTicketsAfterPurchase$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(List<? extends BookingHeader> list, Continuation<? super Unit> continuation) {
        return invoke2((List<BookingHeader>) list, continuation);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00c8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x00a0 -> B:6:0x00a3). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            r0 = 1
            r1 = 2
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r12.label
            r4 = 0
            if (r3 == 0) goto L2e
            if (r3 == r0) goto L2a
            if (r3 != r1) goto L22
            java.lang.Object r3 = r12.L$3
            dk.molslinjen.domain.managers.ticket.TicketsManager$TicketsState r3 = (dk.molslinjen.domain.managers.ticket.TicketsManager.TicketsState) r3
            java.lang.Object r5 = r12.L$2
            java.lang.Object r6 = r12.L$1
            dk.molslinjen.domain.managers.ticket.TicketsManager r6 = (dk.molslinjen.domain.managers.ticket.TicketsManager) r6
            java.lang.Object r7 = r12.L$0
            kotlinx.coroutines.flow.MutableStateFlow r7 = (kotlinx.coroutines.flow.MutableStateFlow) r7
            kotlin.ResultKt.throwOnFailure(r13)
            goto La3
        L22:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L2a:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L7d
        L2e:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            java.util.List r13 = (java.util.List) r13
            r3 = r13
            java.util.Collection r3 = (java.util.Collection) r3
            int r3 = r3.size()
            if (r3 <= r0) goto L6e
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r3 = r12.$returnReservationNumber
            r5 = r13
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.lang.String r6 = r12.$reservationNumber
            java.util.Iterator r5 = r5.iterator()
        L49:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L61
            java.lang.Object r7 = r5.next()
            r8 = r7
            dk.molslinjen.domain.model.booking.BookingHeader r8 = (dk.molslinjen.domain.model.booking.BookingHeader) r8
            java.lang.String r8 = r8.getReservationId()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r6)
            if (r8 != 0) goto L49
            goto L62
        L61:
            r7 = r4
        L62:
            dk.molslinjen.domain.model.booking.BookingHeader r7 = (dk.molslinjen.domain.model.booking.BookingHeader) r7
            if (r7 == 0) goto L6b
            java.lang.String r5 = r7.getReservationId()
            goto L6c
        L6b:
            r5 = r4
        L6c:
            r3.element = r5
        L6e:
            dk.molslinjen.domain.managers.ticket.TicketsManager r3 = r12.this$0
            dk.molslinjen.domain.localstorage.bookings.IBookingsRepository r3 = dk.molslinjen.domain.managers.ticket.TicketsManager.access$getBookingsRepository$p(r3)
            r12.label = r0
            java.lang.Object r13 = r3.addBookings(r13, r12)
            if (r13 != r2) goto L7d
            return r2
        L7d:
            dk.molslinjen.domain.managers.ticket.TicketsManager r13 = r12.this$0
            kotlinx.coroutines.flow.MutableStateFlow r13 = r13.getTicketsState()
            dk.molslinjen.domain.managers.ticket.TicketsManager r3 = r12.this$0
            r7 = r13
            r6 = r3
        L87:
            java.lang.Object r5 = r7.getValue()
            r3 = r5
            dk.molslinjen.domain.managers.ticket.TicketsManager$TicketsState r3 = (dk.molslinjen.domain.managers.ticket.TicketsManager.TicketsState) r3
            dk.molslinjen.domain.localstorage.bookings.IBookingsRepository r13 = dk.molslinjen.domain.managers.ticket.TicketsManager.access$getBookingsRepository$p(r6)
            r12.L$0 = r7
            r12.L$1 = r6
            r12.L$2 = r5
            r12.L$3 = r3
            r12.label = r1
            java.lang.Object r13 = r13.getBookings(r12)
            if (r13 != r2) goto La3
            return r2
        La3:
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            dk.molslinjen.domain.managers.ticket.a r8 = new dk.molslinjen.domain.managers.ticket.a
            r8.<init>()
            dk.molslinjen.domain.managers.ticket.b r9 = new dk.molslinjen.domain.managers.ticket.b
            r9.<init>()
            kotlin.jvm.functions.Function1[] r10 = new kotlin.jvm.functions.Function1[r1]
            r11 = 0
            r10[r11] = r8
            r10[r0] = r9
            java.util.Comparator r8 = kotlin.comparisons.ComparisonsKt.compareBy(r10)
            java.util.List r13 = kotlin.collections.CollectionsKt.sortedWith(r13, r8)
            dk.molslinjen.domain.managers.ticket.TicketsManager$TicketsState r13 = dk.molslinjen.domain.managers.ticket.TicketsManager.TicketsState.copy$default(r3, r13, r4, r1, r4)
            boolean r13 = r7.compareAndSet(r5, r13)
            if (r13 == 0) goto L87
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.domain.managers.ticket.TicketsManager$addTicketsAfterPurchase$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<BookingHeader> list, Continuation<? super Unit> continuation) {
        return ((TicketsManager$addTicketsAfterPurchase$2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
