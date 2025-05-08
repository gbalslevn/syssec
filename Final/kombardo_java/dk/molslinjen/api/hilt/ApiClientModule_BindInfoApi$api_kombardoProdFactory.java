package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.info.InfoApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindInfoApi$api_kombardoProdFactory implements Provider {
    public static InfoApi bindInfoApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (InfoApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindInfoApi$api_kombardoProd(iNetworkManager));
    }
}
