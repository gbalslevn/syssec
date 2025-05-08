package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlg implements Runnable {
    private final /* synthetic */ zzbd zza;
    private final /* synthetic */ zzju zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlg(zzju zzjuVar, zzbd zzbdVar) {
        this.zza = zzbdVar;
        this.zzb = zzjuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.zzb.zzk().zza(this.zza)) {
            this.zzb.zzj().zzp().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(this.zza.zza()));
            return;
        }
        this.zzb.zzj().zzq().zza("Setting DMA consent(FE)", this.zza);
        if (this.zzb.zzq().zzao()) {
            this.zzb.zzq().zzaj();
        } else {
            this.zzb.zzq().zza(false);
        }
    }
}
