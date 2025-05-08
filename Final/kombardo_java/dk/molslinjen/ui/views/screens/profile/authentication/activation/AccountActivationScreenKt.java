package dk.molslinjen.ui.views.screens.profile.authentication.activation;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.unit.Dp;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.LoginResult;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.profile.authentication.activation.AccountActivationScreenKt;
import dk.molslinjen.ui.views.screens.profile.authentication.activation.AccountActivationViewModel;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeFlowType;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeScreenKt;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aO\u0010\u0010\u001a\u00020\u00042\"\u0010\f\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0003¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/activation/AccountActivationViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "AccountActivationScreen", "(Ldk/molslinjen/ui/views/screens/profile/authentication/activation/AccountActivationViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/managers/user/LoginResult;", BuildConfig.FLAVOR, "activateAction", "Lkotlin/Function0;", "onCancelMerge", "onDismiss", "AccountActivationContent", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AccountActivationScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void AccountActivationContent(final Function1<? super Continuation<? super ManagerResult<? extends LoginResult>>, ? extends Object> function1, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1363505241);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function1) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        int i7 = i6;
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1363505241, i7, -1, "dk.molslinjen.ui.views.screens.profile.authentication.activation.AccountActivationContent (AccountActivationScreen.kt:61)");
            }
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(Modifier.INSTANCE, Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(32));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
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
            startRestartGroup.startReplaceableGroup(1890788296);
            ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1729797275);
            ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) AssetsMergeViewModel.class, current, (String) null, createHiltViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, startRestartGroup, 36936, 0);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            AssetsMergeViewModel assetsMergeViewModel = (AssetsMergeViewModel) viewModel;
            AssetsMergeFlowType assetsMergeFlowType = AssetsMergeFlowType.AccountActivation;
            startRestartGroup.startReplaceGroup(-2106732313);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new AccountActivationScreenKt$AccountActivationContent$1$1$1(null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function2 function2 = (Function2) rememberedValue;
            startRestartGroup.endReplaceGroup();
            int i8 = i7 << 6;
            AssetsMergeScreenKt.AssetsMergeScreen(assetsMergeViewModel, assetsMergeFlowType, function1, function2, function02, function0, startRestartGroup, (i8 & 57344) | (i8 & 896) | 48 | ((i7 << 12) & 458752));
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: x3.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AccountActivationContent$lambda$3;
                    AccountActivationContent$lambda$3 = AccountActivationScreenKt.AccountActivationContent$lambda$3(Function1.this, function0, function02, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AccountActivationContent$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountActivationContent$lambda$3(Function1 function1, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        AccountActivationContent(function1, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void AccountActivationScreen(final AccountActivationViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(624815229);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(624815229, i6, -1, "dk.molslinjen.ui.views.screens.profile.authentication.activation.AccountActivationScreen (AccountActivationScreen.kt:34)");
            }
            final AccountActivationViewModel.ViewState viewState = (AccountActivationViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1707634250, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.activation.AccountActivationScreenKt$AccountActivationScreen$1

                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* loaded from: classes2.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[AccountActivationViewModel.ViewState.AuthenticationState.values().length];
                        try {
                            iArr[AccountActivationViewModel.ViewState.AuthenticationState.NotAuthenticated.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[AccountActivationViewModel.ViewState.AuthenticationState.Authenticated.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[AccountActivationViewModel.ViewState.AuthenticationState.Loading.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i7) {
                    Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                    if ((i7 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1707634250, i7, -1, "dk.molslinjen.ui.views.screens.profile.authentication.activation.AccountActivationScreen.<anonymous> (AccountActivationScreen.kt:40)");
                    }
                    int i8 = WhenMappings.$EnumSwitchMapping$0[AccountActivationViewModel.ViewState.this.getAuthenticationState().ordinal()];
                    if (i8 == 1) {
                        composer3.startReplaceGroup(1552422185);
                        AccountActivationViewModel accountActivationViewModel = viewModel;
                        composer3.startReplaceGroup(-2028130142);
                        boolean changedInstance = composer3.changedInstance(accountActivationViewModel);
                        Object rememberedValue = composer3.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new AccountActivationScreenKt$AccountActivationScreen$1$1$1(accountActivationViewModel);
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        KFunction kFunction = (KFunction) rememberedValue;
                        composer3.endReplaceGroup();
                        DestinationsNavigator destinationsNavigator = navigator;
                        composer3.startReplaceGroup(-2028128167);
                        boolean changed = composer3.changed(destinationsNavigator);
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new AccountActivationScreenKt$AccountActivationScreen$1$2$1(destinationsNavigator);
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        Function0 function0 = (Function0) rememberedValue2;
                        composer3.endReplaceGroup();
                        DestinationsNavigator destinationsNavigator2 = navigator;
                        composer3.startReplaceGroup(-2028126343);
                        boolean changed2 = composer3.changed(destinationsNavigator2);
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = new AccountActivationScreenKt$AccountActivationScreen$1$3$1(destinationsNavigator2);
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        composer3.endReplaceGroup();
                        AccountActivationScreenKt.AccountActivationContent((Function1) kFunction, (Function0) rememberedValue3, function0, composer3, 0);
                        composer3.endReplaceGroup();
                    } else if (i8 == 2) {
                        composer3.startReplaceGroup(1552721397);
                        ((UriHandler) composer3.consume(CompositionLocalsKt.getLocalUriHandler())).openUri(AccountActivationViewModel.ViewState.this.getOriginalUrl());
                        navigator.popBackStack();
                        composer3.endReplaceGroup();
                    } else if (i8 == 3) {
                        composer3.startReplaceGroup(1552970048);
                        BoxKt.Box(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer3, 6);
                        composer3.endReplaceGroup();
                    } else {
                        composer3.startReplaceGroup(-2028135337);
                        composer3.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(null, 0.0f, null, null, 0L, null, null, null, null, rememberComposableLambda, startRestartGroup, 805306752, 507);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: x3.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AccountActivationScreen$lambda$0;
                    AccountActivationScreen$lambda$0 = AccountActivationScreenKt.AccountActivationScreen$lambda$0(AccountActivationViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AccountActivationScreen$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountActivationScreen$lambda$0(AccountActivationViewModel accountActivationViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        AccountActivationScreen(accountActivationViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
