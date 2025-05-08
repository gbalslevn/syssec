package dk.molslinjen.ui.views.screens.onboarding.login;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.ui.views.screens.profile.authentication.login.LoginViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class OnboardingLoginScreenKt$OnboardingLoginScreen$9$1 extends FunctionReferenceImpl implements Function2<ManagerResult.Error, Continuation<? super ManagerResult.Error>, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OnboardingLoginScreenKt$OnboardingLoginScreen$9$1(Object obj) {
        super(2, obj, LoginViewModel.class, "loginFailure", "loginFailure(Ldk/molslinjen/domain/managers/ManagerResult$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ManagerResult.Error error, Continuation<? super ManagerResult.Error> continuation) {
        return ((LoginViewModel) this.receiver).loginFailure(error, continuation);
    }
}
