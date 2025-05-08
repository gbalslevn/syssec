package dk.molslinjen.api.hilt;

import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dk.molslinjen.api.INetworkManager;
import dk.molslinjen.api.services.notifications.NotificationApi;

/* loaded from: classes2.dex */
public abstract class ApiClientModule_BindNotificationApi$api_kombardoProdFactory implements Provider {
    public static NotificationApi bindNotificationApi$api_kombardoProd(INetworkManager iNetworkManager) {
        return (NotificationApi) Preconditions.checkNotNullFromProvides(ApiClientModule.INSTANCE.bindNotificationApi$api_kombardoProd(iNetworkManager));
    }
}
