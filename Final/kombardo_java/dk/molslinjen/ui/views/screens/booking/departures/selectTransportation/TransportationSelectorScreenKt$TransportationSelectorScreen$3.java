package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.generated.destinations.CargoDetailsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransportationSelectorScreenKt$TransportationSelectorScreen$3 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ TransportationSelectorViewModel $viewModel;
    final /* synthetic */ TransportationSelectorViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransportationSelectorScreenKt$TransportationSelectorScreen$3(TransportationSelectorViewModel.ViewState viewState, long j5, TransportationSelectorViewModel transportationSelectorViewModel, DestinationsNavigator destinationsNavigator) {
        this.$viewState = viewState;
        this.$backgroundColor = j5;
        this.$viewModel = transportationSelectorViewModel;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(TransportationSelectorViewModel transportationSelectorViewModel) {
        transportationSelectorViewModel.showValidationMessage();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3(TransportationSelectorViewModel transportationSelectorViewModel, final DestinationsNavigator destinationsNavigator) {
        transportationSelectorViewModel.saveAndClose(new Function2() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.f
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit invoke$lambda$4$lambda$3$lambda$2;
                invoke$lambda$4$lambda$3$lambda$2 = TransportationSelectorScreenKt$TransportationSelectorScreen$3.invoke$lambda$4$lambda$3$lambda$2(DestinationsNavigator.this, ((Boolean) obj).booleanValue(), (String) obj2);
                return invoke$lambda$4$lambda$3$lambda$2;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3$lambda$2(DestinationsNavigator destinationsNavigator, boolean z5, String transportationId) {
        Intrinsics.checkNotNullParameter(transportationId, "transportationId");
        if (z5) {
            DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, CargoDetailsScreenDestination.INSTANCE.invoke(transportationId), null, null, 6, null);
        } else {
            destinationsNavigator.popBackStack();
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
            ComposerKt.traceEventStart(-2102994291, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorScreen.<anonymous> (TransportationSelectorScreen.kt:79)");
        }
        Transportation selectedTransportation = this.$viewState.getSelectedTransportation();
        String stringResource = StringResources_androidKt.stringResource((selectedTransportation == null || !selectedTransportation.isWalking()) ? R.string.transportation_selectVehicleButton : R.string.transportation_selectWalkingButton, composer, 0);
        boolean z5 = this.$viewState.getSelectedTransportation() != null;
        long j5 = this.$backgroundColor;
        composer.startReplaceGroup(-263117584);
        boolean changedInstance = composer.changedInstance(this.$viewModel);
        final TransportationSelectorViewModel transportationSelectorViewModel = this.$viewModel;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = TransportationSelectorScreenKt$TransportationSelectorScreen$3.invoke$lambda$1$lambda$0(TransportationSelectorViewModel.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function0 function0 = (Function0) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-263113963);
        boolean changedInstance2 = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
        final TransportationSelectorViewModel transportationSelectorViewModel2 = this.$viewModel;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$4$lambda$3;
                    invoke$lambda$4$lambda$3 = TransportationSelectorScreenKt$TransportationSelectorScreen$3.invoke$lambda$4$lambda$3(TransportationSelectorViewModel.this, destinationsNavigator);
                    return invoke$lambda$4$lambda$3;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource, null, z5, false, false, j5, function0, (Function0) rememberedValue2, composer, 0, 26);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
