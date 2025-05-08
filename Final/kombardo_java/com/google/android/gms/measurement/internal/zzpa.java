package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzpa implements Callable<String> {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ zzou zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpa(zzou zzouVar, zzp zzpVar) {
        this.zza = zzpVar;
        this.zzb = zzouVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        if (!this.zzb.zzb((String) Preconditions.checkNotNull(this.zza.zza)).zzh() || !zzjj.zzb(this.zza.zzt).zzh()) {
            this.zzb.zzj().zzq().zza("Analytics storage consent denied. Returning null app instance id");
            return null;
        }
        zzh zza = this.zzb.zza(this.zza);
        if (zza != null) {
            return zza.zzad();
        }
        this.zzb.zzj().zzr().zza("App info was null when attempting to get app instance id");
        return null;
    }
}
