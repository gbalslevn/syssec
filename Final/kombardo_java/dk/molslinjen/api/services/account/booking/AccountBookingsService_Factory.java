package dk.molslinjen.api.services.account.booking;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class AccountBookingsService_Factory implements Provider {
    private final Provider<AccountBookingsApi> apiProvider;

    public AccountBookingsService_Factory(Provider<AccountBookingsApi> provider) {
        this.apiProvider = provider;
    }

    public static AccountBookingsService_Factory create(javax.inject.Provider<AccountBookingsApi> provider) {
        return new AccountBookingsService_Factory(Providers.asDaggerProvider(provider));
    }

    public static AccountBookingsService newInstance(AccountBookingsApi accountBookingsApi) {
        return new AccountBookingsService(accountBookingsApi);
    }

    public static AccountBookingsService_Factory create(Provider<AccountBookingsApi> provider) {
        return new AccountBookingsService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public AccountBookingsService get() {
        return newInstance(this.apiProvider.get());
    }
}
