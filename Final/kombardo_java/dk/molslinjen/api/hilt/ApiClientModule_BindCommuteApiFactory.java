package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.commuter.bornholm.BornholmCommuterApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindCommuteApiFactory implements Provider {
    public static BornholmCommuterApi bindCommuteApi(INetworkManager iNetworkManager) {
        return (BornholmCommuterApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindCommuteApi(iNetworkManager));
    }
}
