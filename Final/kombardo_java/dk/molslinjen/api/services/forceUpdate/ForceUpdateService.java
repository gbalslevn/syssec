package dk.molslinjen.api.services.forceUpdate;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.BaseService;
import dk.molslinjen.api.services.forceUpdate.response.ForceUpdateDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/api/services/forceUpdate/ForceUpdateService;", "Ldk/molslinjen/api/services/BaseService;", "Ldk/molslinjen/api/services/forceUpdate/IForceUpdateService;", "api", "Ldk/molslinjen/api/services/forceUpdate/ForceUpdateApi;", "<init>", "(Ldk/molslinjen/api/services/forceUpdate/ForceUpdateApi;)V", "getForceUpdateVersion", "Ldk/molslinjen/api/helpers/ApiResult;", "Ldk/molslinjen/api/services/forceUpdate/response/ForceUpdateDTO;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ForceUpdateService extends BaseService implements IForceUpdateService {
    private final ForceUpdateApi api;

    public ForceUpdateService(ForceUpdateApi api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
    }

    @Override // dk.molslinjen.api.services.forceUpdate.IForceUpdateService
    public Object getForceUpdateVersion(Continuation<? super ApiResult<ForceUpdateDTO>> continuation) {
        return withContextHandlingErrors(Dispatchers.getIO(), new ForceUpdateService$getForceUpdateVersion$2(this, null), continuation);
    }
}
