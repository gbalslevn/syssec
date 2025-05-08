package dk.molslinjen.ui.views.reusable.input;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AutofillType;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.InputErrorTextKt;
import dk.molslinjen.ui.views.reusable.input.PhoneNumberInputKt;
import dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodePickerKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001ae\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "phoneNumber", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onPhoneNumberChange", "Lkotlin/Function0;", "showPhoneNumberCodeSelector", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "nationalNumberValidationKey", "countryCodeValidationKey", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", BuildConfig.FLAVOR, "enabled", "PhoneNumberInput", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/shared/PhoneNumber;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;ZLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PhoneNumberInputKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0279  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PhoneNumberInput(Modifier modifier, final PhoneNumber phoneNumber, final Function1<? super PhoneNumber, Unit> onPhoneNumberChange, final Function0<Unit> showPhoneNumberCodeSelector, final IFormValidator.ValidationKey nationalNumberValidationKey, final IFormValidator.ValidationKey countryCodeValidationKey, final IFormValidator validator, boolean z5, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        boolean z6;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        Modifier modifier3;
        Composer composer2;
        boolean changedInstance;
        Object rememberedValue;
        boolean changedInstance2;
        Object rememberedValue2;
        boolean changedInstance3;
        Object rememberedValue3;
        InputValidationError inputValidationError;
        String str;
        final boolean z7;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(onPhoneNumberChange, "onPhoneNumberChange");
        Intrinsics.checkNotNullParameter(showPhoneNumberCodeSelector, "showPhoneNumberCodeSelector");
        Intrinsics.checkNotNullParameter(nationalNumberValidationKey, "nationalNumberValidationKey");
        Intrinsics.checkNotNullParameter(countryCodeValidationKey, "countryCodeValidationKey");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Composer startRestartGroup = composer.startRestartGroup(-135315785);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i5 & 6) == 0) {
                i7 = i5 | (startRestartGroup.changed(modifier2) ? 4 : 2);
            } else {
                i7 = i5;
            }
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(phoneNumber) ? 32 : 16;
        }
        int i9 = i7;
        if ((4 & i6) != 0) {
            i9 |= 384;
        } else if ((i5 & 384) == 0) {
            i9 |= startRestartGroup.changedInstance(onPhoneNumberChange) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i9 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i9 |= startRestartGroup.changedInstance(showPhoneNumberCodeSelector) ? 2048 : 1024;
        }
        if ((i6 & 16) != 0) {
            i9 |= 24576;
        } else if ((i5 & 24576) == 0) {
            i9 |= (32768 & i5) == 0 ? startRestartGroup.changed(nationalNumberValidationKey) : startRestartGroup.changedInstance(nationalNumberValidationKey) ? 16384 : 8192;
        }
        if ((32 & i6) != 0) {
            i9 |= 196608;
        } else if ((i5 & 196608) == 0) {
            i9 |= (262144 & i5) == 0 ? startRestartGroup.changed(countryCodeValidationKey) : startRestartGroup.changedInstance(countryCodeValidationKey) ? 131072 : 65536;
        }
        if ((i6 & 64) != 0) {
            i9 |= 1572864;
        } else if ((i5 & 1572864) == 0) {
            i9 |= (2097152 & i5) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 1048576 : 524288;
        }
        int i10 = 128 & i6;
        if (i10 != 0) {
            i9 |= 12582912;
        } else if ((i5 & 12582912) == 0) {
            z6 = z5;
            i9 |= startRestartGroup.changed(z6) ? 8388608 : 4194304;
            if ((i9 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                Modifier modifier4 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                boolean z8 = i10 == 0 ? true : z6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-135315785, i9, -1, "dk.molslinjen.ui.views.reusable.input.PhoneNumberInput (PhoneNumberInput.kt:48)");
                }
                final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.Vertical top = arrangement.getTop();
                Alignment.Companion companion = Alignment.INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Modifier modifier5 = modifier4;
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
                String stringResource = StringResources_androidKt.stringResource(R.string.textField_label_phoneNumber, startRestartGroup, 6);
                TextStyle sub = TypographyKt.getSub();
                Modifier.Companion companion3 = Modifier.INSTANCE;
                TextKt.m940Text4IGK_g(stringResource, PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(8), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub, startRestartGroup, 48, 1572864, 65532);
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), startRestartGroup, 0);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor2);
                }
                m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                int i11 = i9 >> 3;
                int i12 = i9;
                modifier3 = modifier5;
                PhoneNumberCodePickerKt.PhoneNumberCodePicker(SizeKt.m338widthInVpY3zN4$default(IntrinsicKt.width(companion3, IntrinsicSize.Min), Dp.m2599constructorimpl(100), 0.0f, 2, null), phoneNumber, showPhoneNumberCodeSelector, z8, countryCodeValidationKey, validator, startRestartGroup, (i9 & 112) | 6 | (i11 & 896) | ((i9 >> 12) & 7168) | (57344 & i11) | (i11 & 458752), 0);
                composer2 = startRestartGroup;
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion3, Dp.m2599constructorimpl(16)), composer2, 6);
                composer2.startReplaceGroup(-434619200);
                changedInstance = composer2.changedInstance(phoneNumber);
                rememberedValue = composer2.rememberedValue();
                if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: c2.q
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit PhoneNumberInput$lambda$7$lambda$6$lambda$1$lambda$0;
                            PhoneNumberInput$lambda$7$lambda$6$lambda$1$lambda$0 = PhoneNumberInputKt.PhoneNumberInput$lambda$7$lambda$6$lambda$1$lambda$0(PhoneNumber.this, (SemanticsPropertyReceiver) obj);
                            return PhoneNumberInput$lambda$7$lambda$6$lambda$1$lambda$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                composer2.endReplaceGroup();
                Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion3, (Function1) rememberedValue);
                KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m2420getPhonePjHm6EE(), ImeAction.INSTANCE.m2385getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                String nationalNumber = phoneNumber.getNationalNumber();
                List listOf = CollectionsKt.listOf((Object[]) new AutofillType[]{AutofillType.PhoneNumberNational, AutofillType.PhoneNumberDevice, AutofillType.PhoneNumber});
                composer2.startReplaceGroup(-434608708);
                changedInstance2 = ((i12 & 896) != 256) | composer2.changedInstance(phoneNumber);
                rememberedValue2 = composer2.rememberedValue();
                if (!changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: c2.r
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit PhoneNumberInput$lambda$7$lambda$6$lambda$3$lambda$2;
                            PhoneNumberInput$lambda$7$lambda$6$lambda$3$lambda$2 = PhoneNumberInputKt.PhoneNumberInput$lambda$7$lambda$6$lambda$3$lambda$2(Function1.this, phoneNumber, (String) obj);
                            return PhoneNumberInput$lambda$7$lambda$6$lambda$3$lambda$2;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                }
                Function1 function1 = (Function1) rememberedValue2;
                composer2.endReplaceGroup();
                composer2.startReplaceGroup(-434597331);
                changedInstance3 = composer2.changedInstance(focusManager);
                rememberedValue3 = composer2.rememberedValue();
                if (!changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: c2.s
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit PhoneNumberInput$lambda$7$lambda$6$lambda$5$lambda$4;
                            PhoneNumberInput$lambda$7$lambda$6$lambda$5$lambda$4 = PhoneNumberInputKt.PhoneNumberInput$lambda$7$lambda$6$lambda$5$lambda$4(FocusManager.this);
                            return PhoneNumberInput$lambda$7$lambda$6$lambda$5$lambda$4;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue3);
                }
                composer2.endReplaceGroup();
                boolean z9 = false;
                StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(clearAndSetSemantics, false, 0.0f, listOf, null, null, null, function1, (Function0) rememberedValue3, nationalNumber, false, null, z8, false, 0, nationalNumberValidationKey, validator, keyboardOptions, null, null, 0L, null, false, 0, composer2, 27648, ((i12 >> 15) & 896) | 12582912 | ((i12 << 3) & 458752) | (i12 & 3670016), 384, 12348518);
                composer2.endNode();
                Map map = (Map) SnapshotStateKt.collectAsState(validator.getSubmittedErrors(), null, composer2, 0, 1).getValue();
                inputValidationError = (InputValidationError) map.get(countryCodeValidationKey);
                InputValidationError inputValidationError2 = (InputValidationError) map.get(nationalNumberValidationKey);
                if (inputValidationError == null) {
                    composer2.startReplaceGroup(-1305504647);
                    str = inputValidationError.toErrorMessage((Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext()), countryCodeValidationKey);
                    composer2.endReplaceGroup();
                } else if (inputValidationError2 != null) {
                    composer2.startReplaceGroup(-1305500612);
                    str = inputValidationError2.toErrorMessage((Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext()), nationalNumberValidationKey);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-1815729886);
                    composer2.endReplaceGroup();
                    str = null;
                }
                if (str != null) {
                    z9 = true;
                }
                InputErrorTextKt.InputErrorText(columnScopeInstance, z9, str, composer2, 6);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z7 = z8;
            } else {
                startRestartGroup.skipToGroupEnd();
                z7 = z6;
                composer2 = startRestartGroup;
                modifier3 = modifier2;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier6 = modifier3;
                endRestartGroup.updateScope(new Function2() { // from class: c2.t
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit PhoneNumberInput$lambda$8;
                        PhoneNumberInput$lambda$8 = PhoneNumberInputKt.PhoneNumberInput$lambda$8(Modifier.this, phoneNumber, onPhoneNumberChange, showPhoneNumberCodeSelector, nationalNumberValidationKey, countryCodeValidationKey, validator, z7, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return PhoneNumberInput$lambda$8;
                    }
                });
                return;
            }
            return;
        }
        z6 = z5;
        if ((i9 & 4793491) == 4793490) {
        }
        if (i8 == 0) {
        }
        if (i10 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        final FocusManager focusManager2 = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
        Arrangement arrangement2 = Arrangement.INSTANCE;
        Arrangement.Vertical top2 = arrangement2.getTop();
        Alignment.Companion companion4 = Alignment.INSTANCE;
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(top2, companion4.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
        Modifier modifier52 = modifier4;
        Function0<ComposeUiNode> constructor3 = companion22.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion22.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap3, companion22.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion22.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier3, companion22.getSetModifier());
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        String stringResource2 = StringResources_androidKt.stringResource(R.string.textField_label_phoneNumber, startRestartGroup, 6);
        TextStyle sub2 = TypographyKt.getSub();
        Modifier.Companion companion32 = Modifier.INSTANCE;
        TextKt.m940Text4IGK_g(stringResource2, PaddingKt.m315paddingqDBjuR0$default(companion32, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(8), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub2, startRestartGroup, 48, 1572864, 65532);
        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion32, 0.0f, 1, null);
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion4.getTop(), startRestartGroup, 0);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default2);
        Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion22.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion22.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion22.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion22.getSetModifier());
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        int i112 = i9 >> 3;
        int i122 = i9;
        modifier3 = modifier52;
        PhoneNumberCodePickerKt.PhoneNumberCodePicker(SizeKt.m338widthInVpY3zN4$default(IntrinsicKt.width(companion32, IntrinsicSize.Min), Dp.m2599constructorimpl(100), 0.0f, 2, null), phoneNumber, showPhoneNumberCodeSelector, z8, countryCodeValidationKey, validator, startRestartGroup, (i9 & 112) | 6 | (i112 & 896) | ((i9 >> 12) & 7168) | (57344 & i112) | (i112 & 458752), 0);
        composer2 = startRestartGroup;
        SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion32, Dp.m2599constructorimpl(16)), composer2, 6);
        composer2.startReplaceGroup(-434619200);
        changedInstance = composer2.changedInstance(phoneNumber);
        rememberedValue = composer2.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function1() { // from class: c2.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit PhoneNumberInput$lambda$7$lambda$6$lambda$1$lambda$0;
                PhoneNumberInput$lambda$7$lambda$6$lambda$1$lambda$0 = PhoneNumberInputKt.PhoneNumberInput$lambda$7$lambda$6$lambda$1$lambda$0(PhoneNumber.this, (SemanticsPropertyReceiver) obj);
                return PhoneNumberInput$lambda$7$lambda$6$lambda$1$lambda$0;
            }
        };
        composer2.updateRememberedValue(rememberedValue);
        composer2.endReplaceGroup();
        Modifier clearAndSetSemantics2 = SemanticsModifierKt.clearAndSetSemantics(companion32, (Function1) rememberedValue);
        KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m2420getPhonePjHm6EE(), ImeAction.INSTANCE.m2385getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
        String nationalNumber2 = phoneNumber.getNationalNumber();
        List listOf2 = CollectionsKt.listOf((Object[]) new AutofillType[]{AutofillType.PhoneNumberNational, AutofillType.PhoneNumberDevice, AutofillType.PhoneNumber});
        composer2.startReplaceGroup(-434608708);
        changedInstance2 = ((i122 & 896) != 256) | composer2.changedInstance(phoneNumber);
        rememberedValue2 = composer2.rememberedValue();
        if (!changedInstance2) {
        }
        rememberedValue2 = new Function1() { // from class: c2.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit PhoneNumberInput$lambda$7$lambda$6$lambda$3$lambda$2;
                PhoneNumberInput$lambda$7$lambda$6$lambda$3$lambda$2 = PhoneNumberInputKt.PhoneNumberInput$lambda$7$lambda$6$lambda$3$lambda$2(Function1.this, phoneNumber, (String) obj);
                return PhoneNumberInput$lambda$7$lambda$6$lambda$3$lambda$2;
            }
        };
        composer2.updateRememberedValue(rememberedValue2);
        Function1 function12 = (Function1) rememberedValue2;
        composer2.endReplaceGroup();
        composer2.startReplaceGroup(-434597331);
        changedInstance3 = composer2.changedInstance(focusManager2);
        rememberedValue3 = composer2.rememberedValue();
        if (!changedInstance3) {
        }
        rememberedValue3 = new Function0() { // from class: c2.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit PhoneNumberInput$lambda$7$lambda$6$lambda$5$lambda$4;
                PhoneNumberInput$lambda$7$lambda$6$lambda$5$lambda$4 = PhoneNumberInputKt.PhoneNumberInput$lambda$7$lambda$6$lambda$5$lambda$4(FocusManager.this);
                return PhoneNumberInput$lambda$7$lambda$6$lambda$5$lambda$4;
            }
        };
        composer2.updateRememberedValue(rememberedValue3);
        composer2.endReplaceGroup();
        boolean z92 = false;
        StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(clearAndSetSemantics2, false, 0.0f, listOf2, null, null, null, function12, (Function0) rememberedValue3, nationalNumber2, false, null, z8, false, 0, nationalNumberValidationKey, validator, keyboardOptions2, null, null, 0L, null, false, 0, composer2, 27648, ((i122 >> 15) & 896) | 12582912 | ((i122 << 3) & 458752) | (i122 & 3670016), 384, 12348518);
        composer2.endNode();
        Map map2 = (Map) SnapshotStateKt.collectAsState(validator.getSubmittedErrors(), null, composer2, 0, 1).getValue();
        inputValidationError = (InputValidationError) map2.get(countryCodeValidationKey);
        InputValidationError inputValidationError22 = (InputValidationError) map2.get(nationalNumberValidationKey);
        if (inputValidationError == null) {
        }
        if (str != null) {
        }
        InputErrorTextKt.InputErrorText(columnScopeInstance2, z92, str, composer2, 6);
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        z7 = z8;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PhoneNumberInput$lambda$7$lambda$6$lambda$1$lambda$0(PhoneNumber phoneNumber, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, CollectionsKt.joinToString$default(StringsKt.chunked(phoneNumber.getNationalNumber(), 2), " ", null, null, 0, null, null, 62, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PhoneNumberInput$lambda$7$lambda$6$lambda$3$lambda$2(Function1 function1, PhoneNumber phoneNumber, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(PhoneNumber.copy$default(phoneNumber, null, it, 1, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PhoneNumberInput$lambda$7$lambda$6$lambda$5$lambda$4(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1283getNextdhqQ8s());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PhoneNumberInput$lambda$8(Modifier modifier, PhoneNumber phoneNumber, Function1 function1, Function0 function0, IFormValidator.ValidationKey validationKey, IFormValidator.ValidationKey validationKey2, IFormValidator iFormValidator, boolean z5, int i5, int i6, Composer composer, int i7) {
        PhoneNumberInput(modifier, phoneNumber, function1, function0, validationKey, validationKey2, iFormValidator, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
