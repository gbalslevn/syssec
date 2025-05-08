package dk.molslinjen.ui.views.screens.tickets.details;

import android.content.Context;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel$shareReceipt$1", f = "TicketDetailsViewModel.kt", l = {202, 206, 207, 215}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TicketDetailsViewModel$shareReceipt$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TicketDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketDetailsViewModel$shareReceipt$1(TicketDetailsViewModel ticketDetailsViewModel, Context context, Continuation<? super TicketDetailsViewModel$shareReceipt$1> continuation) {
        super(2, continuation);
        this.this$0 = ticketDetailsViewModel;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketDetailsViewModel$shareReceipt$1(this.this$0, this.$context, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00f3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f4  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ISnackbarService iSnackbarService;
        MutableStateFlow mutableStateFlow;
        Object value;
        File file;
        ITicketsManager iTicketsManager;
        Object downloadReceipt;
        TicketDetailsViewModel ticketDetailsViewModel;
        ISnackbarService iSnackbarService2;
        Object handlePotentialError;
        TicketDetailsViewModel ticketDetailsViewModel2;
        TicketDetailsViewModel$shareReceipt$1$2$1 ticketDetailsViewModel$shareReceipt$1$2$1;
        TicketDetailsViewModel ticketDetailsViewModel3;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        try {
        } catch (Exception e5) {
            Logger.INSTANCE.logError(e5);
            iSnackbarService = this.this$0.snackbarService;
            SnackbarEvent.Error error = new SnackbarEvent.Error(null, 1, null);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 4;
            if (iSnackbarService.publishEvent(error, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, TicketDetailsViewModel.ViewState.copy$default((TicketDetailsViewModel.ViewState) value, null, null, null, null, null, false, false, true, null, false, false, false, null, 8063, null)));
            TicketDetailsViewModel.ViewState value3 = this.this$0.getViewState().getValue();
            String str = value3.getReservationNumber() + ".pdf";
            File externalFilesDir = this.$context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                TicketDetailsViewModel ticketDetailsViewModel4 = this.this$0;
                file = new File(externalFilesDir, str);
                iTicketsManager = ticketDetailsViewModel4.ticketsManager;
                String reservationNumber = value3.getReservationNumber();
                String phone = value3.getPhone();
                this.L$0 = ticketDetailsViewModel4;
                this.L$1 = file;
                this.label = 1;
                downloadReceipt = iTicketsManager.downloadReceipt(reservationNumber, phone, file, this);
                if (downloadReceipt == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ticketDetailsViewModel = ticketDetailsViewModel4;
            }
            return Unit.INSTANCE;
        }
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ticketDetailsViewModel3 = (TicketDetailsViewModel) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutableStateFlow2 = ticketDetailsViewModel3._viewState;
                do {
                    value2 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value2, TicketDetailsViewModel.ViewState.copy$default((TicketDetailsViewModel.ViewState) value2, null, null, null, null, null, false, false, false, null, false, false, false, null, 8063, null)));
                return Unit.INSTANCE;
            }
            File file2 = (File) this.L$1;
            ticketDetailsViewModel2 = (TicketDetailsViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
            file = file2;
            handlePotentialError = obj;
            ticketDetailsViewModel$shareReceipt$1$2$1 = new TicketDetailsViewModel$shareReceipt$1$2$1(ticketDetailsViewModel2, file, null);
            this.L$0 = ticketDetailsViewModel2;
            this.L$1 = null;
            this.label = 3;
            if (ManagerResultExtensionsKt.onSuccess((ManagerResult) handlePotentialError, ticketDetailsViewModel$shareReceipt$1$2$1, this) != coroutine_suspended) {
                return coroutine_suspended;
            }
            ticketDetailsViewModel3 = ticketDetailsViewModel2;
            mutableStateFlow2 = ticketDetailsViewModel3._viewState;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, TicketDetailsViewModel.ViewState.copy$default((TicketDetailsViewModel.ViewState) value2, null, null, null, null, null, false, false, false, null, false, false, false, null, 8063, null)));
            return Unit.INSTANCE;
        }
        File file3 = (File) this.L$1;
        ticketDetailsViewModel = (TicketDetailsViewModel) this.L$0;
        ResultKt.throwOnFailure(obj);
        file = file3;
        downloadReceipt = obj;
        iSnackbarService2 = ticketDetailsViewModel.snackbarService;
        this.L$0 = ticketDetailsViewModel;
        this.L$1 = file;
        this.label = 2;
        handlePotentialError = dk.molslinjen.extensions.ManagerResultExtensionsKt.handlePotentialError((ManagerResult) downloadReceipt, iSnackbarService2, this);
        if (handlePotentialError == coroutine_suspended) {
            return coroutine_suspended;
        }
        ticketDetailsViewModel2 = ticketDetailsViewModel;
        ticketDetailsViewModel$shareReceipt$1$2$1 = new TicketDetailsViewModel$shareReceipt$1$2$1(ticketDetailsViewModel2, file, null);
        this.L$0 = ticketDetailsViewModel2;
        this.L$1 = null;
        this.label = 3;
        if (ManagerResultExtensionsKt.onSuccess((ManagerResult) handlePotentialError, ticketDetailsViewModel$shareReceipt$1$2$1, this) != coroutine_suspended) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketDetailsViewModel$shareReceipt$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
