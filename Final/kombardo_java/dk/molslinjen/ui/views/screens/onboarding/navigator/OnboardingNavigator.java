package dk.molslinjen.ui.views.screens.onboarding.navigator;

import com.ramcosta.composedestinations.generated.destinations.DeparturesScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.OnboardingLocationScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.OnboardingLoginScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.OnboardingMarketingNotificationsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.OnboardingNotificationsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.OnboardingSelectRouteScreenDestination;
import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.core.Feature;
import dk.molslinjen.core.push.IPushHandler;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ldk/molslinjen/ui/views/screens/onboarding/navigator/OnboardingNavigator;", "Ldk/molslinjen/ui/views/screens/onboarding/navigator/IOnboardingNavigator;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "pushHandler", "Ldk/molslinjen/core/push/IPushHandler;", "<init>", "(Ldk/molslinjen/domain/model/settings/ISettings;Ldk/molslinjen/core/push/IPushHandler;)V", "nextStep", "Lcom/ramcosta/composedestinations/spec/Direction;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OnboardingNavigator implements IOnboardingNavigator {
    private final IPushHandler pushHandler;
    private final ISettings settings;

    public OnboardingNavigator(ISettings settings, IPushHandler pushHandler) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(pushHandler, "pushHandler");
        this.settings = settings;
        this.pushHandler = pushHandler;
    }

    @Override // dk.molslinjen.ui.views.screens.onboarding.navigator.IOnboardingNavigator
    public Direction nextStep() {
        return !((Boolean) this.settings.latestValueFor(SettingsProperty.Onboarding.SelectRouteCompleted.INSTANCE)).booleanValue() ? OnboardingSelectRouteScreenDestination.INSTANCE : !((Boolean) this.settings.latestValueFor(SettingsProperty.Onboarding.OnboardingNotificationsCompleted.INSTANCE)).booleanValue() ? OnboardingNotificationsScreenDestination.INSTANCE : !((Boolean) this.settings.latestValueFor(SettingsProperty.Onboarding.OnboardingLocationCompleted.INSTANCE)).booleanValue() ? OnboardingLocationScreenDestination.INSTANCE : (((Boolean) this.settings.latestValueFor(SettingsProperty.Onboarding.OnboardingMarketingNotificationsCompleted.INSTANCE)).booleanValue() || !this.pushHandler.isPushEnabled()) ? (!Feature.Account.isEnabled() || ((Boolean) this.settings.latestValueFor(SettingsProperty.Onboarding.OnboardingLoginCompleted.INSTANCE)).booleanValue()) ? DeparturesScreenDestination.invoke$default(DeparturesScreenDestination.INSTANCE, false, 1, null) : OnboardingLoginScreenDestination.INSTANCE : OnboardingMarketingNotificationsScreenDestination.INSTANCE;
    }
}
