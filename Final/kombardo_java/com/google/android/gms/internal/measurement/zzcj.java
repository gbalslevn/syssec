package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public abstract class zzcj extends SQLiteOpenHelper {
    public zzcj(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i5) {
        this(context, str, null, 1, zzco.zza);
    }

    private zzcj(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i5, zzco zzcoVar) {
        super(context, (str == null || zzcf.zza().zzb(str, zzcoVar, zzcl.SQLITE_OPEN_HELPER_TYPE).equals(BuildConfig.FLAVOR)) ? null : str, (SQLiteDatabase.CursorFactory) null, 1);
    }
}
