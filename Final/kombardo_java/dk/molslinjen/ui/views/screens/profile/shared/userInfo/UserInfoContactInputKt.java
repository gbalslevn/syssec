package dk.molslinjen.ui.views.screens.profile.shared.userInfo;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.text.KeyboardOptions;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.PhoneNumberInputKt;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoContactInputKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0095\u0001\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/model/shared/PhoneNumber;", "phoneNumber", BuildConfig.FLAVOR, "email", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onPhoneNumberChange", "onEmailChange", "Lkotlin/Function0;", "showPhoneNumberCodeSelector", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "countryCodeValidationKey", "nationalNumberValidationKey", "emailValidationKey", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "Landroidx/compose/ui/text/input/ImeAction;", "lastImeAction", "onLastImeAction", BuildConfig.FLAVOR, "enabled", "UserInfoContactInput-k7ZECbw", "(Ldk/molslinjen/domain/model/shared/PhoneNumber;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;ILkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;III)V", "UserInfoContactInput", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class UserInfoContactInputKt {
    /* JADX WARN: Removed duplicated region for block: B:38:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0195  */
    /* renamed from: UserInfoContactInput-k7ZECbw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3516UserInfoContactInputk7ZECbw(final PhoneNumber phoneNumber, final String email, final Function1<? super PhoneNumber, Unit> onPhoneNumberChange, final Function1<? super String, Unit> onEmailChange, final Function0<Unit> showPhoneNumberCodeSelector, final IFormValidator.ValidationKey countryCodeValidationKey, final IFormValidator.ValidationKey nationalNumberValidationKey, final IFormValidator.ValidationKey emailValidationKey, final IFormValidator validator, final int i5, final Function0<Unit> onLastImeAction, boolean z5, Composer composer, final int i6, final int i7, final int i8) {
        int i9;
        int i10;
        int i11;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Composer composer2;
        final boolean z6;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(onPhoneNumberChange, "onPhoneNumberChange");
        Intrinsics.checkNotNullParameter(onEmailChange, "onEmailChange");
        Intrinsics.checkNotNullParameter(showPhoneNumberCodeSelector, "showPhoneNumberCodeSelector");
        Intrinsics.checkNotNullParameter(countryCodeValidationKey, "countryCodeValidationKey");
        Intrinsics.checkNotNullParameter(nationalNumberValidationKey, "nationalNumberValidationKey");
        Intrinsics.checkNotNullParameter(emailValidationKey, "emailValidationKey");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(onLastImeAction, "onLastImeAction");
        Composer startRestartGroup = composer.startRestartGroup(-1377599772);
        if ((i8 & 1) != 0) {
            i9 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i9 = i6 | (startRestartGroup.changedInstance(phoneNumber) ? 4 : 2);
        } else {
            i9 = i6;
        }
        if ((i8 & 2) != 0) {
            i9 |= 48;
        } else if ((i6 & 48) == 0) {
            i9 |= startRestartGroup.changed(email) ? 32 : 16;
        }
        int i12 = i9;
        if ((i8 & 4) != 0) {
            i12 |= 384;
        } else if ((i6 & 384) == 0) {
            i12 |= startRestartGroup.changedInstance(onPhoneNumberChange) ? 256 : 128;
        }
        if ((i8 & 8) != 0) {
            i12 |= 3072;
        } else if ((i6 & 3072) == 0) {
            i12 |= startRestartGroup.changedInstance(onEmailChange) ? 2048 : 1024;
        }
        if ((i8 & 16) != 0) {
            i12 |= 24576;
        } else if ((i6 & 24576) == 0) {
            i12 |= startRestartGroup.changedInstance(showPhoneNumberCodeSelector) ? 16384 : 8192;
        }
        if ((i8 & 32) != 0) {
            i12 |= 196608;
        } else if ((i6 & 196608) == 0) {
            i12 |= (262144 & i6) == 0 ? startRestartGroup.changed(countryCodeValidationKey) : startRestartGroup.changedInstance(countryCodeValidationKey) ? 131072 : 65536;
        }
        if ((i8 & 64) != 0) {
            i12 |= 1572864;
        } else if ((i6 & 1572864) == 0) {
            i12 |= (2097152 & i6) == 0 ? startRestartGroup.changed(nationalNumberValidationKey) : startRestartGroup.changedInstance(nationalNumberValidationKey) ? 1048576 : 524288;
        }
        if ((128 & i8) != 0) {
            i12 |= 12582912;
        } else if ((i6 & 12582912) == 0) {
            i12 |= (16777216 & i6) == 0 ? startRestartGroup.changed(emailValidationKey) : startRestartGroup.changedInstance(emailValidationKey) ? 8388608 : 4194304;
        }
        if ((256 & i8) != 0) {
            i12 |= 100663296;
        } else if ((i6 & 100663296) == 0) {
            i12 |= (134217728 & i6) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 67108864 : 33554432;
        }
        if ((i8 & 512) != 0) {
            i12 |= 805306368;
        } else if ((i6 & 805306368) == 0) {
            i12 |= startRestartGroup.changed(i5) ? 536870912 : 268435456;
            if ((1024 & i8) == 0) {
                i10 = i7 | 6;
            } else if ((i7 & 6) == 0) {
                i10 = i7 | (startRestartGroup.changedInstance(onLastImeAction) ? 4 : 2);
            } else {
                i10 = i7;
            }
            i11 = 2048 & i8;
            if (i11 == 0) {
                i10 |= 48;
            } else if ((i7 & 48) == 0) {
                i10 |= startRestartGroup.changed(z5) ? 32 : 16;
            }
            if ((i12 & 306783379) != 306783378 && (i10 & 19) == 18 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                z6 = z5;
                composer2 = startRestartGroup;
            } else {
                boolean z7 = i11 == 0 ? true : z5;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1377599772, i12, i10, "dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoContactInput (UserInfoContactInput.kt:36)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor);
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i13 = i12 >> 6;
                int i14 = i13 & 3670016;
                composer2 = startRestartGroup;
                int i15 = i12;
                int i16 = i10;
                PhoneNumberInputKt.PhoneNumberInput(null, phoneNumber, onPhoneNumberChange, showPhoneNumberCodeSelector, nationalNumberValidationKey, countryCodeValidationKey, validator, z7, composer2, ((i12 << 3) & 112) | (i12 & 896) | ((i12 >> 3) & 7168) | (i13 & 57344) | (i12 & 458752) | i14 | ((i10 << 18) & 29360128), 1);
                StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null), false, 0.0f, CollectionsKt.listOf((Object[]) new AutofillType[]{AutofillType.EmailAddress, AutofillType.NewUsername, AutofillType.Username}), Integer.valueOf(R.string.textField_label_email), null, null, onEmailChange, onLastImeAction, email, false, null, z7, false, 0, emailValidationKey, validator, new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m2416getEmailPjHm6EE(), i5, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null), null, null, 0L, null, false, 0, composer2, ((i15 << 12) & 29360128) | 27654 | ((i16 << 24) & 234881024) | ((i15 << 24) & 1879048192), ((i16 << 3) & 896) | (i13 & 458752) | i14, 0, 16542822);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z7;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: Y3.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit UserInfoContactInput_k7ZECbw$lambda$1;
                        UserInfoContactInput_k7ZECbw$lambda$1 = UserInfoContactInputKt.UserInfoContactInput_k7ZECbw$lambda$1(PhoneNumber.this, email, onPhoneNumberChange, onEmailChange, showPhoneNumberCodeSelector, countryCodeValidationKey, nationalNumberValidationKey, emailValidationKey, validator, i5, onLastImeAction, z6, i6, i7, i8, (Composer) obj, ((Integer) obj2).intValue());
                        return UserInfoContactInput_k7ZECbw$lambda$1;
                    }
                });
                return;
            }
            return;
        }
        if ((1024 & i8) == 0) {
        }
        i11 = 2048 & i8;
        if (i11 == 0) {
        }
        if ((i12 & 306783379) != 306783378) {
        }
        if (i11 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier.Companion companion3 = Modifier.INSTANCE;
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion3);
        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion22.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion22.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion22.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion22.getSetModifier());
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        int i132 = i12 >> 6;
        int i142 = i132 & 3670016;
        composer2 = startRestartGroup;
        int i152 = i12;
        int i162 = i10;
        PhoneNumberInputKt.PhoneNumberInput(null, phoneNumber, onPhoneNumberChange, showPhoneNumberCodeSelector, nationalNumberValidationKey, countryCodeValidationKey, validator, z7, composer2, ((i12 << 3) & 112) | (i12 & 896) | ((i12 >> 3) & 7168) | (i132 & 57344) | (i12 & 458752) | i142 | ((i10 << 18) & 29360128), 1);
        StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null), false, 0.0f, CollectionsKt.listOf((Object[]) new AutofillType[]{AutofillType.EmailAddress, AutofillType.NewUsername, AutofillType.Username}), Integer.valueOf(R.string.textField_label_email), null, null, onEmailChange, onLastImeAction, email, false, null, z7, false, 0, emailValidationKey, validator, new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m2416getEmailPjHm6EE(), i5, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null), null, null, 0L, null, false, 0, composer2, ((i152 << 12) & 29360128) | 27654 | ((i162 << 24) & 234881024) | ((i152 << 24) & 1879048192), ((i162 << 3) & 896) | (i132 & 458752) | i142, 0, 16542822);
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        z6 = z7;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserInfoContactInput_k7ZECbw$lambda$1(PhoneNumber phoneNumber, String str, Function1 function1, Function1 function12, Function0 function0, IFormValidator.ValidationKey validationKey, IFormValidator.ValidationKey validationKey2, IFormValidator.ValidationKey validationKey3, IFormValidator iFormValidator, int i5, Function0 function02, boolean z5, int i6, int i7, int i8, Composer composer, int i9) {
        m3516UserInfoContactInputk7ZECbw(phoneNumber, str, function1, function12, function0, validationKey, validationKey2, validationKey3, iFormValidator, i5, function02, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), RecomposeScopeImplKt.updateChangedFlags(i7), i8);
        return Unit.INSTANCE;
    }
}
