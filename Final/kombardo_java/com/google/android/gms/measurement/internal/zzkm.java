package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzkm implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzju zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkm(zzju zzjuVar, boolean z5) {
        this.zza = z5;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zzae = this.zzb.zzu.zzae();
        boolean zzad = this.zzb.zzu.zzad();
        this.zzb.zzu.zza(this.zza);
        if (zzad == this.zza) {
            this.zzb.zzu.zzj().zzq().zza("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzu.zzae() == zzae || this.zzb.zzu.zzae() != this.zzb.zzu.zzad()) {
            this.zzb.zzu.zzj().zzw().zza("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zzae));
        }
        this.zzb.zzay();
    }
}
