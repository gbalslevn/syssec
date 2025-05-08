package dk.molslinjen.ui.views.screens.tickets.history;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class TicketHistoryScreenKt$TicketHistoryScreen$2$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TicketHistoryScreenKt$TicketHistoryScreen$2$1(Object obj) {
        super(1, obj, TicketHistoryViewModel.class, "ticketIndexShown", "ticketIndexShown(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i5) {
        ((TicketHistoryViewModel) this.receiver).ticketIndexShown(i5);
    }
}
