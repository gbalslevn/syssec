package androidx.hilt.work;

import androidx.work.ListenableWorker;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
abstract class WorkerFactoryModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static HiltWorkerFactory provideFactory(Map<String, Provider<WorkerAssistedFactory<? extends ListenableWorker>>> map) {
        return new HiltWorkerFactory(map);
    }
}
