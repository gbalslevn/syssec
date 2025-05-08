package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.newsletters.NewslettersApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindNewslettersApi$api_kombardoProdFactory implements Provider {
    public static NewslettersApi bindNewslettersApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (NewslettersApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindNewslettersApi$api_kombardoProd(iNetworkManager));
    }
}
