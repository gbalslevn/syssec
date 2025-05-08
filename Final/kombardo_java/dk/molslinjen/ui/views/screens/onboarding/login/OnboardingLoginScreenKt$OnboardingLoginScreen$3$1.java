package dk.molslinjen.ui.views.screens.onboarding.login;

import androidx.compose.runtime.MutableState;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.onboarding.login.OnboardingLoginScreenKt$OnboardingLoginScreen$3$1", f = "OnboardingLoginScreen.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class OnboardingLoginScreenKt$OnboardingLoginScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ MutableState<Boolean> $forgotPasswordResult$delegate;
    final /* synthetic */ MainViewModel $mainViewModel;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ MutableState<Boolean> $signUpResult$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.onboarding.login.OnboardingLoginScreenKt$OnboardingLoginScreen$3$1$1", f = "OnboardingLoginScreen.kt", l = {87}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.onboarding.login.OnboardingLoginScreenKt$OnboardingLoginScreen$3$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MainViewModel $mainViewModel;
        final /* synthetic */ DestinationsNavigator $navigator;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MainViewModel mainViewModel, DestinationsNavigator destinationsNavigator, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$mainViewModel = mainViewModel;
            this.$navigator = destinationsNavigator;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$mainViewModel, this.$navigator, continuation);
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnboardingLoginScreenKt$OnboardingLoginScreen$3$1(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, MainViewModel mainViewModel, DestinationsNavigator destinationsNavigator, Continuation<? super OnboardingLoginScreenKt$OnboardingLoginScreen$3$1> continuation) {
        super(2, continuation);
        this.$coroutineScope = coroutineScope;
        this.$signUpResult$delegate = mutableState;
        this.$forgotPasswordResult$delegate = mutableState2;
        this.$mainViewModel = mainViewModel;
        this.$navigator = destinationsNavigator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnboardingLoginScreenKt$OnboardingLoginScreen$3$1(this.$coroutineScope, this.$signUpResult$delegate, this.$forgotPasswordResult$delegate, this.$mainViewModel, this.$navigator, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if (r7 != false) goto L8;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean OnboardingLoginScreen$lambda$1;
        boolean OnboardingLoginScreen$lambda$4;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        OnboardingLoginScreen$lambda$1 = OnboardingLoginScreenKt.OnboardingLoginScreen$lambda$1(this.$signUpResult$delegate);
        if (!OnboardingLoginScreen$lambda$1) {
            OnboardingLoginScreen$lambda$4 = OnboardingLoginScreenKt.OnboardingLoginScreen$lambda$4(this.$forgotPasswordResult$delegate);
        }
        BuildersKt__Builders_commonKt.launch$default(this.$coroutineScope, null, null, new AnonymousClass1(this.$mainViewModel, this.$navigator, null), 3, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OnboardingLoginScreenKt$OnboardingLoginScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
