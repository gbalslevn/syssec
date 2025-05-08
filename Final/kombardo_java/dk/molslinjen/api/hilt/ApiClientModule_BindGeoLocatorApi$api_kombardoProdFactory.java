package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.geolocator.GeoLocatorApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindGeoLocatorApi$api_kombardoProdFactory implements Provider {
    public static GeoLocatorApi bindGeoLocatorApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (GeoLocatorApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindGeoLocatorApi$api_kombardoProd(iNetworkManager));
    }
}
