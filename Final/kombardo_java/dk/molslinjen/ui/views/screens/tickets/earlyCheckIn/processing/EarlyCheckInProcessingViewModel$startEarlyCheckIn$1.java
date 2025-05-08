package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing;

import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager;
import dk.molslinjen.domain.model.booking.BookingCompleted;
import dk.molslinjen.domain.model.booking.BookingProcessingResult;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.EarlyCheckInProcessingViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.EarlyCheckInProcessingViewModel$startEarlyCheckIn$1", f = "EarlyCheckInProcessingViewModel.kt", l = {31, 40, 45}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class EarlyCheckInProcessingViewModel$startEarlyCheckIn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $dismiss;
    final /* synthetic */ float $screenHeight;
    final /* synthetic */ float $screenWidth;
    Object L$0;
    int label;
    final /* synthetic */ EarlyCheckInProcessingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarlyCheckInProcessingViewModel$startEarlyCheckIn$1(EarlyCheckInProcessingViewModel earlyCheckInProcessingViewModel, float f5, float f6, Function0<Unit> function0, Continuation<? super EarlyCheckInProcessingViewModel$startEarlyCheckIn$1> continuation) {
        super(2, continuation);
        this.this$0 = earlyCheckInProcessingViewModel;
        this.$screenWidth = f5;
        this.$screenHeight = f6;
        this.$dismiss = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EarlyCheckInProcessingViewModel$startEarlyCheckIn$1(this.this$0, this.$screenWidth, this.$screenHeight, this.$dismiss, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007b A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ISimpleChangeCheckoutManager iSimpleChangeCheckoutManager;
        MutableStateFlow mutableStateFlow;
        Object value;
        ISnackbarService iSnackbarService;
        ManagerResult managerResult;
        SnackbarText resourceText;
        ISnackbarService iSnackbarService2;
        SnackbarEvent.Error error;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iSimpleChangeCheckoutManager = this.this$0.simpleChangeCheckoutManager;
            float f5 = this.$screenWidth;
            float f6 = this.$screenHeight;
            this.label = 1;
            obj = iSimpleChangeCheckoutManager.createBooking(f5, f6, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 == 2) {
                    ResultKt.throwOnFailure(obj);
                    this.$dismiss.invoke();
                    return Unit.INSTANCE;
                }
                if (i5 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                managerResult = (ManagerResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                Logger.INSTANCE.logCritical(new CriticalLog("Early check-in without extra products required payment - should not be possible! " + ((BookingCompleted) ((ManagerResult.Success) managerResult).getData()).getOutboundReservationNumber()));
                this.$dismiss.invoke();
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ManagerResult managerResult2 = (ManagerResult) obj;
        if (managerResult2 instanceof ManagerResult.Error) {
            if (managerResult2 instanceof ManagerResult.Error.ErrorString) {
                ManagerResult.Error.ErrorString errorString = (ManagerResult.Error.ErrorString) managerResult2;
                if (errorString.getMessage() != null) {
                    String message = errorString.getMessage();
                    resourceText = message != null ? new SnackbarText.StringText(message) : null;
                    iSnackbarService2 = this.this$0.snackbarService;
                    error = new SnackbarEvent.Error(resourceText);
                    this.label = 2;
                    if (iSnackbarService2.publishEvent(error, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.$dismiss.invoke();
                    return Unit.INSTANCE;
                }
            }
            resourceText = new SnackbarText.ResourceText(R.string.payment_failedToStart);
            iSnackbarService2 = this.this$0.snackbarService;
            error = new SnackbarEvent.Error(resourceText);
            this.label = 2;
            if (iSnackbarService2.publishEvent(error, this) == coroutine_suspended) {
            }
            this.$dismiss.invoke();
            return Unit.INSTANCE;
        }
        if (!(managerResult2 instanceof ManagerResult.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        if (((BookingCompleted) ((ManagerResult.Success) managerResult2).getData()).getBookingProcessingResult() == BookingProcessingResult.Free) {
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ((EarlyCheckInProcessingViewModel.ViewState) value).copy(true)));
            return Unit.INSTANCE;
        }
        iSnackbarService = this.this$0.snackbarService;
        SnackbarEvent.Error error2 = new SnackbarEvent.Error(new SnackbarText.ResourceText(R.string.payment_failedToStart));
        this.L$0 = managerResult2;
        this.label = 3;
        if (iSnackbarService.publishEvent(error2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        managerResult = managerResult2;
        Logger.INSTANCE.logCritical(new CriticalLog("Early check-in without extra products required payment - should not be possible! " + ((BookingCompleted) ((ManagerResult.Success) managerResult).getData()).getOutboundReservationNumber()));
        this.$dismiss.invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EarlyCheckInProcessingViewModel$startEarlyCheckIn$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
