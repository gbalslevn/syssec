package dk.molslinjen.ui.views.screens.main;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.core.AppUpdater;
import dk.molslinjen.core.Environment;
import dk.molslinjen.core.IAppUpdater;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.core.migration.IMigrator;
import dk.molslinjen.core.migration.Migrator;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarMessageEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import dk.molslinjen.ui.views.global.bottombar.IBottomBarManager;
import dk.molslinjen.ui.views.global.navigation.ScreenTrackingKeyKt;
import dk.molslinjen.ui.views.global.navigation.SimpleScreenConfig;
import dk.molslinjen.ui.views.global.topbar.ITopBarManager;
import dk.molslinjen.ui.views.screens.onboarding.navigator.IOnboardingNavigator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001FBI\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u0014¢\u0006\u0004\b\u001f\u0010\u0016J\u0015\u0010\"\u001a\u00020\u00142\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010(R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010)R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010*R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010+R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010,R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010-\u001a\u0004\b.\u0010/R\u001d\u00102\u001a\b\u0012\u0004\u0012\u000201008\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001d\u00107\u001a\b\u0012\u0004\u0012\u000206008\u0006¢\u0006\f\n\u0004\b7\u00103\u001a\u0004\b8\u00105R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u000209008\u0006¢\u0006\f\n\u0004\b:\u00103\u001a\u0004\b;\u00105R\u0017\u0010<\u001a\u0002098\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020A0@8\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E¨\u0006G"}, d2 = {"Ldk/molslinjen/ui/views/screens/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "Ldk/molslinjen/domain/model/settings/ISettings;", "settings", "Ldk/molslinjen/ui/views/global/bottombar/IBottomBarManager;", "bottomBarManager", "Ldk/molslinjen/ui/views/global/topbar/ITopBarManager;", "topBarManager", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "snackbarService", "Ldk/molslinjen/ui/views/screens/onboarding/navigator/IOnboardingNavigator;", "onboardingNavigator", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "analyticsTracker", "Ldk/molslinjen/core/IAppUpdater;", "appUpdater", "Ldk/molslinjen/core/migration/IMigrator;", "migrator", "<init>", "(Ldk/molslinjen/domain/model/settings/ISettings;Ldk/molslinjen/ui/views/global/bottombar/IBottomBarManager;Ldk/molslinjen/ui/views/global/topbar/ITopBarManager;Ldk/molslinjen/core/snackbar/ISnackbarService;Ldk/molslinjen/ui/views/screens/onboarding/navigator/IOnboardingNavigator;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;Ldk/molslinjen/core/IAppUpdater;Ldk/molslinjen/core/migration/IMigrator;)V", BuildConfig.FLAVOR, "onCleared", "()V", "Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding;", "screenProperty", "setOnboardingStepCompleted", "(Ldk/molslinjen/domain/model/settings/SettingsProperty$Onboarding;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/ramcosta/composedestinations/spec/Direction;", "getNextOnboardingStep", "()Lcom/ramcosta/composedestinations/spec/Direction;", "getInitialScreen", "showExitSnackBar", "Ldk/molslinjen/ui/views/global/navigation/SimpleScreenConfig;", "screenConfig", "onNavigationWithDestinations", "(Ldk/molslinjen/ui/views/global/navigation/SimpleScreenConfig;)V", BuildConfig.FLAVOR, "route", "trackScreen", "(Ljava/lang/String;)V", "Ldk/molslinjen/domain/model/settings/ISettings;", "Ldk/molslinjen/ui/views/global/bottombar/IBottomBarManager;", "Ldk/molslinjen/ui/views/global/topbar/ITopBarManager;", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "Ldk/molslinjen/ui/views/screens/onboarding/navigator/IOnboardingNavigator;", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "getAnalyticsTracker", "()Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/core/migration/Migrator$MigrationState;", "migrationState", "Lkotlinx/coroutines/flow/StateFlow;", "getMigrationState", "()Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/core/AppUpdater$AppUpdateState;", "appUpdateState", "getAppUpdateState", BuildConfig.FLAVOR, "showDeveloperMenu", "getShowDeveloperMenu", "showAppVersionInfo", "Z", "getShowAppVersionInfo", "()Z", "Lkotlinx/coroutines/flow/SharedFlow;", "Ldk/molslinjen/core/snackbar/SnackbarMessageEvent;", "events", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "Companion", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MainViewModel extends ViewModel {
    private static boolean hasBeenInitialized;
    private final IAnalyticsTracker analyticsTracker;
    private final StateFlow<AppUpdater.AppUpdateState> appUpdateState;
    private final IBottomBarManager bottomBarManager;
    private final SharedFlow<SnackbarMessageEvent> events;
    private final StateFlow<Migrator.MigrationState> migrationState;
    private final IOnboardingNavigator onboardingNavigator;
    private final ISettings settings;
    private final boolean showAppVersionInfo;
    private final StateFlow<Boolean> showDeveloperMenu;
    private final ISnackbarService snackbarService;
    private final ITopBarManager topBarManager;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/ui/views/screens/main/MainViewModel$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "value", BuildConfig.FLAVOR, "hasBeenInitialized", "setHasBeenInitialized", "(Z)V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setHasBeenInitialized(boolean z5) {
            if (MainViewModel.hasBeenInitialized && z5) {
                Logger.INSTANCE.logCritical(new CriticalLog("MainViewModel was instantiated multiple times"));
            }
            MainViewModel.hasBeenInitialized = z5;
        }

        private Companion() {
        }
    }

    public MainViewModel(ISettings settings, IBottomBarManager bottomBarManager, ITopBarManager topBarManager, ISnackbarService snackbarService, IOnboardingNavigator onboardingNavigator, IAnalyticsTracker analyticsTracker, IAppUpdater appUpdater, IMigrator migrator) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(bottomBarManager, "bottomBarManager");
        Intrinsics.checkNotNullParameter(topBarManager, "topBarManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        Intrinsics.checkNotNullParameter(onboardingNavigator, "onboardingNavigator");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(appUpdater, "appUpdater");
        Intrinsics.checkNotNullParameter(migrator, "migrator");
        this.settings = settings;
        this.bottomBarManager = bottomBarManager;
        this.topBarManager = topBarManager;
        this.snackbarService = snackbarService;
        this.onboardingNavigator = onboardingNavigator;
        this.analyticsTracker = analyticsTracker;
        this.migrationState = migrator.getMigrationState();
        this.appUpdateState = appUpdater.getAppUpdateState();
        this.showDeveloperMenu = settings.get(ViewModelKt.getViewModelScope(this), SettingsProperty.Dev.ShowDeveloperMenu.INSTANCE);
        this.showAppVersionInfo = !Environment.Prod.isCurrent();
        this.events = snackbarService.getEvents();
        INSTANCE.setHasBeenInitialized(true);
    }

    public final StateFlow<AppUpdater.AppUpdateState> getAppUpdateState() {
        return this.appUpdateState;
    }

    public final SharedFlow<SnackbarMessageEvent> getEvents() {
        return this.events;
    }

    public final Direction getInitialScreen() {
        return getNextOnboardingStep();
    }

    public final StateFlow<Migrator.MigrationState> getMigrationState() {
        return this.migrationState;
    }

    public final Direction getNextOnboardingStep() {
        return this.onboardingNavigator.nextStep();
    }

    public final boolean getShowAppVersionInfo() {
        return this.showAppVersionInfo;
    }

    public final StateFlow<Boolean> getShowDeveloperMenu() {
        return this.showDeveloperMenu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        INSTANCE.setHasBeenInitialized(false);
        super.onCleared();
    }

    public final void onNavigationWithDestinations(SimpleScreenConfig screenConfig) {
        Intrinsics.checkNotNullParameter(screenConfig, "screenConfig");
        this.topBarManager.apply(screenConfig.getTopBarConfiguration());
        this.bottomBarManager.apply(screenConfig.getBottomBarConfiguration());
    }

    public final Object setOnboardingStepCompleted(SettingsProperty.Onboarding onboarding, Continuation<? super Unit> continuation) {
        Object update = this.settings.update(onboarding, Boxing.boxBoolean(true), continuation);
        return update == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? update : Unit.INSTANCE;
    }

    public final void showExitSnackBar() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new MainViewModel$showExitSnackBar$1(this, null), 3, null);
    }

    public final void trackScreen(String route) {
        String trackingKey;
        IAnalyticsTracker iAnalyticsTracker = this.analyticsTracker;
        if (route == null || (trackingKey = ScreenTrackingKeyKt.trackingKey(route)) == null) {
            return;
        }
        iAnalyticsTracker.trackScreen(trackingKey);
    }
}
