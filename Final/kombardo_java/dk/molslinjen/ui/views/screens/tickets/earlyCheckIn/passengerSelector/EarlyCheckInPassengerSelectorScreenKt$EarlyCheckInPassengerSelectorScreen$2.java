package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EarlyCheckInPassengerSelectorScreenKt$EarlyCheckInPassengerSelectorScreen$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isFormValid;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ EarlyCheckInPassengerSelectorViewModel.ViewState $state;
    final /* synthetic */ FormValidator $validator;
    final /* synthetic */ EarlyCheckInPassengerSelectorViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EarlyCheckInPassengerSelectorScreenKt$EarlyCheckInPassengerSelectorScreen$2(DestinationsNavigator destinationsNavigator, EarlyCheckInPassengerSelectorViewModel.ViewState viewState, boolean z5, FormValidator formValidator, Context context, EarlyCheckInPassengerSelectorViewModel earlyCheckInPassengerSelectorViewModel) {
        this.$navigator = destinationsNavigator;
        this.$state = viewState;
        this.$isFormValid = z5;
        this.$validator = formValidator;
        this.$context = context;
        this.$viewModel = earlyCheckInPassengerSelectorViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(FormValidator formValidator, Context context, EarlyCheckInPassengerSelectorViewModel earlyCheckInPassengerSelectorViewModel) {
        formValidator.submitAllFields();
        String anyError = formValidator.getAnyError(context);
        if (anyError != null) {
            earlyCheckInPassengerSelectorViewModel.showValidationMessage(anyError);
        }
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
            ComposerKt.traceEventStart(-159890296, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorScreen.<anonymous> (EarlyCheckInPassengerSelectorScreen.kt:80)");
        }
        String stringResource = StringResources_androidKt.stringResource(R.string.button_saveChanges, composer, 6);
        DestinationsNavigator destinationsNavigator = this.$navigator;
        composer.startReplaceGroup(-806552988);
        boolean changed = composer.changed(destinationsNavigator);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new EarlyCheckInPassengerSelectorScreenKt$EarlyCheckInPassengerSelectorScreen$2$1$1(destinationsNavigator);
            composer.updateRememberedValue(rememberedValue);
        }
        Function0 function0 = (Function0) rememberedValue;
        composer.endReplaceGroup();
        boolean z5 = !this.$state.getIsLoading() && this.$isFormValid;
        composer.startReplaceGroup(-806550916);
        boolean changedInstance = composer.changedInstance(this.$validator) | composer.changedInstance(this.$context) | composer.changedInstance(this.$viewModel);
        final FormValidator formValidator = this.$validator;
        final Context context = this.$context;
        final EarlyCheckInPassengerSelectorViewModel earlyCheckInPassengerSelectorViewModel = this.$viewModel;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = EarlyCheckInPassengerSelectorScreenKt$EarlyCheckInPassengerSelectorScreen$2.invoke$lambda$3$lambda$2(FormValidator.this, context, earlyCheckInPassengerSelectorViewModel);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource, null, z5, false, false, 0L, (Function0) rememberedValue2, function0, composer, 0, 58);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
