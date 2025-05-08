package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzko implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzju zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzko(zzju zzjuVar, long j5) {
        this.zza = j5;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzk().zzf.zza(this.zza);
        this.zzb.zzj().zzc().zza("Session timeout duration set", Long.valueOf(this.zza));
    }
}
