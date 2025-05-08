package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.commuter.oeresund.OeresundCommuterApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindOeresundCommuterApiFactory implements Provider {
    public static OeresundCommuterApi bindOeresundCommuterApi(INetworkManager iNetworkManager) {
        return (OeresundCommuterApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindOeresundCommuterApi(iNetworkManager));
    }
}
