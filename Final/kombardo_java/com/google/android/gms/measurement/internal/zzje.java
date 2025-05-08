package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzje implements Runnable {
    private final /* synthetic */ zzpm zza;
    private final /* synthetic */ zzp zzb;
    private final /* synthetic */ zzig zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzje(zzig zzigVar, zzpm zzpmVar, zzp zzpVar) {
        this.zza = zzpmVar;
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
        if (this.zza.zza() == null) {
            zzouVar3 = this.zzc.zza;
            zzouVar3.zza(this.zza.zza, this.zzb);
        } else {
            zzouVar2 = this.zzc.zza;
            zzouVar2.zza(this.zza, this.zzb);
        }
    }
}
