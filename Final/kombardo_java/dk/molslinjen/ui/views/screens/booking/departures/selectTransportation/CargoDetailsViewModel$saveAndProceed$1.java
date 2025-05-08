package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.CargoDetailsViewModel$saveAndProceed$1", f = "CargoDetailsViewModel.kt", l = {119}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class CargoDetailsViewModel$saveAndProceed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $proceed;
    int label;
    final /* synthetic */ CargoDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CargoDetailsViewModel$saveAndProceed$1(CargoDetailsViewModel cargoDetailsViewModel, Function1<? super Boolean, Unit> function1, Continuation<? super CargoDetailsViewModel$saveAndProceed$1> continuation) {
        super(2, continuation);
        this.this$0 = cargoDetailsViewModel;
        this.$proceed = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CargoDetailsViewModel$saveAndProceed$1(this.this$0, this.$proceed, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IRouteManager iRouteManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iRouteManager = this.this$0.routeManager;
            String transportationId = this.this$0.getViewState().getValue().getTransportationId();
            TransportationCargoInfo outboundCargoInfo = this.this$0.getViewState().getValue().getOutboundCargoInfo();
            TransportationCargoInfo returnCargoInfo = this.this$0.getViewState().getValue().getReturnCargoInfo();
            this.label = 1;
            if (iRouteManager.setTransportation(transportationId, outboundCargoInfo, returnCargoInfo, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$proceed.invoke(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CargoDetailsViewModel$saveAndProceed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
