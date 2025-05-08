package dk.molslinjen.ui.views.screens.developer.inputs;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
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
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.adjust.sdk.Constants;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.ButtonWithPriceKt;
import dk.molslinjen.ui.views.reusable.buttons.DestructiveButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.IconTextButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.OutlineDashedButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.ShowDetailsButtonKt;
import dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputButtonsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a#\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\t\u001a\u00020\u0002*\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e²\u0006\u000e\u0010\f\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\r\u001a\u00020\u000b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lkotlin/Function1;", "Ldk/molslinjen/core/snackbar/SnackbarEvent;", BuildConfig.FLAVOR, "showSnackbar", "DeveloperInputButtons", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/Function0;", "buttons", "ButtonRow", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "isExpanded", "isExpandedFullWidth", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeveloperInputButtonsKt {
    private static final void ButtonRow(final ColumnScope columnScope, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(921436410);
        if ((i5 & 48) == 0) {
            i6 = (startRestartGroup.changedInstance(function2) ? 32 : 16) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 17) == 16 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(921436410, i6, -1, "dk.molslinjen.ui.views.screens.developer.inputs.ButtonRow (DeveloperInputButtons.kt:320)");
            }
            FlowLayoutKt.FlowRow(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(8)), null, 0, 0, null, ComposableLambdaKt.rememberComposableLambda(1433428469, true, new Function3<FlowRowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputButtonsKt$ButtonRow$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(FlowRowScope flowRowScope, Composer composer2, Integer num) {
                    invoke(flowRowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(FlowRowScope FlowRow, Composer composer2, int i7) {
                    Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
                    if ((i7 & 17) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1433428469, i7, -1, "dk.molslinjen.ui.views.screens.developer.inputs.ButtonRow.<anonymous> (DeveloperInputButtons.kt:322)");
                    }
                    function2.invoke(composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 1572918, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m3.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ButtonRow$lambda$62;
                    ButtonRow$lambda$62 = DeveloperInputButtonsKt.ButtonRow$lambda$62(ColumnScope.this, function2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ButtonRow$lambda$62;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ButtonRow$lambda$62(ColumnScope columnScope, Function2 function2, int i5, Composer composer, int i6) {
        ButtonRow(columnScope, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void DeveloperInputButtons(final Function1<? super SnackbarEvent, Unit> showSnackbar, Composer composer, final int i5) {
        int i6;
        int i7;
        Composer composer2;
        Intrinsics.checkNotNullParameter(showSnackbar, "showSnackbar");
        Composer startRestartGroup = composer.startRestartGroup(-107269149);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(showSnackbar) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-107269149, i6, -1, "dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputButtons (DeveloperInputButtons.kt:18)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(8), 0.0f, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(10)), Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
            ButtonConfig[] values = ButtonConfig.values();
            startRestartGroup.startReplaceGroup(-952736765);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion3 = Composer.INSTANCE;
            if (rememberedValue == companion3.getEmpty()) {
                rememberedValue = new Function1() { // from class: m3.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        CharSequence DeveloperInputButtons$lambda$60$lambda$1$lambda$0;
                        DeveloperInputButtons$lambda$60$lambda$1$lambda$0 = DeveloperInputButtonsKt.DeveloperInputButtons$lambda$60$lambda$1$lambda$0((ButtonConfig) obj);
                        return DeveloperInputButtons$lambda$60$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            int i8 = i6;
            TextKt.m940Text4IGK_g("BaseButtons: " + ArraysKt.joinToString$default(values, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) rememberedValue, 31, (Object) null), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH1Bold(), startRestartGroup, 0, 1572864, 65534);
            DeveloperInputComponentsScreenKt.DeveloperSectionHeader("Primary", startRestartGroup, 6);
            ComposableSingletons$DeveloperInputButtonsKt composableSingletons$DeveloperInputButtonsKt = ComposableSingletons$DeveloperInputButtonsKt.INSTANCE;
            ButtonRow(columnScopeInstance, composableSingletons$DeveloperInputButtonsKt.m3489getLambda1$app_kombardoProd(), startRestartGroup, 54);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-952710682);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion3.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: m3.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            ButtonConfig buttonConfig = ButtonConfig.Small;
            PrimaryButtonKt.PrimaryButton(fillMaxWidth$default, "Button title", (Function0) rememberedValue2, null, buttonConfig, false, true, false, startRestartGroup, 1597878, 168);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-952703706);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion3.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: m3.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            ButtonConfig buttonConfig2 = ButtonConfig.Regular;
            PrimaryButtonKt.PrimaryButton(fillMaxWidth$default2, "Button title", (Function0) rememberedValue3, null, buttonConfig2, false, false, false, startRestartGroup, 25014, 232);
            Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-952697626);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion3.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: m3.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            ButtonConfig buttonConfig3 = ButtonConfig.Large;
            PrimaryButtonKt.PrimaryButton(fillMaxWidth$default3, "Button title", (Function0) rememberedValue4, null, buttonConfig3, false, false, false, startRestartGroup, 25014, 232);
            ButtonRow(columnScopeInstance, ComposableLambdaKt.rememberComposableLambda(53827929, true, new DeveloperInputButtonsKt$DeveloperInputButtons$1$4(showSnackbar), startRestartGroup, 54), startRestartGroup, 54);
            Modifier fillMaxWidth$default4 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-952658362);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion3.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: m3.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            Function0 function0 = (Function0) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-952657181);
            int i9 = i8 & 14;
            boolean z5 = i9 == 4;
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue6 == companion3.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: m3.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperInputButtons$lambda$60$lambda$11$lambda$10;
                        DeveloperInputButtons$lambda$60$lambda$11$lambda$10 = DeveloperInputButtonsKt.DeveloperInputButtons$lambda$60$lambda$11$lambda$10(Function1.this);
                        return DeveloperInputButtons$lambda$60$lambda$11$lambda$10;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            PrimaryButtonKt.PrimaryButton(fillMaxWidth$default4, "Button title", function0, (Function0) rememberedValue6, null, false, true, false, startRestartGroup, 1769910, 144);
            DeveloperInputComponentsScreenKt.DeveloperSectionHeader("Secondary", startRestartGroup, 6);
            ButtonRow(columnScopeInstance, composableSingletons$DeveloperInputButtonsKt.m3490getLambda2$app_kombardoProd(), startRestartGroup, 54);
            Modifier fillMaxWidth$default5 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-952606202);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == companion3.getEmpty()) {
                rememberedValue7 = new Function0() { // from class: m3.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            startRestartGroup.endReplaceGroup();
            SecondaryButtonKt.m3406SecondaryButtonbZJ32A(fillMaxWidth$default5, "Button title", (Function0) rememberedValue7, null, false, null, true, null, null, 0L, false, startRestartGroup, 1573302, 0, 1976);
            ButtonRow(columnScopeInstance, composableSingletons$DeveloperInputButtonsKt.m3491getLambda3$app_kombardoProd(), startRestartGroup, 54);
            Modifier fillMaxWidth$default6 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-952570202);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == companion3.getEmpty()) {
                rememberedValue8 = new Function0() { // from class: m3.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            startRestartGroup.endReplaceGroup();
            SecondaryButtonKt.m3406SecondaryButtonbZJ32A(fillMaxWidth$default6, "Button title", (Function0) rememberedValue8, null, false, null, true, null, null, 0L, false, startRestartGroup, 1597878, 0, 1960);
            DeveloperInputComponentsScreenKt.DeveloperSectionHeader("Destructive", startRestartGroup, 6);
            ButtonRow(columnScopeInstance, composableSingletons$DeveloperInputButtonsKt.m3492getLambda4$app_kombardoProd(), startRestartGroup, 54);
            Modifier fillMaxWidth$default7 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-952544058);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == companion3.getEmpty()) {
                rememberedValue9 = new Function0() { // from class: m3.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            startRestartGroup.endReplaceGroup();
            DestructiveButtonKt.DestructiveButton(fillMaxWidth$default7, "Button title", (Function0) rememberedValue9, null, null, false, true, startRestartGroup, 1573302, 56);
            ButtonRow(columnScopeInstance, composableSingletons$DeveloperInputButtonsKt.m3493getLambda5$app_kombardoProd(), startRestartGroup, 54);
            Modifier fillMaxWidth$default8 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-952518586);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (rememberedValue10 == companion3.getEmpty()) {
                rememberedValue10 = new Function0() { // from class: m3.t
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            startRestartGroup.endReplaceGroup();
            DestructiveButtonKt.DestructiveButton(fillMaxWidth$default8, "Button title", (Function0) rememberedValue10, null, null, false, false, startRestartGroup, 197046, 88);
            DeveloperInputComponentsScreenKt.DeveloperSectionHeader("Details", startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-952515418);
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (rememberedValue11 == companion3.getEmpty()) {
                i7 = 2;
                rememberedValue11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            } else {
                i7 = 2;
            }
            final MutableState mutableState = (MutableState) rememberedValue11;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-952513152);
            Object rememberedValue12 = startRestartGroup.rememberedValue();
            if (rememberedValue12 == companion3.getEmpty()) {
                rememberedValue12 = new Function0() { // from class: m3.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperInputButtons$lambda$60$lambda$24$lambda$23;
                        DeveloperInputButtons$lambda$60$lambda$24$lambda$23 = DeveloperInputButtonsKt.DeveloperInputButtons$lambda$60$lambda$24$lambda$23(MutableState.this);
                        return DeveloperInputButtons$lambda$60$lambda$24$lambda$23;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue12);
            }
            startRestartGroup.endReplaceGroup();
            ShowDetailsButtonKt.ShowDetailsButton(null, null, null, (Function0) rememberedValue12, DeveloperInputButtons$lambda$60$lambda$21(mutableState), startRestartGroup, 3072, 7);
            startRestartGroup.startReplaceGroup(-952510234);
            Object rememberedValue13 = startRestartGroup.rememberedValue();
            if (rememberedValue13 == companion3.getEmpty()) {
                rememberedValue13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, i7, null);
                startRestartGroup.updateRememberedValue(rememberedValue13);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue13;
            startRestartGroup.endReplaceGroup();
            Modifier fillMaxWidth$default9 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-952505998);
            Object rememberedValue14 = startRestartGroup.rememberedValue();
            if (rememberedValue14 == companion3.getEmpty()) {
                rememberedValue14 = new Function0() { // from class: m3.v
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperInputButtons$lambda$60$lambda$29$lambda$28;
                        DeveloperInputButtons$lambda$60$lambda$29$lambda$28 = DeveloperInputButtonsKt.DeveloperInputButtons$lambda$60$lambda$29$lambda$28(MutableState.this);
                        return DeveloperInputButtons$lambda$60$lambda$29$lambda$28;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue14);
            }
            startRestartGroup.endReplaceGroup();
            ShowDetailsButtonKt.ShowDetailsButton(fillMaxWidth$default9, null, null, (Function0) rememberedValue14, DeveloperInputButtons$lambda$60$lambda$26(mutableState2), startRestartGroup, 3078, 6);
            TextKt.m940Text4IGK_g("BaseButton disabledOnClick", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 6, 0, 131070);
            Modifier fillMaxWidth$default10 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-952498426);
            Object rememberedValue15 = startRestartGroup.rememberedValue();
            if (rememberedValue15 == companion3.getEmpty()) {
                rememberedValue15 = new Function0() { // from class: m3.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue15);
            }
            startRestartGroup.endReplaceGroup();
            PrimaryButtonKt.PrimaryButton(fillMaxWidth$default10, "Button title", (Function0) rememberedValue15, null, null, false, false, false, startRestartGroup, 197046, 216);
            TextKt.m940Text4IGK_g("PriceButton with price", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 6, 0, 131070);
            PriceWithCurrency.Companion companion4 = PriceWithCurrency.INSTANCE;
            PriceWithCurrency mock = companion4.mock(499);
            startRestartGroup.startReplaceGroup(-952494577);
            Object rememberedValue16 = startRestartGroup.rememberedValue();
            if (rememberedValue16 == companion3.getEmpty()) {
                rememberedValue16 = new Function0() { // from class: m3.x
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue16);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            ButtonWithPriceKt.ButtonWithPrice((Modifier) null, (Function0<Unit>) rememberedValue16, "Mine billetter", mock, (String) null, false, (Function0<Unit>) null, buttonConfig, false, startRestartGroup, 12583344, 369);
            PriceWithCurrency mock2 = companion4.mock(499);
            composer2.startReplaceGroup(-952489969);
            Object rememberedValue17 = composer2.rememberedValue();
            if (rememberedValue17 == companion3.getEmpty()) {
                rememberedValue17 = new Function0() { // from class: m3.y
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer2.updateRememberedValue(rememberedValue17);
            }
            composer2.endReplaceGroup();
            ButtonWithPriceKt.ButtonWithPrice((Modifier) null, (Function0<Unit>) rememberedValue17, "Mine billetter", mock2, (String) null, false, (Function0<Unit>) null, buttonConfig2, false, composer2, 12583344, 369);
            PriceWithCurrency mock3 = companion4.mock(499);
            composer2.startReplaceGroup(-952485297);
            Object rememberedValue18 = composer2.rememberedValue();
            if (rememberedValue18 == companion3.getEmpty()) {
                rememberedValue18 = new Function0() { // from class: m3.z
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer2.updateRememberedValue(rememberedValue18);
            }
            composer2.endReplaceGroup();
            ButtonWithPriceKt.ButtonWithPrice((Modifier) null, (Function0<Unit>) rememberedValue18, "Mine billetter", mock3, (String) null, false, (Function0<Unit>) null, buttonConfig3, false, composer2, 12583344, 369);
            PriceWithCurrency mock4 = companion4.mock(499);
            composer2.startReplaceGroup(-952480698);
            Object rememberedValue19 = composer2.rememberedValue();
            if (rememberedValue19 == companion3.getEmpty()) {
                rememberedValue19 = new Function0() { // from class: m3.A
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer2.updateRememberedValue(rememberedValue19);
            }
            composer2.endReplaceGroup();
            ButtonWithPriceKt.ButtonWithPrice((Modifier) null, (Function0<Unit>) rememberedValue19, "Mine billetter", mock4, (String) null, false, (Function0<Unit>) null, (ButtonConfig) null, false, composer2, 197040, 465);
            TextKt.m940Text4IGK_g("PriceButton no price", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 6, 0, 131070);
            Modifier fillMaxWidth$default11 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            composer2.startReplaceGroup(-952475290);
            Object rememberedValue20 = composer2.rememberedValue();
            if (rememberedValue20 == companion3.getEmpty()) {
                rememberedValue20 = new Function0() { // from class: m3.B
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer2.updateRememberedValue(rememberedValue20);
            }
            composer2.endReplaceGroup();
            ButtonWithPriceKt.ButtonWithPrice(fillMaxWidth$default11, (Function0<Unit>) rememberedValue20, "Mine billetter", (PriceWithCurrency) null, (String) null, false, (Function0<Unit>) null, (ButtonConfig) null, false, composer2, 3510, 496);
            Modifier fillMaxWidth$default12 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            composer2.startReplaceGroup(-952471665);
            Object rememberedValue21 = composer2.rememberedValue();
            if (rememberedValue21 == companion3.getEmpty()) {
                rememberedValue21 = new Function0() { // from class: m3.C
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer2.updateRememberedValue(rememberedValue21);
            }
            composer2.endReplaceGroup();
            ButtonWithPriceKt.ButtonWithPrice(fillMaxWidth$default12, (Function0<Unit>) rememberedValue21, "Mine billetter", (PriceWithCurrency) null, (String) null, false, (Function0<Unit>) null, (ButtonConfig) null, false, composer2, 200118, 464);
            DeveloperInputComponentsScreenKt.DeveloperSectionHeader("PriceButton disabledOnClick", composer2, 6);
            PriceWithCurrency mock5 = companion4.mock(499);
            Modifier fillMaxWidth$default13 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            composer2.startReplaceGroup(-952464602);
            Object rememberedValue22 = composer2.rememberedValue();
            if (rememberedValue22 == companion3.getEmpty()) {
                rememberedValue22 = new Function0() { // from class: m3.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer2.updateRememberedValue(rememberedValue22);
            }
            Function0 function02 = (Function0) rememberedValue22;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-952459358);
            boolean z6 = i9 == 4;
            Object rememberedValue23 = composer2.rememberedValue();
            if (z6 || rememberedValue23 == companion3.getEmpty()) {
                rememberedValue23 = new Function0() { // from class: m3.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit DeveloperInputButtons$lambda$60$lambda$47$lambda$46;
                        DeveloperInputButtons$lambda$60$lambda$47$lambda$46 = DeveloperInputButtonsKt.DeveloperInputButtons$lambda$60$lambda$47$lambda$46(Function1.this);
                        return DeveloperInputButtons$lambda$60$lambda$47$lambda$46;
                    }
                };
                composer2.updateRememberedValue(rememberedValue23);
            }
            composer2.endReplaceGroup();
            ButtonWithPriceKt.ButtonWithPrice(fillMaxWidth$default13, (Function0<Unit>) function02, "Mine billetter", mock5, (String) null, false, (Function0<Unit>) rememberedValue23, (ButtonConfig) null, false, composer2, 197046, Constants.MINIMAL_ERROR_STATUS_CODE);
            PriceWithCurrency mock6 = companion4.mock(100);
            Modifier fillMaxWidth$default14 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            composer2.startReplaceGroup(-952452410);
            Object rememberedValue24 = composer2.rememberedValue();
            if (rememberedValue24 == companion3.getEmpty()) {
                rememberedValue24 = new Function0() { // from class: m3.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer2.updateRememberedValue(rememberedValue24);
            }
            Function0 function03 = (Function0) rememberedValue24;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-952447277);
            Object rememberedValue25 = composer2.rememberedValue();
            if (rememberedValue25 == companion3.getEmpty()) {
                rememberedValue25 = new Function0() { // from class: m3.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer2.updateRememberedValue(rememberedValue25);
            }
            composer2.endReplaceGroup();
            ButtonWithPriceKt.ButtonWithPrice(fillMaxWidth$default14, (Function0<Unit>) function03, "Mine billetter", mock6, (String) null, false, (Function0<Unit>) rememberedValue25, (ButtonConfig) null, false, composer2, 1769910, Constants.MINIMAL_ERROR_STATUS_CODE);
            DeveloperInputComponentsScreenKt.DeveloperSectionHeader("IconText button", composer2, 6);
            composer2.startReplaceGroup(-952442042);
            Object rememberedValue26 = composer2.rememberedValue();
            if (rememberedValue26 == companion3.getEmpty()) {
                rememberedValue26 = new Function0() { // from class: m3.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer2.updateRememberedValue(rememberedValue26);
            }
            Function0 function04 = (Function0) rememberedValue26;
            composer2.endReplaceGroup();
            AppColor appColor = AppColor.INSTANCE;
            IconTextButtonKt.m3404IconTextButtonV9fs2A(companion, function04, R.drawable.icon_delete, R.string.button_delete, true, appColor.m3271getSignalOrange0d7_KjU(), composer2, 224694, 0);
            composer2.startReplaceGroup(-952434074);
            Object rememberedValue27 = composer2.rememberedValue();
            if (rememberedValue27 == companion3.getEmpty()) {
                rememberedValue27 = new Function0() { // from class: m3.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer2.updateRememberedValue(rememberedValue27);
            }
            composer2.endReplaceGroup();
            IconTextButtonKt.m3404IconTextButtonV9fs2A(companion, (Function0) rememberedValue27, R.drawable.icon_delete, R.string.button_delete, true, appColor.m3271getSignalOrange0d7_KjU(), composer2, 224694, 0);
            DeveloperInputComponentsScreenKt.DeveloperSectionHeader("Outline dashed button", composer2, 6);
            composer2.startReplaceGroup(-952421050);
            Object rememberedValue28 = composer2.rememberedValue();
            if (rememberedValue28 == companion3.getEmpty()) {
                rememberedValue28 = new Function0() { // from class: m3.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer2.updateRememberedValue(rememberedValue28);
            }
            composer2.endReplaceGroup();
            OutlineDashedButtonKt.m3405OutlineDashedButtonEMNEwkI(companion, "Outlined Button", R.drawable.icon_plus_circled, 0L, 0L, 0L, (Function0) rememberedValue28, composer2, 1573302, 56);
            long m3269getGrey60d7_KjU = appColor.m3269getGrey60d7_KjU();
            long m3272getSignalRed0d7_KjU = appColor.m3272getSignalRed0d7_KjU();
            long m3272getSignalRed0d7_KjU2 = appColor.m3272getSignalRed0d7_KjU();
            composer2.startReplaceGroup(-952410682);
            Object rememberedValue29 = composer2.rememberedValue();
            if (rememberedValue29 == companion3.getEmpty()) {
                rememberedValue29 = new Function0() { // from class: m3.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                composer2.updateRememberedValue(rememberedValue29);
            }
            composer2.endReplaceGroup();
            OutlineDashedButtonKt.m3405OutlineDashedButtonEMNEwkI(companion, "Outlined Button", R.drawable.icon_plus_circled, m3269getGrey60d7_KjU, m3272getSignalRed0d7_KjU, m3272getSignalRed0d7_KjU2, (Function0) rememberedValue29, composer2, 1797558, 0);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m3.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeveloperInputButtons$lambda$61;
                    DeveloperInputButtons$lambda$61 = DeveloperInputButtonsKt.DeveloperInputButtons$lambda$61(Function1.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeveloperInputButtons$lambda$61;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence DeveloperInputButtons$lambda$60$lambda$1$lambda$0(ButtonConfig it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.name();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputButtons$lambda$60$lambda$11$lambda$10(Function1 function1) {
        function1.invoke(new SnackbarEvent.Information(new SnackbarText.StringText("Clicked disabled button"), null, false, 6, null));
        return Unit.INSTANCE;
    }

    private static final boolean DeveloperInputButtons$lambda$60$lambda$21(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void DeveloperInputButtons$lambda$60$lambda$22(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputButtons$lambda$60$lambda$24$lambda$23(MutableState mutableState) {
        DeveloperInputButtons$lambda$60$lambda$22(mutableState, !DeveloperInputButtons$lambda$60$lambda$21(mutableState));
        return Unit.INSTANCE;
    }

    private static final boolean DeveloperInputButtons$lambda$60$lambda$26(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void DeveloperInputButtons$lambda$60$lambda$27(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputButtons$lambda$60$lambda$29$lambda$28(MutableState mutableState) {
        DeveloperInputButtons$lambda$60$lambda$27(mutableState, !DeveloperInputButtons$lambda$60$lambda$26(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputButtons$lambda$60$lambda$47$lambda$46(Function1 function1) {
        function1.invoke(new SnackbarEvent.Error(new SnackbarText.StringText("PriceButton from onClickDisabled")));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputButtons$lambda$61(Function1 function1, int i5, Composer composer, int i6) {
        DeveloperInputButtons(function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
