package androidx.arch.core.executor;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class ArchTaskExecutor extends TaskExecutor {
    private static volatile ArchTaskExecutor sInstance;
    private final TaskExecutor mDefaultTaskExecutor;
    private TaskExecutor mDelegate;
    private static final Executor sMainThreadExecutor = new Executor() { // from class: c.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            ArchTaskExecutor.lambda$static$0(runnable);
        }
    };
    private static final Executor sIOThreadExecutor = new Executor() { // from class: c.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            ArchTaskExecutor.lambda$static$1(runnable);
        }
    };

    private ArchTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.mDefaultTaskExecutor = defaultTaskExecutor;
        this.mDelegate = defaultTaskExecutor;
    }

    public static Executor getIOThreadExecutor() {
        return sIOThreadExecutor;
    }

    public static ArchTaskExecutor getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (ArchTaskExecutor.class) {
            try {
                if (sInstance == null) {
                    sInstance = new ArchTaskExecutor();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Runnable runnable) {
        getInstance().postToMainThread(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$1(Runnable runnable) {
        getInstance().executeOnDiskIO(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(Runnable runnable) {
        this.mDelegate.executeOnDiskIO(runnable);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(Runnable runnable) {
        this.mDelegate.postToMainThread(runnable);
    }
}
