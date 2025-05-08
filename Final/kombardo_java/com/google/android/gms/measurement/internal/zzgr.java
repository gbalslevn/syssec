package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzgr implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzgo zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgr(zzgo zzgoVar, int i5, String str, Object obj, Object obj2, Object obj3) {
        this.zza = i5;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
        this.zzf = zzgoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c5;
        long j5;
        char c6;
        long j6;
        zzha zzn = this.zzf.zzu.zzn();
        if (!zzn.zzag()) {
            this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        c5 = this.zzf.zza;
        if (c5 == 0) {
            if (this.zzf.zze().zzaa()) {
                this.zzf.zza = 'C';
            } else {
                this.zzf.zza = 'c';
            }
        }
        j5 = this.zzf.zzb;
        if (j5 < 0) {
            this.zzf.zzb = 114010L;
        }
        char charAt = "01VDIWEA?".charAt(this.zza);
        c6 = this.zzf.zza;
        j6 = this.zzf.zzb;
        String str = "2" + charAt + c6 + j6 + ":" + zzgo.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
        if (str.length() > 1024) {
            str = this.zzb.substring(0, 1024);
        }
        zzhe zzheVar = zzn.zzb;
        if (zzheVar != null) {
            zzheVar.zza(str, 1L);
        }
    }
}
