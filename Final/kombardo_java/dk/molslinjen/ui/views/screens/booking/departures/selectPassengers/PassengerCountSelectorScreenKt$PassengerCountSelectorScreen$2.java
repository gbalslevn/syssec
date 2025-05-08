package dk.molslinjen.ui.views.screens.booking.departures.selectPassengers;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
public final class PassengerCountSelectorScreenKt$PassengerCountSelectorScreen$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isFormValid;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ FormValidator $validator;
    final /* synthetic */ PassengerCountSelectorViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PassengerCountSelectorScreenKt$PassengerCountSelectorScreen$2(boolean z5, FormValidator formValidator, Context context, PassengerCountSelectorViewModel passengerCountSelectorViewModel, DestinationsNavigator destinationsNavigator) {
        this.$isFormValid = z5;
        this.$validator = formValidator;
        this.$context = context;
        this.$viewModel = passengerCountSelectorViewModel;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(FormValidator formValidator, Context context, PassengerCountSelectorViewModel passengerCountSelectorViewModel) {
        formValidator.submitAllFields();
        String anyError = formValidator.getAnyError(context);
        if (anyError != null) {
            passengerCountSelectorViewModel.showValidationMessage(anyError);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3(PassengerCountSelectorViewModel passengerCountSelectorViewModel, DestinationsNavigator destinationsNavigator) {
        passengerCountSelectorViewModel.saveAndClose(new PassengerCountSelectorScreenKt$PassengerCountSelectorScreen$2$2$1$1(destinationsNavigator));
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
            ComposerKt.traceEventStart(484629038, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorScreen.<anonymous> (PassengerCountSelectorScreen.kt:62)");
        }
        String stringResource = StringResources_androidKt.stringResource(R.string.passengers_save, composer, 6);
        boolean z5 = this.$isFormValid;
        composer.startReplaceGroup(-787246478);
        boolean changedInstance = composer.changedInstance(this.$validator) | composer.changedInstance(this.$context) | composer.changedInstance(this.$viewModel);
        final FormValidator formValidator = this.$validator;
        final Context context = this.$context;
        final PassengerCountSelectorViewModel passengerCountSelectorViewModel = this.$viewModel;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = PassengerCountSelectorScreenKt$PassengerCountSelectorScreen$2.invoke$lambda$2$lambda$1(FormValidator.this, context, passengerCountSelectorViewModel);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function0 function0 = (Function0) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-787239078);
        boolean changedInstance2 = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
        final PassengerCountSelectorViewModel passengerCountSelectorViewModel2 = this.$viewModel;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$4$lambda$3;
                    invoke$lambda$4$lambda$3 = PassengerCountSelectorScreenKt$PassengerCountSelectorScreen$2.invoke$lambda$4$lambda$3(PassengerCountSelectorViewModel.this, destinationsNavigator);
                    return invoke$lambda$4$lambda$3;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource, null, z5, false, false, 0L, function0, (Function0) rememberedValue2, composer, 0, 58);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
