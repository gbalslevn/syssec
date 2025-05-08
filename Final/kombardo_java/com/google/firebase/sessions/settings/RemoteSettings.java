package com.google.firebase.sessions.settings;

import android.os.Build;
import android.util.Log;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.InstallationId;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0000\u0018\u0000 /2\u00020\u0001:\u0001/B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\u00020\u0013H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001f\u0010*\u001a\u0004\u0018\u00010'8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u0004\u0018\u00010+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings;", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "Lkotlin/coroutines/CoroutineContext;", "backgroundDispatcher", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "firebaseInstallationsApi", "Lcom/google/firebase/sessions/ApplicationInfo;", "appInfo", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "configsFetcher", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "dataStore", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;Landroidx/datastore/core/DataStore;)V", BuildConfig.FLAVOR, "s", "removeForwardSlashesIn", "(Ljava/lang/String;)Ljava/lang/String;", BuildConfig.FLAVOR, "updateSettings", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "Lcom/google/firebase/sessions/ApplicationInfo;", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "Lcom/google/firebase/sessions/settings/SettingsCache;", "settingsCache$delegate", "Lkotlin/Lazy;", "getSettingsCache", "()Lcom/google/firebase/sessions/settings/SettingsCache;", "settingsCache", "Lkotlinx/coroutines/sync/Mutex;", "fetchInProgress", "Lkotlinx/coroutines/sync/Mutex;", BuildConfig.FLAVOR, "getSessionEnabled", "()Ljava/lang/Boolean;", "sessionEnabled", "Lkotlin/time/Duration;", "getSessionRestartTimeout-FghU774", "()Lkotlin/time/Duration;", "sessionRestartTimeout", BuildConfig.FLAVOR, "getSamplingRate", "()Ljava/lang/Double;", "samplingRate", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RemoteSettings implements SettingsProvider {
    private static final Companion Companion = new Companion(null);
    private final ApplicationInfo appInfo;
    private final CoroutineContext backgroundDispatcher;
    private final CrashlyticsSettingsFetcher configsFetcher;
    private final Mutex fetchInProgress;
    private final FirebaseInstallationsApi firebaseInstallationsApi;

    /* renamed from: settingsCache$delegate, reason: from kotlin metadata */
    private final Lazy settingsCache;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings$Companion;", BuildConfig.FLAVOR, "()V", "FORWARD_SLASH_STRING", BuildConfig.FLAVOR, "TAG", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public RemoteSettings(CoroutineContext backgroundDispatcher, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo appInfo, CrashlyticsSettingsFetcher configsFetcher, final DataStore<Preferences> dataStore) {
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(firebaseInstallationsApi, "firebaseInstallationsApi");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(configsFetcher, "configsFetcher");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        this.backgroundDispatcher = backgroundDispatcher;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.appInfo = appInfo;
        this.configsFetcher = configsFetcher;
        this.settingsCache = LazyKt.lazy(new Function0<SettingsCache>() { // from class: com.google.firebase.sessions.settings.RemoteSettings$settingsCache$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SettingsCache invoke() {
                return new SettingsCache(dataStore);
            }
        });
        this.fetchInProgress = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsCache getSettingsCache() {
        return (SettingsCache) this.settingsCache.getValue();
    }

    private final String removeForwardSlashesIn(String s5) {
        return new Regex("/").replace(s5, BuildConfig.FLAVOR);
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Double getSamplingRate() {
        return getSettingsCache().sessionSamplingRate();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Boolean getSessionEnabled() {
        return getSettingsCache().sessionsEnabled();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /* renamed from: getSessionRestartTimeout-FghU774 */
    public Duration mo2918getSessionRestartTimeoutFghU774() {
        Integer sessionRestartTimeout = getSettingsCache().sessionRestartTimeout();
        if (sessionRestartTimeout == null) {
            return null;
        }
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.m3727boximpl(DurationKt.toDuration(sessionRestartTimeout.intValue(), DurationUnit.SECONDS));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c5 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:26:0x004a, B:27:0x00b7, B:29:0x00c5, B:32:0x00d0), top: B:25:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d0 A[Catch: all -> 0x004f, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:26:0x004a, B:27:0x00b7, B:29:0x00c5, B:32:0x00d0), top: B:25:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0092 A[Catch: all -> 0x009d, TRY_LEAVE, TryCatch #1 {all -> 0x009d, blocks: (B:40:0x0088, B:42:0x0092, B:45:0x00a3), top: B:39:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a3 A[Catch: all -> 0x009d, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x009d, blocks: (B:40:0x0088, B:42:0x0092, B:45:0x00a3), top: B:39:0x0088 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateSettings(Continuation<? super Unit> continuation) {
        RemoteSettings$updateSettings$1 remoteSettings$updateSettings$1;
        int i5;
        Mutex mutex;
        RemoteSettings remoteSettings;
        Mutex mutex2;
        Throwable th;
        Mutex mutex3;
        String fid;
        try {
            if (continuation instanceof RemoteSettings$updateSettings$1) {
                remoteSettings$updateSettings$1 = (RemoteSettings$updateSettings$1) continuation;
                int i6 = remoteSettings$updateSettings$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    remoteSettings$updateSettings$1.label = i6 - Integer.MIN_VALUE;
                    Object obj = remoteSettings$updateSettings$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = remoteSettings$updateSettings$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (!this.fetchInProgress.isLocked() && !getSettingsCache().hasCacheExpired$com_google_firebase_firebase_sessions()) {
                            return Unit.INSTANCE;
                        }
                        mutex = this.fetchInProgress;
                        remoteSettings$updateSettings$1.L$0 = this;
                        remoteSettings$updateSettings$1.L$1 = mutex;
                        remoteSettings$updateSettings$1.label = 1;
                        if (mutex.lock(null, remoteSettings$updateSettings$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        remoteSettings = this;
                    } else {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                if (i5 != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                mutex2 = (Mutex) remoteSettings$updateSettings$1.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    Unit unit = Unit.INSTANCE;
                                    mutex2.unlock(null);
                                    return Unit.INSTANCE;
                                } catch (Throwable th2) {
                                    th = th2;
                                    mutex2.unlock(null);
                                    throw th;
                                }
                            }
                            mutex3 = (Mutex) remoteSettings$updateSettings$1.L$1;
                            remoteSettings = (RemoteSettings) remoteSettings$updateSettings$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                fid = ((InstallationId) obj).getFid();
                                if (!Intrinsics.areEqual(fid, BuildConfig.FLAVOR)) {
                                    Log.w("SessionConfigFetcher", "Error getting Firebase Installation ID. Skipping this Session Event.");
                                    Unit unit2 = Unit.INSTANCE;
                                    mutex3.unlock(null);
                                    return unit2;
                                }
                                Pair pair = TuplesKt.to("X-Crashlytics-Installation-ID", fid);
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                String format = String.format("%s/%s", Arrays.copyOf(new Object[]{Build.MANUFACTURER, Build.MODEL}, 2));
                                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                                Pair pair2 = TuplesKt.to("X-Crashlytics-Device-Model", remoteSettings.removeForwardSlashesIn(format));
                                String INCREMENTAL = Build.VERSION.INCREMENTAL;
                                Intrinsics.checkNotNullExpressionValue(INCREMENTAL, "INCREMENTAL");
                                Pair pair3 = TuplesKt.to("X-Crashlytics-OS-Build-Version", remoteSettings.removeForwardSlashesIn(INCREMENTAL));
                                String RELEASE = Build.VERSION.RELEASE;
                                Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
                                Map<String, String> mapOf = MapsKt.mapOf(pair, pair2, pair3, TuplesKt.to("X-Crashlytics-OS-Display-Version", remoteSettings.removeForwardSlashesIn(RELEASE)), TuplesKt.to("X-Crashlytics-API-Client-Version", remoteSettings.appInfo.getSessionSdkVersion()));
                                Log.d("SessionConfigFetcher", "Fetching settings from server.");
                                CrashlyticsSettingsFetcher crashlyticsSettingsFetcher = remoteSettings.configsFetcher;
                                RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(remoteSettings, null);
                                RemoteSettings$updateSettings$2$2 remoteSettings$updateSettings$2$2 = new RemoteSettings$updateSettings$2$2(null);
                                remoteSettings$updateSettings$1.L$0 = mutex3;
                                remoteSettings$updateSettings$1.L$1 = null;
                                remoteSettings$updateSettings$1.label = 3;
                                if (crashlyticsSettingsFetcher.doConfigFetch(mapOf, remoteSettings$updateSettings$2$1, remoteSettings$updateSettings$2$2, remoteSettings$updateSettings$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                mutex2 = mutex3;
                                Unit unit3 = Unit.INSTANCE;
                                mutex2.unlock(null);
                                return Unit.INSTANCE;
                            } catch (Throwable th3) {
                                th = th3;
                                mutex2 = mutex3;
                                mutex2.unlock(null);
                                throw th;
                            }
                        }
                        Mutex mutex4 = (Mutex) remoteSettings$updateSettings$1.L$1;
                        remoteSettings = (RemoteSettings) remoteSettings$updateSettings$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = mutex4;
                    }
                    if (remoteSettings.getSettingsCache().hasCacheExpired$com_google_firebase_firebase_sessions()) {
                        Log.d("SessionConfigFetcher", "Remote settings cache not expired. Using cached values.");
                        Unit unit4 = Unit.INSTANCE;
                        mutex.unlock(null);
                        return unit4;
                    }
                    InstallationId.Companion companion = InstallationId.INSTANCE;
                    FirebaseInstallationsApi firebaseInstallationsApi = remoteSettings.firebaseInstallationsApi;
                    remoteSettings$updateSettings$1.L$0 = remoteSettings;
                    remoteSettings$updateSettings$1.L$1 = mutex;
                    remoteSettings$updateSettings$1.label = 2;
                    Object create = companion.create(firebaseInstallationsApi, remoteSettings$updateSettings$1);
                    if (create == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutex3 = mutex;
                    obj = create;
                    fid = ((InstallationId) obj).getFid();
                    if (!Intrinsics.areEqual(fid, BuildConfig.FLAVOR)) {
                    }
                }
            }
            if (remoteSettings.getSettingsCache().hasCacheExpired$com_google_firebase_firebase_sessions()) {
            }
        } catch (Throwable th4) {
            mutex2 = mutex;
            th = th4;
            mutex2.unlock(null);
            throw th;
        }
        remoteSettings$updateSettings$1 = new RemoteSettings$updateSettings$1(this, continuation);
        Object obj2 = remoteSettings$updateSettings$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = remoteSettings$updateSettings$1.label;
        if (i5 != 0) {
        }
    }
}
