package dk.molslinjen.domain.managers.departure;

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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.departure.DepartureManager$startLoadingDepartures$2", f = "DepartureManager.kt", l = {149}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class DepartureManager$startLoadingDepartures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LocalDate $date;
    final /* synthetic */ DepartureDirection $departureDirection;
    final /* synthetic */ String $departuresRequestId;
    final /* synthetic */ Booking $existingBooking;
    final /* synthetic */ int $i;
    final /* synthetic */ Departure $outboundTripDepartureForReturn;
    final /* synthetic */ RouteSelectedState $outboundTripRouteStateForReturn;
    final /* synthetic */ MutableStateFlow<DepartureState> $resultState;
    final /* synthetic */ RouteSelectedState $routeSelectedState;
    final /* synthetic */ RouteSharedSelectedState $routeSharedSelectedState;
    final /* synthetic */ String $sessionKey;
    int label;
    final /* synthetic */ DepartureManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DepartureManager$startLoadingDepartures$2(DepartureManager departureManager, String str, String str2, RouteSelectedState routeSelectedState, RouteSharedSelectedState routeSharedSelectedState, LocalDate localDate, int i5, MutableStateFlow<DepartureState> mutableStateFlow, Departure departure, RouteSelectedState routeSelectedState2, DepartureDirection departureDirection, Booking booking, Continuation<? super DepartureManager$startLoadingDepartures$2> continuation) {
        super(2, continuation);
        this.this$0 = departureManager;
        this.$departuresRequestId = str;
        this.$sessionKey = str2;
        this.$routeSelectedState = routeSelectedState;
        this.$routeSharedSelectedState = routeSharedSelectedState;
        this.$date = localDate;
        this.$i = i5;
        this.$resultState = mutableStateFlow;
        this.$outboundTripDepartureForReturn = departure;
        this.$outboundTripRouteStateForReturn = routeSelectedState2;
        this.$departureDirection = departureDirection;
        this.$existingBooking = booking;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DepartureManager$startLoadingDepartures$2(this.this$0, this.$departuresRequestId, this.$sessionKey, this.$routeSelectedState, this.$routeSharedSelectedState, this.$date, this.$i, this.$resultState, this.$outboundTripDepartureForReturn, this.$outboundTripRouteStateForReturn, this.$departureDirection, this.$existingBooking, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object departures;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            DepartureManager departureManager = this.this$0;
            String str = this.$departuresRequestId;
            String str2 = this.$sessionKey;
            RouteSelectedState routeSelectedState = this.$routeSelectedState;
            RouteSharedSelectedState routeSharedSelectedState = this.$routeSharedSelectedState;
            LocalDate plusDays = this.$date.plusDays(this.$i);
            Intrinsics.checkNotNullExpressionValue(plusDays, "plusDays(...)");
            MutableStateFlow<DepartureState> mutableStateFlow = this.$resultState;
            Departure departure = this.$outboundTripDepartureForReturn;
            RouteSelectedState routeSelectedState2 = this.$outboundTripRouteStateForReturn;
            DepartureDirection departureDirection = this.$departureDirection;
            Booking booking = this.$existingBooking;
            this.label = 1;
            departures = departureManager.getDepartures(str, str2, routeSelectedState, routeSharedSelectedState, plusDays, mutableStateFlow, departure, routeSelectedState2, departureDirection, booking, this);
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
        return ((DepartureManager$startLoadingDepartures$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
