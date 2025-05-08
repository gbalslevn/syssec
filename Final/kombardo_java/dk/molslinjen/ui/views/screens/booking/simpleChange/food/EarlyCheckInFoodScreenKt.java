package dk.molslinjen.ui.views.screens.booking.simpleChange.food;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BlockedDismissType;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import dk.molslinjen.ui.views.screens.booking.simpleChange.food.EarlyCheckInFoodScreenKt;
import dk.molslinjen.ui.views.screens.booking.simpleChange.food.SimpleChangeFoodViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"EarlyCheckInFoodScreen", BuildConfig.FLAVOR, "viewModel", "Ldk/molslinjen/ui/views/screens/booking/simpleChange/food/SimpleChangeFoodViewModel;", "navigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navController", "Landroidx/navigation/NavController;", "navBackStackEntry", "Landroidx/navigation/NavBackStackEntry;", "bottomSheetDismissHandler", "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;", "(Ldk/molslinjen/ui/views/screens/booking/simpleChange/food/SimpleChangeFoodViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/navigation/NavController;Landroidx/navigation/NavBackStackEntry;Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class EarlyCheckInFoodScreenKt {
    public static final void EarlyCheckInFoodScreen(final SimpleChangeFoodViewModel viewModel, final DestinationsNavigator navigator, final NavController navController, final NavBackStackEntry navBackStackEntry, final BottomSheetDismissHandler bottomSheetDismissHandler, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(bottomSheetDismissHandler, "bottomSheetDismissHandler");
        Composer startRestartGroup = composer.startRestartGroup(611518151);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navController) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(navBackStackEntry) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(bottomSheetDismissHandler) ? 16384 : 8192;
        }
        int i7 = i6;
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(611518151, i7, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.food.EarlyCheckInFoodScreen (EarlyCheckInFoodScreen.kt:22)");
            }
            bottomSheetDismissHandler.SetupHandling(navBackStackEntry, navController, navigator, BlockedDismissType.DragToDismissAndBackAction, startRestartGroup, ((i7 >> 9) & 14) | 3072 | ((i7 >> 3) & 112) | ((i7 << 3) & 896) | (57344 & i7));
            startRestartGroup.startReplaceGroup(-444606605);
            int i8 = i7 & 112;
            boolean changedInstance = startRestartGroup.changedInstance(bottomSheetDismissHandler) | (i8 == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: f3.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit EarlyCheckInFoodScreen$lambda$1$lambda$0;
                        EarlyCheckInFoodScreen$lambda$1$lambda$0 = EarlyCheckInFoodScreenKt.EarlyCheckInFoodScreen$lambda$1$lambda$0(BottomSheetDismissHandler.this, navigator);
                        return EarlyCheckInFoodScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-444610349);
            boolean changedInstance2 = startRestartGroup.changedInstance(bottomSheetDismissHandler) | (i8 == 32);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: f3.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit EarlyCheckInFoodScreen$lambda$3$lambda$2;
                        EarlyCheckInFoodScreen$lambda$3$lambda$2 = EarlyCheckInFoodScreenKt.EarlyCheckInFoodScreen$lambda$3$lambda$2(BottomSheetDismissHandler.this, navigator);
                        return EarlyCheckInFoodScreen$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            SimpleChangeFoodSharedContentKt.SimpleChangeFoodSharedContent(viewModel, function0, (Function0) rememberedValue2, startRestartGroup, i7 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: f3.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit EarlyCheckInFoodScreen$lambda$4;
                    EarlyCheckInFoodScreen$lambda$4 = EarlyCheckInFoodScreenKt.EarlyCheckInFoodScreen$lambda$4(SimpleChangeFoodViewModel.this, navigator, navController, navBackStackEntry, bottomSheetDismissHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return EarlyCheckInFoodScreen$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInFoodScreen$lambda$1$lambda$0(BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator) {
        BottomSheetDismissHandler.dismissPopBlockingSheets$default(bottomSheetDismissHandler, destinationsNavigator, null, false, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInFoodScreen$lambda$3$lambda$2(BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator) {
        BottomSheetDismissHandler.dismissPopBlockingSheets$default(bottomSheetDismissHandler, destinationsNavigator, null, false, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInFoodScreen$lambda$4(SimpleChangeFoodViewModel simpleChangeFoodViewModel, DestinationsNavigator destinationsNavigator, NavController navController, NavBackStackEntry navBackStackEntry, BottomSheetDismissHandler bottomSheetDismissHandler, int i5, Composer composer, int i6) {
        EarlyCheckInFoodScreen(simpleChangeFoodViewModel, destinationsNavigator, navController, navBackStackEntry, bottomSheetDismissHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
