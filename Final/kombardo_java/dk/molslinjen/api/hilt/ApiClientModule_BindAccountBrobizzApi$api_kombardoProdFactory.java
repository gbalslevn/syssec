package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.account.brobizz.AccountBrobizzApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindAccountBrobizzApi$api_kombardoProdFactory implements Provider {
    public static AccountBrobizzApi bindAccountBrobizzApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (AccountBrobizzApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindAccountBrobizzApi$api_kombardoProd(iNetworkManager));
    }
}
