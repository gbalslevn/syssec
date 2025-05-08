package dk.molslinjen.domain.managers.ticket;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.ticket.TicketsManager", f = "TicketsManager.kt", l = {163, 180, 193, 201, 206}, m = "addTickets")
/* loaded from: classes2.dex */
public final class TicketsManager$addTickets$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TicketsManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketsManager$addTickets$1(TicketsManager ticketsManager, Continuation<? super TicketsManager$addTickets$1> continuation) {
        super(continuation);
        this.this$0 = ticketsManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object addTickets;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        addTickets = this.this$0.addTickets(null, this);
        return addTickets;
    }
}
