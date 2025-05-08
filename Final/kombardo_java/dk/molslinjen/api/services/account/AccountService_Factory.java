package dk.molslinjen.api.services.account;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class AccountService_Factory implements Provider {
    private final Provider<AccountApi> accountApiProvider;

    public AccountService_Factory(Provider<AccountApi> provider) {
        this.accountApiProvider = provider;
    }

    public static AccountService_Factory create(javax.inject.Provider<AccountApi> provider) {
        return new AccountService_Factory(Providers.asDaggerProvider(provider));
    }

    public static AccountService newInstance(AccountApi accountApi) {
        return new AccountService(accountApi);
    }

    public static AccountService_Factory create(Provider<AccountApi> provider) {
        return new AccountService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public AccountService get() {
        return newInstance(this.accountApiProvider.get());
    }
}
