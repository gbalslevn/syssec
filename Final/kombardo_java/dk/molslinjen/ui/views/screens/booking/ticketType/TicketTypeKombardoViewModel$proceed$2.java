package dk.molslinjen.ui.views.screens.booking.ticketType;

import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeKombardoViewModel$proceed$2", f = "TicketTypeKombardoViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TicketTypeKombardoViewModel$proceed$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Departure $departure;
    final /* synthetic */ DepartureDirection $departureDirection;
    final /* synthetic */ DepartureTicket $ticket;
    int label;
    final /* synthetic */ TicketTypeKombardoViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketTypeKombardoViewModel$proceed$2(TicketTypeKombardoViewModel ticketTypeKombardoViewModel, Departure departure, DepartureTicket departureTicket, DepartureDirection departureDirection, Continuation<? super TicketTypeKombardoViewModel$proceed$2> continuation) {
        super(2, continuation);
        this.this$0 = ticketTypeKombardoViewModel;
        this.$departure = departure;
        this.$ticket = departureTicket;
        this.$departureDirection = departureDirection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketTypeKombardoViewModel$proceed$2(this.this$0, this.$departure, this.$ticket, this.$departureDirection, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IAnalyticsTracker iAnalyticsTracker;
        IRouteManager iRouteManager;
        Transportation selectedTransportation;
        IRouteManager iRouteManager2;
        PassengerInfo passengerInfo;
        IEditManager iEditManager;
        IRouteManager iRouteManager3;
        Site site;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        iAnalyticsTracker = this.this$0.analyticsTracker;
        Departure departure = this.$departure;
        DepartureTicket departureTicket = this.$ticket;
        iRouteManager = this.this$0.routeManager;
        RouteSharedSelectedState value = iRouteManager.getSharedSelectedState().getValue();
        if (value == null || (selectedTransportation = value.getSelectedTransportation()) == null) {
            return Unit.INSTANCE;
        }
        iRouteManager2 = this.this$0.routeManager;
        RouteSelectedState value2 = iRouteManager2.getActiveSelectedState().getValue();
        if (value2 == null || (passengerInfo = value2.getPassengerInfo()) == null) {
            return Unit.INSTANCE;
        }
        iEditManager = this.this$0.editManager;
        boolean isEditing = iEditManager.getEditState().getValue().getIsEditing();
        DepartureDirection departureDirection = this.$departureDirection;
        iRouteManager3 = this.this$0.routeManager;
        RouteSharedSelectedState value3 = iRouteManager3.getSharedSelectedState().getValue();
        if (value3 == null || (site = value3.getSite()) == null) {
            return Unit.INSTANCE;
        }
        iAnalyticsTracker.trackAddDeparture(departure, departureTicket, selectedTransportation, passengerInfo, null, isEditing, departureDirection, site);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketTypeKombardoViewModel$proceed$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
