package dk.molslinjen.ui.views.screens.profile.authentication.register;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.config.SiteSupportInfo;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.profile.authentication.password.create.CreatePasswordViewKt;
import dk.molslinjen.ui.views.screens.profile.authentication.register.SignupPasswordAndTermsInputKt;
import dk.molslinjen.ui.views.shared.TermsAndLicenseCheckboxKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ai\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {BuildConfig.FLAVOR, "password", "Ldk/molslinjen/domain/model/config/SiteSupportInfo;", "supportInfo", BuildConfig.FLAVOR, "termsAndLicenseAccepted", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onPasswordChange", "onTermsAndLicenseAcceptChange", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "Ldk/molslinjen/ui/views/screens/profile/authentication/register/UserInfoFormField;", "passwordValidationKey", "termsAndLicenseAcceptValidationKey", "SignupPasswordAndTermsInput", "(Ljava/lang/String;Ldk/molslinjen/domain/model/config/SiteSupportInfo;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Ldk/molslinjen/ui/views/screens/profile/authentication/register/UserInfoFormField;Ldk/molslinjen/ui/views/screens/profile/authentication/register/UserInfoFormField;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SignupPasswordAndTermsInputKt {
    public static final void SignupPasswordAndTermsInput(final String password, final SiteSupportInfo siteSupportInfo, final boolean z5, final Function1<? super String, Unit> onPasswordChange, final Function1<? super Boolean, Unit> onTermsAndLicenseAcceptChange, final IFormValidator validator, final UserInfoFormField passwordValidationKey, final UserInfoFormField termsAndLicenseAcceptValidationKey, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(onPasswordChange, "onPasswordChange");
        Intrinsics.checkNotNullParameter(onTermsAndLicenseAcceptChange, "onTermsAndLicenseAcceptChange");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(passwordValidationKey, "passwordValidationKey");
        Intrinsics.checkNotNullParameter(termsAndLicenseAcceptValidationKey, "termsAndLicenseAcceptValidationKey");
        Composer startRestartGroup = composer.startRestartGroup(-1571001961);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(password) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(siteSupportInfo) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(onPasswordChange) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(onTermsAndLicenseAcceptChange) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= (262144 & i5) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changed(passwordValidationKey) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changed(termsAndLicenseAcceptValidationKey) ? 8388608 : 4194304;
        }
        int i7 = i6;
        if ((4793491 & i7) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1571001961, i7, -1, "dk.molslinjen.ui.views.screens.profile.authentication.register.SignupPasswordAndTermsInput (SignupPasswordAndTermsInput.kt:28)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(16), 7, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.signup_passwordScreen_title, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(32), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH2Bold(), startRestartGroup, 48, 1572864, 65532);
            int i8 = i7 << 6;
            composer2 = startRestartGroup;
            CreatePasswordViewKt.CreatePasswordView(null, 0, passwordValidationKey, validator, password, onPasswordChange, false, startRestartGroup, ((i7 >> 12) & 896) | ((i7 >> 6) & 7168) | (57344 & (i7 << 12)) | (i8 & 458752), 67);
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(31), 0.0f, 0.0f, 13, null);
            int i9 = i7 >> 3;
            TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox(m315paddingqDBjuR0$default2, z5, siteSupportInfo != null ? siteSupportInfo.getPrivacyPolicyPageUrl() : null, siteSupportInfo != null ? siteSupportInfo.getTermsAndConditionsPageUrl() : null, false, onTermsAndLicenseAcceptChange, termsAndLicenseAcceptValidationKey, validator, composer2, (i9 & 3670016) | (i9 & 112) | 6 | ((i7 << 3) & 458752) | (i8 & 29360128), 16);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: C3.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SignupPasswordAndTermsInput$lambda$1;
                    SignupPasswordAndTermsInput$lambda$1 = SignupPasswordAndTermsInputKt.SignupPasswordAndTermsInput$lambda$1(password, siteSupportInfo, z5, onPasswordChange, onTermsAndLicenseAcceptChange, validator, passwordValidationKey, termsAndLicenseAcceptValidationKey, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SignupPasswordAndTermsInput$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignupPasswordAndTermsInput$lambda$1(String str, SiteSupportInfo siteSupportInfo, boolean z5, Function1 function1, Function1 function12, IFormValidator iFormValidator, UserInfoFormField userInfoFormField, UserInfoFormField userInfoFormField2, int i5, Composer composer, int i6) {
        SignupPasswordAndTermsInput(str, siteSupportInfo, z5, function1, function12, iFormValidator, userInfoFormField, userInfoFormField2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
