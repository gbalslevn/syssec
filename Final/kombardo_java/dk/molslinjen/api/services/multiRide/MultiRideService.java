package dk.molslinjen.api.services.multiRide;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRideActiveBookingsResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRideHistoryResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRidePriceStepsResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRidePurchaseInfosResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRidePurchaseResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRideResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRideSummaryResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRideVehiclesResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRidesResponseDTO;
import dk.molslinjen.api.services.paymentTypes.response.PaymentTypeDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import dk.molslinjen.api.shared.response.PhoneNumberDTO;
import dk.molslinjen.core.providers.IPaymentCallbackUrlProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0015J,\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\n2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001eJx\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\n2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0096@¢\u0006\u0002\u0010-J4\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\n2\u0006\u00100\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u00101J,\u00102\u001a\b\u0012\u0004\u0012\u00020/0\n2\u0006\u00103\u001a\u00020\r2\u0006\u0010&\u001a\u0002042\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u00105J$\u00106\u001a\b\u0012\u0004\u0012\u0002070\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J$\u00108\u001a\b\u0012\u0004\u0012\u0002090\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J$\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J,\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010>\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010?J4\u0010@\u001a\b\u0012\u0004\u0012\u00020=0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010>\u001a\u00020\r2\u0006\u0010A\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010BR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Ldk/molslinjen/api/services/multiRide/MultiRideService;", "Ldk/molslinjen/api/services/multiRide/IMultiRideService;", "Ldk/molslinjen/api/services/BaseService;", "api", "Ldk/molslinjen/api/services/multiRide/MultiRideApi;", "paymentCallbackUrlProvider", "Ldk/molslinjen/core/providers/IPaymentCallbackUrlProvider;", "<init>", "(Ldk/molslinjen/api/services/multiRide/MultiRideApi;Ldk/molslinjen/core/providers/IPaymentCallbackUrlProvider;)V", "getMultiRide", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/multiRide/response/MultiRideResponseDTO;", "multiRideId", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMultiRides", "Ldk/molslinjen/api/services/multiRide/response/MultiRidesResponseDTO;", "multiRideIds", BuildConfig.FLAVOR, "(Ljava/util/List;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrices", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePriceStepsResponseDTO;", "cardType", "currencyType", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCardPurchasesInfo", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseInfosResponseDTO;", "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchaseOrRefillMultiRide", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseResponseDTO;", "email", "numberOfCharges", BuildConfig.FLAVOR, "paymentType", "Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;", "phone", "phonePrefix", "postalCode", "savedCreditCardToken", "screenWidth", BuildConfig.FLAVOR, "screenHeight", "(Ljava/lang/String;Ljava/lang/String;ILdk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Ljava/lang/String;FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSummaryInfo", "Ldk/molslinjen/api/services/multiRide/response/MultiRideSummaryResponseDTO;", "multiRideTypeId", "(Ljava/lang/String;ILdk/molslinjen/api/shared/response/CurrencyTypeDTO;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReceipt", "reservationNumber", "Ldk/molslinjen/api/shared/response/PhoneNumberDTO;", "(Ljava/lang/String;Ldk/molslinjen/api/shared/response/PhoneNumberDTO;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveBookings", "Ldk/molslinjen/api/services/multiRide/response/MultiRideActiveBookingsResponseDTO;", "getBookingHistory", "Ldk/molslinjen/api/services/multiRide/response/MultiRideHistoryResponseDTO;", "getMultiRideVehicles", "Ldk/molslinjen/api/services/multiRide/response/MultiRideVehiclesResponseDTO;", "removeMultiRideVehicle", BuildConfig.FLAVOR, "licensePlate", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addMultiRideVehicle", "vehicleName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiRideService extends BaseService implements IMultiRideService {
    private final MultiRideApi api;
    private final IPaymentCallbackUrlProvider paymentCallbackUrlProvider;

    public MultiRideService(MultiRideApi api, IPaymentCallbackUrlProvider paymentCallbackUrlProvider) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(paymentCallbackUrlProvider, "paymentCallbackUrlProvider");
        this.api = api;
        this.paymentCallbackUrlProvider = paymentCallbackUrlProvider;
    }

    @Override // dk.molslinjen.api.services.multiRide.IMultiRideService
    public Object addMultiRideVehicle(String str, String str2, String str3, SiteDTO siteDTO, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new MultiRideService$addMultiRideVehicle$2(str3, str2, this, str, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.multiRide.IMultiRideService
    public Object getActiveBookings(String str, SiteDTO siteDTO, Continuation<? super ApiResult<MultiRideActiveBookingsResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new MultiRideService$getActiveBookings$2(this, str, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.multiRide.IMultiRideService
    public Object getBookingHistory(String str, SiteDTO siteDTO, Continuation<? super ApiResult<MultiRideHistoryResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new MultiRideService$getBookingHistory$2(this, str, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.multiRide.IMultiRideService
    public Object getCardPurchasesInfo(SiteDTO siteDTO, CurrencyTypeDTO currencyTypeDTO, Continuation<? super ApiResult<MultiRidePurchaseInfosResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new MultiRideService$getCardPurchasesInfo$2(this, currencyTypeDTO, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.multiRide.IMultiRideService
    public Object getMultiRide(String str, SiteDTO siteDTO, Continuation<? super ApiResult<MultiRideResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new MultiRideService$getMultiRide$2(this, str, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.multiRide.IMultiRideService
    public Object getMultiRideVehicles(String str, SiteDTO siteDTO, Continuation<? super ApiResult<MultiRideVehiclesResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new MultiRideService$getMultiRideVehicles$2(this, str, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.multiRide.IMultiRideService
    public Object getMultiRides(List<String> list, SiteDTO siteDTO, Continuation<? super ApiResult<MultiRidesResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new MultiRideService$getMultiRides$2(list, this, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.multiRide.IMultiRideService
    public Object getPrices(String str, SiteDTO siteDTO, CurrencyTypeDTO currencyTypeDTO, Continuation<? super ApiResult<MultiRidePriceStepsResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new MultiRideService$getPrices$2(this, str, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.multiRide.IMultiRideService
    public Object getReceipt(String str, PhoneNumberDTO phoneNumberDTO, SiteDTO siteDTO, Continuation<? super ApiResult<MultiRideSummaryResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new MultiRideService$getReceipt$2(this, str, phoneNumberDTO, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.multiRide.IMultiRideService
    public Object getSummaryInfo(String str, int i5, CurrencyTypeDTO currencyTypeDTO, SiteDTO siteDTO, Continuation<? super ApiResult<MultiRideSummaryResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new MultiRideService$getSummaryInfo$2(this, str, i5, currencyTypeDTO, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.multiRide.IMultiRideService
    public Object purchaseOrRefillMultiRide(String str, String str2, int i5, PaymentTypeDTO paymentTypeDTO, String str3, String str4, String str5, SiteDTO siteDTO, String str6, String str7, float f5, float f6, Continuation<? super ApiResult<MultiRidePurchaseResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new MultiRideService$purchaseOrRefillMultiRide$2(str, str2, str7, i5, paymentTypeDTO, str3, str4, str5, str6, this, f6, f5, siteDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.multiRide.IMultiRideService
    public Object removeMultiRideVehicle(String str, String str2, SiteDTO siteDTO, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new MultiRideService$removeMultiRideVehicle$2(this, str, str2, siteDTO, null), continuation);
    }
}
