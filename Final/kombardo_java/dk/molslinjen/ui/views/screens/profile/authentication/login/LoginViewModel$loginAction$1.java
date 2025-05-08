package dk.molslinjen.ui.views.screens.profile.authentication.login;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.profile.authentication.login.LoginViewModel", f = "LoginViewModel.kt", l = {43, 46}, m = "loginAction")
/* loaded from: classes2.dex */
public final class LoginViewModel$loginAction$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginViewModel$loginAction$1(LoginViewModel loginViewModel, Continuation<? super LoginViewModel$loginAction$1> continuation) {
        super(continuation);
        this.this$0 = loginViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loginAction(this);
    }
}
