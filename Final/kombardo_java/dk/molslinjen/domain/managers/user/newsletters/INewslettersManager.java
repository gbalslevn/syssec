package dk.molslinjen.domain.managers.user.newsletters;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ8\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H¦@¢\u0006\u0002\u0010\u0013R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/domain/managers/user/newsletters/INewslettersManager;", BuildConfig.FLAVOR, "state", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/user/newsletters/NewslettersManagerState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadSubscriptions", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "email", BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSubscription", "site", "Ldk/molslinjen/domain/model/config/Site;", "allowNewsletter", BuildConfig.FLAVOR, "allowMarketingPromotions", "(Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface INewslettersManager {
    StateFlow<NewslettersManagerState> getState();

    Object loadSubscriptions(String str, Continuation<? super ManagerResult<Unit>> continuation);

    Object updateSubscription(String str, Site site, Boolean bool, Boolean bool2, Continuation<? super ManagerResult<Unit>> continuation);
}
