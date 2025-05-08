package dk.molslinjen.api.services.payment;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class PaymentService_Factory implements Provider {
    private final Provider<PaymentApi> apiProvider;

    public PaymentService_Factory(Provider<PaymentApi> provider) {
        this.apiProvider = provider;
    }

    public static PaymentService_Factory create(javax.inject.Provider<PaymentApi> provider) {
        return new PaymentService_Factory(Providers.asDaggerProvider(provider));
    }

    public static PaymentService newInstance(PaymentApi paymentApi) {
        return new PaymentService(paymentApi);
    }

    public static PaymentService_Factory create(Provider<PaymentApi> provider) {
        return new PaymentService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public PaymentService get() {
        return newInstance(this.apiProvider.get());
    }
}
