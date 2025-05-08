package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzid implements Runnable {
    private final /* synthetic */ zzjs zza;
    private final /* synthetic */ zzic zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzid(zzic zzicVar, zzjs zzjsVar) {
        this.zza = zzjsVar;
        this.zzb = zzicVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzic.zza(this.zzb, this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}
