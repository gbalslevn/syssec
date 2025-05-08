package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzbb {
    private static volatile Handler zza;
    private final zzjh zzb;
    private final Runnable zzc;
    private volatile long zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbb(zzjh zzjhVar) {
        Preconditions.checkNotNull(zzjhVar);
        this.zzb = zzjhVar;
        this.zzc = new zzba(this, zzjhVar);
    }

    private final Handler zzd() {
        Handler handler;
        if (zza != null) {
            return zza;
        }
        synchronized (zzbb.class) {
            try {
                if (zza == null) {
                    zza = new com.google.android.gms.internal.measurement.zzdj(this.zzb.zza().getMainLooper());
                }
                handler = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public abstract void zzb();

    public final boolean zzc() {
        return this.zzd != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        this.zzd = 0L;
        zzd().removeCallbacks(this.zzc);
    }

    public final void zza(long j5) {
        zza();
        if (j5 >= 0) {
            this.zzd = this.zzb.zzb().currentTimeMillis();
            if (zzd().postDelayed(this.zzc, j5)) {
                return;
            }
            this.zzb.zzj().zzg().zza("Failed to schedule delayed post. time", Long.valueOf(j5));
        }
    }
}
