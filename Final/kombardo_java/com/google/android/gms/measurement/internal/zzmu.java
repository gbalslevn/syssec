package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzmu implements Runnable {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ zzme zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmu(zzme zzmeVar, zzp zzpVar) {
        this.zza = zzpVar;
        this.zzb = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar;
        zzfzVar = this.zzb.zzb;
        if (zzfzVar == null) {
            this.zzb.zzj().zzg().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfzVar.zzd(this.zza);
            this.zzb.zzh().zzae();
            this.zzb.zza(zzfzVar, (AbstractSafeParcelable) null, this.zza);
            this.zzb.zzar();
        } catch (RemoteException e5) {
            this.zzb.zzj().zzg().zza("Failed to send app launch to the service", e5);
        }
    }
}
