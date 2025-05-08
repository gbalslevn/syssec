package dk.molslinjen.domain.managers.saleOnBoard;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.payment.response.CreatePaymentResponseDTO;
import dk.molslinjen.api.services.saleOnBoard.response.CreateOrderResponseDTO;
import dk.molslinjen.domain.model.booking.BookingCompleted;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ldk/molslinjen/domain/model/booking/BookingCompleted;", "it", "Ldk/molslinjen/api/services/payment/response/CreatePaymentResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager$createBooking$3", f = "SaleOnBoardCheckoutManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardCheckoutManager$createBooking$3 extends SuspendLambda implements Function2<CreatePaymentResponseDTO, Continuation<? super BookingCompleted>, Object> {
    final /* synthetic */ ApiResult<CreateOrderResponseDTO> $response;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardCheckoutManager$createBooking$3(ApiResult<CreateOrderResponseDTO> apiResult, Continuation<? super SaleOnBoardCheckoutManager$createBooking$3> continuation) {
        super(2, continuation);
        this.$response = apiResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SaleOnBoardCheckoutManager$createBooking$3 saleOnBoardCheckoutManager$createBooking$3 = new SaleOnBoardCheckoutManager$createBooking$3(this.$response, continuation);
        saleOnBoardCheckoutManager$createBooking$3.L$0 = obj;
        return saleOnBoardCheckoutManager$createBooking$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CreatePaymentResponseDTO createPaymentResponseDTO, Continuation<? super BookingCompleted> continuation) {
        return ((SaleOnBoardCheckoutManager$createBooking$3) create(createPaymentResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return BookingCompleted.INSTANCE.invoke((CreatePaymentResponseDTO) this.L$0, String.valueOf(((CreateOrderResponseDTO) ((ApiResult.Success) this.$response).getData()).getOrderId()));
    }
}
