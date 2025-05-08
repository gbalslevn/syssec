package com.google.firebase.perf;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import dagger.internal.Provider;

/* loaded from: classes2.dex */
public final class FirebasePerformance_Factory implements Provider {
    private final javax.inject.Provider<ConfigResolver> configResolverProvider;
    private final javax.inject.Provider<FirebaseApp> firebaseAppProvider;
    private final javax.inject.Provider<FirebaseInstallationsApi> firebaseInstallationsApiProvider;
    private final javax.inject.Provider<com.google.firebase.inject.Provider<RemoteConfigComponent>> firebaseRemoteConfigProvider;
    private final javax.inject.Provider<RemoteConfigManager> remoteConfigManagerProvider;
    private final javax.inject.Provider<SessionManager> sessionManagerProvider;
    private final javax.inject.Provider<com.google.firebase.inject.Provider<TransportFactory>> transportFactoryProvider;

    public FirebasePerformance_Factory(javax.inject.Provider<FirebaseApp> provider, javax.inject.Provider<com.google.firebase.inject.Provider<RemoteConfigComponent>> provider2, javax.inject.Provider<FirebaseInstallationsApi> provider3, javax.inject.Provider<com.google.firebase.inject.Provider<TransportFactory>> provider4, javax.inject.Provider<RemoteConfigManager> provider5, javax.inject.Provider<ConfigResolver> provider6, javax.inject.Provider<SessionManager> provider7) {
        this.firebaseAppProvider = provider;
        this.firebaseRemoteConfigProvider = provider2;
        this.firebaseInstallationsApiProvider = provider3;
        this.transportFactoryProvider = provider4;
        this.remoteConfigManagerProvider = provider5;
        this.configResolverProvider = provider6;
        this.sessionManagerProvider = provider7;
    }

    public static FirebasePerformance_Factory create(javax.inject.Provider<FirebaseApp> provider, javax.inject.Provider<com.google.firebase.inject.Provider<RemoteConfigComponent>> provider2, javax.inject.Provider<FirebaseInstallationsApi> provider3, javax.inject.Provider<com.google.firebase.inject.Provider<TransportFactory>> provider4, javax.inject.Provider<RemoteConfigManager> provider5, javax.inject.Provider<ConfigResolver> provider6, javax.inject.Provider<SessionManager> provider7) {
        return new FirebasePerformance_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static FirebasePerformance newInstance(FirebaseApp firebaseApp, com.google.firebase.inject.Provider<RemoteConfigComponent> provider, FirebaseInstallationsApi firebaseInstallationsApi, com.google.firebase.inject.Provider<TransportFactory> provider2, RemoteConfigManager remoteConfigManager, ConfigResolver configResolver, SessionManager sessionManager) {
        return new FirebasePerformance(firebaseApp, provider, firebaseInstallationsApi, provider2, remoteConfigManager, configResolver, sessionManager);
    }

    @Override // javax.inject.Provider
    public FirebasePerformance get() {
        return newInstance(this.firebaseAppProvider.get(), this.firebaseRemoteConfigProvider.get(), this.firebaseInstallationsApiProvider.get(), this.transportFactoryProvider.get(), this.remoteConfigManagerProvider.get(), this.configResolverProvider.get(), this.sessionManagerProvider.get());
    }
}
