package dk.molslinjen.ui.views.screens.profile.authentication.activation;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.LoginResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class AccountActivationScreenKt$AccountActivationScreen$1$1$1 extends FunctionReferenceImpl implements Function1<Continuation<? super ManagerResult<? extends LoginResult>>, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountActivationScreenKt$AccountActivationScreen$1$1$1(Object obj) {
        super(1, obj, AccountActivationViewModel.class, "activateAccountAction", "activateAccountAction(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super ManagerResult<? extends LoginResult>> continuation) {
        return ((AccountActivationViewModel) this.receiver).activateAccountAction(continuation);
    }
}
