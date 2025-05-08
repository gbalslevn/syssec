package dk.molslinjen.ui.views.screens.onboarding.location;

import androidx.lifecycle.ViewModel;
import dk.molslinjen.core.location.ILocationManager;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.user.IUserManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/ui/views/screens/onboarding/location/OnboardingLocationViewModel;", "Landroidx/lifecycle/ViewModel;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "locationManager", "Ldk/molslinjen/core/location/ILocationManager;", "<init>", "(Ldk/molslinjen/domain/analytics/IAnalyticsTracker;Ldk/molslinjen/domain/managers/user/IUserManager;Ldk/molslinjen/core/location/ILocationManager;)V", "onLocationChanged", BuildConfig.FLAVOR, "enabled", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OnboardingLocationViewModel extends ViewModel {
    private final IAnalyticsTracker analyticsTracker;
    private final ILocationManager locationManager;
    private final IUserManager userManager;

    public OnboardingLocationViewModel(IAnalyticsTracker analyticsTracker, IUserManager userManager, ILocationManager locationManager) {
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        Intrinsics.checkNotNullParameter(locationManager, "locationManager");
        this.analyticsTracker = analyticsTracker;
        this.userManager = userManager;
        this.locationManager = locationManager;
    }

    public final void onLocationChanged(boolean enabled) {
        this.analyticsTracker.updateStateTracking(this.userManager, null);
        this.analyticsTracker.trackEvent(new AnalyticsEvent.ChangeLocationPermissionEvent(enabled, true, false, false, 12, null));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new OnboardingLocationViewModel$onLocationChanged$1(this, null), 3, null);
    }
}
