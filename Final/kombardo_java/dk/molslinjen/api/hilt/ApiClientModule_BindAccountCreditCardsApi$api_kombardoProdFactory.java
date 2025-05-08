package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.account.creditcard.AccountCreditCardsApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindAccountCreditCardsApi$api_kombardoProdFactory implements Provider {
    public static AccountCreditCardsApi bindAccountCreditCardsApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (AccountCreditCardsApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindAccountCreditCardsApi$api_kombardoProd(iNetworkManager));
    }
}
