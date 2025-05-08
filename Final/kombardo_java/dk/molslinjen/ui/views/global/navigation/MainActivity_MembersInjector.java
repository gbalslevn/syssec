package dk.molslinjen.ui.views.global.navigation;

import dk.molslinjen.core.IAppUpdater;
import dk.molslinjen.core.providers.IPaymentCallbackUrlProvider;
import dk.molslinjen.core.push.IPushHandler;
import dk.molslinjen.domain.analytics.IAdjustTracker;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.managers.checkout.IPaymentManager;
import dk.molslinjen.domain.managers.company.ICompanyViewHelper;
import dk.molslinjen.domain.managers.infoAlerts.IInfoAlertManager;
import dk.molslinjen.domain.managers.notification.IMarketingNotificationManager;
import dk.molslinjen.domain.managers.notification.INotificationManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.providers.IPushHandlerProvider;

/* loaded from: classes2.dex */
public abstract class MainActivity_MembersInjector {
    public static void injectAdjustTracker(MainActivity mainActivity, IAdjustTracker iAdjustTracker) {
        mainActivity.adjustTracker = iAdjustTracker;
    }

    public static void injectAnalyticsTracker(MainActivity mainActivity, IAnalyticsTracker iAnalyticsTracker) {
        mainActivity.analyticsTracker = iAnalyticsTracker;
    }

    public static void injectAppUpdater(MainActivity mainActivity, IAppUpdater iAppUpdater) {
        mainActivity.appUpdater = iAppUpdater;
    }

    public static void injectCompanyViewHelper(MainActivity mainActivity, ICompanyViewHelper iCompanyViewHelper) {
        mainActivity.companyViewHelper = iCompanyViewHelper;
    }

    public static void injectInfoAlertsManager(MainActivity mainActivity, IInfoAlertManager iInfoAlertManager) {
        mainActivity.infoAlertsManager = iInfoAlertManager;
    }

    public static void injectMarketingNotificationManager(MainActivity mainActivity, IMarketingNotificationManager iMarketingNotificationManager) {
        mainActivity.marketingNotificationManager = iMarketingNotificationManager;
    }

    public static void injectMultiRideManager(MainActivity mainActivity, IMultiRideManager iMultiRideManager) {
        mainActivity.multiRideManager = iMultiRideManager;
    }

    public static void injectNotificationManager(MainActivity mainActivity, INotificationManager iNotificationManager) {
        mainActivity.notificationManager = iNotificationManager;
    }

    public static void injectPaymentCallbackUrlProvider(MainActivity mainActivity, IPaymentCallbackUrlProvider iPaymentCallbackUrlProvider) {
        mainActivity.paymentCallbackUrlProvider = iPaymentCallbackUrlProvider;
    }

    public static void injectPaymentManager(MainActivity mainActivity, IPaymentManager iPaymentManager) {
        mainActivity.paymentManager = iPaymentManager;
    }

    public static void injectPushHandler(MainActivity mainActivity, IPushHandler iPushHandler) {
        mainActivity.pushHandler = iPushHandler;
    }

    public static void injectPushHandlerProvider(MainActivity mainActivity, IPushHandlerProvider iPushHandlerProvider) {
        mainActivity.pushHandlerProvider = iPushHandlerProvider;
    }

    public static void injectSettings(MainActivity mainActivity, ISettings iSettings) {
        mainActivity.settings = iSettings;
    }

    public static void injectTicketsManager(MainActivity mainActivity, ITicketsManager iTicketsManager) {
        mainActivity.ticketsManager = iTicketsManager;
    }

    public static void injectUserManager(MainActivity mainActivity, IUserManager iUserManager) {
        mainActivity.userManager = iUserManager;
    }
}
