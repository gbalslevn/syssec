package dk.molslinjen.ui.views.screens.tickets.history;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryScreenKt$TicketHistoryContent$1$1$1$4$1", f = "TicketHistoryScreen.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class TicketHistoryScreenKt$TicketHistoryContent$1$1$1$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ Function1<Integer, Unit> $ticketIndexShown;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TicketHistoryScreenKt$TicketHistoryContent$1$1$1$4$1(Function1<? super Integer, Unit> function1, int i5, Continuation<? super TicketHistoryScreenKt$TicketHistoryContent$1$1$1$4$1> continuation) {
        super(2, continuation);
        this.$ticketIndexShown = function1;
        this.$index = i5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketHistoryScreenKt$TicketHistoryContent$1$1$1$4$1(this.$ticketIndexShown, this.$index, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$ticketIndexShown.invoke(Boxing.boxInt(this.$index));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketHistoryScreenKt$TicketHistoryContent$1$1$1$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
