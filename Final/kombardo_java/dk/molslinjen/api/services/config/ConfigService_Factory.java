package dk.molslinjen.api.services.config;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class ConfigService_Factory implements Provider {
    private final Provider<ConfigApi> apiProvider;

    public ConfigService_Factory(Provider<ConfigApi> provider) {
        this.apiProvider = provider;
    }

    public static ConfigService_Factory create(javax.inject.Provider<ConfigApi> provider) {
        return new ConfigService_Factory(Providers.asDaggerProvider(provider));
    }

    public static ConfigService newInstance(ConfigApi configApi) {
        return new ConfigService(configApi);
    }

    public static ConfigService_Factory create(Provider<ConfigApi> provider) {
        return new ConfigService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public ConfigService get() {
        return newInstance(this.apiProvider.get());
    }
}
