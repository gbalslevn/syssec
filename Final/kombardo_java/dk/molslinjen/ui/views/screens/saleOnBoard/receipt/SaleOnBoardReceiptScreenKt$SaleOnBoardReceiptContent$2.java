package dk.molslinjen.ui.views.screens.saleOnBoard.receipt;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.booking.SaleOnBoardContactInfo;
import dk.molslinjen.domain.model.saleOnBoard.NotificationType;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStore;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardTimeSlot;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class SaleOnBoardReceiptScreenKt$SaleOnBoardReceiptContent$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState $saleOnBoardCheckoutState;
    final /* synthetic */ Function1<String, Unit> $showOrder;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SaleOnBoardReceiptScreenKt$SaleOnBoardReceiptContent$2(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, Function1<? super String, Unit> function1) {
        this.$saleOnBoardCheckoutState = saleOnBoardCheckoutState;
        this.$showOrder = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, Function1 function1) {
        String orderNumber = saleOnBoardCheckoutState.getOrderNumber();
        if (orderNumber != null) {
            function1.invoke(orderNumber);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        String saleOnBoardTimeSlot;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(71423004, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.receipt.SaleOnBoardReceiptContent.<anonymous> (SaleOnBoardReceiptScreen.kt:45)");
        }
        SaleOnBoardStore selectedStore = this.$saleOnBoardCheckoutState.getSelectedStore();
        if (selectedStore == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        PriceWithCurrency totalPrice = this.$saleOnBoardCheckoutState.getTotalPrice();
        IDepartureInfo selectedDeparture = this.$saleOnBoardCheckoutState.getSelectedDeparture();
        if (selectedDeparture == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        SaleOnBoardContactInfo contactInfo = this.$saleOnBoardCheckoutState.getContactInfo();
        NotificationType notificationType = this.$saleOnBoardCheckoutState.getNotificationType();
        List<SaleOnBoardLineItem> basketLineItems = this.$saleOnBoardCheckoutState.getBasketLineItems();
        SaleOnBoardTimeSlot selectedTimeSlot = this.$saleOnBoardCheckoutState.getSelectedTimeSlot();
        if (selectedTimeSlot != null && (saleOnBoardTimeSlot = selectedTimeSlot.toString()) != null) {
            String iconUrl = selectedStore.getIconUrl();
            String storeLocation = selectedStore.getStoreLocation();
            composer.startReplaceGroup(143724454);
            boolean changedInstance = composer.changedInstance(this.$saleOnBoardCheckoutState) | composer.changed(this.$showOrder);
            final SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState = this.$saleOnBoardCheckoutState;
            final Function1<String, Unit> function1 = this.$showOrder;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.receipt.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$2$lambda$1;
                        invoke$lambda$2$lambda$1 = SaleOnBoardReceiptScreenKt$SaleOnBoardReceiptContent$2.invoke$lambda$2$lambda$1(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState.this, function1);
                        return invoke$lambda$2$lambda$1;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            SaleOnBoardOrderViewKt.SaleOnBoardOrderView(storeLocation, iconUrl, saleOnBoardTimeSlot, basketLineItems, totalPrice, selectedDeparture, contactInfo, notificationType, false, (Function0) rememberedValue, false, composer, 0, 0, 1280);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
