package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zznv implements Runnable {
    private final /* synthetic */ zzou zza;
    private final /* synthetic */ Runnable zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznv(zznr zznrVar, zzou zzouVar, Runnable runnable) {
        this.zza = zzouVar;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzs();
        this.zza.zza(this.zzb);
        this.zza.zzx();
    }
}
