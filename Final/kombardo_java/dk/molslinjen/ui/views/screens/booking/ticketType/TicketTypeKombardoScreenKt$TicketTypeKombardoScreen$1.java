package dk.molslinjen.ui.views.screens.booking.ticketType;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutButtonSheetBottomBarKt;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeKombardoViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TicketTypeKombardoScreenKt$TicketTypeKombardoScreen$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function2<Direction, Boolean, Unit> $proceed;
    final /* synthetic */ TicketTypeKombardoViewModel $viewModel;
    final /* synthetic */ TicketTypeKombardoViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public TicketTypeKombardoScreenKt$TicketTypeKombardoScreen$1(TicketTypeKombardoViewModel.ViewState viewState, TicketTypeKombardoViewModel ticketTypeKombardoViewModel, Function2<? super Direction, ? super Boolean, Unit> function2) {
        this.$viewState = viewState;
        this.$viewModel = ticketTypeKombardoViewModel;
        this.$proceed = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(TicketTypeKombardoViewModel ticketTypeKombardoViewModel, Function2 function2) {
        ticketTypeKombardoViewModel.proceed(function2);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        Price fromPrice;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1378189823, i5, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeKombardoScreen.<anonymous> (TicketTypeKombardoScreen.kt:83)");
        }
        String stringResource = StringResources_androidKt.stringResource(R.string.checkout_buttonBar_proceed, composer, 6);
        PassengerInfo passengerInfo = this.$viewState.getPassengerInfo();
        Departure departure = this.$viewState.getDeparture();
        PriceTotal priceTotal = (departure == null || (fromPrice = departure.getFromPrice()) == null) ? null : new PriceTotal(fromPrice);
        composer.startReplaceGroup(517732598);
        boolean changedInstance = composer.changedInstance(this.$viewModel) | composer.changed(this.$proceed);
        final TicketTypeKombardoViewModel ticketTypeKombardoViewModel = this.$viewModel;
        final Function2<Direction, Boolean, Unit> function2 = this.$proceed;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.ticketType.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = TicketTypeKombardoScreenKt$TicketTypeKombardoScreen$1.invoke$lambda$2$lambda$1(TicketTypeKombardoViewModel.this, function2);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        CheckoutButtonSheetBottomBarKt.CheckoutButtonSheetBottomBar(null, stringResource, priceTotal, false, passengerInfo, false, null, null, (Function0) rememberedValue, composer, 3072, 225);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
