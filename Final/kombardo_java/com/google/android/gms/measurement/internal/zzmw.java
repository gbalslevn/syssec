package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzmw implements Runnable {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ zzme zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmw(zzme zzmeVar, zzp zzpVar) {
        this.zza = zzpVar;
        this.zzb = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar;
        zzfzVar = this.zzb.zzb;
        if (zzfzVar == null) {
            this.zzb.zzj().zzr().zza("Failed to send app backgrounded");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfzVar.zzc(this.zza);
            this.zzb.zzar();
        } catch (RemoteException e5) {
            this.zzb.zzj().zzg().zza("Failed to send app backgrounded to the service", e5);
        }
    }
}
