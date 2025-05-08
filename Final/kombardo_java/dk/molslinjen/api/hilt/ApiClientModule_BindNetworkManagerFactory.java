package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.core.providers.IApiInfoProvider;
import dk.molslinjen.core.version.AppVersionProvider;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindNetworkManagerFactory implements Provider {
    public static INetworkManager bindNetworkManager(IApiInfoProvider iApiInfoProvider, AppVersionProvider appVersionProvider) {
        return (INetworkManager) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindNetworkManager(iApiInfoProvider, appVersionProvider));
    }
}
