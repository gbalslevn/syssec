package dk.molslinjen.domain.managers.api;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.model.settings.ForceUpdate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/managers/api/IForceUpdateManager;", BuildConfig.FLAVOR, "getForceUpdateVersion", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/model/settings/ForceUpdate;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IForceUpdateManager {
    Object getForceUpdateVersion(Continuation<? super ManagerResult<ForceUpdate>> continuation);
}
