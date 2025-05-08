package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInPassengerCreateScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInPassengerEditScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EarlyCheckInPassengerSelectorScreenKt$EarlyCheckInPassengerSelectorScreen$3 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ PassengerSelectionHelper.PassengerState $passengerState;
    final /* synthetic */ EarlyCheckInPassengerSelectorViewModel.ViewState $state;
    final /* synthetic */ EarlyCheckInPassengerSelectorViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EarlyCheckInPassengerSelectorScreenKt$EarlyCheckInPassengerSelectorScreen$3(EarlyCheckInPassengerSelectorViewModel.ViewState viewState, PassengerSelectionHelper.PassengerState passengerState, DestinationsNavigator destinationsNavigator, EarlyCheckInPassengerSelectorViewModel earlyCheckInPassengerSelectorViewModel) {
        this.$state = viewState;
        this.$passengerState = passengerState;
        this.$navigator = destinationsNavigator;
        this.$viewModel = earlyCheckInPassengerSelectorViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(DestinationsNavigator destinationsNavigator, EarlyCheckInPassengerSelectorViewModel.ViewState viewState, String it) {
        Site site;
        Intrinsics.checkNotNullParameter(it, "it");
        EarlyCheckInPassengerEditScreenDestination earlyCheckInPassengerEditScreenDestination = EarlyCheckInPassengerEditScreenDestination.INSTANCE;
        Booking booking = viewState.getBooking();
        if (booking == null || (site = booking.getSite()) == null) {
            return Unit.INSTANCE;
        }
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, earlyCheckInPassengerEditScreenDestination.invoke(it, site), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(DestinationsNavigator destinationsNavigator, EarlyCheckInPassengerSelectorViewModel.ViewState viewState) {
        Site site;
        EarlyCheckInPassengerCreateScreenDestination earlyCheckInPassengerCreateScreenDestination = EarlyCheckInPassengerCreateScreenDestination.INSTANCE;
        boolean z5 = viewState.getRemainingPassengerCount() > 0;
        Booking booking = viewState.getBooking();
        if (booking == null || (site = booking.getSite()) == null) {
            return Unit.INSTANCE;
        }
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, earlyCheckInPassengerCreateScreenDestination.invoke(z5, site), null, null, 6, null);
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
            ComposerKt.traceEventStart(697287897, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorScreen.<anonymous> (EarlyCheckInPassengerSelectorScreen.kt:93)");
        }
        EarlyCheckInPassengerSelectorViewModel.ViewState viewState = this.$state;
        PassengerSelectionHelper.PassengerState passengerState = this.$passengerState;
        composer.startReplaceGroup(-806536947);
        boolean changed = composer.changed(this.$navigator) | composer.changedInstance(this.$state);
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        final EarlyCheckInPassengerSelectorViewModel.ViewState viewState2 = this.$state;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = EarlyCheckInPassengerSelectorScreenKt$EarlyCheckInPassengerSelectorScreen$3.invoke$lambda$1$lambda$0(DestinationsNavigator.this, viewState2, (String) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function1 function1 = (Function1) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-806526671);
        boolean changed2 = composer.changed(this.$navigator) | composer.changedInstance(this.$state);
        final DestinationsNavigator destinationsNavigator2 = this.$navigator;
        final EarlyCheckInPassengerSelectorViewModel.ViewState viewState3 = this.$state;
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = EarlyCheckInPassengerSelectorScreenKt$EarlyCheckInPassengerSelectorScreen$3.invoke$lambda$3$lambda$2(DestinationsNavigator.this, viewState3);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        Function0 function0 = (Function0) rememberedValue2;
        composer.endReplaceGroup();
        EarlyCheckInPassengerSelectorViewModel earlyCheckInPassengerSelectorViewModel = this.$viewModel;
        composer.startReplaceGroup(-806515511);
        boolean changedInstance = composer.changedInstance(earlyCheckInPassengerSelectorViewModel);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new EarlyCheckInPassengerSelectorScreenKt$EarlyCheckInPassengerSelectorScreen$3$3$1(earlyCheckInPassengerSelectorViewModel);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        Function0 function02 = (Function0) ((KFunction) rememberedValue3);
        EarlyCheckInPassengerSelectorViewModel earlyCheckInPassengerSelectorViewModel2 = this.$viewModel;
        composer.startReplaceGroup(-806513626);
        boolean changedInstance2 = composer.changedInstance(earlyCheckInPassengerSelectorViewModel2);
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = new EarlyCheckInPassengerSelectorScreenKt$EarlyCheckInPassengerSelectorScreen$3$4$1(earlyCheckInPassengerSelectorViewModel2);
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        EarlyCheckInPassengerSelectorScreenKt.PassengerSelectorContent(viewState, passengerState, function1, function0, function02, (Function1) ((KFunction) rememberedValue4), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
