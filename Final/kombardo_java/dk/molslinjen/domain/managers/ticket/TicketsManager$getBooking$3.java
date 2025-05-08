package dk.molslinjen.domain.managers.ticket;

import dk.molslinjen.api.services.booking.response.booking.BookingWrapperResponseDTO;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.ticket.TicketsManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/domain/model/booking/Booking;", "data", "Ldk/molslinjen/api/services/booking/response/booking/BookingWrapperResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.ticket.TicketsManager$getBooking$3", f = "TicketsManager.kt", l = {335}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TicketsManager$getBooking$3 extends SuspendLambda implements Function2<BookingWrapperResponseDTO, Continuation<? super Booking>, Object> {
    final /* synthetic */ Site $site;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TicketsManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketsManager$getBooking$3(TicketsManager ticketsManager, Site site, Continuation<? super TicketsManager$getBooking$3> continuation) {
        super(2, continuation);
        this.this$0 = ticketsManager;
        this.$site = site;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TicketsManager$getBooking$3 ticketsManager$getBooking$3 = new TicketsManager$getBooking$3(this.this$0, this.$site, continuation);
        ticketsManager$getBooking$3.L$0 = obj;
        return ticketsManager$getBooking$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(BookingWrapperResponseDTO bookingWrapperResponseDTO, Continuation<? super Booking> continuation) {
        return ((TicketsManager$getBooking$3) create(bookingWrapperResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IConfigurationManager iConfigurationManager;
        BookingWrapperResponseDTO bookingWrapperResponseDTO;
        TicketsManager.TicketsState value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            BookingWrapperResponseDTO bookingWrapperResponseDTO2 = (BookingWrapperResponseDTO) this.L$0;
            iConfigurationManager = this.this$0.configManager;
            Site site = this.$site;
            this.L$0 = bookingWrapperResponseDTO2;
            this.label = 1;
            Object activeConfiguration = iConfigurationManager.getActiveConfiguration(site, this);
            if (activeConfiguration == coroutine_suspended) {
                return coroutine_suspended;
            }
            bookingWrapperResponseDTO = bookingWrapperResponseDTO2;
            obj = activeConfiguration;
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bookingWrapperResponseDTO = (BookingWrapperResponseDTO) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        LocalizedSiteConfiguration localizedSiteConfiguration = (LocalizedSiteConfiguration) obj;
        Booking booking = new Booking(bookingWrapperResponseDTO.getBooking(), this.$site, localizedSiteConfiguration != null ? localizedSiteConfiguration.getTransportations() : null);
        MutableStateFlow<TicketsManager.TicketsState> ticketsState = this.this$0.getTicketsState();
        do {
            value = ticketsState.getValue();
        } while (!ticketsState.compareAndSet(value, TicketsManager.TicketsState.copy$default(value, null, booking, 1, null)));
        return booking;
    }
}
