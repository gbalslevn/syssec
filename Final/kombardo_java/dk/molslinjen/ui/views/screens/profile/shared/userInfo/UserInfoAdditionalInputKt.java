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
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.BirthdateInputKt;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.GenderPickerKt;
import dk.molslinjen.ui.views.reusable.input.nationality.NationalityPickerKt;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoAdditionalInputKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a±\u0001\u0010\u0017\u001a\u00020\t2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\t0\b2\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/model/account/Gender;", "gender", "Lorg/threeten/bp/LocalDate;", "birthdate", "Ljava/util/Locale;", "nationality", BuildConfig.FLAVOR, "postalCode", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onGenderChange", "onBirthdateChange", "onPostalCodeChange", "Lkotlin/Function0;", "clearNationality", "navigateToNationalitySelection", "Landroidx/compose/ui/text/input/ImeAction;", "lastImeAction", "onLastImeAction", BuildConfig.FLAVOR, "enabled", "UserInfoAdditionalInput-k7ZECbw", "(Ldk/molslinjen/domain/model/account/Gender;Lorg/threeten/bp/LocalDate;Ljava/util/Locale;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ILkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;III)V", "UserInfoAdditionalInput", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class UserInfoAdditionalInputKt {
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01b0, code lost:
    
        r35 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0128  */
    /* renamed from: UserInfoAdditionalInput-k7ZECbw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3515UserInfoAdditionalInputk7ZECbw(final Gender gender, final LocalDate localDate, final Locale locale, final String postalCode, final Function1<? super Gender, Unit> onGenderChange, final Function1<? super LocalDate, Unit> onBirthdateChange, final Function1<? super String, Unit> onPostalCodeChange, final Function0<Unit> clearNationality, final Function0<Unit> navigateToNationalitySelection, final int i5, final Function0<Unit> onLastImeAction, boolean z5, Composer composer, final int i6, final int i7, final int i8) {
        int i9;
        int i10;
        int i11;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Composer composer2;
        final boolean z6;
        ScopeUpdateScope endRestartGroup;
        int i12;
        Intrinsics.checkNotNullParameter(postalCode, "postalCode");
        Intrinsics.checkNotNullParameter(onGenderChange, "onGenderChange");
        Intrinsics.checkNotNullParameter(onBirthdateChange, "onBirthdateChange");
        Intrinsics.checkNotNullParameter(onPostalCodeChange, "onPostalCodeChange");
        Intrinsics.checkNotNullParameter(clearNationality, "clearNationality");
        Intrinsics.checkNotNullParameter(navigateToNationalitySelection, "navigateToNationalitySelection");
        Intrinsics.checkNotNullParameter(onLastImeAction, "onLastImeAction");
        Composer startRestartGroup = composer.startRestartGroup(-2022925107);
        if ((i8 & 1) != 0) {
            i9 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i9 = i6 | (startRestartGroup.changed(gender) ? 4 : 2);
        } else {
            i9 = i6;
        }
        if ((i8 & 2) != 0) {
            i9 |= 48;
        } else if ((i6 & 48) == 0) {
            i9 |= startRestartGroup.changedInstance(localDate) ? 32 : 16;
        }
        int i13 = i9;
        if ((i8 & 4) != 0) {
            i13 |= 384;
        } else if ((i6 & 384) == 0) {
            i13 |= startRestartGroup.changedInstance(locale) ? 256 : 128;
            if ((i8 & 8) == 0) {
                i13 |= 3072;
            } else if ((i6 & 3072) == 0) {
                i13 |= startRestartGroup.changed(postalCode) ? 2048 : 1024;
            }
            if ((i8 & 16) == 0) {
                i13 |= 24576;
            } else if ((i6 & 24576) == 0) {
                i13 |= startRestartGroup.changedInstance(onGenderChange) ? 16384 : 8192;
            }
            if ((i8 & 32) == 0) {
                i13 |= 196608;
            } else if ((i6 & 196608) == 0) {
                i13 |= startRestartGroup.changedInstance(onBirthdateChange) ? 131072 : 65536;
            }
            if ((i8 & 64) == 0) {
                i13 |= 1572864;
            } else if ((i6 & 1572864) == 0) {
                i13 |= startRestartGroup.changedInstance(onPostalCodeChange) ? 1048576 : 524288;
            }
            if ((i8 & 128) == 0) {
                i13 |= 12582912;
            } else if ((i6 & 12582912) == 0) {
                i13 |= startRestartGroup.changedInstance(clearNationality) ? 8388608 : 4194304;
            }
            if ((256 & i8) != 0) {
                i12 = (100663296 & i6) == 0 ? startRestartGroup.changedInstance(navigateToNationalitySelection) ? 67108864 : 33554432 : 100663296;
                if ((i8 & 512) != 0) {
                    i13 |= 805306368;
                } else if ((805306368 & i6) == 0) {
                    i13 |= startRestartGroup.changed(i5) ? 536870912 : 268435456;
                }
                if ((1024 & i8) != 0) {
                    i10 = i7 | 6;
                } else if ((i7 & 6) == 0) {
                    i10 = i7 | (startRestartGroup.changedInstance(onLastImeAction) ? 4 : 2);
                } else {
                    i10 = i7;
                }
                i11 = 2048 & i8;
                if (i11 != 0) {
                    i10 |= 48;
                } else if ((i7 & 48) == 0) {
                    i10 |= startRestartGroup.changed(z5) ? 32 : 16;
                }
                if ((i13 & 306783379) != 306783378 && (i10 & 19) == 18 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    z6 = z5;
                    composer2 = startRestartGroup;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2() { // from class: Y3.a
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit UserInfoAdditionalInput_k7ZECbw$lambda$1;
                                UserInfoAdditionalInput_k7ZECbw$lambda$1 = UserInfoAdditionalInputKt.UserInfoAdditionalInput_k7ZECbw$lambda$1(Gender.this, localDate, locale, postalCode, onGenderChange, onBirthdateChange, onPostalCodeChange, clearNationality, navigateToNationalitySelection, i5, onLastImeAction, z6, i6, i7, i8, (Composer) obj, ((Integer) obj2).intValue());
                                return UserInfoAdditionalInput_k7ZECbw$lambda$1;
                            }
                        });
                        return;
                    }
                    return;
                }
                boolean z7 = z5;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2022925107, i13, i10, "dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoAdditionalInput (UserInfoAdditionalInput.kt:37)");
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
                    startRestartGroup.createNode(constructor);
                } else {
                    startRestartGroup.useNode();
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
                int i14 = i13 << 3;
                int i15 = i10;
                int i16 = i13;
                composer2 = startRestartGroup;
                GenderPickerKt.GenderPicker(null, gender, onGenderChange, z7, null, null, composer2, (i14 & 112) | 221184 | ((i13 >> 6) & 896) | ((i10 << 6) & 7168), 1);
                float f5 = 16;
                BirthdateInputKt.BirthdateInput(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), localDate, LocalDate.now().minusYears(18L), null, null, onBirthdateChange, z7, true, null, null, composer2, (i16 & 112) | 918552582 | (i16 & 458752) | ((i15 << 15) & 3670016), 24);
                NationalityPickerKt.NationalityPicker(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), locale, navigateToNationalitySelection, clearNationality, z7, composer2, ((i16 >> 3) & 112) | 6 | ((i16 >> 18) & 896) | ((i16 >> 12) & 7168) | ((i15 << 9) & 57344), 0);
                StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), false, 0.0f, CollectionsKt.listOf(AutofillType.PostalCode), Integer.valueOf(R.string.textField_label_zipcode), null, null, onPostalCodeChange, onLastImeAction, postalCode, false, null, z7, false, 0, null, null, new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m2417getNumberPjHm6EE(), i5, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null), null, null, 0L, null, false, 0, composer2, (i14 & 29360128) | 27654 | ((i15 << 24) & 234881024) | (1879048192 & (i16 << 18)), (i15 << 3) & 896, 0, 16641126);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z7;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i13 |= i12;
            if ((i8 & 512) != 0) {
            }
            if ((1024 & i8) != 0) {
            }
            i11 = 2048 & i8;
            if (i11 != 0) {
            }
            if ((i13 & 306783379) != 306783378) {
                startRestartGroup.skipToGroupEnd();
                z6 = z5;
                composer2 = startRestartGroup;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            boolean z72 = z5;
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
            int i142 = i13 << 3;
            int i152 = i10;
            int i162 = i13;
            composer2 = startRestartGroup;
            GenderPickerKt.GenderPicker(null, gender, onGenderChange, z72, null, null, composer2, (i142 & 112) | 221184 | ((i13 >> 6) & 896) | ((i10 << 6) & 7168), 1);
            float f52 = 16;
            BirthdateInputKt.BirthdateInput(PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, Dp.m2599constructorimpl(f52), 0.0f, 0.0f, 13, null), localDate, LocalDate.now().minusYears(18L), null, null, onBirthdateChange, z72, true, null, null, composer2, (i162 & 112) | 918552582 | (i162 & 458752) | ((i152 << 15) & 3670016), 24);
            NationalityPickerKt.NationalityPicker(PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, Dp.m2599constructorimpl(f52), 0.0f, 0.0f, 13, null), locale, navigateToNationalitySelection, clearNationality, z72, composer2, ((i162 >> 3) & 112) | 6 | ((i162 >> 18) & 896) | ((i162 >> 12) & 7168) | ((i152 << 9) & 57344), 0);
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, Dp.m2599constructorimpl(f52), 0.0f, 0.0f, 13, null), false, 0.0f, CollectionsKt.listOf(AutofillType.PostalCode), Integer.valueOf(R.string.textField_label_zipcode), null, null, onPostalCodeChange, onLastImeAction, postalCode, false, null, z72, false, 0, null, null, new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m2417getNumberPjHm6EE(), i5, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null), null, null, 0L, null, false, 0, composer2, (i142 & 29360128) | 27654 | ((i152 << 24) & 234881024) | (1879048192 & (i162 << 18)), (i152 << 3) & 896, 0, 16641126);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            z6 = z72;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i8 & 8) == 0) {
        }
        if ((i8 & 16) == 0) {
        }
        if ((i8 & 32) == 0) {
        }
        if ((i8 & 64) == 0) {
        }
        if ((i8 & 128) == 0) {
        }
        if ((256 & i8) != 0) {
        }
        i13 |= i12;
        if ((i8 & 512) != 0) {
        }
        if ((1024 & i8) != 0) {
        }
        i11 = 2048 & i8;
        if (i11 != 0) {
        }
        if ((i13 & 306783379) != 306783378) {
        }
        boolean z722 = z5;
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier.Companion companion32 = Modifier.INSTANCE;
        MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, companion32);
        ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor22 = companion222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy22, companion222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion222.getSetModifier());
        ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
        int i1422 = i13 << 3;
        int i1522 = i10;
        int i1622 = i13;
        composer2 = startRestartGroup;
        GenderPickerKt.GenderPicker(null, gender, onGenderChange, z722, null, null, composer2, (i1422 & 112) | 221184 | ((i13 >> 6) & 896) | ((i10 << 6) & 7168), 1);
        float f522 = 16;
        BirthdateInputKt.BirthdateInput(PaddingKt.m315paddingqDBjuR0$default(companion32, 0.0f, Dp.m2599constructorimpl(f522), 0.0f, 0.0f, 13, null), localDate, LocalDate.now().minusYears(18L), null, null, onBirthdateChange, z722, true, null, null, composer2, (i1622 & 112) | 918552582 | (i1622 & 458752) | ((i1522 << 15) & 3670016), 24);
        NationalityPickerKt.NationalityPicker(PaddingKt.m315paddingqDBjuR0$default(companion32, 0.0f, Dp.m2599constructorimpl(f522), 0.0f, 0.0f, 13, null), locale, navigateToNationalitySelection, clearNationality, z722, composer2, ((i1622 >> 3) & 112) | 6 | ((i1622 >> 18) & 896) | ((i1622 >> 12) & 7168) | ((i1522 << 9) & 57344), 0);
        StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(PaddingKt.m315paddingqDBjuR0$default(companion32, 0.0f, Dp.m2599constructorimpl(f522), 0.0f, 0.0f, 13, null), false, 0.0f, CollectionsKt.listOf(AutofillType.PostalCode), Integer.valueOf(R.string.textField_label_zipcode), null, null, onPostalCodeChange, onLastImeAction, postalCode, false, null, z722, false, 0, null, null, new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m2417getNumberPjHm6EE(), i5, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null), null, null, 0L, null, false, 0, composer2, (i1422 & 29360128) | 27654 | ((i1522 << 24) & 234881024) | (1879048192 & (i1622 << 18)), (i1522 << 3) & 896, 0, 16641126);
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        z6 = z722;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserInfoAdditionalInput_k7ZECbw$lambda$1(Gender gender, LocalDate localDate, Locale locale, String str, Function1 function1, Function1 function12, Function1 function13, Function0 function0, Function0 function02, int i5, Function0 function03, boolean z5, int i6, int i7, int i8, Composer composer, int i9) {
        m3515UserInfoAdditionalInputk7ZECbw(gender, localDate, locale, str, function1, function12, function13, function0, function02, i5, function03, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), RecomposeScopeImplKt.updateChangedFlags(i7), i8);
        return Unit.INSTANCE;
    }
}
