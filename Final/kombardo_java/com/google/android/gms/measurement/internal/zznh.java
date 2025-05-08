package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zznh implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzp zzc;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzdq zzd;
    private final /* synthetic */ zzme zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznh(zzme zzmeVar, String str, String str2, zzp zzpVar, com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzpVar;
        this.zzd = zzdqVar;
        this.zze = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar;
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzfzVar = this.zze.zzb;
            if (zzfzVar == null) {
                this.zze.zzj().zzg().zza("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            ArrayList<Bundle> zzb = zzpn.zzb(zzfzVar.zza(this.zza, this.zzb, this.zzc));
            this.zze.zzar();
            this.zze.zzs().zza(this.zzd, zzb);
        } catch (RemoteException e5) {
            this.zze.zzj().zzg().zza("Failed to get conditional properties; remote exception", this.zza, this.zzb, e5);
        } finally {
            this.zze.zzs().zza(this.zzd, arrayList);
        }
    }
}
