package dk.molslinjen.ui.views.screens.booking.payment;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "webViewAllows", "paymentStateAllows"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.payment.PaymentViewModel$backNavigationAllowed$1", f = "PaymentViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class PaymentViewModel$backNavigationAllowed$1 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Boolean>, Object> {
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PaymentViewModel$backNavigationAllowed$1(Continuation<? super PaymentViewModel$backNavigationAllowed$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Boolean bool2, Continuation<? super Boolean> continuation) {
        return invoke(bool.booleanValue(), bool2.booleanValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Boxing.boxBoolean(this.Z$0 && this.Z$1);
    }

    public final Object invoke(boolean z5, boolean z6, Continuation<? super Boolean> continuation) {
        PaymentViewModel$backNavigationAllowed$1 paymentViewModel$backNavigationAllowed$1 = new PaymentViewModel$backNavigationAllowed$1(continuation);
        paymentViewModel$backNavigationAllowed$1.Z$0 = z5;
        paymentViewModel$backNavigationAllowed$1.Z$1 = z6;
        return paymentViewModel$backNavigationAllowed$1.invokeSuspend(Unit.INSTANCE);
    }
}
