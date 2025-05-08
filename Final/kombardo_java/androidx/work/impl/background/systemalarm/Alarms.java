package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.IdGenerator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class Alarms {
    private static final String TAG = Logger.tagWithPrefix("Alarms");

    public static void cancelAlarm(Context context, WorkDatabase workDatabase, WorkGenerationalId workGenerationalId) {
        SystemIdInfoDao systemIdInfoDao = workDatabase.systemIdInfoDao();
        SystemIdInfo systemIdInfo = systemIdInfoDao.getSystemIdInfo(workGenerationalId);
        if (systemIdInfo != null) {
            cancelExactAlarm(context, workGenerationalId, systemIdInfo.systemId);
            Logger.get().debug(TAG, "Removing SystemIdInfo for workSpecId (" + workGenerationalId + ")");
            systemIdInfoDao.removeSystemIdInfo(workGenerationalId);
        }
    }

    private static void cancelExactAlarm(Context context, WorkGenerationalId workGenerationalId, int i5) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i5, CommandHandler.createDelayMetIntent(context, workGenerationalId), 603979776);
        if (service == null || alarmManager == null) {
            return;
        }
        Logger.get().debug(TAG, "Cancelling existing alarm with (workSpecId, systemId) (" + workGenerationalId + ", " + i5 + ")");
        alarmManager.cancel(service);
    }

    public static void setAlarm(Context context, WorkDatabase workDatabase, WorkGenerationalId workGenerationalId, long j5) {
        SystemIdInfoDao systemIdInfoDao = workDatabase.systemIdInfoDao();
        SystemIdInfo systemIdInfo = systemIdInfoDao.getSystemIdInfo(workGenerationalId);
        if (systemIdInfo != null) {
            cancelExactAlarm(context, workGenerationalId, systemIdInfo.systemId);
            setExactAlarm(context, workGenerationalId, systemIdInfo.systemId, j5);
        } else {
            int nextAlarmManagerId = new IdGenerator(workDatabase).nextAlarmManagerId();
            systemIdInfoDao.insertSystemIdInfo(SystemIdInfoKt.systemIdInfo(workGenerationalId, nextAlarmManagerId));
            setExactAlarm(context, workGenerationalId, nextAlarmManagerId, j5);
        }
    }

    private static void setExactAlarm(Context context, WorkGenerationalId workGenerationalId, int i5, long j5) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i5, CommandHandler.createDelayMetIntent(context, workGenerationalId), 201326592);
        if (alarmManager != null) {
            alarmManager.setExact(0, j5, service);
        }
    }
}
