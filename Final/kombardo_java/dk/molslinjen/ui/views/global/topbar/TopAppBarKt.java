package dk.molslinjen.ui.views.global.topbar;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavController;
import androidx.view.OnBackPressedDispatcher;
import androidx.view.OnBackPressedDispatcherOwner;
import androidx.view.compose.LocalOnBackPressedDispatcherOwner;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.global.navigation.SimpleScreenConfig;
import dk.molslinjen.ui.views.global.topbar.NavigationButton;
import dk.molslinjen.ui.views.global.topbar.TopAppBarKt;
import dk.molslinjen.ui.views.global.topbar.TopBarButtonConfiguration;
import dk.molslinjen.ui.views.global.topbar.TopBarConfiguration;
import dk.molslinjen.ui.views.global.topbar.TopBarViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Ldk/molslinjen/ui/views/global/topbar/TopBarViewModel;", "viewModel", "Landroidx/navigation/NavController;", "navController", BuildConfig.FLAVOR, "TopAppBar", "(Ldk/molslinjen/ui/views/global/topbar/TopBarViewModel;Landroidx/navigation/NavController;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/global/topbar/TopBarConfiguration;", "topBarConfig", "TopAppBarContent", "(Ldk/molslinjen/ui/views/global/topbar/TopBarConfiguration;Landroidx/navigation/NavController;Landroidx/compose/runtime/Composer;I)V", "TopBarBackButton", "(Landroidx/navigation/NavController;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TopAppBarKt {
    public static final void TopAppBar(final TopBarViewModel viewModel, final NavController navController, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer startRestartGroup = composer.startRestartGroup(-3531542);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navController) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-3531542, i6, -1, "dk.molslinjen.ui.views.global.topbar.TopAppBar (TopAppBar.kt:33)");
            }
            State collectAsState = SnapshotStateKt.collectAsState(viewModel.getConfigState(), null, startRestartGroup, 0, 1);
            if (((TopBarConfiguration) collectAsState.getValue()).getIsVisible()) {
                TopAppBarContent((TopBarConfiguration) collectAsState.getValue(), navController, startRestartGroup, i6 & 112);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: V1.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TopAppBar$lambda$0;
                    TopAppBar$lambda$0 = TopAppBarKt.TopAppBar$lambda$0(TopBarViewModel.this, navController, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TopAppBar$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBar$lambda$0(TopBarViewModel topBarViewModel, NavController navController, int i5, Composer composer, int i6) {
        TopAppBar(topBarViewModel, navController, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void TopAppBarContent(final TopBarConfiguration topBarConfiguration, final NavController navController, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1626470429);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(topBarConfiguration) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navController) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1626470429, i6, -1, "dk.molslinjen.ui.views.global.topbar.TopAppBarContent (TopAppBar.kt:46)");
            }
            startRestartGroup.startReplaceGroup(-122964046);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new FocusRequester();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            FocusRequester focusRequester = (FocusRequester) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Integer title = topBarConfiguration.getTitle();
            startRestartGroup.startReplaceGroup(-122961317);
            boolean changedInstance = startRestartGroup.changedInstance(topBarConfiguration);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new TopAppBarKt$TopAppBarContent$1$1(topBarConfiguration, focusRequester, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(title, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 0);
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1130212514, true, new TopAppBarKt$TopAppBarContent$2(topBarConfiguration, focusRequester), startRestartGroup, 54);
            ComposableLambda rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1394860004, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.topbar.TopAppBarKt$TopAppBarContent$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i7) {
                    if ((i7 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1394860004, i7, -1, "dk.molslinjen.ui.views.global.topbar.TopAppBarContent.<anonymous> (TopAppBar.kt:75)");
                    }
                    NavigationButton navigationButton = TopBarConfiguration.this.getNavigationButton();
                    if (Intrinsics.areEqual(navigationButton, NavigationButton.Back.INSTANCE)) {
                        composer3.startReplaceGroup(-2046958413);
                        TopAppBarKt.TopBarBackButton(navController, composer3, 0);
                        composer3.endReplaceGroup();
                    } else if (navigationButton instanceof NavigationButton.Custom) {
                        composer3.startReplaceGroup(-2046955845);
                        TopBarButtonKt.TopBarButton(((NavigationButton.Custom) TopBarConfiguration.this.getNavigationButton()).getConfiguration(), navController, composer3, 0);
                        composer3.endReplaceGroup();
                    } else {
                        if (!Intrinsics.areEqual(navigationButton, NavigationButton.None.INSTANCE)) {
                            composer3.startReplaceGroup(-2046960625);
                            composer3.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composer3.startReplaceGroup(969020816);
                        composer3.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            ComposableLambda rememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-521659949, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.topbar.TopAppBarKt$TopAppBarContent$4

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* loaded from: classes2.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[TopBarButtonType.values().length];
                        try {
                            iArr[TopBarButtonType.Profile.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                    invoke(rowScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope CenterAlignedTopAppBar, Composer composer3, int i7) {
                    Intrinsics.checkNotNullParameter(CenterAlignedTopAppBar, "$this$CenterAlignedTopAppBar");
                    if ((i7 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-521659949, i7, -1, "dk.molslinjen.ui.views.global.topbar.TopAppBarContent.<anonymous> (TopAppBar.kt:84)");
                    }
                    List<TopBarButtonType> buttons = TopBarConfiguration.this.getButtons();
                    NavController navController2 = navController;
                    TopBarConfiguration topBarConfiguration2 = TopBarConfiguration.this;
                    int i8 = 0;
                    for (Object obj : buttons) {
                        int i9 = i8 + 1;
                        if (i8 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (WhenMappings.$EnumSwitchMapping$0[((TopBarButtonType) obj).ordinal()] == 1) {
                            TopBarButtonKt.TopBarButton(SimpleScreenConfig.INSTANCE.getTopBarProfileButton(), navController2, composer3, 0);
                            composer3.startReplaceGroup(-2046935472);
                            if (CollectionsKt.getLastIndex(topBarConfiguration2.getButtons()) == i8) {
                                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(8)), composer3, 6);
                            }
                            composer3.endReplaceGroup();
                            i8 = i9;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            TopAppBarDefaults topAppBarDefaults = TopAppBarDefaults.INSTANCE;
            AppColor appColor = AppColor.INSTANCE;
            composer2 = startRestartGroup;
            AppBarKt.m770CenterAlignedTopAppBarGHTll3U(rememberComposableLambda, null, rememberComposableLambda2, rememberComposableLambda3, 0.0f, null, topAppBarDefaults.m990topAppBarColorszjMxDiM(appColor.m3259getBrandDarkBlue10d7_KjU(), 0L, 0L, appColor.m3281getWhite0d7_KjU(), 0L, startRestartGroup, (TopAppBarDefaults.$stable << 15) | 3078, 22), null, composer2, 3462, 178);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: V1.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TopAppBarContent$lambda$3;
                    TopAppBarContent$lambda$3 = TopAppBarKt.TopAppBarContent$lambda$3(TopBarConfiguration.this, navController, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TopAppBarContent$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopAppBarContent$lambda$3(TopBarConfiguration topBarConfiguration, NavController navController, int i5, Composer composer, int i6) {
        TopAppBarContent(topBarConfiguration, navController, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TopBarBackButton(final NavController navController, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1117774756);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(navController) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1117774756, i6, -1, "dk.molslinjen.ui.views.global.topbar.TopBarBackButton (TopAppBar.kt:106)");
            }
            OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(startRestartGroup, LocalOnBackPressedDispatcherOwner.$stable);
            if (current == null) {
                throw new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner");
            }
            final OnBackPressedDispatcher onBackPressedDispatcher = current.getOnBackPressedDispatcher();
            Integer valueOf = Integer.valueOf(R.string.accessibilityLabel_back);
            startRestartGroup.startReplaceGroup(-25304912);
            boolean changedInstance = startRestartGroup.changedInstance(onBackPressedDispatcher);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: V1.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TopBarBackButton$lambda$6$lambda$5;
                        TopBarBackButton$lambda$6$lambda$5 = TopAppBarKt.TopBarBackButton$lambda$6$lambda$5(OnBackPressedDispatcher.this, (NavController) obj);
                        return TopBarBackButton$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            TopBarButtonKt.TopBarButton(new TopBarButtonConfiguration.Basic(R.drawable.icon_chevron_back, valueOf, (Function1) rememberedValue), navController, startRestartGroup, (i6 << 3) & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: V1.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TopBarBackButton$lambda$7;
                    TopBarBackButton$lambda$7 = TopAppBarKt.TopBarBackButton$lambda$7(NavController.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TopBarBackButton$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBarBackButton$lambda$6$lambda$5(OnBackPressedDispatcher onBackPressedDispatcher, NavController it) {
        Intrinsics.checkNotNullParameter(it, "it");
        onBackPressedDispatcher.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBarBackButton$lambda$7(NavController navController, int i5, Composer composer, int i6) {
        TopBarBackButton(navController, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
