package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzmq implements Runnable {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzpm zzc;
    private final /* synthetic */ zzme zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmq(zzme zzmeVar, zzp zzpVar, boolean z5, zzpm zzpmVar) {
        this.zza = zzpVar;
        this.zzb = z5;
        this.zzc = zzpmVar;
        this.zzd = zzmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar;
        zzfzVar = this.zzd.zzb;
        if (zzfzVar == null) {
            this.zzd.zzj().zzg().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        this.zzd.zza(zzfzVar, this.zzb ? null : this.zzc, this.zza);
        this.zzd.zzar();
    }
}
