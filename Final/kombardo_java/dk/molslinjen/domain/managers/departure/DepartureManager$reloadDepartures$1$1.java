package dk.molslinjen.domain.managers.departure;

import dk.molslinjen.domain.managers.checkout.IEditManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.departure.DepartureManager$reloadDepartures$1$1", f = "DepartureManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class DepartureManager$reloadDepartures$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DepartureDirection $departureDirection;
    final /* synthetic */ RouteSelectedState $routeSelectedState;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DepartureManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DepartureManager$reloadDepartures$1$1(DepartureManager departureManager, DepartureDirection departureDirection, RouteSelectedState routeSelectedState, Continuation<? super DepartureManager$reloadDepartures$1$1> continuation) {
        super(2, continuation);
        this.this$0 = departureManager;
        this.$departureDirection = departureDirection;
        this.$routeSelectedState = routeSelectedState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DepartureManager$reloadDepartures$1$1 departureManager$reloadDepartures$1$1 = new DepartureManager$reloadDepartures$1$1(this.this$0, this.$departureDirection, this.$routeSelectedState, continuation);
        departureManager$reloadDepartures$1$1.L$0 = obj;
        return departureManager$reloadDepartures$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IRouteManager iRouteManager;
        MutableStateFlow state;
        RouteSelectedState routeSelectedState;
        IEditManager iEditManager;
        IRouteManager iRouteManager2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        iRouteManager = this.this$0.routeManager;
        RouteSharedSelectedState value = iRouteManager.getSharedSelectedState().getValue();
        if (value == null) {
            return Unit.INSTANCE;
        }
        state = this.this$0.getState(this.$departureDirection);
        DepartureDirection departureDirection = this.$departureDirection;
        DepartureDirection departureDirection2 = DepartureDirection.Return;
        Departure selectedDeparture = departureDirection == departureDirection2 ? this.this$0.getOutboundState().getValue().getSelectedDeparture() : null;
        if (this.$departureDirection == departureDirection2) {
            iRouteManager2 = this.this$0.routeManager;
            routeSelectedState = iRouteManager2.getOutboundSelectedState().getValue();
        } else {
            routeSelectedState = null;
        }
        DepartureManager departureManager = this.this$0;
        RouteSelectedState routeSelectedState2 = this.$routeSelectedState;
        DepartureDirection departureDirection3 = this.$departureDirection;
        iEditManager = departureManager.editManager;
        departureManager.startLoadingDepartures(coroutineScope, routeSelectedState2, value, state, selectedDeparture, routeSelectedState, departureDirection3, iEditManager.getEditState().getValue().getBooking());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DepartureManager$reloadDepartures$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
