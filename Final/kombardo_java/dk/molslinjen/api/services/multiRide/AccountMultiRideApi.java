package dk.molslinjen.api.services.multiRide;

import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.multiRide.request.AddExistingMultiRideAgreementRequestParameters;
import dk.molslinjen.api.services.multiRide.response.AccountMultiRidesResponseDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/api/services/multiRide/AccountMultiRideApi;", BuildConfig.FLAVOR, "addExistingMultiRide", "Lretrofit2/Response;", BuildConfig.FLAVOR, "requestParameters", "Ldk/molslinjen/api/services/multiRide/request/AddExistingMultiRideAgreementRequestParameters;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "authToken", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/services/multiRide/request/AddExistingMultiRideAgreementRequestParameters;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMultiRides", "Ldk/molslinjen/api/services/multiRide/response/AccountMultiRidesResponseDTO;", "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AccountMultiRideApi {
    @POST("v1/accounts/purchases/multirides/link")
    @Retry
    Object addExistingMultiRide(@Body AddExistingMultiRideAgreementRequestParameters addExistingMultiRideAgreementRequestParameters, @Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<Unit>> continuation);

    @GET("v1/accounts/purchases/multirides")
    @Retry
    Object getMultiRides(@Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<AccountMultiRidesResponseDTO>> continuation);
}
