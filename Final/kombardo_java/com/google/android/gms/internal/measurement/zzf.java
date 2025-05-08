package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class zzf {
    final zzh zza;
    final zzh zzb;
    private final zzbb zzc;
    private final zzl zzd;

    public zzf() {
        zzbb zzbbVar = new zzbb();
        this.zzc = zzbbVar;
        zzh zzhVar = new zzh(null, zzbbVar);
        this.zzb = zzhVar;
        this.zza = zzhVar.zza();
        zzl zzlVar = new zzl();
        this.zzd = zzlVar;
        zzhVar.zzc("require", new zzz(zzlVar));
        zzlVar.zza("internal.platform", new Callable() { // from class: com.google.android.gms.internal.measurement.zze
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzy();
            }
        });
        zzhVar.zzc("runtime.counter", new zzai(Double.valueOf(0.0d)));
    }

    public final zzaq zza(zzh zzhVar, zzgr$zzd... zzgr_zzdArr) {
        zzaq zzaqVar = zzaq.zzc;
        for (zzgr$zzd zzgr_zzd : zzgr_zzdArr) {
            zzaqVar = zzj.zza(zzgr_zzd);
            zzg.zza(this.zzb);
            if ((zzaqVar instanceof zzat) || (zzaqVar instanceof zzar)) {
                zzaqVar = this.zzc.zza(zzhVar, zzaqVar);
            }
        }
        return zzaqVar;
    }

    public final void zza(String str, Callable<? extends zzal> callable) {
        this.zzd.zza(str, callable);
    }
}
