package dk.molslinjen.ui.views.screens.agreements.multiride.common;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePriceStep;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.NumberSelectorHeight;
import dk.molslinjen.ui.views.reusable.input.NumberSelectorKt;
import dk.molslinjen.ui.views.reusable.input.PluralText;
import dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideChargesSelectionListKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aa\u0010\f\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a3\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bH\u0003¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;", "priceSteps", "selectedPriceStep", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "totalPrice", BuildConfig.FLAVOR, "chargeCount", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onPriceStepSelected", "onChargeCountUpdated", "MultiRideChargesSelectionList", "(Ljava/util/List;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "priceStep", BuildConfig.FLAVOR, "selected", "MultiRideChargesRow", "(Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MultiRideChargesSelectionListKt {
    private static final void MultiRideChargesRow(final MultiRidePriceStep multiRidePriceStep, final boolean z5, final Function1<? super MultiRidePriceStep, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer composer3;
        Composer startRestartGroup = composer.startRestartGroup(2042498559);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(multiRidePriceStep) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2042498559, i6, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideChargesRow (MultiRideChargesSelectionList.kt:110)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m327heightInVpY3zN4$default = SizeKt.m327heightInVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(34), 0.0f, 2, null);
            AppColor appColor = AppColor.INSTANCE;
            Modifier clip = ClipKt.clip(BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(m327heightInVpY3zN4$default, appColor.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(z5 ? 2 : 1), z5 ? appColor.m3255getBrandBlue10d7_KjU() : appColor.m3267getGrey40d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), ThemeShapesKt.getThemeShapes().getMedium());
            startRestartGroup.startReplaceGroup(-202886712);
            boolean changedInstance = ((i6 & 896) == 256) | startRestartGroup.changedInstance(multiRidePriceStep);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: x2.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MultiRideChargesRow$lambda$9$lambda$8;
                        MultiRideChargesRow$lambda$9$lambda$8 = MultiRideChargesSelectionListKt.MultiRideChargesRow$lambda$9$lambda$8(Function1.this, multiRidePriceStep);
                        return MultiRideChargesRow$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(ClickableKt.m122clickableXHw0xAI$default(clip, false, null, null, (Function0) rememberedValue, 7, null), Dp.m2599constructorimpl(16), Dp.m2599constructorimpl(8));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 54);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Integer max = multiRidePriceStep.getMax();
            if (max != null) {
                startRestartGroup.startReplaceGroup(-42281948);
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.multiRide_purchase_chargeRange, new Object[]{Integer.valueOf(multiRidePriceStep.getMin()), max}, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65534);
                composer2.endReplaceGroup();
            } else {
                composer2 = startRestartGroup;
                startRestartGroup.startReplaceGroup(-42092693);
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.multiRide_purchase_chargeRangeNoUpper, new Object[]{Integer.valueOf(multiRidePriceStep.getMin())}, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65534);
                composer2.endReplaceGroup();
            }
            Composer composer4 = composer2;
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), composer4, 0);
            final String stringResource = StringResources_androidKt.stringResource(R.string.multiRide_purchase_pricePerCharge, new Object[]{PriceFormatExtensionsKt.formatted(multiRidePriceStep.getPrice(), (Context) composer4.consume(AndroidCompositionLocals_androidKt.getLocalContext()))}, composer4, 6);
            composer4.startReplaceGroup(-139891493);
            boolean changed = composer4.changed(stringResource);
            Object rememberedValue2 = composer4.rememberedValue();
            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: x2.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit MultiRideChargesRow$lambda$12$lambda$11$lambda$10;
                        MultiRideChargesRow$lambda$12$lambda$11$lambda$10 = MultiRideChargesSelectionListKt.MultiRideChargesRow$lambda$12$lambda$11$lambda$10(stringResource, (SemanticsPropertyReceiver) obj);
                        return MultiRideChargesRow$lambda$12$lambda$11$lambda$10;
                    }
                };
                composer4.updateRememberedValue(rememberedValue2);
            }
            composer4.endReplaceGroup();
            composer3 = composer4;
            TextKt.m940Text4IGK_g(stringResource, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue2, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer3, 0, 1572864, 65532);
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: x2.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MultiRideChargesRow$lambda$13;
                    MultiRideChargesRow$lambda$13 = MultiRideChargesSelectionListKt.MultiRideChargesRow$lambda$13(MultiRidePriceStep.this, z5, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MultiRideChargesRow$lambda$13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideChargesRow$lambda$12$lambda$11$lambda$10(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, StringsKt.replace$default(str, "/", " / ", false, 4, (Object) null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideChargesRow$lambda$13(MultiRidePriceStep multiRidePriceStep, boolean z5, Function1 function1, int i5, Composer composer, int i6) {
        MultiRideChargesRow(multiRidePriceStep, z5, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideChargesRow$lambda$9$lambda$8(Function1 function1, MultiRidePriceStep multiRidePriceStep) {
        function1.invoke(multiRidePriceStep);
        return Unit.INSTANCE;
    }

    public static final void MultiRideChargesSelectionList(final List<MultiRidePriceStep> priceSteps, final MultiRidePriceStep multiRidePriceStep, final PriceWithCurrency priceWithCurrency, final int i5, final Function1<? super MultiRidePriceStep, Unit> onPriceStepSelected, final Function1<? super Integer, Unit> onChargeCountUpdated, Composer composer, final int i6) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(priceSteps, "priceSteps");
        Intrinsics.checkNotNullParameter(onPriceStepSelected, "onPriceStepSelected");
        Intrinsics.checkNotNullParameter(onChargeCountUpdated, "onChargeCountUpdated");
        Composer startRestartGroup = composer.startRestartGroup(2035437553);
        int i7 = (i6 & 6) == 0 ? (startRestartGroup.changedInstance(priceSteps) ? 4 : 2) | i6 : i6;
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(multiRidePriceStep) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(priceWithCurrency) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i7 |= startRestartGroup.changed(i5) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(onPriceStepSelected) ? 16384 : 8192;
        }
        if ((196608 & i6) == 0) {
            i7 |= startRestartGroup.changedInstance(onChargeCountUpdated) ? 131072 : 65536;
        }
        if ((74899 & i7) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2035437553, i7, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideChargesSelectionList (MultiRideChargesSelectionList.kt:48)");
            }
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(SizeKt.fillMaxWidth$default(ModifierExtensionsKt.closeKeyboardOnClickOutside(Modifier.INSTANCE, (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager())), 0.0f, 1, null), AppColor.INSTANCE.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(16));
            float f5 = 8;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(f5)), Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-1098097056);
            for (MultiRidePriceStep multiRidePriceStep2 : priceSteps) {
                MultiRideChargesRow(multiRidePriceStep2, Intrinsics.areEqual(multiRidePriceStep2, multiRidePriceStep), onPriceStepSelected, startRestartGroup, (i7 >> 6) & 896);
            }
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            NumberSelectorKt.NumberSelector(null, i5, 0, 0, Integer.MAX_VALUE, new PluralText.Resource(R.plurals.multiRide_charges), null, null, onChargeCountUpdated, onChargeCountUpdated, NumberSelectorHeight.Large, true, false, false, false, startRestartGroup, ((i7 >> 6) & 112) | 27648 | ((i7 << 9) & 234881024) | ((i7 << 12) & 1879048192), 54, 28869);
            startRestartGroup.startReplaceGroup(-1098073751);
            if (priceWithCurrency == null) {
                composer2 = startRestartGroup;
            } else {
                final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.HorizontalOrVertical spaceBetween = arrangement.getSpaceBetween();
                Alignment.Companion companion3 = Alignment.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, companion3.getCenterVertically(), startRestartGroup, 54);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.multiRide_purchase_totalPrice, startRestartGroup, 6), RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 0, 1572864, 65532);
                startRestartGroup.startReplaceGroup(-408195703);
                boolean changedInstance = startRestartGroup.changedInstance(priceWithCurrency) | startRestartGroup.changedInstance(context);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: x2.k
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit MultiRideChargesSelectionList$lambda$6$lambda$5$lambda$4$lambda$2$lambda$1;
                            MultiRideChargesSelectionList$lambda$6$lambda$5$lambda$4$lambda$2$lambda$1 = MultiRideChargesSelectionListKt.MultiRideChargesSelectionList$lambda$6$lambda$5$lambda$4$lambda$2$lambda$1(PriceWithCurrency.this, context, (SemanticsPropertyReceiver) obj);
                            return MultiRideChargesSelectionList$lambda$6$lambda$5$lambda$4$lambda$2$lambda$1;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion2, (Function1) rememberedValue);
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getTop(), startRestartGroup, 0);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics);
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
                Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(PriceWithCurrency.formattedValue$default(priceWithCurrency, false, 1, null), rowScopeInstance.alignByBaseline(companion2), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH2Bold(), composer2, 0, 1572864, 65532);
                TextKt.m940Text4IGK_g(PriceFormatExtensionsKt.formatted(priceWithCurrency.getCurrencyType(), context), PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance.alignByBaseline(companion2), Dp.m2599constructorimpl(2), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65532);
                composer2.endNode();
                composer2.endNode();
                Unit unit = Unit.INSTANCE;
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: x2.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MultiRideChargesSelectionList$lambda$7;
                    MultiRideChargesSelectionList$lambda$7 = MultiRideChargesSelectionListKt.MultiRideChargesSelectionList$lambda$7(priceSteps, multiRidePriceStep, priceWithCurrency, i5, onPriceStepSelected, onChargeCountUpdated, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return MultiRideChargesSelectionList$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideChargesSelectionList$lambda$6$lambda$5$lambda$4$lambda$2$lambda$1(PriceWithCurrency priceWithCurrency, Context context, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, PriceFormatExtensionsKt.formatted(priceWithCurrency, context));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideChargesSelectionList$lambda$7(List list, MultiRidePriceStep multiRidePriceStep, PriceWithCurrency priceWithCurrency, int i5, Function1 function1, Function1 function12, int i6, Composer composer, int i7) {
        MultiRideChargesSelectionList(list, multiRidePriceStep, priceWithCurrency, i5, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }
}
