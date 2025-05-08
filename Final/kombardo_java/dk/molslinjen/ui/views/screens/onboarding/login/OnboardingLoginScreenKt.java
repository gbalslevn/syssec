package dk.molslinjen.ui.views.screens.onboarding.login;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.NavOptionsBuilderKt;
import androidx.navigation.PopUpToBuilder;
import com.ramcosta.composedestinations.generated.destinations.ForgotPasswordScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.OnboardingLoginScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SignupScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.user.LoginResult;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import dk.molslinjen.ui.views.reusable.clickableText.ClickableTextData;
import dk.molslinjen.ui.views.reusable.clickableText.ClickableTextKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.main.MainViewModel;
import dk.molslinjen.ui.views.screens.onboarding.login.OnboardingLoginScreenKt;
import dk.molslinjen.ui.views.screens.profile.authentication.login.LoginContentKt;
import dk.molslinjen.ui.views.screens.profile.authentication.login.LoginViewModel;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeFlowType;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeScreenKt;
import dk.molslinjen.ui.views.screens.profile.merge.AssetsMergeViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001aW\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0011\u0010\u0012\u001a×\u0001\u0010)\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e0\u00172\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e0\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b2\"\u0010!\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d\u0012\u0006\u0012\u0004\u0018\u00010 0\u00172$\u0010$\u001a \b\u0001\u0012\u0004\u0012\u00020#\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u001d\u0012\u0006\u0012\u0004\u0018\u00010 0\"2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bH\u0003¢\u0006\u0004\b)\u0010*\u001a\u007f\u0010,\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e0\u00172\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e0\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bH\u0003¢\u0006\u0004\b,\u0010-¨\u00060²\u0006\u000e\u0010.\u001a\u00020\n8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010/\u001a\u00020\n8\n@\nX\u008a\u008e\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel;", "viewModel", "Ldk/molslinjen/ui/views/screens/main/MainViewModel;", "mainViewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/ForgotPasswordScreenDestination;", BuildConfig.FLAVOR, "forgotPasswordResultRecipient", "Lcom/ramcosta/composedestinations/generated/destinations/SignupScreenDestination;", "signupResultRecipient", BuildConfig.FLAVOR, "OnboardingLoginScreen", "(Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel;Ldk/molslinjen/ui/views/screens/main/MainViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/navigation/NavBackStackEntry;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Landroidx/compose/runtime/Composer;I)V", "completeLoginOnboardingStep", "(Ldk/molslinjen/ui/views/screens/main/MainViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel$ViewState;", "viewState", "Lkotlin/Function1;", BuildConfig.FLAVOR, "updateEmail", "updatePassword", "Lkotlin/Function0;", "triggerLogin", "Lkotlin/coroutines/Continuation;", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/managers/user/LoginResult;", BuildConfig.FLAVOR, "loginAction", "Lkotlin/Function2;", "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "onFailure", "onSignUp", "onForgotPassword", "onContinue", "onCancelMerge", "LoginContent", "(Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel$ViewState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "navigateToForgotPassword", "InputContent", "(Ldk/molslinjen/ui/views/screens/profile/authentication/login/LoginViewModel$ViewState;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "signUpResult", "forgotPasswordResult", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class OnboardingLoginScreenKt {

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

    private static final void InputContent(final LoginViewModel.ViewState viewState, final IFormValidator iFormValidator, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-859556867);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= (i5 & 64) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i6 |= startRestartGroup.changedInstance(function03) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i6 |= startRestartGroup.changedInstance(function04) ? 8388608 : 4194304;
        }
        if ((i6 & 4793491) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-859556867, i6, -1, "dk.molslinjen.ui.views.screens.onboarding.login.InputContent (OnboardingLoginScreen.kt:177)");
            }
            ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            Modifier.Companion companion = Modifier.INSTANCE;
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier closeKeyboardOnClickOutside = ModifierExtensionsKt.closeKeyboardOnClickOutside(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), focusManager);
            float f5 = 24;
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m313paddingVpY3zN4$default(closeKeyboardOnClickOutside, Dp.m2599constructorimpl(f5), 0.0f, 2, null), rememberScrollState, false, null, false, 14, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getCenterHorizontally(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, verticalScroll$default);
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
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(64)), startRestartGroup, 6);
            int i7 = i6;
            LoginContentKt.LoginInputContent(StringResources_androidKt.stringResource(R.string.onboarding_login_description, startRestartGroup, 6), viewState.getEmail(), viewState.getPassword(), iFormValidator, function1, function12, function0, function03, startRestartGroup, ((i6 << 6) & 4193280) | ((i6 << 3) & 29360128), 0);
            float f6 = 32;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.login_cta, startRestartGroup, 6);
            ButtonConfig buttonConfig = ButtonConfig.Large;
            boolean booleanValue = ((Boolean) SnapshotStateKt.collectAsState(iFormValidator.isFormValid(), null, startRestartGroup, 0, 1).getValue()).booleanValue();
            startRestartGroup.startReplaceGroup(1201913987);
            boolean z5 = (i7 & 112) == 32 || ((i7 & 64) != 0 && startRestartGroup.changedInstance(iFormValidator));
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: s3.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit InputContent$lambda$32$lambda$31$lambda$30$lambda$29;
                        InputContent$lambda$32$lambda$31$lambda$30$lambda$29 = OnboardingLoginScreenKt.InputContent$lambda$32$lambda$31$lambda$30$lambda$29(IFormValidator.this);
                        return InputContent$lambda$32$lambda$31$lambda$30$lambda$29;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            PrimaryButtonKt.PrimaryButton(fillMaxWidth$default, stringResource, function0, (Function0) rememberedValue, buttonConfig, booleanValue, false, false, startRestartGroup, ((i7 >> 6) & 896) | 24582, 192);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            ClickableTextKt.m3408ClickableTextFHprtrg(null, StringResources_androidKt.stringResource(R.string.onboarding_login_createProfile_mainText, startRestartGroup, 6), CollectionsKt.listOf(new ClickableTextData(StringResources_androidKt.stringResource(R.string.onboarding_login_createProfile_clickableText, startRestartGroup, 6), function02, null, null, FontWeight.INSTANCE.getBold(), 12, null)), TypographyKt.getSub(), 0L, function02, startRestartGroup, (i7 & 458752) | 3072, 17);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, startRestartGroup, 0, 15);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            SecondaryButtonKt.m3406SecondaryButtonbZJ32A(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.onboarding_login_continueNoLogin, startRestartGroup, 6), function04, null, false, buttonConfig, false, null, null, 0L, false, startRestartGroup, ((i7 >> 15) & 896) | 196614, 0, 2008);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
            startRestartGroup.endNode();
            Modifier align = boxScopeInstance.align(companion, companion2.getBottomCenter());
            startRestartGroup.startReplaceGroup(-363155813);
            boolean z6 = rememberScrollState.getCanScrollForward() && !WindowInsets_androidKt.isImeVisible(WindowInsets.INSTANCE, startRestartGroup, 6);
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            AnimatedVisibilityKt.AnimatedVisibility(z6, align, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), null, ComposableSingletons$OnboardingLoginScreenKt.INSTANCE.m3502getLambda1$app_kombardoProd(), startRestartGroup, 200064, 16);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: s3.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit InputContent$lambda$33;
                    InputContent$lambda$33 = OnboardingLoginScreenKt.InputContent$lambda$33(LoginViewModel.ViewState.this, iFormValidator, function1, function12, function0, function02, function03, function04, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return InputContent$lambda$33;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputContent$lambda$32$lambda$31$lambda$30$lambda$29(IFormValidator iFormValidator) {
        iFormValidator.submitAllFields();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InputContent$lambda$33(LoginViewModel.ViewState viewState, IFormValidator iFormValidator, Function1 function1, Function1 function12, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i5, Composer composer, int i6) {
        InputContent(viewState, iFormValidator, function1, function12, function0, function02, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void LoginContent(final IFormValidator iFormValidator, final LoginViewModel.ViewState viewState, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final Function0<Unit> function0, final Function1<? super Continuation<? super ManagerResult<? extends LoginResult>>, ? extends Object> function13, final Function2<? super ManagerResult.Error, ? super Continuation<? super ManagerResult.Error>, ? extends Object> function2, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, final Function0<Unit> function05, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-2104234927);
        if ((i5 & 6) == 0) {
            i7 = ((i5 & 8) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(viewState) ? 32 : 16;
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
            i8 = i6 | (startRestartGroup.changedInstance(function05) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((i7 & 306783379) == 306783378 && (i8 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2104234927, i7, i8, "dk.molslinjen.ui.views.screens.onboarding.login.LoginContent (OnboardingLoginScreen.kt:142)");
            }
            int i9 = WhenMappings.$EnumSwitchMapping$0[viewState.getUploadState().ordinal()];
            if (i9 == 1) {
                startRestartGroup.startReplaceGroup(-2095957773);
                startRestartGroup.startReplaceableGroup(1890788296);
                ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(startRestartGroup, LocalViewModelStoreOwner.$stable);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(1729797275);
                int i10 = i7;
                ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) AssetsMergeViewModel.class, current, (String) null, createHiltViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, startRestartGroup, 36936, 0);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                int i11 = i10 >> 9;
                AssetsMergeScreenKt.AssetsMergeScreen((AssetsMergeViewModel) viewModel, AssetsMergeFlowType.Login, function13, function2, function04, function05, startRestartGroup, (i11 & 7168) | (i11 & 896) | 48 | ((i10 >> 15) & 57344) | ((i8 << 15) & 458752));
                startRestartGroup.endReplaceGroup();
            } else {
                if (i9 != 2) {
                    startRestartGroup.startReplaceGroup(-2095959704);
                    startRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                startRestartGroup.startReplaceGroup(-2095947589);
                int i12 = ((i7 >> 3) & 14) | ((i7 << 3) & 112) | (i7 & 896) | (i7 & 7168) | (i7 & 57344);
                int i13 = i7 >> 6;
                InputContent(viewState, iFormValidator, function1, function12, function0, function02, function03, function04, startRestartGroup, i12 | (i13 & 458752) | (3670016 & i13) | (i13 & 29360128));
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: s3.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoginContent$lambda$28;
                    LoginContent$lambda$28 = OnboardingLoginScreenKt.LoginContent$lambda$28(IFormValidator.this, viewState, function1, function12, function0, function13, function2, function02, function03, function04, function05, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return LoginContent$lambda$28;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginContent$lambda$28(IFormValidator iFormValidator, LoginViewModel.ViewState viewState, Function1 function1, Function1 function12, Function0 function0, Function1 function13, Function2 function2, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i5, int i6, Composer composer, int i7) {
        LoginContent(iFormValidator, viewState, function1, function12, function0, function13, function2, function02, function03, function04, function05, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }

    public static final void OnboardingLoginScreen(final LoginViewModel viewModel, final MainViewModel mainViewModel, final DestinationsNavigator navigator, final NavBackStackEntry navBackStackEntry, final ResultRecipient<ForgotPasswordScreenDestination, Boolean> forgotPasswordResultRecipient, final ResultRecipient<SignupScreenDestination, Boolean> signupResultRecipient, Composer composer, final int i5) {
        int i6;
        int i7;
        Boolean bool;
        Boolean bool2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(mainViewModel, "mainViewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(forgotPasswordResultRecipient, "forgotPasswordResultRecipient");
        Intrinsics.checkNotNullParameter(signupResultRecipient, "signupResultRecipient");
        Composer startRestartGroup = composer.startRestartGroup(557014291);
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
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(navBackStackEntry) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(forgotPasswordResultRecipient) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(signupResultRecipient) ? 131072 : 65536;
        }
        int i8 = i6;
        if ((74899 & i8) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(557014291, i8, -1, "dk.molslinjen.ui.views.screens.onboarding.login.OnboardingLoginScreen (OnboardingLoginScreen.kt:70)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.startReplaceGroup(1518387113);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1518389257);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1518391552);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: s3.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit OnboardingLoginScreen$lambda$7$lambda$6;
                        OnboardingLoginScreen$lambda$7$lambda$6 = OnboardingLoginScreenKt.OnboardingLoginScreen$lambda$7$lambda$6(MutableState.this, ((Boolean) obj).booleanValue());
                        return OnboardingLoginScreen$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(signupResultRecipient, null, (Function1) rememberedValue4, startRestartGroup, ((i8 >> 15) & 14) | 384, 1);
            startRestartGroup.startReplaceGroup(1518394792);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: s3.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit OnboardingLoginScreen$lambda$9$lambda$8;
                        OnboardingLoginScreen$lambda$9$lambda$8 = OnboardingLoginScreenKt.OnboardingLoginScreen$lambda$9$lambda$8(MutableState.this, ((Boolean) obj).booleanValue());
                        return OnboardingLoginScreen$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(forgotPasswordResultRecipient, null, (Function1) rememberedValue5, startRestartGroup, ((i8 >> 12) & 14) | 384, 1);
            Boolean valueOf = Boolean.valueOf(OnboardingLoginScreen$lambda$1(mutableState));
            Boolean valueOf2 = Boolean.valueOf(OnboardingLoginScreen$lambda$4(mutableState2));
            startRestartGroup.startReplaceGroup(1518399296);
            int i9 = i8 & 896;
            boolean changedInstance = startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(mainViewModel) | (i9 == 256);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue6 == companion.getEmpty()) {
                i7 = 0;
                bool = valueOf;
                bool2 = valueOf2;
                OnboardingLoginScreenKt$OnboardingLoginScreen$3$1 onboardingLoginScreenKt$OnboardingLoginScreen$3$1 = new OnboardingLoginScreenKt$OnboardingLoginScreen$3$1(coroutineScope, mutableState, mutableState2, mainViewModel, navigator, null);
                startRestartGroup.updateRememberedValue(onboardingLoginScreenKt$OnboardingLoginScreen$3$1);
                rememberedValue6 = onboardingLoginScreenKt$OnboardingLoginScreen$3$1;
            } else {
                i7 = 0;
                bool2 = valueOf2;
                bool = valueOf;
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(bool, bool2, (Function2) rememberedValue6, startRestartGroup, i7);
            String route = navBackStackEntry.getDestination().getRoute();
            if (route != null) {
                viewModel.setTrackingScreenRoute(route);
                Unit unit = Unit.INSTANCE;
            }
            LoginViewModel.ViewState viewState = (LoginViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, i7, 1).getValue();
            startRestartGroup.startReplaceGroup(1518412304);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = viewModel.getFormValidator();
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            FormValidator formValidator = (FormValidator) rememberedValue7;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1518416893);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = new OnboardingLoginScreenKt$OnboardingLoginScreen$5$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            KFunction kFunction = (KFunction) rememberedValue8;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1518418464);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue9 == companion.getEmpty()) {
                rememberedValue9 = new OnboardingLoginScreenKt$OnboardingLoginScreen$6$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            KFunction kFunction2 = (KFunction) rememberedValue9;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1518420062);
            boolean changedInstance4 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue10 == companion.getEmpty()) {
                rememberedValue10 = new OnboardingLoginScreenKt$OnboardingLoginScreen$7$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            KFunction kFunction3 = (KFunction) rememberedValue10;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1518421565);
            boolean changedInstance5 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue11 == companion.getEmpty()) {
                rememberedValue11 = new OnboardingLoginScreenKt$OnboardingLoginScreen$8$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            KFunction kFunction4 = (KFunction) rememberedValue11;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1518422974);
            boolean changedInstance6 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (changedInstance6 || rememberedValue12 == companion.getEmpty()) {
                rememberedValue12 = new OnboardingLoginScreenKt$OnboardingLoginScreen$9$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            KFunction kFunction5 = (KFunction) rememberedValue12;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1518436511);
            boolean changedInstance7 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (changedInstance7 || rememberedValue13 == companion.getEmpty()) {
                rememberedValue13 = new OnboardingLoginScreenKt$OnboardingLoginScreen$10$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            KFunction kFunction6 = (KFunction) rememberedValue13;
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) kFunction;
            Function1 function12 = (Function1) kFunction2;
            Function0 function0 = (Function0) kFunction3;
            Function1 function13 = (Function1) kFunction4;
            Function2 function2 = (Function2) kFunction5;
            startRestartGroup.startReplaceGroup(1518424426);
            int i10 = i9 == 256 ? 1 : i7;
            Object rememberedValue14 = startRestartGroup.rememberedValue();
            if (i10 != 0 || rememberedValue14 == companion.getEmpty()) {
                rememberedValue14 = new Function0() { // from class: s3.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OnboardingLoginScreen$lambda$20$lambda$19;
                        OnboardingLoginScreen$lambda$20$lambda$19 = OnboardingLoginScreenKt.OnboardingLoginScreen$lambda$20$lambda$19(DestinationsNavigator.this);
                        return OnboardingLoginScreen$lambda$20$lambda$19;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue14);
            }
            Function0 function02 = (Function0) rememberedValue14;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1518427506);
            int i11 = i9 == 256 ? 1 : i7;
            Object rememberedValue15 = startRestartGroup.rememberedValue();
            if (i11 != 0 || rememberedValue15 == companion.getEmpty()) {
                rememberedValue15 = new Function0() { // from class: s3.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OnboardingLoginScreen$lambda$22$lambda$21;
                        OnboardingLoginScreen$lambda$22$lambda$21 = OnboardingLoginScreenKt.OnboardingLoginScreen$lambda$22$lambda$21(DestinationsNavigator.this);
                        return OnboardingLoginScreen$lambda$22$lambda$21;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue15);
            }
            Function0 function03 = (Function0) rememberedValue15;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1518430726);
            int i12 = (startRestartGroup.changedInstance(coroutineScope) ? 1 : 0) | (startRestartGroup.changedInstance(mainViewModel) ? 1 : 0) | (i9 == 256 ? 1 : i7);
            Object rememberedValue16 = startRestartGroup.rememberedValue();
            if (i12 != 0 || rememberedValue16 == companion.getEmpty()) {
                rememberedValue16 = new Function0() { // from class: s3.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OnboardingLoginScreen$lambda$24$lambda$23;
                        OnboardingLoginScreen$lambda$24$lambda$23 = OnboardingLoginScreenKt.OnboardingLoginScreen$lambda$24$lambda$23(CoroutineScope.this, mainViewModel, navigator);
                        return OnboardingLoginScreen$lambda$24$lambda$23;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue16);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LoginContent(formValidator, viewState, function1, function12, function0, function13, function2, function02, function03, (Function0) rememberedValue16, (Function0) kFunction6, composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: s3.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OnboardingLoginScreen$lambda$25;
                    OnboardingLoginScreen$lambda$25 = OnboardingLoginScreenKt.OnboardingLoginScreen$lambda$25(LoginViewModel.this, mainViewModel, navigator, navBackStackEntry, forgotPasswordResultRecipient, signupResultRecipient, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return OnboardingLoginScreen$lambda$25;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean OnboardingLoginScreen$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void OnboardingLoginScreen$lambda$2(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLoginScreen$lambda$20$lambda$19(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, SignupScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLoginScreen$lambda$22$lambda$21(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ForgotPasswordScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLoginScreen$lambda$24$lambda$23(CoroutineScope coroutineScope, MainViewModel mainViewModel, DestinationsNavigator destinationsNavigator) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new OnboardingLoginScreenKt$OnboardingLoginScreen$13$1$1(mainViewModel, destinationsNavigator, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLoginScreen$lambda$25(LoginViewModel loginViewModel, MainViewModel mainViewModel, DestinationsNavigator destinationsNavigator, NavBackStackEntry navBackStackEntry, ResultRecipient resultRecipient, ResultRecipient resultRecipient2, int i5, Composer composer, int i6) {
        OnboardingLoginScreen(loginViewModel, mainViewModel, destinationsNavigator, navBackStackEntry, resultRecipient, resultRecipient2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean OnboardingLoginScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void OnboardingLoginScreen$lambda$5(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLoginScreen$lambda$7$lambda$6(MutableState mutableState, boolean z5) {
        OnboardingLoginScreen$lambda$2(mutableState, z5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLoginScreen$lambda$9$lambda$8(MutableState mutableState, boolean z5) {
        OnboardingLoginScreen$lambda$5(mutableState, z5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object completeLoginOnboardingStep(MainViewModel mainViewModel, DestinationsNavigator destinationsNavigator, Continuation<? super Unit> continuation) {
        OnboardingLoginScreenKt$completeLoginOnboardingStep$1 onboardingLoginScreenKt$completeLoginOnboardingStep$1;
        int i5;
        if (continuation instanceof OnboardingLoginScreenKt$completeLoginOnboardingStep$1) {
            onboardingLoginScreenKt$completeLoginOnboardingStep$1 = (OnboardingLoginScreenKt$completeLoginOnboardingStep$1) continuation;
            int i6 = onboardingLoginScreenKt$completeLoginOnboardingStep$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                onboardingLoginScreenKt$completeLoginOnboardingStep$1.label = i6 - Integer.MIN_VALUE;
                Object obj = onboardingLoginScreenKt$completeLoginOnboardingStep$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = onboardingLoginScreenKt$completeLoginOnboardingStep$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    SettingsProperty.Onboarding.OnboardingLoginCompleted onboardingLoginCompleted = SettingsProperty.Onboarding.OnboardingLoginCompleted.INSTANCE;
                    onboardingLoginScreenKt$completeLoginOnboardingStep$1.L$0 = mainViewModel;
                    onboardingLoginScreenKt$completeLoginOnboardingStep$1.L$1 = destinationsNavigator;
                    onboardingLoginScreenKt$completeLoginOnboardingStep$1.label = 1;
                    if (mainViewModel.setOnboardingStepCompleted(onboardingLoginCompleted, onboardingLoginScreenKt$completeLoginOnboardingStep$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    destinationsNavigator = (DestinationsNavigator) onboardingLoginScreenKt$completeLoginOnboardingStep$1.L$1;
                    mainViewModel = (MainViewModel) onboardingLoginScreenKt$completeLoginOnboardingStep$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, mainViewModel.getNextOnboardingStep(), NavOptionsBuilderKt.navOptions(new Function1() { // from class: s3.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit completeLoginOnboardingStep$lambda$27;
                        completeLoginOnboardingStep$lambda$27 = OnboardingLoginScreenKt.completeLoginOnboardingStep$lambda$27((NavOptionsBuilder) obj2);
                        return completeLoginOnboardingStep$lambda$27;
                    }
                }), null, 4, null);
                return Unit.INSTANCE;
            }
        }
        onboardingLoginScreenKt$completeLoginOnboardingStep$1 = new OnboardingLoginScreenKt$completeLoginOnboardingStep$1(continuation);
        Object obj2 = onboardingLoginScreenKt$completeLoginOnboardingStep$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = onboardingLoginScreenKt$completeLoginOnboardingStep$1.label;
        if (i5 != 0) {
        }
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, mainViewModel.getNextOnboardingStep(), NavOptionsBuilderKt.navOptions(new Function1() { // from class: s3.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj22) {
                Unit completeLoginOnboardingStep$lambda$27;
                completeLoginOnboardingStep$lambda$27 = OnboardingLoginScreenKt.completeLoginOnboardingStep$lambda$27((NavOptionsBuilder) obj22);
                return completeLoginOnboardingStep$lambda$27;
            }
        }), null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit completeLoginOnboardingStep$lambda$27(NavOptionsBuilder navOptions) {
        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
        navOptions.popUpTo(OnboardingLoginScreenDestination.INSTANCE.getRoute(), new Function1() { // from class: s3.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit completeLoginOnboardingStep$lambda$27$lambda$26;
                completeLoginOnboardingStep$lambda$27$lambda$26 = OnboardingLoginScreenKt.completeLoginOnboardingStep$lambda$27$lambda$26((PopUpToBuilder) obj);
                return completeLoginOnboardingStep$lambda$27$lambda$26;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit completeLoginOnboardingStep$lambda$27$lambda$26(PopUpToBuilder popUpTo) {
        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
        popUpTo.setInclusive(true);
        return Unit.INSTANCE;
    }
}
