package dk.molslinjen.api.services.paymentTypes;

import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.paymentTypes.response.PaymentTypesResponseDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\nH§@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/api/services/paymentTypes/PaymentTypesApi;", BuildConfig.FLAVOR, "getPaymentTypesByCurrency", "Lretrofit2/Response;", "Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypesResponseDTO;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "currency", BuildConfig.FLAVOR, "routeId", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/services/config/response/SiteDTO;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PaymentTypesApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getPaymentTypesByCurrency$default(PaymentTypesApi paymentTypesApi, SiteDTO siteDTO, int i5, String str, Continuation continuation, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPaymentTypesByCurrency");
            }
            if ((i6 & 4) != 0) {
                str = null;
            }
            return paymentTypesApi.getPaymentTypesByCurrency(siteDTO, i5, str, continuation);
        }
    }

    @GET("v1/payment/typesbycurrency")
    @Retry
    Object getPaymentTypesByCurrency(@Header("Line") SiteDTO siteDTO, @Query("currency") int i5, @Query("routeId") String str, Continuation<Response<PaymentTypesResponseDTO>> continuation);
}
