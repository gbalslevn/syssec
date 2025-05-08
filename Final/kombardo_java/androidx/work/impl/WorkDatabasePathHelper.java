package androidx.work.impl;

import android.content.Context;
import androidx.work.Logger;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\r"}, d2 = {"Landroidx/work/impl/WorkDatabasePathHelper;", BuildConfig.FLAVOR, "()V", "getDatabasePath", "Ljava/io/File;", "context", "Landroid/content/Context;", "getDefaultDatabasePath", "getNoBackupPath", "migrateDatabase", BuildConfig.FLAVOR, "migrationPaths", BuildConfig.FLAVOR, "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WorkDatabasePathHelper {
    public static final WorkDatabasePathHelper INSTANCE = new WorkDatabasePathHelper();

    private WorkDatabasePathHelper() {
    }

    private final File getNoBackupPath(Context context) {
        return new File(Api21Impl.INSTANCE.getNoBackupFilesDir(context), "androidx.work.workdb");
    }

    public static final void migrateDatabase(Context context) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(context, "context");
        WorkDatabasePathHelper workDatabasePathHelper = INSTANCE;
        if (workDatabasePathHelper.getDefaultDatabasePath(context).exists()) {
            Logger logger = Logger.get();
            str = WorkDatabasePathHelperKt.TAG;
            logger.debug(str, "Migrating WorkDatabase to the no-backup directory");
            for (Map.Entry<File, File> entry : workDatabasePathHelper.migrationPaths(context).entrySet()) {
                File key = entry.getKey();
                File value = entry.getValue();
                if (key.exists()) {
                    if (value.exists()) {
                        Logger logger2 = Logger.get();
                        str3 = WorkDatabasePathHelperKt.TAG;
                        logger2.warning(str3, "Over-writing contents of " + value);
                    }
                    String str4 = key.renameTo(value) ? "Migrated " + key + "to " + value : "Renaming " + key + " to " + value + " failed";
                    Logger logger3 = Logger.get();
                    str2 = WorkDatabasePathHelperKt.TAG;
                    logger3.debug(str2, str4);
                }
            }
        }
    }

    public final File getDatabasePath(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getNoBackupPath(context);
    }

    public final File getDefaultDatabasePath(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        Intrinsics.checkNotNullExpressionValue(databasePath, "context.getDatabasePath(WORK_DATABASE_NAME)");
        return databasePath;
    }

    public final Map<File, File> migrationPaths(Context context) {
        String[] strArr;
        Intrinsics.checkNotNullParameter(context, "context");
        File defaultDatabasePath = getDefaultDatabasePath(context);
        File databasePath = getDatabasePath(context);
        strArr = WorkDatabasePathHelperKt.DATABASE_EXTRA_FILES;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(strArr.length), 16));
        for (String str : strArr) {
            Pair pair = TuplesKt.to(new File(defaultDatabasePath.getPath() + str), new File(databasePath.getPath() + str));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return MapsKt.plus(linkedHashMap, TuplesKt.to(defaultDatabasePath, databasePath));
    }
}
