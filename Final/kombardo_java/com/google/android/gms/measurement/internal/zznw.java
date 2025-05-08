package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zznw implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zznx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznw(zznx zznxVar, long j5) {
        this.zza = j5;
        this.zzb = zznxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznx.zzb(this.zzb, this.zza);
    }
}
