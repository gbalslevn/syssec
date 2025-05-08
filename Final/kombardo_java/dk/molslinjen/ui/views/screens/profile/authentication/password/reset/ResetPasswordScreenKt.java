package dk.molslinjen.ui.views.screens.profile.authentication.password.reset;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.res.StringResources_androidKt;
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
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.PasswordInputValidator;
import dk.molslinjen.ui.views.screens.profile.authentication.password.create.CreatePasswordFormField;
import dk.molslinjen.ui.views.screens.profile.authentication.password.create.CreatePasswordViewKt;
import dk.molslinjen.ui.views.screens.profile.authentication.password.reset.ResetPasswordScreenKt;
import dk.molslinjen.ui.views.screens.profile.authentication.password.reset.ResetPasswordViewModel;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeFlowType;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeScreenKt;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a©\u0001\u0010\u001c\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u000b2$\u0010\u0018\u001a \b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0003¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "ResetPasswordScreen", "(Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "password", "Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ResetPasswordState;", "uploadState", "Lkotlin/Function1;", "onPasswordChange", "Landroidx/compose/foundation/ScrollState;", "scrollState", "Lkotlin/Function0;", "onDismiss", "Lkotlin/coroutines/Continuation;", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/managers/user/LoginResult;", BuildConfig.FLAVOR, "loginAction", "Lkotlin/Function2;", "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "onFailure", "onCancelMerge", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "ResetPasswordContent", "(Ljava/lang/String;Ldk/molslinjen/ui/views/screens/profile/authentication/password/reset/ResetPasswordViewModel$ResetPasswordState;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ResetPasswordScreenKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResetPasswordViewModel.ResetPasswordState.values().length];
            try {
                iArr[ResetPasswordViewModel.ResetPasswordState.Action.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResetPasswordViewModel.ResetPasswordState.Idle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ResetPasswordContent(final String str, final ResetPasswordViewModel.ResetPasswordState resetPasswordState, final Function1<? super String, Unit> function1, final ScrollState scrollState, final Function0<Unit> function0, final Function1<? super Continuation<? super ManagerResult<? extends LoginResult>>, ? extends Object> function12, final Function2<? super ManagerResult.Error, ? super Continuation<? super ManagerResult.Error>, ? extends Object> function2, final Function0<Unit> function02, final IFormValidator iFormValidator, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-63036790);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(resetPasswordState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(scrollState) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i6 |= (134217728 & i5) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 67108864 : 33554432;
        }
        int i7 = i6;
        if ((38347923 & i7) == 38347922 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-63036790, i7, -1, "dk.molslinjen.ui.views.screens.profile.authentication.password.reset.ResetPasswordContent (ResetPasswordScreen.kt:127)");
            }
            int i8 = WhenMappings.$EnumSwitchMapping$0[resetPasswordState.ordinal()];
            if (i8 == 1) {
                startRestartGroup.startReplaceGroup(1369627468);
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
                int i9 = i7 >> 9;
                AssetsMergeScreenKt.AssetsMergeScreen((AssetsMergeViewModel) viewModel, AssetsMergeFlowType.ResetPassword, function12, function2, function0, function02, startRestartGroup, (i9 & 7168) | (i9 & 896) | 48 | (i7 & 57344) | ((i7 >> 6) & 458752));
                startRestartGroup.endReplaceGroup();
            } else {
                if (i8 != 2) {
                    startRestartGroup.startReplaceGroup(1369626105);
                    startRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                startRestartGroup.startReplaceGroup(1369637693);
                Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(ScrollKt.verticalScroll$default(Modifier.INSTANCE, scrollState, false, null, false, 14, null), Dp.m2599constructorimpl(24), 0.0f, 2, null);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                CreatePasswordViewKt.CreatePasswordView(null, 0, CreatePasswordFormField.Password, iFormValidator, str, function1, false, startRestartGroup, ((i7 >> 15) & 7168) | 384 | ((i7 << 12) & 57344) | ((i7 << 9) & 458752), 67);
                startRestartGroup.endNode();
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: B3.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ResetPasswordContent$lambda$4;
                    ResetPasswordContent$lambda$4 = ResetPasswordScreenKt.ResetPasswordContent$lambda$4(str, resetPasswordState, function1, scrollState, function0, function12, function2, function02, iFormValidator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ResetPasswordContent$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResetPasswordContent$lambda$4(String str, ResetPasswordViewModel.ResetPasswordState resetPasswordState, Function1 function1, ScrollState scrollState, Function0 function0, Function1 function12, Function2 function2, Function0 function02, IFormValidator iFormValidator, int i5, Composer composer, int i6) {
        ResetPasswordContent(str, resetPasswordState, function1, scrollState, function0, function12, function2, function02, iFormValidator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void ResetPasswordScreen(final ResetPasswordViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Function0 function0;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(1868775566);
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
                ComposerKt.traceEventStart(1868775566, i6, -1, "dk.molslinjen.ui.views.screens.profile.authentication.password.reset.ResetPasswordScreen (ResetPasswordScreen.kt:50)");
            }
            final ResetPasswordViewModel.ViewState viewState = (ResetPasswordViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            final ResetPasswordViewModel.ResetPasswordState state = viewState.getState();
            final ResetPasswordViewModel.ViewState.AuthenticationState authenticationState = viewState.getAuthenticationState();
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.startReplaceGroup(-354209621);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new FormValidator(MapsKt.mapOf(TuplesKt.to(CreatePasswordFormField.Password, PasswordInputValidator.INSTANCE)), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final FormValidator formValidator = (FormValidator) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            final ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            ResetPasswordViewModel.ResetPasswordState resetPasswordState = ResetPasswordViewModel.ResetPasswordState.Idle;
            boolean z5 = state == resetPasswordState;
            startRestartGroup.startReplaceGroup(-354200585);
            String stringResource = state == resetPasswordState ? StringResources_androidKt.stringResource(R.string.resetPassword_title, startRestartGroup, 6) : null;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-354195011);
            if (state == resetPasswordState) {
                startRestartGroup.startReplaceGroup(-354193657);
                boolean z6 = (i6 & 112) == 32;
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z6 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new ResetPasswordScreenKt$ResetPasswordScreen$onCloseAction$1$1(navigator);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                function0 = (Function0) rememberedValue3;
            } else {
                function0 = null;
            }
            startRestartGroup.endReplaceGroup();
            Modifier closeKeyboardOnClickOutside = ModifierExtensionsKt.closeKeyboardOnClickOutside(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager()));
            startRestartGroup.startReplaceGroup(-354183522);
            ComposableLambda rememberComposableLambda = z5 ? ComposableLambdaKt.rememberComposableLambda(-399231087, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.password.reset.ResetPasswordScreenKt$ResetPasswordScreen$1
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
                        ComposerKt.traceEventStart(-399231087, i7, -1, "dk.molslinjen.ui.views.screens.profile.authentication.password.reset.ResetPasswordScreen.<anonymous> (ResetPasswordScreen.kt:83)");
                    }
                    String stringResource2 = StringResources_androidKt.stringResource(R.string.button_resetPassword, composer3, 6);
                    boolean booleanValue = ((Boolean) SnapshotStateKt.collectAsState(FormValidator.this.isFormValid(), null, composer3, 0, 1).getValue()).booleanValue();
                    FormValidator formValidator2 = FormValidator.this;
                    composer3.startReplaceGroup(-211812311);
                    boolean changedInstance = composer3.changedInstance(formValidator2);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new ResetPasswordScreenKt$ResetPasswordScreen$1$1$1(formValidator2);
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceGroup();
                    Function0 function02 = (Function0) ((KFunction) rememberedValue4);
                    ResetPasswordViewModel resetPasswordViewModel = viewModel;
                    composer3.startReplaceGroup(-211810450);
                    boolean changedInstance2 = composer3.changedInstance(resetPasswordViewModel);
                    Object rememberedValue5 = composer3.rememberedValue();
                    if (changedInstance2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new ResetPasswordScreenKt$ResetPasswordScreen$1$2$1(resetPasswordViewModel);
                        composer3.updateRememberedValue(rememberedValue5);
                    }
                    composer3.endReplaceGroup();
                    BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource2, null, booleanValue, false, false, 0L, function02, (Function0) ((KFunction) rememberedValue5), composer3, 0, 58);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54) : null;
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(closeKeyboardOnClickOutside, 0.0f, stringResource, null, 0L, null, function0, rememberScrollState, rememberComposableLambda, ComposableLambdaKt.rememberComposableLambda(597614427, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.password.reset.ResetPasswordScreenKt$ResetPasswordScreen$2
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
                        ComposerKt.traceEventStart(597614427, i7, -1, "dk.molslinjen.ui.views.screens.profile.authentication.password.reset.ResetPasswordScreen.<anonymous> (ResetPasswordScreen.kt:94)");
                    }
                    final ResetPasswordViewModel.ViewState.AuthenticationState authenticationState2 = ResetPasswordViewModel.ViewState.AuthenticationState.this;
                    boolean z7 = authenticationState2 == ResetPasswordViewModel.ViewState.AuthenticationState.Loading;
                    final ResetPasswordViewModel.ViewState viewState2 = viewState;
                    final ResetPasswordViewModel.ResetPasswordState resetPasswordState2 = state;
                    final ResetPasswordViewModel resetPasswordViewModel = viewModel;
                    final ScrollState scrollState = rememberScrollState;
                    final DestinationsNavigator destinationsNavigator = navigator;
                    final FormValidator formValidator2 = formValidator;
                    LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, z7, 0, false, null, ComposableLambdaKt.rememberComposableLambda(-1216346201, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.password.reset.ResetPasswordScreenKt$ResetPasswordScreen$2.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i8) {
                            if ((i8 & 3) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1216346201, i8, -1, "dk.molslinjen.ui.views.screens.profile.authentication.password.reset.ResetPasswordScreen.<anonymous>.<anonymous> (ResetPasswordScreen.kt:95)");
                            }
                            if (ResetPasswordViewModel.ViewState.AuthenticationState.this == ResetPasswordViewModel.ViewState.AuthenticationState.NotAuthenticated) {
                                composer4.startReplaceGroup(1410638006);
                                String password = viewState2.getPassword();
                                ResetPasswordViewModel.ResetPasswordState resetPasswordState3 = resetPasswordState2;
                                ResetPasswordViewModel resetPasswordViewModel2 = resetPasswordViewModel;
                                composer4.startReplaceGroup(322604231);
                                boolean changedInstance = composer4.changedInstance(resetPasswordViewModel2);
                                Object rememberedValue4 = composer4.rememberedValue();
                                if (changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = new ResetPasswordScreenKt$ResetPasswordScreen$2$1$1$1(resetPasswordViewModel2);
                                    composer4.updateRememberedValue(rememberedValue4);
                                }
                                composer4.endReplaceGroup();
                                Function1 function1 = (Function1) ((KFunction) rememberedValue4);
                                ScrollState scrollState2 = scrollState;
                                DestinationsNavigator destinationsNavigator2 = destinationsNavigator;
                                composer4.startReplaceGroup(322607621);
                                boolean changed = composer4.changed(destinationsNavigator2);
                                Object rememberedValue5 = composer4.rememberedValue();
                                if (changed || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue5 = new ResetPasswordScreenKt$ResetPasswordScreen$2$1$2$1(destinationsNavigator2);
                                    composer4.updateRememberedValue(rememberedValue5);
                                }
                                Function0 function02 = (Function0) rememberedValue5;
                                composer4.endReplaceGroup();
                                ResetPasswordViewModel resetPasswordViewModel3 = resetPasswordViewModel;
                                composer4.startReplaceGroup(322609516);
                                boolean changedInstance2 = composer4.changedInstance(resetPasswordViewModel3);
                                Object rememberedValue6 = composer4.rememberedValue();
                                if (changedInstance2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue6 = new ResetPasswordScreenKt$ResetPasswordScreen$2$1$3$1(resetPasswordViewModel3);
                                    composer4.updateRememberedValue(rememberedValue6);
                                }
                                composer4.endReplaceGroup();
                                Function1 function12 = (Function1) ((KFunction) rememberedValue6);
                                ResetPasswordViewModel resetPasswordViewModel4 = resetPasswordViewModel;
                                composer4.startReplaceGroup(322611565);
                                boolean changedInstance3 = composer4.changedInstance(resetPasswordViewModel4);
                                Object rememberedValue7 = composer4.rememberedValue();
                                if (changedInstance3 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue7 = new ResetPasswordScreenKt$ResetPasswordScreen$2$1$4$1(resetPasswordViewModel4);
                                    composer4.updateRememberedValue(rememberedValue7);
                                }
                                composer4.endReplaceGroup();
                                Function2 function2 = (Function2) ((KFunction) rememberedValue7);
                                ResetPasswordViewModel resetPasswordViewModel5 = resetPasswordViewModel;
                                composer4.startReplaceGroup(322613766);
                                boolean changedInstance4 = composer4.changedInstance(resetPasswordViewModel5);
                                Object rememberedValue8 = composer4.rememberedValue();
                                if (changedInstance4 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue8 = new ResetPasswordScreenKt$ResetPasswordScreen$2$1$5$1(resetPasswordViewModel5);
                                    composer4.updateRememberedValue(rememberedValue8);
                                }
                                composer4.endReplaceGroup();
                                ResetPasswordScreenKt.ResetPasswordContent(password, resetPasswordState3, function1, scrollState2, function02, function12, function2, (Function0) ((KFunction) rememberedValue8), formValidator2, composer4, 0);
                                composer4.endReplaceGroup();
                            } else {
                                composer4.startReplaceGroup(1411200873);
                                ((UriHandler) composer4.consume(CompositionLocalsKt.getLocalUriHandler())).openUri(viewState2.getOriginalUrl());
                                destinationsNavigator.popBackStack();
                                composer4.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54), composer3, 1572864, 59);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, 805306368, 58);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: B3.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ResetPasswordScreen$lambda$2;
                    ResetPasswordScreen$lambda$2 = ResetPasswordScreenKt.ResetPasswordScreen$lambda$2(ResetPasswordViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ResetPasswordScreen$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResetPasswordScreen$lambda$2(ResetPasswordViewModel resetPasswordViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        ResetPasswordScreen(resetPasswordViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
