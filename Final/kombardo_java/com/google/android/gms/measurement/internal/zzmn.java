package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzmn implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzp zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zze;
    private final /* synthetic */ zzme zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmn(zzme zzmeVar, String str, String str2, zzp zzpVar, boolean z5, com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzpVar;
        this.zzd = z5;
        this.zze = zzdqVar;
        this.zzf = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar;
        Bundle bundle = new Bundle();
        try {
            zzfzVar = this.zzf.zzb;
            if (zzfzVar == null) {
                this.zzf.zzj().zzg().zza("Failed to get user properties; not connected to service", this.zza, this.zzb);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            Bundle zza = zzpn.zza(zzfzVar.zza(this.zza, this.zzb, this.zzd, this.zzc));
            this.zzf.zzar();
            this.zzf.zzs().zza(this.zze, zza);
        } catch (RemoteException e5) {
            this.zzf.zzj().zzg().zza("Failed to get user properties; remote exception", this.zza, e5);
        } finally {
            this.zzf.zzs().zza(this.zze, bundle);
        }
    }
}
