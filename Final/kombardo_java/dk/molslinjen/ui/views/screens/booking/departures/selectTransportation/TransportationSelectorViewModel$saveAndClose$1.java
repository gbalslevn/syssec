package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.config.Transportation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorViewModel$saveAndClose$1", f = "TransportationSelectorViewModel.kt", l = {87}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TransportationSelectorViewModel$saveAndClose$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Boolean, String, Unit> $proceed;
    final /* synthetic */ Transportation $selectedTransportation;
    final /* synthetic */ boolean $showCargoDetails;
    int label;
    final /* synthetic */ TransportationSelectorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TransportationSelectorViewModel$saveAndClose$1(boolean z5, Function2<? super Boolean, ? super String, Unit> function2, Transportation transportation, TransportationSelectorViewModel transportationSelectorViewModel, Continuation<? super TransportationSelectorViewModel$saveAndClose$1> continuation) {
        super(2, continuation);
        this.$showCargoDetails = z5;
        this.$proceed = function2;
        this.$selectedTransportation = transportation;
        this.this$0 = transportationSelectorViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransportationSelectorViewModel$saveAndClose$1(this.$showCargoDetails, this.$proceed, this.$selectedTransportation, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IRouteManager iRouteManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$showCargoDetails) {
                this.$proceed.invoke(Boxing.boxBoolean(true), this.$selectedTransportation.getId());
                return Unit.INSTANCE;
            }
            iRouteManager = this.this$0.routeManager;
            Transportation transportation = this.$selectedTransportation;
            this.label = 1;
            if (iRouteManager.setTransportation(transportation, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$proceed.invoke(Boxing.boxBoolean(false), BuildConfig.FLAVOR);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransportationSelectorViewModel$saveAndClose$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
