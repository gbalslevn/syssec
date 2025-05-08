package dk.molslinjen.api.services.account.creditcard;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class AccountCreditCardsService_Factory implements Provider {
    private final Provider<AccountCreditCardsApi> apiProvider;

    public AccountCreditCardsService_Factory(Provider<AccountCreditCardsApi> provider) {
        this.apiProvider = provider;
    }

    public static AccountCreditCardsService_Factory create(javax.inject.Provider<AccountCreditCardsApi> provider) {
        return new AccountCreditCardsService_Factory(Providers.asDaggerProvider(provider));
    }

    public static AccountCreditCardsService newInstance(AccountCreditCardsApi accountCreditCardsApi) {
        return new AccountCreditCardsService(accountCreditCardsApi);
    }

    public static AccountCreditCardsService_Factory create(Provider<AccountCreditCardsApi> provider) {
        return new AccountCreditCardsService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public AccountCreditCardsService get() {
        return newInstance(this.apiProvider.get());
    }
}
