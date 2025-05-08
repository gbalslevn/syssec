package dk.molslinjen.ui.views.screens.profile.authentication.login;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavBackStackEntry;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.LoginResult;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.buttons.NavigationButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.NavigationButtonType;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.profile.authentication.login.LoginScreenKt;
import dk.molslinjen.ui.views.screens.profile.authentication.login.LoginViewModel;
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
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001aÑ\u0001\u0010 \u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\"\u0010\u0017\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00160\r2$\u0010\u001a\u001a \b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u001f\u001a\u00020\u001eH\u0003¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", BuildConfig.FLAVOR, "LoginScreen", "(Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/navigation/NavBackStackEntry;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel$ViewState;", "viewState", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "Lkotlin/Function1;", BuildConfig.FLAVOR, "updateEmail", "updatePassword", "Lkotlin/Function0;", "triggerLogin", "Lkotlin/coroutines/Continuation;", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/managers/user/LoginResult;", BuildConfig.FLAVOR, "loginAction", "Lkotlin/Function2;", "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "onFailure", "navigateToForgotPassword", "onDismiss", "onCancelMerge", "Landroidx/compose/foundation/ScrollState;", "scrollState", "LoginContent", "(Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel$ViewState;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LoginScreenKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginViewModel.LoginState.values().length];
            try {
                iArr[LoginViewModel.LoginState.Action.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoginViewModel.LoginState.Idle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoginContent(final LoginViewModel.ViewState viewState, final IFormValidator iFormValidator, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final Function0<Unit> function0, final Function1<? super Continuation<? super ManagerResult<? extends LoginResult>>, ? extends Object> function13, final Function2<? super ManagerResult.Error, ? super Continuation<? super ManagerResult.Error>, ? extends Object> function2, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, final ScrollState scrollState, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1651054932);
        if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(viewState) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= (i5 & 64) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function13) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function02) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function03) ? 67108864 : 33554432;
        }
        if ((805306368 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function04) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i8 = i6 | (startRestartGroup.changed(scrollState) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((i7 & 306783379) == 306783378 && (i8 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1651054932, i7, i8, "dk.molslinjen.ui.views.screens.profile.authentication.login.LoginContent (LoginScreen.kt:117)");
            }
            FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            int i9 = WhenMappings.$EnumSwitchMapping$0[viewState.getUploadState().ordinal()];
            if (i9 == 1) {
                int i10 = i7;
                startRestartGroup.startReplaceGroup(-1450115764);
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
                int i11 = i10 >> 9;
                int i12 = i10 >> 12;
                AssetsMergeScreenKt.AssetsMergeScreen((AssetsMergeViewModel) viewModel, AssetsMergeFlowType.Login, function13, function2, function03, function04, startRestartGroup, (i11 & 7168) | (i11 & 896) | 48 | (57344 & i12) | (i12 & 458752));
                startRestartGroup.endReplaceGroup();
            } else {
                if (i9 != 2) {
                    startRestartGroup.startReplaceGroup(-1450117068);
                    startRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                startRestartGroup.startReplaceGroup(-2003571932);
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier verticalScroll$default = ScrollKt.verticalScroll$default(ModifierExtensionsKt.closeKeyboardOnClickOutside(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), focusManager), scrollState, false, null, false, 14, null);
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, verticalScroll$default);
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
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                LoginContentKt.LoginInputContent(null, viewState.getEmail(), viewState.getPassword(), iFormValidator, function1, function12, function0, function02, startRestartGroup, ((i7 << 6) & 4193280) | (29360128 & i7), 1);
                NavigationButtonKt.NavigationButton(NavigationButtonType.Close, boxScopeInstance.align(companion, companion2.getTopEnd()), function03, startRestartGroup, ((i7 >> 18) & 896) | 6, 0);
                startRestartGroup.endNode();
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: y3.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoginContent$lambda$4;
                    LoginContent$lambda$4 = LoginScreenKt.LoginContent$lambda$4(LoginViewModel.ViewState.this, iFormValidator, function1, function12, function0, function13, function2, function02, function03, function04, scrollState, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return LoginContent$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginContent$lambda$4(LoginViewModel.ViewState viewState, IFormValidator iFormValidator, Function1 function1, Function1 function12, Function0 function0, Function1 function13, Function2 function2, Function0 function02, Function0 function03, Function0 function04, ScrollState scrollState, int i5, int i6, Composer composer, int i7) {
        LoginContent(viewState, iFormValidator, function1, function12, function0, function13, function2, function02, function03, function04, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }

    public static final void LoginScreen(final LoginViewModel viewModel, final DestinationsNavigator navigator, final NavBackStackEntry navBackStackEntry, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Composer startRestartGroup = composer.startRestartGroup(-1687547596);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navBackStackEntry) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1687547596, i6, -1, "dk.molslinjen.ui.views.screens.profile.authentication.login.LoginScreen (LoginScreen.kt:46)");
            }
            String route = navBackStackEntry.getDestination().getRoute();
            if (route != null) {
                viewModel.setTrackingScreenRoute(route);
            }
            LoginViewModel.ViewState viewState = (LoginViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(-168076595);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = viewModel.getFormValidator();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            FormValidator formValidator = (FormValidator) rememberedValue;
            startRestartGroup.endReplaceGroup();
            boolean z5 = viewState.getUploadState() == LoginViewModel.LoginState.Idle;
            boolean z6 = ((Boolean) SnapshotStateKt.collectAsState(formValidator.isFormValid(), null, startRestartGroup, 0, 1).getValue()).booleanValue() && viewState.getPassword().length() >= 8;
            ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, null, null, 0L, null, null, rememberScrollState, ComposableLambdaKt.rememberComposableLambda(-1252144714, true, new LoginScreenKt$LoginScreen$2(z5, viewModel, z6, formValidator), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1491054073, true, new LoginScreenKt$LoginScreen$3(viewModel, navigator, viewState, formValidator, rememberScrollState), startRestartGroup, 54), composer2, 905970054, 122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: y3.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoginScreen$lambda$2;
                    LoginScreen$lambda$2 = LoginScreenKt.LoginScreen$lambda$2(LoginViewModel.this, navigator, navBackStackEntry, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return LoginScreen$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginScreen$lambda$2(LoginViewModel loginViewModel, DestinationsNavigator destinationsNavigator, NavBackStackEntry navBackStackEntry, int i5, Composer composer, int i6) {
        LoginScreen(loginViewModel, destinationsNavigator, navBackStackEntry, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
