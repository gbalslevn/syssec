package androidx.hilt.work;

import androidx.work.ListenableWorker;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class WorkerFactoryModule_ProvideFactoryFactory implements Provider {
    public static HiltWorkerFactory provideFactory(Map<String, javax.inject.Provider<WorkerAssistedFactory<? extends ListenableWorker>>> map) {
        return (HiltWorkerFactory) Preconditions.checkNotNullFromProvides(WorkerFactoryModule.provideFactory(map));
    }
}
