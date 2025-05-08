package dk.molslinjen.ui.views.screens.profile.authentication.register;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.profile.authentication.register.SignupContactInfoInputKt;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoContactInputKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001au\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/domain/model/shared/PhoneNumber;", "phoneNumber", BuildConfig.FLAVOR, "email", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onPhoneNumberChange", "Lkotlin/Function0;", "showPhoneNumberCodeSelector", "onEmailChange", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "countryCodeValidationKey", "nationalNumberValidationKey", "emailValidationKey", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "SignupContactInfoInput", "(Ldk/molslinjen/domain/model/shared/PhoneNumber;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SignupContactInfoInputKt {
    public static final void SignupContactInfoInput(final PhoneNumber phoneNumber, final String email, final Function1<? super PhoneNumber, Unit> onPhoneNumberChange, final Function0<Unit> showPhoneNumberCodeSelector, final Function1<? super String, Unit> onEmailChange, final IFormValidator.ValidationKey countryCodeValidationKey, final IFormValidator.ValidationKey nationalNumberValidationKey, final IFormValidator.ValidationKey emailValidationKey, final IFormValidator validator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(onPhoneNumberChange, "onPhoneNumberChange");
        Intrinsics.checkNotNullParameter(showPhoneNumberCodeSelector, "showPhoneNumberCodeSelector");
        Intrinsics.checkNotNullParameter(onEmailChange, "onEmailChange");
        Intrinsics.checkNotNullParameter(countryCodeValidationKey, "countryCodeValidationKey");
        Intrinsics.checkNotNullParameter(nationalNumberValidationKey, "nationalNumberValidationKey");
        Intrinsics.checkNotNullParameter(emailValidationKey, "emailValidationKey");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Composer startRestartGroup = composer.startRestartGroup(1386920350);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(phoneNumber) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(email) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(onPhoneNumberChange) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(showPhoneNumberCodeSelector) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(onEmailChange) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= (262144 & i5) == 0 ? startRestartGroup.changed(countryCodeValidationKey) : startRestartGroup.changedInstance(countryCodeValidationKey) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= (2097152 & i5) == 0 ? startRestartGroup.changed(nationalNumberValidationKey) : startRestartGroup.changedInstance(nationalNumberValidationKey) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= (16777216 & i5) == 0 ? startRestartGroup.changed(emailValidationKey) : startRestartGroup.changedInstance(emailValidationKey) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i6 |= (134217728 & i5) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 67108864 : 33554432;
        }
        if ((38347923 & i6) == 38347922 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1386920350, i6, -1, "dk.molslinjen.ui.views.screens.profile.authentication.register.SignupContactInfoInput (SignupContactInfoInput.kt:31)");
            }
            final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
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
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.signup_contactScreen_title, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH2Bold(), startRestartGroup, 0, 1572864, 65534);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.signup_contactScreen_description, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 432, 1572864, 65528);
            float f5 = 32;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            int m2383getDoneeUduSuo = ImeAction.INSTANCE.m2383getDoneeUduSuo();
            startRestartGroup.startReplaceGroup(810548171);
            boolean changedInstance = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: C3.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SignupContactInfoInput$lambda$2$lambda$1$lambda$0;
                        SignupContactInfoInput$lambda$2$lambda$1$lambda$0 = SignupContactInfoInputKt.SignupContactInfoInput$lambda$2$lambda$1$lambda$0(FocusManager.this);
                        return SignupContactInfoInput$lambda$2$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            UserInfoContactInputKt.m3516UserInfoContactInputk7ZECbw(phoneNumber, email, onPhoneNumberChange, onEmailChange, showPhoneNumberCodeSelector, countryCodeValidationKey, nationalNumberValidationKey, emailValidationKey, validator, m2383getDoneeUduSuo, (Function0) rememberedValue, false, startRestartGroup, (i6 & 14) | 805306368 | (i6 & 112) | (i6 & 896) | ((i6 >> 3) & 7168) | (57344 & (i6 << 3)) | (458752 & i6) | (3670016 & i6) | (29360128 & i6) | (i6 & 234881024), 0, 2048);
            composer2 = startRestartGroup;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer2, 6);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: C3.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SignupContactInfoInput$lambda$3;
                    SignupContactInfoInput$lambda$3 = SignupContactInfoInputKt.SignupContactInfoInput$lambda$3(PhoneNumber.this, email, onPhoneNumberChange, showPhoneNumberCodeSelector, onEmailChange, countryCodeValidationKey, nationalNumberValidationKey, emailValidationKey, validator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SignupContactInfoInput$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignupContactInfoInput$lambda$2$lambda$1$lambda$0(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignupContactInfoInput$lambda$3(PhoneNumber phoneNumber, String str, Function1 function1, Function0 function0, Function1 function12, IFormValidator.ValidationKey validationKey, IFormValidator.ValidationKey validationKey2, IFormValidator.ValidationKey validationKey3, IFormValidator iFormValidator, int i5, Composer composer, int i6) {
        SignupContactInfoInput(phoneNumber, str, function1, function0, function12, validationKey, validationKey2, validationKey3, iFormValidator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
