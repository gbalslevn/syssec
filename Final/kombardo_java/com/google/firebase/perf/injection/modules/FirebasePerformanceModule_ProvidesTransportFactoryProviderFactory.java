package com.google.firebase.perf.injection.modules;

import com.google.android.datatransport.TransportFactory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* loaded from: classes2.dex */
public final class FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory implements Provider {
    private final FirebasePerformanceModule module;

    public FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    public static FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory(firebasePerformanceModule);
    }

    public static com.google.firebase.inject.Provider<TransportFactory> providesTransportFactoryProvider(FirebasePerformanceModule firebasePerformanceModule) {
        return (com.google.firebase.inject.Provider) Preconditions.checkNotNullFromProvides(firebasePerformanceModule.providesTransportFactoryProvider());
    }

    @Override // javax.inject.Provider
    public com.google.firebase.inject.Provider<TransportFactory> get() {
        return providesTransportFactoryProvider(this.module);
    }
}
