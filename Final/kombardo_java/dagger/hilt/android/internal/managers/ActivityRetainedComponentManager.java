package dagger.hilt.android.internal.managers;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.view.ComponentActivity;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.EntryPointAccessors;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.lifecycle.RetainedLifecycleImpl;
import dagger.hilt.internal.GeneratedComponentManager;

/* loaded from: classes2.dex */
final class ActivityRetainedComponentManager implements GeneratedComponentManager<ActivityRetainedComponent> {
    private volatile ActivityRetainedComponent component;
    private final Object componentLock = new Object();
    private final Context context;
    private final ViewModelStoreOwner viewModelStoreOwner;

    /* loaded from: classes2.dex */
    public interface ActivityRetainedComponentBuilderEntryPoint {
        ActivityRetainedComponentBuilder retainedComponentBuilder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class ActivityRetainedComponentViewModel extends ViewModel {
        private final ActivityRetainedComponent component;
        private final SavedStateHandleHolder savedStateHandleHolder;

        ActivityRetainedComponentViewModel(ActivityRetainedComponent activityRetainedComponent, SavedStateHandleHolder savedStateHandleHolder) {
            this.component = activityRetainedComponent;
            this.savedStateHandleHolder = savedStateHandleHolder;
        }

        ActivityRetainedComponent getComponent() {
            return this.component;
        }

        SavedStateHandleHolder getSavedStateHandleHolder() {
            return this.savedStateHandleHolder;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.ViewModel
        public void onCleared() {
            super.onCleared();
            ((RetainedLifecycleImpl) ((ActivityRetainedLifecycleEntryPoint) EntryPoints.get(this.component, ActivityRetainedLifecycleEntryPoint.class)).getActivityRetainedLifecycle()).dispatchOnCleared();
        }
    }

    /* loaded from: classes2.dex */
    public interface ActivityRetainedLifecycleEntryPoint {
        ActivityRetainedLifecycle getActivityRetainedLifecycle();
    }

    /* loaded from: classes2.dex */
    static abstract class LifecycleModule {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static ActivityRetainedLifecycle provideActivityRetainedLifecycle() {
            return new RetainedLifecycleImpl();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityRetainedComponentManager(ComponentActivity componentActivity) {
        this.viewModelStoreOwner = componentActivity;
        this.context = componentActivity;
    }

    private ActivityRetainedComponent createComponent() {
        return ((ActivityRetainedComponentViewModel) getViewModelProvider(this.viewModelStoreOwner, this.context).get(ActivityRetainedComponentViewModel.class)).getComponent();
    }

    private ViewModelProvider getViewModelProvider(ViewModelStoreOwner viewModelStoreOwner, final Context context) {
        return new ViewModelProvider(viewModelStoreOwner, new ViewModelProvider.Factory() { // from class: dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.1
            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
                SavedStateHandleHolder savedStateHandleHolder = new SavedStateHandleHolder(creationExtras);
                return new ActivityRetainedComponentViewModel(((ActivityRetainedComponentBuilderEntryPoint) EntryPointAccessors.fromApplication(context, ActivityRetainedComponentBuilderEntryPoint.class)).retainedComponentBuilder().savedStateHandleHolder(savedStateHandleHolder).build(), savedStateHandleHolder);
            }
        });
    }

    public SavedStateHandleHolder getSavedStateHandleHolder() {
        return ((ActivityRetainedComponentViewModel) getViewModelProvider(this.viewModelStoreOwner, this.context).get(ActivityRetainedComponentViewModel.class)).getSavedStateHandleHolder();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // dagger.hilt.internal.GeneratedComponentManager
    public ActivityRetainedComponent generatedComponent() {
        if (this.component == null) {
            synchronized (this.componentLock) {
                try {
                    if (this.component == null) {
                        this.component = createComponent();
                    }
                } finally {
                }
            }
        }
        return this.component;
    }
}
