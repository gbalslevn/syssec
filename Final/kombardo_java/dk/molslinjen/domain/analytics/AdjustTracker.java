package dk.molslinjen.domain.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.LogLevel;
import dk.molslinjen.core.Environment;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0014B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000bH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/domain/analytics/AdjustTracker;", "Ldk/molslinjen/domain/analytics/IAdjustTracker;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "<init>", "(Ldk/molslinjen/domain/model/settings/ISettings;)V", "setup", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "registerLifecycleCallbacks", "Lkotlin/Function1;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "firstOpen", "purchase", "revenue", BuildConfig.FLAVOR, "currency", BuildConfig.FLAVOR, "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AdjustLifecycleCallbacks", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AdjustTracker implements IAdjustTracker {
    private final ISettings settings;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/domain/analytics/AdjustTracker$AdjustLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "onActivityCreated", BuildConfig.FLAVOR, "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivitySaveInstanceState", "outState", "onActivityDestroyed", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    private static final class AdjustLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Adjust.onPause();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Adjust.onResume();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    public AdjustTracker(ISettings settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.settings = settings;
    }

    @Override // dk.molslinjen.domain.analytics.IAdjustTracker
    public void firstOpen() {
        Adjust.trackEvent(new AdjustEvent(Environment.INSTANCE.isMolslinjen() ? "q6kdcr" : "irnlpp"));
    }

    @Override // dk.molslinjen.domain.analytics.IAdjustTracker
    public Object purchase(int i5, String str, Continuation<? super Unit> continuation) {
        Environment.Companion companion = Environment.INSTANCE;
        AdjustEvent adjustEvent = new AdjustEvent(companion.isMolslinjen() ? "stugpg" : "o30h5f");
        adjustEvent.setRevenue(i5, str);
        Adjust.trackEvent(adjustEvent);
        ISettings iSettings = this.settings;
        SettingsProperty.Tracking.HasPurchasedAnything hasPurchasedAnything = SettingsProperty.Tracking.HasPurchasedAnything.INSTANCE;
        if (((Boolean) iSettings.latestValueFor(hasPurchasedAnything)).booleanValue()) {
            return Unit.INSTANCE;
        }
        Adjust.trackEvent(new AdjustEvent(companion.isMolslinjen() ? "x6urh0" : "o3r2ir"));
        Object update = this.settings.update(hasPurchasedAnything, Boxing.boxBoolean(true), continuation);
        return update == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? update : Unit.INSTANCE;
    }

    @Override // dk.molslinjen.domain.analytics.IAdjustTracker
    public void setup(Context context, Function1<? super Application.ActivityLifecycleCallbacks, Unit> registerLifecycleCallbacks) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(registerLifecycleCallbacks, "registerLifecycleCallbacks");
        Environment environment = Environment.Dev;
        AdjustConfig adjustConfig = new AdjustConfig(context, Constants.Keys.INSTANCE.getAdjustApiKey(), (environment.isCurrent() || Environment.Test.isCurrent()) ? AdjustConfig.ENVIRONMENT_SANDBOX : AdjustConfig.ENVIRONMENT_PRODUCTION);
        adjustConfig.setLogLevel((environment.isCurrent() || Environment.Test.isCurrent()) ? LogLevel.VERBOSE : LogLevel.ERROR);
        adjustConfig.setUrlStrategy(AdjustConfig.DATA_RESIDENCY_EU);
        Adjust.onCreate(adjustConfig);
        registerLifecycleCallbacks.invoke(new AdjustLifecycleCallbacks());
    }
}
