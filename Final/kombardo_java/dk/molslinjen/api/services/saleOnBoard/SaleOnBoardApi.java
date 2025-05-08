package dk.molslinjen.api.services.saleOnBoard;

import dk.molslinjen.api.helpers.retry.EmptyResponseBodyAsSuccess;
import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.saleOnBoard.request.CreateOrderRequestParameters;
import dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters;
import dk.molslinjen.api.services.saleOnBoard.response.CreateOrderResponseDTO;
import dk.molslinjen.api.services.saleOnBoard.response.PlaceOrderResponseDTO;
import dk.molslinjen.api.services.saleOnBoard.response.SaleOnBoardOrderResponseDTO;
import dk.molslinjen.api.services.saleOnBoard.response.ShopAndProductsResponseDTO;
import dk.molslinjen.api.services.saleOnBoard.response.TimeSlotsResponseDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/SaleOnBoardApi;", BuildConfig.FLAVOR, "getShopsAndProducts", "Lretrofit2/Response;", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO;", "timetableId", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTimeSlots", "Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO;", "createOrder", "Ldk/molslinjen/api/services/saleOnBoard/response/CreateOrderResponseDTO;", "requestParameters", "Ldk/molslinjen/api/services/saleOnBoard/request/CreateOrderRequestParameters;", "(Ldk/molslinjen/api/services/saleOnBoard/request/CreateOrderRequestParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "patchOrder", BuildConfig.FLAVOR, "orderId", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters;", "(Ljava/lang/String;Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "placeOrder", "Ldk/molslinjen/api/services/saleOnBoard/response/PlaceOrderResponseDTO;", "getOrderStatus", "Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO;", "cancelOrder", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface SaleOnBoardApi {
    @POST("customerOrders('{orderId}')/Microsoft.NAV.cancelOrder/")
    @Retry
    Object cancelOrder(@Path("orderId") String str, Continuation<Response<Unit>> continuation);

    @POST("cateringOrders")
    @Retry
    Object createOrder(@Body CreateOrderRequestParameters createOrderRequestParameters, Continuation<Response<CreateOrderResponseDTO>> continuation);

    @GET("customerOrders('{orderId}')/orderData")
    @Retry
    Object getOrderStatus(@Path("orderId") String str, Continuation<Response<SaleOnBoardOrderResponseDTO>> continuation);

    @GET("departures({timetableId})/storeProducts")
    @Retry
    Object getShopsAndProducts(@Path("timetableId") String str, Continuation<Response<ShopAndProductsResponseDTO>> continuation);

    @GET("timeSlots({timetableId})/occupancy")
    @Retry
    Object getTimeSlots(@Path("timetableId") String str, Continuation<Response<TimeSlotsResponseDTO>> continuation);

    @EmptyResponseBodyAsSuccess
    @PATCH("cateringOrders({orderId})/data")
    @Headers({"Content-Type: application/json", "If-Match: *"})
    @Retry
    Object patchOrder(@Path("orderId") String str, @Body PatchOrderRequestParameters patchOrderRequestParameters, Continuation<Response<Unit>> continuation);

    @POST("cateringOrders({orderId})/Microsoft.NAV.placeOrder/")
    @Retry
    Object placeOrder(@Path("orderId") String str, Continuation<Response<PlaceOrderResponseDTO>> continuation);
}
