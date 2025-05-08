package dk.molslinjen.ui.views.screens.onboarding.login;

import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.ui.views.screens.main.MainViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.onboarding.login.OnboardingLoginScreenKt$OnboardingLoginScreen$13$1$1", f = "OnboardingLoginScreen.kt", l = {113}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class OnboardingLoginScreenKt$OnboardingLoginScreen$13$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MainViewModel $mainViewModel;
    final /* synthetic */ DestinationsNavigator $navigator;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingLoginScreenKt$OnboardingLoginScreen$13$1$1(MainViewModel mainViewModel, DestinationsNavigator destinationsNavigator, Continuation<? super OnboardingLoginScreenKt$OnboardingLoginScreen$13$1$1> continuation) {
        super(2, continuation);
        this.$mainViewModel = mainViewModel;
        this.$navigator = destinationsNavigator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingLoginScreenKt$OnboardingLoginScreen$13$1$1(this.$mainViewModel, this.$navigator, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object completeLoginOnboardingStep;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            MainViewModel mainViewModel = this.$mainViewModel;
            DestinationsNavigator destinationsNavigator = this.$navigator;
            this.label = 1;
            completeLoginOnboardingStep = OnboardingLoginScreenKt.completeLoginOnboardingStep(mainViewModel, destinationsNavigator, this);
            if (completeLoginOnboardingStep == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OnboardingLoginScreenKt$OnboardingLoginScreen$13$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
