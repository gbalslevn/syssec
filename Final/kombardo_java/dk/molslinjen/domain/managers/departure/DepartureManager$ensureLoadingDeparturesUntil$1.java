package dk.molslinjen.domain.managers.departure;

import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.departure.DepartureManager$ensureLoadingDeparturesUntil$1", f = "DepartureManager.kt", l = {272}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class DepartureManager$ensureLoadingDeparturesUntil$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DepartureDirection $departureDirection;
    final /* synthetic */ RouteSelectedState $departureSelectedState;
    final /* synthetic */ String $departuresRequestId;
    final /* synthetic */ LocalDate $fromDate;
    final /* synthetic */ long $i;
    final /* synthetic */ Departure $outboundTripDepartureForReturn;
    final /* synthetic */ RouteSelectedState $outboundTripRouteStateForReturn;
    final /* synthetic */ RouteSharedSelectedState $routeSharedSelectedState;
    final /* synthetic */ String $sessionKey;
    int label;
    final /* synthetic */ DepartureManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DepartureManager$ensureLoadingDeparturesUntil$1(LocalDate localDate, long j5, DepartureManager departureManager, DepartureDirection departureDirection, String str, String str2, RouteSelectedState routeSelectedState, RouteSharedSelectedState routeSharedSelectedState, Departure departure, RouteSelectedState routeSelectedState2, Continuation<? super DepartureManager$ensureLoadingDeparturesUntil$1> continuation) {
        super(2, continuation);
        this.$fromDate = localDate;
        this.$i = j5;
        this.this$0 = departureManager;
        this.$departureDirection = departureDirection;
        this.$departuresRequestId = str;
        this.$sessionKey = str2;
        this.$departureSelectedState = routeSelectedState;
        this.$routeSharedSelectedState = routeSharedSelectedState;
        this.$outboundTripDepartureForReturn = departure;
        this.$outboundTripRouteStateForReturn = routeSelectedState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DepartureManager$ensureLoadingDeparturesUntil$1(this.$fromDate, this.$i, this.this$0, this.$departureDirection, this.$departuresRequestId, this.$sessionKey, this.$departureSelectedState, this.$routeSharedSelectedState, this.$outboundTripDepartureForReturn, this.$outboundTripRouteStateForReturn, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow state;
        IEditManager iEditManager;
        Object departures;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            LocalDate plusDays = this.$fromDate.plusDays(this.$i);
            Intrinsics.checkNotNullExpressionValue(plusDays, "plusDays(...)");
            state = this.this$0.getState(this.$departureDirection);
            iEditManager = this.this$0.editManager;
            Booking booking = iEditManager.getEditState().getValue().getBooking();
            DepartureManager departureManager = this.this$0;
            String str = this.$departuresRequestId;
            String str2 = this.$sessionKey;
            RouteSelectedState routeSelectedState = this.$departureSelectedState;
            RouteSharedSelectedState routeSharedSelectedState = this.$routeSharedSelectedState;
            Departure departure = this.$outboundTripDepartureForReturn;
            RouteSelectedState routeSelectedState2 = this.$outboundTripRouteStateForReturn;
            DepartureDirection departureDirection = this.$departureDirection;
            this.label = 1;
            departures = departureManager.getDepartures(str, str2, routeSelectedState, routeSharedSelectedState, plusDays, state, departure, routeSelectedState2, departureDirection, booking, this);
            if (departures == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DepartureManager$ensureLoadingDeparturesUntil$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
