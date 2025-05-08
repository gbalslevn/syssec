package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.faq.FaqApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindFaqApi$api_kombardoProdFactory implements Provider {
    public static FaqApi bindFaqApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (FaqApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindFaqApi$api_kombardoProd(iNetworkManager));
    }
}
