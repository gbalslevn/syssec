package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.account.AccountApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindAccountApi$api_kombardoProdFactory implements Provider {
    public static AccountApi bindAccountApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (AccountApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindAccountApi$api_kombardoProd(iNetworkManager));
    }
}
