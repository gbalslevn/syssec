package com.google.firebase.perf.injection.modules;

import com.google.firebase.FirebaseApp;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* loaded from: classes2.dex */
public final class FirebasePerformanceModule_ProvidesFirebaseAppFactory implements Provider {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesFirebaseAppFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesFirebaseAppFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesFirebaseAppFactory(firebasePerformanceModule);
    }

    public static FirebaseApp providesFirebaseApp(FirebasePerformanceModule firebasePerformanceModule) {
        return (FirebaseApp) Preconditions.checkNotNullFromProvides(firebasePerformanceModule.providesFirebaseApp());
    }

    @Override // javax.inject.Provider
    public FirebaseApp get() {
        return providesFirebaseApp(this.module);
    }
}
