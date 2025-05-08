package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzod {
    protected long zza;
    final /* synthetic */ zznx zzb;
    private long zzc;
    private final zzbb zzd;

    public zzod(zznx zznxVar) {
        this.zzb = zznxVar;
        this.zzd = new zzoc(this, zznxVar.zzu);
        long elapsedRealtime = zznxVar.zzb().elapsedRealtime();
        this.zzc = elapsedRealtime;
        this.zza = elapsedRealtime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zza(long j5) {
        long j6 = j5 - this.zza;
        this.zza = j5;
        return j6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(long j5) {
        this.zzd.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(long j5) {
        this.zzb.zzv();
        this.zzd.zza();
        this.zzc = j5;
        this.zza = j5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzod zzodVar) {
        zzodVar.zzb.zzv();
        zzodVar.zza(false, false, zzodVar.zzb.zzb().elapsedRealtime());
        zzodVar.zzb.zzc().zza(zzodVar.zzb.zzb().elapsedRealtime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        this.zzd.zza();
        if (this.zzb.zze().zza(zzbn.zzcw)) {
            this.zzc = this.zzb.zzb().elapsedRealtime();
        } else {
            this.zzc = 0L;
        }
        this.zza = this.zzc;
    }

    public final boolean zza(boolean z5, boolean z6, long j5) {
        this.zzb.zzv();
        this.zzb.zzw();
        if (this.zzb.zzu.zzae()) {
            this.zzb.zzk().zzk.zza(this.zzb.zzb().currentTimeMillis());
        }
        long j6 = j5 - this.zzc;
        if (!z5 && j6 < 1000) {
            this.zzb.zzj().zzq().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j6));
            return false;
        }
        if (!z6) {
            j6 = zza(j5);
        }
        this.zzb.zzj().zzq().zza("Recording user engagement, ms", Long.valueOf(j6));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j6);
        zzpn.zza(this.zzb.zzp().zza(!this.zzb.zze().zzx()), bundle, true);
        if (!z6) {
            this.zzb.zzm().zzc("auto", "_e", bundle);
        }
        this.zzc = j5;
        this.zzd.zza();
        this.zzd.zza(zzbn.zzbk.zza(null).longValue());
        return true;
    }
}
