package dk.molslinjen.api.services.paymentTypes;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class PaymentTypesService_Factory implements Provider {
    private final Provider<PaymentTypesApi> apiProvider;

    public PaymentTypesService_Factory(Provider<PaymentTypesApi> provider) {
        this.apiProvider = provider;
    }

    public static PaymentTypesService_Factory create(javax.inject.Provider<PaymentTypesApi> provider) {
        return new PaymentTypesService_Factory(Providers.asDaggerProvider(provider));
    }

    public static PaymentTypesService newInstance(PaymentTypesApi paymentTypesApi) {
        return new PaymentTypesService(paymentTypesApi);
    }

    public static PaymentTypesService_Factory create(Provider<PaymentTypesApi> provider) {
        return new PaymentTypesService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public PaymentTypesService get() {
        return newInstance(this.apiProvider.get());
    }
}
