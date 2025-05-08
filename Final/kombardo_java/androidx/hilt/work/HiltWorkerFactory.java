package androidx.hilt.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerFactory;
import androidx.work.WorkerParameters;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class HiltWorkerFactory extends WorkerFactory {
    private final Map<String, Provider<WorkerAssistedFactory<? extends ListenableWorker>>> mWorkerFactories;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HiltWorkerFactory(Map<String, Provider<WorkerAssistedFactory<? extends ListenableWorker>>> map) {
        this.mWorkerFactories = map;
    }

    @Override // androidx.work.WorkerFactory
    public ListenableWorker createWorker(Context context, String str, WorkerParameters workerParameters) {
        Provider<WorkerAssistedFactory<? extends ListenableWorker>> provider = this.mWorkerFactories.get(str);
        if (provider == null) {
            return null;
        }
        return provider.get().create(context, workerParameters);
    }
}
