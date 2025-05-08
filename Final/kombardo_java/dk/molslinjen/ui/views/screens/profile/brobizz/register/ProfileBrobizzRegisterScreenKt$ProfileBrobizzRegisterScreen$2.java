package dk.molslinjen.ui.views.screens.profile.brobizz.register;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.screens.profile.brobizz.register.ProfileBrobizzRegisterViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KFunction;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileBrobizzRegisterScreenKt$ProfileBrobizzRegisterScreen$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $isFormValid;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ FormValidator $validator;
    final /* synthetic */ ProfileBrobizzRegisterViewModel $viewModel;
    final /* synthetic */ ProfileBrobizzRegisterViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfileBrobizzRegisterScreenKt$ProfileBrobizzRegisterScreen$2(FormValidator formValidator, boolean z5, ProfileBrobizzRegisterViewModel.ViewState viewState, ProfileBrobizzRegisterViewModel profileBrobizzRegisterViewModel, DestinationsNavigator destinationsNavigator) {
        this.$validator = formValidator;
        this.$isFormValid = z5;
        this.$viewState = viewState;
        this.$viewModel = profileBrobizzRegisterViewModel;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(ProfileBrobizzRegisterViewModel profileBrobizzRegisterViewModel, DestinationsNavigator destinationsNavigator) {
        profileBrobizzRegisterViewModel.registerBrobizz(new ProfileBrobizzRegisterScreenKt$ProfileBrobizzRegisterScreen$2$2$1$1(destinationsNavigator));
        return Unit.INSTANCE;
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
            ComposerKt.traceEventStart(-1665528847, i5, -1, "dk.molslinjen.ui.views.screens.profile.brobizz.register.ProfileBrobizzRegisterScreen.<anonymous> (ProfileBrobizzRegisterScreen.kt:43)");
        }
        String stringResource = StringResources_androidKt.stringResource(R.string.profile_brobizz_register, composer, 6);
        FormValidator formValidator = this.$validator;
        composer.startReplaceGroup(1395688382);
        boolean changedInstance = composer.changedInstance(formValidator);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new ProfileBrobizzRegisterScreenKt$ProfileBrobizzRegisterScreen$2$1$1(formValidator);
            composer.updateRememberedValue(rememberedValue);
        }
        KFunction kFunction = (KFunction) rememberedValue;
        composer.endReplaceGroup();
        boolean z5 = this.$isFormValid && !this.$viewState.getIsLoading();
        boolean isLoading = this.$viewState.getIsLoading();
        Function0 function0 = (Function0) kFunction;
        composer.startReplaceGroup(1395685530);
        boolean changedInstance2 = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
        final ProfileBrobizzRegisterViewModel profileBrobizzRegisterViewModel = this.$viewModel;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.brobizz.register.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = ProfileBrobizzRegisterScreenKt$ProfileBrobizzRegisterScreen$2.invoke$lambda$2$lambda$1(ProfileBrobizzRegisterViewModel.this, destinationsNavigator);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource, null, z5, isLoading, false, 0L, function0, (Function0) rememberedValue2, composer, 0, 50);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
