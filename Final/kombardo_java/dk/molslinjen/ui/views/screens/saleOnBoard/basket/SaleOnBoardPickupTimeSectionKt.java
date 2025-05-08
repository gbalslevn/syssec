package dk.molslinjen.ui.views.screens.saleOnBoard.basket;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardTimeSlot;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.LabeledSelectionControlKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlStyle;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardPickupTimeSectionKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aK\u0010\n\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\n\u0010\u000b\u001a3\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\r\u001a\u00020\fH\u0003¢\u0006\u0004\b\u000e\u0010\u000f\u001aI\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0003¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0015\u001a\u00020\u0007*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListScope;", "Ldk/molslinjen/ui/views/screens/saleOnBoard/basket/SaleOnBoardBasketViewModel$ViewState;", "state", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;", "selectedTimeSlot", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onPickupTimeCategorySelection", "onTimeSlotSelected", "saleOnBoardPickupTimeSection", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/ui/views/screens/saleOnBoard/basket/SaleOnBoardBasketViewModel$ViewState;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "timeSlotAsEarlyAsPossibleContentDescription", "FirstAvailableTimeSlotSection", "(Ldk/molslinjen/ui/views/screens/saleOnBoard/basket/SaleOnBoardBasketViewModel$ViewState;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "SelectAnotherTimeSlotSection", "(Ldk/molslinjen/ui/views/screens/saleOnBoard/basket/SaleOnBoardBasketViewModel$ViewState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/layout/RowScope;", "timeSlot", "isSelected", "TimeSlotRow", "(Landroidx/compose/foundation/layout/RowScope;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;ZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardPickupTimeSectionKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void FirstAvailableTimeSlotSection(final SaleOnBoardBasketViewModel.ViewState viewState, final Function1<? super Boolean, Unit> function1, final String str, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(-1587036708);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1587036708, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.FirstAvailableTimeSlotSection (SaleOnBoardPickupTimeSection.kt:91)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(companion, Dp.m2599constructorimpl(16));
            boolean timeSlotAsEarlyAsPossible = viewState.getTimeSlotAsEarlyAsPossible();
            startRestartGroup.startReplaceGroup(-1291225937);
            int i7 = i6 & 112;
            boolean z5 = i7 == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: f4.Q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit FirstAvailableTimeSlotSection$lambda$1$lambda$0;
                        FirstAvailableTimeSlotSection$lambda$1$lambda$0 = SaleOnBoardPickupTimeSectionKt.FirstAvailableTimeSlotSection$lambda$1$lambda$0(Function1.this, ((Boolean) obj2).booleanValue());
                        return FirstAvailableTimeSlotSection$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m455toggleableXHw0xAI$default = ToggleableKt.m455toggleableXHw0xAI$default(m311padding3ABfNKs, timeSlotAsEarlyAsPossible, false, null, (Function1) rememberedValue, 6, null);
            startRestartGroup.startReplaceGroup(-1291220240);
            boolean z6 = (i6 & 896) == 256;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: f4.S
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit FirstAvailableTimeSlotSection$lambda$3$lambda$2;
                        FirstAvailableTimeSlotSection$lambda$3$lambda$2 = SaleOnBoardPickupTimeSectionKt.FirstAvailableTimeSlotSection$lambda$3$lambda$2(str, (SemanticsPropertyReceiver) obj2);
                        return FirstAvailableTimeSlotSection$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(m455toggleableXHw0xAI$default, (Function1) rememberedValue2);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics);
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
            String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_pickupTime_asEarlyAsPossible, startRestartGroup, 6);
            boolean timeSlotAsEarlyAsPossible2 = viewState.getTimeSlotAsEarlyAsPossible();
            startRestartGroup.startReplaceGroup(1101344734);
            boolean z7 = i7 == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: f4.T
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit FirstAvailableTimeSlotSection$lambda$7$lambda$5$lambda$4;
                        FirstAvailableTimeSlotSection$lambda$7$lambda$5$lambda$4 = SaleOnBoardPickupTimeSectionKt.FirstAvailableTimeSlotSection$lambda$7$lambda$5$lambda$4(Function1.this, ((Boolean) obj2).booleanValue());
                        return FirstAvailableTimeSlotSection$lambda$7$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            LabeledSelectionControlKt.LabeledSelectionControl(null, stringResource, timeSlotAsEarlyAsPossible2, (Function1) rememberedValue3, null, false, null, SelectionControlStyle.RadioButton, false, startRestartGroup, 12582912, 369);
            startRestartGroup.startReplaceGroup(1101351121);
            if (viewState.getTimeSlotAsEarlyAsPossible()) {
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(36), Dp.m2599constructorimpl(8), 0.0f, 0.0f, 12, null);
                Iterator<T> it = viewState.getTimeSlots().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (!((SaleOnBoardTimeSlot) obj).getFullyBooked()) {
                            break;
                        }
                    }
                }
                SaleOnBoardTimeSlot saleOnBoardTimeSlot = (SaleOnBoardTimeSlot) obj;
                String saleOnBoardTimeSlot2 = saleOnBoardTimeSlot != null ? saleOnBoardTimeSlot.toString() : null;
                startRestartGroup.startReplaceGroup(1101355719);
                String stringResource2 = saleOnBoardTimeSlot2 == null ? StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_pickupTime_noneAvailable, startRestartGroup, 6) : saleOnBoardTimeSlot2;
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(stringResource2, m315paddingqDBjuR0$default, AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), composer2, 384, 1572864, 65528);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: f4.U
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit FirstAvailableTimeSlotSection$lambda$8;
                    FirstAvailableTimeSlotSection$lambda$8 = SaleOnBoardPickupTimeSectionKt.FirstAvailableTimeSlotSection$lambda$8(SaleOnBoardBasketViewModel.ViewState.this, function1, str, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return FirstAvailableTimeSlotSection$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FirstAvailableTimeSlotSection$lambda$1$lambda$0(Function1 function1, boolean z5) {
        if (z5) {
            function1.invoke(Boolean.TRUE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FirstAvailableTimeSlotSection$lambda$3$lambda$2(String str, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FirstAvailableTimeSlotSection$lambda$7$lambda$5$lambda$4(Function1 function1, boolean z5) {
        if (z5) {
            function1.invoke(Boolean.TRUE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FirstAvailableTimeSlotSection$lambda$8(SaleOnBoardBasketViewModel.ViewState viewState, Function1 function1, String str, int i5, Composer composer, int i6) {
        FirstAvailableTimeSlotSection(viewState, function1, str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02ac, code lost:
    
        if (r14 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L104;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SelectAnotherTimeSlotSection(final SaleOnBoardBasketViewModel.ViewState viewState, final Function1<? super Boolean, Unit> function1, final Function1<? super SaleOnBoardTimeSlot, Unit> function12, final SaleOnBoardTimeSlot saleOnBoardTimeSlot, Composer composer, final int i5) {
        int i6;
        float m2599constructorimpl;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(-841132607);
        int i7 = (i5 & 6) == 0 ? (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5 : i5;
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(saleOnBoardTimeSlot) ? 2048 : 1024;
        }
        int i8 = i7;
        if ((i8 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-841132607, i8, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.SelectAnotherTimeSlotSection (SaleOnBoardPickupTimeSection.kt:133)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 16;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(companion, Dp.m2599constructorimpl(f5));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
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
            String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_pickupTime_laterTime, startRestartGroup, 6);
            boolean z5 = !viewState.getTimeSlotAsEarlyAsPossible();
            startRestartGroup.startReplaceGroup(-1353442085);
            boolean z6 = (i8 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: f4.N
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit SelectAnotherTimeSlotSection$lambda$15$lambda$10$lambda$9;
                        SelectAnotherTimeSlotSection$lambda$15$lambda$10$lambda$9 = SaleOnBoardPickupTimeSectionKt.SelectAnotherTimeSlotSection$lambda$15$lambda$10$lambda$9(Function1.this, ((Boolean) obj2).booleanValue());
                        return SelectAnotherTimeSlotSection$lambda$15$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            int i9 = i8;
            LabeledSelectionControlKt.LabeledSelectionControl(null, stringResource, z5, (Function1) rememberedValue, null, false, null, SelectionControlStyle.RadioButton, false, startRestartGroup, 12582912, 369);
            startRestartGroup.startReplaceGroup(-1353434726);
            if (!viewState.getTimeSlotAsEarlyAsPossible()) {
                float f6 = 8;
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(24), 0.0f, Dp.m2599constructorimpl(f6), 5, null);
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(f6)), companion2.getStart(), startRestartGroup, 6);
                int i10 = 0;
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
                Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                startRestartGroup.startReplaceGroup(-640186522);
                for (final SaleOnBoardTimeSlot saleOnBoardTimeSlot2 : viewState.getTimeSlots()) {
                    boolean z7 = (saleOnBoardTimeSlot == null || saleOnBoardTimeSlot2.getId() != saleOnBoardTimeSlot.getId()) ? i10 : 1;
                    Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(Modifier.INSTANCE, saleOnBoardTimeSlot2.getFullyBooked() ? AppColor.INSTANCE.m3269getGrey60d7_KjU() : AppColor.INSTANCE.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium());
                    if (z7 != 0) {
                        m2599constructorimpl = Dp.m2599constructorimpl(2);
                        i6 = 1;
                    } else {
                        i6 = 1;
                        m2599constructorimpl = Dp.m2599constructorimpl(1);
                    }
                    AppColor appColor = AppColor.INSTANCE;
                    Modifier clip = ClipKt.clip(BorderKt.m108borderxT4_qwU(m103backgroundbw27NRU, m2599constructorimpl, z7 != 0 ? appColor.m3255getBrandBlue10d7_KjU() : appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), ThemeShapesKt.getThemeShapes().getMedium());
                    boolean z8 = !saleOnBoardTimeSlot2.getFullyBooked();
                    startRestartGroup.startReplaceGroup(-640160570);
                    int i11 = i9;
                    int i12 = ((i11 & 896) == 256 ? i6 : i10) | (startRestartGroup.changedInstance(saleOnBoardTimeSlot2) ? 1 : 0);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (i12 == 0) {
                        obj = rememberedValue2;
                    }
                    Function1 function13 = new Function1() { // from class: f4.O
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit SelectAnotherTimeSlotSection$lambda$15$lambda$14$lambda$12$lambda$11;
                            SelectAnotherTimeSlotSection$lambda$15$lambda$14$lambda$12$lambda$11 = SaleOnBoardPickupTimeSectionKt.SelectAnotherTimeSlotSection$lambda$15$lambda$14$lambda$12$lambda$11(Function1.this, saleOnBoardTimeSlot2, ((Boolean) obj2).booleanValue());
                            return SelectAnotherTimeSlotSection$lambda$15$lambda$14$lambda$12$lambda$11;
                        }
                    };
                    startRestartGroup.updateRememberedValue(function13);
                    obj = function13;
                    startRestartGroup.endReplaceGroup();
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m311padding3ABfNKs(ToggleableKt.m455toggleableXHw0xAI$default(clip, z7, z8, null, (Function1) obj, 4, null), Dp.m2599constructorimpl(f5)), 0.0f, 1, null);
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, i10);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, i10);
                    CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor3);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Composer m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                    if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
                    TimeSlotRow(RowScopeInstance.INSTANCE, saleOnBoardTimeSlot2, z7, startRestartGroup, 6);
                    startRestartGroup.endNode();
                    i9 = i11;
                    i10 = 0;
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: f4.P
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit SelectAnotherTimeSlotSection$lambda$16;
                    SelectAnotherTimeSlotSection$lambda$16 = SaleOnBoardPickupTimeSectionKt.SelectAnotherTimeSlotSection$lambda$16(SaleOnBoardBasketViewModel.ViewState.this, function1, function12, saleOnBoardTimeSlot, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return SelectAnotherTimeSlotSection$lambda$16;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectAnotherTimeSlotSection$lambda$15$lambda$10$lambda$9(Function1 function1, boolean z5) {
        if (z5) {
            function1.invoke(Boolean.FALSE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectAnotherTimeSlotSection$lambda$15$lambda$14$lambda$12$lambda$11(Function1 function1, SaleOnBoardTimeSlot saleOnBoardTimeSlot, boolean z5) {
        function1.invoke(saleOnBoardTimeSlot);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectAnotherTimeSlotSection$lambda$16(SaleOnBoardBasketViewModel.ViewState viewState, Function1 function1, Function1 function12, SaleOnBoardTimeSlot saleOnBoardTimeSlot, int i5, Composer composer, int i6) {
        SelectAnotherTimeSlotSection(viewState, function1, function12, saleOnBoardTimeSlot, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void TimeSlotRow(final RowScope rowScope, final SaleOnBoardTimeSlot saleOnBoardTimeSlot, final boolean z5, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1645804107);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(saleOnBoardTimeSlot) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1645804107, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.TimeSlotRow (SaleOnBoardPickupTimeSection.kt:178)");
            }
            TextKt.m940Text4IGK_g(saleOnBoardTimeSlot.toString(), null, z5 ? AppColor.INSTANCE.m3255getBrandBlue10d7_KjU() : saleOnBoardTimeSlot.getFullyBooked() ? AppColor.INSTANCE.m3266getGrey30d7_KjU() : AppColor.INSTANCE.m3253getBrandBlack10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, z5 ? TypographyKt.getParagraphSmallBold() : TypographyKt.getParagraphSmall(), startRestartGroup, 0, 0, 65530);
            if (saleOnBoardTimeSlot.getFullyBooked()) {
                SpacerKt.Spacer(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), startRestartGroup, 0);
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_pickupTime_noneAvailable, startRestartGroup, 6), null, AppColor.INSTANCE.m3266getGrey30d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 384, 1572864, 65530);
            } else {
                composer2 = startRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: f4.V
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TimeSlotRow$lambda$17;
                    TimeSlotRow$lambda$17 = SaleOnBoardPickupTimeSectionKt.TimeSlotRow$lambda$17(RowScope.this, saleOnBoardTimeSlot, z5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TimeSlotRow$lambda$17;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeSlotRow$lambda$17(RowScope rowScope, SaleOnBoardTimeSlot saleOnBoardTimeSlot, boolean z5, int i5, Composer composer, int i6) {
        TimeSlotRow(rowScope, saleOnBoardTimeSlot, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void saleOnBoardPickupTimeSection(LazyListScope lazyListScope, final SaleOnBoardBasketViewModel.ViewState state, final SaleOnBoardTimeSlot saleOnBoardTimeSlot, final Function1<? super Boolean, Unit> onPickupTimeCategorySelection, final Function1<? super SaleOnBoardTimeSlot, Unit> onTimeSlotSelected) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onPickupTimeCategorySelection, "onPickupTimeCategorySelection");
        Intrinsics.checkNotNullParameter(onTimeSlotSelected, "onTimeSlotSelected");
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1740802741, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardPickupTimeSectionKt$saleOnBoardPickupTimeSection$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i5) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i5 & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1740802741, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.saleOnBoardPickupTimeSection.<anonymous> (SaleOnBoardPickupTimeSection.kt:43)");
                }
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_pickupTime, composer, 6), PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(16), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer, 48, 1572864, 65532);
                boolean isLoadingTimeSlots = SaleOnBoardBasketViewModel.ViewState.this.getIsLoadingTimeSlots();
                final SaleOnBoardBasketViewModel.ViewState viewState = SaleOnBoardBasketViewModel.ViewState.this;
                final Function1<Boolean, Unit> function1 = onPickupTimeCategorySelection;
                final Function1<SaleOnBoardTimeSlot, Unit> function12 = onTimeSlotSelected;
                final SaleOnBoardTimeSlot saleOnBoardTimeSlot2 = saleOnBoardTimeSlot;
                LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, isLoadingTimeSlots, 0, false, null, ComposableLambdaKt.rememberComposableLambda(1526639873, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardPickupTimeSectionKt$saleOnBoardPickupTimeSection$1.1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        String str;
                        Object obj;
                        if ((i6 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1526639873, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.saleOnBoardPickupTimeSection.<anonymous>.<anonymous> (SaleOnBoardPickupTimeSection.kt:50)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        AppColor appColor = AppColor.INSTANCE;
                        Modifier clip = ClipKt.clip(BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(companion, appColor.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(1), appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), ThemeShapesKt.getThemeShapes().getMedium());
                        SaleOnBoardBasketViewModel.ViewState viewState2 = SaleOnBoardBasketViewModel.ViewState.this;
                        Function1<Boolean, Unit> function13 = function1;
                        Function1<SaleOnBoardTimeSlot, Unit> function14 = function12;
                        SaleOnBoardTimeSlot saleOnBoardTimeSlot3 = saleOnBoardTimeSlot2;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, clip);
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_pickupTime_asEarlyAsPossible, composer2, 6);
                        composer2.startReplaceGroup(1093839391);
                        if (viewState2.getTimeSlotAsEarlyAsPossible()) {
                            Iterator<T> it = viewState2.getTimeSlots().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    obj = null;
                                    break;
                                } else {
                                    obj = it.next();
                                    if (!((SaleOnBoardTimeSlot) obj).getFullyBooked()) {
                                        break;
                                    }
                                }
                            }
                            SaleOnBoardTimeSlot saleOnBoardTimeSlot4 = (SaleOnBoardTimeSlot) obj;
                            str = saleOnBoardTimeSlot4 != null ? saleOnBoardTimeSlot4.toString() : null;
                            if (str == null) {
                                str = StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_pickupTime_noneAvailable, composer2, 6);
                            }
                        } else {
                            str = BuildConfig.FLAVOR;
                        }
                        composer2.endReplaceGroup();
                        SaleOnBoardPickupTimeSectionKt.FirstAvailableTimeSlotSection(viewState2, function13, stringResource + " " + str, composer2, 0);
                        HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer2, 0, 15);
                        SaleOnBoardPickupTimeSectionKt.SelectAnotherTimeSlotSection(viewState2, function13, function14, saleOnBoardTimeSlot3, composer2, 0);
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer, 54), composer, 1572864, 59);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$SaleOnBoardPickupTimeSectionKt.INSTANCE.m3530getLambda1$app_kombardoProd(), 3, null);
    }
}
