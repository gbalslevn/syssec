package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.Clock;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CommandHandler implements ExecutionListener {
    private static final String KEY_NEEDS_RESCHEDULE = "KEY_NEEDS_RESCHEDULE";
    private static final String KEY_WORKSPEC_GENERATION = "KEY_WORKSPEC_GENERATION";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    private static final String TAG = Logger.tagWithPrefix("CommandHandler");
    private final Clock mClock;
    private final Context mContext;
    private final StartStopTokens mStartStopTokens;
    private final Map<WorkGenerationalId, DelayMetCommandHandler> mPendingDelayMet = new HashMap();
    private final Object mLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public CommandHandler(Context context, Clock clock, StartStopTokens startStopTokens) {
        this.mContext = context;
        this.mClock = clock;
        this.mStartStopTokens = startStopTokens;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent createConstraintsChangedIntent(Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent createDelayMetIntent(Context context, WorkGenerationalId workGenerationalId) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        return writeWorkGenerationalId(intent, workGenerationalId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent createExecutionCompletedIntent(Context context, WorkGenerationalId workGenerationalId, boolean z5) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra(KEY_NEEDS_RESCHEDULE, z5);
        return writeWorkGenerationalId(intent, workGenerationalId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent createScheduleWorkIntent(Context context, WorkGenerationalId workGenerationalId) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        return writeWorkGenerationalId(intent, workGenerationalId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent createStopWorkIntent(Context context, WorkGenerationalId workGenerationalId) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        return writeWorkGenerationalId(intent, workGenerationalId);
    }

    private void handleConstraintsChanged(Intent intent, int i5, SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.get().debug(TAG, "Handling constraints changed " + intent);
        new ConstraintsCommandHandler(this.mContext, this.mClock, i5, systemAlarmDispatcher).handleConstraintsChanged();
    }

    private void handleDelayMet(Intent intent, int i5, SystemAlarmDispatcher systemAlarmDispatcher) {
        synchronized (this.mLock) {
            try {
                WorkGenerationalId readWorkGenerationalId = readWorkGenerationalId(intent);
                Logger logger = Logger.get();
                String str = TAG;
                logger.debug(str, "Handing delay met for " + readWorkGenerationalId);
                if (this.mPendingDelayMet.containsKey(readWorkGenerationalId)) {
                    Logger.get().debug(str, "WorkSpec " + readWorkGenerationalId + " is is already being handled for ACTION_DELAY_MET");
                } else {
                    DelayMetCommandHandler delayMetCommandHandler = new DelayMetCommandHandler(this.mContext, i5, systemAlarmDispatcher, this.mStartStopTokens.tokenFor(readWorkGenerationalId));
                    this.mPendingDelayMet.put(readWorkGenerationalId, delayMetCommandHandler);
                    delayMetCommandHandler.handleProcessWork();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void handleExecutionCompleted(Intent intent, int i5) {
        WorkGenerationalId readWorkGenerationalId = readWorkGenerationalId(intent);
        boolean z5 = intent.getExtras().getBoolean(KEY_NEEDS_RESCHEDULE);
        Logger.get().debug(TAG, "Handling onExecutionCompleted " + intent + ", " + i5);
        onExecuted(readWorkGenerationalId, z5);
    }

    private void handleReschedule(Intent intent, int i5, SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.get().debug(TAG, "Handling reschedule " + intent + ", " + i5);
        systemAlarmDispatcher.getWorkManager().rescheduleEligibleWork();
    }

    private void handleScheduleWorkIntent(Intent intent, int i5, SystemAlarmDispatcher systemAlarmDispatcher) {
        WorkGenerationalId readWorkGenerationalId = readWorkGenerationalId(intent);
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, "Handling schedule work for " + readWorkGenerationalId);
        WorkDatabase workDatabase = systemAlarmDispatcher.getWorkManager().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            WorkSpec workSpec = workDatabase.workSpecDao().getWorkSpec(readWorkGenerationalId.getWorkSpecId());
            if (workSpec == null) {
                Logger.get().warning(str, "Skipping scheduling " + readWorkGenerationalId + " because it's no longer in the DB");
                return;
            }
            if (workSpec.state.isFinished()) {
                Logger.get().warning(str, "Skipping scheduling " + readWorkGenerationalId + "because it is finished.");
                return;
            }
            long calculateNextRunTime = workSpec.calculateNextRunTime();
            if (workSpec.hasConstraints()) {
                Logger.get().debug(str, "Opportunistically setting an alarm for " + readWorkGenerationalId + "at " + calculateNextRunTime);
                Alarms.setAlarm(this.mContext, workDatabase, readWorkGenerationalId, calculateNextRunTime);
                systemAlarmDispatcher.getTaskExecutor().getMainThreadExecutor().execute(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, createConstraintsChangedIntent(this.mContext), i5));
            } else {
                Logger.get().debug(str, "Setting up Alarms for " + readWorkGenerationalId + "at " + calculateNextRunTime);
                Alarms.setAlarm(this.mContext, workDatabase, readWorkGenerationalId, calculateNextRunTime);
            }
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
        }
    }

    private void handleStopWork(Intent intent, SystemAlarmDispatcher systemAlarmDispatcher) {
        List<StartStopToken> remove;
        Bundle extras = intent.getExtras();
        String string = extras.getString(KEY_WORKSPEC_ID);
        if (extras.containsKey(KEY_WORKSPEC_GENERATION)) {
            int i5 = extras.getInt(KEY_WORKSPEC_GENERATION);
            remove = new ArrayList<>(1);
            StartStopToken remove2 = this.mStartStopTokens.remove(new WorkGenerationalId(string, i5));
            if (remove2 != null) {
                remove.add(remove2);
            }
        } else {
            remove = this.mStartStopTokens.remove(string);
        }
        for (StartStopToken startStopToken : remove) {
            Logger.get().debug(TAG, "Handing stopWork work for " + string);
            systemAlarmDispatcher.getWorkerLauncher().stopWork(startStopToken);
            Alarms.cancelAlarm(this.mContext, systemAlarmDispatcher.getWorkManager().getWorkDatabase(), startStopToken.getId());
            systemAlarmDispatcher.onExecuted(startStopToken.getId(), false);
        }
    }

    private static boolean hasKeys(Bundle bundle, String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    static WorkGenerationalId readWorkGenerationalId(Intent intent) {
        return new WorkGenerationalId(intent.getStringExtra(KEY_WORKSPEC_ID), intent.getIntExtra(KEY_WORKSPEC_GENERATION, 0));
    }

    private static Intent writeWorkGenerationalId(Intent intent, WorkGenerationalId workGenerationalId) {
        intent.putExtra(KEY_WORKSPEC_ID, workGenerationalId.getWorkSpecId());
        intent.putExtra(KEY_WORKSPEC_GENERATION, workGenerationalId.getGeneration());
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasPendingCommands() {
        boolean z5;
        synchronized (this.mLock) {
            z5 = !this.mPendingDelayMet.isEmpty();
        }
        return z5;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(WorkGenerationalId workGenerationalId, boolean z5) {
        synchronized (this.mLock) {
            try {
                DelayMetCommandHandler remove = this.mPendingDelayMet.remove(workGenerationalId);
                this.mStartStopTokens.remove(workGenerationalId);
                if (remove != null) {
                    remove.onExecuted(z5);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onHandleIntent(Intent intent, int i5, SystemAlarmDispatcher systemAlarmDispatcher) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            handleConstraintsChanged(intent, i5, systemAlarmDispatcher);
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            handleReschedule(intent, i5, systemAlarmDispatcher);
            return;
        }
        if (!hasKeys(intent.getExtras(), KEY_WORKSPEC_ID)) {
            Logger.get().error(TAG, "Invalid request for " + action + " , requires " + KEY_WORKSPEC_ID + " .");
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            handleScheduleWorkIntent(intent, i5, systemAlarmDispatcher);
            return;
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            handleDelayMet(intent, i5, systemAlarmDispatcher);
            return;
        }
        if ("ACTION_STOP_WORK".equals(action)) {
            handleStopWork(intent, systemAlarmDispatcher);
            return;
        }
        if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            handleExecutionCompleted(intent, i5);
            return;
        }
        Logger.get().warning(TAG, "Ignoring intent " + intent);
    }
}
