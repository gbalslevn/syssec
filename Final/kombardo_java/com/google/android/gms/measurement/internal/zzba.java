package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzba implements Runnable {
    private final /* synthetic */ zzjh zza;
    private final /* synthetic */ zzbb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(zzbb zzbbVar, zzjh zzjhVar) {
        this.zza = zzjhVar;
        this.zzb = zzbbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzd();
        if (zzaf.zza()) {
            this.zza.zzl().zzb(this);
            return;
        }
        boolean zzc = this.zzb.zzc();
        this.zzb.zzd = 0L;
        if (zzc) {
            this.zzb.zzb();
        }
    }
}
