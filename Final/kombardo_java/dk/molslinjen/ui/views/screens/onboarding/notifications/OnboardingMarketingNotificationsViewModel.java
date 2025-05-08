package dk.molslinjen.ui.views.screens.onboarding.notifications;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.notification.IMarketingNotificationManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.providers.IPushHandlerProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/ui/views/screens/onboarding/notifications/OnboardingMarketingNotificationsViewModel;", "Landroidx/lifecycle/ViewModel;", "pushHandlerProvider", "Ldk/molslinjen/domain/providers/IPushHandlerProvider;", "marketingNotificationManager", "Ldk/molslinjen/domain/managers/notification/IMarketingNotificationManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "<init>", "(Ldk/molslinjen/domain/providers/IPushHandlerProvider;Ldk/molslinjen/domain/managers/notification/IMarketingNotificationManager;Ldk/molslinjen/domain/analytics/IAnalyticsTracker;Ldk/molslinjen/domain/managers/user/IUserManager;)V", "setMarketingPushEnabled", BuildConfig.FLAVOR, "enablePush", BuildConfig.FLAVOR, "onContinue", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "(ZLkotlin/jvm/functions/Function1;)V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OnboardingMarketingNotificationsViewModel extends ViewModel {
    private final IAnalyticsTracker analyticsTracker;
    private final IMarketingNotificationManager marketingNotificationManager;
    private final IPushHandlerProvider pushHandlerProvider;
    private final IUserManager userManager;

    public OnboardingMarketingNotificationsViewModel(IPushHandlerProvider pushHandlerProvider, IMarketingNotificationManager marketingNotificationManager, IAnalyticsTracker analyticsTracker, IUserManager userManager) {
        Intrinsics.checkNotNullParameter(pushHandlerProvider, "pushHandlerProvider");
        Intrinsics.checkNotNullParameter(marketingNotificationManager, "marketingNotificationManager");
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        this.pushHandlerProvider = pushHandlerProvider;
        this.marketingNotificationManager = marketingNotificationManager;
        this.analyticsTracker = analyticsTracker;
        this.userManager = userManager;
    }

    public final void setMarketingPushEnabled(boolean enablePush, Function1<? super Continuation<? super Unit>, ? extends Object> onContinue) {
        Intrinsics.checkNotNullParameter(onContinue, "onContinue");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OnboardingMarketingNotificationsViewModel$setMarketingPushEnabled$1(enablePush, this, null), 3, null);
        this.analyticsTracker.updateStateTracking(this.userManager, this.pushHandlerProvider);
        this.analyticsTracker.trackEvent(new AnalyticsEvent.ChangeMarketingPushEvent(enablePush, "intro"));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new OnboardingMarketingNotificationsViewModel$setMarketingPushEnabled$2(onContinue, null), 3, null);
    }
}
