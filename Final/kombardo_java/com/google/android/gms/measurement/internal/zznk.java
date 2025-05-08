package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zznk implements Runnable {
    private final /* synthetic */ zzfz zza;
    private final /* synthetic */ zznj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznk(zznj zznjVar, zzfz zzfzVar) {
        this.zza = zzfzVar;
        this.zzb = zznjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            try {
                this.zzb.zzb = false;
                if (!this.zzb.zza.zzal()) {
                    this.zzb.zza.zzj().zzc().zza("Connected to remote service");
                    this.zzb.zza.zza(this.zza);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
