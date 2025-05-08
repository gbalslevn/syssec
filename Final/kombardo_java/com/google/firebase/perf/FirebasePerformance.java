package com.google.firebase.perf;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.logging.ConsoleUrlGenerator;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.ImmutableBundle;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class FirebasePerformance {
    private static final int MAX_ATTRIBUTE_KEY_LENGTH = 40;
    private static final int MAX_ATTRIBUTE_VALUE_LENGTH = 100;
    private static final int MAX_TRACE_CUSTOM_ATTRIBUTES = 5;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final ConfigResolver configResolver;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final Provider<RemoteConfigComponent> firebaseRemoteConfigProvider;
    private final Map<String, String> mCustomAttributes = new ConcurrentHashMap();
    private final ImmutableBundle mMetadataBundle;
    private Boolean mPerformanceCollectionForceEnabledState;
    private final Provider<TransportFactory> transportFactoryProvider;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebasePerformance(FirebaseApp firebaseApp, Provider<RemoteConfigComponent> provider, FirebaseInstallationsApi firebaseInstallationsApi, Provider<TransportFactory> provider2, RemoteConfigManager remoteConfigManager, ConfigResolver configResolver, SessionManager sessionManager) {
        this.mPerformanceCollectionForceEnabledState = null;
        this.firebaseApp = firebaseApp;
        this.firebaseRemoteConfigProvider = provider;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.transportFactoryProvider = provider2;
        if (firebaseApp == null) {
            this.mPerformanceCollectionForceEnabledState = Boolean.FALSE;
            this.configResolver = configResolver;
            this.mMetadataBundle = new ImmutableBundle(new Bundle());
            return;
        }
        TransportManager.getInstance().initialize(firebaseApp, firebaseInstallationsApi, provider2);
        Context applicationContext = firebaseApp.getApplicationContext();
        ImmutableBundle extractMetadata = extractMetadata(applicationContext);
        this.mMetadataBundle = extractMetadata;
        remoteConfigManager.setFirebaseRemoteConfigProvider(provider);
        this.configResolver = configResolver;
        configResolver.setMetadataBundle(extractMetadata);
        configResolver.setApplicationContext(applicationContext);
        sessionManager.setApplicationContext(applicationContext);
        this.mPerformanceCollectionForceEnabledState = configResolver.getIsPerformanceCollectionEnabled();
        AndroidLogger androidLogger = logger;
        if (androidLogger.isLogcatEnabled() && isPerformanceCollectionEnabled()) {
            androidLogger.info(String.format("Firebase Performance Monitoring is successfully initialized! In a minute, visit the Firebase console to view your data: %s", ConsoleUrlGenerator.generateDashboardUrl(firebaseApp.getOptions().getProjectId(), applicationContext.getPackageName())));
        }
    }

    private static ImmutableBundle extractMetadata(Context context) {
        Bundle bundle;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e5) {
            Log.d("isEnabled", "No perf enable meta data found " + e5.getMessage());
            bundle = null;
        }
        return bundle != null ? new ImmutableBundle(bundle) : new ImmutableBundle();
    }

    public static FirebasePerformance getInstance() {
        return (FirebasePerformance) FirebaseApp.getInstance().get(FirebasePerformance.class);
    }

    public Map<String, String> getAttributes() {
        return new HashMap(this.mCustomAttributes);
    }

    public boolean isPerformanceCollectionEnabled() {
        Boolean bool = this.mPerformanceCollectionForceEnabledState;
        return bool != null ? bool.booleanValue() : FirebaseApp.getInstance().isDataCollectionDefaultEnabled();
    }
}
