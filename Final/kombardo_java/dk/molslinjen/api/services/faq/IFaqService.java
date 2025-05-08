package dk.molslinjen.api.services.faq;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.faq.response.FaqCategoriesDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/api/services/faq/IFaqService;", BuildConfig.FLAVOR, "getFaq", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/faq/response/FaqCategoriesDTO;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IFaqService {
    Object getFaq(SiteDTO siteDTO, Continuation<? super ApiResult<FaqCategoriesDTO>> continuation);
}
