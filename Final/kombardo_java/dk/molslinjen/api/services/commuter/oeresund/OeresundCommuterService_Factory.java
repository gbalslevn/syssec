package dk.molslinjen.api.services.commuter.oeresund;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class OeresundCommuterService_Factory implements Provider {
    private final Provider<OeresundCommuterApi> apiProvider;

    public OeresundCommuterService_Factory(Provider<OeresundCommuterApi> provider) {
        this.apiProvider = provider;
    }

    public static OeresundCommuterService_Factory create(javax.inject.Provider<OeresundCommuterApi> provider) {
        return new OeresundCommuterService_Factory(Providers.asDaggerProvider(provider));
    }

    public static OeresundCommuterService newInstance(OeresundCommuterApi oeresundCommuterApi) {
        return new OeresundCommuterService(oeresundCommuterApi);
    }

    public static OeresundCommuterService_Factory create(Provider<OeresundCommuterApi> provider) {
        return new OeresundCommuterService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public OeresundCommuterService get() {
        return newInstance(this.apiProvider.get());
    }
}
