package dk.molslinjen.ui.views.screens.tickets.details;

import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel;
import java.io.File;
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

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel$shareReceipt$1$2$1", f = "TicketDetailsViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class TicketDetailsViewModel$shareReceipt$1$2$1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $outputFile;
    int label;
    final /* synthetic */ TicketDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketDetailsViewModel$shareReceipt$1$2$1(TicketDetailsViewModel ticketDetailsViewModel, File file, Continuation<? super TicketDetailsViewModel$shareReceipt$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = ticketDetailsViewModel;
        this.$outputFile = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketDetailsViewModel$shareReceipt$1$2$1(this.this$0, this.$outputFile, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        mutableStateFlow = this.this$0._viewState;
        File file = this.$outputFile;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, TicketDetailsViewModel.ViewState.copy$default((TicketDetailsViewModel.ViewState) value, null, null, null, null, null, false, false, false, file.getAbsolutePath(), false, false, false, null, 7935, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
        return ((TicketDetailsViewModel$shareReceipt$1$2$1) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
