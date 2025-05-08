package dk.molslinjen.ui.views.screens.profile.authentication.register;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PhoneNumberCodeSelectionScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.domain.managers.user.UserInfoInput;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetCustomDismissHandler;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetTitleStyle;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.EmailInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.NonEmptyNameValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.PasswordInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.PhoneNumberInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.RequiredBooleanCustomValidator;
import dk.molslinjen.ui.views.reusable.model.UIUploadState;
import dk.molslinjen.ui.views.screens.profile.authentication.LoginAnimationState;
import dk.molslinjen.ui.views.screens.profile.authentication.LoginAnimationViewKt;
import dk.molslinjen.ui.views.screens.profile.authentication.register.SignupScreenKt;
import dk.molslinjen.ui.views.screens.profile.authentication.register.SignupViewModel;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u001am\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a³\u0001\u0010.\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u001f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00140!2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020$0#2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00140!2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140\u001f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140\u001f2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fH\u0003¢\u0006\u0004\b.\u0010/\u001a\u0085\u0001\u00102\u001a\u00020\u0014*\u0002002\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020$0#2\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020(2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00140!2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140\u001f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140\u001f2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fH\u0003¢\u0006\u0004\b2\u00103\u001a#\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020$0#2\u0006\u00104\u001a\u00020\u0019H\u0002¢\u0006\u0004\b5\u00106\u001a\u0017\u00107\u001a\u00020$2\u0006\u00104\u001a\u00020\u0019H\u0002¢\u0006\u0004\b7\u00108\u001a\u0017\u00109\u001a\u00020$2\u0006\u00104\u001a\u00020\u0019H\u0002¢\u0006\u0004\b9\u00108\u001a\u0017\u0010:\u001a\u00020$2\u0006\u00104\u001a\u00020\u0019H\u0002¢\u0006\u0004\b:\u00108¨\u0006>²\u0006\f\u0010<\u001a\u00020;8\nX\u008a\u0084\u0002²\u0006\f\u0010=\u001a\u00020\u00128\nX\u008a\u0084\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/register/SignupViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Landroidx/navigation/NavController;", "navController", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetCustomDismissHandler;", "bottomSheetCustomDismissHandler", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/PhoneNumberCodeSelectionScreenDestination;", BuildConfig.FLAVOR, "phoneNumberCodeResultRecipient", "Lcom/ramcosta/composedestinations/generated/destinations/NationalitySelectionScreenDestination;", "Ljava/util/Locale;", "nationalityResultRecipient", "Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", BuildConfig.FLAVOR, "resultNavigator", BuildConfig.FLAVOR, "SignupScreen", "(Ldk/molslinjen/ui/views/screens/profile/authentication/register/SignupViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/navigation/NavController;Landroidx/navigation/NavBackStackEntry;Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetCustomDismissHandler;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lcom/ramcosta/composedestinations/result/ResultBackNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/ScrollState;", "scrollState", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Landroidx/compose/foundation/pager/PagerState;", "pagerState", "Ldk/molslinjen/ui/views/screens/profile/authentication/register/SignupScreenPage;", "currentPage", "Lkotlin/Function0;", "backAction", "Lkotlin/Function1;", "onDismiss", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validators", "Ldk/molslinjen/ui/views/screens/profile/authentication/register/SignupViewModel$ViewState;", "viewState", "Ldk/molslinjen/ui/views/screens/profile/shared/userInfo/IUserInfoInputHandler;", "userInfoInputHandler", "onTermsAndLicenseAcceptChange", "navigateToNationalitySelection", "navigateToPhoneNumberCodeSelection", "onSubmit", "SignupContainer", "(Landroidx/compose/foundation/ScrollState;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/pager/PagerState;Ldk/molslinjen/ui/views/screens/profile/authentication/register/SignupScreenPage;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/util/Map;Ldk/molslinjen/ui/views/screens/profile/authentication/register/SignupViewModel$ViewState;Ldk/molslinjen/ui/views/screens/profile/shared/userInfo/IUserInfoInputHandler;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "onFinishFlow", "SignupContent", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/foundation/ScrollState;Ljava/util/Map;Ldk/molslinjen/ui/views/screens/profile/authentication/register/SignupViewModel$ViewState;Landroidx/compose/foundation/pager/PagerState;Ldk/molslinjen/ui/views/screens/profile/shared/userInfo/IUserInfoInputHandler;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "scope", "getIndexMappedValidators", "(Lkotlinx/coroutines/CoroutineScope;)Ljava/util/Map;", "getNamesValidator", "(Lkotlinx/coroutines/CoroutineScope;)Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "getContactValidator", "getPasswordValidator", "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetCloseData;", "localBottomSheetCloseData", "isButtonEnabled", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SignupScreenKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UIUploadState.values().length];
            try {
                iArr[UIUploadState.Loading.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UIUploadState.Success.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UIUploadState.Idle.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SignupContainer(final ScrollState scrollState, final CoroutineScope coroutineScope, final PagerState pagerState, final SignupScreenPage signupScreenPage, final Function0<Unit> function0, final Function1<? super Boolean, Unit> function1, final Map<SignupScreenPage, ? extends IFormValidator> map, final SignupViewModel.ViewState viewState, final IUserInfoInputHandler iUserInfoInputHandler, final Function1<? super Boolean, Unit> function12, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Function0 function05;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-102759143);
        if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(scrollState) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(coroutineScope) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(pagerState) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changed(signupScreenPage) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((i5 & 196608) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i7 |= startRestartGroup.changedInstance(map) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i7 |= startRestartGroup.changedInstance(viewState) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i7 |= (i5 & 134217728) == 0 ? startRestartGroup.changed(iUserInfoInputHandler) : startRestartGroup.changedInstance(iUserInfoInputHandler) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i7 |= startRestartGroup.changedInstance(function12) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i8 = i6 | (startRestartGroup.changedInstance(function02) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(function03) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changedInstance(function04) ? 256 : 128;
        }
        int i9 = i8;
        if ((i7 & 306783379) == 306783378 && (i9 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-102759143, i7, i9, "dk.molslinjen.ui.views.screens.profile.authentication.register.SignupContainer (SignupScreen.kt:197)");
            }
            final boolean z5 = viewState.getUiUploadState() != UIUploadState.Idle;
            int pageCount = pagerState.getPageCount() - 1;
            String stringResource = StringResources_androidKt.stringResource(R.string.stepXofY, new Object[]{Integer.valueOf(signupScreenPage.getIndex() + 1), Integer.valueOf(pagerState.getPageCount())}, startRestartGroup, 6);
            boolean z6 = (signupScreenPage.isFirstPage() || z5) ? false : true;
            IFormValidator iFormValidator = map.get(signupScreenPage);
            StateFlow<Boolean> isFormValid = iFormValidator != null ? iFormValidator.isFormValid() : null;
            startRestartGroup.startReplaceGroup(2129130298);
            State collectAsState = isFormValid == null ? null : SnapshotStateKt.collectAsState(isFormValid, null, startRestartGroup, 0, 1);
            startRestartGroup.endReplaceGroup();
            final boolean booleanValue = collectAsState != null ? ((Boolean) collectAsState.getValue()).booleanValue() : true;
            startRestartGroup.startReplaceGroup(2129132338);
            boolean changed = startRestartGroup.changed(booleanValue);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: C3.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean SignupContainer$lambda$2$lambda$1;
                        SignupContainer$lambda$2$lambda$1 = SignupScreenKt.SignupContainer$lambda$2$lambda$1(booleanValue, z5);
                        return Boolean.valueOf(SignupContainer$lambda$2$lambda$1);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            State state = (State) rememberedValue;
            startRestartGroup.endReplaceGroup();
            FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            String str = z5 ? null : stringResource;
            BottomSheetTitleStyle bottomSheetTitleStyle = BottomSheetTitleStyle.Stepper;
            Function0<Unit> function06 = z6 ? function0 : null;
            startRestartGroup.startReplaceGroup(2129147279);
            if (z5) {
                function05 = null;
            } else {
                startRestartGroup.startReplaceGroup(2129148382);
                boolean z7 = (458752 & i7) == 131072;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z7 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: C3.l
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SignupContainer$lambda$5$lambda$4;
                            SignupContainer$lambda$5$lambda$4 = SignupScreenKt.SignupContainer$lambda$5$lambda$4(Function1.this);
                            return SignupContainer$lambda$5$lambda$4;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                function05 = (Function0) rememberedValue2;
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(fillMaxSize$default, 0.0f, str, bottomSheetTitleStyle, 0L, function06, function05, scrollState, ComposableLambdaKt.rememberComposableLambda(349995931, true, new SignupScreenKt$SignupContainer$2(z5, signupScreenPage, iFormValidator, focusManager, coroutineScope, scrollState, function04, pagerState, pageCount, state), composer2, 54), ComposableLambdaKt.rememberComposableLambda(-1188978964, true, new SignupScreenKt$SignupContainer$3(scrollState, map, viewState, pagerState, iUserInfoInputHandler, function12, function02, function03, function1), composer2, 54), composer2, ((i7 << 21) & 29360128) | 905972742, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: C3.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SignupContainer$lambda$6;
                    SignupContainer$lambda$6 = SignupScreenKt.SignupContainer$lambda$6(ScrollState.this, coroutineScope, pagerState, signupScreenPage, function0, function1, map, viewState, iUserInfoInputHandler, function12, function02, function03, function04, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return SignupContainer$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SignupContainer$lambda$2$lambda$1(boolean z5, boolean z6) {
        return z5 && !z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SignupContainer$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignupContainer$lambda$5$lambda$4(Function1 function1) {
        function1.invoke(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignupContainer$lambda$6(ScrollState scrollState, CoroutineScope coroutineScope, PagerState pagerState, SignupScreenPage signupScreenPage, Function0 function0, Function1 function1, Map map, SignupViewModel.ViewState viewState, IUserInfoInputHandler iUserInfoInputHandler, Function1 function12, Function0 function02, Function0 function03, Function0 function04, int i5, int i6, Composer composer, int i7) {
        SignupContainer(scrollState, coroutineScope, pagerState, signupScreenPage, function0, function1, map, viewState, iUserInfoInputHandler, function12, function02, function03, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SignupContent(final ColumnScope columnScope, final ScrollState scrollState, final Map<SignupScreenPage, ? extends IFormValidator> map, final SignupViewModel.ViewState viewState, final PagerState pagerState, final IUserInfoInputHandler iUserInfoInputHandler, final Function1<? super Boolean, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-182570387);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(columnScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(scrollState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(map) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(viewState) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(pagerState) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= (262144 & i5) == 0 ? startRestartGroup.changed(iUserInfoInputHandler) : startRestartGroup.changedInstance(iUserInfoInputHandler) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i6 |= startRestartGroup.changedInstance(function03) ? 536870912 : 268435456;
        }
        if ((i6 & 306783379) == 306783378 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-182570387, i6, -1, "dk.molslinjen.ui.views.screens.profile.authentication.register.SignupContent (SignupScreen.kt:287)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            UserInfoInput userInfoInput = (UserInfoInput) SnapshotStateKt.collectAsState(iUserInfoInputHandler.getUserInfoInput(), null, startRestartGroup, 0, 1).getValue();
            String firstName = userInfoInput.getFirstName();
            Object obj = BuildConfig.FLAVOR;
            if (firstName == null) {
                firstName = BuildConfig.FLAVOR;
            }
            String lastName = userInfoInput.getLastName();
            String str = lastName == null ? BuildConfig.FLAVOR : lastName;
            Character firstOrNull = StringsKt.firstOrNull(firstName);
            Object valueOf = firstOrNull != null ? Character.valueOf(Character.toUpperCase(firstOrNull.charValue())) : BuildConfig.FLAVOR;
            Character firstOrNull2 = StringsKt.firstOrNull(str);
            if (firstOrNull2 != null) {
                obj = Character.valueOf(Character.toUpperCase(firstOrNull2.charValue()));
            }
            StringBuilder sb = new StringBuilder();
            sb.append(valueOf);
            sb.append(obj);
            String sb2 = sb.toString();
            boolean z5 = viewState.getUiUploadState() == UIUploadState.Idle;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            int i7 = i6;
            Modifier weight$default = ColumnScope.weight$default(columnScope, companion2, 1.0f, false, 2, null);
            if (z5) {
                weight$default = ScrollKt.verticalScroll$default(weight$default, scrollState, false, null, false, 14, null);
            }
            LoginAnimationMode loginAnimationMode = LoginAnimationMode.SignUp;
            int i8 = WhenMappings.$EnumSwitchMapping$0[viewState.getUiUploadState().ordinal()];
            if (i8 == 1) {
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(761788291);
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, fillMaxSize$default);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                LoginAnimationViewKt.LoginAnimationView(loginAnimationMode, LoginAnimationState.Loading.INSTANCE, null, composer2, 54, 4);
                composer2.endNode();
                composer2.endReplaceGroup();
                Unit unit = Unit.INSTANCE;
            } else if (i8 == 2) {
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(761797838);
                Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, fillMaxSize$default2);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                LoginAnimationState.Success success = new LoginAnimationState.Success(sb2);
                composer2.startReplaceGroup(440180125);
                boolean changedInstance = composer2.changedInstance(coroutineScope) | ((i7 & 1879048192) == 536870912);
                Object rememberedValue2 = composer2.rememberedValue();
                if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: C3.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SignupContent$lambda$11$lambda$10$lambda$9;
                            SignupContent$lambda$11$lambda$10$lambda$9 = SignupScreenKt.SignupContent$lambda$11$lambda$10$lambda$9(CoroutineScope.this, function03);
                            return SignupContent$lambda$11$lambda$10$lambda$9;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                }
                composer2.endReplaceGroup();
                LoginAnimationViewKt.LoginAnimationView(loginAnimationMode, success, (Function0) rememberedValue2, composer2, 6, 0);
                composer2.endNode();
                composer2.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            } else {
                if (i8 != 3) {
                    startRestartGroup.startReplaceGroup(761790822);
                    startRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                startRestartGroup.startReplaceGroup(2141495668);
                composer2 = startRestartGroup;
                PagerKt.m438HorizontalPageroI3XNZo(pagerState, ModifierExtensionsKt.closeKeyboardOnClickOutside(weight$default, (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager())), PaddingKt.m308PaddingValuesYgX7TsA$default(Dp.m2599constructorimpl(24), 0.0f, 2, null), null, 0, Dp.m2599constructorimpl(48), Alignment.INSTANCE.getTop(), null, false, false, null, null, null, ComposableLambdaKt.rememberComposableLambda(419996751, true, new SignupScreenKt$SignupContent$3(map, iUserInfoInputHandler, firstName, str, userInfoInput, function0, pagerState, function02, viewState, function1), startRestartGroup, 54), composer2, ((i7 >> 12) & 14) | 102433152, 3072, 7832);
                composer2.endReplaceGroup();
                Unit unit3 = Unit.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: C3.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit SignupContent$lambda$12;
                    SignupContent$lambda$12 = SignupScreenKt.SignupContent$lambda$12(ColumnScope.this, scrollState, map, viewState, pagerState, iUserInfoInputHandler, function1, function0, function02, function03, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return SignupContent$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignupContent$lambda$11$lambda$10$lambda$9(CoroutineScope coroutineScope, Function0 function0) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SignupScreenKt$SignupContent$2$1$1$1(function0, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignupContent$lambda$12(ColumnScope columnScope, ScrollState scrollState, Map map, SignupViewModel.ViewState viewState, PagerState pagerState, IUserInfoInputHandler iUserInfoInputHandler, Function1 function1, Function0 function0, Function0 function02, Function0 function03, int i5, Composer composer, int i6) {
        SignupContent(columnScope, scrollState, map, viewState, pagerState, iUserInfoInputHandler, function1, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void SignupScreen(final SignupViewModel viewModel, final DestinationsNavigator navigator, final NavController navController, final NavBackStackEntry navBackStackEntry, final BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler, final ResultRecipient<PhoneNumberCodeSelectionScreenDestination, String> phoneNumberCodeResultRecipient, final ResultRecipient<NationalitySelectionScreenDestination, Locale> nationalityResultRecipient, final ResultBackNavigator<Boolean> resultNavigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(bottomSheetCustomDismissHandler, "bottomSheetCustomDismissHandler");
        Intrinsics.checkNotNullParameter(phoneNumberCodeResultRecipient, "phoneNumberCodeResultRecipient");
        Intrinsics.checkNotNullParameter(nationalityResultRecipient, "nationalityResultRecipient");
        Intrinsics.checkNotNullParameter(resultNavigator, "resultNavigator");
        Composer startRestartGroup = composer.startRestartGroup(-873254584);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navController) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(navBackStackEntry) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(bottomSheetCustomDismissHandler) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(phoneNumberCodeResultRecipient) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changed(nationalityResultRecipient) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changed(resultNavigator) ? 8388608 : 4194304;
        }
        int i7 = i6;
        if ((4793491 & i7) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-873254584, i7, -1, "dk.molslinjen.ui.views.screens.profile.authentication.register.SignupScreen (SignupScreen.kt:82)");
            }
            composer2 = startRestartGroup;
            bottomSheetCustomDismissHandler.SetupHandling(navBackStackEntry, navController, navigator, ComposableLambdaKt.rememberComposableLambda(-2046522789, true, new SignupScreenKt$SignupScreen$1(phoneNumberCodeResultRecipient, viewModel, nationalityResultRecipient, resultNavigator, bottomSheetCustomDismissHandler, navigator), composer2, 54), composer2, ((i7 >> 9) & 14) | 3072 | ((i7 >> 3) & 112) | ((i7 << 3) & 896) | (i7 & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: C3.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SignupScreen$lambda$0;
                    SignupScreen$lambda$0 = SignupScreenKt.SignupScreen$lambda$0(SignupViewModel.this, navigator, navController, navBackStackEntry, bottomSheetCustomDismissHandler, phoneNumberCodeResultRecipient, nationalityResultRecipient, resultNavigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SignupScreen$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignupScreen$lambda$0(SignupViewModel signupViewModel, DestinationsNavigator destinationsNavigator, NavController navController, NavBackStackEntry navBackStackEntry, BottomSheetCustomDismissHandler bottomSheetCustomDismissHandler, ResultRecipient resultRecipient, ResultRecipient resultRecipient2, ResultBackNavigator resultBackNavigator, int i5, Composer composer, int i6) {
        SignupScreen(signupViewModel, destinationsNavigator, navController, navBackStackEntry, bottomSheetCustomDismissHandler, resultRecipient, resultRecipient2, resultBackNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final IFormValidator getContactValidator(CoroutineScope coroutineScope) {
        return new FormValidator(MapsKt.mapOf(TuplesKt.to(UserInfoFormField.CountryCode, PhoneNumberInputValidator.CountryCode.INSTANCE), TuplesKt.to(UserInfoFormField.NationalNumber, PhoneNumberInputValidator.NationalNumber.INSTANCE), TuplesKt.to(UserInfoFormField.Email, EmailInputValidator.INSTANCE)), coroutineScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<SignupScreenPage, IFormValidator> getIndexMappedValidators(CoroutineScope coroutineScope) {
        return MapsKt.mapOf(TuplesKt.to(SignupScreenPage.Name, getNamesValidator(coroutineScope)), TuplesKt.to(SignupScreenPage.Contact, getContactValidator(coroutineScope)), TuplesKt.to(SignupScreenPage.PasswordAndTerms, getPasswordValidator(coroutineScope)));
    }

    private static final IFormValidator getNamesValidator(CoroutineScope coroutineScope) {
        UserInfoFormField userInfoFormField = UserInfoFormField.FirstName;
        NonEmptyNameValidator nonEmptyNameValidator = NonEmptyNameValidator.INSTANCE;
        return new FormValidator(MapsKt.mapOf(TuplesKt.to(userInfoFormField, nonEmptyNameValidator), TuplesKt.to(UserInfoFormField.LastName, nonEmptyNameValidator)), coroutineScope);
    }

    private static final IFormValidator getPasswordValidator(CoroutineScope coroutineScope) {
        return new FormValidator(MapsKt.mapOf(TuplesKt.to(UserInfoFormField.Password, PasswordInputValidator.INSTANCE), TuplesKt.to(UserInfoFormField.TermsAndLicense, RequiredBooleanCustomValidator.INSTANCE)), coroutineScope);
    }
}
