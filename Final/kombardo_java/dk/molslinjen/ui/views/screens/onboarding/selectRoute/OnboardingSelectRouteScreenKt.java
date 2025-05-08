package dk.molslinjen.ui.views.screens.onboarding.selectRoute;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.NavOptionsBuilderKt;
import androidx.navigation.PopUpToBuilder;
import com.ramcosta.composedestinations.generated.destinations.OnboardingSelectRouteScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.main.MainViewModel;
import dk.molslinjen.ui.views.screens.onboarding.selectRoute.OnboardingSelectRouteScreenKt;
import dk.molslinjen.ui.views.screens.onboarding.selectRoute.OnboardingSelectRouteViewModel;
import dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0003¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Ldk/molslinjen/ui/views/screens/onboarding/selectRoute/OnboardingSelectRouteViewModel;", "viewModel", "Ldk/molslinjen/ui/views/screens/main/MainViewModel;", "mainViewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "OnboardingSelectRouteScreen", "(Ldk/molslinjen/ui/views/screens/onboarding/selectRoute/OnboardingSelectRouteViewModel;Ldk/molslinjen/ui/views/screens/main/MainViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Lkotlin/Function0;", "onRouteSelected", "OnboardingSelectRouteContent", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class OnboardingSelectRouteScreenKt {
    private static final void OnboardingSelectRouteContent(final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1510210190);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1510210190, i6, -1, "dk.molslinjen.ui.views.screens.onboarding.selectRoute.OnboardingSelectRouteContent (OnboardingSelectRouteScreen.kt:42)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            float f5 = 24;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(companion, Dp.m2599constructorimpl(f5));
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getCenterHorizontally(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            String stringResource = StringResources_androidKt.stringResource(R.string.onboarding_selectRoute_title, startRestartGroup, 6);
            TextStyle h1Bold = TypographyKt.getH1Bold();
            AppColor appColor = AppColor.INSTANCE;
            TextKt.m940Text4IGK_g(stringResource, null, appColor.m3253getBrandBlack10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, h1Bold, startRestartGroup, 384, 1572864, 65530);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.onboarding_selectRoute_description, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(16), 0.0f, Dp.m2599constructorimpl(f5), 5, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 432, 1572864, 65016);
            startRestartGroup.endNode();
            composer2 = startRestartGroup;
            RouteSelectorViewKt.RouteSelectorView(function0, composer2, i6 & 14);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: u3.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OnboardingSelectRouteContent$lambda$8;
                    OnboardingSelectRouteContent$lambda$8 = OnboardingSelectRouteScreenKt.OnboardingSelectRouteContent$lambda$8(Function0.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return OnboardingSelectRouteContent$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingSelectRouteContent$lambda$8(Function0 function0, int i5, Composer composer, int i6) {
        OnboardingSelectRouteContent(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void OnboardingSelectRouteScreen(final OnboardingSelectRouteViewModel viewModel, final MainViewModel mainViewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(mainViewModel, "mainViewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-100705688);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(mainViewModel) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-100705688, i6, -1, "dk.molslinjen.ui.views.screens.onboarding.selectRoute.OnboardingSelectRouteScreen (OnboardingSelectRouteScreen.kt:26)");
            }
            startRestartGroup.startReplaceGroup(-504825123);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel) | ((i6 & 896) == 256) | startRestartGroup.changedInstance(mainViewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: u3.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OnboardingSelectRouteScreen$lambda$4$lambda$3;
                        OnboardingSelectRouteScreen$lambda$4$lambda$3 = OnboardingSelectRouteScreenKt.OnboardingSelectRouteScreen$lambda$4$lambda$3(OnboardingSelectRouteViewModel.this, navigator, mainViewModel);
                        return OnboardingSelectRouteScreen$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            OnboardingSelectRouteContent((Function0) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: u3.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OnboardingSelectRouteScreen$lambda$5;
                    OnboardingSelectRouteScreen$lambda$5 = OnboardingSelectRouteScreenKt.OnboardingSelectRouteScreen$lambda$5(OnboardingSelectRouteViewModel.this, mainViewModel, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return OnboardingSelectRouteScreen$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingSelectRouteScreen$lambda$4$lambda$3(OnboardingSelectRouteViewModel onboardingSelectRouteViewModel, final DestinationsNavigator destinationsNavigator, final MainViewModel mainViewModel) {
        onboardingSelectRouteViewModel.routeSelected(new Function0() { // from class: u3.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit OnboardingSelectRouteScreen$lambda$4$lambda$3$lambda$2;
                OnboardingSelectRouteScreen$lambda$4$lambda$3$lambda$2 = OnboardingSelectRouteScreenKt.OnboardingSelectRouteScreen$lambda$4$lambda$3$lambda$2(DestinationsNavigator.this, mainViewModel);
                return OnboardingSelectRouteScreen$lambda$4$lambda$3$lambda$2;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingSelectRouteScreen$lambda$4$lambda$3$lambda$2(DestinationsNavigator destinationsNavigator, MainViewModel mainViewModel) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, mainViewModel.getNextOnboardingStep(), NavOptionsBuilderKt.navOptions(new Function1() { // from class: u3.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit OnboardingSelectRouteScreen$lambda$4$lambda$3$lambda$2$lambda$1;
                OnboardingSelectRouteScreen$lambda$4$lambda$3$lambda$2$lambda$1 = OnboardingSelectRouteScreenKt.OnboardingSelectRouteScreen$lambda$4$lambda$3$lambda$2$lambda$1((NavOptionsBuilder) obj);
                return OnboardingSelectRouteScreen$lambda$4$lambda$3$lambda$2$lambda$1;
            }
        }), null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingSelectRouteScreen$lambda$4$lambda$3$lambda$2$lambda$1(NavOptionsBuilder navOptions) {
        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
        navOptions.popUpTo(OnboardingSelectRouteScreenDestination.INSTANCE.getRoute(), new Function1() { // from class: u3.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit OnboardingSelectRouteScreen$lambda$4$lambda$3$lambda$2$lambda$1$lambda$0;
                OnboardingSelectRouteScreen$lambda$4$lambda$3$lambda$2$lambda$1$lambda$0 = OnboardingSelectRouteScreenKt.OnboardingSelectRouteScreen$lambda$4$lambda$3$lambda$2$lambda$1$lambda$0((PopUpToBuilder) obj);
                return OnboardingSelectRouteScreen$lambda$4$lambda$3$lambda$2$lambda$1$lambda$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingSelectRouteScreen$lambda$4$lambda$3$lambda$2$lambda$1$lambda$0(PopUpToBuilder popUpTo) {
        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
        popUpTo.setInclusive(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingSelectRouteScreen$lambda$5(OnboardingSelectRouteViewModel onboardingSelectRouteViewModel, MainViewModel mainViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        OnboardingSelectRouteScreen(onboardingSelectRouteViewModel, mainViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
