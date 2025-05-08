package dagger.hilt.android.internal.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.view.ComponentActivity;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.internal.Preconditions;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class DefaultViewModelFactories {

    /* loaded from: classes2.dex */
    public interface ActivityEntryPoint {
        InternalFactoryFactory getHiltInternalFactoryFactory();
    }

    /* loaded from: classes2.dex */
    public static final class InternalFactoryFactory {
        private final Map<Class<?>, Boolean> keySet;
        private final ViewModelComponentBuilder viewModelComponentBuilder;

        /* JADX INFO: Access modifiers changed from: package-private */
        public InternalFactoryFactory(Map<Class<?>, Boolean> map, ViewModelComponentBuilder viewModelComponentBuilder) {
            this.keySet = map;
            this.viewModelComponentBuilder = viewModelComponentBuilder;
        }

        private ViewModelProvider.Factory getHiltViewModelFactory(ViewModelProvider.Factory factory) {
            return new HiltViewModelFactory(this.keySet, (ViewModelProvider.Factory) Preconditions.checkNotNull(factory), this.viewModelComponentBuilder);
        }

        ViewModelProvider.Factory fromActivity(ComponentActivity componentActivity, ViewModelProvider.Factory factory) {
            return getHiltViewModelFactory(factory);
        }
    }

    public static ViewModelProvider.Factory getActivityFactory(ComponentActivity componentActivity, ViewModelProvider.Factory factory) {
        return ((ActivityEntryPoint) EntryPoints.get(componentActivity, ActivityEntryPoint.class)).getHiltInternalFactoryFactory().fromActivity(componentActivity, factory);
    }
}
