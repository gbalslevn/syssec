package dk.molslinjen.ui.views.screens.profile.authentication.activation;

import dk.molslinjen.domain.managers.ManagerResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.authentication.activation.AccountActivationScreenKt$AccountActivationContent$1$1$1", f = "AccountActivationScreen.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class AccountActivationScreenKt$AccountActivationContent$1$1$1 extends SuspendLambda implements Function2<ManagerResult.Error, Continuation<? super ManagerResult.Error>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountActivationScreenKt$AccountActivationContent$1$1$1(Continuation<? super AccountActivationScreenKt$AccountActivationContent$1$1$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AccountActivationScreenKt$AccountActivationContent$1$1$1 accountActivationScreenKt$AccountActivationContent$1$1$1 = new AccountActivationScreenKt$AccountActivationContent$1$1$1(continuation);
        accountActivationScreenKt$AccountActivationContent$1$1$1.L$0 = obj;
        return accountActivationScreenKt$AccountActivationContent$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ManagerResult.Error error, Continuation<? super ManagerResult.Error> continuation) {
        return ((AccountActivationScreenKt$AccountActivationContent$1$1$1) create(error, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return (ManagerResult.Error) this.L$0;
    }
}
