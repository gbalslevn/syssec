package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zze implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zza zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(zza zzaVar, long j5) {
        this.zza = j5;
        this.zzb = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
