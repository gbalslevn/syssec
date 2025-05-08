package dk.molslinjen.api.services.saleOnBoard;

import dk.molslinjen.api.helpers.ApiResult;
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

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u000eJ$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\u0006\u0010\u001b\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u001b\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007¨\u0006\u001d"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/ISaleOnBoardService;", BuildConfig.FLAVOR, "getShopsAndProducts", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO;", "timetableId", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTimeSlots", "Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO;", "createOrder", "Ldk/molslinjen/api/services/saleOnBoard/response/CreateOrderResponseDTO;", "name", "phone", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "patchOrder", BuildConfig.FLAVOR, "orderId", BuildConfig.FLAVOR, "requestParameters", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters;", "(ILdk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "placeOrder", "Ldk/molslinjen/api/services/saleOnBoard/response/PlaceOrderResponseDTO;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrderStatus", "Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO;", "orderNumber", "cancelOrder", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ISaleOnBoardService {
    Object cancelOrder(String str, Continuation<? super ApiResult<Unit>> continuation);

    Object createOrder(String str, String str2, Continuation<? super ApiResult<CreateOrderResponseDTO>> continuation);

    Object getOrderStatus(String str, Continuation<? super ApiResult<SaleOnBoardOrderResponseDTO>> continuation);

    Object getShopsAndProducts(String str, Continuation<? super ApiResult<ShopAndProductsResponseDTO>> continuation);

    Object getTimeSlots(String str, Continuation<? super ApiResult<TimeSlotsResponseDTO>> continuation);

    Object patchOrder(int i5, PatchOrderRequestParameters patchOrderRequestParameters, Continuation<? super ApiResult<Unit>> continuation);

    Object placeOrder(int i5, Continuation<? super ApiResult<PlaceOrderResponseDTO>> continuation);
}
