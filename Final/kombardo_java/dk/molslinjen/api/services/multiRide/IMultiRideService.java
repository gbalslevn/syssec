package dk.molslinjen.api.services.multiRide;

import dk.molslinjen.api.helpers.ApiResult;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ*\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u000eJ,\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0014J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0017Jz\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H¦@¢\u0006\u0002\u0010&J4\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00032\u0006\u0010)\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010*J,\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u00032\u0006\u0010,\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020-2\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010.J$\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ$\u00101\u001a\b\u0012\u0004\u0012\u0002020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ$\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ,\u00105\u001a\b\u0012\u0004\u0012\u0002060\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u00108J4\u00109\u001a\b\u0012\u0004\u0012\u0002060\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010;¨\u0006<"}, d2 = {"Ldk/molslinjen/api/services/multiRide/IMultiRideService;", BuildConfig.FLAVOR, "getMultiRide", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/multiRide/response/MultiRideResponseDTO;", "multiRideId", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMultiRides", "Ldk/molslinjen/api/services/multiRide/response/MultiRidesResponseDTO;", "multiRideIds", BuildConfig.FLAVOR, "(Ljava/util/List;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrices", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePriceStepsResponseDTO;", "cardType", "currencyType", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCardPurchasesInfo", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseInfosResponseDTO;", "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchaseOrRefillMultiRide", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseResponseDTO;", "email", "numberOfCharges", BuildConfig.FLAVOR, "paymentType", "Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;", "phone", "phonePrefix", "postalCode", "savedCreditCardToken", "screenWidth", BuildConfig.FLAVOR, "screenHeight", "(Ljava/lang/String;Ljava/lang/String;ILdk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Ljava/lang/String;FFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSummaryInfo", "Ldk/molslinjen/api/services/multiRide/response/MultiRideSummaryResponseDTO;", "multiRideTypeId", "(Ljava/lang/String;ILdk/molslinjen/api/shared/response/CurrencyTypeDTO;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReceipt", "reservationNumber", "Ldk/molslinjen/api/shared/response/PhoneNumberDTO;", "(Ljava/lang/String;Ldk/molslinjen/api/shared/response/PhoneNumberDTO;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveBookings", "Ldk/molslinjen/api/services/multiRide/response/MultiRideActiveBookingsResponseDTO;", "getBookingHistory", "Ldk/molslinjen/api/services/multiRide/response/MultiRideHistoryResponseDTO;", "getMultiRideVehicles", "Ldk/molslinjen/api/services/multiRide/response/MultiRideVehiclesResponseDTO;", "removeMultiRideVehicle", BuildConfig.FLAVOR, "licensePlate", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addMultiRideVehicle", "vehicleName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IMultiRideService {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object purchaseOrRefillMultiRide$default(IMultiRideService iMultiRideService, String str, String str2, int i5, PaymentTypeDTO paymentTypeDTO, String str3, String str4, String str5, SiteDTO siteDTO, String str6, String str7, float f5, float f6, Continuation continuation, int i6, Object obj) {
            if (obj == null) {
                return iMultiRideService.purchaseOrRefillMultiRide(str, str2, i5, paymentTypeDTO, str3, str4, str5, siteDTO, str6, (i6 & 512) != 0 ? null : str7, f5, f6, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: purchaseOrRefillMultiRide");
        }
    }

    Object addMultiRideVehicle(String str, String str2, String str3, SiteDTO siteDTO, Continuation<? super ApiResult<Unit>> continuation);

    Object getActiveBookings(String str, SiteDTO siteDTO, Continuation<? super ApiResult<MultiRideActiveBookingsResponseDTO>> continuation);

    Object getBookingHistory(String str, SiteDTO siteDTO, Continuation<? super ApiResult<MultiRideHistoryResponseDTO>> continuation);

    Object getCardPurchasesInfo(SiteDTO siteDTO, CurrencyTypeDTO currencyTypeDTO, Continuation<? super ApiResult<MultiRidePurchaseInfosResponseDTO>> continuation);

    Object getMultiRide(String str, SiteDTO siteDTO, Continuation<? super ApiResult<MultiRideResponseDTO>> continuation);

    Object getMultiRideVehicles(String str, SiteDTO siteDTO, Continuation<? super ApiResult<MultiRideVehiclesResponseDTO>> continuation);

    Object getMultiRides(List<String> list, SiteDTO siteDTO, Continuation<? super ApiResult<MultiRidesResponseDTO>> continuation);

    Object getPrices(String str, SiteDTO siteDTO, CurrencyTypeDTO currencyTypeDTO, Continuation<? super ApiResult<MultiRidePriceStepsResponseDTO>> continuation);

    Object getReceipt(String str, PhoneNumberDTO phoneNumberDTO, SiteDTO siteDTO, Continuation<? super ApiResult<MultiRideSummaryResponseDTO>> continuation);

    Object getSummaryInfo(String str, int i5, CurrencyTypeDTO currencyTypeDTO, SiteDTO siteDTO, Continuation<? super ApiResult<MultiRideSummaryResponseDTO>> continuation);

    Object purchaseOrRefillMultiRide(String str, String str2, int i5, PaymentTypeDTO paymentTypeDTO, String str3, String str4, String str5, SiteDTO siteDTO, String str6, String str7, float f5, float f6, Continuation<? super ApiResult<MultiRidePurchaseResponseDTO>> continuation);

    Object removeMultiRideVehicle(String str, String str2, SiteDTO siteDTO, Continuation<? super ApiResult<Unit>> continuation);
}
