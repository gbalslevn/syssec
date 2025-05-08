package dk.molslinjen.ui.views.screens.profile.merge;

import android.content.Context;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
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
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.ManagerResultKt;
import dk.molslinjen.domain.managers.user.LoginResult;
import dk.molslinjen.domain.managers.user.merge.AssetsMergeMethod;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.NavigationButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.NavigationButtonType;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import dk.molslinjen.ui.views.reusable.lottie.ShrinkingCheckmarkAnimationViewKt;
import dk.molslinjen.ui.views.screens.profile.authentication.LoginAnimationState;
import dk.molslinjen.ui.views.screens.profile.authentication.LoginAnimationViewKt;
import dk.molslinjen.ui.views.screens.profile.authentication.register.LoginAnimationMode;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeScreenKt;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0085\u0001\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\t\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00042$\u0010\f\u001a \b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a]\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a)\u0010\u001e\u001a\u00020\u000e*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0003¢\u0006\u0004\b\u001e\u0010\u001f\u001a#\u0010 \u001a\u00020\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u0004H\u0003¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel;", "viewModel", "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeFlowType;", "flowType", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/managers/user/LoginResult;", BuildConfig.FLAVOR, "action", "Lkotlin/Function2;", "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "failure", "Lkotlin/Function0;", BuildConfig.FLAVOR, "dismissForSuccess", "onCancelMerge", "AssetsMergeScreen", "(Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel;Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeFlowType;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState;", "state", "retryAction", "Ldk/molslinjen/domain/managers/user/merge/AssetsMergeMethod;", "handleMerge", "cancelMerge", "AssetsMergeContent", "(Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeViewModel$MergeState;Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeFlowType;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/layout/ColumnScope;", "error", "retry", "ErrorView", "(Landroidx/compose/foundation/layout/ColumnScope;Ldk/molslinjen/domain/managers/ManagerResult$Error;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "MergeView", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AssetsMergeScreenKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AssetsMergeFlowType.values().length];
            try {
                iArr[AssetsMergeFlowType.Login.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AssetsMergeFlowType.ResetPassword.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AssetsMergeFlowType.AccountActivation.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x0379  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AssetsMergeContent(final AssetsMergeViewModel.MergeState state, final AssetsMergeFlowType flowType, final Function0<Unit> retryAction, final Function1<? super AssetsMergeMethod, Unit> handleMerge, final Function0<Unit> cancelMerge, final Function0<Unit> dismissForSuccess, Composer composer, final int i5) {
        int i6;
        LoginAnimationMode loginAnimationMode;
        Modifier.Companion companion;
        Modifier.Companion companion2;
        int i7;
        Composer composer2;
        boolean z5;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(flowType, "flowType");
        Intrinsics.checkNotNullParameter(retryAction, "retryAction");
        Intrinsics.checkNotNullParameter(handleMerge, "handleMerge");
        Intrinsics.checkNotNullParameter(cancelMerge, "cancelMerge");
        Intrinsics.checkNotNullParameter(dismissForSuccess, "dismissForSuccess");
        Composer startRestartGroup = composer.startRestartGroup(-593641286);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(state) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(flowType) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(retryAction) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(handleMerge) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(cancelMerge) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(dismissForSuccess) ? 131072 : 65536;
        }
        int i8 = i6;
        if ((74899 & i8) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-593641286, i8, -1, "dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeContent (AssetsMergeScreen.kt:87)");
            }
            int i9 = WhenMappings.$EnumSwitchMapping$0[flowType.ordinal()];
            if (i9 == 1) {
                loginAnimationMode = LoginAnimationMode.Login;
            } else if (i9 == 2) {
                loginAnimationMode = LoginAnimationMode.ResetPassword;
            } else {
                if (i9 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                loginAnimationMode = LoginAnimationMode.Activation;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (rememberedValue == companion3.getEmpty()) {
                rememberedValue = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            Modifier.Companion companion4 = Modifier.INSTANCE;
            Alignment.Companion companion5 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion5.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion4);
            ComposeUiNode.Companion companion6 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion6.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion6.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion6.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion6.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion6.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxSize$default(companion4, 0.0f, 1, null), Dp.m2599constructorimpl(24), 0.0f, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getCenter(), companion5.getCenterHorizontally(), startRestartGroup, 54);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor2 = companion6.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion6.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion6.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion6.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion6.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (Intrinsics.areEqual(state, AssetsMergeViewModel.MergeState.Merge.INSTANCE)) {
                startRestartGroup.startReplaceGroup(2009414146);
                companion = companion4;
                ShrinkingCheckmarkAnimationViewKt.m3423ShrinkingCheckmarkAnimationVieweuL9pac(0L, false, null, ComposableLambdaKt.rememberComposableLambda(1570960749, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeScreenKt$AssetsMergeContent$1$1$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i10) {
                        if ((i10 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1570960749, i10, -1, "dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeContent.<anonymous>.<anonymous>.<anonymous> (AssetsMergeScreen.kt:106)");
                        }
                        AssetsMergeScreenKt.MergeView(handleMerge, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, 3120, 5);
                startRestartGroup.endReplaceGroup();
            } else {
                companion = companion4;
                if (state instanceof AssetsMergeViewModel.MergeState.ActionError) {
                    startRestartGroup.startReplaceGroup(2009419733);
                    ManagerResult.Error error = ((AssetsMergeViewModel.MergeState.ActionError) state).getError();
                    startRestartGroup.startReplaceGroup(2009422195);
                    z5 = (i8 & 896) == 256;
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (z5 || rememberedValue2 == companion3.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: O3.e
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit AssetsMergeContent$lambda$14$lambda$13$lambda$8$lambda$7;
                                AssetsMergeContent$lambda$14$lambda$13$lambda$8$lambda$7 = AssetsMergeScreenKt.AssetsMergeContent$lambda$14$lambda$13$lambda$8$lambda$7(Function0.this);
                                return AssetsMergeContent$lambda$14$lambda$13$lambda$8$lambda$7;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    ErrorView(columnScopeInstance, error, (Function0) rememberedValue2, startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                } else if (state instanceof AssetsMergeViewModel.MergeState.MergingError) {
                    startRestartGroup.startReplaceGroup(2009424972);
                    ManagerResult.Error error2 = ((AssetsMergeViewModel.MergeState.MergingError) state).getError();
                    startRestartGroup.startReplaceGroup(2009427434);
                    z5 = (i8 & 7168) == 2048;
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (z5 || rememberedValue3 == companion3.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: O3.f
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit AssetsMergeContent$lambda$14$lambda$13$lambda$10$lambda$9;
                                AssetsMergeContent$lambda$14$lambda$13$lambda$10$lambda$9 = AssetsMergeScreenKt.AssetsMergeContent$lambda$14$lambda$13$lambda$10$lambda$9(Function1.this);
                                return AssetsMergeContent$lambda$14$lambda$13$lambda$10$lambda$9;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    startRestartGroup.endReplaceGroup();
                    ErrorView(columnScopeInstance, error2, (Function0) rememberedValue3, startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                } else {
                    if (!Intrinsics.areEqual(state, AssetsMergeViewModel.MergeState.Loading.INSTANCE) && !Intrinsics.areEqual(state, AssetsMergeViewModel.MergeState.Success.INSTANCE)) {
                        startRestartGroup.startReplaceGroup(2009413766);
                        startRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    startRestartGroup.startReplaceGroup(-2132103643);
                    LoginAnimationState success = Intrinsics.areEqual(state, AssetsMergeViewModel.MergeState.Success.INSTANCE) ? new LoginAnimationState.Success(null) : LoginAnimationState.Loading.INSTANCE;
                    startRestartGroup.startReplaceGroup(2009445208);
                    boolean changedInstance = ((i8 & 14) == 4) | startRestartGroup.changedInstance(coroutineScope) | ((458752 & i8) == 131072);
                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue4 == companion3.getEmpty()) {
                        rememberedValue4 = new Function0() { // from class: O3.g
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit AssetsMergeContent$lambda$14$lambda$13$lambda$12$lambda$11;
                                AssetsMergeContent$lambda$14$lambda$13$lambda$12$lambda$11 = AssetsMergeScreenKt.AssetsMergeContent$lambda$14$lambda$13$lambda$12$lambda$11(AssetsMergeViewModel.MergeState.this, coroutineScope, dismissForSuccess);
                                return AssetsMergeContent$lambda$14$lambda$13$lambda$12$lambda$11;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    startRestartGroup.endReplaceGroup();
                    LoginAnimationMode loginAnimationMode2 = loginAnimationMode;
                    companion2 = companion;
                    i7 = i8;
                    composer2 = startRestartGroup;
                    LoginAnimationViewKt.LoginAnimationView(loginAnimationMode2, success, (Function0) rememberedValue4, startRestartGroup, 0, 0);
                    composer2.endReplaceGroup();
                    composer2.endNode();
                    composer2.startReplaceGroup(67038608);
                    if (!Intrinsics.areEqual(state, AssetsMergeViewModel.MergeState.Loading.INSTANCE) && !Intrinsics.areEqual(state, AssetsMergeViewModel.MergeState.Success.INSTANCE)) {
                        NavigationButtonKt.NavigationButton(NavigationButtonType.Close, boxScopeInstance.align(companion2, companion5.getTopEnd()), cancelMerge, composer2, ((i7 >> 6) & 896) | 6, 0);
                    }
                    composer2.endReplaceGroup();
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            companion2 = companion;
            i7 = i8;
            composer2 = startRestartGroup;
            composer2.endNode();
            composer2.startReplaceGroup(67038608);
            if (!Intrinsics.areEqual(state, AssetsMergeViewModel.MergeState.Loading.INSTANCE)) {
                NavigationButtonKt.NavigationButton(NavigationButtonType.Close, boxScopeInstance.align(companion2, companion5.getTopEnd()), cancelMerge, composer2, ((i7 >> 6) & 896) | 6, 0);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: O3.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AssetsMergeContent$lambda$15;
                    AssetsMergeContent$lambda$15 = AssetsMergeScreenKt.AssetsMergeContent$lambda$15(AssetsMergeViewModel.MergeState.this, flowType, retryAction, handleMerge, cancelMerge, dismissForSuccess, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AssetsMergeContent$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssetsMergeContent$lambda$14$lambda$13$lambda$10$lambda$9(Function1 function1) {
        function1.invoke(AssetsMergeMethod.Merge);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssetsMergeContent$lambda$14$lambda$13$lambda$12$lambda$11(AssetsMergeViewModel.MergeState mergeState, CoroutineScope coroutineScope, Function0 function0) {
        if (Intrinsics.areEqual(mergeState, AssetsMergeViewModel.MergeState.Success.INSTANCE)) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AssetsMergeScreenKt$AssetsMergeContent$1$1$4$1$1(function0, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssetsMergeContent$lambda$14$lambda$13$lambda$8$lambda$7(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssetsMergeContent$lambda$15(AssetsMergeViewModel.MergeState mergeState, AssetsMergeFlowType assetsMergeFlowType, Function0 function0, Function1 function1, Function0 function02, Function0 function03, int i5, Composer composer, int i6) {
        AssetsMergeContent(mergeState, assetsMergeFlowType, function0, function1, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void AssetsMergeScreen(final AssetsMergeViewModel viewModel, final AssetsMergeFlowType flowType, final Function1<? super Continuation<? super ManagerResult<? extends LoginResult>>, ? extends Object> action, final Function2<? super ManagerResult.Error, ? super Continuation<? super ManagerResult.Error>, ? extends Object> failure, final Function0<Unit> dismissForSuccess, final Function0<Unit> onCancelMerge, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(flowType, "flowType");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(failure, "failure");
        Intrinsics.checkNotNullParameter(dismissForSuccess, "dismissForSuccess");
        Intrinsics.checkNotNullParameter(onCancelMerge, "onCancelMerge");
        Composer startRestartGroup = composer.startRestartGroup(-1799825161);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(flowType) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(action) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(failure) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(dismissForSuccess) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(onCancelMerge) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1799825161, i6, -1, "dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeScreen (AssetsMergeScreen.kt:57)");
            }
            AssetsMergeViewModel.ViewState viewState = (AssetsMergeViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            Boolean bool = Boolean.TRUE;
            startRestartGroup.startReplaceGroup(-935476075);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changedInstance(action) | startRestartGroup.changedInstance(failure);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new AssetsMergeScreenKt$AssetsMergeScreen$1$1(viewModel, action, failure, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(bool, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 6);
            AssetsMergeViewModel.MergeState state = viewState.getState();
            startRestartGroup.startReplaceGroup(-935469913);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changedInstance(action) | startRestartGroup.changedInstance(failure);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: O3.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AssetsMergeScreen$lambda$2$lambda$1;
                        AssetsMergeScreen$lambda$2$lambda$1 = AssetsMergeScreenKt.AssetsMergeScreen$lambda$2$lambda$1(AssetsMergeViewModel.this, action, failure);
                        return AssetsMergeScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-935467951);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new AssetsMergeScreenKt$AssetsMergeScreen$3$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function1 function1 = (Function1) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-935466627);
            boolean changedInstance4 = startRestartGroup.changedInstance(viewModel) | ((i6 & 458752) == 131072);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: O3.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AssetsMergeScreen$lambda$5$lambda$4;
                        AssetsMergeScreen$lambda$5$lambda$4 = AssetsMergeScreenKt.AssetsMergeScreen$lambda$5$lambda$4(AssetsMergeViewModel.this, onCancelMerge);
                        return AssetsMergeScreen$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            AssetsMergeContent(state, flowType, function0, function1, (Function0) rememberedValue4, dismissForSuccess, startRestartGroup, (i6 & 112) | ((i6 << 3) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: O3.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AssetsMergeScreen$lambda$6;
                    AssetsMergeScreen$lambda$6 = AssetsMergeScreenKt.AssetsMergeScreen$lambda$6(AssetsMergeViewModel.this, flowType, action, failure, dismissForSuccess, onCancelMerge, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AssetsMergeScreen$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssetsMergeScreen$lambda$2$lambda$1(AssetsMergeViewModel assetsMergeViewModel, Function1 function1, Function2 function2) {
        assetsMergeViewModel.perform(function1, function2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssetsMergeScreen$lambda$5$lambda$4(AssetsMergeViewModel assetsMergeViewModel, Function0 function0) {
        assetsMergeViewModel.cancelMerge(function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssetsMergeScreen$lambda$6(AssetsMergeViewModel assetsMergeViewModel, AssetsMergeFlowType assetsMergeFlowType, Function1 function1, Function2 function2, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        AssetsMergeScreen(assetsMergeViewModel, assetsMergeFlowType, function1, function2, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void ErrorView(final ColumnScope columnScope, final ManagerResult.Error error, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        String str;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(90630436);
        if ((i5 & 48) == 0) {
            i6 = (startRestartGroup.changedInstance(error) ? 32 : 16) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i7 = i6;
        if ((i7 & 145) == 144 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(90630436, i7, -1, "dk.molslinjen.ui.views.screens.profile.merge.ErrorView (AssetsMergeScreen.kt:153)");
            }
            Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            String errorMessage = ManagerResultKt.errorMessage(error, context);
            if (errorMessage == null) {
                String string = context.getString(R.string.error_general);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                str = string;
            } else {
                str = errorMessage;
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.error, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), null, null, null, 0.0f, null, startRestartGroup, 0, 124);
            Modifier.Companion companion = Modifier.INSTANCE;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(24)), startRestartGroup, 6);
            TextKt.m940Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getH3(), startRestartGroup, 0, 1572864, 65022);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(32)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            SecondaryButtonKt.m3406SecondaryButtonbZJ32A(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.common_tryAgain, startRestartGroup, 6), function0, null, false, null, false, null, null, 0L, false, startRestartGroup, (i7 & 896) | 6, 0, 2040);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: O3.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ErrorView$lambda$16;
                    ErrorView$lambda$16 = AssetsMergeScreenKt.ErrorView$lambda$16(ColumnScope.this, error, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ErrorView$lambda$16;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorView$lambda$16(ColumnScope columnScope, ManagerResult.Error error, Function0 function0, int i5, Composer composer, int i6) {
        ErrorView(columnScope, error, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MergeView(final Function1<? super AssetsMergeMethod, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-476389943);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function1) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-476389943, i6, -1, "dk.molslinjen.ui.views.screens.profile.merge.MergeView (AssetsMergeScreen.kt:177)");
            }
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            String stringResource = StringResources_androidKt.stringResource(R.string.merge_title, startRestartGroup, 6);
            TextStyle paragraphBold = TypographyKt.getParagraphBold();
            TextAlign.Companion companion3 = TextAlign.INSTANCE;
            TextKt.m940Text4IGK_g(stringResource, null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraphBold, startRestartGroup, 0, 1572864, 65022);
            float f5 = 16;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            String stringResource2 = StringResources_androidKt.stringResource(R.string.merge_description, startRestartGroup, 6);
            TextStyle paragraph = TypographyKt.getParagraph();
            TextAlign m2521boximpl = TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk());
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(stringResource2, null, 0L, 0L, null, null, null, 0L, null, m2521boximpl, 0L, 0, false, 0, 0, null, paragraph, composer2, 0, 1572864, 65022);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(24)), composer2, 6);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            String stringResource3 = StringResources_androidKt.stringResource(R.string.merge_button_confirm, composer2, 6);
            composer2.startReplaceGroup(295711428);
            int i7 = i6 & 14;
            boolean z5 = i7 == 4;
            Object rememberedValue = composer2.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: O3.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MergeView$lambda$21$lambda$18$lambda$17;
                        MergeView$lambda$21$lambda$18$lambda$17 = AssetsMergeScreenKt.MergeView$lambda$21$lambda$18$lambda$17(Function1.this);
                        return MergeView$lambda$21$lambda$18$lambda$17;
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
            }
            composer2.endReplaceGroup();
            PrimaryButtonKt.PrimaryButton(fillMaxWidth$default, stringResource3, (Function0) rememberedValue, null, null, false, false, false, composer2, 6, 248);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer2, 6);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            String stringResource4 = StringResources_androidKt.stringResource(R.string.merge_button_deny, composer2, 6);
            composer2.startReplaceGroup(295719878);
            boolean z6 = i7 == 4;
            Object rememberedValue2 = composer2.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: O3.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MergeView$lambda$21$lambda$20$lambda$19;
                        MergeView$lambda$21$lambda$20$lambda$19 = AssetsMergeScreenKt.MergeView$lambda$21$lambda$20$lambda$19(Function1.this);
                        return MergeView$lambda$21$lambda$20$lambda$19;
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer2.endReplaceGroup();
            SecondaryButtonKt.m3406SecondaryButtonbZJ32A(fillMaxWidth$default2, stringResource4, (Function0) rememberedValue2, null, false, null, false, null, null, 0L, false, composer2, 6, 0, 2040);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: O3.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MergeView$lambda$22;
                    MergeView$lambda$22 = AssetsMergeScreenKt.MergeView$lambda$22(Function1.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MergeView$lambda$22;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MergeView$lambda$21$lambda$18$lambda$17(Function1 function1) {
        function1.invoke(AssetsMergeMethod.Merge);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MergeView$lambda$21$lambda$20$lambda$19(Function1 function1) {
        function1.invoke(AssetsMergeMethod.Discard);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MergeView$lambda$22(Function1 function1, int i5, Composer composer, int i6) {
        MergeView(function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
