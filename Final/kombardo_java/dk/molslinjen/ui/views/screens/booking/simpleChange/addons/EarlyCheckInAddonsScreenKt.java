package dk.molslinjen.ui.views.screens.booking.simpleChange.addons;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BlockedDismissType;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import dk.molslinjen.ui.views.screens.booking.simpleChange.addons.EarlyCheckInAddonsScreenKt;
import dk.molslinjen.ui.views.screens.booking.simpleChange.addons.SimpleChangeAddonsViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"EarlyCheckInAddonsScreen", BuildConfig.FLAVOR, "viewModel", "Ldk/molslinjen/ui/views/screens/booking/simpleChange/addons/SimpleChangeAddonsViewModel;", "navigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navController", "Landroidx/navigation/NavController;", "navBackStackEntry", "Landroidx/navigation/NavBackStackEntry;", "bottomSheetDismissHandler", "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;", "(Ldk/molslinjen/ui/views/screens/booking/simpleChange/addons/SimpleChangeAddonsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/navigation/NavController;Landroidx/navigation/NavBackStackEntry;Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class EarlyCheckInAddonsScreenKt {
    public static final void EarlyCheckInAddonsScreen(final SimpleChangeAddonsViewModel viewModel, final DestinationsNavigator navigator, final NavController navController, final NavBackStackEntry navBackStackEntry, final BottomSheetDismissHandler bottomSheetDismissHandler, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(bottomSheetDismissHandler, "bottomSheetDismissHandler");
        Composer startRestartGroup = composer.startRestartGroup(-435011715);
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
                ComposerKt.traceEventStart(-435011715, i7, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.addons.EarlyCheckInAddonsScreen (EarlyCheckInAddonsScreen.kt:22)");
            }
            bottomSheetDismissHandler.SetupHandling(navBackStackEntry, navController, navigator, BlockedDismissType.DragToDismissAndBackAction, startRestartGroup, ((i7 >> 9) & 14) | 3072 | ((i7 >> 3) & 112) | ((i7 << 3) & 896) | (57344 & i7));
            startRestartGroup.startReplaceGroup(-1884669741);
            int i8 = i7 & 112;
            boolean changedInstance = startRestartGroup.changedInstance(bottomSheetDismissHandler) | (i8 == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: e3.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit EarlyCheckInAddonsScreen$lambda$1$lambda$0;
                        EarlyCheckInAddonsScreen$lambda$1$lambda$0 = EarlyCheckInAddonsScreenKt.EarlyCheckInAddonsScreen$lambda$1$lambda$0(BottomSheetDismissHandler.this, navigator);
                        return EarlyCheckInAddonsScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1884673485);
            boolean changedInstance2 = startRestartGroup.changedInstance(bottomSheetDismissHandler) | (i8 == 32);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: e3.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit EarlyCheckInAddonsScreen$lambda$3$lambda$2;
                        EarlyCheckInAddonsScreen$lambda$3$lambda$2 = EarlyCheckInAddonsScreenKt.EarlyCheckInAddonsScreen$lambda$3$lambda$2(BottomSheetDismissHandler.this, navigator);
                        return EarlyCheckInAddonsScreen$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            SimpleChangeAddonsSharedContentKt.SimpleChangeAddonsSharedContent(viewModel, function0, (Function0) rememberedValue2, startRestartGroup, i7 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: e3.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit EarlyCheckInAddonsScreen$lambda$4;
                    EarlyCheckInAddonsScreen$lambda$4 = EarlyCheckInAddonsScreenKt.EarlyCheckInAddonsScreen$lambda$4(SimpleChangeAddonsViewModel.this, navigator, navController, navBackStackEntry, bottomSheetDismissHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return EarlyCheckInAddonsScreen$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInAddonsScreen$lambda$1$lambda$0(BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator) {
        BottomSheetDismissHandler.dismissPopBlockingSheets$default(bottomSheetDismissHandler, destinationsNavigator, null, false, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInAddonsScreen$lambda$3$lambda$2(BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator) {
        BottomSheetDismissHandler.dismissPopBlockingSheets$default(bottomSheetDismissHandler, destinationsNavigator, null, false, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInAddonsScreen$lambda$4(SimpleChangeAddonsViewModel simpleChangeAddonsViewModel, DestinationsNavigator destinationsNavigator, NavController navController, NavBackStackEntry navBackStackEntry, BottomSheetDismissHandler bottomSheetDismissHandler, int i5, Composer composer, int i6) {
        EarlyCheckInAddonsScreen(simpleChangeAddonsViewModel, destinationsNavigator, navController, navBackStackEntry, bottomSheetDismissHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
