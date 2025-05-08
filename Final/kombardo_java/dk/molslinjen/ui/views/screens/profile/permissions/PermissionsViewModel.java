package dk.molslinjen.ui.views.screens.profile.permissions;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.push.IPushHandler;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.notification.IMarketingNotificationManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import dk.molslinjen.domain.providers.IPushHandlerProvider;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001aJ\u0006\u0010!\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/permissions/PermissionsViewModel;", "Landroidx/lifecycle/ViewModel;", "pushHandler", "Ldk/molslinjen/core/push/IPushHandler;", "pushHandlerProvider", "Ldk/molslinjen/domain/providers/IPushHandlerProvider;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "marketingNotificationManager", "Ldk/molslinjen/domain/managers/notification/IMarketingNotificationManager;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "<init>", "(Ldk/molslinjen/core/push/IPushHandler;Ldk/molslinjen/domain/providers/IPushHandlerProvider;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/domain/managers/notification/IMarketingNotificationManager;Ldk/molslinjen/domain/model/settings/ISettings;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/permissions/PermissionsViewModel$ViewState;", "viewState", "getViewState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "reloadPermissionState", BuildConfig.FLAVOR, "togglePushNotificationPermission", "enabled", BuildConfig.FLAVOR, "toggleMarketingPushNotificationPermission", "onLocationPermissionToggled", "showSettingsDialog", "dialogType", "Ldk/molslinjen/ui/views/screens/profile/permissions/AppPermission;", "isEnabled", "dismissSettingsDialog", "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PermissionsViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IAnalyticsTracker analyticsTracker;
    private final IMarketingNotificationManager marketingNotificationManager;
    private final IPushHandler pushHandler;
    private final IPushHandlerProvider pushHandlerProvider;
    private final ISettings settings;
    private final IUserManager userManager;
    private final MutableStateFlow<ViewState> viewState;

    public PermissionsViewModel(IPushHandler pushHandler, IPushHandlerProvider pushHandlerProvider, IAnalyticsTracker analyticsTracker, IUserManager userManager, IMarketingNotificationManager marketingNotificationManager, ISettings settings) {
        Intrinsics.checkNotNullParameter(pushHandler, "pushHandler");
        Intrinsics.checkNotNullParameter(pushHandlerProvider, "pushHandlerProvider");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(marketingNotificationManager, "marketingNotificationManager");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.pushHandler = pushHandler;
        this.pushHandlerProvider = pushHandlerProvider;
        this.analyticsTracker = analyticsTracker;
        this.userManager = userManager;
        this.marketingNotificationManager = marketingNotificationManager;
        this.settings = settings;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, false, null, 7, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        reloadPermissionState();
    }

    public final void dismissSettingsDialog() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, false, null, 3, null)));
    }

    public final MutableStateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void onLocationPermissionToggled(boolean enabled) {
        this.analyticsTracker.updateStateTracking(this.userManager, this.pushHandlerProvider);
        this.analyticsTracker.trackEvent(new AnalyticsEvent.ChangeLocationPermissionEvent(enabled, false, true, false, 10, null));
    }

    public final void reloadPermissionState() {
        ViewState value;
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, this.pushHandler.isPushEnabled(), ((Boolean) this.settings.latestValueFor(SettingsProperty.Notifications.MarketingNotificationsEnabled.INSTANCE)).booleanValue(), null, 4, null)));
    }

    public final void showSettingsDialog(AppPermission dialogType, boolean isEnabled) {
        ViewState value;
        Intrinsics.checkNotNullParameter(dialogType, "dialogType");
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, false, new Pair(dialogType, Boolean.valueOf(isEnabled)), 3, null)));
    }

    public final void toggleMarketingPushNotificationPermission(boolean enabled) {
        ViewState value;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PermissionsViewModel$toggleMarketingPushNotificationPermission$1(enabled, this, null), 3, null);
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, enabled, null, 5, null)));
        this.analyticsTracker.updateStateTracking(this.userManager, this.pushHandlerProvider);
        this.analyticsTracker.trackEvent(new AnalyticsEvent.ChangeMarketingPushEvent(enabled, "profile"));
    }

    public final void togglePushNotificationPermission(boolean enabled) {
        ViewState value;
        this.pushHandler.setPushEnabled(enabled);
        MutableStateFlow<ViewState> mutableStateFlow = this._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ViewState.copy$default(value, enabled, false, null, 6, null)));
        this.analyticsTracker.updateStateTracking(this.userManager, this.pushHandlerProvider);
        this.analyticsTracker.trackEvent(new AnalyticsEvent.ChangePushEvent(enabled, "profile"));
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ<\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0003\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0004\u0010\u0016R%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/permissions/PermissionsViewModel$ViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isPushNotificationEnabled", "isMarketingPushNotificationEnabled", "Lkotlin/Pair;", "Ldk/molslinjen/ui/views/screens/profile/permissions/AppPermission;", "settingsDialogAppPermission", "<init>", "(ZZLkotlin/Pair;)V", "copy", "(ZZLkotlin/Pair;)Ldk/molslinjen/ui/views/screens/profile/permissions/PermissionsViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Lkotlin/Pair;", "getSettingsDialogAppPermission", "()Lkotlin/Pair;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState {
        private final boolean isMarketingPushNotificationEnabled;
        private final boolean isPushNotificationEnabled;
        private final Pair<AppPermission, Boolean> settingsDialogAppPermission;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(boolean z5, boolean z6, Pair<? extends AppPermission, Boolean> pair) {
            this.isPushNotificationEnabled = z5;
            this.isMarketingPushNotificationEnabled = z6;
            this.settingsDialogAppPermission = pair;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, boolean z6, Pair pair, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = viewState.isPushNotificationEnabled;
            }
            if ((i5 & 2) != 0) {
                z6 = viewState.isMarketingPushNotificationEnabled;
            }
            if ((i5 & 4) != 0) {
                pair = viewState.settingsDialogAppPermission;
            }
            return viewState.copy(z5, z6, pair);
        }

        public final ViewState copy(boolean isPushNotificationEnabled, boolean isMarketingPushNotificationEnabled, Pair<? extends AppPermission, Boolean> settingsDialogAppPermission) {
            return new ViewState(isPushNotificationEnabled, isMarketingPushNotificationEnabled, settingsDialogAppPermission);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isPushNotificationEnabled == viewState.isPushNotificationEnabled && this.isMarketingPushNotificationEnabled == viewState.isMarketingPushNotificationEnabled && Intrinsics.areEqual(this.settingsDialogAppPermission, viewState.settingsDialogAppPermission);
        }

        public final Pair<AppPermission, Boolean> getSettingsDialogAppPermission() {
            return this.settingsDialogAppPermission;
        }

        public int hashCode() {
            int hashCode = ((Boolean.hashCode(this.isPushNotificationEnabled) * 31) + Boolean.hashCode(this.isMarketingPushNotificationEnabled)) * 31;
            Pair<AppPermission, Boolean> pair = this.settingsDialogAppPermission;
            return hashCode + (pair == null ? 0 : pair.hashCode());
        }

        /* renamed from: isMarketingPushNotificationEnabled, reason: from getter */
        public final boolean getIsMarketingPushNotificationEnabled() {
            return this.isMarketingPushNotificationEnabled;
        }

        /* renamed from: isPushNotificationEnabled, reason: from getter */
        public final boolean getIsPushNotificationEnabled() {
            return this.isPushNotificationEnabled;
        }

        public String toString() {
            return "ViewState(isPushNotificationEnabled=" + this.isPushNotificationEnabled + ", isMarketingPushNotificationEnabled=" + this.isMarketingPushNotificationEnabled + ", settingsDialogAppPermission=" + this.settingsDialogAppPermission + ")";
        }

        public /* synthetic */ ViewState(boolean z5, boolean z6, Pair pair, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? false : z5, (i5 & 2) != 0 ? false : z6, (i5 & 4) != 0 ? null : pair);
        }
    }
}
