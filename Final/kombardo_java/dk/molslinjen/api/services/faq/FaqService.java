package dk.molslinjen.api.services.faq;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.faq.response.FaqCategoriesDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ldk/molslinjen/api/services/faq/FaqService;", "Ldk/molslinjen/api/services/faq/IFaqService;", "Ldk/molslinjen/api/services/BaseService;", "api", "Ldk/molslinjen/api/services/faq/FaqApi;", "<init>", "(Ldk/molslinjen/api/services/faq/FaqApi;)V", "getFaq", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/faq/response/FaqCategoriesDTO;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FaqService extends BaseService implements IFaqService {
    private final FaqApi api;

    public FaqService(FaqApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.faq.IFaqService
    public Object getFaq(SiteDTO siteDTO, Continuation<? super ApiResult<FaqCategoriesDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new FaqService$getFaq$2(this, siteDTO, null), continuation);
    }
}
