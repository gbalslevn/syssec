package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzir implements Runnable {
    private final /* synthetic */ zzag zza;
    private final /* synthetic */ zzig zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzir(zzig zzigVar, zzag zzagVar) {
        this.zza = zzagVar;
        this.zzb = zzigVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzou zzouVar;
        zzou zzouVar2;
        zzou zzouVar3;
        zzouVar = this.zzb.zza;
        zzouVar.zzs();
        if (this.zza.zzc.zza() == null) {
            zzouVar3 = this.zzb.zza;
            zzouVar3.zza(this.zza);
        } else {
            zzouVar2 = this.zzb.zza;
            zzouVar2.zzb(this.zza);
        }
    }
}
