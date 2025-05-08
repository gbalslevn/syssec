package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzmo implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzp zzb;
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzme zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmo(zzme zzmeVar, AtomicReference atomicReference, zzp zzpVar, Bundle bundle) {
        this.zza = atomicReference;
        this.zzb = zzpVar;
        this.zzc = bundle;
        this.zzd = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar;
        synchronized (this.zza) {
            try {
                try {
                    zzfzVar = this.zzd.zzb;
                } catch (RemoteException e5) {
                    this.zzd.zzj().zzg().zza("Failed to get trigger URIs; remote exception", e5);
                }
                if (zzfzVar == null) {
                    this.zzd.zzj().zzg().zza("Failed to get trigger URIs; not connected to service");
                    return;
                }
                Preconditions.checkNotNull(this.zzb);
                this.zza.set(zzfzVar.zza(this.zzb, this.zzc));
                this.zzd.zzar();
                this.zza.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}
