package dk.molslinjen.ui.views.screens.booking.payment;

import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.managers.checkout.PaymentManager;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.payment.PaymentScreenKt$PaymentScreenShared$3$1", f = "PaymentScreen.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class PaymentScreenKt$PaymentScreenShared$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PaymentManager.PaymentState $paymentState;
    final /* synthetic */ Function2<PaymentOrigin, Boolean, Unit> $proceed;
    final /* synthetic */ PaymentViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PaymentScreenKt$PaymentScreenShared$3$1(PaymentManager.PaymentState paymentState, PaymentViewModel paymentViewModel, Function2<? super PaymentOrigin, ? super Boolean, Unit> function2, Continuation<? super PaymentScreenKt$PaymentScreenShared$3$1> continuation) {
        super(2, continuation);
        this.$paymentState = paymentState;
        this.$viewModel = paymentViewModel;
        this.$proceed = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentScreenKt$PaymentScreenShared$3$1(this.$paymentState, this.$viewModel, this.$proceed, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (Intrinsics.areEqual(this.$paymentState.getPaymentAndOrderCompleted(), Boxing.boxBoolean(true))) {
            Logger.log$default(Logger.INSTANCE, "PaymentScreen paymentAndOrderCompleted == true", "PaymentProcess", 0, 4, null);
            this.$viewModel.proceed(this.$proceed);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaymentScreenKt$PaymentScreenShared$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
