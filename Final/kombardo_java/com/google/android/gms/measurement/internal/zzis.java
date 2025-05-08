package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzis implements Runnable {
    private final /* synthetic */ zzag zza;
    private final /* synthetic */ zzp zzb;
    private final /* synthetic */ zzig zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzis(zzig zzigVar, zzag zzagVar, zzp zzpVar) {
        this.zza = zzagVar;
        this.zzb = zzpVar;
        this.zzc = zzigVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzou zzouVar;
        zzou zzouVar2;
        zzou zzouVar3;
        zzouVar = this.zzc.zza;
        zzouVar.zzs();
        if (this.zza.zzc.zza() == null) {
            zzouVar3 = this.zzc.zza;
            zzouVar3.zza(this.zza, this.zzb);
        } else {
            zzouVar2 = this.zzc.zza;
            zzouVar2.zzb(this.zza, this.zzb);
        }
    }
}
