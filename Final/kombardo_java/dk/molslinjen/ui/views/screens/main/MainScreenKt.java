package dk.molslinjen.ui.views.screens.main;

import android.app.Activity;
import android.content.Context;
import androidx.compose.material.navigation.BottomSheetNavigator;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavHostController;
import androidx.view.compose.BackHandlerKt;
import dk.molslinjen.core.AppUpdater;
import dk.molslinjen.core.migration.Migrator;
import dk.molslinjen.ui.theme.ThemeKt;
import dk.molslinjen.ui.views.screens.developer.DeveloperAppVersionViewKt;
import dk.molslinjen.ui.views.screens.developer.DeveloperPanelViewKt;
import dk.molslinjen.ui.views.screens.developer.DeveloperViewModel;
import dk.molslinjen.ui.views.screens.main.MainScreenKt;
import dk.molslinjen.ui.views.screens.main.MainViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aw\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042 \u0010\u000b\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\t\u0012\u0004\u0012\u00020\n0\u00062\u001c\u0010\f\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0012\u0004\u0012\u00020\n0\u00062\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u0000H\u0003¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0018²\u0006\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00148\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0017\u001a\u00020\u00168\n@\nX\u008a\u008e\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/main/MainViewModel;", "mainViewModel", "Landroidx/navigation/NavHostController;", "navHostController", "Landroidx/compose/material/navigation/BottomSheetNavigator;", "bottomSheetNavigator", "Lkotlin/Function1;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetCloseCallback;", BuildConfig.FLAVOR, "setSheetCloseConfirmCallback", "resetSheetCloseConfirmCallbackIfThisCallback", "Lkotlinx/coroutines/flow/MutableStateFlow;", BuildConfig.FLAVOR, "pushDeepLinkEventRoute", "MainScreen", "(Ldk/molslinjen/ui/views/screens/main/MainViewModel;Landroidx/navigation/NavHostController;Landroidx/compose/material/navigation/BottomSheetNavigator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlinx/coroutines/flow/MutableStateFlow;Landroidx/compose/runtime/Composer;I)V", "ShowSnackbarBeforeCloseOnBack", "(Ldk/molslinjen/ui/views/screens/main/MainViewModel;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/core/snackbar/SnackbarMessageEvent;", "latestSnackbarMessageEvent", "Landroidx/compose/foundation/layout/PaddingValues;", "scaffoldPaddingValues", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MainScreenKt {
    public static final void MainScreen(final MainViewModel mainViewModel, final NavHostController navHostController, final BottomSheetNavigator bottomSheetNavigator, final Function1<? super Function0<Boolean>, Unit> setSheetCloseConfirmCallback, final Function1<? super Function0<Boolean>, Unit> resetSheetCloseConfirmCallbackIfThisCallback, final MutableStateFlow<String> pushDeepLinkEventRoute, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(mainViewModel, "mainViewModel");
        Intrinsics.checkNotNullParameter(navHostController, "navHostController");
        Intrinsics.checkNotNullParameter(bottomSheetNavigator, "bottomSheetNavigator");
        Intrinsics.checkNotNullParameter(setSheetCloseConfirmCallback, "setSheetCloseConfirmCallback");
        Intrinsics.checkNotNullParameter(resetSheetCloseConfirmCallbackIfThisCallback, "resetSheetCloseConfirmCallbackIfThisCallback");
        Intrinsics.checkNotNullParameter(pushDeepLinkEventRoute, "pushDeepLinkEventRoute");
        Composer startRestartGroup = composer.startRestartGroup(52265026);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(mainViewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navHostController) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= (i5 & 512) == 0 ? startRestartGroup.changed(bottomSheetNavigator) : startRestartGroup.changedInstance(bottomSheetNavigator) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(setSheetCloseConfirmCallback) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(resetSheetCloseConfirmCallbackIfThisCallback) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(pushDeepLinkEventRoute) ? 131072 : 65536;
        }
        int i7 = i6;
        if ((74899 & i7) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(52265026, i7, -1, "dk.molslinjen.ui.views.screens.main.MainScreen (MainScreen.kt:54)");
            }
            boolean booleanValue = ((Boolean) SnapshotStateKt.collectAsState(mainViewModel.getShowDeveloperMenu(), null, startRestartGroup, 0, 1).getValue()).booleanValue();
            boolean showAppVersionInfo = mainViewModel.getShowAppVersionInfo();
            Migrator.MigrationState migrationState = (Migrator.MigrationState) SnapshotStateKt.collectAsState(mainViewModel.getMigrationState(), null, startRestartGroup, 0, 1).getValue();
            AppUpdater.AppUpdateState appUpdateState = (AppUpdater.AppUpdateState) SnapshotStateKt.collectAsState(mainViewModel.getAppUpdateState(), null, startRestartGroup, 0, 1).getValue();
            ShowSnackbarBeforeCloseOnBack(mainViewModel, startRestartGroup, i7 & 14);
            composer2 = startRestartGroup;
            ThemeKt.MolslinjenTheme(false, false, ComposableLambdaKt.rememberComposableLambda(754904849, true, new MainScreenKt$MainScreen$1(mainViewModel, migrationState, appUpdateState, bottomSheetNavigator, navHostController, setSheetCloseConfirmCallback, resetSheetCloseConfirmCallbackIfThisCallback, pushDeepLinkEventRoute), composer2, 54), composer2, 438, 0);
            composer2.startReplaceGroup(-610264802);
            if (showAppVersionInfo) {
                composer2.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer2, LocalViewModelStoreOwner.$stable);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer2, 0);
                composer2.startReplaceableGroup(1729797275);
                ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) DeveloperViewModel.class, current, (String) null, createHiltViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composer2, 36936, 0);
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                DeveloperAppVersionViewKt.DeveloperAppVersionView((DeveloperViewModel) viewModel, composer2, 0);
            }
            composer2.endReplaceGroup();
            if (booleanValue) {
                DeveloperPanelViewKt.DeveloperPanelView(navHostController, composer2, (i7 >> 3) & 14);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: o3.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MainScreen$lambda$0;
                    MainScreen$lambda$0 = MainScreenKt.MainScreen$lambda$0(MainViewModel.this, navHostController, bottomSheetNavigator, setSheetCloseConfirmCallback, resetSheetCloseConfirmCallbackIfThisCallback, pushDeepLinkEventRoute, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MainScreen$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainScreen$lambda$0(MainViewModel mainViewModel, NavHostController navHostController, BottomSheetNavigator bottomSheetNavigator, Function1 function1, Function1 function12, MutableStateFlow mutableStateFlow, int i5, Composer composer, int i6) {
        MainScreen(mainViewModel, navHostController, bottomSheetNavigator, function1, function12, mutableStateFlow, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void ShowSnackbarBeforeCloseOnBack(final MainViewModel mainViewModel, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-358754713);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(mainViewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-358754713, i6, -1, "dk.molslinjen.ui.views.screens.main.ShowSnackbarBeforeCloseOnBack (MainScreen.kt:173)");
            }
            startRestartGroup.startReplaceGroup(962381128);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            startRestartGroup.startReplaceGroup(962385357);
            boolean changedInstance = startRestartGroup.changedInstance(mainViewModel) | startRestartGroup.changedInstance(context);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: o3.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ShowSnackbarBeforeCloseOnBack$lambda$3$lambda$2;
                        ShowSnackbarBeforeCloseOnBack$lambda$3$lambda$2 = MainScreenKt.ShowSnackbarBeforeCloseOnBack$lambda$3$lambda$2(MutableState.this, mainViewModel, context);
                        return ShowSnackbarBeforeCloseOnBack$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            BackHandlerKt.BackHandler(false, (Function0) rememberedValue2, startRestartGroup, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: o3.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShowSnackbarBeforeCloseOnBack$lambda$4;
                    ShowSnackbarBeforeCloseOnBack$lambda$4 = MainScreenKt.ShowSnackbarBeforeCloseOnBack$lambda$4(MainViewModel.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ShowSnackbarBeforeCloseOnBack$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShowSnackbarBeforeCloseOnBack$lambda$3$lambda$2(MutableState mutableState, MainViewModel mainViewModel, Context context) {
        LocalTime localTime = (LocalTime) mutableState.getValue();
        if (localTime == null || LocalTime.now().isAfter(localTime.plusSeconds(4L))) {
            mutableState.setValue(LocalTime.now());
            mainViewModel.showExitSnackBar();
        } else {
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                activity.finish();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShowSnackbarBeforeCloseOnBack$lambda$4(MainViewModel mainViewModel, int i5, Composer composer, int i6) {
        ShowSnackbarBeforeCloseOnBack(mainViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
