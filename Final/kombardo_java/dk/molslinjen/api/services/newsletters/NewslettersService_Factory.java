package dk.molslinjen.api.services.newsletters;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class NewslettersService_Factory implements Provider {
    private final Provider<NewslettersApi> apiProvider;

    public NewslettersService_Factory(Provider<NewslettersApi> provider) {
        this.apiProvider = provider;
    }

    public static NewslettersService_Factory create(javax.inject.Provider<NewslettersApi> provider) {
        return new NewslettersService_Factory(Providers.asDaggerProvider(provider));
    }

    public static NewslettersService newInstance(NewslettersApi newslettersApi) {
        return new NewslettersService(newslettersApi);
    }

    public static NewslettersService_Factory create(Provider<NewslettersApi> provider) {
        return new NewslettersService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public NewslettersService get() {
        return newInstance(this.apiProvider.get());
    }
}
