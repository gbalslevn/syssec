package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzow implements Runnable {
    private final /* synthetic */ zzpf zza;
    private final /* synthetic */ zzou zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzow(zzou zzouVar, zzpf zzpfVar) {
        this.zza = zzpfVar;
        this.zzb = zzouVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzou.zza(this.zzb, this.zza);
        this.zzb.zzw();
    }
}
