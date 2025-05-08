package dk.molslinjen.api.services.newsletters;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.account.response.AuthTokenDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.newsletters.response.NewslettersSubscriptionsResponseDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J8\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/api/services/newsletters/NewslettersService;", "Ldk/molslinjen/api/services/newsletters/INewslettersService;", "Ldk/molslinjen/api/services/BaseService;", "api", "Ldk/molslinjen/api/services/newsletters/NewslettersApi;", "<init>", "(Ldk/molslinjen/api/services/newsletters/NewslettersApi;)V", "updateSubscription", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "email", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "allowNewsletter", BuildConfig.FLAVOR, "allowMarketingPromotions", "(Ljava/lang/String;Ldk/molslinjen/api/services/config/response/SiteDTO;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadSubscriptions", "Ldk/molslinjen/api/services/newsletters/response/NewslettersSubscriptionsResponseDTO;", "authToken", "Ldk/molslinjen/api/services/account/response/AuthTokenDTO;", "(Ljava/lang/String;Ldk/molslinjen/api/services/account/response/AuthTokenDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NewslettersService extends BaseService implements INewslettersService {
    private final NewslettersApi api;

    public NewslettersService(NewslettersApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.newsletters.INewslettersService
    public Object loadSubscriptions(String str, AuthTokenDTO authTokenDTO, Continuation<? super ApiResult<NewslettersSubscriptionsResponseDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new NewslettersService$loadSubscriptions$2(this, str, authTokenDTO, null), continuation);
    }

    @Override // dk.molslinjen.api.services.newsletters.INewslettersService
    public Object updateSubscription(String str, SiteDTO siteDTO, Boolean bool, Boolean bool2, Continuation<? super ApiResult<Unit>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new NewslettersService$updateSubscription$2(this, siteDTO, str, bool, bool2, null), continuation);
    }
}
