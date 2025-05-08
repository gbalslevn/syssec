package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.config.RemoteConfigManager;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* loaded from: classes2.dex */
public final class FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory implements Provider {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesRemoteConfigManagerFactory(firebasePerformanceModule);
    }

    public static RemoteConfigManager providesRemoteConfigManager(FirebasePerformanceModule firebasePerformanceModule) {
        return (RemoteConfigManager) Preconditions.checkNotNullFromProvides(firebasePerformanceModule.providesRemoteConfigManager());
    }

    @Override // javax.inject.Provider
    public RemoteConfigManager get() {
        return providesRemoteConfigManager(this.module);
    }
}
