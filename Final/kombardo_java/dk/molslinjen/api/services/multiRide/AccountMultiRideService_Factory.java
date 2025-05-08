package dk.molslinjen.api.services.multiRide;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class AccountMultiRideService_Factory implements Provider {
    private final Provider<AccountMultiRideApi> apiProvider;

    public AccountMultiRideService_Factory(Provider<AccountMultiRideApi> provider) {
        this.apiProvider = provider;
    }

    public static AccountMultiRideService_Factory create(javax.inject.Provider<AccountMultiRideApi> provider) {
        return new AccountMultiRideService_Factory(Providers.asDaggerProvider(provider));
    }

    public static AccountMultiRideService newInstance(AccountMultiRideApi accountMultiRideApi) {
        return new AccountMultiRideService(accountMultiRideApi);
    }

    public static AccountMultiRideService_Factory create(Provider<AccountMultiRideApi> provider) {
        return new AccountMultiRideService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public AccountMultiRideService get() {
        return newInstance(this.apiProvider.get());
    }
}
