package dk.molslinjen.api.services.multiRide;

import dagger.internal.Provider;
import dagger.internal.Providers;
import dk.molslinjen.core.providers.IPaymentCallbackUrlProvider;

/* loaded from: classes2.dex */
public final class MultiRideService_Factory implements Provider {
    private final Provider<MultiRideApi> apiProvider;
    private final Provider<IPaymentCallbackUrlProvider> paymentCallbackUrlProvider;

    public MultiRideService_Factory(Provider<MultiRideApi> provider, Provider<IPaymentCallbackUrlProvider> provider2) {
        this.apiProvider = provider;
        this.paymentCallbackUrlProvider = provider2;
    }

    public static MultiRideService_Factory create(javax.inject.Provider<MultiRideApi> provider, javax.inject.Provider<IPaymentCallbackUrlProvider> provider2) {
        return new MultiRideService_Factory(Providers.asDaggerProvider(provider), Providers.asDaggerProvider(provider2));
    }

    public static MultiRideService newInstance(MultiRideApi multiRideApi, IPaymentCallbackUrlProvider iPaymentCallbackUrlProvider) {
        return new MultiRideService(multiRideApi, iPaymentCallbackUrlProvider);
    }

    public static MultiRideService_Factory create(Provider<MultiRideApi> provider, Provider<IPaymentCallbackUrlProvider> provider2) {
        return new MultiRideService_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public MultiRideService get() {
        return newInstance(this.apiProvider.get(), this.paymentCallbackUrlProvider.get());
    }
}
