package dk.molslinjen.api.services.newsletters;

import dk.molslinjen.api.helpers.retry.Retry;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.newsletters.request.NewsletterStatusSubscriptionRequest;
import dk.molslinjen.api.services.newsletters.request.NewsletterUpdateSubscriptionRequest;
import dk.molslinjen.api.services.newsletters.response.NewslettersSubscriptionsResponseDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ2\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\f2\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/api/services/newsletters/NewslettersApi;", BuildConfig.FLAVOR, "updateSubscription", "Lretrofit2/Response;", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "request", "Ldk/molslinjen/api/services/newsletters/request/NewsletterUpdateSubscriptionRequest;", "(Ldk/molslinjen/api/services/config/response/SiteDTO;Ldk/molslinjen/api/services/newsletters/request/NewsletterUpdateSubscriptionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSubscriptions", "Ldk/molslinjen/api/services/newsletters/response/NewslettersSubscriptionsResponseDTO;", "Ldk/molslinjen/api/services/newsletters/request/NewsletterStatusSubscriptionRequest;", "authToken", BuildConfig.FLAVOR, "(Ldk/molslinjen/api/services/newsletters/request/NewsletterStatusSubscriptionRequest;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface NewslettersApi {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getSubscriptions$default(NewslettersApi newslettersApi, NewsletterStatusSubscriptionRequest newsletterStatusSubscriptionRequest, SiteDTO siteDTO, String str, Continuation continuation, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSubscriptions");
            }
            if ((i5 & 2) != 0) {
                siteDTO = SiteDTO.Mols;
            }
            return newslettersApi.getSubscriptions(newsletterStatusSubscriptionRequest, siteDTO, str, continuation);
        }
    }

    @POST("v1/newsletters/subscribers/status")
    Object getSubscriptions(@Body NewsletterStatusSubscriptionRequest newsletterStatusSubscriptionRequest, @Header("Line") SiteDTO siteDTO, @Header("token") String str, Continuation<? super Response<NewslettersSubscriptionsResponseDTO>> continuation);

    @PUT("v1/newsletters/subscribers/")
    @Retry
    Object updateSubscription(@Header("Line") SiteDTO siteDTO, @Body NewsletterUpdateSubscriptionRequest newsletterUpdateSubscriptionRequest, Continuation<? super Response<Unit>> continuation);
}
