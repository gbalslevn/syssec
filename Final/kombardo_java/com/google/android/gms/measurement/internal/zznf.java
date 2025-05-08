package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zznf implements Runnable {
    private final /* synthetic */ boolean zza = true;
    private final /* synthetic */ zzp zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzag zzd;
    private final /* synthetic */ zzag zze;
    private final /* synthetic */ zzme zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznf(zzme zzmeVar, boolean z5, zzp zzpVar, boolean z6, zzag zzagVar, zzag zzagVar2) {
        this.zzb = zzpVar;
        this.zzc = z6;
        this.zzd = zzagVar;
        this.zze = zzagVar2;
        this.zzf = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar;
        zzfzVar = this.zzf.zzb;
        if (zzfzVar == null) {
            this.zzf.zzj().zzg().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zza) {
            Preconditions.checkNotNull(this.zzb);
            this.zzf.zza(zzfzVar, this.zzc ? null : this.zzd, this.zzb);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze.zza)) {
                    Preconditions.checkNotNull(this.zzb);
                    zzfzVar.zza(this.zzd, this.zzb);
                } else {
                    zzfzVar.zza(this.zzd);
                }
            } catch (RemoteException e5) {
                this.zzf.zzj().zzg().zza("Failed to send conditional user property to the service", e5);
            }
        }
        this.zzf.zzar();
    }
}
