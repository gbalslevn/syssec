package com.google.firebase.perf.injection.modules;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;

/* loaded from: classes2.dex */
public class FirebasePerformanceModule {
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Provider<RemoteConfigComponent> remoteConfigComponentProvider;
    private final Provider<TransportFactory> transportFactoryProvider;

    public FirebasePerformanceModule(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Provider<RemoteConfigComponent> provider, Provider<TransportFactory> provider2) {
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.remoteConfigComponentProvider = provider;
        this.transportFactoryProvider = provider2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConfigResolver providesConfigResolver() {
        return ConfigResolver.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseApp providesFirebaseApp() {
        return this.firebaseApp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseInstallationsApi providesFirebaseInstallations() {
        return this.firebaseInstallations;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Provider<RemoteConfigComponent> providesRemoteConfigComponent() {
        return this.remoteConfigComponentProvider;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteConfigManager providesRemoteConfigManager() {
        return RemoteConfigManager.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionManager providesSessionManager() {
        return SessionManager.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Provider<TransportFactory> providesTransportFactoryProvider() {
        return this.transportFactoryProvider;
    }
}
