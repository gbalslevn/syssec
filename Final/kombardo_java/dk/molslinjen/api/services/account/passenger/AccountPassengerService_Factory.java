package dk.molslinjen.api.services.account.passenger;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class AccountPassengerService_Factory implements Provider {
    private final Provider<AccountPassengersApi> apiProvider;

    public AccountPassengerService_Factory(Provider<AccountPassengersApi> provider) {
        this.apiProvider = provider;
    }

    public static AccountPassengerService_Factory create(javax.inject.Provider<AccountPassengersApi> provider) {
        return new AccountPassengerService_Factory(Providers.asDaggerProvider(provider));
    }

    public static AccountPassengerService newInstance(AccountPassengersApi accountPassengersApi) {
        return new AccountPassengerService(accountPassengersApi);
    }

    public static AccountPassengerService_Factory create(Provider<AccountPassengersApi> provider) {
        return new AccountPassengerService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public AccountPassengerService get() {
        return newInstance(this.apiProvider.get());
    }
}
