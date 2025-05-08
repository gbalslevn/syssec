package dk.molslinjen.ui.views.global.navigation;

import android.os.Bundle;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import com.ramcosta.composedestinations.DestinationsNavHostKt;
import com.ramcosta.composedestinations.generated.NavGraphs;
import com.ramcosta.composedestinations.generated.navgraphs.AnimatedRootNavigationNavGraph;
import com.ramcosta.composedestinations.generated.navgraphs.CheckoutNavigationNavGraph;
import com.ramcosta.composedestinations.manualcomposablecalls.ManualComposableCallsBuilder;
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder;
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainerImpl;
import com.ramcosta.composedestinations.spec.Direction;
import com.ramcosta.composedestinations.utils.SpecExtensionsKt;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.global.navigation.NavigationGraphKt;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetCustomDismissHandler;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import dk.molslinjen.ui.views.screens.booking.checkout.CheckoutViewModel;
import dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.CheckoutExpirationDialogHandler;
import dk.molslinjen.ui.views.screens.main.MainViewModel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a]\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052 \u0010\u0006\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\n\u0012\u0004\u0012\u00020\u00010\u00072\u001c\u0010\u000b\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\t0\bj\u0002`\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\f\u001a\u001d\u0010\r\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u000e\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0012"}, d2 = {"NavigationGraph", BuildConfig.FLAVOR, "navController", "Landroidx/navigation/NavHostController;", "mainViewModel", "Ldk/molslinjen/ui/views/screens/main/MainViewModel;", "setSheetCloseConfirmCallback", "Lkotlin/Function1;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetCloseCallback;", "resetSheetCloseConfirmCallbackIfThisCallback", "(Landroidx/navigation/NavHostController;Ldk/molslinjen/ui/views/screens/main/MainViewModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ListenForNavigationChanges", "(Ldk/molslinjen/ui/views/screens/main/MainViewModel;Landroidx/navigation/NavHostController;Landroidx/compose/runtime/Composer;I)V", "logBreadcrumbForNavigation", "navBackStackEntry", "Landroidx/navigation/NavBackStackEntry;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class NavigationGraphKt {
    private static final void ListenForNavigationChanges(final MainViewModel mainViewModel, final NavHostController navHostController, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1203123108);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(mainViewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navHostController) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1203123108, i6, -1, "dk.molslinjen.ui.views.global.navigation.ListenForNavigationChanges (NavigationGraph.kt:94)");
            }
            Boolean bool = Boolean.TRUE;
            startRestartGroup.startReplaceGroup(-195871837);
            boolean changedInstance = startRestartGroup.changedInstance(navHostController) | startRestartGroup.changedInstance(mainViewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new NavigationGraphKt$ListenForNavigationChanges$1$1(navHostController, mainViewModel, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(bool, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: R1.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ListenForNavigationChanges$lambda$10;
                    ListenForNavigationChanges$lambda$10 = NavigationGraphKt.ListenForNavigationChanges$lambda$10(MainViewModel.this, navHostController, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ListenForNavigationChanges$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListenForNavigationChanges$lambda$10(MainViewModel mainViewModel, NavHostController navHostController, int i5, Composer composer, int i6) {
        ListenForNavigationChanges(mainViewModel, navHostController, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void NavigationGraph(final NavHostController navController, final MainViewModel mainViewModel, final Function1<? super Function0<Boolean>, Unit> setSheetCloseConfirmCallback, final Function1<? super Function0<Boolean>, Unit> resetSheetCloseConfirmCallbackIfThisCallback, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(mainViewModel, "mainViewModel");
        Intrinsics.checkNotNullParameter(setSheetCloseConfirmCallback, "setSheetCloseConfirmCallback");
        Intrinsics.checkNotNullParameter(resetSheetCloseConfirmCallbackIfThisCallback, "resetSheetCloseConfirmCallbackIfThisCallback");
        Composer startRestartGroup = composer.startRestartGroup(788107847);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(navController) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(mainViewModel) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(setSheetCloseConfirmCallback) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(resetSheetCloseConfirmCallbackIfThisCallback) ? 2048 : 1024;
        }
        int i7 = i6;
        if ((i7 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(788107847, i7, -1, "dk.molslinjen.ui.views.global.navigation.NavigationGraph (NavigationGraph.kt:35)");
            }
            startRestartGroup.startReplaceGroup(147047386);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = mainViewModel.getInitialScreen();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Direction direction = (Direction) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(147049865);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Function2 function2 = (Function2) ((MutableState) rememberedValue2).getValue();
            startRestartGroup.startReplaceGroup(147052811);
            if (function2 != null) {
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                function2.invoke(startRestartGroup, 0);
                startRestartGroup.endNode();
                Unit unit = Unit.INSTANCE;
            }
            startRestartGroup.endReplaceGroup();
            Boolean bool = Boolean.TRUE;
            startRestartGroup.startReplaceGroup(147056007);
            boolean changedInstance = startRestartGroup.changedInstance(navController) | startRestartGroup.changedInstance(mainViewModel);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new NavigationGraphKt$NavigationGraph$2$1(navController, mainViewModel, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(bool, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(147063227);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new CheckoutExpirationDialogHandler();
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final CheckoutExpirationDialogHandler checkoutExpirationDialogHandler = (CheckoutExpirationDialogHandler) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            AnimatedRootNavigationNavGraph animatedRootNavigationNavGraph = AnimatedRootNavigationNavGraph.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1032418123, true, new Function3<DependenciesContainerBuilder<?>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.navigation.NavigationGraphKt$NavigationGraph$3
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(DependenciesContainerBuilder<?> dependenciesContainerBuilder, Composer composer3, Integer num) {
                    invoke(dependenciesContainerBuilder, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(DependenciesContainerBuilder<?> DestinationsNavHost, Composer composer3, int i8) {
                    int i9;
                    CreationExtras creationExtras;
                    Intrinsics.checkNotNullParameter(DestinationsNavHost, "$this$DestinationsNavHost");
                    if ((i8 & 6) == 0) {
                        i9 = (composer3.changed(DestinationsNavHost) ? 4 : 2) | i8;
                    } else {
                        i9 = i8;
                    }
                    if ((i9 & 19) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1032418123, i9, -1, "dk.molslinjen.ui.views.global.navigation.NavigationGraph.<anonymous> (NavigationGraph.kt:63)");
                    }
                    DestinationDependenciesContainerImpl destinationDependenciesContainerImpl = (DestinationDependenciesContainerImpl) DestinationsNavHost;
                    destinationDependenciesContainerImpl.dependency(MainViewModel.this, Reflection.getOrCreateKotlinClass(MainViewModel.class));
                    destinationDependenciesContainerImpl.dependency(new BottomSheetDismissHandler(setSheetCloseConfirmCallback, resetSheetCloseConfirmCallbackIfThisCallback), Reflection.getOrCreateKotlinClass(BottomSheetDismissHandler.class));
                    destinationDependenciesContainerImpl.dependency(new BottomSheetCustomDismissHandler(setSheetCloseConfirmCallback, resetSheetCloseConfirmCallbackIfThisCallback), Reflection.getOrCreateKotlinClass(BottomSheetCustomDismissHandler.class));
                    destinationDependenciesContainerImpl.dependency(checkoutExpirationDialogHandler, Reflection.getOrCreateKotlinClass(CheckoutExpirationDialogHandler.class));
                    NavGraphs navGraphs = NavGraphs.INSTANCE;
                    CheckoutNavigationNavGraph checkout = navGraphs.getCheckout();
                    NavHostController navHostController = navController;
                    int i10 = i9 & 14;
                    composer3.startReplaceGroup(945822773);
                    Object navBackStackEntry = DestinationsNavHost.getNavBackStackEntry();
                    composer3.startReplaceGroup(-1585232407);
                    boolean changed = composer3.changed(navBackStackEntry) | composer3.changed(checkout);
                    Object rememberedValue5 = composer3.rememberedValue();
                    if (changed || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        String route = DestinationsNavHost.getNavBackStackEntry().getDestination().getRoute();
                        if (route != null) {
                            rememberedValue5 = Boolean.valueOf(SpecExtensionsKt.findDestination(checkout, route) != null);
                            composer3.updateRememberedValue(rememberedValue5);
                        } else {
                            throw new IllegalArgumentException("Required value was null.");
                        }
                    }
                    boolean booleanValue = ((Boolean) rememberedValue5).booleanValue();
                    composer3.endReplaceGroup();
                    if (booleanValue) {
                        Object navBackStackEntry2 = DestinationsNavHost.getNavBackStackEntry();
                        composer3.startReplaceGroup(1246164552);
                        boolean changed2 = composer3.changed(navBackStackEntry2);
                        Object rememberedValue6 = composer3.rememberedValue();
                        if (changed2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue6 = navHostController.getBackStackEntry(navGraphs.getCheckout().getRoute());
                            composer3.updateRememberedValue(rememberedValue6);
                        }
                        NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) rememberedValue6;
                        composer3.endReplaceGroup();
                        composer3.startReplaceableGroup(1890788296);
                        ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(navBackStackEntry3, composer3, 0);
                        composer3.startReplaceableGroup(1729797275);
                        if (navBackStackEntry3 != null) {
                            creationExtras = navBackStackEntry3.getDefaultViewModelCreationExtras();
                        } else {
                            creationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) CheckoutViewModel.class, navBackStackEntry3, (String) null, createHiltViewModelFactory, creationExtras, composer3, 36936, 0);
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        ((DestinationDependenciesContainerImpl) DestinationsNavHost).dependency(viewModel, Reflection.getOrCreateKotlinClass(CheckoutViewModel.class));
                    }
                    composer3.endReplaceGroup();
                    Iterator<T> it = ScreenConfigurationsKt.getScreenConfigurations().iterator();
                    while (it.hasNext()) {
                        ((SimpleScreenConfig) it.next()).BuildDependencies(DestinationsNavHost, composer3, i10);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            startRestartGroup.startReplaceGroup(147113040);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: R1.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit NavigationGraph$lambda$7$lambda$6;
                        NavigationGraph$lambda$7$lambda$6 = NavigationGraphKt.NavigationGraph$lambda$7$lambda$6((ManualComposableCallsBuilder) obj);
                        return NavigationGraph$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            DestinationsNavHostKt.DestinationsNavHost(animatedRootNavigationNavGraph, m104backgroundbw27NRU$default, direction, null, null, navController, rememberComposableLambda, (Function1) rememberedValue5, startRestartGroup, ((i7 << 15) & 458752) | 14155824, 24);
            ListenForNavigationChanges(mainViewModel, navController, composer2, ((i7 >> 3) & 14) | ((i7 << 3) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: R1.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NavigationGraph$lambda$8;
                    NavigationGraph$lambda$8 = NavigationGraphKt.NavigationGraph$lambda$8(NavHostController.this, mainViewModel, setSheetCloseConfirmCallback, resetSheetCloseConfirmCallbackIfThisCallback, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return NavigationGraph$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationGraph$lambda$7$lambda$6(ManualComposableCallsBuilder DestinationsNavHost) {
        Intrinsics.checkNotNullParameter(DestinationsNavHost, "$this$DestinationsNavHost");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationGraph$lambda$8(NavHostController navHostController, MainViewModel mainViewModel, Function1 function1, Function1 function12, int i5, Composer composer, int i6) {
        NavigationGraph(navHostController, mainViewModel, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logBreadcrumbForNavigation(NavBackStackEntry navBackStackEntry) {
        Bundle arguments = navBackStackEntry.getArguments();
        String str = null;
        String bundle = arguments != null ? arguments.toString() : null;
        if (bundle != null && !Intrinsics.areEqual(bundle, "Bundle[{android-support-nav:controller:deepLinkIntent=Intent { dat=android-app://androidx.navigation/... }}]")) {
            str = StringsKt.replace$default(bundle, "Bundle[{android-support-nav:controller:deepLinkIntent=Intent { dat=android-app://androidx.navigation/... }, ", "[{", false, 4, (Object) null);
        }
        Logger.log$default(Logger.INSTANCE, "New destination: " + navBackStackEntry.getDestination().getRoute() + " > " + str, "Navigation", 0, 4, null);
    }
}
