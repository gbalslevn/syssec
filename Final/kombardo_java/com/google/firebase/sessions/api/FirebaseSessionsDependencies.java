package com.google.firebase.sessions.api;

import android.util.Log;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u0010H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019RT\u0010\u001c\u001aB\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\r0\r \u001b* \u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\r0\r\u0018\u00010\u00100\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies;", BuildConfig.FLAVOR, "<init>", "()V", "Lcom/google/firebase/sessions/api/SessionSubscriber$Name;", "subscriberName", BuildConfig.FLAVOR, "addDependency", "(Lcom/google/firebase/sessions/api/SessionSubscriber$Name;)V", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "subscriber", "register", "(Lcom/google/firebase/sessions/api/SessionSubscriber;)V", "Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies$Dependency;", "getDependency", "(Lcom/google/firebase/sessions/api/SessionSubscriber$Name;)Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies$Dependency;", BuildConfig.FLAVOR, "getRegisteredSubscribers$com_google_firebase_firebase_sessions", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRegisteredSubscribers", "getSubscriber$com_google_firebase_firebase_sessions", "(Lcom/google/firebase/sessions/api/SessionSubscriber$Name;)Lcom/google/firebase/sessions/api/SessionSubscriber;", "getSubscriber", BuildConfig.FLAVOR, "TAG", "Ljava/lang/String;", BuildConfig.FLAVOR, "kotlin.jvm.PlatformType", "dependencies", "Ljava/util/Map;", "Dependency", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FirebaseSessionsDependencies {
    private static final String TAG = "SessionsDependencies";
    public static final FirebaseSessionsDependencies INSTANCE = new FirebaseSessionsDependencies();
    private static final Map<SessionSubscriber.Name, Dependency> dependencies = Collections.synchronizedMap(new LinkedHashMap());

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/google/firebase/sessions/api/FirebaseSessionsDependencies$Dependency;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "subscriber", "<init>", "(Lkotlinx/coroutines/sync/Mutex;Lcom/google/firebase/sessions/api/SessionSubscriber;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/sync/Mutex;", "getMutex", "()Lkotlinx/coroutines/sync/Mutex;", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "getSubscriber", "()Lcom/google/firebase/sessions/api/SessionSubscriber;", "setSubscriber", "(Lcom/google/firebase/sessions/api/SessionSubscriber;)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Dependency {
        private final Mutex mutex;
        private SessionSubscriber subscriber;

        public Dependency(Mutex mutex, SessionSubscriber sessionSubscriber) {
            Intrinsics.checkNotNullParameter(mutex, "mutex");
            this.mutex = mutex;
            this.subscriber = sessionSubscriber;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Dependency)) {
                return false;
            }
            Dependency dependency = (Dependency) other;
            return Intrinsics.areEqual(this.mutex, dependency.mutex) && Intrinsics.areEqual(this.subscriber, dependency.subscriber);
        }

        public final Mutex getMutex() {
            return this.mutex;
        }

        public final SessionSubscriber getSubscriber() {
            return this.subscriber;
        }

        public int hashCode() {
            int hashCode = this.mutex.hashCode() * 31;
            SessionSubscriber sessionSubscriber = this.subscriber;
            return hashCode + (sessionSubscriber == null ? 0 : sessionSubscriber.hashCode());
        }

        public final void setSubscriber(SessionSubscriber sessionSubscriber) {
            this.subscriber = sessionSubscriber;
        }

        public String toString() {
            return "Dependency(mutex=" + this.mutex + ", subscriber=" + this.subscriber + ')';
        }

        public /* synthetic */ Dependency(Mutex mutex, SessionSubscriber sessionSubscriber, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(mutex, (i5 & 2) != 0 ? null : sessionSubscriber);
        }
    }

    private FirebaseSessionsDependencies() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void addDependency(SessionSubscriber.Name subscriberName) {
        Intrinsics.checkNotNullParameter(subscriberName, "subscriberName");
        if (subscriberName == SessionSubscriber.Name.PERFORMANCE) {
            throw new IllegalArgumentException("Incompatible versions of Firebase Perf and Firebase Sessions.\nA safe combination would be:\n  firebase-sessions:1.1.0\n  firebase-crashlytics:18.5.0\n  firebase-perf:20.5.0\nFor more information contact Firebase Support.");
        }
        Map<SessionSubscriber.Name, Dependency> dependencies2 = dependencies;
        if (dependencies2.containsKey(subscriberName)) {
            Log.d(TAG, "Dependency " + subscriberName + " already added.");
            return;
        }
        Intrinsics.checkNotNullExpressionValue(dependencies2, "dependencies");
        dependencies2.put(subscriberName, new Dependency(MutexKt.Mutex(true), null, 2, 0 == true ? 1 : 0));
        Log.d(TAG, "Dependency to " + subscriberName + " added.");
    }

    private final Dependency getDependency(SessionSubscriber.Name subscriberName) {
        Map<SessionSubscriber.Name, Dependency> dependencies2 = dependencies;
        Intrinsics.checkNotNullExpressionValue(dependencies2, "dependencies");
        Dependency dependency = dependencies2.get(subscriberName);
        if (dependency != null) {
            Intrinsics.checkNotNullExpressionValue(dependency, "dependencies.getOrElse(s…load time.\"\n      )\n    }");
            return dependency;
        }
        throw new IllegalStateException("Cannot get dependency " + subscriberName + ". Dependencies should be added at class load time.");
    }

    public static final void register(SessionSubscriber subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        SessionSubscriber.Name sessionSubscriberName = subscriber.getSessionSubscriberName();
        Dependency dependency = INSTANCE.getDependency(sessionSubscriberName);
        if (dependency.getSubscriber() != null) {
            Log.d(TAG, "Subscriber " + sessionSubscriberName + " already registered.");
            return;
        }
        dependency.setSubscriber(subscriber);
        Log.d(TAG, "Subscriber " + sessionSubscriberName + " registered.");
        Mutex.DefaultImpls.unlock$default(dependency.getMutex(), null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00a1 -> B:10:0x00a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getRegisteredSubscribers$com_google_firebase_firebase_sessions(Continuation<? super Map<SessionSubscriber.Name, ? extends SessionSubscriber>> continuation) {
        FirebaseSessionsDependencies$getRegisteredSubscribers$1 firebaseSessionsDependencies$getRegisteredSubscribers$1;
        int i5;
        Iterator it;
        Map map;
        if (continuation instanceof FirebaseSessionsDependencies$getRegisteredSubscribers$1) {
            firebaseSessionsDependencies$getRegisteredSubscribers$1 = (FirebaseSessionsDependencies$getRegisteredSubscribers$1) continuation;
            int i6 = firebaseSessionsDependencies$getRegisteredSubscribers$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                firebaseSessionsDependencies$getRegisteredSubscribers$1.label = i6 - Integer.MIN_VALUE;
                Object obj = firebaseSessionsDependencies$getRegisteredSubscribers$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = firebaseSessionsDependencies$getRegisteredSubscribers$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Map<SessionSubscriber.Name, Dependency> dependencies2 = dependencies;
                    Intrinsics.checkNotNullExpressionValue(dependencies2, "dependencies");
                    LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(dependencies2.size()));
                    it = dependencies2.entrySet().iterator();
                    map = linkedHashMap;
                    if (it.hasNext()) {
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Object key = firebaseSessionsDependencies$getRegisteredSubscribers$1.L$5;
                    map = (Map) firebaseSessionsDependencies$getRegisteredSubscribers$1.L$4;
                    Mutex mutex = (Mutex) firebaseSessionsDependencies$getRegisteredSubscribers$1.L$3;
                    SessionSubscriber.Name name = (SessionSubscriber.Name) firebaseSessionsDependencies$getRegisteredSubscribers$1.L$2;
                    it = (Iterator) firebaseSessionsDependencies$getRegisteredSubscribers$1.L$1;
                    Map map2 = (Map) firebaseSessionsDependencies$getRegisteredSubscribers$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    try {
                        SessionSubscriber subscriber$com_google_firebase_firebase_sessions = INSTANCE.getSubscriber$com_google_firebase_firebase_sessions(name);
                        mutex.unlock(null);
                        map.put(key, subscriber$com_google_firebase_firebase_sessions);
                        map = map2;
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            key = entry.getKey();
                            name = (SessionSubscriber.Name) entry.getKey();
                            mutex = ((Dependency) entry.getValue()).getMutex();
                            firebaseSessionsDependencies$getRegisteredSubscribers$1.L$0 = map;
                            firebaseSessionsDependencies$getRegisteredSubscribers$1.L$1 = it;
                            firebaseSessionsDependencies$getRegisteredSubscribers$1.L$2 = name;
                            firebaseSessionsDependencies$getRegisteredSubscribers$1.L$3 = mutex;
                            firebaseSessionsDependencies$getRegisteredSubscribers$1.L$4 = map;
                            firebaseSessionsDependencies$getRegisteredSubscribers$1.L$5 = key;
                            firebaseSessionsDependencies$getRegisteredSubscribers$1.label = 1;
                            if (mutex.lock(null, firebaseSessionsDependencies$getRegisteredSubscribers$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            map2 = map;
                            SessionSubscriber subscriber$com_google_firebase_firebase_sessions2 = INSTANCE.getSubscriber$com_google_firebase_firebase_sessions(name);
                            mutex.unlock(null);
                            map.put(key, subscriber$com_google_firebase_firebase_sessions2);
                            map = map2;
                            if (it.hasNext()) {
                                return map;
                            }
                        }
                    } catch (Throwable th) {
                        mutex.unlock(null);
                        throw th;
                    }
                }
            }
        }
        firebaseSessionsDependencies$getRegisteredSubscribers$1 = new FirebaseSessionsDependencies$getRegisteredSubscribers$1(this, continuation);
        Object obj2 = firebaseSessionsDependencies$getRegisteredSubscribers$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = firebaseSessionsDependencies$getRegisteredSubscribers$1.label;
        if (i5 != 0) {
        }
    }

    public final SessionSubscriber getSubscriber$com_google_firebase_firebase_sessions(SessionSubscriber.Name subscriberName) {
        Intrinsics.checkNotNullParameter(subscriberName, "subscriberName");
        SessionSubscriber subscriber = getDependency(subscriberName).getSubscriber();
        if (subscriber != null) {
            return subscriber;
        }
        throw new IllegalStateException("Subscriber " + subscriberName + " has not been registered.");
    }
}
