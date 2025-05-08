package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzmy implements Runnable {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ zzme zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmy(zzme zzmeVar, zzp zzpVar, Bundle bundle) {
        this.zza = zzpVar;
        this.zzb = bundle;
        this.zzc = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar;
        zzfzVar = this.zzc.zzb;
        if (zzfzVar == null) {
            this.zzc.zzj().zzg().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfzVar.zza(this.zzb, this.zza);
        } catch (RemoteException e5) {
            this.zzc.zzj().zzg().zza("Failed to send default event parameters to service", e5);
        }
    }
}
