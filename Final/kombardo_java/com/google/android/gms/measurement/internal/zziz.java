package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zziz implements Runnable {
    private final /* synthetic */ zzbl zza;
    private final /* synthetic */ zzp zzb;
    private final /* synthetic */ zzig zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziz(zzig zzigVar, zzbl zzblVar, zzp zzpVar) {
        this.zza = zzblVar;
        this.zzb = zzpVar;
        this.zzc = zzigVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzc(this.zzc.zzb(this.zza, this.zzb), this.zzb);
    }
}
