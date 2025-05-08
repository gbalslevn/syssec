package dk.molslinjen.api.services.faq;

import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.services.faq.response.FaqCategoriesDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/api/services/faq/FaqApi;", BuildConfig.FLAVOR, "getFaq", "Lretrofit2/Response;", "Ldk/molslinjen/api/services/faq/response/FaqCategoriesDTO;", "site", "Ldk/molslinjen/api/services/config/response/SiteDTO;", "(Ldk/molslinjen/api/services/config/response/SiteDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FaqApi {
    @GET("v1/app/content/faq")
    Object getFaq(@Header("Line") SiteDTO siteDTO, Continuation<? super Response<FaqCategoriesDTO>> continuation);
}
