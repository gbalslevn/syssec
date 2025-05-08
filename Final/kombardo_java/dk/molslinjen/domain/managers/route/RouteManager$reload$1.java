package dk.molslinjen.domain.managers.route;

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
@DebugMetadata(c = "dk.molslinjen.domain.managers.route.RouteManager$reload$1", f = "RouteManager.kt", l = {104, 105}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class RouteManager$reload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RouteManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteManager$reload$1(RouteManager routeManager, Continuation<? super RouteManager$reload$1> continuation) {
        super(2, continuation);
        this.this$0 = routeManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RouteManager$reload$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object transportationToDefaultIfOneRequiringReturnIncludedIsSelected;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow<DepartureDirection> activeDepartureDirectionState = this.this$0.getActiveDepartureDirectionState();
            do {
            } while (!activeDepartureDirectionState.compareAndSet(activeDepartureDirectionState.getValue(), DepartureDirection.Outbound));
            RouteManager routeManager = this.this$0;
            this.label = 1;
            transportationToDefaultIfOneRequiringReturnIncludedIsSelected = routeManager.setTransportationToDefaultIfOneRequiringReturnIncludedIsSelected(this);
            if (transportationToDefaultIfOneRequiringReturnIncludedIsSelected == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        RouteManager routeManager2 = this.this$0;
        this.label = 2;
        if (routeManager2.load(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RouteManager$reload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
