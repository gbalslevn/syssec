package dk.molslinjen.ui.views.screens.developer.inputs;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.ui.views.reusable.input.PhoneNumberInputKt;
import dk.molslinjen.ui.views.reusable.input.SwitchRowKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.PhoneNumberInputValidator;
import dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputPhoneNumberFieldsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002\u001a+\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\b\u0010\t¨\u0006\f²\u0006\u000e\u0010\u0007\u001a\u00020\u00068\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000b\u001a\u00020\n8\n@\nX\u008a\u008e\u0002"}, d2 = {BuildConfig.FLAVOR, "DeveloperInputPhoneNumberFields", "(Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "countryCode", "nationalNumber", BuildConfig.FLAVOR, "enabled", "DevInput", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;II)V", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "phoneNumber", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeveloperInputPhoneNumberFieldsKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void DevInput(String str, String str2, final boolean z5, Composer composer, final int i5, final int i6) {
        String str3;
        int i7;
        String str4;
        String str5;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        Object rememberedValue3;
        Object rememberedValue4;
        Object rememberedValue5;
        String str6;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1048536565);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
            str3 = str;
        } else if ((i5 & 6) == 0) {
            str3 = str;
            i7 = (startRestartGroup.changed(str3) ? 4 : 2) | i5;
        } else {
            str3 = str;
            i7 = i5;
        }
        int i9 = i6 & 2;
        if (i9 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            str4 = str2;
            i7 |= startRestartGroup.changed(str4) ? 32 : 16;
            if ((i6 & 4) == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                i7 |= startRestartGroup.changed(z5) ? 256 : 128;
            }
            if ((i7 & 147) == 146 || !startRestartGroup.getSkipping()) {
                str5 = i8 == 0 ? BuildConfig.FLAVOR : str3;
                String str7 = i9 == 0 ? BuildConfig.FLAVOR : str4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1048536565, i7, -1, "dk.molslinjen.ui.views.screens.developer.inputs.DevInput (DeveloperInputPhoneNumberFields.kt:36)");
                }
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                    startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    rememberedValue = compositionScopedCoroutineScopeCanceller;
                }
                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                startRestartGroup.startReplaceGroup(1390973908);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new FormValidator(MapsKt.mapOf(TuplesKt.to(DevPhoneInputFields.CountryCode, PhoneNumberInputValidator.CountryCode.INSTANCE), TuplesKt.to(DevPhoneInputFields.NationalNumber, PhoneNumberInputValidator.NationalNumber.INSTANCE)), coroutineScope);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                FormValidator formValidator = (FormValidator) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1390983909);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new PhoneNumber(str5, str7), null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                final MutableState mutableState = (MutableState) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                PhoneNumber DevInput$lambda$9 = DevInput$lambda$9(mutableState);
                DevPhoneInputFields devPhoneInputFields = DevPhoneInputFields.NationalNumber;
                DevPhoneInputFields devPhoneInputFields2 = DevPhoneInputFields.CountryCode;
                startRestartGroup.startReplaceGroup(1390992357);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: m3.g0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit DevInput$lambda$12$lambda$11;
                            DevInput$lambda$12$lambda$11 = DeveloperInputPhoneNumberFieldsKt.DevInput$lambda$12$lambda$11(MutableState.this, (PhoneNumber) obj);
                            return DevInput$lambda$12$lambda$11;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                Function1 function1 = (Function1) rememberedValue4;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1391000787);
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: m3.h0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                startRestartGroup.endReplaceGroup();
                str6 = str7;
                PhoneNumberInputKt.PhoneNumberInput(null, DevInput$lambda$9, function1, (Function0) rememberedValue5, devPhoneInputFields, devPhoneInputFields2, formValidator, z5, startRestartGroup, ((i7 << 15) & 29360128) | 224640, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                str5 = str3;
                str6 = str4;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final String str8 = str5;
                final String str9 = str6;
                endRestartGroup.updateScope(new Function2() { // from class: m3.i0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit DevInput$lambda$15;
                        DevInput$lambda$15 = DeveloperInputPhoneNumberFieldsKt.DevInput$lambda$15(str8, str9, z5, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return DevInput$lambda$15;
                    }
                });
                return;
            }
            return;
        }
        str4 = str2;
        if ((i6 & 4) == 0) {
        }
        if ((i7 & 147) == 146) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        startRestartGroup.startReplaceGroup(1390973908);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        FormValidator formValidator2 = (FormValidator) rememberedValue2;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(1390983909);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        final MutableState mutableState2 = (MutableState) rememberedValue3;
        startRestartGroup.endReplaceGroup();
        PhoneNumber DevInput$lambda$92 = DevInput$lambda$9(mutableState2);
        DevPhoneInputFields devPhoneInputFields3 = DevPhoneInputFields.NationalNumber;
        DevPhoneInputFields devPhoneInputFields22 = DevPhoneInputFields.CountryCode;
        startRestartGroup.startReplaceGroup(1390992357);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
        }
        Function1 function12 = (Function1) rememberedValue4;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(1391000787);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (rememberedValue5 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        str6 = str7;
        PhoneNumberInputKt.PhoneNumberInput(null, DevInput$lambda$92, function12, (Function0) rememberedValue5, devPhoneInputFields3, devPhoneInputFields22, formValidator2, z5, startRestartGroup, ((i7 << 15) & 29360128) | 224640, 1);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DevInput$lambda$12$lambda$11(MutableState mutableState, PhoneNumber it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DevInput$lambda$15(String str, String str2, boolean z5, int i5, int i6, Composer composer, int i7) {
        DevInput(str, str2, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    private static final PhoneNumber DevInput$lambda$9(MutableState<PhoneNumber> mutableState) {
        return mutableState.getValue();
    }

    public static final void DeveloperInputPhoneNumberFields(Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(185146770);
        if (i5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(185146770, i5, -1, "dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputPhoneNumberFields (DeveloperInputPhoneNumberFields.kt:24)");
            }
            Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(16));
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m265spacedBy0680j_4, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
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
            startRestartGroup.startReplaceGroup(-106223980);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (rememberedValue == companion3.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            boolean DeveloperInputPhoneNumberFields$lambda$5$lambda$1 = DeveloperInputPhoneNumberFields$lambda$5$lambda$1(mutableState);
            startRestartGroup.startReplaceGroup(-106220317);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion3.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: m3.e0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DeveloperInputPhoneNumberFields$lambda$5$lambda$4$lambda$3;
                        DeveloperInputPhoneNumberFields$lambda$5$lambda$4$lambda$3 = DeveloperInputPhoneNumberFieldsKt.DeveloperInputPhoneNumberFields$lambda$5$lambda$4$lambda$3(MutableState.this, ((Boolean) obj).booleanValue());
                        return DeveloperInputPhoneNumberFields$lambda$5$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            SwitchRowKt.SwitchRow(null, "Disable fields", DeveloperInputPhoneNumberFields$lambda$5$lambda$1, (Function1) rememberedValue2, startRestartGroup, 3120, 1);
            DevInput(null, null, DeveloperInputPhoneNumberFields$lambda$5$lambda$1(mutableState), startRestartGroup, 0, 3);
            DevInput("+45", null, DeveloperInputPhoneNumberFields$lambda$5$lambda$1(mutableState), startRestartGroup, 6, 2);
            DevInput(null, "12345678", DeveloperInputPhoneNumberFields$lambda$5$lambda$1(mutableState), startRestartGroup, 48, 1);
            DevInput("+45", "12345678", DeveloperInputPhoneNumberFields$lambda$5$lambda$1(mutableState), startRestartGroup, 54, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m3.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeveloperInputPhoneNumberFields$lambda$6;
                    DeveloperInputPhoneNumberFields$lambda$6 = DeveloperInputPhoneNumberFieldsKt.DeveloperInputPhoneNumberFields$lambda$6(i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeveloperInputPhoneNumberFields$lambda$6;
                }
            });
        }
    }

    private static final boolean DeveloperInputPhoneNumberFields$lambda$5$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void DeveloperInputPhoneNumberFields$lambda$5$lambda$2(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputPhoneNumberFields$lambda$5$lambda$4$lambda$3(MutableState mutableState, boolean z5) {
        DeveloperInputPhoneNumberFields$lambda$5$lambda$2(mutableState, z5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputPhoneNumberFields$lambda$6(int i5, Composer composer, int i6) {
        DeveloperInputPhoneNumberFields(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
