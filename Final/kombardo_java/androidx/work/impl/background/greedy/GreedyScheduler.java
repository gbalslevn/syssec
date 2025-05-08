package androidx.work.impl.background.greedy;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.WorkInfo$State;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.ProcessUtils;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlinx.coroutines.Job;

/* loaded from: classes.dex */
public class GreedyScheduler implements Scheduler, OnConstraintsStateChangedListener, ExecutionListener {
    private static final int NON_THROTTLE_RUN_ATTEMPT_COUNT = 5;
    private static final String TAG = Logger.tagWithPrefix("GreedyScheduler");
    private final Configuration mConfiguration;
    private final WorkConstraintsTracker mConstraintsTracker;
    private final Context mContext;
    private DelayedWorkTracker mDelayedWorkTracker;
    Boolean mInDefaultProcess;
    private final Processor mProcessor;
    private boolean mRegisteredExecutionListener;
    private final TaskExecutor mTaskExecutor;
    private final TimeLimiter mTimeLimiter;
    private final WorkLauncher mWorkLauncher;
    private final Map<WorkGenerationalId, Job> mConstrainedWorkSpecs = new HashMap();
    private final Object mLock = new Object();
    private final StartStopTokens mStartStopTokens = StartStopTokens.create();
    private final Map<WorkGenerationalId, AttemptData> mFirstRunAttempts = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AttemptData {
        final int mRunAttemptCount;
        final long mTimeStamp;

        private AttemptData(int i5, long j5) {
            this.mRunAttemptCount = i5;
            this.mTimeStamp = j5;
        }
    }

    public GreedyScheduler(Context context, Configuration configuration, Trackers trackers, Processor processor, WorkLauncher workLauncher, TaskExecutor taskExecutor) {
        this.mContext = context;
        RunnableScheduler runnableScheduler = configuration.getRunnableScheduler();
        this.mDelayedWorkTracker = new DelayedWorkTracker(this, runnableScheduler, configuration.getClock());
        this.mTimeLimiter = new TimeLimiter(runnableScheduler, workLauncher);
        this.mTaskExecutor = taskExecutor;
        this.mConstraintsTracker = new WorkConstraintsTracker(trackers);
        this.mConfiguration = configuration;
        this.mProcessor = processor;
        this.mWorkLauncher = workLauncher;
    }

