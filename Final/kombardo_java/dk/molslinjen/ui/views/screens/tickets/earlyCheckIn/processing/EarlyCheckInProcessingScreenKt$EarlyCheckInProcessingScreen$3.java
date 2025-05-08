package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInProcessingScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketDetailsScreenDestination;
import com.ramcosta.composedestinations.navargs.primitives.DestinationsBooleanNavTypeKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import dk.molslinjen.ui.views.global.navigation.ResultBackNavigatorExtensionsKt;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.EarlyCheckInProcessingViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EarlyCheckInProcessingScreenKt$EarlyCheckInProcessingScreen$3 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ BottomSheetDismissHandler $bottomSheetDismissHandler;
    final /* synthetic */ NavController $navController;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ ResultBackNavigator<Boolean> $resultNavigator;
    final /* synthetic */ EarlyCheckInProcessingViewModel.ViewState $state;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EarlyCheckInProcessingScreenKt$EarlyCheckInProcessingScreen$3(EarlyCheckInProcessingViewModel.ViewState viewState, ResultBackNavigator<Boolean> resultBackNavigator, NavController navController, BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator) {
        this.$state = viewState;
        this.$resultNavigator = resultBackNavigator;
        this.$navController = navController;
        this.$bottomSheetDismissHandler = bottomSheetDismissHandler;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(ResultBackNavigator resultBackNavigator, NavController navController, BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator) {
        ResultBackNavigatorExtensionsKt.setResult(resultBackNavigator, Boolean.TRUE, TicketDetailsScreenDestination.INSTANCE, Reflection.getOrCreateKotlinClass(EarlyCheckInProcessingScreenDestination.class), DestinationsBooleanNavTypeKt.getBooleanNavType(), navController);
        bottomSheetDismissHandler.dismissPopBlockingSheets(destinationsNavigator, EarlyCheckInScreenDestination.INSTANCE, true);
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
            ComposerKt.traceEventStart(-223062805, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.EarlyCheckInProcessingScreen.<anonymous> (EarlyCheckInProcessingScreen.kt:76)");
        }
        EarlyCheckInProcessingViewModel.ViewState viewState = this.$state;
        composer.startReplaceGroup(-809381723);
        boolean changed = composer.changed(this.$resultNavigator) | composer.changedInstance(this.$navController) | composer.changedInstance(this.$bottomSheetDismissHandler) | composer.changed(this.$navigator);
        final ResultBackNavigator<Boolean> resultBackNavigator = this.$resultNavigator;
        final NavController navController = this.$navController;
        final BottomSheetDismissHandler bottomSheetDismissHandler = this.$bottomSheetDismissHandler;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = EarlyCheckInProcessingScreenKt$EarlyCheckInProcessingScreen$3.invoke$lambda$1$lambda$0(ResultBackNavigator.this, navController, bottomSheetDismissHandler, destinationsNavigator);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        EarlyCheckInProcessingScreenKt.EarlyCheckInProcessingContent(viewState, (Function0) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
