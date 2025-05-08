package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.config.ConfigApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindConfigApi$api_kombardoProdFactory implements Provider {
    public static ConfigApi bindConfigApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (ConfigApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindConfigApi$api_kombardoProd(iNetworkManager));
    }
}
