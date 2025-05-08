package dk.molslinjen.api.services.paymentTypes;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.paymentTypes.response.PaymentTypesResponseDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/api/services/paymentTypes/IPaymentTypesService;", BuildConfig.FLAVOR, "getPaymentTypes", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypesResponseDTO;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "currency", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "routeId", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IPaymentTypesService {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getPaymentTypes$default(IPaymentTypesService iPaymentTypesService, SiteDTO siteDTO, CurrencyTypeDTO currencyTypeDTO, String str, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPaymentTypes");
            }
            if ((i5 & 4) != 0) {
                str = null;
            }
            return iPaymentTypesService.getPaymentTypes(siteDTO, currencyTypeDTO, str, continuation);
        }
    }

    Object getPaymentTypes(SiteDTO siteDTO, CurrencyTypeDTO currencyTypeDTO, String str, Continuation<? super ApiResult<PaymentTypesResponseDTO>> continuation);
}
