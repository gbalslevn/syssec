package dk.molslinjen.ui.views.global.navigation;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.view.ComponentActivity;
import androidx.view.contextaware.OnContextAvailableListener;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.UnsafeCasts;

/* loaded from: classes2.dex */
public abstract class Hilt_MainActivity extends ComponentActivity implements GeneratedComponentManager {
    private volatile ActivityComponentManager componentManager;
    private final Object componentManagerLock = new Object();
    private boolean injected = false;
    private SavedStateHandleHolder savedStateHandleHolder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hilt_MainActivity() {
        _initHiltInternal();
    }

    private void _initHiltInternal() {
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: dk.molslinjen.ui.views.global.navigation.Hilt_MainActivity.1
            @Override // androidx.view.contextaware.OnContextAvailableListener
            public void onContextAvailable(Context context) {
                Hilt_MainActivity.this.inject();
            }
        });
    }

    private void initSavedStateHandleHolder() {
        if (getApplication() instanceof GeneratedComponentManager) {
            SavedStateHandleHolder savedStateHandleHolder = componentManager().getSavedStateHandleHolder();
            this.savedStateHandleHolder = savedStateHandleHolder;
            if (savedStateHandleHolder.isInvalid()) {
                this.savedStateHandleHolder.setExtras(getDefaultViewModelCreationExtras());
            }
        }
    }

    public final ActivityComponentManager componentManager() {
        if (this.componentManager == null) {
            synchronized (this.componentManagerLock) {
                try {
                    if (this.componentManager == null) {
                        this.componentManager = createComponentManager();
                    }
                } finally {
                }
            }
        }
        return this.componentManager;
    }

    protected ActivityComponentManager createComponentManager() {
        return new ActivityComponentManager(this);
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    @Override // androidx.view.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return DefaultViewModelFactories.getActivityFactory(this, super.getDefaultViewModelProviderFactory());
    }

    protected void inject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((MainActivity_GeneratedInjector) generatedComponent()).injectMainActivity((MainActivity) UnsafeCasts.unsafeCast(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initSavedStateHandleHolder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SavedStateHandleHolder savedStateHandleHolder = this.savedStateHandleHolder;
        if (savedStateHandleHolder != null) {
            savedStateHandleHolder.clear();
        }
    }
}
