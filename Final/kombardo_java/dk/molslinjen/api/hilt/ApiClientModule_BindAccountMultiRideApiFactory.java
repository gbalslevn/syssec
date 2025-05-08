package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.multiRide.AccountMultiRideApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindAccountMultiRideApiFactory implements Provider {
    public static AccountMultiRideApi bindAccountMultiRideApi(INetworkManager iNetworkManager) {
        return (AccountMultiRideApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindAccountMultiRideApi(iNetworkManager));
    }
}
