package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzgf$zzf;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzax {
    private final String zza;
    private long zzb;
    private final /* synthetic */ zzar zzc;

    public zzax(zzar zzarVar, String str) {
        this.zzc = zzarVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = -1L;
    }

    public final List<zzav> zza() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                Cursor query = this.zzc.f_().query("raw_events", new String[]{"rowid", "name", "timestamp", "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{this.zza, String.valueOf(this.zzb)}, null, null, "rowid", "1000");
                if (!query.moveToFirst()) {
                    List<zzav> emptyList = Collections.emptyList();
                    query.close();
                    return emptyList;
                }
                do {
                    long j5 = query.getLong(0);
                    long j6 = query.getLong(3);
                    boolean z5 = query.getLong(5) == 1;
                    byte[] blob = query.getBlob(4);
                    if (j5 > this.zzb) {
                        this.zzb = j5;
                    }
                    try {
                        zzgf$zzf.zza zzaVar = (zzgf$zzf.zza) zzpj.zza(zzgf$zzf.zze(), blob);
                        String string = query.getString(1);
                        if (string == null) {
                            string = BuildConfig.FLAVOR;
                        }
                        zzaVar.zza(string).zzb(query.getLong(2));
                        arrayList.add(new zzav(j5, j6, z5, (zzgf$zzf) ((com.google.android.gms.internal.measurement.zzkg) zzaVar.zzaj())));
                    } catch (IOException e5) {
                        this.zzc.zzj().zzg().zza("Data loss. Failed to merge raw event. appId", zzgo.zza(this.zza), e5);
                    }
                } while (query.moveToNext());
                query.close();
            } catch (SQLiteException e6) {
                this.zzc.zzj().zzg().zza("Data loss. Error querying raw events batch. appId", zzgo.zza(this.zza), e6);
                if (0 != 0) {
                    cursor.close();
                }
            }
            return arrayList;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public zzax(zzar zzarVar, String str, long j5) {
        long zza;
        this.zzc = zzarVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        zza = zzarVar.zza("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j5)}, -1L);
        this.zzb = zza;
    }
}