    private void checkDefaultProcess() {
        this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext, this.mConfiguration));
    }

    private void registerExecutionListenerIfNeeded() {
        if (this.mRegisteredExecutionListener) {
            return;
        }
        this.mProcessor.addExecutionListener(this);
        this.mRegisteredExecutionListener = true;
    }

    private void removeConstraintTrackingFor(WorkGenerationalId workGenerationalId) {
        Job remove;
        synchronized (this.mLock) {
            remove = this.mConstrainedWorkSpecs.remove(workGenerationalId);
        }
        if (remove != null) {
            Logger.get().debug(TAG, "Stopping tracking for " + workGenerationalId);
            remove.cancel(null);
        }
    }

    private long throttleIfNeeded(WorkSpec workSpec) {
        long max;
        synchronized (this.mLock) {
            try {
                WorkGenerationalId generationalId = WorkSpecKt.generationalId(workSpec);
                AttemptData attemptData = this.mFirstRunAttempts.get(generationalId);
                if (attemptData == null) {
                    attemptData = new AttemptData(workSpec.runAttemptCount, this.mConfiguration.getClock().currentTimeMillis());
                    this.mFirstRunAttempts.put(generationalId, attemptData);
                }
                max = attemptData.mTimeStamp + (Math.max((workSpec.runAttemptCount - attemptData.mRunAttemptCount) - 5, 0) * 30000);
            } catch (Throwable th) {
                throw th;
            }
        }
        return max;
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(String str) {
        if (this.mInDefaultProcess == null) {
            checkDefaultProcess();
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in non-main process");
            return;
        }
        registerExecutionListenerIfNeeded();
        Logger.get().debug(TAG, "Cancelling work ID " + str);
        DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
        if (delayedWorkTracker != null) {
            delayedWorkTracker.unschedule(str);
        }
        for (StartStopToken startStopToken : this.mStartStopTokens.remove(str)) {
            this.mTimeLimiter.cancel(startStopToken);
            this.mWorkLauncher.stopWork(startStopToken);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return false;
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public void onConstraintsStateChanged(WorkSpec workSpec, ConstraintsState constraintsState) {
        WorkGenerationalId generationalId = WorkSpecKt.generationalId(workSpec);
        if (constraintsState instanceof ConstraintsState.ConstraintsMet) {
            if (this.mStartStopTokens.contains(generationalId)) {
                return;
            }
            Logger.get().debug(TAG, "Constraints met: Scheduling work ID " + generationalId);
            StartStopToken startStopToken = this.mStartStopTokens.tokenFor(generationalId);
            this.mTimeLimiter.track(startStopToken);
            this.mWorkLauncher.startWork(startStopToken);
            return;
        }
        Logger.get().debug(TAG, "Constraints not met: Cancelling work ID " + generationalId);
        StartStopToken remove = this.mStartStopTokens.remove(generationalId);
        if (remove != null) {
            this.mTimeLimiter.cancel(remove);
            this.mWorkLauncher.stopWorkWithReason(remove, ((ConstraintsState.ConstraintsNotMet) constraintsState).getReason());
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(WorkGenerationalId workGenerationalId, boolean z5) {
        StartStopToken remove = this.mStartStopTokens.remove(workGenerationalId);
        if (remove != null) {
            this.mTimeLimiter.cancel(remove);
        }
        removeConstraintTrackingFor(workGenerationalId);
        if (z5) {
            return;
        }
        synchronized (this.mLock) {
            this.mFirstRunAttempts.remove(workGenerationalId);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public void schedule(WorkSpec... workSpecArr) {
        if (this.mInDefaultProcess == null) {
            checkDefaultProcess();
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in a secondary process");
            return;
        }
        registerExecutionListenerIfNeeded();
        HashSet<WorkSpec> hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (WorkSpec workSpec : workSpecArr) {
            if (!this.mStartStopTokens.contains(WorkSpecKt.generationalId(workSpec))) {
                long max = Math.max(workSpec.calculateNextRunTime(), throttleIfNeeded(workSpec));
                long currentTimeMillis = this.mConfiguration.getClock().currentTimeMillis();
                if (workSpec.state == WorkInfo$State.ENQUEUED) {
                    if (currentTimeMillis < max) {
                        DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
                        if (delayedWorkTracker != null) {
                            delayedWorkTracker.schedule(workSpec, max);
                        }
                    } else if (workSpec.hasConstraints()) {
                        Constraints constraints = workSpec.constraints;
                        if (constraints.getRequiresDeviceIdle()) {
                            Logger.get().debug(TAG, "Ignoring " + workSpec + ". Requires device idle.");
                        } else if (constraints.hasContentUriTriggers()) {
                            Logger.get().debug(TAG, "Ignoring " + workSpec + ". Requires ContentUri triggers.");
                        } else {
                            hashSet.add(workSpec);
                            hashSet2.add(workSpec.id);
                        }
                    } else if (!this.mStartStopTokens.contains(WorkSpecKt.generationalId(workSpec))) {
                        Logger.get().debug(TAG, "Starting work for " + workSpec.id);
                        StartStopToken startStopToken = this.mStartStopTokens.tokenFor(workSpec);
                        this.mTimeLimiter.track(startStopToken);
                        this.mWorkLauncher.startWork(startStopToken);
                    }
                }
            }
        }
        synchronized (this.mLock) {
            try {
                if (!hashSet.isEmpty()) {
                    Logger.get().debug(TAG, "Starting tracking for " + TextUtils.join(",", hashSet2));
                    for (WorkSpec workSpec2 : hashSet) {
                        WorkGenerationalId generationalId = WorkSpecKt.generationalId(workSpec2);
                        if (!this.mConstrainedWorkSpecs.containsKey(generationalId)) {
                            this.mConstrainedWorkSpecs.put(generationalId, WorkConstraintsTrackerKt.listen(this.mConstraintsTracker, workSpec2, this.mTaskExecutor.getTaskCoroutineDispatcher(), this));
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
