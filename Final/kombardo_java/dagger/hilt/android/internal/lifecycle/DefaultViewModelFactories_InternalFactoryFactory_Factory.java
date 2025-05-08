package dagger.hilt.android.internal.lifecycle;

import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.internal.Provider;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class DefaultViewModelFactories_InternalFactoryFactory_Factory implements Provider {
    public static DefaultViewModelFactories.InternalFactoryFactory newInstance(Map<Class<?>, Boolean> map, ViewModelComponentBuilder viewModelComponentBuilder) {
        return new DefaultViewModelFactories.InternalFactoryFactory(map, viewModelComponentBuilder);
    }
}
