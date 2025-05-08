package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlj implements Runnable {
    private final /* synthetic */ zzjj zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzju zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlj(zzju zzjuVar, zzjj zzjjVar, long j5, boolean z5) {
        this.zza = zzjjVar;
        this.zzb = j5;
        this.zzc = z5;
        this.zzd = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zza(this.zza);
        zzju.zza(this.zzd, this.zza, this.zzb, true, this.zzc);
    }
}
