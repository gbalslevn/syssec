package dk.molslinjen.domain.managers.agreement.multiride.purchase;

import dk.molslinjen.api.services.multiRide.response.MultiRidePurchaseResponseDTO;
import dk.molslinjen.domain.model.booking.BookingCompleted;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/domain/model/booking/BookingCompleted;", "it", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.agreement.multiride.purchase.MultiRideCardCheckoutManager$createBooking$3", f = "MultiRideCardCheckoutManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class MultiRideCardCheckoutManager$createBooking$3 extends SuspendLambda implements Function2<MultiRidePurchaseResponseDTO, Continuation<? super BookingCompleted>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiRideCardCheckoutManager$createBooking$3(Continuation<? super MultiRideCardCheckoutManager$createBooking$3> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MultiRideCardCheckoutManager$createBooking$3 multiRideCardCheckoutManager$createBooking$3 = new MultiRideCardCheckoutManager$createBooking$3(continuation);
        multiRideCardCheckoutManager$createBooking$3.L$0 = obj;
        return multiRideCardCheckoutManager$createBooking$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MultiRidePurchaseResponseDTO multiRidePurchaseResponseDTO, Continuation<? super BookingCompleted> continuation) {
        return ((MultiRideCardCheckoutManager$createBooking$3) create(multiRidePurchaseResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return BookingCompleted.INSTANCE.invoke((MultiRidePurchaseResponseDTO) this.L$0);
    }
}
