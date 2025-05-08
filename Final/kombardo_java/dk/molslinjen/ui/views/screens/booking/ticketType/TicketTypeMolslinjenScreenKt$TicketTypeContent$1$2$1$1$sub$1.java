package dk.molslinjen.ui.views.screens.booking.ticketType;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.CheapestTicketType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TicketTypeMolslinjenScreenKt$TicketTypeContent$1$2$1$1$sub$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Departure $departure;
    final /* synthetic */ String $fewTicketsAvailableTicketCategoryId;
    final /* synthetic */ float $screenWidth;
    final /* synthetic */ DepartureTicket $ticket;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TicketTypeMolslinjenScreenKt$TicketTypeContent$1$2$1$1$sub$1(DepartureTicket departureTicket, Departure departure, String str, float f5) {
        this.$ticket = departureTicket;
        this.$departure = departure;
        this.$fewTicketsAvailableTicketCategoryId = str;
        this.$screenWidth = f5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(DepartureTicket it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1967347945, i5, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TicketTypeMolslinjenScreen.kt:190)");
        }
        DepartureTicket departureTicket = this.$ticket;
        CheapestTicketType cheapestTicketType = this.$departure.getCheapestTicketType();
        boolean areEqual = Intrinsics.areEqual(this.$fewTicketsAvailableTicketCategoryId, this.$ticket.getCategory().getId());
        float m2599constructorimpl = Dp.m2599constructorimpl(this.$screenWidth * 0.8f);
        composer.startReplaceGroup(-479426877);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.ticketType.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = TicketTypeMolslinjenScreenKt$TicketTypeContent$1$2$1$1$sub$1.invoke$lambda$1$lambda$0((DepartureTicket) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        TicketTypeMolslinjenScreenKt.m3475TicketTypeDetailsViewjt2gSs(departureTicket, cheapestTicketType, areEqual, m2599constructorimpl, (Function1) rememberedValue, composer, 24576);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
