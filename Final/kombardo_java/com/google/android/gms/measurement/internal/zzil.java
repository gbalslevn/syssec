package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzil implements Runnable {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ zzig zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzil(zzig zzigVar, zzp zzpVar) {
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
        zzp zzpVar = this.zza;
        zzouVar2.zzl().zzv();
        zzouVar2.zzt();
        Preconditions.checkNotEmpty(zzpVar.zza);
        zzouVar2.zza(zzpVar);
    }
}
