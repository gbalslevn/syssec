package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class zza extends zzg {
    private final Map<String, Long> zza;
    private final Map<String, Integer> zzb;
    private long zzc;

    public zza(zzic zzicVar) {
        super(zzicVar);
        this.zzb = new ArrayMap();
        this.zza = new ArrayMap();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzb(zza zzaVar, String str, long j5) {
        zzaVar.zzv();
        Preconditions.checkNotEmpty(str);
        Integer num = zzaVar.zzb.get(str);
        if (num != null) {
            zzlw zza = zzaVar.zzp().zza(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                zzaVar.zzb.remove(str);
                Long l5 = zzaVar.zza.get(str);
                if (l5 == null) {
                    zzaVar.zzj().zzg().zza("First ad unit exposure time was never set");
                } else {
                    long longValue = j5 - l5.longValue();
                    zzaVar.zza.remove(str);
                    zzaVar.zza(str, longValue, zza);
                }
                if (zzaVar.zzb.isEmpty()) {
                    long j6 = zzaVar.zzc;
                    if (j6 == 0) {
                        zzaVar.zzj().zzg().zza("First ad exposure time was never set");
                        return;
                    } else {
                        zzaVar.zza(j5 - j6, zza);
                        zzaVar.zzc = 0L;
                        return;
                    }
                }
                return;
            }
            zzaVar.zzb.put(str, Integer.valueOf(intValue));
            return;
        }
        zzaVar.zzj().zzg().zza("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zza zzaVar, String str, long j5) {
        zzaVar.zzv();
        Preconditions.checkNotEmpty(str);
        if (zzaVar.zzb.isEmpty()) {
            zzaVar.zzc = j5;
        }
        Integer num = zzaVar.zzb.get(str);
        if (num != null) {
            zzaVar.zzb.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (zzaVar.zzb.size() >= 100) {
            zzaVar.zzj().zzr().zza("Too many ads visible");
        } else {
            zzaVar.zzb.put(str, 1);
            zzaVar.zza.put(str, Long.valueOf(j5));
        }
    }

    public final void zza(String str, long j5) {
        if (str != null && str.length() != 0) {
            zzl().zzb(new zzc(this, str, j5));
        } else {
            zzj().zzg().zza("Ad unit id must be a non-empty string");
        }
    }

    private final void zza(long j5, zzlw zzlwVar) {
        if (zzlwVar == null) {
            zzj().zzq().zza("Not logging ad exposure. No active activity");
            return;
        }
        if (j5 < 1000) {
            zzj().zzq().zza("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j5));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j5);
        zzpn.zza(zzlwVar, bundle, true);
        zzm().zzc("am", "_xa", bundle);
    }

    public final void zzb(String str, long j5) {
        if (str != null && str.length() != 0) {
            zzl().zzb(new zzb(this, str, j5));
        } else {
            zzj().zzg().zza("Ad unit id must be a non-empty string");
        }
    }

    private final void zza(String str, long j5, zzlw zzlwVar) {
        if (zzlwVar == null) {
            zzj().zzq().zza("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j5 < 1000) {
            zzj().zzq().zza("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j5));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j5);
        zzpn.zza(zzlwVar, bundle, true);
        zzm().zzc("am", "_xu", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(long j5) {
        Iterator<String> it = this.zza.keySet().iterator();
        while (it.hasNext()) {
            this.zza.put(it.next(), Long.valueOf(j5));
        }
        if (this.zza.isEmpty()) {
            return;
        }
        this.zzc = j5;
    }

    public final void zza(long j5) {
        zzlw zza = zzp().zza(false);
        for (String str : this.zza.keySet()) {
            zza(str, j5 - this.zza.get(str).longValue(), zza);
        }
        if (!this.zza.isEmpty()) {
            zza(j5 - this.zzc, zza);
        }
        zzb(j5);
    }
}
