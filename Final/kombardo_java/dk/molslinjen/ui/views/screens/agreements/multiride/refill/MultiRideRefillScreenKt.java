package dk.molslinjen.ui.views.screens.agreements.multiride.refill;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
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
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePriceStep;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePurchaseInfo;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.InfoBoxViewKt;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideChargesSelectionListKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.refill.MultiRideRefillScreenKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.refill.MultiRideRefillViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001ak\u0010\u0016\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u0013H\u0003¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/refill/MultiRideRefillViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "MultiRideRefillScreen", "(Ldk/molslinjen/ui/views/screens/agreements/multiride/refill/MultiRideRefillViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/ScrollState;", "scrollState", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "multiRideCard", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePurchaseInfo;", "purchaseInfo", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;", "selectedPriceStep", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "totalPrice", BuildConfig.FLAVOR, "chargeCount", "Lkotlin/Function1;", "onPriceStepSelected", "onChargeCountUpdated", "Content", "(Landroidx/compose/foundation/ScrollState;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePurchaseInfo;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MultiRideRefillScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Content(final ScrollState scrollState, final MultiRideCard multiRideCard, final MultiRidePurchaseInfo multiRidePurchaseInfo, final MultiRidePriceStep multiRidePriceStep, final PriceWithCurrency priceWithCurrency, final int i5, final Function1<? super MultiRidePriceStep, Unit> function1, final Function1<? super Integer, Unit> function12, Composer composer, final int i6) {
        int i7;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-349194227);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changed(scrollState) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(multiRideCard) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(multiRidePurchaseInfo) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(multiRidePriceStep) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(priceWithCurrency) ? 16384 : 8192;
        }
        if ((196608 & i6) == 0) {
            i7 |= startRestartGroup.changed(i5) ? 131072 : 65536;
        }
        if ((1572864 & i6) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((12582912 & i6) == 0) {
            i7 |= startRestartGroup.changedInstance(function12) ? 8388608 : 4194304;
        }
        if ((4793491 & i7) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-349194227, i7, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.refill.Content (MultiRideRefillScreen.kt:109)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 24;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(ScrollKt.verticalScroll$default(companion, scrollState, false, null, false, 14, null), Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null);
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
            final String stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_number, new Object[]{multiRideCard.getId()}, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-1448442230);
            boolean changed = startRestartGroup.changed(stringResource);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: C2.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$6$lambda$3$lambda$2;
                        Content$lambda$6$lambda$3$lambda$2 = MultiRideRefillScreenKt.Content$lambda$6$lambda$3$lambda$2(stringResource, (SemanticsPropertyReceiver) obj);
                        return Content$lambda$6$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.m940Text4IGK_g("#" + multiRideCard.getId(), SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 384, 1572864, 65528);
            float f6 = (float) 4;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.multiRide_refill_currentCharges, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 0, 1572864, 65534);
            int remainingCharges = multiRideCard.isExpired() ? 0 : multiRideCard.getRemainingCharges();
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
            TextKt.m940Text4IGK_g(StringResources_androidKt.pluralStringResource(R.plurals.multiRide_numberOfCharges, remainingCharges, new Object[]{Integer.valueOf(remainingCharges)}, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 0, 1572864, 65534);
            startRestartGroup.endNode();
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            MultiRideChargesSelectionListKt.MultiRideChargesSelectionList(multiRidePurchaseInfo.getPriceSteps(), multiRidePriceStep, priceWithCurrency, i5, function1, function12, startRestartGroup, (i7 >> 6) & 524272);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer2, 6);
            String validToDescription = multiRidePurchaseInfo.getValidToDescription();
            composer2.startReplaceGroup(-1448399725);
            if (validToDescription != null) {
                InfoBoxViewKt.InfoBoxView(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0, validToDescription, false, composer2, 6, 10);
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
            endRestartGroup.updateScope(new Function2() { // from class: C2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$7;
                    Content$lambda$7 = MultiRideRefillScreenKt.Content$lambda$7(ScrollState.this, multiRideCard, multiRidePurchaseInfo, multiRidePriceStep, priceWithCurrency, i5, function1, function12, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$6$lambda$3$lambda$2(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$7(ScrollState scrollState, MultiRideCard multiRideCard, MultiRidePurchaseInfo multiRidePurchaseInfo, MultiRidePriceStep multiRidePriceStep, PriceWithCurrency priceWithCurrency, int i5, Function1 function1, Function1 function12, int i6, Composer composer, int i7) {
        Content(scrollState, multiRideCard, multiRidePurchaseInfo, multiRidePriceStep, priceWithCurrency, i5, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }

    public static final void MultiRideRefillScreen(final MultiRideRefillViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-1541381534);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1541381534, i6, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.refill.MultiRideRefillScreen (MultiRideRefillScreen.kt:59)");
            }
            final MultiRideRefillViewModel.ViewState viewState = (MultiRideRefillViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            final IMultiRideCardCheckoutManager.CheckoutState checkoutState = (IMultiRideCardCheckoutManager.CheckoutState) SnapshotStateKt.collectAsState(viewModel.getCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            final ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            boolean z5 = checkoutState.getNumberOfCharges() > 0;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.multiRide_refill, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(793428943);
            boolean z6 = (i6 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MultiRideRefillScreenKt$MultiRideRefillScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(2069865632, true, new MultiRideRefillScreenKt$MultiRideRefillScreen$2(checkoutState, z5, navigator), startRestartGroup, 54);
            ComposableLambda rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(191721391, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.refill.MultiRideRefillScreenKt$MultiRideRefillScreen$3
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i7) {
                    Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                    if ((i7 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(191721391, i7, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.refill.MultiRideRefillScreen.<anonymous> (MultiRideRefillScreen.kt:80)");
                    }
                    boolean isLoading = MultiRideRefillViewModel.ViewState.this.getIsLoading();
                    final IMultiRideCardCheckoutManager.CheckoutState checkoutState2 = checkoutState;
                    final ScrollState scrollState = rememberScrollState;
                    final MultiRideRefillViewModel multiRideRefillViewModel = viewModel;
                    LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, isLoading, 0, false, null, ComposableLambdaKt.rememberComposableLambda(-1218011653, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.refill.MultiRideRefillScreenKt$MultiRideRefillScreen$3.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i8) {
                            if ((i8 & 3) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1218011653, i8, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.refill.MultiRideRefillScreen.<anonymous>.<anonymous> (MultiRideRefillScreen.kt:81)");
                            }
                            MultiRidePurchaseInfo selectedPurchaseInfo = IMultiRideCardCheckoutManager.CheckoutState.this.getSelectedPurchaseInfo();
                            MultiRideCard multiRideCardToRefill = IMultiRideCardCheckoutManager.CheckoutState.this.getMultiRideCardToRefill();
                            if (selectedPurchaseInfo != null && multiRideCardToRefill != null) {
                                ScrollState scrollState2 = scrollState;
                                MultiRidePriceStep selectedPriceStep = IMultiRideCardCheckoutManager.CheckoutState.this.getSelectedPriceStep();
                                PriceWithCurrency totalPrice = IMultiRideCardCheckoutManager.CheckoutState.this.getTotalPrice();
                                int numberOfCharges = IMultiRideCardCheckoutManager.CheckoutState.this.getNumberOfCharges();
                                MultiRideRefillViewModel multiRideRefillViewModel2 = multiRideRefillViewModel;
                                composer4.startReplaceGroup(-1274534376);
                                boolean changedInstance = composer4.changedInstance(multiRideRefillViewModel2);
                                Object rememberedValue2 = composer4.rememberedValue();
                                if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new MultiRideRefillScreenKt$MultiRideRefillScreen$3$1$1$1(multiRideRefillViewModel2);
                                    composer4.updateRememberedValue(rememberedValue2);
                                }
                                composer4.endReplaceGroup();
                                Function1 function1 = (Function1) ((KFunction) rememberedValue2);
                                MultiRideRefillViewModel multiRideRefillViewModel3 = multiRideRefillViewModel;
                                composer4.startReplaceGroup(-1274531854);
                                boolean changedInstance2 = composer4.changedInstance(multiRideRefillViewModel3);
                                Object rememberedValue3 = composer4.rememberedValue();
                                if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = new MultiRideRefillScreenKt$MultiRideRefillScreen$3$1$2$1(multiRideRefillViewModel3);
                                    composer4.updateRememberedValue(rememberedValue3);
                                }
                                composer4.endReplaceGroup();
                                MultiRideRefillScreenKt.Content(scrollState2, multiRideCardToRefill, selectedPurchaseInfo, selectedPriceStep, totalPrice, numberOfCharges, function1, (Function1) ((KFunction) rememberedValue3), composer4, 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54), composer3, 1572864, 59);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(fillMaxSize$default, 0.0f, stringResource, null, 0L, null, (Function0) rememberedValue, rememberScrollState, rememberComposableLambda, rememberComposableLambda2, startRestartGroup, 905969670, 58);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: C2.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MultiRideRefillScreen$lambda$1;
                    MultiRideRefillScreen$lambda$1 = MultiRideRefillScreenKt.MultiRideRefillScreen$lambda$1(MultiRideRefillViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MultiRideRefillScreen$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideRefillScreen$lambda$1(MultiRideRefillViewModel multiRideRefillViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        MultiRideRefillScreen(multiRideRefillViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
