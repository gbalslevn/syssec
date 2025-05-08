package dk.molslinjen.ui.views.reusable.input;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.InputErrorTextKt;
import dk.molslinjen.ui.views.reusable.dialog.DatePickerSpinnerDialogKt;
import dk.molslinjen.ui.views.reusable.input.BirthdateInputKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.reusable.input.validation.validators.NonNullCustomValidator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0083\u0001\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014²\u0006\u000e\u0010\u0013\u001a\u00020\n8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lorg/threeten/bp/LocalDate;", "birthdate", "defaultDate", "maxDate", "minDate", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onBirthdateChange", BuildConfig.FLAVOR, "inputEnabled", "canClear", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "validationKey", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "BirthdateInput", "(Landroidx/compose/ui/Modifier;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Lorg/threeten/bp/LocalDate;Lkotlin/jvm/functions/Function1;ZZLdk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Landroidx/compose/runtime/Composer;II)V", "showDatePicker", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BirthdateInputKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0326  */
    /* JADX WARN: Type inference failed for: r29v1, types: [kotlin.jvm.functions.Function2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BirthdateInput(Modifier modifier, final LocalDate localDate, LocalDate localDate2, LocalDate localDate3, LocalDate localDate4, final Function1<? super LocalDate, Unit> onBirthdateChange, boolean z5, boolean z6, final IFormValidator.ValidationKey validationKey, final IFormValidator iFormValidator, Composer composer, final int i5, final int i6) {
        int i7;
        LocalDate localDate5;
        LocalDate localDate6;
        int i8;
        int i9;
        int i10;
        Modifier modifier2;
        LocalDate localDate7;
        LocalDate localDate8;
        boolean z7;
        int i11;
        boolean z8;
        boolean z9;
        boolean z10;
        String errorMessage;
        Map map;
        Object rememberedValue;
        Composer.Companion companion;
        String str;
        final MutableState mutableState;
        LocalDate localDate9;
        String str2;
        Composer composer2;
        Composer composer3;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        String formatBirthdateInput;
        boolean z11;
        Object obj;
        Object rememberedValue2;
        int i12;
        boolean z12;
        final LocalDate localDate10;
        final LocalDate localDate11;
        final LocalDate localDate12;
        final boolean z13;
        final Modifier modifier3;
        final boolean z14;
        int i13;
        int i14;
        Intrinsics.checkNotNullParameter(onBirthdateChange, "onBirthdateChange");
        Composer startRestartGroup = composer.startRestartGroup(-34992448);
        int i15 = i6 & 1;
        if (i15 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = i5 | (startRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(localDate) ? 32 : 16;
        }
        int i16 = i7;
        int i17 = 4 & i6;
        if (i17 != 0) {
            i16 |= 384;
        } else if ((i5 & 384) == 0) {
            localDate5 = localDate2;
            i16 |= startRestartGroup.changedInstance(localDate5) ? 256 : 128;
            if ((i5 & 3072) != 0) {
                if ((i6 & 8) == 0) {
                    localDate6 = localDate3;
                    if (startRestartGroup.changedInstance(localDate6)) {
                        i14 = 2048;
                        i16 |= i14;
                    }
                } else {
                    localDate6 = localDate3;
                }
                i14 = 1024;
                i16 |= i14;
            } else {
                localDate6 = localDate3;
            }
            i8 = 16 & i6;
            if (i8 == 0) {
                i16 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i16 |= startRestartGroup.changedInstance(localDate4) ? 16384 : 8192;
                if ((32 & i6) != 0) {
                    i16 |= 196608;
                } else if ((i5 & 196608) == 0) {
                    i16 |= startRestartGroup.changedInstance(onBirthdateChange) ? 131072 : 65536;
                }
                i9 = i6 & 64;
                if (i9 != 0) {
                    i16 |= 1572864;
                } else if ((i5 & 1572864) == 0) {
                    i16 |= startRestartGroup.changed(z5) ? 1048576 : 524288;
                }
                i10 = 128 & i6;
                if (i10 == 0) {
                    i13 = (i5 & 12582912) == 0 ? startRestartGroup.changed(z6) ? 8388608 : 4194304 : 12582912;
                    if ((256 & i6) == 0) {
                        i16 |= 100663296;
                    } else if ((i5 & 100663296) == 0) {
                        i16 |= (134217728 & i5) == 0 ? startRestartGroup.changed(validationKey) : startRestartGroup.changedInstance(validationKey) ? 67108864 : 33554432;
                    }
                    if ((i6 & 512) == 0) {
                        i16 |= 805306368;
                    } else if ((i5 & 805306368) == 0) {
                        i16 |= (1073741824 & i5) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 536870912 : 268435456;
                    }
                    if ((306783379 & i16) == 306783378 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            modifier2 = i15 == 0 ? Modifier.INSTANCE : modifier;
                            if (i17 != 0) {
                                localDate5 = null;
                            }
                            if ((i6 & 8) == 0) {
                                localDate7 = LocalDate.now();
                                i16 &= -7169;
                            } else {
                                localDate7 = localDate6;
                            }
                            localDate8 = i8 == 0 ? null : localDate4;
                            z7 = i9 == 0 ? true : z5;
                            if (i10 == 0) {
                                i11 = i16;
                                z8 = false;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-34992448, i11, -1, "dk.molslinjen.ui.views.reusable.input.BirthdateInput (BirthdateInput.kt:44)");
                                }
                                z9 = (z8 || !z7 || localDate == null) ? false : true;
                                if (validationKey != null && iFormValidator != null) {
                                    iFormValidator.set(validationKey, NonNullCustomValidator.Birthdate.INSTANCE.validateInput(localDate));
                                    Unit unit = Unit.INSTANCE;
                                }
                                startRestartGroup.startReplaceGroup(-2025055187);
                                if (validationKey != null) {
                                    z10 = z8;
                                    errorMessage = null;
                                } else {
                                    StateFlow<Map<IFormValidator.ValidationKey, InputValidationError>> submittedErrors = iFormValidator != null ? iFormValidator.getSubmittedErrors() : null;
                                    startRestartGroup.startReplaceGroup(-2025053962);
                                    z10 = z8;
                                    State collectAsState = submittedErrors == null ? null : SnapshotStateKt.collectAsState(submittedErrors, null, startRestartGroup, 0, 1);
                                    startRestartGroup.endReplaceGroup();
                                    InputValidationError inputValidationError = (collectAsState == null || (map = (Map) collectAsState.getValue()) == null) ? null : (InputValidationError) map.get(validationKey);
                                    startRestartGroup.startReplaceGroup(-2025052434);
                                    errorMessage = inputValidationError == null ? null : inputValidationError.toErrorMessage((Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), validationKey);
                                    startRestartGroup.endReplaceGroup();
                                }
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.startReplaceGroup(-2025050072);
                                rememberedValue = startRestartGroup.rememberedValue();
                                companion = Composer.INSTANCE;
                                if (rememberedValue != companion.getEmpty()) {
                                    str = null;
                                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                } else {
                                    str = null;
                                }
                                mutableState = (MutableState) rememberedValue;
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.startReplaceGroup(-2025048383);
                                if (BirthdateInput$lambda$3(mutableState)) {
                                    localDate9 = localDate5;
                                    str2 = str;
                                    composer2 = startRestartGroup;
                                } else {
                                    String stringResource = StringResources_androidKt.stringResource(R.string.textField_label_birthdate, startRestartGroup, 6);
                                    LocalDate localDate13 = localDate == null ? localDate5 : localDate;
                                    startRestartGroup.startReplaceGroup(-2025039902);
                                    boolean z15 = (458752 & i11) == 131072;
                                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (z15 || rememberedValue3 == companion.getEmpty()) {
                                        rememberedValue3 = new Function1() { // from class: c2.d
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj2) {
                                                Unit BirthdateInput$lambda$6$lambda$5;
                                                BirthdateInput$lambda$6$lambda$5 = BirthdateInputKt.BirthdateInput$lambda$6$lambda$5(Function1.this, mutableState, (LocalDate) obj2);
                                                return BirthdateInput$lambda$6$lambda$5;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                    }
                                    Function1 function1 = (Function1) rememberedValue3;
                                    startRestartGroup.endReplaceGroup();
                                    startRestartGroup.startReplaceGroup(-2025035968);
                                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                                    localDate9 = localDate5;
                                    if (rememberedValue4 == companion.getEmpty()) {
                                        rememberedValue4 = new Function0() { // from class: c2.e
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                Unit BirthdateInput$lambda$8$lambda$7;
                                                BirthdateInput$lambda$8$lambda$7 = BirthdateInputKt.BirthdateInput$lambda$8$lambda$7(MutableState.this);
                                                return BirthdateInput$lambda$8$lambda$7;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue4);
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    int i18 = i11 >> 3;
                                    str2 = null;
                                    composer2 = startRestartGroup;
                                    DatePickerSpinnerDialogKt.DatePickerSpinnerDialog(stringResource, localDate13, localDate7, localDate8, function1, (Function0) rememberedValue4, composer2, (i18 & 896) | 196608 | (i18 & 7168), 0);
                                }
                                composer2.endReplaceGroup();
                                String formatBirthdateInput2 = localDate == null ? LocalDateTimeExtensionsKt.toFormatBirthdateInput(localDate) : str2;
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                composer3 = composer2;
                                LocalDate localDate14 = localDate8;
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, companion2);
                                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                LocalDate localDate15 = localDate7;
                                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                if (composer3.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.useNode();
                                } else {
                                    composer3.createNode(constructor);
                                }
                                m1226constructorimpl = Updater.m1226constructorimpl(composer3);
                                boolean z16 = z7;
                                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                String stringResource2 = StringResources_androidKt.stringResource(R.string.textField_label_birthdate, composer3, 6);
                                formatBirthdateInput = localDate == null ? LocalDateTimeExtensionsKt.toFormatBirthdateInput(localDate) : str2;
                                composer3.startReplaceGroup(-533474881);
                                if (formatBirthdateInput == null) {
                                    formatBirthdateInput = StringResources_androidKt.stringResource(R.string.placeholder_birthdate, composer3, 6);
                                }
                                String str3 = formatBirthdateInput;
                                composer3.endReplaceGroup();
                                if (localDate != null || (r5 = LocalDateTimeExtensionsKt.toAccessibilityReadableDate(localDate)) == null) {
                                    String str4 = BuildConfig.FLAVOR;
                                }
                                String str5 = str4;
                                AppColor appColor = AppColor.INSTANCE;
                                long m3253getBrandBlack10d7_KjU = formatBirthdateInput2 == null ? appColor.m3253getBrandBlack10d7_KjU() : appColor.m3264getGrey10d7_KjU();
                                AppColor appColor2 = AppColor.INSTANCE;
                                long m3253getBrandBlack10d7_KjU2 = formatBirthdateInput2 == null ? appColor2.m3253getBrandBlack10d7_KjU() : appColor2.m3267getGrey40d7_KjU();
                                boolean z17 = errorMessage == null;
                                composer3.startReplaceGroup(-533457707);
                                if (z9) {
                                    z11 = true;
                                    obj = str2;
                                } else {
                                    z11 = true;
                                    obj = ComposableLambdaKt.rememberComposableLambda(-166218797, true, new BirthdateInputKt$BirthdateInput$4$1(onBirthdateChange), composer3, 54);
                                }
                                composer3.endReplaceGroup();
                                composer3.startReplaceGroup(-533459906);
                                rememberedValue2 = composer3.rememberedValue();
                                if (rememberedValue2 == companion.getEmpty()) {
                                    rememberedValue2 = new Function0() { // from class: c2.f
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            Unit BirthdateInput$lambda$11$lambda$10$lambda$9;
                                            BirthdateInput$lambda$11$lambda$10$lambda$9 = BirthdateInputKt.BirthdateInput$lambda$11$lambda$10$lambda$9(MutableState.this);
                                            return BirthdateInput$lambda$11$lambda$10$lambda$9;
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue2);
                                }
                                composer3.endReplaceGroup();
                                TextBoxKt.m3414TextBoxNpQZenA(modifier2, str3, stringResource2, str5, z16, (Function0) rememberedValue2, false, z17, 0L, m3253getBrandBlack10d7_KjU, m3253getBrandBlack10d7_KjU2, null, obj, composer3, (i11 & 14) | 196608 | ((i11 >> 6) & 57344), 0, 2368);
                                if (errorMessage == null) {
                                    z12 = z11;
                                    i12 = 6;
                                } else {
                                    i12 = 6;
                                    z12 = false;
                                }
                                InputErrorTextKt.InputErrorText(columnScopeInstance, z12, errorMessage, composer3, i12);
                                composer3.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                localDate10 = localDate9;
                                localDate11 = localDate14;
                                localDate12 = localDate15;
                                z13 = z16;
                                modifier3 = modifier2;
                                z14 = z10;
                            } else {
                                i11 = i16;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i6 & 8) != 0) {
                                i16 &= -7169;
                            }
                            modifier2 = modifier;
                            localDate8 = localDate4;
                            z7 = z5;
                            i11 = i16;
                            localDate7 = localDate6;
                        }
                        z8 = z6;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (z8) {
                        }
                        if (validationKey != null) {
                            iFormValidator.set(validationKey, NonNullCustomValidator.Birthdate.INSTANCE.validateInput(localDate));
                            Unit unit2 = Unit.INSTANCE;
                        }
                        startRestartGroup.startReplaceGroup(-2025055187);
                        if (validationKey != null) {
                        }
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-2025050072);
                        rememberedValue = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (rememberedValue != companion.getEmpty()) {
                        }
                        mutableState = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-2025048383);
                        if (BirthdateInput$lambda$3(mutableState)) {
                        }
                        composer2.endReplaceGroup();
                        if (localDate == null) {
                        }
                        Modifier.Companion companion22 = Modifier.INSTANCE;
                        composer3 = composer2;
                        LocalDate localDate142 = localDate8;
                        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, companion22);
                        ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
                        LocalDate localDate152 = localDate7;
                        Function0<ComposeUiNode> constructor2 = companion32.getConstructor();
                        if (composer3.getApplier() == null) {
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                        }
                        m1226constructorimpl = Updater.m1226constructorimpl(composer3);
                        boolean z162 = z7;
                        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion32.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion32.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion32.getSetCompositeKeyHash();
                        if (!m1226constructorimpl.getInserting()) {
                        }
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion32.getSetModifier());
                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                        String stringResource22 = StringResources_androidKt.stringResource(R.string.textField_label_birthdate, composer3, 6);
                        if (localDate == null) {
                        }
                        composer3.startReplaceGroup(-533474881);
                        if (formatBirthdateInput == null) {
                        }
                        String str32 = formatBirthdateInput;
                        composer3.endReplaceGroup();
                        if (localDate != null) {
                        }
                        String str42 = BuildConfig.FLAVOR;
                        String str52 = str42;
                        AppColor appColor3 = AppColor.INSTANCE;
                        long m3253getBrandBlack10d7_KjU3 = formatBirthdateInput2 == null ? appColor3.m3253getBrandBlack10d7_KjU() : appColor3.m3264getGrey10d7_KjU();
                        AppColor appColor22 = AppColor.INSTANCE;
                        long m3253getBrandBlack10d7_KjU22 = formatBirthdateInput2 == null ? appColor22.m3253getBrandBlack10d7_KjU() : appColor22.m3267getGrey40d7_KjU();
                        if (errorMessage == null) {
                        }
                        composer3.startReplaceGroup(-533457707);
                        if (z9) {
                        }
                        composer3.endReplaceGroup();
                        composer3.startReplaceGroup(-533459906);
                        rememberedValue2 = composer3.rememberedValue();
                        if (rememberedValue2 == companion.getEmpty()) {
                        }
                        composer3.endReplaceGroup();
                        TextBoxKt.m3414TextBoxNpQZenA(modifier2, str32, stringResource22, str52, z162, (Function0) rememberedValue2, false, z17, 0L, m3253getBrandBlack10d7_KjU3, m3253getBrandBlack10d7_KjU22, null, obj, composer3, (i11 & 14) | 196608 | ((i11 >> 6) & 57344), 0, 2368);
                        if (errorMessage == null) {
                        }
                        InputErrorTextKt.InputErrorText(columnScopeInstance2, z12, errorMessage, composer3, i12);
                        composer3.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        localDate10 = localDate9;
                        localDate11 = localDate142;
                        localDate12 = localDate152;
                        z13 = z162;
                        modifier3 = modifier2;
                        z14 = z10;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        localDate11 = localDate4;
                        z13 = z5;
                        z14 = z6;
                        localDate10 = localDate5;
                        localDate12 = localDate6;
                        composer3 = startRestartGroup;
                    }
                    ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2() { // from class: c2.g
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                Unit BirthdateInput$lambda$12;
                                BirthdateInput$lambda$12 = BirthdateInputKt.BirthdateInput$lambda$12(Modifier.this, localDate, localDate10, localDate12, localDate11, onBirthdateChange, z13, z14, validationKey, iFormValidator, i5, i6, (Composer) obj2, ((Integer) obj3).intValue());
                                return BirthdateInput$lambda$12;
                            }
                        });
                        return;
                    }
                    return;
                }
                i16 |= i13;
                if ((256 & i6) == 0) {
                }
                if ((i6 & 512) == 0) {
                }
                if ((306783379 & i16) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i15 == 0) {
                }
                if (i17 != 0) {
                }
                if ((i6 & 8) == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
            }
            if ((32 & i6) != 0) {
            }
            i9 = i6 & 64;
            if (i9 != 0) {
            }
            i10 = 128 & i6;
            if (i10 == 0) {
            }
            i16 |= i13;
            if ((256 & i6) == 0) {
            }
            if ((i6 & 512) == 0) {
            }
            if ((306783379 & i16) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i15 == 0) {
            }
            if (i17 != 0) {
            }
            if ((i6 & 8) == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
        }
        localDate5 = localDate2;
        if ((i5 & 3072) != 0) {
        }
        i8 = 16 & i6;
        if (i8 == 0) {
        }
        if ((32 & i6) != 0) {
        }
        i9 = i6 & 64;
        if (i9 != 0) {
        }
        i10 = 128 & i6;
        if (i10 == 0) {
        }
        i16 |= i13;
        if ((256 & i6) == 0) {
        }
        if ((i6 & 512) == 0) {
        }
        if ((306783379 & i16) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i15 == 0) {
        }
        if (i17 != 0) {
        }
        if ((i6 & 8) == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BirthdateInput$lambda$11$lambda$10$lambda$9(MutableState mutableState) {
        BirthdateInput$lambda$4(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BirthdateInput$lambda$12(Modifier modifier, LocalDate localDate, LocalDate localDate2, LocalDate localDate3, LocalDate localDate4, Function1 function1, boolean z5, boolean z6, IFormValidator.ValidationKey validationKey, IFormValidator iFormValidator, int i5, int i6, Composer composer, int i7) {
        BirthdateInput(modifier, localDate, localDate2, localDate3, localDate4, function1, z5, z6, validationKey, iFormValidator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    private static final boolean BirthdateInput$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BirthdateInput$lambda$4(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BirthdateInput$lambda$6$lambda$5(Function1 function1, MutableState mutableState, LocalDate it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        BirthdateInput$lambda$4(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BirthdateInput$lambda$8$lambda$7(MutableState mutableState) {
        BirthdateInput$lambda$4(mutableState, false);
        return Unit.INSTANCE;
    }
}
