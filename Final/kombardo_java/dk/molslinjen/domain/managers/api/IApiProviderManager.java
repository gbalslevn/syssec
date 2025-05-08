package dk.molslinjen.domain.managers.api;

import dk.molslinjen.core.ApiEnvironment;
import dk.molslinjen.core.providers.IApiInfoProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\u0004H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H¦@¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/domain/managers/api/IApiProviderManager;", "Ldk/molslinjen/core/providers/IApiInfoProvider;", "overrideApiState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/core/ApiEnvironment;", "getOverrideApiState", "()Lkotlinx/coroutines/flow/StateFlow;", "originalApi", "getOriginalApi", "()Ldk/molslinjen/core/ApiEnvironment;", "overrideApi", "getOverrideApi", "getActiveApi", "getAvailableApis", BuildConfig.FLAVOR, "setApiEnvironment", BuildConfig.FLAVOR, "apiEnvironment", "(Ldk/molslinjen/core/ApiEnvironment;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IApiProviderManager extends IApiInfoProvider {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static ApiEnvironment getActiveApi(IApiProviderManager iApiProviderManager) {
            ApiEnvironment overrideApi = iApiProviderManager.getOverrideApi();
            return overrideApi == null ? iApiProviderManager.getOriginalApi() : overrideApi;
        }

        public static ApiEnvironment getOverrideApi(IApiProviderManager iApiProviderManager) {
            return iApiProviderManager.getOverrideApiState().getValue();
        }
    }

    ApiEnvironment getActiveApi();

    List<ApiEnvironment> getAvailableApis();

    @Override // dk.molslinjen.core.providers.IApiInfoProvider
    ApiEnvironment getOriginalApi();

    @Override // dk.molslinjen.core.providers.IApiInfoProvider
    ApiEnvironment getOverrideApi();

    StateFlow<ApiEnvironment> getOverrideApiState();

    Object setApiEnvironment(ApiEnvironment apiEnvironment, Continuation<? super Unit> continuation);
}
