package dk.molslinjen.api.services.payment;

import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.payment.request.CreatePaymentRequestParameters;
import dk.molslinjen.api.services.payment.response.CreatePaymentResponseDTO;
import dk.molslinjen.api.services.payment.response.PaymentStatusResponseDTO;
import dk.molslinjen.api.services.payment.response.UpdateOrderPaymentStatusResponseDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/api/services/payment/PaymentApi;", BuildConfig.FLAVOR, "isPaymentCompleted", "Lretrofit2/Response;", "Ldk/molslinjen/api/services/payment/response/PaymentStatusResponseDTO;", "reservationNumber", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPayment", "Ldk/molslinjen/api/services/payment/response/CreatePaymentResponseDTO;", "parameters", "Ldk/molslinjen/api/services/payment/request/CreatePaymentRequestParameters;", "(Ldk/molslinjen/api/services/payment/request/CreatePaymentRequestParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOrderPaymentStatus", "Ldk/molslinjen/api/services/payment/response/UpdateOrderPaymentStatusResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PaymentApi {
    @POST("create")
    @Retry
    Object createPayment(@Body CreatePaymentRequestParameters createPaymentRequestParameters, Continuation<Response<CreatePaymentResponseDTO>> continuation);

    @GET("isPaymentCompleted/{orderId}")
    @Retry
    Object isPaymentCompleted(@Path("orderId") String str, Continuation<Response<PaymentStatusResponseDTO>> continuation);

    @GET("updateOrderPaymentStatus/{orderId}")
    @Retry
    Object updateOrderPaymentStatus(@Path("orderId") String str, Continuation<Response<UpdateOrderPaymentStatusResponseDTO>> continuation);
}
