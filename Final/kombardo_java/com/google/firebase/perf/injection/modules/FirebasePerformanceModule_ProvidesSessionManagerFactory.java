package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.session.SessionManager;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* loaded from: classes2.dex */
public final class FirebasePerformanceModule_ProvidesSessionManagerFactory implements Provider {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesSessionManagerFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesSessionManagerFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesSessionManagerFactory(firebasePerformanceModule);
    }

    public static SessionManager providesSessionManager(FirebasePerformanceModule firebasePerformanceModule) {
        return (SessionManager) Preconditions.checkNotNullFromProvides(firebasePerformanceModule.providesSessionManager());
    }

    @Override // javax.inject.Provider
    public SessionManager get() {
        return providesSessionManager(this.module);
    }
}
