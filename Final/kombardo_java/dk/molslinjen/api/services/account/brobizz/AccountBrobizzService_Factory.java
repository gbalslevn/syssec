package dk.molslinjen.api.services.account.brobizz;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class AccountBrobizzService_Factory implements Provider {
    private final Provider<AccountBrobizzApi> apiProvider;

    public AccountBrobizzService_Factory(Provider<AccountBrobizzApi> provider) {
        this.apiProvider = provider;
    }

    public static AccountBrobizzService_Factory create(javax.inject.Provider<AccountBrobizzApi> provider) {
        return new AccountBrobizzService_Factory(Providers.asDaggerProvider(provider));
    }

    public static AccountBrobizzService newInstance(AccountBrobizzApi accountBrobizzApi) {
        return new AccountBrobizzService(accountBrobizzApi);
    }

    public static AccountBrobizzService_Factory create(Provider<AccountBrobizzApi> provider) {
        return new AccountBrobizzService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public AccountBrobizzService get() {
        return newInstance(this.apiProvider.get());
    }
}
