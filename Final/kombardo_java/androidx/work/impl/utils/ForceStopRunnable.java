package androidx.work.impl.utils;

import W.c;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.UserManagerCompat;
import androidx.core.util.Consumer;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo$State;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ForceStopRunnable implements Runnable {
    private static final int ALARM_ID = -1;
    private static final long BACKOFF_DURATION_MS = 300;
    private static final String TAG = Logger.tagWithPrefix("ForceStopRunnable");
    private static final long TEN_YEARS = TimeUnit.DAYS.toMillis(3650);
    private final Context mContext;
    private final PreferenceUtils mPreferenceUtils;
    private int mRetryCount = 0;
    private final WorkManagerImpl mWorkManager;

    /* loaded from: classes.dex */
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        private static final String TAG = Logger.tagWithPrefix("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                return;
            }
            Logger.get().verbose(TAG, "Rescheduling alarm that keeps track of force-stops.");
            ForceStopRunnable.setAlarm(context);
        }
    }

    public ForceStopRunnable(Context context, WorkManagerImpl workManagerImpl) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = workManagerImpl;
        this.mPreferenceUtils = workManagerImpl.getPreferenceUtils();
    }

    static Intent getIntent(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    private static PendingIntent getPendingIntent(Context context, int i5) {
        return PendingIntent.getBroadcast(context, -1, getIntent(context), i5);
    }

    @SuppressLint({"ClassVerificationFailure"})
    static void setAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent pendingIntent = getPendingIntent(context, Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728);
        long currentTimeMillis = System.currentTimeMillis() + TEN_YEARS;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, pendingIntent);
        }
    }

    public boolean cleanUp() {
        boolean reconcileJobs = SystemJobScheduler.reconcileJobs(this.mContext, this.mWorkManager.getWorkDatabase());
        WorkDatabase workDatabase = this.mWorkManager.getWorkDatabase();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkProgressDao workProgressDao = workDatabase.workProgressDao();
        workDatabase.beginTransaction();
        try {
            List<WorkSpec> runningWork = workSpecDao.getRunningWork();
            boolean z5 = (runningWork == null || runningWork.isEmpty()) ? false : true;
            if (z5) {
                for (WorkSpec workSpec : runningWork) {
                    workSpecDao.setState(WorkInfo$State.ENQUEUED, workSpec.id);
                    workSpecDao.setStopReason(workSpec.id, -512);
                    workSpecDao.markWorkSpecScheduled(workSpec.id, -1L);
                }
            }
            workProgressDao.deleteAll();
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            return z5 || reconcileJobs;
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }

    public void forceStopRunnable() {
        boolean cleanUp = cleanUp();
        if (shouldRescheduleWorkers()) {
            Logger.get().debug(TAG, "Rescheduling Workers.");
            this.mWorkManager.rescheduleEligibleWork();
            this.mWorkManager.getPreferenceUtils().setNeedsReschedule(false);
        } else if (isForceStopped()) {
            Logger.get().debug(TAG, "Application was force-stopped, rescheduling.");
            this.mWorkManager.rescheduleEligibleWork();
            this.mPreferenceUtils.setLastForceStopEventMillis(this.mWorkManager.getConfiguration().getClock().currentTimeMillis());
        } else if (cleanUp) {
            Logger.get().debug(TAG, "Found unfinished work, scheduling it.");
            Schedulers.schedule(this.mWorkManager.getConfiguration(), this.mWorkManager.getWorkDatabase(), this.mWorkManager.getSchedulers());
        }
    }

    @SuppressLint({"ClassVerificationFailure"})
    public boolean isForceStopped() {
        List historicalProcessExitReasons;
        int reason;
        long timestamp;
        try {
            int i5 = Build.VERSION.SDK_INT;
            PendingIntent pendingIntent = getPendingIntent(this.mContext, i5 >= 31 ? 570425344 : 536870912);
            if (i5 >= 30) {
                if (pendingIntent != null) {
                    pendingIntent.cancel();
                }
                historicalProcessExitReasons = ((ActivityManager) this.mContext.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    long lastForceStopEventMillis = this.mPreferenceUtils.getLastForceStopEventMillis();
                    for (int i6 = 0; i6 < historicalProcessExitReasons.size(); i6++) {
                        ApplicationExitInfo a5 = c.a(historicalProcessExitReasons.get(i6));
                        reason = a5.getReason();
                        if (reason == 10) {
                            timestamp = a5.getTimestamp();
                            if (timestamp >= lastForceStopEventMillis) {
                                return true;
                            }
                        }
                    }
                }
            } else if (pendingIntent == null) {
                setAlarm(this.mContext);
                return true;
            }
            return false;
        } catch (IllegalArgumentException e5) {
            e = e5;
            Logger.get().warning(TAG, "Ignoring exception", e);
            return true;
        } catch (SecurityException e6) {
            e = e6;
            Logger.get().warning(TAG, "Ignoring exception", e);
            return true;
        }
    }

    public boolean multiProcessChecks() {
        Configuration configuration = this.mWorkManager.getConfiguration();
        if (TextUtils.isEmpty(configuration.getDefaultProcessName())) {
            Logger.get().debug(TAG, "The default process name was not specified.");
            return true;
        }
        boolean isDefaultProcess = ProcessUtils.isDefaultProcess(this.mContext, configuration);
        Logger.get().debug(TAG, "Is default app process = " + isDefaultProcess);
        return isDefaultProcess;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i5;
        try {
            if (multiProcessChecks()) {
                while (true) {
                    try {
                        WorkDatabasePathHelper.migrateDatabase(this.mContext);
                        Logger.get().debug(TAG, "Performing cleanup operations.");
                        try {
                            forceStopRunnable();
                            break;
                        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteFullException | SQLiteTableLockedException e5) {
                            i5 = this.mRetryCount + 1;
                            this.mRetryCount = i5;
                            if (i5 >= 3) {
                                String str = UserManagerCompat.isUserUnlocked(this.mContext) ? "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store." : "WorkManager can't be accessed from direct boot, because credential encrypted storage isn't accessible.\nDon't access or initialise WorkManager from directAware components. See https://developer.android.com/training/articles/direct-boot";
                                Logger logger = Logger.get();
                                String str2 = TAG;
                                logger.error(str2, str, e5);
                                IllegalStateException illegalStateException = new IllegalStateException(str, e5);
                                Consumer<Throwable> initializationExceptionHandler = this.mWorkManager.getConfiguration().getInitializationExceptionHandler();
                                if (initializationExceptionHandler == null) {
                                    throw illegalStateException;
                                }
                                Logger.get().debug(str2, "Routing exception to the specified exception handler", illegalStateException);
                                initializationExceptionHandler.accept(illegalStateException);
                            } else {
                                long j5 = i5 * BACKOFF_DURATION_MS;
                                Logger.get().debug(TAG, "Retrying after " + j5, e5);
                                sleep(((long) this.mRetryCount) * BACKOFF_DURATION_MS);
                            }
                        }
                        long j52 = i5 * BACKOFF_DURATION_MS;
                        Logger.get().debug(TAG, "Retrying after " + j52, e5);
                        sleep(((long) this.mRetryCount) * BACKOFF_DURATION_MS);
                    } catch (SQLiteException e6) {
                        Logger.get().error(TAG, "Unexpected SQLite exception during migrations");
                        IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected SQLite exception during migrations", e6);
                        Consumer<Throwable> initializationExceptionHandler2 = this.mWorkManager.getConfiguration().getInitializationExceptionHandler();
                        if (initializationExceptionHandler2 == null) {
                            throw illegalStateException2;
                        }
                        initializationExceptionHandler2.accept(illegalStateException2);
                    }
                }
            }
        } finally {
            this.mWorkManager.onForceStopRunnableCompleted();
        }
    }

    public boolean shouldRescheduleWorkers() {
        return this.mWorkManager.getPreferenceUtils().getNeedsReschedule();
    }

    public void sleep(long j5) {
        try {
            Thread.sleep(j5);
        } catch (InterruptedException unused) {
        }
    }
}
