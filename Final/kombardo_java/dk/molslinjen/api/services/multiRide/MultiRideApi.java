package dk.molslinjen.api.services.multiRide;

import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.multiRide.request.AddMultiRideVehicleRequestParameters;
import dk.molslinjen.api.services.multiRide.request.GetMultiRideRequestParameters;
import dk.molslinjen.api.services.multiRide.request.PurchaseMultiRideRequestParameters;
import dk.molslinjen.api.services.multiRide.response.MultiRideActiveBookingsResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRideHistoryResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRidePriceStepsResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRidePurchaseInfosResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRidePurchaseResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRideResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRideSummaryResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRideVehiclesResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRidesResponseDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ2\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00152\b\b\u0003\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u0018J<\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u00062\b\b\u0001\u0010\u001b\u001a\u00020\u00152\b\b\u0001\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\u001cJ(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\f\u001a\u00020\u001f2\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010 J2\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\"\u001a\u00020\u00062\b\b\u0001\u0010#\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010$J(\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ(\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ(\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ2\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010-\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010$J2\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020/2\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u00100¨\u00061"}, d2 = {"Ldk/molslinjen/api/services/multiRide/MultiRideApi;", BuildConfig.FLAVOR, "getMultiRide", "Lretrofit2/Response;", "Ldk/molslinjen/api/services/multiRide/response/MultiRideResponseDTO;", "multiRideId", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMultiRides", "Ldk/molslinjen/api/services/multiRide/response/MultiRidesResponseDTO;", "requestParameters", "Ldk/molslinjen/api/services/multiRide/request/GetMultiRideRequestParameters;", "(Ldk/molslinjen/api/services/multiRide/request/GetMultiRideRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrices", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePriceStepsResponseDTO;", "cardType", "getCardPurchasesInfo", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseInfosResponseDTO;", "currency", BuildConfig.FLAVOR, "includePrices", BuildConfig.FLAVOR, "(IZLdk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSummaryInfo", "Ldk/molslinjen/api/services/multiRide/response/MultiRideSummaryResponseDTO;", "numberOfTickets", "(Ljava/lang/String;IILdk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchaseOrRefillMultiRide", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseResponseDTO;", "Ldk/molslinjen/api/services/multiRide/request/PurchaseMultiRideRequestParameters;", "(Ldk/molslinjen/api/services/multiRide/request/PurchaseMultiRideRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMultiRideReceipt", "reservationNumber", "phone", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveBookings", "Ldk/molslinjen/api/services/multiRide/response/MultiRideActiveBookingsResponseDTO;", "getMultiRideHistory", "Ldk/molslinjen/api/services/multiRide/response/MultiRideHistoryResponseDTO;", "getMultiRideVehicles", "Ldk/molslinjen/api/services/multiRide/response/MultiRideVehiclesResponseDTO;", "removeMultiRideVehicle", BuildConfig.FLAVOR, "licensePlate", "addMultiRideVehicle", "Ldk/molslinjen/api/services/multiRide/request/AddMultiRideVehicleRequestParameters;", "(Ljava/lang/String;Ldk/molslinjen/api/services/multiRide/request/AddMultiRideVehicleRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface MultiRideApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getCardPurchasesInfo$default(MultiRideApi multiRideApi, int i5, boolean z5, SiteDTO siteDTO, Continuation continuation, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCardPurchasesInfo");
            }
            if ((i6 & 2) != 0) {
                z5 = true;
            }
            return multiRideApi.getCardPurchasesInfo(i5, z5, siteDTO, continuation);
        }
    }

    @POST("v1/multiride/{multiRideId}/numberplates")
    @Retry
    Object addMultiRideVehicle(@Path("multiRideId") String str, @Body AddMultiRideVehicleRequestParameters addMultiRideVehicleRequestParameters, @Header("Line") SiteDTO siteDTO, Continuation<Response<Unit>> continuation);

    @GET("v1/multiride/{multiRideId}/active")
    @Retry
    Object getActiveBookings(@Path("multiRideId") String str, @Header("Line") SiteDTO siteDTO, Continuation<Response<MultiRideActiveBookingsResponseDTO>> continuation);

    @GET("v1/multiride/cards")
    Object getCardPurchasesInfo(@Query("currency") int i5, @Query("includePrices") boolean z5, @Header("Line") SiteDTO siteDTO, Continuation<Response<MultiRidePurchaseInfosResponseDTO>> continuation);

    @GET("v1/multiride/{multiRideId}")
    @Retry
    Object getMultiRide(@Path("multiRideId") String str, @Header("Line") SiteDTO siteDTO, Continuation<Response<MultiRideResponseDTO>> continuation);

    @GET("v1/multiride/{multiRideId}/history")
    @Retry
    Object getMultiRideHistory(@Path("multiRideId") String str, @Header("Line") SiteDTO siteDTO, Continuation<Response<MultiRideHistoryResponseDTO>> continuation);

    @GET("v1/multiride/receipt")
    @Retry
    Object getMultiRideReceipt(@Query("reservationId") String str, @Query("phone") String str2, @Header("Line") SiteDTO siteDTO, Continuation<Response<MultiRideSummaryResponseDTO>> continuation);

    @GET("v1/multiride/{multiRideId}/numberplates")
    @Retry
    Object getMultiRideVehicles(@Path("multiRideId") String str, @Header("Line") SiteDTO siteDTO, Continuation<Response<MultiRideVehiclesResponseDTO>> continuation);

    @POST("v1/multiride")
    @Retry
    Object getMultiRides(@Body GetMultiRideRequestParameters getMultiRideRequestParameters, @Header("Line") SiteDTO siteDTO, Continuation<Response<MultiRidesResponseDTO>> continuation);

    @GET("v1/multiride/prices")
    @Retry
    Object getPrices(@Query("cardType") String str, @Header("Line") SiteDTO siteDTO, Continuation<Response<MultiRidePriceStepsResponseDTO>> continuation);

    @GET("v1/multiride")
    @Retry
    Object getSummaryInfo(@Query("cardType") String str, @Query("numberOfTickets") int i5, @Query("currency") int i6, @Header("Line") SiteDTO siteDTO, Continuation<Response<MultiRideSummaryResponseDTO>> continuation);

    @POST("v1/multiride/purchase")
    @Retry
    Object purchaseOrRefillMultiRide(@Body PurchaseMultiRideRequestParameters purchaseMultiRideRequestParameters, @Header("Line") SiteDTO siteDTO, Continuation<Response<MultiRidePurchaseResponseDTO>> continuation);

    @DELETE("v1/multiride/{multiRideId}/numberplates/{id}")
    @Retry
    Object removeMultiRideVehicle(@Path("multiRideId") String str, @Path("id") String str2, @Header("Line") SiteDTO siteDTO, Continuation<Response<Unit>> continuation);
}
