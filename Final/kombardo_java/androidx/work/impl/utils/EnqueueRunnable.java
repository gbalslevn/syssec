package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.WorkInfo$State;
import androidx.work.WorkRequest;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class EnqueueRunnable {
    private static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");

    public static boolean addToDatabase(WorkContinuationImpl workContinuationImpl) {
        WorkManagerImpl workManagerImpl = workContinuationImpl.getWorkManagerImpl();
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            EnqueueUtilsKt.checkContentUriTriggerWorkerLimits(workDatabase, workManagerImpl.getConfiguration(), workContinuationImpl);
            boolean processContinuation = processContinuation(workContinuationImpl);
            workDatabase.setTransactionSuccessful();
            return processContinuation;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public static void enqueue(WorkContinuationImpl workContinuationImpl) {
        if (!workContinuationImpl.hasCycles()) {
            if (addToDatabase(workContinuationImpl)) {
                scheduleWorkInBackground(workContinuationImpl);
            }
        } else {
            throw new IllegalStateException("WorkContinuation has cycles (" + workContinuationImpl + ")");
        }
    }

    private static boolean enqueueContinuation(WorkContinuationImpl workContinuationImpl) {
        boolean enqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(workContinuationImpl.getWorkManagerImpl(), workContinuationImpl.getWork(), (String[]) WorkContinuationImpl.prerequisitesFor(workContinuationImpl).toArray(new String[0]), workContinuationImpl.getName(), workContinuationImpl.getExistingWorkPolicy());
        workContinuationImpl.markEnqueued();
        return enqueueWorkWithPrerequisites;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean enqueueWorkWithPrerequisites(WorkManagerImpl workManagerImpl, List<? extends WorkRequest> list, String[] strArr, String str, ExistingWorkPolicy existingWorkPolicy) {
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        Iterator<? extends WorkRequest> it;
        DependencyDao dependencyDao;
        String[] strArr2 = strArr;
        long currentTimeMillis = workManagerImpl.getConfiguration().getClock().currentTimeMillis();
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        boolean z9 = strArr2 != null && strArr2.length > 0;
        if (z9) {
            z5 = false;
            z6 = false;
            z7 = true;
            for (String str2 : strArr2) {
                WorkSpec workSpec = workDatabase.workSpecDao().getWorkSpec(str2);
                if (workSpec == null) {
                    Logger.get().error(TAG, "Prerequisite " + str2 + " doesn't exist; not enqueuing");
                    return false;
                }
                WorkInfo$State workInfo$State = workSpec.state;
                z7 &= workInfo$State == WorkInfo$State.SUCCEEDED;
                if (workInfo$State == WorkInfo$State.FAILED) {
                    z6 = true;
                } else if (workInfo$State == WorkInfo$State.CANCELLED) {
                    z5 = true;
                }
            }
        } else {
            z5 = false;
            z6 = false;
            z7 = true;
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        if (!isEmpty && !z9) {
            List<WorkSpec.IdAndState> workSpecIdAndStatesForName = workDatabase.workSpecDao().getWorkSpecIdAndStatesForName(str);
            if (!workSpecIdAndStatesForName.isEmpty()) {
                if (existingWorkPolicy != ExistingWorkPolicy.APPEND && existingWorkPolicy != ExistingWorkPolicy.APPEND_OR_REPLACE) {
                    if (existingWorkPolicy == ExistingWorkPolicy.KEEP) {
                        Iterator<WorkSpec.IdAndState> it2 = workSpecIdAndStatesForName.iterator();
                        while (it2.hasNext()) {
                            WorkInfo$State workInfo$State2 = it2.next().state;
                            if (workInfo$State2 == WorkInfo$State.ENQUEUED || workInfo$State2 == WorkInfo$State.RUNNING) {
                                return false;
                            }
                        }
                    }
                    CancelWorkRunnable.forNameInline(str, workManagerImpl);
                    WorkSpecDao workSpecDao = workDatabase.workSpecDao();
                    Iterator<WorkSpec.IdAndState> it3 = workSpecIdAndStatesForName.iterator();
                    while (it3.hasNext()) {
                        workSpecDao.delete(it3.next().id);
                    }
                    z8 = true;
                    it = list.iterator();
                    while (it.hasNext()) {
                    }
                    return z8;
                }
                DependencyDao dependencyDao2 = workDatabase.dependencyDao();
                List arrayList = new ArrayList();
                for (WorkSpec.IdAndState idAndState : workSpecIdAndStatesForName) {
                    if (dependencyDao2.hasDependents(idAndState.id)) {
                        dependencyDao = dependencyDao2;
                    } else {
                        WorkInfo$State workInfo$State3 = idAndState.state;
                        dependencyDao = dependencyDao2;
                        boolean z10 = (workInfo$State3 == WorkInfo$State.SUCCEEDED) & z7;
                        if (workInfo$State3 == WorkInfo$State.FAILED) {
                            z6 = true;
                        } else if (workInfo$State3 == WorkInfo$State.CANCELLED) {
                            z5 = true;
                        }
                        arrayList.add(idAndState.id);
                        z7 = z10;
                    }
                    dependencyDao2 = dependencyDao;
                }
                if (existingWorkPolicy == ExistingWorkPolicy.APPEND_OR_REPLACE && (z5 || z6)) {
                    WorkSpecDao workSpecDao2 = workDatabase.workSpecDao();
                    Iterator<WorkSpec.IdAndState> it4 = workSpecDao2.getWorkSpecIdAndStatesForName(str).iterator();
                    while (it4.hasNext()) {
                        workSpecDao2.delete(it4.next().id);
                    }
                    arrayList = Collections.emptyList();
                    z5 = false;
                    z6 = false;
                }
                strArr2 = (String[]) arrayList.toArray(strArr2);
                z9 = strArr2.length > 0;
                z8 = false;
                it = list.iterator();
                while (it.hasNext()) {
                    WorkRequest next = it.next();
                    WorkSpec workSpec2 = next.getWorkSpec();
                    if (!z9 || z7) {
                        workSpec2.lastEnqueueTime = currentTimeMillis;
                    } else if (z6) {
                        workSpec2.state = WorkInfo$State.FAILED;
                    } else if (z5) {
                        workSpec2.state = WorkInfo$State.CANCELLED;
                    } else {
                        workSpec2.state = WorkInfo$State.BLOCKED;
                    }
                    Iterator<? extends WorkRequest> it5 = it;
                    if (workSpec2.state == WorkInfo$State.ENQUEUED) {
                        z8 = true;
                    }
                    workDatabase.workSpecDao().insertWorkSpec(EnqueueUtilsKt.wrapWorkSpecIfNeeded(workManagerImpl.getSchedulers(), workSpec2));
                    if (z9) {
                        int length = strArr2.length;
                        int i5 = 0;
                        while (i5 < length) {
                            workDatabase.dependencyDao().insertDependency(new Dependency(next.getStringId(), strArr2[i5]));
                            i5++;
                            length = length;
                            strArr2 = strArr2;
                        }
                    }
                    String[] strArr3 = strArr2;
                    workDatabase.workTagDao().insertTags(next.getStringId(), next.getTags());
                    if (!isEmpty) {
                        workDatabase.workNameDao().insert(new WorkName(str, next.getStringId()));
                    }
                    it = it5;
                    strArr2 = strArr3;
                }
                return z8;
            }
        }
        z8 = false;
        it = list.iterator();
        while (it.hasNext()) {
        }
        return z8;
    }

    private static boolean processContinuation(WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
        boolean z5 = false;
        if (parents != null) {
            for (WorkContinuationImpl workContinuationImpl2 : parents) {
                if (workContinuationImpl2.isEnqueued()) {
                    Logger.get().warning(TAG, "Already enqueued work ids (" + TextUtils.join(", ", workContinuationImpl2.getIds()) + ")");
                } else {
                    z5 |= processContinuation(workContinuationImpl2);
                }
            }
        }
        return enqueueContinuation(workContinuationImpl) | z5;
    }

    public static void scheduleWorkInBackground(WorkContinuationImpl workContinuationImpl) {
        WorkManagerImpl workManagerImpl = workContinuationImpl.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }
}
