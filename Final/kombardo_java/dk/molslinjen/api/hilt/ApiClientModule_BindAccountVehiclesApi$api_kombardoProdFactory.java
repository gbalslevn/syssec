package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.account.vehicle.AccountVehiclesApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindAccountVehiclesApi$api_kombardoProdFactory implements Provider {
    public static AccountVehiclesApi bindAccountVehiclesApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (AccountVehiclesApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindAccountVehiclesApi$api_kombardoProd(iNetworkManager));
    }
}
