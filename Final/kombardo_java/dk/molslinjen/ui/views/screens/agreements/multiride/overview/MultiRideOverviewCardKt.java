package dk.molslinjen.ui.views.screens.agreements.multiride.overview;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.views.reusable.VerticalDividerKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideCardInfoViewKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideExpireInfoBoxKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideOverviewCardKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001aW\u0010\t\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0002H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "multiRideCard", "Lkotlin/Function1;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardNumber;", BuildConfig.FLAVOR, "navigateToDetails", "navigateToOrderTicket", "navigateToRefillMultiRide", "MultiRideOverviewCard", "(Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MultiRideOverviewCardKt {
    public static final void MultiRideOverviewCard(final MultiRideCard multiRideCard, final Function1<? super String, Unit> navigateToDetails, final Function1<? super MultiRideCard, Unit> navigateToOrderTicket, final Function1<? super String, Unit> navigateToRefillMultiRide, Composer composer, final int i5) {
        int i6;
        boolean z5;
        int i7;
        Composer composer2;
        Composer composer3;
        Intrinsics.checkNotNullParameter(multiRideCard, "multiRideCard");
        Intrinsics.checkNotNullParameter(navigateToDetails, "navigateToDetails");
        Intrinsics.checkNotNullParameter(navigateToOrderTicket, "navigateToOrderTicket");
        Intrinsics.checkNotNullParameter(navigateToRefillMultiRide, "navigateToRefillMultiRide");
        Composer startRestartGroup = composer.startRestartGroup(-2017931324);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(multiRideCard) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToDetails) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToOrderTicket) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToRefillMultiRide) ? 2048 : 1024;
        }
        int i8 = i6;
        if ((i8 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2017931324, i8, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideOverviewCard (MultiRideOverviewCard.kt:48)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(SizeKt.fillMaxWidth$default(ModifierExtensionsKt.defaultShadow(companion, ThemeShapesKt.getThemeShapes().getMedium()), 0.0f, 1, null), multiRideCard.isExpired() ? AppColor.INSTANCE.m3269getGrey60d7_KjU() : AppColor.INSTANCE.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium());
            startRestartGroup.startReplaceGroup(-1649304023);
            boolean changedInstance = ((i8 & 112) == 32) | startRestartGroup.changedInstance(multiRideCard);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: A2.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MultiRideOverviewCard$lambda$1$lambda$0;
                        MultiRideOverviewCard$lambda$1$lambda$0 = MultiRideOverviewCardKt.MultiRideOverviewCard$lambda$1$lambda$0(Function1.this, multiRideCard);
                        return MultiRideOverviewCard$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            float f5 = 16;
            float f6 = 8;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(ClickableKt.m122clickableXHw0xAI$default(m103backgroundbw27NRU, false, null, null, (Function0) rememberedValue, 7, null), Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0.0f, Dp.m2599constructorimpl(f6), 0.0f, Dp.m2599constructorimpl(f5), 5, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            boolean isExpired = multiRideCard.isExpired();
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(IntrinsicKt.height(companion, IntrinsicSize.Min), 0.0f, 1, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            MultiRideCardInfoViewKt.MultiRideCardInfoView(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), multiRideCard, startRestartGroup, (i8 << 3) & 112, 0);
            VerticalDividerKt.m3394VerticalDividertZIQpXc(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(2)), startRestartGroup, 3078, 6);
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            Modifier m331size3ABfNKs = SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(f5));
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_chevron_right, startRestartGroup, 6);
            String skip = Accessibility.INSTANCE.getSkip();
            AppColor appColor = AppColor.INSTANCE;
            IconKt.m857Iconww6aTOc(painterResource, skip, m331size3ABfNKs, appColor.m3253getBrandBlack10d7_KjU(), startRestartGroup, 3456, 0);
            startRestartGroup.endNode();
            MultiRideExpireInfoBoxKt.MultiRideExpireInfoBox(multiRideCard, startRestartGroup, i8 & 14);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(f5)), companion2.getTop(), startRestartGroup, 6);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            startRestartGroup.startReplaceGroup(-364206073);
            if (isExpired || multiRideCard.getRemainingCharges() <= 0) {
                z5 = false;
                i7 = i8;
                composer2 = startRestartGroup;
            } else {
                Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
                String stringResource = StringResources_androidKt.stringResource(R.string.button_orderTicket, startRestartGroup, 6);
                ButtonConfig buttonConfig = ButtonConfig.Regular;
                startRestartGroup.startReplaceGroup(-364196588);
                boolean changedInstance2 = ((i8 & 896) == 256) | startRestartGroup.changedInstance(multiRideCard);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: A2.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit MultiRideOverviewCard$lambda$8$lambda$7$lambda$4$lambda$3;
                            MultiRideOverviewCard$lambda$8$lambda$7$lambda$4$lambda$3 = MultiRideOverviewCardKt.MultiRideOverviewCard$lambda$8$lambda$7$lambda$4$lambda$3(Function1.this, multiRideCard);
                            return MultiRideOverviewCard$lambda$8$lambda$7$lambda$4$lambda$3;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                z5 = false;
                i7 = i8;
                composer2 = startRestartGroup;
                PrimaryButtonKt.PrimaryButton(weight$default, stringResource, (Function0) rememberedValue2, null, buttonConfig, false, false, false, startRestartGroup, 24576, 232);
            }
            composer2.endReplaceGroup();
            Composer composer4 = composer2;
            composer4.startReplaceGroup(-364192049);
            if (multiRideCard.getEnableForRefill()) {
                Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.multiRide_refill, composer4, 6);
                ButtonConfig buttonConfig2 = ButtonConfig.Regular;
                long m3269getGrey60d7_KjU = isExpired ? appColor.m3269getGrey60d7_KjU() : appColor.m3281getWhite0d7_KjU();
                composer4.startReplaceGroup(-364180549);
                boolean changedInstance3 = composer4.changedInstance(multiRideCard) | ((i7 & 7168) == 2048 ? true : z5);
                Object rememberedValue3 = composer4.rememberedValue();
                if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: A2.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit MultiRideOverviewCard$lambda$8$lambda$7$lambda$6$lambda$5;
                            MultiRideOverviewCard$lambda$8$lambda$7$lambda$6$lambda$5 = MultiRideOverviewCardKt.MultiRideOverviewCard$lambda$8$lambda$7$lambda$6$lambda$5(Function1.this, multiRideCard);
                            return MultiRideOverviewCard$lambda$8$lambda$7$lambda$6$lambda$5;
                        }
                    };
                    composer4.updateRememberedValue(rememberedValue3);
                }
                Function0 function0 = (Function0) rememberedValue3;
                composer4.endReplaceGroup();
                composer3 = composer4;
                SecondaryButtonKt.m3406SecondaryButtonbZJ32A(weight$default2, stringResource2, function0, null, false, buttonConfig2, false, null, null, m3269getGrey60d7_KjU, false, composer3, 196608, 0, 1496);
            } else {
                composer3 = composer4;
            }
            composer3.endReplaceGroup();
            composer3.endNode();
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: A2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MultiRideOverviewCard$lambda$9;
                    MultiRideOverviewCard$lambda$9 = MultiRideOverviewCardKt.MultiRideOverviewCard$lambda$9(MultiRideCard.this, navigateToDetails, navigateToOrderTicket, navigateToRefillMultiRide, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MultiRideOverviewCard$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideOverviewCard$lambda$1$lambda$0(Function1 function1, MultiRideCard multiRideCard) {
        function1.invoke(multiRideCard.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideOverviewCard$lambda$8$lambda$7$lambda$4$lambda$3(Function1 function1, MultiRideCard multiRideCard) {
        function1.invoke(multiRideCard);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideOverviewCard$lambda$8$lambda$7$lambda$6$lambda$5(Function1 function1, MultiRideCard multiRideCard) {
        function1.invoke(multiRideCard.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideOverviewCard$lambda$9(MultiRideCard multiRideCard, Function1 function1, Function1 function12, Function1 function13, int i5, Composer composer, int i6) {
        MultiRideOverviewCard(multiRideCard, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
