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
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoNameInputKt;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0083\u0001\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "firstNameValidationKey", "lastNameValidationKey", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", BuildConfig.FLAVOR, "firstName", "lastName", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onFirstNameChange", "onLastNameChange", "Landroidx/compose/ui/text/input/ImeAction;", "lastImeAction", "Lkotlin/Function0;", "onLastImeAction", BuildConfig.FLAVOR, "enabled", "UserInfoNameInput-dAaJhyQ", "(Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ILkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "UserInfoNameInput", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class UserInfoNameInputKt {
    /* JADX WARN: Removed duplicated region for block: B:31:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0134  */
    /* renamed from: UserInfoNameInput-dAaJhyQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3517UserInfoNameInputdAaJhyQ(final IFormValidator.ValidationKey firstNameValidationKey, final IFormValidator.ValidationKey lastNameValidationKey, final IFormValidator validator, final String str, final String str2, final Function1<? super String, Unit> onFirstNameChange, final Function1<? super String, Unit> onLastNameChange, final int i5, final Function0<Unit> onLastImeAction, boolean z5, Composer composer, final int i6, final int i7) {
        int i8;
        int i9;
        boolean z6;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        boolean changedInstance;
        Object rememberedValue;
        Composer composer2;
        final boolean z7;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(firstNameValidationKey, "firstNameValidationKey");
        Intrinsics.checkNotNullParameter(lastNameValidationKey, "lastNameValidationKey");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(onFirstNameChange, "onFirstNameChange");
        Intrinsics.checkNotNullParameter(onLastNameChange, "onLastNameChange");
        Intrinsics.checkNotNullParameter(onLastImeAction, "onLastImeAction");
        Composer startRestartGroup = composer.startRestartGroup(1755517564);
        if ((i7 & 1) != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i8 = i6 | ((i6 & 8) == 0 ? startRestartGroup.changed(firstNameValidationKey) : startRestartGroup.changedInstance(firstNameValidationKey) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((2 & i7) != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i8 |= (i6 & 64) == 0 ? startRestartGroup.changed(lastNameValidationKey) : startRestartGroup.changedInstance(lastNameValidationKey) ? 32 : 16;
        }
        int i10 = i8;
        if ((4 & i7) != 0) {
            i10 |= 384;
        } else if ((i6 & 384) == 0) {
            i10 |= (i6 & 512) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 256 : 128;
        }
        if ((i7 & 8) != 0) {
            i10 |= 3072;
        } else if ((i6 & 3072) == 0) {
            i10 |= startRestartGroup.changed(str) ? 2048 : 1024;
        }
        if ((i7 & 16) != 0) {
            i10 |= 24576;
        } else if ((i6 & 24576) == 0) {
            i10 |= startRestartGroup.changed(str2) ? 16384 : 8192;
        }
        if ((32 & i7) != 0) {
            i10 |= 196608;
        } else if ((i6 & 196608) == 0) {
            i10 |= startRestartGroup.changedInstance(onFirstNameChange) ? 131072 : 65536;
        }
        if ((i7 & 64) != 0) {
            i10 |= 1572864;
        } else if ((i6 & 1572864) == 0) {
            i10 |= startRestartGroup.changedInstance(onLastNameChange) ? 1048576 : 524288;
        }
        if ((128 & i7) != 0) {
            i10 |= 12582912;
        } else if ((i6 & 12582912) == 0) {
            i10 |= startRestartGroup.changed(i5) ? 8388608 : 4194304;
            if ((256 & i7) == 0) {
                i10 |= 100663296;
            } else if ((i6 & 100663296) == 0) {
                i10 |= startRestartGroup.changedInstance(onLastImeAction) ? 67108864 : 33554432;
            }
            i9 = i7 & 512;
            if (i9 == 0) {
                i10 |= 805306368;
                z6 = z5;
            } else {
                z6 = z5;
                if ((i6 & 805306368) == 0) {
                    i10 |= startRestartGroup.changed(z6) ? 536870912 : 268435456;
                }
            }
            if ((i10 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                boolean z8 = i9 == 0 ? true : z6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1755517564, i10, -1, "dk.molslinjen.ui.views.screens.profile.shared.userInfo.UserInfoNameInput (UserInfoNameInput.kt:34)");
                }
                final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
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
                KeyboardCapitalization.Companion companion3 = KeyboardCapitalization.INSTANCE;
                KeyboardOptions keyboardOptions = new KeyboardOptions(companion3.m2406getWordsIUNYP9k(), (Boolean) null, 0, ImeAction.INSTANCE.m2385getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 118, (DefaultConstructorMarker) null);
                String str3 = str != null ? BuildConfig.FLAVOR : str;
                List listOf = CollectionsKt.listOf(AutofillType.PersonFirstName);
                Integer valueOf = Integer.valueOf(R.string.textField_label_firstName);
                startRestartGroup.startReplaceGroup(-563741990);
                changedInstance = startRestartGroup.changedInstance(focusManager);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: Y3.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit UserInfoNameInput_dAaJhyQ$lambda$2$lambda$1$lambda$0;
                            UserInfoNameInput_dAaJhyQ$lambda$2$lambda$1$lambda$0 = UserInfoNameInputKt.UserInfoNameInput_dAaJhyQ$lambda$2$lambda$1$lambda$0(FocusManager.this);
                            return UserInfoNameInput_dAaJhyQ$lambda$2$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                int i11 = (i10 >> 21) & 896;
                int i12 = i10 << 12;
                int i13 = i12 & 3670016;
                composer2 = startRestartGroup;
                int i14 = i10;
                StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, listOf, valueOf, null, null, onFirstNameChange, (Function0) rememberedValue, str3, false, null, z8, false, 0, firstNameValidationKey, validator, keyboardOptions, null, null, 0L, null, false, 0, composer2, ((i10 << 6) & 29360128) | 27648, i11 | 12582912 | ((i10 << 15) & 458752) | i13, 0, 16542823);
                StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null), false, 0.0f, CollectionsKt.listOf(AutofillType.PersonLastName), Integer.valueOf(R.string.textField_label_lastName), null, null, onLastNameChange, onLastImeAction, str2 != null ? BuildConfig.FLAVOR : str2, false, null, z8, false, 0, lastNameValidationKey, validator, new KeyboardOptions(companion3.m2406getWordsIUNYP9k(), (Boolean) null, 0, i5, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 118, (DefaultConstructorMarker) null), null, null, 0L, null, false, 0, composer2, ((i14 << 3) & 29360128) | 27654 | (i14 & 234881024), i11 | (i12 & 458752) | i13, 0, 16542822);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z7 = z8;
            } else {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
                z7 = z6;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: Y3.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit UserInfoNameInput_dAaJhyQ$lambda$3;
                        UserInfoNameInput_dAaJhyQ$lambda$3 = UserInfoNameInputKt.UserInfoNameInput_dAaJhyQ$lambda$3(IFormValidator.ValidationKey.this, lastNameValidationKey, validator, str, str2, onFirstNameChange, onLastNameChange, i5, onLastImeAction, z7, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                        return UserInfoNameInput_dAaJhyQ$lambda$3;
                    }
                });
                return;
            }
            return;
        }
        if ((256 & i7) == 0) {
        }
        i9 = i7 & 512;
        if (i9 == 0) {
        }
        if ((i10 & 306783379) == 306783378) {
        }
        if (i9 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        final FocusManager focusManager2 = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
        Modifier.Companion companion4 = Modifier.INSTANCE;
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion4);
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
        KeyboardCapitalization.Companion companion32 = KeyboardCapitalization.INSTANCE;
        KeyboardOptions keyboardOptions2 = new KeyboardOptions(companion32.m2406getWordsIUNYP9k(), (Boolean) null, 0, ImeAction.INSTANCE.m2385getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 118, (DefaultConstructorMarker) null);
        if (str != null) {
        }
        List listOf2 = CollectionsKt.listOf(AutofillType.PersonFirstName);
        Integer valueOf2 = Integer.valueOf(R.string.textField_label_firstName);
        startRestartGroup.startReplaceGroup(-563741990);
        changedInstance = startRestartGroup.changedInstance(focusManager2);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function0() { // from class: Y3.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit UserInfoNameInput_dAaJhyQ$lambda$2$lambda$1$lambda$0;
                UserInfoNameInput_dAaJhyQ$lambda$2$lambda$1$lambda$0 = UserInfoNameInputKt.UserInfoNameInput_dAaJhyQ$lambda$2$lambda$1$lambda$0(FocusManager.this);
                return UserInfoNameInput_dAaJhyQ$lambda$2$lambda$1$lambda$0;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        int i112 = (i10 >> 21) & 896;
        int i122 = i10 << 12;
        int i132 = i122 & 3670016;
        composer2 = startRestartGroup;
        int i142 = i10;
        StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, listOf2, valueOf2, null, null, onFirstNameChange, (Function0) rememberedValue, str3, false, null, z8, false, 0, firstNameValidationKey, validator, keyboardOptions2, null, null, 0L, null, false, 0, composer2, ((i10 << 6) & 29360128) | 27648, i112 | 12582912 | ((i10 << 15) & 458752) | i132, 0, 16542823);
        StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(PaddingKt.m315paddingqDBjuR0$default(companion4, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null), false, 0.0f, CollectionsKt.listOf(AutofillType.PersonLastName), Integer.valueOf(R.string.textField_label_lastName), null, null, onLastNameChange, onLastImeAction, str2 != null ? BuildConfig.FLAVOR : str2, false, null, z8, false, 0, lastNameValidationKey, validator, new KeyboardOptions(companion32.m2406getWordsIUNYP9k(), (Boolean) null, 0, i5, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 118, (DefaultConstructorMarker) null), null, null, 0L, null, false, 0, composer2, ((i142 << 3) & 29360128) | 27654 | (i142 & 234881024), i112 | (i122 & 458752) | i132, 0, 16542822);
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        z7 = z8;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserInfoNameInput_dAaJhyQ$lambda$2$lambda$1$lambda$0(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1283getNextdhqQ8s());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserInfoNameInput_dAaJhyQ$lambda$3(IFormValidator.ValidationKey validationKey, IFormValidator.ValidationKey validationKey2, IFormValidator iFormValidator, String str, String str2, Function1 function1, Function1 function12, int i5, Function0 function0, boolean z5, int i6, int i7, Composer composer, int i8) {
        m3517UserInfoNameInputdAaJhyQ(validationKey, validationKey2, iFormValidator, str, str2, function1, function12, i5, function0, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }
}
