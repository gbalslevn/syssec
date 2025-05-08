package com.google.firebase.sessions.settings;

import android.content.Context;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseKt;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.ProcessDetailsProvider;
import com.google.firebase.sessions.SessionDataStoreConfigs;
import com.google.firebase.sessions.SessionEvents;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B/\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB'\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u000eB\u0015\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001d\u0010 \u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u00020$H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00188Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Lcom/google/firebase/sessions/settings/SessionsSettings;", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "blockingDispatcher", "Lkotlin/coroutines/CoroutineContext;", "backgroundDispatcher", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "appInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;)V", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "(Lcom/google/firebase/FirebaseApp;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;)V", "localOverrideSettings", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "remoteSettings", "(Lcom/google/firebase/sessions/settings/SettingsProvider;Lcom/google/firebase/sessions/settings/SettingsProvider;)V", "samplingRate", BuildConfig.FLAVOR, "getSamplingRate", "()D", "sessionRestartTimeout", "Lkotlin/time/Duration;", "getSessionRestartTimeout-UwyO8pc", "()J", "sessionsEnabled", BuildConfig.FLAVOR, "getSessionsEnabled", "()Z", "isValidSamplingRate", "isValidSessionRestartTimeout", "isValidSessionRestartTimeout-LRDsOJo", "(J)Z", "updateSettings", BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionsSettings {
    private static final String TAG = "SessionsSettings";
    private final SettingsProvider localOverrideSettings;
    private final SettingsProvider remoteSettings;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ReadOnlyProperty<Context, DataStore<Preferences>> dataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default(SessionDataStoreConfigs.INSTANCE.getSETTINGS_CONFIG_NAME(), new ReplaceFileCorruptionHandler(new Function1<CorruptionException, Preferences>() { // from class: com.google.firebase.sessions.settings.SessionsSettings$Companion$dataStore$2
        @Override // kotlin.jvm.functions.Function1
        public final Preferences invoke(CorruptionException ex) {
            Intrinsics.checkNotNullParameter(ex, "ex");
            Log.w("SessionsSettings", "CorruptionException in settings DataStore in " + ProcessDetailsProvider.INSTANCE.getProcessName$com_google_firebase_firebase_sessions() + '.', ex);
            return PreferencesFactory.createEmpty();
        }
    }), null, null, 12, null);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/google/firebase/sessions/settings/SessionsSettings$Companion;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "instance", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "getInstance", "()Lcom/google/firebase/sessions/settings/SessionsSettings;", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Landroid/content/Context;", "getDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "dataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property2(new PropertyReference2Impl(Companion.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DataStore<Preferences> getDataStore(Context context) {
            return (DataStore) SessionsSettings.dataStore$delegate.getValue(context, $$delegatedProperties[0]);
        }

        public final SessionsSettings getInstance() {
            Object obj = FirebaseKt.getApp(Firebase.INSTANCE).get(SessionsSettings.class);
            Intrinsics.checkNotNullExpressionValue(obj, "Firebase.app[SessionsSettings::class.java]");
            return (SessionsSettings) obj;
        }

        private Companion() {
        }
    }

    public SessionsSettings(SettingsProvider localOverrideSettings, SettingsProvider remoteSettings) {
        Intrinsics.checkNotNullParameter(localOverrideSettings, "localOverrideSettings");
        Intrinsics.checkNotNullParameter(remoteSettings, "remoteSettings");
        this.localOverrideSettings = localOverrideSettings;
        this.remoteSettings = remoteSettings;
    }

    private final boolean isValidSamplingRate(double samplingRate) {
        return 0.0d <= samplingRate && samplingRate <= 1.0d;
    }

    /* renamed from: isValidSessionRestartTimeout-LRDsOJo, reason: not valid java name */
    private final boolean m2919isValidSessionRestartTimeoutLRDsOJo(long sessionRestartTimeout) {
        return Duration.m3749isPositiveimpl(sessionRestartTimeout) && Duration.m3744isFiniteimpl(sessionRestartTimeout);
    }

    public final double getSamplingRate() {
        Double samplingRate = this.localOverrideSettings.getSamplingRate();
        if (samplingRate != null) {
            double doubleValue = samplingRate.doubleValue();
            if (isValidSamplingRate(doubleValue)) {
                return doubleValue;
            }
        }
        Double samplingRate2 = this.remoteSettings.getSamplingRate();
        if (samplingRate2 == null) {
            return 1.0d;
        }
        double doubleValue2 = samplingRate2.doubleValue();
        if (isValidSamplingRate(doubleValue2)) {
            return doubleValue2;
        }
        return 1.0d;
    }

    /* renamed from: getSessionRestartTimeout-UwyO8pc, reason: not valid java name */
    public final long m2920getSessionRestartTimeoutUwyO8pc() {
        Duration mo2918getSessionRestartTimeoutFghU774 = this.localOverrideSettings.mo2918getSessionRestartTimeoutFghU774();
        if (mo2918getSessionRestartTimeoutFghU774 != null) {
            long rawValue = mo2918getSessionRestartTimeoutFghU774.getRawValue();
            if (m2919isValidSessionRestartTimeoutLRDsOJo(rawValue)) {
                return rawValue;
            }
        }
        Duration mo2918getSessionRestartTimeoutFghU7742 = this.remoteSettings.mo2918getSessionRestartTimeoutFghU774();
        if (mo2918getSessionRestartTimeoutFghU7742 != null) {
            long rawValue2 = mo2918getSessionRestartTimeoutFghU7742.getRawValue();
            if (m2919isValidSessionRestartTimeoutLRDsOJo(rawValue2)) {
                return rawValue2;
            }
        }
        Duration.Companion companion = Duration.INSTANCE;
        return DurationKt.toDuration(30, DurationUnit.MINUTES);
    }

    public final boolean getSessionsEnabled() {
        Boolean sessionEnabled = this.localOverrideSettings.getSessionEnabled();
        if (sessionEnabled != null) {
            return sessionEnabled.booleanValue();
        }
        Boolean sessionEnabled2 = this.remoteSettings.getSessionEnabled();
        if (sessionEnabled2 != null) {
            return sessionEnabled2.booleanValue();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateSettings(Continuation<? super Unit> continuation) {
        SessionsSettings$updateSettings$1 sessionsSettings$updateSettings$1;
        Object coroutine_suspended;
        int i5;
        SessionsSettings sessionsSettings;
        SettingsProvider settingsProvider;
        if (continuation instanceof SessionsSettings$updateSettings$1) {
            sessionsSettings$updateSettings$1 = (SessionsSettings$updateSettings$1) continuation;
            int i6 = sessionsSettings$updateSettings$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                sessionsSettings$updateSettings$1.label = i6 - Integer.MIN_VALUE;
                Object obj = sessionsSettings$updateSettings$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = sessionsSettings$updateSettings$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    SettingsProvider settingsProvider2 = this.localOverrideSettings;
                    sessionsSettings$updateSettings$1.L$0 = this;
                    sessionsSettings$updateSettings$1.label = 1;
                    if (settingsProvider2.updateSettings(sessionsSettings$updateSettings$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sessionsSettings = this;
                } else {
                    if (i5 != 1) {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    sessionsSettings = (SessionsSettings) sessionsSettings$updateSettings$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                settingsProvider = sessionsSettings.remoteSettings;
                sessionsSettings$updateSettings$1.L$0 = null;
                sessionsSettings$updateSettings$1.label = 2;
                if (settingsProvider.updateSettings(sessionsSettings$updateSettings$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        sessionsSettings$updateSettings$1 = new SessionsSettings$updateSettings$1(this, continuation);
        Object obj2 = sessionsSettings$updateSettings$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = sessionsSettings$updateSettings$1.label;
        if (i5 != 0) {
        }
        settingsProvider = sessionsSettings.remoteSettings;
        sessionsSettings$updateSettings$1.L$0 = null;
        sessionsSettings$updateSettings$1.label = 2;
        if (settingsProvider.updateSettings(sessionsSettings$updateSettings$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    private SessionsSettings(Context context, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo applicationInfo) {
        this(new LocalOverrideSettings(context), new RemoteSettings(coroutineContext2, firebaseInstallationsApi, applicationInfo, new RemoteSettingsFetcher(applicationInfo, coroutineContext, null, 4, null), INSTANCE.getDataStore(context)));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SessionsSettings(FirebaseApp firebaseApp, CoroutineContext blockingDispatcher, CoroutineContext backgroundDispatcher, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(r2, blockingDispatcher, backgroundDispatcher, firebaseInstallationsApi, SessionEvents.INSTANCE.getApplicationInfo(firebaseApp));
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Intrinsics.checkNotNullParameter(blockingDispatcher, "blockingDispatcher");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(firebaseInstallationsApi, "firebaseInstallationsApi");
        Context applicationContext = firebaseApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "firebaseApp.applicationContext");
    }
}
