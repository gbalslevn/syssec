package dk.molslinjen.ui.views.screens.developer.inputs;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.NumberSelectorHeight;
import dk.molslinjen.ui.views.reusable.input.NumberSelectorKt;
import dk.molslinjen.ui.views.reusable.input.PluralText;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlStyle;
import dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputTickersAndCheckboxesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a#\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u000f\u0010\u0006\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\b\u001a\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0003¢\u0006\u0004\b\b\u0010\u0005¨\u0006\u0016²\u0006\u000e\u0010\n\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000b\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\f\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\r\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000e\u001a\u00020\t8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0010\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0011\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0012\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0013\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0014\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0015\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0010\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0011\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0012\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0013\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0014\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u0015\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lkotlin/Function1;", "Ldk/molslinjen/core/snackbar/SnackbarEvent;", BuildConfig.FLAVOR, "showSnackbar", "DeveloperInputTickersAndCheckboxes", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Tickers", "(Landroidx/compose/runtime/Composer;I)V", "Checkboxes", BuildConfig.FLAVOR, "numberSelectorBase", "numberSelectorCustomHeight", "numberSelectorBaseFullWidth", "numberSelectorCustomHeightFullWidth", "noTextTicker", BuildConfig.FLAVOR, "regularCheck", "regularCheckError", "regularChecked", "disabledCheck", "disabledWithDisabledClickCheck", "disabledPreChecked", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeveloperInputTickersAndCheckboxesKt {
    private static final void Checkboxes(final Function1<? super SnackbarEvent, Unit> function1, Composer composer, final int i5) {
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-4451913);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function1) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-4451913, i6, -1, "dk.molslinjen.ui.views.screens.developer.inputs.Checkboxes (DeveloperInputTickersAndCheckboxes.kt:93)");
            }
            Arrangement arrangement = Arrangement.INSTANCE;
            float f5 = 16;
            Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(f5));
            Modifier.Companion companion = Modifier.INSTANCE;
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m265spacedBy0680j_4, companion2.getTop(), startRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-935247442);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue == companion4.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            boolean Checkboxes$lambda$69$lambda$38 = Checkboxes$lambda$69$lambda$38(mutableState);
            startRestartGroup.startReplaceGroup(-935243380);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion4.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: m3.Y0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Checkboxes$lambda$69$lambda$41$lambda$40;
                        Checkboxes$lambda$69$lambda$41$lambda$40 = DeveloperInputTickersAndCheckboxesKt.Checkboxes$lambda$69$lambda$41$lambda$40(MutableState.this, ((Boolean) obj).booleanValue());
                        return Checkboxes$lambda$69$lambda$41$lambda$40;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            SelectionControlStyle selectionControlStyle = SelectionControlStyle.Checkbox;
            int i8 = i6;
            SelectionControlKt.SelectionControl(null, Checkboxes$lambda$69$lambda$38, (Function1) rememberedValue2, null, false, null, selectionControlStyle, false, startRestartGroup, 1573248, 185);
            startRestartGroup.startReplaceGroup(-935239250);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion4.getEmpty()) {
                i7 = 2;
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            } else {
                i7 = 2;
            }
            final MutableState mutableState2 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            boolean Checkboxes$lambda$69$lambda$43 = Checkboxes$lambda$69$lambda$43(mutableState2);
            boolean z5 = !Checkboxes$lambda$69$lambda$43(mutableState2);
            startRestartGroup.startReplaceGroup(-935234990);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion4.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: m3.l1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Checkboxes$lambda$69$lambda$46$lambda$45;
                        Checkboxes$lambda$69$lambda$46$lambda$45 = DeveloperInputTickersAndCheckboxesKt.Checkboxes$lambda$69$lambda$46$lambda$45(MutableState.this, ((Boolean) obj).booleanValue());
                        return Checkboxes$lambda$69$lambda$46$lambda$45;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            int i9 = i7;
            SelectionControlKt.SelectionControl(null, Checkboxes$lambda$69$lambda$43, (Function1) rememberedValue4, null, false, null, selectionControlStyle, z5, startRestartGroup, 1573248, 57);
            startRestartGroup.startReplaceGroup(-935228371);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion4.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, i9, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            boolean Checkboxes$lambda$69$lambda$48 = Checkboxes$lambda$69$lambda$48(mutableState3);
            startRestartGroup.startReplaceGroup(-935224272);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == companion4.getEmpty()) {
                rememberedValue6 = new Function1() { // from class: m3.m1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Checkboxes$lambda$69$lambda$51$lambda$50;
                        Checkboxes$lambda$69$lambda$51$lambda$50 = DeveloperInputTickersAndCheckboxesKt.Checkboxes$lambda$69$lambda$51$lambda$50(MutableState.this, ((Boolean) obj).booleanValue());
                        return Checkboxes$lambda$69$lambda$51$lambda$50;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            SelectionControlKt.SelectionControl(null, Checkboxes$lambda$69$lambda$48, (Function1) rememberedValue6, null, false, null, selectionControlStyle, false, startRestartGroup, 1573248, 185);
            startRestartGroup.startReplaceGroup(-935220146);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == companion4.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i9, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue7;
            startRestartGroup.endReplaceGroup();
            boolean Checkboxes$lambda$69$lambda$53 = Checkboxes$lambda$69$lambda$53(mutableState4);
            startRestartGroup.startReplaceGroup(-935216050);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == companion4.getEmpty()) {
                rememberedValue8 = new Function1() { // from class: m3.n1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Checkboxes$lambda$69$lambda$56$lambda$55;
                        Checkboxes$lambda$69$lambda$56$lambda$55 = DeveloperInputTickersAndCheckboxesKt.Checkboxes$lambda$69$lambda$56$lambda$55(MutableState.this, ((Boolean) obj).booleanValue());
                        return Checkboxes$lambda$69$lambda$56$lambda$55;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            startRestartGroup.endReplaceGroup();
            SelectionControlKt.SelectionControl(null, Checkboxes$lambda$69$lambda$53, (Function1) rememberedValue8, null, false, null, selectionControlStyle, false, startRestartGroup, 1597824, 169);
            startRestartGroup.startReplaceGroup(-935210514);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == companion4.getEmpty()) {
                rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i9, null);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue9;
            startRestartGroup.endReplaceGroup();
            boolean Checkboxes$lambda$69$lambda$58 = Checkboxes$lambda$69$lambda$58(mutableState5);
            startRestartGroup.startReplaceGroup(-935205840);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (rememberedValue10 == companion4.getEmpty()) {
                rememberedValue10 = new Function1() { // from class: m3.O0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Checkboxes$lambda$69$lambda$61$lambda$60;
                        Checkboxes$lambda$69$lambda$61$lambda$60 = DeveloperInputTickersAndCheckboxesKt.Checkboxes$lambda$69$lambda$61$lambda$60(MutableState.this, ((Boolean) obj).booleanValue());
                        return Checkboxes$lambda$69$lambda$61$lambda$60;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            Function1 function12 = (Function1) rememberedValue10;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-935201661);
            int i10 = i8 & 14;
            boolean z6 = i10 == 4;
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue11 == companion4.getEmpty()) {
                rememberedValue11 = new Function0() { // from class: m3.P0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit Checkboxes$lambda$69$lambda$63$lambda$62;
                        Checkboxes$lambda$69$lambda$63$lambda$62 = DeveloperInputTickersAndCheckboxesKt.Checkboxes$lambda$69$lambda$63$lambda$62(Function1.this);
                        return Checkboxes$lambda$69$lambda$63$lambda$62;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            startRestartGroup.endReplaceGroup();
            SelectionControlKt.SelectionControl(null, Checkboxes$lambda$69$lambda$58, function12, (Function0) rememberedValue11, false, null, selectionControlStyle, false, startRestartGroup, 1597824, 161);
            startRestartGroup.startReplaceGroup(-935194803);
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (rememberedValue12 == companion4.getEmpty()) {
                rememberedValue12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, i9, null);
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            final MutableState mutableState6 = (MutableState) rememberedValue12;
            startRestartGroup.endReplaceGroup();
            boolean Checkboxes$lambda$69$lambda$65 = Checkboxes$lambda$69$lambda$65(mutableState6);
            startRestartGroup.startReplaceGroup(-935190568);
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (rememberedValue13 == companion4.getEmpty()) {
                rememberedValue13 = new Function1() { // from class: m3.Q0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Checkboxes$lambda$69$lambda$68$lambda$67;
                        Checkboxes$lambda$69$lambda$68$lambda$67 = DeveloperInputTickersAndCheckboxesKt.Checkboxes$lambda$69$lambda$68$lambda$67(MutableState.this, ((Boolean) obj).booleanValue());
                        return Checkboxes$lambda$69$lambda$68$lambda$67;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            startRestartGroup.endReplaceGroup();
            SelectionControlKt.SelectionControl(null, Checkboxes$lambda$69$lambda$65, (Function1) rememberedValue13, null, false, null, selectionControlStyle, false, startRestartGroup, 1597824, 169);
            startRestartGroup.endNode();
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(24), 0.0f, 0.0f, 13, null);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(f5)), companion2.getTop(), startRestartGroup, 6);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            startRestartGroup.startReplaceGroup(-935181042);
            Object rememberedValue14 = startRestartGroup.rememberedValue();
            if (rememberedValue14 == companion4.getEmpty()) {
                rememberedValue14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i9, null);
                startRestartGroup.updateRememberedValue(rememberedValue14);
            }
            final MutableState mutableState7 = (MutableState) rememberedValue14;
            startRestartGroup.endReplaceGroup();
            boolean Checkboxes$lambda$102$lambda$71 = Checkboxes$lambda$102$lambda$71(mutableState7);
            startRestartGroup.startReplaceGroup(-935177760);
            Object rememberedValue15 = startRestartGroup.rememberedValue();
            if (rememberedValue15 == companion4.getEmpty()) {
                rememberedValue15 = new Function1() { // from class: m3.R0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Checkboxes$lambda$102$lambda$74$lambda$73;
                        Checkboxes$lambda$102$lambda$74$lambda$73 = DeveloperInputTickersAndCheckboxesKt.Checkboxes$lambda$102$lambda$74$lambda$73(MutableState.this, ((Boolean) obj).booleanValue());
                        return Checkboxes$lambda$102$lambda$74$lambda$73;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue15);
            }
            startRestartGroup.endReplaceGroup();
            SelectionControlStyle selectionControlStyle2 = SelectionControlStyle.RadioButton;
            SelectionControlKt.SelectionControl(null, Checkboxes$lambda$102$lambda$71, (Function1) rememberedValue15, null, false, null, selectionControlStyle2, false, startRestartGroup, 1573248, 185);
            startRestartGroup.startReplaceGroup(-935173586);
            Object rememberedValue16 = startRestartGroup.rememberedValue();
            if (rememberedValue16 == companion4.getEmpty()) {
                rememberedValue16 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i9, null);
                startRestartGroup.updateRememberedValue(rememberedValue16);
            }
            final MutableState mutableState8 = (MutableState) rememberedValue16;
            startRestartGroup.endReplaceGroup();
            boolean Checkboxes$lambda$102$lambda$76 = Checkboxes$lambda$102$lambda$76(mutableState8);
            startRestartGroup.startReplaceGroup(-935169354);
            Object rememberedValue17 = startRestartGroup.rememberedValue();
            if (rememberedValue17 == companion4.getEmpty()) {
                rememberedValue17 = new Function1() { // from class: m3.S0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Checkboxes$lambda$102$lambda$79$lambda$78;
                        Checkboxes$lambda$102$lambda$79$lambda$78 = DeveloperInputTickersAndCheckboxesKt.Checkboxes$lambda$102$lambda$79$lambda$78(MutableState.this, ((Boolean) obj).booleanValue());
                        return Checkboxes$lambda$102$lambda$79$lambda$78;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue17);
            }
            startRestartGroup.endReplaceGroup();
            SelectionControlKt.SelectionControl(null, Checkboxes$lambda$102$lambda$76, (Function1) rememberedValue17, null, false, null, selectionControlStyle2, !Checkboxes$lambda$102$lambda$76(mutableState8), startRestartGroup, 1573248, 57);
            startRestartGroup.startReplaceGroup(-935163507);
            Object rememberedValue18 = startRestartGroup.rememberedValue();
            if (rememberedValue18 == companion4.getEmpty()) {
                rememberedValue18 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, i9, null);
                startRestartGroup.updateRememberedValue(rememberedValue18);
            }
            final MutableState mutableState9 = (MutableState) rememberedValue18;
            startRestartGroup.endReplaceGroup();
            boolean Checkboxes$lambda$102$lambda$81 = Checkboxes$lambda$102$lambda$81(mutableState9);
            startRestartGroup.startReplaceGroup(-935160188);
            Object rememberedValue19 = startRestartGroup.rememberedValue();
            if (rememberedValue19 == companion4.getEmpty()) {
                rememberedValue19 = new Function1() { // from class: m3.T0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Checkboxes$lambda$102$lambda$84$lambda$83;
                        Checkboxes$lambda$102$lambda$84$lambda$83 = DeveloperInputTickersAndCheckboxesKt.Checkboxes$lambda$102$lambda$84$lambda$83(MutableState.this, ((Boolean) obj).booleanValue());
                        return Checkboxes$lambda$102$lambda$84$lambda$83;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue19);
            }
            startRestartGroup.endReplaceGroup();
            SelectionControlKt.SelectionControl(null, Checkboxes$lambda$102$lambda$81, (Function1) rememberedValue19, null, false, null, selectionControlStyle2, false, startRestartGroup, 1573248, 185);
            startRestartGroup.startReplaceGroup(-935156018);
            Object rememberedValue20 = startRestartGroup.rememberedValue();
            if (rememberedValue20 == companion4.getEmpty()) {
                rememberedValue20 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i9, null);
                startRestartGroup.updateRememberedValue(rememberedValue20);
            }
            final MutableState mutableState10 = (MutableState) rememberedValue20;
            startRestartGroup.endReplaceGroup();
            boolean Checkboxes$lambda$102$lambda$86 = Checkboxes$lambda$102$lambda$86(mutableState10);
            startRestartGroup.startReplaceGroup(-935151922);
            Object rememberedValue21 = startRestartGroup.rememberedValue();
            if (rememberedValue21 == companion4.getEmpty()) {
                rememberedValue21 = new Function1() { // from class: m3.g1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Checkboxes$lambda$102$lambda$89$lambda$88;
                        Checkboxes$lambda$102$lambda$89$lambda$88 = DeveloperInputTickersAndCheckboxesKt.Checkboxes$lambda$102$lambda$89$lambda$88(MutableState.this, ((Boolean) obj).booleanValue());
                        return Checkboxes$lambda$102$lambda$89$lambda$88;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue21);
            }
            startRestartGroup.endReplaceGroup();
            SelectionControlKt.SelectionControl(null, Checkboxes$lambda$102$lambda$86, (Function1) rememberedValue21, null, false, null, selectionControlStyle2, false, startRestartGroup, 1597824, 169);
            startRestartGroup.startReplaceGroup(-935146290);
            Object rememberedValue22 = startRestartGroup.rememberedValue();
            if (rememberedValue22 == companion4.getEmpty()) {
                rememberedValue22 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i9, null);
                startRestartGroup.updateRememberedValue(rememberedValue22);
            }
            final MutableState mutableState11 = (MutableState) rememberedValue22;
            startRestartGroup.endReplaceGroup();
            boolean Checkboxes$lambda$102$lambda$91 = Checkboxes$lambda$102$lambda$91(mutableState11);
            startRestartGroup.startReplaceGroup(-935141616);
            Object rememberedValue23 = startRestartGroup.rememberedValue();
            if (rememberedValue23 == companion4.getEmpty()) {
                rememberedValue23 = new Function1() { // from class: m3.h1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Checkboxes$lambda$102$lambda$94$lambda$93;
                        Checkboxes$lambda$102$lambda$94$lambda$93 = DeveloperInputTickersAndCheckboxesKt.Checkboxes$lambda$102$lambda$94$lambda$93(MutableState.this, ((Boolean) obj).booleanValue());
                        return Checkboxes$lambda$102$lambda$94$lambda$93;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue23);
            }
            Function1 function13 = (Function1) rememberedValue23;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-935135651);
            boolean z7 = i10 == 4;
            Object rememberedValue24 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue24 == companion4.getEmpty()) {
                rememberedValue24 = new Function0() { // from class: m3.i1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit Checkboxes$lambda$102$lambda$96$lambda$95;
                        Checkboxes$lambda$102$lambda$96$lambda$95 = DeveloperInputTickersAndCheckboxesKt.Checkboxes$lambda$102$lambda$96$lambda$95(Function1.this);
                        return Checkboxes$lambda$102$lambda$96$lambda$95;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue24);
            }
            startRestartGroup.endReplaceGroup();
            SelectionControlKt.SelectionControl(null, Checkboxes$lambda$102$lambda$91, function13, (Function0) rememberedValue24, false, null, selectionControlStyle2, false, startRestartGroup, 1597824, 161);
            startRestartGroup.startReplaceGroup(-935129651);
            Object rememberedValue25 = startRestartGroup.rememberedValue();
            if (rememberedValue25 == companion4.getEmpty()) {
                rememberedValue25 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, i9, null);
                startRestartGroup.updateRememberedValue(rememberedValue25);
            }
            final MutableState mutableState12 = (MutableState) rememberedValue25;
            startRestartGroup.endReplaceGroup();
            boolean Checkboxes$lambda$102$lambda$98 = Checkboxes$lambda$102$lambda$98(mutableState12);
            startRestartGroup.startReplaceGroup(-935125416);
            Object rememberedValue26 = startRestartGroup.rememberedValue();
            if (rememberedValue26 == companion4.getEmpty()) {
                rememberedValue26 = new Function1() { // from class: m3.j1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Checkboxes$lambda$102$lambda$101$lambda$100;
                        Checkboxes$lambda$102$lambda$101$lambda$100 = DeveloperInputTickersAndCheckboxesKt.Checkboxes$lambda$102$lambda$101$lambda$100(MutableState.this, ((Boolean) obj).booleanValue());
                        return Checkboxes$lambda$102$lambda$101$lambda$100;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue26);
            }
            startRestartGroup.endReplaceGroup();
            SelectionControlKt.SelectionControl(null, Checkboxes$lambda$102$lambda$98, (Function1) rememberedValue26, null, false, null, selectionControlStyle2, false, startRestartGroup, 1597824, 169);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m3.k1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Checkboxes$lambda$103;
                    Checkboxes$lambda$103 = DeveloperInputTickersAndCheckboxesKt.Checkboxes$lambda$103(Function1.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Checkboxes$lambda$103;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkboxes$lambda$102$lambda$101$lambda$100(MutableState mutableState, boolean z5) {
        Checkboxes$lambda$102$lambda$99(mutableState, !Checkboxes$lambda$102$lambda$98(mutableState));
        return Unit.INSTANCE;
    }

    private static final boolean Checkboxes$lambda$102$lambda$71(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Checkboxes$lambda$102$lambda$72(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkboxes$lambda$102$lambda$74$lambda$73(MutableState mutableState, boolean z5) {
        Checkboxes$lambda$102$lambda$72(mutableState, !Checkboxes$lambda$102$lambda$71(mutableState));
        return Unit.INSTANCE;
    }

    private static final boolean Checkboxes$lambda$102$lambda$76(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Checkboxes$lambda$102$lambda$77(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkboxes$lambda$102$lambda$79$lambda$78(MutableState mutableState, boolean z5) {
        Checkboxes$lambda$102$lambda$77(mutableState, !Checkboxes$lambda$102$lambda$76(mutableState));
        return Unit.INSTANCE;
    }

    private static final boolean Checkboxes$lambda$102$lambda$81(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Checkboxes$lambda$102$lambda$82(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkboxes$lambda$102$lambda$84$lambda$83(MutableState mutableState, boolean z5) {
        Checkboxes$lambda$102$lambda$82(mutableState, !Checkboxes$lambda$102$lambda$81(mutableState));
        return Unit.INSTANCE;
    }

    private static final boolean Checkboxes$lambda$102$lambda$86(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Checkboxes$lambda$102$lambda$87(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkboxes$lambda$102$lambda$89$lambda$88(MutableState mutableState, boolean z5) {
        Checkboxes$lambda$102$lambda$87(mutableState, !Checkboxes$lambda$102$lambda$86(mutableState));
        return Unit.INSTANCE;
    }

    private static final boolean Checkboxes$lambda$102$lambda$91(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Checkboxes$lambda$102$lambda$92(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkboxes$lambda$102$lambda$94$lambda$93(MutableState mutableState, boolean z5) {
        Checkboxes$lambda$102$lambda$92(mutableState, !Checkboxes$lambda$102$lambda$91(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkboxes$lambda$102$lambda$96$lambda$95(Function1 function1) {
        function1.invoke(new SnackbarEvent.Error(new SnackbarText.StringText("Clicked a disabled button, with a disabled callback")));
        return Unit.INSTANCE;
    }

    private static final boolean Checkboxes$lambda$102$lambda$98(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Checkboxes$lambda$102$lambda$99(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkboxes$lambda$103(Function1 function1, int i5, Composer composer, int i6) {
        Checkboxes(function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final boolean Checkboxes$lambda$69$lambda$38(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Checkboxes$lambda$69$lambda$39(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkboxes$lambda$69$lambda$41$lambda$40(MutableState mutableState, boolean z5) {
        Checkboxes$lambda$69$lambda$39(mutableState, !Checkboxes$lambda$69$lambda$38(mutableState));
        return Unit.INSTANCE;
    }

    private static final boolean Checkboxes$lambda$69$lambda$43(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Checkboxes$lambda$69$lambda$44(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkboxes$lambda$69$lambda$46$lambda$45(MutableState mutableState, boolean z5) {
        Checkboxes$lambda$69$lambda$44(mutableState, !Checkboxes$lambda$69$lambda$43(mutableState));
        return Unit.INSTANCE;
    }

    private static final boolean Checkboxes$lambda$69$lambda$48(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Checkboxes$lambda$69$lambda$49(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkboxes$lambda$69$lambda$51$lambda$50(MutableState mutableState, boolean z5) {
        Checkboxes$lambda$69$lambda$49(mutableState, !Checkboxes$lambda$69$lambda$48(mutableState));
        return Unit.INSTANCE;
    }

    private static final boolean Checkboxes$lambda$69$lambda$53(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Checkboxes$lambda$69$lambda$54(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkboxes$lambda$69$lambda$56$lambda$55(MutableState mutableState, boolean z5) {
        Checkboxes$lambda$69$lambda$54(mutableState, !Checkboxes$lambda$69$lambda$53(mutableState));
        return Unit.INSTANCE;
    }

    private static final boolean Checkboxes$lambda$69$lambda$58(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Checkboxes$lambda$69$lambda$59(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkboxes$lambda$69$lambda$61$lambda$60(MutableState mutableState, boolean z5) {
        Checkboxes$lambda$69$lambda$59(mutableState, !Checkboxes$lambda$69$lambda$58(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkboxes$lambda$69$lambda$63$lambda$62(Function1 function1) {
        function1.invoke(new SnackbarEvent.Error(new SnackbarText.StringText("This checkbox is disabled")));
        return Unit.INSTANCE;
    }

    private static final boolean Checkboxes$lambda$69$lambda$65(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void Checkboxes$lambda$69$lambda$66(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkboxes$lambda$69$lambda$68$lambda$67(MutableState mutableState, boolean z5) {
        Checkboxes$lambda$69$lambda$66(mutableState, !Checkboxes$lambda$69$lambda$65(mutableState));
        return Unit.INSTANCE;
    }

    public static final void DeveloperInputTickersAndCheckboxes(final Function1<? super SnackbarEvent, Unit> showSnackbar, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(showSnackbar, "showSnackbar");
        Composer startRestartGroup = composer.startRestartGroup(1840863877);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(showSnackbar) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1840863877, i6, -1, "dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputTickersAndCheckboxes (DeveloperInputTickersAndCheckboxes.kt:19)");
            }
            DeveloperInputComponentsScreenKt.DeveloperSectionHeader("Number tickers", startRestartGroup, 6);
            Tickers(startRestartGroup, 0);
            DeveloperInputComponentsScreenKt.DeveloperSectionHeader("Checkboxes", startRestartGroup, 6);
            Checkboxes(showSnackbar, startRestartGroup, i6 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m3.N0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeveloperInputTickersAndCheckboxes$lambda$0;
                    DeveloperInputTickersAndCheckboxes$lambda$0 = DeveloperInputTickersAndCheckboxesKt.DeveloperInputTickersAndCheckboxes$lambda$0(Function1.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeveloperInputTickersAndCheckboxes$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputTickersAndCheckboxes$lambda$0(Function1 function1, int i5, Composer composer, int i6) {
        DeveloperInputTickersAndCheckboxes(function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void Tickers(Composer composer, final int i5) {
        char c5;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-577330092);
        if (i5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-577330092, i5, -1, "dk.molslinjen.ui.views.screens.developer.inputs.Tickers (DeveloperInputTickersAndCheckboxes.kt:29)");
            }
            startRestartGroup.startReplaceGroup(-1501160341);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            int Tickers$lambda$2 = Tickers$lambda$2(mutableState);
            PluralText.Resource resource = new PluralText.Resource(R.plurals.passengers);
            startRestartGroup.startReplaceGroup(-1501152376);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: m3.U0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Tickers$lambda$5$lambda$4;
                        Tickers$lambda$5$lambda$4 = DeveloperInputTickersAndCheckboxesKt.Tickers$lambda$5$lambda$4(MutableState.this, ((Integer) obj).intValue());
                        return Tickers$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function1 function1 = (Function1) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1501150616);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: m3.W0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Tickers$lambda$7$lambda$6;
                        Tickers$lambda$7$lambda$6 = DeveloperInputTickersAndCheckboxesKt.Tickers$lambda$7$lambda$6(MutableState.this, ((Integer) obj).intValue());
                        return Tickers$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            NumberSelectorKt.NumberSelector(null, Tickers$lambda$2, 0, 0, 9, resource, "Mine billetter", null, function1, (Function1) rememberedValue3, null, false, false, false, false, startRestartGroup, 907570176, 0, 31877);
            startRestartGroup.startReplaceGroup(-1501148277);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f5 = 16;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
            int Tickers$lambda$9 = Tickers$lambda$9(mutableState2);
            PluralText.Resource resource2 = new PluralText.Resource(R.plurals.passengers);
            startRestartGroup.startReplaceGroup(-1501138448);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: m3.X0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Tickers$lambda$12$lambda$11;
                        Tickers$lambda$12$lambda$11 = DeveloperInputTickersAndCheckboxesKt.Tickers$lambda$12$lambda$11(MutableState.this, ((Integer) obj).intValue());
                        return Tickers$lambda$12$lambda$11;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            Function1 function12 = (Function1) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1501136432);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new Function1() { // from class: m3.Z0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Tickers$lambda$14$lambda$13;
                        Tickers$lambda$14$lambda$13 = DeveloperInputTickersAndCheckboxesKt.Tickers$lambda$14$lambda$13(MutableState.this, ((Integer) obj).intValue());
                        return Tickers$lambda$14$lambda$13;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            NumberSelectorHeight numberSelectorHeight = NumberSelectorHeight.Large;
            NumberSelectorKt.NumberSelector(m315paddingqDBjuR0$default, Tickers$lambda$9, 0, 0, 4, resource2, "Mine billetter", null, function12, (Function1) rememberedValue6, numberSelectorHeight, false, false, false, false, startRestartGroup, 907570182, 6, 30852);
            startRestartGroup.startReplaceGroup(-1501132181);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue7;
            startRestartGroup.endReplaceGroup();
            int Tickers$lambda$16 = Tickers$lambda$16(mutableState3);
            PluralText.Resource resource3 = new PluralText.Resource(R.plurals.passengers);
            startRestartGroup.startReplaceGroup(-1501123919);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = new Function1() { // from class: m3.a1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Tickers$lambda$19$lambda$18;
                        Tickers$lambda$19$lambda$18 = DeveloperInputTickersAndCheckboxesKt.Tickers$lambda$19$lambda$18(MutableState.this, ((Integer) obj).intValue());
                        return Tickers$lambda$19$lambda$18;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            Function1 function13 = (Function1) rememberedValue8;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1501121871);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == companion.getEmpty()) {
                rememberedValue9 = new Function1() { // from class: m3.b1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Tickers$lambda$21$lambda$20;
                        Tickers$lambda$21$lambda$20 = DeveloperInputTickersAndCheckboxesKt.Tickers$lambda$21$lambda$20(MutableState.this, ((Integer) obj).intValue());
                        return Tickers$lambda$21$lambda$20;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            startRestartGroup.endReplaceGroup();
            NumberSelectorKt.NumberSelector(null, Tickers$lambda$16, 0, 0, 9, resource3, "Mine billetter", null, function13, (Function1) rememberedValue9, null, true, false, false, false, startRestartGroup, 907570176, 48, 29829);
            startRestartGroup.startReplaceGroup(-1501118037);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (rememberedValue10 == companion.getEmpty()) {
                c5 = 2;
                rememberedValue10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            } else {
                c5 = 2;
            }
            final MutableState mutableState4 = (MutableState) rememberedValue10;
            startRestartGroup.endReplaceGroup();
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
            int Tickers$lambda$23 = Tickers$lambda$23(mutableState4);
            PluralText.Resource resource4 = new PluralText.Resource(R.plurals.passengers);
            startRestartGroup.startReplaceGroup(-1501107495);
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (rememberedValue11 == companion.getEmpty()) {
                rememberedValue11 = new Function1() { // from class: m3.c1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Tickers$lambda$26$lambda$25;
                        Tickers$lambda$26$lambda$25 = DeveloperInputTickersAndCheckboxesKt.Tickers$lambda$26$lambda$25(MutableState.this, ((Integer) obj).intValue());
                        return Tickers$lambda$26$lambda$25;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            Function1 function14 = (Function1) rememberedValue11;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1501105191);
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (rememberedValue12 == companion.getEmpty()) {
                rememberedValue12 = new Function1() { // from class: m3.d1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Tickers$lambda$28$lambda$27;
                        Tickers$lambda$28$lambda$27 = DeveloperInputTickersAndCheckboxesKt.Tickers$lambda$28$lambda$27(MutableState.this, ((Integer) obj).intValue());
                        return Tickers$lambda$28$lambda$27;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            startRestartGroup.endReplaceGroup();
            NumberSelectorKt.NumberSelector(m315paddingqDBjuR0$default2, Tickers$lambda$23, 0, 0, 4, resource4, "Mine billetter", null, function14, (Function1) rememberedValue12, numberSelectorHeight, true, false, false, false, startRestartGroup, 907570182, 54, 28804);
            startRestartGroup.startReplaceGroup(-1501100213);
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (rememberedValue13 == companion.getEmpty()) {
                rememberedValue13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(8, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            final MutableState mutableState5 = (MutableState) rememberedValue13;
            startRestartGroup.endReplaceGroup();
            int Tickers$lambda$30 = Tickers$lambda$30(mutableState5);
            startRestartGroup.startReplaceGroup(-1501094270);
            Object rememberedValue14 = startRestartGroup.rememberedValue();
            if (rememberedValue14 == companion.getEmpty()) {
                rememberedValue14 = new Function1() { // from class: m3.e1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Tickers$lambda$33$lambda$32;
                        Tickers$lambda$33$lambda$32 = DeveloperInputTickersAndCheckboxesKt.Tickers$lambda$33$lambda$32(MutableState.this, ((Integer) obj).intValue());
                        return Tickers$lambda$33$lambda$32;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue14);
            }
            Function1 function15 = (Function1) rememberedValue14;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1501092702);
            Object rememberedValue15 = startRestartGroup.rememberedValue();
            if (rememberedValue15 == companion.getEmpty()) {
                rememberedValue15 = new Function1() { // from class: m3.f1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Tickers$lambda$35$lambda$34;
                        Tickers$lambda$35$lambda$34 = DeveloperInputTickersAndCheckboxesKt.Tickers$lambda$35$lambda$34(MutableState.this, ((Integer) obj).intValue());
                        return Tickers$lambda$35$lambda$34;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue15);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            NumberSelectorKt.NumberSelector(null, Tickers$lambda$30, 0, 8, 15, null, "Mine billetter", null, function15, (Function1) rememberedValue15, null, false, false, false, false, composer2, 907570176, 0, 31909);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m3.V0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Tickers$lambda$36;
                    Tickers$lambda$36 = DeveloperInputTickersAndCheckboxesKt.Tickers$lambda$36(i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Tickers$lambda$36;
                }
            });
        }
    }

    private static final void Tickers$lambda$10(MutableState<Integer> mutableState, int i5) {
        mutableState.setValue(Integer.valueOf(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tickers$lambda$12$lambda$11(MutableState mutableState, int i5) {
        Tickers$lambda$10(mutableState, i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tickers$lambda$14$lambda$13(MutableState mutableState, int i5) {
        Tickers$lambda$10(mutableState, i5);
        return Unit.INSTANCE;
    }

    private static final int Tickers$lambda$16(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void Tickers$lambda$17(MutableState<Integer> mutableState, int i5) {
        mutableState.setValue(Integer.valueOf(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tickers$lambda$19$lambda$18(MutableState mutableState, int i5) {
        Tickers$lambda$17(mutableState, i5);
        return Unit.INSTANCE;
    }

    private static final int Tickers$lambda$2(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tickers$lambda$21$lambda$20(MutableState mutableState, int i5) {
        Tickers$lambda$17(mutableState, i5);
        return Unit.INSTANCE;
    }

    private static final int Tickers$lambda$23(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void Tickers$lambda$24(MutableState<Integer> mutableState, int i5) {
        mutableState.setValue(Integer.valueOf(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tickers$lambda$26$lambda$25(MutableState mutableState, int i5) {
        Tickers$lambda$24(mutableState, i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tickers$lambda$28$lambda$27(MutableState mutableState, int i5) {
        Tickers$lambda$24(mutableState, i5);
        return Unit.INSTANCE;
    }

    private static final void Tickers$lambda$3(MutableState<Integer> mutableState, int i5) {
        mutableState.setValue(Integer.valueOf(i5));
    }

    private static final int Tickers$lambda$30(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void Tickers$lambda$31(MutableState<Integer> mutableState, int i5) {
        mutableState.setValue(Integer.valueOf(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tickers$lambda$33$lambda$32(MutableState mutableState, int i5) {
        Tickers$lambda$31(mutableState, i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tickers$lambda$35$lambda$34(MutableState mutableState, int i5) {
        Tickers$lambda$31(mutableState, i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tickers$lambda$36(int i5, Composer composer, int i6) {
        Tickers(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tickers$lambda$5$lambda$4(MutableState mutableState, int i5) {
        Tickers$lambda$3(mutableState, i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tickers$lambda$7$lambda$6(MutableState mutableState, int i5) {
        Tickers$lambda$3(mutableState, i5);
        return Unit.INSTANCE;
    }

    private static final int Tickers$lambda$9(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }
}
