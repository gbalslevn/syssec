package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzmc implements Runnable {
    private final /* synthetic */ zzlw zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzlz zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmc(zzlz zzlzVar, zzlw zzlwVar, long j5) {
        this.zza = zzlwVar;
        this.zzb = j5;
        this.zzc = zzlzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza(this.zza, false, this.zzb);
        zzlz zzlzVar = this.zzc;
        zzlzVar.zza = null;
        zzlzVar.zzq().zza((zzlw) null);
    }
}
