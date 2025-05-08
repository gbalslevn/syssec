package dk.molslinjen.ui.views.screens.booking.payment;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.payment.PaymentScreenKt$PaymentScreenShared$1$1", f = "PaymentScreen.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class PaymentScreenKt$PaymentScreenShared$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $dismiss;
    final /* synthetic */ float $screenHeight;
    final /* synthetic */ float $screenWith;
    final /* synthetic */ PaymentViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentScreenKt$PaymentScreenShared$1$1(PaymentViewModel paymentViewModel, Function0<Unit> function0, float f5, float f6, Continuation<? super PaymentScreenKt$PaymentScreenShared$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = paymentViewModel;
        this.$dismiss = function0;
        this.$screenWith = f5;
        this.$screenHeight = f6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentScreenKt$PaymentScreenShared$1$1(this.$viewModel, this.$dismiss, this.$screenWith, this.$screenHeight, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$viewModel.startBooking(this.$dismiss, this.$screenWith, this.$screenHeight);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaymentScreenKt$PaymentScreenShared$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
