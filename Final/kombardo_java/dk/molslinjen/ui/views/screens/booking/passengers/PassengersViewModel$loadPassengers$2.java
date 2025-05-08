package dk.molslinjen.ui.views.screens.booking.passengers;

import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.ICheckoutPassengerManager;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel$loadPassengers$2", f = "PassengersViewModel.kt", l = {148}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class PassengersViewModel$loadPassengers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DepartureDirection $departureDirection;
    final /* synthetic */ boolean $mergeAfterProfileChange;
    final /* synthetic */ boolean $onlySelectMe;
    int label;
    final /* synthetic */ PassengersViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PassengersViewModel$loadPassengers$2(PassengersViewModel passengersViewModel, DepartureDirection departureDirection, boolean z5, boolean z6, Continuation<? super PassengersViewModel$loadPassengers$2> continuation) {
        super(2, continuation);
        this.this$0 = passengersViewModel;
        this.$departureDirection = departureDirection;
        this.$onlySelectMe = z5;
        this.$mergeAfterProfileChange = z6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PassengersViewModel$loadPassengers$2(this.this$0, this.$departureDirection, this.$onlySelectMe, this.$mergeAfterProfileChange, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CheckoutManager.CheckoutDirectionState value;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            CheckoutManager.CheckoutState value3 = this.this$0.checkoutManager.getCheckoutState().getValue();
            if (value3 != null && (value = this.this$0.checkoutManager.directionState(this.this$0.getViewState().getValue().getDepartureDirection()).getValue()) != null) {
                boolean isWalking = value3.getTransportation().isWalking();
                PassengerInfo passengerInfo = value.getPassengerInfo();
                ICheckoutPassengerManager iCheckoutPassengerManager = this.this$0.checkoutPassengerManager;
                Site site = value3.getSite();
                DepartureDirection departureDirection = this.$departureDirection;
                boolean z5 = this.$onlySelectMe;
                boolean z6 = this.$mergeAfterProfileChange;
                this.label = 1;
                if (iCheckoutPassengerManager.load(site, departureDirection, isWalking, passengerInfo, z5, z6, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i5 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MutableStateFlow mutableStateFlow = this.this$0._viewState;
        do {
            value2 = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value2, PassengersViewModel.ViewState.copy$default((PassengersViewModel.ViewState) value2, false, 0, 0, 0, 0, 0, false, false, false, null, null, null, 4094, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PassengersViewModel$loadPassengers$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
