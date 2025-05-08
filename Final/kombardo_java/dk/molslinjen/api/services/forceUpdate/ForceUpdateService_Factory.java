package dk.molslinjen.api.services.forceUpdate;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class ForceUpdateService_Factory implements Provider {
    private final Provider<ForceUpdateApi> apiProvider;

    public ForceUpdateService_Factory(Provider<ForceUpdateApi> provider) {
        this.apiProvider = provider;
    }

    public static ForceUpdateService_Factory create(javax.inject.Provider<ForceUpdateApi> provider) {
        return new ForceUpdateService_Factory(Providers.asDaggerProvider(provider));
    }

    public static ForceUpdateService newInstance(ForceUpdateApi forceUpdateApi) {
        return new ForceUpdateService(forceUpdateApi);
    }

    public static ForceUpdateService_Factory create(Provider<ForceUpdateApi> provider) {
        return new ForceUpdateService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public ForceUpdateService get() {
        return newInstance(this.apiProvider.get());
    }
}
