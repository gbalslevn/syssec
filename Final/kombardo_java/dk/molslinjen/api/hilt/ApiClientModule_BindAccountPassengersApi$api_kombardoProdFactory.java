package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.account.passenger.AccountPassengersApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindAccountPassengersApi$api_kombardoProdFactory implements Provider {
    public static AccountPassengersApi bindAccountPassengersApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (AccountPassengersApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindAccountPassengersApi$api_kombardoProd(iNetworkManager));
    }
}
