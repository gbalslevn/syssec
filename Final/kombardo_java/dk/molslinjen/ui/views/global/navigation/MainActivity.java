package dk.molslinjen.ui.views.global.navigation;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.view.compose.ComponentActivityKt;
import dk.molslinjen.App;
import dk.molslinjen.core.IAppUpdater;
import dk.molslinjen.core.log.Logger;
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
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.providers.IPushHandlerProvider;
import dk.molslinjen.extensions.AnyExtensionsKt;
import dk.molslinjen.workers.UpdateWorker;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \u008f\u00012\u00020\u0001:\u0002\u008f\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0013\u0010\u0003J)\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001a\u0010\fJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001b\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0002058\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010K\u001a\u00020J8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010R\u001a\u00020Q8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010Y\u001a\u00020X8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010`\u001a\u00020_8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010g\u001a\u00020f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010n\u001a\u00020m8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\"\u0010u\u001a\u00020t8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010|\u001a\u00020{8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R*\u0010\u0083\u0001\u001a\u00030\u0082\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R!\u0010\u008b\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u008a\u00010\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0017\u0010\u008d\u0001\u001a\u00020\u00148\u0002X\u0082D¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001¨\u0006\u0090\u0001"}, d2 = {"Ldk/molslinjen/ui/views/global/navigation/MainActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "Landroidx/navigation/NavHostController;", "navHostController", BuildConfig.FLAVOR, "ensureNavigationState", "(Landroidx/navigation/NavHostController;)V", "Landroid/content/Intent;", "intent", "trackPotentialPushNotificationOpened", "(Landroid/content/Intent;)V", "handleDeepLink", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "onResume", BuildConfig.FLAVOR, "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onNewIntent", "onDestroy", "Landroidx/navigation/NavHostController;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "Ldk/molslinjen/core/IAppUpdater;", "appUpdater", "Ldk/molslinjen/core/IAppUpdater;", "getAppUpdater", "()Ldk/molslinjen/core/IAppUpdater;", "setAppUpdater", "(Ldk/molslinjen/core/IAppUpdater;)V", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "paymentManager", "Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "getPaymentManager", "()Ldk/molslinjen/domain/managers/checkout/IPaymentManager;", "setPaymentManager", "(Ldk/molslinjen/domain/managers/checkout/IPaymentManager;)V", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "ticketsManager", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "getTicketsManager", "()Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "setTicketsManager", "(Ldk/molslinjen/domain/managers/ticket/ITicketsManager;)V", "Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;", "multiRideManager", "Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;", "getMultiRideManager", "()Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;", "setMultiRideManager", "(Ldk/molslinjen/domain/managers/agreement/multiride/IMultiRideManager;)V", "Ldk/molslinjen/domain/managers/user/IUserManager;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "getUserManager", "()Ldk/molslinjen/domain/managers/user/IUserManager;", "setUserManager", "(Ldk/molslinjen/domain/managers/user/IUserManager;)V", "Ldk/molslinjen/core/push/IPushHandler;", "pushHandler", "Ldk/molslinjen/core/push/IPushHandler;", "getPushHandler", "()Ldk/molslinjen/core/push/IPushHandler;", "setPushHandler", "(Ldk/molslinjen/core/push/IPushHandler;)V", "Ldk/molslinjen/domain/managers/notification/INotificationManager;", "notificationManager", "Ldk/molslinjen/domain/managers/notification/INotificationManager;", "getNotificationManager", "()Ldk/molslinjen/domain/managers/notification/INotificationManager;", "setNotificationManager", "(Ldk/molslinjen/domain/managers/notification/INotificationManager;)V", "Ldk/molslinjen/domain/providers/IPushHandlerProvider;", "pushHandlerProvider", "Ldk/molslinjen/domain/providers/IPushHandlerProvider;", "getPushHandlerProvider", "()Ldk/molslinjen/domain/providers/IPushHandlerProvider;", "setPushHandlerProvider", "(Ldk/molslinjen/domain/providers/IPushHandlerProvider;)V", "Ldk/molslinjen/domain/managers/company/ICompanyViewHelper;", "companyViewHelper", "Ldk/molslinjen/domain/managers/company/ICompanyViewHelper;", "getCompanyViewHelper", "()Ldk/molslinjen/domain/managers/company/ICompanyViewHelper;", "setCompanyViewHelper", "(Ldk/molslinjen/domain/managers/company/ICompanyViewHelper;)V", "Ldk/molslinjen/domain/managers/infoAlerts/IInfoAlertManager;", "infoAlertsManager", "Ldk/molslinjen/domain/managers/infoAlerts/IInfoAlertManager;", "getInfoAlertsManager", "()Ldk/molslinjen/domain/managers/infoAlerts/IInfoAlertManager;", "setInfoAlertsManager", "(Ldk/molslinjen/domain/managers/infoAlerts/IInfoAlertManager;)V", "Ldk/molslinjen/domain/analytics/IAdjustTracker;", "adjustTracker", "Ldk/molslinjen/domain/analytics/IAdjustTracker;", "getAdjustTracker", "()Ldk/molslinjen/domain/analytics/IAdjustTracker;", "setAdjustTracker", "(Ldk/molslinjen/domain/analytics/IAdjustTracker;)V", "Ldk/molslinjen/domain/model/settings/ISettings;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "getSettings", "()Ldk/molslinjen/domain/model/settings/ISettings;", "setSettings", "(Ldk/molslinjen/domain/model/settings/ISettings;)V", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "getAnalyticsTracker", "()Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "setAnalyticsTracker", "(Ldk/molslinjen/domain/analytics/IAnalyticsTracker;)V", "Ldk/molslinjen/core/providers/IPaymentCallbackUrlProvider;", "paymentCallbackUrlProvider", "Ldk/molslinjen/core/providers/IPaymentCallbackUrlProvider;", "getPaymentCallbackUrlProvider", "()Ldk/molslinjen/core/providers/IPaymentCallbackUrlProvider;", "setPaymentCallbackUrlProvider", "(Ldk/molslinjen/core/providers/IPaymentCallbackUrlProvider;)V", "Ldk/molslinjen/domain/managers/notification/IMarketingNotificationManager;", "marketingNotificationManager", "Ldk/molslinjen/domain/managers/notification/IMarketingNotificationManager;", "getMarketingNotificationManager", "()Ldk/molslinjen/domain/managers/notification/IMarketingNotificationManager;", "setMarketingNotificationManager", "(Ldk/molslinjen/domain/managers/notification/IMarketingNotificationManager;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", BuildConfig.FLAVOR, "pushDeepLinkEventRoute", "Lkotlinx/coroutines/flow/MutableStateFlow;", "pushReportIdDefaultValue", "I", "Companion", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MainActivity extends Hilt_MainActivity {
    private static MainActivity shared;
    public IAdjustTracker adjustTracker;
    public IAnalyticsTracker analyticsTracker;
    public IAppUpdater appUpdater;
    public ICompanyViewHelper companyViewHelper;
    public IInfoAlertManager infoAlertsManager;
    public IMarketingNotificationManager marketingNotificationManager;
    public IMultiRideManager multiRideManager;
    private NavHostController navHostController;
    public INotificationManager notificationManager;
    public IPaymentCallbackUrlProvider paymentCallbackUrlProvider;
    public IPaymentManager paymentManager;
    public IPushHandler pushHandler;
    public IPushHandlerProvider pushHandlerProvider;
    public ISettings settings;
    public ITicketsManager ticketsManager;
    public IUserManager userManager;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
    private final MutableStateFlow<String> pushDeepLinkEventRoute = StateFlowKt.MutableStateFlow(null);
    private final int pushReportIdDefaultValue = -1000;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/ui/views/global/navigation/MainActivity$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Ldk/molslinjen/ui/views/global/navigation/MainActivity;", "shared", "Ldk/molslinjen/ui/views/global/navigation/MainActivity;", "getShared", "()Ldk/molslinjen/ui/views/global/navigation/MainActivity;", "setShared", "(Ldk/molslinjen/ui/views/global/navigation/MainActivity;)V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MainActivity getShared() {
            return MainActivity.shared;
        }

        private Companion() {
        }
    }

    public MainActivity() {
        shared = this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureNavigationState(NavHostController navHostController) {
        Application application = getApplication();
        App app = application instanceof App ? (App) application : null;
        if (app != null && !app.getMainActivityCreated()) {
            navHostController.restoreState(new Bundle());
        }
        if (app != null) {
            app.setMainActivityCreated(true);
        }
    }

    private final void handleDeepLink(Intent intent) {
        NavHostController navHostController;
        String uri;
        Uri data = intent.getData();
        if (data != null && (uri = data.toString()) != null && StringsKt.startsWith$default(uri, getPaymentCallbackUrlProvider().getPaymentCallbackUrl(), false, 2, (Object) null)) {
            getPaymentManager().setPaymentCallbackReceived();
            getIntent().setData(null);
            return;
        }
        if (this.navHostController == null) {
            MutableStateFlow<String> mutableStateFlow = this.pushDeepLinkEventRoute;
            do {
            } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), intent.getStringExtra(Constants.IntentExtra.NavigateToKnownRoute)));
            return;
        }
        String stringExtra = intent.getStringExtra(Constants.IntentExtra.NavigateToKnownRoute);
        if (stringExtra != null) {
            NavHostController navHostController2 = this.navHostController;
            if (navHostController2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navHostController");
                navHostController = null;
            } else {
                navHostController = navHostController2;
            }
            NavController.navigate$default((NavController) navHostController, stringExtra, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
            getIntent().removeExtra(Constants.IntentExtra.NavigateToKnownRoute);
            return;
        }
        if (data != null) {
            NavHostController navHostController3 = this.navHostController;
            if (navHostController3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navHostController");
                navHostController3 = null;
            }
            if (navHostController3.getGraph().hasDeepLink(data)) {
                NavHostController navHostController4 = this.navHostController;
                if (navHostController4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navHostController");
                    navHostController4 = null;
                }
                navHostController4.navigate(data);
                getIntent().setData(null);
            }
        }
    }

    private final void trackPotentialPushNotificationOpened(Intent intent) {
        Integer intOrNull;
        Logger.log$default(Logger.INSTANCE, "trackPotentialPushNotificationOpened: " + (intent != null ? intent.getExtras() : null), "Push", 0, 4, null);
        String stringExtra = intent.getStringExtra(Constants.IntentExtra.AgillicReportId);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new MainActivity$trackPotentialPushNotificationOpened$1(intent, this, (stringExtra == null || (intOrNull = StringsKt.toIntOrNull(stringExtra)) == null) ? intent.getIntExtra(Constants.IntentExtra.ReportId, this.pushReportIdDefaultValue) : intOrNull.intValue(), null), 3, null);
    }

    public final IAdjustTracker getAdjustTracker() {
        IAdjustTracker iAdjustTracker = this.adjustTracker;
        if (iAdjustTracker != null) {
            return iAdjustTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adjustTracker");
        return null;
    }

    public final IAnalyticsTracker getAnalyticsTracker() {
        IAnalyticsTracker iAnalyticsTracker = this.analyticsTracker;
        if (iAnalyticsTracker != null) {
            return iAnalyticsTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analyticsTracker");
        return null;
    }

    public final IAppUpdater getAppUpdater() {
        IAppUpdater iAppUpdater = this.appUpdater;
        if (iAppUpdater != null) {
            return iAppUpdater;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appUpdater");
        return null;
    }

    public final ICompanyViewHelper getCompanyViewHelper() {
        ICompanyViewHelper iCompanyViewHelper = this.companyViewHelper;
        if (iCompanyViewHelper != null) {
            return iCompanyViewHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("companyViewHelper");
        return null;
    }

    public final IInfoAlertManager getInfoAlertsManager() {
        IInfoAlertManager iInfoAlertManager = this.infoAlertsManager;
        if (iInfoAlertManager != null) {
            return iInfoAlertManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("infoAlertsManager");
        return null;
    }

    public final IMarketingNotificationManager getMarketingNotificationManager() {
        IMarketingNotificationManager iMarketingNotificationManager = this.marketingNotificationManager;
        if (iMarketingNotificationManager != null) {
            return iMarketingNotificationManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("marketingNotificationManager");
        return null;
    }

    public final IMultiRideManager getMultiRideManager() {
        IMultiRideManager iMultiRideManager = this.multiRideManager;
        if (iMultiRideManager != null) {
            return iMultiRideManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("multiRideManager");
        return null;
    }

    public final INotificationManager getNotificationManager() {
        INotificationManager iNotificationManager = this.notificationManager;
        if (iNotificationManager != null) {
            return iNotificationManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
        return null;
    }

    public final IPaymentCallbackUrlProvider getPaymentCallbackUrlProvider() {
        IPaymentCallbackUrlProvider iPaymentCallbackUrlProvider = this.paymentCallbackUrlProvider;
        if (iPaymentCallbackUrlProvider != null) {
            return iPaymentCallbackUrlProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paymentCallbackUrlProvider");
        return null;
    }

    public final IPaymentManager getPaymentManager() {
        IPaymentManager iPaymentManager = this.paymentManager;
        if (iPaymentManager != null) {
            return iPaymentManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paymentManager");
        return null;
    }

    public final IPushHandler getPushHandler() {
        IPushHandler iPushHandler = this.pushHandler;
        if (iPushHandler != null) {
            return iPushHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pushHandler");
        return null;
    }

    public final IPushHandlerProvider getPushHandlerProvider() {
        IPushHandlerProvider iPushHandlerProvider = this.pushHandlerProvider;
        if (iPushHandlerProvider != null) {
            return iPushHandlerProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pushHandlerProvider");
        return null;
    }

    public final ISettings getSettings() {
        ISettings iSettings = this.settings;
        if (iSettings != null) {
            return iSettings;
        }
        Intrinsics.throwUninitializedPropertyAccessException("settings");
        return null;
    }

    public final ITicketsManager getTicketsManager() {
        ITicketsManager iTicketsManager = this.ticketsManager;
        if (iTicketsManager != null) {
            return iTicketsManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ticketsManager");
        return null;
    }

    public final IUserManager getUserManager() {
        IUserManager iUserManager = this.userManager;
        if (iUserManager != null) {
            return iUserManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userManager");
        return null;
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    @Deprecated
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new MainActivity$onActivityResult$1(this, requestCode, resultCode, null), 2, null);
    }

    @Override // dk.molslinjen.ui.views.global.navigation.Hilt_MainActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashScreen.INSTANCE.installSplashScreen(this);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        trackPotentialPushNotificationOpened(intent);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-998842175, true, new MainActivity$onCreate$1(this)), 1, null);
    }

    @Override // dk.molslinjen.ui.views.global.navigation.Hilt_MainActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (Intrinsics.areEqual(shared, this)) {
            shared = null;
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        Logger.log$default(Logger.INSTANCE, "onNewIntent: " + intent + " with activity: " + AnyExtensionsKt.getTypeName(this), null, 0, 6, null);
        trackPotentialPushNotificationOpened(intent);
        handleDeepLink(intent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new MainActivity$onResume$1(this, null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MainActivity$onResume$2(this, null), 3, null);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        UpdateWorker.INSTANCE.startAllUpdaters(this);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new MainActivity$onStart$1(this, null), 3, null);
    }
}
