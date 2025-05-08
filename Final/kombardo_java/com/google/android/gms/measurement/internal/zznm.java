package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zznm implements Runnable {
    private final /* synthetic */ zznj zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznm(zznj zznjVar) {
        this.zza = zznjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza.zzb = null;
        this.zza.zza.zzaq();
    }
}
