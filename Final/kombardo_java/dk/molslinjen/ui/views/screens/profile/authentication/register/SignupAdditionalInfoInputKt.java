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
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.profile.authentication.register.SignupAdditionalInfoInputKt;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoAdditionalInputKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0099\u0001\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00002\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\n0\t2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {BuildConfig.FLAVOR, "firstName", "Ldk/molslinjen/domain/model/account/Gender;", "gender", "Lorg/threeten/bp/LocalDate;", "birthdate", "Ljava/util/Locale;", "nationality", "postalCode", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onGenderChange", "onBirthdateChange", "Lkotlin/Function0;", "clearNationality", "onPostalCodeChange", "navigateToNationalitySelection", "SignupAdditionalInfoInput", "(Ljava/lang/String;Ldk/molslinjen/domain/model/account/Gender;Lorg/threeten/bp/LocalDate;Ljava/util/Locale;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SignupAdditionalInfoInputKt {
    public static final void SignupAdditionalInfoInput(final String firstName, final Gender gender, final LocalDate localDate, final Locale locale, final String postalCode, final Function1<? super Gender, Unit> onGenderChange, final Function1<? super LocalDate, Unit> onBirthdateChange, final Function0<Unit> clearNationality, final Function1<? super String, Unit> onPostalCodeChange, final Function0<Unit> navigateToNationalitySelection, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        Intrinsics.checkNotNullParameter(postalCode, "postalCode");
        Intrinsics.checkNotNullParameter(onGenderChange, "onGenderChange");
        Intrinsics.checkNotNullParameter(onBirthdateChange, "onBirthdateChange");
        Intrinsics.checkNotNullParameter(clearNationality, "clearNationality");
        Intrinsics.checkNotNullParameter(onPostalCodeChange, "onPostalCodeChange");
        Intrinsics.checkNotNullParameter(navigateToNationalitySelection, "navigateToNationalitySelection");
        Composer startRestartGroup = composer.startRestartGroup(1232421332);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(firstName) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(gender) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(localDate) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(locale) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(postalCode) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(onGenderChange) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(onBirthdateChange) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(clearNationality) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(onPostalCodeChange) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToNationalitySelection) ? 536870912 : 268435456;
        }
        if ((i6 & 306783379) == 306783378 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1232421332, i6, -1, "dk.molslinjen.ui.views.screens.profile.authentication.register.SignupAdditionalInfoInput (SignupAdditionalInfoInput.kt:35)");
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
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.signup_additionalInfoScreen_title, new Object[]{firstName}, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH2Bold(), startRestartGroup, 0, 1572864, 65534);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.signup_additionalInfoScreen_description, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 432, 1572864, 65528);
            float f5 = 32;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            int m2383getDoneeUduSuo = ImeAction.INSTANCE.m2383getDoneeUduSuo();
            startRestartGroup.startReplaceGroup(752466070);
            boolean changedInstance = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: C3.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SignupAdditionalInfoInput$lambda$2$lambda$1$lambda$0;
                        SignupAdditionalInfoInput$lambda$2$lambda$1$lambda$0 = SignupAdditionalInfoInputKt.SignupAdditionalInfoInput$lambda$2$lambda$1$lambda$0(FocusManager.this);
                        return SignupAdditionalInfoInput$lambda$2$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            int i7 = i6 >> 3;
            UserInfoAdditionalInputKt.m3515UserInfoAdditionalInputk7ZECbw(gender, localDate, locale, postalCode, onGenderChange, onBirthdateChange, onPostalCodeChange, clearNationality, navigateToNationalitySelection, m2383getDoneeUduSuo, (Function0) rememberedValue, false, startRestartGroup, (i6 & 29360128) | (i7 & 14) | 805306368 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (57344 & i7) | (458752 & i7) | ((i6 >> 6) & 3670016) | (i7 & 234881024), 0, 2048);
            composer2 = startRestartGroup;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer2, 6);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: C3.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SignupAdditionalInfoInput$lambda$3;
                    SignupAdditionalInfoInput$lambda$3 = SignupAdditionalInfoInputKt.SignupAdditionalInfoInput$lambda$3(firstName, gender, localDate, locale, postalCode, onGenderChange, onBirthdateChange, clearNationality, onPostalCodeChange, navigateToNationalitySelection, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SignupAdditionalInfoInput$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignupAdditionalInfoInput$lambda$2$lambda$1$lambda$0(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SignupAdditionalInfoInput$lambda$3(String str, Gender gender, LocalDate localDate, Locale locale, String str2, Function1 function1, Function1 function12, Function0 function0, Function1 function13, Function0 function02, int i5, Composer composer, int i6) {
        SignupAdditionalInfoInput(str, gender, localDate, locale, str2, function1, function12, function0, function13, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
