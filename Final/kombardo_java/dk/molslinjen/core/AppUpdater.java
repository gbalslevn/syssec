package dk.molslinjen.core;

import android.app.Activity;
import android.content.IntentSender;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import dk.molslinjen.core.AppUpdater;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.api.IForceUpdateManager;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\u0001/B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J&\u0010\u001f\u001a\u00020\u001c2\u001c\b\u0002\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001c\u0018\u00010!H\u0002J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0010H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J(\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010&\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J \u0010'\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\"\u0010(\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00132\b\b\u0001\u0010)\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J \u0010,\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Ldk/molslinjen/core/AppUpdater;", "Ldk/molslinjen/core/IAppUpdater;", "forceUpdateManager", "Ldk/molslinjen/domain/managers/api/IForceUpdateManager;", "settings", "Ldk/molslinjen/domain/model/settings/ISettings;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "<init>", "(Ldk/molslinjen/domain/managers/api/IForceUpdateManager;Ldk/molslinjen/domain/model/settings/ISettings;Ldk/molslinjen/core/snackbar/ISnackbarService;)V", "appUpdateState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/core/AppUpdater$AppUpdateState;", "getAppUpdateState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "appUpdateRequestKey", BuildConfig.FLAVOR, "appUpdateInfo", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "appUpdateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "stateListener", "Lcom/google/android/play/core/install/InstallStateUpdatedListener;", "shownUpdateStarted", BuildConfig.FLAVOR, "hasAttemptedFlexible", "checkForUpdates", BuildConfig.FLAVOR, "activity", "Landroid/app/Activity;", "getUpdateVersionCode", "completed", "Lkotlin/Function2;", "shouldForceImmediateUpdate", "forceUpdateMinVersionCode", "startUpdate", "allowImmediateUpdate", "startImmediateUpdate", "startFlexibleUpdate", "safeStartUpdateFlow", "updateType", "popupSnackbarForStartingUpdate", "popupSnackbarForCompleteUpdate", "checkUpdateStatus", "requestCode", "resultCode", "AppUpdateState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AppUpdater implements IAppUpdater {
    private Task<AppUpdateInfo> appUpdateInfo;
    private AppUpdateManager appUpdateManager;
    private final int appUpdateRequestKey;
    private final MutableStateFlow<AppUpdateState> appUpdateState;
    private final IForceUpdateManager forceUpdateManager;
    private boolean hasAttemptedFlexible;
    private final ISettings settings;
    private boolean shownUpdateStarted;
    private final ISnackbarService snackbarService;
    private InstallStateUpdatedListener stateListener;

    public AppUpdater(IForceUpdateManager forceUpdateManager, ISettings settings, ISnackbarService snackbarService) {
        Intrinsics.checkNotNullParameter(forceUpdateManager, "forceUpdateManager");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        this.forceUpdateManager = forceUpdateManager;
        this.settings = settings;
        this.snackbarService = snackbarService;
        this.appUpdateState = StateFlowKt.MutableStateFlow(new AppUpdateState(false, 1, null));
        this.appUpdateRequestKey = 123;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkForUpdates$lambda$1(final AppUpdater appUpdater, final Activity activity, final AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.updateAvailability() == 2) {
            if (appUpdater.shouldForceImmediateUpdate()) {
                Intrinsics.checkNotNull(appUpdateInfo);
                appUpdater.startUpdate(true, appUpdateInfo, activity, appUpdater.snackbarService);
                getUpdateVersionCode$default(appUpdater, null, 1, null);
            } else {
                appUpdater.getUpdateVersionCode(new Function2() { // from class: t1.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit checkForUpdates$lambda$1$lambda$0;
                        checkForUpdates$lambda$1$lambda$0 = AppUpdater.checkForUpdates$lambda$1$lambda$0(AppUpdater.this, appUpdateInfo, activity, ((Boolean) obj).booleanValue(), ((Integer) obj2).intValue());
                        return checkForUpdates$lambda$1$lambda$0;
                    }
                });
            }
        }
        if (appUpdateInfo.updateAvailability() == 3) {
            Logger.log$default(Logger.INSTANCE, "Resuming update flow of app", "AppUpdater", 0, 4, null);
            if (appUpdater.shouldForceImmediateUpdate()) {
                Intrinsics.checkNotNull(appUpdateInfo);
                appUpdater.safeStartUpdateFlow(appUpdateInfo, 1, activity);
            }
            if (appUpdateInfo.installStatus() == 11) {
                appUpdater.popupSnackbarForCompleteUpdate(appUpdater.snackbarService);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkForUpdates$lambda$1$lambda$0(AppUpdater appUpdater, AppUpdateInfo appUpdateInfo, Activity activity, boolean z5, int i5) {
        boolean z6 = z5 && appUpdater.shouldForceImmediateUpdate(i5);
        Intrinsics.checkNotNull(appUpdateInfo);
        appUpdater.startUpdate(z6, appUpdateInfo, activity, appUpdater.snackbarService);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkForUpdates$lambda$5(final AppUpdater appUpdater, Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "<unused var>");
        appUpdater.getUpdateVersionCode(new Function2() { // from class: t1.f
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit checkForUpdates$lambda$5$lambda$4;
                checkForUpdates$lambda$5$lambda$4 = AppUpdater.checkForUpdates$lambda$5$lambda$4(AppUpdater.this, ((Boolean) obj).booleanValue(), ((Integer) obj2).intValue());
                return checkForUpdates$lambda$5$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkForUpdates$lambda$5$lambda$4(AppUpdater appUpdater, boolean z5, int i5) {
        AppUpdateState value;
        boolean z6 = z5 && appUpdater.shouldForceImmediateUpdate(i5);
        MutableStateFlow<AppUpdateState> appUpdateState = appUpdater.getAppUpdateState();
        do {
            value = appUpdateState.getValue();
        } while (!appUpdateState.compareAndSet(value, value.copy(z6)));
        return Unit.INSTANCE;
    }

    private final void getUpdateVersionCode(Function2<? super Boolean, ? super Integer, Unit> completed) {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AppUpdater$getUpdateVersionCode$1(this, completed, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void getUpdateVersionCode$default(AppUpdater appUpdater, Function2 function2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            function2 = null;
        }
        appUpdater.getUpdateVersionCode(function2);
    }

    private final void popupSnackbarForCompleteUpdate(ISnackbarService snackbarService) {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AppUpdater$popupSnackbarForCompleteUpdate$1(snackbarService, this, null), 2, null);
    }

    private final void popupSnackbarForStartingUpdate(ISnackbarService snackbarService) {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AppUpdater$popupSnackbarForStartingUpdate$1(snackbarService, null), 2, null);
    }

    private final void safeStartUpdateFlow(AppUpdateInfo appUpdateInfo, int updateType, Activity activity) {
        try {
            AppUpdateManager appUpdateManager = this.appUpdateManager;
            if (appUpdateManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appUpdateManager");
                appUpdateManager = null;
            }
            appUpdateManager.startUpdateFlowForResult(appUpdateInfo, updateType, activity, this.appUpdateRequestKey);
        } catch (IntentSender.SendIntentException unused) {
            Logger.log$default(Logger.INSTANCE, "Failed because starting a second update flow at the same time is not possible", "AppUpdater", 0, 4, null);
        }
    }

    private final boolean shouldForceImmediateUpdate(int forceUpdateMinVersionCode) {
        return 100000362 < forceUpdateMinVersionCode;
    }

    private final void startFlexibleUpdate(AppUpdateInfo appUpdateInfo, Activity activity, final ISnackbarService snackbarService) {
        if (this.hasAttemptedFlexible) {
            return;
        }
        this.hasAttemptedFlexible = true;
        Logger.log$default(Logger.INSTANCE, "Starting Flexible Update flow", "AppUpdater", 0, 4, null);
        this.stateListener = new InstallStateUpdatedListener() { // from class: t1.g
            @Override // com.google.android.play.core.listener.StateUpdatedListener
            public final void onStateUpdate(InstallState installState) {
                AppUpdater.startFlexibleUpdate$lambda$6(AppUpdater.this, snackbarService, installState);
            }
        };
        AppUpdateManager appUpdateManager = this.appUpdateManager;
        InstallStateUpdatedListener installStateUpdatedListener = null;
        if (appUpdateManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appUpdateManager");
            appUpdateManager = null;
        }
        InstallStateUpdatedListener installStateUpdatedListener2 = this.stateListener;
        if (installStateUpdatedListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateListener");
        } else {
            installStateUpdatedListener = installStateUpdatedListener2;
        }
        appUpdateManager.registerListener(installStateUpdatedListener);
        safeStartUpdateFlow(appUpdateInfo, 0, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startFlexibleUpdate$lambda$6(AppUpdater appUpdater, ISnackbarService iSnackbarService, InstallState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.installStatus() == 1 && !appUpdater.shownUpdateStarted) {
            appUpdater.shownUpdateStarted = true;
            appUpdater.popupSnackbarForStartingUpdate(iSnackbarService);
        }
        if (state.installStatus() == 11) {
            AppUpdateManager appUpdateManager = appUpdater.appUpdateManager;
            InstallStateUpdatedListener installStateUpdatedListener = null;
            if (appUpdateManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appUpdateManager");
                appUpdateManager = null;
            }
            InstallStateUpdatedListener installStateUpdatedListener2 = appUpdater.stateListener;
            if (installStateUpdatedListener2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stateListener");
            } else {
                installStateUpdatedListener = installStateUpdatedListener2;
            }
            appUpdateManager.unregisterListener(installStateUpdatedListener);
            appUpdater.popupSnackbarForCompleteUpdate(iSnackbarService);
        }
    }

    private final void startImmediateUpdate(AppUpdateInfo appUpdateInfo, Activity activity) {
        Logger.log$default(Logger.INSTANCE, "Starting Immediate Update flow", "AppUpdater", 0, 4, null);
        safeStartUpdateFlow(appUpdateInfo, 1, activity);
    }

    private final void startUpdate(boolean allowImmediateUpdate, AppUpdateInfo appUpdateInfo, Activity activity, ISnackbarService snackbarService) {
        if (appUpdateInfo.isUpdateTypeAllowed(1) && allowImmediateUpdate) {
            startImmediateUpdate(appUpdateInfo, activity);
        } else if (appUpdateInfo.isUpdateTypeAllowed(0)) {
            startFlexibleUpdate(appUpdateInfo, activity, snackbarService);
        }
    }

    @Override // dk.molslinjen.core.IAppUpdater
    public void checkForUpdates(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AppUpdateManager create = AppUpdateManagerFactory.create(activity);
        this.appUpdateManager = create;
        Task<AppUpdateInfo> task = null;
        if (create == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appUpdateManager");
            create = null;
        }
        Task<AppUpdateInfo> appUpdateInfo = create.getAppUpdateInfo();
        this.appUpdateInfo = appUpdateInfo;
        if (appUpdateInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appUpdateInfo");
            appUpdateInfo = null;
        }
        final Function1 function1 = new Function1() { // from class: t1.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit checkForUpdates$lambda$1;
                checkForUpdates$lambda$1 = AppUpdater.checkForUpdates$lambda$1(AppUpdater.this, activity, (AppUpdateInfo) obj);
                return checkForUpdates$lambda$1;
            }
        };
        appUpdateInfo.addOnSuccessListener(new OnSuccessListener() { // from class: t1.c
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                Function1.this.invoke(obj);
            }
        });
        Task<AppUpdateInfo> task2 = this.appUpdateInfo;
        if (task2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appUpdateInfo");
        } else {
            task = task2;
        }
        task.addOnFailureListener(new OnFailureListener() { // from class: t1.d
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                AppUpdater.checkForUpdates$lambda$5(AppUpdater.this, exc);
            }
        });
    }

    @Override // dk.molslinjen.core.IAppUpdater
    public void checkUpdateStatus(Activity activity, int requestCode, int resultCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (requestCode == this.appUpdateRequestKey) {
            if (resultCode == 1 && !shouldForceImmediateUpdate()) {
                Logger.log$default(Logger.INSTANCE, "Update of non-immediate update flow failed! Result code: " + resultCode, "AppUpdater", 0, 4, null);
                checkForUpdates(activity);
                return;
            }
            if (resultCode == -1 || !shouldForceImmediateUpdate()) {
                return;
            }
            Logger.log$default(Logger.INSTANCE, "Update flow of immediate update failed! Result code: " + resultCode, "AppUpdater", 0, 4, null);
            checkForUpdates(activity);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/core/AppUpdater$AppUpdateState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "manuelForceUpdateRequired", "<init>", "(Z)V", "copy", "(Z)Ldk/molslinjen/core/AppUpdater$AppUpdateState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getManuelForceUpdateRequired", "()Z", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class AppUpdateState {
        private final boolean manuelForceUpdateRequired;

        public AppUpdateState(boolean z5) {
            this.manuelForceUpdateRequired = z5;
        }

        public final AppUpdateState copy(boolean manuelForceUpdateRequired) {
            return new AppUpdateState(manuelForceUpdateRequired);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AppUpdateState) && this.manuelForceUpdateRequired == ((AppUpdateState) other).manuelForceUpdateRequired;
        }

        public final boolean getManuelForceUpdateRequired() {
            return this.manuelForceUpdateRequired;
        }

        public int hashCode() {
            return Boolean.hashCode(this.manuelForceUpdateRequired);
        }

        public String toString() {
            return "AppUpdateState(manuelForceUpdateRequired=" + this.manuelForceUpdateRequired + ")";
        }

        public /* synthetic */ AppUpdateState(boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? false : z5);
        }
    }

    private final boolean shouldForceImmediateUpdate() {
        return shouldForceImmediateUpdate(((Number) this.settings.latestValueFor(SettingsProperty.ForceUpdate.MinAppVersionCode.INSTANCE)).intValue());
    }

    @Override // dk.molslinjen.core.IAppUpdater
    public MutableStateFlow<AppUpdateState> getAppUpdateState() {
        return this.appUpdateState;
    }
}
