package dk.molslinjen.api.services.geolocator;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class GeoLocatorService_Factory implements Provider {
    private final Provider<GeoLocatorApi> apiProvider;

    public GeoLocatorService_Factory(Provider<GeoLocatorApi> provider) {
        this.apiProvider = provider;
    }

    public static GeoLocatorService_Factory create(javax.inject.Provider<GeoLocatorApi> provider) {
        return new GeoLocatorService_Factory(Providers.asDaggerProvider(provider));
    }

    public static GeoLocatorService newInstance(GeoLocatorApi geoLocatorApi) {
        return new GeoLocatorService(geoLocatorApi);
    }

    public static GeoLocatorService_Factory create(Provider<GeoLocatorApi> provider) {
        return new GeoLocatorService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public GeoLocatorService get() {
        return newInstance(this.apiProvider.get());
    }
}
