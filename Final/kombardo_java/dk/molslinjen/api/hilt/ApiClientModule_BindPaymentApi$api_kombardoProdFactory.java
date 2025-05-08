package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.payment.PaymentApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindPaymentApi$api_kombardoProdFactory implements Provider {
    public static PaymentApi bindPaymentApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (PaymentApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindPaymentApi$api_kombardoProd(iNetworkManager));
    }
}
