package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.paymentTypes.PaymentTypesApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindPaymentTypesApi$api_kombardoProdFactory implements Provider {
    public static PaymentTypesApi bindPaymentTypesApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (PaymentTypesApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindPaymentTypesApi$api_kombardoProd(iNetworkManager));
    }
}
