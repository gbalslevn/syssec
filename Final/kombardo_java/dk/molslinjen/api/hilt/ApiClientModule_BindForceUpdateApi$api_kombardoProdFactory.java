package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.forceUpdate.ForceUpdateApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindForceUpdateApi$api_kombardoProdFactory implements Provider {
    public static ForceUpdateApi bindForceUpdateApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (ForceUpdateApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindForceUpdateApi$api_kombardoProd(iNetworkManager));
    }
}
