package dk.molslinjen.ui.views.screens.profile.authentication.password.reset;

import dk.molslinjen.domain.managers.ManagerResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class ResetPasswordScreenKt$ResetPasswordScreen$2$1$4$1 extends FunctionReferenceImpl implements Function2<ManagerResult.Error, Continuation<? super ManagerResult.Error>, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ResetPasswordScreenKt$ResetPasswordScreen$2$1$4$1(Object obj) {
        super(2, obj, ResetPasswordViewModel.class, "resetPasswordFailure", "resetPasswordFailure(Ldk/molslinjen/domain/managers/ManagerResult$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ManagerResult.Error error, Continuation<? super ManagerResult.Error> continuation) {
        return ((ResetPasswordViewModel) this.receiver).resetPasswordFailure(error, continuation);
    }
}
