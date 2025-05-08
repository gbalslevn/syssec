package dk.molslinjen.ui.views.screens.agreements.multiride.common;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCardSummaryInfo;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideSummaryCardKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryBackgroundViewKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryFooterRowKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryHeaderRowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a!\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardSummaryInfo;", "multiRideSummaryInfo", BuildConfig.FLAVOR, "skeletonForMultiRideId", BuildConfig.FLAVOR, "MultiRideSummaryCard", "(Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardSummaryInfo;ZLandroidx/compose/runtime/Composer;I)V", "summaryInfo", "MiddleContent", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MultiRideSummaryCardKt {
    private static final void MiddleContent(final MultiRideCardSummaryInfo multiRideCardSummaryInfo, final boolean z5, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(938020708);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(multiRideCardSummaryInfo) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(938020708, i6, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.common.MiddleContent (MultiRideSummaryCard.kt:77)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 16;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 1, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
            composer2 = startRestartGroup;
            MultiRideCardInfoViewKt.MultiRideCardInfoView(PaddingKt.m313paddingVpY3zN4$default(PaddingKt.m315paddingqDBjuR0$default(BackgroundKt.m103backgroundbw27NRU(companion, AppColor.INSTANCE.m3269getGrey60d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, Dp.m2599constructorimpl(8), 1, null), multiRideCardSummaryInfo.getMultiRideId(), multiRideCardSummaryInfo.getChargesExpireDate(), multiRideCardSummaryInfo.getTicketCategoryType(), multiRideCardSummaryInfo.getTicketTypeName(), multiRideCardSummaryInfo.getNumberOfChargesToAdd(), null, false, z5, startRestartGroup, (i6 << 21) & 234881024, 192);
            Integer newTotalNumberOfCharges = multiRideCardSummaryInfo.getNewTotalNumberOfCharges();
            composer2.startReplaceGroup(1092131856);
            if (newTotalNumberOfCharges != null) {
                int intValue = newTotalNumberOfCharges.intValue();
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer2, 6);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composer2, 48);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.multiRide_refill_totalChargesAfterRefill, composer2, 6), RowScope.weight$default(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65532);
                TextKt.m940Text4IGK_g(StringResources_androidKt.pluralStringResource(R.plurals.multiRide_numberOfCharges, intValue, new Object[]{Integer.valueOf(intValue)}, composer2, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, 0, 1572864, 65534);
                composer2.endNode();
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: x2.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MiddleContent$lambda$15;
                    MiddleContent$lambda$15 = MultiRideSummaryCardKt.MiddleContent$lambda$15(MultiRideCardSummaryInfo.this, z5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MiddleContent$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MiddleContent$lambda$15(MultiRideCardSummaryInfo multiRideCardSummaryInfo, boolean z5, int i5, Composer composer, int i6) {
        MiddleContent(multiRideCardSummaryInfo, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void MultiRideSummaryCard(final MultiRideCardSummaryInfo multiRideCardSummaryInfo, final boolean z5, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(816915425);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(multiRideCardSummaryInfo) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        int i7 = i6;
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(816915425, i7, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideSummaryCard (MultiRideSummaryCard.kt:37)");
            }
            if (multiRideCardSummaryInfo == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: x2.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit MultiRideSummaryCard$lambda$0;
                            MultiRideSummaryCard$lambda$0 = MultiRideSummaryCardKt.MultiRideSummaryCard$lambda$0(MultiRideCardSummaryInfo.this, z5, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return MultiRideSummaryCard$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier height = IntrinsicKt.height(companion, IntrinsicSize.Max);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, height);
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Object[] objArr = new Object[0];
            startRestartGroup.startReplaceGroup(38559039);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue == companion4.getEmpty()) {
                rememberedValue = new Function0() { // from class: x2.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState MultiRideSummaryCard$lambda$10$lambda$2$lambda$1;
                        MultiRideSummaryCard$lambda$10$lambda$2$lambda$1 = MultiRideSummaryCardKt.MultiRideSummaryCard$lambda$10$lambda$2$lambda$1();
                        return MultiRideSummaryCard$lambda$10$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
            Object[] objArr2 = new Object[0];
            startRestartGroup.startReplaceGroup(38561279);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion4.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: x2.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState MultiRideSummaryCard$lambda$10$lambda$4$lambda$3;
                        MultiRideSummaryCard$lambda$10$lambda$4$lambda$3 = MultiRideSummaryCardKt.MultiRideSummaryCard$lambda$10$lambda$4$lambda$3();
                        return MultiRideSummaryCard$lambda$10$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            final MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, null, null, (Function0) rememberedValue2, startRestartGroup, 3072, 6);
            TicketSummaryBackgroundViewKt.m3563TicketSummaryBackgroundViewww6aTOc(ModifierExtensionsKt.defaultShadow$default(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), null, 1, null), ((Number) mutableState.getValue()).intValue(), ((Number) mutableState2.getValue()).intValue(), 0L, startRestartGroup, 0, 8);
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(16), 0.0f, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(477462389);
            boolean changed = startRestartGroup.changed(mutableState);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == companion4.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: x2.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit MultiRideSummaryCard$lambda$10$lambda$9$lambda$6$lambda$5;
                        MultiRideSummaryCard$lambda$10$lambda$9$lambda$6$lambda$5 = MultiRideSummaryCardKt.MultiRideSummaryCard$lambda$10$lambda$9$lambda$6$lambda$5(MutableState.this, (LayoutCoordinates) obj);
                        return MultiRideSummaryCard$lambda$10$lambda$9$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            TicketSummaryHeaderRowKt.TicketSummaryHeaderRow(OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) rememberedValue3), StringResources_androidKt.stringResource(R.string.simpleChange_summary_yourOrder, startRestartGroup, 6), null, startRestartGroup, 0, 4);
            float f5 = 2;
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(f5)), startRestartGroup, 3072, 7);
            MiddleContent(multiRideCardSummaryInfo, z5, startRestartGroup, i7 & 126);
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(f5)), startRestartGroup, 3072, 7);
            startRestartGroup.startReplaceGroup(477478356);
            boolean changed2 = startRestartGroup.changed(mutableState2);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue4 == companion4.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: x2.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit MultiRideSummaryCard$lambda$10$lambda$9$lambda$8$lambda$7;
                        MultiRideSummaryCard$lambda$10$lambda$9$lambda$8$lambda$7 = MultiRideSummaryCardKt.MultiRideSummaryCard$lambda$10$lambda$9$lambda$8$lambda$7(MutableState.this, (LayoutCoordinates) obj);
                        return MultiRideSummaryCard$lambda$10$lambda$9$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            TicketSummaryFooterRowKt.TicketSummaryFooterRow(OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) rememberedValue4), multiRideCardSummaryInfo.getTotalPrice(), null, null, null, null, null, startRestartGroup, 196608, 92);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: x2.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MultiRideSummaryCard$lambda$11;
                    MultiRideSummaryCard$lambda$11 = MultiRideSummaryCardKt.MultiRideSummaryCard$lambda$11(MultiRideCardSummaryInfo.this, z5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MultiRideSummaryCard$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideSummaryCard$lambda$0(MultiRideCardSummaryInfo multiRideCardSummaryInfo, boolean z5, int i5, Composer composer, int i6) {
        MultiRideSummaryCard(multiRideCardSummaryInfo, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState MultiRideSummaryCard$lambda$10$lambda$2$lambda$1() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState MultiRideSummaryCard$lambda$10$lambda$4$lambda$3() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideSummaryCard$lambda$10$lambda$9$lambda$6$lambda$5(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideSummaryCard$lambda$10$lambda$9$lambda$8$lambda$7(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideSummaryCard$lambda$11(MultiRideCardSummaryInfo multiRideCardSummaryInfo, boolean z5, int i5, Composer composer, int i6) {
        MultiRideSummaryCard(multiRideCardSummaryInfo, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
