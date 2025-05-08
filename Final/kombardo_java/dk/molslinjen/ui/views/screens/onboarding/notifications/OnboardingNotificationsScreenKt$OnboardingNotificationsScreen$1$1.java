package dk.molslinjen.ui.views.screens.onboarding.notifications;

import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.NavOptionsBuilderKt;
import androidx.navigation.PopUpToBuilder;
import com.ramcosta.composedestinations.generated.destinations.OnboardingNotificationsScreenDestination;
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
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.onboarding.notifications.OnboardingNotificationsScreenKt$OnboardingNotificationsScreen$1$1", f = "OnboardingNotificationsScreen.kt", l = {35}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class OnboardingNotificationsScreenKt$OnboardingNotificationsScreen$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ MainViewModel $mainViewModel;
    final /* synthetic */ DestinationsNavigator $navigator;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingNotificationsScreenKt$OnboardingNotificationsScreen$1$1(MainViewModel mainViewModel, DestinationsNavigator destinationsNavigator, Continuation<? super OnboardingNotificationsScreenKt$OnboardingNotificationsScreen$1$1> continuation) {
        super(1, continuation);
        this.$mainViewModel = mainViewModel;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(NavOptionsBuilder navOptionsBuilder) {
        navOptionsBuilder.popUpTo(OnboardingNotificationsScreenDestination.INSTANCE.getRoute(), new Function1() { // from class: dk.molslinjen.ui.views.screens.onboarding.notifications.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$1$lambda$0;
                invokeSuspend$lambda$1$lambda$0 = OnboardingNotificationsScreenKt$OnboardingNotificationsScreen$1$1.invokeSuspend$lambda$1$lambda$0((PopUpToBuilder) obj);
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
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new OnboardingNotificationsScreenKt$OnboardingNotificationsScreen$1$1(this.$mainViewModel, this.$navigator, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            MainViewModel mainViewModel = this.$mainViewModel;
            SettingsProperty.Onboarding.OnboardingNotificationsCompleted onboardingNotificationsCompleted = SettingsProperty.Onboarding.OnboardingNotificationsCompleted.INSTANCE;
            this.label = 1;
            if (mainViewModel.setOnboardingStepCompleted(onboardingNotificationsCompleted, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        DestinationsNavigator.DefaultImpls.navigate$default(this.$navigator, this.$mainViewModel.getNextOnboardingStep(), NavOptionsBuilderKt.navOptions(new Function1() { // from class: dk.molslinjen.ui.views.screens.onboarding.notifications.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                Unit invokeSuspend$lambda$1;
                invokeSuspend$lambda$1 = OnboardingNotificationsScreenKt$OnboardingNotificationsScreen$1$1.invokeSuspend$lambda$1((NavOptionsBuilder) obj2);
                return invokeSuspend$lambda$1;
            }
        }), null, 4, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((OnboardingNotificationsScreenKt$OnboardingNotificationsScreen$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
