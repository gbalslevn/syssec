package dk.molslinjen.api.services.notifications;

import dagger.internal.Provider;
import dagger.internal.Providers;

/* loaded from: classes2.dex */
public final class NotificationService_Factory implements Provider {
    private final Provider<NotificationApi> apiProvider;

    public NotificationService_Factory(Provider<NotificationApi> provider) {
        this.apiProvider = provider;
    }

    public static NotificationService_Factory create(javax.inject.Provider<NotificationApi> provider) {
        return new NotificationService_Factory(Providers.asDaggerProvider(provider));
    }

    public static NotificationService newInstance(NotificationApi notificationApi) {
        return new NotificationService(notificationApi);
    }

    public static NotificationService_Factory create(Provider<NotificationApi> provider) {
        return new NotificationService_Factory(provider);
    }

    @Override // javax.inject.Provider
    public NotificationService get() {
        return newInstance(this.apiProvider.get());
    }
}
