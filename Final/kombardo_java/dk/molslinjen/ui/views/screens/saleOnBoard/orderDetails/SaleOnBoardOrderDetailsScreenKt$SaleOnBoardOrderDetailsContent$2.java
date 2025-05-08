package dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import dk.molslinjen.domain.model.booking.SaleOnBoardContactInfo;
import dk.molslinjen.domain.model.saleOnBoard.NotificationType;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardDeparture;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.domain.SaleOnBoardOrderExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.buttons.DestructiveButtonKt;
import dk.molslinjen.ui.views.reusable.dialog.DeleteDialogKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsViewModel;
import dk.molslinjen.ui.views.screens.saleOnBoard.receipt.SaleOnBoardOrderViewKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsContent$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function1<SaleOnBoardOrder, Unit> $cancelOrder;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ Function0<Unit> $showCancelOrderDisabledMessage;
    final /* synthetic */ Function0<Unit> $startCancelOrder;
    final /* synthetic */ SaleOnBoardOrderDetailsViewModel.ViewState $state;
    final /* synthetic */ Function0<Unit> $stopCancelOrder;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsContent$2(SaleOnBoardOrderDetailsViewModel.ViewState viewState, ScrollState scrollState, Function1<? super SaleOnBoardOrder, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        this.$state = viewState;
        this.$scrollState = scrollState;
        this.$cancelOrder = function1;
        this.$stopCancelOrder = function0;
        this.$startCancelOrder = function02;
        this.$showCancelOrderDisabledMessage = function03;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1$lambda$0(Function1 function1, SaleOnBoardOrder saleOnBoardOrder) {
        function1.invoke(saleOnBoardOrder);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        final SaleOnBoardOrder saleOnBoardOrder;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(998197289, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsContent.<anonymous> (SaleOnBoardOrderDetailsScreen.kt:126)");
        }
        SaleOnBoardOrder order = this.$state.getOrder();
        if (order == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier verticalScroll$default = ScrollKt.verticalScroll$default(companion, this.$scrollState, false, null, false, 14, null);
        SaleOnBoardOrderDetailsViewModel.ViewState viewState = this.$state;
        final Function1<SaleOnBoardOrder, Unit> function1 = this.$cancelOrder;
        Function0<Unit> function0 = this.$stopCancelOrder;
        Function0<Unit> function02 = this.$startCancelOrder;
        Function0<Unit> function03 = this.$showCancelOrderDisabledMessage;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, verticalScroll$default);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        SaleOnBoardOrderDetailsScreenKt.HeadlineStatus(order, composer, 0);
        PriceWithCurrency priceWithCurrency = order.totalPrice();
        SaleOnBoardDeparture departure = order.getDeparture();
        SaleOnBoardContactInfo contactInfo = order.getContactInfo();
        NotificationType notificationType = order.getNotificationType();
        List<SaleOnBoardLineItem> lineItems = order.getLineItems();
        SaleOnBoardOrderViewKt.SaleOnBoardOrderView(order.getShopLocation(), order.getShopImageUrl(), SaleOnBoardOrderExtensionsKt.timeFormatted(order), lineItems, priceWithCurrency, departure, contactInfo, notificationType, order.isActive(), null, order.getStatus() == SaleOnBoardOrder.OrderStatus.Done, composer, 805306368, 0, 0);
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(32)), composer, 6);
        composer.startReplaceGroup(1269533973);
        if (order.isActive() && order.getStatus() != SaleOnBoardOrder.OrderStatus.Cancelled) {
            composer.startReplaceGroup(1269536537);
            if (viewState.getShowCancelOrderDialog()) {
                String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_orderDetails_cancel_dialog_title, composer, 6);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.saleOnBoard_orderDetails_cancel, composer, 6);
                boolean isCancellingOrder = viewState.getIsCancellingOrder();
                composer.startReplaceGroup(1269548404);
                saleOnBoardOrder = order;
                boolean changed = composer.changed(function1) | composer.changedInstance(saleOnBoardOrder);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit invoke$lambda$2$lambda$1$lambda$0;
                            invoke$lambda$2$lambda$1$lambda$0 = SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsContent$2.invoke$lambda$2$lambda$1$lambda$0(Function1.this, saleOnBoardOrder);
                            return invoke$lambda$2$lambda$1$lambda$0;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                DeleteDialogKt.DeleteDialog(stringResource, null, stringResource2, null, isCancellingOrder, (Function0) rememberedValue, function0, composer, 0, 10);
            } else {
                saleOnBoardOrder = order;
            }
            composer.endReplaceGroup();
            DestructiveButtonKt.DestructiveButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), StringResources_androidKt.stringResource(R.string.saleOnBoard_orderDetails_cancel, composer, 6), function02, function03, null, saleOnBoardOrder.getStatus() == SaleOnBoardOrder.OrderStatus.Received, false, composer, 6, 80);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(40)), composer, 6);
        }
        composer.endReplaceGroup();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
