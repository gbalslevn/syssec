package dk.molslinjen.ui.views.screens.main;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.navigation.BottomSheetKt;
import androidx.compose.material.navigation.BottomSheetNavigator;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import dk.molslinjen.core.AppUpdater;
import dk.molslinjen.core.migration.Migrator;
import dk.molslinjen.core.snackbar.SnackbarMessageEvent;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.global.bottombar.BottomBarKt;
import dk.molslinjen.ui.views.global.bottombar.BottomBarViewModel;
import dk.molslinjen.ui.views.global.navigation.NavigationGraphKt;
import dk.molslinjen.ui.views.global.topbar.TopAppBarKt;
import dk.molslinjen.ui.views.global.topbar.TopBarViewModel;
import dk.molslinjen.ui.views.reusable.snackbar.CustomSnackbarHostKt;
import dk.molslinjen.ui.views.screens.main.push.PushDialogViewKt;
import dk.molslinjen.ui.views.screens.main.push.PushDialogViewModel;
import dk.molslinjen.ui.views.shared.error.ErrorScreenKt;
import dk.molslinjen.ui.views.shared.error.ErrorViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class MainScreenKt$MainScreen$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ AppUpdater.AppUpdateState $appUpdateState;
    final /* synthetic */ BottomSheetNavigator $bottomSheetNavigator;
    final /* synthetic */ MainViewModel $mainViewModel;
    final /* synthetic */ Migrator.MigrationState $migrationState;
    final /* synthetic */ NavHostController $navHostController;
    final /* synthetic */ MutableStateFlow<String> $pushDeepLinkEventRoute;
    final /* synthetic */ Function1<Function0<Boolean>, Unit> $resetSheetCloseConfirmCallbackIfThisCallback;
    final /* synthetic */ Function1<Function0<Boolean>, Unit> $setSheetCloseConfirmCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public MainScreenKt$MainScreen$1(MainViewModel mainViewModel, Migrator.MigrationState migrationState, AppUpdater.AppUpdateState appUpdateState, BottomSheetNavigator bottomSheetNavigator, NavHostController navHostController, Function1<? super Function0<Boolean>, Unit> function1, Function1<? super Function0<Boolean>, Unit> function12, MutableStateFlow<String> mutableStateFlow) {
        this.$mainViewModel = mainViewModel;
        this.$migrationState = migrationState;
        this.$appUpdateState = appUpdateState;
        this.$bottomSheetNavigator = bottomSheetNavigator;
        this.$navHostController = navHostController;
        this.$setSheetCloseConfirmCallback = function1;
        this.$resetSheetCloseConfirmCallbackIfThisCallback = function12;
        this.$pushDeepLinkEventRoute = mutableStateFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(SystemUiController systemUiController) {
        AppColor appColor = AppColor.INSTANCE;
        SystemUiController.m2916setStatusBarColorek8zF_U$default(systemUiController, appColor.m3280getTransparent0d7_KjU(), false, null, 6, null);
        SystemUiController.m2915setNavigationBarColorIv8Zu3U$default(systemUiController, appColor.m3281getWhite0d7_KjU(), false, false, null, 14, null);
        return Unit.INSTANCE;
    }

    private static final SnackbarMessageEvent invoke$lambda$3(MutableState<SnackbarMessageEvent> mutableState) {
        return mutableState.getValue();
    }

    private static final PaddingValues invoke$lambda$8(MutableState<PaddingValues> mutableState) {
        return mutableState.getValue();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(Composer composer, int i5) {
        CreationExtras creationExtras;
        SnackbarHostState snackbarHostState;
        MutableState mutableState;
        CreationExtras creationExtras2;
        CreationExtras creationExtras3;
        CreationExtras creationExtras4;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(754904849, i5, -1, "dk.molslinjen.ui.views.screens.main.MainScreen.<anonymous> (MainScreen.kt:66)");
        }
        final SystemUiController rememberSystemUiController = SystemUiControllerKt.rememberSystemUiController(null, composer, 0, 1);
        composer.startReplaceGroup(90922331);
        boolean changed = composer.changed(rememberSystemUiController);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.main.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = MainScreenKt$MainScreen$1.invoke$lambda$1$lambda$0(SystemUiController.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        EffectsKt.SideEffect((Function0) rememberedValue, composer, 0);
        composer.startReplaceGroup(90929685);
        Object rememberedValue2 = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        MutableState mutableState2 = (MutableState) rememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(90931796);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new SnackbarHostState();
            composer.updateRememberedValue(rememberedValue3);
        }
        SnackbarHostState snackbarHostState2 = (SnackbarHostState) rememberedValue3;
        composer.endReplaceGroup();
        Boolean bool = Boolean.TRUE;
        composer.startReplaceGroup(90934646);
        boolean changedInstance = composer.changedInstance(this.$mainViewModel);
        MainViewModel mainViewModel = this.$mainViewModel;
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance || rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = new MainScreenKt$MainScreen$1$2$1(mainViewModel, snackbarHostState2, mutableState2, null);
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(bool, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue4, composer, 6);
        composer.startReplaceGroup(90956836);
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == companion.getEmpty()) {
            rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PaddingKt.m306PaddingValues0680j_4(Dp.m2599constructorimpl(0)), null, 2, null);
            composer.updateRememberedValue(rememberedValue5);
        }
        final MutableState mutableState3 = (MutableState) rememberedValue5;
        composer.endReplaceGroup();
        composer.startReplaceableGroup(1890788296);
        LocalViewModelStoreOwner localViewModelStoreOwner = LocalViewModelStoreOwner.INSTANCE;
        int i6 = LocalViewModelStoreOwner.$stable;
        ViewModelStoreOwner current = localViewModelStoreOwner.getCurrent(composer, i6);
        if (current != null) {
            ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
            composer.startReplaceableGroup(1729797275);
            if (current instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
            } else {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ErrorViewModel.class, current, (String) null, createHiltViewModelFactory, creationExtras, composer, 36936, 0);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            ErrorViewModel errorViewModel = (ErrorViewModel) viewModel;
            if (((ErrorViewModel.ViewState) SnapshotStateKt.collectAsState(errorViewModel.getViewState(), null, composer, 0, 1).getValue()).getShouldShowBlockingErrorScreen()) {
                composer.startReplaceGroup(-1475031121);
                ErrorScreenKt.ErrorScreen(errorViewModel, composer, 0);
                composer.endReplaceGroup();
            } else if (!this.$migrationState.getMigrationErrors().isEmpty()) {
                composer.startReplaceGroup(-1474913755);
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current2 = localViewModelStoreOwner.getCurrent(composer, i6);
                if (current2 != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory2 = HiltViewModelKt.createHiltViewModelFactory(current2, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current2 instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras4 = ((HasDefaultViewModelProviderFactory) current2).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras4 = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel2 = ViewModelKt.viewModel((Class<ViewModel>) MigrationErrorViewModel.class, current2, (String) null, createHiltViewModelFactory2, creationExtras4, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    MigrationErrorScreenKt.MigrationErrorScreen((MigrationErrorViewModel) viewModel2, composer, 0);
                    composer.endReplaceGroup();
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            } else if (this.$appUpdateState.getManuelForceUpdateRequired()) {
                composer.startReplaceGroup(-1474789662);
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current3 = localViewModelStoreOwner.getCurrent(composer, i6);
                if (current3 != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory3 = HiltViewModelKt.createHiltViewModelFactory(current3, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current3 instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras3 = ((HasDefaultViewModelProviderFactory) current3).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras3 = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel3 = ViewModelKt.viewModel((Class<ViewModel>) ManuelForceUpdateViewModel.class, current3, (String) null, createHiltViewModelFactory3, creationExtras3, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    ManuelForceUpdateScreenKt.ManuelForceUpdateScreen((ManuelForceUpdateViewModel) viewModel3, composer, 0);
                    composer.endReplaceGroup();
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            } else {
                composer.startReplaceGroup(-1474631097);
                BottomSheetNavigator bottomSheetNavigator = this.$bottomSheetNavigator;
                final NavHostController navHostController = this.$navHostController;
                final MainViewModel mainViewModel2 = this.$mainViewModel;
                final Function1<Function0<Boolean>, Unit> function1 = this.$setSheetCloseConfirmCallback;
                final Function1<Function0<Boolean>, Unit> function12 = this.$resetSheetCloseConfirmCallbackIfThisCallback;
                final MutableStateFlow<String> mutableStateFlow = this.$pushDeepLinkEventRoute;
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, companion2);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                if (composer.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                float f5 = 15;
                float f6 = 0;
                snackbarHostState = snackbarHostState2;
                mutableState = mutableState2;
                BottomSheetKt.m748ModalBottomSheetLayout4erKP6g(bottomSheetNavigator, WindowInsetsPadding_androidKt.imePadding(WindowInsetsPadding_androidKt.navigationBarsPadding(companion2)), RoundedCornerShapeKt.m461RoundedCornerShapea9UjIt4(Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6)), 0.0f, 0L, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(-1659759648, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.main.MainScreenKt$MainScreen$1$3$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i7) {
                        if ((i7 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1659759648, i7, -1, "dk.molslinjen.ui.views.screens.main.MainScreen.<anonymous>.<anonymous>.<anonymous> (MainScreen.kt:115)");
                        }
                        final NavHostController navHostController2 = NavHostController.this;
                        ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1927125596, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.main.MainScreenKt$MainScreen$1$3$1.1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i8) {
                                CreationExtras creationExtras5;
                                if ((i8 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1927125596, i8, -1, "dk.molslinjen.ui.views.screens.main.MainScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainScreen.kt:117)");
                                }
                                composer3.startReplaceableGroup(1890788296);
                                ViewModelStoreOwner current4 = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer3, LocalViewModelStoreOwner.$stable);
                                if (current4 != null) {
                                    ViewModelProvider.Factory createHiltViewModelFactory4 = HiltViewModelKt.createHiltViewModelFactory(current4, composer3, 0);
                                    composer3.startReplaceableGroup(1729797275);
                                    if (current4 instanceof HasDefaultViewModelProviderFactory) {
                                        creationExtras5 = ((HasDefaultViewModelProviderFactory) current4).getDefaultViewModelCreationExtras();
                                    } else {
                                        creationExtras5 = CreationExtras.Empty.INSTANCE;
                                    }
                                    ViewModel viewModel4 = ViewModelKt.viewModel((Class<ViewModel>) TopBarViewModel.class, current4, (String) null, createHiltViewModelFactory4, creationExtras5, composer3, 36936, 0);
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    TopAppBarKt.TopAppBar((TopBarViewModel) viewModel4, NavHostController.this, composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                            }
                        }, composer2, 54);
                        final NavHostController navHostController3 = NavHostController.this;
                        ComposableLambda rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(2139051749, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.main.MainScreenKt$MainScreen$1$3$1.2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i8) {
                                CreationExtras creationExtras5;
                                if ((i8 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2139051749, i8, -1, "dk.molslinjen.ui.views.screens.main.MainScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainScreen.kt:123)");
                                }
                                composer3.startReplaceableGroup(1890788296);
                                ViewModelStoreOwner current4 = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer3, LocalViewModelStoreOwner.$stable);
                                if (current4 != null) {
                                    ViewModelProvider.Factory createHiltViewModelFactory4 = HiltViewModelKt.createHiltViewModelFactory(current4, composer3, 0);
                                    composer3.startReplaceableGroup(1729797275);
                                    if (current4 instanceof HasDefaultViewModelProviderFactory) {
                                        creationExtras5 = ((HasDefaultViewModelProviderFactory) current4).getDefaultViewModelCreationExtras();
                                    } else {
                                        creationExtras5 = CreationExtras.Empty.INSTANCE;
                                    }
                                    ViewModel viewModel4 = ViewModelKt.viewModel((Class<ViewModel>) BottomBarViewModel.class, current4, (String) null, createHiltViewModelFactory4, creationExtras5, composer3, 36936, 0);
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    BottomBarKt.BottomBar((BottomBarViewModel) viewModel4, NavHostController.this, composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                            }
                        }, composer2, 54);
                        WindowInsets WindowInsets = WindowInsetsKt.WindowInsets(0, 0, 0, 0);
                        final MutableState<PaddingValues> mutableState4 = mutableState3;
                        final NavHostController navHostController4 = NavHostController.this;
                        final MainViewModel mainViewModel3 = mainViewModel2;
                        final Function1<Function0<Boolean>, Unit> function13 = function1;
                        final Function1<Function0<Boolean>, Unit> function14 = function12;
                        final MutableStateFlow<String> mutableStateFlow2 = mutableStateFlow;
                        ScaffoldKt.m886ScaffoldTvnljyQ(null, rememberComposableLambda, rememberComposableLambda2, null, null, 0, 0L, 0L, WindowInsets, ComposableLambdaKt.rememberComposableLambda(-1445840849, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.main.MainScreenKt$MainScreen$1$3$1.3
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer3, Integer num) {
                                invoke(paddingValues, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(PaddingValues paddingValues, Composer composer3, int i8) {
                                Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                                if ((i8 & 6) == 0) {
                                    i8 |= composer3.changed(paddingValues) ? 4 : 2;
                                }
                                if ((i8 & 19) == 18 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1445840849, i8, -1, "dk.molslinjen.ui.views.screens.main.MainScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainScreen.kt:131)");
                                }
                                mutableState4.setValue(paddingValues);
                                Modifier consumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(PaddingKt.padding(Modifier.INSTANCE, paddingValues), paddingValues);
                                NavHostController navHostController5 = navHostController4;
                                MainViewModel mainViewModel4 = mainViewModel3;
                                Function1<Function0<Boolean>, Unit> function15 = function13;
                                Function1<Function0<Boolean>, Unit> function16 = function14;
                                MutableStateFlow<String> mutableStateFlow3 = mutableStateFlow2;
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, consumeWindowInsets);
                                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                                if (composer3.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor2);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer3);
                                Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                NavigationGraphKt.NavigationGraph(navHostController5, mainViewModel4, function15, function16, composer3, 0);
                                String str = (String) SnapshotStateKt.collectAsState(mutableStateFlow3, null, composer3, 0, 1).getValue();
                                if (str != null) {
                                    NavController.navigate$default((NavController) navHostController5, str, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
                                    do {
                                    } while (!mutableStateFlow3.compareAndSet(mutableStateFlow3.getValue(), null));
                                }
                                composer3.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, 805306800, 249);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer, 54), composer, BottomSheetNavigator.$stable | 12582912, 120);
                composer.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current4 = localViewModelStoreOwner.getCurrent(composer, i6);
                if (current4 != null) {
                    ViewModelProvider.Factory createHiltViewModelFactory4 = HiltViewModelKt.createHiltViewModelFactory(current4, composer, 0);
                    composer.startReplaceableGroup(1729797275);
                    if (current4 instanceof HasDefaultViewModelProviderFactory) {
                        creationExtras2 = ((HasDefaultViewModelProviderFactory) current4).getDefaultViewModelCreationExtras();
                    } else {
                        creationExtras2 = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel4 = ViewModelKt.viewModel((Class<ViewModel>) PushDialogViewModel.class, current4, (String) null, createHiltViewModelFactory4, creationExtras2, composer, 36936, 0);
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    PushDialogViewKt.PushDialogView((PushDialogViewModel) viewModel4, composer, 0);
                    composer.endNode();
                    composer.endReplaceGroup();
                    CustomSnackbarHostKt.CustomSnackbarHost(invoke$lambda$3(mutableState), snackbarHostState, invoke$lambda$8(mutableState3), composer, 48);
                    if (ComposerKt.isTraceInProgress()) {
                        return;
                    }
                    ComposerKt.traceEventEnd();
                    return;
                }
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            snackbarHostState = snackbarHostState2;
            mutableState = mutableState2;
            CustomSnackbarHostKt.CustomSnackbarHost(invoke$lambda$3(mutableState), snackbarHostState, invoke$lambda$8(mutableState3), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
        }
    }
}
