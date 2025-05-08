package dk.molslinjen.ui.views.screens.booking.simpleChange;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.ramcosta.composedestinations.generated.destinations.PaymentBottomSheetScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeSummaryViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SimpleChangeSummaryScreenKt$SimpleChangeSummaryScreen$2 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ BottomSheetDismissHandler $bottomSheetDismissHandler;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ SimpleChangeCheckoutManager.SimpleChangeCheckoutState $simpleChangeCheckoutState;
    final /* synthetic */ SimpleChangeSummaryViewModel.ViewState $state;
    final /* synthetic */ FormValidator $validator;
    final /* synthetic */ SimpleChangeSummaryViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleChangeSummaryScreenKt$SimpleChangeSummaryScreen$2(SimpleChangeSummaryViewModel simpleChangeSummaryViewModel, SimpleChangeSummaryViewModel.ViewState viewState, SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, FormValidator formValidator, BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator) {
        this.$viewModel = simpleChangeSummaryViewModel;
        this.$state = viewState;
        this.$simpleChangeCheckoutState = simpleChangeCheckoutState;
        this.$validator = formValidator;
        this.$bottomSheetDismissHandler = bottomSheetDismissHandler;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator) {
        BottomSheetDismissHandler.navigatePopBlockingSheets$default(bottomSheetDismissHandler, destinationsNavigator, PaymentBottomSheetScreenDestination.INSTANCE.invoke(PaymentOrigin.SimpleChangeOrEarlyCheckInTicket), null, 4, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1194780986, i5, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeSummaryScreen.<anonymous> (SimpleChangeSummaryScreen.kt:90)");
        }
        SimpleChangeSummaryViewModel simpleChangeSummaryViewModel = this.$viewModel;
        composer.startReplaceGroup(-157606947);
        boolean changedInstance = composer.changedInstance(simpleChangeSummaryViewModel);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new SimpleChangeSummaryScreenKt$SimpleChangeSummaryScreen$2$1$1(simpleChangeSummaryViewModel);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        SimpleChangeSummaryViewModel.ViewState viewState = this.$state;
        SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState = this.$simpleChangeCheckoutState;
        FormValidator formValidator = this.$validator;
        Function2 function2 = (Function2) ((KFunction) rememberedValue);
        composer.startReplaceGroup(-157616844);
        boolean changedInstance2 = composer.changedInstance(this.$bottomSheetDismissHandler) | composer.changed(this.$navigator);
        final BottomSheetDismissHandler bottomSheetDismissHandler = this.$bottomSheetDismissHandler;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.simpleChange.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = SimpleChangeSummaryScreenKt$SimpleChangeSummaryScreen$2.invoke$lambda$2$lambda$1(BottomSheetDismissHandler.this, destinationsNavigator);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        SimpleChangeSummaryScreenKt.ChangeProductSummaryContent(viewState, simpleChangeCheckoutState, formValidator, function2, (Function0) rememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
