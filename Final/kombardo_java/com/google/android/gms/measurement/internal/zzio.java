package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class zzio implements Callable<List<zzpo>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzig zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzio(zzig zzigVar, String str) {
        this.zza = str;
        this.zzb = zzigVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzpo> call() {
        zzou zzouVar;
        zzou zzouVar2;
        zzouVar = this.zzb.zza;
        zzouVar.zzs();
        zzouVar2 = this.zzb.zza;
        return zzouVar2.zzf().zzk(this.zza);
    }
}
