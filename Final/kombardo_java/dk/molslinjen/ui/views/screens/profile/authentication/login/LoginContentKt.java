package dk.molslinjen.ui.views.screens.profile.authentication.login;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AutofillType;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.profile.authentication.login.LoginContentKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aw\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {BuildConfig.FLAVOR, "description", "email", "password", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "Lkotlin/Function1;", BuildConfig.FLAVOR, "updateEmail", "updatePassword", "Lkotlin/Function0;", "triggerLogin", "navigateToForgotPassword", "LoginInputContent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LoginContentKt {
    /* JADX WARN: Removed duplicated region for block: B:85:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0507  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LoginInputContent(String str, final String email, final String password, final IFormValidator validator, final Function1<? super String, Unit> updateEmail, final Function1<? super String, Unit> updatePassword, final Function0<Unit> triggerLogin, final Function0<Unit> navigateToForgotPassword, Composer composer, final int i5, final int i6) {
        int i7;
        String str2;
        final IFormValidator iFormValidator;
        boolean z5;
        boolean z6;
        Object rememberedValue;
        Composer composer2;
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(updateEmail, "updateEmail");
        Intrinsics.checkNotNullParameter(updatePassword, "updatePassword");
        Intrinsics.checkNotNullParameter(triggerLogin, "triggerLogin");
        Intrinsics.checkNotNullParameter(navigateToForgotPassword, "navigateToForgotPassword");
        Composer startRestartGroup = composer.startRestartGroup(1900483007);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = i5 | (startRestartGroup.changed(str) ? 4 : 2);
        } else {
            i7 = i5;
        }
        if ((2 & i6) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(email) ? 32 : 16;
        }
        int i9 = i7;
        if ((4 & i6) != 0) {
            i9 |= 384;
        } else if ((i5 & 384) == 0) {
            i9 |= startRestartGroup.changed(password) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i9 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i9 |= (i5 & 4096) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 2048 : 1024;
        }
        if ((i6 & 16) != 0) {
            i9 |= 24576;
        } else if ((i5 & 24576) == 0) {
            i9 |= startRestartGroup.changedInstance(updateEmail) ? 16384 : 8192;
        }
        if ((i6 & 32) != 0) {
            i9 |= 196608;
        } else if ((i5 & 196608) == 0) {
            i9 |= startRestartGroup.changedInstance(updatePassword) ? 131072 : 65536;
        }
        if ((i6 & 64) != 0) {
            i9 |= 1572864;
        } else if ((i5 & 1572864) == 0) {
            i9 |= startRestartGroup.changedInstance(triggerLogin) ? 1048576 : 524288;
        }
        if ((128 & i6) != 0) {
            i9 |= 12582912;
        } else if ((i5 & 12582912) == 0) {
            i9 |= startRestartGroup.changedInstance(navigateToForgotPassword) ? 8388608 : 4194304;
        }
        if ((4793491 & i9) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            str2 = str;
            composer2 = startRestartGroup;
        } else {
            str2 = i8 != 0 ? null : str;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1900483007, i9, -1, "dk.molslinjen.ui.views.screens.profile.authentication.login.LoginInputContent (LoginContent.kt:45)");
            }
            final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier closeKeyboardOnClickOutside = ModifierExtensionsKt.closeKeyboardOnClickOutside(companion, focusManager);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getCenterHorizontally(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, closeKeyboardOnClickOutside);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_login, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), null, null, null, 0.0f, null, startRestartGroup, 0, 124);
            float f5 = 16;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.login_title, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH2Bold(), startRestartGroup, 48, 1572864, 65532);
            startRestartGroup.startReplaceGroup(-1427698905);
            if (str2 != null) {
                TextKt.m940Text4IGK_g(str2, PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 432, 1572864, 65016);
                Unit unit = Unit.INSTANCE;
            }
            startRestartGroup.endReplaceGroup();
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(32), 0.0f, 0.0f, 13, null);
            KeyboardType.Companion companion4 = KeyboardType.INSTANCE;
            int m2416getEmailPjHm6EE = companion4.m2416getEmailPjHm6EE();
            ImeAction.Companion companion5 = ImeAction.INSTANCE;
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, m2416getEmailPjHm6EE, companion5.m2385getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
            LoginFormField loginFormField = LoginFormField.Email;
            List listOf = CollectionsKt.listOf((Object[]) new AutofillType[]{AutofillType.EmailAddress, AutofillType.Username});
            Integer valueOf = Integer.valueOf(R.string.textField_label_email);
            startRestartGroup.startReplaceGroup(-1427684903);
            boolean z7 = (57344 & i9) == 16384;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: y3.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit LoginInputContent$lambda$9$lambda$2$lambda$1;
                        LoginInputContent$lambda$9$lambda$2$lambda$1 = LoginContentKt.LoginInputContent$lambda$9$lambda$2$lambda$1(Function1.this, (String) obj);
                        return LoginInputContent$lambda$9$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function1 function1 = (Function1) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1427678283);
            boolean changedInstance = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: y3.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit LoginInputContent$lambda$9$lambda$4$lambda$3;
                        LoginInputContent$lambda$9$lambda$4$lambda$3 = LoginContentKt.LoginInputContent$lambda$9$lambda$4$lambda$3(FocusManager.this);
                        return LoginInputContent$lambda$9$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            int i10 = (i9 << 9) & 3670016;
            int i11 = i9;
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(m315paddingqDBjuR0$default, false, 0.0f, listOf, valueOf, null, null, function1, (Function0) rememberedValue3, email, false, null, false, false, 0, loginFormField, validator, keyboardOptions, null, null, 0L, null, false, 0, startRestartGroup, ((i9 << 24) & 1879048192) | 27654, i10 | 12779520, 0, 16546918);
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
            KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, companion4.m2419getPasswordPjHm6EE(), companion5.m2383getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
            LoginFormField loginFormField2 = LoginFormField.Password;
            List listOf2 = CollectionsKt.listOf(AutofillType.Password);
            Integer valueOf2 = Integer.valueOf(R.string.textField_label_password);
            startRestartGroup.startReplaceGroup(-1427664804);
            boolean z8 = (458752 & i11) == 131072;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: y3.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit LoginInputContent$lambda$9$lambda$6$lambda$5;
                        LoginInputContent$lambda$9$lambda$6$lambda$5 = LoginContentKt.LoginInputContent$lambda$9$lambda$6$lambda$5(Function1.this, (String) obj);
                        return LoginInputContent$lambda$9$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function1 function12 = (Function1) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1427656613);
            boolean changedInstance2 = startRestartGroup.changedInstance(focusManager);
            if ((i11 & 7168) != 2048) {
                iFormValidator = validator;
                if ((i11 & 4096) == 0 || !startRestartGroup.changedInstance(iFormValidator)) {
                    z5 = false;
                    z6 = changedInstance2 | z5 | ((i11 & 3670016) == 1048576);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: y3.d
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit LoginInputContent$lambda$9$lambda$8$lambda$7;
                                LoginInputContent$lambda$9$lambda$8$lambda$7 = LoginContentKt.LoginInputContent$lambda$9$lambda$8$lambda$7(FocusManager.this, iFormValidator, triggerLogin);
                                return LoginInputContent$lambda$9$lambda$8$lambda$7;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceGroup();
                    StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(m315paddingqDBjuR0$default2, false, 0.0f, listOf2, valueOf2, null, null, function12, (Function0) rememberedValue, password, true, null, false, false, 0, loginFormField2, validator, keyboardOptions2, null, null, 0L, null, false, 0, startRestartGroup, ((i11 << 21) & 1879048192) | 27654, i10 | 12779526, 0, 16545894);
                    Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(PaddingKt.m315paddingqDBjuR0$default(columnScopeInstance.align(companion, companion2.getStart()), 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), false, null, null, navigateToForgotPassword, 7, null);
                    composer2 = startRestartGroup;
                    TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.forgotPassword, composer2, 6), m122clickableXHw0xAI$default, 0L, 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, 100663296, 1572864, 65276);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            } else {
                iFormValidator = validator;
            }
            z5 = true;
            z6 = changedInstance2 | z5 | ((i11 & 3670016) == 1048576);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z6) {
            }
            rememberedValue = new Function0() { // from class: y3.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit LoginInputContent$lambda$9$lambda$8$lambda$7;
                    LoginInputContent$lambda$9$lambda$8$lambda$7 = LoginContentKt.LoginInputContent$lambda$9$lambda$8$lambda$7(FocusManager.this, iFormValidator, triggerLogin);
                    return LoginInputContent$lambda$9$lambda$8$lambda$7;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(m315paddingqDBjuR0$default2, false, 0.0f, listOf2, valueOf2, null, null, function12, (Function0) rememberedValue, password, true, null, false, false, 0, loginFormField2, validator, keyboardOptions2, null, null, 0L, null, false, 0, startRestartGroup, ((i11 << 21) & 1879048192) | 27654, i10 | 12779526, 0, 16545894);
            Modifier m122clickableXHw0xAI$default2 = ClickableKt.m122clickableXHw0xAI$default(PaddingKt.m315paddingqDBjuR0$default(columnScopeInstance.align(companion, companion2.getStart()), 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), false, null, null, navigateToForgotPassword, 7, null);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.forgotPassword, composer2, 6), m122clickableXHw0xAI$default2, 0L, 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, 100663296, 1572864, 65276);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str3 = str2;
            endRestartGroup.updateScope(new Function2() { // from class: y3.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoginInputContent$lambda$10;
                    LoginInputContent$lambda$10 = LoginContentKt.LoginInputContent$lambda$10(str3, email, password, validator, updateEmail, updatePassword, triggerLogin, navigateToForgotPassword, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return LoginInputContent$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginInputContent$lambda$10(String str, String str2, String str3, IFormValidator iFormValidator, Function1 function1, Function1 function12, Function0 function0, Function0 function02, int i5, int i6, Composer composer, int i7) {
        LoginInputContent(str, str2, str3, iFormValidator, function1, function12, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginInputContent$lambda$9$lambda$2$lambda$1(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginInputContent$lambda$9$lambda$4$lambda$3(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1279getDowndhqQ8s());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginInputContent$lambda$9$lambda$6$lambda$5(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginInputContent$lambda$9$lambda$8$lambda$7(FocusManager focusManager, IFormValidator iFormValidator, Function0 function0) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1281getExitdhqQ8s());
        focusManager.clearFocus(true);
        iFormValidator.submitAllFields();
        if (iFormValidator.isFormValid().getValue().booleanValue()) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }
}
