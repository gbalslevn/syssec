package com.google.firebase.perf;

import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.StartupTime;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.FirebasePerfEarly;
import com.google.firebase.perf.FirebasePerfRegistrar;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.injection.components.DaggerFirebasePerformanceComponent;
import com.google.firebase.perf.injection.modules.FirebasePerformanceModule;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

@Keep
/* loaded from: classes2.dex */
public class FirebasePerfRegistrar implements ComponentRegistrar {
    private static final String EARLY_LIBRARY_NAME = "fire-perf-early";
    private static final String LIBRARY_NAME = "fire-perf";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FirebasePerfEarly lambda$getComponents$0(Qualified qualified, ComponentContainer componentContainer) {
        return new FirebasePerfEarly((FirebaseApp) componentContainer.get(FirebaseApp.class), (StartupTime) componentContainer.getProvider(StartupTime.class).get(), (Executor) componentContainer.get(qualified));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FirebasePerformance providesFirebasePerformance(ComponentContainer componentContainer) {
        componentContainer.get(FirebasePerfEarly.class);
        return DaggerFirebasePerformanceComponent.builder().firebasePerformanceModule(new FirebasePerformanceModule((FirebaseApp) componentContainer.get(FirebaseApp.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), componentContainer.getProvider(RemoteConfigComponent.class), componentContainer.getProvider(TransportFactory.class))).build().getFirebasePerformance();
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<Component<?>> getComponents() {
        final Qualified qualified = Qualified.qualified(UiThread.class, Executor.class);
        return Arrays.asList(Component.builder(FirebasePerformance.class).name(LIBRARY_NAME).add(Dependency.required((Class<?>) FirebaseApp.class)).add(Dependency.requiredProvider((Class<?>) RemoteConfigComponent.class)).add(Dependency.required((Class<?>) FirebaseInstallationsApi.class)).add(Dependency.requiredProvider((Class<?>) TransportFactory.class)).add(Dependency.required((Class<?>) FirebasePerfEarly.class)).factory(new ComponentFactory() { // from class: S0.a
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                FirebasePerformance providesFirebasePerformance;
                providesFirebasePerformance = FirebasePerfRegistrar.providesFirebasePerformance(componentContainer);
                return providesFirebasePerformance;
            }
        }).build(), Component.builder(FirebasePerfEarly.class).name(EARLY_LIBRARY_NAME).add(Dependency.required((Class<?>) FirebaseApp.class)).add(Dependency.optionalProvider((Class<?>) StartupTime.class)).add(Dependency.required((Qualified<?>) qualified)).eagerInDefaultApp().factory(new ComponentFactory() { // from class: S0.b
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                FirebasePerfEarly lambda$getComponents$0;
                lambda$getComponents$0 = FirebasePerfRegistrar.lambda$getComponents$0(Qualified.this, componentContainer);
                return lambda$getComponents$0;
            }
        }).build(), LibraryVersionComponent.create(LIBRARY_NAME, "21.0.4"));
    }
}
