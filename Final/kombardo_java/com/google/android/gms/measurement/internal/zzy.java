package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzgf$zzf;
import com.google.android.gms.internal.measurement.zzgf$zzh;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzy {
    private zzgf$zzf zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzx zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzgf$zzf zza(String str, zzgf$zzf zzgf_zzf) {
        Object obj;
        String zzg = zzgf_zzf.zzg();
        List<zzgf$zzh> zzh = zzgf_zzf.zzh();
        this.zzd.h_();
        Long l5 = (Long) zzpj.zzb(zzgf_zzf, "_eid");
        boolean z5 = l5 != null;
        if (z5 && zzg.equals("_ep")) {
            Preconditions.checkNotNull(l5);
            this.zzd.h_();
            zzg = (String) zzpj.zzb(zzgf_zzf, "_en");
            if (TextUtils.isEmpty(zzg)) {
                this.zzd.zzj().zzo().zza("Extra parameter without an event name. eventId", l5);
                return null;
            }
            if (this.zza == null || this.zzb == null || l5.longValue() != this.zzb.longValue()) {
                Pair<zzgf$zzf, Long> zza = this.zzd.zzh().zza(str, l5);
                if (zza == null || (obj = zza.first) == null) {
                    this.zzd.zzj().zzo().zza("Extra parameter without existing main event. eventName, eventId", zzg, l5);
                    return null;
                }
                this.zza = (zzgf$zzf) obj;
                this.zzc = ((Long) zza.second).longValue();
                this.zzd.h_();
                this.zzb = (Long) zzpj.zzb(this.zza, "_eid");
            }
            long j5 = this.zzc - 1;
            this.zzc = j5;
            if (j5 <= 0) {
                zzar zzh2 = this.zzd.zzh();
                zzh2.zzv();
                zzh2.zzj().zzq().zza("Clearing complex main event info. appId", str);
                try {
                    zzh2.f_().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e5) {
                    zzh2.zzj().zzg().zza("Error clearing complex main event", e5);
                }
            } else {
                this.zzd.zzh().zza(str, l5, this.zzc, this.zza);
            }
            ArrayList arrayList = new ArrayList();
            for (zzgf$zzh zzgf_zzh : this.zza.zzh()) {
                this.zzd.h_();
                if (zzpj.zza(zzgf_zzf, zzgf_zzh.zzg()) == null) {
                    arrayList.add(zzgf_zzh);
                }
            }
            if (arrayList.isEmpty()) {
                this.zzd.zzj().zzo().zza("No unique parameters in main event. eventName", zzg);
            } else {
                arrayList.addAll(zzh);
                zzh = arrayList;
            }
        } else if (z5) {
            this.zzb = l5;
            this.zza = zzgf_zzf;
            this.zzd.h_();
            long longValue = ((Long) zzpj.zza(zzgf_zzf, "_epc", (Object) 0L)).longValue();
            this.zzc = longValue;
            if (longValue <= 0) {
                this.zzd.zzj().zzo().zza("Complex event with zero extra param count. eventName", zzg);
            } else {
                this.zzd.zzh().zza(str, (Long) Preconditions.checkNotNull(l5), this.zzc, zzgf_zzf);
            }
        }
        return (zzgf$zzf) ((com.google.android.gms.internal.measurement.zzkg) zzgf_zzf.zzch().zza(zzg).zzd().zza(zzh).zzaj());
    }

    private zzy(zzx zzxVar) {
        this.zzd = zzxVar;
    }
}
