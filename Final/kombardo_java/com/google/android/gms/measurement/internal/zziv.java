package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class zziv implements Callable<List<zzag>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzig zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziv(zzig zzigVar, String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzigVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzag> call() {
        zzou zzouVar;
        zzou zzouVar2;
        zzouVar = this.zzd.zza;
        zzouVar.zzs();
        zzouVar2 = this.zzd.zza;
        return zzouVar2.zzf().zza(this.zza, this.zzb, this.zzc);
    }
}
