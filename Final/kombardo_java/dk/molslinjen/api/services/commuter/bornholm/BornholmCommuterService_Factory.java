package dk.molslinjen.api.services.commuter.bornholm;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class BornholmCommuterService_Factory implements Provider {
    private final Provider<BornholmCommuterApi> apiProvider;

    public BornholmCommuterService_Factory(Provider<BornholmCommuterApi> provider) {
        this.apiProvider = provider;
    }

    public static BornholmCommuterService_Factory create(javax.inject.Provider<BornholmCommuterApi> provider) {
        return new BornholmCommuterService_Factory(Providers.asDaggerProvider(provider));
    }

    public static BornholmCommuterService newInstance(BornholmCommuterApi bornholmCommuterApi) {
        return new BornholmCommuterService(bornholmCommuterApi);
    }

    public static BornholmCommuterService_Factory create(Provider<BornholmCommuterApi> provider) {
        return new BornholmCommuterService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public BornholmCommuterService get() {
        return newInstance(this.apiProvider.get());
    }
}
