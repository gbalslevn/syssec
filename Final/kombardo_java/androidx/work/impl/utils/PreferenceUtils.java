package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;

/* loaded from: classes.dex */
public class PreferenceUtils {
    private static final String KEY_LAST_FORCE_STOP_MS = "last_force_stop_ms";
    private final WorkDatabase mWorkDatabase;

    public PreferenceUtils(WorkDatabase workDatabase) {
        this.mWorkDatabase = workDatabase;
    }

    public static void migrateLegacyPreferences(Context context, SupportSQLiteDatabase supportSQLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j5 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
            long j6 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
            supportSQLiteDatabase.beginTransaction();
            try {
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j5)});
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j6)});
                sharedPreferences.edit().clear().apply();
                supportSQLiteDatabase.setTransactionSuccessful();
            } finally {
                supportSQLiteDatabase.endTransaction();
            }
        }
    }

    public long getLastForceStopEventMillis() {
        Long longValue = this.mWorkDatabase.preferenceDao().getLongValue(KEY_LAST_FORCE_STOP_MS);
        if (longValue != null) {
            return longValue.longValue();
        }
        return 0L;
    }

    public boolean getNeedsReschedule() {
        Long longValue = this.mWorkDatabase.preferenceDao().getLongValue("reschedule_needed");
        return longValue != null && longValue.longValue() == 1;
    }

    public void setLastForceStopEventMillis(long j5) {
        this.mWorkDatabase.preferenceDao().insertPreference(new Preference(KEY_LAST_FORCE_STOP_MS, Long.valueOf(j5)));
    }

    public void setNeedsReschedule(boolean z5) {
        this.mWorkDatabase.preferenceDao().insertPreference(new Preference("reschedule_needed", z5));
    }
}
