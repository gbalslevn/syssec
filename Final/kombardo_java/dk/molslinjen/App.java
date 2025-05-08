package dk.molslinjen;

import android.app.ActivityManager;
import android.app.Application;
import androidx.core.content.ContextCompat;
import androidx.hilt.work.HiltWorkerFactory;
import androidx.work.Configuration;
import coil.ComponentRegistry;
import coil.ImageLoader;
import coil.ImageLoaderFactory;
import coil.content.DebugLogger;
import coil.decode.SvgDecoder;
import coil.memory.MemoryCache;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.ktx.FirebaseCrashlyticsKt;
import com.google.firebase.crashlytics.ktx.KeyValueBuilder;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.jakewharton.threetenabp.AndroidThreeTen;
import defpackage.MolslinjenSharedHelper;
import dk.molslinjen.App;
import dk.molslinjen.core.Environment;
import dk.molslinjen.core.location.ILocationManager;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.core.log.RustLogger;
import dk.molslinjen.core.migration.IMigrator;
import dk.molslinjen.core.push.IPushHandler;
import dk.molslinjen.domain.analytics.IAdjustTracker;
import dk.molslinjen.domain.analytics.IFacebookTracker;
import dk.molslinjen.domain.extensions.ApiEnvironmentExtensionsKt;
import dk.molslinjen.domain.managers.api.IApiProviderManager;
import dk.molslinjen.domain.managers.notification.INotificationManager;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.rustBridges.ApiAuthentication;
import dk.molslinjen.domain.rustBridges.RequestParameters;
import dk.molslinjen.extensions.domain.EnvironmentExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.Molslinjen_sharedKt;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020B8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010J\u001a\u00020I8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010Q\u001a\u00020P8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0014\u0010Z\u001a\u00020W8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010Y¨\u0006["}, d2 = {"Ldk/molslinjen/App;", "Landroid/app/Application;", "Lcoil/ImageLoaderFactory;", "Landroidx/work/Configuration$Provider;", "<init>", "()V", BuildConfig.FLAVOR, "startLoadingCurrentLocation", "setupDeviceId", "setRustVerticaApiUrl", "rustSetup", "setupFirebaseCustomKeys", "setupFirebasePushTokenListener", "onCreate", "Lcoil/ImageLoader;", "newImageLoader", "()Lcoil/ImageLoader;", "Ldk/molslinjen/domain/model/settings/ISettings;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "getSettings", "()Ldk/molslinjen/domain/model/settings/ISettings;", "setSettings", "(Ldk/molslinjen/domain/model/settings/ISettings;)V", "Ldk/molslinjen/core/push/IPushHandler;", "pushHandler", "Ldk/molslinjen/core/push/IPushHandler;", "getPushHandler", "()Ldk/molslinjen/core/push/IPushHandler;", "setPushHandler", "(Ldk/molslinjen/core/push/IPushHandler;)V", "Landroidx/hilt/work/HiltWorkerFactory;", "workerFactory", "Landroidx/hilt/work/HiltWorkerFactory;", "getWorkerFactory", "()Landroidx/hilt/work/HiltWorkerFactory;", "setWorkerFactory", "(Landroidx/hilt/work/HiltWorkerFactory;)V", "Ldk/molslinjen/core/migration/IMigrator;", "migrator", "Ldk/molslinjen/core/migration/IMigrator;", "getMigrator", "()Ldk/molslinjen/core/migration/IMigrator;", "setMigrator", "(Ldk/molslinjen/core/migration/IMigrator;)V", "Ldk/molslinjen/domain/analytics/IAdjustTracker;", "adjustTracker", "Ldk/molslinjen/domain/analytics/IAdjustTracker;", "getAdjustTracker", "()Ldk/molslinjen/domain/analytics/IAdjustTracker;", "setAdjustTracker", "(Ldk/molslinjen/domain/analytics/IAdjustTracker;)V", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "getFacebookTracker", "()Ldk/molslinjen/domain/analytics/IFacebookTracker;", "setFacebookTracker", "(Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", "Ldk/molslinjen/domain/managers/api/IApiProviderManager;", "apiProviderManager", "Ldk/molslinjen/domain/managers/api/IApiProviderManager;", "getApiProviderManager", "()Ldk/molslinjen/domain/managers/api/IApiProviderManager;", "setApiProviderManager", "(Ldk/molslinjen/domain/managers/api/IApiProviderManager;)V", "Ldk/molslinjen/domain/managers/notification/INotificationManager;", "notificationManager", "Ldk/molslinjen/domain/managers/notification/INotificationManager;", "getNotificationManager", "()Ldk/molslinjen/domain/managers/notification/INotificationManager;", "setNotificationManager", "(Ldk/molslinjen/domain/managers/notification/INotificationManager;)V", "Ldk/molslinjen/core/location/ILocationManager;", "locationManager", "Ldk/molslinjen/core/location/ILocationManager;", "getLocationManager", "()Ldk/molslinjen/core/location/ILocationManager;", "setLocationManager", "(Ldk/molslinjen/core/location/ILocationManager;)V", BuildConfig.FLAVOR, "mainActivityCreated", "Z", "getMainActivityCreated", "()Z", "setMainActivityCreated", "(Z)V", "Landroidx/work/Configuration;", "getWorkManagerConfiguration", "()Landroidx/work/Configuration;", "workManagerConfiguration", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class App extends Hilt_App implements ImageLoaderFactory, Configuration.Provider {
    public IAdjustTracker adjustTracker;
    public IApiProviderManager apiProviderManager;
    public IFacebookTracker facebookTracker;
    public ILocationManager locationManager;
    private boolean mainActivityCreated;
    public IMigrator migrator;
    public INotificationManager notificationManager;
    public IPushHandler pushHandler;
    public ISettings settings;
    public HiltWorkerFactory workerFactory;

    /* JADX INFO: Access modifiers changed from: private */
    public static final MemoryCache newImageLoader$lambda$0(App app) {
        return new MemoryCache.Builder(app).maxSizePercent(0.1d).build();
    }

    private final void rustSetup() {
        new ApiAuthentication();
        new RequestParameters();
        RustLogger.INSTANCE.setup();
        Molslinjen_sharedKt.ffiInitializeConfiguration(EnvironmentExtensionsKt.toBuildConfiguration(Environment.INSTANCE.current()));
        setRustVerticaApiUrl();
    }

    private final void setRustVerticaApiUrl() {
        Molslinjen_sharedKt.constantsApiSetMolslinjenBaseUrl(ApiEnvironmentExtensionsKt.getVerticaApiUrl(getApiProviderManager().getActiveApi()) + "/v1/");
        Molslinjen_sharedKt.constantsApiSetAgillicBaseUrl("https://api-eu1.agillic.net/");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new App$setRustVerticaApiUrl$1(this, null), 3, null);
    }

    private final void setupDeviceId() {
        BuildersKt__BuildersKt.runBlocking$default(null, new App$setupDeviceId$1(this, null), 1, null);
    }

    private final void setupFirebaseCustomKeys() {
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = -1;
        ActivityManager activityManager = (ActivityManager) ContextCompat.getSystemService(this, ActivityManager.class);
        if (activityManager != null) {
            ref$IntRef.element = (getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
        }
        FirebaseCrashlyticsKt.setCustomKeys(FirebaseCrashlyticsKt.getCrashlytics(Firebase.INSTANCE), new Function1() { // from class: n1.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                unit = App.setupFirebaseCustomKeys$lambda$3(Ref$IntRef.this, (KeyValueBuilder) obj);
                return unit;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupFirebaseCustomKeys$lambda$3(Ref$IntRef ref$IntRef, KeyValueBuilder setCustomKeys) {
        Intrinsics.checkNotNullParameter(setCustomKeys, "$this$setCustomKeys");
        setCustomKeys.key(Constants.FirebaseCustomKeys.DalvikHeapSizeMB, ref$IntRef.element);
        return Unit.INSTANCE;
    }

    private final void setupFirebasePushTokenListener() {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: n1.a
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                App.setupFirebasePushTokenListener$lambda$4(App.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFirebasePushTokenListener$lambda$4(App app, Task task) {
        String str;
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            Logger logger = Logger.INSTANCE;
            Exception exception = task.getException();
            if (exception == null || (str = exception.getMessage()) == null) {
                str = BuildConfig.FLAVOR;
            }
            Logger.log$default(logger, "Fetching FCM registration token failed: " + str, null, 0, 6, null);
            return;
        }
        String str2 = (String) task.getResult();
        Logger.log$default(Logger.INSTANCE, "FCM registration token: " + str2, null, 0, 6, null);
        INotificationManager notificationManager = app.getNotificationManager();
        Intrinsics.checkNotNull(str2);
        notificationManager.setToken(str2);
        app.getPushHandler().setToken(str2);
    }

    private final void startLoadingCurrentLocation() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new App$startLoadingCurrentLocation$1(this, null), 3, null);
    }

    public final IAdjustTracker getAdjustTracker() {
        IAdjustTracker iAdjustTracker = this.adjustTracker;
        if (iAdjustTracker != null) {
            return iAdjustTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adjustTracker");
        return null;
    }

    public final IApiProviderManager getApiProviderManager() {
        IApiProviderManager iApiProviderManager = this.apiProviderManager;
        if (iApiProviderManager != null) {
            return iApiProviderManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("apiProviderManager");
        return null;
    }

    public final IFacebookTracker getFacebookTracker() {
        IFacebookTracker iFacebookTracker = this.facebookTracker;
        if (iFacebookTracker != null) {
            return iFacebookTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("facebookTracker");
        return null;
    }

    public final ILocationManager getLocationManager() {
        ILocationManager iLocationManager = this.locationManager;
        if (iLocationManager != null) {
            return iLocationManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationManager");
        return null;
    }

    public final boolean getMainActivityCreated() {
        return this.mainActivityCreated;
    }

    public final IMigrator getMigrator() {
        IMigrator iMigrator = this.migrator;
        if (iMigrator != null) {
            return iMigrator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("migrator");
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

    public final IPushHandler getPushHandler() {
        IPushHandler iPushHandler = this.pushHandler;
        if (iPushHandler != null) {
            return iPushHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pushHandler");
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

    @Override // androidx.work.Configuration.Provider
    public Configuration getWorkManagerConfiguration() {
        return new Configuration.Builder().setWorkerFactory(getWorkerFactory()).build();
    }

    public final HiltWorkerFactory getWorkerFactory() {
        HiltWorkerFactory hiltWorkerFactory = this.workerFactory;
        if (hiltWorkerFactory != null) {
            return hiltWorkerFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("workerFactory");
        return null;
    }

    @Override // coil.ImageLoaderFactory
    public ImageLoader newImageLoader() {
        int i5 = 1;
        boolean z5 = false;
        DefaultConstructorMarker defaultConstructorMarker = null;
        ImageLoader.Builder memoryCache = new ImageLoader.Builder(this).logger(Environment.INSTANCE.current() == Environment.Dev ? new DebugLogger(0, 1, null) : null).memoryCache(new Function0() { // from class: n1.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MemoryCache newImageLoader$lambda$0;
                newImageLoader$lambda$0 = App.newImageLoader$lambda$0(App.this);
                return newImageLoader$lambda$0;
            }
        });
        ComponentRegistry.Builder builder = new ComponentRegistry.Builder();
        builder.add(new SvgDecoder.Factory(z5, i5, defaultConstructorMarker));
        return memoryCache.components(builder.build()).build();
    }

    @Override // dk.molslinjen.Hilt_App, android.app.Application
    public void onCreate() {
        AndroidThreeTen.init((Application) this);
        super.onCreate();
        if (FirebaseCrashlytics.getInstance().didCrashOnPreviousExecution()) {
            Logger.log$default(Logger.INSTANCE, "!!! Crashed on previous run !!!", null, 0, 6, null);
        }
        MolslinjenSharedHelper.INSTANCE.setup();
        rustSetup();
        setupDeviceId();
        Logger logger = Logger.INSTANCE;
        Logger.log$default(logger, "Starting migration", null, 0, 6, null);
        BuildersKt__BuildersKt.runBlocking$default(null, new App$onCreate$1(this, null), 1, null);
        Logger.log$default(logger, "After migration", null, 0, 6, null);
        getAdjustTracker().setup(this, new App$onCreate$2(this));
        getFacebookTracker().setup(this);
        setupFirebaseCustomKeys();
        setupFirebasePushTokenListener();
        getPushHandler().setup(this);
        startLoadingCurrentLocation();
    }

    public final void setMainActivityCreated(boolean z5) {
        this.mainActivityCreated = z5;
    }
}
