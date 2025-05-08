package dk.molslinjen.ui.views.reusable.input.checkbox;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
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
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.extensions.domain.GenderExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.GenderPickerKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.reusable.input.validation.validators.NonNullCustomValidator;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001aW\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001aG\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Ldk/molslinjen/domain/model/account/Gender;", "selectedGender", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onGenderChange", BuildConfig.FLAVOR, "inputEnabled", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "validationKey", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "GenderPicker", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/account/Gender;Lkotlin/jvm/functions/Function1;ZLdk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Landroidx/compose/runtime/Composer;II)V", "gender", "enabled", "onGenderSelected", "showError", "GenderCheckBox", "(Ldk/molslinjen/domain/model/account/Gender;ZLdk/molslinjen/domain/model/account/Gender;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class GenderPickerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void GenderCheckBox(final Gender gender, final boolean z5, final Gender gender2, final Function1<? super Gender, Unit> function1, final boolean z6, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(282604020);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(gender) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(gender2) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(282604020, i6, -1, "dk.molslinjen.ui.views.reusable.input.checkbox.GenderCheckBox (GenderPicker.kt:79)");
            }
            String stringResource = StringResources_androidKt.stringResource(GenderExtensionsKt.getTitle(gender), startRestartGroup, 0);
            boolean z7 = gender == gender2;
            SelectionControlStyle selectionControlStyle = SelectionControlStyle.RadioButton;
            startRestartGroup.startReplaceGroup(2138425850);
            boolean z8 = ((i6 & 7168) == 2048) | ((i6 & 14) == 4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: d2.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit GenderCheckBox$lambda$5$lambda$4;
                        GenderCheckBox$lambda$5$lambda$4 = GenderPickerKt.GenderCheckBox$lambda$5$lambda$4(Function1.this, gender, ((Boolean) obj).booleanValue());
                        return GenderCheckBox$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            int i7 = i6 << 12;
            LabeledSelectionControlKt.LabeledSelectionControl(null, stringResource, z7, (Function1) rememberedValue, null, z5, null, selectionControlStyle, z6, startRestartGroup, (458752 & i7) | 12582912 | (i7 & 234881024), 81);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: d2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit GenderCheckBox$lambda$6;
                    GenderCheckBox$lambda$6 = GenderPickerKt.GenderCheckBox$lambda$6(Gender.this, z5, gender2, function1, z6, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return GenderCheckBox$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GenderCheckBox$lambda$5$lambda$4(Function1 function1, Gender gender, boolean z5) {
        if (!z5) {
            gender = null;
        }
        function1.invoke(gender);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GenderCheckBox$lambda$6(Gender gender, boolean z5, Gender gender2, Function1 function1, boolean z6, int i5, Composer composer, int i6) {
        GenderCheckBox(gender, z5, gender2, function1, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void GenderPicker(Modifier modifier, final Gender gender, final Function1<? super Gender, Unit> onGenderChange, boolean z5, final IFormValidator.ValidationKey validationKey, final IFormValidator iFormValidator, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        final boolean z6;
        final String errorMessage;
        Map map;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onGenderChange, "onGenderChange");
        Composer startRestartGroup = composer.startRestartGroup(-296202764);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(gender) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(onGenderChange) ? 256 : 128;
        }
        int i9 = i6 & 8;
        if (i9 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            z6 = z5;
            i7 |= startRestartGroup.changed(z6) ? 2048 : 1024;
            if ((i6 & 16) == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i7 |= (32768 & i5) == 0 ? startRestartGroup.changed(validationKey) : startRestartGroup.changedInstance(validationKey) ? 16384 : 8192;
            }
            if ((i6 & 32) == 0) {
                i7 |= 196608;
            } else if ((i5 & 196608) == 0) {
                i7 |= (262144 & i5) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 131072 : 65536;
            }
            if ((74899 & i7) == 74898 || !startRestartGroup.getSkipping()) {
                Modifier modifier4 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                if (i9 != 0) {
                    z6 = true;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-296202764, i7, -1, "dk.molslinjen.ui.views.reusable.input.checkbox.GenderPicker (GenderPicker.kt:34)");
                }
                if (validationKey != null && iFormValidator != null) {
                    iFormValidator.set(validationKey, NonNullCustomValidator.Gender.INSTANCE.validateInput(gender));
                }
                startRestartGroup.startReplaceGroup(1480692952);
                if (validationKey != null) {
                    errorMessage = null;
                } else {
                    StateFlow<Map<IFormValidator.ValidationKey, InputValidationError>> submittedErrors = iFormValidator != null ? iFormValidator.getSubmittedErrors() : null;
                    startRestartGroup.startReplaceGroup(1480694177);
                    State collectAsState = submittedErrors == null ? null : SnapshotStateKt.collectAsState(submittedErrors, null, startRestartGroup, 0, 1);
                    startRestartGroup.endReplaceGroup();
                    InputValidationError inputValidationError = (collectAsState == null || (map = (Map) collectAsState.getValue()) == null) ? null : (InputValidationError) map.get(validationKey);
                    startRestartGroup.startReplaceGroup(1480695705);
                    errorMessage = inputValidationError == null ? null : inputValidationError.toErrorMessage((Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), validationKey);
                    startRestartGroup.endReplaceGroup();
                }
                startRestartGroup.endReplaceGroup();
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Modifier.Companion companion2 = Modifier.INSTANCE;
                float f5 = 16;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.textField_label_gender, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 48, 1572864, 65532);
                composer2 = startRestartGroup;
                FlowLayoutKt.FlowRow(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(f5)), null, 0, 0, null, ComposableLambdaKt.rememberComposableLambda(360112441, true, new Function3<FlowRowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.checkbox.GenderPickerKt$GenderPicker$2$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(FlowRowScope flowRowScope, Composer composer3, Integer num) {
                        invoke(flowRowScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(FlowRowScope FlowRow, Composer composer3, int i10) {
                        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
                        if ((i10 & 17) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(360112441, i10, -1, "dk.molslinjen.ui.views.reusable.input.checkbox.GenderPicker.<anonymous>.<anonymous> (GenderPicker.kt:59)");
                        }
                        EnumEntries<Gender> entries = Gender.getEntries();
                        boolean z7 = z6;
                        Gender gender2 = gender;
                        Function1<Gender, Unit> function1 = onGenderChange;
                        String str = errorMessage;
                        Iterator<E> it = entries.iterator();
                        while (it.hasNext()) {
                            GenderPickerKt.GenderCheckBox((Gender) it.next(), z7, gender2, function1, str != null, composer3, 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), composer2, 1572918, 60);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                final boolean z7 = z6;
                endRestartGroup.updateScope(new Function2() { // from class: d2.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit GenderPicker$lambda$3;
                        GenderPicker$lambda$3 = GenderPickerKt.GenderPicker$lambda$3(Modifier.this, gender, onGenderChange, z7, validationKey, iFormValidator, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return GenderPicker$lambda$3;
                    }
                });
                return;
            }
            return;
        }
        z6 = z5;
        if ((i6 & 16) == 0) {
        }
        if ((i6 & 32) == 0) {
        }
        if ((74899 & i7) == 74898) {
        }
        if (i8 == 0) {
        }
        if (i9 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (validationKey != null) {
            iFormValidator.set(validationKey, NonNullCustomValidator.Gender.INSTANCE.validateInput(gender));
        }
        startRestartGroup.startReplaceGroup(1480692952);
        if (validationKey != null) {
        }
        startRestartGroup.endReplaceGroup();
        Arrangement arrangement2 = Arrangement.INSTANCE;
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement2.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion3.getSetModifier());
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        Modifier.Companion companion22 = Modifier.INSTANCE;
        float f52 = 16;
        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.textField_label_gender, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion22, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f52), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 48, 1572864, 65532);
        composer2 = startRestartGroup;
        FlowLayoutKt.FlowRow(SizeKt.fillMaxWidth$default(companion22, 0.0f, 1, null), arrangement2.m265spacedBy0680j_4(Dp.m2599constructorimpl(f52)), null, 0, 0, null, ComposableLambdaKt.rememberComposableLambda(360112441, true, new Function3<FlowRowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.checkbox.GenderPickerKt$GenderPicker$2$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(FlowRowScope flowRowScope, Composer composer3, Integer num) {
                invoke(flowRowScope, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(FlowRowScope FlowRow, Composer composer3, int i10) {
                Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
                if ((i10 & 17) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(360112441, i10, -1, "dk.molslinjen.ui.views.reusable.input.checkbox.GenderPicker.<anonymous>.<anonymous> (GenderPicker.kt:59)");
                }
                EnumEntries<Gender> entries = Gender.getEntries();
                boolean z72 = z6;
                Gender gender2 = gender;
                Function1<Gender, Unit> function1 = onGenderChange;
                String str = errorMessage;
                Iterator<E> it = entries.iterator();
                while (it.hasNext()) {
                    GenderPickerKt.GenderCheckBox((Gender) it.next(), z72, gender2, function1, str != null, composer3, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), composer2, 1572918, 60);
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GenderPicker$lambda$3(Modifier modifier, Gender gender, Function1 function1, boolean z5, IFormValidator.ValidationKey validationKey, IFormValidator iFormValidator, int i5, int i6, Composer composer, int i7) {
        GenderPicker(modifier, gender, function1, z5, validationKey, iFormValidator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
