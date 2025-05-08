package dk.molslinjen.ui.views.screens.profile.edit.changePassword;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AutofillType;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.PasswordInputValidator;
import dk.molslinjen.ui.views.screens.profile.authentication.password.create.CreatePasswordViewKt;
import dk.molslinjen.ui.views.screens.profile.authentication.register.UserInfoFormField;
import dk.molslinjen.ui.views.screens.profile.edit.changePassword.ChangePasswordScreenKt;
import dk.molslinjen.ui.views.screens.profile.edit.changePassword.ChangePasswordViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a[\u0010\u0012\u001a\u00020\u0004*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000fH\u0003¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/edit/changePassword/ChangePasswordViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "ChangePasswordScreen", "(Ldk/molslinjen/ui/views/screens/profile/edit/changePassword/ChangePasswordViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/layout/ColumnScope;", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "formValidator", BuildConfig.FLAVOR, "isLoading", BuildConfig.FLAVOR, "currentPasswordInput", "newPasswordInput", "Lkotlin/Function1;", "onCurrentPasswordChange", "onNewPasswordChange", "ChangePasswordContent", "(Landroidx/compose/foundation/layout/ColumnScope;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;ZLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ChangePasswordScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void ChangePasswordContent(final ColumnScope columnScope, final IFormValidator iFormValidator, final boolean z5, final String str, final String str2, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1931068259);
        if ((i5 & 48) == 0) {
            i6 = ((i5 & 64) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 32 : 16) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(str) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(str2) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 1048576 : 524288;
        }
        if ((599185 & i6) == 599184 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1931068259, i6, -1, "dk.molslinjen.ui.views.screens.profile.edit.changePassword.ChangePasswordContent (ChangePasswordScreen.kt:89)");
            }
            final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m2419getPasswordPjHm6EE(), ImeAction.INSTANCE.m2383getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
            boolean z6 = !z5;
            List listOf = CollectionsKt.listOf(AutofillType.Password);
            Integer valueOf = Integer.valueOf(R.string.changePassword_label_current);
            startRestartGroup.startReplaceGroup(-1776265752);
            boolean changedInstance = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: L3.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ChangePasswordContent$lambda$3$lambda$2;
                        ChangePasswordContent$lambda$3$lambda$2 = ChangePasswordScreenKt.ChangePasswordContent$lambda$3$lambda$2(FocusManager.this);
                        return ChangePasswordContent$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            int i7 = i6 << 6;
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, listOf, valueOf, null, null, function1, (Function0) rememberedValue, str, true, null, z6, false, 0, null, null, keyboardOptions, null, null, 0L, null, false, 0, startRestartGroup, (29360128 & i7) | 27648 | ((i6 << 18) & 1879048192), 12582918, 384, 12445799);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            CreatePasswordViewKt.CreatePasswordView(null, R.string.changePassword_label_new, UserInfoFormField.Password, iFormValidator, str2, function12, !z5, startRestartGroup, (i7 & 7168) | 432 | (57344 & i6) | ((i6 >> 3) & 458752), 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: L3.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ChangePasswordContent$lambda$4;
                    ChangePasswordContent$lambda$4 = ChangePasswordScreenKt.ChangePasswordContent$lambda$4(ColumnScope.this, iFormValidator, z5, str, str2, function1, function12, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ChangePasswordContent$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChangePasswordContent$lambda$3$lambda$2(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1283getNextdhqQ8s());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChangePasswordContent$lambda$4(ColumnScope columnScope, IFormValidator iFormValidator, boolean z5, String str, String str2, Function1 function1, Function1 function12, int i5, Composer composer, int i6) {
        ChangePasswordContent(columnScope, iFormValidator, z5, str, str2, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void ChangePasswordScreen(final ChangePasswordViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-322140646);
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
                ComposerKt.traceEventStart(-322140646, i6, -1, "dk.molslinjen.ui.views.screens.profile.edit.changePassword.ChangePasswordScreen (ChangePasswordScreen.kt:38)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            final FormValidator formValidator = new FormValidator(MapsKt.mapOf(TuplesKt.to(UserInfoFormField.Password, PasswordInputValidator.INSTANCE)), ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope());
            final ChangePasswordViewModel.ViewState viewState = (ChangePasswordViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            final boolean isLoading = viewState.getIsLoading();
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(ModifierExtensionsKt.closeKeyboardOnClickOutside(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager())), Dp.m2599constructorimpl(24), 0.0f, 2, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.changePassword_title, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-1979712329);
            boolean z5 = (i6 & 112) == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new ChangePasswordScreenKt$ChangePasswordScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-565666660, true, new ChangePasswordScreenKt$ChangePasswordScreen$2(formValidator, isLoading, viewModel, navigator), startRestartGroup, 54);
            ComposableLambda rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(850019309, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.edit.changePassword.ChangePasswordScreenKt$ChangePasswordScreen$3
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i7) {
                    Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                    if ((i7 & 6) == 0) {
                        i7 |= composer3.changed(BottomSheetContainer) ? 4 : 2;
                    }
                    if ((i7 & 19) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(850019309, i7, -1, "dk.molslinjen.ui.views.screens.profile.edit.changePassword.ChangePasswordScreen.<anonymous> (ChangePasswordScreen.kt:69)");
                    }
                    FormValidator formValidator2 = FormValidator.this;
                    boolean z6 = isLoading;
                    String currentPassword = viewState.getCurrentPassword();
                    String newPassword = viewState.getNewPassword();
                    ChangePasswordViewModel changePasswordViewModel = viewModel;
                    composer3.startReplaceGroup(-855206721);
                    boolean changedInstance = composer3.changedInstance(changePasswordViewModel);
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new ChangePasswordScreenKt$ChangePasswordScreen$3$1$1(changePasswordViewModel);
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceGroup();
                    Function1 function1 = (Function1) ((KFunction) rememberedValue3);
                    ChangePasswordViewModel changePasswordViewModel2 = viewModel;
                    composer3.startReplaceGroup(-855204549);
                    boolean changedInstance2 = composer3.changedInstance(changePasswordViewModel2);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changedInstance2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new ChangePasswordScreenKt$ChangePasswordScreen$3$2$1(changePasswordViewModel2);
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceGroup();
                    ChangePasswordScreenKt.ChangePasswordContent(BottomSheetContainer, formValidator2, z6, currentPassword, newPassword, function1, (Function1) ((KFunction) rememberedValue4), composer3, i7 & 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(m313paddingVpY3zN4$default, 0.0f, stringResource, null, 0L, null, (Function0) rememberedValue2, rememberScrollState, rememberComposableLambda, rememberComposableLambda2, startRestartGroup, 905969664, 58);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: L3.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ChangePasswordScreen$lambda$1;
                    ChangePasswordScreen$lambda$1 = ChangePasswordScreenKt.ChangePasswordScreen$lambda$1(ChangePasswordViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ChangePasswordScreen$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChangePasswordScreen$lambda$1(ChangePasswordViewModel changePasswordViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        ChangePasswordScreen(changePasswordViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
