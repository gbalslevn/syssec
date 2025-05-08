package androidx.work.impl;

import android.content.Context;
import androidx.work.Clock;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.Schedulers;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.PackageManagerHelper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class Schedulers {
    private static final String TAG = Logger.tagWithPrefix("Schedulers");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Scheduler createBestAvailableBackgroundScheduler(Context context, WorkDatabase workDatabase, Configuration configuration) {
        SystemJobScheduler systemJobScheduler = new SystemJobScheduler(context, workDatabase, configuration);
        PackageManagerHelper.setComponentEnabled(context, SystemJobService.class, true);
        Logger.get().debug(TAG, "Created SystemJobScheduler and enabled SystemJobService");
        return systemJobScheduler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$registerRescheduling$0(List list, WorkGenerationalId workGenerationalId, Configuration configuration, WorkDatabase workDatabase) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Scheduler) it.next()).cancel(workGenerationalId.getWorkSpecId());
        }
        schedule(configuration, workDatabase, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$registerRescheduling$1(Executor executor, final List list, final Configuration configuration, final WorkDatabase workDatabase, final WorkGenerationalId workGenerationalId, boolean z5) {
        executor.execute(new Runnable() { // from class: Q.e
            @Override // java.lang.Runnable
            public final void run() {
                Schedulers.lambda$registerRescheduling$0(list, workGenerationalId, configuration, workDatabase);
            }
        });
    }

    private static void markScheduled(WorkSpecDao workSpecDao, Clock clock, List<WorkSpec> list) {
        if (list.size() > 0) {
            long currentTimeMillis = clock.currentTimeMillis();
            Iterator<WorkSpec> it = list.iterator();
            while (it.hasNext()) {
                workSpecDao.markWorkSpecScheduled(it.next().id, currentTimeMillis);
            }
        }
    }

    public static void registerRescheduling(final List<Scheduler> list, Processor processor, final Executor executor, final WorkDatabase workDatabase, final Configuration configuration) {
        processor.addExecutionListener(new ExecutionListener() { // from class: Q.d
            @Override // androidx.work.impl.ExecutionListener
            public final void onExecuted(WorkGenerationalId workGenerationalId, boolean z5) {
                Schedulers.lambda$registerRescheduling$1(executor, list, configuration, workDatabase, workGenerationalId, z5);
            }
        });
    }

    public static void schedule(Configuration configuration, WorkDatabase workDatabase, List<Scheduler> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        workDatabase.beginTransaction();
        try {
            List<WorkSpec> eligibleWorkForSchedulingWithContentUris = workSpecDao.getEligibleWorkForSchedulingWithContentUris();
            markScheduled(workSpecDao, configuration.getClock(), eligibleWorkForSchedulingWithContentUris);
            List<WorkSpec> eligibleWorkForScheduling = workSpecDao.getEligibleWorkForScheduling(configuration.getMaxSchedulerLimit());
            markScheduled(workSpecDao, configuration.getClock(), eligibleWorkForScheduling);
            if (eligibleWorkForSchedulingWithContentUris != null) {
                eligibleWorkForScheduling.addAll(eligibleWorkForSchedulingWithContentUris);
            }
            List<WorkSpec> allEligibleWorkSpecsForScheduling = workSpecDao.getAllEligibleWorkSpecsForScheduling(200);
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            if (eligibleWorkForScheduling.size() > 0) {
                WorkSpec[] workSpecArr = (WorkSpec[]) eligibleWorkForScheduling.toArray(new WorkSpec[eligibleWorkForScheduling.size()]);
                for (Scheduler scheduler : list) {
                    if (scheduler.hasLimitedSchedulingSlots()) {
                        scheduler.schedule(workSpecArr);
                    }
                }
            }
            if (allEligibleWorkSpecsForScheduling.size() > 0) {
                WorkSpec[] workSpecArr2 = (WorkSpec[]) allEligibleWorkSpecsForScheduling.toArray(new WorkSpec[allEligibleWorkSpecsForScheduling.size()]);
                for (Scheduler scheduler2 : list) {
                    if (!scheduler2.hasLimitedSchedulingSlots()) {
                        scheduler2.schedule(workSpecArr2);
                    }
                }
            }
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
