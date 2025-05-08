package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class zzjg implements Callable<List<zzog>> {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ zzig zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjg(zzig zzigVar, zzp zzpVar, Bundle bundle) {
        this.zza = zzpVar;
        this.zzb = bundle;
        this.zzc = zzigVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzog> call() {
        zzou zzouVar;
        zzou zzouVar2;
        zzouVar = this.zzc.zza;
        zzouVar.zzs();
        zzouVar2 = this.zzc.zza;
        return zzouVar2.zza(this.zza, this.zzb);
    }
}
