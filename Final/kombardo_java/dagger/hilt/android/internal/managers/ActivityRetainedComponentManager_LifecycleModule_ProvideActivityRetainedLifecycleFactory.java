package dagger.hilt.android.internal.managers;

import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* loaded from: classes2.dex */
public abstract class ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory implements Provider {
    public static ActivityRetainedLifecycle provideActivityRetainedLifecycle() {
        return (ActivityRetainedLifecycle) Preconditions.checkNotNullFromProvides(ActivityRetainedComponentManager.LifecycleModule.provideActivityRetainedLifecycle());
    }
}
