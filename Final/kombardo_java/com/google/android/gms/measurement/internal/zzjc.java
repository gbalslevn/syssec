package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzjc implements Runnable {
    private final /* synthetic */ zzbl zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzig zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjc(zzig zzigVar, zzbl zzblVar, String str) {
        this.zza = zzblVar;
        this.zzb = str;
        this.zzc = zzigVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzou zzouVar;
        zzou zzouVar2;
        zzouVar = this.zzc.zza;
        zzouVar.zzs();
        zzouVar2 = this.zzc.zza;
        zzouVar2.zza(this.zza, this.zzb);
    }
}
