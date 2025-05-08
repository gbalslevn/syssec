package dk.molslinjen;

import android.app.Application;
import dagger.hilt.android.internal.managers.ApplicationComponentManager;
import dagger.hilt.android.internal.managers.ComponentSupplier;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.UnsafeCasts;

/* loaded from: classes2.dex */
public abstract class Hilt_App extends Application implements GeneratedComponentManager {
    private boolean injected = false;
    private final ApplicationComponentManager componentManager = new ApplicationComponentManager(new ComponentSupplier() { // from class: dk.molslinjen.Hilt_App.1
        @Override // dagger.hilt.android.internal.managers.ComponentSupplier
        public Object get() {
            return DaggerApp_HiltComponents_SingletonC.builder().applicationContextModule(new ApplicationContextModule(Hilt_App.this)).build();
        }
    });

    public final ApplicationComponentManager componentManager() {
        return this.componentManager;
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    protected void hiltInternalInject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((App_GeneratedInjector) generatedComponent()).injectApp((App) UnsafeCasts.unsafeCast(this));
    }

    @Override // android.app.Application
    public void onCreate() {
        hiltInternalInject();
        super.onCreate();
    }
}
