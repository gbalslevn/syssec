package dk.molslinjen.ui.views.screens.profile.edit.changePassword;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChangePasswordScreenKt$ChangePasswordScreen$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ FormValidator $formValidator;
    final /* synthetic */ boolean $isLoading;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ ChangePasswordViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChangePasswordScreenKt$ChangePasswordScreen$2(FormValidator formValidator, boolean z5, ChangePasswordViewModel changePasswordViewModel, DestinationsNavigator destinationsNavigator) {
        this.$formValidator = formValidator;
        this.$isLoading = z5;
        this.$viewModel = changePasswordViewModel;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(ChangePasswordViewModel changePasswordViewModel, DestinationsNavigator destinationsNavigator) {
        changePasswordViewModel.submit(new ChangePasswordScreenKt$ChangePasswordScreen$2$1$1$1(destinationsNavigator));
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
            ComposerKt.traceEventStart(-565666660, i5, -1, "dk.molslinjen.ui.views.screens.profile.edit.changePassword.ChangePasswordScreen.<anonymous> (ChangePasswordScreen.kt:61)");
        }
        String stringResource = StringResources_androidKt.stringResource(R.string.changePassword_button, composer, 6);
        boolean z5 = ((Boolean) SnapshotStateKt.collectAsState(this.$formValidator.isFormValid(), null, composer, 0, 1).getValue()).booleanValue() && !this.$isLoading;
        boolean z6 = this.$isLoading;
        composer.startReplaceGroup(-855217620);
        boolean changedInstance = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
        final ChangePasswordViewModel changePasswordViewModel = this.$viewModel;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.edit.changePassword.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = ChangePasswordScreenKt$ChangePasswordScreen$2.invoke$lambda$1$lambda$0(ChangePasswordViewModel.this, destinationsNavigator);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource, null, z5, z6, false, 0L, null, (Function0) rememberedValue, composer, 0, 114);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
