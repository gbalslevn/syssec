package dk.molslinjen.ui.views.screens.agreements.multiride.purchase;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePriceStep;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePurchaseInfo;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.InfoBoxViewKt;
import dk.molslinjen.ui.views.reusable.SegmentedControlKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideChargesSelectionListKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiRidePurchaseScreenKt$Content$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ IMultiRideCardCheckoutManager.CheckoutState $checkoutState;
    final /* synthetic */ Function1<Integer, Unit> $onChargeCountUpdated;
    final /* synthetic */ Function1<MultiRidePriceStep, Unit> $onPriceStepSelected;
    final /* synthetic */ Function1<MultiRidePurchaseInfo, Unit> $onPurchaseInfoSelected;
    final /* synthetic */ ScrollState $scrollState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public MultiRidePurchaseScreenKt$Content$1(ScrollState scrollState, IMultiRideCardCheckoutManager.CheckoutState checkoutState, Function1<? super MultiRidePurchaseInfo, Unit> function1, Function1<? super MultiRidePriceStep, Unit> function12, Function1<? super Integer, Unit> function13) {
        this.$scrollState = scrollState;
        this.$checkoutState = checkoutState;
        this.$onPurchaseInfoSelected = function1;
        this.$onPriceStepSelected = function12;
        this.$onChargeCountUpdated = function13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$2$lambda$1(Function1 function1, List list, int i5) {
        function1.invoke(list.get(i5));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        int currentMarker = composer.getCurrentMarker();
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2039004605, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.Content.<anonymous> (MultiRidePurchaseScreen.kt:129)");
        }
        float f5 = 24;
        Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), this.$scrollState, false, null, false, 14, null), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(16));
        IMultiRideCardCheckoutManager.CheckoutState checkoutState = this.$checkoutState;
        final Function1<MultiRidePurchaseInfo, Unit> function1 = this.$onPurchaseInfoSelected;
        Function1<MultiRidePriceStep, Unit> function12 = this.$onPriceStepSelected;
        Function1<Integer, Unit> function13 = this.$onChargeCountUpdated;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m312paddingVpY3zN4);
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        composer.startReplaceGroup(-1531712308);
        final List<MultiRidePurchaseInfo> purchaseInfos = checkoutState.getPurchaseInfos();
        if (purchaseInfos == null) {
            composer.endToMarker(currentMarker);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        MultiRidePurchaseInfo selectedPurchaseInfo = checkoutState.getSelectedPurchaseInfo();
        if (selectedPurchaseInfo == null) {
            composer.endToMarker(currentMarker);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        List<MultiRidePurchaseInfo> list = purchaseInfos;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((MultiRidePurchaseInfo) it.next()).getTicketTypeName());
        }
        InfoBoxViewKt.InfoBoxView(null, 0, StringResources_androidKt.stringResource(R.string.multiRide_purchase_molslinjenDestination_disclaimer, composer, 6), false, composer, 0, 11);
        Modifier.Companion companion2 = Modifier.INSTANCE;
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), composer, 6);
        int indexOf = purchaseInfos.indexOf(selectedPurchaseInfo);
        composer.startReplaceGroup(1613174615);
        boolean changed = composer.changed(function1) | composer.changedInstance(purchaseInfos);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.purchase.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$6$lambda$2$lambda$1;
                    invoke$lambda$6$lambda$2$lambda$1 = MultiRidePurchaseScreenKt$Content$1.invoke$lambda$6$lambda$2$lambda$1(Function1.this, purchaseInfos, ((Integer) obj).intValue());
                    return invoke$lambda$6$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        SegmentedControlKt.SegmentedControlStrings(null, arrayList, indexOf, (Function1) rememberedValue, composer, 0, 1);
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(22)), composer, 6);
        composer.startReplaceGroup(1613183465);
        List<String> terms = selectedPurchaseInfo.getTerms();
        composer.startReplaceGroup(1613184412);
        if (!terms.isEmpty()) {
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(8)), Alignment.INSTANCE.getStart(), composer, 6);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion2);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (composer.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer);
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            composer.startReplaceGroup(856746911);
            Iterator<T> it2 = terms.iterator();
            while (it2.hasNext()) {
                MultiRidePurchaseScreenKt.TermsLine((String) it2.next(), composer, 0);
            }
            composer.endReplaceGroup();
            composer.endNode();
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(f5)), composer, 6);
        }
        composer.endReplaceGroup();
        composer.endReplaceGroup();
        MultiRideChargesSelectionListKt.MultiRideChargesSelectionList(selectedPurchaseInfo.getPriceSteps(), checkoutState.getSelectedPriceStep(), checkoutState.getTotalPrice(), checkoutState.getNumberOfCharges(), function12, function13, composer, 0);
        composer.endReplaceGroup();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
