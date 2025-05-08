package dk.molslinjen.api.services.saleOnBoard;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class SaleOnBoardService_Factory implements Provider {
    private final Provider<SaleOnBoardApi> apiProvider;

    public SaleOnBoardService_Factory(Provider<SaleOnBoardApi> provider) {
        this.apiProvider = provider;
    }

    public static SaleOnBoardService_Factory create(javax.inject.Provider<SaleOnBoardApi> provider) {
        return new SaleOnBoardService_Factory(Providers.asDaggerProvider(provider));
    }

    public static SaleOnBoardService newInstance(SaleOnBoardApi saleOnBoardApi) {
        return new SaleOnBoardService(saleOnBoardApi);
    }

    public static SaleOnBoardService_Factory create(Provider<SaleOnBoardApi> provider) {
        return new SaleOnBoardService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public SaleOnBoardService get() {
        return newInstance(this.apiProvider.get());
    }
}
