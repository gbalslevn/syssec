package dk.molslinjen.domain.managers.splitTest;

import com.sdk.growthbook.GBSDKBuilder;
import com.sdk.growthbook.GrowthBookSDK;
import com.sdk.growthbook.model.GBExperiment;
import com.sdk.growthbook.model.GBExperimentResult;
import com.sdk.growthbook.network.GBNetworkDispatcherOkHttp;
import dk.molslinjen.core.Environment;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.analytics.AnalyticsEvent;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.managers.splitTest.SplitTestManager;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0014\u0010\u0016\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0014\u0010\u0018\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0014\u0010\u001a\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\r¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/domain/managers/splitTest/SplitTestManager;", "Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;", "analyticsTracker", "Ldk/molslinjen/domain/analytics/IAnalyticsTracker;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "<init>", "(Ldk/molslinjen/domain/analytics/IAnalyticsTracker;Ldk/molslinjen/domain/model/settings/ISettings;)V", "growthBook", "Lcom/sdk/growthbook/GrowthBookSDK;", "addOnRampsUseAlternativeText", BuildConfig.FLAVOR, "getAddOnRampsUseAlternativeText", "()Z", "aaTestCase", "getAaTestCase", "enableReturnTicketAttractionView", "getEnableReturnTicketAttractionView", "enableNavigateProgressBar", "getEnableNavigateProgressBar", "moveSummaryAddons", "getMoveSummaryAddons", "moveReturnTripSelector", "getMoveReturnTripSelector", "showRouteSwitchWithText", "getShowRouteSwitchWithText", "movePassengerInfo", "getMovePassengerInfo", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitTestManager implements ISplitTestManager {
    private final IAnalyticsTracker analyticsTracker;
    private final GrowthBookSDK growthBook;

    public SplitTestManager(IAnalyticsTracker analyticsTracker, ISettings settings) {
        Intrinsics.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.analyticsTracker = analyticsTracker;
        Constants.GrowthBook growthBook = Constants.GrowthBook.INSTANCE;
        this.growthBook = new GBSDKBuilder(growthBook.getApiKey(), growthBook.getHostUrl(), new GBNetworkDispatcherOkHttp(null, false, 3, null), MapsKt.mapOf(TuplesKt.to("deviceType", "app"), TuplesKt.to("deviceId", settings.latestValueFor(SettingsProperty.Notifications.DeviceId.INSTANCE)), TuplesKt.to("appOS", "Android"), TuplesKt.to("app", Environment.INSTANCE.isMolslinjen() ? "Molslinjen" : "KombardoExpressen")), growthBook.getEncryptionKey(), new Function2() { // from class: F1.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit growthBook$lambda$0;
                growthBook$lambda$0 = SplitTestManager.growthBook$lambda$0(SplitTestManager.this, (GBExperiment) obj, (GBExperimentResult) obj2);
                return growthBook$lambda$0;
            }
        }, false, false, 192, null).initialize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit growthBook$lambda$0(SplitTestManager splitTestManager, GBExperiment gbExperiment, GBExperimentResult gbExperimentResult) {
        Intrinsics.checkNotNullParameter(gbExperiment, "gbExperiment");
        Intrinsics.checkNotNullParameter(gbExperimentResult, "gbExperimentResult");
        Logger.log$default(Logger.INSTANCE, "Experiment: " + gbExperiment.getKey() + " Variation: " + gbExperimentResult.getVariationId(), null, 0, 6, null);
        splitTestManager.analyticsTracker.trackEvent(new AnalyticsEvent.SplitTestExperimentViewed(gbExperiment.getKey(), gbExperimentResult.getVariationId()));
        return Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.managers.splitTest.ISplitTestManager
    public boolean getAaTestCase() {
        return this.growthBook.isOn("app-aa-test");
    }

    @Override // dk.molslinjen.domain.managers.splitTest.ISplitTestManager
    public boolean getAddOnRampsUseAlternativeText() {
        return this.growthBook.isOn("app-addOn-rampsAlternativeText");
    }

    @Override // dk.molslinjen.domain.managers.splitTest.ISplitTestManager
    public boolean getEnableNavigateProgressBar() {
        return this.growthBook.isOn("app-navigate-progressbar");
    }

    @Override // dk.molslinjen.domain.managers.splitTest.ISplitTestManager
    public boolean getEnableReturnTicketAttractionView() {
        return this.growthBook.isOn("app-return-ticket-attraction");
    }

    @Override // dk.molslinjen.domain.managers.splitTest.ISplitTestManager
    public boolean getMovePassengerInfo() {
        return this.growthBook.isOn("app-move-passenger-info");
    }

    @Override // dk.molslinjen.domain.managers.splitTest.ISplitTestManager
    public boolean getMoveReturnTripSelector() {
        return this.growthBook.isOn("app-move-return-trip-selector");
    }

    @Override // dk.molslinjen.domain.managers.splitTest.ISplitTestManager
    public boolean getMoveSummaryAddons() {
        return this.growthBook.isOn("app-move-summary-addons");
    }

    @Override // dk.molslinjen.domain.managers.splitTest.ISplitTestManager
    public boolean getShowRouteSwitchWithText() {
        return this.growthBook.isOn("app-show-route-switch-with-text");
    }
}
