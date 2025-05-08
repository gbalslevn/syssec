package dk.molslinjen.api.services.newsletters;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.newsletters.response.NewslettersSubscriptionsResponseDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH¦@¢\u0006\u0002\u0010\fJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/api/services/newsletters/INewslettersService;", BuildConfig.FLAVOR, "updateSubscription", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "email", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "allowNewsletter", BuildConfig.FLAVOR, "allowMarketingPromotions", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadSubscriptions", "Ldk/molslinjen/api/services/newsletters/response/NewslettersSubscriptionsResponseDTO;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface INewslettersService {
    Object loadSubscriptions(String str, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<NewslettersSubscriptionsResponseDTO>> continuation);

    Object updateSubscription(String str, SiteDTO siteDTO, Boolean bool, Boolean bool2, Continuation<? super ApiResult<Unit>> continuation);
}
