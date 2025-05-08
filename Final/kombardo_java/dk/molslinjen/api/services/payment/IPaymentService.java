package dk.molslinjen.api.services.payment;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.payment.request.PaymentServiceAppPaymentRedirectDetailsDTO;
import dk.molslinjen.api.services.payment.response.CreatePaymentResponseDTO;
import dk.molslinjen.api.services.payment.response.PaymentStatusResponseDTO;
import dk.molslinjen.api.services.payment.response.UpdateOrderPaymentStatusResponseDTO;
import dk.molslinjen.api.services.paymentTypes.response.PaymentTypeDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJf\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/api/services/payment/IPaymentService;", BuildConfig.FLAVOR, "isPaymentCompleted", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/payment/response/PaymentStatusResponseDTO;", "reservationNumber", BuildConfig.FLAVOR, "paymentCapturedLater", BuildConfig.FLAVOR, "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSaleOnBoardPaymentWindowUrl", "Ldk/molslinjen/api/services/payment/response/CreatePaymentResponseDTO;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "amount", BuildConfig.FLAVOR, "currency", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "creditCardToken", "paymentType", "Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;", "language", "paymentCallbackUrl", "email", "paymentRedirectDetails", "Ldk/molslinjen/api/services/payment/request/PaymentServiceAppPaymentRedirectDetailsDTO;", "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;ILdk/molslinjen/api/shared/response/CurrencyTypeDTO;Ljava/lang/String;Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/payment/request/PaymentServiceAppPaymentRedirectDetailsDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOrderPaymentStatus", "Ldk/molslinjen/api/services/payment/response/UpdateOrderPaymentStatusResponseDTO;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IPaymentService {
    Object getSaleOnBoardPaymentWindowUrl(SiteDTO siteDTO, String str, int i5, CurrencyTypeDTO currencyTypeDTO, String str2, PaymentTypeDTO paymentTypeDTO, String str3, String str4, String str5, PaymentServiceAppPaymentRedirectDetailsDTO paymentServiceAppPaymentRedirectDetailsDTO, Continuation<? super ApiResult<CreatePaymentResponseDTO>> continuation);

    Object isPaymentCompleted(String str, boolean z5, Continuation<? super ApiResult<PaymentStatusResponseDTO>> continuation);

    Object updateOrderPaymentStatus(String str, Continuation<? super ApiResult<UpdateOrderPaymentStatusResponseDTO>> continuation);
}
