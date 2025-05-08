package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zznz implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zznx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznz(zznx zznxVar, long j5) {
        this.zza = j5;
        this.zzb = zznxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznx.zza(this.zzb, this.zza);
    }
}
