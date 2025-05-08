package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zznb implements Runnable {
    private final /* synthetic */ zzbl zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zzc;
    private final /* synthetic */ zzme zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznb(zzme zzmeVar, zzbl zzblVar, String str, com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        this.zza = zzblVar;
        this.zzb = str;
        this.zzc = zzdqVar;
        this.zzd = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar;
        try {
            zzfzVar = this.zzd.zzb;
            if (zzfzVar == null) {
                this.zzd.zzj().zzg().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] zza = zzfzVar.zza(this.zza, this.zzb);
            this.zzd.zzar();
            this.zzd.zzs().zza(this.zzc, zza);
        } catch (RemoteException e5) {
            this.zzd.zzj().zzg().zza("Failed to send event to the service to bundle", e5);
        } finally {
            this.zzd.zzs().zza(this.zzc, (byte[]) null);
        }
    }
}
