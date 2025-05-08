package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.multiRide.MultiRideApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindMultiRideApiFactory implements Provider {
    public static MultiRideApi bindMultiRideApi(INetworkManager iNetworkManager) {
        return (MultiRideApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindMultiRideApi(iNetworkManager));
    }
}
