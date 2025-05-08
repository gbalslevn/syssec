package dk.molslinjen.ui.views.screens.profile.authentication.register;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.profile.authentication.register.SignupNameInputKt;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoNameInputKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001ac\u0010\f\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "firstNameValidationKey", "lastNameValidationKey", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", BuildConfig.FLAVOR, "firstName", "lastName", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onFirstNameChange", "onLastNameChange", "SignupNameInput", "(Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SignupNameInputKt {
    public static final void SignupNameInput(final IFormValidator.ValidationKey firstNameValidationKey, final IFormValidator.ValidationKey lastNameValidationKey, final IFormValidator validator, final String str, final String str2, final Function1<? super String, Unit> onFirstNameChange, final Function1<? super String, Unit> onLastNameChange, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(firstNameValidationKey, "firstNameValidationKey");
        Intrinsics.checkNotNullParameter(lastNameValidationKey, "lastNameValidationKey");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(onFirstNameChange, "onFirstNameChange");
        Intrinsics.checkNotNullParameter(onLastNameChange, "onLastNameChange");
        Composer startRestartGroup = composer.startRestartGroup(-1814974050);
        if ((i5 & 6) == 0) {
            i6 = ((i5 & 8) == 0 ? startRestartGroup.changed(firstNameValidationKey) : startRestartGroup.changedInstance(firstNameValidationKey) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= (i5 & 64) == 0 ? startRestartGroup.changed(lastNameValidationKey) : startRestartGroup.changedInstance(lastNameValidationKey) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= (i5 & 512) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(str) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(str2) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(onFirstNameChange) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(onLastNameChange) ? 1048576 : 524288;
        }
        if ((599187 & i6) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1814974050, i6, -1, "dk.molslinjen.ui.views.screens.profile.authentication.register.SignupNameInput (SignupNameInput.kt:28)");
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
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.signup_nameScreen_title, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH2Bold(), startRestartGroup, 0, 1572864, 65534);
            float f5 = 32;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            int m2383getDoneeUduSuo = ImeAction.INSTANCE.m2383getDoneeUduSuo();
            startRestartGroup.startReplaceGroup(2100604512);
            boolean changedInstance = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: C3.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SignupNameInput$lambda$2$lambda$1$lambda$0;
                        SignupNameInput$lambda$2$lambda$1$lambda$0 = SignupNameInputKt.SignupNameInput$lambda$2$lambda$1$lambda$0(FocusManager.this);
                        return SignupNameInput$lambda$2$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            UserInfoNameInputKt.m3517UserInfoNameInputdAaJhyQ(firstNameValidationKey, lastNameValidationKey, validator, str, str2, onFirstNameChange, onLastNameChange, m2383getDoneeUduSuo, (Function0) rememberedValue, false, startRestartGroup, (i6 & 14) | 12582912 | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (i6 & 3670016), 512);
            composer2 = startRestartGroup;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer2, 6);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: C3.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SignupNameInput$lambda$3;
                    SignupNameInput$lambda$3 = SignupNameInputKt.SignupNameInput$lambda$3(IFormValidator.ValidationKey.this, lastNameValidationKey, validator, str, str2, onFirstNameChange, onLastNameChange, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SignupNameInput$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignupNameInput$lambda$2$lambda$1$lambda$0(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignupNameInput$lambda$3(IFormValidator.ValidationKey validationKey, IFormValidator.ValidationKey validationKey2, IFormValidator iFormValidator, String str, String str2, Function1 function1, Function1 function12, int i5, Composer composer, int i6) {
        SignupNameInput(validationKey, validationKey2, iFormValidator, str, str2, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
