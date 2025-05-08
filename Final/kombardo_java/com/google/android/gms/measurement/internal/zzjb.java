package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class zzjb implements Callable<byte[]> {
    private final /* synthetic */ zzbl zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzig zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjb(zzig zzigVar, zzbl zzblVar, String str) {
        this.zza = zzblVar;
        this.zzb = str;
        this.zzc = zzigVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() {
        zzou zzouVar;
        zzou zzouVar2;
        zzouVar = this.zzc.zza;
        zzouVar.zzs();
        zzouVar2 = this.zzc.zza;
        return zzouVar2.zzm().zza(this.zza, this.zzb);
    }
}
