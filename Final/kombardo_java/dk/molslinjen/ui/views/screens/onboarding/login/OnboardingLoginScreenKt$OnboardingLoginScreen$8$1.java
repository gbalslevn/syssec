package dk.molslinjen.ui.views.screens.onboarding.login;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.LoginResult;
import dk.molslinjen.ui.views.screens.profile.authentication.login.LoginViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class OnboardingLoginScreenKt$OnboardingLoginScreen$8$1 extends FunctionReferenceImpl implements Function1<Continuation<? super ManagerResult<? extends LoginResult>>, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OnboardingLoginScreenKt$OnboardingLoginScreen$8$1(Object obj) {
        super(1, obj, LoginViewModel.class, "loginAction", "loginAction(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super ManagerResult<? extends LoginResult>> continuation) {
        return ((LoginViewModel) this.receiver).loginAction(continuation);
    }
}
