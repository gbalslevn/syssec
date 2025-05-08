package dk.molslinjen.ui.views.screens.onboarding.login;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.onboarding.login.OnboardingLoginScreenKt", f = "OnboardingLoginScreen.kt", l = {121}, m = "completeLoginOnboardingStep")
/* loaded from: classes2.dex */
public final class OnboardingLoginScreenKt$completeLoginOnboardingStep$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnboardingLoginScreenKt$completeLoginOnboardingStep$1(Continuation<? super OnboardingLoginScreenKt$completeLoginOnboardingStep$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object completeLoginOnboardingStep;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        completeLoginOnboardingStep = OnboardingLoginScreenKt.completeLoginOnboardingStep(null, null, this);
        return completeLoginOnboardingStep;
    }
}
