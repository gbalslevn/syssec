package dk.molslinjen.ui.views.screens.tickets;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.screens.tickets.TicketsViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.TicketsViewModel$loadTickets$1", f = "TicketsViewModel.kt", l = {68, 68}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TicketsViewModel$loadTickets$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TicketsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketsViewModel$loadTickets$1(TicketsViewModel ticketsViewModel, Continuation<? super TicketsViewModel$loadTickets$1> continuation) {
        super(2, continuation);
        this.this$0 = ticketsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketsViewModel$loadTickets$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object value;
        ISnackbarService iSnackbarService;
        MutableStateFlow mutableStateFlow;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow mutableStateFlow2 = this.this$0._viewState;
            do {
                value = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value, TicketsViewModel.ViewState.copy$default((TicketsViewModel.ViewState) value, null, null, null, true, 7, null)));
            ITicketsManager iTicketsManager = this.this$0.ticketsManager;
            this.label = 1;
            obj = iTicketsManager.updateLocalBookings(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                mutableStateFlow = this.this$0._viewState;
                do {
                    value2 = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value2, TicketsViewModel.ViewState.copy$default((TicketsViewModel.ViewState) value2, null, null, null, false, 7, null)));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        iSnackbarService = this.this$0.snackbarService;
        this.label = 2;
        if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        mutableStateFlow = this.this$0._viewState;
        do {
            value2 = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value2, TicketsViewModel.ViewState.copy$default((TicketsViewModel.ViewState) value2, null, null, null, false, 7, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketsViewModel$loadTickets$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
