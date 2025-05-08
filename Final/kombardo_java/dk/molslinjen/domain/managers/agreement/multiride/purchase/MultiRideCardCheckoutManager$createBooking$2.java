package dk.molslinjen.domain.managers.agreement.multiride.purchase;

import dk.molslinjen.api.services.multiRide.response.MultiRidePurchaseResponseDTO;
import dk.molslinjen.domain.managers.agreement.multiride.purchase.IMultiRideCardCheckoutManager;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.model.booking.BookingProcessingResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.purchase.MultiRideCardCheckoutManager$createBooking$2", f = "MultiRideCardCheckoutManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class MultiRideCardCheckoutManager$createBooking$2 extends SuspendLambda implements Function2<MultiRidePurchaseResponseDTO, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMultiRideCardCheckoutManager.CheckoutState $state;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MultiRideCardCheckoutManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideCardCheckoutManager$createBooking$2(MultiRideCardCheckoutManager multiRideCardCheckoutManager, IMultiRideCardCheckoutManager.CheckoutState checkoutState, Continuation<? super MultiRideCardCheckoutManager$createBooking$2> continuation) {
        super(2, continuation);
        this.this$0 = multiRideCardCheckoutManager;
        this.$state = checkoutState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MultiRideCardCheckoutManager$createBooking$2 multiRideCardCheckoutManager$createBooking$2 = new MultiRideCardCheckoutManager$createBooking$2(this.this$0, this.$state, continuation);
        multiRideCardCheckoutManager$createBooking$2.L$0 = obj;
        return multiRideCardCheckoutManager$createBooking$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MultiRidePurchaseResponseDTO multiRidePurchaseResponseDTO, Continuation<? super Unit> continuation) {
        return ((MultiRideCardCheckoutManager$createBooking$2) create(multiRidePurchaseResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IPaymentManager iPaymentManager;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MultiRidePurchaseResponseDTO multiRidePurchaseResponseDTO = (MultiRidePurchaseResponseDTO) this.L$0;
        iPaymentManager = this.this$0.paymentManager;
        iPaymentManager.setPaymentData(multiRidePurchaseResponseDTO.getOrderId(), this.$state.getSelectedPaymentType(), BookingProcessingResult.Pay, false);
        return Unit.INSTANCE;
    }
}
