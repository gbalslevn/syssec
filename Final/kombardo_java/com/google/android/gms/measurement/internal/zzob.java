package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzob implements Runnable {
    private long zza;
    private long zzb;
    private final /* synthetic */ zzny zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzob(zzny zznyVar, long j5, long j6) {
        this.zzc = zznyVar;
        this.zza = j5;
        this.zzb = j6;
    }

    public static /* synthetic */ void zza(zzob zzobVar) {
        zzny zznyVar = zzobVar.zzc;
        long j5 = zzobVar.zza;
        long j6 = zzobVar.zzb;
        zznyVar.zza.zzv();
        zznyVar.zza.zzj().zzc().zza("Application going to the background");
        zznyVar.zza.zzk().zzn.zza(true);
        zznyVar.zza.zza(true);
        if (!zznyVar.zza.zze().zzx()) {
            zznyVar.zza.zza(false, false, j6);
            zznyVar.zza.zzb.zzb(j6);
        }
        zznyVar.zza.zzj().zzp().zza("Application backgrounded at: timestamp_millis", Long.valueOf(j5));
        zznyVar.zza.zzm().zzao();
        if (zznyVar.zza.zze().zza(zzbn.zzcm)) {
            long zzc = zznyVar.zza.zzs().zzd(zznyVar.zza.zza().getPackageName(), zznyVar.zza.zze().zzr()) ? 1000L : zznyVar.zza.zze().zzc(zznyVar.zza.zza().getPackageName(), zzbn.zzz);
            zznyVar.zza.zzj().zzq().zza("[sgtm] Scheduling batch upload with minimum latency in millis", Long.valueOf(zzc));
            zznyVar.zza.zzo().zza(zzc);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzoa
            @Override // java.lang.Runnable
            public final void run() {
                zzob.zza(zzob.this);
            }
        });
    }
}
