package dk.molslinjen.ui.views.screens.booking.departures.selectTrailers;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TrailerSelectorScreenKt$TrailerSelectorScreen$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ TrailerSelectorViewModel.TrailerSelectedState $outboundState;
    final /* synthetic */ TrailerSelectorViewModel.TrailerSelectedState $returnState;
    final /* synthetic */ TrailerSelectorViewModel $viewModel;
    final /* synthetic */ TrailerSelectorViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrailerSelectorScreenKt$TrailerSelectorScreen$2(TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState, TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState2, TrailerSelectorViewModel.ViewState viewState, TrailerSelectorViewModel trailerSelectorViewModel, DestinationsNavigator destinationsNavigator) {
        this.$outboundState = trailerSelectedState;
        this.$returnState = trailerSelectedState2;
        this.$viewState = viewState;
        this.$viewModel = trailerSelectorViewModel;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(TrailerSelectorViewModel trailerSelectorViewModel, DestinationsNavigator destinationsNavigator) {
        trailerSelectorViewModel.saveAndClose(new TrailerSelectorScreenKt$TrailerSelectorScreen$2$1$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(Composer composer, int i5) {
        boolean z5;
        boolean changedInstance;
        Object rememberedValue;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(551937181, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorScreen.<anonymous> (TrailerSelectorScreen.kt:37)");
        }
        if (this.$outboundState.getSelectedTrailer() == null) {
            TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState = this.$returnState;
            if ((trailerSelectedState != null ? trailerSelectedState.getSelectedTrailer() : null) == null) {
                z5 = false;
                String stringResource = StringResources_androidKt.stringResource((this.$viewState.getHadSelectedTrailerOnShow() || z5) ? R.string.trailer_selectTrailer : R.string.trailer_removeTrailer, composer, 0);
                boolean z6 = !this.$viewState.getHadSelectedTrailerOnShow() || z5;
                composer.startReplaceGroup(-918487433);
                changedInstance = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
                final TrailerSelectorViewModel trailerSelectorViewModel = this.$viewModel;
                final DestinationsNavigator destinationsNavigator = this.$navigator;
                rememberedValue = composer.rememberedValue();
                if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$1$lambda$0;
                            invoke$lambda$1$lambda$0 = TrailerSelectorScreenKt$TrailerSelectorScreen$2.invoke$lambda$1$lambda$0(TrailerSelectorViewModel.this, destinationsNavigator);
                            return invoke$lambda$1$lambda$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource, null, z6, false, false, 0L, null, (Function0) rememberedValue, composer, 0, 122);
                if (ComposerKt.isTraceInProgress()) {
                    return;
                }
                ComposerKt.traceEventEnd();
                return;
            }
        }
        z5 = true;
        String stringResource2 = StringResources_androidKt.stringResource((this.$viewState.getHadSelectedTrailerOnShow() || z5) ? R.string.trailer_selectTrailer : R.string.trailer_removeTrailer, composer, 0);
        if (this.$viewState.getHadSelectedTrailerOnShow()) {
        }
        composer.startReplaceGroup(-918487433);
        changedInstance = composer.changedInstance(this.$viewModel) | composer.changed(this.$navigator);
        final TrailerSelectorViewModel trailerSelectorViewModel2 = this.$viewModel;
        final DestinationsNavigator destinationsNavigator2 = this.$navigator;
        rememberedValue = composer.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit invoke$lambda$1$lambda$0;
                invoke$lambda$1$lambda$0 = TrailerSelectorScreenKt$TrailerSelectorScreen$2.invoke$lambda$1$lambda$0(TrailerSelectorViewModel.this, destinationsNavigator2);
                return invoke$lambda$1$lambda$0;
            }
        };
        composer.updateRememberedValue(rememberedValue);
        composer.endReplaceGroup();
        BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource2, null, z6, false, false, 0L, null, (Function0) rememberedValue, composer, 0, 122);
        if (ComposerKt.isTraceInProgress()) {
        }
    }
}
