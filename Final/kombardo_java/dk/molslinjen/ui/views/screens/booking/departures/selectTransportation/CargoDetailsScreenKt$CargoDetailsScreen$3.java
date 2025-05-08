package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CargoDetailsScreenKt$CargoDetailsScreen$3 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<Boolean, Unit> $dismiss;
    final /* synthetic */ boolean $isFormValid;
    final /* synthetic */ FormValidator $outboundValidator;
    final /* synthetic */ FormValidator $returnValidator;
    final /* synthetic */ CargoDetailsViewModel $viewModel;
    final /* synthetic */ CargoDetailsViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public CargoDetailsScreenKt$CargoDetailsScreen$3(boolean z5, FormValidator formValidator, FormValidator formValidator2, Context context, CargoDetailsViewModel.ViewState viewState, CargoDetailsViewModel cargoDetailsViewModel, Function1<? super Boolean, Unit> function1) {
        this.$isFormValid = z5;
        this.$outboundValidator = formValidator;
        this.$returnValidator = formValidator2;
        this.$context = context;
        this.$viewState = viewState;
        this.$viewModel = cargoDetailsViewModel;
        this.$dismiss = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(FormValidator formValidator, FormValidator formValidator2, Context context, CargoDetailsViewModel.ViewState viewState, CargoDetailsViewModel cargoDetailsViewModel) {
        DepartureDirection departureDirection;
        formValidator.submitAllFields();
        formValidator2.submitAllFields();
        String anyError = formValidator.getAnyError(context);
        String anyError2 = viewState.getHasReturn() ? formValidator2.getAnyError(context) : null;
        DepartureDirection activeDirectionTab = viewState.getActiveDirectionTab();
        DepartureDirection departureDirection2 = DepartureDirection.Outbound;
        if ((activeDirectionTab != departureDirection2 || anyError == null) && (activeDirectionTab != (departureDirection = DepartureDirection.Return) || anyError2 == null)) {
            if (activeDirectionTab != departureDirection2 && anyError != null) {
                activeDirectionTab = departureDirection2;
            } else if (activeDirectionTab != departureDirection && anyError2 != null) {
                activeDirectionTab = departureDirection;
            }
        }
        cargoDetailsViewModel.changeSection(activeDirectionTab);
        if (anyError == null) {
            anyError = anyError2;
        }
        if (anyError != null) {
            cargoDetailsViewModel.showValidationMessage(anyError);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3(CargoDetailsViewModel cargoDetailsViewModel, Function1 function1) {
        cargoDetailsViewModel.saveAndProceed(function1);
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
            ComposerKt.traceEventStart(-1783625185, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsScreen.<anonymous> (CargoDetailsScreen.kt:111)");
        }
        String stringResource = StringResources_androidKt.stringResource(R.string.cargoDetails_buttonTitle, composer, 6);
        boolean z5 = this.$isFormValid;
        composer.startReplaceGroup(-923533757);
        boolean changedInstance = composer.changedInstance(this.$outboundValidator) | composer.changedInstance(this.$returnValidator) | composer.changedInstance(this.$context) | composer.changedInstance(this.$viewState) | composer.changedInstance(this.$viewModel);
        final FormValidator formValidator = this.$outboundValidator;
        final FormValidator formValidator2 = this.$returnValidator;
        final Context context = this.$context;
        final CargoDetailsViewModel.ViewState viewState = this.$viewState;
        final CargoDetailsViewModel cargoDetailsViewModel = this.$viewModel;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = CargoDetailsScreenKt$CargoDetailsScreen$3.invoke$lambda$2$lambda$1(FormValidator.this, formValidator2, context, viewState, cargoDetailsViewModel);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function0 function0 = (Function0) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-923498451);
        boolean changedInstance2 = composer.changedInstance(this.$viewModel) | composer.changed(this.$dismiss);
        final CargoDetailsViewModel cargoDetailsViewModel2 = this.$viewModel;
        final Function1<Boolean, Unit> function1 = this.$dismiss;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$4$lambda$3;
                    invoke$lambda$4$lambda$3 = CargoDetailsScreenKt$CargoDetailsScreen$3.invoke$lambda$4$lambda$3(CargoDetailsViewModel.this, function1);
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
