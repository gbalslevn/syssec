package dk.molslinjen.api.services.faq;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class FaqService_Factory implements Provider {
    private final Provider<FaqApi> apiProvider;

    public FaqService_Factory(Provider<FaqApi> provider) {
        this.apiProvider = provider;
    }

    public static FaqService_Factory create(javax.inject.Provider<FaqApi> provider) {
        return new FaqService_Factory(Providers.asDaggerProvider(provider));
    }

    public static FaqService newInstance(FaqApi faqApi) {
        return new FaqService(faqApi);
    }

    public static FaqService_Factory create(Provider<FaqApi> provider) {
        return new FaqService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public FaqService get() {
        return newInstance(this.apiProvider.get());
    }
}
