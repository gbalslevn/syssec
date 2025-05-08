package dk.molslinjen.api.services.paymentTypes;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.paymentTypes.response.PaymentTypesResponseDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J.\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/api/services/paymentTypes/PaymentTypesService;", "Ldk/molslinjen/api/services/paymentTypes/IPaymentTypesService;", "Ldk/molslinjen/api/services/BaseService;", "api", "Ldk/molslinjen/api/services/paymentTypes/PaymentTypesApi;", "<init>", "(Ldk/molslinjen/api/services/paymentTypes/PaymentTypesApi;)V", "getPaymentTypes", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypesResponseDTO;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "currency", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "routeId", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaymentTypesService extends BaseService implements IPaymentTypesService {
    private final PaymentTypesApi api;

    public PaymentTypesService(PaymentTypesApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.paymentTypes.IPaymentTypesService
    public Object getPaymentTypes(SiteDTO siteDTO, CurrencyTypeDTO currencyTypeDTO, String str, Continuation<? super ApiResult<PaymentTypesResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new PaymentTypesService$getPaymentTypes$2(this, siteDTO, currencyTypeDTO, str, null), continuation);
    }
}
