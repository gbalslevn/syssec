package dk.molslinjen.api.services.account.vehicle;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class AccountVehicleService_Factory implements Provider {
    private final Provider<AccountVehiclesApi> apiProvider;

    public AccountVehicleService_Factory(Provider<AccountVehiclesApi> provider) {
        this.apiProvider = provider;
    }

    public static AccountVehicleService_Factory create(javax.inject.Provider<AccountVehiclesApi> provider) {
        return new AccountVehicleService_Factory(Providers.asDaggerProvider(provider));
    }

    public static AccountVehicleService newInstance(AccountVehiclesApi accountVehiclesApi) {
        return new AccountVehicleService(accountVehiclesApi);
    }

    public static AccountVehicleService_Factory create(Provider<AccountVehiclesApi> provider) {
        return new AccountVehicleService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public AccountVehicleService get() {
        return newInstance(this.apiProvider.get());
    }
}
