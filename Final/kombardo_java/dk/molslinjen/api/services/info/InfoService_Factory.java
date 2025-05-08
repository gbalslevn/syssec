package dk.molslinjen.api.services.info;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class InfoService_Factory implements Provider {
    private final Provider<InfoApi> apiProvider;

    public InfoService_Factory(Provider<InfoApi> provider) {
        this.apiProvider = provider;
    }

    public static InfoService_Factory create(javax.inject.Provider<InfoApi> provider) {
        return new InfoService_Factory(Providers.asDaggerProvider(provider));
    }

    public static InfoService newInstance(InfoApi infoApi) {
        return new InfoService(infoApi);
    }

    public static InfoService_Factory create(Provider<InfoApi> provider) {
        return new InfoService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public InfoService get() {
        return newInstance(this.apiProvider.get());
    }
}
