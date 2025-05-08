package dk.molslinjen.ui.views.screens.booking.payment;

import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.ICreateBooking;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.model.booking.BookingCompleted;
import dk.molslinjen.domain.model.booking.BookingProcessingResult;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.booking.payment.PaymentViewModel;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.payment.PaymentViewModel$startBooking$1", f = "PaymentViewModel.kt", l = {105, 123, 138}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class PaymentViewModel$startBooking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $dismiss;
    final /* synthetic */ float $screenHeight;
    final /* synthetic */ float $screenWith;
    int label;
    final /* synthetic */ PaymentViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentViewModel$startBooking$1(PaymentViewModel paymentViewModel, float f5, float f6, Function0<Unit> function0, Continuation<? super PaymentViewModel$startBooking$1> continuation) {
        super(2, continuation);
        this.this$0 = paymentViewModel;
        this.$screenHeight = f5;
        this.$screenWith = f6;
        this.$dismiss = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentViewModel$startBooking$1(this.this$0, this.$screenHeight, this.$screenWith, this.$dismiss, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a3 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ICreateBooking createBookingHandler;
        MutableStateFlow mutableStateFlow;
        Object value;
        ISnackbarService iSnackbarService;
        IPaymentManager iPaymentManager;
        SnackbarText resourceText;
        ISnackbarService iSnackbarService2;
        SnackbarEvent.Error error;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            createBookingHandler = this.this$0.getCreateBookingHandler();
            float f5 = this.$screenHeight;
            float f6 = this.$screenWith;
            this.label = 1;
            obj = createBookingHandler.createBooking(f5, f6, this);
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
                ResultKt.throwOnFailure(obj);
                this.$dismiss.invoke();
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ManagerResult managerResult = (ManagerResult) obj;
        if (!(managerResult instanceof ManagerResult.Error)) {
            if (!(managerResult instanceof ManagerResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            ManagerResult.Success success = (ManagerResult.Success) managerResult;
            if (((BookingCompleted) success.getData()).getBookingProcessingResult() == BookingProcessingResult.Free) {
                Logger.log$default(Logger.INSTANCE, "PaymentViewModel startBooking Free", "PaymentProcess", 0, 4, null);
                iPaymentManager = this.this$0.paymentManager;
                iPaymentManager.setPaymentCallbackReceived();
                return Unit.INSTANCE;
            }
            String nullIfEmpty = StringExtensionsKt.nullIfEmpty(((BookingCompleted) success.getData()).getPaymentWindowUrl());
            String nullIfEmpty2 = StringExtensionsKt.nullIfEmpty(((BookingCompleted) success.getData()).getFallbackPaymentWindowUrl());
            if (nullIfEmpty != null) {
                mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, PaymentViewModel.ViewState.copy$default((PaymentViewModel.ViewState) value, false, nullIfEmpty, nullIfEmpty2, false, 9, null)));
                return Unit.INSTANCE;
            }
            Logger.log$default(Logger.INSTANCE, "PaymentViewModel startBooking paymentWindowUrl is null", "PaymentProcess", 0, 4, null);
            iSnackbarService = this.this$0.snackbarService;
            SnackbarEvent.Error error2 = new SnackbarEvent.Error(new SnackbarText.ResourceText(R.string.payment_failedToStart));
            this.label = 3;
            if (iSnackbarService.publishEvent(error2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this.$dismiss.invoke();
            return Unit.INSTANCE;
        }
        if (managerResult instanceof ManagerResult.Error.ErrorString) {
            ManagerResult.Error.ErrorString errorString = (ManagerResult.Error.ErrorString) managerResult;
            if (errorString.getMessage() != null) {
                Logger.INSTANCE.logCritical(new CriticalLog("PaymentViewModel startBooking error: " + errorString.getMessage()));
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
        Logger.INSTANCE.logCritical(new CriticalLog("PaymentViewModel startBooking error with default error."));
        resourceText = new SnackbarText.ResourceText(R.string.payment_failedToStart);
        iSnackbarService2 = this.this$0.snackbarService;
        error = new SnackbarEvent.Error(resourceText);
        this.label = 2;
        if (iSnackbarService2.publishEvent(error, this) == coroutine_suspended) {
        }
        this.$dismiss.invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaymentViewModel$startBooking$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
