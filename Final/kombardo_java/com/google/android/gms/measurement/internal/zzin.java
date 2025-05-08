package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzin implements Runnable {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ zzig zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzin(zzig zzigVar, zzp zzpVar) {
        this.zza = zzpVar;
        this.zzb = zzigVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzou zzouVar;
        zzou zzouVar2;
        zzouVar = this.zzb.zza;
        zzouVar.zzs();
        zzouVar2 = this.zzb.zza;
        zzouVar2.zzd(this.zza);
    }
}
