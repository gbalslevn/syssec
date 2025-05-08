package dk.molslinjen.ui.views.screens.profile.authentication.password.forgot;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardOptions;
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
import androidx.compose.ui.autofill.AutofillType;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.reusable.dialog.TextDialogKt;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.EmailInputValidator;
import dk.molslinjen.ui.views.reusable.model.UIUploadState;
import dk.molslinjen.ui.views.screens.profile.authentication.password.forgot.ForgotPasswordScreenKt;
import dk.molslinjen.ui.views.screens.profile.authentication.password.forgot.ForgotPasswordViewModel;
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
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001aU\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\fH\u0003¢\u0006\u0004\b\u0011\u0010\u0012\u001a;\u0010\u0016\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\fH\u0003¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/password/forgot/ForgotPasswordViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", BuildConfig.FLAVOR, "resultNavigator", BuildConfig.FLAVOR, "ForgotPasswordScreen", "(Ldk/molslinjen/ui/views/screens/profile/authentication/password/forgot/ForgotPasswordViewModel;Lcom/ramcosta/composedestinations/result/ResultBackNavigator;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "email", "Ldk/molslinjen/ui/views/reusable/model/UIUploadState;", "uploadState", "Lkotlin/Function1;", "onEmailChange", "Lkotlin/Function0;", "onSubmit", "onDismiss", "ForgotPasswordContent", "(Ljava/lang/String;Ldk/molslinjen/ui/views/reusable/model/UIUploadState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "isLoading", "ForgotPasswordInput", "(Ljava/lang/String;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ForgotPasswordScreenKt {
    private static final void ForgotPasswordContent(final String str, final UIUploadState uIUploadState, final Function1<? super String, Unit> function1, final Function0<Unit> function0, final Function1<? super Boolean, Unit> function12, Composer composer, final int i5) {
        int i6;
        int i7;
        int i8;
        final boolean z5;
        Composer startRestartGroup = composer.startRestartGroup(-893754874);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(uIUploadState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 16384 : 8192;
        }
        int i9 = i6;
        if ((i9 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-893754874, i9, -1, "dk.molslinjen.ui.views.screens.profile.authentication.password.forgot.ForgotPasswordContent (ForgotPasswordScreen.kt:64)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.startReplaceGroup(2097556396);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new FormValidator(MapsKt.mapOf(TuplesKt.to(ForgotPasswordFormField.Email, EmailInputValidator.INSTANCE)), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final FormValidator formValidator = (FormValidator) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(2097561676);
            if (uIUploadState == UIUploadState.Success) {
                String stringResource = StringResources_androidKt.stringResource(R.string.forgotPassword_successDialog_title, startRestartGroup, 6);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.forgotPassword_successDialog_description, startRestartGroup, 6);
                String stringResource3 = StringResources_androidKt.stringResource(R.string.button_ok, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(2097574634);
                boolean z6 = (i9 & 57344) == 16384;
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z6 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: A3.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit ForgotPasswordContent$lambda$7$lambda$6;
                            ForgotPasswordContent$lambda$7$lambda$6 = ForgotPasswordScreenKt.ForgotPasswordContent$lambda$7$lambda$6(Function1.this);
                            return ForgotPasswordContent$lambda$7$lambda$6;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                SimpleButtonData simpleButtonData = new SimpleButtonData(stringResource3, false, false, (Function0) rememberedValue3, 6, null);
                startRestartGroup.startReplaceGroup(2097570137);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: A3.d
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                i7 = i9;
                TextDialogKt.TextDialog(stringResource, stringResource2, simpleButtonData, null, null, false, (Function0) rememberedValue4, startRestartGroup, 1572864, 56);
            } else {
                i7 = i9;
            }
            startRestartGroup.endReplaceGroup();
            if (uIUploadState == UIUploadState.Loading) {
                i8 = 0;
                z5 = true;
            } else {
                i8 = 0;
                z5 = false;
            }
            final ScrollState rememberScrollState = ScrollKt.rememberScrollState(i8, startRestartGroup, i8, 1);
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(ModifierExtensionsKt.closeKeyboardOnClickOutside(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager())), Dp.m2599constructorimpl(24), 0.0f, 2, null);
            String stringResource4 = StringResources_androidKt.stringResource(R.string.forgotPassword, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(2097588447);
            if ((i7 & 57344) == 16384) {
                i8 = 1;
            }
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (i8 != 0 || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: A3.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ForgotPasswordContent$lambda$11$lambda$10;
                        ForgotPasswordContent$lambda$11$lambda$10 = ForgotPasswordScreenKt.ForgotPasswordContent$lambda$11$lambda$10(Function1.this);
                        return ForgotPasswordContent$lambda$11$lambda$10;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(m313paddingVpY3zN4$default, 0.0f, stringResource4, null, 0L, null, (Function0) rememberedValue5, null, ComposableLambdaKt.rememberComposableLambda(-599662652, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.password.forgot.ForgotPasswordScreenKt$ForgotPasswordContent$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
                
                    if (((java.lang.Boolean) androidx.compose.runtime.SnapshotStateKt.collectAsState(r2.isFormValid(), null, r14, 0, 1).getValue()).booleanValue() != false) goto L17;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke(Composer composer2, int i10) {
                    boolean z7;
                    if ((i10 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-599662652, i10, -1, "dk.molslinjen.ui.views.screens.profile.authentication.password.forgot.ForgotPasswordContent.<anonymous> (ForgotPasswordScreen.kt:98)");
                    }
                    String stringResource5 = StringResources_androidKt.stringResource(R.string.button_resetPassword, composer2, 6);
                    composer2.startReplaceGroup(2096098864);
                    if (!z5) {
                        z7 = true;
                    }
                    z7 = false;
                    composer2.endReplaceGroup();
                    FormValidator formValidator2 = formValidator;
                    composer2.startReplaceGroup(2096101840);
                    boolean changedInstance = composer2.changedInstance(formValidator2);
                    Object rememberedValue6 = composer2.rememberedValue();
                    if (changedInstance || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue6 = new ForgotPasswordScreenKt$ForgotPasswordContent$4$1$1(formValidator2);
                        composer2.updateRememberedValue(rememberedValue6);
                    }
                    composer2.endReplaceGroup();
                    BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource5, null, z7, z5, false, 0L, (Function0) ((KFunction) rememberedValue6), function0, composer2, 0, 50);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(313238675, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.password.forgot.ForgotPasswordScreenKt$ForgotPasswordContent$5
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                    invoke(columnScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetContainer, Composer composer2, int i10) {
                    Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                    if ((i10 & 17) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(313238675, i10, -1, "dk.molslinjen.ui.views.screens.profile.authentication.password.forgot.ForgotPasswordContent.<anonymous> (ForgotPasswordScreen.kt:107)");
                    }
                    Modifier verticalScroll$default = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollState.this, false, null, false, 14, null);
                    String str2 = str;
                    FormValidator formValidator2 = formValidator;
                    boolean z7 = z5;
                    Function1<String, Unit> function13 = function1;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, verticalScroll$default);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
                    Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ForgotPasswordScreenKt.ForgotPasswordInput(str2, formValidator2, z7, function13, composer2, 0);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 905969664, 186);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: A3.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ForgotPasswordContent$lambda$12;
                    ForgotPasswordContent$lambda$12 = ForgotPasswordScreenKt.ForgotPasswordContent$lambda$12(str, uIUploadState, function1, function0, function12, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ForgotPasswordContent$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ForgotPasswordContent$lambda$11$lambda$10(Function1 function1) {
        function1.invoke(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ForgotPasswordContent$lambda$12(String str, UIUploadState uIUploadState, Function1 function1, Function0 function0, Function1 function12, int i5, Composer composer, int i6) {
        ForgotPasswordContent(str, uIUploadState, function1, function0, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ForgotPasswordContent$lambda$7$lambda$6(Function1 function1) {
        function1.invoke(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ForgotPasswordInput(final String str, final IFormValidator iFormValidator, final boolean z5, final Function1<? super String, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1289291229);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= (i5 & 64) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1289291229, i6, -1, "dk.molslinjen.ui.views.screens.profile.authentication.password.forgot.ForgotPasswordInput (ForgotPasswordScreen.kt:127)");
            }
            FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.forgotPassword_description, startRestartGroup, 6), null, AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 384, 1572864, 65530);
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null);
            boolean z6 = !z5;
            ForgotPasswordFormField forgotPasswordFormField = ForgotPasswordFormField.Email;
            startRestartGroup.startReplaceGroup(1184438144);
            boolean changedInstance = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new ForgotPasswordScreenKt$ForgotPasswordInput$1$1(focusManager);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(m315paddingqDBjuR0$default, false, 0.0f, CollectionsKt.listOf((Object[]) new AutofillType[]{AutofillType.EmailAddress, AutofillType.Username}), Integer.valueOf(R.string.textField_label_inputEmail), null, null, function1, (Function0) rememberedValue, str, false, null, z6, false, 0, forgotPasswordFormField, iFormValidator, new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m2416getEmailPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (DefaultConstructorMarker) null), null, null, 0L, null, false, 0, composer2, ((i6 << 12) & 29360128) | 27654 | ((i6 << 27) & 1879048192), ((i6 << 15) & 3670016) | 12779520, 0, 16542822);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: A3.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ForgotPasswordInput$lambda$14;
                    ForgotPasswordInput$lambda$14 = ForgotPasswordScreenKt.ForgotPasswordInput$lambda$14(str, iFormValidator, z5, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ForgotPasswordInput$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ForgotPasswordInput$lambda$14(String str, IFormValidator iFormValidator, boolean z5, Function1 function1, int i5, Composer composer, int i6) {
        ForgotPasswordInput(str, iFormValidator, z5, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void ForgotPasswordScreen(final ForgotPasswordViewModel viewModel, final ResultBackNavigator<Boolean> resultNavigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(resultNavigator, "resultNavigator");
        Composer startRestartGroup = composer.startRestartGroup(1019051297);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(resultNavigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1019051297, i6, -1, "dk.molslinjen.ui.views.screens.profile.authentication.password.forgot.ForgotPasswordScreen (ForgotPasswordScreen.kt:43)");
            }
            ForgotPasswordViewModel.ViewState viewState = (ForgotPasswordViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            String email = viewState.getEmail();
            UIUploadState uploadState = viewState.getUploadState();
            startRestartGroup.startReplaceGroup(1470376900);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new ForgotPasswordScreenKt$ForgotPasswordScreen$1$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue);
            startRestartGroup.startReplaceGroup(1470378285);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new ForgotPasswordScreenKt$ForgotPasswordScreen$2$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Function0 function0 = (Function0) ((KFunction) rememberedValue2);
            startRestartGroup.startReplaceGroup(1470380022);
            boolean z5 = (i6 & 112) == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: A3.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ForgotPasswordScreen$lambda$3$lambda$2;
                        ForgotPasswordScreen$lambda$3$lambda$2 = ForgotPasswordScreenKt.ForgotPasswordScreen$lambda$3$lambda$2(ResultBackNavigator.this, ((Boolean) obj).booleanValue());
                        return ForgotPasswordScreen$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            ForgotPasswordContent(email, uploadState, function1, function0, (Function1) rememberedValue3, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: A3.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ForgotPasswordScreen$lambda$4;
                    ForgotPasswordScreen$lambda$4 = ForgotPasswordScreenKt.ForgotPasswordScreen$lambda$4(ForgotPasswordViewModel.this, resultNavigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ForgotPasswordScreen$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ForgotPasswordScreen$lambda$3$lambda$2(ResultBackNavigator resultBackNavigator, boolean z5) {
        resultBackNavigator.navigateBack(Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ForgotPasswordScreen$lambda$4(ForgotPasswordViewModel forgotPasswordViewModel, ResultBackNavigator resultBackNavigator, int i5, Composer composer, int i6) {
        ForgotPasswordScreen(forgotPasswordViewModel, resultBackNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
