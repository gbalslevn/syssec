package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInProcessingScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SimpleChangeSummaryScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.extensions.PriceWithCurrencyExtensionsKt;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EarlyCheckInScreenKt$EarlyCheckInScreen$3 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ SimpleChangeCheckoutManager.SimpleChangeCheckoutState $simpleChangeCheckoutState;
    final /* synthetic */ EarlyCheckInViewModel.ViewState $state;
    final /* synthetic */ FormValidator $validator;
    final /* synthetic */ EarlyCheckInViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EarlyCheckInScreenKt$EarlyCheckInScreen$3(SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, EarlyCheckInViewModel.ViewState viewState, FormValidator formValidator, EarlyCheckInViewModel earlyCheckInViewModel, DestinationsNavigator destinationsNavigator) {
        this.$simpleChangeCheckoutState = simpleChangeCheckoutState;
        this.$state = viewState;
        this.$validator = formValidator;
        this.$viewModel = earlyCheckInViewModel;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(FormValidator formValidator) {
        formValidator.submitAllFields();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$4(EarlyCheckInViewModel earlyCheckInViewModel, final DestinationsNavigator destinationsNavigator) {
        earlyCheckInViewModel.checkIn(new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit invoke$lambda$5$lambda$4$lambda$2;
                invoke$lambda$5$lambda$4$lambda$2 = EarlyCheckInScreenKt$EarlyCheckInScreen$3.invoke$lambda$5$lambda$4$lambda$2(DestinationsNavigator.this);
                return invoke$lambda$5$lambda$4$lambda$2;
            }
        }, new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit invoke$lambda$5$lambda$4$lambda$3;
                invoke$lambda$5$lambda$4$lambda$3 = EarlyCheckInScreenKt$EarlyCheckInScreen$3.invoke$lambda$5$lambda$4$lambda$3(DestinationsNavigator.this);
                return invoke$lambda$5$lambda$4$lambda$3;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$4$lambda$2(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SimpleChangeSummaryScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$4$lambda$3(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, EarlyCheckInProcessingScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        String stringResource;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2094885738, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInScreen.<anonymous> (EarlyCheckInScreen.kt:130)");
        }
        PriceWithCurrency nullIfZero = PriceWithCurrencyExtensionsKt.nullIfZero(this.$simpleChangeCheckoutState.getTotalPrice());
        if (nullIfZero != null && nullIfZero.getValue() > 0) {
            composer.startReplaceGroup(-2091368102);
            stringResource = StringResources_androidKt.stringResource(R.string.earlyCheckIn_payAndCheckIn, composer, 6);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-2091272126);
            stringResource = StringResources_androidKt.stringResource(R.string.earlyCheckIn_title, composer, 6);
            composer.endReplaceGroup();
        }
        String str = stringResource;
        composer.startReplaceGroup(-898739699);
        boolean z5 = false;
        if (!this.$state.getIsLoading() && ((Boolean) SnapshotStateKt.collectAsState(this.$validator.isFormValid(), null, composer, 0, 1).getValue()).booleanValue()) {
            z5 = true;
        }
        composer.endReplaceGroup();
        composer.startReplaceGroup(-898735408);
        boolean changedInstance = composer.changedInstance(this.$validator);
        final FormValidator formValidator = this.$validator;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = EarlyCheckInScreenKt$EarlyCheckInScreen$3.invoke$lambda$1$lambda$0(FormValidator.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function0 function0 = (Function0) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-898732030);
        boolean changedInstance2 = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
        final EarlyCheckInViewModel earlyCheckInViewModel = this.$viewModel;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$5$lambda$4;
                    invoke$lambda$5$lambda$4 = EarlyCheckInScreenKt$EarlyCheckInScreen$3.invoke$lambda$5$lambda$4(EarlyCheckInViewModel.this, destinationsNavigator);
                    return invoke$lambda$5$lambda$4;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(str, nullIfZero, z5, false, true, 0L, function0, (Function0) rememberedValue2, composer, 24576, 40);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
