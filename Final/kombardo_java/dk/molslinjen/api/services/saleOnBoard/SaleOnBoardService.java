package dk.molslinjen.api.services.saleOnBoard;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters;
import dk.molslinjen.api.services.saleOnBoard.response.CreateOrderResponseDTO;
import dk.molslinjen.api.services.saleOnBoard.response.PlaceOrderResponseDTO;
import dk.molslinjen.api.services.saleOnBoard.response.SaleOnBoardOrderResponseDTO;
import dk.molslinjen.api.services.saleOnBoard.response.ShopAndProductsResponseDTO;
import dk.molslinjen.api.services.saleOnBoard.response.TimeSlotsResponseDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0013J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\b2\u0006\u0010 \u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\b2\u0006\u0010 \u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/SaleOnBoardService;", "Ldk/molslinjen/api/services/saleOnBoard/ISaleOnBoardService;", "Ldk/molslinjen/api/services/BaseService;", "api", "Ldk/molslinjen/api/services/saleOnBoard/SaleOnBoardApi;", "<init>", "(Ldk/molslinjen/api/services/saleOnBoard/SaleOnBoardApi;)V", "getShopsAndProducts", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/saleOnBoard/response/ShopAndProductsResponseDTO;", "timetableId", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTimeSlots", "Ldk/molslinjen/api/services/saleOnBoard/response/TimeSlotsResponseDTO;", "createOrder", "Ldk/molslinjen/api/services/saleOnBoard/response/CreateOrderResponseDTO;", "name", "phone", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "patchOrder", BuildConfig.FLAVOR, "orderId", BuildConfig.FLAVOR, "requestParameters", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters;", "(ILdk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "placeOrder", "Ldk/molslinjen/api/services/saleOnBoard/response/PlaceOrderResponseDTO;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrderStatus", "Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO;", "orderNumber", "cancelOrder", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardService extends BaseService implements ISaleOnBoardService {
    private final SaleOnBoardApi api;

    public SaleOnBoardService(SaleOnBoardApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.saleOnBoard.ISaleOnBoardService
    public Object cancelOrder(String str, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new SaleOnBoardService$cancelOrder$2(this, str, null), continuation);
    }

    @Override // dk.molslinjen.api.services.saleOnBoard.ISaleOnBoardService
    public Object createOrder(String str, String str2, Continuation<? super ApiResult<CreateOrderResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new SaleOnBoardService$createOrder$2(str, str2, this, null), continuation);
    }

    @Override // dk.molslinjen.api.services.saleOnBoard.ISaleOnBoardService
    public Object getOrderStatus(String str, Continuation<? super ApiResult<SaleOnBoardOrderResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new SaleOnBoardService$getOrderStatus$2(this, str, null), continuation);
    }

    @Override // dk.molslinjen.api.services.saleOnBoard.ISaleOnBoardService
    public Object getShopsAndProducts(String str, Continuation<? super ApiResult<ShopAndProductsResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new SaleOnBoardService$getShopsAndProducts$2(this, str, null), continuation);
    }

    @Override // dk.molslinjen.api.services.saleOnBoard.ISaleOnBoardService
    public Object getTimeSlots(String str, Continuation<? super ApiResult<TimeSlotsResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new SaleOnBoardService$getTimeSlots$2(this, str, null), continuation);
    }

    @Override // dk.molslinjen.api.services.saleOnBoard.ISaleOnBoardService
    public Object patchOrder(int i5, PatchOrderRequestParameters patchOrderRequestParameters, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new SaleOnBoardService$patchOrder$2(this, i5, patchOrderRequestParameters, null), continuation);
    }

    @Override // dk.molslinjen.api.services.saleOnBoard.ISaleOnBoardService
    public Object placeOrder(int i5, Continuation<? super ApiResult<PlaceOrderResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new SaleOnBoardService$placeOrder$2(this, i5, null), continuation);
    }
}
