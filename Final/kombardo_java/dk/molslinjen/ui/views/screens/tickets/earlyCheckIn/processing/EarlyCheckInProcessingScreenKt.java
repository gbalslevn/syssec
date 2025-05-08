package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing;

import android.content.res.Configuration;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.view.compose.BackHandlerKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt;
import com.airbnb.lottie.compose.LottieAnimatable;
import com.airbnb.lottie.compose.LottieAnimatableKt;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieClipSpec;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BlockedDismissType;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.lottie.FixedSizeLottieAnimationKt;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.EarlyCheckInProcessingScreenKt;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.EarlyCheckInProcessingViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001aE\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a%\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0012H\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001d\u0010\u0016\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0012H\u0003¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001c²\u0006\u000e\u0010\u0019\u001a\u0004\u0018\u00010\u00188\nX\u008a\u0084\u0002²\u0006\f\u0010\u001b\u001a\u00020\u001a8\nX\u008a\u0084\u0002²\u0006\u000e\u0010\u0019\u001a\u0004\u0018\u00010\u00188\nX\u008a\u0084\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/processing/EarlyCheckInProcessingViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", BuildConfig.FLAVOR, "resultNavigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Landroidx/navigation/NavController;", "navController", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;", "bottomSheetDismissHandler", BuildConfig.FLAVOR, "EarlyCheckInProcessingScreen", "(Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/processing/EarlyCheckInProcessingViewModel;Lcom/ramcosta/composedestinations/result/ResultBackNavigator;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/navigation/NavController;Landroidx/navigation/NavBackStackEntry;Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/processing/EarlyCheckInProcessingViewModel$ViewState;", "state", "Lkotlin/Function0;", "proceed", "EarlyCheckInProcessingContent", "(Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/processing/EarlyCheckInProcessingViewModel$ViewState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SuccessView", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Lcom/airbnb/lottie/LottieComposition;", "composition", BuildConfig.FLAVOR, "progress", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class EarlyCheckInProcessingScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void EarlyCheckInProcessingContent(final EarlyCheckInProcessingViewModel.ViewState viewState, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1408538720);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1408538720, i6, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.EarlyCheckInProcessingContent (EarlyCheckInProcessingScreen.kt:97)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (viewState.getIsCompleted()) {
                startRestartGroup.startReplaceGroup(2052660564);
                SuccessView(function0, startRestartGroup, (i6 >> 3) & 14);
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
            } else {
                startRestartGroup.startReplaceGroup(2052734468);
                LottieCompositionResult rememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m2761boximpl(LottieCompositionSpec.RawRes.m2762constructorimpl(R.raw.animation_lottie_full_width_spinner)), null, null, null, null, null, startRestartGroup, 6, 62);
                final LottieAnimationState animateLottieCompositionAsState = AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(EarlyCheckInProcessingContent$lambda$8$lambda$4(rememberLottieComposition), false, false, false, null, 0.0f, Integer.MAX_VALUE, null, false, false, startRestartGroup, 1572864, 958);
                LottieComposition EarlyCheckInProcessingContent$lambda$8$lambda$4 = EarlyCheckInProcessingContent$lambda$8$lambda$4(rememberLottieComposition);
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(1313156324);
                boolean changed = composer2.changed(animateLottieCompositionAsState);
                Object rememberedValue = composer2.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: s4.e
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            float EarlyCheckInProcessingContent$lambda$8$lambda$5;
                            EarlyCheckInProcessingContent$lambda$8$lambda$5 = EarlyCheckInProcessingScreenKt.EarlyCheckInProcessingContent$lambda$8$lambda$5(LottieAnimationState.this);
                            return Float.valueOf(EarlyCheckInProcessingContent$lambda$8$lambda$5);
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                composer2.endReplaceGroup();
                FixedSizeLottieAnimationKt.FixedSizeLottieAnimation(EarlyCheckInProcessingContent$lambda$8$lambda$4, (Function0) rememberedValue, null, Accessibility.INSTANCE.getSkip(), composer2, 0, 4);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: s4.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit EarlyCheckInProcessingContent$lambda$9;
                    EarlyCheckInProcessingContent$lambda$9 = EarlyCheckInProcessingScreenKt.EarlyCheckInProcessingContent$lambda$9(EarlyCheckInProcessingViewModel.ViewState.this, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return EarlyCheckInProcessingContent$lambda$9;
                }
            });
        }
    }

    private static final LottieComposition EarlyCheckInProcessingContent$lambda$8$lambda$4(LottieCompositionResult lottieCompositionResult) {
        return lottieCompositionResult.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float EarlyCheckInProcessingContent$lambda$8$lambda$5(LottieAnimationState lottieAnimationState) {
        return lottieAnimationState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInProcessingContent$lambda$9(EarlyCheckInProcessingViewModel.ViewState viewState, Function0 function0, int i5, Composer composer, int i6) {
        EarlyCheckInProcessingContent(viewState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void EarlyCheckInProcessingScreen(final EarlyCheckInProcessingViewModel viewModel, final ResultBackNavigator<Boolean> resultNavigator, final DestinationsNavigator navigator, final NavController navController, final NavBackStackEntry navBackStackEntry, final BottomSheetDismissHandler bottomSheetDismissHandler, Composer composer, final int i5) {
        int i6;
        Boolean bool;
        boolean z5;
        int i7;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(resultNavigator, "resultNavigator");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(bottomSheetDismissHandler, "bottomSheetDismissHandler");
        Composer startRestartGroup = composer.startRestartGroup(694068952);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(resultNavigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(navController) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(navBackStackEntry) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(bottomSheetDismissHandler) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(694068952, i6, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.EarlyCheckInProcessingScreen (EarlyCheckInProcessingScreen.kt:48)");
            }
            int i8 = i6 & 896;
            bottomSheetDismissHandler.SetupHandling(navBackStackEntry, navController, navigator, BlockedDismissType.DragToDismissAndBackAction, startRestartGroup, ((i6 >> 12) & 14) | 3072 | ((i6 >> 6) & 112) | i8 | ((i6 >> 3) & 57344));
            EarlyCheckInProcessingViewModel.ViewState viewState = (EarlyCheckInProcessingViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            Configuration configuration = (Configuration) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
            float m2599constructorimpl = Dp.m2599constructorimpl(configuration.screenWidthDp);
            float m2599constructorimpl2 = Dp.m2599constructorimpl(configuration.screenHeightDp);
            Boolean bool2 = Boolean.TRUE;
            startRestartGroup.startReplaceGroup(-805990571);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changedInstance(bottomSheetDismissHandler) | (i8 == 256) | startRestartGroup.changed(m2599constructorimpl) | startRestartGroup.changed(m2599constructorimpl2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                bool = bool2;
                z5 = true;
                i7 = 0;
                EarlyCheckInProcessingScreenKt$EarlyCheckInProcessingScreen$1$1 earlyCheckInProcessingScreenKt$EarlyCheckInProcessingScreen$1$1 = new EarlyCheckInProcessingScreenKt$EarlyCheckInProcessingScreen$1$1(viewModel, m2599constructorimpl, m2599constructorimpl2, bottomSheetDismissHandler, navigator, null);
                startRestartGroup.updateRememberedValue(earlyCheckInProcessingScreenKt$EarlyCheckInProcessingScreen$1$1);
                rememberedValue = earlyCheckInProcessingScreenKt$EarlyCheckInProcessingScreen$1$1;
            } else {
                bool = bool2;
                z5 = true;
                i7 = 0;
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(bool, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-805982537);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: s4.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            BackHandlerKt.BackHandler(z5, (Function0) rememberedValue2, startRestartGroup, 54, i7);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3398BottomSheetContainer8Un_QVk(null, 0.0f, 0L, new AnnotatedString(StringResources_androidKt.stringResource(R.string.earlyCheckIn_title, startRestartGroup, 6), null, null, 6, null), null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-223062805, z5, new EarlyCheckInProcessingScreenKt$EarlyCheckInProcessingScreen$3(viewState, resultNavigator, navController, bottomSheetDismissHandler, navigator), startRestartGroup, 54), composer2, 805306368, 503);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: s4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit EarlyCheckInProcessingScreen$lambda$3;
                    EarlyCheckInProcessingScreen$lambda$3 = EarlyCheckInProcessingScreenKt.EarlyCheckInProcessingScreen$lambda$3(EarlyCheckInProcessingViewModel.this, resultNavigator, navigator, navController, navBackStackEntry, bottomSheetDismissHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return EarlyCheckInProcessingScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInProcessingScreen$lambda$3(EarlyCheckInProcessingViewModel earlyCheckInProcessingViewModel, ResultBackNavigator resultBackNavigator, DestinationsNavigator destinationsNavigator, NavController navController, NavBackStackEntry navBackStackEntry, BottomSheetDismissHandler bottomSheetDismissHandler, int i5, Composer composer, int i6) {
        EarlyCheckInProcessingScreen(earlyCheckInProcessingViewModel, resultBackNavigator, destinationsNavigator, navController, navBackStackEntry, bottomSheetDismissHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void SuccessView(final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-736042092);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-736042092, i6, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.SuccessView (EarlyCheckInProcessingScreen.kt:120)");
            }
            startRestartGroup.startReplaceGroup(-1135813677);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new LottieClipSpec.Markers("Pop", "Shrink", false, 4, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            LottieClipSpec.Markers markers = (LottieClipSpec.Markers) rememberedValue;
            startRestartGroup.endReplaceGroup();
            LottieCompositionResult rememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m2761boximpl(LottieCompositionSpec.RawRes.m2762constructorimpl(R.raw.animation_lottie_login_check_pop_shrink)), null, null, null, null, null, startRestartGroup, 6, 62);
            final LottieAnimatable rememberLottieAnimatable = LottieAnimatableKt.rememberLottieAnimatable(startRestartGroup, 0);
            LottieComposition SuccessView$lambda$11 = SuccessView$lambda$11(rememberLottieComposition);
            startRestartGroup.startReplaceGroup(-1135801839);
            boolean changed = startRestartGroup.changed(rememberLottieAnimatable) | startRestartGroup.changed(rememberLottieComposition) | startRestartGroup.changedInstance(markers);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new EarlyCheckInProcessingScreenKt$SuccessView$1$1(rememberLottieAnimatable, markers, rememberLottieComposition, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(markers, SuccessView$lambda$11, (Function2) rememberedValue2, startRestartGroup, LottieClipSpec.Markers.$stable);
            Boolean valueOf = Boolean.valueOf(rememberLottieAnimatable.isAtEnd());
            Float valueOf2 = Float.valueOf(rememberLottieAnimatable.getProgress());
            startRestartGroup.startReplaceGroup(-1135793973);
            boolean changed2 = startRestartGroup.changed(rememberLottieAnimatable) | ((i6 & 14) == 4);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new EarlyCheckInProcessingScreenKt$SuccessView$2$1(rememberLottieAnimatable, function0, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(valueOf, valueOf2, (Function2) rememberedValue3, startRestartGroup, 0);
            LottieComposition SuccessView$lambda$112 = SuccessView$lambda$11(rememberLottieComposition);
            startRestartGroup.startReplaceGroup(-1135788036);
            boolean changed3 = startRestartGroup.changed(rememberLottieAnimatable);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: s4.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        float progress;
                        progress = LottieAnimatable.this.getProgress();
                        return Float.valueOf(progress);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            FixedSizeLottieAnimationKt.FixedSizeLottieAnimation(SuccessView$lambda$112, (Function0) rememberedValue4, null, Accessibility.INSTANCE.getSkip(), startRestartGroup, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: s4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SuccessView$lambda$16;
                    SuccessView$lambda$16 = EarlyCheckInProcessingScreenKt.SuccessView$lambda$16(Function0.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SuccessView$lambda$16;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LottieComposition SuccessView$lambda$11(LottieCompositionResult lottieCompositionResult) {
        return lottieCompositionResult.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuccessView$lambda$16(Function0 function0, int i5, Composer composer, int i6) {
        SuccessView(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
