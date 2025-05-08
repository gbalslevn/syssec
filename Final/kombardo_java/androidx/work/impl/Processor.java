package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public class Processor implements ForegroundProcessor {
    private static final String FOREGROUND_WAKELOCK_TAG = "ProcessorForegroundLck";
    private static final String TAG = Logger.tagWithPrefix("Processor");
    private Context mAppContext;
    private Configuration mConfiguration;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;
    private Map<String, WorkerWrapper> mEnqueuedWorkMap = new HashMap();
    private Map<String, WorkerWrapper> mForegroundWorkMap = new HashMap();
    private Set<String> mCancelledIds = new HashSet();
    private final List<ExecutionListener> mOuterListeners = new ArrayList();
    private PowerManager.WakeLock mForegroundLock = null;
    private final Object mLock = new Object();
    private Map<String, Set<StartStopToken>> mWorkRuns = new HashMap();

    public Processor(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase) {
        this.mAppContext = context;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = workDatabase;
    }

    private WorkerWrapper cleanUpWorkerUnsafe(String str) {
        WorkerWrapper remove = this.mForegroundWorkMap.remove(str);
        boolean z5 = remove != null;
        if (!z5) {
            remove = this.mEnqueuedWorkMap.remove(str);
        }
        this.mWorkRuns.remove(str);
        if (z5) {
            stopForegroundService();
        }
        return remove;
    }

    private WorkerWrapper getWorkerWrapperUnsafe(String str) {
        WorkerWrapper workerWrapper = this.mForegroundWorkMap.get(str);
        return workerWrapper == null ? this.mEnqueuedWorkMap.get(str) : workerWrapper;
    }

    private static boolean interrupt(String str, WorkerWrapper workerWrapper, int i5) {
        if (workerWrapper == null) {
            Logger.get().debug(TAG, "WorkerWrapper could not be found for " + str);
            return false;
        }
        workerWrapper.interrupt(i5);
        Logger.get().debug(TAG, "WorkerWrapper interrupted for " + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runOnExecuted$2(WorkGenerationalId workGenerationalId, boolean z5) {
        synchronized (this.mLock) {
            try {
                Iterator<ExecutionListener> it = this.mOuterListeners.iterator();
                while (it.hasNext()) {
                    it.next().onExecuted(workGenerationalId, z5);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WorkSpec lambda$startWork$0(ArrayList arrayList, String str) {
        arrayList.addAll(this.mWorkDatabase.workTagDao().getTagsForWorkSpecId(str));
        return this.mWorkDatabase.workSpecDao().getWorkSpec(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$startWork$1(ListenableFuture listenableFuture, WorkerWrapper workerWrapper) {
        boolean z5;
        try {
            z5 = ((Boolean) listenableFuture.get()).booleanValue();
        } catch (InterruptedException | ExecutionException unused) {
            z5 = true;
        }
        onExecuted(workerWrapper, z5);
    }

    private void onExecuted(WorkerWrapper workerWrapper, boolean z5) {
        synchronized (this.mLock) {
            try {
                WorkGenerationalId workGenerationalId = workerWrapper.getWorkGenerationalId();
                String workSpecId = workGenerationalId.getWorkSpecId();
                if (getWorkerWrapperUnsafe(workSpecId) == workerWrapper) {
                    cleanUpWorkerUnsafe(workSpecId);
                }
                Logger.get().debug(TAG, getClass().getSimpleName() + " " + workSpecId + " executed; reschedule = " + z5);
                Iterator<ExecutionListener> it = this.mOuterListeners.iterator();
                while (it.hasNext()) {
                    it.next().onExecuted(workGenerationalId, z5);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void runOnExecuted(final WorkGenerationalId workGenerationalId, final boolean z5) {
        this.mWorkTaskExecutor.getMainThreadExecutor().execute(new Runnable() { // from class: Q.c
            @Override // java.lang.Runnable
            public final void run() {
                Processor.this.lambda$runOnExecuted$2(workGenerationalId, z5);
            }
        });
    }

    private void stopForegroundService() {
        synchronized (this.mLock) {
            try {
                if (this.mForegroundWorkMap.isEmpty()) {
                    try {
                        this.mAppContext.startService(SystemForegroundDispatcher.createStopForegroundIntent(this.mAppContext));
                    } catch (Throwable th) {
                        Logger.get().error(TAG, "Unable to stop foreground service", th);
                    }
                    PowerManager.WakeLock wakeLock = this.mForegroundLock;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.mForegroundLock = null;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void addExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    public WorkSpec getRunningWorkSpec(String str) {
        synchronized (this.mLock) {
            try {
                WorkerWrapper workerWrapperUnsafe = getWorkerWrapperUnsafe(str);
                if (workerWrapperUnsafe == null) {
                    return null;
                }
                return workerWrapperUnsafe.getWorkSpec();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isCancelled(String str) {
        boolean contains;
        synchronized (this.mLock) {
            contains = this.mCancelledIds.contains(str);
        }
        return contains;
    }

    public boolean isEnqueued(String str) {
        boolean z5;
        synchronized (this.mLock) {
            z5 = getWorkerWrapperUnsafe(str) != null;
        }
        return z5;
    }

    public void removeExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.remove(executionListener);
        }
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void startForeground(String str, ForegroundInfo foregroundInfo) {
        synchronized (this.mLock) {
            try {
                Logger.get().info(TAG, "Moving WorkSpec (" + str + ") to the foreground");
                WorkerWrapper remove = this.mEnqueuedWorkMap.remove(str);
                if (remove != null) {
                    if (this.mForegroundLock == null) {
                        PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.mAppContext, FOREGROUND_WAKELOCK_TAG);
                        this.mForegroundLock = newWakeLock;
                        newWakeLock.acquire();
                    }
                    this.mForegroundWorkMap.put(str, remove);
                    ContextCompat.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, remove.getWorkGenerationalId(), foregroundInfo));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean startWork(StartStopToken startStopToken) {
        return startWork(startStopToken, null);
    }

    public boolean stopAndCancelWork(String str, int i5) {
        WorkerWrapper cleanUpWorkerUnsafe;
        synchronized (this.mLock) {
            Logger.get().debug(TAG, "Processor cancelling " + str);
            this.mCancelledIds.add(str);
            cleanUpWorkerUnsafe = cleanUpWorkerUnsafe(str);
        }
        return interrupt(str, cleanUpWorkerUnsafe, i5);
    }

    public boolean stopForegroundWork(StartStopToken startStopToken, int i5) {
        WorkerWrapper cleanUpWorkerUnsafe;
        String workSpecId = startStopToken.getId().getWorkSpecId();
        synchronized (this.mLock) {
            cleanUpWorkerUnsafe = cleanUpWorkerUnsafe(workSpecId);
        }
        return interrupt(workSpecId, cleanUpWorkerUnsafe, i5);
    }

    public boolean stopWork(StartStopToken startStopToken, int i5) {
        String workSpecId = startStopToken.getId().getWorkSpecId();
        synchronized (this.mLock) {
            try {
                if (this.mForegroundWorkMap.get(workSpecId) == null) {
                    Set<StartStopToken> set = this.mWorkRuns.get(workSpecId);
                    if (set != null && set.contains(startStopToken)) {
                        return interrupt(workSpecId, cleanUpWorkerUnsafe(workSpecId), i5);
                    }
                    return false;
                }
                Logger.get().debug(TAG, "Ignored stopWork. WorkerWrapper " + workSpecId + " is in foreground");
                return false;
            } finally {
            }
        }
    }

    public boolean startWork(StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        WorkGenerationalId id = startStopToken.getId();
        final String workSpecId = id.getWorkSpecId();
        final ArrayList arrayList = new ArrayList();
        WorkSpec workSpec = (WorkSpec) this.mWorkDatabase.runInTransaction(new Callable() { // from class: Q.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                WorkSpec lambda$startWork$0;
                lambda$startWork$0 = Processor.this.lambda$startWork$0(arrayList, workSpecId);
                return lambda$startWork$0;
            }
        });
        if (workSpec == null) {
            Logger.get().warning(TAG, "Didn't find WorkSpec for id " + id);
            runOnExecuted(id, false);
            return false;
        }
        synchronized (this.mLock) {
            try {
                if (isEnqueued(workSpecId)) {
                    Set<StartStopToken> set = this.mWorkRuns.get(workSpecId);
                    if (set.iterator().next().getId().getGeneration() == id.getGeneration()) {
                        set.add(startStopToken);
                        Logger.get().debug(TAG, "Work " + id + " is already enqueued for processing");
                    } else {
                        runOnExecuted(id, false);
                    }
                    return false;
                }
                if (workSpec.getGeneration() != id.getGeneration()) {
                    runOnExecuted(id, false);
                    return false;
                }
                final WorkerWrapper build = new WorkerWrapper.Builder(this.mAppContext, this.mConfiguration, this.mWorkTaskExecutor, this, this.mWorkDatabase, workSpec, arrayList).withRuntimeExtras(runtimeExtras).build();
                final ListenableFuture<Boolean> launch = build.launch();
                launch.addListener(new Runnable() { // from class: Q.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        Processor.this.lambda$startWork$1(launch, build);
                    }
                }, this.mWorkTaskExecutor.getMainThreadExecutor());
                this.mEnqueuedWorkMap.put(workSpecId, build);
                HashSet hashSet = new HashSet();
                hashSet.add(startStopToken);
                this.mWorkRuns.put(workSpecId, hashSet);
                Logger.get().debug(TAG, getClass().getSimpleName() + ": processing " + id);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
