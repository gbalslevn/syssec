package dk.molslinjen.ui.views.screens.tickets.details;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.domain.extensions.domain.BookingExtensionsKt;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingDeparture;
import dk.molslinjen.domain.model.booking.BookingTicket;
import dk.molslinjen.domain.model.booking.RouteType;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.ui.views.reusable.barcode.BarcodeViewType;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.TravelDetailsState;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidity;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TicketDetailsScreenKt$topSection$4 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ Function4<String, String, BarcodeViewType, BarcodeValidity, Unit> $expandBarcode;
    final /* synthetic */ Function1<String, Unit> $showOnMap;
    final /* synthetic */ Function3<String, String, Site, Unit> $startEarlyCheckIn;
    final /* synthetic */ TicketDetailsViewModel.ViewState $state;
    final /* synthetic */ TravelDetailsState $travelDetailsState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public TicketDetailsScreenKt$topSection$4(TicketDetailsViewModel.ViewState viewState, TravelDetailsState travelDetailsState, Function4<? super String, ? super String, ? super BarcodeViewType, ? super BarcodeValidity, Unit> function4, Function1<? super String, Unit> function1, Function3<? super String, ? super String, ? super Site, Unit> function3) {
        this.$state = viewState;
        this.$travelDetailsState = travelDetailsState;
        this.$expandBarcode = function4;
        this.$showOnMap = function1;
        this.$startEarlyCheckIn = function3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function3 function3, TicketDetailsViewModel.ViewState viewState) {
        function3.invoke(viewState.getReservationNumber(), viewState.getPhone(), viewState.getSite());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer composer, int i5) {
        BookingTicket ticket;
        BookingDeparture departure;
        BookingTicket ticket2;
        Transportation transport;
        BookingTicket ticket3;
        BookingDeparture departure2;
        BookingDeparture departure3;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(503894787, i5, -1, "dk.molslinjen.ui.views.screens.tickets.details.topSection.<anonymous> (TicketDetailsScreen.kt:363)");
        }
        Booking booking = this.$state.getBooking();
        RouteType routeType = null;
        BookingTicket ticket4 = booking != null ? booking.getTicket() : null;
        boolean z5 = true;
        boolean z6 = (ticket4 == null || (departure3 = ticket4.getDeparture()) == null || !BookingExtensionsKt.isEarlyCheckInAllowedNow(departure3)) ? false : true;
        Booking booking2 = this.$state.getBooking();
        if (booking2 != null && (ticket3 = booking2.getTicket()) != null && (departure2 = ticket3.getDeparture()) != null) {
            routeType = departure2.getRouteType();
        }
        String reservationNumber = this.$state.getReservationNumber();
        Booking booking3 = this.$state.getBooking();
        boolean z7 = (booking3 == null || (ticket2 = booking3.getTicket()) == null || (transport = ticket2.getTransport()) == null || !transport.isWalking()) ? false : true;
        boolean z8 = (ticket4 == null || (departure = ticket4.getDeparture()) == null || !departure.isEarlyCheckInPossible()) ? false : true;
        Booking booking4 = this.$state.getBooking();
        boolean z9 = (booking4 == null || (ticket = booking4.getTicket()) == null || !ticket.isCheckedIn()) ? false : true;
        if (routeType != null && routeType != RouteType.Shuttle) {
            z5 = false;
        }
        TravelDetailsState travelDetailsState = this.$travelDetailsState;
        Function4<String, String, BarcodeViewType, BarcodeValidity, Unit> function4 = this.$expandBarcode;
        Function1<String, Unit> function1 = this.$showOnMap;
        composer.startReplaceGroup(-314134310);
        boolean changed = composer.changed(this.$startEarlyCheckIn) | composer.changedInstance(this.$state);
        final Function3<String, String, Site, Unit> function3 = this.$startEarlyCheckIn;
        final TicketDetailsViewModel.ViewState viewState = this.$state;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.details.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = TicketDetailsScreenKt$topSection$4.invoke$lambda$1$lambda$0(Function3.this, viewState);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        BarcodeAndEarlyCheckInSectionKt.BarcodeAndEarlyCheckInSection(reservationNumber, z8, z6, z5, z9, z7, travelDetailsState, function4, function1, (Function0) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
