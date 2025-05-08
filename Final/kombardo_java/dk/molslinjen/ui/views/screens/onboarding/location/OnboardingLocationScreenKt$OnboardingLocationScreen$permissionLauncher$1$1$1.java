package dk.molslinjen.ui.views.screens.onboarding.location;

import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.NavOptionsBuilderKt;
import androidx.navigation.PopUpToBuilder;
import com.ramcosta.composedestinations.generated.destinations.OnboardingLocationScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import dk.molslinjen.ui.views.screens.main.MainViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.onboarding.location.OnboardingLocationScreenKt$OnboardingLocationScreen$permissionLauncher$1$1$1", f = "OnboardingLocationScreen.kt", l = {43}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class OnboardingLocationScreenKt$OnboardingLocationScreen$permissionLauncher$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $granted;
    final /* synthetic */ MainViewModel $mainViewModel;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ OnboardingLocationViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingLocationScreenKt$OnboardingLocationScreen$permissionLauncher$1$1$1(DestinationsNavigator destinationsNavigator, MainViewModel mainViewModel, OnboardingLocationViewModel onboardingLocationViewModel, boolean z5, Continuation<? super OnboardingLocationScreenKt$OnboardingLocationScreen$permissionLauncher$1$1$1> continuation) {
        super(2, continuation);
        this.$navigator = destinationsNavigator;
        this.$mainViewModel = mainViewModel;
        this.$viewModel = onboardingLocationViewModel;
        this.$granted = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(NavOptionsBuilder navOptionsBuilder) {
        navOptionsBuilder.popUpTo(OnboardingLocationScreenDestination.INSTANCE.getRoute(), new Function1() { // from class: dk.molslinjen.ui.views.screens.onboarding.location.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$1$lambda$0;
                invokeSuspend$lambda$1$lambda$0 = OnboardingLocationScreenKt$OnboardingLocationScreen$permissionLauncher$1$1$1.invokeSuspend$lambda$1$lambda$0((PopUpToBuilder) obj);
                return invokeSuspend$lambda$1$lambda$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$lambda$0(PopUpToBuilder popUpToBuilder) {
        popUpToBuilder.setInclusive(true);
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingLocationScreenKt$OnboardingLocationScreen$permissionLauncher$1$1$1(this.$navigator, this.$mainViewModel, this.$viewModel, this.$granted, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            DestinationsNavigator.DefaultImpls.navigate$default(this.$navigator, this.$mainViewModel.getNextOnboardingStep(), NavOptionsBuilderKt.navOptions(new Function1() { // from class: dk.molslinjen.ui.views.screens.onboarding.location.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = OnboardingLocationScreenKt$OnboardingLocationScreen$permissionLauncher$1$1$1.invokeSuspend$lambda$1((NavOptionsBuilder) obj2);
                    return invokeSuspend$lambda$1;
                }
            }), null, 4, null);
            this.$viewModel.onLocationChanged(this.$granted);
            MainViewModel mainViewModel = this.$mainViewModel;
            SettingsProperty.Onboarding.OnboardingLocationCompleted onboardingLocationCompleted = SettingsProperty.Onboarding.OnboardingLocationCompleted.INSTANCE;
            this.label = 1;
            if (mainViewModel.setOnboardingStepCompleted(onboardingLocationCompleted, this) == coroutine_suspended) {
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
        return ((OnboardingLocationScreenKt$OnboardingLocationScreen$permissionLauncher$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
