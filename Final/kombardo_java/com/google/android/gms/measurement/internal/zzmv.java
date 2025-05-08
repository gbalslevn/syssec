package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzmv implements Runnable {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zzb;
    private final /* synthetic */ zzme zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmv(zzme zzmeVar, zzp zzpVar, com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        this.zza = zzpVar;
        this.zzb = zzdqVar;
        this.zzc = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar;
        try {
            if (!this.zzc.zzk().zzp().zzh()) {
                this.zzc.zzj().zzw().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zzm().zzb((String) null);
                this.zzc.zzk().zze.zza(null);
                return;
            }
            zzfzVar = this.zzc.zzb;
            if (zzfzVar == null) {
                this.zzc.zzj().zzg().zza("Failed to get app instance id");
                return;
            }
            Preconditions.checkNotNull(this.zza);
            String zzb = zzfzVar.zzb(this.zza);
            if (zzb != null) {
                this.zzc.zzm().zzb(zzb);
                this.zzc.zzk().zze.zza(zzb);
            }
            this.zzc.zzar();
            this.zzc.zzs().zza(this.zzb, zzb);
        } catch (RemoteException e5) {
            this.zzc.zzj().zzg().zza("Failed to get app instance id", e5);
        } finally {
            this.zzc.zzs().zza(this.zzb, (String) null);
        }
    }
}
