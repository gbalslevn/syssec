package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class zzay {
    private static Set<String> zza(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzgo zzgoVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) {
        if (zzgoVar != null) {
            if (!zza(zzgoVar, sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                Set<String> zza = zza(sQLiteDatabase, str);
                for (String str4 : str3.split(",")) {
                    if (!zza.remove(str4)) {
                        throw new SQLiteException("Table " + str + " is missing required column: " + str4);
                    }
                }
                if (strArr != null) {
                    for (int i5 = 0; i5 < strArr.length; i5 += 2) {
                        if (!zza.remove(strArr[i5])) {
                            sQLiteDatabase.execSQL(strArr[i5 + 1]);
                        }
                    }
                }
                if (zza.isEmpty()) {
                    return;
                }
                zzgoVar.zzr().zza("Table has extra columns. table, columns", str, TextUtils.join(", ", zza));
                return;
            } catch (SQLiteException e5) {
                zzgoVar.zzg().zza("Failed to verify columns on table that was just created", str);
                throw e5;
            }
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzgo zzgoVar, SQLiteDatabase sQLiteDatabase) {
        if (zzgoVar != null) {
            File file = new File(com.google.android.gms.internal.measurement.zzcf.zza().zza(sQLiteDatabase.getPath()));
            if (!file.setReadable(false, false)) {
                zzgoVar.zzr().zza("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                zzgoVar.zzr().zza("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                zzgoVar.zzr().zza("Failed to turn on database read permission for owner");
            }
            if (file.setWritable(true, true)) {
                return;
            }
            zzgoVar.zzr().zza("Failed to turn on database write permission for owner");
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }

    private static boolean zza(zzgo zzgoVar, SQLiteDatabase sQLiteDatabase, String str) {
        if (zzgoVar != null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                    boolean moveToFirst = cursor.moveToFirst();
                    cursor.close();
                    return moveToFirst;
                } catch (SQLiteException e5) {
                    zzgoVar.zzr().zza("Error querying for table", str, e5);
                    if (cursor == null) {
                        return false;
                    }
                    cursor.close();
                    return false;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }
}
