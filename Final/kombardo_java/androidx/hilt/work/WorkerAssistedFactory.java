package androidx.hilt.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;

/* loaded from: classes.dex */
public interface WorkerAssistedFactory<T extends ListenableWorker> {
    T create(Context context, WorkerParameters workerParameters);
}
