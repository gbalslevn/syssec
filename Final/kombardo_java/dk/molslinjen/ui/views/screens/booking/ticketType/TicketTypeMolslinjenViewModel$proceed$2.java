package dk.molslinjen.ui.views.screens.booking.ticketType;

import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.extensions.AnalyticsExtensionsKt;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeMolslinjenViewModel$proceed$2", f = "TicketTypeMolslinjenViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TicketTypeMolslinjenViewModel$proceed$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BookingType $bookingType;
    final /* synthetic */ Departure $departure;
    final /* synthetic */ DepartureDirection $departureDirection;
    final /* synthetic */ DepartureTicket $ticket;
    int label;
    final /* synthetic */ TicketTypeMolslinjenViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketTypeMolslinjenViewModel$proceed$2(TicketTypeMolslinjenViewModel ticketTypeMolslinjenViewModel, Departure departure, DepartureTicket departureTicket, DepartureDirection departureDirection, BookingType bookingType, Continuation<? super TicketTypeMolslinjenViewModel$proceed$2> continuation) {
        super(2, continuation);
        this.this$0 = ticketTypeMolslinjenViewModel;
        this.$departure = departure;
        this.$ticket = departureTicket;
        this.$departureDirection = departureDirection;
        this.$bookingType = bookingType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketTypeMolslinjenViewModel$proceed$2(this.this$0, this.$departure, this.$ticket, this.$departureDirection, this.$bookingType, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IRouteManager iRouteManager;
        Transportation selectedTransportation;
        IAnalyticsTracker iAnalyticsTracker;
        IRouteManager iRouteManager2;
        PassengerInfo passengerInfo;
        IRouteManager iRouteManager3;
        IEditManager iEditManager;
        IRouteManager iRouteManager4;
        Site site;
        IAnalyticsTracker iAnalyticsTracker2;
        IEditManager iEditManager2;
        List<DepartureTicket> tickets;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        iRouteManager = this.this$0.routeManager;
        RouteSharedSelectedState value = iRouteManager.getSharedSelectedState().getValue();
        if (value == null || (selectedTransportation = value.getSelectedTransportation()) == null) {
            return Unit.INSTANCE;
        }
        iAnalyticsTracker = this.this$0.analyticsTracker;
        Departure departure = this.$departure;
        DepartureTicket departureTicket = this.$ticket;
        iRouteManager2 = this.this$0.routeManager;
        RouteSelectedState value2 = iRouteManager2.getActiveSelectedState().getValue();
        if (value2 == null || (passengerInfo = value2.getPassengerInfo()) == null) {
            return Unit.INSTANCE;
        }
        iRouteManager3 = this.this$0.routeManager;
        RouteSelectedState value3 = iRouteManager3.getActiveSelectedState().getValue();
        Object obj2 = null;
        TrailerProduct selectedTrailer = value3 != null ? value3.getSelectedTrailer() : null;
        iEditManager = this.this$0.editManager;
        boolean isEditing = iEditManager.getEditState().getValue().getIsEditing();
        DepartureDirection departureDirection = this.$departureDirection;
        iRouteManager4 = this.this$0.routeManager;
        RouteSharedSelectedState value4 = iRouteManager4.getSharedSelectedState().getValue();
        if (value4 == null || (site = value4.getSite()) == null) {
            return Unit.INSTANCE;
        }
        iAnalyticsTracker.trackAddDeparture(departure, departureTicket, selectedTransportation, passengerInfo, selectedTrailer, isEditing, departureDirection, site);
        iAnalyticsTracker2 = this.this$0.analyticsTracker;
        iEditManager2 = this.this$0.editManager;
        boolean isEditing2 = iEditManager2.getEditState().getValue().getIsEditing();
        DepartureTicket departureTicket2 = this.$ticket;
        Departure departure2 = this.this$0.getViewState().getValue().getDeparture();
        if (departure2 != null && (tickets = departure2.getTickets()) != null) {
            Iterator<T> it = tickets.iterator();
            if (it.hasNext()) {
                obj2 = it.next();
                if (it.hasNext()) {
                    int analyticsAmount = AnalyticsExtensionsKt.toAnalyticsAmount(((DepartureTicket) obj2).getPrice());
                    do {
                        Object next = it.next();
                        int analyticsAmount2 = AnalyticsExtensionsKt.toAnalyticsAmount(((DepartureTicket) next).getPrice());
                        if (analyticsAmount > analyticsAmount2) {
                            obj2 = next;
                            analyticsAmount = analyticsAmount2;
                        }
                    } while (it.hasNext());
                }
            }
            obj2 = (DepartureTicket) obj2;
        }
        iAnalyticsTracker2.trackEvent(new AnalyticsEvent.SelectTicketTypeEvent(this.$ticket, this.$departure, selectedTransportation, this.$bookingType, isEditing2, Intrinsics.areEqual(departureTicket2, obj2)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketTypeMolslinjenViewModel$proceed$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
