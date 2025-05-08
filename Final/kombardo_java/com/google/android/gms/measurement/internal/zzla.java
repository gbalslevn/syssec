package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzla implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zza;
    private final /* synthetic */ zzju zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzla(zzju zzjuVar, com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        this.zza = zzdqVar;
        this.zzb = zzjuVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Long valueOf;
        zznx zzr = this.zzb.zzr();
        if (!zzr.zzk().zzp().zzh()) {
            zzr.zzj().zzw().zza("Analytics storage consent denied; will not get session id");
        } else if (!zzr.zzk().zza(zzr.zzb().currentTimeMillis()) && zzr.zzk().zzl.zza() != 0) {
            valueOf = Long.valueOf(zzr.zzk().zzl.zza());
            if (valueOf == null) {
                this.zzb.zzu.zzv().zza(this.zza, valueOf.longValue());
                return;
            }
            try {
                this.zza.zza(null);
                return;
            } catch (RemoteException e5) {
                this.zzb.zzu.zzj().zzg().zza("getSessionId failed with exception", e5);
                return;
            }
        }
        valueOf = null;
        if (valueOf == null) {
        }
    }
}
