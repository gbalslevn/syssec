package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzmd implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzlz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmd(zzlz zzlzVar, long j5) {
        this.zza = j5;
        this.zzb = zzlzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc().zza(this.zza);
        this.zzb.zza = null;
    }
}
