package dk.molslinjen.ui.views.screens.booking.departures.selectPassengers;

import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorViewModel$saveAndClose$1", f = "PassengerCountSelectorViewModel.kt", l = {98}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class PassengerCountSelectorViewModel$saveAndClose$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $proceed;
    int label;
    final /* synthetic */ PassengerCountSelectorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PassengerCountSelectorViewModel$saveAndClose$1(PassengerCountSelectorViewModel passengerCountSelectorViewModel, Function0<Unit> function0, Continuation<? super PassengerCountSelectorViewModel$saveAndClose$1> continuation) {
        super(2, continuation);
        this.this$0 = passengerCountSelectorViewModel;
        this.$proceed = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PassengerCountSelectorViewModel$saveAndClose$1(this.this$0, this.$proceed, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PassengerCountSelectorViewModel.PassengerSelectionState value;
        IRouteManager iRouteManager;
        IReturnManager iReturnManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            PassengerCountSelectorViewModel.PassengerSelectionState value2 = this.this$0.getOutboundPassengerState().getValue();
            PassengerInfo passengerInfo = new PassengerInfo(value2.getAdults(), value2.getChildren(), value2.getInfants());
            PassengerCountSelectorViewModel.ViewState value3 = this.this$0.getViewState().getValue();
            PassengerInfo passengerInfo2 = ((value3 == null || !value3.getSamePassengersForBothDirections()) && (value = this.this$0.getReturnPassengerState().getValue()) != null) ? new PassengerInfo(value.getAdults(), value.getChildren(), value.getInfants()) : passengerInfo;
            iRouteManager = this.this$0.routeManager;
            iReturnManager = this.this$0.returnManager;
            boolean isAddingReturnFromBookingSummary = iReturnManager.getReturnState().getValue().getIsAddingReturnFromBookingSummary();
            this.label = 1;
            if (iRouteManager.updatePassengers(passengerInfo, passengerInfo2, isAddingReturnFromBookingSummary, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$proceed.invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PassengerCountSelectorViewModel$saveAndClose$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
