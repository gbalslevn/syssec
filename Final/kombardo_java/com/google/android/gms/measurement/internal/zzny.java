package com.google.android.gms.measurement.internal;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzny {
    final /* synthetic */ zznx zza;
    private zzob zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzny(zznx zznxVar) {
        this.zza = zznxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(long j5) {
        Handler handler;
        this.zzb = new zzob(this, this.zza.zzb().currentTimeMillis(), j5);
        handler = this.zza.zzc;
        handler.postDelayed(this.zzb, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        Handler handler;
        this.zza.zzv();
        if (this.zzb != null) {
            handler = this.zza.zzc;
            handler.removeCallbacks(this.zzb);
        }
        this.zza.zzk().zzn.zza(false);
        this.zza.zza(false);
        if (this.zza.zze().zza(zzbn.zzct) && this.zza.zzm().zzax()) {
            this.zza.zzj().zzq().zza("Retrying trigger URI registration in foreground");
            this.zza.zzm().zzav();
        }
    }
}
