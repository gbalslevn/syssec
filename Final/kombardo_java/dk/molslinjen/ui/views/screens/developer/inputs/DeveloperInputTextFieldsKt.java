package dk.molslinjen.ui.views.screens.developer.inputs;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
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
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import defpackage.LicensePlateInputFieldKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.SwitchRowKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputTextFieldsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0012²\u0006\u000e\u0010\u0004\u001a\u00020\u00038\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0006\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0007\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\b\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\t\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\n\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000b\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\f\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\r\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000e\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000f\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0010\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0011\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002"}, d2 = {BuildConfig.FLAVOR, "DeveloperInputTextFields", "(Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "enabled", BuildConfig.FLAVOR, "defaultInput", "passwordInput", "noLabelInput", "defaultPlaceholderInput", "filledState", "initialBasicErrorInput", "noShowErrorInput", "additionalInfoInput", "additionNoShowErrorInput", "additionalWithErrorInput", "licensePlateInput", "multilineInput", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeveloperInputTextFieldsKt {
    public static final void DeveloperInputTextFields(Composer composer, final int i5) {
        Object obj;
        Object obj2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1981613012);
        if (i5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1981613012, i5, -1, "dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputTextFields (DeveloperInputTextFields.kt:24)");
            }
            final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.startReplaceGroup(-966370849);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new FormValidator(DeveloperInputFormField.INSTANCE.getValidators(), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            FormValidator formValidator = (FormValidator) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(24));
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m265spacedBy0680j_4, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
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
            startRestartGroup.startReplaceGroup(346350402);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            boolean DeveloperInputTextFields$lambda$98$lambda$2 = DeveloperInputTextFields$lambda$98$lambda$2(mutableState);
            startRestartGroup.startReplaceGroup(346354065);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: m3.j0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        Unit DeveloperInputTextFields$lambda$98$lambda$5$lambda$4;
                        DeveloperInputTextFields$lambda$98$lambda$5$lambda$4 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$5$lambda$4(MutableState.this, ((Boolean) obj3).booleanValue());
                        return DeveloperInputTextFields$lambda$98$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            SwitchRowKt.SwitchRow(null, "Disable fields", DeveloperInputTextFields$lambda$98$lambda$2, (Function1) rememberedValue4, startRestartGroup, 3120, 1);
            startRestartGroup.startReplaceGroup(346356192);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(BuildConfig.FLAVOR, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            KeyboardType.Companion companion4 = KeyboardType.INSTANCE;
            int m2421getTextPjHm6EE = companion4.m2421getTextPjHm6EE();
            ImeAction.Companion companion5 = ImeAction.INSTANCE;
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, m2421getTextPjHm6EE, companion5.m2385getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
            String DeveloperInputTextFields$lambda$98$lambda$7 = DeveloperInputTextFields$lambda$98$lambda$7(mutableState2);
            boolean DeveloperInputTextFields$lambda$98$lambda$22 = DeveloperInputTextFields$lambda$98$lambda$2(mutableState);
            List emptyList = CollectionsKt.emptyList();
            Integer valueOf = Integer.valueOf(R.string.ticketsScreen_title);
            startRestartGroup.startReplaceGroup(346360530);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new Function1() { // from class: m3.l0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        Unit DeveloperInputTextFields$lambda$98$lambda$10$lambda$9;
                        DeveloperInputTextFields$lambda$98$lambda$10$lambda$9 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$10$lambda$9(MutableState.this, (String) obj3);
                        return DeveloperInputTextFields$lambda$98$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            Function1 function1 = (Function1) rememberedValue6;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(346368076);
            boolean changedInstance = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = new Function0() { // from class: m3.x0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperInputTextFields$lambda$98$lambda$12$lambda$11;
                        DeveloperInputTextFields$lambda$98$lambda$12$lambda$11 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$12$lambda$11(FocusManager.this);
                        return DeveloperInputTextFields$lambda$98$lambda$12$lambda$11;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, emptyList, valueOf, null, null, function1, (Function0) rememberedValue7, DeveloperInputTextFields$lambda$98$lambda$7, false, null, DeveloperInputTextFields$lambda$98$lambda$22, false, 0, null, null, keyboardOptions, null, null, 0L, null, false, 0, startRestartGroup, 12610560, 12582912, 0, 16641127);
            startRestartGroup.startReplaceGroup(346375689);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("prefilled", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue8;
            startRestartGroup.endReplaceGroup();
            KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, companion4.m2419getPasswordPjHm6EE(), companion5.m2383getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
            String DeveloperInputTextFields$lambda$98$lambda$14 = DeveloperInputTextFields$lambda$98$lambda$14(mutableState3);
            List listOf = CollectionsKt.listOf(AutofillType.Password);
            String stringResource = StringResources_androidKt.stringResource(R.string.ticketsScreen_title, startRestartGroup, 6);
            DeveloperInputFormField developerInputFormField = DeveloperInputFormField.DevPassword;
            boolean DeveloperInputTextFields$lambda$98$lambda$23 = DeveloperInputTextFields$lambda$98$lambda$2(mutableState);
            Integer valueOf2 = Integer.valueOf(R.string.ticketsScreen_title);
            startRestartGroup.startReplaceGroup(346380279);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == companion.getEmpty()) {
                rememberedValue9 = new Function1() { // from class: m3.y0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        Unit DeveloperInputTextFields$lambda$98$lambda$17$lambda$16;
                        DeveloperInputTextFields$lambda$98$lambda$17$lambda$16 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$17$lambda$16(MutableState.this, (String) obj3);
                        return DeveloperInputTextFields$lambda$98$lambda$17$lambda$16;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            Function1 function12 = (Function1) rememberedValue9;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(346381982);
            boolean changedInstance2 = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue10 == companion.getEmpty()) {
                rememberedValue10 = new Function0() { // from class: m3.z0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperInputTextFields$lambda$98$lambda$19$lambda$18;
                        DeveloperInputTextFields$lambda$98$lambda$19$lambda$18 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$19$lambda$18(FocusManager.this);
                        return DeveloperInputTextFields$lambda$98$lambda$19$lambda$18;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, listOf, valueOf2, null, stringResource, function12, (Function0) rememberedValue10, DeveloperInputTextFields$lambda$98$lambda$14, true, null, DeveloperInputTextFields$lambda$98$lambda$23, false, 0, developerInputFormField, formValidator, keyboardOptions2, null, null, 0L, null, false, 0, startRestartGroup, 12610560, 12779526, 0, 16541735);
            boolean DeveloperInputTextFields$lambda$98$lambda$24 = DeveloperInputTextFields$lambda$98$lambda$2(mutableState);
            List emptyList2 = CollectionsKt.emptyList();
            Integer valueOf3 = Integer.valueOf(R.string.ticketsScreen_title);
            startRestartGroup.startReplaceGroup(346405507);
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (rememberedValue11 == companion.getEmpty()) {
                rememberedValue11 = new Function1() { // from class: m3.A0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        Unit DeveloperInputTextFields$lambda$98$lambda$21$lambda$20;
                        DeveloperInputTextFields$lambda$98$lambda$21$lambda$20 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$21$lambda$20((String) obj3);
                        return DeveloperInputTextFields$lambda$98$lambda$21$lambda$20;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            Function1 function13 = (Function1) rememberedValue11;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(346407491);
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (rememberedValue12 == companion.getEmpty()) {
                rememberedValue12 = new Function0() { // from class: m3.B0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, emptyList2, valueOf3, null, null, function13, (Function0) rememberedValue12, "ReadOnly - try to copy text", false, null, DeveloperInputTextFields$lambda$98$lambda$24, true, 0, null, null, null, null, null, 0L, null, false, 0, startRestartGroup, 918580224, 3072, 0, 16764007);
            List emptyList3 = CollectionsKt.emptyList();
            Integer valueOf4 = Integer.valueOf(R.string.ticketsScreen_title);
            startRestartGroup.startReplaceGroup(346415715);
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (rememberedValue13 == companion.getEmpty()) {
                rememberedValue13 = new Function1() { // from class: m3.C0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        Unit DeveloperInputTextFields$lambda$98$lambda$25$lambda$24;
                        DeveloperInputTextFields$lambda$98$lambda$25$lambda$24 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$25$lambda$24((String) obj3);
                        return DeveloperInputTextFields$lambda$98$lambda$25$lambda$24;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            Function1 function14 = (Function1) rememberedValue13;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(346417699);
            Object rememberedValue14 = startRestartGroup.rememberedValue();
            if (rememberedValue14 == companion.getEmpty()) {
                rememberedValue14 = new Function0() { // from class: m3.D0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue14);
            }
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, emptyList3, valueOf4, null, null, function14, (Function0) rememberedValue14, "Disabled - no interaction", false, null, false, false, 0, null, null, null, null, null, 0L, null, false, 0, startRestartGroup, 918580224, 384, 0, 16772199);
            startRestartGroup.startReplaceGroup(346422504);
            Object rememberedValue15 = startRestartGroup.rememberedValue();
            if (rememberedValue15 == companion.getEmpty()) {
                rememberedValue15 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("No label", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue15);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue15;
            startRestartGroup.endReplaceGroup();
            KeyboardOptions keyboardOptions3 = new KeyboardOptions(0, (Boolean) null, companion4.m2421getTextPjHm6EE(), companion5.m2385getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
            String DeveloperInputTextFields$lambda$98$lambda$29 = DeveloperInputTextFields$lambda$98$lambda$29(mutableState4);
            boolean DeveloperInputTextFields$lambda$98$lambda$25 = DeveloperInputTextFields$lambda$98$lambda$2(mutableState);
            List emptyList4 = CollectionsKt.emptyList();
            startRestartGroup.startReplaceGroup(346426322);
            Object rememberedValue16 = startRestartGroup.rememberedValue();
            if (rememberedValue16 == companion.getEmpty()) {
                rememberedValue16 = new Function1() { // from class: m3.E0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        Unit DeveloperInputTextFields$lambda$98$lambda$32$lambda$31;
                        DeveloperInputTextFields$lambda$98$lambda$32$lambda$31 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$32$lambda$31(MutableState.this, (String) obj3);
                        return DeveloperInputTextFields$lambda$98$lambda$32$lambda$31;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue16);
            }
            Function1 function15 = (Function1) rememberedValue16;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(346433868);
            boolean changedInstance3 = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue17 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue17 == companion.getEmpty()) {
                rememberedValue17 = new Function0() { // from class: m3.u0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperInputTextFields$lambda$98$lambda$34$lambda$33;
                        DeveloperInputTextFields$lambda$98$lambda$34$lambda$33 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$34$lambda$33(FocusManager.this);
                        return DeveloperInputTextFields$lambda$98$lambda$34$lambda$33;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue17);
            }
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, emptyList4, null, null, null, function15, (Function0) rememberedValue17, DeveloperInputTextFields$lambda$98$lambda$29, false, null, DeveloperInputTextFields$lambda$98$lambda$25, false, 0, null, null, keyboardOptions3, null, null, 0L, null, false, 0, startRestartGroup, 12610560, 12582912, 0, 16641127);
            startRestartGroup.startReplaceGroup(346442304);
            Object rememberedValue18 = startRestartGroup.rememberedValue();
            if (rememberedValue18 == companion.getEmpty()) {
                obj = BuildConfig.FLAVOR;
                rememberedValue18 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue18);
            } else {
                obj = BuildConfig.FLAVOR;
            }
            final MutableState mutableState5 = (MutableState) rememberedValue18;
            startRestartGroup.endReplaceGroup();
            KeyboardOptions keyboardOptions4 = new KeyboardOptions(0, (Boolean) null, companion4.m2421getTextPjHm6EE(), companion5.m2383getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
            String DeveloperInputTextFields$lambda$98$lambda$36 = DeveloperInputTextFields$lambda$98$lambda$36(mutableState5);
            boolean DeveloperInputTextFields$lambda$98$lambda$26 = DeveloperInputTextFields$lambda$98$lambda$2(mutableState);
            List emptyList5 = CollectionsKt.emptyList();
            Integer valueOf5 = Integer.valueOf(R.string.ticketsScreen_title);
            Integer valueOf6 = Integer.valueOf(R.string.departuresScreen_title);
            startRestartGroup.startReplaceGroup(346446625);
            Object rememberedValue19 = startRestartGroup.rememberedValue();
            if (rememberedValue19 == companion.getEmpty()) {
                rememberedValue19 = new Function1() { // from class: m3.F0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        Unit DeveloperInputTextFields$lambda$98$lambda$39$lambda$38;
                        DeveloperInputTextFields$lambda$98$lambda$39$lambda$38 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$39$lambda$38(MutableState.this, (String) obj3);
                        return DeveloperInputTextFields$lambda$98$lambda$39$lambda$38;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue19);
            }
            Function1 function16 = (Function1) rememberedValue19;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(346453626);
            boolean changedInstance4 = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue20 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue20 == companion.getEmpty()) {
                rememberedValue20 = new Function0() { // from class: m3.G0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperInputTextFields$lambda$98$lambda$41$lambda$40;
                        DeveloperInputTextFields$lambda$98$lambda$41$lambda$40 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$41$lambda$40(FocusManager.this);
                        return DeveloperInputTextFields$lambda$98$lambda$41$lambda$40;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue20);
            }
            startRestartGroup.endReplaceGroup();
            Object obj3 = obj;
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, emptyList5, valueOf5, valueOf6, null, function16, (Function0) rememberedValue20, DeveloperInputTextFields$lambda$98$lambda$36, false, null, DeveloperInputTextFields$lambda$98$lambda$26, false, 0, null, null, keyboardOptions4, null, null, 0L, null, false, 0, startRestartGroup, 12807168, 12582912, 0, 16641095);
            startRestartGroup.startReplaceGroup(346462806);
            Object rememberedValue21 = startRestartGroup.rememberedValue();
            if (rememberedValue21 == companion.getEmpty()) {
                rememberedValue21 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Filled unfocused style", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue21);
            }
            final MutableState mutableState6 = (MutableState) rememberedValue21;
            startRestartGroup.endReplaceGroup();
            String DeveloperInputTextFields$lambda$98$lambda$43 = DeveloperInputTextFields$lambda$98$lambda$43(mutableState6);
            boolean DeveloperInputTextFields$lambda$98$lambda$27 = DeveloperInputTextFields$lambda$98$lambda$2(mutableState);
            List emptyList6 = CollectionsKt.emptyList();
            Integer valueOf7 = Integer.valueOf(R.string.ticketsScreen_title);
            startRestartGroup.startReplaceGroup(346467797);
            Object rememberedValue22 = startRestartGroup.rememberedValue();
            if (rememberedValue22 == companion.getEmpty()) {
                rememberedValue22 = new Function1() { // from class: m3.H0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        Unit DeveloperInputTextFields$lambda$98$lambda$46$lambda$45;
                        DeveloperInputTextFields$lambda$98$lambda$46$lambda$45 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$46$lambda$45(MutableState.this, (String) obj4);
                        return DeveloperInputTextFields$lambda$98$lambda$46$lambda$45;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue22);
            }
            Function1 function17 = (Function1) rememberedValue22;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(346469484);
            boolean changedInstance5 = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue23 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue23 == companion.getEmpty()) {
                rememberedValue23 = new Function0() { // from class: m3.I0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperInputTextFields$lambda$98$lambda$48$lambda$47;
                        DeveloperInputTextFields$lambda$98$lambda$48$lambda$47 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$48$lambda$47(FocusManager.this);
                        return DeveloperInputTextFields$lambda$98$lambda$48$lambda$47;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue23);
            }
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, emptyList6, valueOf7, null, null, function17, (Function0) rememberedValue23, DeveloperInputTextFields$lambda$98$lambda$43, false, null, DeveloperInputTextFields$lambda$98$lambda$27, false, 0, null, null, null, null, null, 0L, null, false, 0, startRestartGroup, 12610560, 0, 0, 16772199);
            startRestartGroup.startReplaceGroup(346479061);
            Object rememberedValue24 = startRestartGroup.rememberedValue();
            if (rememberedValue24 == companion.getEmpty()) {
                rememberedValue24 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Should be email", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue24);
            }
            final MutableState mutableState7 = (MutableState) rememberedValue24;
            startRestartGroup.endReplaceGroup();
            String DeveloperInputTextFields$lambda$98$lambda$50 = DeveloperInputTextFields$lambda$98$lambda$50(mutableState7);
            DeveloperInputFormField developerInputFormField2 = DeveloperInputFormField.DevEmail;
            boolean DeveloperInputTextFields$lambda$98$lambda$28 = DeveloperInputTextFields$lambda$98$lambda$2(mutableState);
            List emptyList7 = CollectionsKt.emptyList();
            Integer valueOf8 = Integer.valueOf(R.string.ticketsScreen_title);
            startRestartGroup.startReplaceGroup(346484032);
            Object rememberedValue25 = startRestartGroup.rememberedValue();
            if (rememberedValue25 == companion.getEmpty()) {
                rememberedValue25 = new Function1() { // from class: m3.J0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        Unit DeveloperInputTextFields$lambda$98$lambda$53$lambda$52;
                        DeveloperInputTextFields$lambda$98$lambda$53$lambda$52 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$53$lambda$52(MutableState.this, (String) obj4);
                        return DeveloperInputTextFields$lambda$98$lambda$53$lambda$52;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue25);
            }
            Function1 function18 = (Function1) rememberedValue25;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(346486060);
            boolean changedInstance6 = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue26 = startRestartGroup.rememberedValue();
            if (changedInstance6 || rememberedValue26 == companion.getEmpty()) {
                rememberedValue26 = new Function0() { // from class: m3.K0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperInputTextFields$lambda$98$lambda$55$lambda$54;
                        DeveloperInputTextFields$lambda$98$lambda$55$lambda$54 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$55$lambda$54(FocusManager.this);
                        return DeveloperInputTextFields$lambda$98$lambda$55$lambda$54;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue26);
            }
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, emptyList7, valueOf8, null, null, function18, (Function0) rememberedValue26, DeveloperInputTextFields$lambda$98$lambda$50, false, null, DeveloperInputTextFields$lambda$98$lambda$28, false, 0, developerInputFormField2, formValidator, null, null, null, 0L, null, false, 0, startRestartGroup, 12610560, 196608, 0, 16673895);
            startRestartGroup.startReplaceGroup(346501334);
            Object rememberedValue27 = startRestartGroup.rememberedValue();
            if (rememberedValue27 == companion.getEmpty()) {
                rememberedValue27 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("This text is too long, should show error", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue27);
            }
            final MutableState mutableState8 = (MutableState) rememberedValue27;
            startRestartGroup.endReplaceGroup();
            String DeveloperInputTextFields$lambda$98$lambda$57 = DeveloperInputTextFields$lambda$98$lambda$57(mutableState8);
            DeveloperInputFormField developerInputFormField3 = DeveloperInputFormField.DevNoErrorText;
            boolean DeveloperInputTextFields$lambda$98$lambda$210 = DeveloperInputTextFields$lambda$98$lambda$2(mutableState);
            List emptyList8 = CollectionsKt.emptyList();
            Integer valueOf9 = Integer.valueOf(R.string.ticketsScreen_title);
            startRestartGroup.startReplaceGroup(346506330);
            Object rememberedValue28 = startRestartGroup.rememberedValue();
            if (rememberedValue28 == companion.getEmpty()) {
                rememberedValue28 = new Function1() { // from class: m3.L0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        Unit DeveloperInputTextFields$lambda$98$lambda$60$lambda$59;
                        DeveloperInputTextFields$lambda$98$lambda$60$lambda$59 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$60$lambda$59(MutableState.this, (String) obj4);
                        return DeveloperInputTextFields$lambda$98$lambda$60$lambda$59;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue28);
            }
            Function1 function19 = (Function1) rememberedValue28;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(346508172);
            boolean changedInstance7 = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue29 = startRestartGroup.rememberedValue();
            if (changedInstance7 || rememberedValue29 == companion.getEmpty()) {
                rememberedValue29 = new Function0() { // from class: m3.M0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperInputTextFields$lambda$98$lambda$62$lambda$61;
                        DeveloperInputTextFields$lambda$98$lambda$62$lambda$61 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$62$lambda$61(FocusManager.this);
                        return DeveloperInputTextFields$lambda$98$lambda$62$lambda$61;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue29);
            }
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, emptyList8, valueOf9, null, null, function19, (Function0) rememberedValue29, DeveloperInputTextFields$lambda$98$lambda$57, false, null, DeveloperInputTextFields$lambda$98$lambda$210, false, 0, developerInputFormField3, formValidator, null, null, null, 0L, null, false, 0, startRestartGroup, 12610560, 196608, 0, 16673895);
            startRestartGroup.startReplaceGroup(346519769);
            Object rememberedValue30 = startRestartGroup.rememberedValue();
            if (rememberedValue30 == companion.getEmpty()) {
                rememberedValue30 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Has additional info label", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue30);
            }
            final MutableState mutableState9 = (MutableState) rememberedValue30;
            startRestartGroup.endReplaceGroup();
            String DeveloperInputTextFields$lambda$98$lambda$64 = DeveloperInputTextFields$lambda$98$lambda$64(mutableState9);
            String stringResource2 = StringResources_androidKt.stringResource(R.string.forceUpdate_downloadInProgress, startRestartGroup, 6);
            boolean DeveloperInputTextFields$lambda$98$lambda$211 = DeveloperInputTextFields$lambda$98$lambda$2(mutableState);
            List emptyList9 = CollectionsKt.emptyList();
            Integer valueOf10 = Integer.valueOf(R.string.ticketsScreen_title);
            startRestartGroup.startReplaceGroup(346524861);
            Object rememberedValue31 = startRestartGroup.rememberedValue();
            if (rememberedValue31 == companion.getEmpty()) {
                rememberedValue31 = new Function1() { // from class: m3.k0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        Unit DeveloperInputTextFields$lambda$98$lambda$67$lambda$66;
                        DeveloperInputTextFields$lambda$98$lambda$67$lambda$66 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$67$lambda$66(MutableState.this, (String) obj4);
                        return DeveloperInputTextFields$lambda$98$lambda$67$lambda$66;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue31);
            }
            Function1 function110 = (Function1) rememberedValue31;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(346526796);
            boolean changedInstance8 = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue32 = startRestartGroup.rememberedValue();
            if (changedInstance8 || rememberedValue32 == companion.getEmpty()) {
                rememberedValue32 = new Function0() { // from class: m3.m0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperInputTextFields$lambda$98$lambda$69$lambda$68;
                        DeveloperInputTextFields$lambda$98$lambda$69$lambda$68 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$69$lambda$68(FocusManager.this);
                        return DeveloperInputTextFields$lambda$98$lambda$69$lambda$68;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue32);
            }
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, emptyList9, valueOf10, null, stringResource2, function110, (Function0) rememberedValue32, DeveloperInputTextFields$lambda$98$lambda$64, false, null, DeveloperInputTextFields$lambda$98$lambda$211, false, 0, null, null, null, null, null, 0L, null, false, 0, startRestartGroup, 12610560, 0, 0, 16772135);
            startRestartGroup.startReplaceGroup(346538637);
            Object rememberedValue33 = startRestartGroup.rememberedValue();
            if (rememberedValue33 == companion.getEmpty()) {
                rememberedValue33 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Additional info, No error, colored additional", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue33);
            }
            final MutableState mutableState10 = (MutableState) rememberedValue33;
            startRestartGroup.endReplaceGroup();
            String DeveloperInputTextFields$lambda$98$lambda$71 = DeveloperInputTextFields$lambda$98$lambda$71(mutableState10);
            String stringResource3 = StringResources_androidKt.stringResource(R.string.forceUpdate_downloadInProgress, startRestartGroup, 6);
            DeveloperInputFormField developerInputFormField4 = DeveloperInputFormField.DevErrorOnDescription;
            boolean DeveloperInputTextFields$lambda$98$lambda$212 = DeveloperInputTextFields$lambda$98$lambda$2(mutableState);
            List emptyList10 = CollectionsKt.emptyList();
            Integer valueOf11 = Integer.valueOf(R.string.ticketsScreen_title);
            startRestartGroup.startReplaceGroup(346544354);
            Object rememberedValue34 = startRestartGroup.rememberedValue();
            if (rememberedValue34 == companion.getEmpty()) {
                rememberedValue34 = new Function1() { // from class: m3.n0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        Unit DeveloperInputTextFields$lambda$98$lambda$74$lambda$73;
                        DeveloperInputTextFields$lambda$98$lambda$74$lambda$73 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$74$lambda$73(MutableState.this, (String) obj4);
                        return DeveloperInputTextFields$lambda$98$lambda$74$lambda$73;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue34);
            }
            Function1 function111 = (Function1) rememberedValue34;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(346546444);
            boolean changedInstance9 = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue35 = startRestartGroup.rememberedValue();
            if (changedInstance9 || rememberedValue35 == companion.getEmpty()) {
                rememberedValue35 = new Function0() { // from class: m3.o0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperInputTextFields$lambda$98$lambda$76$lambda$75;
                        DeveloperInputTextFields$lambda$98$lambda$76$lambda$75 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$76$lambda$75(FocusManager.this);
                        return DeveloperInputTextFields$lambda$98$lambda$76$lambda$75;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue35);
            }
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, emptyList10, valueOf11, null, stringResource3, function111, (Function0) rememberedValue35, DeveloperInputTextFields$lambda$98$lambda$71, false, null, DeveloperInputTextFields$lambda$98$lambda$212, false, 0, developerInputFormField4, formValidator, null, null, null, 0L, null, false, 0, startRestartGroup, 12610560, 196608, 384, 12479527);
            startRestartGroup.startReplaceGroup(346565527);
            Object rememberedValue36 = startRestartGroup.rememberedValue();
            if (rememberedValue36 == companion.getEmpty()) {
                rememberedValue36 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Additional info with error message", null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue36);
            }
            final MutableState mutableState11 = (MutableState) rememberedValue36;
            startRestartGroup.endReplaceGroup();
            String DeveloperInputTextFields$lambda$98$lambda$78 = DeveloperInputTextFields$lambda$98$lambda$78(mutableState11);
            String stringResource4 = StringResources_androidKt.stringResource(R.string.forceUpdate_downloadInProgress, startRestartGroup, 6);
            DeveloperInputFormField developerInputFormField5 = DeveloperInputFormField.DevErrorBelowDescription;
            boolean DeveloperInputTextFields$lambda$98$lambda$213 = DeveloperInputTextFields$lambda$98$lambda$2(mutableState);
            List emptyList11 = CollectionsKt.emptyList();
            Integer valueOf12 = Integer.valueOf(R.string.ticketsScreen_title);
            startRestartGroup.startReplaceGroup(346570562);
            Object rememberedValue37 = startRestartGroup.rememberedValue();
            if (rememberedValue37 == companion.getEmpty()) {
                rememberedValue37 = new Function1() { // from class: m3.p0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        Unit DeveloperInputTextFields$lambda$98$lambda$81$lambda$80;
                        DeveloperInputTextFields$lambda$98$lambda$81$lambda$80 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$81$lambda$80(MutableState.this, (String) obj4);
                        return DeveloperInputTextFields$lambda$98$lambda$81$lambda$80;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue37);
            }
            Function1 function112 = (Function1) rememberedValue37;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(346572652);
            boolean changedInstance10 = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue38 = startRestartGroup.rememberedValue();
            if (changedInstance10 || rememberedValue38 == companion.getEmpty()) {
                rememberedValue38 = new Function0() { // from class: m3.q0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperInputTextFields$lambda$98$lambda$83$lambda$82;
                        DeveloperInputTextFields$lambda$98$lambda$83$lambda$82 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$83$lambda$82(FocusManager.this);
                        return DeveloperInputTextFields$lambda$98$lambda$83$lambda$82;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue38);
            }
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, emptyList11, valueOf12, null, stringResource4, function112, (Function0) rememberedValue38, DeveloperInputTextFields$lambda$98$lambda$78, false, null, DeveloperInputTextFields$lambda$98$lambda$213, false, 0, developerInputFormField5, formValidator, null, null, null, 0L, null, false, 0, startRestartGroup, 12610560, 196608, 0, 16673831);
            startRestartGroup.startReplaceGroup(346587296);
            Object rememberedValue39 = startRestartGroup.rememberedValue();
            if (rememberedValue39 == companion.getEmpty()) {
                obj2 = obj3;
                rememberedValue39 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj2, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue39);
            } else {
                obj2 = obj3;
            }
            final MutableState mutableState12 = (MutableState) rememberedValue39;
            startRestartGroup.endReplaceGroup();
            String DeveloperInputTextFields$lambda$98$lambda$85 = DeveloperInputTextFields$lambda$98$lambda$85(mutableState12);
            boolean DeveloperInputTextFields$lambda$98$lambda$214 = DeveloperInputTextFields$lambda$98$lambda$2(mutableState);
            startRestartGroup.startReplaceGroup(346592475);
            Object rememberedValue40 = startRestartGroup.rememberedValue();
            if (rememberedValue40 == companion.getEmpty()) {
                rememberedValue40 = new Function1() { // from class: m3.r0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        Unit DeveloperInputTextFields$lambda$98$lambda$88$lambda$87;
                        DeveloperInputTextFields$lambda$98$lambda$88$lambda$87 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$88$lambda$87(MutableState.this, (String) obj4);
                        return DeveloperInputTextFields$lambda$98$lambda$88$lambda$87;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue40);
            }
            Function1 function113 = (Function1) rememberedValue40;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(346594386);
            boolean changedInstance11 = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue41 = startRestartGroup.rememberedValue();
            if (changedInstance11 || rememberedValue41 == companion.getEmpty()) {
                rememberedValue41 = new Function0() { // from class: m3.s0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperInputTextFields$lambda$98$lambda$90$lambda$89;
                        DeveloperInputTextFields$lambda$98$lambda$90$lambda$89 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$90$lambda$89(FocusManager.this);
                        return DeveloperInputTextFields$lambda$98$lambda$90$lambda$89;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue41);
            }
            startRestartGroup.endReplaceGroup();
            LicensePlateInputFieldKt.LicensePlateInputField(DeveloperInputTextFields$lambda$98$lambda$85, DeveloperInputTextFields$lambda$98$lambda$214, function113, (Function0) rememberedValue41, DeveloperInputFormField.DevLicensePlate, formValidator, startRestartGroup, 24960);
            Object obj4 = obj2;
            TextKt.m940Text4IGK_g("Growing Multiline", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 6, 0, 131070);
            startRestartGroup.startReplaceGroup(346604832);
            Object rememberedValue42 = startRestartGroup.rememberedValue();
            if (rememberedValue42 == companion.getEmpty()) {
                rememberedValue42 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj4, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue42);
            }
            final MutableState mutableState13 = (MutableState) rememberedValue42;
            startRestartGroup.endReplaceGroup();
            String DeveloperInputTextFields$lambda$98$lambda$92 = DeveloperInputTextFields$lambda$98$lambda$92(mutableState13);
            boolean DeveloperInputTextFields$lambda$98$lambda$215 = DeveloperInputTextFields$lambda$98$lambda$2(mutableState);
            List emptyList12 = CollectionsKt.emptyList();
            Integer valueOf13 = Integer.valueOf(R.string.ticketsScreen_title);
            startRestartGroup.startReplaceGroup(346609144);
            Object rememberedValue43 = startRestartGroup.rememberedValue();
            if (rememberedValue43 == companion.getEmpty()) {
                rememberedValue43 = new Function1() { // from class: m3.t0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj5) {
                        Unit DeveloperInputTextFields$lambda$98$lambda$95$lambda$94;
                        DeveloperInputTextFields$lambda$98$lambda$95$lambda$94 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$95$lambda$94(MutableState.this, (String) obj5);
                        return DeveloperInputTextFields$lambda$98$lambda$95$lambda$94;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue43);
            }
            Function1 function114 = (Function1) rememberedValue43;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(346610924);
            boolean changedInstance12 = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue44 = startRestartGroup.rememberedValue();
            if (changedInstance12 || rememberedValue44 == companion.getEmpty()) {
                rememberedValue44 = new Function0() { // from class: m3.v0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperInputTextFields$lambda$98$lambda$97$lambda$96;
                        DeveloperInputTextFields$lambda$98$lambda$97$lambda$96 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$98$lambda$97$lambda$96(FocusManager.this);
                        return DeveloperInputTextFields$lambda$98$lambda$97$lambda$96;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue44);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, emptyList12, valueOf13, null, null, function114, (Function0) rememberedValue44, DeveloperInputTextFields$lambda$98$lambda$92, false, null, DeveloperInputTextFields$lambda$98$lambda$215, false, 3, null, null, null, null, null, 0L, null, false, 0, composer2, 12610560, 24576, 0, 16755815);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m3.w0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj5, Object obj6) {
                    Unit DeveloperInputTextFields$lambda$99;
                    DeveloperInputTextFields$lambda$99 = DeveloperInputTextFieldsKt.DeveloperInputTextFields$lambda$99(i5, (Composer) obj5, ((Integer) obj6).intValue());
                    return DeveloperInputTextFields$lambda$99;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$10$lambda$9(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$12$lambda$11(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1279getDowndhqQ8s());
        return Unit.INSTANCE;
    }

    private static final String DeveloperInputTextFields$lambda$98$lambda$14(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$17$lambda$16(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$19$lambda$18(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    private static final boolean DeveloperInputTextFields$lambda$98$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$21$lambda$20(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$25$lambda$24(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    private static final String DeveloperInputTextFields$lambda$98$lambda$29(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final void DeveloperInputTextFields$lambda$98$lambda$3(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$32$lambda$31(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$34$lambda$33(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1279getDowndhqQ8s());
        return Unit.INSTANCE;
    }

    private static final String DeveloperInputTextFields$lambda$98$lambda$36(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$39$lambda$38(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$41$lambda$40(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    private static final String DeveloperInputTextFields$lambda$98$lambda$43(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$46$lambda$45(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$48$lambda$47(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1279getDowndhqQ8s());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$5$lambda$4(MutableState mutableState, boolean z5) {
        DeveloperInputTextFields$lambda$98$lambda$3(mutableState, z5);
        return Unit.INSTANCE;
    }

    private static final String DeveloperInputTextFields$lambda$98$lambda$50(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$53$lambda$52(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$55$lambda$54(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1279getDowndhqQ8s());
        return Unit.INSTANCE;
    }

    private static final String DeveloperInputTextFields$lambda$98$lambda$57(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$60$lambda$59(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$62$lambda$61(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1279getDowndhqQ8s());
        return Unit.INSTANCE;
    }

    private static final String DeveloperInputTextFields$lambda$98$lambda$64(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$67$lambda$66(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$69$lambda$68(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1279getDowndhqQ8s());
        return Unit.INSTANCE;
    }

    private static final String DeveloperInputTextFields$lambda$98$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String DeveloperInputTextFields$lambda$98$lambda$71(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$74$lambda$73(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$76$lambda$75(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1279getDowndhqQ8s());
        return Unit.INSTANCE;
    }

    private static final String DeveloperInputTextFields$lambda$98$lambda$78(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$81$lambda$80(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$83$lambda$82(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1279getDowndhqQ8s());
        return Unit.INSTANCE;
    }

    private static final String DeveloperInputTextFields$lambda$98$lambda$85(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$88$lambda$87(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$90$lambda$89(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1283getNextdhqQ8s());
        return Unit.INSTANCE;
    }

    private static final String DeveloperInputTextFields$lambda$98$lambda$92(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$95$lambda$94(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$98$lambda$97$lambda$96(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1279getDowndhqQ8s());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTextFields$lambda$99(int i5, Composer composer, int i6) {
        DeveloperInputTextFields(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
