package dk.molslinjen.ui.views.screens.booking.addons;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.seating.ISelectSeatingManager;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.product.CheckoutSeatReservation;
import dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import uniffi.molslinjen_shared.FerrySeat;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.AddonsViewModel$syncSeats$1", f = "AddonsViewModel.kt", l = {109}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class AddonsViewModel$syncSeats$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DepartureDirection $direction;
    int label;
    final /* synthetic */ AddonsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddonsViewModel$syncSeats$1(AddonsViewModel addonsViewModel, DepartureDirection departureDirection, Continuation<? super AddonsViewModel$syncSeats$1> continuation) {
        super(2, continuation);
        this.this$0 = addonsViewModel;
        this.$direction = departureDirection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddonsViewModel$syncSeats$1(this.this$0, this.$direction, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISelectSeatingManager iSelectSeatingManager;
        AddonsViewModel.ViewState.SeatsState reserved;
        CheckoutSeatReservation seatReservation;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iSelectSeatingManager = this.this$0.seatingManager;
            DepartureDirection departureDirection = this.$direction;
            this.label = 1;
            obj = iSelectSeatingManager.synchronizeSeatSelection(departureDirection, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ManagerResult managerResult = (ManagerResult) obj;
        if (managerResult instanceof ManagerResult.Error) {
            reserved = AddonsViewModel.ViewState.SeatsState.Error.INSTANCE;
        } else {
            if (!(managerResult instanceof ManagerResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            CheckoutManager.CheckoutDirectionState value2 = this.this$0.checkoutManager.directionState(this.$direction).getValue();
            List<FerrySeat> seats = (value2 == null || (seatReservation = value2.getSeatReservation()) == null) ? null : seatReservation.getSeats();
            List<FerrySeat> list = seats;
            reserved = (list == null || list.isEmpty()) ? AddonsViewModel.ViewState.SeatsState.Empty.INSTANCE : new AddonsViewModel.ViewState.SeatsState.Reserved(seats);
        }
        MutableStateFlow mutableStateFlow = this.this$0._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, AddonsViewModel.ViewState.copy$default((AddonsViewModel.ViewState) value, false, null, 0, null, reserved, null, 47, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddonsViewModel$syncSeats$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
