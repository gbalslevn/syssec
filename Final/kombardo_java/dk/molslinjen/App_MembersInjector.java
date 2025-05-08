package dk.molslinjen;

import androidx.hilt.work.HiltWorkerFactory;
import dk.molslinjen.core.location.ILocationManager;
import dk.molslinjen.core.migration.IMigrator;
import dk.molslinjen.core.push.IPushHandler;
import dk.molslinjen.domain.analytics.IAdjustTracker;
import dk.molslinjen.domain.analytics.IFacebookTracker;
import dk.molslinjen.domain.managers.api.IApiProviderManager;
import dk.molslinjen.domain.managers.notification.INotificationManager;
import dk.molslinjen.domain.model.settings.ISettings;

/* loaded from: classes2.dex */
public abstract class App_MembersInjector {
    public static void injectAdjustTracker(App app, IAdjustTracker iAdjustTracker) {
        app.adjustTracker = iAdjustTracker;
    }

    public static void injectApiProviderManager(App app, IApiProviderManager iApiProviderManager) {
        app.apiProviderManager = iApiProviderManager;
    }

    public static void injectFacebookTracker(App app, IFacebookTracker iFacebookTracker) {
        app.facebookTracker = iFacebookTracker;
    }

    public static void injectLocationManager(App app, ILocationManager iLocationManager) {
        app.locationManager = iLocationManager;
    }

    public static void injectMigrator(App app, IMigrator iMigrator) {
        app.migrator = iMigrator;
    }

    public static void injectNotificationManager(App app, INotificationManager iNotificationManager) {
        app.notificationManager = iNotificationManager;
    }

    public static void injectPushHandler(App app, IPushHandler iPushHandler) {
        app.pushHandler = iPushHandler;
    }

    public static void injectSettings(App app, ISettings iSettings) {
        app.settings = iSettings;
    }

    public static void injectWorkerFactory(App app, HiltWorkerFactory hiltWorkerFactory) {
        app.workerFactory = hiltWorkerFactory;
    }
}
