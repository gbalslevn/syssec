package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import com.adjust.sdk.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ1\u0010\u000f\u001a\u00020\b\"\u0004\b\u0000\u0010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001e\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010!\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0017H\u0086@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001d\u0010$\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u001aH\u0086@ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u001aH\u0086@ø\u0001\u0000¢\u0006\u0004\b'\u0010%J\u001d\u0010*\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0086@ø\u0001\u0000¢\u0006\u0004\b*\u0010+R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010/\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/google/firebase/sessions/settings/SettingsCache;", BuildConfig.FLAVOR, "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "dataStore", "<init>", "(Landroidx/datastore/core/DataStore;)V", "preferences", BuildConfig.FLAVOR, "updateSessionConfigs", "(Landroidx/datastore/preferences/core/Preferences;)V", "T", "Landroidx/datastore/preferences/core/Preferences$Key;", "key", "value", "updateConfigValue", "(Landroidx/datastore/preferences/core/Preferences$Key;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "hasCacheExpired$com_google_firebase_firebase_sessions", "()Z", "hasCacheExpired", "sessionsEnabled", "()Ljava/lang/Boolean;", BuildConfig.FLAVOR, "sessionSamplingRate", "()Ljava/lang/Double;", BuildConfig.FLAVOR, "sessionRestartTimeout", "()Ljava/lang/Integer;", "enabled", "updateSettingsEnabled", "(Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rate", "updateSamplingRate", "(Ljava/lang/Double;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeoutInSeconds", "updateSessionRestartTimeout", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheDurationInSeconds", "updateSessionCacheDuration", BuildConfig.FLAVOR, "cacheUpdatedTime", "updateSessionCacheUpdatedTime", "(Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/datastore/core/DataStore;", "Lcom/google/firebase/sessions/settings/SessionConfigs;", "sessionConfigs", "Lcom/google/firebase/sessions/settings/SessionConfigs;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SettingsCache {
    private final DataStore<Preferences> dataStore;
    private SessionConfigs sessionConfigs;
    private static final Companion Companion = new Companion(null);
    private static final Preferences.Key<Boolean> SESSIONS_ENABLED = PreferencesKeys.booleanKey("firebase_sessions_enabled");
    private static final Preferences.Key<Double> SAMPLING_RATE = PreferencesKeys.doubleKey("firebase_sessions_sampling_rate");
    private static final Preferences.Key<Integer> RESTART_TIMEOUT_SECONDS = PreferencesKeys.intKey("firebase_sessions_restart_timeout");
    private static final Preferences.Key<Integer> CACHE_DURATION_SECONDS = PreferencesKeys.intKey("firebase_sessions_cache_duration");
    private static final Preferences.Key<Long> CACHE_UPDATED_TIME = PreferencesKeys.longKey("firebase_sessions_cache_updated_time");

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache$1", f = "SettingsCache.kt", l = {46}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.settings.SettingsCache$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SettingsCache settingsCache;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                SettingsCache settingsCache2 = SettingsCache.this;
                Flow data = settingsCache2.dataStore.getData();
                this.L$0 = settingsCache2;
                this.label = 1;
                Object first = FlowKt.first(data, this);
                if (first == coroutine_suspended) {
                    return coroutine_suspended;
                }
                settingsCache = settingsCache2;
                obj = first;
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                settingsCache = (SettingsCache) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            settingsCache.updateSessionConfigs(((Preferences) obj).toPreferences());
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/sessions/settings/SettingsCache$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "TAG", "Ljava/lang/String;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SettingsCache(DataStore<Preferences> dataStore) {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        this.dataStore = dataStore;
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|24|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0029, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        android.util.Log.w("SettingsCache", "Failed to update cache config value: " + r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object updateConfigValue(Preferences.Key<T> key, T t5, Continuation<? super Unit> continuation) {
        SettingsCache$updateConfigValue$1 settingsCache$updateConfigValue$1;
        int i5;
        if (continuation instanceof SettingsCache$updateConfigValue$1) {
            settingsCache$updateConfigValue$1 = (SettingsCache$updateConfigValue$1) continuation;
            int i6 = settingsCache$updateConfigValue$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                settingsCache$updateConfigValue$1.label = i6 - Integer.MIN_VALUE;
                Object obj = settingsCache$updateConfigValue$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = settingsCache$updateConfigValue$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    DataStore<Preferences> dataStore = this.dataStore;
                    SettingsCache$updateConfigValue$2 settingsCache$updateConfigValue$2 = new SettingsCache$updateConfigValue$2(t5, key, this, null);
                    settingsCache$updateConfigValue$1.label = 1;
                    if (PreferencesKt.edit(dataStore, settingsCache$updateConfigValue$2, settingsCache$updateConfigValue$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
        settingsCache$updateConfigValue$1 = new SettingsCache$updateConfigValue$1(this, continuation);
        Object obj2 = settingsCache$updateConfigValue$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = settingsCache$updateConfigValue$1.label;
        if (i5 != 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSessionConfigs(Preferences preferences) {
        this.sessionConfigs = new SessionConfigs((Boolean) preferences.get(SESSIONS_ENABLED), (Double) preferences.get(SAMPLING_RATE), (Integer) preferences.get(RESTART_TIMEOUT_SECONDS), (Integer) preferences.get(CACHE_DURATION_SECONDS), (Long) preferences.get(CACHE_UPDATED_TIME));
    }

    public final boolean hasCacheExpired$com_google_firebase_firebase_sessions() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        SessionConfigs sessionConfigs2 = null;
        if (sessionConfigs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfigs");
            sessionConfigs = null;
        }
        Long cacheUpdatedTime = sessionConfigs.getCacheUpdatedTime();
        SessionConfigs sessionConfigs3 = this.sessionConfigs;
        if (sessionConfigs3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfigs");
        } else {
            sessionConfigs2 = sessionConfigs3;
        }
        Integer cacheDuration = sessionConfigs2.getCacheDuration();
        return cacheUpdatedTime == null || cacheDuration == null || (System.currentTimeMillis() - cacheUpdatedTime.longValue()) / ((long) Constants.ONE_SECOND) >= ((long) cacheDuration.intValue());
    }

    public final Integer sessionRestartTimeout() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        if (sessionConfigs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.getSessionRestartTimeout();
    }

    public final Double sessionSamplingRate() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        if (sessionConfigs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.getSessionSamplingRate();
    }

    public final Boolean sessionsEnabled() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        if (sessionConfigs == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.getSessionEnabled();
    }

    public final Object updateSamplingRate(Double d5, Continuation<? super Unit> continuation) {
        Object updateConfigValue = updateConfigValue(SAMPLING_RATE, d5, continuation);
        return updateConfigValue == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateConfigValue : Unit.INSTANCE;
    }

    public final Object updateSessionCacheDuration(Integer num, Continuation<? super Unit> continuation) {
        Object updateConfigValue = updateConfigValue(CACHE_DURATION_SECONDS, num, continuation);
        return updateConfigValue == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateConfigValue : Unit.INSTANCE;
    }

    public final Object updateSessionCacheUpdatedTime(Long l5, Continuation<? super Unit> continuation) {
        Object updateConfigValue = updateConfigValue(CACHE_UPDATED_TIME, l5, continuation);
        return updateConfigValue == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateConfigValue : Unit.INSTANCE;
    }

    public final Object updateSessionRestartTimeout(Integer num, Continuation<? super Unit> continuation) {
        Object updateConfigValue = updateConfigValue(RESTART_TIMEOUT_SECONDS, num, continuation);
        return updateConfigValue == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateConfigValue : Unit.INSTANCE;
    }

    public final Object updateSettingsEnabled(Boolean bool, Continuation<? super Unit> continuation) {
        Object updateConfigValue = updateConfigValue(SESSIONS_ENABLED, bool, continuation);
        return updateConfigValue == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateConfigValue : Unit.INSTANCE;
    }
}
