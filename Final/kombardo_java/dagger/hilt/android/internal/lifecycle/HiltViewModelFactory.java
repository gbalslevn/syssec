package dagger.hilt.android.internal.lifecycle;

import android.app.Activity;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.lifecycle.RetainedLifecycleImpl;
import java.io.Closeable;
import java.util.Map;
import javax.inject.Provider;
import kotlin.jvm.functions.Function1;

/* loaded from: classes2.dex */
public final class HiltViewModelFactory implements ViewModelProvider.Factory {
    public static final CreationExtras.Key<Function1<Object, ViewModel>> CREATION_CALLBACK_KEY = new CreationExtras.Key<Function1<Object, ViewModel>>() { // from class: dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.1
    };
    private final ViewModelProvider.Factory delegateFactory;
    private final ViewModelProvider.Factory hiltViewModelFactory;
    private final Map<Class<?>, Boolean> hiltViewModelKeys;

    /* loaded from: classes2.dex */
    interface ActivityCreatorEntryPoint {
        ViewModelComponentBuilder getViewModelComponentBuilder();

        Map<Class<?>, Boolean> getViewModelKeys();
    }

    /* loaded from: classes2.dex */
    public interface ViewModelFactoriesEntryPoint {
        Map<Class<?>, Object> getHiltViewModelAssistedMap();

        Map<Class<?>, Provider<ViewModel>> getHiltViewModelMap();
    }

    public HiltViewModelFactory(Map<Class<?>, Boolean> map, ViewModelProvider.Factory factory, final ViewModelComponentBuilder viewModelComponentBuilder) {
        this.hiltViewModelKeys = map;
        this.delegateFactory = factory;
        this.hiltViewModelFactory = new ViewModelProvider.Factory() { // from class: dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.2
            private <T extends ViewModel> T createViewModel(ViewModelComponent viewModelComponent, Class<T> cls, CreationExtras creationExtras) {
                Provider<ViewModel> provider = ((ViewModelFactoriesEntryPoint) EntryPoints.get(viewModelComponent, ViewModelFactoriesEntryPoint.class)).getHiltViewModelMap().get(cls);
                Function1 function1 = (Function1) creationExtras.get(HiltViewModelFactory.CREATION_CALLBACK_KEY);
                Object obj = ((ViewModelFactoriesEntryPoint) EntryPoints.get(viewModelComponent, ViewModelFactoriesEntryPoint.class)).getHiltViewModelAssistedMap().get(cls);
                if (obj == null) {
                    if (function1 != null) {
                        throw new IllegalStateException("Found creation callback but class " + cls.getName() + " does not have an assisted factory specified in @HiltViewModel.");
                    }
                    if (provider != null) {
                        return (T) provider.get();
                    }
                    throw new IllegalStateException("Expected the @HiltViewModel-annotated class " + cls.getName() + " to be available in the multi-binding of @HiltViewModelMap but none was found.");
                }
                if (provider != null) {
                    throw new AssertionError("Found the @HiltViewModel-annotated class " + cls.getName() + " in both the multi-bindings of @HiltViewModelMap and @HiltViewModelAssistedMap.");
                }
                if (function1 != null) {
                    return (T) function1.invoke(obj);
                }
                throw new IllegalStateException("Found @HiltViewModel-annotated class " + cls.getName() + " using @AssistedInject but no creation callback was provided in CreationExtras.");
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
                final RetainedLifecycleImpl retainedLifecycleImpl = new RetainedLifecycleImpl();
                T t5 = (T) createViewModel(viewModelComponentBuilder.savedStateHandle(SavedStateHandleSupport.createSavedStateHandle(creationExtras)).viewModelLifecycle(retainedLifecycleImpl).build(), cls, creationExtras);
                t5.addCloseable(new Closeable() { // from class: l1.a
                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public final void close() {
                        RetainedLifecycleImpl.this.dispatchOnCleared();
                    }
                });
                return t5;
            }
        };
    }

    public static ViewModelProvider.Factory createInternal(Activity activity, ViewModelProvider.Factory factory) {
        ActivityCreatorEntryPoint activityCreatorEntryPoint = (ActivityCreatorEntryPoint) EntryPoints.get(activity, ActivityCreatorEntryPoint.class);
        return new HiltViewModelFactory(activityCreatorEntryPoint.getViewModelKeys(), factory, activityCreatorEntryPoint.getViewModelComponentBuilder());
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        if (this.hiltViewModelKeys.containsKey(cls)) {
            return (T) this.hiltViewModelFactory.create(cls, creationExtras);
        }
        return (T) this.delegateFactory.create(cls, creationExtras);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        if (this.hiltViewModelKeys.containsKey(cls)) {
            return (T) this.hiltViewModelFactory.create(cls);
        }
        return (T) this.delegateFactory.create(cls);
    }
}
