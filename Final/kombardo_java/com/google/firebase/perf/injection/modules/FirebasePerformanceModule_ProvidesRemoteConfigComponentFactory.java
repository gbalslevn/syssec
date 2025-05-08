package com.google.firebase.perf.injection.modules;

import com.google.firebase.remoteconfig.RemoteConfigComponent;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* loaded from: classes2.dex */
public final class FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory implements Provider {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesRemoteConfigComponentFactory(firebasePerformanceModule);
    }

    public static com.google.firebase.inject.Provider<RemoteConfigComponent> providesRemoteConfigComponent(FirebasePerformanceModule firebasePerformanceModule) {
        return (com.google.firebase.inject.Provider) Preconditions.checkNotNullFromProvides(firebasePerformanceModule.providesRemoteConfigComponent());
    }

    @Override // javax.inject.Provider
    public com.google.firebase.inject.Provider<RemoteConfigComponent> get() {
        return providesRemoteConfigComponent(this.module);
    }
}
