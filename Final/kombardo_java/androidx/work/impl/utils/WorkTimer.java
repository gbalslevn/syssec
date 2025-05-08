package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class WorkTimer {
    private static final String TAG = Logger.tagWithPrefix("WorkTimer");
    final RunnableScheduler mRunnableScheduler;
    final Map<WorkGenerationalId, WorkTimerRunnable> mTimerMap = new HashMap();
    final Map<WorkGenerationalId, TimeLimitExceededListener> mListeners = new HashMap();
    final Object mLock = new Object();

    /* loaded from: classes.dex */
    public interface TimeLimitExceededListener {
        void onTimeLimitExceeded(WorkGenerationalId workGenerationalId);
    }

    /* loaded from: classes.dex */
    public static class WorkTimerRunnable implements Runnable {
        private final WorkGenerationalId mWorkGenerationalId;
        private final WorkTimer mWorkTimer;

        WorkTimerRunnable(WorkTimer workTimer, WorkGenerationalId workGenerationalId) {
            this.mWorkTimer = workTimer;
            this.mWorkGenerationalId = workGenerationalId;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.mWorkTimer.mLock) {
                try {
                    if (this.mWorkTimer.mTimerMap.remove(this.mWorkGenerationalId) != null) {
                        TimeLimitExceededListener remove = this.mWorkTimer.mListeners.remove(this.mWorkGenerationalId);
                        if (remove != null) {
                            remove.onTimeLimitExceeded(this.mWorkGenerationalId);
                        }
                    } else {
                        Logger.get().debug("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.mWorkGenerationalId));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public WorkTimer(RunnableScheduler runnableScheduler) {
        this.mRunnableScheduler = runnableScheduler;
    }

    public void startTimer(WorkGenerationalId workGenerationalId, long j5, TimeLimitExceededListener timeLimitExceededListener) {
        synchronized (this.mLock) {
            Logger.get().debug(TAG, "Starting timer for " + workGenerationalId);
            stopTimer(workGenerationalId);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, workGenerationalId);
            this.mTimerMap.put(workGenerationalId, workTimerRunnable);
            this.mListeners.put(workGenerationalId, timeLimitExceededListener);
            this.mRunnableScheduler.scheduleWithDelay(j5, workTimerRunnable);
        }
    }

    public void stopTimer(WorkGenerationalId workGenerationalId) {
        synchronized (this.mLock) {
            try {
                if (this.mTimerMap.remove(workGenerationalId) != null) {
                    Logger.get().debug(TAG, "Stopping timer for " + workGenerationalId);
                    this.mListeners.remove(workGenerationalId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
