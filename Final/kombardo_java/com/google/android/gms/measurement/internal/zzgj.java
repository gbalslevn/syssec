package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzgj extends zzf {
    private final zzgi zza;
    private boolean zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgj(zzic zzicVar) {
        super(zzicVar);
        this.zza = new zzgi(this, zza(), "google_app_measurement_local.db");
    }

    private static long zza(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
            if (cursor.moveToFirst()) {
                long j5 = cursor.getLong(0);
                cursor.close();
                return j5;
            }
            cursor.close();
            return -1L;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final SQLiteDatabase zzaf() {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    private final boolean zzag() {
        return zza().getDatabasePath("google_app_measurement_local.db").exists();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzab() {
        return false;
    }

    public final void zzac() {
        int delete;
        zzv();
        try {
            SQLiteDatabase zzaf = zzaf();
            if (zzaf == null || (delete = zzaf.delete("messages", null, null)) <= 0) {
                return;
            }
            zzj().zzq().zza("Reset local analytics data. records", Integer.valueOf(delete));
        } catch (SQLiteException e5) {
            zzj().zzg().zza("Error resetting local analytics data. error", e5);
        }
    }

    public final boolean zzad() {
        return zza(3, new byte[0]);
    }

    public final boolean zzae() {
        zzv();
        if (this.zzb || !zzag()) {
            return false;
        }
        int i5 = 5;
        for (int i6 = 0; i6 < 5; i6++) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    SQLiteDatabase zzaf = zzaf();
                    if (zzaf == null) {
                        this.zzb = true;
                        if (zzaf != null) {
                            zzaf.close();
                        }
                        return false;
                    }
                    zzaf.beginTransaction();
                    zzaf.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    zzaf.setTransactionSuccessful();
                    zzaf.endTransaction();
                    zzaf.close();
                    return true;
                } catch (SQLiteFullException e5) {
                    zzj().zzg().zza("Error deleting app launch break from local database", e5);
                    this.zzb = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep(i5);
                i5 += 20;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e6) {
                if (0 != 0) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Throwable th) {
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                }
                zzj().zzg().zza("Error deleting app launch break from local database", e6);
                this.zzb = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        zzj().zzr().zza("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzaf zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzai zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgg zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgj zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzgl zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzgo zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzha zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzju zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzls zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzlz zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzme zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zznx zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzv() {
        super.zzv();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0201 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0201 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0201 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x020d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<AbstractSafeParcelable> zza(int i5) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase2;
        SQLiteDatabase sQLiteDatabase3;
        long j5;
        String str;
        String[] strArr;
        Parcel obtain;
        zzpm zzpmVar;
        zzag zzagVar;
        zzv();
        Cursor cursor2 = null;
        if (this.zzb) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!zzag()) {
            return arrayList;
        }
        int i6 = 5;
        int i7 = 0;
        for (int i8 = 5; i7 < i8; i8 = 5) {
            try {
                sQLiteDatabase2 = zzaf();
                if (sQLiteDatabase2 == null) {
                    try {
                        this.zzb = true;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.close();
                        }
                        return null;
                    } catch (SQLiteFullException e5) {
                        e = e5;
                        cursor = null;
                        zzj().zzg().zza("Error reading entries from local database", e);
                        this.zzb = true;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase2 != null) {
                        }
                        i7++;
                    } catch (SQLiteException e6) {
                        e = e6;
                        cursor = null;
                        if (sQLiteDatabase2 != null) {
                        }
                        zzj().zzg().zza("Error reading entries from local database", e);
                        this.zzb = true;
                        if (cursor != null) {
                        }
                        if (sQLiteDatabase2 != null) {
                        }
                        i7++;
                    }
                } else {
                    try {
                        try {
                            sQLiteDatabase2.beginTransaction();
                            long zza = zza(sQLiteDatabase2);
                            j5 = -1;
                            if (zza != -1) {
                                str = "rowid<?";
                                strArr = new String[]{String.valueOf(zza)};
                            } else {
                                str = null;
                                strArr = null;
                            }
                            sQLiteDatabase = sQLiteDatabase2;
                        } catch (SQLiteFullException e7) {
                            e = e7;
                            cursor = null;
                            zzj().zzg().zza("Error reading entries from local database", e);
                            this.zzb = true;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase2 != null) {
                                sQLiteDatabase2.close();
                            }
                            i7++;
                        } catch (SQLiteException e8) {
                            e = e8;
                            cursor = null;
                            if (sQLiteDatabase2 != null) {
                                try {
                                    if (sQLiteDatabase2.inTransaction()) {
                                        sQLiteDatabase2.endTransaction();
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    cursor2 = cursor;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                    throw th;
                                }
                            }
                            zzj().zzg().zza("Error reading entries from local database", e);
                            this.zzb = true;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase2 != null) {
                                sQLiteDatabase2.close();
                            }
                            i7++;
                        }
                    } catch (SQLiteDatabaseLockedException unused) {
                        sQLiteDatabase = sQLiteDatabase2;
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteDatabase = sQLiteDatabase2;
                        if (cursor2 != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        throw th;
                    }
                    try {
                        cursor = sQLiteDatabase2.query("messages", new String[]{"rowid", "type", "entry"}, str, strArr, null, null, "rowid asc", Integer.toString(100));
                        while (cursor.moveToNext()) {
                            try {
                                j5 = cursor.getLong(0);
                                int i9 = cursor.getInt(1);
                                byte[] blob = cursor.getBlob(2);
                                if (i9 == 0) {
                                    obtain = Parcel.obtain();
                                    try {
                                        try {
                                            obtain.unmarshall(blob, 0, blob.length);
                                            obtain.setDataPosition(0);
                                            zzbl createFromParcel = zzbl.CREATOR.createFromParcel(obtain);
                                            if (createFromParcel != null) {
                                                arrayList.add(createFromParcel);
                                            }
                                        } finally {
                                        }
                                    } catch (SafeParcelReader.ParseException unused2) {
                                        zzj().zzg().zza("Failed to load event from local database");
                                        obtain.recycle();
                                    }
                                } else if (i9 == 1) {
                                    obtain = Parcel.obtain();
                                    try {
                                        try {
                                            obtain.unmarshall(blob, 0, blob.length);
                                            obtain.setDataPosition(0);
                                            zzpmVar = zzpm.CREATOR.createFromParcel(obtain);
                                        } finally {
                                        }
                                    } catch (SafeParcelReader.ParseException unused3) {
                                        zzj().zzg().zza("Failed to load user property from local database");
                                        obtain.recycle();
                                        zzpmVar = null;
                                    }
                                    if (zzpmVar != null) {
                                        arrayList.add(zzpmVar);
                                    }
                                } else if (i9 == 2) {
                                    obtain = Parcel.obtain();
                                    try {
                                        try {
                                            obtain.unmarshall(blob, 0, blob.length);
                                            obtain.setDataPosition(0);
                                            zzagVar = zzag.CREATOR.createFromParcel(obtain);
                                        } catch (SafeParcelReader.ParseException unused4) {
                                            zzj().zzg().zza("Failed to load conditional user property from local database");
                                            obtain.recycle();
                                            zzagVar = null;
                                        }
                                        if (zzagVar != null) {
                                            arrayList.add(zzagVar);
                                        }
                                    } finally {
                                    }
                                } else if (i9 == 3) {
                                    zzj().zzr().zza("Skipping app launch break");
                                } else {
                                    zzj().zzg().zza("Unknown record type in local database");
                                }
                            } catch (SQLiteDatabaseLockedException unused5) {
                                sQLiteDatabase3 = sQLiteDatabase;
                                SystemClock.sleep(i6);
                                i6 += 20;
                                if (cursor != null) {
                                }
                                if (sQLiteDatabase3 == null) {
                                }
                                i7++;
                            } catch (SQLiteFullException e9) {
                                e = e9;
                                sQLiteDatabase2 = sQLiteDatabase;
                                zzj().zzg().zza("Error reading entries from local database", e);
                                this.zzb = true;
                                if (cursor != null) {
                                }
                                if (sQLiteDatabase2 != null) {
                                }
                                i7++;
                            } catch (SQLiteException e10) {
                                e = e10;
                                sQLiteDatabase2 = sQLiteDatabase;
                                if (sQLiteDatabase2 != null) {
                                }
                                zzj().zzg().zza("Error reading entries from local database", e);
                                this.zzb = true;
                                if (cursor != null) {
                                }
                                if (sQLiteDatabase2 != null) {
                                }
                                i7++;
                            } catch (Throwable th3) {
                                th = th3;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                }
                                if (sQLiteDatabase != null) {
                                }
                                throw th;
                            }
                        }
                        if (sQLiteDatabase.delete("messages", "rowid <= ?", new String[]{Long.toString(j5)}) < arrayList.size()) {
                            zzj().zzg().zza("Fewer entries removed from local database than expected");
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        sQLiteDatabase.endTransaction();
                        cursor.close();
                        sQLiteDatabase.close();
                        return arrayList;
                    } catch (SQLiteDatabaseLockedException unused6) {
                        cursor = null;
                        sQLiteDatabase3 = sQLiteDatabase;
                        SystemClock.sleep(i6);
                        i6 += 20;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase3 == null) {
                            sQLiteDatabase3.close();
                        }
                        i7++;
                    } catch (SQLiteFullException e11) {
                        e = e11;
                        cursor = null;
                    } catch (SQLiteException e12) {
                        e = e12;
                        cursor = null;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
            } catch (SQLiteDatabaseLockedException unused7) {
                cursor = null;
                sQLiteDatabase3 = null;
            } catch (SQLiteFullException e13) {
                e = e13;
                cursor = null;
                sQLiteDatabase2 = null;
            } catch (SQLiteException e14) {
                e = e14;
                cursor = null;
                sQLiteDatabase2 = null;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabase = null;
            }
        }
        zzj().zzr().zza("Failed to read events from database in reasonable time");
        return null;
    }

    public final boolean zza(zzag zzagVar) {
        zzs();
        byte[] zza = zzpn.zza((Parcelable) zzagVar);
        if (zza.length > 131072) {
            zzj().zzo().zza("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return zza(2, zza);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d A[Catch: all -> 0x0058, SQLiteException -> 0x005c, SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, TRY_ENTER, TryCatch #6 {SQLiteDatabaseLockedException -> 0x00bf, SQLiteFullException -> 0x005e, SQLiteException -> 0x005c, all -> 0x0058, blocks: (B:74:0x004d, B:76:0x0053, B:17:0x006d, B:19:0x0092, B:20:0x00ac), top: B:73:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b7  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zza(int i5, byte[] bArr) {
        SQLiteDatabase sQLiteDatabase;
        ?? r10;
        long j5;
        zzv();
        ?? r22 = 0;
        if (this.zzb) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i5));
        contentValues.put("entry", bArr);
        int i6 = 0;
        int i7 = 5;
        for (int i8 = 5; i6 < i8; i8 = 5) {
            Cursor cursor = null;
            r7 = null;
            cursor = null;
            Cursor cursor2 = null;
            cursor = null;
            SQLiteDatabase sQLiteDatabase2 = null;
            try {
                sQLiteDatabase = zzaf();
                try {
                    if (sQLiteDatabase == null) {
                        this.zzb = true;
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        return r22;
                    }
                    sQLiteDatabase.beginTransaction();
                    r10 = sQLiteDatabase.rawQuery("select count(1) from messages", null);
                    if (r10 != 0) {
                        try {
                            if (r10.moveToFirst()) {
                                j5 = r10.getLong(r22);
                                if (j5 >= 100000) {
                                    zzj().zzg().zza("Data loss, local db full");
                                    long j6 = 100001 - j5;
                                    long delete = sQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j6)});
                                    if (delete != j6) {
                                        zzj().zzg().zza("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j6), Long.valueOf(delete), Long.valueOf(j6 - delete));
                                    }
                                }
                                sQLiteDatabase.insertOrThrow("messages", null, contentValues);
                                sQLiteDatabase.setTransactionSuccessful();
                                sQLiteDatabase.endTransaction();
                                if (r10 != 0) {
                                    r10.close();
                                }
                                sQLiteDatabase.close();
                                return true;
                            }
                        } catch (SQLiteDatabaseLockedException unused) {
                            cursor2 = r10;
                            SystemClock.sleep(i7);
                            i7 += 20;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i6++;
                            r22 = 0;
                        } catch (SQLiteFullException e5) {
                            e = e5;
                            cursor = r10;
                            try {
                                zzj().zzg().zza("Error writing entry; local database full", e);
                                this.zzb = true;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                i6++;
                                r22 = 0;
                            } catch (Throwable th) {
                                th = th;
                                if (cursor != null) {
                                }
                                if (sQLiteDatabase != null) {
                                }
                                throw th;
                            }
                        } catch (SQLiteException e6) {
                            e = e6;
                            sQLiteDatabase2 = sQLiteDatabase;
                            r10 = r10;
                            if (sQLiteDatabase2 != null) {
                                try {
                                    if (sQLiteDatabase2.inTransaction()) {
                                        sQLiteDatabase2.endTransaction();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    cursor = r10;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                    throw th;
                                }
                            }
                            zzj().zzg().zza("Error writing entry to local database", e);
                            this.zzb = true;
                            if (r10 != 0) {
                                r10.close();
                            }
                            if (sQLiteDatabase2 != null) {
                                sQLiteDatabase2.close();
                            }
                            i6++;
                            r22 = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            cursor = r10;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th;
                        }
                    }
                    j5 = 0;
                    if (j5 >= 100000) {
                    }
                    sQLiteDatabase.insertOrThrow("messages", null, contentValues);
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    if (r10 != 0) {
                    }
                    sQLiteDatabase.close();
                    return true;
                } catch (SQLiteDatabaseLockedException unused2) {
                } catch (SQLiteFullException e7) {
                    e = e7;
                } catch (SQLiteException e8) {
                    e = e8;
                    r10 = 0;
                }
            } catch (SQLiteDatabaseLockedException unused3) {
                sQLiteDatabase = null;
            } catch (SQLiteFullException e9) {
                e = e9;
                sQLiteDatabase = null;
            } catch (SQLiteException e10) {
                e = e10;
                r10 = 0;
            } catch (Throwable th4) {
                th = th4;
                sQLiteDatabase = null;
                if (cursor != null) {
                }
                if (sQLiteDatabase != null) {
                }
                throw th;
            }
        }
        zzj().zzq().zza("Failed to write entry to local database");
        return false;
    }

    public final boolean zza(zzbl zzblVar) {
        Parcel obtain = Parcel.obtain();
        zzblVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            zzj().zzo().zza("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return zza(0, marshall);
    }

    public final boolean zza(zzpm zzpmVar) {
        Parcel obtain = Parcel.obtain();
        zzpmVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            zzj().zzo().zza("User property too long for local database. Sending directly to service");
            return false;
        }
        return zza(1, marshall);
    }
}
