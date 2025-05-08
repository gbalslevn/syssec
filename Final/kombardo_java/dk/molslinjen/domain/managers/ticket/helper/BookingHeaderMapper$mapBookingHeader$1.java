package dk.molslinjen.domain.managers.ticket.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.ticket.helper.BookingHeaderMapper", f = "BookingHeaderMapper.kt", l = {21}, m = "mapBookingHeader")
/* loaded from: classes2.dex */
public final class BookingHeaderMapper$mapBookingHeader$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BookingHeaderMapper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookingHeaderMapper$mapBookingHeader$1(BookingHeaderMapper bookingHeaderMapper, Continuation<? super BookingHeaderMapper$mapBookingHeader$1> continuation) {
        super(continuation);
        this.this$0 = bookingHeaderMapper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mapBookingHeader(null, null, this);
    }
}
