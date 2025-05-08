package dk.molslinjen.api.services.payment;

import dk.molslinjen.api.extensions.SiteDTOExtensionsKt;
import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.payment.request.CreatePaymentRequestParameters;
import dk.molslinjen.api.services.payment.request.PaymentProductTypeDTO;
import dk.molslinjen.api.services.payment.request.PaymentServiceAppPaymentRedirectDetailsDTO;
import dk.molslinjen.api.services.payment.request.PaymentSourceDTO;
import dk.molslinjen.api.services.payment.response.CreatePaymentResponseDTO;
import dk.molslinjen.api.services.payment.response.PaymentStatusResponseDTO;
import dk.molslinjen.api.services.payment.response.UpdateOrderPaymentStatusResponseDTO;
import dk.molslinjen.api.services.paymentTypes.response.PaymentTypeDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006Jf\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u0010\u001fJ,\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010\"J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Ldk/molslinjen/api/services/payment/PaymentService;", "Ldk/molslinjen/api/services/payment/IPaymentService;", "Ldk/molslinjen/api/services/BaseService;", "api", "Ldk/molslinjen/api/services/payment/PaymentApi;", "<init>", "(Ldk/molslinjen/api/services/payment/PaymentApi;)V", "getSaleOnBoardPaymentWindowUrl", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/payment/response/CreatePaymentResponseDTO;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "reservationNumber", BuildConfig.FLAVOR, "amount", BuildConfig.FLAVOR, "currency", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "creditCardToken", "paymentType", "Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;", "language", "paymentCallbackUrl", "email", "paymentRedirectDetails", "Ldk/molslinjen/api/services/payment/request/PaymentServiceAppPaymentRedirectDetailsDTO;", "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;ILdk/molslinjen/api/shared/response/CurrencyTypeDTO;Ljava/lang/String;Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/payment/request/PaymentServiceAppPaymentRedirectDetailsDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPaymentCompleted", "Ldk/molslinjen/api/services/payment/response/PaymentStatusResponseDTO;", "paymentCapturedLater", BuildConfig.FLAVOR, "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstRequestTime", "Lorg/threeten/bp/LocalDateTime;", "(Ljava/lang/String;ZLorg/threeten/bp/LocalDateTime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOrderPaymentStatus", "Ldk/molslinjen/api/services/payment/response/UpdateOrderPaymentStatusResponseDTO;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaymentService extends BaseService implements IPaymentService {
    private final PaymentApi api;

    public PaymentService(PaymentApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.payment.IPaymentService
    public Object getSaleOnBoardPaymentWindowUrl(SiteDTO siteDTO, String str, int i5, CurrencyTypeDTO currencyTypeDTO, String str2, PaymentTypeDTO paymentTypeDTO, String str3, String str4, String str5, PaymentServiceAppPaymentRedirectDetailsDTO paymentServiceAppPaymentRedirectDetailsDTO, Continuation<? super ApiResult<CreatePaymentResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new PaymentService$getSaleOnBoardPaymentWindowUrl$2(this, new CreatePaymentRequestParameters(i5, str4, str2, currencyTypeDTO, str3, str, paymentTypeDTO, PaymentProductTypeDTO.Other, str4, PaymentSourceDTO.LsRetail, str5, SiteDTOExtensionsKt.toPaymentLine(siteDTO), paymentServiceAppPaymentRedirectDetailsDTO), null), continuation);
    }

    @Override // dk.molslinjen.api.services.payment.IPaymentService
    public Object isPaymentCompleted(String str, boolean z5, Continuation<? super ApiResult<PaymentStatusResponseDTO>> continuation) {
        LocalDateTime now = LocalDateTime.now();
        Intrinsics.checkNotNullExpressionValue(now, "now(...)");
        return isPaymentCompleted(str, z5, now, continuation);
    }

    @Override // dk.molslinjen.api.services.payment.IPaymentService
    public Object updateOrderPaymentStatus(String str, Continuation<? super ApiResult<UpdateOrderPaymentStatusResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new PaymentService$updateOrderPaymentStatus$2(this, str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object isPaymentCompleted(String str, boolean z5, LocalDateTime localDateTime, Continuation<? super ApiResult<PaymentStatusResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new PaymentService$isPaymentCompleted$3(this, str, z5, localDateTime, null), continuation);
    }
}
