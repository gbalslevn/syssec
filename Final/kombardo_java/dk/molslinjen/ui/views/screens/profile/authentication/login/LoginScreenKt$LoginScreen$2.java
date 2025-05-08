package dk.molslinjen.ui.views.screens.profile.authentication.login;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.screens.profile.authentication.login.LoginScreenKt$LoginScreen$2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoginScreenKt$LoginScreen$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $isButtonEnabled;
    final /* synthetic */ boolean $isButtonVisible;
    final /* synthetic */ FormValidator $validator;
    final /* synthetic */ LoginViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: dk.molslinjen.ui.views.screens.profile.authentication.login.LoginScreenKt$LoginScreen$2$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass3 implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
        final /* synthetic */ boolean $isButtonEnabled;
        final /* synthetic */ FormValidator $validator;
        final /* synthetic */ LoginViewModel $viewModel;

        AnonymousClass3(LoginViewModel loginViewModel, boolean z5, FormValidator formValidator) {
            this.$viewModel = loginViewModel;
            this.$isButtonEnabled = z5;
            this.$validator = formValidator;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$2$lambda$1(FormValidator formValidator) {
            formValidator.submitAllFields();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
            invoke(animatedVisibilityScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i5) {
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1748849294, i5, -1, "dk.molslinjen.ui.views.screens.profile.authentication.login.LoginScreen.<anonymous>.<anonymous> (LoginScreen.kt:70)");
            }
            String stringResource = StringResources_androidKt.stringResource(R.string.login_cta, composer, 6);
            LoginViewModel loginViewModel = this.$viewModel;
            composer.startReplaceGroup(-3807143);
            boolean changedInstance = composer.changedInstance(loginViewModel);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new LoginScreenKt$LoginScreen$2$3$1$1(loginViewModel);
                composer.updateRememberedValue(rememberedValue);
            }
            KFunction kFunction = (KFunction) rememberedValue;
            composer.endReplaceGroup();
            boolean z5 = this.$isButtonEnabled;
            composer.startReplaceGroup(-3803615);
            boolean changedInstance2 = composer.changedInstance(this.$validator);
            final FormValidator formValidator = this.$validator;
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.login.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$2$lambda$1;
                        invoke$lambda$2$lambda$1 = LoginScreenKt$LoginScreen$2.AnonymousClass3.invoke$lambda$2$lambda$1(FormValidator.this);
                        return invoke$lambda$2$lambda$1;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource, null, z5, false, false, 0L, (Function0) rememberedValue2, (Function0) kFunction, composer, 0, 58);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginScreenKt$LoginScreen$2(boolean z5, LoginViewModel loginViewModel, boolean z6, FormValidator formValidator) {
        this.$isButtonVisible = z5;
        this.$viewModel = loginViewModel;
        this.$isButtonEnabled = z6;
        this.$validator = formValidator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int invoke$lambda$1$lambda$0(int i5) {
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int invoke$lambda$3$lambda$2(int i5) {
        return i5;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1252144714, i5, -1, "dk.molslinjen.ui.views.screens.profile.authentication.login.LoginScreen.<anonymous> (LoginScreen.kt:65)");
        }
        boolean z5 = this.$isButtonVisible;
        composer.startReplaceGroup(711407881);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.login.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    int invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = LoginScreenKt$LoginScreen$2.invoke$lambda$1$lambda$0(((Integer) obj).intValue());
                    return Integer.valueOf(invoke$lambda$1$lambda$0);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        EnterTransition slideInVertically$default = EnterExitTransitionKt.slideInVertically$default(null, (Function1) rememberedValue, 1, null);
        composer.startReplaceGroup(711409481);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.login.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    int invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = LoginScreenKt$LoginScreen$2.invoke$lambda$3$lambda$2(((Integer) obj).intValue());
                    return Integer.valueOf(invoke$lambda$3$lambda$2);
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        AnimatedVisibilityKt.AnimatedVisibility(z5, null, slideInVertically$default, EnterExitTransitionKt.slideOutVertically$default(null, (Function1) rememberedValue2, 1, null), null, ComposableLambdaKt.rememberComposableLambda(1748849294, true, new AnonymousClass3(this.$viewModel, this.$isButtonEnabled, this.$validator), composer, 54), composer, 200064, 18);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
