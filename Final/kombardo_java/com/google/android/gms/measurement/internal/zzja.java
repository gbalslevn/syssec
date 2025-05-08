package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class zzja implements Callable<zzap> {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ zzig zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzja(zzig zzigVar, zzp zzpVar) {
        this.zza = zzpVar;
        this.zzb = zzigVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzap call() {
        zzou zzouVar;
        zzou zzouVar2;
        zzouVar = this.zzb.zza;
        zzouVar.zzs();
        zzouVar2 = this.zzb.zza;
        return new zzap(zzouVar2.zza(this.zza.zza));
    }
}
